import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Este objeto va a recoger los datos de un paciente tras una consulta o prueba médica. Fecha, departamento que genera el expediente y texto explicativo
 */
public class Expediente
{
    private Calendar calendario;
    private String entrada;

    /**
     * Constructor for objects of class Expediente
     */
    public Expediente()
    {
        calendario = new GregorianCalendar();
        entrada = "";
    }
    
    public void setEntrada(String nuevaEntrada){
        entrada = nuevaEntrada;
    }
    
}
