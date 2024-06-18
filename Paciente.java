import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.GregorianCalendar;
/**
 * El paciente, además de los atributos heredados de persona, va a tener otros como ingresos, seguros, pagos...
 * Tambien va a contar con un arraylist de objetos Expediente, donde se van a recoger todas las entradas del expediente.
 */
public class Paciente extends Persona
{
    
    private ArrayList<Expediente> expediente;
    private HashMap<GregorianCalendar, Unidad> citas;

    /**
     * Constructor
     */
    public Paciente(String nombre, String telefono, String email, String dni)
    {
        super(nombre, telefono, dni);
        email = generarEmail(nombre);
        citas = new HashMap<>();
    }
    
    public String generarEmail(String nombre){
        System.out.println("INDICA EL EMAIL DEL PACIENTE");
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        return email;
    }
    
    public void agregarCita(GregorianCalendar calendario, Unidad unidad){
        citas.put(calendario, unidad);
    }
    
}
