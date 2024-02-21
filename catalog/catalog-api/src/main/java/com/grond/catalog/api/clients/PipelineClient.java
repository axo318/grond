package com.grond.catalog.api.clients;

import static com.grond.catalog.api.CatalogApi.CATALOG_SERVICE_BASE_PATH;

import com.grond.catalog.api.objects.Pipeline;
import com.grond.catalog.api.objects.PipelineCreateRequest;
import com.grond.catalog.api.objects.PipelineUpdateRequest;
import com.grond.catalog.api.services.PipelineService;
import com.grond.common.dialog.Client;
import com.grond.common.dialog.ClientConfig;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;


public class PipelineClient extends Client implements PipelineService {
    private static final String BASE = CATALOG_SERVICE_BASE_PATH + BASE_PATH;

    public PipelineClient(ClientConfig config) {
        super(config);
    }

    @Override
    public Pipeline getPipeline(String pipelineId) {
        return get(BASE + GET_PIPELINE_PATH, Pipeline.class, pipelineId);
    }

    @Override
    public List<Pipeline> getPipelines() {
        return get(BASE + GET_PIPELINES_PATH, new ParameterizedTypeReference<List<Pipeline>>() {
        });
    }

    @Override
    public Pipeline createPipeline(PipelineCreateRequest request) {
        return post(BASE + CREATE_PIPELINE_PATH, request, Pipeline.class);
    }

    @Override
    public void updatePipeline(PipelineUpdateRequest request) {
        put(BASE + UPDATE_PIPELINE_PATH, request);
    }

    @Override
    public void deletePipeline(String pipelineId) {
        delete(BASE + DELETE_PIPELINE_PATH, pipelineId);
    }
}
