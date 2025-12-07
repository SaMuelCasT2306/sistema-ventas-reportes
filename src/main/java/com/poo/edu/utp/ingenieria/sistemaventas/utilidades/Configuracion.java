package com.poo.edu.utp.ingenieria.sistemaventas.utilidades;

public class Configuracion {
    
    // Rutas de plantillas
    public static final String RUTA_PLANTILLAS = "src/main/resources/plantillas/";
    public static final String RUTA_REPORTES_SALIDA = "C:/Test/";
    
    // Nombres de plantillas
    public static final String PLANTILLA_PRODUCTOS = "plantilla_reporte.xlsx";
    public static final String PLANTILLA_CLIENTES = "plantilla_reporte_clientes.xlsx";
    public static final String PLANTILLA_FACTURAS = "plantilla_reporte_facturas.xlsx";
    
    // Configuración de base de datos
    //public static final String DB_URL = "jdbc:sqlserver://localhost\\SQLEXPRESS01;databaseName=db_ventas;encrypt=false";
    public static final String DB_URL = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=db_ventas;encrypt=false";
    public static final String DB_USUARIO = "usuario_ventas";
    public static final String DB_PASSWORD = "9876543210";
    
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
    
    public static String obtenerRutaSalidaReporteUI(String ruta) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(FORMATO_FECHA_ARCHIVO);
        String timestamp = sdf.format(new java.util.Date());
        return ruta + "_" + timestamp + ".xlsx";
    }
    
}
