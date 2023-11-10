package com.cursojava.jerarquias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cursojava.jerarquias.interfaces.Acuatico;
import com.cursojava.jerarquias.interfaces.Aereo;
import com.cursojava.jerarquias.interfaces.Terrestre;
import com.cursojava.jerarquias.interfaces.TransportePublico;

public class Principal {

	public static void main(String[] args) {

		/**
		 * Creamos una lista de vehículos
		 */
		int edadMaximaVehiculo = 7; // Variable que usaremos como maximo a la hora de definir una edad aleatoria
		List<Vehiculo> listaVehiculos = crearVehiculos(edadMaximaVehiculo);
		System.out.println("Se ha cargado una lista de " + listaVehiculos.size() + " vehiculos");
		
		accionarVehiculos(listaVehiculos);
		
		int numeroVehiculosMatriculados = Vehiculo.getNumeroVehiculosMatriculados();
		System.out.println("\n En total hay " + numeroVehiculosMatriculados + " vehículos matriculados en el sistema");
		
	}

	/**
	 * Método que crea un vehiculo de cada tipo con una edad aleatoria hasta un maximo dado
	 */
	private static List<Vehiculo> crearVehiculos(int edadMax) {
		
		List<Vehiculo> listaVehiculos = new ArrayList<>();
		
		Vehiculo yate = new Yate("1111", "Yate molon");
		Vehiculo lancha = new Lancha("2222", 2);
		Vehiculo motocicleta = new Motocicleta("3333");
		Vehiculo coche = new Coche("4444", "Peugeot");
		Vehiculo autobus = new Autobus("5555", 80);
		Vehiculo avion = new Avion("6666", 300);
		
		Collections.addAll(listaVehiculos, yate, lancha, motocicleta, coche, autobus, avion);
		
		for(Vehiculo v: listaVehiculos) {
			int edadAleatoria = (int) (Math.random() * edadMax) + 1; // Genera un numero aleatorio >0 y <= edadMax
			v.setEdad(edadAleatoria);
		}
		
		return listaVehiculos;
	}
	
	/**
	 * Método que ejecutará las acciones de los vehículos
	 * @param lista
	 */
	private static void accionarVehiculos(List<Vehiculo> lista) {
		System.out.println("\nEjecutando acciones: \n");
		
		for(Vehiculo vehiculo: lista) {
			System.out.println("***********************************************************");
			System.out.println("(Debug) Clase ejecutada: "+vehiculo.getClass());
			vehiculo.arrancar();
			vehiculo.comprobarPrimeraRevision();
			vehiculo.parar();
			
			if(vehiculo instanceof Acuatico) {
				((Acuatico) vehiculo).navegar();
				((Acuatico) vehiculo).atracar();
			}
			
			if (vehiculo instanceof Terrestre){
				((Terrestre) vehiculo).circular();
			}
			
			if (vehiculo instanceof Aereo) {
				
				try {
					((Aereo) vehiculo).volar();
				} catch (ExcepcionAereo e) {
					System.out.println(e.getMessage());
				}
				
				((Aereo) vehiculo).desactivarTrenAterrizaje();
				
				try {
					((Aereo) vehiculo).volar();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			if (vehiculo instanceof TransportePublico) {
				((TransportePublico) vehiculo).iniciarTrayecto();
			}
			
			System.out.println("\nTodas las ejecuciones del vehiculo realizadas");
			System.out.println("***********************************************************\n");
		}
	}
	
}
