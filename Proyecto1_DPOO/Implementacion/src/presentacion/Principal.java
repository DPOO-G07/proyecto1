package presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import Modelo.Rentadora;
import logica.Persona;



public class Principal {
	private Rentadora ren;
	public static void main(String[]args) throws IOException {
		Principal principal = new Principal();
		principal.ejecutarAplicacion();
	}
		
	public void ejecutarAplicacion() throws IOException
	{
		System.out.println("Rentadora de carros \n");
		Inicializaraplicacion();
		Boolean continuar = true;
		while (continuar == true) {
			String user = (input("Por favor ingrese su usuario"));
			String contraseña = (input("Por favor ingrese su contraseña"));
			String cargo = ren.verificarIdentidad(user, contraseña);
			
			if (cargo == "Administrador Local") {
				Menuadministradorlocal (user);
			}
			else if (cargo == "Administrador General") {
				Menuadministrador(user);
				
			}
			else if (cargo == "Empleado") {
				
			}
			else if( cargo == "Cliente") {
				
			}
			else {
				System.out.println("Contraseña incorrecta \n");
				System.out.println("1. Desea intentar de nuevo? \n");
				System.out.println("2. Si no tiene cuenta, desea crear una?  \n");
				System.out.println("3. Desea salir de la aplicacion? \n");
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 2) {
					Inscripcion("Cliente");
				}
				else if (opcion_seleccionada == 3) {
					System.out.println("Gracias por usar la aplicacion");
					continuar = false;
				}
				
			}
				
		}
	}
		
			
		
	private void Inicializaraplicacion() {
		ren = carga.Leer("Proyecto1_DPOO/Implementacion/data/personas.txt", "Proyecto1_DPOO/Implementacion/data/sede.txt", "Proyecto1_DPOO/Implementacion/data/reserva.txt", "Proyecto1_DPOO/Implementacion/data/vehiculos.txt");
		System.out.println("Se inicio la app");
	}
	
	private void Inscripcion(String posicion) {
		
		String cargo = posicion;
		String nombre = (input("Por favor ingrese su nombre"));
		Double cedula = Double.parseDouble(input("Por favor ingrese su cedula"));
		String fechadeNacimiento= (input("Por favor ingrese su fecha de nacimiento (DD/MM/YYYY"));
		String nacionalidad = (input("Por favor ingrese su nacionalidad"));
		String email = (input("Por favor ingrese su email"));
		Double numero = Double.parseDouble(input("Por favor ingrese su numero"));
		String login = (input("Por favor ingrese como desea su login"));
		String password = (input("Por favor ingrese su contraseña"));
	
			
		ren.agregarPersona(cargo, nombre, cedula, fechadeNacimiento, nacionalidad, email, numero, login, password);
		
		System.out.println("Se creo exitosamente la cuenta ");
		
	}
	private void Menuadministradorlocal(String user) {
		System.out.println("Bienvenido Administrador\n");
		System.out.println("1. Desea consultar la informacion de los empleados de la sede? \n");
		System.out.println("2. Desea consultar los vehiculos de la sede?  \n");
		System.out.println("3. Desea consultar informacion de los clientes?  \n");
		System.out.println("4. Desea agregar un nuevo empleado?  \n");
		System.out.println("5. Desea agregar un nuevo cliente?  \n");
		System.out.println("6. Desea actualizar el estado de un vehiculo?  \n");
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
		if (opcion_seleccionada == 1){
			System.out.println("Los empleados de la sede son:  \n");
			System.out.println(ren.devolverEmpleados(user));
		}
		else if (opcion_seleccionada ==2){
			System.out.println("Los vehiculos de la sede son:  \n");
			System.out.println(ren.devolverVehiculos(user));
		}
		else if (opcion_seleccionada ==3){
			String nomcliente = (input("Ingrese el user del cliente"));
			Persona cliente = ren.devolverCliente(nomcliente);
			
			SolicitarInformacionCliente(cliente);
			
			
			
		}
		else if (opcion_seleccionada ==4){
			Inscripcion("Empleado");
		}
		else if (opcion_seleccionada ==5){
			Inscripcion("Cliente");
		}
		else if (opcion_seleccionada ==6){
			Integer idCarro = Integer.parseInt(input("Que carro esta buscando, ingrese el Id porfavor"));
			System.out.println("1. Desea actualizar su estado?  \n");
			System.out.println("2. Desea cambiarlo de sede para disponibilidad? \n");
			int opcion_seleccionada2 = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada2 == 1) {
				String estado = (input("Que carro esta buscando, ingrese el Id porfavor"));
				ren.actualizarEstadoVehiculo(idCarro,estado);
				System.out.println("Listo, el estado del vehiculo esta actualizado ");
			}
			else if (opcion_seleccionada2 == 2){
				String sede = (input("A que sede desea transladar el carro?"));
				ren.cambiarVehiculoSede(idCarro, sede);
				System.out.println("Listo, el translado fue hecho con exito ");
			}
			else {
				System.out.println("Seleccione una opcion valida");
			}
		}
		else {
			System.out.println("Seleccione una opcion valida");
		}
		
	}
	private void Menuadministrador(String user) {
		System.out.println("1. Desea consultar la informacion de los empleados de la sede? \n");
		System.out.println("2. Desea consultar los vehiculos de la sede?  \n");
		System.out.println("3. Desea consultar informacion de los clientes?  \n");
		System.out.println("4. Desea agregar un nuevo empleado?  \n");
		System.out.println("5. Desea agregar un nuevo cliente?  \n");
		System.out.println("6. Desea actualizar el estado de un vehiculo?  \n");
		System.out.println("7. Desea actualizar las tarifas?  \n");
		System.out.println("8. Desea gestionar los convenios con los seguros?  \n");
		System.out.println("9. Desea gestionar una sede?  \n");
		System.out.println("10. Desea gestionar un proveedor?  \n");
		
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
		if (opcion_seleccionada == 1){
			System.out.println("Los empleados de la sede son:  \n");
			System.out.println(ren.devolverEmpleados(user));
		}
		else if (opcion_seleccionada ==2){
			System.out.println("Los vehiculos de la sede son:  \n");
			System.out.println(ren.devolverVehiculos(user));
		}
		else if (opcion_seleccionada ==3){
			String nomcliente = (input("Ingrese el user del cliente"));
			Persona cliente = ren.devolverCliente(nomcliente);
			
			SolicitarInformacionCliente(cliente);
			
			
			
		}
		else if (opcion_seleccionada ==4){
			Inscripcion("Empleado");
		}
		else if (opcion_seleccionada ==5){
			Inscripcion("Cliente");
		}
		else if (opcion_seleccionada ==6){
			Integer idCarro = Integer.parseInt(input("Que carro esta buscando, ingrese el Id porfavor"));
			System.out.println("1. Desea actualizar su estado?  \n");
			System.out.println("2. Desea cambiarlo de sede para disponibilidad? \n");
			int opcion_seleccionada2 = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada2 == 1) {
				String estado = (input("Que carro esta buscando, ingrese el Id porfavor"));
				ren.actualizarEstadoVehiculo(idCarro,estado);
				System.out.println("Listo, el estado del vehiculo esta actualizado ");
			}
			else if (opcion_seleccionada2 == 2){
				String sede = (input("A que sede desea transladar el carro?"));
				ren.cambiarVehiculoSede(idCarro, sede);
				System.out.println("Listo, el translado fue hecho con exito ");
			}
			else {
				System.out.println("Seleccione una opcion valida");
			}
		}
		else if (opcion_seleccionada == 7) {
				
			}
		else if (opcion_seleccionada == 8) {
			
		}
		else if (opcion_seleccionada == 9) {
			
		}
		else if (opcion_seleccionada == 10) {
			
		}
		
		else {
			System.out.println("Seleccione una opcion valida");
		}
	}
	private void SolicitarInformacionCliente(Persona cliente) {
		System.out.println("1. Desea saber su nombre");
		System.out.println("2. Desea saber su cedula");
		System.out.println("3. Desea saber su fecha de nacimiento ");
		System.out.println("4. Desea saber su nacionalidad");
		System.out.println("5. Desea saber su email");
		System.out.println("6. Desea saber su numero");
		System.out.println("7. Desea saber su login");
		Integer opcion = Integer.parseInt(input("Que desea saber del cliente? "));
		if (opcion == 1) {
			System.out.println(cliente.getNombre());
			
		}
		else if (opcion == 2) {
			System.out.println(cliente.getCedula());
			
		}
		else if (opcion == 3) {
			System.out.println(cliente.getFechadeNacimiento());
		}
		else if (opcion == 4) {
			System.out.println(cliente.getNacionalidad());
		}
		else if (opcion == 5) {
			System.out.println(cliente.getEmail());
		}
		else if (opcion == 6) {
			System.out.println(cliente.getCelular());
		}
		else if (opcion == 7) {
			System.out.println(cliente.getLogin());
		}
		else {
			System.out.println("Seleccione una opcion valida");
		}
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

}
