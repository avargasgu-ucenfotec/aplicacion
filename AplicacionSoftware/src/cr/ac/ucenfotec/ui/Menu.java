package cr.ac.ucenfotec.ui;

import java.util.Scanner;
import cr.ac.ucenfotec.db.*;

public class Menu {

    //Clase "Menu" que despliega un menú en consola que permite registrar y listar las clases definidas.

    //Atributos
    private boolean estaCorriendo;      //Bandera que indica si el menú está corriendo.
    private final Database database;    //Datos asociados al sistema y manipulados a través del menú.

    //Métodos
    //Constructor
    public Menu() {
        estaCorriendo = true;
        database = new Database();
    }

    //Funcionales
    public void correrMenu() {
        while(estaCorriendo) {
            desplegarMenu();
            obtenerOpcion();
        }
    }

    public void desplegarMenu() {
        System.out.println("\nMenú");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Registrar departamento");
        System.out.println("3. Registrar ticket");
        System.out.println("4. Desplegar usuarios registrados");
        System.out.println("5. Desplegar departamentos registrados");
        System.out.println("6. Desplegar tickets registrados");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción del menú: ");
    }

    public void obtenerOpcion() {
        Scanner scanner = new Scanner(System.in);
        String seleccion = scanner.nextLine();
        switch (seleccion) {
            case "1":
                System.out.println("\nRegistrando usuario");
                System.out.print("Ingrese el nombre del usuario: ");
                String nombreUsuario = scanner.nextLine();
                System.out.print("Ingrese el correo electrónico del usuario: ");
                String correoUsuario = scanner.nextLine();
                System.out.print("Ingrese la contraseña del usuario: ");
                String contrasenaUsuario = scanner.nextLine();
                System.out.print("Ingrese el teléfono del usuario: ");
                String telefonoUsuario = scanner.nextLine();
                System.out.print("Ingrese el tipo del usuario: ");
                String tipoUsuario = scanner.nextLine();
                database.registrarUsuario(nombreUsuario, correoUsuario, contrasenaUsuario, telefonoUsuario, tipoUsuario);
                break;
            case "2":
                System.out.println("\nRegistrando departamento");
                System.out.print("Ingrese el nombre del departamento: ");
                String nombreDepartamento = scanner.nextLine();
                System.out.print("Ingrese la descripción del departamento: ");
                String descripcionDepartamento = scanner.nextLine();
                System.out.print("Ingrese el correo electrónico del departamento: ");
                String correoDepartamento = scanner.nextLine();
                System.out.print("Ingrese la extensión del departamento: ");
                String extensionDepartamento = scanner.nextLine();
                database.registrarDepartamento(nombreDepartamento, descripcionDepartamento, correoDepartamento, extensionDepartamento);
                break;
            case "3":
                System.out.println("\nRegistrando ticket");
                System.out.print("Ingrese el asunto del ticket: ");
                String asuntoTicket = scanner.nextLine();
                System.out.print("Ingrese la descripción del ticket: ");
                String descripcionTicket = scanner.nextLine();
                database.registrarTicket(asuntoTicket, descripcionTicket);
                break;
            case "4":
                System.out.println("\nDesplegando usuarios registrados");
                database.imprimirListaUsuarios();
                break;
            case "5":
                System.out.println("\nDesplegando departamentos registrados");
                database.imprimirListaDepartamentos();
                break;
            case "6":
                System.out.println("\nDesplegando tickets registrados");
                database.imprimirListaTickets();
                break;
            case "7":
                System.out.println("\nCerrando el programa...");
                estaCorriendo = false;
                break;
            default:
                System.out.println("\nOpción inválida, por favor intente de nuevo.");
        }
    }
}
