package com.indra.pe.bbva.reauni.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.OpcionMenuDto;
import com.indra.pe.bbva.reauni.service.MenuBO;

@Service("menuBO")
@Transactional
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class MenuBOImpl implements MenuBO {
 
	@Autowired
	@Qualifier("daoGenerico")
	private DAOGenerico<OpcionMenuDto> perfilOpcionMenuDAO;
	
	@Override
	public List<OpcionMenuDto> obtenerListaOpcionesMenu(Long codPerfil)
			throws ServiceException {
		List<OpcionMenuDto> listaOpcionesMenu = new ArrayList<OpcionMenuDto>();
		try{
			Object[] o = null;
			String query = "select distinct o from OpcionMenuDto o join fetch o.treauniPerfilOpcionMenuList om, PerfilOpcionMenuDto p where o.id=p.opcionMenu.id and p.perfil.id=" + codPerfil; 
			listaOpcionesMenu = perfilOpcionMenuDAO.obtenerDtosPorQuery(query, o);

		}catch(DAOException e){
			throw new ServiceException(e);
		} 
		return listaOpcionesMenu;
	}
	
}
