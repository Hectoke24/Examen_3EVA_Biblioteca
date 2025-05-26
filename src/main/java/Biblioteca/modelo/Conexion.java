package Biblioteca.modelo;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root"; // Cambiar si es necesario
    private static final String PASSWORD = ""; // Cambiar si es necesario

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
