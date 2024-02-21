package com.grond.catalog.api.objects;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Date;

@Data
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
    private String status;
}
