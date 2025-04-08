package com.nuevospa.taskmanager.service;

import com.nuevospa.taskmanager.dto.TareaRequest;
import com.nuevospa.taskmanager.dto.TareaResponse;
import com.nuevospa.taskmanager.entity.Tarea;
import com.nuevospa.taskmanager.entity.Usuario;
import java.util.List;
import java.util.Optional;

public interface TareaService {
    List<Tarea> findByUsuario(Usuario usuario);
    Tarea save(Tarea tarea);
    void delete(Long id);
    Optional<Tarea> findById(Long id);
    TareaResponse crearTarea(TareaRequest tareaRequest);
}
