package com.poo.edu.utp.ingenieria.sistemaventas;

import com.poo.edu.utp.ingenieria.sistemaventas.dto.FacturaProducto;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Cliente;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Producto;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.ClienteRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.FacturaRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.ProductoRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.servicios.ConexionBaseDatos;
import com.poo.edu.utp.ingenieria.sistemaventas.utilidades.Reportes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EduUtpIngenieriaSistemaventas {

    public static void main(String[] args) {

        //String url = "jdbc:sqlserver://localhost\\SQLEXPRESS01;databaseName=db_ventas;integratedSecurity=true;encrypt=false";
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER ;databaseName=db_ventas;integratedSecurity=true;encrypt=false";
        String usuario = "";
        String password = "";

        ConexionBaseDatos con = new ConexionBaseDatos(url, usuario, password);
        ClienteRepository cr = new ClienteRepository(con);
        ProductoRepository pr = new ProductoRepository(con);
        FacturaRepository fr = new FacturaRepository(con);
        

        Cliente c = new Cliente(2, 54536666, "Samuel Castillo", "Av. Alamos");
        Producto p = new Producto(1, "P002", "PS5", (float) 45.25);

        try {
            
            Date fechaActual = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd_HHmmss");
            String fechaArchivo = sdf.format(fechaActual);

            /*
            cr.insertarCliente(c);
            System.out.println("Cliente agregado con exito, id: " + c.getId());
             */
 /*
            cr.updateCliente(c);
            System.out.println("Fila actualizada correctamente");
             */
 /*
            cr.deleteCliente(c);
            System.out.println("Fila eliminida correctamente");
             */

            /* 
            List<Producto> listaProductos = pr.listarProductos();
            pr.imprimirListaProductos(listaProductos);

            List<Cliente> listaClientes = cr.listarClientes();
            cr.imprimirListaClientes(listaClientes);

            String rutaPlantilla = "C:\\Test\\plantilla_reporte.xlsx";
            String rutaSalida = "C:\\Test\\Output\\reporte_" + fechaArchivo + ".xlsx";

            Reportes.crearReportesProductos(rutaPlantilla, rutaSalida, listaProductos);
            */

            List<FacturaProducto> listaFacturaProductos = fr.listaFacturasPorNombreProducto("P020");
            fr.ImprimirFacturasPorNombreProducto(listaFacturaProductos);


        } catch (Exception e) {
            StackTraceElement ste = e.getStackTrace()[0];
            System.err.println("Error en la clase: " + ste.getClassName() + "en el metodo: " + ste.getMethodName() + ", en la linea: " + ste.getLineNumber());
            System.err.println("Detalle error: " + e.getMessage());
        }

    }

}
