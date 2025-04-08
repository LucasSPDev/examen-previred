package com.nuevospa.taskmanager.controller;

//import src.main.java.com.nuevospa.taskmanager.dto.request.LoginRequest;
//import src.main.java.com.nuevospa.taskmanager.dto.response.RespuestaBase;
//import src.main.java.com.nuevospa.taskmanager.service.JwtService;
//import src.main.java.com.nuevospa.taskmanager.service.UsuarioService;
//import src.main.java.com.nuevospa.taskmanager.util.NuevoSPAParams;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
public class AuthController {

//    @Autowired
//    private JwtService jwtService;
//
//    @Autowired
//    private UsuarioService usuarioService;


//    @PostMapping("/login")
//    public ResponseEntity<RespuestaBase> login(@RequestBody LoginRequest loginRequest) {
//
//        String token = jwtService.authenticateAndGenerateToken(loginRequest.getUsername(), loginRequest.getPassword());
//
//        if (token == null) {
//            return ResponseEntity.status(401).body(
//                    new RespuestaBase(NuevoSPAParams.CODIGO_NO_AUTORIZADO, NuevoSPAParams.DESCRIPCION_NO_AUTORIZADO)
//            );
//        }
//
//        return ResponseEntity.ok(
//                new RespuestaBase(NuevoSPAParams.CODIGO_OK, NuevoSPAParams.DESCRIPCION_OK, token)
//        );
//    }
}