package Modelo;


import java.io.BufferedReader;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import logica.Cliente;
import logica.Empleado;
import logica.Persona;
import logica.Proveedor;
import logica.Reserva;
import logica.Sede;
import logica.SeguroAdicional;
import logica.Tarifa;
import logica.Vehiculo;
import logica.Categoria;


public class Rentadora {
	private Map <String, Persona> Personas;
	
	private Map <String, Sede> Sedes;
	private Map <Double, Reserva> Reservas;
	private Map <Integer, Vehiculo> Vehiculos;
	private Tarifa tarifa;
	private Map<String, SeguroAdicional> seguros;

	private Map<String, Categoria> categorias;

	private Map<String, Proveedor> proveedores;
	

	

	public Rentadora (Map <String, Persona> Personas,Map <String, Sede> Sedes,  Map <Double, Reserva> Reservas, Map <Integer, Vehiculo> Vehiculos) {
		this.Personas = Personas;
		this.Sedes = Sedes;
		this.Reservas = Reservas;
		this.Vehiculos = Vehiculos;
		this.seguros = new HashMap<String,SeguroAdicional>();
		this.proveedores = new HashMap<String,Proveedor>();
		
		
		
		
		
		
		
		
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
	public void devolverEmpleadosadmin(String sede){
		
		Sede lasede = Sedes.get(sede);
		ArrayList<Empleado> lista = new ArrayList<Empleado>(lasede.getListaempleados().values());
		for (Empleado elemp : lista) {
			System.out.println(elemp.getNombre());
		}
		
		
		
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
	public void devolverVehiculosadmin(String nomsede){
		
		Sede lasede = Sedes.get(nomsede);
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>(lasede.getListavehiculos());
		for (Vehiculo elvehi : lista) {
			System.out.println(elvehi.getPlaca());
		}
	
		
	}
	public void devolverVehiculos(String user){
		Empleado elempleado = (Empleado) Personas.get(user);
		String nomsede = elempleado.getNomsede();
		Sede lasede = Sedes.get(nomsede);
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>(lasede.getListavehiculos());
		for (Vehiculo elvehi : lista) {
			System.out.println(elvehi.getPlaca());
		}
		
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
			Empleado lapersona = new Empleado(cargo, nombre, cedula, fechadeNacimiento, nacionalidad, email, celular, login, password,nomsede);
			Sede lasede = Sedes.get(nomsede);
			Map<String, Empleado> mapa = lasede.getListaempleados();
			mapa.put(login, lapersona);
			lasede.setmapempleados(mapa);
			
			Sedes.put(nombre, lasede);
			
			
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
		seguros.put(nome2, seguro2);
		
		
		
	}
	public void Proveedores() {
		String nomv = "mazda";
		String nomv1 = "susuki";
		String nomv2 = "mercedes";
		String nom = "Mercado libre";
		String nom2 = "Automercol";
		String nom3 = "La romana";
		int cantidad = 3;
		Proveedor prov1 = crearProveedor(nom,nomv,cantidad);
		Proveedor prov2 = crearProveedor(nom2,nomv1,cantidad);
		Proveedor prov3 = crearProveedor(nom3,nomv2,cantidad);
		proveedores.put(nom,prov1);
		proveedores.put(nom2,prov2);
		proveedores.put(nom3,prov3);
		
	}
	public void mostrarProveedores() {
		for (Proveedor elprov : proveedores.values()) {
			System.out.println(elprov.getNombre());
		}
	}
	public void mostrarSeguross() {
		for (SeguroAdicional elseg : seguros.values()) {
			System.out.println(elseg.getNombredelSeguro());
		}
	}
	public void agregarSeguro(String nom, int tarifa) {
		SeguroAdicional segurito = new SeguroAdicional(nom,tarifa);
		seguros.put(nom, segurito);
		
	}
	public void agregarProveedor(String nom, String vehiculo, int cantidad) {
		Proveedor prov = crearProveedor(nom,vehiculo,cantidad);
		proveedores.put(nom, prov);
		
		
	}
	public void pedidoProveedor(String nom, int cantidad) {
		Proveedor prov = proveedores.get(nom);
		prov.agregarCantidad(cantidad);
		proveedores.put(nom, prov);
		System.out.println("Con este pedido se han hecho " + prov.getCantidaddeVehiculo());
		
		
	}
	public void eliminarProveedor(String nom) {
		proveedores.remove(nom);
		
	}
	public Proveedor crearProveedor(String nom,String vehiculo,int cantidad) {
		Proveedor prov = new Proveedor(nom, vehiculo, cantidad);
		
		return prov;
		
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
	public void agregarVehiculo(String sede,int id, Vehiculo elvehiculo) {
		Sede lasede = Sedes.get(sede);
		Map <Integer,Vehiculo> mapa = lasede.getMapaVehiculos();
		mapa.put(id, elvehiculo);
		lasede.setListavehiculos(mapa);
		Vehiculos.put(id, elvehiculo);
		Sedes.put(sede, lasede);
		
		
	}
	public void categoria(){
		 double iddeCategoria = 1;
		 double tarifaporDia = 1000000;
		 String temporada = "alta";
		 String nombre = "SUV";
		 ArrayList <Vehiculo> SUV = new ArrayList<>();
		 Categoria categoria1 = new Categoria(iddeCategoria,tarifaporDia,temporada,nombre,SUV);
		 
		 double iddeCategoria2 = 2;
		 double tarifaporDia2 = 10000000;
		 String temporada2 = "alta";
		 String nombre2 = "Lujo";
		 ArrayList <Vehiculo> Lujo = new ArrayList<>();
		 Categoria categoria2 = new Categoria(iddeCategoria2,tarifaporDia2,temporada2,nombre2,SUV);
		 
		categorias.put(nombre, categoria1);
		categorias.put(nombre2, categoria2);
;
	
		
	    
		
	}
	public void iniciarReserva(String categoria, String sede, String fechadeRecoleccion, String horadeRecoleccion,String fechadeEntrega,String horadeEntrega, String nombredelCliente) throws ParseException {
		double id = Reservas.size() + 1;
		Categoria lacategoria = categorias.get(categoria);
		double cobro = lacategoria.getTarifaporDia() * obtenerNumeroDeDiasdeunareserva(fechadeRecoleccion,fechadeEntrega); 
		String estado = "disponible";
		
		Reserva reserva = new Reserva(id, categoria, sede, fechadeRecoleccion, horadeRecoleccion, fechadeEntrega, horadeEntrega, cobro, nombredelCliente, estado);
		Reservas.put(id, reserva);
	}

	
	private double obtenerNumeroDeDiasdeunareserva(String fechadeRecoleccion, String fechadeEntrega) throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio = date.parse(fechadeRecoleccion);
		Date fechaFinal = date.parse(fechadeEntrega);
		double milisecondsByDay = 86400000;
		double dias = (int) ((fechaFinal.getTime()-fechaInicio.getTime()) / milisecondsByDay);
		return dias;
		
	}
	
	
}















