package com.mycompany.proyecto_progra;

import java.util.Scanner;

public class PROYECTO_PROGRA {
    
    static final int MAX_LIBROS = 100; // Limite de libros
    
    static String[] titulos = new String[MAX_LIBROS]; // Títulos de los libros
    static String[] autores = new String[MAX_LIBROS]; // Autores de los libros
    static String[] generos = new String[MAX_LIBROS]; // Géneros de los libros
    static int[] cantidades = new int[MAX_LIBROS]; // Cantidad disponible de cada libro
    
    static int acumLibros = 0; // acumulador de libros
    
    static Scanner captu = new Scanner(System.in); // Scanner 
    
    
    public static void main(String[] args) {

        // Ciclo principal para opciones de la biblioteca
        while (true) {
            mostrarMenu(); // Muestra el menu

            int opcion = captu.nextInt(); // Captura la opción
            captu.nextLine();

            // Ejecuta la opción seleccionada
            switch (opcion) {

                case 1:
                    agregarLibro();
                    break;
                case 2:
                    prestarLibro();
                    break; 
                case 3:
                    devolverLibro();
                    break; 
                case 4:
                    buscarLibro();
                    break; 
                case 5:
                    buscarPorGenero();
                    break; 
                case 6:
                    mostrarInventario();
                    break; 
                case 7:
                    System.out.println("Gracias por usar la BIBLIOTECA COCONUTS. Hasta luego!");
                    System.exit(0); // Salir del programa

                default:
                    System.out.println("Opcion no valida, intente de nuevo.");

            }

        }

    }

    // Muestra el menú de opciones
    public static void mostrarMenu() {

        System.out.println("--- BIBLIOTECA COCONUTS ---");
        System.out.println("1. Agregar libro");
        System.out.println("2. Prestar libro");
        System.out.println("3. Devolver libro");
        System.out.println("4. Buscar libro");
        System.out.println("5. Buscar libros por genero");
        System.out.println("6. Mostrar inventario");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opcion: ");

    }

    // Agrega un nuevo libro a la biblioteca
    public static void agregarLibro() {
        
        String titulo;
        String autor;
        String genero;
        int cantidad;

        if (acumLibros >= MAX_LIBROS) {
            System.out.println("No se pueden agregar más libros, el limite ha sido alcanzado.");
            return; //Salir si se alcanzo el limite
        }

        // Captura los datos del libro
        System.out.print("Ingrese el titulo del libro: ");
        titulo = captu.nextLine();

        System.out.print("Ingrese el autor del libro: ");
        autor = captu.nextLine();
        
        System.out.print("Ingrese el genero del libro: ");
        genero = captu.nextLine();

        System.out.print("Ingrese la cantidad disponible: ");
        cantidad = captu.nextInt();
        captu.nextLine(); 

        // Asigna valores capturados a los arreglos
        titulos[acumLibros] = titulo;

        autores[acumLibros] = autor;

        generos[acumLibros] = genero;

        cantidades[acumLibros] = cantidad;

        acumLibros++; // aumenta acumulador

        System.out.println("Libro agregado: " + titulo); 

    }

    // Presta un libro
    public static void prestarLibro() {
        String titulo;
        
        
        System.out.print("Ingrese el titulo del libro a prestar: ");
        titulo = captu.nextLine(); // Captura el título

        // Busca el libro en el arreglo
        for (int i = 0; i < acumLibros; i++) {
            if (titulos[i].equalsIgnoreCase(titulo) && cantidades[i] > 0) {
                cantidades[i]--; // Decrementa la cantidad
                System.out.println("Libro prestado: " + titulos[i]); 
                return; // Salir del método
            }

        }

        System.out.println("Libro no disponible o no encontrado."); // Mensaje de error

    }

    // Devuelve un libro
    public static void devolverLibro() {
        String titulo;
        
        
        System.out.print("Ingrese el titulo del libro a devolver: ");

        titulo = captu.nextLine(); // Captura el título

        // Busca el libro en el arreglo
        for (int i = 0; i < acumLibros; i++) {
            if (titulos[i].equalsIgnoreCase(titulo)) {
                cantidades[i]++; // Incrementa la cantidad
                System.out.println("Libro devuelto: " + titulos[i]); // Confirmación
                return; // Salir del método
            }

        }

        System.out.println("Libro no encontrado en el sistema."); // Mensaje de error

    }

    // Busca un libro por título o autor
    public static void buscarLibro() {
        String busqueda;
        
        
        System.out.print("Ingrese el titulo o autor a buscar: ");
        busqueda = captu.nextLine().toLowerCase(); // Captura la búsqueda

        boolean encontrado = false; // Boleano para verificar si se encontro el libro

        // Busca en los arreglos de títulos y autores
        for (int i = 0; i < acumLibros; i++) {
            if (titulos[i].toLowerCase().contains(busqueda) || autores[i].toLowerCase().contains(busqueda)) {
                // Muestra los detalles del libro encontrado
                System.out.println("Titulo: " + titulos[i] + ", Autor: " + autores[i] + ", Genero: " + generos[i] + ", Disponibles: " + cantidades[i]);
                encontrado = true; // Marca que se encontro
            }

        }

        if (encontrado == false) {
            System.out.println("No se encontraron libros que coincidan con la búsqueda."); // Mensaje si no se encontro
        }

    }

    // Busca libros por genero
    public static void buscarPorGenero() {
        String generoBuscado;
        

        System.out.print("Ingrese el genero a buscar: ");
        generoBuscado = captu.nextLine().toLowerCase(); // Captura el género y lo convierte a puras minusculas

        boolean encontrado = false; //Boleando para verificar si se encontro el genero

        // Busca en el arreglo de géneros convertidos los dos a minusculas para hacer la comparacion
        for (int i = 0; i < acumLibros; i++) {
            if (generos[i].toLowerCase().equals(generoBuscado)) {
                // Muestra los detalles del libro encontrado
                System.out.println("Titulo: " + titulos[i] + ", Autor: " + autores[i] + ", Genero: " + generos[i] + ", Disponibles: " + cantidades[i]);
                encontrado = true; // Marca que se encontró
            }

        }

        if (encontrado == false) {
            System.out.println("No se encontraron libros en el genero especificado."); // Mensaje si no se encontró
        }

    }

    // Muestra el inventario de la biblioteca
    public static void mostrarInventario() {

        if (acumLibros == 0) {
            System.out.println("La biblioteca está vacía."); // Mensaje si no hay libros
        } else {
            System.out.println("Inventario de la biblioteca:"); 

            // Ciclo for para que vaya imprimiendo cada libro
            for (int i = 0; i < acumLibros; i++) {
                System.out.println("Título: " + titulos[i] + ", Autor: " + autores[i] + ", Género: " + generos[i] + ", Disponibles: " + cantidades[i]);
            }

        }

    }

}