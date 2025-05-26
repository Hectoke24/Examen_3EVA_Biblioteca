package Biblioteca.vista;

import Biblioteca.controlador.LibroControlador;
import Biblioteca.controlador.LectorControlador;

import java.util.Scanner;

public class BibliotecaVista {
    private Scanner scanner = new Scanner(System.in);
    private LibroControlador libroControlador = new LibroControlador();
    private LectorControlador lectorControlador = new LectorControlador();

    public void mostrarMenuPrincipal() {
        int opcion;

        do {
            System.out.println("\n=== Sistema de Gestión de Biblioteca ===");
            System.out.println("1. Gestionar Libros");
            System.out.println("2. Gestionar Lectores");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = obtenerEntero();

            switch (opcion) {
                case 1 -> libroControlador.menu();
                case 2 -> lectorControlador.menu();
                case 3 -> System.out.println("¡Gracias por usar el sistema! Hasta luego.");
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }

        } while (opcion != 3);
    }

    private int obtenerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Por favor, ingrese un número válido: ");
            }
        }
    }
}
