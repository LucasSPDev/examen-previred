package com.nuevospa.taskmanager.controller;

import com.nuevospa.taskmanager.dto.CrearTareaRequest;
import com.nuevospa.taskmanager.dto.CrearTareaResponse;
import com.nuevospa.taskmanager.dto.ListarTareasRequest;
import com.nuevospa.taskmanager.dto.ListarTareasResponse;
import com.nuevospa.taskmanager.dto.TareaEliminarRequest;
import com.nuevospa.taskmanager.dto.TareaPorIdRequest;
import com.nuevospa.taskmanager.dto.RespuestaBase;
import com.nuevospa.taskmanager.service.TareaService;
import com.nuevospa.taskmanager.util.NuevoSPAParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @PostMapping("/crear")
    public ResponseEntity<CrearTareaResponse> crearTarea(@RequestBody CrearTareaRequest request) {
    	
    	CrearTareaResponse response = new CrearTareaResponse();
    	response.setCodigo(NuevoSPAParams.CODIGO_OK);
    	response.setDescripcion(NuevoSPAParams.DESCRIPCION_OK);
    	
    	response = tareaService.crearTarea(request);
       
        return ResponseEntity.ok(response);
    }

    @PostMapping("/listarTareaPorEstado")
    public ResponseEntity<ListarTareasResponse> ListarTareaPorEstado(@RequestBody ListarTareasRequest request) {
    	
    	ListarTareasResponse response = new ListarTareasResponse();
    	response.setCodigo(NuevoSPAParams.CODIGO_OK);
    	response.setDescripcion(NuevoSPAParams.DESCRIPCION_OK);
    	
    	response = tareaService.listarTareasPorEstado(request);
       
        return ResponseEntity.ok(response);
    }
}
