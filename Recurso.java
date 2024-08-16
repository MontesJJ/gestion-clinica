

public class Recurso{
    private String nombre;
    private Empleado tecnico;

    public Recurso(String nombre){
        this.nombre = nombre;
        this.tecnico = null;
    }

    public String getNombre(){
        return nombre;
    }

    public void setTecnico(Empleado tecnico){
        this.tecnico = tecnico;
    }

    public Empleado getTecnico(){
        return tecnico;
    }
}

