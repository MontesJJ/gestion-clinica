
/**
 * Los empleados no sanitarios, al igual que los sanitarios, estan asignados a una unidad.
 */
public class Nosanitarios extends Empleado
{

    /**
     * Constructor
     */
    public Nosanitarios(Unidad unidadAsignada, String nombre, String telefono, String email)
    {
        super(unidadAsignada, nombre, telefono, email);
    }

}
