import java.util.*;
public class Usuario {
    private String nombre;
    private String apellidos;
    private String NIF;
    private String contraseña;
    private ArrayList<String> listaReservas = new ArrayList<>();


    public ArrayList<String> getlistaReservas() {return listaReservas;}
    public void setListaReservas(ArrayList<String> listaReservas) {this.listaReservas = listaReservas;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellidos() {return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public String getNIF() {return NIF;}
    public void setNIF(String NIF) {this.NIF = NIF;}
    public String getContraseña() {return contraseña;}
    public void setContraseña(String contraseña) {
        Scanner teclat = new Scanner(System.in);
        if (contraseña.length() > 8){
            this.contraseña = contraseña;}
        else {
            contraseña = teclat.nextLine();
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", NIF='" + NIF + '\'' +
                '}';
    }
    public Usuario(){
        nombre = null;
        apellidos = null;
        NIF = null;
        contraseña = null;
    }

    public Usuario(String nombre, String apellidos, String NIF, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.contraseña = contraseña;
    }

    public Usuario (Usuario objUsuario){
        this.nombre=objUsuario.nombre;
        this.apellidos=objUsuario.apellidos;
        this.NIF=objUsuario.NIF;
        this.contraseña=objUsuario.contraseña;
    }

    public static void añadirUsuario(ArrayList<Usuario> listaUsuarios){
        Scanner teclat = new Scanner(System.in);
        Usuario usuario = new Usuario();
        System.out.println("Se va a añadir un usuario");
        System.out.println("Dime tu nombre");
        usuario.setNombre(teclat.nextLine());
        System.out.println("Dime tus apellidos");
        usuario.setApellidos(teclat.nextLine());
        System.out.println("Dime tu NIF");
        usuario.setNIF(teclat.nextLine());
        System.out.println("Establece tu contraseña");
        usuario.setContraseña(teclat.nextLine());
        listaUsuarios.add(usuario);
    }

    public static void eliminarUsuario(ArrayList<Usuario> listaUsuarios){
        Scanner teclat = new Scanner(System.in);
        System.out.println("Dame el NIF de tu usuario");
        String busqueda = teclat.nextLine();
        boolean trobat = false;
        int i = 0;
        while (trobat == false && i < listaUsuarios.size()) {
            if (listaUsuarios.get(i).getNIF().equals(busqueda)){
                trobat = true;
                System.out.println("¿Quieres eliminar este usuario?");
                System.out.println("Escribe 'S' o 's' para confirmar");
                String confirmacion = teclat.nextLine();
                if (confirmacion == "S" || confirmacion == "s") {
                    listaUsuarios.remove(i);
                    System.out.println("Usuario eliminado");
                }
            }
        }
    }

    public static void reservarLibro(ArrayList<String> listaReservas, ArrayList<Libro> listaLibros) {
        Scanner teclat = new Scanner (System.in);
        System.out.println("¿Qué libro quieres reservar?");
        System.out.println("Estos son los libros disponibles");
        Biblioteca.mostrarLibrosDisponibles(listaLibros);
        System.out.println("Pon el ISBN del libro que quieres reservar");
        String busqueda = teclat.nextLine();
        boolean trobat = false;
        int i = 0;
        while (trobat == false && i<listaLibros.size()) {
            if (listaLibros.get(i).equals(busqueda)) {
                System.out.println("Libro encontrado");
                System.out.println(listaLibros.get(i).toString());
                System.out.println("¿Deseas reservarlo?");
                System.out.println("Escribe 'S' o 's' para confirmar");
                String eleccion5 = teclat.nextLine();
                if (eleccion5 == "S" || eleccion5 == "s") {
                    if (listaReservas.size() < 5) {
                        Biblioteca.getListaLibros().get(i).setNcopiasdisp(-1);
                        String copiarISBN = listaLibros.get(i).getISBN();
                        listaReservas.add(copiarISBN);
                    }
                    else {
                        System.out.println("Tienes demasiadas reservas. Máximo 5.");
                    }
                }
                else {
                    System.out.println("Operación cancelada");
                }
            }

        }

    }

    public static void eliminarReserva(ArrayList<String> listaReservas, ArrayList<Libro> listaLibros) {
        Scanner teclat = new Scanner(System.in);
        System.out.println("¿Qué libro quieres eliminar?");
        for (int i = 0; i < listaReservas.size(); i++) {
            System.out.println(listaReservas.get(i));
        }
        System.out.println("Introduce el ISBN");
        String busqueda = teclat.nextLine();
        boolean trobat = false;
        int i = 0;
        while (trobat == false && i < listaReservas.size()) {
            if (listaReservas.get(i).equals(busqueda)){
                System.out.println("Se va a eliminar el libro");
                System.out.println("¿Estás seguro?");
                System.out.println("Confirma con 'S' o 's'");
                String eleccion6 = teclat.nextLine();
                if (eleccion6 == "S" || eleccion6 == "s") {
                    int posicio = -1;
                    int x = 0;
                    boolean trobat2 = false;
                    while (trobat2 == false && x < listaLibros.size()) {
                        if (listaLibros.get(i).getISBN().equals(busqueda)){
                            trobat = true;
                            posicio = x;
                        }
                        else {
                            x++;
                        }
                    }
                    listaReservas.remove(i);
                    Biblioteca.getListaLibros().get(x).setNcopiasdisp(+1);
                }
            }
            else {
                System.out.println("La búsqueda no ha dado resultados");
            }
        }
    }
}