package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionOficina_e810717a
 */
public class EJSRemoteStatelessSesionOficina_e810717a extends EJSWrapper implements SesionOficina {
	/**
	 * EJSRemoteStatelessSesionOficina_e810717a
	 */
	public EJSRemoteStatelessSesionOficina_e810717a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * actualizarOficinaHija
	 */
	public boolean actualizarOficinaHija(com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija oficinaHija) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = oficinaHija;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.actualizarOficinaHija(oficinaHija);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * crearOficinaHija
	 */
	public boolean crearOficinaHija(com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija oficinaHija) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = oficinaHija;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.crearOficinaHija(oficinaHija);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * eliminarOficinaHija
	 */
	public boolean eliminarOficinaHija(com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija oficinaHija) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = oficinaHija;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.eliminarOficinaHija(oficinaHija);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByCodigoOficina
	 */
	public boolean findByCodigoOficina(java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findByCodigoOficina(codOficina);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findOficinaAndTerri
	 */
	public boolean findOficinaAndTerri(java.lang.String codTerritorio, java.lang.String codOfi) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = codOfi;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findOficinaAndTerri(codTerritorio, codOfi);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByCodOficina
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Oficina findByCodOficina(java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Oficina _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findByCodOficina(codOficina);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByCodOficinaHija
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Oficina findByCodOficinaHija(java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Oficina _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findByCodOficinaHija(codOficina);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findOficinaHija
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija findOficinaHija(com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija oficinaHija) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.OficinaHija _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = oficinaHija;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findOficinaHija(oficinaHija);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findTerritorioByCodOficina
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Territorio findTerritorioByCodOficina(java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Territorio _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findTerritorioByCodOficina(codOficina);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * eliminarOficina
	 */
	public int eliminarOficina(java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.eliminarOficina(codOficina);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * nuevaOficina
	 */
	public int nuevaOficina(java.lang.String codTerritorio, java.lang.String codOficina, java.lang.String nomOficina, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = codOficina;
				_jacc_parms[2] = nomOficina;
				_jacc_parms[3] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.nuevaOficina(codTerritorio, codOficina, nomOficina, usuario);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busOficinaxTerritorio
	 */
	public java.util.Vector busOficinaxTerritorio(java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busOficinaxTerritorio(codTerritorio);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busOficinaxTerritorio
	 */
	public java.util.Vector busOficinaxTerritorio(java.lang.String codTerritorio, boolean showAll) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = new java.lang.Boolean(showAll);
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busOficinaxTerritorio(codTerritorio, showAll);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 12, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * editarOficina
	 */
	public java.util.Vector editarOficina(com.grupobbva.bc.per.tele.sdo.serializable.Oficina oficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = oficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.editarOficina(oficina);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * editarOficina
	 */
	public java.util.Vector editarOficina(java.lang.String codTerritorio, java.lang.String codOficina, java.lang.String nomOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = codOficina;
				_jacc_parms[2] = nomOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.editarOficina(codTerritorio, codOficina, nomOficina);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * editarTerritoriosDeOficinas
	 */
	public java.util.Vector editarTerritoriosDeOficinas(java.lang.String codOficina, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codOficina;
				_jacc_parms[1] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.editarTerritoriosDeOficinas(codOficina, codTerritorio);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllOficinaByCodTerri
	 */
	public java.util.Vector findAllOficinaByCodTerri(java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllOficinaByCodTerri(codTerritorio);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllOficinaByCodTerri_MOD1
	 */
	public java.util.Vector findAllOficinaByCodTerri_MOD1(java.lang.String codTerritorio, java.lang.String anho, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllOficinaByCodTerri_MOD1(codTerritorio, anho, mes);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllOficinaByCodTerri_MOD2
	 */
	public java.util.Vector findAllOficinaByCodTerri_MOD2(java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 18, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllOficinaByCodTerri_MOD2(codTerritorio);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 18, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllOficinas
	 */
	public java.util.Vector findAllOficinas() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 19, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllOficinas();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 19, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findHijas
	 */
	public java.util.Vector findHijas(java.lang.String codOficinaPadre) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codOficinaPadre;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 20, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findHijas(codOficinaPadre);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 20, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findListaByCodOficina
	 */
	public java.util.Vector findListaByCodOficina(java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 21, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findListaByCodOficina(codOficina);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 21, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findTodosOficinaHija
	 */
	public java.util.Vector findTodosOficinaHija() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 22, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findTodosOficinaHija();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 22, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * nuevaOficina
	 */
	public java.util.Vector nuevaOficina(java.lang.String codTerritorio, java.lang.String codOficina, java.lang.String nomOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = codOficina;
				_jacc_parms[2] = nomOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionOficinaBean)container.preInvoke(this, 23, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.nuevaOficina(codTerritorio, codOficina, nomOficina);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 23, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
