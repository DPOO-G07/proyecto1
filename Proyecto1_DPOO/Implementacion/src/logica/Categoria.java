package logica;

import java.util.Collection;
import java.util.Map;

public class Categoria {
	public double iddeCategoria;
	public double tarifaporDia;
	public String temporada;
	Map <String, Vehiculo> listaVehiculos;
	public Categoria(double iddeCategoria, double tarifaporDia, String temporada) {
		super();
		this.iddeCategoria = iddeCategoria;
		this.tarifaporDia = tarifaporDia;
		this.temporada = temporada;
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
	public Collection<Vehiculo> getListavehiculos(){
		return this.listaVehiculos.values();
	}
	public void agregarVehiculo(String id, Vehiculo elvehiculo) {
		listaVehiculos.put(id, elvehiculo);
	}
	public void setListavehiculos( Map<String, Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

}
