import java.util.*;
public class Main {
    public static void main (String [] Args) {
        Scanner teclat = new Scanner (System.in);
        boolean confirmacion = false;
        while (confirmacion == false){
        System.out.println("Menú de inicio");
        System.out.println("1.- Gestión de libros");
        System.out.println("2.- Gestión de usuarios");
        System.out.println("3.- Gestión de personal");
        System.out.println("4.- Gestión de reservas");
        System.out.println("5.- Salir");
        int eleccion = teclat.nextInt();
            switch(eleccion) {
                case 1:
                    System.out.println("Gestión de libros");
                    System.out.println("1.- Añadir libro");
                    System.out.println("2.- Eliminar libro");
                    System.out.println("3.- Mostrar libros");
                    System.out.println("4.- Mostrar libros disponibles");
                    System.out.println("5.- Buscar libro por ISBN");
                    System.out.println("6.- Buscar libro por título");
                    System.out.println("7.- Salir");
                    int eleccion2 = teclat.nextInt();
                    switch (eleccion2) {
                        case 1:
                            Libro.añadirLibro(Biblioteca.getListaLibros());
                            break;
                        case 2:
                            Libro.eliminarLibro(Biblioteca.getListaLibros());
                            break;
                        case 3:
                            Biblioteca.mostrarLibros(Biblioteca.getListaLibros());
                            break;
                        case 4:
                            Biblioteca.mostrarLibrosDisponibles(Biblioteca.getListaLibros());
                            break;
                        case 5:
                            Libro.buscarISBN(Biblioteca.getListaLibros());
                            break;
                        case 6:
                            Libro.buscarTitulo(Biblioteca.getListaLibros());
                            break;
                        case 7:
                            System.out.println("Adiós");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Gestión de usuarios");
                    System.out.println("1.- Añadir usuario");
                    System.out.println("2.- Eliminar usuario");
                    System.out.println("3.- Mostrar usuarios");
                    System.out.println("4.- Salir");
                    int eleccion3 = teclat.nextInt();
                    switch (eleccion3) {
                        case 1:
                            Usuario.añadirUsuario(Biblioteca.getListaUsuarios());
                            break;
                        case 2:
                            Usuario.eliminarUsuario(Biblioteca.getListaUsuarios());
                            break;
                        case 3:
                            System.out.println("WIP");
                            break;
                        case 4:
                            System.out.println("Adiós");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Gestión de administradores");
                    System.out.println("1.- Añadir admin");
                    System.out.println("2.- Eliminar admin");
                    System.out.println("3.- Mostrar admins");
                    System.out.println("4.- Salir");
                    int eleccion4 = teclat.nextInt();
                    switch (eleccion4) {
                        case 1:
                            Personal.añadirPersonal(Biblioteca.getListaPersonal());
                            break;
                        case 2:
                            Personal.eliminarUsuario(Biblioteca.getListaPersonal());
                            break;
                        case 3:
                            System.out.println("WIP");
                            break;
                        case 4:
                            System.out.println("Adiós");
                            break;
                        }
                        break;
                case 4:
                    System.out.println("Gestión de reservas");
                    System.out.println("1.- Hacer reserva");
                    System.out.println("2.- Eliminar reserva");
                    System.out.println("3.- Salir");
                    int eleccion5 = teclat.nextInt();
                    switch (eleccion5) {
                        case 1:
                            Usuario.reservarLibro(Usuario.getlistaReservas(), Biblioteca.getListaLibros());
                            break;
                        case 2:
                            Usuario.eliminarReserva(Usuario.getlistaReservas(), Biblioteca.getListaLibros());
                            break;
                        case 3:
                            System.out.println("Adiós");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Adiós");
                    confirmacion = true;
                }
            }
        }
    }


