package Biblioteca.gestor;

import Biblioteca.controlador.LibroControlador;
import Biblioteca.controlador.LectorControlador;
import Biblioteca.consola.BibliotecaConsola;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de controladores
        LibroControlador libroControlador = new LibroControlador();
        LectorControlador lectorControlador = new LectorControlador();

        // Mostrar info en consola sobre los controladores creados
        System.out.println("Controlador de Libros creado: " + libroControlador);
        System.out.println("Controlador de Lectores creado: " + lectorControlador);

        // Crear la vista pasándole las instancias de los controladores
        BibliotecaConsola vista = new BibliotecaConsola(libroControlador, lectorControlador);

        // Mostrar info de la vista creada
        System.out.println("Vista BibliotecaConsola creada: " + vista);

        // Ejecutar el menú principal (consola interactiva)
        vista.mostrarMenuPrincipal();
    }
}
