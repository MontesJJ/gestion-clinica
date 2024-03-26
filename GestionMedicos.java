import java.util.ArrayList;
/**
 * Write a description of class GestionMedicos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestionMedicos
{
    // instance variables - replace the example below with your own
    private ArrayList<Medico> medicos;
    private GestionEstudiantes estudiantes;
    public GestionMedicos(){
        medicos = new ArrayList<>();
        estudiantes = new GestionEstudiantes();
        medicos.add(new Medico(1, "Javier", estudiantes.getEstudiante(0)));
        medicos.add(new Medico(1, "Montes", estudiantes.getEstudiante(1)));
    }
    
    public void addMedico(int id, String name, Estudiante estudianteAsignado){
        medicos.add(new Medico(id, name, estudianteAsignado));
    }
    
    public void imprimirListaMedicos(){
        for(Medico medico : medicos){
            System.out.println(medico.getName() + " | Estudiante asignado: " + medico.getEstudiante().getName());
        }
    }
    
}
