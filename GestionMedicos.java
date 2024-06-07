import java.util.Scanner; 

/**
 * Esta parte de la aplicacion se centra en la gestión de los sanitarios. Las diferentes opciones se muestran a través de un menú.
 */

public class GestionMedicos extends Hospital {
            
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) { 
            
            System.out.println("+------------------------------------+");
            System.out.println("|         GESTIÓN DE MEDICOS         |");
            System.out.println("+------------------------------------+");
            System.out.println("| [1]  Listar todos los médicos      |");
            System.out.println("| [2]  Dar de alta un médico         |");
            System.out.println("| [3]  Calendario de citas           |");
            System.out.println("| [4]  Asignar estudiante            |");
            System.out.println("| [5]  Volver                        |");
            System.out.println("+------------------------------------+");
            System.out.print("Elige una opción (1-5): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); 
                System.out.print("Elige una opción (1-5): ");
            }
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println('\u000C');
                    System.out.println("LISTADO DE TODOS LOS MEDICOS DE LA CLÍNICA");
                    System.out.println(unidades.get(0).getNombreUnidad());
                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc1 = new Scanner(System.in);
                    String salir1 = sc1.nextLine();
                    System.out.print('\u000C');
                    break;
                case 2:
                    System.out.println('\u000C');
                    System.out.println("INDICA EL NOMBRE DEL MEDICO");

                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc2 = new Scanner(System.in);
                    String salir2 = sc2.nextLine();
                    System.out.print('\u000C');
                    break;
                case 3:
                    System.out.println("Calendario de citas'");
                    
                    break;
                case 4:
                    System.out.println("Has elegido 'Asignar estudiante'");
                    
                    break;
             
                case 5:
                    scanner.close();
                    System.out.print('\u000C');
                    return;
                    
                default:
                    System.out.println("Opción no válida. Por favor, elige entre 1 y 5.");
            }
        }
    }
}