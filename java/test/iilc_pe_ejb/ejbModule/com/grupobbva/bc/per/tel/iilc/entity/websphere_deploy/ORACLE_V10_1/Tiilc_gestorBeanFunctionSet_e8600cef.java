package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * Tiilc_gestorBeanFunctionSet_e8600cef
 */
public class Tiilc_gestorBeanFunctionSet_e8600cef extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO IILC.TIILC_GESTOR (COD_GESTOR, COD_AREA, COD_TERRITORIO, COD_OFICINA, NOM_GESTOR, REG_GESTOR, PERFIL_GESTOR) VALUES (?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column NOM_GESTOR
			// For column NOM_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column REG_GESTOR
			// For column REG_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column PERFIL_GESTOR
			// For column PERFIL_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
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
	private static String RemoveQuery_0 = "DELETE FROM IILC.TIILC_GESTOR  WHERE COD_GESTOR = ? AND COD_AREA = ? AND COD_TERRITORIO = ? AND COD_OFICINA = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
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
	private static String StoreQuery_0 = "UPDATE IILC.TIILC_GESTOR  SET NOM_GESTOR = ?, REG_GESTOR = ?, PERFIL_GESTOR = ? WHERE COD_GESTOR = ? AND COD_AREA = ? AND COD_TERRITORIO = ? AND COD_OFICINA = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column NOM_GESTOR
			// For column NOM_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column REG_GESTOR
			// For column REG_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column PERFIL_GESTOR
			// For column PERFIL_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			if (executeUpdate(connection, pstmt, StoreQuery_0)==0)
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
	private static String StoreOCCQuery_0 = "UPDATE IILC.TIILC_GESTOR  SET NOM_GESTOR = ?, REG_GESTOR = ?, PERFIL_GESTOR = ? WHERE COD_GESTOR = ? AND COD_AREA = ? AND COD_TERRITORIO = ? AND COD_OFICINA = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column NOM_GESTOR
			// For column NOM_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column REG_GESTOR
			// For column REG_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column PERFIL_GESTOR
			// For column PERFIL_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			if (executeUpdate(connection, pstmt, StoreOCCQuery_0)==0)
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
	private static String findAllGestorxOfxTexArQuery_0 = " select  q1.\"COD_GESTOR\",  q1.\"NOM_GESTOR\",  q1.\"REG_GESTOR\",  q1.\"PERFIL_GESTOR\",  q1.\"COD_AREA\",  q1.\"COD_TERRITORIO\",  q1.\"COD_OFICINA\" from IILC.TIILC_GESTOR q1 inner join IILC.TIILC_OFICINA q2 on ( ( q2.\"COD_AREA\" =  q1.\"COD_AREA\")  AND  ( q2.\"COD_TERRITORIO\" =  q1.\"COD_TERRITORIO\")  AND  ( q2.\"COD_OFICINA\" =  q1.\"COD_OFICINA\") ) inner join IILC.TIILC_TERRITORIO q3 on ( ( q3.\"COD_AREA\" =  q2.\"COD_AREA\")  AND  ( q3.\"COD_TERRITORIO\" =  q2.\"COD_TERRITORIO\") ) where  ( q3.\"COD_TERRITORIO\" = ?)  and  ( q2.\"COD_OFICINA\" = ?)  order by  q1.\"NOM_GESTOR\" asc";
	/**
	 * FindAllGestorxOfxTexAr
	 */
	public javax.resource.cci.Record FindAllGestorxOfxTexAr(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_gestor o where  o.tiilc_oficina_fk.tiilc_territorio_fk.cod_territorio = ?2 and  o.tiilc_oficina_fk.cod_oficina = ?1 ORDER BY o.nom_gestor */
			pstmt = prepareStatement(connection, findAllGestorxOfxTexArQuery_0);

			// For ?2 (cod_territorio)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (cod_oficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllGestorxOfxTexArQuery_0);

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
	private static String findAllGestorxOfxTexArForUpdateQuery_0 = " select  q1.\"COD_GESTOR\",  q1.\"NOM_GESTOR\",  q1.\"REG_GESTOR\",  q1.\"PERFIL_GESTOR\",  q1.\"COD_AREA\",  q1.\"COD_TERRITORIO\",  q1.\"COD_OFICINA\" from IILC.TIILC_GESTOR q1 inner join IILC.TIILC_OFICINA q2 on ( ( q2.\"COD_AREA\" =  q1.\"COD_AREA\")  AND  ( q2.\"COD_TERRITORIO\" =  q1.\"COD_TERRITORIO\")  AND  ( q2.\"COD_OFICINA\" =  q1.\"COD_OFICINA\") ) inner join IILC.TIILC_TERRITORIO q3 on ( ( q3.\"COD_AREA\" =  q2.\"COD_AREA\")  AND  ( q3.\"COD_TERRITORIO\" =  q2.\"COD_TERRITORIO\") ) where  ( q3.\"COD_TERRITORIO\" = ?)  and  ( q2.\"COD_OFICINA\" = ?)  order by  q1.\"NOM_GESTOR\" asc for update ";
	/**
	 * FindAllGestorxOfxTexAr444Update
	 */
	public javax.resource.cci.Record FindAllGestorxOfxTexAr444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_gestor o where  o.tiilc_oficina_fk.tiilc_territorio_fk.cod_territorio = ?2 and  o.tiilc_oficina_fk.cod_oficina = ?1 ORDER BY o.nom_gestor */
			pstmt = prepareStatement(connection, findAllGestorxOfxTexArForUpdateQuery_0);

			// For ?2 (cod_territorio)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (cod_oficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllGestorxOfxTexArForUpdateQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.COD_GESTOR, T1.NOM_GESTOR, T1.REG_GESTOR, T1.PERFIL_GESTOR, T1.COD_AREA, T1.COD_TERRITORIO, T1.COD_OFICINA FROM IILC.TIILC_GESTOR  T1 WHERE T1.COD_GESTOR = ? AND T1.COD_AREA = ? AND T1.COD_TERRITORIO = ? AND T1.COD_OFICINA = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.COD_GESTOR, T1.NOM_GESTOR, T1.REG_GESTOR, T1.PERFIL_GESTOR, T1.COD_AREA, T1.COD_TERRITORIO, T1.COD_OFICINA FROM IILC.TIILC_GESTOR  T1 WHERE T1.COD_GESTOR = ? AND T1.COD_AREA = ? AND T1.COD_TERRITORIO = ? AND T1.COD_OFICINA = ? FOR UPDATE ";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
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
	private static String findGestorxRegGestorQuery_0 = " select  q1.\"COD_GESTOR\",  q1.\"NOM_GESTOR\",  q1.\"REG_GESTOR\",  q1.\"PERFIL_GESTOR\",  q1.\"COD_AREA\",  q1.\"COD_TERRITORIO\",  q1.\"COD_OFICINA\" from IILC.TIILC_GESTOR q1 where  ( q1.\"REG_GESTOR\" = ?) ";
	/**
	 * FindGestorxRegGestor
	 */
	public javax.resource.cci.Record FindGestorxRegGestor(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_gestor o where o.reg_gestor = ?1 */
			pstmt = prepareStatement(connection, findGestorxRegGestorQuery_0);

			// For ?1 (reg_gestor)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findGestorxRegGestorQuery_0);

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
	private static String findGestorxRegGestorForUpdateQuery_0 = " select  q1.\"COD_GESTOR\",  q1.\"NOM_GESTOR\",  q1.\"REG_GESTOR\",  q1.\"PERFIL_GESTOR\",  q1.\"COD_AREA\",  q1.\"COD_TERRITORIO\",  q1.\"COD_OFICINA\" from IILC.TIILC_GESTOR q1 where  ( q1.\"REG_GESTOR\" = ?)  for update ";
	/**
	 * FindGestorxRegGestor444Update
	 */
	public javax.resource.cci.Record FindGestorxRegGestor444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_gestor o where o.reg_gestor = ?1 */
			pstmt = prepareStatement(connection, findGestorxRegGestorForUpdateQuery_0);

			// For ?1 (reg_gestor)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findGestorxRegGestorForUpdateQuery_0);

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
	private static String findAllGestorQuery_0 = " select  q1.\"COD_GESTOR\",  q1.\"NOM_GESTOR\",  q1.\"REG_GESTOR\",  q1.\"PERFIL_GESTOR\",  q1.\"COD_AREA\",  q1.\"COD_TERRITORIO\",  q1.\"COD_OFICINA\" from IILC.TIILC_GESTOR q1 inner join IILC.TIILC_OFICINA q2 on ( ( q2.\"COD_AREA\" =  q1.\"COD_AREA\")  AND  ( q2.\"COD_TERRITORIO\" =  q1.\"COD_TERRITORIO\")  AND  ( q2.\"COD_OFICINA\" =  q1.\"COD_OFICINA\") ) inner join IILC.TIILC_TERRITORIO q3 on ( ( q3.\"COD_AREA\" =  q2.\"COD_AREA\")  AND  ( q3.\"COD_TERRITORIO\" =  q2.\"COD_TERRITORIO\") ) inner join IILC.TIILC_AREA q4 on  ( q4.\"COD_AREA\" =  q3.\"COD_AREA\")  where  ( q4.\"COD_AREA\" = ?) ";
	/**
	 * FindAllGestor
	 */
	public javax.resource.cci.Record FindAllGestor(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_gestor o where o.tiilc_oficina_fk.tiilc_territorio_fk.tiilc_area_fk.cod_area = ?1 */
			pstmt = prepareStatement(connection, findAllGestorQuery_0);

			// For ?1 (cod_area)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllGestorQuery_0);

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
	private static String findAllGestorForUpdateQuery_0 = " select  q1.\"COD_GESTOR\",  q1.\"NOM_GESTOR\",  q1.\"REG_GESTOR\",  q1.\"PERFIL_GESTOR\",  q1.\"COD_AREA\",  q1.\"COD_TERRITORIO\",  q1.\"COD_OFICINA\" from IILC.TIILC_GESTOR q1 inner join IILC.TIILC_OFICINA q2 on ( ( q2.\"COD_AREA\" =  q1.\"COD_AREA\")  AND  ( q2.\"COD_TERRITORIO\" =  q1.\"COD_TERRITORIO\")  AND  ( q2.\"COD_OFICINA\" =  q1.\"COD_OFICINA\") ) inner join IILC.TIILC_TERRITORIO q3 on ( ( q3.\"COD_AREA\" =  q2.\"COD_AREA\")  AND  ( q3.\"COD_TERRITORIO\" =  q2.\"COD_TERRITORIO\") ) inner join IILC.TIILC_AREA q4 on  ( q4.\"COD_AREA\" =  q3.\"COD_AREA\")  where  ( q4.\"COD_AREA\" = ?)  for update ";
	/**
	 * FindAllGestor444Update
	 */
	public javax.resource.cci.Record FindAllGestor444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_gestor o where o.tiilc_oficina_fk.tiilc_territorio_fk.tiilc_area_fk.cod_area = ?1 */
			pstmt = prepareStatement(connection, findAllGestorForUpdateQuery_0);

			// For ?1 (cod_area)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllGestorForUpdateQuery_0);

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
	private static String findTiilc_gestorByTiilc_oficina_fkKey_LocalQuery_0 = " SELECT T1.COD_GESTOR, T1.NOM_GESTOR, T1.REG_GESTOR, T1.PERFIL_GESTOR, T1.COD_AREA, T1.COD_TERRITORIO, T1.COD_OFICINA FROM IILC.TIILC_GESTOR  T1 WHERE T1.COD_AREA = ? AND T1.COD_TERRITORIO = ? AND T1.COD_OFICINA = ?";
	/**
	 * findTiilc_gestorByTiilc_oficina_fkKey_Local
	 */
	public javax.resource.cci.Record findTiilc_gestorByTiilc_oficina_fkKey_Local(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiilc_gestorByTiilc_oficina_fkKey_LocalQuery_0);

			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findTiilc_gestorByTiilc_oficina_fkKey_LocalQuery_0);

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
	private static String findTiilc_gestorByTiilc_oficina_fkKey_LocalForUpdateQuery_0 = " SELECT T1.COD_GESTOR, T1.NOM_GESTOR, T1.REG_GESTOR, T1.PERFIL_GESTOR, T1.COD_AREA, T1.COD_TERRITORIO, T1.COD_OFICINA FROM IILC.TIILC_GESTOR  T1 WHERE T1.COD_AREA = ? AND T1.COD_TERRITORIO = ? AND T1.COD_OFICINA = ? FOR UPDATE ";
	/**
	 * findTiilc_gestorByTiilc_oficina_fkKey_Local444Update
	 */
	public javax.resource.cci.Record findTiilc_gestorByTiilc_oficina_fkKey_Local444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiilc_gestorByTiilc_oficina_fkKey_LocalForUpdateQuery_0);

			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findTiilc_gestorByTiilc_oficina_fkKey_LocalForUpdateQuery_0);

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
	 * Tiilc_gestorBeanFunctionSet_e8600cef
	 */
	public Tiilc_gestorBeanFunctionSet_e8600cef() {
		functionHash=new java.util.HashMap(18);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindAllGestorxOfxTexAr",new Integer(4));
		functionHash.put("FindAllGestorxOfxTexAr444Update",new Integer(5));
		functionHash.put("FindByPrimaryKey",new Integer(6));
		functionHash.put("FindByPrimaryKey444Update",new Integer(7));
		functionHash.put("FindGestorxRegGestor",new Integer(8));
		functionHash.put("FindGestorxRegGestor444Update",new Integer(9));
		functionHash.put("FindAllGestor",new Integer(10));
		functionHash.put("FindAllGestor444Update",new Integer(11));
		functionHash.put("findTiilc_gestorByTiilc_oficina_fkKey_Local",new Integer(12));
		functionHash.put("findTiilc_gestorByTiilc_oficina_fkKey_Local444Update",new Integer(13));
		functionHash.put("ReadReadChecking",new Integer(14));
		functionHash.put("ReadReadCheckingForUpdate",new Integer(15));
		functionHash.put("PartialStore",new Integer(16));
		functionHash.put("PartialStoreUsingOCC",new Integer(17));
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
			outputRecord=FindAllGestorxOfxTexAr(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindAllGestorxOfxTexAr444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindGestorxRegGestor(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindGestorxRegGestor444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindAllGestor(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindAllGestor444Update(inputRecord,connection,interactionSpec);
			break;
		case 12:
			outputRecord=findTiilc_gestorByTiilc_oficina_fkKey_Local(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=findTiilc_gestorByTiilc_oficina_fkKey_Local444Update(inputRecord,connection,interactionSpec);
			break;
		case 14:
			ReadReadChecking(inputRecord,connection,interactionSpec);
			break;
		case 15:
			ReadReadCheckingForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 16:
			PartialStore(inputRecord,connection,interactionSpec);
			break;
		case 17:
			PartialStoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
	private static String ReadReadQuery_0 = " SELECT 1 FROM IILC.TIILC_GESTOR  T1 WHERE T1.COD_GESTOR = ? AND T1.COD_AREA = ? AND T1.COD_TERRITORIO = ? AND T1.COD_OFICINA = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM IILC.TIILC_GESTOR  T1 WHERE T1.COD_GESTOR = ? AND T1.COD_AREA = ? AND T1.COD_TERRITORIO = ? AND T1.COD_OFICINA = ? FOR UPDATE ";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
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
		updateTemplateList = Tiilc_gestorBeanPartialUpdateQueryHelper.getUpdateTemplates();
	}
	private java.util.List updateTemplateList = null;
	/**
	 * PartialStore
	 */
	public void PartialStore(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			boolean[] changedFieldIndexes = interactionSpec.getChangedFieldsIndexes();
			if (updateTemplateList == null)
				initializeUpdateTemplates();
			{
				com.ibm.ws.ejbdeploy.Jiilc_pe_ejb.ORACLE_V10_1.RdbRuntimeUpdateTemplate aTemplate = (com.ibm.ws.ejbdeploy.Jiilc_pe_ejb.ORACLE_V10_1.RdbRuntimeUpdateTemplate) updateTemplateList.get(0);
				String updateQuery = aTemplate.nativeQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[1])
					{
						// For column NOM_GESTOR
						String tempString;


						tempString=(String)inputRecord.get(1);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[2])
					{
						// For column REG_GESTOR
						String tempString;


						tempString=(String)inputRecord.get(2);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[3])
					{
						// For column PERFIL_GESTOR
						String tempString;


						tempString=(String)inputRecord.get(3);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_GESTOR
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_OFICINA
						String tempString;


						tempString=(String)inputRecord.get(4);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERRITORIO
						String tempString;


						tempString=(String)inputRecord.get(5);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_AREA
						String tempString;


						tempString=(String)inputRecord.get(6);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					if (executeUpdate(connection, pstmt, updateQuery)==0)
						throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

				}
			}
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
	 * PartialStoreUsingOCC
	 */
	public void PartialStoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			boolean[] changedFieldIndexes = interactionSpec.getChangedFieldsIndexes();
			if (updateTemplateList == null)
				initializeUpdateTemplates();
			{
				com.ibm.ws.ejbdeploy.Jiilc_pe_ejb.ORACLE_V10_1.RdbRuntimeUpdateTemplate aTemplate = (com.ibm.ws.ejbdeploy.Jiilc_pe_ejb.ORACLE_V10_1.RdbRuntimeUpdateTemplate) updateTemplateList.get(0);
				String updateQuery = aTemplate.nativeQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[1])
					{
						// For column NOM_GESTOR
						String tempString;


						tempString=(String)inputRecord.get(1);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[2])
					{
						// For column REG_GESTOR
						String tempString;


						tempString=(String)inputRecord.get(2);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[3])
					{
						// For column PERFIL_GESTOR
						String tempString;


						tempString=(String)inputRecord.get(3);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_GESTOR
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_OFICINA
						String tempString;


						tempString=(String)inputRecord.get(4);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERRITORIO
						String tempString;


						tempString=(String)inputRecord.get(5);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_AREA
						String tempString;


						tempString=(String)inputRecord.get(6);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					if (executeUpdate(connection, pstmt, updateQuery)==0)
						throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

				}
			}
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
}
