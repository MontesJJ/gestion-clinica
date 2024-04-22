import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Vamos a regustrar los ingresos de los pacientes en el hospital. Para cada ingreso haremos constar la fecha de inicio del ingreso y la fecha de fin.
 * También tendremos que guardar la información sobre el paciente ingresado y la habitación asignada.
 */
public class Ingreso
{
    private Paciente paciente;
    private Habitacion habitacion;
    private Calendar fechaAlta;
    private Calendar fechaBaja;
    
    /**
     * Constructor
     */
    public Ingreso(Paciente paciente, Habitacion habitacion)
    {
        this.paciente = paciente;
        this.habitacion = habitacion;
    }
    
    public void setAlta(){
        fechaAlta = new GregorianCalendar();
    }
    
    public void setBaja(){
        fechaBaja = new GregorianCalendar();
    }
    
    public Calendar getAlta(){
        return fechaAlta;
    }
    
    public Calendar getBaja(){
        return fechaBaja;
    }
    
}
