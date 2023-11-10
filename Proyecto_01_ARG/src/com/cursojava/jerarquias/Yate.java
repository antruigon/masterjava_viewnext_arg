package com.cursojava.jerarquias;

import com.cursojava.jerarquias.interfaces.Acuatico;

public class Yate extends Vehiculo implements Acuatico {

	/**
	 * Variable para todas las instancias de yate
	 */
	private String nombre;
	
	/**
	 * Constructor en el que se indica matricula, nombre y se asigna 0 como numero de ruedas
	 * @param matricula
	 * @param nombre
	 */
	public Yate(String matricula, String nombre) {
		super(matricula, 0);
		this.nombre = nombre;
	}

	/**
	 * Método navegar implementado desde de la interfaz Acuatico
	 */
	@Override
	public void navegar() {
		System.out.println("Navegando...");
	}

	/**
	 * Método atracar implementado desde la interfaz Acuatico
	 */
	@Override
	public void atracar() {
		System.out.println("Atracando yate, soltando ancla");

	}

	/**
	 * Método abstracto heredado de Vehiculo
	 */
	@Override
	public void parar() {
		System.out.println("Parando yate...");
	}

}
