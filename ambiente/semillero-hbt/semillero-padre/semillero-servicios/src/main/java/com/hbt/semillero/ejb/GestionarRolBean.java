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
import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.dto.RolDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Personaje;
import com.hbt.semillero.entidad.Rol;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los roles
 * 
 * @author Lenin
 * @version
 */
@Stateless
public class GestionarRolBean implements IGestionarRolLocal {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	private static final Logger logger = Logger.getLogger(GestionarRolBean.class);
	

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarRolLocal#crearRol()
	 * @descripcion metodo para crear rol
	 * @author Lenin Narvaez
	 */
	@Override
	public void crearRol(RolDTO rolDTO) {
		logger.debug("Inicio del metodo CrearRol");
		Rol rol = convertirDTOEntidad(rolDTO);
		entityManager.persist(rol);
		logger.debug("fin del metodo CrearRol");		
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarRolLocal#modificarRol()
	 * @descripcion metodo para actualizar rol
	 * @author Lenin Narvaez
	 */
	@Override
	public void actualizarRol() {
		logger.debug("Inicio del metodo actualizarRol");
		
		logger.debug("fin del metodo actualizarRol");
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarRolLocal#eliminarRol()
	 * @descripcion metodo para crear eliminar rol
	 * @author Lenin Narvaez
	 */
	@Override
	public void eliminarRol() {
		logger.debug("Inicio del metodo eliminarRol");
		
		logger.debug("fin del metodo eliminarRol");
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarRolLocal#consultarRol()
	 * @descripcion metodo para consultar rol
	 * @author Lenin Narvaez
	 */

	public void consultarRol() {
		logger.debug("Inicio del metodo ConsularRol");
		
		logger.debug("fin del metodo ConsularRol");
	}
	
	/**	 
	 * @see com.hbt.semillero.ejb.IGestionarPersonajeLocal#consultarRoles()
	 * @descripcion metodo para Consultar roles
	 * @author Lenin Narvaez
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<RolDTO> consultarRoles() {
		logger.debug("Inicio del metodo ConsularRol");
		
		String query = "SELECT rol "
				+ "FROM Rol rol";
		
		List<Rol> listaRoles = entityManager.createQuery(query).getResultList();
		
		List<RolDTO> listaRolesDTO = new ArrayList<>();
		
		for (Rol rol : listaRoles) {
			listaRolesDTO.add(convertirEntidadDTO(rol));
		}
		
		logger.debug("fin del metodo ConsularRol");
		return listaRolesDTO;
	}
	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarRolLocal#consultarRol()
	 * @descripcion metodo para consultar roles
	 * @author Lenin Narvaez
	 */
	
	@Override
	public List<RolDTO> consultarRoles(Long idPersonaje) {
		logger.debug("Inicio del metodo ConsularRol");
		
		String query = "SELECT rol "
				+ "FROM Rol rol "
				+ "WHERE rol.personaje.id = :idPersonaje";
		
		List<Rol> listaRoles = entityManager.createQuery(query)
				.setParameter("idPersonaje", idPersonaje).getResultList();
		
		List<RolDTO> listaRolesDTO = new ArrayList<>();
		
		for (Rol rol : listaRoles) {
			listaRolesDTO.add(convertirEntidadDTO(rol));
		}
		
		logger.debug("fin del metodo ConsularRol");
		return listaRolesDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un rol a un rolDTO
	 * 
	 * @param rol
	 * @return
	 */

	private Rol convertirDTOEntidad(RolDTO rolDTO) {
		Rol Rol = new Rol();
		Rol.setId(rolDTO.getId());
		Rol.setNombre(rolDTO.getNombre());
		Rol.setPersonaje(new Personaje());
		Rol.getPersonaje().setId(rolDTO.getIdPersonaje());;
		Rol.setEstado(rolDTO.getEstado());			
		return Rol;
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un rolDTO a un rol
	 * 
	 * @param rol
	 * @return
	 */
	
	private RolDTO convertirEntidadDTO(Rol rol) {
		RolDTO RolDTO = new RolDTO();
		RolDTO.setId(rol.getId());
		RolDTO.setNombre(rol.getNombre());
		RolDTO.setIdPersonaje(rol.getPersonaje().getId());
		RolDTO.setEstado(rol.getEstado());		
		return RolDTO;
	}

}
