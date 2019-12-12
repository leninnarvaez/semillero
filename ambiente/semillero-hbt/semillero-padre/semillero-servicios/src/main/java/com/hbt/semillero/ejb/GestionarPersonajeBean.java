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

import com.hbt.semillero.dto.CalcularIva;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Personaje;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los personajes
 * 
 * @author Lenin
 * @version
 */
@Stateless
public class GestionarPersonajeBean implements IGestionarPersonajeLocal {

	final static Logger logger = Logger.getLogger(GestionarPersonajeBean.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#crearPersonaje()
	 */
	@Override
	public void crearPersonaje(PersonajeDTO personajeDTO) {
		logger.debug("Inicio del metodo CrearPersonaje");
		Personaje personaje = convertirDTOEntidad(personajeDTO);
		entityManager.persist(personaje);
		logger.debug("fin del metodo CrearPersonaje");
		
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#modificarPersonaje()
	 */
	@Override
	public void actualizarPersonaje() {
		logger.debug("Inicio del metodo modificarPersonaje");
		
		logger.debug("fin del metodo modificarPersonaje");
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#eliminarPersonaje()
	 */
	@Override
	public void eliminarPersonaje() {
		logger.debug("Inicio del metodo eliminarPersonaje");
		
		logger.debug("fin del metodo eliminarPersonaje");
	}


	public void consultarPersonaje() {
		logger.debug("Inicio del metodo ConsularPersonaje");
		
		logger.debug("fin del metodo ConsularPersonaje");
	}
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#consultarPersonaje()
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonajeDTO> consultarPersonajes() {
		logger.debug("Inicio del metodo ConsularPersonaje");
		
		String query = "SELECT personaje "
				+ "FROM Personaje personaje";
		
		List<Personaje> listaPersonajes = entityManager.createQuery(query).getResultList();
		
		List<PersonajeDTO> listaPersonajesDTO = new ArrayList<>();
		
		for (Personaje personaje : listaPersonajes) {
			listaPersonajesDTO.add(convertirEntidadDTO(personaje));
		}
		
		logger.debug("fin del metodo ConsularPersonaje");
		return listaPersonajesDTO;
	}
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#consultarPersonaje()
	 */
	@Override
	public List<PersonajeDTO> consultarPersonajes(Long idComic) {
		logger.debug("Inicio del metodo ConsularPersonaje");
		
		String query = "SELECT personaje "
				+ "FROM Personaje personaje "
				+ "WHERE personaje.comic.id = :idComic";
		
		List<Personaje> listaPersonajes = entityManager.createQuery(query)
				.setParameter("idComic", idComic).getResultList();
		
		List<PersonajeDTO> listaPersonajesDTO = new ArrayList<>();
		
		for (Personaje personaje : listaPersonajes) {
			listaPersonajesDTO.add(convertirEntidadDTO(personaje));
		}
		
		logger.debug("fin del metodo ConsularPersonaje");
		return listaPersonajesDTO;
	}
		
	
	/**
 	 * Metodo encargado de transformar un personaje a un personajecDTO
	 * 
	 * @param comic
	 * @return
	**/

	private Personaje convertirDTOEntidad(PersonajeDTO personajeDTO) {
		Personaje Personaje = new Personaje();
		Personaje.setId(personajeDTO.getId());
		Personaje.setNombre(personajeDTO.getNombre());
		Personaje.setComic(new Comic());
		Personaje.getComic().setId(personajeDTO.getIdComic());;
		Personaje.setEstado(personajeDTO.getEstado());
		Personaje.setSuperPoder(personajeDTO.getSuperPoder());		
		return Personaje;
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un personajeDTO a un personaje
	 * 
	 * @param personaje
	 * @return
	 */
	
	private PersonajeDTO convertirEntidadDTO(Personaje personaje) {
		PersonajeDTO PersonajeDTO = new PersonajeDTO();
		PersonajeDTO.setId(personaje.getId());
		PersonajeDTO.setNombre(personaje.getNombre());
		PersonajeDTO.setIdComic(personaje.getComic().getId());
		PersonajeDTO.setEstado(personaje.getEstado());
		PersonajeDTO.setSuperPoder(personaje.getSuperPoder());
		return PersonajeDTO;
	}
	
	
	@Override
	public double defaultMethod() {
		
		CalcularIva cIva = new CalcularIva();
		cIva.setPrecio(5000);
		double valorIva = cIva.getPrecio();
		logger.debug("El valor de Iva es: " + valorIva);
		
		return valorIva;
	}

}























