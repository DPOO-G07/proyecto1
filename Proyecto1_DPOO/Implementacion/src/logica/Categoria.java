package logica;

import java.util.ArrayList;


public class Categoria {
	public double iddeCategoria;
	public double tarifaporDia;
	public String temporada;
	public static ArrayList<Vehiculo> listaVehiculos;
	public Categoria(double iddeCategoria, double tarifaporDia, String temporada, ArrayList<Vehiculo> listaVehiculos) {
		super();
		this.iddeCategoria = iddeCategoria;
		this.tarifaporDia = tarifaporDia;
		this.temporada = temporada;
		Categoria.listaVehiculos = listaVehiculos;
	}
	public double getIddeCategoria() {
		return iddeCategoria;
	}
	public double getTarifaporDia() {
		return tarifaporDia;
	}
	public String getTemporada() {
		return temporada;
	}
	public void agregarVehiculo(String id, Vehiculo elvehiculo) {
	listaVehiculos.add(elvehiculo);
	}
	public void setListavehiculos( ArrayList<Vehiculo> listaVehiculos) {
		Categoria.listaVehiculos = listaVehiculos;
	}

}
