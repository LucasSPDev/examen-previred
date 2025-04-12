package com.nuevospa.taskmanager.dto;

import com.nuevospa.taskmanager.dto.TareaDTO;
import com.nuevospa.taskmanager.dto.EstadoTareaDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaDTO {
	
    private Long id;
    private String titulo;
    private String descripcion;
    private EstadoTareaDTO estadoTarea;
    
    public TareaDTO() {
        this.estadoTarea = new EstadoTareaDTO(); 
    }

}
