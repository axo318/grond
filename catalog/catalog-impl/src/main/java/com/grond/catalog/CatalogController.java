package com.grond.catalog;

import com.grond.catalog.api.CatalogObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {
    @GetMapping("/catalog")
    public CatalogObject catalog() {
        return new CatalogObject("catalog");
    }
}
