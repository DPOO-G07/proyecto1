package presentacion;

import java.io.BufferedReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logica.Cliente;
import logica.Empleado;
import logica.Persona;
import logica.Reserva;
import logica.Sede;

import java.io.FileReader;



public class carga {
	public static Principal Leer(String archivo, String archivo2, String archivo3) {
		try {

			Map <String, Persona> Personas = new HashMap<>();
			Map <String, Sede> Menu = new HashMap<>();
			Map <String, Reserva> Ingredientes = new HashMap<>();
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea;
			while((linea=br.readLine()) != null) {
				String [] partes = linea.split(";");
				// este archivo tiene que ser el que contenga las personas 
				String elcargo = partes[0];
				String elnombre = partes[1];
				double lacedula = Double.parseDouble(partes[2]);
				String lafechadeNacimiento = partes[3];
				String lanacionalidad = partes[4];
				String elemail = partes[5];
				double elcelular = Double.parseDouble(partes[6]);
				String ellogin = partes[7];
				String lapassword = partes[8];
				
				if (elcargo == "cliente") {
					Persona lapersona = new Cliente(elcargo, elnombre, lacedula, lafechadeNacimiento, lanacionalidad, elemail, elcelular, ellogin, lapassword);
					Personas.put(elnombre, lapersona);
					}
				else {
					Persona lapersona = new Empleado(elcargo, elnombre, lacedula, lafechadeNacimiento, lanacionalidad, elemail, elcelular, ellogin, lapassword);
					Personas.put(elnombre, lapersona);
					
				}
				
				
			}
			br.close();
			BufferedReader br1 = new BufferedReader(new FileReader(archivo2));
			String linea1;
			while((linea1=br1.readLine()) != null) {
				String [] partes = linea1.split(";");
			
				String nombre = partes[0];
				Double precio = Double.parseDouble(partes[1]);
				Menu elmenu = new Menu(nombre, precio);
				Menu.put(nombre, elmenu);
			}
			br1.close();
			BufferedReader br2 = new BufferedReader(new FileReader(archivo3));
			String linea2;
			while((linea2=br2.readLine()) != null) {
				String [] partes = linea2.split(";");
			
				String nombre = partes[0];
				Double precio = Double.parseDouble(partes[1]);
				Ingredientes elingrediente = new Ingredientes (nombre, precio);
				Ingredientes.put(nombre, elingrediente);
			}
			br2.close();
		
			
		
			
		
			Restaurante res = new Restaurante(Combos, Menu, Ingredientes, pedido);
			return res;



	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;

}

}
