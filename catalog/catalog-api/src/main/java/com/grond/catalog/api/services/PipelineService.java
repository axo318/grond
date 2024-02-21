package com.grond.catalog.api.services;

import com.grond.catalog.api.objects.Pipeline;
import com.grond.catalog.api.objects.PipelineCreateRequest;
import com.grond.catalog.api.objects.PipelineUpdateRequest;
import java.util.List;

public interface PipelineService {
    String BASE_PATH = "/v1/pipelines";

    String GET_PIPELINE_PATH = "/{pipelineId}";
    String GET_PIPELINES_PATH = "";
    String CREATE_PIPELINE_PATH = "";
    String UPDATE_PIPELINE_PATH = "";
    String DELETE_PIPELINE_PATH = "/{pipelineId}";

    Pipeline getPipeline(String pipelineId);

    List<Pipeline> getPipelines();

    Pipeline createPipeline(PipelineCreateRequest request);

    void updatePipeline(PipelineUpdateRequest request);

    void deletePipeline(String pipelineId);
}
