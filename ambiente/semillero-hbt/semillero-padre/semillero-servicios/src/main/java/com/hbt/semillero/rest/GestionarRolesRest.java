package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

//import org.hibernate.service.spi.InjectService;


import com.hbt.semillero.dto.RolDTO;
import com.hbt.semillero.ejb.GestionarComicBean;
import com.hbt.semillero.ejb.IGestionarRolLocal;
import com.hbt.semillero.exceptions.RolException;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * un rol
 * 
 * @author Lenin Narvaez
 * @version
 */

@Path("/GestionarRol")
public class GestionarRolesRest {
	
	final static Logger logger = Logger.getLogger(GestionarComicBean.class);	
	/**
	 * Atriburo que permite gestionar un rol
	 */
	@EJB
	private IGestionarRolLocal gestionarRolBean;
	
	/**
	 * Crea las personas en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarRol/crear
	 * @param rol
	 * @return
	 * @throws PersonajeException 
	 */
	
	@POST
	@Path("/crear")
	public void crearRol(RolDTO rolDTO) throws RolException {
		
		try {
			gestionarRolBean.crearRol(rolDTO);
		}catch (RolException e) {
			logger.error("Se capturo la excepcion y la informacion es: " + e.getCodigo() + "message: " + e.getMensaje());
			throw new RolException("COD-per-001","Error al realizar el llamado a la creacion de personaje",e);	
		}
				
	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarRol/consultarRoles
	 * 
	 * @param idRol
	 * @return
	 * @throws RolException 
	 */
	
	@GET
	@Path("/consultarRoles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RolDTO> consultarRoles() throws RolException{
		
		try {
			return gestionarRolBean.consultarRoles();
		}catch (RolException e) {
			logger.error("Se capturo la excepcion y la informacion es: " + e.getCodigo() + "message: " + e.getMensaje());
			throw new RolException("COD-rol-001","Error al realizar el llamado a la consulta de personaje",e);
		}						
	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarRol/consultarRolesPorId?idPersonaje=1
	 * 
	 * @param idPersonaje
	 * @return
	 * @throws RolException 
	 */
	
	@GET
	@Path("/consultarRolesPorId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RolDTO> consultaRol(@QueryParam("idPersonaje") long idPersonaje) throws RolException{
		
		try {
			return gestionarRolBean.consultarRoles(idPersonaje);
		}catch (RolException e) {
			logger.error("Se capturo la excepcion y la informacion es: " + e.getCodigo() + "message: " + e.getMensaje());
			throw new RolException("COD-rol-002","Error al realizar el llamado a la consulta de personaje",e);
		}
		
		
	}

}