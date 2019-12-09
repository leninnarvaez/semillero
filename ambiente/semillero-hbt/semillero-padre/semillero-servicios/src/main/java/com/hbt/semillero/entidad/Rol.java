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
@Table(name = "ROL")
public class Rol implements Serializable{

	/**
	 * Serializar es pasar un Objeto a un array de bytes y viceversa. Atributo que
	 * determina serialVersionUID es el id único que identifica una clase cuando lo
	 * serializamos. mediante este id podemos identificar el objeto convertido en un
	 * array de bytes.
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "ROL_ID_GENERATOR", sequenceName = "SEQ_ROL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_ID_GENERATOR")
	@Column(name = "ROL_ID")
	private long id;
	
	@Column(name = "ROL_NOMBRE")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROL_ID_PERSONAJE")
	private Personaje personaje;
	
	@Column(name = "ROL_ESTADO")
	@Enumerated(value = EnumType.STRING)
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
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * 
	 * @param nombre El nuevo nombre a modificar.
	 */
	
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo personaje
	 * 
	 * @return El estado asociado a la clase
	 */

	
	public Personaje getPersonaje() {
		return personaje;
	}
	
	/**
	 * Metodo encargado de modificar el valor del atributo personaje
	 * 
	 * @param personaje El nuevo estado a modificar.
	 */

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
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

	
}
