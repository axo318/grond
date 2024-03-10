package com.grond.catalog.pipeline;

import com.grond.catalog.api.endpoints.PipelineEndpoints;
import com.grond.catalog.api.objects.Pipeline;
import com.grond.catalog.api.objects.PipelineCreateRequest;
import com.grond.catalog.api.objects.PipelineUpdateRequest;
import com.grond.common.dialog.Controller;
import com.grond.common.exception.ErrorCode;
import com.grond.common.exception.ServiceException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PipelineController extends Controller implements PipelineEndpoints {
    private final PipelineRepository pipelineRepository;

    @Autowired
    public PipelineController(PipelineRepository pipelineRepository) {
        this.pipelineRepository = pipelineRepository;
    }

    @Override
    public Pipeline getPipeline(String pipelineId) {
        return pipelineRepository.findById(UUID.fromString(pipelineId))
                .map(PipelineMapper::toObject)
                .orElseThrow(() -> new ServiceException("Pipeline not found", ErrorCode.NOT_FOUND));
    }

    @Override
    public List<Pipeline> getPipelines() {
        return pipelineRepository.findAll().stream()
                .map(PipelineMapper::toObject)
                .toList();
    }

    @Override
    public Pipeline createPipeline(PipelineCreateRequest request) {
        return PipelineMapper.toObject(pipelineRepository.save(PipelineMapper.toEntity(request)));
    }

    @Override
    public void updatePipeline(PipelineUpdateRequest request) {
        pipelineRepository.save(PipelineMapper.toEntity(request));
    }

    @Override
    public void deletePipeline(String pipelineId) {
        pipelineRepository.deleteById(UUID.fromString(pipelineId));
    }
}
