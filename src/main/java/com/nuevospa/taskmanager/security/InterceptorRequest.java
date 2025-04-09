package com.nuevospa.taskmanager.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class InterceptorRequest extends OncePerRequestFilter {

	@Value("${jwt.secret}")
	private String secretKey;
	
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    	 System.out.println("Interceptor...");
    	 
         if (request.getRequestURI().equals("/api/auth/login")) {
        	 
        	 System.out.println("Excepcion de login");
             filterChain.doFilter(request, response); // Continuar con la cadena de filtros
             return;
         }

         String token = request.getHeader("Authorization"); // Obtener token del encabezado

         // Si el token no está presente
         if (token == null || !token.startsWith("Bearer ")) {
             response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token no presente o formato incorrecto");
             return;
         }

         token = token.substring(7); // Extraer el token eliminando "Bearer "

         try {
             Claims claims = Jwts.parser()
                     .setSigningKey(secretKey)
                     .parseClaimsJws(token)
                     .getBody();

             // Si el token es válido, establecer el usuario en el contexto de seguridad
             Authentication authentication = new UsernamePasswordAuthenticationToken(claims.getSubject(), null, new ArrayList<>());
             SecurityContextHolder.getContext().setAuthentication(authentication);

         } catch (Exception e) {
             System.out.println("Token no válido o expirado...");
             response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token no válido o expirado");
             return;
         }

         filterChain.doFilter(request, response); // Continuar con la cadena de filtros
    }
}
