package com.grond.common.dialog;

import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;

@Data
@Builder
public final class ClientConfig {
    @Nonnull
    private String basePath;
}
