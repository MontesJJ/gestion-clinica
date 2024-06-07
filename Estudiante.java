
/**
 * El estudiante se distingue de los otros objeto persona en que tiene una relacion de dependencia con el miembro del personal medico asignado
 */
public class Estudiante extends Persona
{


    /**
     * Constructor
     */
    public Estudiante(String nombre, String telefono, String dni)
    {
        super(nombre, telefono, dni);
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
    
}
