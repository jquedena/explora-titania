package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * Tiido_firmasBeanFunctionSet_7cbca68a
 */
public class Tiido_firmasBeanFunctionSet_7cbca68a extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO IIDO.TIIDO_FIRMAS (COD_FIRMA, COD_TERR, COD_OFIC, ANHO_FIRM, MES_FIRM, ITEM_FIRM, COD_GESTOR, DESCRIPCION, FEC_FIRM) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column COD_FIRMA
			// For column COD_FIRMA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ANHO_FIRM
			// For column ANHO_FIRM
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column MES_FIRM
			// For column MES_FIRM
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column ITEM_FIRM
			// For column ITEM_FIRM
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column DESCRIPCION
			// For column DESCRIPCION
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column FEC_FIRM
			// For column FEC_FIRM
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(6);
				if(tempDate != null)
					pstmt.setDate(9,tempDate);
				else
					pstmt.setNull(9,java.sql.Types.DATE);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
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
	private static String RemoveQuery_0 = "DELETE FROM IIDO.TIIDO_FIRMAS  WHERE COD_FIRMA = ? AND COD_TERR = ? AND COD_OFIC = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column COD_FIRMA
			// For column COD_FIRMA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
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
	private static String StoreQuery_0 = "UPDATE IIDO.TIIDO_FIRMAS  SET ANHO_FIRM = ?, MES_FIRM = ?, ITEM_FIRM = ?, COD_GESTOR = ?, DESCRIPCION = ?, FEC_FIRM = ? WHERE COD_FIRMA = ? AND COD_TERR = ? AND COD_OFIC = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column COD_FIRMA
			// For column COD_FIRMA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column ANHO_FIRM
			// For column ANHO_FIRM
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column MES_FIRM
			// For column MES_FIRM
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ITEM_FIRM
			// For column ITEM_FIRM
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column DESCRIPCION
			// For column DESCRIPCION
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column FEC_FIRM
			// For column FEC_FIRM
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(6);
				if(tempDate != null)
					pstmt.setDate(6,tempDate);
				else
					pstmt.setNull(6,java.sql.Types.DATE);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
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
	private static String StoreOCCQuery_0 = "UPDATE IIDO.TIIDO_FIRMAS  SET ANHO_FIRM = ?, MES_FIRM = ?, ITEM_FIRM = ?, COD_GESTOR = ?, DESCRIPCION = ?, FEC_FIRM = ? WHERE COD_FIRMA = ? AND COD_TERR = ? AND COD_OFIC = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column COD_FIRMA
			// For column COD_FIRMA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column ANHO_FIRM
			// For column ANHO_FIRM
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column MES_FIRM
			// For column MES_FIRM
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ITEM_FIRM
			// For column ITEM_FIRM
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column DESCRIPCION
			// For column DESCRIPCION
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column FEC_FIRM
			// For column FEC_FIRM
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(6);
				if(tempDate != null)
					pstmt.setDate(6,tempDate);
				else
					pstmt.setNull(6,java.sql.Types.DATE);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
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
	private static String findFirmByAnoMesCgesItemQuery_0 = " select  q1.\"COD_FIRMA\",  q1.\"ANHO_FIRM\",  q1.\"MES_FIRM\",  q1.\"ITEM_FIRM\",  q1.\"COD_GESTOR\",  q1.\"DESCRIPCION\",  q1.\"FEC_FIRM\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_FIRMAS q1 where  ( q1.\"ANHO_FIRM\" = ?)  and  ( q1.\"MES_FIRM\" = ?)  and  ( q1.\"COD_GESTOR\" = ?)  and  ( q1.\"ITEM_FIRM\" = ?) ";
	/**
	 * FindFirmByAnoMesCgesItem
	 */
	public javax.resource.cci.Record FindFirmByAnoMesCgesItem(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_firmas o where o.anho_firm = ?1 and o.mes_firm = ?2 and o.cod_gestor = ?3 and o.item_firm = ?4 */
			pstmt = prepareStatement(connection, findFirmByAnoMesCgesItemQuery_0);

			// For ?1 (anho)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (mes)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (codGestor)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (item)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findFirmByAnoMesCgesItemQuery_0);

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
	private static String findFirmByAnoMesCgesItemForUpdateQuery_0 = " select  q1.\"COD_FIRMA\",  q1.\"ANHO_FIRM\",  q1.\"MES_FIRM\",  q1.\"ITEM_FIRM\",  q1.\"COD_GESTOR\",  q1.\"DESCRIPCION\",  q1.\"FEC_FIRM\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_FIRMAS q1 where  ( q1.\"ANHO_FIRM\" = ?)  and  ( q1.\"MES_FIRM\" = ?)  and  ( q1.\"COD_GESTOR\" = ?)  and  ( q1.\"ITEM_FIRM\" = ?)  for update ";
	/**
	 * FindFirmByAnoMesCgesItem444Update
	 */
	public javax.resource.cci.Record FindFirmByAnoMesCgesItem444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_firmas o where o.anho_firm = ?1 and o.mes_firm = ?2 and o.cod_gestor = ?3 and o.item_firm = ?4 */
			pstmt = prepareStatement(connection, findFirmByAnoMesCgesItemForUpdateQuery_0);

			// For ?1 (anho)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (mes)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (codGestor)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (item)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findFirmByAnoMesCgesItemForUpdateQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.COD_FIRMA, T1.ANHO_FIRM, T1.MES_FIRM, T1.ITEM_FIRM, T1.COD_GESTOR, T1.DESCRIPCION, T1.FEC_FIRM, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_FIRMAS  T1 WHERE T1.COD_FIRMA = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column COD_FIRMA
			// For column COD_FIRMA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.COD_FIRMA, T1.ANHO_FIRM, T1.MES_FIRM, T1.ITEM_FIRM, T1.COD_GESTOR, T1.DESCRIPCION, T1.FEC_FIRM, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_FIRMAS  T1 WHERE T1.COD_FIRMA = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ? FOR UPDATE ";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column COD_FIRMA
			// For column COD_FIRMA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
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
	private static String findTiido_firmasByTiido_fir_oficina_fkKey_LocalQuery_0 = " SELECT T1.COD_FIRMA, T1.ANHO_FIRM, T1.MES_FIRM, T1.ITEM_FIRM, T1.COD_GESTOR, T1.DESCRIPCION, T1.FEC_FIRM, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_FIRMAS  T1 WHERE T1.COD_TERR = ? AND T1.COD_OFIC = ?";
	/**
	 * findTiido_firmasByTiido_fir_oficina_fkKey_Local
	 */
	public javax.resource.cci.Record findTiido_firmasByTiido_fir_oficina_fkKey_Local(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_firmasByTiido_fir_oficina_fkKey_LocalQuery_0);

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
			result = executeQuery(connection, pstmt, findTiido_firmasByTiido_fir_oficina_fkKey_LocalQuery_0);

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
	private static String findTiido_firmasByTiido_fir_oficina_fkKey_LocalForUpdateQuery_0 = " SELECT T1.COD_FIRMA, T1.ANHO_FIRM, T1.MES_FIRM, T1.ITEM_FIRM, T1.COD_GESTOR, T1.DESCRIPCION, T1.FEC_FIRM, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_FIRMAS  T1 WHERE T1.COD_TERR = ? AND T1.COD_OFIC = ? FOR UPDATE ";
	/**
	 * findTiido_firmasByTiido_fir_oficina_fkKey_Local444Update
	 */
	public javax.resource.cci.Record findTiido_firmasByTiido_fir_oficina_fkKey_Local444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_firmasByTiido_fir_oficina_fkKey_LocalForUpdateQuery_0);

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
			result = executeQuery(connection, pstmt, findTiido_firmasByTiido_fir_oficina_fkKey_LocalForUpdateQuery_0);

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
	 * Tiido_firmasBeanFunctionSet_7cbca68a
	 */
	public Tiido_firmasBeanFunctionSet_7cbca68a() {
		functionHash=new java.util.HashMap(14);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindFirmByAnoMesCgesItem",new Integer(4));
		functionHash.put("FindFirmByAnoMesCgesItem444Update",new Integer(5));
		functionHash.put("FindByPrimaryKey",new Integer(6));
		functionHash.put("FindByPrimaryKey444Update",new Integer(7));
		functionHash.put("findTiido_firmasByTiido_fir_oficina_fkKey_Local",new Integer(8));
		functionHash.put("findTiido_firmasByTiido_fir_oficina_fkKey_Local444Update",new Integer(9));
		functionHash.put("ReadReadChecking",new Integer(10));
		functionHash.put("ReadReadCheckingForUpdate",new Integer(11));
		functionHash.put("PartialStore",new Integer(12));
		functionHash.put("PartialStoreUsingOCC",new Integer(13));
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
			outputRecord=FindFirmByAnoMesCgesItem(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindFirmByAnoMesCgesItem444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=findTiido_firmasByTiido_fir_oficina_fkKey_Local(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=findTiido_firmasByTiido_fir_oficina_fkKey_Local444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			ReadReadChecking(inputRecord,connection,interactionSpec);
			break;
		case 11:
			ReadReadCheckingForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 12:
			PartialStore(inputRecord,connection,interactionSpec);
			break;
		case 13:
			PartialStoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
	private static String ReadReadQuery_0 = " SELECT 1 FROM IIDO.TIIDO_FIRMAS  T1 WHERE T1.COD_FIRMA = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column COD_FIRMA
			// For column COD_FIRMA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM IIDO.TIIDO_FIRMAS  T1 WHERE T1.COD_FIRMA = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ? FOR UPDATE ";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column COD_FIRMA
			// For column COD_FIRMA
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
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
		updateTemplateList = Tiido_firmasBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
					if (changedFieldIndexes[1])
					{
						// For column ANHO_FIRM
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
						// For column MES_FIRM
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
						// For column ITEM_FIRM
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
						// For column COD_GESTOR
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
						// For column DESCRIPCION
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
						// For column FEC_FIRM
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(6);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_FIRMA
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_OFIC
						String tempString;


						tempString=(String)inputRecord.get(7);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERR
						String tempString;


						tempString=(String)inputRecord.get(8);
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
					if (changedFieldIndexes[1])
					{
						// For column ANHO_FIRM
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
						// For column MES_FIRM
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
						// For column ITEM_FIRM
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
						// For column COD_GESTOR
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
						// For column DESCRIPCION
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
						// For column FEC_FIRM
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(6);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_FIRMA
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_OFIC
						String tempString;


						tempString=(String)inputRecord.get(7);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERR
						String tempString;


						tempString=(String)inputRecord.get(8);
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
