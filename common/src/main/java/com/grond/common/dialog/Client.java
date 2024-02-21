package com.grond.common.dialog;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public abstract class Client {
    private final ClientConfig config;

    public Client(ClientConfig config) {
        this.config = config;
    }

    public <T> T get(String endpoint, Class<T> responseType, Object... uriVariables) {

        return DialogExceptionHandler.safeWrap(
                () -> getRestTemplate().getForObject(getUrl(endpoint), responseType, uriVariables));
    }

    public <T> T get(String endpoint, ParameterizedTypeReference<T> responseType,
            Object... uriVariables) {
        return DialogExceptionHandler.safeWrap(
                () -> getRestTemplate()
                        .exchange(getUrl(endpoint), HttpMethod.GET, HttpEntity.EMPTY, responseType,
                                uriVariables)
                        .getBody());
    }

    public <T> T post(String endpoint, Object request, Class<T> responseType,
            Object... uriVariables) {
        return DialogExceptionHandler.safeWrap(
                () -> getRestTemplate().postForObject(getUrl(endpoint), request, responseType,
                        uriVariables));
    }

    public void put(String endpoint, Object request, Object... uriVariables) {
        DialogExceptionHandler.safeWrap(
                () -> getRestTemplate().put(getUrl(endpoint), request, uriVariables));
    }

    public void delete(String endpoint, Object... uriVariables) {
        getRestTemplate().delete(getUrl(endpoint), uriVariables);
    }

    private String getUrl(String endpoint) {
        return "http://" + config.getBasePath() + endpoint;
    }

    private RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
