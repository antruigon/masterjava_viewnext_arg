package com.cursojava.jerarquias;

public abstract class Vehiculo {
	
	/**
	 * Variable común en todas las instancias para determinar el número de ruedas de un Vehiculo
	 */
	private int numeroRuedas;
	
	/**
	 * Variable que hay que establecer obligatoriamente y no se modificará
	 */
	private final String matricula;
	
	/**
	 * Variable que indica la antigüedad del Vehiculo
	 */
	private int edad;
	
	/**
	 * Variable que indica los años minimos que tendrá que tener un Vehiculo para que tenga que asistir a revisión
	 */
	private static final int PRIMERA_REVISION = 4;
	
	private static int numeroVehiculosMatriculados;

	/**
	 * Constructor "vacío", obligatorio matricula
	 */
	public Vehiculo(String matricula) {
		this.matricula = matricula;
		this.edad = 0;
		numeroVehiculosMatriculados += 1;
	}
	
	/**
	 * Constructor al que hay que indicarle numeroRuedas.
	 * @param numeroRuedas
	 * @param matricula
	 */
	public Vehiculo(String matricula, int numeroRuedas) {
		this.numeroRuedas = numeroRuedas;
		this.matricula = matricula;
		numeroVehiculosMatriculados += 1;
	}
	
	/**
	 * Método que sirve para comprobar si un Vehiculo ha pasado la primera revisión.
	 * Para ello se comrueba la edad, y si es menor o igual a 4 (supondríamos años) aparecerá un mensaje por pantalla u otro. 
	 */
	public void comprobarPrimeraRevision() {
		if(this.edad <= PRIMERA_REVISION) {
			System.out.println("El vehículo con matrícula "+ this.matricula + " no ha pasado todavía la primera revisión ya que tiene " + this.getEdad() + " años");
		}
		else {
			System.out.println("El vehículo con matrícula "+ this.matricula + " debe haber la primera revisión ya que tiene " + this.getEdad() + " años");
		}
	}
	
	/**
	 * Método común para todas las instancias (si no se sobreescribe) que muestra una frase por pantalla
	 */
	public void arrancar() {
		System.out.println("Arrancando vehículo con matrícula "+ this.matricula + " con " + this.numeroRuedas);
	}
	
	/**
	 * Método a definir en cada subclase
	 */
	public abstract void parar();
	
	/**
	 * Método que devuelve la edad de un vehiculo
	 * @return
	 */
	public int getEdad() {
		return this.edad;
	}
	
	/**
	 * Método para definir la edad de un vehículo
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Método para obtener la matrícula de un vehículo
	 * @return
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Metodo que devuelve el numero total de vehiculos matriculados
	 * @return
	 */
	public static int getNumeroVehiculosMatriculados() {
		return numeroVehiculosMatriculados;
	}
	
}
