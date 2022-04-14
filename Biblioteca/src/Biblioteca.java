import java.util.*;
public class Biblioteca {
    private String nombre;
    private static ArrayList <Libro> listaLibros = new ArrayList<>();
    private static ArrayList <Personal> listaPersonal = new ArrayList<>();
    private static ArrayList <Usuario> listaUsuarios = new ArrayList<>();

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public static ArrayList<Libro> getListaLibros() {return listaLibros;}
    public static ArrayList<Usuario> getListaUsuarios() {return listaUsuarios;}
    public static void setListaLibros(ArrayList<Libro> listaLibros) {Biblioteca.listaLibros = listaLibros;}
    public static ArrayList<Personal> getListaPersonal() {return listaPersonal;}
    public void setListaPersonal(ArrayList<Personal> listaPersonal) {this.listaPersonal = listaPersonal;}


    public Biblioteca() {nombre = null;}

    public Biblioteca(String nombre, ArrayList<Libro> listaLibros, ArrayList<Personal> listaPersonal) {
        this.nombre = nombre;
        this.listaLibros = listaLibros;
        this.listaPersonal = listaPersonal;
    }

    public static void mostrarLibros(ArrayList<Libro> listaLibros) {
        System.out.println("Se va a mostrar la lista de libros");
        for (int i = 0; i < listaLibros.size(); i++){
            System.out.println(listaLibros.get(i).toString());
        }
    }

    public static void mostrarLibrosDisponibles(ArrayList<Libro> listaLibros) {
        System.out.println("Se va a mostrar la lista de libros disponibles");
        for (int i = 0; i < listaLibros.size(); i++){
            if (listaLibros.get(i).getNcopiasdisp() > 0) {
                System.out.println(listaLibros.get(i).toString());
            }
        }
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", listaLibros=" + listaLibros +
                ", listaPersonal=" + listaPersonal +
                '}';
    }
}
