package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexionbd {

    static public String url = "jdbc:mysql://localhost:3306/bd_anuncios";
    static public String usuario = "root";
    static public String contra = "";
    static public String driver = "com.mysql.jdbc.Driver";

    protected Connection conn = null;

    public conexionbd() {

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, contra);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el Driver " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error en la conexion " + ex.getMessage());
        }

    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error en cerrar la base de datos " + ex.getMessage());
        }
    }

}
