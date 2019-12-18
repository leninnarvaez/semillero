/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.math.BigDecimal;
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

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.exceptions.ComicException;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los comics
 * 
 * @author ccastano
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {

	
	final static Logger logger = Logger.getLogger(GestionarComicBean.class);
	
	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @throws ComicException 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearComic(ComicDTO comicNuevo) throws ComicException {
		
		try {
			// Entidad nueva
			Comic comic = convertirComicDTOToComic(comicNuevo);
			// Se almacena la informacion y se maneja la enidad comic
			em.persist(comic);
		}catch(Exception e) {
			logger.error("Ha ocurrido un error al momento de crear el comic: "+e);
			throw new ComicException("COD-0001","Error ejecutando la creacion del comic",e);
		}
		
	}

	/**
	 * 
	 * @throws ComicException 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) throws ComicException {
		
		try {
			Comic comicModificar ;
			if(comicNuevo==null) {
				// Entidad a modificar
				comicModificar = em.find(Comic.class, id);
			}else {
				comicModificar = convertirComicDTOToComic(comicNuevo);
			}
			comicModificar.setNombre(nombre);
			em.merge(comicModificar);
		}catch (Exception e) {
			logger.error("Error al modificar comic " + e);
			throw new ComicException("COD-0002","Error ejecutando modificar del comic",e);
		}
		
		
	}

	/**
	 * 
	 * @throws ComicException 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarComic(Long idComic) throws ComicException {
		logger.debug("Inicio metodo eliminarCOmic");
		try {
			
			Comic comicEliminar = em.find(Comic.class, idComic);
			if (comicEliminar != null) {
				em.remove(comicEliminar);
			}
//		Query query = em.createQuery("DELETE FROM Comic c WHERE c.id = :idCOmic")
//				.setParameter("idComic", idComic);
//		query.executeUpdate();
			em.flush();
			em.clear();
			
		}catch (Exception e) {
			
			logger.error("Error al eliminar comic " + e);
			throw new ComicException("COD-0003","Error ejecutando la eliminacion del comic",e);
			
		}		
		
	}

	/**
	 * 
	 * @throws ComicException 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComic(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String idComic) throws ComicException {
		try {
			Comic comic = null;
		comic = new Comic();
		comic = em.find(Comic.class, Long.parseLong(idComic));
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;
		} catch (NumberFormatException e) {
			logger.error("Error convirtiendo la cadena a numero: " + idComic);
			throw new ComicException("COD-0002","Error no se pudo convertir a cadena",e);
		}
		
	}

	/**
	 * 
	 * @throws ComicException 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() throws ComicException {		
		try {
			logger.debug("Se ejecuta el metodo consultar comic");
			
			List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
			List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();
			for (Comic comic:resultados) {
				resultadosComicDTO.add(convertirComicToComicDTO(comic));
			}
			return resultadosComicDTO;
		}catch(ArrayIndexOutOfBoundsException e) {
			logger.error("Error al ejecutar consultar Comics");
			throw new ComicException("COD-0004","Error no se pudo convertir a cadena",e);
		}				
		
	}
	/**
	public BigDecimal calcularPrecioTotal() {
		BigDecimal pTotal;
		return new BigDecimal("0");
	}

	/**
	 * 
	 * Metodo encargado de transformar un comic a un comicDTO
	 * 
	 * @param comic
	 * @return
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		if(comic.getId()!=null) {
		 comicDTO.setId(comic.getId().toString());
		}
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
	//	comicDTO.setPrecio(comic.getPrecioTotal());
		//comicDTO.setIva(comic.getIva());
		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un comicDTO a un comic
	 * 
	 * @param comic
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		if(comicDTO.getId()!=null) {
			comic.setId(Long.parseLong(comicDTO.getId()));
		}
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
//		comic.setPrecio(comicDTO.getPrecioTotal());
//		comic.setIva(comicDTO.getIva());
		return comic;
	}
}
