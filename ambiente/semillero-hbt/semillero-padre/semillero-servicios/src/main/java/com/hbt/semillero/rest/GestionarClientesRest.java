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

import com.hbt.semillero.dto.ClienteDTO;
import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.GestionarClienteBean;
import com.hbt.semillero.ejb.GestionarComicBean;
import com.hbt.semillero.ejb.GestionarPersonajeBean;
import com.hbt.semillero.ejb.IGestionarClienteLocal;
import com.hbt.semillero.ejb.IGestionarPersonajeLocal;
import com.hbt.semillero.exceptions.ClienteException;
import com.hbt.semillero.exceptions.ComicException;
import com.hbt.semillero.exceptions.PersonajeException;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * un personaje
 * 
 * @author Lenin Narvaez
 * @version
 */


@Path("/GestionarCliente")
public class GestionarClientesRest {
	
	/**
	 * Atriburo que permite gestionar un personaje
	 */
	
	final static Logger logger = Logger.getLogger(GestionarClienteBean.class);
	
	@EJB
	private IGestionarClienteLocal gestionarClienteBean;

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
	public Response crearCliente(ClienteDTO clienteDTO) {
		
		try {
			gestionarClienteBean.crearCliente(clienteDTO);
			//ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Personaje creado exitosamente");			
			return Response.status(Response.Status.CREATED)
					.entity(clienteDTO)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}catch (ClienteException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Fallo en la invocación del servicio " + e)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
						
	}
	
		
	
	@GET
	@Path("/consultarClientes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteDTO> consultarClientes() throws ClienteException{
		logger.debug("Iniciando el servicio consultar clientesS");
		try {
			return gestionarClienteBean.consultarClientes();	
		}catch (ClienteException e) {
			logger.error("Se capturo la excepcion y la informacion es: " + e.getCodigo() + "message: " + e.getMensaje());
			throw new ClienteException("COD-lj","Error al realizar el llamado cadena",e);	
		}						
	}	
}