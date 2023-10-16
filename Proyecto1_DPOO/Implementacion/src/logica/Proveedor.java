package logica;

import java.util.ArrayList;

public class Proveedor {
	public String nombre;
	public String vehiculo;
	public int cantidaddeVehiculo;
	public static ArrayList<Vehiculo> listaVehiculos;
	public Proveedor(String nombre, String vehiculo, int cantidaddeVehiculo,ArrayList<Vehiculo> listaVehiculos) {
		super();
		this.nombre = nombre;
		this.vehiculo = vehiculo;
		this.cantidaddeVehiculo = cantidaddeVehiculo;
		Proveedor.listaVehiculos = listaVehiculos;
	}
	public String getNombre() {
		return nombre;
	}
	public String getVehiculo() {
		return vehiculo;
	}
	public int getCantidaddeVehiculo() {
		return cantidaddeVehiculo;
	}
	public void agregarVehiculo( Vehiculo elvehiculo) {
		 listaVehiculos.add(elvehiculo);
	}
	public void setListavehiculos(ArrayList<Vehiculo> listaVehiculos) {
		Proveedor.listaVehiculos = listaVehiculos;
	}
	

}
