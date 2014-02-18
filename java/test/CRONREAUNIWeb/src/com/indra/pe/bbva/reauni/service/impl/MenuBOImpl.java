package com.indra.pe.bbva.reauni.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.pe.bbva.core.transactional.AppReauniTxReadOnly;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.exception.DAOException;
import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.model.entidad.OpcionMenuDto;
import com.indra.pe.bbva.reauni.model.entidad.PerfilOpcionMenuDto;
import com.indra.pe.bbva.reauni.service.MenuBO;

@Service("menuBO")
public class MenuBOImpl implements MenuBO {
 
	@Autowired
	private DAOGenerico<PerfilOpcionMenuDto> perfilOpcionMenuDAO;
	
	@Override
	@AppReauniTxReadOnly
	public List<OpcionMenuDto> obtenerListaOpcionesMenu(Long codPerfil)
			throws ServiceException {
		List<OpcionMenuDto> listaOpcionesMenu = new ArrayList<OpcionMenuDto>();
		try{
			Map<String,Object> parametros = new HashMap<String, Object>();
			parametros.put("perfil.id",codPerfil);
			List<PerfilOpcionMenuDto> listaPerfilOpcionMenu = perfilOpcionMenuDAO.obtenerDtosConFiltros(PerfilOpcionMenuDto.class,parametros);
			for (PerfilOpcionMenuDto perfilOpcionMenuDto : listaPerfilOpcionMenu) {
				listaOpcionesMenu.add(perfilOpcionMenuDto.getOpcionMenu());
			}
		}catch(DAOException e){
			throw new ServiceException(e);
		} 
		return listaOpcionesMenu;
	}
	
}
