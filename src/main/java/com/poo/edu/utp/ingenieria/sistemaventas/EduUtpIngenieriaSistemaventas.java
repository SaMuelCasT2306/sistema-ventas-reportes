package com.poo.edu.utp.ingenieria.sistemaventas;

import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Cliente;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Producto;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.ClienteRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.ProductoRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.servicios.ConexionBaseDatos;
import java.sql.SQLException;
import java.util.List;

public class EduUtpIngenieriaSistemaventas {

    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS01;databaseName=db_ventas;integratedSecurity=true;encrypt=false";
        String usuario = "";
        String password = "";

        ConexionBaseDatos con = new ConexionBaseDatos(url, usuario, password);
        ClienteRepository cr = new ClienteRepository(con);
        ProductoRepository pr = new ProductoRepository(con);

        Cliente c = new Cliente(2, 54536666, "Samuel Castillo", "Av. Alamos");
        Producto p = new Producto(1, "P002", "PS5", (float) 45.25);

        try {

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
            List<Producto> listaProductos = pr.listarProductos();
            pr.imprimirListaProductos(listaProductos);

            List<Cliente> listaClientes = cr.listarClientes();
            cr.imprimirListaClientes(listaClientes);

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
