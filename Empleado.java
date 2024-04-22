
/**
 * La clase empleado es una subclase de Persona, de la que heredan una serie de caracteristicas comunes (datos personales).
 * Todos los empleados tienen que estar asignados a una unidad.
 */
public class Empleado extends Persona
{
    
    private Unidad unidadAsignada;

    /**
     * Constructor, asignamos la unidad y heredamos los datos personales de la clase Persona
     */
    public Empleado(Unidad unidadAsignada, String nombre, String telefono, String email)
    {
        super(nombre, telefono, email);
        this.unidadAsignada = unidadAsignada;
        
    }

    
}
