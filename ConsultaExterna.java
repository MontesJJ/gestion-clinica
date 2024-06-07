
/**
 * Nos va a servir para saber que, si el objeto unidad creado es de tipo ConsultaMedica, tenemos que crear un objeto Especialidad para el Sanitario.
 * He considerado que las consultas externas están formadas por dos medicos y dos enfermeras. Hay dos turno, de mañana y de tarde, de lunes a viernes. En cada turno hay un medico y una enfermera.
 */
public class ConsultaExterna extends Unidad
{

    /**
     * Constructor
     */
    public ConsultaExterna(String nombreUnidad)
    {
        super(nombreUnidad);
        
    }

}
