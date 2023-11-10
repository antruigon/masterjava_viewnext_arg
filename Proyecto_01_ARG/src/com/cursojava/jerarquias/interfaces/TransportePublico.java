package com.cursojava.jerarquias.interfaces;

public interface TransportePublico {

	/**
	 * Método común para las subclases que implementen esta interfaz
	 */
	default void iniciarTrayecto() {
		System.out.println("Pongase cómodo, su trayecto va a inciar");
	};
	
}
