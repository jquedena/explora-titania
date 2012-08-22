package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * Tiido_campanias_detalleBeanFunctionSet_6826fb65
 */
public class Tiido_campanias_detalleBeanFunctionSet_6826fb65 extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO IIDO.TIIDO_CAMPANIAS_DETALLE (COD_CAMP_DETA, COD_CAMP, ANHO, MES, COD_OFIC, COD_TERR, NOM_CAMP, COD_GEST, NRO_CLIE, COMP_GEST, NRO_GEST_SEGU_1, NRO_CONC_SEGU_1, MONT_SEGU_1, NRO_GEST_SEGU_2, NRO_CONC_SEGU_2, MONT_SEGU_2, FEC_REGI, FEC_SEGU_1, FEC_SEGU_2, USU_REGI, FEC_ACTU, USU_ACTU) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column COD_CAMP_DETA
			// For column COD_CAMP_DETA
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.DECIMAL);
			}
			// For column NOM_CAMP
			// For column NOM_CAMP
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column COD_GEST
			// For column COD_GEST
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column NRO_CLIE
			// For column NRO_CLIE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(3);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(9,tempBigDecimal);
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column COMP_GEST
			// For column COMP_GEST
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(4);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(10,tempBigDecimal);
				else
					pstmt.setNull(10,java.sql.Types.DECIMAL);
			}
			// For column NRO_GEST_SEGU_1
			// For column NRO_GEST_SEGU_1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(11,tempBigDecimal);
				else
					pstmt.setNull(11,java.sql.Types.DECIMAL);
			}
			// For column NRO_CONC_SEGU_1
			// For column NRO_CONC_SEGU_1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(6);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(12,tempBigDecimal);
				else
					pstmt.setNull(12,java.sql.Types.DECIMAL);
			}
			// For column MONT_SEGU_1
			// For column MONT_SEGU_1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(13,tempBigDecimal);
				else
					pstmt.setNull(13,java.sql.Types.DECIMAL);
			}
			// For column NRO_GEST_SEGU_2
			// For column NRO_GEST_SEGU_2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(8);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(14,tempBigDecimal);
				else
					pstmt.setNull(14,java.sql.Types.DECIMAL);
			}
			// For column NRO_CONC_SEGU_2
			// For column NRO_CONC_SEGU_2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(9);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(15,tempBigDecimal);
				else
					pstmt.setNull(15,java.sql.Types.DECIMAL);
			}
			// For column MONT_SEGU_2
			// For column MONT_SEGU_2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(16,tempBigDecimal);
				else
					pstmt.setNull(16,java.sql.Types.DECIMAL);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(11);
				if(tempDate != null)
					pstmt.setDate(17,tempDate);
				else
					pstmt.setNull(17,java.sql.Types.DATE);
			}
			// For column FEC_SEGU_1
			// For column FEC_SEGU_1
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(12);
				if(tempDate != null)
					pstmt.setDate(18,tempDate);
				else
					pstmt.setNull(18,java.sql.Types.DATE);
			}
			// For column FEC_SEGU_2
			// For column FEC_SEGU_2
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(13);
				if(tempDate != null)
					pstmt.setDate(19,tempDate);
				else
					pstmt.setNull(19,java.sql.Types.DATE);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(20,tempString);
				else
					pstmt.setNull(20,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(15);
				if(tempDate != null)
					pstmt.setDate(21,tempDate);
				else
					pstmt.setNull(21,java.sql.Types.DATE);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.VARCHAR);
			}
			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(17);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.DECIMAL);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(18);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(20);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
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
	private static String RemoveQuery_0 = "DELETE FROM IIDO.TIIDO_CAMPANIAS_DETALLE  WHERE COD_CAMP_DETA = ? AND COD_CAMP = ? AND ANHO = ? AND MES = ? AND COD_OFIC = ? AND COD_TERR = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column COD_CAMP_DETA
			// For column COD_CAMP_DETA
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.DECIMAL);
			}
			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(17);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.DECIMAL);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(18);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(20);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
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
	private static String StoreQuery_0 = "UPDATE IIDO.TIIDO_CAMPANIAS_DETALLE  SET NOM_CAMP = ?, COD_GEST = ?, NRO_CLIE = ?, COMP_GEST = ?, NRO_GEST_SEGU_1 = ?, NRO_CONC_SEGU_1 = ?, MONT_SEGU_1 = ?, NRO_GEST_SEGU_2 = ?, NRO_CONC_SEGU_2 = ?, MONT_SEGU_2 = ?, FEC_REGI = ?, FEC_SEGU_1 = ?, FEC_SEGU_2 = ?, USU_REGI = ?, FEC_ACTU = ?, USU_ACTU = ? WHERE COD_CAMP_DETA = ? AND COD_CAMP = ? AND ANHO = ? AND MES = ? AND COD_OFIC = ? AND COD_TERR = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column COD_CAMP_DETA
			// For column COD_CAMP_DETA
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(17,tempInteger.intValue());
				else
					pstmt.setNull(17,java.sql.Types.DECIMAL);
			}
			// For column NOM_CAMP
			// For column NOM_CAMP
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_GEST
			// For column COD_GEST
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column NRO_CLIE
			// For column NRO_CLIE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(3);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(3,tempBigDecimal);
				else
					pstmt.setNull(3,java.sql.Types.DECIMAL);
			}
			// For column COMP_GEST
			// For column COMP_GEST
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(4);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(4,tempBigDecimal);
				else
					pstmt.setNull(4,java.sql.Types.DECIMAL);
			}
			// For column NRO_GEST_SEGU_1
			// For column NRO_GEST_SEGU_1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(5,tempBigDecimal);
				else
					pstmt.setNull(5,java.sql.Types.DECIMAL);
			}
			// For column NRO_CONC_SEGU_1
			// For column NRO_CONC_SEGU_1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(6);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(6,tempBigDecimal);
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
			}
			// For column MONT_SEGU_1
			// For column MONT_SEGU_1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(7,tempBigDecimal);
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
			}
			// For column NRO_GEST_SEGU_2
			// For column NRO_GEST_SEGU_2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(8);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(8,tempBigDecimal);
				else
					pstmt.setNull(8,java.sql.Types.DECIMAL);
			}
			// For column NRO_CONC_SEGU_2
			// For column NRO_CONC_SEGU_2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(9);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(9,tempBigDecimal);
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column MONT_SEGU_2
			// For column MONT_SEGU_2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(10,tempBigDecimal);
				else
					pstmt.setNull(10,java.sql.Types.DECIMAL);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(11);
				if(tempDate != null)
					pstmt.setDate(11,tempDate);
				else
					pstmt.setNull(11,java.sql.Types.DATE);
			}
			// For column FEC_SEGU_1
			// For column FEC_SEGU_1
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(12);
				if(tempDate != null)
					pstmt.setDate(12,tempDate);
				else
					pstmt.setNull(12,java.sql.Types.DATE);
			}
			// For column FEC_SEGU_2
			// For column FEC_SEGU_2
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(13);
				if(tempDate != null)
					pstmt.setDate(13,tempDate);
				else
					pstmt.setNull(13,java.sql.Types.DATE);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(15);
				if(tempDate != null)
					pstmt.setDate(15,tempDate);
				else
					pstmt.setNull(15,java.sql.Types.DATE);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.VARCHAR);
			}
			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(17);
				if(tempInteger != null)
					pstmt.setInt(18,tempInteger.intValue());
				else
					pstmt.setNull(18,java.sql.Types.DECIMAL);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(18);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.VARCHAR);
			}
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(20,tempString);
				else
					pstmt.setNull(20,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(20);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.VARCHAR);
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
	private static String StoreOCCQuery_0 = "UPDATE IIDO.TIIDO_CAMPANIAS_DETALLE  SET NOM_CAMP = ?, COD_GEST = ?, NRO_CLIE = ?, COMP_GEST = ?, NRO_GEST_SEGU_1 = ?, NRO_CONC_SEGU_1 = ?, MONT_SEGU_1 = ?, NRO_GEST_SEGU_2 = ?, NRO_CONC_SEGU_2 = ?, MONT_SEGU_2 = ?, FEC_REGI = ?, FEC_SEGU_1 = ?, FEC_SEGU_2 = ?, USU_REGI = ?, FEC_ACTU = ?, USU_ACTU = ? WHERE COD_CAMP_DETA = ? AND COD_CAMP = ? AND ANHO = ? AND MES = ? AND COD_OFIC = ? AND COD_TERR = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column COD_CAMP_DETA
			// For column COD_CAMP_DETA
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(17,tempInteger.intValue());
				else
					pstmt.setNull(17,java.sql.Types.DECIMAL);
			}
			// For column NOM_CAMP
			// For column NOM_CAMP
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_GEST
			// For column COD_GEST
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column NRO_CLIE
			// For column NRO_CLIE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(3);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(3,tempBigDecimal);
				else
					pstmt.setNull(3,java.sql.Types.DECIMAL);
			}
			// For column COMP_GEST
			// For column COMP_GEST
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(4);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(4,tempBigDecimal);
				else
					pstmt.setNull(4,java.sql.Types.DECIMAL);
			}
			// For column NRO_GEST_SEGU_1
			// For column NRO_GEST_SEGU_1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(5,tempBigDecimal);
				else
					pstmt.setNull(5,java.sql.Types.DECIMAL);
			}
			// For column NRO_CONC_SEGU_1
			// For column NRO_CONC_SEGU_1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(6);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(6,tempBigDecimal);
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
			}
			// For column MONT_SEGU_1
			// For column MONT_SEGU_1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(7,tempBigDecimal);
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
			}
			// For column NRO_GEST_SEGU_2
			// For column NRO_GEST_SEGU_2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(8);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(8,tempBigDecimal);
				else
					pstmt.setNull(8,java.sql.Types.DECIMAL);
			}
			// For column NRO_CONC_SEGU_2
			// For column NRO_CONC_SEGU_2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(9);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(9,tempBigDecimal);
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column MONT_SEGU_2
			// For column MONT_SEGU_2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(10,tempBigDecimal);
				else
					pstmt.setNull(10,java.sql.Types.DECIMAL);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(11);
				if(tempDate != null)
					pstmt.setDate(11,tempDate);
				else
					pstmt.setNull(11,java.sql.Types.DATE);
			}
			// For column FEC_SEGU_1
			// For column FEC_SEGU_1
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(12);
				if(tempDate != null)
					pstmt.setDate(12,tempDate);
				else
					pstmt.setNull(12,java.sql.Types.DATE);
			}
			// For column FEC_SEGU_2
			// For column FEC_SEGU_2
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(13);
				if(tempDate != null)
					pstmt.setDate(13,tempDate);
				else
					pstmt.setNull(13,java.sql.Types.DATE);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(15);
				if(tempDate != null)
					pstmt.setDate(15,tempDate);
				else
					pstmt.setNull(15,java.sql.Types.DATE);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.VARCHAR);
			}
			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(17);
				if(tempInteger != null)
					pstmt.setInt(18,tempInteger.intValue());
				else
					pstmt.setNull(18,java.sql.Types.DECIMAL);
			}
			// For column ANHO
			// For column ANHO
			{
				String tempString;


				tempString=(String)inputRecord.get(18);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.VARCHAR);
			}
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(20,tempString);
				else
					pstmt.setNull(20,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(20);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.VARCHAR);
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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.COD_CAMP_DETA, T1.NOM_CAMP, T1.COD_GEST, T1.NRO_CLIE, T1.COMP_GEST, T1.NRO_GEST_SEGU_1, T1.NRO_CONC_SEGU_1, T1.MONT_SEGU_1, T1.NRO_GEST_SEGU_2, T1.NRO_CONC_SEGU_2, T1.MONT_SEGU_2, T1.FEC_REGI, T1.FEC_SEGU_1, T1.FEC_SEGU_2, T1.USU_REGI, T1.FEC_ACTU, T1.USU_ACTU, T1.COD_CAMP, T1.ANHO, T1.MES, T1.COD_OFIC, T1.COD_TERR FROM IIDO.TIIDO_CAMPANIAS_DETALLE  T1 WHERE T1.COD_CAMP_DETA = ? AND T1.COD_CAMP = ? AND T1.ANHO = ? AND T1.MES = ? AND T1.COD_OFIC = ? AND T1.COD_TERR = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column COD_CAMP_DETA
			// For column COD_CAMP_DETA
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.DECIMAL);
			}
			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.DECIMAL);
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
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.COD_CAMP_DETA, T1.NOM_CAMP, T1.COD_GEST, T1.NRO_CLIE, T1.COMP_GEST, T1.NRO_GEST_SEGU_1, T1.NRO_CONC_SEGU_1, T1.MONT_SEGU_1, T1.NRO_GEST_SEGU_2, T1.NRO_CONC_SEGU_2, T1.MONT_SEGU_2, T1.FEC_REGI, T1.FEC_SEGU_1, T1.FEC_SEGU_2, T1.USU_REGI, T1.FEC_ACTU, T1.USU_ACTU, T1.COD_CAMP, T1.ANHO, T1.MES, T1.COD_OFIC, T1.COD_TERR FROM IIDO.TIIDO_CAMPANIAS_DETALLE  T1 WHERE T1.COD_CAMP_DETA = ? AND T1.COD_CAMP = ? AND T1.ANHO = ? AND T1.MES = ? AND T1.COD_OFIC = ? AND T1.COD_TERR = ? FOR UPDATE ";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column COD_CAMP_DETA
			// For column COD_CAMP_DETA
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.DECIMAL);
			}
			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.DECIMAL);
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
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
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
	private static String findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_LocalQuery_0 = " SELECT T1.COD_CAMP_DETA, T1.NOM_CAMP, T1.COD_GEST, T1.NRO_CLIE, T1.COMP_GEST, T1.NRO_GEST_SEGU_1, T1.NRO_CONC_SEGU_1, T1.MONT_SEGU_1, T1.NRO_GEST_SEGU_2, T1.NRO_CONC_SEGU_2, T1.MONT_SEGU_2, T1.FEC_REGI, T1.FEC_SEGU_1, T1.FEC_SEGU_2, T1.USU_REGI, T1.FEC_ACTU, T1.USU_ACTU, T1.COD_CAMP, T1.ANHO, T1.MES, T1.COD_OFIC, T1.COD_TERR FROM IIDO.TIIDO_CAMPANIAS_DETALLE  T1 WHERE T1.COD_CAMP = ? AND T1.ANHO = ? AND T1.MES = ? AND T1.COD_OFIC = ? AND T1.COD_TERR = ?";
	/**
	 * findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local
	 */
	public javax.resource.cci.Record findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_LocalQuery_0);

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
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_LocalQuery_0);

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
	private static String findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_LocalForUpdateQuery_0 = " SELECT T1.COD_CAMP_DETA, T1.NOM_CAMP, T1.COD_GEST, T1.NRO_CLIE, T1.COMP_GEST, T1.NRO_GEST_SEGU_1, T1.NRO_CONC_SEGU_1, T1.MONT_SEGU_1, T1.NRO_GEST_SEGU_2, T1.NRO_CONC_SEGU_2, T1.MONT_SEGU_2, T1.FEC_REGI, T1.FEC_SEGU_1, T1.FEC_SEGU_2, T1.USU_REGI, T1.FEC_ACTU, T1.USU_ACTU, T1.COD_CAMP, T1.ANHO, T1.MES, T1.COD_OFIC, T1.COD_TERR FROM IIDO.TIIDO_CAMPANIAS_DETALLE  T1 WHERE T1.COD_CAMP = ? AND T1.ANHO = ? AND T1.MES = ? AND T1.COD_OFIC = ? AND T1.COD_TERR = ? FOR UPDATE ";
	/**
	 * findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local444Update
	 */
	public javax.resource.cci.Record findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_LocalForUpdateQuery_0);

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
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_LocalForUpdateQuery_0);

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
	 * Tiido_campanias_detalleBeanFunctionSet_6826fb65
	 */
	public Tiido_campanias_detalleBeanFunctionSet_6826fb65() {
		functionHash=new java.util.HashMap(12);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByPrimaryKey",new Integer(4));
		functionHash.put("FindByPrimaryKey444Update",new Integer(5));
		functionHash.put("findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local",new Integer(6));
		functionHash.put("findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local444Update",new Integer(7));
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
			outputRecord=findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=findTiido_campanias_detalleByTiido_camdet_campanias_fkKey_Local444Update(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM IIDO.TIIDO_CAMPANIAS_DETALLE  T1 WHERE T1.COD_CAMP_DETA = ? AND T1.COD_CAMP = ? AND T1.ANHO = ? AND T1.MES = ? AND T1.COD_OFIC = ? AND T1.COD_TERR = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column COD_CAMP_DETA
			// For column COD_CAMP_DETA
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.DECIMAL);
			}
			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.DECIMAL);
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
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM IIDO.TIIDO_CAMPANIAS_DETALLE  T1 WHERE T1.COD_CAMP_DETA = ? AND T1.COD_CAMP = ? AND T1.ANHO = ? AND T1.MES = ? AND T1.COD_OFIC = ? AND T1.COD_TERR = ? FOR UPDATE ";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column COD_CAMP_DETA
			// For column COD_CAMP_DETA
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.DECIMAL);
			}
			// For column COD_CAMP
			// For column COD_CAMP
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.DECIMAL);
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
			// For column MES
			// For column MES
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
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
		updateTemplateList = Tiido_campanias_detalleBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column NOM_CAMP
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
						// For column COD_GEST
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
						// For column NRO_CLIE
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(3);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column COMP_GEST
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(4);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column NRO_GEST_SEGU_1
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
						// For column NRO_CONC_SEGU_1
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(6);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column MONT_SEGU_1
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column NRO_GEST_SEGU_2
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(8);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column NRO_CONC_SEGU_2
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(9);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column MONT_SEGU_2
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column FEC_REGI
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(11);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column FEC_SEGU_1
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(12);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column FEC_SEGU_2
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(13);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column USU_REGI
						String tempString;


						tempString=(String)inputRecord.get(14);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column FEC_ACTU
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(15);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column USU_ACTU
						String tempString;


						tempString=(String)inputRecord.get(16);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_CAMP_DETA
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column COD_CAMP
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(17);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column ANHO
						String tempString;


						tempString=(String)inputRecord.get(18);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column MES
						String tempString;


						tempString=(String)inputRecord.get(19);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_OFIC
						String tempString;


						tempString=(String)inputRecord.get(20);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERR
						String tempString;


						tempString=(String)inputRecord.get(21);
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
						// For column NOM_CAMP
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
						// For column COD_GEST
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
						// For column NRO_CLIE
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(3);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column COMP_GEST
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(4);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column NRO_GEST_SEGU_1
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
						// For column NRO_CONC_SEGU_1
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(6);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column MONT_SEGU_1
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column NRO_GEST_SEGU_2
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(8);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column NRO_CONC_SEGU_2
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(9);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column MONT_SEGU_2
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column FEC_REGI
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(11);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column FEC_SEGU_1
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(12);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column FEC_SEGU_2
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(13);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column USU_REGI
						String tempString;


						tempString=(String)inputRecord.get(14);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column FEC_ACTU
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(15);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column USU_ACTU
						String tempString;


						tempString=(String)inputRecord.get(16);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_CAMP_DETA
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column COD_CAMP
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(17);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column ANHO
						String tempString;


						tempString=(String)inputRecord.get(18);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column MES
						String tempString;


						tempString=(String)inputRecord.get(19);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_OFIC
						String tempString;


						tempString=(String)inputRecord.get(20);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERR
						String tempString;


						tempString=(String)inputRecord.get(21);
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
