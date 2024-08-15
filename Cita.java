import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Cita
{
    private GregorianCalendar fecha;
    private Unidad unidad;
    private Especialidad especialidad;
    
    public Cita(GregorianCalendar fecha, Unidad unidad, Especialidad especialidad) {
        this.fecha = fecha;
        this.unidad = unidad;
        this.especialidad = especialidad;
    }
    
    public Calendar getFecha() {
        return fecha;
    }
    
    public Unidad getUnidad() {
        return unidad;
    }
    
    public Especialidad getEspecialidad() {
        return especialidad;
    }
}

