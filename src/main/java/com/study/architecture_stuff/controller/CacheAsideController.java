package com.study.architecture_stuff.controller;

import com.study.architecture_stuff.model.Info;
import com.study.architecture_stuff.service.CacheAsideService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CacheAsideController {

    private final CacheAsideService cacheAsideService;

    @GetMapping("/cache-aside")
    public ResponseEntity<Info> getCacheAside() {
        Info info = cacheAsideService.getInfo();
        return ResponseEntity.ok(info);
    }

}
