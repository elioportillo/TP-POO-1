import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Fecha {
    private int dia;
    private int mes;
    private int año;

    public Fecha(String fechaString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Hacer que el parsing sea estricto
        Date fecha = dateFormat.parse(fechaString);

        // Obtener los componentes de la fecha
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        this.dia = calendar.get(Calendar.DAY_OF_MONTH);
        this.mes = calendar.get(Calendar.MONTH) + 1; // Se suma 1 porque en Calendar, enero es 0
        this.año = calendar.get(Calendar.YEAR);

        // Validar la fecha
        if (!validarFecha()) {
            throw new ParseException("Fecha inválida", 0);
        }
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", dia, mes, año);
    }

    // Método para validar la fecha en su totalidad
    private boolean validarFecha() {
        boolean fechaValida = true;

        // Validar que el año esté entre 1900 y el 2100
        if (año < 1900 || año > 2100) {
            System.out.println("El año debe estar entre 1900 y el 2100.");
            fechaValida = false;
        }

        // Validar que el mes esté entre 1 y 12
        else if (mes < 1 || mes > 12) {
            System.out.println("El mes debe estar entre 1 y 12.");
            fechaValida = false;
        }

        // Validar que el día esté dentro del rango válido para el mes
        else if (dia < 1 || dia > obtenerMaximoDia(mes, año)) {
            System.out.println("El día no es válido para el mes y año especificados.");
            fechaValida = false;
        }

        // Validar si el año es bisiesto
        else if (mes == 2 && dia == 29 && !esAñoBisiesto(año)) {
            System.out.println("El año " + año + " no es bisiesto.");
            fechaValida = false;
        }

        return fechaValida;
    }
    
    // Método para verificar si un año es bisiesto
    private boolean esAñoBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    // Método para obtener el máximo día para un mes y año dados
    private int obtenerMaximoDia(int mes, int año) {
        if (mes == 2) { // Febrero
            return esAñoBisiesto(año) ? 29 : 28;
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        } else {
            return 31;
        }
    }
    
    public static Fecha obtenerFecha(String fechaString) {
        try {
            return new Fecha(fechaString);
        } catch (ParseException  e) {
            System.out.println("Formato de fecha incorrecto o fecha inválida. Intente nuevamente.");
            return null; // En caso de excepción, devolver null
        }
    }
    
    public static String obtenerFechaYHoraActual() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return fechaHoraActual.format(formateador);
    }
    
    
}
