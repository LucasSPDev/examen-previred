package com.nuevospa.taskmanager.dto;

import com.nuevospa.taskmanager.entity.EstadoTarea;
import com.nuevospa.taskmanager.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaRequest {
    private String nombre;
    private String descripcion;
    private EstadoTarea estado;
    private Usuario usuario;
}
