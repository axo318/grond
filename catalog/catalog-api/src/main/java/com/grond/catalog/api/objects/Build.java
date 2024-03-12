package com.grond.catalog.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grond.common.validators.ValidJson;
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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
