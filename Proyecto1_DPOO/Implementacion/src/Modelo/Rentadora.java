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

	public Rentadora (Map <String, Persona> Personas,Map <String, Sede> Sedes,  Map <Double, Reserva> Reservas) {
		this.Personas = new HashMap <String, Persona>();
		this.Sedes = new HashMap <String, Sede>();
		this.Reservas = new HashMap <Double, Reserva>();
		
		
		
		
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
	public Collection<Empleado> devolverEmpleados(String user){
		Empleado elempleado = (Empleado) Personas.get(user);
		String nomsede = elempleado.getNomsede();
		Sede lasede = Sedes.get(nomsede);
		Collection<Empleado> lista = lasede.getListaempleados().values();
		
		return lista;
		
	}
	public Collection<Vehiculo> devolverVehiculos(String user){
		Empleado elempleado = (Empleado) Personas.get(user);
		String nomsede = elempleado.getNomsede();
		Sede lasede = Sedes.get(nomsede);
		Collection<Vehiculo> lista = lasede.getListavehiculos();
		
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
}