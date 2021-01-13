package org.dell.kube.pages;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category")
public interface CategoryClient {
    @GetMapping("/category/{categoryId}")
    Category findCategory(@PathVariable("categoryId") Long categoryId);
}