package com.grond.catalog.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grond.common.validators.ValidJson;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineCreateRequest {
    @Nonnull
    private String name;
    @Nullable
    private String description;
    @Nonnull
    @ValidJson
    private String instructions;
    @Nullable
    private String repositoryUrl;
}
