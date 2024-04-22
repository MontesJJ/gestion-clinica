import java.util.ArrayList;
/**
 * La clase especialidad hace referencia a la especialidad médica. Los sanitarios serán asignados a una especialidad médica cuando su unidad sea "Consultas externas".
 * Las especialidades médicas son: Aparato digestivo, cardiología, cirugía general, dermatología, medicina interna, oncología, oftalmología, psquiatría y traumatología.
 */
public class Especialidad
{
    private String nombreEspecialidad;
    private ArrayList<Sanitarios> sanitariosAsignados;
    /**
     * Constructor
     */
    public Especialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
        sanitariosAsignados = new ArrayList<>();
    }
    
    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }
    

}
