package com.grond;

import com.grond.catalog.api.clients.PipelineClient;
import com.grond.catalog.api.objects.Pipeline;
import com.grond.catalog.api.objects.PipelineCreateRequest;
import com.grond.catalog.api.objects.PipelineUpdateRequest;
import com.grond.common.dialog.ClientConfig;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PipelineClient pipelineClient = new PipelineClient(
                ClientConfig.builder().basePath("localhost:8080").build());
        Pipeline pipeline = pipelineClient.getPipeline("pipelineId");
        System.out.println(pipeline);
        List<Pipeline> pipelineList = pipelineClient.getPipelines();
        System.out.println(pipelineList);
        Pipeline newPipeline = pipelineClient.createPipeline(PipelineCreateRequest.builder()
                .name("name")
                .description("description")
                .build());
        System.out.println(newPipeline);
        pipelineClient.updatePipeline(PipelineUpdateRequest.builder()
                .id("error")
                .name("name")
                .description("description")
                .build());
    }
}