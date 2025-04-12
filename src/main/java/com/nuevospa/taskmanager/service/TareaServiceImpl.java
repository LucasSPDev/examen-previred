package com.nuevospa.taskmanager.service;


import com.nuevospa.taskmanager.dto.CrearTareaRequest;
import com.nuevospa.taskmanager.dto.CrearTareaResponse;

import com.nuevospa.taskmanager.dto.ListarTareasRequest;
import com.nuevospa.taskmanager.dto.ListarTareasResponse;

import com.nuevospa.taskmanager.entity.EstadoTarea;
import com.nuevospa.taskmanager.entity.Tarea;
import com.nuevospa.taskmanager.dto.TareaDTO;
import com.nuevospa.taskmanager.dto.UsuarioDTO;
import com.nuevospa.taskmanager.entity.Usuario;
import com.nuevospa.taskmanager.repository.TareaRepository;
import com.nuevospa.taskmanager.repository.UsuarioRepository;
import com.nuevospa.taskmanager.service.TareaService;
import com.nuevospa.taskmanager.util.NuevoSPAParams;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class TareaServiceImpl implements TareaService {
	
    private final TareaRepository tareaRepository;
    private final UsuarioRepository usuarioRepository;
    
    public TareaServiceImpl(TareaRepository tareaRepository, UsuarioRepository usuarioRepository) {
        this.tareaRepository = tareaRepository;
        this.usuarioRepository = usuarioRepository;
    }
    
    @Override
    @Transactional
    public CrearTareaResponse crearTarea(CrearTareaRequest request) {
    	
    	try {
    		
            Tarea nuevaTarea = new Tarea();
           
            
    		CrearTareaResponse response = new CrearTareaResponse();
        	response.setCodigo(NuevoSPAParams.CODIGO_OK);
        	response.setDescripcion(NuevoSPAParams.DESCRIPCION_OK);
        	
        	Optional<Usuario> usuarioOptional = usuarioRepository.findById(request.getIdUsuario());

            if (usuarioOptional.isEmpty()) {
       
            	response.setCodigo(NuevoSPAParams.CODIGO_USUARIO_NO_ENCONTRADO);
            	response.setDescripcion(NuevoSPAParams.DESC_USUARIO_NO_ENCONTRADO);
            	return response;
            }

            Usuario usuario = usuarioOptional.get();
            
            EstadoTarea estadoTarea = new EstadoTarea();
            estadoTarea.setId(1L);
            estadoTarea.setNombre(NuevoSPAParams.ESTADO_TAREA_PENDIENTE);
            
            nuevaTarea.setTitulo(request.getTituloTarea());
            nuevaTarea.setDescripcion(request.getDescripcionTarea());
            nuevaTarea.setEstadoTarea(estadoTarea);
            nuevaTarea.setUsuario(usuario);

            Tarea tareaGuardada = tareaRepository.save(nuevaTarea);
            
            if (tareaGuardada == null && tareaGuardada.getId() == null) {
            	response.setCodigo(NuevoSPAParams.CODIIGO_ERROR_CREAR_TAREA);
            	response.setDescripcion(NuevoSPAParams.DESC_ERROR_CREAR_TAREA);
            	return response;
            }
            
            
            response.getTarea().setId(tareaGuardada.getId());
            response.getTarea().setTitulo(tareaGuardada.getTitulo());
            response.getTarea().setDescripcion(tareaGuardada.getDescripcion());
            response.getTarea().getEstadoTarea().setNombre(tareaGuardada.getEstadoTarea().getNombre());
            response.getTarea().getEstadoTarea().setId(tareaGuardada.getEstadoTarea().getId());
            response.setIdUsuario(tareaGuardada.getUsuario().getId());
            
            
            return response;
    		
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    		
    		CrearTareaResponse errorResponse = new CrearTareaResponse();
    		errorResponse.setCodigo(NuevoSPAParams.CODIGO_ERROR);
    		errorResponse.setDescripcion(NuevoSPAParams.DESCRIPCION_ERROR);
        	
        	return errorResponse;
    		
    	}
    	
    }
    
    @Override
    public ListarTareasResponse listarTareasPorEstado(ListarTareasRequest request) {
    	try {
    		
        	ListarTareasResponse response = new ListarTareasResponse();
        	response.setCodigo(NuevoSPAParams.CODIGO_OK);
        	response.setDescripcion(NuevoSPAParams.DESCRIPCION_OK);
        	
        	List<Tarea> tareasList = null;
            if (request.getEstadoTarea() != null && !request.getEstadoTarea().isEmpty() && request.getEstadoTarea().equals("ALL")) {

               tareasList = tareaRepository.findByEstadoTarea_Nombre(request.getEstadoTarea());
                
            } else {
            
            	tareasList = tareaRepository.findAll();
                 
            }
            
            if(tareasList == null || tareasList.isEmpty()) {
            	response.setCodigo(NuevoSPAParams.CODIGO_TAREAS_NO_ENCONTRADAS);
            	response.setDescripcion(NuevoSPAParams.DESC_TAREAS_NO_ENCONTRADAS);
            }

            List<TareaDTO> tareaDTOList = new ArrayList<>();
            for (Tarea tarea : tareasList) {
                TareaDTO dto = new TareaDTO();
                dto.setId(tarea.getId());
                dto.setTitulo(tarea.getTitulo());
                dto.setDescripcion(tarea.getDescripcion());
                dto.getEstadoTarea().setNombre(tarea.getEstadoTarea().getNombre());
                dto.getEstadoTarea().setId(tarea.getEstadoTarea().getId());
                tareaDTOList.add(dto);
            }
            
            response.setListaTareas(tareaDTOList);
        	
        	return response;
    		
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    		
    		ListarTareasResponse errorResponse = new ListarTareasResponse();
    		errorResponse.setCodigo(NuevoSPAParams.CODIGO_ERROR);
    		errorResponse.setDescripcion(NuevoSPAParams.DESCRIPCION_ERROR);
        	
        	return errorResponse;
    		
    	}
    }

}
