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
    private GregorianCalendar fechaAlta;
    private GregorianCalendar fechaBaja;
    
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
    
    //Esta función solo la voy a usar para trucar los datos de prueba y que cuando se emitan las facturas ya haya ingresos que se puedan facturar
    public void setAltaFake(){
        fechaAlta = new GregorianCalendar(2024, 8, 13, 8, 0, 0);
    }
    
    public Calendar getAlta(){
        return fechaAlta;
    }
    
    public Calendar getBaja(){
        return fechaBaja;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }
}
