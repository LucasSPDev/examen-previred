package com.nuevospa.taskmanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse extends RespuestaBase {
    private String token;
}
