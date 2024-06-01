public class Paquete extends Producto {
 // Constructor
 Paquete(String nombre, double precio) {
     super(nombre, precio);
 }
 
 public void mostrarProductos(){
	 System.out.println("Paquete de viajes en Argentina");
	 System.out.println("Paquete de viajes en Uruguay");
 }
}