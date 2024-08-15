import java.util.Scanner; 
import java.util.ArrayList;
 
/**
 * Esta parte de la aplicacion se muestan las diferentes acciones que se pueden llevar a cabo con los empleados.
 */

public class GestionEstudiantes extends Hospital {
            
    public void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) { 
            
            System.out.println("+------------------------------------------------+");
            System.out.println("|             GESTIÓN DE ESTUDIANTES             |");
            System.out.println("+------------------------------------------------+");
            System.out.println("| [1]  Dar de alta un estudiante                 |");
            System.out.println("| [2]  Listado de estudiantes                    |");
            System.out.println("| [3]  Sanitarios encargados de las practicas    |");
            System.out.println("| [4]  Expulsar estudiante                       |");
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
                    altaEstudiante();
                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc1 = new Scanner(System.in);
                    String salir1 = sc1.nextLine();
                    System.out.print('\u000C');
                    break;
                case 2:
                    System.out.println('\u000C');
                    System.out.println("LISTADO DE ESTUDIANTES:");
                    imprimirListadoEstudiantes();
                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc2 = new Scanner(System.in);
                    String salir2 = sc2.nextLine();
                    System.out.print('\u000C');
                    break;
                case 3:
                    System.out.println('\u000C');
                    System.out.println("LISTADO DE SANITARIOS ENCARGADOS DE PRÁCTICAS:");
                    imprimirListadoSanitariosFormadores();
                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc3 = new Scanner(System.in);
                    String salir3 = sc3.nextLine();
                    System.out.print('\u000C');
                    break;

                case 4:
                    System.out.println('\u000C');
                    System.out.println("LISTADO DE SANITARIOS ENCARGADOS DE PRÁCTICAS:");
                    expulsarEstudiante();
                                        
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc4 = new Scanner(System.in);
                    String salir4 = sc4.nextLine();
                    System.out.print('\u000C');
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
    
    public void altaEstudiante(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("INDIQUE EL NOMBRE COMPLETO DEL ESTUDIANTE:");
        String nombre = scanner.nextLine();
        
        System.out.println("INDIQUE EL TELÉFONO DEL ESTUDIANTE:");
        String tel = scanner.nextLine();
        
        System.out.println("INDIQUE EL DNI DEL ESTUDIANTE:");
        String dni = scanner.nextLine();
        
        System.out.println("SELECCIONE LA UNIDAD FORMATIVA DEL ESTUDIANTE:");
        System.out.println("[1] Medicina" + "\n" + "[2] Enfermería");
        
        Scanner ud = new Scanner(System.in);
        int unidadFormativa = ud.nextInt();
        
        int horario;
        if(unidadFormativa == 1){
            horario = 1;
            System.out.println("SELECCIONE LA ESPECIALIDAD A LA QUE VA A ASIGNAR AL ESTUDIANTE:");
            imprimirEspecialidades();
            Scanner esp = new Scanner(System.in);
            int especialidad = esp.nextInt();
            System.out.println("SELECCIONE AL ESPECIALISTA DE " + especialidades.get(especialidad - 1).getNombreEspecialidad().toUpperCase() + ":");
            especialidades.get(especialidad).printSanitariosAsignados();
            Scanner espe = new Scanner(System.in);
            int especialista = espe.nextInt();
            Empleado sanitarioAsignado = especialidades.get(especialidad).sanitariosAsignados.get(especialista - 1);
                      
            Estudiante nuevoEstudiante = new Estudiante(nombre, tel, dni, unidades.get(9), sanitarioAsignado, horario);
            estudiantes.add(nuevoEstudiante);
            
            System.out.println("Se ha dado de alta correctamente al estudiante. Acudira a la unidad de formación de medicina, en horario de mañanas");
            System.out.println("Su sanitario asignado es: " + sanitarioAsignado.getNombreEmpleado());
            
        }else{
            horario = 2;
            
            System.out.println("SELECCIONE AL MIEMBRO DEL EQUIPO DE ENFERMERÍA QUE SE LE VA A ASIGNAR AL ESTUDIANTE:");
            imprimirEnfermeros();
            Scanner md = new Scanner(System.in);
            int enf = md.nextInt();
            
            ArrayList<Empleado> enfermeros = crearListaEnfermeros();
            Empleado sanitarioAsignado = enfermeros.get(enf - 1);
            
            Estudiante nuevoEstudiante = new Estudiante(nombre, tel, dni, unidades.get(9), sanitarioAsignado, horario);
            estudiantes.add(nuevoEstudiante);
            
            System.out.println("Se ha dado de alta correctamente al estudiante. Acudira a la unidad de formación de enfermería, en horario de tardes");
            System.out.println("Su sanitario asignado es: " + sanitarioAsignado.getNombreEmpleado());
            
        }
        
    }
    
    public void imprimirListadoEstudiantes(){
        int index = 1;
        for(Estudiante estudiante : estudiantes){
            System.out.println("[" + index + "] " + estudiante.getNombre());
            index++;
        }
        System.out.println("\n");
    }
    
    public void imprimirListadoSanitariosFormadores(){
        int index = 1;
        for(Estudiante estudiante : estudiantes){
            System.out.println("[" + index + "] " + estudiante.getSanitarioAsignado().getNombre());
            index++;
        }
        System.out.println("\n");
    }
    
    public void expulsarEstudiante(){
        System.out.println("SELECCIONE EL ESTUDIANTE AL QUE DESEA EXPULSAR:");
        imprimirListadoEstudiantes();
        Scanner est = new Scanner(System.in);
        estudiantes.remove(est.nextInt());
        
        System.out.println("INDIQUE BREVEMENTE EL MOTIVO DE LA EXPULSIÓN:");
        Scanner motivo = new Scanner(System.in);
        
        System.out.println("El estudiante ha sido expulsado de la formación por " + motivo.nextLine());
    }
    
    public ArrayList imprimirEnfermeros(){
        int index = 1;
        ArrayList<Empleado> enfermeros = new ArrayList<>();
        for(Empleado empleado : empleados){
            if(empleado instanceof Sanitarios){
                Sanitarios sanitario = (Sanitarios) empleado;
                if(sanitario.getEspecialidad() == null){
                    System.out.println("[" + index + "] " + sanitario.getNombreSanitario());
                    enfermeros.add(sanitario);
                    index++;
                }
            }
        }
        return enfermeros;
    }
    
    public ArrayList crearListaEnfermeros(){
        int index = 1;
        ArrayList<Empleado> enfermeros = new ArrayList<>();
        for(Empleado empleado : empleados){
            if(empleado instanceof Sanitarios){
                Sanitarios sanitario = (Sanitarios) empleado;
                if(sanitario.getEspecialidad() == null){                    
                    enfermeros.add(sanitario);
                    index++;
                }
            }
        }
        return enfermeros;
    }
}
