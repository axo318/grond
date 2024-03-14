package com.grond.object.store.binary_stores;

import com.grond.common.dialog.Controller;
import com.grond.object.store.api.endpoints.BinaryStoreEndpoints;
import com.grond.object.store.api.objects.BinaryKeyValue;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BinaryStoreController extends Controller implements BinaryStoreEndpoints {

    @Override
    public BinaryKeyValue getBinaryKeyValue(String key) {
        return BinaryKeyValue.builder().key(key).value(key + key).build();
    }

    @Override
    public BinaryKeyValue createBinaryKeyValue(BinaryKeyValue request) {
        return request;
    }

    @Override
    public void appendBinaryKeyValue(BinaryKeyValue request) {}

    @Override
    public void deleteBinaryKeyValue(String key) {}
}
