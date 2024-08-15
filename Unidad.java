import java.util.ArrayList;
/**
 * Estas son las unidades del hospital. Por defecto, vamos a considerar que las enfermeras no estan asignadas a ninguna unidad, pondremos valor "null".
 * Hay 10 unidades: Administración, consultas externas, hospitalización, pruebas médicas, unidades médicas especializadas, urgencias,UCI, unidad de formación, cafetería y aparcamiento.
 */
public class Unidad
{
    
    private String nombreUnidad;
    private ArrayList<Empleado> empleadosAsignados;
    private Calendario calendario;
    
    /**
     * Constructor
     */
    public Unidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
        this.empleadosAsignados = new ArrayList<>();
        calendario = new Calendario();
    }
    
    public void crearCita(Paciente paciente, Unidad unidad, int horario){
        calendario.nuevaCita(paciente, unidad, horario);
    }
    
    public void agregarEmpleado(Empleado empleado) {
        empleadosAsignados.add(empleado);
    }
    
    public Calendario getCalendario(){
        return calendario;
    }
    
    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public ArrayList getEmpleadosAsignados() {
        return empleadosAsignados;
    }

}
