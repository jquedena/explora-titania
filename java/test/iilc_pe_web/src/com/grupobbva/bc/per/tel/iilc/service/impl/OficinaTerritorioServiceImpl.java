package com.grupobbva.bc.per.tel.iilc.service.impl;

import java.util.List;

import com.grupobbva.bc.per.tel.iilc.beans.OficinaTerritorio;
import com.grupobbva.bc.per.tel.iilc.beans.PermisoUsuario;
import com.grupobbva.bc.per.tel.iilc.dao.impl.OficinaTerritorioDAOImpl;

public class OficinaTerritorioServiceImpl {

	private OficinaTerritorioDAOImpl oficinaTerritorioDAO;
	
	public OficinaTerritorioServiceImpl(){
		oficinaTerritorioDAO = new OficinaTerritorioDAOImpl();
	}
	
	public List<OficinaTerritorio> listarOficina() {
		return oficinaTerritorioDAO.listarOficina();
	}
	
	public List<PermisoUsuario> listarPermiso(String codUsuario) {
		return oficinaTerritorioDAO.listarPermiso(codUsuario);
	}
	
	public boolean eliminarPermiso(String codUsuario) {
		return oficinaTerritorioDAO.eliminarPermiso(codUsuario);
	}

	public boolean registrarPermiso(PermisoUsuario o) {
		return oficinaTerritorioDAO.registrarPermiso(o);
	}
	
	public int perfil(String codUsuario, String codCargo) {
		return oficinaTerritorioDAO.perfil(codUsuario, codCargo);
	}
}
