package com.hbt.semillero.interfaces;

import javax.ejb.Local;

@FunctionalInterface
@Local
public interface IConsultarIva {

	public double calcularIva();
}
