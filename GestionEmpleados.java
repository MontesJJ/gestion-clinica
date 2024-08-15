import java.util.Scanner; 

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

}
