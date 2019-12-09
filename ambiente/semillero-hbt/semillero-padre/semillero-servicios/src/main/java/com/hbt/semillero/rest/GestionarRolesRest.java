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


import com.hbt.semillero.dto.RolDTO;
import com.hbt.semillero.ejb.IGestionarRolLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * un rol
 * 
 * @author Lenin Narvaez
 * @version
 */

@Path("/GestionarRol")
public class GestionarRolesRest {
	
	
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
	 */
	
	@POST
	@Path("/crear")
	public void crearRol(RolDTO rolDTO) {
		gestionarRolBean.crearRol(rolDTO);
	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarRol/consultarRoles
	 * 
	 * @param idRol
	 * @return
	 */
	
	@GET
	@Path("/consultarRoles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RolDTO> consultarRoles(){
		return gestionarRolBean.consultarRoles();
		
	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarRol/consultarRolesPorId?idPersonaje=1
	 * 
	 * @param idPersonaje
	 * @return
	 */
	
	@GET
	@Path("/consultarRolesPorId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RolDTO> consultaRol(@QueryParam("idPersonaje") long idPersonaje){
		return gestionarRolBean.consultarRoles(idPersonaje);
	}

}