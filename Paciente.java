import java.util.ArrayList;
/**
 * El paciente, además de los atributos heredados de persona, va a tener otros como ingresos, seguros, pagos...
 * Tambien va a contar con un arraylist de objetos Expediente, donde se van a recoger todas las entradas del expediente.
 */
public class Paciente extends Persona
{
    
    private ArrayList<Expediente> expediente;

    /**
     * Constructor
     */
    public Paciente(String nombre, String telefono, String email)
    {
        super(nombre, telefono, email);
        
    }

    
}
