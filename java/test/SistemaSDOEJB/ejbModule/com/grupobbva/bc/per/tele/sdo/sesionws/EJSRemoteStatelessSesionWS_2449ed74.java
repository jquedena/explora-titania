package com.grupobbva.bc.per.tele.sdo.sesionws;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionWS_2449ed74
 */
public class EJSRemoteStatelessSesionWS_2449ed74 extends EJSWrapper implements SesionWS {
	/**
	 * EJSRemoteStatelessSesionWS_2449ed74
	 */
	public EJSRemoteStatelessSesionWS_2449ed74() throws java.rmi.RemoteException {
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
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
	 * actualizarProgTerritorio
	 */
	public boolean actualizarProgTerritorio(com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = progTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.actualizarProgTerritorio(progTerritorio);
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
	 * actualizarSeguimiento1
	 */
	public boolean actualizarSeguimiento1(java.lang.String tipoSeguimiento, java.lang.String numDato, java.lang.String codigo1, java.lang.String codigo2, java.lang.String valor, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = tipoSeguimiento;
				_jacc_parms[1] = numDato;
				_jacc_parms[2] = codigo1;
				_jacc_parms[3] = codigo2;
				_jacc_parms[4] = valor;
				_jacc_parms[5] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.actualizarSeguimiento1(tipoSeguimiento, numDato, codigo1, codigo2, valor, usuario);
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
	 * actualizarSeguimiento2
	 */
	public boolean actualizarSeguimiento2(java.lang.String tipoSeguimiento, java.lang.String numDato, java.lang.String codigo1, java.lang.String codigo2, java.lang.String valor, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = tipoSeguimiento;
				_jacc_parms[1] = numDato;
				_jacc_parms[2] = codigo1;
				_jacc_parms[3] = codigo2;
				_jacc_parms[4] = valor;
				_jacc_parms[5] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.actualizarSeguimiento2(tipoSeguimiento, numDato, codigo1, codigo2, valor, usuario);
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
	 * borrarEpigrafe
	 */
	public boolean borrarEpigrafe() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.borrarEpigrafe();
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
	 * borrarMaestro
	 */
	public boolean borrarMaestro() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.borrarMaestro();
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
	 * borrarPlanIngresado
	 */
	public boolean borrarPlanIngresado(java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.borrarPlanIngresado(usuario);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * crearProgTerritorio
	 */
	public boolean crearProgTerritorio(com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = progTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.crearProgTerritorio(progTerritorio);
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
	 * createEpigrafe
	 */
	public boolean createEpigrafe(com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe epigrafe) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = epigrafe;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createEpigrafe(epigrafe);
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
	 * createEquivalencia
	 */
	public boolean createEquivalencia(com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia equivalencia) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = equivalencia;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createEquivalencia(equivalencia);
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
	 * createMaestrPlan
	 */
	public boolean createMaestrPlan(java.lang.String anho, java.lang.String mes, java.lang.String codOfi, java.lang.String codTerr) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = codOfi;
				_jacc_parms[3] = codTerr;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createMaestrPlan(anho, mes, codOfi, codTerr);
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
	 * createMenu
	 */
	public boolean createMenu(com.grupobbva.bc.per.tele.sdo.serializable.Menu menu) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = menu;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createMenu(menu);
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
	 * createMetasGestor
	 */
	public boolean createMetasGestor(com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor metasGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = metasGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createMetasGestor(metasGestor);
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
	 * createPerfil
	 */
	public boolean createPerfil(com.grupobbva.bc.per.tele.sdo.serializable.Perfil perfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = perfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createPerfil(perfil);
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
	 * createPermisoPerfil
	 */
	public boolean createPermisoPerfil(com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil permisoPerfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = permisoPerfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createPermisoPerfil(permisoPerfil);
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
	 * createPlan
	 */
	public boolean createPlan(com.grupobbva.bc.per.tele.sdo.serializable.Plan plan) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = plan;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createPlan(plan);
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
	 * createUpdatePlan
	 */
	public boolean createUpdatePlan(com.grupobbva.bc.per.tele.sdo.serializable.Plan plan) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = plan;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.createUpdatePlan(plan);
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
	 * deleteEquivalencia
	 */
	public boolean deleteEquivalencia(java.lang.String cod_cargo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_cargo;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 18, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.deleteEquivalencia(cod_cargo);
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
	 * deleteMenu
	 */
	public boolean deleteMenu(java.lang.String padre) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = padre;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 19, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.deleteMenu(padre);
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
	 * deletePerfil
	 */
	public boolean deletePerfil(java.lang.String cod_perfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_perfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 20, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.deletePerfil(cod_perfil);
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
	 * deletePermisoPerfil
	 */
	public boolean deletePermisoPerfil(java.lang.String codPerfil, java.lang.String tipoAcceso, java.lang.String valorRCP) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codPerfil;
				_jacc_parms[1] = tipoAcceso;
				_jacc_parms[2] = valorRCP;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 21, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.deletePermisoPerfil(codPerfil, tipoAcceso, valorRCP);
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
	 * edicionAccion
	 */
	public boolean edicionAccion(java.lang.String codAccion, java.lang.String descAccion, java.lang.String numeroCliente, java.lang.String compromisoGestor, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codAccion;
				_jacc_parms[1] = descAccion;
				_jacc_parms[2] = numeroCliente;
				_jacc_parms[3] = compromisoGestor;
				_jacc_parms[4] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 22, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.edicionAccion(codAccion, descAccion, numeroCliente, compromisoGestor, usuario);
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
	 * edicionCampaniaDetalle
	 */
	public boolean edicionCampaniaDetalle(java.lang.String codCampaniaDetalle, java.lang.String nomCampania, int nroClie, double compGest, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codCampaniaDetalle;
				_jacc_parms[1] = nomCampania;
				_jacc_parms[2] = new java.lang.Integer(nroClie);
				_jacc_parms[3] = new java.lang.Double(compGest);
				_jacc_parms[4] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 23, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.edicionCampaniaDetalle(codCampaniaDetalle, nomCampania, nroClie, compGest, usuario);
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
	/**
	 * eliminarCampaniaDetalle
	 */
	public boolean eliminarCampaniaDetalle(java.lang.String codCamp) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codCamp;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 24, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.eliminarCampaniaDetalle(codCamp);
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
				container.postInvoke(this, 24, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 25, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 25, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * eliminarProgTerritorio
	 */
	public boolean eliminarProgTerritorio(com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = progTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 26, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.eliminarProgTerritorio(progTerritorio);
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
				container.postInvoke(this, 26, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * existeDataMaestroPlanesMesAnio
	 */
	public boolean existeDataMaestroPlanesMesAnio(java.lang.String mes, java.lang.String anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 27, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.existeDataMaestroPlanesMesAnio(mes, anio);
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
				container.postInvoke(this, 27, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * existeDataPlanesMesAnio
	 */
	public boolean existeDataPlanesMesAnio(java.lang.String mes, java.lang.String anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 28, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.existeDataPlanesMesAnio(mes, anio);
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
				container.postInvoke(this, 28, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 29, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 29, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 30, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 30, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * insertUpdateMesesReferencia
	 */
	public boolean insertUpdateMesesReferencia(int mes, int anio, int sel_mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = new java.lang.Integer(mes);
				_jacc_parms[1] = new java.lang.Integer(anio);
				_jacc_parms[2] = new java.lang.Integer(sel_mes);
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 31, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.insertUpdateMesesReferencia(mes, anio, sel_mes);
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
				container.postInvoke(this, 31, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * nuevoCampaniaDetalle
	 */
	public boolean nuevoCampaniaDetalle(java.lang.String codTerritorio, java.lang.String codOficina, java.lang.String codCampania, java.lang.String mes, java.lang.String anho, java.lang.String nomCampania, java.lang.String codGest, int nroClie, double compGest, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[10];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = codOficina;
				_jacc_parms[2] = codCampania;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = anho;
				_jacc_parms[5] = nomCampania;
				_jacc_parms[6] = codGest;
				_jacc_parms[7] = new java.lang.Integer(nroClie);
				_jacc_parms[8] = new java.lang.Double(compGest);
				_jacc_parms[9] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 32, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.nuevoCampaniaDetalle(codTerritorio, codOficina, codCampania, mes, anho, nomCampania, codGest, nroClie, compGest, usuario);
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
				container.postInvoke(this, 32, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * updateCorporativa
	 */
	public boolean updateCorporativa(com.grupobbva.bc.per.tele.sdo.serializable.Multitabla multitabla) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = multitabla;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 33, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateCorporativa(multitabla);
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
				container.postInvoke(this, 33, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * updateElemMultitabla
	 */
	public boolean updateElemMultitabla(com.grupobbva.bc.per.tele.sdo.serializable.Multitabla multitabla) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = multitabla;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 34, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateElemMultitabla(multitabla);
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
				container.postInvoke(this, 34, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * updateEquivalencia
	 */
	public boolean updateEquivalencia(com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia equivalencia) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = equivalencia;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 35, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateEquivalencia(equivalencia);
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
				container.postInvoke(this, 35, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * updateMenu
	 */
	public boolean updateMenu(com.grupobbva.bc.per.tele.sdo.serializable.Menu menu) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = menu;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 36, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateMenu(menu);
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
				container.postInvoke(this, 36, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * updateMetasGestor
	 */
	public boolean updateMetasGestor(com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor metasGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = metasGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 37, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updateMetasGestor(metasGestor);
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
				container.postInvoke(this, 37, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * updatePerfil
	 */
	public boolean updatePerfil(com.grupobbva.bc.per.tele.sdo.serializable.Perfil perfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = perfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 38, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updatePerfil(perfil);
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
				container.postInvoke(this, 38, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * updatePermisoPerfil
	 */
	public boolean updatePermisoPerfil(com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil origPermisoPerfil, com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil nuevoPermisoPerfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = origPermisoPerfil;
				_jacc_parms[1] = nuevoPermisoPerfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 39, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updatePermisoPerfil(origPermisoPerfil, nuevoPermisoPerfil);
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
				container.postInvoke(this, 39, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * updatePlan
	 */
	public boolean updatePlan(com.grupobbva.bc.per.tele.sdo.serializable.Plan plan) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		boolean _EJS_result = false;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = plan;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 40, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.updatePlan(plan);
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
				container.postInvoke(this, 40, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busAccion
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Accion busAccion(java.lang.String codAccion) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Accion _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codAccion;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 41, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAccion(codAccion);
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
				container.postInvoke(this, 41, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busCampaniaDetalle
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Campanias busCampaniaDetalle(java.lang.String codCampaniaDetalle) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Campanias _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codCampaniaDetalle;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 42, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busCampaniaDetalle(codCampaniaDetalle);
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
				container.postInvoke(this, 42, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByCodEpigAnho
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe findByCodEpigAnho(java.lang.String codEpigrafe, java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codEpigrafe;
				_jacc_parms[1] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 43, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findByCodEpigAnho(codEpigrafe, anho);
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
				container.postInvoke(this, 43, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findEquivalenciaByCodCargo
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia findEquivalenciaByCodCargo(java.lang.String codCargo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codCargo;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 44, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findEquivalenciaByCodCargo(codCargo);
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
				container.postInvoke(this, 44, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findFirmByAnoMesCgesItem
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Firmas findFirmByAnoMesCgesItem(java.lang.String anho, java.lang.String mes, java.lang.String codGestor, java.lang.String item) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Firmas _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = codGestor;
				_jacc_parms[3] = item;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 45, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findFirmByAnoMesCgesItem(anho, mes, codGestor, item);
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
				container.postInvoke(this, 45, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findUbicar
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.MaestroPlan findUbicar(java.lang.String mes, java.lang.String anho, java.lang.String codOficina, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.MaestroPlan _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 46, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findUbicar(mes, anho, codOficina, codTerritorio);
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
				container.postInvoke(this, 46, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findxIdMenu
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Menu findxIdMenu(java.lang.String padre) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Menu _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = padre;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 47, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findxIdMenu(padre);
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
				container.postInvoke(this, 47, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findGestorByCodMonthYear
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor findGestorByCodMonthYear(java.lang.String anho, java.lang.String mes, java.lang.String codOficina, java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 48, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findGestorByCodMonthYear(anho, mes, codOficina, codGestor);
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
				container.postInvoke(this, 48, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findGestorByCodigo
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor findGestorByCodigo(java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 49, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findGestorByCodigo(codGestor);
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
				container.postInvoke(this, 49, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findMetGestorByPrimaryKey
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor findMetGestorByPrimaryKey(java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codEpigrafe;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 50, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findMetGestorByPrimaryKey(codEpigrafe, anho, codOficina, mes, codGestor);
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
				container.postInvoke(this, 50, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByID
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Multitabla findByID(java.lang.String id) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Multitabla _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = id;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 51, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findByID(id);
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
				container.postInvoke(this, 51, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findMultiByPrimaryKey
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Multitabla findMultiByPrimaryKey(java.lang.String codMulti, java.lang.String codElem) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Multitabla _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codMulti;
				_jacc_parms[1] = codElem;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 52, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findMultiByPrimaryKey(codMulti, codElem);
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
				container.postInvoke(this, 52, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 53, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 53, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 54, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 54, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 55, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 55, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findParametroAll
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Parametro findParametroAll() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Parametro _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 56, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findParametroAll();
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
				container.postInvoke(this, 56, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findPerfil
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Perfil findPerfil(java.lang.String cod_perfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Perfil _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = cod_perfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 57, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findPerfil(cod_perfil);
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
				container.postInvoke(this, 57, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findPermisoPerfilById
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil findPermisoPerfilById(java.lang.String codPerfil, java.lang.String tipoAcceso, java.lang.String valorRCP) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codPerfil;
				_jacc_parms[1] = tipoAcceso;
				_jacc_parms[2] = valorRCP;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 58, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findPermisoPerfilById(codPerfil, tipoAcceso, valorRCP);
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
				container.postInvoke(this, 58, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findPermisoPerfilxTipAccxValorRCP
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil findPermisoPerfilxTipAccxValorRCP(java.lang.String codReg, java.lang.String codCat, java.lang.String path) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codReg;
				_jacc_parms[1] = codCat;
				_jacc_parms[2] = path;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 59, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findPermisoPerfilxTipAccxValorRCP(codReg, codCat, path);
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
				container.postInvoke(this, 59, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findConsultaPlanesResumen
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Plan findConsultaPlanesResumen(java.lang.String mes, java.lang.String anho, java.lang.String codEpigrafe, java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Plan _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codEpigrafe;
				_jacc_parms[3] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 60, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findConsultaPlanesResumen(mes, anho, codEpigrafe, codOficina);
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
				container.postInvoke(this, 60, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findProgTerritorio
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento findProgTerritorio(com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = progTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 61, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findProgTerritorio(progTerritorio);
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
				container.postInvoke(this, 61, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findProgramacionSeguimiento
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento findProgramacionSeguimiento(java.lang.String mes, java.lang.String anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anio;
				_jacc_parms[2] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 62, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findProgramacionSeguimiento(mes, anio, codTerritorio);
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
				container.postInvoke(this, 62, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByCodTerritorio
	 */
	public com.grupobbva.bc.per.tele.sdo.serializable.Territorio findByCodTerritorio(java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		com.grupobbva.bc.per.tele.sdo.serializable.Territorio _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 63, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findByCodTerritorio(codTerritorio);
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
				container.postInvoke(this, 63, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 64, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 64, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * actualizarEstadoFlag
	 */
	public int actualizarEstadoFlag(java.lang.String flag) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = flag;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 65, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.actualizarEstadoFlag(flag);
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
				container.postInvoke(this, 65, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * actualizarPorcentajeEpigrafe
	 */
	public int actualizarPorcentajeEpigrafe(com.grupobbva.bc.per.tele.sdo.serializable.Epigrafe datos) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = datos;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 66, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.actualizarPorcentajeEpigrafe(datos);
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
				container.postInvoke(this, 66, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busID_IngresoMax
	 */
	public int busID_IngresoMax() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 67, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busID_IngresoMax();
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
				container.postInvoke(this, 67, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * codigoAccion
	 */
	public int codigoAccion() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 68, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.codigoAccion();
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
				container.postInvoke(this, 68, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * codigoCampMax
	 */
	public int codigoCampMax() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 69, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.codigoCampMax();
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
				container.postInvoke(this, 69, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 70, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 70, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findMesesReferencia
	 */
	public int findMesesReferencia(int mes, int anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(mes);
				_jacc_parms[1] = new java.lang.Integer(anio);
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 71, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findMesesReferencia(mes, anio);
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
				container.postInvoke(this, 71, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * listadoIngresoxDia
	 */
	public int listadoIngresoxDia(java.lang.String diaActual, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = diaActual;
				_jacc_parms[1] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 72, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listadoIngresoxDia(diaActual, codTerritorio);
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
				container.postInvoke(this, 72, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * metasGestor
	 */
	public int metasGestor(java.lang.String codGestor, int anio, int mes, java.lang.String codEpigrafe) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codGestor;
				_jacc_parms[1] = new java.lang.Integer(anio);
				_jacc_parms[2] = new java.lang.Integer(mes);
				_jacc_parms[3] = codEpigrafe;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 73, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.metasGestor(codGestor, anio, mes, codEpigrafe);
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
				container.postInvoke(this, 73, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * metasOficina
	 */
	public int metasOficina(java.lang.String codOficina, int anio, int mes, java.lang.String codEpigrafe) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codOficina;
				_jacc_parms[1] = new java.lang.Integer(anio);
				_jacc_parms[2] = new java.lang.Integer(mes);
				_jacc_parms[3] = codEpigrafe;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 74, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.metasOficina(codOficina, anio, mes, codEpigrafe);
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
				container.postInvoke(this, 74, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 75, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 75, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * nuevoIngreso
	 */
	public int nuevoIngreso(java.lang.String id_ingresos, java.lang.String codUsuario, java.lang.String cargo, java.lang.String nomTerritorio, java.lang.String codOficina, java.lang.String nombres) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = id_ingresos;
				_jacc_parms[1] = codUsuario;
				_jacc_parms[2] = cargo;
				_jacc_parms[3] = nomTerritorio;
				_jacc_parms[4] = codOficina;
				_jacc_parms[5] = nombres;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 76, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.nuevoIngreso(id_ingresos, codUsuario, cargo, nomTerritorio, codOficina, nombres);
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
				container.postInvoke(this, 76, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * obtenerPrimerMesPresup
	 */
	public int obtenerPrimerMesPresup() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 77, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.obtenerPrimerMesPresup();
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
				container.postInvoke(this, 77, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * registrarPermisoPerfil
	 */
	public int registrarPermisoPerfil(com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil permisoPerfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = permisoPerfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 78, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.registrarPermisoPerfil(permisoPerfil);
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
				container.postInvoke(this, 78, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTAcciones
	 */
	public int xInsertarTAcciones(java.lang.String codigoAccion, java.lang.String nomberAccion, java.lang.String codigoGestor, java.lang.String mes, java.lang.String anho, int nroClientes, int compromisoGestor, int nroGestorSeguimiento1, int nroConcSeguimiento1, int montoSeguimiento1, int nroGestorSeguimiento2, int nroConcSeguimiento2, int montoSeguimiento2, java.lang.String codigoOficina, java.lang.String codigoEpigrafe, java.util.Date fechaSeg1, java.util.Date fechaSeg2, java.util.Date fechaGrabacion, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[19];
				_jacc_parms[0] = codigoAccion;
				_jacc_parms[1] = nomberAccion;
				_jacc_parms[2] = codigoGestor;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = anho;
				_jacc_parms[5] = new java.lang.Integer(nroClientes);
				_jacc_parms[6] = new java.lang.Integer(compromisoGestor);
				_jacc_parms[7] = new java.lang.Integer(nroGestorSeguimiento1);
				_jacc_parms[8] = new java.lang.Integer(nroConcSeguimiento1);
				_jacc_parms[9] = new java.lang.Integer(montoSeguimiento1);
				_jacc_parms[10] = new java.lang.Integer(nroGestorSeguimiento2);
				_jacc_parms[11] = new java.lang.Integer(nroConcSeguimiento2);
				_jacc_parms[12] = new java.lang.Integer(montoSeguimiento2);
				_jacc_parms[13] = codigoOficina;
				_jacc_parms[14] = codigoEpigrafe;
				_jacc_parms[15] = fechaSeg1;
				_jacc_parms[16] = fechaSeg2;
				_jacc_parms[17] = fechaGrabacion;
				_jacc_parms[18] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 79, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTAcciones(codigoAccion, nomberAccion, codigoGestor, mes, anho, nroClientes, compromisoGestor, nroGestorSeguimiento1, nroConcSeguimiento1, montoSeguimiento1, nroGestorSeguimiento2, nroConcSeguimiento2, montoSeguimiento2, codigoOficina, codigoEpigrafe, fechaSeg1, fechaSeg2, fechaGrabacion, codTerritorio);
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
				container.postInvoke(this, 79, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTCampanhas
	 */
	public int xInsertarTCampanhas(java.lang.String codigoCampania, java.lang.String anho, java.lang.String mes, java.lang.String nombreCampania, java.lang.String codigoOficina, java.lang.String codigoGestor, java.lang.String orden, java.lang.String gte, java.util.Date fechaGrabacion, java.lang.String codigoTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[10];
				_jacc_parms[0] = codigoCampania;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = mes;
				_jacc_parms[3] = nombreCampania;
				_jacc_parms[4] = codigoOficina;
				_jacc_parms[5] = codigoGestor;
				_jacc_parms[6] = orden;
				_jacc_parms[7] = gte;
				_jacc_parms[8] = fechaGrabacion;
				_jacc_parms[9] = codigoTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 80, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTCampanhas(codigoCampania, anho, mes, nombreCampania, codigoOficina, codigoGestor, orden, gte, fechaGrabacion, codigoTerritorio);
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
				container.postInvoke(this, 80, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTCampanhasDetalle
	 */
	public int xInsertarTCampanhasDetalle(java.lang.String codigoCampanhaDetalle, java.lang.String nombreCampanha, java.lang.String codigoGestor, java.lang.String mes, java.lang.String anho, int nroClientes, int compromisoGestor, int nroGestorSeguimiento1, int nroConcSeguimiento1, int montoSeguimiento1, int nroGestorSeguimiento2, int nroConcSeguimiento2, int montoSeguimiento2, java.lang.String codigoOficina, java.lang.String codigoCampanha, java.util.Date fechaGrabacion, java.util.Date fechaSeg1, java.util.Date fechaSeg2, java.lang.String codigoTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[19];
				_jacc_parms[0] = codigoCampanhaDetalle;
				_jacc_parms[1] = nombreCampanha;
				_jacc_parms[2] = codigoGestor;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = anho;
				_jacc_parms[5] = new java.lang.Integer(nroClientes);
				_jacc_parms[6] = new java.lang.Integer(compromisoGestor);
				_jacc_parms[7] = new java.lang.Integer(nroGestorSeguimiento1);
				_jacc_parms[8] = new java.lang.Integer(nroConcSeguimiento1);
				_jacc_parms[9] = new java.lang.Integer(montoSeguimiento1);
				_jacc_parms[10] = new java.lang.Integer(nroGestorSeguimiento2);
				_jacc_parms[11] = new java.lang.Integer(nroConcSeguimiento2);
				_jacc_parms[12] = new java.lang.Integer(montoSeguimiento2);
				_jacc_parms[13] = codigoOficina;
				_jacc_parms[14] = codigoCampanha;
				_jacc_parms[15] = fechaGrabacion;
				_jacc_parms[16] = fechaSeg1;
				_jacc_parms[17] = fechaSeg2;
				_jacc_parms[18] = codigoTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 81, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTCampanhasDetalle(codigoCampanhaDetalle, nombreCampanha, codigoGestor, mes, anho, nroClientes, compromisoGestor, nroGestorSeguimiento1, nroConcSeguimiento1, montoSeguimiento1, nroGestorSeguimiento2, nroConcSeguimiento2, montoSeguimiento2, codigoOficina, codigoCampanha, fechaGrabacion, fechaSeg1, fechaSeg2, codigoTerritorio);
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
				container.postInvoke(this, 81, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTEpigrafes
	 */
	public int xInsertarTEpigrafes(java.lang.String codigoepigrafe, java.lang.String nombreepigrafe, java.lang.String anho, java.lang.String indicadorclase, java.lang.String indicadorsubclase, java.lang.String orden, java.lang.String indicadorgrupo, java.lang.String abreviatura, java.lang.String indicadorhijo, java.lang.String indicadorafecta) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[10];
				_jacc_parms[0] = codigoepigrafe;
				_jacc_parms[1] = nombreepigrafe;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = indicadorclase;
				_jacc_parms[4] = indicadorsubclase;
				_jacc_parms[5] = orden;
				_jacc_parms[6] = indicadorgrupo;
				_jacc_parms[7] = abreviatura;
				_jacc_parms[8] = indicadorhijo;
				_jacc_parms[9] = indicadorafecta;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 82, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTEpigrafes(codigoepigrafe, nombreepigrafe, anho, indicadorclase, indicadorsubclase, orden, indicadorgrupo, abreviatura, indicadorhijo, indicadorafecta);
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
				container.postInvoke(this, 82, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTEquivalencias
	 */
	public int xInsertarTEquivalencias(java.lang.String codigoCargo, java.lang.String codigoPerfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codigoCargo;
				_jacc_parms[1] = codigoPerfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 83, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTEquivalencias(codigoCargo, codigoPerfil);
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
				container.postInvoke(this, 83, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTFirmas
	 */
	public int xInsertarTFirmas(java.lang.String anho, java.lang.String mes, java.lang.String item, java.lang.String codigoGestor, java.lang.String codigoOficina, java.lang.String descripcion, java.util.Date fecha) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[7];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = item;
				_jacc_parms[3] = codigoGestor;
				_jacc_parms[4] = codigoOficina;
				_jacc_parms[5] = descripcion;
				_jacc_parms[6] = fecha;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 84, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTFirmas(anho, mes, item, codigoGestor, codigoOficina, descripcion, fecha);
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
				container.postInvoke(this, 84, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTMaestroPlanes
	 */
	public int xInsertarTMaestroPlanes(java.lang.String codigoOficina, java.lang.String mes, java.lang.String anho, java.lang.String codigoTerritorio, java.lang.String prioridad, java.util.Date fechaGrabacion) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = codigoOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codigoTerritorio;
				_jacc_parms[4] = prioridad;
				_jacc_parms[5] = fechaGrabacion;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 85, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTMaestroPlanes(codigoOficina, mes, anho, codigoTerritorio, prioridad, fechaGrabacion);
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
				container.postInvoke(this, 85, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTMetasGestor
	 */
	public int xInsertarTMetasGestor(java.lang.String codigoMetaGestor, java.lang.String codigoEpigrafe, java.lang.String codigoOficina, java.lang.String codigoGestor, java.lang.String anho, java.lang.String mes, java.lang.String orden, java.util.Date fechaGrabacion, java.lang.String porcAsignado, java.lang.String nombreEpigrafe, java.lang.String nombreGestor, java.lang.String codigoTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[12];
				_jacc_parms[0] = codigoMetaGestor;
				_jacc_parms[1] = codigoEpigrafe;
				_jacc_parms[2] = codigoOficina;
				_jacc_parms[3] = codigoGestor;
				_jacc_parms[4] = anho;
				_jacc_parms[5] = mes;
				_jacc_parms[6] = orden;
				_jacc_parms[7] = fechaGrabacion;
				_jacc_parms[8] = porcAsignado;
				_jacc_parms[9] = nombreEpigrafe;
				_jacc_parms[10] = nombreGestor;
				_jacc_parms[11] = codigoTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 86, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTMetasGestor(codigoMetaGestor, codigoEpigrafe, codigoOficina, codigoGestor, anho, mes, orden, fechaGrabacion, porcAsignado, nombreEpigrafe, nombreGestor, codigoTerritorio);
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
				container.postInvoke(this, 86, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTOficina
	 */
	public int xInsertarTOficina(java.lang.String codigoTerritorio, java.lang.String nombreOficina, java.lang.String codigoOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codigoTerritorio;
				_jacc_parms[1] = nombreOficina;
				_jacc_parms[2] = codigoOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 87, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTOficina(codigoTerritorio, nombreOficina, codigoOficina);
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
				container.postInvoke(this, 87, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTParametros
	 */
	public int xInsertarTParametros(java.util.Date fechaAccion, java.util.Date fechaSeguimiento1, java.util.Date fechaSeguimiento2, java.lang.String afectaAccion, java.lang.String afectaSeguimiento, java.lang.String afectaPlanificacion, java.util.Date fechaPlanificacion) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[7];
				_jacc_parms[0] = fechaAccion;
				_jacc_parms[1] = fechaSeguimiento1;
				_jacc_parms[2] = fechaSeguimiento2;
				_jacc_parms[3] = afectaAccion;
				_jacc_parms[4] = afectaSeguimiento;
				_jacc_parms[5] = afectaPlanificacion;
				_jacc_parms[6] = fechaPlanificacion;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 88, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTParametros(fechaAccion, fechaSeguimiento1, fechaSeguimiento2, afectaAccion, afectaSeguimiento, afectaPlanificacion, fechaPlanificacion);
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
				container.postInvoke(this, 88, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTPerfiles
	 */
	public int xInsertarTPerfiles(java.lang.String codigoPerfil, java.lang.String nombrePerfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codigoPerfil;
				_jacc_parms[1] = nombrePerfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 89, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTPerfiles(codigoPerfil, nombrePerfil);
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
				container.postInvoke(this, 89, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTPlanes
	 */
	public int xInsertarTPlanes(java.lang.String codigoOficina, java.lang.String mes, java.lang.String anho, java.lang.String codigoEpigrafe, java.lang.String nombreEpigrafe, int pesodor, int monto, int porcAlcanzado, int desvpPto, int nroMesesFalt, int proyCrecMensual, int ajusteEstimadoTerr, int proyAjusteMensual, int saldoMedioJunio, int porcSaldoMedioJunio, int saldoDiciembreAnterior, int saldoMedioDiciembre, java.lang.String codigoTerritorio, int porcSaldoMedioDiciembre, int factorAjusteSaldoPuntual, int historicoBajas, int metaMesSaldoPuntual, int metaGerenteOficina, int prioridad, java.lang.String mesEvaluacion, java.lang.String indicadorDor, int varMes, int ajustePspto, int desvPsptoAjustado, int factAjustTerritorial, int factAsignGteOf) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[31];
				_jacc_parms[0] = codigoOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codigoEpigrafe;
				_jacc_parms[4] = nombreEpigrafe;
				_jacc_parms[5] = new java.lang.Integer(pesodor);
				_jacc_parms[6] = new java.lang.Integer(monto);
				_jacc_parms[7] = new java.lang.Integer(porcAlcanzado);
				_jacc_parms[8] = new java.lang.Integer(desvpPto);
				_jacc_parms[9] = new java.lang.Integer(nroMesesFalt);
				_jacc_parms[10] = new java.lang.Integer(proyCrecMensual);
				_jacc_parms[11] = new java.lang.Integer(ajusteEstimadoTerr);
				_jacc_parms[12] = new java.lang.Integer(proyAjusteMensual);
				_jacc_parms[13] = new java.lang.Integer(saldoMedioJunio);
				_jacc_parms[14] = new java.lang.Integer(porcSaldoMedioJunio);
				_jacc_parms[15] = new java.lang.Integer(saldoDiciembreAnterior);
				_jacc_parms[16] = new java.lang.Integer(saldoMedioDiciembre);
				_jacc_parms[17] = codigoTerritorio;
				_jacc_parms[18] = new java.lang.Integer(porcSaldoMedioDiciembre);
				_jacc_parms[19] = new java.lang.Integer(factorAjusteSaldoPuntual);
				_jacc_parms[20] = new java.lang.Integer(historicoBajas);
				_jacc_parms[21] = new java.lang.Integer(metaMesSaldoPuntual);
				_jacc_parms[22] = new java.lang.Integer(metaGerenteOficina);
				_jacc_parms[23] = new java.lang.Integer(prioridad);
				_jacc_parms[24] = mesEvaluacion;
				_jacc_parms[25] = indicadorDor;
				_jacc_parms[26] = new java.lang.Integer(varMes);
				_jacc_parms[27] = new java.lang.Integer(ajustePspto);
				_jacc_parms[28] = new java.lang.Integer(desvPsptoAjustado);
				_jacc_parms[29] = new java.lang.Integer(factAjustTerritorial);
				_jacc_parms[30] = new java.lang.Integer(factAsignGteOf);
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 90, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTPlanes(codigoOficina, mes, anho, codigoEpigrafe, nombreEpigrafe, pesodor, monto, porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual, ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio, porcSaldoMedioJunio, saldoDiciembreAnterior, saldoMedioDiciembre, codigoTerritorio, porcSaldoMedioDiciembre, factorAjusteSaldoPuntual, historicoBajas, metaMesSaldoPuntual, metaGerenteOficina, prioridad, mesEvaluacion, indicadorDor, varMes, ajustePspto, desvPsptoAjustado, factAjustTerritorial, factAsignGteOf);
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
				container.postInvoke(this, 90, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xInsertarTTerritorio
	 */
	public int xInsertarTTerritorio(java.lang.String codigoTerritorio, java.lang.String nombreTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		int _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codigoTerritorio;
				_jacc_parms[1] = nombreTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 91, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xInsertarTTerritorio(codigoTerritorio, nombreTerritorio);
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
				container.postInvoke(this, 91, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * buscarEstadoFlag
	 */
	public java.lang.String buscarEstadoFlag() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 92, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.buscarEstadoFlag();
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
				container.postInvoke(this, 92, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCorrelativo
	 */
	public java.lang.String getCorrelativo(java.lang.String nomTabla, java.lang.String nomCampo, java.lang.String tamano) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = nomTabla;
				_jacc_parms[1] = nomCampo;
				_jacc_parms[2] = tamano;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 93, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.getCorrelativo(nomTabla, nomCampo, tamano);
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
				container.postInvoke(this, 93, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * testearBD
	 */
	public java.lang.String testearBD() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 94, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.testearBD();
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
				container.postInvoke(this, 94, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xDameTerritorio
	 */
	public java.lang.String xDameTerritorio(java.lang.String codigoOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.lang.String _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codigoOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 95, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xDameTerritorio(codigoOficina);
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
				container.postInvoke(this, 95, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * buscarMontoGestor
	 */
	public java.math.BigDecimal buscarMontoGestor(java.lang.String codGestor, java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codGestor;
				_jacc_parms[1] = codEpigrafe;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codOficina;
				_jacc_parms[4] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 96, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.buscarMontoGestor(codGestor, codEpigrafe, anho, codOficina, mes);
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
				container.postInvoke(this, 96, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * promedioMensual
	 */
	public java.math.BigDecimal promedioMensual(java.lang.String anho, java.lang.String mes, java.lang.String codOfi, java.lang.String codTerr, java.lang.String codEpi, java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.math.BigDecimal _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = codOfi;
				_jacc_parms[3] = codTerr;
				_jacc_parms[4] = codEpi;
				_jacc_parms[5] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 97, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.promedioMensual(anho, mes, codOfi, codTerr, codEpi, codGestor);
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
				container.postInvoke(this, 97, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * listarDiasMesesxAnio
	 */
	public java.util.ArrayList listarDiasMesesxAnio(int anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.ArrayList _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Integer(anio);
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 98, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listarDiasMesesxAnio(anio);
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
				container.postInvoke(this, 98, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * buscarResumenMontos
	 */
	public java.util.HashMap buscarResumenMontos(java.util.Vector listaEpigrafe, java.lang.String codTerritorio, java.lang.String codOficina, java.lang.String anho, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.HashMap _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = listaEpigrafe;
				_jacc_parms[1] = codTerritorio;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = anho;
				_jacc_parms[4] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 99, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.buscarResumenMontos(listaEpigrafe, codTerritorio, codOficina, anho, mes);
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
				container.postInvoke(this, 99, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findCantidadPersonal
	 */
	public java.util.HashMap findCantidadPersonal(java.lang.String anho, java.lang.String mes, java.lang.String codOfi, java.lang.String codTerr) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.HashMap _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = codOfi;
				_jacc_parms[3] = codTerr;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 100, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findCantidadPersonal(anho, mes, codOfi, codTerr);
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
				container.postInvoke(this, 100, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * reportePGOResumen2
	 */
	public java.util.Hashtable reportePGOResumen2(java.lang.String codTerritorio, java.lang.String mes, java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Hashtable _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 101, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportePGOResumen2(codTerritorio, mes, anho);
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
				container.postInvoke(this, 101, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busAccionesPGG3
	 */
	public java.util.Vector busAccionesPGG3(java.lang.String codAnho, java.lang.String codMes, java.lang.String codGestor, java.lang.String codEpigrafe) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codAnho;
				_jacc_parms[1] = codMes;
				_jacc_parms[2] = codGestor;
				_jacc_parms[3] = codEpigrafe;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 102, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAccionesPGG3(codAnho, codMes, codGestor, codEpigrafe);
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
				container.postInvoke(this, 102, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busAllAnho
	 */
	public java.util.Vector busAllAnho() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 103, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAllAnho();
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
				container.postInvoke(this, 103, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busAllAnhos
	 */
	public java.util.Vector busAllAnhos() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 104, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAllAnhos();
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
				container.postInvoke(this, 104, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busAllTerritorio
	 */
	public java.util.Vector busAllTerritorio() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 105, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAllTerritorio();
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
				container.postInvoke(this, 105, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busAllTerritorioActivo
	 */
	public java.util.Vector busAllTerritorioActivo() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 106, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAllTerritorioActivo();
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
				container.postInvoke(this, 106, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busAnhoMaxAcciones
	 */
	public java.util.Vector busAnhoMaxAcciones() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 107, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAnhoMaxAcciones();
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
				container.postInvoke(this, 107, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busAnhosAcciones
	 */
	public java.util.Vector busAnhosAcciones() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 108, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busAnhosAcciones();
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
				container.postInvoke(this, 108, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busEpigrafeAcciones2
	 */
	public java.util.Vector busEpigrafeAcciones2(java.lang.String codGestor, java.lang.String anho, java.lang.String mes, java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codGestor;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = mes;
				_jacc_parms[3] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 109, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busEpigrafeAcciones2(codGestor, anho, mes, codOficina);
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
				container.postInvoke(this, 109, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busGestorxOficina
	 */
	public java.util.Vector busGestorxOficina(java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 110, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busGestorxOficina(codOficina);
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
				container.postInvoke(this, 110, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busGestorxOficinaxAnioxMes
	 */
	public java.util.Vector busGestorxOficinaxAnioxMes(java.lang.String codOficina, java.lang.String mes, java.lang.String anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 111, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busGestorxOficinaxAnioxMes(codOficina, mes, anio);
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
				container.postInvoke(this, 111, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busIngresoxDIA
	 */
	public java.util.Vector busIngresoxDIA(java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 112, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxDIA(codTerritorioUsuario);
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
				container.postInvoke(this, 112, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busIngresoxOFICINAxAnho
	 */
	public java.util.Vector busIngresoxOFICINAxAnho(java.lang.String anho, java.lang.String codOficina, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = codOficina;
				_jacc_parms[2] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 113, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxOFICINAxAnho(anho, codOficina, codTerritorioUsuario);
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
				container.postInvoke(this, 113, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busIngresoxOFICINAxMes
	 */
	public java.util.Vector busIngresoxOFICINAxMes(java.lang.String mes, java.lang.String codOficina, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = codOficina;
				_jacc_parms[2] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 114, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxOFICINAxMes(mes, codOficina, codTerritorioUsuario);
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
				container.postInvoke(this, 114, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busIngresoxOficina
	 */
	public java.util.Vector busIngresoxOficina(java.lang.String anho, java.lang.String mes, java.lang.String dia, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = dia;
				_jacc_parms[3] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 115, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxOficina(anho, mes, dia, codTerritorioUsuario);
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
				container.postInvoke(this, 115, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busIngresoxTERRITORIOxAnho
	 */
	public java.util.Vector busIngresoxTERRITORIOxAnho(java.lang.String anho, java.lang.String nomTerritorio, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = nomTerritorio;
				_jacc_parms[2] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 116, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxTERRITORIOxAnho(anho, nomTerritorio, codTerritorioUsuario);
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
				container.postInvoke(this, 116, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busIngresoxTERRITORIOxMes
	 */
	public java.util.Vector busIngresoxTERRITORIOxMes(java.lang.String mes, java.lang.String nomTerritorio, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = nomTerritorio;
				_jacc_parms[2] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 117, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxTERRITORIOxMes(mes, nomTerritorio, codTerritorioUsuario);
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
				container.postInvoke(this, 117, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busIngresoxTerritorio
	 */
	public java.util.Vector busIngresoxTerritorio(java.lang.String anho, java.lang.String mes, java.lang.String dia, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = dia;
				_jacc_parms[3] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 118, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxTerritorio(anho, mes, dia, codTerritorioUsuario);
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
				container.postInvoke(this, 118, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busIngresoxUSUARIOxAnho
	 */
	public java.util.Vector busIngresoxUSUARIOxAnho(java.lang.String anho, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 119, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxUSUARIOxAnho(anho, codTerritorioUsuario);
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
				container.postInvoke(this, 119, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busIngresoxUSUARIOxMes
	 */
	public java.util.Vector busIngresoxUSUARIOxMes(java.lang.String mes, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 120, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxUSUARIOxMes(mes, codTerritorioUsuario);
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
				container.postInvoke(this, 120, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busIngresoxUsuario
	 */
	public java.util.Vector busIngresoxUsuario(java.lang.String anho, java.lang.String mes, java.lang.String dia, java.lang.String codTerritorioUsuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = dia;
				_jacc_parms[3] = codTerritorioUsuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 121, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busIngresoxUsuario(anho, mes, dia, codTerritorioUsuario);
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
				container.postInvoke(this, 121, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busOficinaCodyNom
	 */
	public java.util.Vector busOficinaCodyNom(java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 122, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busOficinaCodyNom(codTerritorio);
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
				container.postInvoke(this, 122, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 123, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 123, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 124, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 124, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busTerritorioxCod
	 */
	public java.util.Vector busTerritorioxCod(java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 125, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busTerritorioxCod(codTerritorio);
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
				container.postInvoke(this, 125, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * busTerritorioxRegistroLDAP
	 */
	public java.util.Vector busTerritorioxRegistroLDAP(java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 126, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.busTerritorioxRegistroLDAP(codGestor);
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
				container.postInvoke(this, 126, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * buscarUsuariosLDAP
	 */
	public java.util.Vector buscarUsuariosLDAP(java.lang.String codOficina, java.lang.String codEmpresa, int limiteOcurrencias) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codOficina;
				_jacc_parms[1] = codEmpresa;
				_jacc_parms[2] = new java.lang.Integer(limiteOcurrencias);
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 127, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.buscarUsuariosLDAP(codOficina, codEmpresa, limiteOcurrencias);
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
				container.postInvoke(this, 127, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * codOficinaMax
	 */
	public java.util.Vector codOficinaMax(java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 128, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.codOficinaMax(codTerritorio);
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
				container.postInvoke(this, 128, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * consultaSeguimientoAccionEsfuerzo
	 */
	public java.util.Vector consultaSeguimientoAccionEsfuerzo(java.lang.String codOfi, java.lang.String mes, java.lang.String anho, java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codOfi;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 129, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.consultaSeguimientoAccionEsfuerzo(codOfi, mes, anho, codGestor);
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
				container.postInvoke(this, 129, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * consultaSeguimientoAccionEsfuerzoPGO
	 */
	public java.util.Vector consultaSeguimientoAccionEsfuerzoPGO(java.lang.String codOfi, java.lang.String mes, java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codOfi;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 130, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.consultaSeguimientoAccionEsfuerzoPGO(codOfi, mes, anho);
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
				container.postInvoke(this, 130, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * consultarCampaniasDetalles
	 */
	public java.util.Vector consultarCampaniasDetalles(java.lang.String codigoOficina, java.lang.String mes, java.lang.String anho, java.lang.String codigoGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codigoOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codigoGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 131, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.consultarCampaniasDetalles(codigoOficina, mes, anho, codigoGestor);
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
				container.postInvoke(this, 131, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * consultarCampaniasDetallesPGG
	 */
	public java.util.Vector consultarCampaniasDetallesPGG(java.lang.String codigoOficina, java.lang.String mes, java.lang.String anho, java.lang.String codigoGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codigoOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codigoGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 132, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.consultarCampaniasDetallesPGG(codigoOficina, mes, anho, codigoGestor);
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
				container.postInvoke(this, 132, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * consultarPLanesAccion
	 */
	public java.util.Vector consultarPLanesAccion(java.lang.String codigoOficina, java.lang.String mes, java.lang.String anho, java.lang.String codigoGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codigoOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codigoGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 133, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.consultarPLanesAccion(codigoOficina, mes, anho, codigoGestor);
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
				container.postInvoke(this, 133, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * consultarPlanesAccionesPPG
	 */
	public java.util.Vector consultarPlanesAccionesPPG(java.lang.String codigoOficina, java.lang.String mes, java.lang.String anho, java.lang.String codigoGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codigoOficina;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codigoGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 134, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.consultarPlanesAccionesPPG(codigoOficina, mes, anho, codigoGestor);
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
				container.postInvoke(this, 134, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * distribuirGOF
	 */
	public java.util.Vector distribuirGOF(java.util.Vector listaGestoresLDAP, java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = listaGestoresLDAP;
				_jacc_parms[1] = codEpigrafe;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codOficina;
				_jacc_parms[4] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 135, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.distribuirGOF(listaGestoresLDAP, codEpigrafe, anho, codOficina, mes);
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
				container.postInvoke(this, 135, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * editarCampania
	 */
	public java.util.Vector editarCampania(java.lang.String anho, java.lang.String mes, java.lang.String nomCamp, java.lang.String orden, java.lang.String codCamp, java.lang.String usuario, java.lang.String codEpigrafe) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[7];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = nomCamp;
				_jacc_parms[3] = orden;
				_jacc_parms[4] = codCamp;
				_jacc_parms[5] = usuario;
				_jacc_parms[6] = codEpigrafe;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 136, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.editarCampania(anho, mes, nomCamp, orden, codCamp, usuario, codEpigrafe);
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
				container.postInvoke(this, 136, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 137, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 137, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 138, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 138, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * eliminarAccion
	 */
	public java.util.Vector eliminarAccion(java.lang.String codAccion) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codAccion;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 139, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.eliminarAccion(codAccion);
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
				container.postInvoke(this, 139, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * eliminarCampania
	 */
	public java.util.Vector eliminarCampania(java.lang.String codCamp) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codCamp;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 140, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.eliminarCampania(codCamp);
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
				container.postInvoke(this, 140, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * eliminarTerritorio
	 */
	public java.util.Vector eliminarTerritorio(java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 141, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.eliminarTerritorio(codTerritorio);
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
				container.postInvoke(this, 141, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * exportarTablasTXT
	 */
	public java.util.Vector exportarTablasTXT(int tabla, int mes, int anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = new java.lang.Integer(tabla);
				_jacc_parms[1] = new java.lang.Integer(mes);
				_jacc_parms[2] = new java.lang.Integer(anio);
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 142, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.exportarTablasTXT(tabla, mes, anio);
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
				container.postInvoke(this, 142, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllEquivalencias
	 */
	public java.util.Vector findAllEquivalencias() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 143, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllEquivalencias();
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
				container.postInvoke(this, 143, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllMenu
	 */
	public java.util.Vector findAllMenu() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 144, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllMenu();
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
				container.postInvoke(this, 144, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 145, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 145, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 146, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 146, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 147, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 147, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllOficinaConMetas
	 */
	public java.util.Vector findAllOficinaConMetas(java.lang.String codTerritorio, java.lang.String mes, java.lang.String anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 148, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllOficinaConMetas(codTerritorio, mes, anio);
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
				container.postInvoke(this, 148, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 149, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 149, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllParametro
	 */
	public java.util.Vector findAllParametro() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 150, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllParametro();
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
				container.postInvoke(this, 150, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllPerfil
	 */
	public java.util.Vector findAllPerfil() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 151, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllPerfil();
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
				container.postInvoke(this, 151, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllPermisoPerfil
	 */
	public java.util.Vector findAllPermisoPerfil() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 152, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllPermisoPerfil();
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
				container.postInvoke(this, 152, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllTerritorio
	 */
	public java.util.Vector findAllTerritorio() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 153, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findAllTerritorio();
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
				container.postInvoke(this, 153, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByCodMulti
	 */
	public java.util.Vector findByCodMulti(java.lang.String codMulti) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codMulti;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 154, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findByCodMulti(codMulti);
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
				container.postInvoke(this, 154, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByMultiForPresup
	 */
	public java.util.Vector findByMultiForPresup(java.lang.String codMulti, java.lang.String Valor2) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codMulti;
				_jacc_parms[1] = Valor2;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 155, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findByMultiForPresup(codMulti, Valor2);
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
				container.postInvoke(this, 155, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findConsultaPlanes
	 */
	public java.util.Vector findConsultaPlanes(java.lang.String codTerritorio, java.lang.String codOficina, java.lang.String anho, java.lang.String mes, java.lang.String presuReferencia) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = codOficina;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = presuReferencia;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 156, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findConsultaPlanes(codTerritorio, codOficina, anho, mes, presuReferencia);
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
				container.postInvoke(this, 156, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findConsultarPlanesxMes
	 */
	public java.util.Vector findConsultarPlanesxMes(java.lang.String codOficina, java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codOficina;
				_jacc_parms[1] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 157, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findConsultarPlanesxMes(codOficina, anho);
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
				container.postInvoke(this, 157, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findEpiByAnho
	 */
	public java.util.Vector findEpiByAnho(java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 158, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findEpiByAnho(anho);
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
				container.postInvoke(this, 158, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findEpigrafeInf
	 */
	public java.util.Vector findEpigrafeInf(java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 159, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findEpigrafeInf(anho);
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
				container.postInvoke(this, 159, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findEpigrafesinPlanes
	 */
	public java.util.Vector findEpigrafesinPlanes(java.lang.String codOficina, java.lang.String anho, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codOficina;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 160, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findEpigrafesinPlanes(codOficina, anho, mes);
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
				container.postInvoke(this, 160, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 161, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 161, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 162, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 162, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findPlanAnual
	 */
	public java.util.Vector findPlanAnual(java.lang.String anho, java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 163, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findPlanAnual(anho, codOficina);
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
				container.postInvoke(this, 163, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 164, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 164, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findTodosProgTerritorio
	 */
	public java.util.Vector findTodosProgTerritorio(com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = progTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 165, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findTodosProgTerritorio(progTerritorio);
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
				container.postInvoke(this, 165, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findxCodPerfil
	 */
	public java.util.Vector findxCodPerfil(java.lang.String codPerfil) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codPerfil;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 166, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.findxCodPerfil(codPerfil);
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
				container.postInvoke(this, 166, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * listaCampaniaDetalle
	 */
	public java.util.Vector listaCampaniaDetalle(java.lang.String codTerritorio, java.lang.String codOficina, java.lang.String codCamp, java.lang.String mes, java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = codOficina;
				_jacc_parms[2] = codCamp;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 167, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listaCampaniaDetalle(codTerritorio, codOficina, codCamp, mes, anho);
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
				container.postInvoke(this, 167, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * listaReportePPG
	 */
	public java.util.Vector listaReportePPG(java.lang.String anho, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 168, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listaReportePPG(anho, mes);
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
				container.postInvoke(this, 168, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * listaReportePlanificacion
	 */
	public java.util.Vector listaReportePlanificacion() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 169, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listaReportePlanificacion();
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
				container.postInvoke(this, 169, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * listaReporteSeguimiento1
	 */
	public java.util.Vector listaReporteSeguimiento1(java.lang.String anho, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 170, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listaReporteSeguimiento1(anho, mes);
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
				container.postInvoke(this, 170, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * listaReporteSeguimiento2
	 */
	public java.util.Vector listaReporteSeguimiento2(java.lang.String anho, java.lang.String mes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = anho;
				_jacc_parms[1] = mes;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 171, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.listaReporteSeguimiento2(anho, mes);
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
				container.postInvoke(this, 171, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * modificarTerritorio
	 */
	public java.util.Vector modificarTerritorio(java.lang.String codTerritorio, java.lang.String nomTerritorio, java.lang.String estado, java.lang.String mensaje, java.lang.String colorFondo, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = nomTerritorio;
				_jacc_parms[2] = estado;
				_jacc_parms[3] = mensaje;
				_jacc_parms[4] = colorFondo;
				_jacc_parms[5] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 172, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.modificarTerritorio(codTerritorio, nomTerritorio, estado, mensaje, colorFondo, usuario);
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
				container.postInvoke(this, 172, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * mostrarEditarCampania
	 */
	public java.util.Vector mostrarEditarCampania(java.lang.String codCamp) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = codCamp;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 173, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.mostrarEditarCampania(codCamp);
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
				container.postInvoke(this, 173, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * mostrarEsfuerzoCampania
	 */
	public java.util.Vector mostrarEsfuerzoCampania(java.lang.String codGest, java.lang.String mes, java.lang.String anho, java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = codGest;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 174, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.mostrarEsfuerzoCampania(codGest, mes, anho, codOficina);
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
				container.postInvoke(this, 174, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * nuevaAccion
	 */
	public java.util.Vector nuevaAccion(java.lang.String cod_acci, java.lang.String cod_epigrafe, java.lang.String anho, java.lang.String cod_terr, java.lang.String cod_ofic, java.lang.String nom_acci, java.lang.String cod_gest, java.lang.String mes_acci, java.lang.String nro_clie, java.lang.String comp_gest, java.lang.String nro_gest_segu_1, java.lang.String nro_conc_segu_1, java.lang.String mon_segu_1, java.lang.String nro_gest_segu_2, java.lang.String nro_conc_segu_2, java.lang.String mon_segu_2, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[17];
				_jacc_parms[0] = cod_acci;
				_jacc_parms[1] = cod_epigrafe;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = cod_terr;
				_jacc_parms[4] = cod_ofic;
				_jacc_parms[5] = nom_acci;
				_jacc_parms[6] = cod_gest;
				_jacc_parms[7] = mes_acci;
				_jacc_parms[8] = nro_clie;
				_jacc_parms[9] = comp_gest;
				_jacc_parms[10] = nro_gest_segu_1;
				_jacc_parms[11] = nro_conc_segu_1;
				_jacc_parms[12] = mon_segu_1;
				_jacc_parms[13] = nro_gest_segu_2;
				_jacc_parms[14] = nro_conc_segu_2;
				_jacc_parms[15] = mon_segu_2;
				_jacc_parms[16] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 175, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.nuevaAccion(cod_acci, cod_epigrafe, anho, cod_terr, cod_ofic, nom_acci, cod_gest, mes_acci, nro_clie, comp_gest, nro_gest_segu_1, nro_conc_segu_1, mon_segu_1, nro_gest_segu_2, nro_conc_segu_2, mon_segu_2, usuario);
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
				container.postInvoke(this, 175, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * nuevaCampania
	 */
	public java.util.Vector nuevaCampania(int codCamp, java.lang.String nomCamp, java.lang.String codOficicina, java.lang.String codTerritorio, java.lang.String codGestor, java.lang.String anho, java.lang.String mes, java.lang.String orden, java.lang.String get, java.lang.String usuario, java.lang.String codEpigrafe) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[11];
				_jacc_parms[0] = new java.lang.Integer(codCamp);
				_jacc_parms[1] = nomCamp;
				_jacc_parms[2] = codOficicina;
				_jacc_parms[3] = codTerritorio;
				_jacc_parms[4] = codGestor;
				_jacc_parms[5] = anho;
				_jacc_parms[6] = mes;
				_jacc_parms[7] = orden;
				_jacc_parms[8] = get;
				_jacc_parms[9] = usuario;
				_jacc_parms[10] = codEpigrafe;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 176, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.nuevaCampania(codCamp, nomCamp, codOficicina, codTerritorio, codGestor, anho, mes, orden, get, usuario, codEpigrafe);
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
				container.postInvoke(this, 176, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * nuevaMetaGestor
	 */
	public java.util.Vector nuevaMetaGestor(java.lang.String codMetaGestor, java.lang.String codTerritorio, java.lang.String codOficina, java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codGestor, java.lang.String codigoPerfil, java.lang.String mes, java.lang.Double porc_asig, java.lang.String nom_epigrafe, java.lang.String nom_gestor, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[12];
				_jacc_parms[0] = codMetaGestor;
				_jacc_parms[1] = codTerritorio;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codEpigrafe;
				_jacc_parms[4] = anho;
				_jacc_parms[5] = codGestor;
				_jacc_parms[6] = codigoPerfil;
				_jacc_parms[7] = mes;
				_jacc_parms[8] = porc_asig;
				_jacc_parms[9] = nom_epigrafe;
				_jacc_parms[10] = nom_gestor;
				_jacc_parms[11] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 177, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.nuevaMetaGestor(codMetaGestor, codTerritorio, codOficina, codEpigrafe, anho, codGestor, codigoPerfil, mes, porc_asig, nom_epigrafe, nom_gestor, usuario);
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
				container.postInvoke(this, 177, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * nuevoTerritorio
	 */
	public java.util.Vector nuevoTerritorio(java.lang.String codTerritorio, java.lang.String nomTerritorio, java.lang.String mensaje, java.lang.String colorFondo, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = nomTerritorio;
				_jacc_parms[2] = mensaje;
				_jacc_parms[3] = colorFondo;
				_jacc_parms[4] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 178, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.nuevoTerritorio(codTerritorio, nomTerritorio, mensaje, colorFondo, usuario);
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
				container.postInvoke(this, 178, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * pggEsfuerzoAdicional1
	 */
	public java.util.Vector pggEsfuerzoAdicional1(java.lang.String mes, java.lang.String anho, java.lang.String codOficina, java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 179, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.pggEsfuerzoAdicional1(mes, anho, codOficina, codGestor);
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
				container.postInvoke(this, 179, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * pggEsfuerzoAdicional1
	 */
	public java.util.Vector pggEsfuerzoAdicional1(java.lang.String mes, java.lang.String anho, java.lang.String codOficina, java.lang.String codGestor, com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progSeguimiento) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codGestor;
				_jacc_parms[4] = progSeguimiento;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 180, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.pggEsfuerzoAdicional1(mes, anho, codOficina, codGestor, progSeguimiento);
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
				container.postInvoke(this, 180, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * pggEsfuerzoAdicional2
	 */
	public java.util.Vector pggEsfuerzoAdicional2(java.lang.String mes, java.lang.String anho, java.lang.String codOficina, java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 181, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.pggEsfuerzoAdicional2(mes, anho, codOficina, codGestor);
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
				container.postInvoke(this, 181, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * pggEsfuerzoAdicional2
	 */
	public java.util.Vector pggEsfuerzoAdicional2(java.lang.String mes, java.lang.String anho, java.lang.String codOficina, java.lang.String codGestor, com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progSeguimiento) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codGestor;
				_jacc_parms[4] = progSeguimiento;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 182, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.pggEsfuerzoAdicional2(mes, anho, codOficina, codGestor, progSeguimiento);
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
				container.postInvoke(this, 182, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * pggSeguimiento1
	 */
	public java.util.Vector pggSeguimiento1(java.lang.String mes, java.lang.String anho, java.lang.String codOficina, java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 183, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.pggSeguimiento1(mes, anho, codOficina, codGestor);
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
				container.postInvoke(this, 183, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * pggSeguimiento1
	 */
	public java.util.Vector pggSeguimiento1(java.lang.String mes, java.lang.String anho, java.lang.String codOficina, java.lang.String codGestor, com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progSeguimiento) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codGestor;
				_jacc_parms[4] = progSeguimiento;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 184, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.pggSeguimiento1(mes, anho, codOficina, codGestor, progSeguimiento);
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
				container.postInvoke(this, 184, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * pggSeguimiento2
	 */
	public java.util.Vector pggSeguimiento2(java.lang.String mes, java.lang.String anho, java.lang.String codOficina, java.lang.String codGestor) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codGestor;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 185, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.pggSeguimiento2(mes, anho, codOficina, codGestor);
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
				container.postInvoke(this, 185, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * pggSeguimiento2
	 */
	public java.util.Vector pggSeguimiento2(java.lang.String mes, java.lang.String anho, java.lang.String codOficina, java.lang.String codGestor, com.grupobbva.bc.per.tele.sdo.serializable.ProgSeguimiento progSeguimiento) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = codGestor;
				_jacc_parms[4] = progSeguimiento;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 186, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.pggSeguimiento2(mes, anho, codOficina, codGestor, progSeguimiento);
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
				container.postInvoke(this, 186, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * reportePGO1
	 */
	public java.util.Vector reportePGO1(java.lang.String codAnho, java.lang.String codMes, java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codAnho;
				_jacc_parms[1] = codMes;
				_jacc_parms[2] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 187, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportePGO1(codAnho, codMes, codOficina);
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
				container.postInvoke(this, 187, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * reportePGOEsfuerzos
	 */
	public java.util.Vector reportePGOEsfuerzos(java.lang.String codAnho, java.lang.String codMes, java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codAnho;
				_jacc_parms[1] = codMes;
				_jacc_parms[2] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 188, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportePGOEsfuerzos(codAnho, codMes, codOficina);
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
				container.postInvoke(this, 188, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * reportePGOResumen
	 */
	public java.util.Vector reportePGOResumen(java.lang.String codTerritorio, java.util.Hashtable hash) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = hash;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 189, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportePGOResumen(codTerritorio, hash);
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
				container.postInvoke(this, 189, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * reportePGOResumenxAnioMes
	 */
	public java.util.Vector reportePGOResumenxAnioMes(java.lang.String codTerritorio, java.lang.String mes, java.lang.String anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = mes;
				_jacc_parms[2] = anio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 190, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportePGOResumenxAnioMes(codTerritorio, mes, anio);
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
				container.postInvoke(this, 190, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * reportexOficina
	 */
	public java.util.Vector reportexOficina(int dia, int mes, int anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = new java.lang.Integer(dia);
				_jacc_parms[1] = new java.lang.Integer(mes);
				_jacc_parms[2] = new java.lang.Integer(anio);
				_jacc_parms[3] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 191, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportexOficina(dia, mes, anio, codTerritorio);
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
				container.postInvoke(this, 191, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * reportexOficinaxAnio
	 */
	public java.util.Vector reportexOficinaxAnio(int anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(anio);
				_jacc_parms[1] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 192, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportexOficinaxAnio(anio, codTerritorio);
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
				container.postInvoke(this, 192, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * reportexTerritorio
	 */
	public java.util.Vector reportexTerritorio(int dia, int mes, int anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = new java.lang.Integer(dia);
				_jacc_parms[1] = new java.lang.Integer(mes);
				_jacc_parms[2] = new java.lang.Integer(anio);
				_jacc_parms[3] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 193, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportexTerritorio(dia, mes, anio, codTerritorio);
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
				container.postInvoke(this, 193, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * reportexTerritorioxAnio
	 */
	public java.util.Vector reportexTerritorioxAnio(int anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(anio);
				_jacc_parms[1] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 194, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportexTerritorioxAnio(anio, codTerritorio);
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
				container.postInvoke(this, 194, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * reportexUsuario
	 */
	public java.util.Vector reportexUsuario(int dia, int mes, int anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = new java.lang.Integer(dia);
				_jacc_parms[1] = new java.lang.Integer(mes);
				_jacc_parms[2] = new java.lang.Integer(anio);
				_jacc_parms[3] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 195, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportexUsuario(dia, mes, anio, codTerritorio);
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
				container.postInvoke(this, 195, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * reportexUsuarioxAnio
	 */
	public java.util.Vector reportexUsuarioxAnio(int anio, java.lang.String codTerritorio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = new java.lang.Integer(anio);
				_jacc_parms[1] = codTerritorio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 196, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.reportexUsuarioxAnio(anio, codTerritorio);
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
				container.postInvoke(this, 196, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaAccionesAntiguo
	 */
	public java.util.Vector xBusAllTablaAccionesAntiguo(java.lang.String mes, java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 197, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaAccionesAntiguo(mes, anho);
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
				container.postInvoke(this, 197, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaCampanhasAntiguo
	 */
	public java.util.Vector xBusAllTablaCampanhasAntiguo(java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 198, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaCampanhasAntiguo(anho);
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
				container.postInvoke(this, 198, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaCampanhasDetalleAntiguo
	 */
	public java.util.Vector xBusAllTablaCampanhasDetalleAntiguo() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 199, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaCampanhasDetalleAntiguo();
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
				container.postInvoke(this, 199, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaEpigrafesAntiguo
	 */
	public java.util.Vector xBusAllTablaEpigrafesAntiguo() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 200, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaEpigrafesAntiguo();
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
				container.postInvoke(this, 200, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaEquivalencias
	 */
	public java.util.Vector xBusAllTablaEquivalencias() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 201, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaEquivalencias();
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
				container.postInvoke(this, 201, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaFirmas
	 */
	public java.util.Vector xBusAllTablaFirmas() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 202, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaFirmas();
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
				container.postInvoke(this, 202, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaMaestroPlanes
	 */
	public java.util.Vector xBusAllTablaMaestroPlanes(java.lang.String contadorMes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = contadorMes;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 203, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaMaestroPlanes(contadorMes);
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
				container.postInvoke(this, 203, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaMetasGestor
	 */
	public java.util.Vector xBusAllTablaMetasGestor(java.lang.String contadorMes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = contadorMes;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 204, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaMetasGestor(contadorMes);
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
				container.postInvoke(this, 204, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaOficinaAntiguo
	 */
	public java.util.Vector xBusAllTablaOficinaAntiguo() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 205, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaOficinaAntiguo();
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
				container.postInvoke(this, 205, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaParametros
	 */
	public java.util.Vector xBusAllTablaParametros() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 206, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaParametros();
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
				container.postInvoke(this, 206, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaPerfiles
	 */
	public java.util.Vector xBusAllTablaPerfiles() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 207, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaPerfiles();
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
				container.postInvoke(this, 207, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaPlanes
	 */
	public java.util.Vector xBusAllTablaPlanes(java.lang.String mes, java.lang.String anho) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[2];
				_jacc_parms[0] = mes;
				_jacc_parms[1] = anho;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 208, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaPlanes(mes, anho);
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
				container.postInvoke(this, 208, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * xBusAllTablaTerritorioAntiguo
	 */
	public java.util.Vector xBusAllTablaTerritorioAntiguo() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		java.util.Vector _EJS_result = null;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[0];
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 209, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.xBusAllTablaTerritorioAntiguo();
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
				container.postInvoke(this, 209, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * existeIngresoForm
	 */
	public long existeIngresoForm(int tipo, int mes, int anio, java.lang.String codUsuario, java.lang.String fecha, java.lang.String codGestorM, java.lang.String codOficinaM) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		long _EJS_result = 0;
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[7];
				_jacc_parms[0] = new java.lang.Integer(tipo);
				_jacc_parms[1] = new java.lang.Integer(mes);
				_jacc_parms[2] = new java.lang.Integer(anio);
				_jacc_parms[3] = codUsuario;
				_jacc_parms[4] = fecha;
				_jacc_parms[5] = codGestorM;
				_jacc_parms[6] = codOficinaM;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 210, _EJS_s, _jacc_parms);
			_EJS_result = beanRef.existeIngresoForm(tipo, mes, anio, codUsuario, fecha, codGestorM, codOficinaM);
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
				container.postInvoke(this, 210, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * actualizarCargoGestoresLDAP
	 */
	public void actualizarCargoGestoresLDAP(java.util.Vector listaGestoresLDAP, java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = listaGestoresLDAP;
				_jacc_parms[1] = codEpigrafe;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codOficina;
				_jacc_parms[4] = mes;
				_jacc_parms[5] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 211, _EJS_s, _jacc_parms);
			beanRef.actualizarCargoGestoresLDAP(listaGestoresLDAP, codEpigrafe, anho, codOficina, mes, usuario);
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
				container.postInvoke(this, 211, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * actualizarGestoresDistribuidosLDAP
	 */
	public void actualizarGestoresDistribuidosLDAP(java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[5];
				_jacc_parms[0] = codEpigrafe;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 212, _EJS_s, _jacc_parms);
			beanRef.actualizarGestoresDistribuidosLDAP(codEpigrafe, anho, codOficina, mes, usuario);
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
				container.postInvoke(this, 212, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * actualizarGestoresEliminadosLDAP
	 */
	public void actualizarGestoresEliminadosLDAP(java.util.Vector listaGestoresLDAP, java.lang.String codEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = listaGestoresLDAP;
				_jacc_parms[1] = codEpigrafe;
				_jacc_parms[2] = anho;
				_jacc_parms[3] = codOficina;
				_jacc_parms[4] = mes;
				_jacc_parms[5] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 213, _EJS_s, _jacc_parms);
			beanRef.actualizarGestoresEliminadosLDAP(listaGestoresLDAP, codEpigrafe, anho, codOficina, mes, usuario);
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
				container.postInvoke(this, 213, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * actualizarIngreso
	 */
	public void actualizarIngreso(int tipo, int idIngreso, java.lang.String mes, java.lang.String anio) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[4];
				_jacc_parms[0] = new java.lang.Integer(tipo);
				_jacc_parms[1] = new java.lang.Integer(idIngreso);
				_jacc_parms[2] = mes;
				_jacc_parms[3] = anio;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 214, _EJS_s, _jacc_parms);
			beanRef.actualizarIngreso(tipo, idIngreso, mes, anio);
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
				container.postInvoke(this, 214, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * actualizarIngresoFormEditUsuario
	 */
	public void actualizarIngresoFormEditUsuario(long id) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = new java.lang.Long(id);
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 215, _EJS_s, _jacc_parms);
			beanRef.actualizarIngresoFormEditUsuario(id);
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
				container.postInvoke(this, 215, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * actualizarMetaGestoresPlanes
	 */
	public void actualizarMetaGestoresPlanes(java.util.Vector listaEpigrafe, java.lang.String anho, java.lang.String codOficina, java.lang.String mes, java.lang.String codGestorGOF, java.lang.String usuario) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[6];
				_jacc_parms[0] = listaEpigrafe;
				_jacc_parms[1] = anho;
				_jacc_parms[2] = codOficina;
				_jacc_parms[3] = mes;
				_jacc_parms[4] = codGestorGOF;
				_jacc_parms[5] = usuario;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 216, _EJS_s, _jacc_parms);
			beanRef.actualizarMetaGestoresPlanes(listaEpigrafe, anho, codOficina, mes, codGestorGOF, usuario);
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
				container.postInvoke(this, 216, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * editarMensajeTerritorio
	 */
	public void editarMensajeTerritorio(java.lang.String codTerritorio, java.lang.String mensaje, java.lang.String colorFondo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[3];
				_jacc_parms[0] = codTerritorio;
				_jacc_parms[1] = mensaje;
				_jacc_parms[2] = colorFondo;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 217, _EJS_s, _jacc_parms);
			beanRef.editarMensajeTerritorio(codTerritorio, mensaje, colorFondo);
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
				container.postInvoke(this, 217, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * eliminarMetaGestoresHijas
	 */
	public void eliminarMetaGestoresHijas(java.util.Vector listaGestores) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[1];
				_jacc_parms[0] = listaGestores;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 218, _EJS_s, _jacc_parms);
			beanRef.eliminarMetaGestoresHijas(listaGestores);
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
				container.postInvoke(this, 218, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * insertarIngresoForm
	 */
	public void insertarIngresoForm(int tipo, int mes, int anio, java.lang.String codUsuario, java.lang.String editUsuario, java.lang.String codGestor, java.lang.String codOficina) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		Object[] _jacc_parms = null;
		
		try {
			if (container.doesJaccNeedsEJBArguments( this ))
			{
				_jacc_parms = new Object[7];
				_jacc_parms[0] = new java.lang.Integer(tipo);
				_jacc_parms[1] = new java.lang.Integer(mes);
				_jacc_parms[2] = new java.lang.Integer(anio);
				_jacc_parms[3] = codUsuario;
				_jacc_parms[4] = editUsuario;
				_jacc_parms[5] = codGestor;
				_jacc_parms[6] = codOficina;
			}
	com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesionws.SesionWSBean)container.preInvoke(this, 219, _EJS_s, _jacc_parms);
			beanRef.insertarIngresoForm(tipo, mes, anio, codUsuario, editUsuario, codGestor, codOficina);
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
				container.postInvoke(this, 219, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
