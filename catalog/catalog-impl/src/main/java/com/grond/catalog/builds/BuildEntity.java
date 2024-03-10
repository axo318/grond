package com.grond.catalog.builds;

import com.grond.catalog.api.objects.BuildStatus;
import com.grond.catalog.pipeline.PipelineEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
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
@Table(name = "build")
public class BuildEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Nonnull
    @Column(name = "pipeline_id", nullable = false)
    private UUID pipelineId;

    @Nonnull
    @Column(name = "start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Nullable
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Nonnull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BuildStatus status;

    @Nonnull
    @Column(name = "instructions", nullable = false, columnDefinition = "jsonb")
    private String instructions;

    @Nullable
    @Column(name = "repository_url")
    private String repositoryUrl;

    @ManyToOne
    @JoinColumn(name = "pipeline_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PipelineEntity pipeline;
}


