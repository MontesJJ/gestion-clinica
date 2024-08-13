
/**
 * Los sanitarios pueden ser médicos o enfermeras
 * Se distinguen del resto de empleados porque tienen citas programadas.
 * Las citas pueden ser: consultas externas, pruebas médicas, unidad médica especializada o paciente ingresado
 * También pueden tener asignados estudiantes.
 * Dentro de los sanitarios, la diferencia entre médicos y enfermeras es que los medicos tienen asignada una especialidad.
 * Además, las enfermeras no están asignadas a ninguna unidad en concreto.
 * He considerado que las consultas externas están formadas por dos medicos y dos enfermeras. Hay dos turno, de mañana y de tarde, de lunes a viernes. En cada turno hay un medico y una enfermera.
 */
public class Sanitarios extends Empleado
{
    private Especialidad especialidadAsignada;
    private Calendario calendario;

    /**
     * Constructor para la clase Iniciar, donde ya asignamos directamente la especialidad
     */
    public Sanitarios(Especialidad especialidadAsignada,Unidad unidadAsignada, String nombre, String telefono, String dni, int horario)
    {
        super(unidadAsignada, nombre, telefono, dni, horario);
        this.especialidadAsignada = especialidadAsignada;
        calendario = new Calendario();
    }      
    
    public Unidad getUnidad(){
        return unidadAsignada;
    }
    
    public void crearCita(Paciente paciente){
        calendario.nuevaCita(paciente, getUnidad());
    }
    
    public void imprimirCitas(){
        calendario.imprimirCitas();
    }

    
    
}
