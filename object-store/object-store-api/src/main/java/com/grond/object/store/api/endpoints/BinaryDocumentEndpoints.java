package com.grond.object.store.api.endpoints;

import com.grond.object.store.api.objects.BinaryKeyValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(BinaryDocumentEndpoints.BASE_PATH)
public interface BinaryDocumentEndpoints {
    String BASE_PATH = "/v1/binary-store";
    String GET_BINARY_PATH = "/{key}";
    String APPEND_BINARY_PATH = "/append";
    String CREATE_BINARY_PATH = "";
    String DELETE_BINARY_PATH = "/{key}";

    @GetMapping(BinaryDocumentEndpoints.GET_BINARY_PATH)
    BinaryKeyValue getBinaryKeyValue(@PathVariable String key);

    @PostMapping(BinaryDocumentEndpoints.CREATE_BINARY_PATH)
    BinaryKeyValue createBinaryKeyValue(@RequestBody BinaryKeyValue request);

    @PostMapping(BinaryDocumentEndpoints.APPEND_BINARY_PATH)
    void appendBinaryKeyValue(@RequestBody BinaryKeyValue request);

    @DeleteMapping(BinaryDocumentEndpoints.DELETE_BINARY_PATH)
    void deleteBinaryKeyValue(@PathVariable String key);
}
