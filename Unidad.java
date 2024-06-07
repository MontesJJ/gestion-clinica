import java.util.ArrayList;
/**
 * Estas son las unidades del hospital. Por defecto, vamos a considerar que las enfermeras no estan asignadas a ninguna unidad, pondremos valor "null".
 * Hay 10 unidades: Administración, consultas externas, hospitalización, pruebas médicas, unidades médicas especializadas, urgencias,UCI, unidad de formación, cafetería y aparcamiento.
 */
public class Unidad
{
    
    private String nombreUnidad;
    private ArrayList<Empleado> empleadosAsignados;

    /**
     * Constructor
     */
    public Unidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
        this.empleadosAsignados = new ArrayList<>();
    }
    
    
    public void agregarEmpleado(Empleado empleado) {
        empleadosAsignados.add(empleado);
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public ArrayList getEmpleadosAsignados() {
        return empleadosAsignados;
    }

}
