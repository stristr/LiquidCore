#ifndef SRC_NODE_FILE_H_
#define SRC_NODE_FILE_H_

#if defined(NODE_WANT_INTERNALS) && NODE_WANT_INTERNALS

#include "node.h"
#include "v8.h"

namespace nodedroid {

#define _FS_ACCESS_RD (1)
#define _FS_ACCESS_WR (2)
#define _FS_ACCESS_NONE (0)

void InitFs(v8::Local<v8::Object> target);
v8::Local<v8::Value> alias_(node::Environment *env, v8::Local<v8::Value> path);
v8::Local<v8::Value> fs_(node::Environment *env, v8::Local<v8::Value> path, int req_access);

extern "C" node::node_module fs_module;

}  // namespace nodedroid

#endif  // defined(NODE_WANT_INTERNALS) && NODE_WANT_INTERNALS

#endif  // SRC_NODE_FILE_H_
