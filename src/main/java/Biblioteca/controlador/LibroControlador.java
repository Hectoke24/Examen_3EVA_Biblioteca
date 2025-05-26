package Biblioteca.controlador;

import Biblioteca.modelo.Libro;
import Biblioteca.modelo.LibroDAO;

import java.util.Scanner;

public class LibroControlador {
    private LibroDAO libroDAO = new LibroDAO();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcion;

        do {
            System.out.println("\n--- Gestión de Libros ---");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Listar Libros");
            System.out.println("3. Editar Libro");
            System.out.println("4. Eliminar Libro");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            opcion = obtenerEntero();

            switch (opcion) {
                case 1 -> agregarLibro();
                case 2 -> libroDAO.listar();
                case 3 -> editarLibro();
                case 4 -> eliminarLibro();
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 5);
    }

    private void agregarLibro() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Año de publicación: ");
        int anio = obtenerEntero();

        Libro libro = new Libro(0, titulo, autor, anio);
        libroDAO.agregar(libro);
    }

    private void editarLibro() {
        System.out.print("ID del libro a editar: ");
        int id = obtenerEntero();

        System.out.print("Nuevo título: ");
        String titulo = scanner.nextLine();

        System.out.print("Nuevo autor: ");
        String autor = scanner.nextLine();

        System.out.print("Nuevo año de publicación: ");
        int anio = obtenerEntero();

        Libro libro = new Libro(id, titulo, autor, anio);
        libroDAO.actualizar(libro);
    }

    private void eliminarLibro() {
        System.out.print("ID del libro a eliminar: ");
        int id = obtenerEntero();

        libroDAO.eliminar(id);
    }

    private int obtenerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número válido: ");
            }
        }
    }
}
