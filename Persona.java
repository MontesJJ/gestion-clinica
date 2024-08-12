import java.util.Scanner;
/**
 * Esta clase va a contener los datos personal comunes a todas las personas representadas en la práctica. Esta clase es abstracta, nunca se va a instanciar y va a contener un metodo abstracto
 */
public abstract class Persona
{
    private String nombre;
    private String telefono;
    protected String email;
    private String dni;

    /**
     * Constructor
     */
    public Persona(String nombre, String telefono, String dni)
    {
        this.nombre = nombre;
        this.telefono = telefono;
        this.dni = dni;        
    }

    public abstract String generarEmail(String nombre);
    
    public void comprobarNombre(String nombre){        
        Scanner sc = new Scanner(System.in);
        boolean nombreCompleto = false;
        String nombreC = nombre;
        
        while(!nombreCompleto){
            int espacios = 0;
            for(int i=0; i<nombreC.length(); i++){
                if(nombreC.charAt(i) == ' '){ 
                    espacios++;
                }
            }
            
            if(espacios == 0){
                System.out.println("VUELVE A INTRODUCIR EL NOMBRE COMPLETO DE LA PERSONA INCLUYENDO SUS DOS APELLIDOS");
                nombreC = sc.nextLine();
            }else if(espacios == 1){
                System.out.println("VUELVE A INTRODUCIR EL NOMBRE COMPLETO DE LA PERSONA INCLUYENDO SU SEGUNDO APELLIDO");
                nombreC = sc.nextLine();
            }else{
                nombreCompleto = true;
                this.nombre = nombreC;
            }
        }               
    }
    
   /* public void comprobarNombreCompleto(String nombre){
        Scanner sc = new Scanner(System.in);
        nombre = sc.nextLine();
        comprobarNombre(nombre);
    }
    */
    public String getNombre(){
        return nombre;
    }
    
}
