package com.grond.object.store.jsonstore;

import com.grond.common.dialog.Controller;
import com.grond.common.exception.ErrorCode;
import com.grond.common.exception.ServiceException;
import com.grond.object.store.api.endpoints.JsonStoreEndpoints;
import com.grond.object.store.api.objects.JsonKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonStoreController extends Controller implements JsonStoreEndpoints {

    private final JsonStoreRepository jsonStoreRepository;

    @Autowired
    public JsonStoreController(JsonStoreRepository jsonStoreRepository) {
        this.jsonStoreRepository = jsonStoreRepository;
    }

    @Override
    public JsonKeyValue getJSONKeyValue(String key) {
        return jsonStoreRepository
                .findById(key)
                .map(JsonKeyValueMapper::toObject)
                .orElseThrow(() -> new ServiceException("JsonKeyValue not found", ErrorCode.NOT_FOUND));
    }

    @Override
    public JsonKeyValue createJSONKeyValue(JsonKeyValue request) {
        JsonStore newRequest = JsonKeyValueMapper.toStore(request);
        JsonStore jsonStore = jsonStoreRepository.save(newRequest);
        return JsonKeyValueMapper.toObject(jsonStore);
    }

    @Override
    public void deleteJSONKeyValue(String key) {
        jsonStoreRepository.deleteById(key);
    }
}
