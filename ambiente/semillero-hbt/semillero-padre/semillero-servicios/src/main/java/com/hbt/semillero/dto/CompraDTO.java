package com.hbt.semillero.dto;

import java.io.Serializable;

import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.EstadoEnum;
import com.hbt.semillero.entidad.TipoDocumentoEnum;

/**
 * <b>Descripción:<b> Clase que determina el dto a usar para modificar,
 * consultar y posteriormente eliminar un personaje
 * 
 * @author Lenin Narvaez
 */

public class CompraDTO implements Serializable{
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getScid() {
		return scid;
	}

	public void setScid(long scid) {
		this.scid = scid;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Atributo que determina
	 */
	
	private long id;
	private long scid;
	private String fecha;
	
	
	

	/**
	 * Método encargado de convertir los datos recibidos en JSON al tipo PersonajeDTO.
	 * <b>Caso de Uso:</b>
	 * 
	 * @param arg Cadena que representa el objeto complejo JSON.
	 * @return Instancia con los datos recibidos.
	 */
	public static CompraDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, CompraDTO.class);
	}

	/**
	 * Método encargado de convertir los datos recibidos en PersonajeDTO al JSON
	 * esperado
	 * 
	 * @param dto DTO
	 * 
	 * @return Json
	 */
	@Override
	public String toString() {
		return JsonUtils.toStringJson(this);
	}
}
