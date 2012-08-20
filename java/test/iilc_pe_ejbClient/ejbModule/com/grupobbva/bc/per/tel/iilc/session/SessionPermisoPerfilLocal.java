package com.grupobbva.bc.per.tel.iilc.session;
import java.util.Vector;

import javax.ejb.FinderException;

import com.grupobbva.bc.per.tel.iilc.serializable.Perfil;
import com.grupobbva.bc.per.tel.iilc.serializable.PermisoPerfil;
/**
 * Local interface for Enterprise Bean: SessionPermisoPerfil
 */
public interface SessionPermisoPerfilLocal extends javax.ejb.EJBLocalObject {
	public PermisoPerfil findComponente(
		String codReg,
		String codCat,
		String path)throws FinderException;
	public Vector findAllPerfil() throws FinderException;
	public Vector findAllPermisoPerfil() throws FinderException;
	public Perfil findPerfil(String cod_perfil);
	public PermisoPerfil findPermisoPerfil(
		String cod_perfil,
		int tipo_acceso,
		String valor_rcp);
	public boolean deletePerfil(String cod_perfil);
	public boolean updatePerfil(Perfil perfil);
	public boolean deletePermisoPerfil(
		String cod_perfil,
		int tipo_acceso,
		String valor_rcp);
	public String findPerfilxRegistro(String registro);
}
