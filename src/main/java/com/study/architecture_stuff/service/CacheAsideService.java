package com.study.architecture_stuff.service;

import com.study.architecture_stuff.model.Info;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheAsideService {

    @Cacheable("cache-simples")
    public Info getInfo() {
        return new Info("Cache aside!");
    }
}


