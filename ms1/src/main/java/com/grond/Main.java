package com.grond;

import com.grond.catalog.api.clients.BuildClient;
import com.grond.catalog.api.clients.PipelineClient;
import com.grond.catalog.api.objects.BuildCreateRequest;
import com.grond.catalog.api.objects.BuildStatus;
import com.grond.catalog.api.objects.Pipeline;
import com.grond.catalog.api.objects.PipelineCreateRequest;
import com.grond.common.dialog.ClientConfig;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PipelineClient pipelineClient = new PipelineClient(
            ClientConfig.builder().basePath("localhost:8080/catalog-service/api").build());

        BuildClient buildClient = new BuildClient(
            ClientConfig.builder().basePath("localhost:8080/catalog-service/api").build());

        List<Pipeline> allPipelines = pipelineClient.getPipelines();
        Pipeline pipeline;

        if (allPipelines.isEmpty()) {
            PipelineCreateRequest pipelineCreateRequest = PipelineCreateRequest.builder()
                .name("Gregorio's")
                .instructions("{}")
                .build();
            pipeline = pipelineClient.createPipeline(pipelineCreateRequest);
        } else {
            pipeline = allPipelines.get(0);
        }

        BuildCreateRequest buildCreateRequest = BuildCreateRequest.builder()
            .pipelineId(pipeline.getId())
            .instructions("{}")
            .status(BuildStatus.FAILED)
            .startTime(new Date())
            .build();
        buildClient.createBuild(buildCreateRequest);
    }


}