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
 * Esta parte de la aplicacion se centra en la gestión de los sanitarios. Las diferentes opciones se muestran a través de un menú.
 */

public class GestionPacientes extends Hospital {
    
    public GestionPacientes() {
    }    
    
    
    public void iniciarMenu(){
        
        Scanner scanner = new Scanner(System.in);
        int option;
        
        while (true) { 
            
            System.out.println("+--------------------------------------------+");
            System.out.println("|            GESTIÓN DE PACIENTES            |");
            System.out.println("+--------------------------------------------+");
            System.out.println("| [1]  Dar de alta un paciente               |");
            System.out.println("| [2]  Solicitar cita                        |");
            System.out.println("| [3]  Consultar expediente                  |");
            System.out.println("| [4]  Consultar las citas de un paciente    |");
            System.out.println("| [5]  Volver                                |");
            System.out.println("+--------------------------------------------+");
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
                    crearCita();

                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc2 = new Scanner(System.in);
                    String salir2 = sc2.nextLine();
                    System.out.print('\u000C');
                    break;
                case 3:
                    System.out.println('\u000C');
                    consultarCitas();
                    
                    break;
                case 4:
                    System.out.println('\u000C');
                    consultarCitas();
                    
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
    
    public void crearCita(){
        System.out.println("SELECCIONE EL PACIENTE PARA EL QUE SE VA A DAR DE ALTA LA CITA:");
        imprimirListadoPacientes();
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
    
    public void consultarCitas(){
        
        System.out.println("SELECCIONE EL PACIENTE PARA EL QUE QUIERE CONSULTAR LAS CITAS:");
        imprimirListadoPacientes();
        Scanner p = new Scanner(System.in);
        Paciente paciente = pacientes.get(p.nextInt() - 1);
        
        paciente.imprimirCitas();
        
    }
}