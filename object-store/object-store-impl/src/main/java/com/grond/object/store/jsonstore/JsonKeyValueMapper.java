package com.grond.object.store.jsonstore;

import com.grond.object.store.api.objects.JsonKeyValue;

public class JsonKeyValueMapper {
    public static JsonStore toStore(JsonKeyValue jsonKeyValue) {
        return JsonStore.builder()
                .key(jsonKeyValue.getKey())
                .value(jsonKeyValue.getValue())
                .build();
    }

    public static JsonKeyValue toObject(JsonStore jsonStore) {
        return JsonKeyValue.builder()
                .key(jsonStore.getKey())
                .value(jsonStore.getValue())
                .build();
    }
}
