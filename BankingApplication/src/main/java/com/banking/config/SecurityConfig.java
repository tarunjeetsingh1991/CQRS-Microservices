package com.banking.config;



import com.banking.service.UserService;
import com.banking.config.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.authentication.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UserService authService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(UserService authService, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.authService = authService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    // Define the password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Define the AuthenticationManager as a Bean
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(authService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    // Define the SecurityFilterChain for HTTP security
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .requestMatchers("/api/auth/**").permitAll() // Allow authentication endpoints without authentication
                .anyRequest().authenticated()           // All other requests need to be authenticated
            .and()
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);  // Add JWT filter before the default Spring filter

        return http.build();
    }
}
