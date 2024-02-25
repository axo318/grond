package com.grond.catalog.api.endpoints;

import com.grond.catalog.api.objects.Pipeline;
import com.grond.catalog.api.objects.PipelineCreateRequest;
import com.grond.catalog.api.objects.PipelineUpdateRequest;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(PipelineEndpoints.BASE_PATH)
public interface PipelineEndpoints {
    String BASE_PATH = "/v1/pipelines";

    String GET_PIPELINE_PATH = "/{pipelineId}";
    String GET_PIPELINES_PATH = "";
    String CREATE_PIPELINE_PATH = "";
    String UPDATE_PIPELINE_PATH = "";
    String DELETE_PIPELINE_PATH = "/{pipelineId}";

    @GetMapping(GET_PIPELINE_PATH)
    Pipeline getPipeline(@PathVariable String pipelineId);

    @GetMapping(GET_PIPELINES_PATH)
    List<Pipeline> getPipelines();

    @PostMapping(CREATE_PIPELINE_PATH)
    Pipeline createPipeline(@RequestBody PipelineCreateRequest request);

    @PutMapping(UPDATE_PIPELINE_PATH)
    void updatePipeline(@RequestBody PipelineUpdateRequest request);

    @DeleteMapping(DELETE_PIPELINE_PATH)
    void deletePipeline(@PathVariable String pipelineId);
}
