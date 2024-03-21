package com.grond.object.store.binarydocument;

import com.grond.object.store.api.objects.BinaryKeyValue;

public class BinaryKeyValueMapper {
    public static BinaryDocument toStore(BinaryKeyValue binaryKeyValue) {
        return BinaryDocument.builder()
                .key(binaryKeyValue.getKey())
                .value(binaryKeyValue.getValue())
                .build();
    }

    public static BinaryKeyValue toObject(BinaryDocument binaryDocument) {
        return BinaryKeyValue.builder()
                .key(binaryDocument.getKey())
                .value(binaryDocument.getValue())
                .build();
    }
}
