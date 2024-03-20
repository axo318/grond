package com.grond.object.store.jsonstore;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grond.common.dialog.Controller;
import com.grond.object.store.api.endpoints.JsonStoreEndpoints;
import com.grond.object.store.api.objects.JsonKeyValue;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonStoreController extends Controller implements JsonStoreEndpoints {
    @Override
    public JsonKeyValue getJSONKeyValue(String key) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.createObjectNode();
        return JsonKeyValue.builder().key(key).value(node).build();
    }

    @Override
    public JsonKeyValue createJSONKeyValue(JsonKeyValue request) {
        return request;
    }

    @Override
    public void deleteJSONKeyValue(String key) {}
}
