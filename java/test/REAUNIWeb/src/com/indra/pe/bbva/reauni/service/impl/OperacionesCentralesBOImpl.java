package com.indra.pe.bbva.reauni.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.ldap.service.LdapService;
import com.indra.pe.bbva.ldap.util.Constantes;
import com.indra.pe.bbva.reauni.model.entidad.OperacionCentralizadaDto;
import com.indra.pe.bbva.reauni.service.OperacionesCentralesBO;

@Controller("operacionesCentralesBO")
@Transactional
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class OperacionesCentralesBOImpl implements OperacionesCentralesBO {

	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<OperacionCentralizadaDto> operacionCentralizadaDAO;
	
	@Autowired
	private LdapService ldapService;
	
	@Override
	public void insertarOperacionesCentrales(
			OperacionCentralizadaDto operacionCentralizadaDto)
			throws ServiceException {
		try {
			operacionCentralizadaDAO.save(operacionCentralizadaDto);
		} catch (DAOException e) {
			throw new ServiceException(e); 
		}
	}

	@Override
	public void actualizarOperacionesCentrales(
			OperacionCentralizadaDto operacionCentralizadaDto)
			throws ServiceException {
		try {
			operacionCentralizadaDAO.saveOrUpdate(operacionCentralizadaDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void eliminarOperacionesCentrales(Long id) throws ServiceException {
		OperacionCentralizadaDto operacionCentralizadaDto =  new OperacionCentralizadaDto();
		operacionCentralizadaDto.setId(id);
		try {
			operacionCentralizadaDAO.delete(operacionCentralizadaDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<OperacionCentralizadaDto> obtenerListaSituaciones(
			OperacionCentralizadaDto operacionCentralizadaDto)
			throws ServiceException {
		List<OperacionCentralizadaDto> listaOperacionCentralizadaDto =  new ArrayList<OperacionCentralizadaDto>();
		Map<String,Object> parametro =  new HashMap<String,Object>();
		if(operacionCentralizadaDto.getId()!=null){
			parametro.put("id",operacionCentralizadaDto.getId());
		}	
		if(operacionCentralizadaDto.getRegistro()!=null && !operacionCentralizadaDto.getRegistro().equalsIgnoreCase("")){
			parametro.put("registro",operacionCentralizadaDto.getRegistro());
		}	
		if(operacionCentralizadaDto.getProducto()!=null && !operacionCentralizadaDto.getProducto().equalsIgnoreCase("")){
			parametro.put("producto",operacionCentralizadaDto.getProducto());
		}
		if(operacionCentralizadaDto.getEstado()!=null){
			parametro.put("estado",operacionCentralizadaDto.getEstado());
		}	
		if(operacionCentralizadaDto.getFechaCreacion()!=null){
			parametro.put("fechaCreacion",operacionCentralizadaDto.getFechaCreacion());
		}
		if(operacionCentralizadaDto.getFechaModificacion()!=null){
			parametro.put("fechaModificacion",operacionCentralizadaDto.getFechaModificacion());
		}
		if(operacionCentralizadaDto.getUsuarioCreacion()!=null &&operacionCentralizadaDto.getUsuarioCreacion().equalsIgnoreCase("")){
				parametro.put("usuarioCreacion",operacionCentralizadaDto.getUsuarioCreacion());
		}	
		if(operacionCentralizadaDto.getUsuarioModificacion()!=null && operacionCentralizadaDto.getUsuarioModificacion()!=null){
				parametro.put("usuarioModificacion",operacionCentralizadaDto.getUsuarioModificacion());
		}	
		try {
			listaOperacionCentralizadaDto = operacionCentralizadaDAO.obtenerDtosConFiltros(OperacionCentralizadaDto.class,parametro);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return listaOperacionCentralizadaDto;
	}

	@Override
	public OperacionCentralizadaDto obtenerOperacionesCentralesPorId(Long id)
			throws ServiceException {
		OperacionCentralizadaDto operacionCentralizadaDto =  null;
		try {
			operacionCentralizadaDto = operacionCentralizadaDAO.obtenerDtoPorId(OperacionCentralizadaDto.class,new BigDecimal(id));
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return operacionCentralizadaDto;
	}
	
	@Override
	public String validarExistenciaRegistro(String registro) throws ServiceException {
		return ldapService.validarExistenciaLdapPorColumna(Constantes.ColumnasLdap.REGISTRO, registro);
	}
	
	@Override
	public boolean noSeRepiteCombinacion(
			OperacionCentralizadaDto operacionCentralizadaDto)
			throws ServiceException {
		List<OperacionCentralizadaDto> listaOperacionCentralizadaDto =  new ArrayList<OperacionCentralizadaDto>();
		boolean retorno = false;
		Map<String,Object> parametro =  new HashMap<String,Object>();
		
		if(operacionCentralizadaDto.getRegistro()!=null && !operacionCentralizadaDto.getRegistro().equalsIgnoreCase("")){
			parametro.put("registro",operacionCentralizadaDto.getRegistro());
		}	
		if(operacionCentralizadaDto.getProducto()!=null && !operacionCentralizadaDto.getProducto().equalsIgnoreCase("")){
			parametro.put("producto",operacionCentralizadaDto.getProducto());
		}		
		try {
			listaOperacionCentralizadaDto = operacionCentralizadaDAO.obtenerDtosConFiltros(OperacionCentralizadaDto.class,parametro);
			if (listaOperacionCentralizadaDto.size()>0) {
				retorno = false;
			}else {
				retorno = true;
			}
		} catch (DAOException e) {
			retorno = false;
			throw new ServiceException(e);
			
		}
		return retorno;
	}

}
