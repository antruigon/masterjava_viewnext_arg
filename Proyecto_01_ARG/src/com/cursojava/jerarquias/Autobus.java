package com.cursojava.jerarquias;

import com.cursojava.jerarquias.interfaces.Terrestre;
import com.cursojava.jerarquias.interfaces.TransportePublico;

public class Autobus extends Vehiculo implements Terrestre, TransportePublico {

	/**
	 * Variable para todas las instancias de Autobus
	 */
	private int numeroPlazas;
	
	/**
	 * Constructor que asigna por defecto 6 ruedas y pide matricula y numero de plazas
	 * @param matricula
	 * @param numeroPlazas
	 */
	public Autobus(String matricula, int numeroPlazas) {
		super(matricula, 6);
		this.numeroPlazas = numeroPlazas;
	}

//	/**
//	 * Método iniciarTrayecto implementado de la interfaz TransportePublico
//	 */
//	@Override
//	public void iniciarTrayecto() {
//		System.out.println("Pongase comodo, se va a iniciar el trayecto");
//
//	}

	/**
	 * Método circular implementado de la interfaz Terrestre
	 */
	@Override
	public void circular() {
		System.out.println("Autobus circulando");
	}

	/**
	 * Método abstracto heredado de la clase Vehiculo
	 */
	@Override
	public void parar() {
		System.out.println("Llegando a su destino");
	}

	public int getNumeroPlazas() {
		return this.numeroPlazas;
	}
}
