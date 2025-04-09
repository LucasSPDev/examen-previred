package com.nuevospa.taskmanager.dto;

import com.nuevospa.taskmanager.entity.EstadoTarea;
import com.nuevospa.taskmanager.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaResponse extends RespuestaBase {
    private Long id;
    private String nombre;
    private String descripcion;
    private EstadoTarea estado;
    private String usuario;
}