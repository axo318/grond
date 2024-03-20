package com.grond.object.store.binarystore;

import com.grond.common.dialog.Controller;
import com.grond.common.exception.ErrorCode;
import com.grond.common.exception.ServiceException;
import com.grond.object.store.api.endpoints.BinaryStoreEndpoints;
import com.grond.object.store.api.objects.BinaryKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BinaryStoreController extends Controller implements BinaryStoreEndpoints {
    private final BinaryStoreRepository binaryStoreRepository;

    @Autowired
    public BinaryStoreController(BinaryStoreRepository binaryStoreRepository) {
        this.binaryStoreRepository = binaryStoreRepository;
    }

    @Override
    public BinaryKeyValue getBinaryKeyValue(String key) {
        return binaryStoreRepository
                .findById(key)
                .map(BinaryKeyValueMapper::toObject)
                .orElseThrow(() -> new ServiceException("BinaryKeyValue not found", ErrorCode.NOT_FOUND));
    }

    @Override
    public BinaryKeyValue createBinaryKeyValue(BinaryKeyValue request) {
        BinaryStore newRequest = BinaryKeyValueMapper.toStore(request);
        BinaryStore binaryStore = binaryStoreRepository.save(newRequest);
        return BinaryKeyValueMapper.toObject(binaryStore);
    }

    @Override
    public void appendBinaryKeyValue(BinaryKeyValue request) {
        BinaryKeyValue binaryKeyValue = getBinaryKeyValue(request.getKey());
        binaryKeyValue.setValue(binaryKeyValue.getValue() + request.getValue());
        binaryStoreRepository.save(BinaryKeyValueMapper.toStore(binaryKeyValue));
    }

    @Override
    public void deleteBinaryKeyValue(String key) {
        binaryStoreRepository.deleteById(key);
    }
}
