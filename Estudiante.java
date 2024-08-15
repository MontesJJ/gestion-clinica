import java.util.ArrayList;

/**
 * El estudiante se distingue de los otros objeto persona en que tiene una relacion de dependencia con el miembro del personal medico asignado
 */
public class Estudiante extends Persona
{
    
    private Unidad unidadAsignada;
    private Empleado sanitarioAsignado;
    private int horario;
    
    /**
     * Constructor
     */
    public Estudiante(String nombre, String telefono, String dni, Unidad unidad, Empleado sanitario, int horario)
    {
        super(nombre, telefono, dni);
        comprobarNombre(nombre);
        unidadAsignada = unidad;
        sanitarioAsignado = sanitario;
        this.horario = horario;
        email = generarEmail(nombre) + "@alumnos.hospital.es";
    }
    
    //Esta función la voy a usar para generar el correo del nuevo empleado, cogiendo la primera letra de su nombre y su primer apellido.
    public String generarEmail(String nombre){
        String alias="";
        int inicioApellido = 0;
        int finApellido = 0;
        boolean inicio = false;
        boolean fin = false;
        int i = 0;
        while(i<nombre.length() && !fin){
            if(nombre.charAt(i) == ' ' && !inicio){
                inicioApellido = i+1;
                inicio = true;
            }else if(nombre.charAt(i) == ' ' && inicio){
                finApellido = i;
                fin = true;
            }
            i++;
        }
        
        alias = Character.toLowerCase(nombre.charAt(0)) + nombre.substring(inicioApellido, finApellido).toLowerCase();
                
        return alias;        
    }
    
    public Empleado getSanitarioAsignado(){
        return sanitarioAsignado;
    }
    
}
