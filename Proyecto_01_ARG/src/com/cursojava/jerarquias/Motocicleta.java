package com.cursojava.jerarquias;

import com.cursojava.jerarquias.interfaces.Terrestre;

public class Motocicleta extends Vehiculo implements Terrestre {

	/**
	 * Constructor que asigna 2 ruedas por defecto y pide la matrícula
	 * @param matricula
	 */
	public Motocicleta(String matricula) {
		super(matricula, 2);
	}

	/**
	 * Método circular implementado de la interfaz Terrestre
	 */
	@Override
	public void circular() {
		System.out.println("Motocicleta con matrícula " + super.getMatricula() + " circulando");
	}

	/**
	 * Método abstracto heredado de la clase Vehiculo
	 */
	@Override
	public void parar() {
		System.out.println("La motocicleta se parará entre dos coches");
	}

}
