package com.nuevospa.taskmanager.dto;

import com.nuevospa.taskmanager.entity.EstadoTarea;
import com.nuevospa.taskmanager.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaRequest {
    private String nombreTarea;
    private String descripcionTarea;
    private long idUsuario;
}
