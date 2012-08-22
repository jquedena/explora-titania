package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * Tiido_epigrafeBeanFunctionSet_b2c8f8ed
 */
public class Tiido_epigrafeBeanFunctionSet_b2c8f8ed extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO IIDO.TIIDO_EPIGRAFE (COD_EPIGRAFE, ANHO, NOM_EPIGRAFE, IND_CLASE, IND_SUB_CLASE, ORDEN, IND_GRUPO, ABREVIATURA, IND_HIJO, IND_AFECTA, PORCENTAJE_MAX, PORCENTAJE_MIN) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column NOM_EPIGRAFE
			// For column NOM_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column IND_CLASE
			// For column IND_CLASE
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column IND_SUB_CLASE
			// For column IND_SUB_CLASE
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column ORDEN
			// For column ORDEN
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column IND_GRUPO
			// For column IND_GRUPO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column ABREVIATURA
			// For column ABREVIATURA
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column IND_HIJO
			// For column IND_HIJO
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.VARCHAR);
			}
			// For column IND_AFECTA
			// For column IND_AFECTA
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.VARCHAR);
			}
			// For column PORCENTAJE_MAX
			// For column PORCENTAJE_MAX
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(11,tempBigDecimal);
				else
					pstmt.setNull(11,java.sql.Types.NUMERIC);
			}
			// For column PORCENTAJE_MIN
			// For column PORCENTAJE_MIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(12,tempBigDecimal);
				else
					pstmt.setNull(12,java.sql.Types.NUMERIC);
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
	private static String RemoveQuery_0 = "DELETE FROM IIDO.TIIDO_EPIGRAFE  WHERE COD_EPIGRAFE = ? AND ANHO = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
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
	private static String StoreQuery_0 = "UPDATE IIDO.TIIDO_EPIGRAFE  SET NOM_EPIGRAFE = ?, IND_CLASE = ?, IND_SUB_CLASE = ?, ORDEN = ?, IND_GRUPO = ?, ABREVIATURA = ?, IND_HIJO = ?, IND_AFECTA = ?, PORCENTAJE_MAX = ?, PORCENTAJE_MIN = ? WHERE COD_EPIGRAFE = ? AND ANHO = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column NOM_EPIGRAFE
			// For column NOM_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column IND_CLASE
			// For column IND_CLASE
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column IND_SUB_CLASE
			// For column IND_SUB_CLASE
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column ORDEN
			// For column ORDEN
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column IND_GRUPO
			// For column IND_GRUPO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column ABREVIATURA
			// For column ABREVIATURA
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column IND_HIJO
			// For column IND_HIJO
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column IND_AFECTA
			// For column IND_AFECTA
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column PORCENTAJE_MAX
			// For column PORCENTAJE_MAX
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(9,tempBigDecimal);
				else
					pstmt.setNull(9,java.sql.Types.NUMERIC);
			}
			// For column PORCENTAJE_MIN
			// For column PORCENTAJE_MIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(10,tempBigDecimal);
				else
					pstmt.setNull(10,java.sql.Types.NUMERIC);
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
	private static String StoreOCCQuery_0 = "UPDATE IIDO.TIIDO_EPIGRAFE  SET NOM_EPIGRAFE = ?, IND_CLASE = ?, IND_SUB_CLASE = ?, ORDEN = ?, IND_GRUPO = ?, ABREVIATURA = ?, IND_HIJO = ?, IND_AFECTA = ?, PORCENTAJE_MAX = ?, PORCENTAJE_MIN = ? WHERE COD_EPIGRAFE = ? AND ANHO = ? AND PORCENTAJE_MAX = ? AND PORCENTAJE_MIN = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column NOM_EPIGRAFE
			// For column NOM_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column IND_CLASE
			// For column IND_CLASE
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column IND_SUB_CLASE
			// For column IND_SUB_CLASE
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column ORDEN
			// For column ORDEN
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column IND_GRUPO
			// For column IND_GRUPO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column ABREVIATURA
			// For column ABREVIATURA
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column IND_HIJO
			// For column IND_HIJO
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column IND_AFECTA
			// For column IND_AFECTA
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column PORCENTAJE_MAX
			// For column PORCENTAJE_MAX
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(9,tempBigDecimal);
				else
					pstmt.setNull(9,java.sql.Types.NUMERIC);
			}
			// For column PORCENTAJE_MIN
			// For column PORCENTAJE_MIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(10,tempBigDecimal);
				else
					pstmt.setNull(10,java.sql.Types.NUMERIC);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column PORCENTAJE_MAX
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)oldRecord.get(10);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(13,tempBigDecimal);
				else
					pstmt.setNull(13,java.sql.Types.NUMERIC);
			}
			// For column PORCENTAJE_MIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)oldRecord.get(11);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(14,tempBigDecimal);
				else
					pstmt.setNull(14,java.sql.Types.NUMERIC);
			}
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
	private static String findByCodEpigAnhoQuery_0 = " select  q1.\"COD_EPIGRAFE\",  q1.\"ANHO\",  q1.\"NOM_EPIGRAFE\",  q1.\"IND_CLASE\",  q1.\"IND_SUB_CLASE\",  q1.\"ORDEN\",  q1.\"IND_GRUPO\",  q1.\"ABREVIATURA\",  q1.\"IND_HIJO\",  q1.\"IND_AFECTA\",  q1.\"PORCENTAJE_MAX\",  q1.\"PORCENTAJE_MIN\" from IIDO.TIIDO_EPIGRAFE q1 where  ( q1.\"COD_EPIGRAFE\" = ?)  and  ( q1.\"ANHO\" = ?) ";
	/**
	 * FindByCodEpigAnho
	 */
	public javax.resource.cci.Record FindByCodEpigAnho(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_epigrafe o where  o.cod_epigrafe = ?1 and  o.anho = ?2 */
			pstmt = prepareStatement(connection, findByCodEpigAnhoQuery_0);

			// For ?1 (codEpigrafe)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (anho)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCodEpigAnhoQuery_0);

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
	private static String findByCodEpigAnhoForUpdateQuery_0 = " select  q1.\"COD_EPIGRAFE\",  q1.\"ANHO\",  q1.\"NOM_EPIGRAFE\",  q1.\"IND_CLASE\",  q1.\"IND_SUB_CLASE\",  q1.\"ORDEN\",  q1.\"IND_GRUPO\",  q1.\"ABREVIATURA\",  q1.\"IND_HIJO\",  q1.\"IND_AFECTA\",  q1.\"PORCENTAJE_MAX\",  q1.\"PORCENTAJE_MIN\" from IIDO.TIIDO_EPIGRAFE q1 where  ( q1.\"COD_EPIGRAFE\" = ?)  and  ( q1.\"ANHO\" = ?)  for update ";
	/**
	 * FindByCodEpigAnho444Update
	 */
	public javax.resource.cci.Record FindByCodEpigAnho444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_epigrafe o where  o.cod_epigrafe = ?1 and  o.anho = ?2 */
			pstmt = prepareStatement(connection, findByCodEpigAnhoForUpdateQuery_0);

			// For ?1 (codEpigrafe)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (anho)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCodEpigAnhoForUpdateQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.COD_EPIGRAFE, T1.ANHO, T1.NOM_EPIGRAFE, T1.IND_CLASE, T1.IND_SUB_CLASE, T1.ORDEN, T1.IND_GRUPO, T1.ABREVIATURA, T1.IND_HIJO, T1.IND_AFECTA, T1.PORCENTAJE_MAX, T1.PORCENTAJE_MIN FROM IIDO.TIIDO_EPIGRAFE  T1 WHERE T1.COD_EPIGRAFE = ? AND T1.ANHO = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.COD_EPIGRAFE, T1.ANHO, T1.NOM_EPIGRAFE, T1.IND_CLASE, T1.IND_SUB_CLASE, T1.ORDEN, T1.IND_GRUPO, T1.ABREVIATURA, T1.IND_HIJO, T1.IND_AFECTA, T1.PORCENTAJE_MAX, T1.PORCENTAJE_MIN FROM IIDO.TIIDO_EPIGRAFE  T1 WHERE T1.COD_EPIGRAFE = ? AND T1.ANHO = ? FOR UPDATE ";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
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
	private static String findEpiByAnhoQuery_0 = " select  q1.\"COD_EPIGRAFE\",  q1.\"ANHO\",  q1.\"NOM_EPIGRAFE\",  q1.\"IND_CLASE\",  q1.\"IND_SUB_CLASE\",  q1.\"ORDEN\",  q1.\"IND_GRUPO\",  q1.\"ABREVIATURA\",  q1.\"IND_HIJO\",  q1.\"IND_AFECTA\",  q1.\"PORCENTAJE_MAX\",  q1.\"PORCENTAJE_MIN\" from IIDO.TIIDO_EPIGRAFE q1 where  ( q1.\"ANHO\" = ?) ";
	/**
	 * FindEpiByAnho
	 */
	public javax.resource.cci.Record FindEpiByAnho(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_epigrafe o where o.anho = ?1 */
			pstmt = prepareStatement(connection, findEpiByAnhoQuery_0);

			// For ?1 (anho)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findEpiByAnhoQuery_0);

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
	private static String findEpiByAnhoForUpdateQuery_0 = " select  q1.\"COD_EPIGRAFE\",  q1.\"ANHO\",  q1.\"NOM_EPIGRAFE\",  q1.\"IND_CLASE\",  q1.\"IND_SUB_CLASE\",  q1.\"ORDEN\",  q1.\"IND_GRUPO\",  q1.\"ABREVIATURA\",  q1.\"IND_HIJO\",  q1.\"IND_AFECTA\",  q1.\"PORCENTAJE_MAX\",  q1.\"PORCENTAJE_MIN\" from IIDO.TIIDO_EPIGRAFE q1 where  ( q1.\"ANHO\" = ?)  for update ";
	/**
	 * FindEpiByAnho444Update
	 */
	public javax.resource.cci.Record FindEpiByAnho444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_epigrafe o where o.anho = ?1 */
			pstmt = prepareStatement(connection, findEpiByAnhoForUpdateQuery_0);

			// For ?1 (anho)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findEpiByAnhoForUpdateQuery_0);

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
	private static String findByCodEpigQuery_0 = " select  q1.\"COD_EPIGRAFE\",  q1.\"ANHO\",  q1.\"NOM_EPIGRAFE\",  q1.\"IND_CLASE\",  q1.\"IND_SUB_CLASE\",  q1.\"ORDEN\",  q1.\"IND_GRUPO\",  q1.\"ABREVIATURA\",  q1.\"IND_HIJO\",  q1.\"IND_AFECTA\",  q1.\"PORCENTAJE_MAX\",  q1.\"PORCENTAJE_MIN\" from IIDO.TIIDO_EPIGRAFE q1 where  ( q1.\"COD_EPIGRAFE\" = ?) ";
	/**
	 * FindByCodEpig
	 */
	public javax.resource.cci.Record FindByCodEpig(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_epigrafe o where  o.cod_epigrafe = ?1 */
			pstmt = prepareStatement(connection, findByCodEpigQuery_0);

			// For ?1 (codEpigrafe)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCodEpigQuery_0);

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
	private static String findByCodEpigForUpdateQuery_0 = " select  q1.\"COD_EPIGRAFE\",  q1.\"ANHO\",  q1.\"NOM_EPIGRAFE\",  q1.\"IND_CLASE\",  q1.\"IND_SUB_CLASE\",  q1.\"ORDEN\",  q1.\"IND_GRUPO\",  q1.\"ABREVIATURA\",  q1.\"IND_HIJO\",  q1.\"IND_AFECTA\",  q1.\"PORCENTAJE_MAX\",  q1.\"PORCENTAJE_MIN\" from IIDO.TIIDO_EPIGRAFE q1 where  ( q1.\"COD_EPIGRAFE\" = ?)  for update ";
	/**
	 * FindByCodEpig444Update
	 */
	public javax.resource.cci.Record FindByCodEpig444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_epigrafe o where  o.cod_epigrafe = ?1 */
			pstmt = prepareStatement(connection, findByCodEpigForUpdateQuery_0);

			// For ?1 (codEpigrafe)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCodEpigForUpdateQuery_0);

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
	 * Tiido_epigrafeBeanFunctionSet_b2c8f8ed
	 */
	public Tiido_epigrafeBeanFunctionSet_b2c8f8ed() {
		functionHash=new java.util.HashMap(16);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByCodEpigAnho",new Integer(4));
		functionHash.put("FindByCodEpigAnho444Update",new Integer(5));
		functionHash.put("FindByPrimaryKey",new Integer(6));
		functionHash.put("FindByPrimaryKey444Update",new Integer(7));
		functionHash.put("FindEpiByAnho",new Integer(8));
		functionHash.put("FindEpiByAnho444Update",new Integer(9));
		functionHash.put("FindByCodEpig",new Integer(10));
		functionHash.put("FindByCodEpig444Update",new Integer(11));
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
			outputRecord=FindByCodEpigAnho(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindByCodEpigAnho444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindEpiByAnho(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindEpiByAnho444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindByCodEpig(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindByCodEpig444Update(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM IIDO.TIIDO_EPIGRAFE  T1 WHERE T1.COD_EPIGRAFE = ? AND T1.ANHO = ? AND T1.PORCENTAJE_MAX = ? AND T1.PORCENTAJE_MIN = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column PORCENTAJE_MAX
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(2);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(3,tempBigDecimal);
				else
					pstmt.setNull(3,java.sql.Types.NUMERIC);
			}
			// For column PORCENTAJE_MIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(3);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(4,tempBigDecimal);
				else
					pstmt.setNull(4,java.sql.Types.NUMERIC);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM IIDO.TIIDO_EPIGRAFE  T1 WHERE T1.COD_EPIGRAFE = ? AND T1.ANHO = ? AND T1.PORCENTAJE_MAX = ? AND T1.PORCENTAJE_MIN = ? FOR UPDATE ";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column PORCENTAJE_MAX
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(2);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(3,tempBigDecimal);
				else
					pstmt.setNull(3,java.sql.Types.NUMERIC);
			}
			// For column PORCENTAJE_MIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(3);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(4,tempBigDecimal);
				else
					pstmt.setNull(4,java.sql.Types.NUMERIC);
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
		updateTemplateList = Tiido_epigrafeBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
				com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate aTemplate = (com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate) updateTemplateList.get(0);
				String updateQuery = aTemplate.nativeQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[2])
					{
						// For column NOM_EPIGRAFE
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
						// For column IND_CLASE
						String tempString;


						tempString=(String)inputRecord.get(3);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column IND_SUB_CLASE
						String tempString;


						tempString=(String)inputRecord.get(4);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column ORDEN
						String tempString;


						tempString=(String)inputRecord.get(5);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column IND_GRUPO
						String tempString;


						tempString=(String)inputRecord.get(6);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column ABREVIATURA
						String tempString;


						tempString=(String)inputRecord.get(7);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column IND_HIJO
						String tempString;


						tempString=(String)inputRecord.get(8);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column IND_AFECTA
						String tempString;


						tempString=(String)inputRecord.get(9);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column PORCENTAJE_MAX
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column PORCENTAJE_MIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_EPIGRAFE
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column ANHO
						String tempString;


						tempString=(String)inputRecord.get(1);
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
				com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate aTemplate = (com.ibm.ws.ejbdeploy.JSistemaSDOEJB.ORACLE_V10_1.RdbRuntimeUpdateTemplate) updateTemplateList.get(0);
				IndexedRecord oldRecord = interactionSpec.getOldRecord();
				Object[] oldValues = new Object[2];
				oldValues[0] = oldRecord.get(10);
				oldValues[1] = oldRecord.get(11);
				String updateQuery = aTemplate.nativeOptimisticQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[2])
					{
						// For column NOM_EPIGRAFE
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
						// For column IND_CLASE
						String tempString;


						tempString=(String)inputRecord.get(3);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column IND_SUB_CLASE
						String tempString;


						tempString=(String)inputRecord.get(4);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column ORDEN
						String tempString;


						tempString=(String)inputRecord.get(5);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column IND_GRUPO
						String tempString;


						tempString=(String)inputRecord.get(6);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column ABREVIATURA
						String tempString;


						tempString=(String)inputRecord.get(7);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column IND_HIJO
						String tempString;


						tempString=(String)inputRecord.get(8);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column IND_AFECTA
						String tempString;


						tempString=(String)inputRecord.get(9);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column PORCENTAJE_MAX
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column PORCENTAJE_MIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_EPIGRAFE
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column ANHO
						String tempString;


						tempString=(String)inputRecord.get(1);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					// optimistic predicate columns
					{
						// For column PORCENTAJE_MAX
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)oldValues[0];
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
							stmtIndex++;
						}

					}
					{
						// For column PORCENTAJE_MIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)oldValues[1];
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
							stmtIndex++;
						}

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
