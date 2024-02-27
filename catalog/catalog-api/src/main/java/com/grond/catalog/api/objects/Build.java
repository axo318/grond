package com.grond.catalog.api.objects;

import com.grond.common.validators.ValidJson;
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Build {
    @Nonnull
    private String id;
    @Nonnull
    private String pipelineId;
    @Nonnull
    private Date startTime;
    @Nullable
    private Date endTime;
    @Nonnull
    private BuildStatus status;
    @Nonnull
    @ValidJson
    private String instructions;
    @Nullable
    private String repositoryUrl;
}
