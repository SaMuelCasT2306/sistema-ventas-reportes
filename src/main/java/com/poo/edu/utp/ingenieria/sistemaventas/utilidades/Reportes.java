package com.poo.edu.utp.ingenieria.sistemaventas.utilidades;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Producto;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Reportes {

    public static void crearReportesProductos(String rutaPlantilla, String rutaSalida, List<Producto> productos) {

        try (FileInputStream fis = new FileInputStream(rutaPlantilla); Workbook workbook = new XSSFWorkbook(fis)) {

            //Definir fecha actual
            Date fechaActual = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = formatoFecha.format(fechaActual);

            Sheet sheet = workbook.getSheetAt(0);
            // Inicio de tabla
            int fila = 7;
            // Cantidad de columnas
            int columnas = 4;

            // Definir formato del precio del los productos
            DecimalFormat df = new DecimalFormat("0.00");

            // Estilo de borde de celda
            CellStyle estiloBorde = workbook.createCellStyle();
            estiloBorde.setBorderTop(BorderStyle.THIN);
            estiloBorde.setBorderBottom(BorderStyle.THIN);
            estiloBorde.setBorderLeft(BorderStyle.THIN);
            estiloBorde.setBorderRight(BorderStyle.THIN);

            // Insertar informacion de empresa
            Row rowEmpresa = sheet.getRow(2);
            Cell cellEmpresa = rowEmpresa.createCell(2);
            cellEmpresa.setCellValue("TEC.SAC");

            //Insertar fecha actual
            Row rowFecha = sheet.getRow(3);
            Cell cellFecha = rowFecha.createCell(2);
            cellFecha.setCellValue(fechaFormateada);

            // Insertar valores en el reporte
            for (Producto p : productos) {
                Row row = sheet.createRow(fila++);
                for (int col = 0; col < columnas; col++) {
                    Cell cell = row.createCell(col);
                    // Formatear precio
                    String precioFormateado = df.format(p.getPrecioUnitario());
                    switch (col) {
                        case 0:
                            cell.setCellValue(p.getId());
                            cell.setCellStyle(estiloBorde);
                            break;
                        case 1:
                            cell.setCellValue(p.getCodigo());
                            cell.setCellStyle(estiloBorde);
                            break;
                        case 2:
                            cell.setCellValue(p.getNombre());
                            cell.setCellStyle(estiloBorde);
                            break;
                        case 3:
                            cell.setCellValue("S/. " + precioFormateado);
                            cell.setCellStyle(estiloBorde);
                            break;
                    }
                }
            }

            try (FileOutputStream fos = new FileOutputStream(rutaSalida)) {
                workbook.write(fos);
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}
