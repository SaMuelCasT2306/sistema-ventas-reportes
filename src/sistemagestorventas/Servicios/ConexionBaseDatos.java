
package sistemagestorventas.Servicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    
    private String cadenaConexion;
    private String usuario;
    private String clave;

    public ConexionBaseDatos(String cadenaConexion, String usuario, String clave) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.clave = clave;
    }

    public ConexionBaseDatos() {
    }

    public void setCadenaConexion(String cadenaConexion) {
        this.cadenaConexion = cadenaConexion;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
   public Connection conexion() throws SQLException {
       
       if (usuario != null && clave != null){
           return DriverManager.getConnection(cadenaConexion,usuario,clave);
       }
       return DriverManager.getConnection(cadenaConexion);
   }      
   
}
