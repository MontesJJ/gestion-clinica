
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
    private Cita citas;

    /**
     * Constructor para la clase Iniciar, donde ya asignamos directamente la especialidad
     */
    public Sanitarios(Especialidad especialidadAsignada,Unidad unidadAsignada, String nombre, String telefono, String dni)
    {
        super(unidadAsignada, nombre, telefono, dni);
        this.especialidadAsignada = especialidadAsignada;
    }
    
    
    /**
     * Constructor para dar de alta manualmente un nuevo usuario
     */
    public Sanitarios(Unidad unidadAsignada, String nombre, String telefono, String email)
    {
        super(unidadAsignada, nombre, telefono, email);
        if(unidadAsignada instanceof ConsultaExterna){
            asignarEspecialidad();
        }else{
            especialidadAsignada = null;
        }
    }
    
    public Especialidad asignarEspecialidad(){
        
        //Aqui tenemos que crear un metodo que pregunte cual es la especialidad asignada preguntando al user por teclado
        
        return null;
    }

    
    
}
