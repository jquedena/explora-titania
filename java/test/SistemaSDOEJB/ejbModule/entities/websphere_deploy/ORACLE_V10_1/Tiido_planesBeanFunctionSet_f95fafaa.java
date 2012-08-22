package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * Tiido_planesBeanFunctionSet_f95fafaa
 */
public class Tiido_planesBeanFunctionSet_f95fafaa extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO IIDO.TIIDO_PLANES (MES_PLAN, ANHO_PLAN, COD_EPIGRAFE, COD_TERR, COD_OFIC, NOM_EPIGRAFE, PESO_DOR, MONTO, PORC_ALCANZADO, DESV_PPTO, NRO_MESES_FALT, PROY_CREC_MEN, AJUSTE_ESTIMADO_TERR, PROY_AJUSTE_MEN, SALDMEDI_JUNIO, PORC_SALDMEDI_JUNIO, SALD_DIC_ANTE, SALDMEDI_DIC, COD_TERRI, PORC_SALDMEDI_DIC, FAC_AJU_SAL_PUN, HIST_BAJAS, MET_MESSALD_PUNT, MET_GER_OFI, PRIORIDAD, MES_EVAL, IND_DOR, VAR_MES, AJUS_PPTO, DESV_PPTO_AJUS, FACT_AJUS_TERRI, FACT_ASIG_GTE_OF, FEC_ACTU, USU_REGI, USU_ACTU, FEC_REGI) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column MES_PLAN
			// For column MES_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ANHO_PLAN
			// For column ANHO_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column NOM_EPIGRAFE
			// For column NOM_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column PESO_DOR
			// For column PESO_DOR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(4);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(7,tempBigDecimal);
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
			}
			// For column MONTO
			// For column MONTO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(8,tempBigDecimal);
				else
					pstmt.setNull(8,java.sql.Types.DECIMAL);
			}
			// For column PORC_ALCANZADO
			// For column PORC_ALCANZADO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(6);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(9,tempBigDecimal);
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column DESV_PPTO
			// For column DESV_PPTO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(10,tempBigDecimal);
				else
					pstmt.setNull(10,java.sql.Types.DECIMAL);
			}
			// For column NRO_MESES_FALT
			// For column NRO_MESES_FALT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(8);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(11,tempBigDecimal);
				else
					pstmt.setNull(11,java.sql.Types.DECIMAL);
			}
			// For column PROY_CREC_MEN
			// For column PROY_CREC_MEN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(9);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(12,tempBigDecimal);
				else
					pstmt.setNull(12,java.sql.Types.DECIMAL);
			}
			// For column AJUSTE_ESTIMADO_TERR
			// For column AJUSTE_ESTIMADO_TERR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(13,tempBigDecimal);
				else
					pstmt.setNull(13,java.sql.Types.DECIMAL);
			}
			// For column PROY_AJUSTE_MEN
			// For column PROY_AJUSTE_MEN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(14,tempBigDecimal);
				else
					pstmt.setNull(14,java.sql.Types.DECIMAL);
			}
			// For column SALDMEDI_JUNIO
			// For column SALDMEDI_JUNIO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(12);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(15,tempBigDecimal);
				else
					pstmt.setNull(15,java.sql.Types.DECIMAL);
			}
			// For column PORC_SALDMEDI_JUNIO
			// For column PORC_SALDMEDI_JUNIO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(13);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(16,tempBigDecimal);
				else
					pstmt.setNull(16,java.sql.Types.DECIMAL);
			}
			// For column SALD_DIC_ANTE
			// For column SALD_DIC_ANTE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(14);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(17,tempBigDecimal);
				else
					pstmt.setNull(17,java.sql.Types.DECIMAL);
			}
			// For column SALDMEDI_DIC
			// For column SALDMEDI_DIC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(15);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(18,tempBigDecimal);
				else
					pstmt.setNull(18,java.sql.Types.DECIMAL);
			}
			// For column COD_TERRI
			// For column COD_TERRI
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.VARCHAR);
			}
			// For column PORC_SALDMEDI_DIC
			// For column PORC_SALDMEDI_DIC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(17);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(20,tempBigDecimal);
				else
					pstmt.setNull(20,java.sql.Types.DECIMAL);
			}
			// For column FAC_AJU_SAL_PUN
			// For column FAC_AJU_SAL_PUN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(18);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(21,tempBigDecimal);
				else
					pstmt.setNull(21,java.sql.Types.DECIMAL);
			}
			// For column HIST_BAJAS
			// For column HIST_BAJAS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(19);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(22,tempBigDecimal);
				else
					pstmt.setNull(22,java.sql.Types.DECIMAL);
			}
			// For column MET_MESSALD_PUNT
			// For column MET_MESSALD_PUNT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(20);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(23,tempBigDecimal);
				else
					pstmt.setNull(23,java.sql.Types.DECIMAL);
			}
			// For column MET_GER_OFI
			// For column MET_GER_OFI
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(21);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(24,tempBigDecimal);
				else
					pstmt.setNull(24,java.sql.Types.DECIMAL);
			}
			// For column PRIORIDAD
			// For column PRIORIDAD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(22);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(25,tempBigDecimal);
				else
					pstmt.setNull(25,java.sql.Types.DECIMAL);
			}
			// For column MES_EVAL
			// For column MES_EVAL
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(26,tempString);
				else
					pstmt.setNull(26,java.sql.Types.VARCHAR);
			}
			// For column IND_DOR
			// For column IND_DOR
			{
				String tempString;


				tempString=(String)inputRecord.get(24);
				if(tempString != null)
					pstmt.setString(27,tempString);
				else
					pstmt.setNull(27,java.sql.Types.VARCHAR);
			}
			// For column VAR_MES
			// For column VAR_MES
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(25);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(28,tempBigDecimal);
				else
					pstmt.setNull(28,java.sql.Types.DECIMAL);
			}
			// For column AJUS_PPTO
			// For column AJUS_PPTO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(26);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(29,tempBigDecimal);
				else
					pstmt.setNull(29,java.sql.Types.DECIMAL);
			}
			// For column DESV_PPTO_AJUS
			// For column DESV_PPTO_AJUS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(27);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(30,tempBigDecimal);
				else
					pstmt.setNull(30,java.sql.Types.DECIMAL);
			}
			// For column FACT_AJUS_TERRI
			// For column FACT_AJUS_TERRI
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(28);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(31,tempBigDecimal);
				else
					pstmt.setNull(31,java.sql.Types.DECIMAL);
			}
			// For column FACT_ASIG_GTE_OF
			// For column FACT_ASIG_GTE_OF
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(29);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(32,tempBigDecimal);
				else
					pstmt.setNull(32,java.sql.Types.DECIMAL);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(30);
				if(tempTimestamp != null)
					pstmt.setTimestamp(33,tempTimestamp);
				else
					pstmt.setNull(33,java.sql.Types.TIMESTAMP);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(31);
				if(tempString != null)
					pstmt.setString(34,tempString);
				else
					pstmt.setNull(34,java.sql.Types.VARCHAR);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(32);
				if(tempString != null)
					pstmt.setString(35,tempString);
				else
					pstmt.setNull(35,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(33);
				if(tempTimestamp != null)
					pstmt.setTimestamp(36,tempTimestamp);
				else
					pstmt.setNull(36,java.sql.Types.TIMESTAMP);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(34);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(35);
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
	private static String RemoveQuery_0 = "DELETE FROM IIDO.TIIDO_PLANES  WHERE MES_PLAN = ? AND ANHO_PLAN = ? AND COD_EPIGRAFE = ? AND COD_TERR = ? AND COD_OFIC = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column MES_PLAN
			// For column MES_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ANHO_PLAN
			// For column ANHO_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
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


				tempString=(String)inputRecord.get(34);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(35);
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
	private static String StoreQuery_0 = "UPDATE IIDO.TIIDO_PLANES  SET NOM_EPIGRAFE = ?, PESO_DOR = ?, MONTO = ?, PORC_ALCANZADO = ?, DESV_PPTO = ?, NRO_MESES_FALT = ?, PROY_CREC_MEN = ?, AJUSTE_ESTIMADO_TERR = ?, PROY_AJUSTE_MEN = ?, SALDMEDI_JUNIO = ?, PORC_SALDMEDI_JUNIO = ?, SALD_DIC_ANTE = ?, SALDMEDI_DIC = ?, COD_TERRI = ?, PORC_SALDMEDI_DIC = ?, FAC_AJU_SAL_PUN = ?, HIST_BAJAS = ?, MET_MESSALD_PUNT = ?, MET_GER_OFI = ?, PRIORIDAD = ?, MES_EVAL = ?, IND_DOR = ?, VAR_MES = ?, AJUS_PPTO = ?, DESV_PPTO_AJUS = ?, FACT_AJUS_TERRI = ?, FACT_ASIG_GTE_OF = ?, FEC_ACTU = ?, USU_REGI = ?, USU_ACTU = ?, FEC_REGI = ? WHERE MES_PLAN = ? AND ANHO_PLAN = ? AND COD_EPIGRAFE = ? AND COD_TERR = ? AND COD_OFIC = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column MES_PLAN
			// For column MES_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(32,tempString);
				else
					pstmt.setNull(32,java.sql.Types.VARCHAR);
			}
			// For column ANHO_PLAN
			// For column ANHO_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(33,tempString);
				else
					pstmt.setNull(33,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(34,tempString);
				else
					pstmt.setNull(34,java.sql.Types.VARCHAR);
			}
			// For column NOM_EPIGRAFE
			// For column NOM_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column PESO_DOR
			// For column PESO_DOR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(4);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(2,tempBigDecimal);
				else
					pstmt.setNull(2,java.sql.Types.DECIMAL);
			}
			// For column MONTO
			// For column MONTO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(3,tempBigDecimal);
				else
					pstmt.setNull(3,java.sql.Types.DECIMAL);
			}
			// For column PORC_ALCANZADO
			// For column PORC_ALCANZADO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(6);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(4,tempBigDecimal);
				else
					pstmt.setNull(4,java.sql.Types.DECIMAL);
			}
			// For column DESV_PPTO
			// For column DESV_PPTO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(5,tempBigDecimal);
				else
					pstmt.setNull(5,java.sql.Types.DECIMAL);
			}
			// For column NRO_MESES_FALT
			// For column NRO_MESES_FALT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(8);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(6,tempBigDecimal);
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
			}
			// For column PROY_CREC_MEN
			// For column PROY_CREC_MEN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(9);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(7,tempBigDecimal);
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
			}
			// For column AJUSTE_ESTIMADO_TERR
			// For column AJUSTE_ESTIMADO_TERR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(8,tempBigDecimal);
				else
					pstmt.setNull(8,java.sql.Types.DECIMAL);
			}
			// For column PROY_AJUSTE_MEN
			// For column PROY_AJUSTE_MEN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(9,tempBigDecimal);
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column SALDMEDI_JUNIO
			// For column SALDMEDI_JUNIO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(12);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(10,tempBigDecimal);
				else
					pstmt.setNull(10,java.sql.Types.DECIMAL);
			}
			// For column PORC_SALDMEDI_JUNIO
			// For column PORC_SALDMEDI_JUNIO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(13);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(11,tempBigDecimal);
				else
					pstmt.setNull(11,java.sql.Types.DECIMAL);
			}
			// For column SALD_DIC_ANTE
			// For column SALD_DIC_ANTE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(14);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(12,tempBigDecimal);
				else
					pstmt.setNull(12,java.sql.Types.DECIMAL);
			}
			// For column SALDMEDI_DIC
			// For column SALDMEDI_DIC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(15);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(13,tempBigDecimal);
				else
					pstmt.setNull(13,java.sql.Types.DECIMAL);
			}
			// For column COD_TERRI
			// For column COD_TERRI
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.VARCHAR);
			}
			// For column PORC_SALDMEDI_DIC
			// For column PORC_SALDMEDI_DIC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(17);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(15,tempBigDecimal);
				else
					pstmt.setNull(15,java.sql.Types.DECIMAL);
			}
			// For column FAC_AJU_SAL_PUN
			// For column FAC_AJU_SAL_PUN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(18);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(16,tempBigDecimal);
				else
					pstmt.setNull(16,java.sql.Types.DECIMAL);
			}
			// For column HIST_BAJAS
			// For column HIST_BAJAS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(19);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(17,tempBigDecimal);
				else
					pstmt.setNull(17,java.sql.Types.DECIMAL);
			}
			// For column MET_MESSALD_PUNT
			// For column MET_MESSALD_PUNT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(20);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(18,tempBigDecimal);
				else
					pstmt.setNull(18,java.sql.Types.DECIMAL);
			}
			// For column MET_GER_OFI
			// For column MET_GER_OFI
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(21);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(19,tempBigDecimal);
				else
					pstmt.setNull(19,java.sql.Types.DECIMAL);
			}
			// For column PRIORIDAD
			// For column PRIORIDAD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(22);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(20,tempBigDecimal);
				else
					pstmt.setNull(20,java.sql.Types.DECIMAL);
			}
			// For column MES_EVAL
			// For column MES_EVAL
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.VARCHAR);
			}
			// For column IND_DOR
			// For column IND_DOR
			{
				String tempString;


				tempString=(String)inputRecord.get(24);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.VARCHAR);
			}
			// For column VAR_MES
			// For column VAR_MES
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(25);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(23,tempBigDecimal);
				else
					pstmt.setNull(23,java.sql.Types.DECIMAL);
			}
			// For column AJUS_PPTO
			// For column AJUS_PPTO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(26);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(24,tempBigDecimal);
				else
					pstmt.setNull(24,java.sql.Types.DECIMAL);
			}
			// For column DESV_PPTO_AJUS
			// For column DESV_PPTO_AJUS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(27);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(25,tempBigDecimal);
				else
					pstmt.setNull(25,java.sql.Types.DECIMAL);
			}
			// For column FACT_AJUS_TERRI
			// For column FACT_AJUS_TERRI
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(28);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(26,tempBigDecimal);
				else
					pstmt.setNull(26,java.sql.Types.DECIMAL);
			}
			// For column FACT_ASIG_GTE_OF
			// For column FACT_ASIG_GTE_OF
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(29);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(27,tempBigDecimal);
				else
					pstmt.setNull(27,java.sql.Types.DECIMAL);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(30);
				if(tempTimestamp != null)
					pstmt.setTimestamp(28,tempTimestamp);
				else
					pstmt.setNull(28,java.sql.Types.TIMESTAMP);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(31);
				if(tempString != null)
					pstmt.setString(29,tempString);
				else
					pstmt.setNull(29,java.sql.Types.VARCHAR);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(32);
				if(tempString != null)
					pstmt.setString(30,tempString);
				else
					pstmt.setNull(30,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(33);
				if(tempTimestamp != null)
					pstmt.setTimestamp(31,tempTimestamp);
				else
					pstmt.setNull(31,java.sql.Types.TIMESTAMP);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(34);
				if(tempString != null)
					pstmt.setString(36,tempString);
				else
					pstmt.setNull(36,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(35);
				if(tempString != null)
					pstmt.setString(35,tempString);
				else
					pstmt.setNull(35,java.sql.Types.VARCHAR);
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
	private static String StoreOCCQuery_0 = "UPDATE IIDO.TIIDO_PLANES  SET NOM_EPIGRAFE = ?, PESO_DOR = ?, MONTO = ?, PORC_ALCANZADO = ?, DESV_PPTO = ?, NRO_MESES_FALT = ?, PROY_CREC_MEN = ?, AJUSTE_ESTIMADO_TERR = ?, PROY_AJUSTE_MEN = ?, SALDMEDI_JUNIO = ?, PORC_SALDMEDI_JUNIO = ?, SALD_DIC_ANTE = ?, SALDMEDI_DIC = ?, COD_TERRI = ?, PORC_SALDMEDI_DIC = ?, FAC_AJU_SAL_PUN = ?, HIST_BAJAS = ?, MET_MESSALD_PUNT = ?, MET_GER_OFI = ?, PRIORIDAD = ?, MES_EVAL = ?, IND_DOR = ?, VAR_MES = ?, AJUS_PPTO = ?, DESV_PPTO_AJUS = ?, FACT_AJUS_TERRI = ?, FACT_ASIG_GTE_OF = ?, FEC_ACTU = ?, USU_REGI = ?, USU_ACTU = ?, FEC_REGI = ? WHERE MES_PLAN = ? AND ANHO_PLAN = ? AND COD_EPIGRAFE = ? AND COD_TERR = ? AND COD_OFIC = ? AND FEC_ACTU = ? AND USU_REGI = ? AND USU_ACTU = ? AND FEC_REGI = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column MES_PLAN
			// For column MES_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(32,tempString);
				else
					pstmt.setNull(32,java.sql.Types.VARCHAR);
			}
			// For column ANHO_PLAN
			// For column ANHO_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(33,tempString);
				else
					pstmt.setNull(33,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(34,tempString);
				else
					pstmt.setNull(34,java.sql.Types.VARCHAR);
			}
			// For column NOM_EPIGRAFE
			// For column NOM_EPIGRAFE
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column PESO_DOR
			// For column PESO_DOR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(4);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(2,tempBigDecimal);
				else
					pstmt.setNull(2,java.sql.Types.DECIMAL);
			}
			// For column MONTO
			// For column MONTO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(3,tempBigDecimal);
				else
					pstmt.setNull(3,java.sql.Types.DECIMAL);
			}
			// For column PORC_ALCANZADO
			// For column PORC_ALCANZADO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(6);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(4,tempBigDecimal);
				else
					pstmt.setNull(4,java.sql.Types.DECIMAL);
			}
			// For column DESV_PPTO
			// For column DESV_PPTO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(5,tempBigDecimal);
				else
					pstmt.setNull(5,java.sql.Types.DECIMAL);
			}
			// For column NRO_MESES_FALT
			// For column NRO_MESES_FALT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(8);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(6,tempBigDecimal);
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
			}
			// For column PROY_CREC_MEN
			// For column PROY_CREC_MEN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(9);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(7,tempBigDecimal);
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
			}
			// For column AJUSTE_ESTIMADO_TERR
			// For column AJUSTE_ESTIMADO_TERR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(8,tempBigDecimal);
				else
					pstmt.setNull(8,java.sql.Types.DECIMAL);
			}
			// For column PROY_AJUSTE_MEN
			// For column PROY_AJUSTE_MEN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(9,tempBigDecimal);
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column SALDMEDI_JUNIO
			// For column SALDMEDI_JUNIO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(12);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(10,tempBigDecimal);
				else
					pstmt.setNull(10,java.sql.Types.DECIMAL);
			}
			// For column PORC_SALDMEDI_JUNIO
			// For column PORC_SALDMEDI_JUNIO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(13);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(11,tempBigDecimal);
				else
					pstmt.setNull(11,java.sql.Types.DECIMAL);
			}
			// For column SALD_DIC_ANTE
			// For column SALD_DIC_ANTE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(14);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(12,tempBigDecimal);
				else
					pstmt.setNull(12,java.sql.Types.DECIMAL);
			}
			// For column SALDMEDI_DIC
			// For column SALDMEDI_DIC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(15);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(13,tempBigDecimal);
				else
					pstmt.setNull(13,java.sql.Types.DECIMAL);
			}
			// For column COD_TERRI
			// For column COD_TERRI
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.VARCHAR);
			}
			// For column PORC_SALDMEDI_DIC
			// For column PORC_SALDMEDI_DIC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(17);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(15,tempBigDecimal);
				else
					pstmt.setNull(15,java.sql.Types.DECIMAL);
			}
			// For column FAC_AJU_SAL_PUN
			// For column FAC_AJU_SAL_PUN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(18);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(16,tempBigDecimal);
				else
					pstmt.setNull(16,java.sql.Types.DECIMAL);
			}
			// For column HIST_BAJAS
			// For column HIST_BAJAS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(19);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(17,tempBigDecimal);
				else
					pstmt.setNull(17,java.sql.Types.DECIMAL);
			}
			// For column MET_MESSALD_PUNT
			// For column MET_MESSALD_PUNT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(20);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(18,tempBigDecimal);
				else
					pstmt.setNull(18,java.sql.Types.DECIMAL);
			}
			// For column MET_GER_OFI
			// For column MET_GER_OFI
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(21);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(19,tempBigDecimal);
				else
					pstmt.setNull(19,java.sql.Types.DECIMAL);
			}
			// For column PRIORIDAD
			// For column PRIORIDAD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(22);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(20,tempBigDecimal);
				else
					pstmt.setNull(20,java.sql.Types.DECIMAL);
			}
			// For column MES_EVAL
			// For column MES_EVAL
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.VARCHAR);
			}
			// For column IND_DOR
			// For column IND_DOR
			{
				String tempString;


				tempString=(String)inputRecord.get(24);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.VARCHAR);
			}
			// For column VAR_MES
			// For column VAR_MES
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(25);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(23,tempBigDecimal);
				else
					pstmt.setNull(23,java.sql.Types.DECIMAL);
			}
			// For column AJUS_PPTO
			// For column AJUS_PPTO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(26);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(24,tempBigDecimal);
				else
					pstmt.setNull(24,java.sql.Types.DECIMAL);
			}
			// For column DESV_PPTO_AJUS
			// For column DESV_PPTO_AJUS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(27);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(25,tempBigDecimal);
				else
					pstmt.setNull(25,java.sql.Types.DECIMAL);
			}
			// For column FACT_AJUS_TERRI
			// For column FACT_AJUS_TERRI
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(28);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(26,tempBigDecimal);
				else
					pstmt.setNull(26,java.sql.Types.DECIMAL);
			}
			// For column FACT_ASIG_GTE_OF
			// For column FACT_ASIG_GTE_OF
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(29);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(27,tempBigDecimal);
				else
					pstmt.setNull(27,java.sql.Types.DECIMAL);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(30);
				if(tempTimestamp != null)
					pstmt.setTimestamp(28,tempTimestamp);
				else
					pstmt.setNull(28,java.sql.Types.TIMESTAMP);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(31);
				if(tempString != null)
					pstmt.setString(29,tempString);
				else
					pstmt.setNull(29,java.sql.Types.VARCHAR);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(32);
				if(tempString != null)
					pstmt.setString(30,tempString);
				else
					pstmt.setNull(30,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(33);
				if(tempTimestamp != null)
					pstmt.setTimestamp(31,tempTimestamp);
				else
					pstmt.setNull(31,java.sql.Types.TIMESTAMP);
			}
			// For column COD_OFIC
			// For column COD_OFIC
			{
				String tempString;


				tempString=(String)inputRecord.get(34);
				if(tempString != null)
					pstmt.setString(36,tempString);
				else
					pstmt.setNull(36,java.sql.Types.VARCHAR);
			}
			// For column COD_TERR
			// For column COD_TERR
			{
				String tempString;


				tempString=(String)inputRecord.get(35);
				if(tempString != null)
					pstmt.setString(35,tempString);
				else
					pstmt.setNull(35,java.sql.Types.VARCHAR);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column FEC_ACTU
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)oldRecord.get(30);
				if(tempTimestamp != null)
					pstmt.setTimestamp(37,tempTimestamp);
				else
					pstmt.setNull(37,java.sql.Types.TIMESTAMP);
			}
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)oldRecord.get(31);
				if(tempString != null)
					pstmt.setString(38,tempString);
				else
					pstmt.setNull(38,java.sql.Types.VARCHAR);
			}
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)oldRecord.get(32);
				if(tempString != null)
					pstmt.setString(39,tempString);
				else
					pstmt.setNull(39,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)oldRecord.get(33);
				if(tempTimestamp != null)
					pstmt.setTimestamp(40,tempTimestamp);
				else
					pstmt.setNull(40,java.sql.Types.TIMESTAMP);
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
	private static String findConsultaPlanesQuery_0 = " select  q1.\"MES_PLAN\",  q1.\"ANHO_PLAN\",  q1.\"COD_EPIGRAFE\",  q1.\"NOM_EPIGRAFE\",  q1.\"PESO_DOR\",  q1.\"MONTO\",  q1.\"PORC_ALCANZADO\",  q1.\"DESV_PPTO\",  q1.\"NRO_MESES_FALT\",  q1.\"PROY_CREC_MEN\",  q1.\"AJUSTE_ESTIMADO_TERR\",  q1.\"PROY_AJUSTE_MEN\",  q1.\"SALDMEDI_JUNIO\",  q1.\"PORC_SALDMEDI_JUNIO\",  q1.\"SALD_DIC_ANTE\",  q1.\"SALDMEDI_DIC\",  q1.\"COD_TERRI\",  q1.\"PORC_SALDMEDI_DIC\",  q1.\"FAC_AJU_SAL_PUN\",  q1.\"HIST_BAJAS\",  q1.\"MET_MESSALD_PUNT\",  q1.\"MET_GER_OFI\",  q1.\"PRIORIDAD\",  q1.\"MES_EVAL\",  q1.\"IND_DOR\",  q1.\"VAR_MES\",  q1.\"AJUS_PPTO\",  q1.\"DESV_PPTO_AJUS\",  q1.\"FACT_AJUS_TERRI\",  q1.\"FACT_ASIG_GTE_OF\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_REGI\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_PLANES q1 inner join IIDO.TIIDO_OFICINA q2 on ( ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  AND  ( q2.\"COD_OFIC\" =  q1.\"COD_OFIC\") ) where  ( q2.\"COD_OFIC\" LIKE ?)  and  ( q1.\"ANHO_PLAN\" = ?)  and  ( q1.\"MES_PLAN\" = ?) ";
	/**
	 * FindConsultaPlanes
	 */
	public javax.resource.cci.Record FindConsultaPlanes(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_planes o where o.tiido_pla_oficina_fk.cod_ofic like ?1 and o.anho_plan = ?2 and o.mes_plan = ?3 */
			pstmt = prepareStatement(connection, findConsultaPlanesQuery_0);

			// For ?1 (codOficina)
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
			// For ?3 (mes)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findConsultaPlanesQuery_0);

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
	private static String findConsultaPlanesForUpdateQuery_0 = " select  q1.\"MES_PLAN\",  q1.\"ANHO_PLAN\",  q1.\"COD_EPIGRAFE\",  q1.\"NOM_EPIGRAFE\",  q1.\"PESO_DOR\",  q1.\"MONTO\",  q1.\"PORC_ALCANZADO\",  q1.\"DESV_PPTO\",  q1.\"NRO_MESES_FALT\",  q1.\"PROY_CREC_MEN\",  q1.\"AJUSTE_ESTIMADO_TERR\",  q1.\"PROY_AJUSTE_MEN\",  q1.\"SALDMEDI_JUNIO\",  q1.\"PORC_SALDMEDI_JUNIO\",  q1.\"SALD_DIC_ANTE\",  q1.\"SALDMEDI_DIC\",  q1.\"COD_TERRI\",  q1.\"PORC_SALDMEDI_DIC\",  q1.\"FAC_AJU_SAL_PUN\",  q1.\"HIST_BAJAS\",  q1.\"MET_MESSALD_PUNT\",  q1.\"MET_GER_OFI\",  q1.\"PRIORIDAD\",  q1.\"MES_EVAL\",  q1.\"IND_DOR\",  q1.\"VAR_MES\",  q1.\"AJUS_PPTO\",  q1.\"DESV_PPTO_AJUS\",  q1.\"FACT_AJUS_TERRI\",  q1.\"FACT_ASIG_GTE_OF\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_REGI\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_PLANES q1 inner join IIDO.TIIDO_OFICINA q2 on ( ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  AND  ( q2.\"COD_OFIC\" =  q1.\"COD_OFIC\") ) where  ( q2.\"COD_OFIC\" LIKE ?)  and  ( q1.\"ANHO_PLAN\" = ?)  and  ( q1.\"MES_PLAN\" = ?)  for update ";
	/**
	 * FindConsultaPlanes444Update
	 */
	public javax.resource.cci.Record FindConsultaPlanes444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_planes o where o.tiido_pla_oficina_fk.cod_ofic like ?1 and o.anho_plan = ?2 and o.mes_plan = ?3 */
			pstmt = prepareStatement(connection, findConsultaPlanesForUpdateQuery_0);

			// For ?1 (codOficina)
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
			// For ?3 (mes)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findConsultaPlanesForUpdateQuery_0);

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
	private static String findConsultaPlanesPrioridadQuery_0 = " select  q1.\"MES_PLAN\",  q1.\"ANHO_PLAN\",  q1.\"COD_EPIGRAFE\",  q1.\"NOM_EPIGRAFE\",  q1.\"PESO_DOR\",  q1.\"MONTO\",  q1.\"PORC_ALCANZADO\",  q1.\"DESV_PPTO\",  q1.\"NRO_MESES_FALT\",  q1.\"PROY_CREC_MEN\",  q1.\"AJUSTE_ESTIMADO_TERR\",  q1.\"PROY_AJUSTE_MEN\",  q1.\"SALDMEDI_JUNIO\",  q1.\"PORC_SALDMEDI_JUNIO\",  q1.\"SALD_DIC_ANTE\",  q1.\"SALDMEDI_DIC\",  q1.\"COD_TERRI\",  q1.\"PORC_SALDMEDI_DIC\",  q1.\"FAC_AJU_SAL_PUN\",  q1.\"HIST_BAJAS\",  q1.\"MET_MESSALD_PUNT\",  q1.\"MET_GER_OFI\",  q1.\"PRIORIDAD\",  q1.\"MES_EVAL\",  q1.\"IND_DOR\",  q1.\"VAR_MES\",  q1.\"AJUS_PPTO\",  q1.\"DESV_PPTO_AJUS\",  q1.\"FACT_AJUS_TERRI\",  q1.\"FACT_ASIG_GTE_OF\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_REGI\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_PLANES q1 inner join IIDO.TIIDO_OFICINA q2 on ( ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  AND  ( q2.\"COD_OFIC\" =  q1.\"COD_OFIC\") ) where  ( q1.\"MES_PLAN\" = ?)  and  ( q1.\"ANHO_PLAN\" = ?)  and  ( q1.\"COD_EPIGRAFE\" = ?)  and  ( q2.\"COD_OFIC\" = ?) ";
	/**
	 * FindConsultaPlanesPrioridad
	 */
	public javax.resource.cci.Record FindConsultaPlanesPrioridad(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_planes o where  o.mes_plan = ?1 and  o.anho_plan = ?2 and  o.cod_epigrafe = ?3 and  o.tiido_pla_oficina_fk.cod_ofic = ?4 */
			pstmt = prepareStatement(connection, findConsultaPlanesPrioridadQuery_0);

			// For ?1 (mes)
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
			// For ?3 (codEpigrafe)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (codOficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findConsultaPlanesPrioridadQuery_0);

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
	private static String findConsultaPlanesPrioridadForUpdateQuery_0 = " select  q1.\"MES_PLAN\",  q1.\"ANHO_PLAN\",  q1.\"COD_EPIGRAFE\",  q1.\"NOM_EPIGRAFE\",  q1.\"PESO_DOR\",  q1.\"MONTO\",  q1.\"PORC_ALCANZADO\",  q1.\"DESV_PPTO\",  q1.\"NRO_MESES_FALT\",  q1.\"PROY_CREC_MEN\",  q1.\"AJUSTE_ESTIMADO_TERR\",  q1.\"PROY_AJUSTE_MEN\",  q1.\"SALDMEDI_JUNIO\",  q1.\"PORC_SALDMEDI_JUNIO\",  q1.\"SALD_DIC_ANTE\",  q1.\"SALDMEDI_DIC\",  q1.\"COD_TERRI\",  q1.\"PORC_SALDMEDI_DIC\",  q1.\"FAC_AJU_SAL_PUN\",  q1.\"HIST_BAJAS\",  q1.\"MET_MESSALD_PUNT\",  q1.\"MET_GER_OFI\",  q1.\"PRIORIDAD\",  q1.\"MES_EVAL\",  q1.\"IND_DOR\",  q1.\"VAR_MES\",  q1.\"AJUS_PPTO\",  q1.\"DESV_PPTO_AJUS\",  q1.\"FACT_AJUS_TERRI\",  q1.\"FACT_ASIG_GTE_OF\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_REGI\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_PLANES q1 inner join IIDO.TIIDO_OFICINA q2 on ( ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  AND  ( q2.\"COD_OFIC\" =  q1.\"COD_OFIC\") ) where  ( q1.\"MES_PLAN\" = ?)  and  ( q1.\"ANHO_PLAN\" = ?)  and  ( q1.\"COD_EPIGRAFE\" = ?)  and  ( q2.\"COD_OFIC\" = ?)  for update ";
	/**
	 * FindConsultaPlanesPrioridad444Update
	 */
	public javax.resource.cci.Record FindConsultaPlanesPrioridad444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_planes o where  o.mes_plan = ?1 and  o.anho_plan = ?2 and  o.cod_epigrafe = ?3 and  o.tiido_pla_oficina_fk.cod_ofic = ?4 */
			pstmt = prepareStatement(connection, findConsultaPlanesPrioridadForUpdateQuery_0);

			// For ?1 (mes)
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
			// For ?3 (codEpigrafe)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (codOficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findConsultaPlanesPrioridadForUpdateQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.MES_PLAN, T1.ANHO_PLAN, T1.COD_EPIGRAFE, T1.NOM_EPIGRAFE, T1.PESO_DOR, T1.MONTO, T1.PORC_ALCANZADO, T1.DESV_PPTO, T1.NRO_MESES_FALT, T1.PROY_CREC_MEN, T1.AJUSTE_ESTIMADO_TERR, T1.PROY_AJUSTE_MEN, T1.SALDMEDI_JUNIO, T1.PORC_SALDMEDI_JUNIO, T1.SALD_DIC_ANTE, T1.SALDMEDI_DIC, T1.COD_TERRI, T1.PORC_SALDMEDI_DIC, T1.FAC_AJU_SAL_PUN, T1.HIST_BAJAS, T1.MET_MESSALD_PUNT, T1.MET_GER_OFI, T1.PRIORIDAD, T1.MES_EVAL, T1.IND_DOR, T1.VAR_MES, T1.AJUS_PPTO, T1.DESV_PPTO_AJUS, T1.FACT_AJUS_TERRI, T1.FACT_ASIG_GTE_OF, T1.FEC_ACTU, T1.USU_REGI, T1.USU_ACTU, T1.FEC_REGI, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_PLANES  T1 WHERE T1.MES_PLAN = ? AND T1.ANHO_PLAN = ? AND T1.COD_EPIGRAFE = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column MES_PLAN
			// For column MES_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ANHO_PLAN
			// For column ANHO_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.MES_PLAN, T1.ANHO_PLAN, T1.COD_EPIGRAFE, T1.NOM_EPIGRAFE, T1.PESO_DOR, T1.MONTO, T1.PORC_ALCANZADO, T1.DESV_PPTO, T1.NRO_MESES_FALT, T1.PROY_CREC_MEN, T1.AJUSTE_ESTIMADO_TERR, T1.PROY_AJUSTE_MEN, T1.SALDMEDI_JUNIO, T1.PORC_SALDMEDI_JUNIO, T1.SALD_DIC_ANTE, T1.SALDMEDI_DIC, T1.COD_TERRI, T1.PORC_SALDMEDI_DIC, T1.FAC_AJU_SAL_PUN, T1.HIST_BAJAS, T1.MET_MESSALD_PUNT, T1.MET_GER_OFI, T1.PRIORIDAD, T1.MES_EVAL, T1.IND_DOR, T1.VAR_MES, T1.AJUS_PPTO, T1.DESV_PPTO_AJUS, T1.FACT_AJUS_TERRI, T1.FACT_ASIG_GTE_OF, T1.FEC_ACTU, T1.USU_REGI, T1.USU_ACTU, T1.FEC_REGI, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_PLANES  T1 WHERE T1.MES_PLAN = ? AND T1.ANHO_PLAN = ? AND T1.COD_EPIGRAFE = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ? FOR UPDATE ";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column MES_PLAN
			// For column MES_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ANHO_PLAN
			// For column ANHO_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
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
	private static String findConsultarPlanesxMesQuery_0 = " select  q1.\"MES_PLAN\",  q1.\"ANHO_PLAN\",  q1.\"COD_EPIGRAFE\",  q1.\"NOM_EPIGRAFE\",  q1.\"PESO_DOR\",  q1.\"MONTO\",  q1.\"PORC_ALCANZADO\",  q1.\"DESV_PPTO\",  q1.\"NRO_MESES_FALT\",  q1.\"PROY_CREC_MEN\",  q1.\"AJUSTE_ESTIMADO_TERR\",  q1.\"PROY_AJUSTE_MEN\",  q1.\"SALDMEDI_JUNIO\",  q1.\"PORC_SALDMEDI_JUNIO\",  q1.\"SALD_DIC_ANTE\",  q1.\"SALDMEDI_DIC\",  q1.\"COD_TERRI\",  q1.\"PORC_SALDMEDI_DIC\",  q1.\"FAC_AJU_SAL_PUN\",  q1.\"HIST_BAJAS\",  q1.\"MET_MESSALD_PUNT\",  q1.\"MET_GER_OFI\",  q1.\"PRIORIDAD\",  q1.\"MES_EVAL\",  q1.\"IND_DOR\",  q1.\"VAR_MES\",  q1.\"AJUS_PPTO\",  q1.\"DESV_PPTO_AJUS\",  q1.\"FACT_AJUS_TERRI\",  q1.\"FACT_ASIG_GTE_OF\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_REGI\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_PLANES q1 inner join IIDO.TIIDO_OFICINA q2 on ( ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  AND  ( q2.\"COD_OFIC\" =  q1.\"COD_OFIC\") ) where  ( q2.\"COD_OFIC\" = ?)  and  ( q1.\"ANHO_PLAN\" = ?) ";
	/**
	 * FindConsultarPlanesxMes
	 */
	public javax.resource.cci.Record FindConsultarPlanesxMes(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_planes o where  o.tiido_pla_oficina_fk.cod_ofic = ?1 and  o.anho_plan = ?2 */
			pstmt = prepareStatement(connection, findConsultarPlanesxMesQuery_0);

			// For ?1 (codOficina)
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
			result = executeQuery(connection, pstmt, findConsultarPlanesxMesQuery_0);

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
	private static String findConsultarPlanesxMesForUpdateQuery_0 = " select  q1.\"MES_PLAN\",  q1.\"ANHO_PLAN\",  q1.\"COD_EPIGRAFE\",  q1.\"NOM_EPIGRAFE\",  q1.\"PESO_DOR\",  q1.\"MONTO\",  q1.\"PORC_ALCANZADO\",  q1.\"DESV_PPTO\",  q1.\"NRO_MESES_FALT\",  q1.\"PROY_CREC_MEN\",  q1.\"AJUSTE_ESTIMADO_TERR\",  q1.\"PROY_AJUSTE_MEN\",  q1.\"SALDMEDI_JUNIO\",  q1.\"PORC_SALDMEDI_JUNIO\",  q1.\"SALD_DIC_ANTE\",  q1.\"SALDMEDI_DIC\",  q1.\"COD_TERRI\",  q1.\"PORC_SALDMEDI_DIC\",  q1.\"FAC_AJU_SAL_PUN\",  q1.\"HIST_BAJAS\",  q1.\"MET_MESSALD_PUNT\",  q1.\"MET_GER_OFI\",  q1.\"PRIORIDAD\",  q1.\"MES_EVAL\",  q1.\"IND_DOR\",  q1.\"VAR_MES\",  q1.\"AJUS_PPTO\",  q1.\"DESV_PPTO_AJUS\",  q1.\"FACT_AJUS_TERRI\",  q1.\"FACT_ASIG_GTE_OF\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_REGI\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_PLANES q1 inner join IIDO.TIIDO_OFICINA q2 on ( ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  AND  ( q2.\"COD_OFIC\" =  q1.\"COD_OFIC\") ) where  ( q2.\"COD_OFIC\" = ?)  and  ( q1.\"ANHO_PLAN\" = ?)  for update ";
	/**
	 * FindConsultarPlanesxMes444Update
	 */
	public javax.resource.cci.Record FindConsultarPlanesxMes444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_planes o where  o.tiido_pla_oficina_fk.cod_ofic = ?1 and  o.anho_plan = ?2 */
			pstmt = prepareStatement(connection, findConsultarPlanesxMesForUpdateQuery_0);

			// For ?1 (codOficina)
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
			result = executeQuery(connection, pstmt, findConsultarPlanesxMesForUpdateQuery_0);

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
	private static String findConsultaPlanesResumenQuery_0 = " select  q1.\"MES_PLAN\",  q1.\"ANHO_PLAN\",  q1.\"COD_EPIGRAFE\",  q1.\"NOM_EPIGRAFE\",  q1.\"PESO_DOR\",  q1.\"MONTO\",  q1.\"PORC_ALCANZADO\",  q1.\"DESV_PPTO\",  q1.\"NRO_MESES_FALT\",  q1.\"PROY_CREC_MEN\",  q1.\"AJUSTE_ESTIMADO_TERR\",  q1.\"PROY_AJUSTE_MEN\",  q1.\"SALDMEDI_JUNIO\",  q1.\"PORC_SALDMEDI_JUNIO\",  q1.\"SALD_DIC_ANTE\",  q1.\"SALDMEDI_DIC\",  q1.\"COD_TERRI\",  q1.\"PORC_SALDMEDI_DIC\",  q1.\"FAC_AJU_SAL_PUN\",  q1.\"HIST_BAJAS\",  q1.\"MET_MESSALD_PUNT\",  q1.\"MET_GER_OFI\",  q1.\"PRIORIDAD\",  q1.\"MES_EVAL\",  q1.\"IND_DOR\",  q1.\"VAR_MES\",  q1.\"AJUS_PPTO\",  q1.\"DESV_PPTO_AJUS\",  q1.\"FACT_AJUS_TERRI\",  q1.\"FACT_ASIG_GTE_OF\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_REGI\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_PLANES q1 inner join IIDO.TIIDO_OFICINA q2 on ( ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  AND  ( q2.\"COD_OFIC\" =  q1.\"COD_OFIC\") ) where  ( q1.\"MES_PLAN\" = ?)  and  ( q1.\"ANHO_PLAN\" = ?)  and  ( q1.\"COD_EPIGRAFE\" = ?)  and  ( q2.\"COD_OFIC\" = ?) ";
	/**
	 * FindConsultaPlanesResumen
	 */
	public javax.resource.cci.Record FindConsultaPlanesResumen(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_planes o where  o.mes_plan = ?1 and  o.anho_plan = ?2 and  o.cod_epigrafe = ?3 and  o.tiido_pla_oficina_fk.cod_ofic = ?4 */
			pstmt = prepareStatement(connection, findConsultaPlanesResumenQuery_0);

			// For ?1 (mes)
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
			// For ?3 (codEpigrafe)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (codOficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findConsultaPlanesResumenQuery_0);

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
	private static String findConsultaPlanesResumenForUpdateQuery_0 = " select  q1.\"MES_PLAN\",  q1.\"ANHO_PLAN\",  q1.\"COD_EPIGRAFE\",  q1.\"NOM_EPIGRAFE\",  q1.\"PESO_DOR\",  q1.\"MONTO\",  q1.\"PORC_ALCANZADO\",  q1.\"DESV_PPTO\",  q1.\"NRO_MESES_FALT\",  q1.\"PROY_CREC_MEN\",  q1.\"AJUSTE_ESTIMADO_TERR\",  q1.\"PROY_AJUSTE_MEN\",  q1.\"SALDMEDI_JUNIO\",  q1.\"PORC_SALDMEDI_JUNIO\",  q1.\"SALD_DIC_ANTE\",  q1.\"SALDMEDI_DIC\",  q1.\"COD_TERRI\",  q1.\"PORC_SALDMEDI_DIC\",  q1.\"FAC_AJU_SAL_PUN\",  q1.\"HIST_BAJAS\",  q1.\"MET_MESSALD_PUNT\",  q1.\"MET_GER_OFI\",  q1.\"PRIORIDAD\",  q1.\"MES_EVAL\",  q1.\"IND_DOR\",  q1.\"VAR_MES\",  q1.\"AJUS_PPTO\",  q1.\"DESV_PPTO_AJUS\",  q1.\"FACT_AJUS_TERRI\",  q1.\"FACT_ASIG_GTE_OF\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_REGI\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_PLANES q1 inner join IIDO.TIIDO_OFICINA q2 on ( ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  AND  ( q2.\"COD_OFIC\" =  q1.\"COD_OFIC\") ) where  ( q1.\"MES_PLAN\" = ?)  and  ( q1.\"ANHO_PLAN\" = ?)  and  ( q1.\"COD_EPIGRAFE\" = ?)  and  ( q2.\"COD_OFIC\" = ?)  for update ";
	/**
	 * FindConsultaPlanesResumen444Update
	 */
	public javax.resource.cci.Record FindConsultaPlanesResumen444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_planes o where  o.mes_plan = ?1 and  o.anho_plan = ?2 and  o.cod_epigrafe = ?3 and  o.tiido_pla_oficina_fk.cod_ofic = ?4 */
			pstmt = prepareStatement(connection, findConsultaPlanesResumenForUpdateQuery_0);

			// For ?1 (mes)
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
			// For ?3 (codEpigrafe)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (codOficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findConsultaPlanesResumenForUpdateQuery_0);

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
	private static String findPlanByObjectQuery_0 = " select  q1.\"MES_PLAN\",  q1.\"ANHO_PLAN\",  q1.\"COD_EPIGRAFE\",  q1.\"NOM_EPIGRAFE\",  q1.\"PESO_DOR\",  q1.\"MONTO\",  q1.\"PORC_ALCANZADO\",  q1.\"DESV_PPTO\",  q1.\"NRO_MESES_FALT\",  q1.\"PROY_CREC_MEN\",  q1.\"AJUSTE_ESTIMADO_TERR\",  q1.\"PROY_AJUSTE_MEN\",  q1.\"SALDMEDI_JUNIO\",  q1.\"PORC_SALDMEDI_JUNIO\",  q1.\"SALD_DIC_ANTE\",  q1.\"SALDMEDI_DIC\",  q1.\"COD_TERRI\",  q1.\"PORC_SALDMEDI_DIC\",  q1.\"FAC_AJU_SAL_PUN\",  q1.\"HIST_BAJAS\",  q1.\"MET_MESSALD_PUNT\",  q1.\"MET_GER_OFI\",  q1.\"PRIORIDAD\",  q1.\"MES_EVAL\",  q1.\"IND_DOR\",  q1.\"VAR_MES\",  q1.\"AJUS_PPTO\",  q1.\"DESV_PPTO_AJUS\",  q1.\"FACT_AJUS_TERRI\",  q1.\"FACT_ASIG_GTE_OF\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_REGI\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_PLANES q1 inner join IIDO.TIIDO_OFICINA q2 on ( ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  AND  ( q2.\"COD_OFIC\" =  q1.\"COD_OFIC\") ) where  ( q1.\"MES_PLAN\" = ?)  and  ( q1.\"ANHO_PLAN\" = ?)  and  ( q1.\"COD_EPIGRAFE\" = ?)  and  ( q2.\"COD_OFIC\" = ?) ";
	/**
	 * FindPlanByObject
	 */
	public javax.resource.cci.Record FindPlanByObject(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_planes o where  o.mes_plan = ?1 and  o.anho_plan = ?2 and  o.cod_epigrafe = ?3 and o.tiido_pla_oficina_fk.cod_ofic = ?4 */
			pstmt = prepareStatement(connection, findPlanByObjectQuery_0);

			// For ?1 (mes)
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
			// For ?3 (codEpigrafe)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (codOficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findPlanByObjectQuery_0);

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
	private static String findPlanByObjectForUpdateQuery_0 = " select  q1.\"MES_PLAN\",  q1.\"ANHO_PLAN\",  q1.\"COD_EPIGRAFE\",  q1.\"NOM_EPIGRAFE\",  q1.\"PESO_DOR\",  q1.\"MONTO\",  q1.\"PORC_ALCANZADO\",  q1.\"DESV_PPTO\",  q1.\"NRO_MESES_FALT\",  q1.\"PROY_CREC_MEN\",  q1.\"AJUSTE_ESTIMADO_TERR\",  q1.\"PROY_AJUSTE_MEN\",  q1.\"SALDMEDI_JUNIO\",  q1.\"PORC_SALDMEDI_JUNIO\",  q1.\"SALD_DIC_ANTE\",  q1.\"SALDMEDI_DIC\",  q1.\"COD_TERRI\",  q1.\"PORC_SALDMEDI_DIC\",  q1.\"FAC_AJU_SAL_PUN\",  q1.\"HIST_BAJAS\",  q1.\"MET_MESSALD_PUNT\",  q1.\"MET_GER_OFI\",  q1.\"PRIORIDAD\",  q1.\"MES_EVAL\",  q1.\"IND_DOR\",  q1.\"VAR_MES\",  q1.\"AJUS_PPTO\",  q1.\"DESV_PPTO_AJUS\",  q1.\"FACT_AJUS_TERRI\",  q1.\"FACT_ASIG_GTE_OF\",  q1.\"FEC_ACTU\",  q1.\"USU_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_REGI\",  q1.\"COD_TERR\",  q1.\"COD_OFIC\" from IIDO.TIIDO_PLANES q1 inner join IIDO.TIIDO_OFICINA q2 on ( ( q2.\"COD_TERR\" =  q1.\"COD_TERR\")  AND  ( q2.\"COD_OFIC\" =  q1.\"COD_OFIC\") ) where  ( q1.\"MES_PLAN\" = ?)  and  ( q1.\"ANHO_PLAN\" = ?)  and  ( q1.\"COD_EPIGRAFE\" = ?)  and  ( q2.\"COD_OFIC\" = ?)  for update ";
	/**
	 * FindPlanByObject444Update
	 */
	public javax.resource.cci.Record FindPlanByObject444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_planes o where  o.mes_plan = ?1 and  o.anho_plan = ?2 and  o.cod_epigrafe = ?3 and o.tiido_pla_oficina_fk.cod_ofic = ?4 */
			pstmt = prepareStatement(connection, findPlanByObjectForUpdateQuery_0);

			// For ?1 (mes)
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
			// For ?3 (codEpigrafe)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (codOficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findPlanByObjectForUpdateQuery_0);

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
	private static String findTiido_planesByTiido_pla_oficina_fkKey_LocalQuery_0 = " SELECT T1.MES_PLAN, T1.ANHO_PLAN, T1.COD_EPIGRAFE, T1.NOM_EPIGRAFE, T1.PESO_DOR, T1.MONTO, T1.PORC_ALCANZADO, T1.DESV_PPTO, T1.NRO_MESES_FALT, T1.PROY_CREC_MEN, T1.AJUSTE_ESTIMADO_TERR, T1.PROY_AJUSTE_MEN, T1.SALDMEDI_JUNIO, T1.PORC_SALDMEDI_JUNIO, T1.SALD_DIC_ANTE, T1.SALDMEDI_DIC, T1.COD_TERRI, T1.PORC_SALDMEDI_DIC, T1.FAC_AJU_SAL_PUN, T1.HIST_BAJAS, T1.MET_MESSALD_PUNT, T1.MET_GER_OFI, T1.PRIORIDAD, T1.MES_EVAL, T1.IND_DOR, T1.VAR_MES, T1.AJUS_PPTO, T1.DESV_PPTO_AJUS, T1.FACT_AJUS_TERRI, T1.FACT_ASIG_GTE_OF, T1.FEC_ACTU, T1.USU_REGI, T1.USU_ACTU, T1.FEC_REGI, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_PLANES  T1 WHERE T1.COD_TERR = ? AND T1.COD_OFIC = ?";
	/**
	 * findTiido_planesByTiido_pla_oficina_fkKey_Local
	 */
	public javax.resource.cci.Record findTiido_planesByTiido_pla_oficina_fkKey_Local(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_planesByTiido_pla_oficina_fkKey_LocalQuery_0);

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
			result = executeQuery(connection, pstmt, findTiido_planesByTiido_pla_oficina_fkKey_LocalQuery_0);

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
	private static String findTiido_planesByTiido_pla_oficina_fkKey_LocalForUpdateQuery_0 = " SELECT T1.MES_PLAN, T1.ANHO_PLAN, T1.COD_EPIGRAFE, T1.NOM_EPIGRAFE, T1.PESO_DOR, T1.MONTO, T1.PORC_ALCANZADO, T1.DESV_PPTO, T1.NRO_MESES_FALT, T1.PROY_CREC_MEN, T1.AJUSTE_ESTIMADO_TERR, T1.PROY_AJUSTE_MEN, T1.SALDMEDI_JUNIO, T1.PORC_SALDMEDI_JUNIO, T1.SALD_DIC_ANTE, T1.SALDMEDI_DIC, T1.COD_TERRI, T1.PORC_SALDMEDI_DIC, T1.FAC_AJU_SAL_PUN, T1.HIST_BAJAS, T1.MET_MESSALD_PUNT, T1.MET_GER_OFI, T1.PRIORIDAD, T1.MES_EVAL, T1.IND_DOR, T1.VAR_MES, T1.AJUS_PPTO, T1.DESV_PPTO_AJUS, T1.FACT_AJUS_TERRI, T1.FACT_ASIG_GTE_OF, T1.FEC_ACTU, T1.USU_REGI, T1.USU_ACTU, T1.FEC_REGI, T1.COD_TERR, T1.COD_OFIC FROM IIDO.TIIDO_PLANES  T1 WHERE T1.COD_TERR = ? AND T1.COD_OFIC = ? FOR UPDATE ";
	/**
	 * findTiido_planesByTiido_pla_oficina_fkKey_Local444Update
	 */
	public javax.resource.cci.Record findTiido_planesByTiido_pla_oficina_fkKey_Local444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, findTiido_planesByTiido_pla_oficina_fkKey_LocalForUpdateQuery_0);

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
			result = executeQuery(connection, pstmt, findTiido_planesByTiido_pla_oficina_fkKey_LocalForUpdateQuery_0);

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
	 * Tiido_planesBeanFunctionSet_f95fafaa
	 */
	public Tiido_planesBeanFunctionSet_f95fafaa() {
		functionHash=new java.util.HashMap(22);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindConsultaPlanes",new Integer(4));
		functionHash.put("FindConsultaPlanes444Update",new Integer(5));
		functionHash.put("FindConsultaPlanesPrioridad",new Integer(6));
		functionHash.put("FindConsultaPlanesPrioridad444Update",new Integer(7));
		functionHash.put("FindByPrimaryKey",new Integer(8));
		functionHash.put("FindByPrimaryKey444Update",new Integer(9));
		functionHash.put("FindConsultarPlanesxMes",new Integer(10));
		functionHash.put("FindConsultarPlanesxMes444Update",new Integer(11));
		functionHash.put("FindConsultaPlanesResumen",new Integer(12));
		functionHash.put("FindConsultaPlanesResumen444Update",new Integer(13));
		functionHash.put("FindPlanByObject",new Integer(14));
		functionHash.put("FindPlanByObject444Update",new Integer(15));
		functionHash.put("findTiido_planesByTiido_pla_oficina_fkKey_Local",new Integer(16));
		functionHash.put("findTiido_planesByTiido_pla_oficina_fkKey_Local444Update",new Integer(17));
		functionHash.put("ReadReadChecking",new Integer(18));
		functionHash.put("ReadReadCheckingForUpdate",new Integer(19));
		functionHash.put("PartialStore",new Integer(20));
		functionHash.put("PartialStoreUsingOCC",new Integer(21));
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
			outputRecord=FindConsultaPlanes(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindConsultaPlanes444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindConsultaPlanesPrioridad(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindConsultaPlanesPrioridad444Update(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindConsultarPlanesxMes(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindConsultarPlanesxMes444Update(inputRecord,connection,interactionSpec);
			break;
		case 12:
			outputRecord=FindConsultaPlanesResumen(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=FindConsultaPlanesResumen444Update(inputRecord,connection,interactionSpec);
			break;
		case 14:
			outputRecord=FindPlanByObject(inputRecord,connection,interactionSpec);
			break;
		case 15:
			outputRecord=FindPlanByObject444Update(inputRecord,connection,interactionSpec);
			break;
		case 16:
			outputRecord=findTiido_planesByTiido_pla_oficina_fkKey_Local(inputRecord,connection,interactionSpec);
			break;
		case 17:
			outputRecord=findTiido_planesByTiido_pla_oficina_fkKey_Local444Update(inputRecord,connection,interactionSpec);
			break;
		case 18:
			ReadReadChecking(inputRecord,connection,interactionSpec);
			break;
		case 19:
			ReadReadCheckingForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 20:
			PartialStore(inputRecord,connection,interactionSpec);
			break;
		case 21:
			PartialStoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
	private static String ReadReadQuery_0 = " SELECT 1 FROM IIDO.TIIDO_PLANES  T1 WHERE T1.MES_PLAN = ? AND T1.ANHO_PLAN = ? AND T1.COD_EPIGRAFE = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ? AND T1.FEC_ACTU = ? AND T1.USU_REGI = ? AND T1.USU_ACTU = ? AND T1.FEC_REGI = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column MES_PLAN
			// For column MES_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ANHO_PLAN
			// For column ANHO_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
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
			// For column FEC_ACTU
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(5);
				if(tempTimestamp != null)
					pstmt.setTimestamp(6,tempTimestamp);
				else
					pstmt.setNull(6,java.sql.Types.TIMESTAMP);
			}
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(8);
				if(tempTimestamp != null)
					pstmt.setTimestamp(9,tempTimestamp);
				else
					pstmt.setNull(9,java.sql.Types.TIMESTAMP);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM IIDO.TIIDO_PLANES  T1 WHERE T1.MES_PLAN = ? AND T1.ANHO_PLAN = ? AND T1.COD_EPIGRAFE = ? AND T1.COD_TERR = ? AND T1.COD_OFIC = ? AND T1.FEC_ACTU = ? AND T1.USU_REGI = ? AND T1.USU_ACTU = ? AND T1.FEC_REGI = ? FOR UPDATE ";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column MES_PLAN
			// For column MES_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ANHO_PLAN
			// For column ANHO_PLAN
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_EPIGRAFE
			// For column COD_EPIGRAFE
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
			// For column FEC_ACTU
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(5);
				if(tempTimestamp != null)
					pstmt.setTimestamp(6,tempTimestamp);
				else
					pstmt.setNull(6,java.sql.Types.TIMESTAMP);
			}
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(8);
				if(tempTimestamp != null)
					pstmt.setTimestamp(9,tempTimestamp);
				else
					pstmt.setNull(9,java.sql.Types.TIMESTAMP);
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
		updateTemplateList = Tiido_planesBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column NOM_EPIGRAFE
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
						// For column PESO_DOR
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
						// For column MONTO
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
						// For column PORC_ALCANZADO
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
						// For column DESV_PPTO
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
						// For column NRO_MESES_FALT
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
						// For column PROY_CREC_MEN
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
						// For column AJUSTE_ESTIMADO_TERR
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
						// For column PROY_AJUSTE_MEN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column SALDMEDI_JUNIO
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(12);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column PORC_SALDMEDI_JUNIO
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(13);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column SALD_DIC_ANTE
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(14);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column SALDMEDI_DIC
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(15);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column COD_TERRI
						String tempString;


						tempString=(String)inputRecord.get(16);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column PORC_SALDMEDI_DIC
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(17);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column FAC_AJU_SAL_PUN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(18);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column HIST_BAJAS
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(19);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column MET_MESSALD_PUNT
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(20);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column MET_GER_OFI
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(21);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column PRIORIDAD
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(22);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column MES_EVAL
						String tempString;


						tempString=(String)inputRecord.get(23);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column IND_DOR
						String tempString;


						tempString=(String)inputRecord.get(24);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[25])
					{
						// For column VAR_MES
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(25);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[26])
					{
						// For column AJUS_PPTO
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(26);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column DESV_PPTO_AJUS
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(27);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[28])
					{
						// For column FACT_AJUS_TERRI
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(28);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[29])
					{
						// For column FACT_ASIG_GTE_OF
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(29);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[32])
					{
						// For column FEC_ACTU
						java.sql.Timestamp tempTimestamp;


						tempTimestamp=(java.sql.Timestamp)inputRecord.get(30);
						if(tempTimestamp != null){
							pstmt.setTimestamp(stmtIndex,tempTimestamp);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIMESTAMP);
						stmtIndex++;

					}
					if (changedFieldIndexes[33])
					{
						// For column USU_REGI
						String tempString;


						tempString=(String)inputRecord.get(31);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[34])
					{
						// For column USU_ACTU
						String tempString;


						tempString=(String)inputRecord.get(32);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[35])
					{
						// For column FEC_REGI
						java.sql.Timestamp tempTimestamp;


						tempTimestamp=(java.sql.Timestamp)inputRecord.get(33);
						if(tempTimestamp != null){
							pstmt.setTimestamp(stmtIndex,tempTimestamp);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIMESTAMP);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column MES_PLAN
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column ANHO_PLAN
						String tempString;


						tempString=(String)inputRecord.get(1);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_EPIGRAFE
						String tempString;


						tempString=(String)inputRecord.get(2);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_OFIC
						String tempString;


						tempString=(String)inputRecord.get(34);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERR
						String tempString;


						tempString=(String)inputRecord.get(35);
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
				Object[] oldValues = new Object[4];
				oldValues[0] = oldRecord.get(30);
				oldValues[1] = oldRecord.get(31);
				oldValues[2] = oldRecord.get(32);
				oldValues[3] = oldRecord.get(33);
				String updateQuery = aTemplate.nativeOptimisticQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[3])
					{
						// For column NOM_EPIGRAFE
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
						// For column PESO_DOR
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
						// For column MONTO
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
						// For column PORC_ALCANZADO
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
						// For column DESV_PPTO
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
						// For column NRO_MESES_FALT
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
						// For column PROY_CREC_MEN
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
						// For column AJUSTE_ESTIMADO_TERR
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
						// For column PROY_AJUSTE_MEN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column SALDMEDI_JUNIO
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(12);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column PORC_SALDMEDI_JUNIO
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(13);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column SALD_DIC_ANTE
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(14);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column SALDMEDI_DIC
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(15);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column COD_TERRI
						String tempString;


						tempString=(String)inputRecord.get(16);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column PORC_SALDMEDI_DIC
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(17);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column FAC_AJU_SAL_PUN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(18);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column HIST_BAJAS
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(19);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column MET_MESSALD_PUNT
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(20);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column MET_GER_OFI
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(21);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column PRIORIDAD
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(22);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column MES_EVAL
						String tempString;


						tempString=(String)inputRecord.get(23);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column IND_DOR
						String tempString;


						tempString=(String)inputRecord.get(24);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[25])
					{
						// For column VAR_MES
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(25);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[26])
					{
						// For column AJUS_PPTO
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(26);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column DESV_PPTO_AJUS
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(27);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[28])
					{
						// For column FACT_AJUS_TERRI
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(28);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[29])
					{
						// For column FACT_ASIG_GTE_OF
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(29);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[32])
					{
						// For column FEC_ACTU
						java.sql.Timestamp tempTimestamp;


						tempTimestamp=(java.sql.Timestamp)inputRecord.get(30);
						if(tempTimestamp != null){
							pstmt.setTimestamp(stmtIndex,tempTimestamp);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIMESTAMP);
						stmtIndex++;

					}
					if (changedFieldIndexes[33])
					{
						// For column USU_REGI
						String tempString;


						tempString=(String)inputRecord.get(31);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[34])
					{
						// For column USU_ACTU
						String tempString;


						tempString=(String)inputRecord.get(32);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[35])
					{
						// For column FEC_REGI
						java.sql.Timestamp tempTimestamp;


						tempTimestamp=(java.sql.Timestamp)inputRecord.get(33);
						if(tempTimestamp != null){
							pstmt.setTimestamp(stmtIndex,tempTimestamp);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIMESTAMP);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column MES_PLAN
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column ANHO_PLAN
						String tempString;


						tempString=(String)inputRecord.get(1);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_EPIGRAFE
						String tempString;


						tempString=(String)inputRecord.get(2);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_OFIC
						String tempString;


						tempString=(String)inputRecord.get(34);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column COD_TERR
						String tempString;


						tempString=(String)inputRecord.get(35);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					// optimistic predicate columns
					{
						// For column FEC_ACTU
						java.sql.Timestamp tempTimestamp;


						tempTimestamp=(java.sql.Timestamp)oldValues[0];
						if(tempTimestamp != null){
							pstmt.setTimestamp(stmtIndex,tempTimestamp);
							stmtIndex++;
						}

					}
					{
						// For column USU_REGI
						String tempString;


						tempString=(String)oldValues[1];
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
							stmtIndex++;
						}

					}
					{
						// For column USU_ACTU
						String tempString;


						tempString=(String)oldValues[2];
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
							stmtIndex++;
						}

					}
					{
						// For column FEC_REGI
						java.sql.Timestamp tempTimestamp;


						tempTimestamp=(java.sql.Timestamp)oldValues[3];
						if(tempTimestamp != null){
							pstmt.setTimestamp(stmtIndex,tempTimestamp);
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
