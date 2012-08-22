package com.grupobbva.bc.per.tele.sdo.sesion;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessSesionAcciones_2d2ae4af
 */
public class EJSRemoteStatelessSesionAcciones_2d2ae4af extends EJSWrapper implements SesionAcciones {
	/**
	 * EJSRemoteStatelessSesionAcciones_2d2ae4af
	 */
	public EJSRemoteStatelessSesionAcciones_2d2ae4af() throws java.rmi.RemoteException {
		super();	}
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 0, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 0, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 1, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 1, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 2, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 2, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 3, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 3, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 4, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 4, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 5, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 5, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 6, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 6, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 7, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 7, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 8, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 8, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 9, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 9, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 10, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 10, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 11, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 11, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 12, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 12, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 13, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 13, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 14, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 14, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 15, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 15, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 16, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 16, _EJS_s);
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
	com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean beanRef = (com.grupobbva.bc.per.tele.sdo.sesion.SesionAccionesBean)container.preInvoke(this, 17, _EJS_s, _jacc_parms);
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
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
