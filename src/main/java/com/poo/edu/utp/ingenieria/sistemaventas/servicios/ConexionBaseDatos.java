
package com.poo.edu.utp.ingenieria.sistemaventas.servicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    
    //Atributos
    private String cadenaConexion;
    private String usuario;
    private String clave;

    //Constructor
    public ConexionBaseDatos(String cadenaConexion, String usuario, String clave) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.clave = clave;
    }

    //Constructor vacio
    public ConexionBaseDatos() {
    }

    //Setters
    public void setCadenaConexion(String cadenaConexion) {
        this.cadenaConexion = cadenaConexion;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    //Metodo de conexión a BD
    public Connection conexion() throws SQLException {
       
       if (usuario != null && clave != null){
           return DriverManager.getConnection(cadenaConexion,usuario,clave);
       }
       return DriverManager.getConnection(cadenaConexion);
   }      
   
}
