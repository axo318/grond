package com.grond.catalog.api.clients;

import com.grond.catalog.api.endpoints.BuildEndpoints;
import com.grond.catalog.api.objects.Build;
import com.grond.catalog.api.objects.BuildCreateRequest;
import com.grond.catalog.api.objects.BuildUpdateRequest;
import com.grond.common.dialog.Client;
import com.grond.common.dialog.ClientConfig;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;

public class BuildClient extends Client implements BuildEndpoints {
    public BuildClient(ClientConfig config) {
        super(config);
    }

    @Override
    public Build getBuild(String buildId) {
        return get(BASE_PATH + GET_BUILD_PATH, Build.class, buildId);
    }

    @Override
    public List<Build> getBuilds() {
        return get(BASE_PATH + GET_BUILDS_PATH,
                new ParameterizedTypeReference<List<Build>>() {
                });
    }

    @Override
    public Build createBuild(BuildCreateRequest request) {
        return post(BASE_PATH + CREATE_BUILD_PATH, request, Build.class);
    }

    @Override
    public void updateBuild(BuildUpdateRequest request) {
        put(BASE_PATH + UPDATE_BUILD_PATH, request);
    }

    @Override
    public void deleteBuild(String buildId) {
        delete(BASE_PATH + DELETE_BUILD_PATH, buildId);
    }
}
