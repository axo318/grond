package com.grond.catalog.pipeline;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pipeline")
public class PipelineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Nonnull
    @Column(name = "name", nullable = false)
    private String name;

    @Nullable
    @Column(name = "description")
    private String description;

    @Nonnull
    @Column(name = "instructions", nullable = false, columnDefinition = "jsonb")
    private String instructions;

    @Nullable
    @Column(name = "repository_url")
    private String repositoryUrl;
}
