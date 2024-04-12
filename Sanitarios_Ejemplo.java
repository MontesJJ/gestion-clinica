import java.util.ArrayList;
/**
 * Write a description of class Sanitarios here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sanitarios_Ejemplo
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Calendario calendario;
    
    public Sanitarios_Ejemplo(String nombre){
        this.nombre = nombre;
        calendario = new Calendario();
    }
    
    public void crearCita(){
        calendario.nuevaCita();
    }
}
