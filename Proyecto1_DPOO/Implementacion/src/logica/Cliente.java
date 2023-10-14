package logica;

public class Cliente extends Persona{
	public String clientedelaEmpresa;
	public double licenciadeConduccion;
	public double metododePago;
	public Cliente(String cargo,String nombre, double cedula, String fechadeNacimiento, String nacionalidad, String email,
			double celular, String login, String password) {
		super(cargo, nombre, cedula, fechadeNacimiento, nacionalidad, email, celular, login, password);
		// TODO Auto-generated constructor stub
	}
	
}
