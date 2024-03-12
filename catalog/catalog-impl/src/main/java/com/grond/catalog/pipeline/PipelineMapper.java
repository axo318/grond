package com.grond.catalog.pipeline;

import com.grond.catalog.api.objects.Pipeline;
import com.grond.catalog.api.objects.PipelineCreateRequest;
import java.util.UUID;

public final class PipelineMapper {
    public static PipelineEntity toEntity(Pipeline pipeline) {
        return PipelineEntity.builder()
                .id(UUID.fromString(pipeline.getId()))
                .name(pipeline.getName())
                .description(pipeline.getDescription())
                .instructions(pipeline.getInstructions())
                .repositoryUrl(pipeline.getRepositoryUrl())
                .build();
    }

    public static PipelineEntity toEntity(PipelineCreateRequest request) {
        return PipelineEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .instructions(request.getInstructions())
                .repositoryUrl(request.getRepositoryUrl())
                .build();
    }

    public static Pipeline toObject(PipelineEntity entity) {
        return Pipeline.builder()
                .id(entity.getId().toString())
                .name(entity.getName())
                .description(entity.getDescription())
                .instructions(entity.getInstructions())
                .repositoryUrl(entity.getRepositoryUrl())
                .build();
    }
}
