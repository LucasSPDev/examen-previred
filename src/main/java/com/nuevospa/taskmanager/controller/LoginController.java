package com.nuevospa.taskmanager.controller;

import com.nuevospa.taskmanager.dto.LoginRequest;
import com.nuevospa.taskmanager.dto.LoginResponse;
import com.nuevospa.taskmanager.service.LoginService;
import com.nuevospa.taskmanager.service.UsuarioService;
import com.nuevospa.taskmanager.util.NuevoSPAParams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;


@RestController
@RequestMapping("/api/auth")
public class LoginController {

	@Autowired
	private LoginService LoginService;

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
		
		System.out.println("Inicio login");

		LoginResponse response = new LoginResponse();
		response.setCodigo(NuevoSPAParams.CODIGO_OK);
		response.setDescripcion(NuevoSPAParams.DESCRIPCION_OK);
		
		response = LoginService.login(loginRequest.getNombreUsuario(), loginRequest.getPassword());
	
		return ResponseEntity.ok(response);
	}
}