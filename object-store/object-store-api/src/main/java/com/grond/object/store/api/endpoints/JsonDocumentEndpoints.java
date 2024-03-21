package com.grond.object.store.api.endpoints;

import com.grond.object.store.api.objects.JsonKeyValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(JsonDocumentEndpoints.BASE_PATH)
public interface JsonDocumentEndpoints {
    String BASE_PATH = "/v1/json-store";
    String GET_JSON_PATH = "/{key}";
    String CREATE_JSON_PATH = "";
    String DELETE_JSON_PATH = "/{key}";

    @GetMapping(JsonDocumentEndpoints.GET_JSON_PATH)
    JsonKeyValue getJSONKeyValue(@PathVariable String key);

    @PostMapping(JsonDocumentEndpoints.CREATE_JSON_PATH)
    JsonKeyValue createJSONKeyValue(@RequestBody JsonKeyValue request);

    @DeleteMapping(JsonDocumentEndpoints.DELETE_JSON_PATH)
    void deleteJSONKeyValue(@PathVariable String key);
}
