package com.grond.catalog;

import static com.grond.catalog.api.CatalogApi.CATALOG_SERVICE_BASE_PATH;
import static com.grond.catalog.api.services.PipelineService.BASE_PATH;

import com.grond.catalog.api.objects.Pipeline;
import com.grond.catalog.api.objects.PipelineCreateRequest;
import com.grond.catalog.api.objects.PipelineUpdateRequest;
import com.grond.catalog.api.services.PipelineService;
import com.grond.common.dialog.Controller;
import com.grond.common.exception.ErrorCode;
import com.grond.common.exception.ServiceException;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CATALOG_SERVICE_BASE_PATH + BASE_PATH)
public class PipelineController extends Controller implements PipelineService {
    @Override
    @GetMapping(GET_PIPELINE_PATH)
    public Pipeline getPipeline(@PathVariable String pipelineId) {
        if (pipelineId.equals("error")) {
            throw new RuntimeException("Error");
        }
        return new Pipeline(pipelineId, "name", "description");
    }

    @Override
    @GetMapping(GET_PIPELINES_PATH)
    public List<Pipeline> getPipelines() {
        return List.of(
                new Pipeline("id", "name", "description"),
                new Pipeline("id2", "name2", "description2")
        );
    }

    @Override
    @PostMapping(CREATE_PIPELINE_PATH)
    public Pipeline createPipeline(@RequestBody PipelineCreateRequest request) {
        return new Pipeline("id", request.getName(), request.getDescription());
    }

    @Override
    @PutMapping(UPDATE_PIPELINE_PATH)
    public void updatePipeline(@RequestBody PipelineUpdateRequest request) {
        if (request.getId().equals("error")) {
            throw new ServiceException("Error with user authorization", ErrorCode.UNAUTHORIZED);
        }
    }

    @Override
    @DeleteMapping(DELETE_PIPELINE_PATH)
    public void deletePipeline(@PathVariable String pipelineId) {
        if (pipelineId.equals("error")) {
            throw new RuntimeException("Error deleting error");
        }
    }
}
