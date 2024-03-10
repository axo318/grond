package com.grond.catalog.builds;


import com.grond.catalog.api.endpoints.BuildEndpoints;
import com.grond.catalog.api.objects.Build;
import com.grond.catalog.api.objects.BuildCreateRequest;
import com.grond.common.dialog.Controller;
import com.grond.common.exception.ErrorCode;
import com.grond.common.exception.ServiceException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildController extends Controller implements BuildEndpoints {
    private final BuildRepository buildRepository;

    @Autowired
    public BuildController(BuildRepository buildRepository) {
        this.buildRepository = buildRepository;
    }

    @Override
    public Build getBuild(String buildId) {
        return buildRepository.findById(UUID.fromString(buildId))
                .map(BuildMapper::toObject)
                .orElseThrow(() -> new ServiceException("Build not found", ErrorCode.NOT_FOUND));
    }

    @Override
    public List<Build> getBuilds() {
        return buildRepository.findAll().stream()
                .map(BuildMapper::toObject)
                .toList();
    }

    @Override
    public Build createBuild(BuildCreateRequest request) {
        return BuildMapper.toObject(buildRepository.save(BuildMapper.toEntity(request)));
    }

    @Override
    public void updateBuild(BuildCreateRequest request) {
        buildRepository.save(BuildMapper.toEntity(request));
    }

    @Override
    public void deleteBuild(String buildId) {
        buildRepository.deleteById(UUID.fromString(buildId));
    }
}
