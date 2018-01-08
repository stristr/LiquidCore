//
// JSONTest.java
//
// AndroidJSCore project
// https://github.com/ericwlange/AndroidJSCore/
//
// LiquidPlayer project
// https://github.com/LiquidPlayer
//
// Created by Eric Lange
//
/*
 Copyright (c) 2014-2016 Eric Lange. All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met:

 - Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer.

 - Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.liquidplayer.javascript;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class JSONTest {

    protected JSContext getContext() {
        return new JSContext();
    }

    @Test
    public void testStringify() throws Exception {
        JSContext context = getContext();
        context.evaluateScript("var s1 = JSON.stringify(1);");
        context.evaluateScript("var s2 = JSON.stringify('abc');");
        context.evaluateScript("var s3 = JSON.stringify([1,2,3]);");
        context.evaluateScript("var s4 = JSON.stringify({foo:'bar'});");
        String s1 = JSON.stringify(context,1);
        String s2 = JSON.stringify(context,"abc");
        String s3 = JSON.stringify(context, Arrays.asList(1,2,3));
        Map<String,String> map = new HashMap<>();
        map.put("foo","bar");
        String s4 = JSON.stringify(context, map);
        assertEquals(context.property("s1").toString(),s1);
        assertEquals(context.property("s2").toString(),s2);
        assertEquals(context.property("s3").toString(),s3);
        assertEquals(context.property("s4").toString(),s4);
    }

    @Test
    public void testStringify1() throws Exception {
        JSContext context = getContext();
        context.evaluateScript("var s1 = JSON.stringify(1);");
        context.evaluateScript("var s2 = JSON.stringify('abc');");
        context.evaluateScript("var s3 = JSON.stringify([1,2,3]);");
        context.evaluateScript("var s4 = JSON.stringify({foo:'bar'});");
        String s1 = JSON.stringify(new JSValue(context,1));
        String s2 = JSON.stringify(new JSValue(context,"abc"));
        String s3 = JSON.stringify(new JSValue(context, Arrays.asList(1,2,3)));
        Map<String,String> map = new HashMap<>();
        map.put("foo","bar");
        String s4 = JSON.stringify(new JSValue(context, map));
        assertEquals(context.property("s1").toString(),s1);
        assertEquals(context.property("s2").toString(),s2);
        assertEquals(context.property("s3").toString(),s3);
        assertEquals(context.property("s4").toString(),s4);
    }

    @Test
    public void testParse() throws Exception {
        JSContext context = getContext();
        context.evaluateScript("var s1 = JSON.stringify(1);");
        context.evaluateScript("var s2 = JSON.stringify('abc');");
        context.evaluateScript("var s3 = JSON.stringify([1,2,3]);");
        context.evaluateScript("var s4 = JSON.stringify({foo:'bar'});");
        JSValue v1 = JSON.parse(context,context.property("s1").toString());
        JSValue v2 = JSON.parse(context,context.property("s2").toString());
        JSValue v3 = JSON.parse(context,context.property("s3").toString());
        JSValue v4 = JSON.parse(context,context.property("s4").toString());
        assertEquals(v1.toNumber().intValue(),1);
        assertEquals(v2.toString(),"abc");
        assertEquals(v3.toJSArray(),Arrays.asList(1,2,3));
        assertEquals(v4.toObject().property("foo").toString(),"bar");

        JSValue v5 = JSON.parse(context,"x,z,1");
        assertTrue(v5.isUndefined());
    }
}