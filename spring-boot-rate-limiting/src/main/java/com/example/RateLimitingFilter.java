package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class RateLimitingFilter implements Filter {

    private static final int MAX_REQUESTS_PER_MINUTE = 5;
    private final Map<String, AtomicInteger> requestCounts = new ConcurrentHashMap<>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException 
    {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String clientIp = httpRequest.getRemoteAddr();
        requestCounts.putIfAbsent(clientIp, new AtomicInteger(0));
        int currentCount = requestCounts.get(clientIp).incrementAndGet();

        if (currentCount > MAX_REQUESTS_PER_MINUTE) {
        	httpResponse.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            httpResponse.getWriter().write("Too many requests. Please try again later.");
            return;
        }

        chain.doFilter(request, response);
    }
}