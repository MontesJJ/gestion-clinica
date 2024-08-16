import java.util.ArrayList;
import java.util.Scanner;

public class Mantenimiento extends Hospital {

    private ArrayList<Recurso> recursos;

    public Mantenimiento(){
        this.recursos = new ArrayList<>();
    }

    public void iniciarMenu(){
        Scanner scanner = new Scanner(System.in);
        int option;

        while(true){
            System.out.println("+--------------------------------------------+");
            System.out.println("|            GESTIÓN DE MANTENIMIENTO        |");
            System.out.println("+--------------------------------------------+");
            System.out.println("| [1]  Dar de alta recurso dañado            |");
            System.out.println("| [2]  Dar de baja recurso reparado          |");
            System.out.println("| [3]  Asignar técnico                       |");
            System.out.println("| [4]  Volver                                |");
            System.out.println("+--------------------------------------------+");
            System.out.print("Elige una opción (1-4): ");

            while(!scanner.hasNextInt()){
                System.out.println("Por favor, introduce un número válido.");
                scanner.next();
                System.out.print("Elige una opción (1-4): ");
            }
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print('\u000C');
                    darAltaRecurso();                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc1 = new Scanner(System.in);
                    String salir1 = sc1.nextLine();
                    System.out.print('\u000C');
                    break;
                case 2:
                    System.out.print('\u000C');
                    darBajaRecurso();                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc2 = new Scanner(System.in);
                    String salir2 = sc2.nextLine();
                    System.out.print('\u000C');
                    break;
                case 3:
                    System.out.print('\u000C');
                    asignarTecnico();                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc3 = new Scanner(System.in);
                    String salir3 = sc3.nextLine();
                    System.out.print('\u000C');
                    break;
                case 4:
                    scanner.close();
                    System.out.print('\u000C');
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elige entre 1 y 4.");
            }
        }
    }

    private void darAltaRecurso(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del recurso dañado: ");
        String nombreRecurso = scanner.nextLine();
        Recurso recurso = new Recurso(nombreRecurso);
        recursos.add(recurso);
        System.out.println("Recurso " + nombreRecurso + " dado de alta para mantenimiento.");
    }

    private void darBajaRecurso(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Listado de recursos en mantenimiento:");
        for (int i = 0; i < recursos.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + recursos.get(i).getNombre());
        }
        System.out.print("Selecciona el número del recurso a dar de baja: ");
        int recursoIndex = scanner.nextInt() - 1;
        if (recursoIndex >= 0 && recursoIndex < recursos.size()) {
            Recurso recurso = recursos.remove(recursoIndex);
            System.out.println("Recurso " + recurso.getNombre() + " dado de baja.");
        } else {
            System.out.println("Índice no válido.");
        }
    }

    private void asignarTecnico(){
        if (recursos.isEmpty()) {
            System.out.println("No hay recursos que necesiten mantenimiento.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Listado de recursos en mantenimiento:");
        for(int i = 0; i < recursos.size(); i++){
            System.out.println("[" + (i + 1) + "] " + recursos.get(i).getNombre());
        }
        System.out.print("Selecciona el número del recurso al que asignar un técnico: ");
        int recursoIndex = scanner.nextInt() - 1;

        if(recursoIndex >= 0 && recursoIndex < recursos.size()) {
            Recurso recurso = recursos.get(recursoIndex);

            System.out.println("Selecciona el técnico a asignar:");
            for (int i = 0; i < Hospital.empleados.size(); i++){
                Empleado empleado = Hospital.empleados.get(i);
                if (empleado.getUnidad().getNombreUnidad().equals("Mantenimiento")) {
                    System.out.println("[" + (i + 1) + "] " + empleado.getNombre());
                }
            }

            int tecnicoIndex = scanner.nextInt() - 1;
            if (tecnicoIndex >= 0 && tecnicoIndex < Hospital.empleados.size()){
                Empleado tecnico = Hospital.empleados.get(tecnicoIndex);
                recurso.setTecnico(tecnico);
                System.out.println("Técnico " + tecnico.getNombre() + " asignado al recurso " + recurso.getNombre());
            }else{
                System.out.println("Índice no válido.");
            }
        }else{
            System.out.println("Índice no válido.");
        }
    }
}

