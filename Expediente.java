import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Este objeto va a recoger los datos de un paciente tras una consulta o prueba médica. Fecha, departamento que genera el expediente y texto explicativo
 */
public class Expediente {
    private Calendar calendario;
    private String entrada;
    private Unidad unidad;

    /**
     * Constructor for objects of class Expediente
     */
    public Expediente(Unidad unidad) {
        this.unidad = unidad;
        this.calendario = new GregorianCalendar(); 
        this.entrada = "";
    }
    
    public void setEntrada(String nuevaEntrada){
        this.entrada = nuevaEntrada;
    }

    public String getEntrada() {
        return this.entrada;
    }

    public Calendar getFecha() {
        return this.calendario;
    }
    
    public String getFechaFormateada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(calendario.getTime());
    }
    
    public String getUnidad(){
        return unidad.getNombreUnidad();
    }
}
