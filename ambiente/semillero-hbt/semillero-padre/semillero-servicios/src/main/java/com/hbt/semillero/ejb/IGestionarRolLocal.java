package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.dto.RolDTO;
import com.hbt.semillero.exceptions.PersonajeException;
import com.hbt.semillero.exceptions.RolException;

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
	 * @throws PersonajeException 
	 * @throws RolException 
	 * 
	 */
	public void crearRol(RolDTO rolDTO) throws RolException;

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
	 * @throws RolException 
	 */
	
	public List<RolDTO> consultarRoles() throws RolException;

	/**
	 * 
	 * Metodo encargado de retornar una lista de roles
	 * @author lenin
	 * @throws RolException 
	 */
	
	
	public List<RolDTO> consultarRoles(Long idPersonaje) throws RolException;
		
}
