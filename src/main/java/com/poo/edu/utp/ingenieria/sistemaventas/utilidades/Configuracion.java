package com.poo.edu.utp.ingenieria.sistemaventas.utilidades;

/**
 * Clase de configuración centralizada para rutas y constantes del sistema
 */
public class Configuracion {
    
    // Rutas de plantillas (puedes cambiarlas según tu estructura)
    public static final String RUTA_PLANTILLAS = "src/main/resources/plantillas/";
    public static final String RUTA_REPORTES_SALIDA = "C:/Test/Reportes_Java/";
    
    // Nombres de plantillas
    public static final String PLANTILLA_PRODUCTOS = "plantilla_reporte_productos.xlsx";
    public static final String PLANTILLA_CLIENTES = "plantilla_reporte_clientes.xlsx";
    public static final String PLANTILLA_FACTURAS = "plantilla_reporte_facturas.xlsx";
    
    // Configuración de base de datos
    public static final String DB_URL = "jdbc:sqlserver://localhost\\SQLEXPRESS01;databaseName=db_ventas;integratedSecurity=true;encrypt=false";
    public static final String DB_USUARIO = "";
    public static final String DB_PASSWORD = "";
    
    // Formatos de fecha
    public static final String FORMATO_FECHA_ARCHIVO = "yyyyMMdd_HHmmss";
    public static final String FORMATO_FECHA_REPORTE = "dd/MM/yyyy";
    
    public static String obtenerRutaPlantilla(String nombrePlantilla) {
        return RUTA_PLANTILLAS + nombrePlantilla;
    }
    
    public static String obtenerRutaSalidaReporte(String nombreBase, String extension) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(FORMATO_FECHA_ARCHIVO);
        String timestamp = sdf.format(new java.util.Date());
        return RUTA_REPORTES_SALIDA + nombreBase + "_" + timestamp + extension;
    }
}
