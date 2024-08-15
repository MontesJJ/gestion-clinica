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
 * Write a description of class Calendario here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Calendario
{
    private Calendar calendario;
    private HashMap<GregorianCalendar, Paciente> cits;
    private ArrayList<GregorianCalendar> citas;
    
    
    public Calendario(){
        calendario = new GregorianCalendar();
        citas = new ArrayList<>();
        cits = new HashMap<>();
    }
    /**
     * Vamos a generar un calendario para 30 días a partir del día en el que se crea. Para poder crear el calendario de los medicos, vamos a contar con que
     * hay tres turnos; mañana, tarde y noche, y 
     */
    public void generarCalendario(){
            //Creamos las variables año, mes y dia para configurar una fecha que vaya desde el dia en el que se genera el calendario hasta 30 días despues
            int year = calendario.get(Calendar.YEAR);
            int month = calendario.get(Calendar.MONTH);
            int day = calendario.get(Calendar.DATE);
            //Preparamos la fecha para que empiece a las 8.00 AM y vaya pasando de una hora en una hora
            Date date = new Date((year-1900), month, day, 0, 0, 0); //Por defecto, el objeto DATE empieza contando desde 1901, por eso le resto 1900 al año en curso.
                        
            calendario.setTime(date);
            
        for(int i=1; i<24; i++){            
            
            System.out.println(calendario.getTime());
            calendario.roll(calendario.HOUR_OF_DAY, true);
        }
    }
    
    public void printCalendar(){
            //Creamos las variables año, mes y dia para configurar una fecha que vaya desde el dia en el que se genera el calendario hasta 30 días despues
            int year = calendario.get(Calendar.YEAR);
            int month = calendario.get(Calendar.MONTH);
            int day = calendario.get(Calendar.DATE);
            
            //Creo otra instancia del calendario para el dia de la semana
            Calendar semana = Calendar.getInstance();
            SimpleDateFormat diaSemana = new SimpleDateFormat("EEEE", new Locale("es", "ES"));

            
            System.out.println(calendario.getTime());
            System.out.println();
            System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                                2024                                                                 |");
            System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.print("|||||||||||||||||");
            for(int i = day; i<(day+30); i++){
                System.out.printf(diaSemana.format(calendario.getTime()).substring(0, 3) + " ");
                calendario.roll(calendario.DAY_OF_MONTH, true);
            }

            System.out.print("\n" + "|||||||||||||||||");
            for(int i = day; i<(day+30); i++){
                System.out.printf("%-4d", calendario.get(Calendar.DAY_OF_MONTH));
                calendario.roll(calendario.DAY_OF_MONTH, true);
            }
            System.out.println("");
            System.out.println("| 08:00 - 09:00 |");//Tengo que plantear un bucle que primero mire si hay citas para esa hora, si es que si ya empiza a reccorer los dias, si es que no, sale del bucle
            System.out.println("| 09:00 - 10:00 |");
            System.out.println("| 10:00 - 11:00 |");
            System.out.println("| 11:00 - 12:00 |");
            System.out.println("| 12:00 - 13:00 |");
            System.out.println("| 13:00 - 14:00 |");
            System.out.println("| 14:00 - 15:00 |");
            
    }
    //https://docs.oracle.com/javase/8/docs/api/java/util/Date.html
    //https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html#setTime-java.util.Date-
    //https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html
    //https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html#setGregorianChange-java.util.Date-
    
    public void nuevaCita(Paciente paciente, Unidad unidad, int horario) {
        // Primero, vamos a comprobar que la cita que se da de alta está dentro del rango de fechas permitido (HOY + 30 días)
        // y que no hay ninguna otra cita para ese día/hora
        boolean citaGuardada = false;
        while (!citaGuardada) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Seleccione el día del mes en el que acudirá a la cita:");
            int dia = sc.nextInt();
            System.out.println("Seleccione el mes (1-12):");
            int mes = sc.nextInt() - 1; 
            System.out.println("Seleccione el año:");
            int ano = sc.nextInt();
    
            // Determinar las horas disponibles según el turno del medico o la unidadd
            int horaInicio, horaFin;
            if(horario == 1){ // Turno de mañana
                horaInicio = 8;
                horaFin = 15;
                System.out.println("El médico está disponible entre las 8:00 y las 15:00.");
            }else if(horario == 2){ // Turno de tarde
                horaInicio = 15;
                horaFin = 22;
                System.out.println("El médico está disponible entre las 15:00 y las 22:00.");
            }else if(horario == 3) { // Turno de 24 horas
                horaInicio = 0;
                horaFin = 24;
            }else{ // Turno extendido de 8:00 a 22:00
                horaInicio = 8;
                horaFin = 22;
            }
    
            System.out.println("Seleccione la hora para su cita (las citas se dan en franjas de una hora, " +
                    "por ejemplo, para las 16:00, escriba 16):");
            int hora = sc.nextInt();
    
            if(hora < horaInicio || hora >= horaFin){
                System.out.println("La hora seleccionada está fuera del rango disponible para este médico.");
                continue;
            }
    
            // Declaro un ArrayList que va a contener todas las claves del HashMap, y así poder acceder a él a través de un índice
            ArrayList<GregorianCalendar> keys = new ArrayList<>(cits.keySet());
            boolean hueco = true;
            int index = 0;
    
            while (hueco && index < cits.size()) {
                if (keys.get(index).get(Calendar.DAY_OF_MONTH) == dia &&
                    keys.get(index).get(Calendar.MONTH) == mes &&
                    keys.get(index).get(Calendar.YEAR) == ano &&
                    keys.get(index).get(Calendar.HOUR_OF_DAY) == hora) {
                    hueco = false;
                } else {
                    index++;
                }
            }
    
            // Si hay hueco para el día seleccionado lo añadimos a la lista de citas
            if (hueco) {
                GregorianCalendar nuevaCita = new GregorianCalendar(ano, mes, dia, hora, 0, 0);
                citas.add(nuevaCita);
                cits.put(nuevaCita, paciente);
                // paciente.agregarCita(nuevaCita, unidad);
                citaGuardada = true;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                //System.out.println("La cita se ha generado correctamente: " + sdf.format(nuevaCita.getTime()));
            } else {
                System.out.println("No hay hueco disponible para la fecha y hora seleccionadas, ¿Desea seleccionar otra? [Y/N]");
                String nueva = sc.next();
                if (!nueva.equalsIgnoreCase("Y")) {
                    citaGuardada = true;
                }
            }
        }
    }

    
    public void imprimirCitas(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        for(Map.Entry<GregorianCalendar, Paciente> citas : cits.entrySet()){
            System.out.println(citas.getValue().getNombre() + " " + sdf.format(citas.getKey().getTime()));
        }
    }
    
    public String getFechaFormateada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(calendario.getTime());
    }
    
    public ArrayList getCitas(){
        return citas;
    }
}
