# This file is generated by gyp; do not edit.

TOOLSET := host
TARGET := v8_inspector_compress_protocol_json
### Rules for final target.
$(obj).host/v8_inspector_compress_protocol_json.stamp: TOOLSET := $(TOOLSET)
$(obj).host/v8_inspector_compress_protocol_json.stamp:  FORCE_DO_CMD
	$(call do_cmd,touch)

all_deps += $(obj).host/v8_inspector_compress_protocol_json.stamp
# Add target alias
.PHONY: v8_inspector_compress_protocol_json
v8_inspector_compress_protocol_json: $(obj).host/v8_inspector_compress_protocol_json.stamp

# Add target alias to "all" target.
.PHONY: all
all: v8_inspector_compress_protocol_json
