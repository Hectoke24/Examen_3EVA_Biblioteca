package Biblioteca.controlador;

import Biblioteca.modelo.Lector;
import Biblioteca.modelo.LectorDAO;

import java.util.Scanner;

public class LectorControlador {
    private LectorDAO lectorDAO = new LectorDAO();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcion;

        do {
            System.out.println("\n--- Gestión de Lectores ---");
            System.out.println("1. Agregar Lector");
            System.out.println("2. Listar Lectores");
            System.out.println("3. Editar Lector");
            System.out.println("4. Eliminar Lector");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            opcion = obtenerEntero();

            switch (opcion) {
                case 1 -> agregarLector();
                case 2 -> lectorDAO.listar();
                case 3 -> editarLector();
                case 4 -> eliminarLector();
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 5);
    }

    private void agregarLector() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Lector lector = new Lector(0, nombre, email);
        lectorDAO.agregar(lector);
    }

    private void editarLector() {
        System.out.print("ID del lector a editar: ");
        int id = obtenerEntero();

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo email: ");
        String email = scanner.nextLine();

        Lector lector = new Lector(id, nombre, email);
        lectorDAO.actualizar(lector);
    }

    private void eliminarLector() {
        System.out.print("ID del lector a eliminar: ");
        int id = obtenerEntero();

        lectorDAO.eliminar(id);
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
