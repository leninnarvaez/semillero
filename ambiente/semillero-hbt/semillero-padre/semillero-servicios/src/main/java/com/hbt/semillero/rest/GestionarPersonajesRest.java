package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//import org.hibernate.service.spi.InjectService;

import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.ejb.GestionarComicBean;
import com.hbt.semillero.ejb.GestionarPersonajeBean;
import com.hbt.semillero.ejb.IGestionarPersonajeLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * un personaje
 * 
 * @author Lenin Narvaez
 * @version
 */


@Path("/GestionarPersonaje2")
public class GestionarPersonajesRest {
	
	/**
	 * Atriburo que permite gestionar un personaje
	 */
	
	@EJB
	private IGestionarPersonajeLocal gestionarPersonajeBean;

	/**
	 * Crea las personas en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarRol/crear
	 * @param persona
	 * @return
	 */
	
	@POST
	@Path("/crear")
	public void crearPersonaje(PersonajeDTO personajeDTO) {
		gestionarPersonajeBean.crearPersonaje(personajeDTO);
	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersonaje/consultarPersonajes
	 * 
	 * @param idPersonaje
	 * @return
	 */
	
	@GET
	@Path("/consultarPersonajes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonajeDTO> consultarPersonajes(){
		return gestionarPersonajeBean.consultarPersonajes();		
	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersonaje/consultarPersonajesPorId?idComic=1
	 * 
	 * @param idComic
	 * @return
	 */
	
	@GET
	@Path("/consultarPersonajesPorId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonajeDTO> consultaPersonaje(@QueryParam("idComic") long idComic){
		return gestionarPersonajeBean.consultarPersonajes(idComic);
	}

}