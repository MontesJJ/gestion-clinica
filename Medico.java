import java.util.ArrayList;
/**
 * Write a description of class Medicos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medico
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private ArrayList<String> horario;
    private Estudiante estudianteAsignado;
    
    public Medico(int id, String name, Estudiante estudianteAsignado){
        this.id = id;
        this.name = name;
        this.estudianteAsignado = estudianteAsignado;
        horario = new ArrayList<>();
    }
    
    public String getName(){
        return name;
    }
    
    public Estudiante getEstudiante(){
        return estudianteAsignado;
    }
    
}
