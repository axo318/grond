package com.grond.catalog;

import com.grond.catalog.api.endpoints.PipelineEndpoints;
import com.grond.catalog.api.objects.Pipeline;
import com.grond.catalog.api.objects.PipelineCreateRequest;
import com.grond.catalog.api.objects.PipelineUpdateRequest;
import com.grond.common.dialog.Controller;
import com.grond.common.exception.ErrorCode;
import com.grond.common.exception.ServiceException;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PipelineController extends Controller implements PipelineEndpoints {
    @Override
    public Pipeline getPipeline(String pipelineId) {
        if (pipelineId.equals("error")) {
            throw new RuntimeException("Error");
        }
        return new Pipeline(pipelineId, "name", "description");
    }

    @Override
    public List<Pipeline> getPipelines() {
        return List.of(
                new Pipeline("id", "name", "description"),
                new Pipeline("id2", "name2", "description2")
        );
    }

    @Override
    public Pipeline createPipeline(PipelineCreateRequest request) {
        return new Pipeline("id", request.getName(), request.getDescription());
    }

    @Override
    public void updatePipeline(PipelineUpdateRequest request) {
        if (request.getId().equals("error")) {
            throw new ServiceException("Error with user authorization", ErrorCode.UNAUTHORIZED);
        }
    }

    @Override
    public void deletePipeline(String pipelineId) {
        if (pipelineId.equals("error")) {
            throw new RuntimeException("Error deleting error");
        }
    }
}
