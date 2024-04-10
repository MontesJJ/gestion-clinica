import java.util.ArrayList;
/**
 * Write a description of class Sanitarios here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sanitarios
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Calendario calendario;
    
    public Sanitarios(String nombre){
        this.nombre = nombre;
        calendario = new Calendario();
    }
    
    public void crearCita(){
        calendario.nuevaCita();
    }
}
