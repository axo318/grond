package com.grond.object.store.binarydocument;

import com.grond.common.dialog.Controller;
import com.grond.common.exception.ErrorCode;
import com.grond.common.exception.ServiceException;
import com.grond.object.store.api.endpoints.BinaryStoreEndpoints;
import com.grond.object.store.api.objects.BinaryKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BinaryStoreController extends Controller implements BinaryStoreEndpoints {
    private final BinaryDocumentRepository binaryDocumentRepository;

    @Autowired
    public BinaryStoreController(BinaryDocumentRepository binaryDocumentRepository) {
        this.binaryDocumentRepository = binaryDocumentRepository;
    }

    @Override
    public BinaryKeyValue getBinaryKeyValue(String key) {
        return binaryDocumentRepository
                .findById(key)
                .map(BinaryKeyValueMapper::toObject)
                .orElseThrow(() -> new ServiceException("BinaryKeyValue not found", ErrorCode.NOT_FOUND));
    }

    @Override
    public BinaryKeyValue createBinaryKeyValue(BinaryKeyValue request) {
        BinaryDocument newRequest = BinaryKeyValueMapper.toStore(request);
        BinaryDocument binaryDocument = binaryDocumentRepository.save(newRequest);
        return BinaryKeyValueMapper.toObject(binaryDocument);
    }

    @Override
    public void appendBinaryKeyValue(BinaryKeyValue request) {
        BinaryKeyValue binaryKeyValue = getBinaryKeyValue(request.getKey());
        binaryKeyValue.setValue(binaryKeyValue.getValue() + request.getValue());
        binaryDocumentRepository.save(BinaryKeyValueMapper.toStore(binaryKeyValue));
    }

    @Override
    public void deleteBinaryKeyValue(String key) {
        binaryDocumentRepository.deleteById(key);
    }
}
