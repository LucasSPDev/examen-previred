package com.nuevospa.taskmanager.service;

import com.nuevospa.taskmanager.dto.CrearTareaRequest;
import com.nuevospa.taskmanager.dto.CrearTareaResponse;

import com.nuevospa.taskmanager.dto.ListarTareasRequest;
import com.nuevospa.taskmanager.dto.ListarTareasResponse;

import com.nuevospa.taskmanager.dto.TareaDTO;
import com.nuevospa.taskmanager.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface TareaService {
	
	CrearTareaResponse crearTarea(CrearTareaRequest request);
	ListarTareasResponse listarTareasPorEstado(ListarTareasRequest request);
  
}
