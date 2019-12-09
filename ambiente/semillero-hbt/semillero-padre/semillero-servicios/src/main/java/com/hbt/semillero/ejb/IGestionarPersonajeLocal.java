package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonajeDTO;

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
	 * 
	 * 
	 */
	public void crearPersonaje(PersonajeDTO personajeDTO);

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
	 */
	
	public List<PersonajeDTO> consultarPersonajes();

	/**
	 * 
	 * Metodo encargado de retornar una lista de personajes
	 * @author lenin
	 */
	
	public List<PersonajeDTO> consultarPersonajes(Long idComic);
	
	
}
