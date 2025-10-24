package com.poo.edu.utp.ingenieria.sistemaventas.utilidades;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Producto;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Reportes {

    public static void crearReportes(String rutaPlantilla, String rutaSalida, List<Producto> productos) {

        try (FileInputStream fis = new FileInputStream(rutaPlantilla); Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            int fila = 7;

            for (Producto p : productos){

                Row row = sheet.createRow(fila++);
                row.createCell(0).setCellValue(p.getCodigo());
                row.createCell(1).setCellValue(p.getNombre());
                row.createCell(2).setCellValue(p.getPrecioUnitario());

            }

            try (FileOutputStream fos = new FileOutputStream(rutaSalida)){
                workbook.write(fos);
            }

        }catch (IOException e){
            e.printStackTrace();

        }

    }

}
