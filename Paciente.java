import java.util.ArrayList;
import java.util.HashMap;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;

/**
 * El paciente, además de los atributos heredados de persona, va a tener otros como ingresos, seguros, pagos...
 * También va a contar con un ArrayList de objetos Expediente, donde se van a recoger todas las entradas del expediente.
 */
public class Paciente extends Persona {
    
    private Calendario calendario;
    private ArrayList<Expediente> expediente;
    private ArrayList<Cita> citas;
    private boolean seguroPrivado;

    /**
     * Constructor
     */
    public Paciente(String nombre, String telefono, String email, String dni, boolean seguro) {
        super(nombre, telefono, dni);
        this.email = email;
        this.seguroPrivado = seguro;
        this.citas = new ArrayList<>();
        this.expediente = new ArrayList<>(); 
    }
    
    public String generarEmail(String nombre){
        System.out.println("INDICA EL EMAIL DEL PACIENTE");
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        return email;
    }
    
    public void agregarCita(Cita cita){
        citas.add(cita);
    }

    
    public void agregarEntradaExpediente(String textoEntrada, Unidad unidad) {
        Expediente nuevoExpediente = new Expediente(unidad);
        nuevoExpediente.setEntrada(textoEntrada); 
        expediente.add(nuevoExpediente); 
        System.out.println("Nueva entrada añadida el " + nuevoExpediente.getFechaFormateada());
    }

    
    public void mostrarExpediente() {
        if (expediente.isEmpty()) {
            System.out.println("No hay entradas en el expediente.");
        } else {
            for (int i = 0; i < expediente.size(); i++) {
                Expediente exp = expediente.get(i);
                System.out.println("Entrada " + (i + 1) + " | " + exp.getFechaFormateada() + " | " + "Unidad: " + expediente.get(i).getUnidad() + " | " + exp.getEntrada());
            }
        }
    }
    
    public void imprimirCitas(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        for(Cita cita : citas){
            if(cita.getUnidad().getNombreUnidad().equals("Consultas externas")){
                System.out.println("[" + cita.getUnidad().getNombreUnidad() + ": Departamento de " + cita.getEspecialidad().getNombreEspecialidad() + "] " + sdf.format(cita.getFecha().getTime()));
            }else{
                System.out.println("[" + cita.getUnidad().getNombreUnidad() + "] " + sdf.format(cita.getFecha().getTime()));
            }
        }
    }
}
