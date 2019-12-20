package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ClienteDTO;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.exceptions.ClienteException;
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
public interface IGestionarClienteLocal {

	/**
	 * 
	 * Metodo encargado de crear un personaje
	 * 
	 * @author Lenin
	 * @throws PersonajeException 
	 * 
	 * 
	 */
	public ClienteDTO crearCliente(ClienteDTO clienteDTO) throws ClienteException;

	/**
	 * 
	 * Metodo encargado de actualizar un personaje 
	 * 
	 * @author lenin
	 * @throws PersonajeException 
	 * 
	 */
	public ClienteDTO actualizarCliente(ClienteDTO clienteDTO) throws ClienteException;

	/**
	 * 
	 * Metodo encargado de eliminar un personaje 
	 * 
	 * @author lenin
	 * 
	 * 
	 */
	public void eliminarCliente();
		
	/**
	 * 
	 * Metodo encargado de retornar la informacion de un personaje
	 * @author lenin
	 */
	
	public void consultarCliente();
	/**
	 * 
	 * Metodo encargado de retornar la informacion de un personaje
	 * @author lenin
	 * @throws PersonajeException 
	 */
	
	public List<ClienteDTO> consultarClientes() throws ClienteException;

	/**
	 * 
	 * Metodo encargado de retornar una lista de personajes
	 * @author lenin
	 * @throws PersonajeException 
	 */
	
	public List<ClienteDTO> consultarClientes(Long idComic) throws ClienteException;
	
	
}
