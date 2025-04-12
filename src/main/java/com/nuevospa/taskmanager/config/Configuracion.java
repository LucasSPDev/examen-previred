package com.nuevospa.taskmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import com.nuevospa.taskmanager.security.InterceptorRequest;

@Configuration
@EnableWebSecurity
public class Configuracion {

	private final InterceptorRequest interceptorRequest;

	public Configuracion(InterceptorRequest interceptorRequest) {
		this.interceptorRequest = interceptorRequest;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {    

//		http
//		.authorizeRequests(auth -> auth
//				.requestMatchers("/h2-console/**").permitAll()  // Permite el acceso sin autenticación a la consola H2
//				.requestMatchers("/api/auth/login").permitAll()  // Permite el acceso sin autenticación al login
//				.requestMatchers("/api/tareas/crear").permitAll()
//				.anyRequest().authenticated()  // Las demás rutas requieren autenticación
//				)
//		.csrf(csrf -> csrf
//				.ignoringRequestMatchers("/h2-console/**", "/api/auth/login") // Desactiva CSRF para la consola H2
//				.disable()
//				)
//		.headers().frameOptions().disable();  // Permite cargar el iframe de la consola H2
//
//		return http.build();
		
        http
        .csrf().disable()
        .authorizeRequests()
        .requestMatchers("/api/auth/login").permitAll()
        .requestMatchers("/h2-console/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .headers()
            .frameOptions().disable()
        .and()
        .addFilterBefore(interceptorRequest, UsernamePasswordAuthenticationFilter.class);

    return http.build();
	}
}