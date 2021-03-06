package com.indra.pe.bbva.ldap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.pe.bbva.core.dao.DAOGenericoLDAP;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.ldap.model.entidad.LdapDto;
import com.indra.pe.bbva.ldap.service.LdapService;
import com.indra.pe.bbva.ldap.util.Constantes;

@Service("ldapService")
public class LdapServiceImpl implements LdapService {
	
	@Autowired
	private DAOGenericoLDAP<LdapDto> ldapDAO;
	
	@Override
	public Boolean validarExistenciaLdap(String columna,String valor) throws ServiceException {
		 try {
			List<LdapDto> lista = ldapDAO.obtenerDtosConFiltros(LdapDto.class, columna, valor);
			if(lista!=null && lista.size()>0){
				return true;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		 return false;
	}
 
	@Override
	public String validarExistenciaLdapPorColumna(String columna,String valor)
			throws ServiceException {
		if(columna.equalsIgnoreCase(Constantes.ColumnasLdap.REGISTRO)){
			if(!this.validarExistenciaLdap(columna,valor)){
				return Constantes.Mensajes.SUFIJO_MSG;
			}
		}else if(columna.equalsIgnoreCase(Constantes.ColumnasLdap.CARGO)){
			if(!this.validarExistenciaLdap(columna,valor)){
				return Constantes.Mensajes.SUFIJO_MSG;
			}
		}
		return "";
	}
	
	@Override
	public LdapDto obtenerInformacionPorRegistro(String codRegistro) throws ServiceException {
		LdapDto ldapDto = null;
		try {
			List<LdapDto> lista = ldapDAO.obtenerDtosConFiltros(LdapDto.class,"codusu",codRegistro);
			if(lista != null && lista.size()>0){
				ldapDto = lista.get(0);
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return ldapDto;
	}

	@Override
	public List<LdapDto> obtenerDtosInvolucrados(String codOficina, List<String> codCargos) throws ServiceException {
		List<LdapDto> lista = null;
		String[] cargos = new String[codCargos.size()];
		int i = 0;
		for(String c : codCargos) {
			cargos[i] = c;
			i++;
		}
		try {
			lista = ldapDAO.obtenerDtosInvolucrados(LdapDto.class, codOficina, cargos);			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lista;
	}
	
	@Override
	public List<LdapDto> obtenerDtosInvolucradosGT(String codOficina, List<String> codCargos) throws ServiceException {
		List<LdapDto> lista = null;
		String[] cargos = new String[codCargos.size()];
		int i = 0;
		for(String c : codCargos) {
			cargos[i] = c;
			i++;
		}
		try {
			lista = ldapDAO.obtenerDtosInvolucradosGT(LdapDto.class, codOficina, cargos);			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lista;
	}
}
