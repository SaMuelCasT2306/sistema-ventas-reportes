package com.poo.edu.utp.ingenieria.sistemaventas;

import com.poo.edu.utp.ingenieria.sistemaventas.dto.ClienteProductoDTO;
import com.poo.edu.utp.ingenieria.sistemaventas.dto.FacturaProductoDTO;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Cliente;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Producto;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.ClienteRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.FacturaRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.ProductoRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.servicios.ConexionBaseDatos;
import com.poo.edu.utp.ingenieria.sistemaventas.ui.PantallaLogin;
import com.poo.edu.utp.ingenieria.sistemaventas.ui.PantallaPrincipal;
import com.poo.edu.utp.ingenieria.sistemaventas.utilidades.Reportes;
import com.poo.edu.utp.ingenieria.sistemaventas.utilidades.Configuracion;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EduUtpIngenieriaSistemaventas {

    // Repositorios globales
    private static ConexionBaseDatos con;
    private static ClienteRepository cr;
    private static ProductoRepository pr;
    private static FacturaRepository fr;
    private static Scanner scanner;

    public static void main(String[] args) {

        PantallaLogin mp = new PantallaLogin();
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
        mp.setResizable(false);


         /*
        inicializarConexiones();


        scanner = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();

            try {
                switch (opcion) {
                    case 1:
                        listarClientes();
                        break;
                    case 2:
                        listarProductos();
                        break;
                    case 3:
                        generarReporteProductos();
                        break;
                    case 4:
                        buscarFacturasPorProducto();
                        break;
                    case 5:
                        buscarClientesPorProducto();
                        break;
                    case 6:
                        agregarCliente();
                        break;
                    case 0:
                        salir = true;
                        System.out.println("\n¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("\nOpción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                manejarError(e);
            }
        }

        scanner.close();
    }

    private static void inicializarConexiones() {
        con = new ConexionBaseDatos(Configuracion.DB_URL, Configuracion.DB_USUARIO, Configuracion.DB_PASSWORD);
        cr = new ClienteRepository(con);
        pr = new ProductoRepository(con);
        fr = new FacturaRepository(con);
    }

    private static void mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("    SISTEMA DE GESTIÓN DE VENTAS");
        System.out.println("========================================");
        System.out.println("1. Listar Clientes");
        System.out.println("2. Listar Productos");
        System.out.println("3. Generar Reporte de Productos (Excel)");
        System.out.println("4. Listar Facturas por Producto");
        System.out.println("5. Listar Clientes por Producto");
        System.out.println("6. Agregar Cliente");
        System.out.println("0. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void listarClientes() throws SQLException {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        List<Cliente> listaClientes = cr.listarClientes();
        cr.imprimirListaClientes(listaClientes);
        pausar();
    }

    private static void listarProductos() throws SQLException {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        List<Producto> listaProductos = pr.listarProductos();
        pr.imprimirListaProductos(listaProductos);
        pausar();
    }

    private static void generarReporteProductos() throws SQLException {
        System.out.println("\n--- GENERAR REPORTE DE PRODUCTOS ---");

        List<Producto> listaProductos = pr.listarProductos();

        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos para generar el reporte.");
            pausar();
            return;
        }

        // Obtener rutas usando la configuración centralizada
        String rutaPlantilla = Configuracion.obtenerRutaPlantilla(Configuracion.PLANTILLA_PRODUCTOS);
        String rutaSalida = Configuracion.obtenerRutaSalidaReporte("reporte_productos", ".xlsx");

        System.out.println("Generando reporte...");
        Reportes.crearReportesProductos(rutaPlantilla, rutaSalida, listaProductos);
        System.out.println("Reporte generado exitosamente");
        System.out.println("Ubicación en la ruta: " + rutaSalida);
        pausar();
    }

    private static void buscarFacturasPorProducto() throws SQLException {
        System.out.println("\n--- BUSCAR FACTURAS POR PRODUCTO ---");
        System.out.print("Ingrese el código del producto: ");
        String codigoProducto = scanner.nextLine();

        List<FacturaProductoDTO> listaFacturas = fr.listaFacturasPorNombreProducto(codigoProducto);

        if (listaFacturas.isEmpty()) {
            System.out.println("No se encontraron facturas para el producto: " + codigoProducto);
        } else {
            fr.ImprimirFacturasPorNombreProducto(listaFacturas);
        }
        pausar();
    }

    private static void buscarClientesPorProducto() throws SQLException {
        System.out.println("\n--- BUSCAR CLIENTES POR PRODUCTO ---");
        System.out.print("Ingrese el código del producto: ");
        String codigoProducto = scanner.nextLine();

        List<ClienteProductoDTO> listaClientes = cr.listarClientesPorProducto(codigoProducto);

        if (listaClientes.isEmpty()) {
            System.out.println("No se encontraron clientes para este producto");
        } else {
            cr.imprimirListaClientesPorProductos(listaClientes);
        }
        pausar();
    }

    private static void agregarCliente() throws SQLException {
        System.out.println("\n--- AGREGAR NUEVO CLIENTE ---");

        System.out.print("RUC: ");
        long ruc = Long.parseLong(scanner.nextLine());

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(0, ruc, nombre, direccion);
        cr.insertarCliente(nuevoCliente);

        System.out.println("Cliente agregado exitosamente con ID: " + nuevoCliente.getId());
        pausar();
    }

    private static void pausar() {
        System.out.print("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }

    private static void manejarError(Exception e) {
        System.err.println("Error,");
        if (e.getStackTrace().length > 0) {
            StackTraceElement ste = e.getStackTrace()[0];
            System.err.println("Clase: " + ste.getClassName());
            System.err.println("Método: " + ste.getMethodName());
            System.err.println("Línea: " + ste.getLineNumber());
        }

        System.err.println("Detalle: " + e.getMessage());
        pausar();


         */
    }
}
