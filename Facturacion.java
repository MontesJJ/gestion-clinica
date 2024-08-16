import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta parte de la aplicacion se van a generar las facturas para los pacientes.
 */

public class Facturacion extends Hospital {
    
    public void iniciarMenu(){
        
        System.out.println("SELECCIONE EL PACIENTE AL QUE DESEA EMITIR UNA FACTURA:");
        imprimirListadoPacientes();
        
        ArrayList<Paciente> pacientesSinSeguro = new ArrayList<>();
        for(Paciente paciente : pacientes){
            if(!paciente.getSeguro()){
                pacientesSinSeguro.add(paciente);
            }
        }
        
        Scanner p = new Scanner(System.in);
        Paciente paciente = pacientesSinSeguro.get(p.nextInt() - 1);
        
        System.out.println("SELECCIONE EL AÑO DE EMISIÓN DE FACTURAS:");
        int anio = p.nextInt();
        
        System.out.println("SELECCIONE EL MES DE EMISIÓN DE FACTURAS (1-12):");
        int mes = p.nextInt();
        
        cobroPacientes(anio, mes, paciente);
        
        
        //por una lado tengo que recorrer el array list de citas y comprobar si ha habido alguna cita dentro de ese mes, si es asi la recupero
        System.out.println("Pulsa intro para volver...");                    
        Scanner sc1 = new Scanner(System.in);
        String salir1 = sc1.nextLine();
        System.out.print('\u000C');
    }
    
    public void imprimirListadoPacientes(){
        ArrayList<Paciente> pacientesSinSeguro = new ArrayList<>();
        for(Paciente paciente : pacientes){
            if(!paciente.getSeguro()){
                pacientesSinSeguro.add(paciente);
            }
        }
        
        int index = 1;
        for(Paciente paciente : pacientesSinSeguro){
            System.out.println("[" + index + "] " + paciente.getNombre());
            index++;
        }
        System.out.println("\n");
    }
    
    public void cobroPacientes(int anio, int mes, Paciente paciente) {
        ArrayList<Cita> citas = paciente.getCitas();
        ArrayList<Ingreso> ingresos = paciente.getIngresos();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdfFechaEmision = new SimpleDateFormat("dd/MM/yyyy");
    
        int coste = 0;
        Date fechaActual = new Date();
        
        // Encabezado de la factura
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("|                    FACTURACIÓN HOSPITAL                   |");
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("Fecha de emisión de la factura: " + sdfFechaEmision.format(fechaActual));
        System.out.println("Nombre del paciente: " + paciente.getNombre());
        System.out.println("Periodo de facturación: " + String.format("%02d/%04d", mes, anio));
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("");
        
        // Detalle de las consultas
        System.out.println("Detalle de las consultas:");
        System.out.println("-------------------------------------------------------------");
    
        for (Cita cita : citas) {
            if (cita.getFecha().get(Calendar.MONTH) == (mes - 1) && cita.getFecha().get(Calendar.YEAR) == anio) {
                Date fecha = cita.getFecha().getTime();
                String nombreUnidad = cita.getUnidad().getNombreUnidad();
                int costeConsulta = nombreUnidad.equals("Pruebas médicas") ? 150 : 50;
    
                System.out.println(sdf.format(fecha) + " [" + nombreUnidad + "] -- " + costeConsulta + "€");
                coste += costeConsulta;
            }
        }
    
        System.out.println("\nDetalle de los ingresos hospitalarios:");
        System.out.println("-------------------------------------------------------------");
    
        for(Ingreso ingreso : ingresos) {
            if(ingreso.getAlta() != null && ingreso.getBaja() != null) {
                if(ingreso.getBaja().get(Calendar.MONTH) == (mes - 1) && ingreso.getBaja().get(Calendar.YEAR) == anio) {
                    Date fechaIngreso = ingreso.getAlta().getTime();
                    Date fechaAlta = ingreso.getBaja().getTime();
                    
                    long diferenciaMilisegundos = fechaAlta.getTime() - fechaIngreso.getTime();
                    long diasHospitalizacion = (diferenciaMilisegundos / (1000 * 60 * 60 * 24)) + 1;
        
                    int costeIngreso = (int) diasHospitalizacion * 100;
                    
                    System.out.println(sdf.format(fechaIngreso) + " al " + sdf.format(fechaAlta) + " -- " + diasHospitalizacion + " días -- " + costeIngreso + "€");
                    coste += costeIngreso;
                }
            } else {
                System.out.println("Error: Fecha de alta o baja no establecida correctamente.");
            }
        }

    
        System.out.println("-------------------------------------------------------------");
        System.out.println("Total a pagar: " + coste + "€");
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("");
    }

    
}
