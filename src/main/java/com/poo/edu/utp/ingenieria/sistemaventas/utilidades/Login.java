package com.poo.edu.utp.ingenieria.sistemaventas.utilidades;

import com.poo.edu.utp.ingenieria.sistemaventas.servicios.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    //atributos conexion DB
    private ConexionBaseDatos db;

    //Constructor 
    public Login(ConexionBaseDatos db) {
        this.db = db;
    }

    public boolean validarLogin(String usuario, String contraseña) throws SQLException {

        String sql = "SELECT Passwordhash FROM Usuarios WHERE Username = ?";

        try (Connection con = db.conexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String ClaveBD = rs.getString("Passwordhash");
                return contraseña.trim().equals(ClaveBD.trim());
            } else {
                return false;
            }
        }
    }
}
