package com.study.architecture_stuff.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class ExternalService {

    @SneakyThrows
    @CircuitBreaker(name = "apiService", fallbackMethod = "fallbackResponse")
    public String callExternalApi() {
        throw new RuntimeException("Erro simulado");
    }

    public String fallbackResponse(Throwable t) {
        return "Fallback foi chamado";
    }
}

