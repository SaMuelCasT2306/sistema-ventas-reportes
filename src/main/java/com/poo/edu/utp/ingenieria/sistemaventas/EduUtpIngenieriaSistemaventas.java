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

    }
}
