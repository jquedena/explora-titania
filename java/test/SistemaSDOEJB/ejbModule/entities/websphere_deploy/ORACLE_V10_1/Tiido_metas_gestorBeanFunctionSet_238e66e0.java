package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * Tiido_metas_gestorBeanFunctionSet_238e66e0
 */
public class Tiido_metas_gestorBeanFunctionSet_238e66e0 extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO IIDO.TIIDO_METAS_GESTOR (COD_META_GESTOR, COD_EPIGRAFE, ANHO, COD_TERR, COD_OFIC, COD_GESTOR, MES, ORDEN, FEC_REGI, PORC_ASIG, NOM_EPIGRAFE, NOM_GESTOR, COD_PERFIL, ESTADO, FEC_ACTU, USU_REGI, USU_ACTU) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column COD_META_GESTOR
			// For column COD_META_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column ORDEN
			// For column ORDEN
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(4);
				if(tempDate != null)
					pstmt.setDate(9,tempDate);
				else
					pstmt.setNull(9,java.sql.Types.DATE);
			}
			// For column PORC_ASIG
			// For column PORC_ASIG
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(10,tempBigDecimal);
				else
					pstmt.setNull(10,java.sql.Types.DECIMAL);
			}
			// For column NOM_EPIGRAFE
			// For column NOM_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column NOM_GESTOR
			// For column NOM_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.VARCHAR);
			}
			// For column ESTADO
			// For column ESTADO
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.CHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(10);
				if(tempTimestamp != null)
					pstmt.setTimestamp(15,tempTimestamp);
				else
					pstmt.setNull(15,java.sql.Types.TIMESTAMP);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.VARCHAR);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
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
	private static String RemoveQuery_0 = "DELETE FROM IIDO.TIIDO_METAS_GESTOR  WHERE COD_META_GESTOR = ? AND COD_EPIGRAFE = ? AND ANHO = ? AND COD_TERR = ? AND COD_OFIC = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column COD_META_GESTOR
			// For column COD_META_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
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
	private static String StoreQuery_0 = "UPDATE IIDO.TIIDO_METAS_GESTOR  SET COD_GESTOR = ?, MES = ?, ORDEN = ?, FEC_REGI = ?, PORC_ASIG = ?, NOM_EPIGRAFE = ?, NOM_GESTOR = ?, COD_PERFIL = ?, ESTADO = ?, FEC_ACTU = ?, USU_REGI = ?, USU_ACTU = ? WHERE COD_META_GESTOR = ? AND COD_EPIGRAFE = ? AND ANHO = ? AND COD_TERR = ? AND COD_OFIC = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column COD_META_GESTOR
			// For column COD_META_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.VARCHAR);
			}
			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ORDEN
			// For column ORDEN
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(4);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			// For column PORC_ASIG
			// For column PORC_ASIG
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(5,tempBigDecimal);
				else
					pstmt.setNull(5,java.sql.Types.DECIMAL);
			}
			// For column NOM_EPIGRAFE
			// For column NOM_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column NOM_GESTOR
			// For column NOM_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column ESTADO
			// For column ESTADO
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(10);
				if(tempTimestamp != null)
					pstmt.setTimestamp(10,tempTimestamp);
				else
					pstmt.setNull(10,java.sql.Types.TIMESTAMP);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.VARCHAR);
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
	private static String StoreOCCQuery_0 = "UPDATE IIDO.TIIDO_METAS_GESTOR  SET COD_GESTOR = ?, MES = ?, ORDEN = ?, FEC_REGI = ?, PORC_ASIG = ?, NOM_EPIGRAFE = ?, NOM_GESTOR = ?, COD_PERFIL = ?, ESTADO = ?, FEC_ACTU = ?, USU_REGI = ?, USU_ACTU = ? WHERE COD_META_GESTOR = ? AND COD_EPIGRAFE = ? AND ANHO = ? AND COD_TERR = ? AND COD_OFIC = ? AND COD_PERFIL = ? AND ESTADO = ? AND FEC_ACTU = ? AND USU_REGI = ? AND USU_ACTU = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column COD_META_GESTOR
			// For column COD_META_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.VARCHAR);
			}
			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ORDEN
			// For column ORDEN
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(4);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			// For column PORC_ASIG
			// For column PORC_ASIG
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(5,tempBigDecimal);
				else
					pstmt.setNull(5,java.sql.Types.DECIMAL);
			}
			// For column NOM_EPIGRAFE
			// For column NOM_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column NOM_GESTOR
			// For column NOM_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column ESTADO
			// For column ESTADO
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(10);
				if(tempTimestamp != null)
					pstmt.setTimestamp(10,tempTimestamp);
				else
					pstmt.setNull(10,java.sql.Types.TIMESTAMP);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.VARCHAR);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)oldRecord.get(8);
				if(tempString != null)
					pstmt.setString(18,tempString);
				else
					pstmt.setNull(18,java.sql.Types.VARCHAR);
			}
			// For column ESTADO
			{
				String tempString;


				tempString=(String)oldRecord.get(9);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.CHAR);
			}
			// For column FEC_ACTU
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)oldRecord.get(10);
				if(tempTimestamp != null)
					pstmt.setTimestamp(20,tempTimestamp);
				else
					pstmt.setNull(20,java.sql.Types.TIMESTAMP);
			}
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)oldRecord.get(11);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.VARCHAR);
			}
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)oldRecord.get(12);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.VARCHAR);
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
	private static String findMetGestorByPrimaryKeyQuery_0 = " select  q1.\"COD_META_GESTOR\",  q1.\"COD_GESTOR\",  q1.\"MES\",  q1.\"ORDEN\",  q1.\"FEC_REGI\",  q1.\"PORC_ASIG\",  q1.\"NOM_EPIGRAFE\",  q1.\"NOM_GESTOR\",  q1.\"COD_PERFIL\",  q1.\"ESTADO\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"COD_EPIGRAFE\",  q1.\"ANHO\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_METAS_GESTOR q1, IIDO.TIIDO_EPIGRAFE q2, IIDO.TIIDO_OFICINA q3 where  ( q2.\"COD_EPIGRAFE\" = ?)  and  ( q2.\"ANHO\" = ?)  and  ( q3.\"COD_OFIC\" = ?)  and  ( q1.\"MES\" = ?)  and  ( q1.\"COD_GESTOR\" = ?)  and  ( q2.\"COD_EPIGRAFE\" =  q1.\"COD_EPIGRAFE\")  and  ( q2.\"ANHO\" =  q1.\"ANHO\")  and  ( q3.\"COD_TERR\" =  q1.\"COD_TERR\")  and  ( q3.\"COD_OFIC\" =  q1.\"COD_OFIC\") ";
	/**
	 * FindMetGestorByPrimaryKey
	 */
	public javax.resource.cci.Record FindMetGestorByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_metas_gestor o where  o.tiido_metges_epigrafe_fk.cod_epigrafe = ?1 and  o.tiido_metges_epigrafe_fk.anho = ?2 and  o.tiido_metges_oficina_fk.cod_ofic = ?3 and o.mes = ?4 and o.cod_gestor = ?5 */
			pstmt = prepareStatement(connection, findMetGestorByPrimaryKeyQuery_0);

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
			// For ?3 (codOficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (mes)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For ?5 (codGestor)
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findMetGestorByPrimaryKeyQuery_0);

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
	private static String findMetGestorByPrimaryKeyForUpdateQuery_0 = " select  q1.\"COD_META_GESTOR\",  q1.\"COD_GESTOR\",  q1.\"MES\",  q1.\"ORDEN\",  q1.\"FEC_REGI\",  q1.\"PORC_ASIG\",  q1.\"NOM_EPIGRAFE\",  q1.\"NOM_GESTOR\",  q1.\"COD_PERFIL\",  q1.\"ESTADO\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"COD_EPIGRAFE\",  q1.\"ANHO\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_METAS_GESTOR q1, IIDO.TIIDO_EPIGRAFE q2, IIDO.TIIDO_OFICINA q3 where  ( q2.\"COD_EPIGRAFE\" = ?)  and  ( q2.\"ANHO\" = ?)  and  ( q3.\"COD_OFIC\" = ?)  and  ( q1.\"MES\" = ?)  and  ( q1.\"COD_GESTOR\" = ?)  and  ( q2.\"COD_EPIGRAFE\" =  q1.\"COD_EPIGRAFE\")  and  ( q2.\"ANHO\" =  q1.\"ANHO\")  and  ( q3.\"COD_TERR\" =  q1.\"COD_TERR\")  and  ( q3.\"COD_OFIC\" =  q1.\"COD_OFIC\")  for update ";
	/**
	 * FindMetGestorByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindMetGestorByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_metas_gestor o where  o.tiido_metges_epigrafe_fk.cod_epigrafe = ?1 and  o.tiido_metges_epigrafe_fk.anho = ?2 and  o.tiido_metges_oficina_fk.cod_ofic = ?3 and o.mes = ?4 and o.cod_gestor = ?5 */
			pstmt = prepareStatement(connection, findMetGestorByPrimaryKeyForUpdateQuery_0);

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
			// For ?3 (codOficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (mes)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For ?5 (codGestor)
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findMetGestorByPrimaryKeyForUpdateQuery_0);

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
	private static String findGestorByCodigoQuery_0 = " select  q1.\"COD_META_GESTOR\",  q1.\"COD_GESTOR\",  q1.\"MES\",  q1.\"ORDEN\",  q1.\"FEC_REGI\",  q1.\"PORC_ASIG\",  q1.\"NOM_EPIGRAFE\",  q1.\"NOM_GESTOR\",  q1.\"COD_PERFIL\",  q1.\"ESTADO\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"COD_EPIGRAFE\",  q1.\"ANHO\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_METAS_GESTOR q1 where  ( q1.\"COD_GESTOR\" = ?) ";
	/**
	 * FindGestorByCodigo
	 */
	public javax.resource.cci.Record FindGestorByCodigo(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_metas_gestor o where o.cod_gestor = ?1 */
			pstmt = prepareStatement(connection, findGestorByCodigoQuery_0);

			// For ?1 (codGestor)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findGestorByCodigoQuery_0);

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
	private static String findGestorByCodigoForUpdateQuery_0 = " select  q1.\"COD_META_GESTOR\",  q1.\"COD_GESTOR\",  q1.\"MES\",  q1.\"ORDEN\",  q1.\"FEC_REGI\",  q1.\"PORC_ASIG\",  q1.\"NOM_EPIGRAFE\",  q1.\"NOM_GESTOR\",  q1.\"COD_PERFIL\",  q1.\"ESTADO\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"COD_EPIGRAFE\",  q1.\"ANHO\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_METAS_GESTOR q1 where  ( q1.\"COD_GESTOR\" = ?)  for update ";
	/**
	 * FindGestorByCodigo444Update
	 */
	public javax.resource.cci.Record FindGestorByCodigo444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_metas_gestor o where o.cod_gestor = ?1 */
			pstmt = prepareStatement(connection, findGestorByCodigoForUpdateQuery_0);

			// For ?1 (codGestor)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findGestorByCodigoForUpdateQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.COD_META_GESTOR, T1.COD_GESTOR, T1.MES, T1.ORDEN, T1.FEC_REGI, T1.PORC_ASIG, T1.NOM_EPIGRAFE, T1.NOM_GESTOR, T1.COD_PERFIL, T1.ESTADO, T1.FEC_ACTU, T1.USU_REGI, T1.USU_ACTU, T1.COD_EPIGRAFE, T1.ANHO, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_METAS_GESTOR  T1 WHERE T1.COD_META_GESTOR = ? AND T1.COD_EPIGRAFE = ? AND T1.ANHO = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column COD_META_GESTOR
			// For column COD_META_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.COD_META_GESTOR, T1.COD_GESTOR, T1.MES, T1.ORDEN, T1.FEC_REGI, T1.PORC_ASIG, T1.NOM_EPIGRAFE, T1.NOM_GESTOR, T1.COD_PERFIL, T1.ESTADO, T1.FEC_ACTU, T1.USU_REGI, T1.USU_ACTU, T1.COD_EPIGRAFE, T1.ANHO, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_METAS_GESTOR  T1 WHERE T1.COD_META_GESTOR = ? AND T1.COD_EPIGRAFE = ? AND T1.ANHO = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ? FOR UPDATE ";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column COD_META_GESTOR
			// For column COD_META_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
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
	private static String findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_LocalQuery_0 = " SELECT T1.COD_META_GESTOR, T1.COD_GESTOR, T1.MES, T1.ORDEN, T1.FEC_REGI, T1.PORC_ASIG, T1.NOM_EPIGRAFE, T1.NOM_GESTOR, T1.COD_PERFIL, T1.ESTADO, T1.FEC_ACTU, T1.USU_REGI, T1.USU_ACTU, T1.COD_EPIGRAFE, T1.ANHO, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_METAS_GESTOR  T1 WHERE T1.COD_EPIGRAFE = ? AND T1.ANHO = ?";
	/**
	 * findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local
	 */
	public javax.resource.cci.Record findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_LocalQuery_0);

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
			result = executeQuery(connection, pstmt, findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_LocalQuery_0);

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
	private static String findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_LocalForUpdateQuery_0 = " SELECT T1.COD_META_GESTOR, T1.COD_GESTOR, T1.MES, T1.ORDEN, T1.FEC_REGI, T1.PORC_ASIG, T1.NOM_EPIGRAFE, T1.NOM_GESTOR, T1.COD_PERFIL, T1.ESTADO, T1.FEC_ACTU, T1.USU_REGI, T1.USU_ACTU, T1.COD_EPIGRAFE, T1.ANHO, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_METAS_GESTOR  T1 WHERE T1.COD_EPIGRAFE = ? AND T1.ANHO = ? FOR UPDATE ";
	/**
	 * findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local444Update
	 */
	public javax.resource.cci.Record findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_LocalForUpdateQuery_0);

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
			result = executeQuery(connection, pstmt, findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_LocalForUpdateQuery_0);

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
	private static String findTiido_metas_gestorByTiido_metges_oficina_fkKey_LocalQuery_0 = " SELECT T1.COD_META_GESTOR, T1.COD_GESTOR, T1.MES, T1.ORDEN, T1.FEC_REGI, T1.PORC_ASIG, T1.NOM_EPIGRAFE, T1.NOM_GESTOR, T1.COD_PERFIL, T1.ESTADO, T1.FEC_ACTU, T1.USU_REGI, T1.USU_ACTU, T1.COD_EPIGRAFE, T1.ANHO, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_METAS_GESTOR  T1 WHERE T1.COD_TERR = ? AND T1.COD_OFIC = ?";
	/**
	 * findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local
	 */
	public javax.resource.cci.Record findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_metas_gestorByTiido_metges_oficina_fkKey_LocalQuery_0);

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
			result = executeQuery(connection, pstmt, findTiido_metas_gestorByTiido_metges_oficina_fkKey_LocalQuery_0);

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
	private static String findTiido_metas_gestorByTiido_metges_oficina_fkKey_LocalForUpdateQuery_0 = " SELECT T1.COD_META_GESTOR, T1.COD_GESTOR, T1.MES, T1.ORDEN, T1.FEC_REGI, T1.PORC_ASIG, T1.NOM_EPIGRAFE, T1.NOM_GESTOR, T1.COD_PERFIL, T1.ESTADO, T1.FEC_ACTU, T1.USU_REGI, T1.USU_ACTU, T1.COD_EPIGRAFE, T1.ANHO, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_METAS_GESTOR  T1 WHERE T1.COD_TERR = ? AND T1.COD_OFIC = ? FOR UPDATE ";
	/**
	 * findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local444Update
	 */
	public javax.resource.cci.Record findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_metas_gestorByTiido_metges_oficina_fkKey_LocalForUpdateQuery_0);

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
			result = executeQuery(connection, pstmt, findTiido_metas_gestorByTiido_metges_oficina_fkKey_LocalForUpdateQuery_0);

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
	 * Tiido_metas_gestorBeanFunctionSet_238e66e0
	 */
	public Tiido_metas_gestorBeanFunctionSet_238e66e0() {
		functionHash=new java.util.HashMap(18);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindMetGestorByPrimaryKey",new Integer(4));
		functionHash.put("FindMetGestorByPrimaryKey444Update",new Integer(5));
		functionHash.put("FindGestorByCodigo",new Integer(6));
		functionHash.put("FindGestorByCodigo444Update",new Integer(7));
		functionHash.put("FindByPrimaryKey",new Integer(8));
		functionHash.put("FindByPrimaryKey444Update",new Integer(9));
		functionHash.put("findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local",new Integer(10));
		functionHash.put("findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local444Update",new Integer(11));
		functionHash.put("findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local",new Integer(12));
		functionHash.put("findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local444Update",new Integer(13));
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
			outputRecord=FindMetGestorByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindMetGestorByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindGestorByCodigo(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindGestorByCodigo444Update(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=findTiido_metas_gestorByTiido_metges_epigrafe_fkKey_Local444Update(inputRecord,connection,interactionSpec);
			break;
		case 12:
			outputRecord=findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=findTiido_metas_gestorByTiido_metges_oficina_fkKey_Local444Update(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM IIDO.TIIDO_METAS_GESTOR  T1 WHERE T1.COD_META_GESTOR = ? AND T1.COD_EPIGRAFE = ? AND T1.ANHO = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ? AND T1.COD_PERFIL = ? AND T1.ESTADO = ? AND T1.FEC_ACTU = ? AND T1.USU_REGI = ? AND T1.USU_ACTU = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column COD_META_GESTOR
			// For column COD_META_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
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
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column ESTADO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column FEC_ACTU
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(7);
				if(tempTimestamp != null)
					pstmt.setTimestamp(8,tempTimestamp);
				else
					pstmt.setNull(8,java.sql.Types.TIMESTAMP);
			}
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.VARCHAR);
			}
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.VARCHAR);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM IIDO.TIIDO_METAS_GESTOR  T1 WHERE T1.COD_META_GESTOR = ? AND T1.COD_EPIGRAFE = ? AND T1.ANHO = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ? AND T1.COD_PERFIL = ? AND T1.ESTADO = ? AND T1.FEC_ACTU = ? AND T1.USU_REGI = ? AND T1.USU_ACTU = ? FOR UPDATE ";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column COD_META_GESTOR
			// For column COD_META_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column ANHO
			// For column ANHO
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
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column ESTADO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column FEC_ACTU
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(7);
				if(tempTimestamp != null)
					pstmt.setTimestamp(8,tempTimestamp);
				else
					pstmt.setNull(8,java.sql.Types.TIMESTAMP);
			}
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.VARCHAR);
			}
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.VARCHAR);
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
		updateTemplateList = Tiido_metas_gestorBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column COD_GESTOR
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
						// For column MES
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
						// For column ORDEN
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
						// For column FEC_REGI
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(4);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column PORC_ASIG
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column NOM_EPIGRAFE
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
						// For column NOM_GESTOR
						String tempString;


						tempString=(String)inputRecord.get(7);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column COD_PERFIL
						String tempString;


						tempString=(String)inputRecord.get(8);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column ESTADO
						String tempString;


						tempString=(String)inputRecord.get(9);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column FEC_ACTU
						java.sql.Timestamp tempTimestamp;


						tempTimestamp=(java.sql.Timestamp)inputRecord.get(10);
						if(tempTimestamp != null){
							pstmt.setTimestamp(stmtIndex,tempTimestamp);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIMESTAMP);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column USU_REGI
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column USU_ACTU
						String tempString;


						tempString=(String)inputRecord.get(12);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_META_GESTOR
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_EPIGRAFE
						String tempString;


						tempString=(String)inputRecord.get(13);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column ANHO
						String tempString;


						tempString=(String)inputRecord.get(14);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_OFIC
						String tempString;


						tempString=(String)inputRecord.get(15);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERR
						String tempString;


						tempString=(String)inputRecord.get(16);
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
				Object[] oldValues = new Object[5];
				oldValues[0] = oldRecord.get(8);
				oldValues[1] = oldRecord.get(9);
				oldValues[2] = oldRecord.get(10);
				oldValues[3] = oldRecord.get(11);
				oldValues[4] = oldRecord.get(12);
				String updateQuery = aTemplate.nativeOptimisticQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[1])
					{
						// For column COD_GESTOR
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
						// For column MES
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
						// For column ORDEN
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
						// For column FEC_REGI
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(4);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column PORC_ASIG
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column NOM_EPIGRAFE
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
						// For column NOM_GESTOR
						String tempString;


						tempString=(String)inputRecord.get(7);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column COD_PERFIL
						String tempString;


						tempString=(String)inputRecord.get(8);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column ESTADO
						String tempString;


						tempString=(String)inputRecord.get(9);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column FEC_ACTU
						java.sql.Timestamp tempTimestamp;


						tempTimestamp=(java.sql.Timestamp)inputRecord.get(10);
						if(tempTimestamp != null){
							pstmt.setTimestamp(stmtIndex,tempTimestamp);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIMESTAMP);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column USU_REGI
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column USU_ACTU
						String tempString;


						tempString=(String)inputRecord.get(12);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_META_GESTOR
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_EPIGRAFE
						String tempString;


						tempString=(String)inputRecord.get(13);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column ANHO
						String tempString;


						tempString=(String)inputRecord.get(14);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_OFIC
						String tempString;


						tempString=(String)inputRecord.get(15);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERR
						String tempString;


						tempString=(String)inputRecord.get(16);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					// optimistic predicate columns
					{
						// For column COD_PERFIL
						String tempString;


						tempString=(String)oldValues[0];
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
							stmtIndex++;
						}

					}
					{
						// For column ESTADO
						String tempString;


						tempString=(String)oldValues[1];
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
							stmtIndex++;
						}

					}
					{
						// For column FEC_ACTU
						java.sql.Timestamp tempTimestamp;


						tempTimestamp=(java.sql.Timestamp)oldValues[2];
						if(tempTimestamp != null){
							pstmt.setTimestamp(stmtIndex,tempTimestamp);
							stmtIndex++;
						}

					}
					{
						// For column USU_REGI
						String tempString;


						tempString=(String)oldValues[3];
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
							stmtIndex++;
						}

					}
					{
						// For column USU_ACTU
						String tempString;


						tempString=(String)oldValues[4];
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
