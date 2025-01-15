package com.microservice.rest.webservices.restful_webservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class SpringSecurityConfiguration {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests(
			auth->auth.anyRequest().authenticated()
			);
	http.httpBasic(
			withDefaults());
	http.csrf().disable();
	return http.build();
}
}
