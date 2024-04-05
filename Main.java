import java.util.Scanner; // Importamos la clase Scanner para leer la entrada del usuario

/**
 * Inicio de la aplicación
 */

public class Main {
    
    protected static BD baseDatos;
    private static Primero primero;
    
    public static void main(String[] args) {
        
        baseDatos = new BD();
        Scanner scanner = new Scanner(System.in); // Creamos un objeto Scanner para leer la entrada del teclado
        int option; // Variable para almacenar la opción elegida por el usuario

        while (true) { // Un bucle infinito para mostrar el menú repetidamente hasta que el usuario decida salir
            // Imprime el menú con diseño
            System.out.println("+------------------------------------+");
            System.out.println("|             MENÚ CHULO             |");
            System.out.println("+------------------------------------+");
            System.out.println("| [1]  Aventura Mágica               |");
            System.out.println("| [2]  Misión Espacial               |");
            System.out.println("| [3]  Viaje Submarino               |");
            System.out.println("| [4]  Tesoros Ocultos               |");
            System.out.println("| [5]  Desafío Culinario             |");
            System.out.println("| [6]  Carrera de Mente              |");
            System.out.println("| [7]  Reto de Supervivencia         |");
            System.out.println("| [8]  Salir                         |");
            System.out.println("+------------------------------------+");
            System.out.print("Elige una opción (1-8): ");

            // Validamos la entrada del usuario
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // esto es importante para descartar la entrada incorrecta
                System.out.print("Elige una opción (1-8): ");
            }
            option = scanner.nextInt(); // Lee la opción del usuario

            // Procesa la elección del usuario
            switch (option) {
                case 1:
                    System.out.println("Has elegido 'Aventura Mágica'");
                    System.out.print('\u000C');
                    String[] argsPrimero = {"arg1", "arg2"};
                    Primero.main(argsPrimero);

                    // Aquí puedes añadir más código para realizar la acción correspondiente
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
                    System.out.println("Has elegido 'Desafío Culinario'");
                    // Aquí puedes añadir más código para realizar la acción correspondiente
                    break;
                case 6:
                    System.out.println("Has elegido 'Carrera de Mente'");
                    // Aquí puedes añadir más código para realizar la acción correspondiente
                    break;
                case 7:
                    System.out.println("Has elegido 'Reto de Supervivencia'");
                    // Aquí puedes añadir más código para realizar la acción correspondiente
                    break;
                case 8:
                    System.out.println("Gracias. ¡Hasta la próxima!");
                    scanner.close(); // Cerrar el scanner antes de salir
                    System.out.print('\u0017'); //BUSCAR UNICODE PARA SIMULAR CTRL+W
                    return; // Sale del bucle y termina el programa
                default:
                    System.out.println("Opción no válida. Por favor, elige entre 1 y 8.");
            }
        }
    }
}


