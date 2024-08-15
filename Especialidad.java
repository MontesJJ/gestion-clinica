import java.util.ArrayList;
/**
 * La clase especialidad hace referencia a la especialidad médica. Los sanitarios serán asignados a una especialidad médica cuando su unidad sea "Consultas externas".
 * Las especialidades médicas son: Aparato digestivo, cardiología, cirugía general, dermatología, medicina interna, oncología, oftalmología, psquiatría y traumatología.
 */
public class Especialidad
{
    private String nombreEspecialidad;
    protected ArrayList<Empleado> sanitariosAsignados;
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
    
    public void agregarSanitario(Empleado sanitario){
        sanitariosAsignados.add(sanitario);
    }
    
    public void printSanitariosAsignados(){
        int index = 1;
        for(Empleado sanitario : sanitariosAsignados){
            System.out.println("[" + index + "] " + sanitario.getNombreEmpleado());
            index++;
        }
    }
    
    public ArrayList getSanitariosAsignados(){
        return sanitariosAsignados;
    }

}
