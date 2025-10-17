package com.poo.edu.utp.ingenieria.sistemaventas.repositorios;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.poo.edu.utp.ingenieria.sistemaventas.servicios.ConexionBaseDatos;

public class FacturaRepository {
    
    //atributos conexion DB
    private ConexionBaseDatos db;
    
    //Constructor 
    public FacturaRepository(ConexionBaseDatos db) {
        this.db = db;
    }
    
    
    
}
