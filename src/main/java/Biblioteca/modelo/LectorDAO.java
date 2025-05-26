package Biblioteca.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LectorDAO {

    public void agregar(Lector lector) {
        String sql = "INSERT INTO lectores (nombre, email) VALUES (?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, lector.getNombre());
            stmt.setString(2, lector.getEmail());

            stmt.executeUpdate();
            System.out.println("Lector agregado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar lector: " + e.getMessage());
        }
    }

    public List<Lector> listar() {
        List<Lector> lectores = new ArrayList<>();
        String sql = "SELECT * FROM lectores";

        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Lista de Lectores:");
            while (rs.next()) {
                Lector lector = new Lector(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email")
                );
                lectores.add(lector);

                System.out.println(lector.getId() + " | " + lector.getNombre() + " | " + lector.getEmail());
            }

        } catch (SQLException e) {
            System.out.println("Error al listar lectores: " + e.getMessage());
        }

        return lectores;
    }

    public void actualizar(Lector lector) {
        String sql = "UPDATE lectores SET nombre = ?, email = ? WHERE id = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, lector.getNombre());
            stmt.setString(2, lector.getEmail());
            stmt.setInt(3, lector.getId());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Lector actualizado.");
            } else {
                System.out.println("No se encontró un lector con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar lector: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM lectores WHERE id = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Lector eliminado.");
            } else {
                System.out.println("No se encontró un lector con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar lector: " + e.getMessage());
        }
    }
}
