package com.nuevospa.taskmanager.dto;

import com.nuevospa.taskmanager.entity.EstadoTarea;
import com.nuevospa.taskmanager.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearTareaRequest {
	
    private String tituloTarea;
    private String descripcionTarea;
    private Long idUsuario;;
}
