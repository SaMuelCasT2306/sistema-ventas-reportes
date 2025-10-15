package sistemagestorventas.Main;

import Modelos.Cliente;
import Repositorios.ClienteRepository;
import sistemagestorventas.Servicios.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS01;databaseName=db_ventas;integratedSecurity=true;encrypt=false";
        String usuario = "";
        String password = "";
                        
        ConexionBaseDatos con = new ConexionBaseDatos(url, usuario, password);
        ClienteRepository cr = new ClienteRepository(con);

        Cliente c = new Cliente(2, 54536666, "Samuel Castillo", "Av. Alamos");
        
        try {
            
            /*
            cr.insertarCliente(c);
            System.out.println("Cliente agregado con exito, id: " + c.getId());
            */
            
            /*
            List<Cliente> listaclientes = cr.listarClientes();
            if (listaclientes.isEmpty()){
                System.out.println("La lista de clientes esta vacia");
            }else{
                for (Cliente e : listaclientes){
                    System.out.println("id: " + e.getId() + " | ruc: " + e.getRuc() + " | nombre: " + e.getNombre() + " | direccion: " + e.getDireccion());
                }
            }
            */
            
            /*
            cr.updateCliente(c);
            System.out.println("Fila actualizada correctamente");
            */
            
            cr.deleteCliente(c);
            System.out.println("Fila eliminida correctamente");

        }catch (SQLException e){
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
                    
        }
        
        
    
    }
    
