package com.grond.object.store.jsondocument;

import com.grond.object.store.api.objects.JsonKeyValue;

public class JsonKeyValueMapper {
    public static JsonDocument toStore(JsonKeyValue jsonKeyValue) {
        return JsonDocument.builder()
                .key(jsonKeyValue.getKey())
                .value(jsonKeyValue.getValue())
                .build();
    }

    public static JsonKeyValue toObject(JsonDocument jsonDocument) {
        return JsonKeyValue.builder()
                .key(jsonDocument.getKey())
                .value(jsonDocument.getValue())
                .build();
    }
}
