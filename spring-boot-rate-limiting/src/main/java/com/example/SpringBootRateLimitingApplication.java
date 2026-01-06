package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootRateLimitingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRateLimitingApplication.class, args);
	}
	
	@Bean
    public FilterRegistrationBean<RateLimitingFilter> rateLimitingFilter() 
	{
        FilterRegistrationBean<RateLimitingFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new RateLimitingFilter());
        registration.addUrlPatterns("/api/*");
        return registration;
    }
}
