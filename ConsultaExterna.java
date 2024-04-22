
/**
 * Nos va a servir para saber que, si el objeto unidad creado es de tipo ConsultaMedica, tenemos que crear un objeto Especialidad para el Sanitario
 */
public class ConsultaExterna extends Unidad
{

    /**
     * Constructor
     */
    public ConsultaExterna(String nombreUnidad, String tipoUnidad)
    {
        super(nombreUnidad, tipoUnidad);
        
    }

}
