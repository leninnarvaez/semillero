/**
 * GestionarPersonajeBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidad.Comic;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los personajes
 * 
 * @author Lenin
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarPersonajeBean implements IGestionarPersonajeLocal {

	
	final static Logger logger = Logger.getLogger(GestionarPersonajeBean.class);
	
	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#crearPersonaje()
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersonaje() {
		logger.debug("Inicio del metodo CrearPersonaje");
		
		logger.debug("fin del metodo CrearPersonaje");
		
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#modificarPersonaje()
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarPersonaje() {
		logger.debug("Inicio del metodo modificarPersonaje");
		
		logger.debug("fin del metodo modificarPersonaje");
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#eliminarPersonaje()
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarPersonaje() {
		logger.debug("Inicio del metodo eliminarPersonaje");
		
		logger.debug("fin del metodo eliminarPersonaje");
	}

	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#consultarPersonaje()
	 */

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PersonajeDTO consultarPersonaje() {
		logger.debug("Inicio del metodo ConsularPersonaje");
		
		logger.debug("fin del metodo ConsularPersonaje");
	}

	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#consultarPersonaje()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PersonajeDTO> consultarPersonajes() {
		logger.debug("Inicio del metodo listarPersonaje");
		
		logger.debug("fin del metodo listarPersonaje");
		
	}

}
