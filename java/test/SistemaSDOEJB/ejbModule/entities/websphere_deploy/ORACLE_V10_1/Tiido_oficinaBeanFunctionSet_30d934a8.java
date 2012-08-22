package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * Tiido_oficinaBeanFunctionSet_30d934a8
 */
public class Tiido_oficinaBeanFunctionSet_30d934a8 extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO IIDO.TIIDO_OFICINA (COD_OFIC, COD_TERR, NOM_OFIC, USU_REGI, FEC_REGI, USU_ACTU, FEC_ACTU, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column NOM_OFIC
			// For column NOM_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(5,tempDate);
				else
					pstmt.setNull(5,java.sql.Types.DATE);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(5);
				if(tempDate != null)
					pstmt.setDate(7,tempDate);
				else
					pstmt.setNull(7,java.sql.Types.DATE);
			}
			// For column ESTADO
			// For column ESTADO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
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
	private static String RemoveQuery_0 = "DELETE FROM IIDO.TIIDO_OFICINA  WHERE COD_OFIC = ? AND COD_TERR = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
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
	private static String StoreQuery_0 = "UPDATE IIDO.TIIDO_OFICINA  SET NOM_OFIC = ?, USU_REGI = ?, FEC_REGI = ?, USU_ACTU = ?, FEC_ACTU = ?, ESTADO = ? WHERE COD_OFIC = ? AND COD_TERR = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column NOM_OFIC
			// For column NOM_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(5);
				if(tempDate != null)
					pstmt.setDate(5,tempDate);
				else
					pstmt.setNull(5,java.sql.Types.DATE);
			}
			// For column ESTADO
			// For column ESTADO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
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
	private static String StoreOCCQuery_0 = "UPDATE IIDO.TIIDO_OFICINA  SET NOM_OFIC = ?, USU_REGI = ?, FEC_REGI = ?, USU_ACTU = ?, FEC_ACTU = ?, ESTADO = ? WHERE COD_OFIC = ? AND COD_TERR = ? AND ESTADO = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column NOM_OFIC
			// For column NOM_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(5);
				if(tempDate != null)
					pstmt.setDate(5,tempDate);
				else
					pstmt.setNull(5,java.sql.Types.DATE);
			}
			// For column ESTADO
			// For column ESTADO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column ESTADO
			{
				String tempString;


				tempString=(String)oldRecord.get(6);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
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
	private static String findListaByCodOficinaQuery_0 = " select  q1.\"COD_OFIC\",  q1.\"NOM_OFIC\",  q1.\"USU_REGI\",  q1.\"FEC_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_ACTU\",  q1.\"ESTADO\",  q1.\"COD_TERR\" from IIDO.TIIDO_OFICINA q1 inner join IIDO.TIIDO_TERRITORIO q2 on  ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  where  ( q1.\"COD_OFIC\" = ?)  and  ( q2.\"ESTADO\" = \'0\') ";
	/**
	 * FindListaByCodOficina
	 */
	public javax.resource.cci.Record FindListaByCodOficina(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_oficina o where  o.cod_ofic = ?1 and o.tiido_territorio_fk.estado = '0' */
			pstmt = prepareStatement(connection, findListaByCodOficinaQuery_0);

			// For ?1 (codOficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findListaByCodOficinaQuery_0);

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
	private static String findListaByCodOficinaForUpdateQuery_0 = " select  q1.\"COD_OFIC\",  q1.\"NOM_OFIC\",  q1.\"USU_REGI\",  q1.\"FEC_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_ACTU\",  q1.\"ESTADO\",  q1.\"COD_TERR\" from IIDO.TIIDO_OFICINA q1 inner join IIDO.TIIDO_TERRITORIO q2 on  ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  where  ( q1.\"COD_OFIC\" = ?)  and  ( q2.\"ESTADO\" = \'0\')  for update ";
	/**
	 * FindListaByCodOficina444Update
	 */
	public javax.resource.cci.Record FindListaByCodOficina444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_oficina o where  o.cod_ofic = ?1 and o.tiido_territorio_fk.estado = '0' */
			pstmt = prepareStatement(connection, findListaByCodOficinaForUpdateQuery_0);

			// For ?1 (codOficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findListaByCodOficinaForUpdateQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.COD_OFIC, T1.NOM_OFIC, T1.USU_REGI, T1.FEC_REGI, T1.USU_ACTU, T1.FEC_ACTU, T1.ESTADO, T1.COD_TERR FROM IIDO.TIIDO_OFICINA  T1 WHERE T1.COD_OFIC = ? AND T1.COD_TERR = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.COD_OFIC, T1.NOM_OFIC, T1.USU_REGI, T1.FEC_REGI, T1.USU_ACTU, T1.FEC_ACTU, T1.ESTADO, T1.COD_TERR FROM IIDO.TIIDO_OFICINA  T1 WHERE T1.COD_OFIC = ? AND T1.COD_TERR = ? FOR UPDATE ";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
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
	private static String findAllOficinaByCodTerriQuery_0 = " select  q1.\"COD_OFIC\",  q1.\"NOM_OFIC\",  q1.\"USU_REGI\",  q1.\"FEC_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_ACTU\",  q1.\"ESTADO\",  q1.\"COD_TERR\" from IIDO.TIIDO_OFICINA q1 inner join IIDO.TIIDO_TERRITORIO q2 on  ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  where  ( q2.\"COD_TERR\" = ?)  and  ( q2.\"ESTADO\" = \'0\') ";
	/**
	 * FindAllOficinaByCodTerri
	 */
	public javax.resource.cci.Record FindAllOficinaByCodTerri(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_oficina o where  o.tiido_territorio_fk.cod_terr = ?1 and o.tiido_territorio_fk.estado = '0' */
			pstmt = prepareStatement(connection, findAllOficinaByCodTerriQuery_0);

			// For ?1 (codTerritorio)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllOficinaByCodTerriQuery_0);

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
	private static String findAllOficinaByCodTerriForUpdateQuery_0 = " select  q1.\"COD_OFIC\",  q1.\"NOM_OFIC\",  q1.\"USU_REGI\",  q1.\"FEC_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_ACTU\",  q1.\"ESTADO\",  q1.\"COD_TERR\" from IIDO.TIIDO_OFICINA q1 inner join IIDO.TIIDO_TERRITORIO q2 on  ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  where  ( q2.\"COD_TERR\" = ?)  and  ( q2.\"ESTADO\" = \'0\')  for update ";
	/**
	 * FindAllOficinaByCodTerri444Update
	 */
	public javax.resource.cci.Record FindAllOficinaByCodTerri444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_oficina o where  o.tiido_territorio_fk.cod_terr = ?1 and o.tiido_territorio_fk.estado = '0' */
			pstmt = prepareStatement(connection, findAllOficinaByCodTerriForUpdateQuery_0);

			// For ?1 (codTerritorio)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllOficinaByCodTerriForUpdateQuery_0);

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
	private static String findByCodOficinaQuery_0 = " select  q1.\"COD_OFIC\",  q1.\"NOM_OFIC\",  q1.\"USU_REGI\",  q1.\"FEC_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_ACTU\",  q1.\"ESTADO\",  q1.\"COD_TERR\" from IIDO.TIIDO_OFICINA q1 inner join IIDO.TIIDO_TERRITORIO q2 on  ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  where  ( q1.\"COD_OFIC\" = ?)  and  ( q2.\"ESTADO\" = \'0\') ";
	/**
	 * FindByCodOficina
	 */
	public javax.resource.cci.Record FindByCodOficina(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_oficina o where  o.cod_ofic = ?1 and o.tiido_territorio_fk.estado = '0' */
			pstmt = prepareStatement(connection, findByCodOficinaQuery_0);

			// For ?1 (codOficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCodOficinaQuery_0);

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
	private static String findByCodOficinaForUpdateQuery_0 = " select  q1.\"COD_OFIC\",  q1.\"NOM_OFIC\",  q1.\"USU_REGI\",  q1.\"FEC_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_ACTU\",  q1.\"ESTADO\",  q1.\"COD_TERR\" from IIDO.TIIDO_OFICINA q1 inner join IIDO.TIIDO_TERRITORIO q2 on  ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  where  ( q1.\"COD_OFIC\" = ?)  and  ( q2.\"ESTADO\" = \'0\')  for update ";
	/**
	 * FindByCodOficina444Update
	 */
	public javax.resource.cci.Record FindByCodOficina444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_oficina o where  o.cod_ofic = ?1 and o.tiido_territorio_fk.estado = '0' */
			pstmt = prepareStatement(connection, findByCodOficinaForUpdateQuery_0);

			// For ?1 (codOficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCodOficinaForUpdateQuery_0);

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
	private static String findTiido_oficinaByTiido_territorio_fkKey_LocalQuery_0 = " SELECT T1.COD_OFIC, T1.NOM_OFIC, T1.USU_REGI, T1.FEC_REGI, T1.USU_ACTU, T1.FEC_ACTU, T1.ESTADO, T1.COD_TERR FROM IIDO.TIIDO_OFICINA  T1 WHERE T1.COD_TERR = ?";
	/**
	 * findTiido_oficinaByTiido_territorio_fkKey_Local
	 */
	public javax.resource.cci.Record findTiido_oficinaByTiido_territorio_fkKey_Local(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_oficinaByTiido_territorio_fkKey_LocalQuery_0);

			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findTiido_oficinaByTiido_territorio_fkKey_LocalQuery_0);

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
	private static String findTiido_oficinaByTiido_territorio_fkKey_LocalForUpdateQuery_0 = " SELECT T1.COD_OFIC, T1.NOM_OFIC, T1.USU_REGI, T1.FEC_REGI, T1.USU_ACTU, T1.FEC_ACTU, T1.ESTADO, T1.COD_TERR FROM IIDO.TIIDO_OFICINA  T1 WHERE T1.COD_TERR = ? FOR UPDATE ";
	/**
	 * findTiido_oficinaByTiido_territorio_fkKey_Local444Update
	 */
	public javax.resource.cci.Record findTiido_oficinaByTiido_territorio_fkKey_Local444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_oficinaByTiido_territorio_fkKey_LocalForUpdateQuery_0);

			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findTiido_oficinaByTiido_territorio_fkKey_LocalForUpdateQuery_0);

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
	 * Tiido_oficinaBeanFunctionSet_30d934a8
	 */
	public Tiido_oficinaBeanFunctionSet_30d934a8() {
		functionHash=new java.util.HashMap(18);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindListaByCodOficina",new Integer(4));
		functionHash.put("FindListaByCodOficina444Update",new Integer(5));
		functionHash.put("FindByPrimaryKey",new Integer(6));
		functionHash.put("FindByPrimaryKey444Update",new Integer(7));
		functionHash.put("FindAllOficinaByCodTerri",new Integer(8));
		functionHash.put("FindAllOficinaByCodTerri444Update",new Integer(9));
		functionHash.put("FindByCodOficina",new Integer(10));
		functionHash.put("FindByCodOficina444Update",new Integer(11));
		functionHash.put("findTiido_oficinaByTiido_territorio_fkKey_Local",new Integer(12));
		functionHash.put("findTiido_oficinaByTiido_territorio_fkKey_Local444Update",new Integer(13));
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
			outputRecord=FindListaByCodOficina(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindListaByCodOficina444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindAllOficinaByCodTerri(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindAllOficinaByCodTerri444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindByCodOficina(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindByCodOficina444Update(inputRecord,connection,interactionSpec);
			break;
		case 12:
			outputRecord=findTiido_oficinaByTiido_territorio_fkKey_Local(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=findTiido_oficinaByTiido_territorio_fkKey_Local444Update(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM IIDO.TIIDO_OFICINA  T1 WHERE T1.COD_OFIC = ? AND T1.COD_TERR = ? AND T1.ESTADO = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ESTADO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM IIDO.TIIDO_OFICINA  T1 WHERE T1.COD_OFIC = ? AND T1.COD_TERR = ? AND T1.ESTADO = ? FOR UPDATE ";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ESTADO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
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
		updateTemplateList = Tiido_oficinaBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column NOM_OFIC
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
						// For column USU_REGI
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
						// For column FEC_REGI
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(3);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column USU_ACTU
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
						// For column FEC_ACTU
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(5);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column ESTADO
						String tempString;


						tempString=(String)inputRecord.get(6);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_OFIC
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERR
						String tempString;


						tempString=(String)inputRecord.get(7);
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
				Object[] oldValues = new Object[1];
				oldValues[0] = oldRecord.get(6);
				String updateQuery = aTemplate.nativeOptimisticQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[1])
					{
						// For column NOM_OFIC
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
						// For column USU_REGI
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
						// For column FEC_REGI
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(3);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column USU_ACTU
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
						// For column FEC_ACTU
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(5);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column ESTADO
						String tempString;


						tempString=(String)inputRecord.get(6);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_OFIC
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERR
						String tempString;


						tempString=(String)inputRecord.get(7);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					// optimistic predicate columns
					{
						// For column ESTADO
						String tempString;


						tempString=(String)oldValues[0];
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
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
