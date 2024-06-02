import java.util.Scanner;

public class MercadoPago {
    private String titular;
    private String numCuenta;
    private String numComprobante;

    // Constructor
    public MercadoPago(String titular, String numCuenta, String numComprobante) {
        this.titular = titular;
        this.numCuenta = numCuenta;
        this.numComprobante = numComprobante;
    }

    // Getters and Setters
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    @Override
    public String toString() {
        return "Titula de la cuenta = " + titular +
               ", Número de la cuenta = " + numCuenta +
               ", Número de comprobante = " + numComprobante + "\n";
    }

    public static MercadoPago crearMercadoPago(Scanner entrada) {
        System.out.print("Ingrese el nombre del titular: ");
        String titular = entrada.nextLine();

        System.out.print("Ingrese el número de la cuenta: ");
        String numCuenta = entrada.nextLine();

        System.out.print("Ingrese el número de comprobante del titular: ");
        String numComprobante = entrada.nextLine();

        return new MercadoPago(titular, numCuenta, numComprobante);
    }
}