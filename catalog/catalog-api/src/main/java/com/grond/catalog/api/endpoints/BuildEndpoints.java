package com.grond.catalog.api.endpoints;

import com.grond.catalog.api.objects.Build;
import com.grond.catalog.api.objects.BuildCreateRequest;
import com.grond.catalog.api.objects.BuildUpdateRequest;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(BuildEndpoints.BASE_PATH)
public interface BuildEndpoints {
    String BASE_PATH = "/v1/builds";

    String GET_BUILD_PATH = "/{buildId}";
    String GET_BUILDS_PATH = "";
    String CREATE_BUILD_PATH = "";
    String UPDATE_BUILD_PATH = "";
    String DELETE_BUILD_PATH = "/{buildId}";

    @GetMapping(GET_BUILD_PATH)
    Build getBuild(@PathVariable String buildId);

    @GetMapping(GET_BUILDS_PATH)
    List<Build> getBuilds();

    @PostMapping(CREATE_BUILD_PATH)
    Build createBuild(@RequestBody BuildCreateRequest request);

    @PutMapping(UPDATE_BUILD_PATH)
    void updateBuild(@RequestBody BuildUpdateRequest request);

    @DeleteMapping(DELETE_BUILD_PATH)
    void deleteBuild(@PathVariable String buildId);
}
