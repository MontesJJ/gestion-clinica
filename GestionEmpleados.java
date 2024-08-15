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
 * Esta parte de la aplicacion se muestan las diferentes acciones que se pueden llevar a cabo con los empleados.
 */

public class GestionEmpleados extends Hospital {
            
    public void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) { 
            
            System.out.println("+------------------------------------+");
            System.out.println("|        GESTIÓN DE EMPLEADOS        |");
            System.out.println("+------------------------------------+");
            System.out.println("| [1]  Dar de alta un empleado       |");
            System.out.println("| [2]  Consultar calendario          |");
            System.out.println("| [3]  Modificar calendario          |");
            System.out.println("| [4]  Buscar empleado               |");
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
                    imprimirCitas();

                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc2 = new Scanner(System.in);
                    String salir2 = sc2.nextLine();
                    System.out.print('\u000C');
                    break;
                case 3:
                    System.out.println('\u000C');                    
                    modificarCitas();
                    
                    System.out.println("Pulsa intro para volver...");                    
                    Scanner sc3 = new Scanner(System.in);
                    String salir3 = sc3.nextLine();
                    System.out.print('\u000C');
                    break;

                case 4:
                    System.out.println('\u000C');                    
                    buscarEmpleado();
                    
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
    
    public void altaEmpleado(){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("INDIQUE EL NOMBRE COMPLETO DEL EMPLEADO:");
        String nombre = scanner.nextLine();
        
        System.out.println("INDIQUE EL TELÉFONO DEL EMPLEADO:");
        String tel = scanner.nextLine();
        
        System.out.println("INDIQUE EL DNI DEL EMPLEADO:");
        String dni = scanner.nextLine(); 
        
        System.out.println("SELECCIONA LA UNIDAD A LA QUE VA A SER ASIGNADO EL NUEVO EMPLEADO:");
        imprimirUnidades();
        Scanner ud = new Scanner(System.in);
        int unidad = ud.nextInt();      
                
        //Seleccionamos la especialidad del nuevo empleado
        if(3 < unidad && unidad < 9){            
            System.out.println("INDIQUE A QUE EQUIPO SE VA A INCORPORAR EL NUEVO SANITARIO, MEDICINA O ENFERMERÍA:");
            System.out.println("[1] Medicina" + "\n" + "[2] Enfermería");
            Scanner md = new Scanner(System.in);
            int equipo = md.nextInt();
            if(equipo == 1){
                System.out.println("SELECCIONE LA ESPECIALIDAD:");
                imprimirEspecialidades();
                Scanner esp = new Scanner(System.in);
                int especialidad = esp.nextInt();
                int horario = seleccionarHorario(unidad);
                Empleado nuevoEmpleado = new Sanitarios(especialidades.get(especialidad - 1) ,unidades.get(unidad - 1), nombre, tel, dni, horario);
                empleados.add(nuevoEmpleado);
                especialidades.get(especialidad).agregarSanitario(nuevoEmpleado);
            }else{
                int horario = seleccionarHorario(unidad);
                Empleado nuevoEmpleado = new Sanitarios(null ,unidades.get(unidad - 1), nombre, tel, dni, horario);
                empleados.add(nuevoEmpleado);
            }            
        }else{
            int horario = seleccionarHorario(unidad);
            Empleado nuevoEmpleado = new Nosanitarios(unidades.get(unidad - 1), nombre, tel, dni, horario);
            empleados.add(nuevoEmpleado);
        }
        
        System.out.println("El empleado se ha dado de alta correctamente");
        System.out.println("Su horario es:");
        System.out.println(horarios.get(empleados.get(empleados.size() - 1).getHorario()));
                   
    }
    
    /*
     * Voy a usar esta función para asignar el horario al empleado. A modo general, hay 2 tipos de unidades; las que tienen servicios de guardia y las que no.
     * Si el empleado no está en servicio de guardia, podra tener trabajo de mañana o tardes. En las unidades en las que hay servicio de guardia, tenemos mañana, tarde y noche.
     */
    public int seleccionarHorario(int unidad){
        int horario = 0; //lo pongo a cero para saber si lo está cogiendo bien
        if(unidad == 1 || unidad == 4 || unidad == 5 || unidad == 6 || unidad == 10){
            System.out.println("SELECCIONE EL TURNO DE TRABAJO DEL EMPLEADO;");
            System.out.println("[1] Mañana" + "\n" + "[2] Tarde");
            Scanner tur = new Scanner(System.in);
            if(tur.nextInt() == 1){
                horario = 1;
            }else{
                horario = 2;
            }
        }else{
            System.out.println("SELECCIONE LOS DÍAS DE TRABAJO DEL EMPLEADO;");
            System.out.println("[1] Entresemana" + "\n" + "[2] Fines de semana" );
            Scanner dia = new Scanner(System.in);
            if(dia.nextInt() == 1){
                System.out.println("SELECCIONE EL TURNO DE TRABAJO DEL EMPLEADO:");
                System.out.println("[1] Mañana" + "\n" + "[2] Tarde" + "\n" + "[3] Noche");
                Scanner tur = new Scanner(System.in);
                int turno = tur.nextInt();
                if(turno == 1){
                    horario = 1;
                }else if(turno == 2){
                    horario = 3;
                }else{
                    horario = 4;
                }
            }else{
                System.out.println("SELECCIONE EL TURNO DE TRABAJO DEL EMPLEADO;");
                System.out.println("[1] Día" + "\n" + "[2] Noche");
                Scanner tur = new Scanner(System.in);
                if(tur.nextInt() == 1){
                    horario = 6;
                }else{
                    horario = 5;
                }
            }
        }
        return horario;
    }
    
    public void imprimirCitas(){
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

    public void buscarEmpleado() {
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
                        System.out.println("INTRODUCE EL NOMBRE DEL EMPLEADO:"); //Tenemos la posibilidd de buscar por concordacia ampia o concordancia exacta
                        String nombreBusqueda = scanner.nextLine().trim().toLowerCase();

                        ArrayList<Empleado> resultadosPorNombre = new ArrayList<>();

                        for (Empleado empleado : empleados) {
                            String nombreEmpleado = empleado.getNombre().toLowerCase();

                            if (nombreEmpleado.contains(nombreBusqueda)) {
                                resultadosPorNombre.add(empleado);
                            }
                        }

                        if (resultadosPorNombre.isEmpty()) {
                            System.out.println("No se encontraron empleados con el nombre proporcionado.");
                        } else {
                            System.out.println("Empleados encontrados:");
                            for (Empleado empleado : resultadosPorNombre) {
                                System.out.println(empleado.getNombre());
                            }
                        }
                        break;

                    case 2:
                        System.out.println("INTRODUCE EL DNI DEL EMPLEADO:");//Solo concordacia exacta
                        String dniBusqueda = scanner.nextLine().trim();

                        Empleado empleadoEncontrado = null;

                        for (Empleado empleado : empleados) {
                            if (empleado.getDNI().equalsIgnoreCase(dniBusqueda)) {
                                empleadoEncontrado = empleado;
                                break;
                            }
                        }

                        if (empleadoEncontrado == null) {
                            System.out.println("No se encontró ningún empleado con el DNI proporcionado.");
                        } else {
                            System.out.println("Empleado encontrado:");
                            System.out.println(empleadoEncontrado.getNombre());
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
    
    public void modificarCitas(){
        ArrayList<Sanitarios> sanitarios = new ArrayList<>();
        for(Empleado empleado : empleados){
            if(empleado instanceof Sanitarios){
                Sanitarios sanitario = (Sanitarios) empleado;
                sanitarios.add(sanitario);
            }
        }
        
        System.out.println("SELECCIONA EL EMPLEADO PARA EL QUE SE VA A MODIFICAR UNA CITA:");
        int index = 1;
        for(Sanitarios sanitario : sanitarios){
            if(sanitario.getEspecialidad() != null){
                System.out.println("[" + index + "] " + sanitario.getNombre());
            }
            index++;
        }
                
        /*Scanner sn = new Scanner(System.in);
        sanitarios.get(sn.nextInt() - 1).getCalendario().imprimirCitas();
        
        int seleccion = sn.nextInt() - 1;
        Calendario calendario = sanitarios.get(seleccion).getCalendario();
        System.out.println("SELECCIONA LA CITA QUE DESEAS MODIFICAR:");
        */
        Scanner sn = new Scanner(System.in);
        int seleccion = sn.nextInt() - 1;
        Calendario calendario = sanitarios.get(seleccion).getCalendario();
        
        if(calendario.getCitas().isEmpty()){
            System.out.println("No hay citas disponibles para modificar.");
        }else{
            System.out.println("SELECCIONA LA CITA QUE DESEAS MODIFICAR:");
            calendario.imprimirCitas();
            int citaModificar = sn.nextInt() - 1;

            if(citaModificar < 0 || citaModificar >= calendario.getCitas().size()){
                System.out.println("Selección de cita no válida.");
                return;
            }

            GregorianCalendar fechaOriginal = calendario.getCitas().get(citaModificar);
            
            Paciente paciente = calendario.getCits().get(fechaOriginal);
            
            System.out.println("INDICA SI DESEAS MODIFICAR O ELIMINAR LA CITA:");
            System.out.println("[1] Modificar" + "\n" + "[2] Eliminar");
            int me = sn.nextInt();
            
            if(me == 1){
                
                System.out.println("Introduce el nuevo día del mes:");
                int nuevoDia = sn.nextInt();
                System.out.println("Introduce el nuevo mes (1-12):");
                int nuevoMes = sn.nextInt() - 1;
                System.out.println("Introduce el nuevo año:");
                int nuevoAno = sn.nextInt();
                System.out.println("Introduce la nueva hora (0-23):");
                int nuevaHora = sn.nextInt();
            
                GregorianCalendar nuevaFecha = new GregorianCalendar(nuevoAno, nuevoMes, nuevoDia, nuevaHora, 0);
            

                calendario.getCitas().remove(citaModificar);
                calendario.getCits().remove(fechaOriginal);
            
                calendario.getCitas().add(nuevaFecha);
                calendario.getCits().put(nuevaFecha, paciente);
            
                System.out.println("La cita ha sido modificada correctamente.");
            
            }else if(me == 2){
                
                calendario.getCitas().remove(citaModificar);
                calendario.getCits().remove(fechaOriginal);
            
                System.out.println("La cita ha sido eliminada correctamente.");
            }else{
                System.out.println("Opción no válida.");
            }


            
        }

       
        
    }
    
}
