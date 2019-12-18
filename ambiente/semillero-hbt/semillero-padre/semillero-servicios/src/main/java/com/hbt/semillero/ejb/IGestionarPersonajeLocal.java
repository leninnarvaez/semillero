package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.exceptions.PersonajeException;

/**
 * Expone los métodos del EJB GestionarPersonaje Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author Lenin
 *
 */
@Local
public interface IGestionarPersonajeLocal {

	/**
	 * 
	 * Metodo encargado de crear un personaje
	 * 
	 * @author Lenin
	 * @throws PersonajeException 
	 * 
	 * 
	 */
	public void crearPersonaje(PersonajeDTO personajeDTO) throws PersonajeException;

	/**
	 * 
	 * Metodo encargado de actualizar un personaje 
	 * 
	 * @author lenin
	 * 
	 */
	public void actualizarPersonaje();

	/**
	 * 
	 * Metodo encargado de eliminar un personaje 
	 * 
	 * @author lenin
	 * 
	 * 
	 */
	public void eliminarPersonaje();
		
	/**
	 * 
	 * Metodo encargado de retornar la informacion de un personaje
	 * @author lenin
	 */
	
	public void consultarPersonaje();
	/**
	 * 
	 * Metodo encargado de retornar la informacion de un personaje
	 * @author lenin
	 * @throws PersonajeException 
	 */
	
	public List<PersonajeDTO> consultarPersonajes() throws PersonajeException;

	/**
	 * 
	 * Metodo encargado de retornar una lista de personajes
	 * @author lenin
	 * @throws PersonajeException 
	 */
	
	public List<PersonajeDTO> consultarPersonajes(Long idComic) throws PersonajeException;
	
	
	public List<PersonajeDTO> consultarPersonajes(int index, String cadena);
	
	
	default double defaultMethod() {
		System.out.println("Interface A Default Method");
		return 0;
	}
}
