import java.util.*;
public class Personal {
    private String nombre;
    private String apellidos;
    private String NIF;
    private String contraseña;

    public Personal(String nombre, String apellidos, String NIF, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.contraseña = contraseña;
    }

    public Personal() {
        nombre = null;
        apellidos = null;
        NIF = null;
        contraseña = null;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellidos() {return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public String getNIF() {return NIF;}
    public void setNIF(String NIF) {this.NIF = NIF;}
    public String getContraseña() {return contraseña;}
    public void setContraseña(String contraseña) {this.contraseña = contraseña;}

    public static void añadirPersonal(ArrayList<Personal> listaPersonal){
        Scanner teclat = new Scanner(System.in);
        Personal personal = new Personal();
        System.out.println("Se va a añadir un admin");
        System.out.println("Dime tu nombre");
        personal.setNombre(teclat.nextLine());
        System.out.println("Dime tus apellidos");
        personal.setApellidos(teclat.nextLine());
        System.out.println("Dime tu NIF");
        personal.setNIF(teclat.nextLine());
        System.out.println("Establece tu contraseña");
        personal.setContraseña(teclat.nextLine());
        listaPersonal.add(personal);
    }

    public static void eliminarUsuario(ArrayList<Personal> listaPersonal){
        Scanner teclat = new Scanner(System.in);
        System.out.println("Dame el NIF de tu usuario administrador");
        String busqueda = teclat.nextLine();
        boolean trobat = false;
        int i = 0;
        while (trobat == false && i < listaPersonal.size()) {
            if (listaPersonal.get(i).getNIF().equals(busqueda)){
                trobat = true;
                System.out.println("¿Quieres eliminar este usuario?");
                System.out.println("Escribe 'S' o 's' para confirmar");
                String confirmacion = teclat.nextLine();
                if (confirmacion == "S" || confirmacion == "s") {
                    listaPersonal.remove(i);
                    System.out.println("Usuario eliminado");
                }
            }
        }
    }
}

