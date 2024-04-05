import java.util.ArrayList;
/**
 * Write a description of class BD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BD
{
    // instance variables - replace the example below with your own
    private ArrayList<Medicos> medicos;
    private ArrayList<Estudiantes> estudiantes;
    
    public BD(){
        
        estudiantes = new ArrayList<>();
        medicos = new ArrayList<>();
        
        Medicos medico1 = new Medicos("Javier Montes", 1);
        Medicos medico2 = new Medicos("Manolo García", 2);
        medicos.add(medico1);
        medicos.add(medico2);
        
        Estudiantes estudiante1 = new Estudiantes("Pedro", 1);
        Estudiantes estudiante2 = new Estudiantes("Alf", 2);
        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);
    }
    
    public void imprimirMedicos(){
        for(Medicos medico : medicos){
            System.out.println(medico);
        }
    }
    
    public void agregarMedico(Medicos medico){
        medicos.add(medico);
    }
}
