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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.ldap.service.LdapService;
import com.indra.pe.bbva.reauni.model.entidad.PermisoPerfilDto;
import com.indra.pe.bbva.reauni.service.PermisoPerfilBO;

@Service("permisoPerfilBO")
@Transactional
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PermisoPerfilBOImpl implements PermisoPerfilBO {

	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<PermisoPerfilDto> permisoPerfilDAO;
	
	@Autowired
	private LdapService ldapService;
	
	@Override
	public void insertarPermisoPerfil(PermisoPerfilDto permisoPerfilDto)throws ServiceException {
		try {
			permisoPerfilDAO.save(permisoPerfilDto);
		} catch (DAOException e) {
			throw new ServiceException(e); 
		}
	}

	@Override
	public void actualizarPermisoPerfil(PermisoPerfilDto permisoPerfilDto) throws ServiceException {
		try {
			permisoPerfilDAO.saveOrUpdate(permisoPerfilDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void eliminarPermisoPerfil(Long id) throws ServiceException {
		PermisoPerfilDto permisoPerfilDto =  new PermisoPerfilDto();
		permisoPerfilDto.setId(id);
		try {
			permisoPerfilDAO.delete(permisoPerfilDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void eliminarPermisoPerfil2(PermisoPerfilDto permisoPerfilDto) throws ServiceException {		
		try {
			permisoPerfilDAO.delete(permisoPerfilDto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<PermisoPerfilDto> obtenerListaPermisoPerfil(PermisoPerfilDto permisoPerfilDto) throws ServiceException {
		List<PermisoPerfilDto> listaPermisoPerfilDto =  new ArrayList<PermisoPerfilDto>();
		Map<String,Object> parametro =  new HashMap<String,Object>();
		
		if(permisoPerfilDto.getId()!=null){
				parametro.put("id",permisoPerfilDto.getId());
		}	
		
		if(permisoPerfilDto.getValor()!=null && !permisoPerfilDto.getValor().equalsIgnoreCase("")){
				parametro.put("valor",permisoPerfilDto.getValor());
		}
		
		if(permisoPerfilDto.getPerfil().getId()!=null && permisoPerfilDto.getPerfil().getId()!=-1L && permisoPerfilDto.getPerfil().getId()!=0L){
				parametro.put("perfil.id",permisoPerfilDto.getPerfil().getId());
		}
		
		try {
			listaPermisoPerfilDto = permisoPerfilDAO.obtenerDtosConFiltros(PermisoPerfilDto.class,parametro);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return listaPermisoPerfilDto;
	}

	@Override
	public PermisoPerfilDto obtenerPermisoPerfilPorId(Long id)throws ServiceException {
		PermisoPerfilDto permisoPerfilDto =  null;
		try {
			permisoPerfilDto = permisoPerfilDAO.obtenerDtoPorId(PermisoPerfilDto.class,new BigDecimal(id));
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return permisoPerfilDto;
	}

	@Override
	public PermisoPerfilDto obtenerPerfilSegunRegistroOCargo(String registro, String codCargo) throws ServiceException {
		PermisoPerfilDto permisoPerfilDto =  null;
		List<PermisoPerfilDto> listaPermisoPerfil  = null;
		Map<String,Object> parametro = null;
		try {
			parametro = new HashMap<String,Object>();
			parametro.put("valor",registro);
			listaPermisoPerfil = permisoPerfilDAO.obtenerDtosConFiltros(PermisoPerfilDto.class, parametro);
			if(listaPermisoPerfil.size()<=0){
				parametro = new HashMap<String,Object>();
				parametro.put("valor",codCargo);
				listaPermisoPerfil = permisoPerfilDAO.obtenerDtosConFiltros(PermisoPerfilDto.class, parametro);
			}
			if(listaPermisoPerfil.size()>0){
				permisoPerfilDto = listaPermisoPerfil.get(0); 
			}
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return permisoPerfilDto;
	}

	@Override
	public String validarRegistroCargo(String tipoAcceso, String valor) throws ServiceException {
		if(tipoAcceso.equals(com.indra.pe.bbva.ldap.util.Constantes.ColumnasLdap.CARGO)){
			String validarCargo = ldapService.validarExistenciaLdapPorColumna(com.indra.pe.bbva.ldap.util.Constantes.ColumnasLdap.CARGO,valor);

			if(validarCargo.trim().length()>0){

				return validarCargo;
			}else{

				PermisoPerfilDto obj = new PermisoPerfilDto();
				obj.setValor(valor);
				List<PermisoPerfilDto> lista = this.obtenerListaPermisoPerfil(obj);

				if(lista!=null && lista.size()>0){

					return "EL CARGO YA SE ENCUENTRA REGISTRADO EN EL SISTEMA";
				}else{
					return "";
				}
			}
		}else if(tipoAcceso.equals(com.indra.pe.bbva.ldap.util.Constantes.ColumnasLdap.REGISTRO)){
			String validarRegistro = ldapService.validarExistenciaLdapPorColumna(com.indra.pe.bbva.ldap.util.Constantes.ColumnasLdap.REGISTRO,valor);

			if(validarRegistro.trim().length()>0){

				return validarRegistro;
			}else{

				PermisoPerfilDto obj = new PermisoPerfilDto();
				obj.setValor(valor);
				List<PermisoPerfilDto> lista = this.obtenerListaPermisoPerfil(obj);

				if(lista!=null && lista.size()>0){

					return "EL USUARIO YA SE ENCUENTRA REGISTRADO EN EL SISTEMA";
				}else{
					return "";
				}
			}
		}else{
			return "";
		}
	}
}
