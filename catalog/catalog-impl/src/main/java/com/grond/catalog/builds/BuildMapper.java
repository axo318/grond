package com.grond.catalog.builds;

import com.grond.catalog.api.objects.Build;
import com.grond.catalog.api.objects.BuildCreateRequest;
import com.grond.catalog.api.objects.BuildStatus;
import java.util.UUID;

public final class BuildMapper {
    public static BuildEntity toEntity(Build build) {
        return BuildEntity.builder()
                .id(UUID.fromString(build.getId()))
                .pipelineId(UUID.fromString(build.getPipelineId()))
                .startTime(build.getStartTime())
                .endTime(build.getEndTime())
                .status(build.getStatus().toString())
                .instructions(build.getInstructions())
                .repositoryUrl(build.getRepositoryUrl())
                .build();
    }

    public static BuildEntity toEntity(BuildCreateRequest request) {
        return BuildEntity.builder()
                .pipelineId(UUID.fromString(request.getPipelineId()))
                .startTime(request.getStartTime())
                .status(request.getStatus().toString())
                .instructions(request.getInstructions())
                .repositoryUrl(request.getRepositoryUrl())
                .build();
    }

    public static Build toObject(BuildEntity entity) {
        return Build.builder()
                .id(entity.getId().toString())
                .pipelineId(entity.getPipelineId().toString())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .status(BuildStatus.valueOf(entity.getStatus()))
                .instructions(entity.getInstructions())
                .repositoryUrl(entity.getRepositoryUrl())
                .build();
    }
}
