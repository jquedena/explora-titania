package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * Tiilc_permiso_perfilBeanFunctionSet_993509dc
 */
public class Tiilc_permiso_perfilBeanFunctionSet_993509dc extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO IILC.TIILC_PERMISO_PERFIL (COD_PERFIL, TIPO_ACCESO, VALOR_RCP) VALUES (?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column TIPO_ACCESO
			// For column TIPO_ACCESO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(1);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(2,tempBigDecimal);
				else
					pstmt.setNull(2,java.sql.Types.NUMERIC);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			if (executeUpdate(connection, pstmt, CreateQuery_0)==0)
				throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	private static String RemoveQuery_0 = "DELETE FROM IILC.TIILC_PERMISO_PERFIL  WHERE COD_PERFIL = ? AND TIPO_ACCESO = ? AND VALOR_RCP = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column TIPO_ACCESO
			// For column TIPO_ACCESO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(1);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(2,tempBigDecimal);
				else
					pstmt.setNull(2,java.sql.Types.NUMERIC);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			if (executeUpdate(connection, pstmt, RemoveQuery_0)==0)
				throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		
	}
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		
	}
	private static String findPermisoPerfilQuery_0 = " select  q1.\"COD_PERFIL\",  q1.\"TIPO_ACCESO\",  q1.\"VALOR_RCP\" from IILC.TIILC_PERMISO_PERFIL q1 where  ( q1.\"COD_PERFIL\" = ?)  and  ( q1.\"TIPO_ACCESO\" = ?)  and  ( q1.\"VALOR_RCP\" = ?) ";
	/**
	 * FindPermisoPerfil
	 */
	public javax.resource.cci.Record FindPermisoPerfil(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_permiso_perfil o where  o.cod_perfil = ?1 and  o.tipo_acceso = ?2 and  o.valor_rcp = ?3 */
			pstmt = prepareStatement(connection, findPermisoPerfilQuery_0);

			// For ?1 (cod_perfil)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (tipo_acceso)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (valor_rcp)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findPermisoPerfilQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findPermisoPerfilForUpdateQuery_0 = " select  q1.\"COD_PERFIL\",  q1.\"TIPO_ACCESO\",  q1.\"VALOR_RCP\" from IILC.TIILC_PERMISO_PERFIL q1 where  ( q1.\"COD_PERFIL\" = ?)  and  ( q1.\"TIPO_ACCESO\" = ?)  and  ( q1.\"VALOR_RCP\" = ?)  for update ";
	/**
	 * FindPermisoPerfil444Update
	 */
	public javax.resource.cci.Record FindPermisoPerfil444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_permiso_perfil o where  o.cod_perfil = ?1 and  o.tipo_acceso = ?2 and  o.valor_rcp = ?3 */
			pstmt = prepareStatement(connection, findPermisoPerfilForUpdateQuery_0);

			// For ?1 (cod_perfil)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (tipo_acceso)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (valor_rcp)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findPermisoPerfilForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.COD_PERFIL, T1.TIPO_ACCESO, T1.VALOR_RCP FROM IILC.TIILC_PERMISO_PERFIL  T1 WHERE T1.COD_PERFIL = ? AND T1.TIPO_ACCESO = ? AND T1.VALOR_RCP = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column TIPO_ACCESO
			// For column TIPO_ACCESO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(1);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(2,tempBigDecimal);
				else
					pstmt.setNull(2,java.sql.Types.NUMERIC);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, FindByPrimaryKeyQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.COD_PERFIL, T1.TIPO_ACCESO, T1.VALOR_RCP FROM IILC.TIILC_PERMISO_PERFIL  T1 WHERE T1.COD_PERFIL = ? AND T1.TIPO_ACCESO = ? AND T1.VALOR_RCP = ? FOR UPDATE ";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column TIPO_ACCESO
			// For column TIPO_ACCESO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(1);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(2,tempBigDecimal);
				else
					pstmt.setNull(2,java.sql.Types.NUMERIC);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, FindByPrimaryKeyForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findAllPermisoPerfilQuery_0 = " select  q1.\"COD_PERFIL\",  q1.\"TIPO_ACCESO\",  q1.\"VALOR_RCP\" from IILC.TIILC_PERMISO_PERFIL q1 order by  q1.\"COD_PERFIL\" asc,  q1.\"TIPO_ACCESO\" asc,  q1.\"VALOR_RCP\" asc";
	/**
	 * FindAllPermisoPerfil
	 */
	public javax.resource.cci.Record FindAllPermisoPerfil(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_permiso_perfil o ORDER BY o.cod_perfil ASC, o.tipo_acceso ASC, o.valor_rcp ASC */
			pstmt = prepareStatement(connection, findAllPermisoPerfilQuery_0);

			result = executeQuery(connection, pstmt, findAllPermisoPerfilQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findAllPermisoPerfilForUpdateQuery_0 = " select  q1.\"COD_PERFIL\",  q1.\"TIPO_ACCESO\",  q1.\"VALOR_RCP\" from IILC.TIILC_PERMISO_PERFIL q1 order by  q1.\"COD_PERFIL\" asc,  q1.\"TIPO_ACCESO\" asc,  q1.\"VALOR_RCP\" asc for update ";
	/**
	 * FindAllPermisoPerfil444Update
	 */
	public javax.resource.cci.Record FindAllPermisoPerfil444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_permiso_perfil o ORDER BY o.cod_perfil ASC, o.tipo_acceso ASC, o.valor_rcp ASC */
			pstmt = prepareStatement(connection, findAllPermisoPerfilForUpdateQuery_0);

			result = executeQuery(connection, pstmt, findAllPermisoPerfilForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findPermisoPerfilxTipAccxValorRCPQuery_0 = " select  q1.\"COD_PERFIL\",  q1.\"TIPO_ACCESO\",  q1.\"VALOR_RCP\" from IILC.TIILC_PERMISO_PERFIL q1 where  ( q1.\"TIPO_ACCESO\" = ?)  and  ( q1.\"VALOR_RCP\" = ?) ";
	/**
	 * FindPermisoPerfilxTipAccxValorRCP
	 */
	public javax.resource.cci.Record FindPermisoPerfilxTipAccxValorRCP(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_permiso_perfil o where o.tipo_acceso = ?1 and o.valor_rcp=?2 */
			pstmt = prepareStatement(connection, findPermisoPerfilxTipAccxValorRCPQuery_0);

			// For ?1 (tipo_acceso)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (valor_rcp)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findPermisoPerfilxTipAccxValorRCPQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findPermisoPerfilxTipAccxValorRCPForUpdateQuery_0 = " select  q1.\"COD_PERFIL\",  q1.\"TIPO_ACCESO\",  q1.\"VALOR_RCP\" from IILC.TIILC_PERMISO_PERFIL q1 where  ( q1.\"TIPO_ACCESO\" = ?)  and  ( q1.\"VALOR_RCP\" = ?)  for update ";
	/**
	 * FindPermisoPerfilxTipAccxValorRCP444Update
	 */
	public javax.resource.cci.Record FindPermisoPerfilxTipAccxValorRCP444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_permiso_perfil o where o.tipo_acceso = ?1 and o.valor_rcp=?2 */
			pstmt = prepareStatement(connection, findPermisoPerfilxTipAccxValorRCPForUpdateQuery_0);

			// For ?1 (tipo_acceso)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (valor_rcp)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findPermisoPerfilxTipAccxValorRCPForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	/**
	 * Tiilc_permiso_perfilBeanFunctionSet_993509dc
	 */
	public Tiilc_permiso_perfilBeanFunctionSet_993509dc() {
		functionHash=new java.util.HashMap(16);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindPermisoPerfil",new Integer(4));
		functionHash.put("FindPermisoPerfil444Update",new Integer(5));
		functionHash.put("FindByPrimaryKey",new Integer(6));
		functionHash.put("FindByPrimaryKey444Update",new Integer(7));
		functionHash.put("FindAllPermisoPerfil",new Integer(8));
		functionHash.put("FindAllPermisoPerfil444Update",new Integer(9));
		functionHash.put("FindPermisoPerfilxTipAccxValorRCP",new Integer(10));
		functionHash.put("FindPermisoPerfilxTipAccxValorRCP444Update",new Integer(11));
		functionHash.put("ReadReadChecking",new Integer(12));
		functionHash.put("ReadReadCheckingForUpdate",new Integer(13));
		functionHash.put("PartialStore",new Integer(14));
		functionHash.put("PartialStoreUsingOCC",new Integer(15));
	}
	/**
	 * execute
	 */
	public Record execute(WSInteractionSpec interactionSpec, IndexedRecord inputRecord, Object connection) throws javax.resource.ResourceException {
		String functionName=interactionSpec.getFunctionName();
		Record outputRecord=null;
		int functionIndex=((Integer)functionHash.get(functionName)).intValue();

		switch (functionIndex) {
		case 0:
			Create(inputRecord,connection,interactionSpec);
			break;
		case 1:
			Remove(inputRecord,connection,interactionSpec);
			break;
		case 2:
			Store(inputRecord,connection,interactionSpec);
			break;
		case 3:
			StoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		case 4:
			outputRecord=FindPermisoPerfil(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindPermisoPerfil444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindAllPermisoPerfil(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindAllPermisoPerfil444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindPermisoPerfilxTipAccxValorRCP(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindPermisoPerfilxTipAccxValorRCP444Update(inputRecord,connection,interactionSpec);
			break;
		case 12:
			ReadReadChecking(inputRecord,connection,interactionSpec);
			break;
		case 13:
			ReadReadCheckingForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 14:
			PartialStore(inputRecord,connection,interactionSpec);
			break;
		case 15:
			PartialStoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
	private static String ReadReadQuery_0 = " SELECT 1 FROM IILC.TIILC_PERMISO_PERFIL  T1 WHERE T1.COD_PERFIL = ? AND T1.TIPO_ACCESO = ? AND T1.VALOR_RCP = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column TIPO_ACCESO
			// For column TIPO_ACCESO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(1);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(2,tempBigDecimal);
				else
					pstmt.setNull(2,java.sql.Types.NUMERIC);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			executeQuery(connection, pstmt, ReadReadQuery_0);

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM IILC.TIILC_PERMISO_PERFIL  T1 WHERE T1.COD_PERFIL = ? AND T1.TIPO_ACCESO = ? AND T1.VALOR_RCP = ? FOR UPDATE ";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column TIPO_ACCESO
			// For column TIPO_ACCESO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(1);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(2,tempBigDecimal);
				else
					pstmt.setNull(2,java.sql.Types.NUMERIC);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			executeQuery(connection, pstmt, ReadReadForUpdateQuery_0);

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	/**
	 * initializeUpdateTemplates
	 */
	private void initializeUpdateTemplates() throws javax.resource.ResourceException {
		updateTemplateList = Tiilc_permiso_perfilBeanPartialUpdateQueryHelper.getUpdateTemplates();
	}
	private java.util.List updateTemplateList = null;
	/**
	 * PartialStore
	 */
	public void PartialStore(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		
	}
	/**
	 * PartialStoreUsingOCC
	 */
	public void PartialStoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		
	}
}
