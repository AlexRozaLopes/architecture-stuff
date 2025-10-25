package com.study.architecture_stuff.controller;

import com.study.architecture_stuff.model.Info;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class RateLimitController {

    @GetMapping("/rate-limit")
    public ResponseEntity<Info> getRateLimit() {
        return ResponseEntity.ok(new Info("Rate Limit!"));
    }

}
