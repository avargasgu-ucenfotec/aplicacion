import java.util.ArrayList;

public class Database {

    //Clase "Database" que representa una base de datos que almacena los usuarios, departamentos y tickets.

    //Atributo
    private final ArrayList<Usuario> datosUsuario;            //Lista con los datos de los usuarios registrados.
    private final ArrayList<Departamento> datosDepartamento;  //Lista con los datos de los departamentos registrados.
    private final ArrayList<Ticket> datosTicket;              //Lista con los datos de los tickets registrados.

    //Métodos
    //Constructor
    public Database(){
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
        insertarUsuario(usuario);
    }

    public void registrarDepartamento(String nombre, String descripcion, String correo, String extension) {
        Departamento departamento = new Departamento(nombre, descripcion, correo, extension);
        insertarDepartamento(departamento);
    }

    public void registrarTicket(String asunto, String descripcion, String estado, String usuario, String departamento) {
        Ticket ticket = new Ticket(asunto, descripcion, estado, usuario, departamento);
        insertarTicket(ticket);
    }

    public void imprimirListaUsuarios() {
        if(!datosUsuario.isEmpty()) {
            for (Object o : datosUsuario) {
                System.out.println(o);
            }
        }else{
            System.out.println("No hay usuarios registrados.");
        }
    }

    public void imprimirListaDepartamentos() {
        if(!datosDepartamento.isEmpty()) {
            for (Object o : datosDepartamento) {
                System.out.println(o);
            }
        }else{
            System.out.println("No hay departamentos registrados.");
        }
    }

    public void imprimirListaTickets() {
        if(!datosTicket.isEmpty()) {
            for (Object o : datosTicket) {
                System.out.println(o);
            }
        }else{
            System.out.println("No hay tickets registrados.");
        }
    }
}
