import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Fecha {
    private int dia;
    private int mes;
    private int año;

    public Fecha(String fechaString) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaString, formatter);

        this.dia = fecha.getDayOfMonth();
        this.mes = fecha.getMonthValue();
        this.año = fecha.getYear();

        // Validar la fecha
        if (!validarFecha(fechaString)) {
            throw new DateTimeParseException("Fecha inválida", fechaString, 0);
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
    private boolean validarFecha(String fechaString) {
        try {
            // Verificar si los valores originales coinciden con los valores de la fecha obtenida
            LocalDate fechaValidada = LocalDate.of(año, mes, dia);
            return fechaValidada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).equals(fechaString);
        } catch (DateTimeException e) {
            return false; // Si no se puede crear la fecha, es inválida
        }
    }

    public boolean esFechaFutura() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fecha = LocalDate.of(año, mes, dia);
        return fecha.isAfter(fechaActual);
    }
    
    public static Fecha obtenerFecha(String fechaString) {
        try {
            return new Fecha(fechaString);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha incorrecto o fecha inválida. Intente nuevamente.");
            return null; // En caso de excepción, devolver null
        }
    }
    
    
    
}
