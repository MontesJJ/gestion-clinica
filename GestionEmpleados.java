import java.util.Scanner; 

/**
 * Esta parte de la aplicacion se muestan las diferentes acciones que se pueden llevar a cabo con los empleados.
 */

public class GestionEmpleados extends Hospital {
            
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) { 
            
            System.out.println("+------------------------------------+");
            System.out.println("|        GESTIÓN DE EMPLEADOS        |");
            System.out.println("+------------------------------------+");
            System.out.println("| [1]  Dar de alta un empleado       |");
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
                    altaEmpleado();
                    
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
    
    public static void altaEmpleado(){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("INDIQUE EL NOMBRE COMPLETO DEL EMPLEADO:");
        String nombre = scanner.nextLine();
        
        System.out.println("INDIQUE EL TELÉFONO DEL EMPLEADO:");
        String tel = scanner.nextLine();
        
        System.out.println("INDIQUE EL DNI DEL EMPLEADO:");
        String dni = scanner.nextLine(); 
        
        System.out.println("SELECCIONA LA UNIDAD A LA QUE VA A SER ASIGNADO EL NUEVO EMPLEADO:");
        //Aqui meter un for y un selector para elegir la unidad
        
        Empleado nuevoEmpleado = new Empleado(unidades.get(0), nombre, tel, dni);
        nuevoEmpleado.comprobarNombre(nombre);
        nuevoEmpleado.generarEmail(nombre);
                
        empleados.add(nuevoEmpleado);
        

        //PENDIENTE --> Ver como distinguir entre empleado sanitario y no sanitario antes de darlo de alta, (new Sanitario) o (new Nosanitario)        
        
    }
    

}
