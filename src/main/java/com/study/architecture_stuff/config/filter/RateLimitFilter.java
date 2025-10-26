package com.study.architecture_stuff.config.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.architecture_stuff.model.Info;
import io.github.bucket4j.Bucket;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
public class RateLimitFilter implements Filter {

    private final Bucket bucket;
    private final ObjectMapper objectMapper;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        if (bucket.tryConsume(1)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.setContentType("application/json");
            httpResponse.setStatus(429);

            Info info = new Info("Too many requests");
            String json = objectMapper.writeValueAsString(info);

            httpResponse.getWriter().write(json);
        }
    }
}
