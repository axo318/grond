package com.grond.object.store.jsondocument;

import com.grond.common.dialog.Controller;
import com.grond.common.exception.ErrorCode;
import com.grond.common.exception.ServiceException;
import com.grond.object.store.api.endpoints.JsonDocumentEndpoints;
import com.grond.object.store.api.objects.JsonKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonDocumentController extends Controller implements JsonDocumentEndpoints {
    private final JsonDocumentRepository jsonDocumentRepository;

    @Autowired
    public JsonDocumentController(JsonDocumentRepository jsonDocumentRepository) {
        this.jsonDocumentRepository = jsonDocumentRepository;
    }

    @Override
    public JsonKeyValue getJSONKeyValue(String key) {
        return jsonDocumentRepository
                .findById(key)
                .map(JsonKeyValueMapper::toObject)
                .orElseThrow(() -> new ServiceException("JsonKeyValue not found", ErrorCode.NOT_FOUND));
    }

    @Override
    public JsonKeyValue createJSONKeyValue(JsonKeyValue request) {
        JsonDocument newRequest = JsonKeyValueMapper.toStore(request);
        JsonDocument jsonDocument = jsonDocumentRepository.save(newRequest);
        return JsonKeyValueMapper.toObject(jsonDocument);
    }

    @Override
    public void deleteJSONKeyValue(String key) {
        jsonDocumentRepository.deleteById(key);
    }
}
