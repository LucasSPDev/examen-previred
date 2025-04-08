package com.nuevospa.taskmanager.util;

public class NuevoSPAParams {

    // =======================
    // Códigos de Respuesta
    // =======================
    public static final String CODIGO_OK = "200";
    public static final String DESCRIPCION_OK = "Operación realizada con éxito";

    public static final String CODIGO_ERROR = "500";
    public static final String DESCRIPCION_ERROR = "Ocurrió un error inesperado";

    public static final String CODIGO_NO_AUTORIZADO = "401";
    public static final String DESCRIPCION_NO_AUTORIZADO = "Usuario no autorizado";

    public static final String CODIGO_NO_ENCONTRADO = "404";
    public static final String DESCRIPCION_NO_ENCONTRADO = "Recurso no encontrado";

    public static final String CODIGO_CONFLICTO = "409";
    public static final String DESCRIPCION_CONFLICTO = "Conflicto con los datos solicitados";
    
    
    public static final String CODIIGO_ERROR_CREAR_TAREA ="01";
    public static final String DESC_ERROR_CREAR_TAREA = "No se ha podifo crear la tarea";
    
    public static final String CODIGO_USUARIO_NO_ENCONTRADO = "02";
    public static final String DESC_USUARIO_NO_ENCONTRADO = "Usuario no conetrado";

    // =======================
    // Mensajes Comunes
    // =======================
    public static final String MENSAJE_USUARIO_NO_ENCONTRADO = "El usuario no fue encontrado";
    public static final String MENSAJE_TAREA_NO_ENCONTRADA = "La tarea no fue encontrada";
    public static final String MENSAJE_ERROR_CREACION_TAREA = "Error al crear la tarea";
    public static final String MENSAJE_ERROR_ACTUALIZACION_TAREA = "Error al actualizar la tarea";
    
    // =======================
    // Parámetros Utilizados
    // =======================
    public static final String PARAM_TOKEN = "token";
    public static final String PARAM_USUARIO_ID = "usuarioId";
    
    // =======================
    // Códigos de Estado de Tarea
    // =======================
    public static final String ESTADO_TAREA_PENDIENTE = "Pendiente";
    public static final String ESTADO_TAREA_EN_PROCESO = "En Proceso";
    public static final String ESTADO_TAREA_COMPLETADA = "Completada";
}