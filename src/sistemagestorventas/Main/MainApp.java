package sistemagestorventas.Main;

import sistemagestorventas.Servicios.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class MainApp {

    public static void main(String[] args) {
        
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS01;databaseName=db_ventas;integratedSecurity=true;encrypt=false";
        String usuario = "";
        String password = "";
                        
        try (Connection con = new ConexionBaseDatos(url, usuario, password).conexion()){
            System.out.println("Conexion exitosa");

        }catch(SQLException e){            
            System.out.println(e.getMessage());
        }
        
    }
    
}
