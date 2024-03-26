import java.util.Scanner; // Importamos la clase Scanner para leer la entrada del usuario

/**
 * Inicio de la aplicación
 */

public class Primero {
    
    private static GestionMedicos gestionMedicos = new GestionMedicos();
    private static GestionEstudiantes gestionEstudiantes = new GestionEstudiantes();
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creamos un objeto Scanner para leer la entrada del teclado
        int option; // Variable para almacenar la opción elegida por el usuario

        while (true) { // Un bucle infinito para mostrar el menú repetidamente hasta que el usuario decida salir
            // Imprime el menú con diseño
            System.out.println("+------------------------------------+");
            System.out.println("|         GESTIÓN DE MEDICOS         |");
            System.out.println("+------------------------------------+");
            System.out.println("| [1]  Listar todos los médicos      |");
            System.out.println("| [2]  Misión Espacial               |");
            System.out.println("| [3]  Viaje Submarino               |");
            System.out.println("| [4]  Tesoros Ocultos               |");
            System.out.println("| [5]  Volver                        |");
            System.out.println("+------------------------------------+");
            System.out.print("Elige una opción (1-8): ");

            // Validamos la entrada del usuario
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // esto es importante para descartar la entrada incorrecta
                System.out.print("Elige una opción (1-5): ");
            }
            option = scanner.nextInt(); // Lee la opción del usuario

            // Procesamos la elección del usuario
            switch (option) {
                case 1:
                    System.out.println('\u000C');
                    System.out.println("LISTADO DE TODOS LOS MEDICOS DE LA CLÍNICA");
                    gestionMedicos.imprimirListaMedicos();
                    System.out.println("Pulsa intro para volver...");
                    
                    Scanner sc = new Scanner(System.in);
                    String salir = sc.nextLine();
                    System.out.print('\u000C');
                    break;
                case 2:
                    System.out.println("Has elegido 'Misión Espacial'");
                    // Aquí puedes añadir más código para realizar la acción correspondiente
                    break;
                case 3:
                    System.out.println("Has elegido 'Viaje Submarino'");
                    // Aquí puedes añadir más código para realizar la acción correspondiente
                    break;
                case 4:
                    System.out.println("Has elegido 'Tesoros Ocultos'");
                    // Aquí puedes añadir más código para realizar la acción correspondiente
                    break;
             
                case 5:
                    
                    System.out.println("Gracias por participar. ¡Hasta la próxima!");
                    scanner.close(); // Cerrar el scanner antes de salir
                    System.out.print('\u000C');
                    return; // Sale del bucle y termina el programa
                    
                default:
                    System.out.println("Opción no válida. Por favor, elige entre 1 y 5.");
            }
        }
    }
}