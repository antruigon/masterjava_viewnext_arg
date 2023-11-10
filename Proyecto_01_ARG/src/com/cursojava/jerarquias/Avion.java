package com.cursojava.jerarquias;

import com.cursojava.jerarquias.interfaces.Aereo;
import com.cursojava.jerarquias.interfaces.TransportePublico;

public class Avion extends Vehiculo implements Aereo, TransportePublico {

	/**
	 * Variable para todas las instancias de Avion
	 */
	private int numeroPlazas;

	/**
	 * Constructor que asigna por defecto 5 ruedas y pide matricula y numero de plazas
	 * @param matricula
	 * @param numeroPlazas
	 */
	public Avion(String matricula, int numeroPlazas) {
		super(matricula, 5);
		this.numeroPlazas = numeroPlazas;
	}

	/**
	 * Método iniciarTrayecto implementado de la interfaz TransportePublico
	 */
	@Override
	public void iniciarTrayecto() {
		System.out.println("Pongase comodo, se va a iniciar el trayecto");

	}

	/**
	 * Método volar implementado de la interfaz Aereo
	 */
	@Override
	public void volar() {
		System.out.println("Su avión va a prodecer a arrancar el vuelo");

	}

	/**
	 * Sobreescrito metodo arrancar de la clase Vehiculo
	 */
	@Override
	public void arrancar() {
		System.out.println("Tocando botoncitos para arrancar el avión");
	}
	
	/**
	 * Método abstracto heredado de Vehiculo
	 */
	@Override
	public void parar() {
		System.out.println("Tocando botoncitos para parar el avión");
	}

	/**
	 * Método activarTrenAterrizajes implementado de la interfaz Aereo
	 */
	@Override
	public void activarTrenAterrizaje() {
		System.out.println("Desplegando tren de aterrizaje");
		
	}

	/*
	 * Método desactivarTrenAterrizaje implementado de la interfaz Aereo
	 */
	@Override
	public void desactivarTrenAterrizaje() {
		System.out.println("Recogiendo tren de aterrizaje");
		
	}

}
