package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.dto.RolDTO;

/**
 * Expone los métodos del EJB GestionarRol Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author Lenin
 *
 */
@Local
public interface IGestionarRolLocal {

	/**
	 * 
	 * Metodo encargado de crear un rol	
	 * @author Lenin	 
	 * 
	 */
	public void crearRol(RolDTO rolDTO);

	/**
	 * 
	 * Metodo encargado de actualizar un rol 	 
	 * @author lenin	 
	 * 
	 */
	public void actualizarRol();

	/**
	 * 
	 * Metodo encargado de eliminar un rol 
	 * @author lenin	  
	 * 
	 */
	public void eliminarRol();
		
	/**
	 * 
	 * Metodo encargado de retornar la informacion de un rol
	 * @author lenin
	 */
	
	public void consultarRol();
	/**
	 * 
	 * Metodo encargado de retornar la informacion de un rol
	 * @author lenin
	 */
	
	public List<RolDTO> consultarRoles();

	/**
	 * 
	 * Metodo encargado de retornar una lista de roles
	 * @author lenin
	 */
	
	
	public List<RolDTO> consultarRoles(Long idPersonaje);
		
}
