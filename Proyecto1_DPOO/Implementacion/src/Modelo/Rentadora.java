package Modelo;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import logica.Cliente;
import logica.Empleado;
import logica.Persona;
import logica.Reserva;
import logica.Sede;
import logica.Vehiculo;


public class Rentadora {
	private Map <String, Persona> Personas;
	
	private Map <String, Sede> Sedes;
	private Map <Double, Reserva> Reservas;
	private Map <Integer, Vehiculo> Vehiculos;

	public Rentadora (Map <String, Persona> Personas,Map <String, Sede> Sedes,  Map <Double, Reserva> Reservas, Map <Integer, Vehiculo> Vehiculos) {
		this.Personas = new HashMap <String, Persona>();
		this.Sedes = new HashMap <String, Sede>();
		this.Reservas = new HashMap <Double, Reserva>();
		this.Vehiculos = new HashMap<Integer,Vehiculo>();
		
		
		
		
	}
	public Map <String, Persona> darPersonas() {
		
		return Personas;
	}
	public Map <String, Sede> darsedes() {
		
		return Sedes;
	}
	public Map<Double, Reserva> darReservas() {
		
		return Reservas;
	}
	public Map<Integer, Vehiculo> darVehiculos() {
		
		return Vehiculos;
	}
	public String verificarIdentidad(String usuario, String Password) {
		Persona lapersona =  Personas.get(usuario);
		String contraseña = lapersona.getPassword();
		String cargo = lapersona.getCargo();
		if (contraseña == Password) {
			return cargo;
		}
		else 
			return "contraseña incorrecta";
		
		
		
		
	}
	public ArrayList<Empleado> devolverEmpleados(String user){
		Empleado elempleado = (Empleado) Personas.get(user);
		String nomsede = elempleado.getNomsede();
		Sede lasede = Sedes.get(nomsede);
		ArrayList<Empleado> lista = new ArrayList<Empleado>(lasede.getListaempleados().values());
		
		return lista;
		
	}
	public ArrayList<Vehiculo> devolverVehiculos(String user){
		Empleado elempleado = (Empleado) Personas.get(user);
		String nomsede = elempleado.getNomsede();
		Sede lasede = Sedes.get(nomsede);
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>(lasede.getListavehiculos());
		
		return lista;
		
	}
	public Persona devolverCliente(String user) {
		return Personas.get(user);
	}
	public void agregarPersona (String cargo,String nombre, double cedula, String fechadeNacimiento, String nacionalidad, String email,
			double celular, String login, String password) {
		Persona lapersona = new Cliente(cargo, nombre, cedula, fechadeNacimiento, nacionalidad, email, celular, login, password);
		Personas.put(login, lapersona);
	}
	public void actualizarEstadoVehiculo(Integer id, String estado) {
		Vehiculo elcarro = Vehiculos.get(id);
		elcarro.setEstado(estado);
		Vehiculos.put(id, elcarro);
	}
	
	public void cambiarVehiculoSede(Integer id, String sede) {
		Vehiculo elcarro = Vehiculos.get(id);
		String antiguaSede = elcarro.getSede();
		Sede viejaSede = Sedes.get(elcarro.getSede());
		Map<Integer, Vehiculo> mapavehiculosviejo = viejaSede.getMapaVehiculos();
		viejaSede.setListavehiculos(mapavehiculosviejo);
		Sedes.put(antiguaSede, viejaSede);
		//actualizar antigua sede, quitar vehiculo//
		
		
		elcarro.setSede(sede);
		
		Vehiculos.put(id, elcarro);
		Sede lasede = Sedes.get(sede);
		Map<Integer, Vehiculo> mapavehiculos = lasede.getMapaVehiculos();
		lasede.setListavehiculos(mapavehiculos);
		Sedes.put(sede, lasede);
		
		
	}
}















