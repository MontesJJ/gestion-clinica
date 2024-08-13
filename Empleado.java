
/**
 * La clase empleado es una subclase de Persona, de la que heredan una serie de caracteristicas comunes (datos personales).
 * Todos los empleados tienen que estar asignados a una unidad.
 */
public class Empleado extends Persona
{
    
    protected Unidad unidadAsignada;

    /**
     * Constructor, asignamos la unidad y heredamos los datos personales de la clase Persona
     */
    public Empleado(Unidad unidadAsignada, String nombre, String telefono, String dni)
    {
        super(nombre, telefono, dni);
        comprobarNombre(nombre);
        this.unidadAsignada = unidadAsignada;
        email = generarEmail(this.nombre) + "@hospital.es";
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
    
    public Unidad getUnidad(){
        return unidadAsignada;
    }
    
}
