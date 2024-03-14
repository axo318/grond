package com.grond.object.store.api.clients;

import com.grond.common.dialog.Client;
import com.grond.common.dialog.ClientConfig;
import com.grond.object.store.api.endpoints.BinaryStoreEndpoints;
import com.grond.object.store.api.objects.BinaryKeyValue;

public class BinaryStoreClient extends Client implements BinaryStoreEndpoints {
    public BinaryStoreClient(ClientConfig config) {
        super(config);
    }

    @Override
    public BinaryKeyValue getBinaryKeyValue(String id) {
        return get(BASE_PATH + GET_BINARY_PATH, BinaryKeyValue.class, id);
    }

    @Override
    public BinaryKeyValue createBinaryKeyValue(BinaryKeyValue request) {
        return post(BASE_PATH + CREATE_BINARY_PATH, request, BinaryKeyValue.class);
    }

    @Override
    public BinaryKeyValue appendBinaryKeyValue(BinaryKeyValue request) {
        return post(BASE_PATH + APPEND_BINARY_PATH, request, BinaryKeyValue.class);
    }

    @Override
    public void deleteBinaryKeyValue(String id) {
        delete(BASE_PATH + DELETE_BINARY_PATH, id);
    }
}
