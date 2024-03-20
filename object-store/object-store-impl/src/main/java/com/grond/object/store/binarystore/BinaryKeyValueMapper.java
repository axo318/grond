package com.grond.object.store.binarystore;

import com.grond.object.store.api.objects.BinaryKeyValue;

public class BinaryKeyValueMapper {
    public static BinaryStore toStore(BinaryKeyValue binaryKeyValue) {
        return BinaryStore.builder()
                .key(binaryKeyValue.getKey())
                .value(binaryKeyValue.getValue())
                .build();
    }

    public static BinaryKeyValue toObject(BinaryStore binaryStore) {
        return BinaryKeyValue.builder()
                .key(binaryStore.getKey())
                .value(binaryStore.getValue())
                .build();
    }
}
