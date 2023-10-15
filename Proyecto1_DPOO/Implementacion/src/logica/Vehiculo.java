package logica;

public class Vehiculo {
	public String id;
	public String categoria;
	public String estado;
	public String ubicacion;
	public String placa;
	public String marca;
	public String modelo;
	public String color;
	public String tipodeTransmision;
	public int capacidaddePersonas;
	public String sede;
	public Vehiculo(String id,String categoria, String estado, String ubicacion, String placa, String marca, String modelo,
			String color, String tipodeTransmision, int capacidaddePersonas, String sede) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.estado = estado;
		this.ubicacion = ubicacion;
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.tipodeTransmision = tipodeTransmision;
		this.capacidaddePersonas = capacidaddePersonas;
		this.sede = sede;
	}
	public String getId() {
		return id;
	}
	public String getCategoria() {
		return categoria;
	}
	public String getEstado() {
		return estado;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public String getPlaca() {
		return placa;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public String getColor() {
		return color;
	}
	public String getTipodeTransmision() {
		return tipodeTransmision;
	}
	public int getCapacidaddePersonas() {
		return capacidaddePersonas;
	}
	public String getSede() {
		return sede;
	}
	public void setEstado(String sede ) {
		this.sede = sede;
	}
	

}
