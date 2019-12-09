package com.hbt.semillero.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAJE")
public class Personaje implements Serializable{

	/**
	 * Serializar es pasar un Objeto a un array de bytes y viceversa. Atributo que
	 * determina serialVersionUID es el id único que identifica una clase cuando lo
	 * serializamos. mediante este id podemos identificar el objeto convertido en un
	 * array de bytes.
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "PERSONAJE_ID_GENERATOR", sequenceName = "SEQ_PERSONAJE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONAJE_ID_GENERATOR")
	@Column(name = "PERS_ID")
	private long id;
	
	@Column(name = "PERS_NOMBRE")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERS_ID_COMIC")
	private Comic comic;
	
	@Column(name = "PERS_ESTADO")
	@Enumerated(value = EnumType.STRING)
	private EstadoEnum estado;
	
	@Column(name = "PERS_SOPERPODER")
	private String superPoder;

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
	 * Metodo encargado de retornar el valor del atributo comic
	 * 
	 * @return El comic asociado a la clase
	 */
	
	public Comic getComic() {
		return comic;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo comic
	 * 
	 * @param comic El nuevo estado a modificar.
	 */
	
	public void setComic(Comic comic) {
		this.comic = comic;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * 
	 * @return El estado asociado a la clase
	 */
	
	public EstadoEnum getEstado() {
		return estado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * 
	 * @param estado El nuevo estado a modificar.
	 */
	
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	public String getSuperPoder() {
		return superPoder;
	}

	public void setSuperPoder(String superPoder) {
		this.superPoder = superPoder;
	}
	
	
}



























