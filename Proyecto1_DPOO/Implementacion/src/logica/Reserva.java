package logica;

public class Reserva {
	public String tipodeVehiculo;
	public String Sede;
	public String fechadeRecoleccion;
	public String horadeRecoleccion;
	public String fechadeEntrega;
	public String horadeEntrega;
	public int cobro;
	public String cliente;
	public String estado;
	
	public Reserva(String tipodeVehiculo, String sede, String fechadeRecoleccion, String horadeRecoleccion,
			String fechadeEntrega, String horadeEntrega, int cobro, String cliente, String estado) {
		super();
		this.tipodeVehiculo = tipodeVehiculo;
		Sede = sede;
		this.fechadeRecoleccion = fechadeRecoleccion;
		this.horadeRecoleccion = horadeRecoleccion;
		this.fechadeEntrega = fechadeEntrega;
		this.horadeEntrega = horadeEntrega;
		this.cobro = cobro;
		this.cliente = cliente;
		this.estado = estado;
	}
	public String getTipodeVehiculo() {
		return tipodeVehiculo;
	}
	public String getSede() {
		return Sede;
	}
	public String getFechadeRecoleccion() {
		return fechadeRecoleccion;
	}
	public String getHoradeRecoleccion() {
		return horadeRecoleccion;
	}
	public String getFechadeEntrega() {
		return fechadeEntrega;
	}
	public String getHoradeEntrega() {
		return horadeEntrega;
	}
	public int getCobro() {
		return cobro;
	}
	public String getCliente() {
		return cliente;
	}
	
	public String getEstado() {
		return estado;
	}
	
}
