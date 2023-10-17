package Modelo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import logica.Cliente;
import logica.Empleado;
import logica.Persona;
import logica.Reserva;
import logica.Sede;
import logica.SeguroAdicional;
import logica.Tarifa;
import logica.Vehiculo;


public class Rentadora {
	private Map <String, Persona> Personas;
	
	private Map <String, Sede> Sedes;
	private Map <Double, Reserva> Reservas;
	private Map <Integer, Vehiculo> Vehiculos;
	private Tarifa tarifa;
	private Map<String, SeguroAdicional> seguros;
	
	

	public Rentadora (Map <String, Persona> Personas,Map <String, Sede> Sedes,  Map <Double, Reserva> Reservas, Map <Integer, Vehiculo> Vehiculos) {
		this.Personas = Personas;
		this.Sedes = Sedes;
		this.Reservas = Reservas;
		this.Vehiculos = Vehiculos;
		
		
		
		
		
		
		
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
		if (contraseña.equals(Password)) {
			return cargo;
		}
		else 
			return "contraseña incorrecta";
		
		
		
		
	}
	public void devolverEmpleados(String user){
		Empleado elempleado = (Empleado) Personas.get(user);
		String nomsede = elempleado.getNomsede();
		Sede lasede = Sedes.get(nomsede);
		ArrayList<Empleado> lista = new ArrayList<Empleado>(lasede.getListaempleados().values());
		for (Empleado elemp : lista) {
			System.out.println(elemp.getNombre());
		}
		
		
		
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
		if (cargo.equalsIgnoreCase("Cliente")){
			Double licencia = Double.parseDouble(input("Por favor ingrese su licencia"));
			Double metododepago = Double.parseDouble(input("Por favor ingrese su metodo de pago"));
			Persona lapersona = new Cliente(cargo, nombre, cedula, fechadeNacimiento, nacionalidad, email, celular, login, password, licencia,metododepago);
			Personas.put(login, lapersona);
	}
		else {
			String nomsede = (input("Por favor ingrese la sede que hara parte"));
			Persona lapersona = new Empleado(cargo, nombre, cedula, fechadeNacimiento, nacionalidad, email, celular, login, password,nomsede);
			Personas.put(login, lapersona);
		}
		
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
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	public void Seguros(){
		String nom1 = "Seguros Bolivar";
		int tarifa1 = 20000;
		SeguroAdicional seguro1 = new SeguroAdicional(nom1,tarifa1);
		
		String nome2 = "Seguros Sura";
		int tarifa2 = 30000;
		SeguroAdicional seguro2 = new SeguroAdicional(nome2,tarifa2);
		seguros.put(nom1, seguro1);
		seguros.put(nom1, seguro2);
		
		
		
	}
	public void agregarSeguro(String nom, int tarifa) {
		SeguroAdicional segurito = new SeguroAdicional(nom,tarifa);
		seguros.put(nom, segurito);
		
	}
	public void eliminarSeguro(String nom) {
		
		seguros.remove(nom);
		
	}
	public void cambiarHorarios (String sede, String nuevohorario) {
		Sede nomsede = Sedes.get(sede);
		
		nomsede.setHorariosdeAtencion(nuevohorario);
		Sedes.put(sede, nomsede);
	}
	public void cambiarAdmin(String sede, String nuevoadmin, boolean nuevo) {
		if (nuevo == false) {
			Persona eladmin = Personas.get(nuevoadmin);
			eladmin.setCargo("Administrador Local");
			Personas.put(nuevoadmin, eladmin);
			
		}
		Sede nomsede = Sedes.get(sede);
		
		nomsede.setAdministradordeSede(nuevoadmin);
		Sedes.put(sede, nomsede);
	}
	public void agregarVehiculosede(String sede,int id, Vehiculo elvehiculo) {
		Sede lasede = Sedes.get(sede);
		Map <Integer,Vehiculo> mapa = lasede.getMapaVehiculos();
		mapa.put(id, elvehiculo);
		lasede.setListavehiculos(mapa);
		
		Sedes.put(sede, lasede);
		
		
	}
	
}















