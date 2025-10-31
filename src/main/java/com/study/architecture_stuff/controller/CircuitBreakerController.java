package com.study.architecture_stuff.controller;

import com.study.architecture_stuff.model.Info;
import com.study.architecture_stuff.service.ExternalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CircuitBreakerController {

    private final ExternalService service;


    @GetMapping("/circuit-breaker")
    public ResponseEntity<Info> test() {
        return ResponseEntity.ok(new Info(service.callExternalApi()));
    }
}
