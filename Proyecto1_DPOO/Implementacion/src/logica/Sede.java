package logica;

public class Sede {
	public String nombre;
	public String ubicacion;
	public String horariosdeAtencion;
	public String administradordeSede;
	//public int empleados;//
	public Sede(String nombre, String ubicacion, String horariosdeAtencion, String administradordeSede) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.horariosdeAtencion = horariosdeAtencion;
		this.administradordeSede = administradordeSede;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getHorariosdeAtencion() {
		return horariosdeAtencion;
	}
	public void setHorariosdeAtencion(String horariosdeAtencion) {
		this.horariosdeAtencion = horariosdeAtencion;
	}
	public String getAdministradordeSede() {
		return administradordeSede;
	}
	public void setAdministradordeSede(String administradordeSede) {
		this.administradordeSede = administradordeSede;
	}
	

}
