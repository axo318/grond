package com.grond.catalog;

import com.grond.catalog.api.clients.PipelineClient;
import com.grond.common.dialog.ClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceDependencies {
    private final ServiceConfig serviceConfig;

    @Autowired
    public ServiceDependencies(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    @Bean
    public PipelineClient pipelineClient() {
        ClientConfig clientConfig = ClientConfig.builder()
                .basePath(serviceConfig.getCatalogServiceUrl())
                .build();
        return new PipelineClient(clientConfig);
    }
}
