package com.cursojava.jerarquias;

public class Lancha extends Vehiculo implements Acuatico {

	/**
	 * Variable para todas las instancias de Lancha
	 */
	private int numeroMotores;
	
	/** Constructor en el que se indica matricula, nombre y se asigna 0 como numero de ruedas
	 * @param matricula
	 * @param numeroMotores
	 */
	public Lancha(String matricula, int numeroMotores) {
		super(matricula, 0);
		this.numeroMotores = numeroMotores;
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
		System.out.println("Atracando lancha, procedemos a tirar la cuerda");

	}

	/**
	 * Método heredado de Vehiculo sobreescrito
	 */
	@Override
	public void arrancar() {
		System.out.println("Encencdiendo motores de la lancha");
	}
	
	/**
	 * Método abstracto heredado de Vehiculo
	 */
	@Override
	public void parar() {
		System.out.println("Parando motores de la lancha");
	}

}
