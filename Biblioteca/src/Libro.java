import java.util.*;
public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int ncopias;
    private int ncopiasdisp;

    public String getISBN() {return ISBN;}
    public void setISBN(String ISBN) {this.ISBN = ISBN;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getAutor() {return autor;}
    public void setAutor(String autor) {this.autor = autor;}
    public String getEditorial() {return editorial;}
    public void setEditorial(String editorial) {this.editorial = editorial;}
    public int getNcopias() {return ncopias;}
    public void setNcopias(int ncopias) {this.ncopias = ncopias;}
    public int getNcopiasdisp() {return ncopiasdisp;}
    public void setNcopiasdisp(int ncopiasdisp) {this.ncopiasdisp = ncopiasdisp;}

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", ncopias=" + ncopias +
                ", ncopiasdisp=" + ncopiasdisp +
                '}';
    }

    public Libro() {
        ISBN = null;
        titulo = null;
        autor = null;
        editorial = null;
        ncopias = 0;
        ncopiasdisp = 0;
    }

    public Libro(String ISBN, String titulo, String autor, String editorial, int ncopias, int ncopiasdisp) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.ncopias = ncopias;
        this.ncopiasdisp = ncopiasdisp;
    }

    public static void añadirLibro(ArrayList<Libro> listaLibros) {
        Scanner teclat = new Scanner (System.in);
        Libro libro = new Libro();
        System.out.println("Has seleccionado 'Añadir libro' ");
        System.out.println("¿Qué ISBN tiene?");
        libro.setISBN(teclat.nextLine());
        System.out.println("¿Cual es el título?");
        libro.setTitulo(teclat.nextLine());
        System.out.println("¿Quién es el autor?");
        libro.setAutor(teclat.nextLine());
        System.out.println("¿Cual es la editorial?");
        libro.setEditorial(teclat.nextLine());
        System.out.println("¿Cuántas copias dispone la biblioteca?");
        libro.setNcopias(teclat.nextInt());
        System.out.println("¿Cuántas copias hay disponibles?");
        libro.setNcopiasdisp(teclat.nextInt());
        listaLibros.add(libro);
    }

    public static void eliminarLibro (ArrayList<Libro> listaLibros) {
        Scanner teclat = new Scanner (System.in);
        System.out.println("Dame el ISBN del libro que quieras eliminar");
        String busqueda = teclat.nextLine();
        boolean trobat = false;
        int i = 0;
        while (trobat == false && i < listaLibros.size()) {
            if (listaLibros.get(i).getISBN().equals(busqueda)){
                trobat = true;
                if (listaLibros.get(i).getNcopiasdisp() < listaLibros.get(i).getNcopias()) {
                    System.out.println("No puedes eliminar este libro porque tiene reservas");
                }
                else {
                    System.out.println("Vas a eliminar el libro: "+listaLibros.get(i).getTitulo());
                    System.out.println("¿Estás seguro?");
                    System.out.println("Confirma con S o s");
                    System.out.println("Si escribes otra cosa se cancelará la operación");
                    String confirmacion = teclat.nextLine();
                    if (confirmacion =="S" || confirmacion == "s") {
                        listaLibros.remove(i);
                    }
                    else {
                        System.out.println("No se ha eliminado el libro");
                    }
                }
            }
            else {
                i++;
            }
        }
    }

    public static int buscarISBN(ArrayList<Libro> listaLibros) {
        Scanner teclat = new Scanner (System.in);
        String busqueda;
        System.out.println("Dame el ISBN");
        busqueda = teclat.nextLine();
        int posicio = -1;
        int i = 0;
        boolean trobat = false;
        while (trobat == false && i < listaLibros.size()) {
            if (listaLibros.get(i).getISBN().equals(busqueda)){
                trobat = true;
                posicio = i;
            }
            else {
                i++;
            }
        }
        return posicio;
    }

    public static void buscarTitulo(ArrayList<Libro> listaLibros){
        Scanner teclat = new Scanner (System.in);
        String busqueda;
        System.out.println("Dame la palabra que quieras buscar");
        busqueda = teclat.nextLine();
        int posicio = -1;
        int i = 0;
        boolean trobat = false;
        while (trobat == false && i < listaLibros.size()) {
            if (listaLibros.get(i).getISBN().contains(busqueda)){
                trobat = true;
                posicio = i;
                System.out.println(listaLibros.get(i).toString());
            }
            i++;
        }
    }
}
