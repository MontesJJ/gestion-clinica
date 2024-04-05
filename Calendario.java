import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
/**
 * Write a description of class Calendario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calendario
{
    private Calendar calendario;
    //private Calendar currentDate;
    
    public Calendario(){
        calendario = new GregorianCalendar();
        //currentDate = new GregorianCalendar();
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
            
            System.out.println();
            System.out.println("+---------------------------------------+");
            System.out.println("|                  2024                 |");
            System.out.println("+---------------------------------------+");
            
            for(int i = day; i<(day+30); i++){
                System.out.print(day);
                calendario.roll(calendario.DATE, true);
            }
            System.out.println("");
            System.out.println("| 08:00 - 09:00 |");
            System.out.println("| 09:00 - 10:00 |");
            System.out.println("| 10:00 - 11:00 |");
            System.out.println("| 08:00 - 09:00 |");
            System.out.println("| 08:00 - 09:00 |");
            System.out.println("| 08:00 - 09:00 |");
            System.out.println("| 08:00 - 09:00 |");
            
    }
    //https://docs.oracle.com/javase/8/docs/api/java/util/Date.html
    //https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html#setTime-java.util.Date-
    //https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html
    //https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html#setGregorianChange-java.util.Date-
}
