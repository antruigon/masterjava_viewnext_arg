package com.cursojava.jerarquias;

public class ExcepcionAereo extends Exception{
	
	private int codigoError;

	public ExcepcionAereo(int codigoError) {
		super();
		this.codigoError = codigoError;
	}

	@Override
	public String getMessage() {
		String mensaje = "";
		if(this.codigoError == 111) {
			mensaje = "No puede volar. Tren de aterrizaje desplegado";
		}
		return mensaje;
	}
}
