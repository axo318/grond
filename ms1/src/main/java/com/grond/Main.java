package com.grond;

import com.grond.common.dialog.ClientConfig;
import com.grond.object.store.api.clients.JsonStoreClient;
import com.grond.object.store.api.objects.JsonKeyValue;

public class Main {

    public static void main(String[] args) {
        //        PipelineClient pipelineClient = new PipelineClient(ClientConfig.builder()
        //                .basePath("localhost:8080/catalog-service/api")
        //                .build());
        //
        //        BuildClient buildClient = new BuildClient(ClientConfig.builder()
        //                .basePath("localhost:8080/catalog-service/api")
        //                .build());
        //
        //        List<Pipeline> allPipelines = pipelineClient.getPipelines();
        //        Pipeline pipeline;
        //
        //        if (allPipelines.isEmpty()) {
        //            PipelineCreateRequest pipelineCreateRequest = PipelineCreateRequest.builder()
        //                    .name("Gregorio's")
        //                    .instructions("{}")
        //                    .build();
        //            pipeline = pipelineClient.createPipeline(pipelineCreateRequest);
        //        } else {
        //            pipeline = allPipelines.get(0);
        //        }
        //
        //        BuildCreateRequest buildCreateRequest = BuildCreateRequest.builder()
        //                .pipelineId(pipeline.getId())
        //                .instructions("{}")
        //                .status(BuildStatus.FAILED)
        //                .startTime(new Date())
        //                .build();
        //        buildClient.createBuild(buildCreateRequest);

        JsonStoreClient jsonStoreClient = new JsonStoreClient(ClientConfig.builder()
                .basePath("localhost:8081/object-store/api")
                .build());
        JsonKeyValue test = jsonStoreClient.getJSONKeyValue("123");
        System.out.println(test);
    }
}