package com.nuevospa.taskmanager.controller;

import com.nuevospa.taskmanager.dto.TareaRequest;
import com.nuevospa.taskmanager.dto.TareaEliminarRequest;
import com.nuevospa.taskmanager.dto.TareaResponse;
import com.nuevospa.taskmanager.dto.TareaPorIdRequest;
import com.nuevospa.taskmanager.dto.RespuestaBase;
import com.nuevospa.taskmanager.service.TareaService;
import com.nuevospa.taskmanager.util.NuevoSPAParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @PostMapping("/crear")
    public ResponseEntity<TareaResponse> crearTarea(@RequestBody TareaRequest tareaRequest) {
    	
    	TareaResponse respuesta = new TareaResponse();
    	respuesta.setCodigo(NuevoSPAParams.CODIGO_OK);
    	respuesta.setDescripcion(NuevoSPAParams.DESCRIPCION_OK);
    	
    	respuesta = tareaService.crearTarea(tareaRequest);
       
        return ResponseEntity.ok(respuesta);
    }

//    @GetMapping("/listar")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    public ResponseEntity<Iterable<TareaResponse>> listarTareas() {
//        Iterable<TareaResponse> tareas = tareaService.listarTareas();
//        RespuestaBase<Iterable<TareaResponse>> respuesta = new RespuestaBase<>(tareas, NuevoSPAParams.CODIGO_OK, NuevoSPAParams.DESCRIPCION_OK);
//        return ResponseEntity.ok(respuesta);
//    }
//
//    @PostMapping("/ver")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    public ResponseEntity<TareaResponse> obtenerTarea(@RequestBody TareaPorIdRequest tareaPorIdRequest) {
//        TareaResponse tareaResponse = tareaService.obtenerTareaPorId(tareaPorIdRequest.getId());
//        if (tareaResponse == null) {
//            RespuestaBase<TareaResponse> respuesta = new RespuestaBase<>(null, NuevoSPAParams.CODIGO_NO_ENCONTRADO, NuevoSPAParams.MENSAJE_TAREA_NO_ENCONTRADA);
//            return ResponseEntity.status(Integer.parseInt(NuevoSPAParams.CODIGO_NO_ENCONTRADO)).body(respuesta);
//        }
//        RespuestaBase<TareaResponse> respuesta = new RespuestaBase<>(tareaResponse, NuevoSPAParams.CODIGO_OK, NuevoSPAParams.DESCRIPCION_OK);
//        return ResponseEntity.ok(respuesta);
//    }
//
//    @PutMapping("/actualizar")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<TareaResponse> actualizarTarea(@RequestBody TareaRequest tareaRequest) {
//        TareaResponse tareaResponse = tareaService.actualizarTarea(tareaRequest);
//        RespuestaBase<TareaResponse> respuesta = new RespuestaBase<>(tareaResponse, NuevoSPAParams.CODIGO_OK, NuevoSPAParams.DESCRIPCION_OK);
//        return ResponseEntity.ok(respuesta);
//    }
//
//   
//    
//    @DeleteMapping("/eliminar")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<TareaResponse> eliminarTarea(@RequestBody TareaEliminarRequest tareaEliminarRequest) {
//        Optional<Tarea> tareaOptional = tareaService.obtenerTareaPorId(tareaEliminarRequest.getId());
//
//        if (tareaOptional.isEmpty()) {
//            TareaResponse tareaResponse = new TareaResponse();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new TareaResponse(NuevoSPAParams.CODIGO_NO_ENCONTRADO, NuevoSPAParams.DESCRIPCION_NO_ENCONTRADO));
//        }
//
//        tareaService.eliminarTarea(tareaEliminarRequest.getId());
//
//        Optional<Tarea> tareaEliminada = tareaService.obtenerTareaPorId(tareaEliminarRequest.getId());
//        if (tareaEliminada.isPresent()) {
//            TareaResponse tareaResponseError = new TareaResponse();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(new TareaResponse(NuevoSPAParams.CODIGO_ERROR, "Error al eliminar la tarea"));
//        }
//
//        TareaResponse tareaResponse = new TareaResponse(NuevoSPAParams.CODIGO_OK, "Tarea eliminada con éxito");
//        return ResponseEntity.ok(tareaResponse);
//    }
}
