import java.util.Scanner;

public class Menu {

    //Clase "Menu" que despliega un menú en consola que permite registrar y listar las clases definidas.

    //Atributos
    private boolean estaCorriendo;

    //Métodos
    //Constructor
    public Menu() {
        estaCorriendo = true;
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
                break;
            case "2":
                System.out.println("\nRegistrando departamento");
                break;
            case "3":
                System.out.println("\nRegistrando ticket");
                break;
            case "4":
                System.out.println("\nDesplegando usuarios registrados");
                break;
            case "5":
                System.out.println("\nDesplegando departamentos registrados");
                break;
            case "6":
                System.out.println("\nDesplegando tickets registrados");
                break;
            case "7":
                System.out.println("\nSaliendo");
                estaCorriendo = false;
                break;
            default:
                System.out.println("\nOpción inválida, por favor intente de nuevo.");
        }
    }
}
