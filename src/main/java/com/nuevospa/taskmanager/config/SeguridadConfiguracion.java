package src.main.java.com.nuevospa.taskmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SeguridadConfiguracion {

//	 @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	        http
//	            .authorizeHttpRequests(auth -> auth
//	                .requestMatchers(
//	                    new AntPathRequestMatcher("/h2-console/**"),
//	                    new AntPathRequestMatcher("/api/**"),
//	                    new AntPathRequestMatcher("/**")
//	                ).permitAll()
//	                .anyRequest().permitAll()
//	            )
//	            .csrf(csrf -> csrf
//	                .ignoringRequestMatchers(
//	                    new AntPathRequestMatcher("/h2-console/**"),
//	                    new AntPathRequestMatcher("/api/**")
//	                )
//	                .disable()
//	            )
//	            .headers(headers -> headers
//	                .frameOptions().disable()
//	            )
//	            .httpBasic(Customizer.withDefaults());
//
//	        return http.build();
//	    }
}