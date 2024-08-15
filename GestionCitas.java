import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta parte de la aplicacion se muestan las diferentes acciones que se pueden llevar a cabo con las citas.
 */

public class GestionCitas extends Hospital {
    
    public void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
    
        while (true) { 
            
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("|                        GESTIÓN DE CITAS                         |");
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("| [1]  Consultar citas del personal médico                        |");
            System.out.println("| [2]  Consultar citas unidad médica especializada - Cardiología  |");
            System.out.println("| [3]  Consultar citas unidad médica especializada - Diabetes     |");
            System.out.println("| [4]  Consultar citas unidad de pruebas médicas                  |");
            System.out.println("| [5]  Dar de alta una nueva cita                                 |");  
            System.out.println("| [6]  Volver                                                     |");
            System.out.println("+-----------------------------------------------------------------+");
            System.out.print("Elige una opción (1-6): ");
    
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); 
                System.out.print("Elige una opción (1-6): ");
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
                    consultarCitasCardio();
    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc2 = new Scanner(System.in);
                    String salir2 = sc2.nextLine();
                    System.out.print('\u000C');
                    break;
                case 3:
                    System.out.println('\u000C');
                    consultarCitasDiabetes();
    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc3 = new Scanner(System.in);
                    String salir3 = sc3.nextLine();
                    System.out.print('\u000C');
                    break;
                case 4:
                    System.out.println('\u000C');
                    consultarCitasPruebasMedicas();
    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc4 = new Scanner(System.in);
                    String salir4 = sc4.nextLine();
                    System.out.print('\u000C');
                    break;
                case 5:
                    System.out.println('\u000C');
                    generarNuevaCita();
    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc5 = new Scanner(System.in);
                    String salir5 = sc5.nextLine();
                    System.out.print('\u000C');
                    break;
                case 6:
                    scanner.close();
                    System.out.print('\u000C');
                    return;
                    
                default:
                    System.out.println("Opción no válida. Por favor, elige entre 1 y 6.");
            }
        }
    }

    
    public void consultarCitasMedicos(){
        
        Especialidad especialidad;
        System.out.println("SELECCIONE LA ESPECIALIDAD:");
        imprimirEspecialidades();
        Scanner sp = new Scanner(System.in);
        int espe = sp.nextInt();
        especialidad = especialidades.get(espe - 1);
            
        System.out.println("SELECCIONE AL ESPECIALISTA DE " + especialidad.getNombreEspecialidad().toUpperCase() + ":");
        especialidad.printSanitariosAsignados();
        Scanner md = new Scanner(System.in);
        Sanitarios sanitario = (Sanitarios) especialidad.getSanitariosAsignados().get(md.nextInt() - 1);
        sanitario.imprimirCitas();             

    }
    
    public void consultarCitasCardio(){
        System.out.println("CITAS DE LA UNIDAD MÉDICA ESPECIALIZADA DE CARDIOLOGÍA");
        unidades.get(4).getCalendario().imprimirCitas();
    }
    
    public void consultarCitasDiabetes(){
        System.out.println("CITAS DE LA UNIDAD MÉDICA ESPECIALIZADA DE DIABETES");
        unidades.get(3).getCalendario().imprimirCitas();
    }
    
    public void consultarCitasPruebasMedicas(){
        System.out.println("CITAS DE LA UNIDAD DE PRUEBAS MÉDICAS");
        unidades.get(2).getCalendario().imprimirCitas();
    }
    
    public void generarNuevaCita(){
        System.out.println("SELECCIONE EL PACIENTE PARA EL QUE SE VA A DAR DE ALTA LA CITA:");
        int index = 1;
        for(Paciente paciente : pacientes){
            System.out.println("[" + index + "] " + paciente.getNombre());
            index++;
        }
        System.out.println("\n");
        Scanner p = new Scanner(System.in);
        Paciente paciente = pacientes.get(p.nextInt() - 1);
        
        System.out.println("SELECCIONE LA UNIDAD EN LA QUE DESEA RESERVAR CITA:");
        System.out.println("[1] Pruebas médicas");
        System.out.println("[2] Unidad médica especializada - Diabetes");
        System.out.println("[3] Unidad médica especializada - Cardiología");
        System.out.println("[4] Consultas externas");
        Scanner ud = new Scanner(System.in);
        int unidad = ud.nextInt();
        
        Unidad unidadSeleccionada;
        Especialidad especialidad;
        if(unidad == 1){
            unidadSeleccionada = unidades.get(2);
            especialidad = null;
            unidadSeleccionada.crearCita(paciente, unidadSeleccionada, 3);
            ArrayList<GregorianCalendar> citas = unidadSeleccionada.getCalendario().getCitas();
            GregorianCalendar fecha = citas.get(citas.size() - 1);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
            Cita cita = new Cita(fecha, unidadSeleccionada, especialidad);
            paciente.agregarCita(cita);
            
            System.out.println("La cita se ha generado correctamente el " + sdf.format(fecha.getTime()) + " en la unidad de " + unidadSeleccionada.getNombreUnidad().toLowerCase());
        }else if(unidad == 2){
            unidadSeleccionada = unidades.get(3);
            especialidad = null;
            unidadSeleccionada.crearCita(paciente, unidadSeleccionada, 4);
            ArrayList<GregorianCalendar> citas = unidadSeleccionada.getCalendario().getCitas();
            GregorianCalendar fecha = citas.get(citas.size() - 1);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
            Cita cita = new Cita(fecha, unidadSeleccionada, especialidad);
            paciente.agregarCita(cita);
            
            System.out.println("La cita se ha generado correctamente el " + sdf.format(fecha.getTime()) + " en la unidad de " + unidadSeleccionada.getNombreUnidad().toLowerCase());
        }else if(unidad == 3){
            unidadSeleccionada = unidades.get(4);
            especialidad = null;
            unidadSeleccionada.crearCita(paciente, unidadSeleccionada, 4);
            ArrayList<GregorianCalendar> citas = unidadSeleccionada.getCalendario().getCitas();
            GregorianCalendar fecha = citas.get(citas.size() - 1);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
            Cita cita = new Cita(fecha, unidadSeleccionada, especialidad);
            paciente.agregarCita(cita);
            
            System.out.println("La cita se ha generado correctamente el " + sdf.format(fecha.getTime()) + " en " + unidadSeleccionada.getNombreUnidad().toLowerCase());
        }else{
            unidadSeleccionada = unidades.get(5);
            System.out.println("SELECCIONE LA ESPECIALIDAD:");
            imprimirEspecialidades();
            Scanner sp = new Scanner(System.in);
            int espe = sp.nextInt();
            especialidad = especialidades.get(espe - 1);
            
            System.out.println("SELECCIONE AL ESPECIALISTA DE " + especialidad.getNombreEspecialidad().toUpperCase() + ":");
            especialidad.printSanitariosAsignados();
            Scanner md = new Scanner(System.in);
            Sanitarios sanitario = (Sanitarios) especialidad.getSanitariosAsignados().get(md.nextInt() - 1);
            sanitario.crearCita(paciente);
            
            ArrayList<GregorianCalendar> citas = sanitario.getCalendario().getCitas();
            GregorianCalendar fecha = citas.get(citas.size() - 1);
            
            Cita cita = new Cita(fecha, unidadSeleccionada, especialidad);
            paciente.agregarCita(cita);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println("La cita se ha generado correctamente el " + sdf.format(fecha.getTime())
                + " en " + unidadSeleccionada.getNombreUnidad() 
                + ", en el departamento de " + especialidad.getNombreEspecialidad()
            );
        }     
    }
    
}
