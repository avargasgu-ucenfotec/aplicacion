package cr.ac.ucenfotec.ui;

import java.util.Scanner;
import cr.ac.ucenfotec.db.*;

/**
 * Controla la interacción del usuario con el sistema mediante un menú en consola.
 * Desde aquí se registran usuarios, departamentos, tickets y se gestionan los
 * diccionarios técnico/emocional, además de ejecutar el análisis Bag of Words.
 */
public class Menu {

    private boolean estaCorriendo;    // Mantiene el ciclo principal activo
    private final Database database;  // Acceso centralizado a los datos del sistema

    /**
     * Inicializa el menú y la base de datos en memoria.
     */
    public Menu() {
        estaCorriendo = true;
        database = new Database();
    }

    /**
     * Bucle principal del sistema: muestra el menú y procesa opciones
     * hasta que el usuario seleccione salir.
     */
    public void correrMenu() {
        while (estaCorriendo) {
            desplegarMenu();
            obtenerOpcion();
        }
    }

    /** Muestra las opciones principales del sistema. */
    public void desplegarMenu() {
        System.out.println("\nMenú");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Registrar departamento");
        System.out.println("3. Registrar ticket");
        System.out.println("4. Desplegar usuarios registrados");
        System.out.println("5. Desplegar departamentos registrados");
        System.out.println("6. Desplegar tickets registrados");
        System.out.println("7. Salir");
        System.out.println("8. Diccionario técnico");
        System.out.println("9. Diccionario emocional");
        System.out.println("10. Analizar ticket (Bag of Words)");
        System.out.print("Seleccione una opción del menú: ");
    }

    /**
     * Procesa la opción seleccionada y redirige según la acción requerida.
     * Incluye validaciones de entrada y llamadas a la capa Database.
     */
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
                System.out.print("Ingrese el correo del usuario que crea el ticket: ");
                String correoUsuarioTicket = scanner.nextLine();
                System.out.print("Ingrese el nombre del departamento asociado: ");
                String nombreDepartamentoTicket = scanner.nextLine();
                database.registrarTicket(asuntoTicket, descripcionTicket, correoUsuarioTicket, nombreDepartamentoTicket);
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

            case "8":
                submenuDiccionarioTecnico();
                break;

            case "9":
                submenuDiccionarioEmocional();
                break;

            case "10":
                System.out.println("\nAnálisis de ticket (Bag of Words)");
                database.listarTicketsConIndice();
                System.out.print("Ingrese el número del ticket que desea analizar: ");
                String indiceStr = scanner.nextLine();
                try {
                    int indice = Integer.parseInt(indiceStr);
                    database.analizarTicketPorIndice(indice);
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido. Debe ingresar un número entero.");
                }
                break;

            default:
                System.out.println("\nOpción inválida, por favor intente de nuevo.");
        }
    }

    /**
     * Submenú para administrar el diccionario técnico: agregar, editar,
     * eliminar y listar palabras clasificadas por categoría técnica.
     */
    private void submenuDiccionarioTecnico() {
        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        while (!opcion.equals("5")) {
            System.out.println("\nDiccionario Técnico");
            System.out.println("1. Agregar palabra");
            System.out.println("2. Editar palabra");
            System.out.println("3. Eliminar palabra");
            System.out.println("4. Listar palabras");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese la palabra técnica: ");
                    String palabra = scanner.nextLine();
                    System.out.print("Ingrese la categoría técnica: ");
                    String categoria = scanner.nextLine();
                    database.agregarPalabraTecnica(palabra, categoria);
                    break;

                case "2":
                    System.out.print("Ingrese la palabra actual: ");
                    String palabraActual = scanner.nextLine();
                    System.out.print("Ingrese la nueva palabra: ");
                    String nuevaPalabra = scanner.nextLine();
                    System.out.print("Ingrese la nueva categoría: ");
                    String nuevaCategoria = scanner.nextLine();
                    database.editarPalabraTecnica(palabraActual, nuevaPalabra, nuevaCategoria);
                    break;

                case "3":
                    System.out.print("Ingrese la palabra a eliminar: ");
                    String palabraEliminar = scanner.nextLine();
                    database.eliminarPalabraTecnica(palabraEliminar);
                    break;

                case "4":
                    database.listarDiccionarioTecnico();
                    break;

                case "5":
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    /**
     * Submenú para administrar el diccionario emocional: agregar, editar,
     * eliminar y listar palabras asociadas a emociones.
     */
    private void submenuDiccionarioEmocional() {
        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        while (!opcion.equals("5")) {
            System.out.println("\nDiccionario Emocional");
            System.out.println("1. Agregar palabra");
            System.out.println("2. Editar palabra");
            System.out.println("3. Eliminar palabra");
            System.out.println("4. Listar palabras");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese la palabra emocional: ");
                    String palabra = scanner.nextLine();
                    System.out.print("Ingrese la emoción asociada: ");
                    String emocion = scanner.nextLine();
                    database.agregarPalabraEmocional(palabra, emocion);
                    break;

                case "2":
                    System.out.print("Ingrese la palabra actual: ");
                    String palabraActual = scanner.nextLine();
                    System.out.print("Ingrese la nueva palabra: ");
                    String nuevaPalabra = scanner.nextLine();
                    System.out.print("Ingrese la nueva emoción: ");
                    String nuevaEmocion = scanner.nextLine();
                    database.editarPalabraEmocional(palabraActual, nuevaPalabra, nuevaEmocion);
                    break;

                case "3":
                    System.out.print("Ingrese la palabra a eliminar: ");
                    String palabraEliminar = scanner.nextLine();
                    database.eliminarPalabraEmocional(palabraEliminar);
                    break;

                case "4":
                    database.listarDiccionarioEmocional();
                    break;

                case "5":
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}