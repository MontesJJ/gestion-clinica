import java.util.Scanner; 
import java.util.ArrayList;
/**
 * Inicio de la aplicación. La clase Hospital va a contar con un ArrayList para cada una de las clases (Empleado, Estudiante, Paciente, Unidad, Habitación...).
 * Creamos un metodo "iniciar" para que la aplicacion arranque con datos.
 */

public class Hospital {
     
    private static GestionMedicos gestionMedicos;
    private static GestionPacientes gestionPacientes;
    protected static ArrayList<Unidad> unidades;
    protected static ArrayList<Empleado> empleados;
    
    public static void main(String[] args) {
        unidades = new ArrayList<>();
        empleados = new ArrayList<>();
        iniciar();
        Scanner scanner = new Scanner(System.in); 
        int option; 

        while (true) {
            
            System.out.println("+------------------------------------+");
            System.out.println("|          GESTIÓN HOSPITAL          |");
            System.out.println("+------------------------------------+");
            System.out.println("| [1]  Gestión Empleados             |");
            System.out.println("| [2]  Gestión Pacientes             |");
            System.out.println("| [3]  Gestión Estudiantes           |");
            System.out.println("| [4]  Habitaciones                  |");
            System.out.println("| [5]  Administración                |");
            System.out.println("| [6]  Mantenimiento                 |");
            System.out.println("| [7]  Facturación                   |");
            System.out.println("| [8]  Salir                         |");
            System.out.println("+------------------------------------+");
            System.out.print("Elige una opción (1-8): ");

            // Validamos la entrada del usuario
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); 
                System.out.print("Elige una opción (1-8): ");
            }
            option = scanner.nextInt(); 
            
            switch (option) {
                case 1:
                    System.out.println("Has elegido 'Empleados'");
                    System.out.print('\u000C');
                    String[] argsPrimero = {"arg1", "arg2"};
                    GestionMedicos.main(argsPrimero);
                    
                    break;
                case 2:
                    System.out.println("Has elegido 'Gestión Pacientes'");
                    System.out.print('\u000C');
                    gestionPacientes = new GestionPacientes();
                    gestionPacientes.iniciarMenu();
                    
                    break;
                case 3:
                    System.out.println("Has elegido 'Gestión Estudiantes'");
                    
                    break;
                case 4:
                    System.out.println("Has elegido 'Habitaciones'");
                    
                    break;
                case 5:
                    System.out.println("Has elegido 'Administración'");
                    
                    break;
                case 6:
                    System.out.println("Has elegido 'Mantenimiento'");
                    
                    break;
                case 7:
                    System.out.println("Has elegido 'Facturación'");
                    
                    break;
                case 8:
                    System.out.println("Gracias. ¡Hasta la próxima!");
                    scanner.close(); 
                    System.out.print('\u0017'); //BUSCAR UNICODE PARA SIMULAR CTRL+W
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elige entre 1 y 8.");
            }
        }
    }
    
    public static void iniciar(){
        //Alta de unidades
        Unidad administracion = new Unidad("Administración");
        unidades.add(administracion);
        Unidad hospitalizacion = new Unidad("Hospitalización");
        unidades.add(hospitalizacion);
        Unidad pruebasMedicas= new Unidad("Pruebas médicas");
        unidades.add(pruebasMedicas);
        Unidad umeDiabetes = new Unidad("Unidad médica especializada de diabetes");
        unidades.add(umeDiabetes);
        Unidad umeCardio = new Unidad("Unidad médica especializada de enfermedades cardiovasculares");
        unidades.add(umeCardio);
        Unidad urgencias = new Unidad("Urgencias");
        unidades.add(urgencias);
        Unidad cafeteria = new Unidad("Cafetería");
        unidades.add(cafeteria);
        Unidad uci = new Unidad("UCI");
        unidades.add(uci);
        Unidad formacion = new Unidad("Unidad de formación");
        unidades.add(formacion);
        Unidad aparcamiento = new Unidad("Aparcamiento");
        unidades.add(aparcamiento);
        
        //Alta de consultas externas
        /**Unidad digestivo = new ConsultaExterna("Aparato digestivo");
        *unidades.add(digestivo);
        *Unidad cardiologia = new ConsultaExterna("Cardiología");
        *unidades.add(cardiologia);
        *
        *Unidad cirugiaGeneral = new ConsultaExterna("Cirugía general");
        *unidades.add(cirugiaGeneral);
        
        Unidad derma = new ConsultaExterna("Dermatología");
        unidades.add(derma);
        */
        Unidad medicinaInterna = new ConsultaExterna("Medicina interna");
        unidades.add(medicinaInterna);
        Unidad oncologia = new ConsultaExterna("Oncología");
        unidades.add(oncologia);
        Unidad oftalmologia = new ConsultaExterna("Oftalmología");
        unidades.add(oftalmologia);
        Unidad psico = new ConsultaExterna("Psiquiatría");
        unidades.add(psico);
        Unidad trauma = new ConsultaExterna("Traumatología");
        unidades.add(trauma);
        Unidad consultasExternas = new Unidad("Consultas externas");
        unidades.add(consultasExternas);
        
        //Alta especialidades
        Especialidad aparatoDigestivo = new Especialidad("Aparato digestivo");
        Especialidad cardiologia = new Especialidad("Cardiología");
        Especialidad cirugiaGeneral = new Especialidad("Cirugia general");
        Especialidad dermatologia = new Especialidad("Dermatología");
        //Alta empleados
        
            // Administración
            Empleado jmontes = new Nosanitarios(administracion, "Javier Montes Ganuza", "612845652", "12345678A");
            empleados.add(jmontes);
            Empleado mlara = new Nosanitarios(administracion, "María Lara Ortega", "658741529", "23456789B");
            empleados.add(mlara);
            Empleado avazquez = new Nosanitarios(administracion, "Antonio Vázquez Pérez", "655758322", "34567890C");
            empleados.add(avazquez);
            
            // Hospitalización
            Empleado lgomez = new Nosanitarios(hospitalizacion, "Laura Gómez García", "665405516", "78901234G");
            empleados.add(lgomez);
            Empleado rperez = new Nosanitarios(hospitalizacion, "Roberto Pérez Martínez", "686997422", "89012345H");
            empleados.add(rperez);
            Empleado acortes = new Nosanitarios(hospitalizacion, "Ana Cortés Sánchez", "632198777", "90123456I");
            empleados.add(acortes);
            
            // Pruebas médicas
            Empleado jlopez = new Nosanitarios(pruebasMedicas, "Julia López Navarro", "644956215", "01234567J");
            empleados.add(jlopez);
            Empleado rramirez = new Nosanitarios(pruebasMedicas, "Ricardo Ramírez Ortega", "633459675", "12345678K");
            empleados.add(rramirez);
            Empleado bsanchez = new Nosanitarios(pruebasMedicas, "Beatriz Sánchez Díaz", "650252500", "23456789L");
            empleados.add(bsanchez);
            
            // Unidades médicas especializadas - Diabetes
            Empleado amartinez = new Empleado(umeDiabetes, "Alberto Martínez Hidalgo", "605447712", "34567890M");
            empleados.add(amartinez);
            Empleado mestrada = new Empleado(umeDiabetes, "Marta Estrada Jiménez", "611364500", "45678901N");
            empleados.add(mestrada);
            Empleado dperez = new Empleado(umeDiabetes, "Daniel Pérez Fernández", "612345678", "56789012O");
            empleados.add(dperez);
            
            // Unidades médicas especializadas - Enfermedades cardiovasculares
            Empleado pgarcia = new Empleado(umeCardio, "Patricia García López", "665854421", "67890123P");
            empleados.add(pgarcia);
            Empleado jsantos = new Empleado(umeCardio, "Jorge Santos Gil", "633258415", "78901234Q");
            empleados.add(jsantos);
            Empleado vflores = new Empleado(umeCardio, "Victoria Flores Martín", "635997854", "89012345R");
            empleados.add(vflores);
            
            // Urgencias
            Empleado pfernandez = new Empleado(urgencias, "Pablo Fernández Torres", "644587532", "90123456S");
            empleados.add(pfernandez);
            Empleado asuarez = new Empleado(urgencias, "Alicia Suárez Rodríguez", "622456789", "01234567T");
            empleados.add(asuarez);
            Empleado jmendez = new Empleado(urgencias, "José Méndez Serrano", "625241012", "12345678U");
            empleados.add(jmendez);
            
            // UCI
            Empleado msantos = new Empleado(uci, "Marcos Santos Gil", "639128541", "23456789V");
            empleados.add(msantos);
            Empleado ejimenez = new Empleado(uci, "Elena Jiménez Vega", "620820911", "34567890W");
            empleados.add(ejimenez);
            Empleado jortega = new Empleado(uci, "Javier Ortega Ramos", "613551001", "45678901X");
            empleados.add(jortega);
            
            // Unidad de formación
            Empleado mlopez = new Nosanitarios(formacion, "Mónica López Ramírez", "614482561", "56789012Y");
            empleados.add(mlopez);
            Empleado gmora = new Nosanitarios(formacion, "Gonzalo Mora Ruiz", "683725811", "67890123Z");
            empleados.add(gmora);
            Empleado smoreno = new Nosanitarios(formacion, "Sara Moreno Blanco", "600521458", "78901234A");
            empleados.add(smoreno);
            
            // Cafetería
            Empleado jdominguez = new Nosanitarios(cafeteria, "Javier Domínguez Sanz", "645842566", "89012345B");
            empleados.add(jdominguez);
            Empleado ymartinez = new Nosanitarios(cafeteria, "Yolanda Martínez Vázquez", "620961024", "90123456C");
            empleados.add(ymartinez);
            Empleado fgarcia = new Nosanitarios(cafeteria, "Fernando García Herrero", "628071991", "01234567D");
            empleados.add(fgarcia);
            
            // Aparcamiento
            Empleado pblanco = new Nosanitarios(aparcamiento, "Pilar Blanco Pérez", "614022552", "12345678E");
            empleados.add(pblanco);
            Empleado jhernandez = new Nosanitarios(aparcamiento, "Juan Hernández Ruiz", "6317557558", "23456789F");
            empleados.add(jhernandez);
            Empleado aramirez = new Nosanitarios(aparcamiento, "Alba Ramírez Gómez", "654321012", "34567890G");
            empleados.add(aramirez);
            
            // Consultas externas - Aparato digestivo
            Empleado rcano = new Sanitarios(aparatoDigestivo, consultasExternas, "Raúl Cano Fernández", "614022552", "45678901D");
            empleados.add(rcano);
            aparatoDigestivo.agregarSanitario(rcano);
            Empleado mgarcia = new Sanitarios(aparatoDigestivo, consultasExternas, "Marta García López", "651195325", "56789012E");
            empleados.add(mgarcia);
            aparatoDigestivo.agregarSanitario(mgarcia);
            
            // Consultas externas - Cardiología
            Empleado ccano = new Sanitarios(cardiologia, consultasExternas,"Carlos Cano Jiménez", "633325123", "78901234G");
            empleados.add(ccano);
            cardiologia.agregarSanitario(ccano);
            Empleado agomez = new Sanitarios(cardiologia, consultasExternas,"Ana Gómez Fernández", "665405510", "89012345H");
            empleados.add(agomez);
            cardiologia.agregarSanitario(agomez);
            
            // Consultas externas - Cirugía general
            Empleado mleon = new Sanitarios(cirugiaGeneral, consultasExternas, "Miguel Leon Sánchez", "665551156", "01234567J");
            empleados.add(mleon);
            cirugiaGeneral.agregarSanitario(mleon);
            Empleado agracia = new Sanitarios(cirugiaGeneral, consultasExternas, "Antonio García Herrera", "633277156", "23456789L");
            empleados.add(agracia);
            cirugiaGeneral.agregarSanitario(agracia);
            
            // Consultas externas - Dermatología
            Empleado lmartin = new Sanitarios(dermatologia, consultasExternas, "Laura Martín Rodríguez", "625435510", "34567890M");
            empleados.add(lmartin);
            dermatologia.agregarSanitario(lmartin);
            Empleado nhernandez = new Sanitarios(dermatologia, consultasExternas, "Nuria Hernández Gómez", "645750591", "45678901N");
            empleados.add(nhernandez);
            dermatologia.agregarSanitario(nhernandez);

            
            // Consultas externas - Medicina Interna
            Empleado dsantos = new Empleado(medicinaInterna, "Daniel Santos Gil", "645256256", "67890123P");
            empleados.add(dsantos);
            Empleado Fmora = new Empleado(medicinaInterna, "Francisco Mora Robles", "695252500", "78901234Q");
            empleados.add(Fmora);
            Empleado saragon = new Empleado(medicinaInterna, "Sara Aragon Blanco", "628458891", "89012345R");
            empleados.add(saragon);
            
            // Consultas externas - Oncología
            Empleado jpardo = new Empleado(oncologia, "José Pardo Fernández", "631100891", "90123456S");
            empleados.add(jpardo);
            Empleado amarquez = new Empleado(oncologia, "Ana Márquez Pérez", "645055010", "01234567T");
            empleados.add(amarquez);
            Empleado rmendez = new Empleado(oncologia, "Raúl Méndez Serrano", "651193425", "12345678U");
            empleados.add(rmendez);
            
            // Consultas externas - Oftalmología
            Empleado sblanco = new Empleado(oftalmologia, "Silvia Blanco Ramírez", "633395325", "23456789V");
            empleados.add(sblanco);
            Empleado jprieto = new Empleado(oftalmologia, "Jorge Prieto Ortega", "652595344", "34567890W");
            empleados.add(jprieto);
            Empleado yramirez = new Empleado(oftalmologia, "Yolanda Ramírez Díaz", "686145789", "45678901X");
            empleados.add(yramirez);
            
            // Consultas externas - Psiquiatría
            Empleado fserrano = new Empleado(psico, "Francisco Serrano López", "648159753", "56789012Y");
            empleados.add(fserrano);
            Empleado amarina = new Empleado(psico, "Alicia Marina Vega", "665444789", "67890123Z");
            empleados.add(amarina);
            Empleado rmolina = new Empleado(psico, "Ricardo Molina Sánchez", "632554419", "78901234A");
            empleados.add(rmolina);
            
            // Consultas externas - Traumatología
            Empleado hbermejo = new Sanitarios(trauma, "Héctor Bermejo Hernández", "601223587", "89012345B");
            empleados.add(hbermejo);
            Empleado ogutierrez = new Empleado(trauma, "Olga Gutiérrez Sanz", "632258852", "90123456C");
            empleados.add(ogutierrez);
            Empleado mdominguez = new Empleado(trauma, "Marcos Domínguez Moya", "615546456", "01234567D");
            empleados.add(mdominguez);

            //Alta enfermeros
            Empleado mreyes = new Sanitarios(null, consultasExternas, "María Reyes Sánchez", "658678458", "73299333K");
            empleados.add(mreyes);
            Empleado jperez = new Sanitarios(null, consultasExternas, "Juan  Pérez Ruiz", "642541112", "67890123F");
            empleados.add(jperez);
            Empleado psancho = new Sanitarios(null, consultasExternas, "Paula Sancho Rey", "672571199", "77890333F");
            empleados.add(psancho);
            Empleado vfernandez = new Sanitarios(null, consultasExternas,"Verónica Fernández Martínez", "633221156", "90123456I");
            empleados.add(vfernandez);
            Empleado escobar = new Sanitarios(null, consultasExternas, "Elena Escobar Pérez", "611560110", "12345678K");
            empleados.add(escobar);
            Empleado jmoreno = new Sanitarios(null, consultasExternas, "Jorge Moreno Gil", "658578366", "56789012O");
            empleados.add(jmoreno);
    
    }
    
}


