package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * Tiido_campaniasBeanFunctionSet_97b3883c
 */
public class Tiido_campaniasBeanFunctionSet_97b3883c extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO IIDO.TIIDO_CAMPANIAS (COD_CAMP, ANHO, MES, COD_TERR, COD_OFIC, NOM_CAMP, COD_GEST, ORDEN, GTE, FEC_REGI, USU_REGI, FEC_ACTU, USU_ACTU) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.DECIMAL);
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
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column NOM_CAMP
			// For column NOM_CAMP
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column COD_GEST
			// For column COD_GEST
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column ORDEN
			// For column ORDEN
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column GTE
			// For column GTE
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setDate(10,tempDate);
				else
					pstmt.setNull(10,java.sql.Types.DATE);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(9);
				if(tempDate != null)
					pstmt.setDate(12,tempDate);
				else
					pstmt.setNull(12,java.sql.Types.DATE);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.CHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
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
	private static String RemoveQuery_0 = "DELETE FROM IIDO.TIIDO_CAMPANIAS  WHERE COD_CAMP = ? AND ANHO = ? AND MES = ? AND COD_TERR = ? AND COD_OFIC = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.DECIMAL);
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
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
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
	private static String StoreQuery_0 = "UPDATE IIDO.TIIDO_CAMPANIAS  SET NOM_CAMP = ?, COD_GEST = ?, ORDEN = ?, GTE = ?, FEC_REGI = ?, USU_REGI = ?, FEC_ACTU = ?, USU_ACTU = ? WHERE COD_CAMP = ? AND ANHO = ? AND MES = ? AND COD_TERR = ? AND COD_OFIC = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.VARCHAR);
			}
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column NOM_CAMP
			// For column NOM_CAMP
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_GEST
			// For column COD_GEST
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ORDEN
			// For column ORDEN
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column GTE
			// For column GTE
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setDate(5,tempDate);
				else
					pstmt.setNull(5,java.sql.Types.DATE);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(9);
				if(tempDate != null)
					pstmt.setDate(7,tempDate);
				else
					pstmt.setNull(7,java.sql.Types.DATE);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
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
	private static String StoreOCCQuery_0 = "UPDATE IIDO.TIIDO_CAMPANIAS  SET NOM_CAMP = ?, COD_GEST = ?, ORDEN = ?, GTE = ?, FEC_REGI = ?, USU_REGI = ?, FEC_ACTU = ?, USU_ACTU = ? WHERE COD_CAMP = ? AND ANHO = ? AND MES = ? AND COD_TERR = ? AND COD_OFIC = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.VARCHAR);
			}
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column NOM_CAMP
			// For column NOM_CAMP
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_GEST
			// For column COD_GEST
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ORDEN
			// For column ORDEN
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column GTE
			// For column GTE
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setDate(5,tempDate);
				else
					pstmt.setNull(5,java.sql.Types.DATE);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(9);
				if(tempDate != null)
					pstmt.setDate(7,tempDate);
				else
					pstmt.setNull(7,java.sql.Types.DATE);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.COD_CAMP, T1.ANHO, T1.MES, T1.NOM_CAMP, T1.COD_GEST, T1.ORDEN, T1.GTE, T1.FEC_REGI, T1.USU_REGI, T1.FEC_ACTU, T1.USU_ACTU, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_CAMPANIAS  T1 WHERE T1.COD_CAMP = ? AND T1.ANHO = ? AND T1.MES = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.DECIMAL);
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
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.COD_CAMP, T1.ANHO, T1.MES, T1.NOM_CAMP, T1.COD_GEST, T1.ORDEN, T1.GTE, T1.FEC_REGI, T1.USU_REGI, T1.FEC_ACTU, T1.USU_ACTU, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_CAMPANIAS  T1 WHERE T1.COD_CAMP = ? AND T1.ANHO = ? AND T1.MES = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ? FOR UPDATE ";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.DECIMAL);
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
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
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
	private static String findTiido_campaniasByTiido_cam_oficina_fkKey_LocalQuery_0 = " SELECT T1.COD_CAMP, T1.ANHO, T1.MES, T1.NOM_CAMP, T1.COD_GEST, T1.ORDEN, T1.GTE, T1.FEC_REGI, T1.USU_REGI, T1.FEC_ACTU, T1.USU_ACTU, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_CAMPANIAS  T1 WHERE T1.COD_TERR = ? AND T1.COD_OFIC = ?";
	/**
	 * findTiido_campaniasByTiido_cam_oficina_fkKey_Local
	 */
	public javax.resource.cci.Record findTiido_campaniasByTiido_cam_oficina_fkKey_Local(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_campaniasByTiido_cam_oficina_fkKey_LocalQuery_0);

			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findTiido_campaniasByTiido_cam_oficina_fkKey_LocalQuery_0);

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
	private static String findTiido_campaniasByTiido_cam_oficina_fkKey_LocalForUpdateQuery_0 = " SELECT T1.COD_CAMP, T1.ANHO, T1.MES, T1.NOM_CAMP, T1.COD_GEST, T1.ORDEN, T1.GTE, T1.FEC_REGI, T1.USU_REGI, T1.FEC_ACTU, T1.USU_ACTU, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_CAMPANIAS  T1 WHERE T1.COD_TERR = ? AND T1.COD_OFIC = ? FOR UPDATE ";
	/**
	 * findTiido_campaniasByTiido_cam_oficina_fkKey_Local444Update
	 */
	public javax.resource.cci.Record findTiido_campaniasByTiido_cam_oficina_fkKey_Local444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_campaniasByTiido_cam_oficina_fkKey_LocalForUpdateQuery_0);

			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findTiido_campaniasByTiido_cam_oficina_fkKey_LocalForUpdateQuery_0);

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
	 * Tiido_campaniasBeanFunctionSet_97b3883c
	 */
	public Tiido_campaniasBeanFunctionSet_97b3883c() {
		functionHash=new java.util.HashMap(12);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByPrimaryKey",new Integer(4));
		functionHash.put("FindByPrimaryKey444Update",new Integer(5));
		functionHash.put("findTiido_campaniasByTiido_cam_oficina_fkKey_Local",new Integer(6));
		functionHash.put("findTiido_campaniasByTiido_cam_oficina_fkKey_Local444Update",new Integer(7));
		functionHash.put("ReadReadChecking",new Integer(8));
		functionHash.put("ReadReadCheckingForUpdate",new Integer(9));
		functionHash.put("PartialStore",new Integer(10));
		functionHash.put("PartialStoreUsingOCC",new Integer(11));
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
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=findTiido_campaniasByTiido_cam_oficina_fkKey_Local(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=findTiido_campaniasByTiido_cam_oficina_fkKey_Local444Update(inputRecord,connection,interactionSpec);
			break;
		case 8:
			ReadReadChecking(inputRecord,connection,interactionSpec);
			break;
		case 9:
			ReadReadCheckingForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 10:
			PartialStore(inputRecord,connection,interactionSpec);
			break;
		case 11:
			PartialStoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
	private static String ReadReadQuery_0 = " SELECT 1 FROM IIDO.TIIDO_CAMPANIAS  T1 WHERE T1.COD_CAMP = ? AND T1.ANHO = ? AND T1.MES = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.DECIMAL);
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
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM IIDO.TIIDO_CAMPANIAS  T1 WHERE T1.COD_CAMP = ? AND T1.ANHO = ? AND T1.MES = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ? FOR UPDATE ";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.DECIMAL);
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
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
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
		updateTemplateList = Tiido_campaniasBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
					if (changedFieldIndexes[3])
					{
						// For column NOM_CAMP
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
						// For column COD_GEST
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
						// For column GTE
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
						// For column FEC_REGI
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(7);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column USU_REGI
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
						// For column FEC_ACTU
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(9);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column USU_ACTU
						String tempString;


						tempString=(String)inputRecord.get(10);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_CAMP
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column ANHO
						String tempString;


						tempString=(String)inputRecord.get(1);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column MES
						String tempString;


						tempString=(String)inputRecord.get(2);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_OFIC
						String tempString;


						tempString=(String)inputRecord.get(11);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERR
						String tempString;


						tempString=(String)inputRecord.get(12);
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
				String updateQuery = aTemplate.nativeQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[3])
					{
						// For column NOM_CAMP
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
						// For column COD_GEST
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
						// For column GTE
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
						// For column FEC_REGI
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(7);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column USU_REGI
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
						// For column FEC_ACTU
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(9);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column USU_ACTU
						String tempString;


						tempString=(String)inputRecord.get(10);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_CAMP
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column ANHO
						String tempString;


						tempString=(String)inputRecord.get(1);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column MES
						String tempString;


						tempString=(String)inputRecord.get(2);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_OFIC
						String tempString;


						tempString=(String)inputRecord.get(11);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERR
						String tempString;


						tempString=(String)inputRecord.get(12);
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
