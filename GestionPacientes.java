import java.util.Scanner; 

/**
 * Esta parte de la aplicacion se centra en la gestión de los sanitarios. Las diferentes opciones se muestran a través de un menú.
 */

public class GestionPacientes extends Hospital {
            
    public GestionPacientes() {
    }    
    
    
    public void iniciarMenu(){
        
        Scanner scanner = new Scanner(System.in);
        int option;
        
        while (true) { 
            
            System.out.println("+------------------------------------+");
            System.out.println("|         GESTIÓN DE MEDICOS         |");
            System.out.println("+------------------------------------+");
            System.out.println("| [1]  Dar de alta un paciente       |");
            System.out.println("| [2]  Solicitar cita                |");
            System.out.println("| [3]  Consultar expediente          |");
            System.out.println("| [4]  Listar todos los pacientes    |");
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
                    altaPaciente();
                    
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
    
    public void altaPaciente(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("INDIQUE EL NOMBRE COMPLETO DEL PACIENTE:");
        String nombre = scanner.nextLine();
        
        System.out.println("INDIQUE EL TELÉFONO DEL PACIENTE:");
        String tel = scanner.nextLine();
        
        System.out.println("INDIQUE EL DNI DEL PACIENTE:");
        String dni = scanner.nextLine();

        System.out.println("INDIQUE EL EMAIL DEL PACIENTE:");
        String email = scanner.nextLine();
        
        System.out.println("INDIQUE SI EL ESTUDIANTE CUENTA CON SEGURO PRIVADO:");
        System.out.println("[1] Si" + "\n" + "[2] No");
        int se = scanner.nextInt();
        boolean seguro;
        
        if(se == 1){
            seguro = true;
        }else{
            seguro = false;
        }
        
        Paciente nuevoPaciente = new Paciente(nombre, tel, email, dni, seguro);
        pacientes.add(nuevoPaciente);
        
         System.out.println("El paciente se ha dado de alta correctamente" + "\n");
        
    }
    
    public void imprimirListadoPacientes(){
        int index = 1;
        for(Paciente paciente : pacientes){
            System.out.println("[" + index + "] " + paciente.getNombre());
            index++;
        }
        System.out.println("\n");
    }
}