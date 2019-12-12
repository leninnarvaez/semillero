package com.hbt.semillero.dto;

import com.hbt.semillero.interfaces.IConsultarIva;

public class CalcularIva implements IConsultarIva{

	private double precio;
	
	
	
	
	public double getPrecio() {
		return precio;
	}




	public void setPrecio(float precio) {
		this.precio = precio;
	}




	@Override
	public double calcularIva() {
		// TODO Auto-generated method stub
		return precio*0.19;
	}

}
