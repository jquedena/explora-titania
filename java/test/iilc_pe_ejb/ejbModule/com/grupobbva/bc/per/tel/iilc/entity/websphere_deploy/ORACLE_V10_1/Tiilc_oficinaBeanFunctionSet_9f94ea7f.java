package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * Tiilc_oficinaBeanFunctionSet_9f94ea7f
 */
public class Tiilc_oficinaBeanFunctionSet_9f94ea7f extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO IILC.TIILC_OFICINA (COD_OFICINA, COD_AREA, COD_TERRITORIO, DES_OFICINA) VALUES (?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column DES_OFICINA
			// For column DES_OFICINA
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
	private static String RemoveQuery_0 = "DELETE FROM IILC.TIILC_OFICINA  WHERE COD_OFICINA = ? AND COD_AREA = ? AND COD_TERRITORIO = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
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
	private static String StoreQuery_0 = "UPDATE IILC.TIILC_OFICINA  SET DES_OFICINA = ? WHERE COD_OFICINA = ? AND COD_AREA = ? AND COD_TERRITORIO = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column DES_OFICINA
			// For column DES_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
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
	private static String StoreOCCQuery_0 = "UPDATE IILC.TIILC_OFICINA  SET DES_OFICINA = ? WHERE COD_OFICINA = ? AND COD_AREA = ? AND COD_TERRITORIO = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column DES_OFICINA
			// For column DES_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
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
	private static String findAllOficinaxTerQuery_0 = " select  q1.\"COD_OFICINA\",  q1.\"DES_OFICINA\",  q1.\"COD_AREA\",  q1.\"COD_TERRITORIO\" from IILC.TIILC_OFICINA q1 inner join IILC.TIILC_TERRITORIO q2 on ( ( q2.\"COD_AREA\" =  q1.\"COD_AREA\")  AND  ( q2.\"COD_TERRITORIO\" =  q1.\"COD_TERRITORIO\") ) where  ( q2.\"COD_TERRITORIO\" = ?)  order by  q1.\"DES_OFICINA\" asc";
	/**
	 * FindAllOficinaxTer
	 */
	public javax.resource.cci.Record FindAllOficinaxTer(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_oficina o where o.tiilc_territorio_fk.cod_territorio = ?1 ORDER BY o.des_oficina */
			pstmt = prepareStatement(connection, findAllOficinaxTerQuery_0);

			// For ?1 (cod_territorio)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllOficinaxTerQuery_0);

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
	private static String findAllOficinaxTerForUpdateQuery_0 = " select  q1.\"COD_OFICINA\",  q1.\"DES_OFICINA\",  q1.\"COD_AREA\",  q1.\"COD_TERRITORIO\" from IILC.TIILC_OFICINA q1 inner join IILC.TIILC_TERRITORIO q2 on ( ( q2.\"COD_AREA\" =  q1.\"COD_AREA\")  AND  ( q2.\"COD_TERRITORIO\" =  q1.\"COD_TERRITORIO\") ) where  ( q2.\"COD_TERRITORIO\" = ?)  order by  q1.\"DES_OFICINA\" asc for update ";
	/**
	 * FindAllOficinaxTer444Update
	 */
	public javax.resource.cci.Record FindAllOficinaxTer444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_oficina o where o.tiilc_territorio_fk.cod_territorio = ?1 ORDER BY o.des_oficina */
			pstmt = prepareStatement(connection, findAllOficinaxTerForUpdateQuery_0);

			// For ?1 (cod_territorio)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllOficinaxTerForUpdateQuery_0);

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
	private static String findAllOficinaxCod_oficinaQuery_0 = " select  q1.\"COD_OFICINA\",  q1.\"DES_OFICINA\",  q1.\"COD_AREA\",  q1.\"COD_TERRITORIO\" from IILC.TIILC_OFICINA q1 where  ( q1.\"COD_OFICINA\" = ?) ";
	/**
	 * FindAllOficinaxCod_oficina
	 */
	public javax.resource.cci.Record FindAllOficinaxCod_oficina(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_oficina o where  o.cod_oficina = ?1 */
			pstmt = prepareStatement(connection, findAllOficinaxCod_oficinaQuery_0);

			// For ?1 (cod_oficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllOficinaxCod_oficinaQuery_0);

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
	private static String findAllOficinaxCod_oficinaForUpdateQuery_0 = " select  q1.\"COD_OFICINA\",  q1.\"DES_OFICINA\",  q1.\"COD_AREA\",  q1.\"COD_TERRITORIO\" from IILC.TIILC_OFICINA q1 where  ( q1.\"COD_OFICINA\" = ?)  for update ";
	/**
	 * FindAllOficinaxCod_oficina444Update
	 */
	public javax.resource.cci.Record FindAllOficinaxCod_oficina444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_oficina o where  o.cod_oficina = ?1 */
			pstmt = prepareStatement(connection, findAllOficinaxCod_oficinaForUpdateQuery_0);

			// For ?1 (cod_oficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllOficinaxCod_oficinaForUpdateQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.COD_OFICINA, T1.DES_OFICINA, T1.COD_AREA, T1.COD_TERRITORIO FROM IILC.TIILC_OFICINA  T1 WHERE T1.COD_OFICINA = ? AND T1.COD_AREA = ? AND T1.COD_TERRITORIO = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.COD_OFICINA, T1.DES_OFICINA, T1.COD_AREA, T1.COD_TERRITORIO FROM IILC.TIILC_OFICINA  T1 WHERE T1.COD_OFICINA = ? AND T1.COD_AREA = ? AND T1.COD_TERRITORIO = ? FOR UPDATE ";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
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
	private static String findTiilc_oficinaByTiilc_territorio_fkKey_LocalQuery_0 = " SELECT T1.COD_OFICINA, T1.DES_OFICINA, T1.COD_AREA, T1.COD_TERRITORIO FROM IILC.TIILC_OFICINA  T1 WHERE T1.COD_AREA = ? AND T1.COD_TERRITORIO = ?";
	/**
	 * findTiilc_oficinaByTiilc_territorio_fkKey_Local
	 */
	public javax.resource.cci.Record findTiilc_oficinaByTiilc_territorio_fkKey_Local(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiilc_oficinaByTiilc_territorio_fkKey_LocalQuery_0);

			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findTiilc_oficinaByTiilc_territorio_fkKey_LocalQuery_0);

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
	private static String findTiilc_oficinaByTiilc_territorio_fkKey_LocalForUpdateQuery_0 = " SELECT T1.COD_OFICINA, T1.DES_OFICINA, T1.COD_AREA, T1.COD_TERRITORIO FROM IILC.TIILC_OFICINA  T1 WHERE T1.COD_AREA = ? AND T1.COD_TERRITORIO = ? FOR UPDATE ";
	/**
	 * findTiilc_oficinaByTiilc_territorio_fkKey_Local444Update
	 */
	public javax.resource.cci.Record findTiilc_oficinaByTiilc_territorio_fkKey_Local444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiilc_oficinaByTiilc_territorio_fkKey_LocalForUpdateQuery_0);

			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findTiilc_oficinaByTiilc_territorio_fkKey_LocalForUpdateQuery_0);

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
	 * Tiilc_oficinaBeanFunctionSet_9f94ea7f
	 */
	public Tiilc_oficinaBeanFunctionSet_9f94ea7f() {
		functionHash=new java.util.HashMap(16);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindAllOficinaxTer",new Integer(4));
		functionHash.put("FindAllOficinaxTer444Update",new Integer(5));
		functionHash.put("FindAllOficinaxCod_oficina",new Integer(6));
		functionHash.put("FindAllOficinaxCod_oficina444Update",new Integer(7));
		functionHash.put("FindByPrimaryKey",new Integer(8));
		functionHash.put("FindByPrimaryKey444Update",new Integer(9));
		functionHash.put("findTiilc_oficinaByTiilc_territorio_fkKey_Local",new Integer(10));
		functionHash.put("findTiilc_oficinaByTiilc_territorio_fkKey_Local444Update",new Integer(11));
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
			outputRecord=FindAllOficinaxTer(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindAllOficinaxTer444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindAllOficinaxCod_oficina(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindAllOficinaxCod_oficina444Update(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=findTiilc_oficinaByTiilc_territorio_fkKey_Local(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=findTiilc_oficinaByTiilc_territorio_fkKey_Local444Update(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM IILC.TIILC_OFICINA  T1 WHERE T1.COD_OFICINA = ? AND T1.COD_AREA = ? AND T1.COD_TERRITORIO = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM IILC.TIILC_OFICINA  T1 WHERE T1.COD_OFICINA = ? AND T1.COD_AREA = ? AND T1.COD_TERRITORIO = ? FOR UPDATE ";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_AREA
			// For column COD_AREA
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
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
		updateTemplateList = Tiilc_oficinaBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column DES_OFICINA
						String tempString;


						tempString=(String)inputRecord.get(1);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_OFICINA
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERRITORIO
						String tempString;


						tempString=(String)inputRecord.get(2);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_AREA
						String tempString;


						tempString=(String)inputRecord.get(3);
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
						// For column DES_OFICINA
						String tempString;


						tempString=(String)inputRecord.get(1);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_OFICINA
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERRITORIO
						String tempString;


						tempString=(String)inputRecord.get(2);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_AREA
						String tempString;


						tempString=(String)inputRecord.get(3);
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
