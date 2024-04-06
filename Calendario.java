import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

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
            System.out.println("| 14:00 - 15:00 |");//ASIIC 28∟ , ME HE QUEDADO EN EL ALT+130
            
    }
    //https://docs.oracle.com/javase/8/docs/api/java/util/Date.html
    //https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html#setTime-java.util.Date-
    //https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html
    //https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html#setGregorianChange-java.util.Date-
}
