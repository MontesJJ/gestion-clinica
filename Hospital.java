import java.util.Scanner; 
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Inicio de la aplicación. La clase Hospital va a contar con un ArrayList para cada una de las clases (Empleado, Estudiante, Paciente, Unidad, Habitación...).
 * Creamos un metodo "iniciar" para que la aplicacion arranque con datos.
 */

public class Hospital {
    
    private static GestionEmpleados gestionEmpleados;
    private static GestionEstudiantes gestionEstudiantes;
    private static GestionMedicos gestionMedicos;
    private static GestionPacientes gestionPacientes;
    protected static ArrayList<Unidad> unidades;
    protected static ArrayList<Empleado> empleados;
    protected static ArrayList<Especialidad> especialidades;
    protected static ArrayList<Estudiante> estudiantes;
    protected static HashMap<Integer, String> horarios;
    
    public static void main(String[] args) {
        unidades = new ArrayList<>();
        empleados = new ArrayList<>();
        especialidades = new ArrayList<>();
        estudiantes = new ArrayList<>();
        horarios = new HashMap<>();
        iniciar();
        Scanner scanner = new Scanner(System.in); 
        int option; 

        while (true) {
            
            System.out.println("+------------------------------------+");
            System.out.println("|          GESTIÓN HOSPITAL          |");
            System.out.println("+------------------------------------+");
            System.out.println("| [1]  Gestión Empleados             |");
            System.out.println("| [2]  Gestión Estudiantes           |");
            System.out.println("| [3]  Gestión Pacientes             |");
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
                    System.out.println("Has elegido 'Gestion Empleados'");
                    System.out.print('\u000C');
                    gestionEmpleados = new GestionEmpleados();
                    gestionEmpleados.iniciarMenu();                    
                    
                    break;
                case 2:
                    System.out.println("Has elegido 'Gestión Estudiantes'");
                    System.out.print('\u000C');
                    gestionEstudiantes = new GestionEstudiantes();
                    gestionEstudiantes.iniciarMenu();
                    
                    break;
                case 3:
                    System.out.println("Has elegido 'Gestión Empleados'");
                    System.out.print('\u000C');
                    String[] argEmpleados = {};
                    GestionMedicos.main(argEmpleados);

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
                    System.out.print('\u000C');
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
        Unidad consultasExternas = new Unidad("Consultas externas");
        unidades.add(consultasExternas);
        Unidad urgencias = new Unidad("Urgencias");
        unidades.add(urgencias);
        Unidad uci = new Unidad("UCI");
        unidades.add(uci);
        Unidad cafeteria = new Unidad("Cafetería");
        unidades.add(cafeteria);
        Unidad formacion = new Unidad("Unidad de formación");
        unidades.add(formacion);
        Unidad aparcamiento = new Unidad("Aparcamiento");
        unidades.add(aparcamiento);

        
        //Alta especialidades
        Especialidad aparatoDigestivo = new Especialidad("Aparato digestivo");
        especialidades.add(aparatoDigestivo);
        Especialidad cardiologia = new Especialidad("Cardiología");
        especialidades.add(cardiologia);
        Especialidad cirugiaGeneral = new Especialidad("Cirugia general");
        especialidades.add(cirugiaGeneral);
        Especialidad dermatologia = new Especialidad("Dermatología");
        especialidades.add(dermatologia);
        Especialidad medicinaInterna = new Especialidad("Medicina interna");
        especialidades.add(medicinaInterna);
        Especialidad oncologia = new Especialidad("Oncología");
        especialidades.add(oncologia);
        Especialidad oftalmologia = new Especialidad("Oftalmología");
        especialidades.add(oftalmologia);
        Especialidad psiquiatria = new Especialidad("Psiquiatría");
        especialidades.add(psiquiatria);
        Especialidad traumatologia = new Especialidad("Traumatología");
        especialidades.add(traumatologia);
        Especialidad endocrino = new Especialidad("Endocrinología");
        especialidades.add(endocrino);
        Especialidad medicinaGeneral = new Especialidad("Medicina General");
        especialidades.add(medicinaGeneral);
        
        //Alta empleados
        
            // Administración
            Empleado jmontes = new Nosanitarios(administracion, "Javier Montes Ganuza", "612845652", "12345678A", 1);
            empleados.add(jmontes);
            Empleado mlara = new Nosanitarios(administracion, "María Lara Ortega", "658741529", "23456789B", 1);
            empleados.add(mlara);
            Empleado sgomez = new Nosanitarios(administracion, "Sara Gómez Pérez", "655701321", "11567894F", 2);
            empleados.add(sgomez);
            Empleado avazquez = new Nosanitarios(administracion, "Antonio Vázquez Pérez", "655758322", "34567890C", 2);
            empleados.add(avazquez);
            
            // Hospitalización
            Empleado lpomez = new Nosanitarios(hospitalizacion, "Laura Pómez García", "665405516", "78901234G", 1);
            empleados.add(lpomez);
            Empleado rperez = new Nosanitarios(hospitalizacion, "Roberto Pérez Martínez", "686997422", "89012345H", 3);
            empleados.add(rperez);
            Empleado acortes = new Nosanitarios(hospitalizacion, "Ana Cortés Sánchez", "632198777", "90123456I", 4);
            empleados.add(acortes);
            Empleado mgarcia = new Nosanitarios(hospitalizacion, "María García Pérez", "612345678", "34567890M", 5);
            empleados.add(mgarcia);
            Empleado jduran = new Nosanitarios(hospitalizacion, "Javier Durán López", "622233445", "45678901N", 6);
            empleados.add(jduran);

            // Pruebas médicas
            Empleado jlopez = new Nosanitarios(pruebasMedicas, "Julia López Navarro", "644956215", "01234567J", 1);
            empleados.add(jlopez);
            Empleado rramirez = new Nosanitarios(pruebasMedicas, "Ricardo Ramírez Ortega", "633459675", "12345678K", 3);
            empleados.add(rramirez);
            Empleado bsanchez = new Nosanitarios(pruebasMedicas, "Beatriz Sánchez Díaz", "650252500", "23456789L", 4);
            empleados.add(bsanchez);
            Empleado aflores = new Nosanitarios(pruebasMedicas, "Antonio Flores Ruiz", "689112233", "67890123P", 5);
            empleados.add(aflores);
            Empleado lmartin = new Nosanitarios(pruebasMedicas, "Laura Martín Sánchez", "699223344", "78901234Q", 6);
            empleados.add(lmartin);
            
            // Unidades médicas especializadas - Diabetes
            Empleado amartinez = new Sanitarios(endocrino, umeDiabetes, "Alberto Martínez Hidalgo", "605447712", "34567890M", 1);
            empleados.add(amartinez);
            Empleado mestrada = new Sanitarios(endocrino, umeDiabetes, "Marta Estrada Jiménez", "611364500", "45678901N", 2);
            empleados.add(mestrada);
            
            // Unidades médicas especializadas - Enfermedades cardiovasculares
            Empleado pgarcia = new Sanitarios(cardiologia, umeCardio, "Patricia García López", "665854421", "67890123P", 1);
            empleados.add(pgarcia);
            Empleado jsantos = new Sanitarios(cardiologia, umeCardio, "Jorge Santos Gil", "633258415", "78901234Q", 2);
            empleados.add(jsantos);

            
            // Urgencias
            Empleado pfernandez = new Sanitarios(medicinaGeneral, urgencias, "Pablo Fernández Torres", "644587532", "90123456S", 1);
            empleados.add(pfernandez);
            Empleado asuarez = new Sanitarios(medicinaGeneral, urgencias, "Alicia Suárez Rodríguez", "622456789", "01234567T", 3);
            empleados.add(asuarez);
            Empleado jmendez = new Sanitarios(medicinaGeneral, urgencias, "José Méndez Serrano", "625241012", "12345678U", 4);
            empleados.add(jmendez);
            Empleado dperez = new Sanitarios(medicinaGeneral, umeDiabetes, "Daniel Pérez Fernández", "612345678", "56789012O", 5);
            empleados.add(dperez);
            Empleado vflores = new Sanitarios(medicinaGeneral, umeCardio, "Victoria Flores Martín", "635997854", "89012345R", 6);
            empleados.add(vflores);
            
            // UCI
            Empleado msantos = new Sanitarios(medicinaInterna, uci, "Marcos Santos Gil", "639128541", "23456789V", 1);
            empleados.add(msantos);
            Empleado ejimenez = new Sanitarios(medicinaInterna, uci, "Elena Jiménez Vega", "620820911", "34567890W", 3);
            empleados.add(ejimenez);
            Empleado jortega = new Sanitarios(medicinaInterna, uci, "Javier Ortega Ramos", "613551001", "45678901X", 4);
            empleados.add(jortega);
            Empleado jtorres = new Sanitarios(medicinaInterna, uci, "Jorge Torres García", "655334455", "89012345R", 5);
            empleados.add(jtorres);            
            Empleado mrodriguez = new Sanitarios(medicinaInterna, uci, "Miguel Rodríguez López", "661445566", "90123456S", 6);
            empleados.add(mrodriguez);
            
            // Unidad de formación
            Empleado mlopez = new Nosanitarios(formacion, "Mónica López Ramírez", "614482561", "56789012Y", 1);
            empleados.add(mlopez);
            Empleado gmora = new Nosanitarios(formacion, "Gonzalo Mora Ruiz", "683725811", "67890123Z", 2);
            empleados.add(gmora);

            
            // Cafetería
            Empleado jdominguez = new Nosanitarios(cafeteria, "Javier Domínguez Sanz", "645842566", "89012345B", 1);
            empleados.add(jdominguez);
            Empleado ymartinez = new Nosanitarios(cafeteria, "Yolanda Martínez Vázquez", "620961024", "90123456C", 3);
            empleados.add(ymartinez);
            Empleado fgarcia = new Nosanitarios(cafeteria, "Fernando García Herrero", "628071991", "01234567D", 4);
            empleados.add(fgarcia);
            Empleado mgomez = new Nosanitarios(cafeteria, "Marta Gómez Fernández", "622334455", "23456789E", 5);
            empleados.add(mgomez);
            Empleado sperez = new Nosanitarios(cafeteria, "Sofía Pérez Sánchez", "633445566", "34567890F", 6);
            empleados.add(sperez);
            
            // Aparcamiento
            Empleado pblanco = new Nosanitarios(aparcamiento, "Pilar Blanco Pérez", "614022552", "12345678E", 1);
            empleados.add(pblanco);
            Empleado jhernandez = new Nosanitarios(aparcamiento, "Juan Hernández Ruiz", "6317557558", "23456789F", 3);
            empleados.add(jhernandez);
            Empleado aramirez = new Nosanitarios(aparcamiento, "Alba Ramírez Gómez", "654321012", "34567890G", 4);
            empleados.add(aramirez);
            empleados.add(aramirez);Empleado lmoreno = new Nosanitarios(aparcamiento, "Luis Moreno Díaz", "661234567", "56789012H", 5);
            empleados.add(lmoreno);            
            Empleado mperez = new Nosanitarios(aparcamiento, "Miguel Pérez García", "672345678", "67890123I", 6);
            empleados.add(mperez);
            
            // Consultas externas - Aparato digestivo
            Empleado rcano = new Sanitarios(aparatoDigestivo, consultasExternas, "Raúl Cano Fernández", "614022552", "45678901D", 1);
            empleados.add(rcano);
            aparatoDigestivo.agregarSanitario(rcano);
            Empleado mgallina = new Sanitarios(aparatoDigestivo, consultasExternas, "Marta Gallina López", "651195325", "56789012E", 2);
            empleados.add(mgallina);
            aparatoDigestivo.agregarSanitario(mgallina);
            
            // Consultas externas - Cardiología
            Empleado ccano = new Sanitarios(cardiologia, consultasExternas,"Carlos Cano Jiménez", "633325123", "78901234G", 1);
            empleados.add(ccano);
            cardiologia.agregarSanitario(ccano);
            Empleado agomez = new Sanitarios(cardiologia, consultasExternas,"Ana Gómez Fernández", "665405510", "89012345H", 2);
            empleados.add(agomez);
            cardiologia.agregarSanitario(agomez);
            
            // Consultas externas - Cirugía general
            Empleado mleon = new Sanitarios(cirugiaGeneral, consultasExternas, "Miguel Leon Sánchez", "665551156", "01234567J", 1);
            empleados.add(mleon);
            cirugiaGeneral.agregarSanitario(mleon);
            Empleado agracia = new Sanitarios(cirugiaGeneral, consultasExternas, "Antonio García Herrera", "633277156", "23456789L", 2);
            empleados.add(agracia);
            cirugiaGeneral.agregarSanitario(agracia);
            
            // Consultas externas - Dermatología
            Empleado lmarin = new Sanitarios(dermatologia, consultasExternas, "Laura Marín Rodríguez", "625435510", "34567890M", 1);
            empleados.add(lmarin);
            dermatologia.agregarSanitario(lmarin);
            Empleado nhernandez = new Sanitarios(dermatologia, consultasExternas, "Nuria Hernández Gómez", "645750591", "45678901N", 2);
            empleados.add(nhernandez);
            dermatologia.agregarSanitario(nhernandez);
            
            // Consultas externas - Medicina Interna
            Empleado dsantos = new Sanitarios(medicinaInterna, consultasExternas, "Daniel Santos Gil", "645256256", "67890123P", 1);
            empleados.add(dsantos);
            medicinaInterna.agregarSanitario(dsantos);
            Empleado fmora = new Sanitarios(medicinaInterna, consultasExternas,"Francisco Mora Robles", "695252500", "78901234Q", 2);
            empleados.add(fmora);
            medicinaInterna.agregarSanitario(fmora);
            
            // Consultas externas - Oncología
            Empleado jpardo = new Sanitarios(oncologia, consultasExternas, "José Pardo Fernández", "631100891", "90123456S", 1);
            empleados.add(jpardo);
            oncologia.agregarSanitario(jpardo);
            Empleado amarquez = new Sanitarios(oncologia, consultasExternas, "Ana Márquez Pérez", "645055010", "01234567T", 2);
            empleados.add(amarquez);
            oncologia.agregarSanitario(amarquez);
            
            // Consultas externas - Oftalmología
            Empleado sblanco = new Sanitarios(oftalmologia, consultasExternas, "Silvia Blanco Ramírez", "633395325", "23456789V", 1);
            empleados.add(sblanco);
            oftalmologia.agregarSanitario(sblanco);
            Empleado jprieto = new Sanitarios(oftalmologia, consultasExternas, "Jorge Prieto Ortega", "652595344", "34567890W", 2);
            empleados.add(jprieto);
            oftalmologia.agregarSanitario(jprieto);
            
            // Consultas externas - Psiquiatría
            Empleado fserrano = new Sanitarios(psiquiatria, consultasExternas, "Francisco Serrano López", "648159753", "56789012Y", 1);
            empleados.add(fserrano);
            psiquiatria.agregarSanitario(fserrano);
            Empleado amarina = new Sanitarios(psiquiatria, consultasExternas, "Alicia Marina Vega", "665444789", "67890123Z", 2);
            empleados.add(amarina);
            psiquiatria.agregarSanitario(amarina);
            
            // Consultas externas - Traumatología
            Empleado hbermejo = new Sanitarios(traumatologia, consultasExternas, "Héctor Bermejo Hernández", "601223587", "89012345B", 1);
            empleados.add(hbermejo);
            traumatologia.agregarSanitario(hbermejo);
            Empleado ogutierrez = new Sanitarios(traumatologia, consultasExternas, "Olga Gutiérrez Sanz", "632258852", "90123456C", 2);
            empleados.add(ogutierrez);
            traumatologia.agregarSanitario(ogutierrez);

            //Alta enfermeros
            Empleado mreyes = new Sanitarios(null, consultasExternas, "María Reyes Sánchez", "658678458", "73299333K", 1);
            empleados.add(mreyes);
            Empleado jperez = new Sanitarios(null, consultasExternas, "Juan  Pérez Ruiz", "642541112", "67890123F", 2);
            empleados.add(jperez);
            Empleado psancho = new Sanitarios(null, consultasExternas, "Paula Sancho Rey", "672571199", "77890333F", 3);
            empleados.add(psancho);
            Empleado vfernandez = new Sanitarios(null, consultasExternas,"Verónica Fernández Martínez", "633221156", "90123456I", 4);
            empleados.add(vfernandez);
            Empleado escobar = new Sanitarios(null, consultasExternas, "Elena Escobar Pérez", "611560110", "12345678K", 5);
            empleados.add(escobar);
            Empleado jmoreno = new Sanitarios(null, consultasExternas, "Jorge Moreno Gil", "658578366", "56789012O", 6);
            empleados.add(jmoreno);
            Empleado saragon = new Sanitarios(null, consultasExternas, "Sara Aragon Blanco", "628458891", "89012345R", 1);
            empleados.add(saragon);
            Empleado rmendez = new Sanitarios(null, consultasExternas, "Raúl Méndez Serrano", "651193425", "12345678U", 2);
            empleados.add(rmendez);
            Empleado yramirez = new Sanitarios(null, consultasExternas, "Yolanda Ramírez Díaz", "686145789", "45678901X", 3);
            empleados.add(yramirez);
            Empleado rmolina = new Sanitarios(null, consultasExternas, "Ricardo Molina Sánchez", "632554419", "78901234A", 4);
            empleados.add(rmolina);
            
            //Unidad de formación
            Empleado mdominguez = new Sanitarios(null, formacion, "Marcos Domínguez Moya", "615546456", "01234567D", 1);
            empleados.add(mdominguez);
            Empleado ldominguez = new Sanitarios(medicinaGeneral, formacion, "Lucas Domínguez Moya", "675546477", "71234568N", 2);
            empleados.add(ldominguez);
            
            //Estudiantes
            Estudiante rmarcos = new Estudiante("Ramón Marcos Pam", "648845520", "89445725L", formacion, fmora, 1);
            estudiantes.add(rmarcos);
            Estudiante jgarcia = new Estudiante("Juan García López", "654123987", "12345678A", formacion, sblanco, 1);
            estudiantes.add(jgarcia);
            Estudiante aperez = new Estudiante("Ana Pérez Sánchez", "612345678", "23456789B", formacion, jpardo, 1);
            estudiantes.add(aperez);
            Estudiante trodriguez = new Estudiante("Tito Rodríguez Díaz", "678912345", "34567890C", formacion, lmarin, 1);
            estudiantes.add(trodriguez);
            Estudiante sfernandez = new Estudiante("Sara Fernández Gómez", "623456789", "45678901D", formacion, ogutierrez, 1);
            estudiantes.add(sfernandez);
            Estudiante jmartinez = new Estudiante("Jorge Martínez Ruiz", "634567890", "56789012E", formacion, vfernandez, 2);
            estudiantes.add(jmartinez);
            Estudiante llopez = new Estudiante("Laura López Torres", "645678901", "67890123F", formacion, escobar, 2);
            estudiantes.add(llopez);
            Estudiante ipascual = new Estudiante("Isabel Pascual Vázquez", "656789012", "78901234G", formacion, saragon, 2);
            estudiantes.add(ipascual);
            Estudiante agonzalez = new Estudiante("Andrés González Martín", "667890123", "89012345H", formacion, rmendez, 2);
            estudiantes.add(agonzalez);
            Estudiante emartin = new Estudiante("Elena Martín Pérez", "678901234", "90123456I", formacion, yramirez, 2);
            estudiantes.add(emartin);
            Estudiante pcortes = new Estudiante("Pablo Cortés Jiménez", "689012345", "01234567J", formacion, rmolina, 2);
            estudiantes.add(pcortes);

            
            //Horarios
            horarios.put(1, "De lunes a viernes, desde las 08:00 hasta las 16:00");//Horario 1
            horarios.put(2, "De lunes a viernes, desde las 14:00 hasta las 22:00");//Horario 2
            horarios.put(3, "De lunes a viernes, desde las 16:00 hasta las 00:00");//Horario 3
            horarios.put(4, "De lunes a viernes, desde las 00:00 hasta las 08:00");//Horario 4
            horarios.put(5, "De sábado a domingo, desde las 00:00 hasta las 12:00");//Horario 5
            horarios.put(6, "De sábado a domingo, desde las 12:00 hasta las 00:00");//Horario 6
    
    }
    
    public static void imprimirUnidades(){ //Para imprimir el listado de unidades
        int index = 1;
        for(Unidad unidad : unidades){
            System.out.println("[" + index + "]" + " " + unidad.getNombreUnidad());
            index++;
        }
    }
    
    public static void imprimirEspecialidades(){//Para imprimir el listado de especialidades
        int index = 1;
        for(Especialidad especialidad : especialidades){
            System.out.println("[" + index + "]" + " " + especialidad.getNombreEspecialidad());
            index++;
        }
    }
    
}


