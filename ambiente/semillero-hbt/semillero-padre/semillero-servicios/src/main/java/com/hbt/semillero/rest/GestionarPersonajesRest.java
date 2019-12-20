package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.GestionarComicBean;
import com.hbt.semillero.ejb.GestionarPersonajeBean;
import com.hbt.semillero.ejb.IGestionarPersonajeLocal;
import com.hbt.semillero.exceptions.ComicException;
import com.hbt.semillero.exceptions.PersonajeException;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * un personaje
 * 
 * @author Lenin Narvaez
 * @version
 */


@Path("/GestionarPersonaje")
public class GestionarPersonajesRest {
	
	/**
	 * Atriburo que permite gestionar un personaje
	 */
	
	final static Logger logger = Logger.getLogger(GestionarComicBean.class);
	
	@EJB
	private IGestionarPersonajeLocal gestionarPersonajeBean;

	/**
	 * Crea las personas en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarRol/crear
	 * @param persona
	 * @return
	 * @throws PersonajeException 
	 */
	
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearPersonaje(PersonajeDTO personajeDTO) {
		
		try {
			gestionarPersonajeBean.crearPersonaje(personajeDTO);
			//ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Personaje creado exitosamente");			
			return Response.status(Response.Status.CREATED)
					.entity(personajeDTO)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}catch (PersonajeException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Fallo en la invocación del servicio " + e)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
		
//		try {
//			gestionarPersonajeBean.crearPersonaje(personajeDTO);
//		}catch (PersonajeException e) {
//			logger.error("Se capturo la excepcion y la informacion es: " + e.getCodigo() + "message: " + e.getMensaje());
//			throw new PersonajeException("COD-per-001","Error al realizar el llamado a la creacion de personaje",e);	
//		}
				
	}
	
	
	/**
	 * Crea las personas en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarRol/modificar
	 * @param persona
	 * @return
	 * @throws PersonajeException 
	 */
	
	@POST
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarPersonaje(PersonajeDTO personajeDTO) {
		
		try {
			gestionarPersonajeBean.actualizarPersonaje(personajeDTO);
			//ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Personaje creado exitosamente");			
			return Response.status(Response.Status.OK)
					.entity(personajeDTO)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}catch (PersonajeException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Fallo en la invocación del servicio " + e)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}		
	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersonaje/consultarPersonajes
	 * 
	 * @param idPersonaje
	 * @return
	 * @throws PersonajeException 
	 */
	
	@GET
	@Path("/consultarPersonajes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonajeDTO> consultarPersonajes() throws PersonajeException{
		
		try {
			return gestionarPersonajeBean.consultarPersonajes();	
		}catch (PersonajeException e) {
			logger.error("Se capturo la excepcion y la informacion es: " + e.getCodigo() + "message: " + e.getMensaje());
			throw new PersonajeException("COD-lj","Error al realizar el llamado cadena",e);	
		}						
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
	@Path("/consultarPersonajesPorParametro")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonajeDTO> consultarPersonajes(@QueryParam("index") int index, @QueryParam("cadena") String cadena){
		return gestionarPersonajeBean.consultarPersonajes(index, cadena);		
	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersonaje/consultarPersonajesPorId?idComic=1
	 * 
	 * @param idComic
	 * @return
	 * @throws PersonajeException 
	 */
	
	@GET
	@Path("/consultarPersonajesPorId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonajeDTO> consultaPersonaje(@QueryParam("idComic") long idComic) throws PersonajeException{
		
		try {
			return gestionarPersonajeBean.consultarPersonajes(idComic);
		}catch(PersonajeException e) {
			logger.error("Se capturo la excepcion y la informacion es: " + e.getCodigo() + "message: " + e.getMensaje());
			throw new PersonajeException("COD-lj02","Error al realizar el llamado cadena",e);
		}					
	}
	
	@GET
	@Path("/consultarDefault")
	@Produces(MediaType.APPLICATION_JSON)
	public double consultarDefault() {
		return gestionarPersonajeBean.defaultMethod();
	}

}