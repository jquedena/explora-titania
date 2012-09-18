package com.indra.pe.bbva.ldap.service;

import java.util.List;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.ldap.model.entidad.LdapDto;

public interface LdapService {

	public LdapDto obtenerInformacionPorRegistro(String codRegistro)throws ServiceException;
	public Boolean validarExistenciaLdap(String columna,String valor) throws ServiceException;
	public String validarExistenciaLdapPorColumna(String columna,String valor) throws ServiceException;
	public List<LdapDto> obtenerDtosInvolucrados (String codOficina, String...codCargos) throws ServiceException;
	
}
