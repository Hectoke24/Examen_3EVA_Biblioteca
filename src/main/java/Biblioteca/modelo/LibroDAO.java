package Biblioteca.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public void agregar(Libro libro) {
        String sql = "INSERT INTO libros (titulo, autor, anio_publicacion) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getAnioPublicacion());

            stmt.executeUpdate();
            System.out.println("✅ Libro agregado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar libro: " + e.getMessage());
        }
    }

    public List<Libro> listar() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros";

        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("📚 Lista de Libros:");
            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("anio_publicacion")
                );
                libros.add(libro);

                System.out.println(libro.getId() + " | " + libro.getTitulo() + " | " + libro.getAutor() + " | " + libro.getAnioPublicacion());
            }

        } catch (SQLException e) {
            System.out.println("Error al listar libros: " + e.getMessage());
        }

        return libros;
    }

    public void actualizar(Libro libro) {
        String sql = "UPDATE libros SET titulo = ?, autor = ?, anio_publicacion = ? WHERE id = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getAnioPublicacion());
            stmt.setInt(4, libro.getId());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Libro actualizado.");
            } else {
                System.out.println("No se encontró un libro con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar libro: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM libros WHERE id = ?";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Libro eliminado.");
            } else {
                System.out.println("No se encontró un libro con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar libro: " + e.getMessage());
        }
    }
}
