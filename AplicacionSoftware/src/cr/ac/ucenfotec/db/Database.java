package cr.ac.ucenfotec.db;

import java.util.ArrayList;
import cr.ac.ucenfotec.bl.*;

public class Database {

    //Clase "Database" que representa una base de datos que almacena los usuarios, departamentos y tickets.

    //Atributo
    private final ArrayList<Usuario> datosUsuario;            //Lista con los datos de los usuarios registrados.
    private final ArrayList<Departamento> datosDepartamento;  //Lista con los datos de los departamentos registrados.
    private final ArrayList<Ticket> datosTicket;              //Lista con los datos de los tickets registrados.

    //Métodos
    //Constructor
    public Database() {
        datosUsuario = new ArrayList<>();
        datosDepartamento = new ArrayList<>();
        datosTicket = new ArrayList<>();
    }

    //Funcionales
    public void insertarUsuario(Usuario usuario) {
        datosUsuario.add(usuario);
    }

    public void insertarDepartamento(Departamento departamento) {
        datosDepartamento.add(departamento);
    }

    public void insertarTicket(Ticket ticket) {
        datosTicket.add(ticket);
    }

    public void registrarUsuario(String nombre, String correo, String contrasena, String telefono, String tipo) {
        Usuario usuario = new Usuario(nombre, correo, contrasena, telefono, tipo);
        if (estaRepetidoUsuario(usuario)) {
            System.out.println("""
                            
                            Registro no completado.\
                            
                            El correo electrónico ingresado ya se encuentra registrado.\
                            
                            Intente de nuevo con un correo electrónico distinto.""");
        } else {
            insertarUsuario(usuario);
            System.out.println("Registro completado.");
        }
    }

    public void registrarDepartamento(String nombre, String descripcion, String correo, String extension) {
        Departamento departamento = new Departamento(nombre, descripcion, correo, extension);
        if (estaRepetidoDepartamento(departamento)) {
            System.out.println("""
                            
                            Registro no completado.\
                            
                            El departamento ingresado ya se encuentra registrado.\
                            
                            Intente de nuevo con un nombre de departamento distinto.""");
        } else {
            insertarDepartamento(departamento);
            System.out.println("Registro completado.");
        }
    }

    public void registrarTicket(String asunto, String descripcion) {
        Ticket ticket = new Ticket(asunto, descripcion);
        insertarTicket(ticket);
    }

    public void imprimirListaUsuarios() {
        if (datosUsuario.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario u : datosUsuario) {
                System.out.println(u);
            }
        }
    }

    public void imprimirListaDepartamentos() {
        if (datosDepartamento.isEmpty()) {
            System.out.println("No hay departamentos registrados.");
        } else {
            for (Departamento d : datosDepartamento) {
                System.out.println(d);
            }
        }
    }

    public void imprimirListaTickets() {
        if (datosTicket.isEmpty()) {
            System.out.println("No hay tickets registrados.");
        } else {
            for (Object o : datosTicket) {
                System.out.println(o);
            }
        }
    }

    public boolean estaRepetidoUsuario(Usuario usuario) {
        if (!datosUsuario.isEmpty()) {
            for (Usuario u : datosUsuario) {
                if (u.equals(usuario)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean estaRepetidoDepartamento(Departamento departamento) {
        if (!datosDepartamento.isEmpty()) {
            for (Departamento d : datosDepartamento) {
                if (d.equals(departamento)) {
                    return true;
                }
            }
        }
        return false;
    }
}