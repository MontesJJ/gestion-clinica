import java.util.Scanner; 
import java.util.ArrayList;

/**
 * Esta parte de la aplicacion se muestan las diferentes acciones que se pueden llevar a cabo con las citas.
 */

public class GestionCitas extends Hospital {
            
    public void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) { 
            
            System.out.println("+------------------------------------------------+");
            System.out.println("|                GESTIÓN DE CITAS                |");
            System.out.println("+------------------------------------------------+");
            System.out.println("| [1]  Consultar citas del personal médico       |");
            System.out.println("| [2]  Consultar citas                           |");
            System.out.println("| [3]  Calendario de citas                       |");
            System.out.println("| [4]  Asignar estudiante                        |");
            System.out.println("| [5]  Volver                                    |");
            System.out.println("+------------------------------------------------+");
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
                    consultarCitasMedicos();
                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc1 = new Scanner(System.in);
                    String salir1 = sc1.nextLine();
                    System.out.print('\u000C');
                    break;
                case 2:
                    System.out.println('\u000C');
                    

                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc2 = new Scanner(System.in);
                    String salir2 = sc2.nextLine();
                    System.out.print('\u000C');
                    break;
                case 3:
                    System.out.println("Calendario de citas'");

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
    
    public void consultarCitasMedicos(){
        
       System.out.println("SELECCIONE LA ESPECIALIDAD MÉDICA:");
       imprimirEspecialidades();
       
       Scanner esp = new Scanner(System.in);
       int especialidad = esp.nextInt();
       
       System.out.println("SELECCIONE EL MÉDICO DE EL DEPARTAMENTO DE " + especialidades.get(especialidad - 1) + ":");
       especialidades.get(especialidad - 1).printSanitariosAsignados();
        
       ArrayList<Sanitarios> sanitarios = new ArrayList<>();
       for(Empleado empleado : empleados){
            if(empleado instanceof Sanitarios){
                Sanitarios sanitario = (Sanitarios) empleado;
                sanitarios.add(sanitario);
            }
       }
        
       for(Sanitarios sanitario : sanitarios){
            sanitario.imprimirCitas();
       }
    }

    
}
