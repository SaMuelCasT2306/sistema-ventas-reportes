
package com.poo.edu.utp.ingenieria.sistemaventas.controladores;
import com.poo.edu.utp.ingenieria.sistemaventas.dto.ClienteProductoDTO;
import com.poo.edu.utp.ingenieria.sistemaventas.dto.FacturaClienteDTO;
import com.poo.edu.utp.ingenieria.sistemaventas.dto.FacturaProductoDTO;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Cliente;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Producto;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.ClienteRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.FacturaRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.ProductoRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.servicios.ConexionBaseDatos;
import com.poo.edu.utp.ingenieria.sistemaventas.ui.PantallaPrincipal;
import com.poo.edu.utp.ingenieria.sistemaventas.utilidades.Configuracion;
import com.poo.edu.utp.ingenieria.sistemaventas.utilidades.Login;
import com.poo.edu.utp.ingenieria.sistemaventas.utilidades.Reportes;
import java.sql.SQLException;
import java.util.List;

public class Controlador {
    
    ConexionBaseDatos cbd = new ConexionBaseDatos(Configuracion.DB_URL, Configuracion.DB_USUARIO, Configuracion.DB_PASSWORD);
    ClienteRepository cr = new ClienteRepository(cbd);
    ProductoRepository pr = new ProductoRepository(cbd);
    FacturaRepository fr = new FacturaRepository(cbd);
    Login l = new Login(cbd);
    
    
    public List<Cliente> cargarTablaClientes() throws SQLException{        
        List<Cliente> list = cr.listarClientes();
        return list;       
    }
    
    public List<Producto> cargarTablaProductos() throws SQLException{        
        List<Producto> list = pr.listarProductos();
        return list;       
    }
    
    public List<FacturaProductoDTO> cargarTablaFacturaProductos() throws SQLException{       
        List<FacturaProductoDTO> list = fr.listaFacturasPorNombreProducto();
        return list;       
    }
    
    public List<ClienteProductoDTO> cargarTablaClientesProducto() throws SQLException{       
        List<ClienteProductoDTO> list = cr.listarClientesPorProducto();
        return list;      
    }
    
    public List<Producto> cargarTablaProductosDinamicos(String nombre) throws SQLException{
        List<Producto> list = pr.listarProductosDinamico(nombre);
        return list;
    }
    
    public List<FacturaProductoDTO> cargarTablaFacturasProductosDinamicos(String nombre) throws SQLException{
        List<FacturaProductoDTO> list = fr.listaFacturasPorNombreProductoDinamico(nombre);
        return list;
    }
    
    public List<ClienteProductoDTO> cargarTablaClientesProductosDinamicos(String nombre) throws SQLException{       
        List<ClienteProductoDTO> list = cr.listarClientesPorProductoDinamico(nombre);
        return list;      
    }
    
    public void generarReporte(String rutaPlantilla, String rutaReporte, List<Producto> p){
        Reportes.crearReportesProductos(rutaPlantilla, rutaReporte, p);
    }
    
    public boolean login(String usuario, String contraseña) throws SQLException{
        return l.validarLogin(usuario, contraseña);
    }
    
    public List<FacturaClienteDTO> cargarTablaFacturasPorFecha(String fromDate, String toDate) throws SQLException{
        return fr.listaFacturas(fromDate,toDate);
    }
    
}
