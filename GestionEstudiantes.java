import java.util.ArrayList;
/**
 * Write a description of class GestionEstudiantes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestionEstudiantes
{
    // instance variables - replace the example below with your own
    private ArrayList<Estudiante> estudiantes;
    
    public GestionEstudiantes(){
        estudiantes = new ArrayList<>();
        Estudiante Estudiante1 = new Estudiante("Pedro");
        Estudiante Estudiante2 = new Estudiante("Maria");
        estudiantes.add(Estudiante1);
        estudiantes.add(Estudiante2);
    }
    
    public Estudiante getEstudiante(int index){
        return estudiantes.get(index);
    }
    
}
