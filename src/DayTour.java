public class DayTour extends Producto {
	private String descripcion;
	private Fecha fechaInicio;
	private String hora;
	private String duracion;
	private String guiaTour;
	
	// Constructor
	DayTour(String nombre, double precio, String descripcion, Fecha fechaInicio, String hora, String duracion, String guiaTour) {
		super(nombre, precio);
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.hora = hora;
		this.duracion = duracion;
		this.guiaTour = guiaTour;
	}
	
	//Getters y setters
	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public Fecha getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Fecha fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
 
	public String getGuiaTour() {
		return guiaTour;
	}


	public void setGuiaTour(String guiaTour) {
		this.guiaTour = guiaTour;
	}
 
	public void mostrarProductos(){
		System.out.println("1- DayTour en Argentina");
		System.out.println("2- DayTour en Uruguay");
	}
	
    @Override
    public String toString() {
        return "Day Tour - " + getNombre() + " " + "| Guia a cargo - " + getGuiaTour();
    }
	
    // Método para mostrar la experiencia creada
    public void mostrarDayTour(DayTour daytour) {
        System.out.println("Experiencia creada:");
        System.out.println("Nombre: " + daytour.getNombre());
        System.out.println("Precio: " + daytour.getPrecio());
        System.out.println("Descripción: " + daytour.getDescripcion());
        System.out.println("Fecha de inicio: " + daytour.getFechaInicio());
        System.out.println("Hora: " + daytour.getHora());
        System.out.println("Duración: " + daytour.getDuracion());
        System.out.println("Guía de turismo: " + daytour.getGuiaTour());
    }
 
}