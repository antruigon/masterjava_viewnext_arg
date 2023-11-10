package com.cursojava.jerarquias.interfaces;

import com.cursojava.jerarquias.ExcepcionAereo;

public interface Aereo {
	
	/**
	 * Método común a todos los subtipos que implementen esta interfaz
	 * @throws ExcepcionAereo 
	 */
	void volar() throws ExcepcionAereo;
	void activarTrenAterrizaje();
	void desactivarTrenAterrizaje();
}
