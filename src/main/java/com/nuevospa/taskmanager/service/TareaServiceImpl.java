package com.nuevospa.taskmanager.service;


import com.nuevospa.taskmanager.dto.TareaRequest;
import com.nuevospa.taskmanager.dto.TareaResponse;
import com.nuevospa.taskmanager.entity.EstadoTarea;
import com.nuevospa.taskmanager.entity.Tarea;
import com.nuevospa.taskmanager.entity.Usuario;
import com.nuevospa.taskmanager.repository.TareaRepository;
import com.nuevospa.taskmanager.repository.UsuarioRepository;
import com.nuevospa.taskmanager.service.TareaService;
import com.nuevospa.taskmanager.util.NuevoSPAParams;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements TareaService {
    private final TareaRepository tareaRepository;
    private final UsuarioRepository usuarioRepository;
    
    
    @Override
    public TareaResponse crearTarea(TareaRequest tareaRequest) {
    	
    	try {
    		
    		TareaResponse tareaResponse = new TareaResponse();
        	tareaResponse.setCodigo(NuevoSPAParams.CODIGO_OK);
        	tareaResponse.setDescripcion(NuevoSPAParams.DESCRIPCION_OK);
        	
        	Optional<Usuario> usuarioOptional = usuarioRepository.findById(tareaRequest.getIdUsuario());

            if (usuarioOptional.isEmpty()) {
       
            	tareaResponse.setCodigo(NuevoSPAParams.CODIGO_USUARIO_NO_ENCONTRADO);
            	tareaResponse.setDescripcion(NuevoSPAParams.DESC_USUARIO_NO_ENCONTRADO);
            	return tareaResponse;
            }

            Usuario usuario = usuarioOptional.get();

            Tarea nuevaTarea = new Tarea();
            EstadoTarea estadoTarea = new EstadoTarea();
            
            estadoTarea.setId(1L);
            estadoTarea.setNombre(NuevoSPAParams.ESTADO_TAREA_PENDIENTE);
            
            nuevaTarea.setTitulo(tareaRequest.getNombreTarea());
            nuevaTarea.setDescripcion(tareaRequest.getDescripcionTarea());
            nuevaTarea.setEstadoTarea(estadoTarea);
            nuevaTarea.setUsuario(usuario);

            Tarea tareaGuardada = tareaRepository.save(nuevaTarea);
            
            if (tareaGuardada == null && tareaGuardada.getId() == null) {
            	tareaResponse.setCodigo(NuevoSPAParams.CODIIGO_ERROR_CREAR_TAREA);
            	tareaResponse.setDescripcion(NuevoSPAParams.DESC_ERROR_CREAR_TAREA);
            	return tareaResponse;
            }
            
            
            tareaResponse.setId(tareaGuardada.getId());
            tareaResponse.setNombre(tareaGuardada.getTitulo());
            tareaResponse.setDescripcion(tareaGuardada.getDescripcion());
            tareaResponse.setEstado(tareaGuardada.getEstadoTarea());
            tareaResponse.setUsuario(tareaGuardada.getUsuario().getNombre());
            
            
            return tareaResponse;
    		
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    		
    		TareaResponse errorTarea = new TareaResponse();
    		errorTarea.setCodigo(NuevoSPAParams.CODIGO_ERROR);
    		errorTarea.setDescripcion(NuevoSPAParams.DESCRIPCION_ERROR);
        	
        	return errorTarea;
    		
    	}
    	
    }

    public TareaServiceImpl(TareaRepository tareaRepository, UsuarioRepository usuarioRepository ) {
        this.tareaRepository = tareaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Tarea> findByUsuario(Usuario usuario) {
        return tareaRepository.findByUsuario(usuario);
    }

    @Override
    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public void delete(Long id) {
        tareaRepository.deleteById(id);
    }

    @Override
    public Optional<Tarea> findById(Long id) {
        return tareaRepository.findById(id);
    }
    

}
