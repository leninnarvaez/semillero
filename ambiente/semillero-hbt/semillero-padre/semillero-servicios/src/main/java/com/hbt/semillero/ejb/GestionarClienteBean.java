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
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.CalcularIva;
import com.hbt.semillero.dto.ClienteDTO;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.entidad.Cliente;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Personaje;
import com.hbt.semillero.exceptions.ClienteException;
import com.hbt.semillero.exceptions.ComicException;
import com.hbt.semillero.exceptions.PersonajeException;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los clientes
 * 
 * @author Lenin
 * @version
 */
@Stateless
public class GestionarClienteBean implements IGestionarClienteLocal {

	final static Logger logger = Logger.getLogger(GestionarClienteBean.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * 
	 * @throws ClienteException 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#crearPersonaje()
	 */
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ClienteDTO crearCliente(ClienteDTO clienteDTO) throws ClienteException {
		logger.debug("Inicio del metodo CrearPersonaje");
		
		try {
			// Entidad nueva
			Cliente cliente = convertirDTOEntidad(clienteDTO);
			// Se almacena la informacion y se maneja la enidad comic
			logger.debug("Adentro del try: "+cliente);
			entityManager.persist(cliente);
			return convertirEntidadDTO(cliente);
		}catch(Exception e) {
			logger.error("Ha ocurrido un error al momento de crear el personaje: "+e);
			throw new ClienteException("COD-0001","Error ejecutando la creacion del personaje",e);
		}
				
	}



	public void consultarCliente() {
		logger.debug("Inicio del metodo ConsularPersonaje");
		
		logger.debug("fin del metodo ConsularPersonaje");
	}
	
	/**
	 * 
	 * @throws ClienteException 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#consultarPersonaje()
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<ClienteDTO> consultarClientes() throws ClienteException {
		logger.debug("Inicio del metodo ConsularClientes");
		try {
			String query = "SELECT cliente "
					+ "FROM Cliente cliente";
			
			List<Cliente> listaClientes = entityManager.createQuery(query).getResultList();
			
			List<ClienteDTO> listaClientesDTO = new ArrayList<>();
			
			for (Cliente cliente : listaClientes) {
				listaClientesDTO.add(convertirEntidadDTO(cliente));
			}
			
			return listaClientesDTO;
			
		}catch (Exception e) {
			logger.error("Ha ocurrido un error al momento de consultar el pesonaje");
			throw new ClienteException("COD-C-0002","Error creando personaje",e);
		}				
				
	}
	
	
		
	
	/**
 	 * Metodo encargado de transformar un personaje a un personajecDTO
	 * 
	 * @param comic
	 * @return
	**/

	private Cliente convertirDTOEntidad(ClienteDTO clienteDTO) {
		Cliente Cliente = new Cliente();
		Cliente.setId(clienteDTO.getId());
		Cliente.setNombre(clienteDTO.getNombre());
		Cliente.setComic(new Comic());		
		Cliente.setTipoDocumento(clienteDTO.getTipoDocumento());
				
		return Cliente;
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un clienteDTO a un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	
	private ClienteDTO convertirEntidadDTO(Cliente cliente) {
		ClienteDTO ClienteDTO = new ClienteDTO();
		ClienteDTO.setId(cliente.getId());
		ClienteDTO.setNombre(cliente.getNombre());		
		ClienteDTO.setTipoDocumento(cliente.getTipoDocumento());
		
		return ClienteDTO;
	}



	@Override
	public ClienteDTO actualizarCliente(ClienteDTO clienteDTO) throws ClienteException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void eliminarCliente() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<ClienteDTO> consultarClientes(Long idComic) throws ClienteException {
		// TODO Auto-generated method stub
		return null;
	}	

}
