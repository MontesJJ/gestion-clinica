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
    
    public void iniciarMenu(){
        
        Scanner scanner = new Scanner(System.in);
        int option;
        
        while (true) { 
            
            System.out.println("+--------------------------------------------+");
            System.out.println("|            GESTIÓN DE PACIENTES            |");
            System.out.println("+--------------------------------------------+");
            System.out.println("| [1]  Dar de alta un paciente               |");
            System.out.println("| [2]  Solicitar cita                        |");
            System.out.println("| [3]  Consultar las citas de un paciente    |");
            System.out.println("| [4]  Actualizar expediente                 |");
            System.out.println("| [5]  Ver expediente                        |");  
            System.out.println("| [6]  Gestionar ingreso                     |");
            System.out.println("| [7]  Dar de baja un ingreso                |");
            System.out.println("| [8]  Buscar Paciente                       |");
            System.out.println("| [9]  Volver                                |");
            System.out.println("+--------------------------------------------+");
            System.out.print("Elige una opción (1-8): ");
    
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); 
                System.out.print("Elige una opción (1-8): ");
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
                    actualizarExpediente();
                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc4 = new Scanner(System.in);
                    String salir4 = sc4.nextLine();
                    System.out.print('\u000C');
                    break;
                case 5:
                    System.out.println('\u000C');
                    verExpediente();
                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc5 = new Scanner(System.in);
                    String salir5 = sc5.nextLine();
                    System.out.print('\u000C');
                    break;
                case 6:
                    System.out.println('\u000C');
                    darAltaIngreso();
                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc6 = new Scanner(System.in);
                    String salir6 = sc6.nextLine();
                    System.out.print('\u000C');
                    break;
                case 7:
                    System.out.println('\u000C');
                    darBajaIngreso();
                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc7 = new Scanner(System.in);
                    String salir7 = sc7.nextLine();
                    System.out.print('\u000C');
                    break;
                case 8:
                    System.out.println('\u000C');
                    buscarPaciente();
                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc8 = new Scanner(System.in);
                    String salir8 = sc8.nextLine();
                    System.out.print('\u000C');
                    break;
                case 9:
                    scanner.close();
                    System.out.print('\u000C');
                    return;
                    
                default:
                    System.out.println("Opción no válida. Por favor, elige entre 1 y 8.");
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
    
    public void actualizarExpediente(){
        
        System.out.println("SELECCIONE EL PACIENTE PARA EL QUE QUIERE ACTUALIZAR EL EXPEDIENTE:");
        imprimirListadoPacientes();
        Scanner p = new Scanner(System.in);
        Paciente paciente = pacientes.get(p.nextInt() - 1);
        
        System.out.println("SELECCIONE LA UNIDAD DESDE LA QUE SE VA A GENERAR LA ENTRADA:");
        imprimirUnidades();
        Scanner ud = new Scanner(System.in);
        Unidad unidad = unidades.get(ud.nextInt()); 
        
        System.out.println("ESCRIBA LA ENTRADA PARA EL EXPEDIENTE:");
        Scanner tx = new Scanner(System.in);
        String textoEntrada = tx.nextLine();
        
        paciente.agregarEntradaExpediente(textoEntrada, unidad);
    }
    
    public void verExpediente(){
  
        System.out.println("SELECCIONE EL PACIENTE PARA EL QUE QUIERE ACTUALIZAR EL EXPEDIENTE:");
        imprimirListadoPacientes();
        Scanner p = new Scanner(System.in);
        Paciente paciente = pacientes.get(p.nextInt() - 1);        
        paciente.mostrarExpediente();
        
    }
    
    public void darAltaIngreso() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el paciente para ingresar:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + pacientes.get(i).getNombre());
        }
        int pacienteSeleccionado = scanner.nextInt() - 1;
        Paciente paciente = pacientes.get(pacienteSeleccionado);

        Habitacion habitacionLibre = null;
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.estaLibre()) {
                habitacionLibre = habitacion;
                break;
            }
        }

        if (habitacionLibre != null) {
            Ingreso ingreso = new Ingreso(paciente, habitacionLibre);
            ingreso.setAlta(); 
            habitacionLibre.getIngresos().add(ingreso);

            System.out.println("El paciente " + paciente.getNombre() + " ha sido ingresado en la habitación " +
                    habitacionLibre.getNumeroHabitacion());
        } else {
            System.out.println("No hay habitaciones disponibles.");
        }
    }

    public void darBajaIngreso() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el paciente para dar de baja:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + pacientes.get(i).getNombre());
        }
        int pacienteSeleccionado = scanner.nextInt() - 1;
        Paciente paciente = pacientes.get(pacienteSeleccionado);

        Ingreso ingresoActivo = null;
        for (Habitacion habitacion : habitaciones) {
            for (Ingreso ingreso : habitacion.getIngresos()) {
                if (ingreso.getPaciente().equals(paciente) && ingreso.getBaja() == null) {
                    ingresoActivo = ingreso;
                    break;
                }
            }
            if (ingresoActivo != null) {
                break;
            }
        }

        if (ingresoActivo != null) {
            ingresoActivo.setBaja();
            System.out.println("El paciente " + paciente.getNombre() + " ha sido dado de baja del ingreso.");
        } else {
            System.out.println("No se encontró un ingreso activo para el paciente seleccionado.");
        }
    }
    
    public void buscarPaciente() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Seleccione el criterio de búsqueda:");
                System.out.println("[1] Buscar por nombre");
                System.out.println("[2] Buscar por DNI");
                System.out.println("[3] Salir");
                String opcionStr = scanner.nextLine().trim();
                int opcion = Integer.parseInt(opcionStr);

                if (opcion == 3) {
                    System.out.println("Saliendo de la búsqueda...");
                    break;
                }

                switch (opcion) {
                    case 1:
                        System.out.println("INTRODUCE EL NOMBRE DEL PACIENTE:"); //Tenemos la posibilidd de buscar por concordacia ampia o concordancia exacta
                        String nombreBusqueda = scanner.nextLine().trim().toLowerCase();

                        ArrayList<Paciente> resultadosPorNombre = new ArrayList<>();

                        for (Paciente paciente : pacientes) {
                            String nombrePaciente = paciente.getNombre().toLowerCase();

                            if (nombrePaciente.contains(nombreBusqueda)) {
                                resultadosPorNombre.add(paciente);
                            }
                        }

                        if (resultadosPorNombre.isEmpty()) {
                            System.out.println("No se encontraron pacientes con el nombre proporcionado.");
                        } else {
                            System.out.println("Pacientes encontrados:");
                            for (Paciente paciente : resultadosPorNombre) {
                                System.out.println(paciente.getNombre());
                            }
                        }
                        break;

                    case 2:
                        System.out.println("INTRODUCE EL DNI DEL PACIENTE:");//Solo concordacia exacta
                        String dniBusqueda = scanner.nextLine().trim();

                        Paciente pacienteEncontrado = null;

                        for (Paciente paciente : pacientes) {
                            if (paciente.getDNI().equalsIgnoreCase(dniBusqueda)) {
                                pacienteEncontrado = paciente;
                                break;
                            }
                        }

                        if (pacienteEncontrado == null) {
                            System.out.println("No se encontró ningún paciente con el DNI proporcionado.");
                        } else {
                            System.out.println("Paciente encontrado:");
                            System.out.println(pacienteEncontrado.getNombre());
                        }
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, seleccione 1, 2 o 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
            }
        }
    }
}
