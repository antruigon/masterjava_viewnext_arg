package com.cursojava.jerarquias;

public class Coche extends Vehiculo implements Terrestre {

	private String marca;
	
	
	/**
	 * Constructor que asigna por defecto 4 ruedas y pide la matrícula y la marca
	 * @param matricula
	 * @param marca
	 */
	public Coche(String matricula, String marca) {
		super(matricula, 4);
		this.marca = marca;
	}

	
	/**
	 * Método circular implementado de la interfaz Terrestre
	 */
	@Override
	public void circular() {
		System.out.println("Coche con matrícula " + super.getMatricula() + " circulando");

	}

	/**
	 * Método abstracto heredado de la clase Vehiculo
	 */
	@Override
	public void parar() {
		System.out.println("Estacionando vehículo");

	}

}
