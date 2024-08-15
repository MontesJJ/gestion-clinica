import java.util.ArrayList;
/**
 * Hay 90 habitaciones en el hospital. Al realizar un ingreso, hay que comprobar que haya alguna habitación libre. 
 * Por cada habitacion es necesario dejar constancia de los ingresos que se han producido en ella para poder determinar si cuando se quiere ingresar un nuevo paciente la habitación está libre.
 * Vamos a crear un arraylist de ingresos. Si el ultimo elemento del array list no tiene fecha de baja, quiere decir que la habitacion sigue ocupada.
 */
public class Habitacion {
    private ArrayList<Ingreso> ingresos;
    private int numeroHabitacion;
    
    /**
     * Constructor
     */
    public Habitacion(int numeroHabitacion) {
        ingresos = new ArrayList<>();
        this.numeroHabitacion = numeroHabitacion;
    }
    
    public boolean estaLibre() {
        
        if (ingresos.isEmpty()) {
            return true;
        }
        
        if (ingresos.get(ingresos.size() - 1).getBaja() != null) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Ingreso> getIngresos() {
        return ingresos;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }
}

