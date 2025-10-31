package com.study.architecture_stuff.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

@Configuration
public class CircuitBreakConfig {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(1)).build())
                .circuitBreakerConfig(CircuitBreakerConfig.custom()
                        .failureRateThreshold(10)
                        .slidingWindowSize(2)
                        .waitDurationInOpenState(Duration.ofSeconds(5))
                        .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                        .minimumNumberOfCalls(1)
                        .recordExceptions(RuntimeException.class, TimeoutException.class)
                        .slowCallRateThreshold(10)
                        .build()
                )
                .build());
    }
}
