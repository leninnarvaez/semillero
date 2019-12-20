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
import com.hbt.semillero.dto.CompraDTO;
import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.entidad.Cliente;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Personaje;
import com.hbt.semillero.exceptions.ClienteException;
import com.hbt.semillero.exceptions.ComicException;
import com.hbt.semillero.exceptions.CompraException;
import com.hbt.semillero.exceptions.PersonajeException;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los clientes
 * 
 * @author Lenin
 * @version
 */
@Stateless
public class GestionarCompraBean implements IGestionarCompraLocal {

	final static Logger logger = Logger.getLogger(GestionarCompraBean.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * 
	 * @throws ClienteException 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#crearPersonaje()
	 */
/**	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public CompraDTO compraCliente(CompraDTO compraDTO) throws CompraException {
		logger.debug("Inicio del metodo CrearPersonaje");
		
		try {
			// Entidad nueva
			Compra compra = convertirDTOEntidad(compraDTO);
			// Se almacena la informacion y se maneja la enidad comic
			logger.debug("Adentro del try: "+compra);
			entityManager.persist(compra);
			return convertirEntidadDTO(compra);
		}catch(Exception e) {
			logger.error("Ha ocurrido un error al momento de crear el personaje: "+e);
			throw new ClienteException("COD-0001","Error ejecutando la creacion del personaje",e);
		}
				
	}



	
	/**
	 * 
	 * @throws ClienteException 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#consultarPersonaje()
	 */
/**
	@SuppressWarnings("unchecked")
	@Override
	public List<CompraDTO> consultarCompra() throws CompraException {
		logger.debug("Inicio del metodo ConsularClientes");
		try {
			String query = "SELECT cliente "
					+ "FROM Cliente cliente";
			
			List<Compra> listaCompras = entityManager.createQuery(query).getResultList();
			
			List<CompraDTO> listaComprasDTO = new ArrayList<>();
			
			for (Cliente compra : listaCompras) {
				listaComprasDTO.add(convertirEntidadDTO(compra));
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


@Override
public CompraDTO compraCliente(CompraDTO compraDTO) throws CompraException {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void consultarCompra() {
	// TODO Auto-generated method stub
	
}


@Override
public List<CompraDTO> consultarCompras() throws CompraException {
	// TODO Auto-generated method stub
	return null;
}


@Override
public List<CompraDTO> consultarCompras(Long idComic) throws CompraException {
	// TODO Auto-generated method stub
	return null;
}
	
	/**
	 * 
	 * Metodo encargado de transformar un clienteDTO a un cliente
	 * 
	 * @param cliente
	 * @return
	 */
	/**
	private CompraDTO convertirEntidadDTO(Compra compra) {
		CompraDTO CompraDTO = new CompraDTO();
		CompraDTO.setId(compra.getId());
		CompraDTO.setNombre(compra.getNombre());		
		CompraDTO.setTipoDocumento(compra.getTipoDocumento());
		
		return CompraDTO;
	}
*/
}
