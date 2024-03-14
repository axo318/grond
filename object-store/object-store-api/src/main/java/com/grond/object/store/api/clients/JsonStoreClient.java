package com.grond.object.store.api.clients;

import com.grond.common.dialog.Client;
import com.grond.common.dialog.ClientConfig;
import com.grond.object.store.api.endpoints.JsonStoreEndpoints;
import com.grond.object.store.api.objects.JsonKeyValue;

public class JsonStoreClient extends Client implements JsonStoreEndpoints {
    public JsonStoreClient(ClientConfig config) {
        super(config);
    }

    @Override
    public JsonKeyValue getJSONKeyValue(String key) {
        return get(BASE_PATH + GET_JSON_PATH, JsonKeyValue.class, key);
    }

    @Override
    public JsonKeyValue createJSONKeyValue(JsonKeyValue request) {
        return post(BASE_PATH + CREATE_JSON_PATH, request, JsonKeyValue.class);
    }

    @Override
    public void deleteJSONKeyValue(String key) {
        delete(BASE_PATH + DELETE_JSON_PATH, key);
    }
}
