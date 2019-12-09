package com.hbt.semillero.dto;

import java.io.Serializable;

import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.EstadoEnum;

/**
 * <b>Descripción:<b> Clase que determina el dto a usar para modificar,
 * consultar y posteriormente eliminar un rol
 * 
 * @author Lenin Narvaez
 */

public class RolDTO implements Serializable{
	
	/**
	 * Atributo que determina
	 */
	
	private long id;
	private String nombre;
	private long idPersonaje;
	private EstadoEnum estado;
	
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	
	public long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * 
	 * @param id El nuevo id a modificar.
	 */
	
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * 
	 * @return El nombre asociado a la clase
	 */
	
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * 
	 * @param nombre El nuevo nombre a modificar.
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo getIdPersonaje
	 * 
	 * @return El getIdPersonaje asociado a la clase
	 */
	
	public long getIdPersonaje() {
		return idPersonaje;
	}
	
	/**
	 * Metodo encargado de modificar el valor del atributo getIdPersonaje
	 * 
	 * @param getIdPersonaje El nuevo getIdPersonaje a modificar.
	 */

	public void setIdPersonaje(long idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estadoEnum
	 * 
	 * @return El estadoEnum asociado a la clase
	 */
	
	public EstadoEnum getEstado() {
		return estado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estadoEnum
	 * 
	 * @param estadoEnum El nuevo estadoEnum a modificar.
	 */
	
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	/**
	 * Método encargado de convertir los datos recibidos en JSON al tipo PersonajeDTO.
	 * <b>Caso de Uso:</b>
	 * 
	 * @param arg Cadena que representa el objeto complejo JSON.
	 * @return Instancia con los datos recibidos.
	 */
	public static RolDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, RolDTO.class);
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
