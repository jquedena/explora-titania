package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * Tiilc_totalBeanFunctionSet_40ed895e
 */
public class Tiilc_totalBeanFunctionSet_40ed895e extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO IILC.TIILC_TOTAL (COD_TOTAL, COD_TERRITORIO, IND_REGISTRO, COD_OFICINA, COD_GESTOR, CLIXGEST, SEG_10100, SEG_10200, SEG_20100, SEG_20200, SEG_20300, SEG_20400, SEG_20500, SEG_20600, SEG_30100, SEG_30200, SEG_30300, SEG_30400, SEG_40100, SEG_40200, SEG_40300, SEG_40400, SEG_50100, SEG_50200, SEG_50300, SEG_50400, SEG_60100, SEG_60200, SEG_60300, SEG_60400, SEG_80100, SEG_80200, SEG_80300, SEG_80400, SEG_80500, SEG_80600, SEG_80700, SEG_90200, SEG_99900, DESVIN, POCOVIN, VIN, MUYVIN, NATDESVIN, NATVIN, JURVIN, AHOR_T, AHSD_T, AVAL_T, B24_T, CCTE_T, CEXT_T, CLOC_T, COLB_T, CPTE_T, CTS_T, CTSD_T, VIP_T, DSCT_T, FCEX_T, FMUT_T, LCTA_T, LEAS_T, MCLA_T, MORO_T, MP_T, PAUT_T, PCOM_T, PER_T, PH_T, PHIP_T, PLZO_T, PMAS_T, PMIV_T, PPER_T, PPPER_T, PREF_T, PROM_T, PSER_T, PSERV_T, DEP_T, SDEP_T, SEXT_T, SONC_T, SPRO_T, VID_T, SVID_T, TDE_T, SVIP_T, TVIP_T, VARC_T, VCLA_T, VCTR_T, VEMP_T, VNAC_T, VORO_T, VPLA_T, VPOLA_T, VREP_T, TDEB_T, CNET_T, LINCO_T, POS_T, EMPH_T, RIESGO_D_T, RIESGO_I_T, RIESGO_T, PASIVO_T, VOLUMEN_T, SUM_T_ACT, SUM_T_ACT1, SUM_T_ACT2, SUM_T_ACT3, SUM_T_ACT4, SUM_T_ACT5, SUM_T_ACT6, SUM_ACT_CTO, SUM_ACT_CT1, SUM_ACT_CT2, SUM_ACT_CT3, SUM_ACT_CT4, SUM_ACT_CT5, SUM_ACT_CT6, CEMP_T, CVIP_T, ICALICTE00, ICALICTE10, ICALICTE20, ICALICTE30, ICALICTE40, MOFACTV_T, CS000LINEAMAXTC_T, CS000MTOPRESTAMO_T, MONTOVEHICULAR_T, MONTOHIPOTECARIO_T, MONTOSUBROGADOS_T) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column COD_TOTAL
			// For column COD_TOTAL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(0);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(1,tempBigDecimal);
				else
					pstmt.setNull(1,java.sql.Types.NUMERIC);
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
			// For column IND_REGISTRO
			// For column IND_REGISTRO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column CLIXGEST
			// For column CLIXGEST
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(6,tempBigDecimal);
				else
					pstmt.setNull(6,java.sql.Types.NUMERIC);
			}
			// For column SEG_10100
			// For column SEG_10100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(6);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(7,tempBigDecimal);
				else
					pstmt.setNull(7,java.sql.Types.NUMERIC);
			}
			// For column SEG_10200
			// For column SEG_10200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(8,tempBigDecimal);
				else
					pstmt.setNull(8,java.sql.Types.NUMERIC);
			}
			// For column SEG_20100
			// For column SEG_20100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(8);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(9,tempBigDecimal);
				else
					pstmt.setNull(9,java.sql.Types.NUMERIC);
			}
			// For column SEG_20200
			// For column SEG_20200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(9);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(10,tempBigDecimal);
				else
					pstmt.setNull(10,java.sql.Types.NUMERIC);
			}
			// For column SEG_20300
			// For column SEG_20300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(11,tempBigDecimal);
				else
					pstmt.setNull(11,java.sql.Types.NUMERIC);
			}
			// For column SEG_20400
			// For column SEG_20400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(12,tempBigDecimal);
				else
					pstmt.setNull(12,java.sql.Types.NUMERIC);
			}
			// For column SEG_20500
			// For column SEG_20500
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(12);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(13,tempBigDecimal);
				else
					pstmt.setNull(13,java.sql.Types.NUMERIC);
			}
			// For column SEG_20600
			// For column SEG_20600
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(13);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(14,tempBigDecimal);
				else
					pstmt.setNull(14,java.sql.Types.NUMERIC);
			}
			// For column SEG_30100
			// For column SEG_30100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(14);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(15,tempBigDecimal);
				else
					pstmt.setNull(15,java.sql.Types.NUMERIC);
			}
			// For column SEG_30200
			// For column SEG_30200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(15);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(16,tempBigDecimal);
				else
					pstmt.setNull(16,java.sql.Types.NUMERIC);
			}
			// For column SEG_30300
			// For column SEG_30300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(16);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(17,tempBigDecimal);
				else
					pstmt.setNull(17,java.sql.Types.NUMERIC);
			}
			// For column SEG_30400
			// For column SEG_30400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(17);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(18,tempBigDecimal);
				else
					pstmt.setNull(18,java.sql.Types.NUMERIC);
			}
			// For column SEG_40100
			// For column SEG_40100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(18);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(19,tempBigDecimal);
				else
					pstmt.setNull(19,java.sql.Types.NUMERIC);
			}
			// For column SEG_40200
			// For column SEG_40200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(19);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(20,tempBigDecimal);
				else
					pstmt.setNull(20,java.sql.Types.NUMERIC);
			}
			// For column SEG_40300
			// For column SEG_40300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(20);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(21,tempBigDecimal);
				else
					pstmt.setNull(21,java.sql.Types.NUMERIC);
			}
			// For column SEG_40400
			// For column SEG_40400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(21);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(22,tempBigDecimal);
				else
					pstmt.setNull(22,java.sql.Types.NUMERIC);
			}
			// For column SEG_50100
			// For column SEG_50100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(22);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(23,tempBigDecimal);
				else
					pstmt.setNull(23,java.sql.Types.NUMERIC);
			}
			// For column SEG_50200
			// For column SEG_50200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(23);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(24,tempBigDecimal);
				else
					pstmt.setNull(24,java.sql.Types.NUMERIC);
			}
			// For column SEG_50300
			// For column SEG_50300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(24);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(25,tempBigDecimal);
				else
					pstmt.setNull(25,java.sql.Types.NUMERIC);
			}
			// For column SEG_50400
			// For column SEG_50400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(25);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(26,tempBigDecimal);
				else
					pstmt.setNull(26,java.sql.Types.NUMERIC);
			}
			// For column SEG_60100
			// For column SEG_60100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(26);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(27,tempBigDecimal);
				else
					pstmt.setNull(27,java.sql.Types.NUMERIC);
			}
			// For column SEG_60200
			// For column SEG_60200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(27);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(28,tempBigDecimal);
				else
					pstmt.setNull(28,java.sql.Types.NUMERIC);
			}
			// For column SEG_60300
			// For column SEG_60300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(28);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(29,tempBigDecimal);
				else
					pstmt.setNull(29,java.sql.Types.NUMERIC);
			}
			// For column SEG_60400
			// For column SEG_60400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(29);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(30,tempBigDecimal);
				else
					pstmt.setNull(30,java.sql.Types.NUMERIC);
			}
			// For column SEG_80100
			// For column SEG_80100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(30);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(31,tempBigDecimal);
				else
					pstmt.setNull(31,java.sql.Types.NUMERIC);
			}
			// For column SEG_80200
			// For column SEG_80200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(31);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(32,tempBigDecimal);
				else
					pstmt.setNull(32,java.sql.Types.NUMERIC);
			}
			// For column SEG_80300
			// For column SEG_80300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(32);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(33,tempBigDecimal);
				else
					pstmt.setNull(33,java.sql.Types.NUMERIC);
			}
			// For column SEG_80400
			// For column SEG_80400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(33);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(34,tempBigDecimal);
				else
					pstmt.setNull(34,java.sql.Types.NUMERIC);
			}
			// For column SEG_80500
			// For column SEG_80500
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(34);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(35,tempBigDecimal);
				else
					pstmt.setNull(35,java.sql.Types.NUMERIC);
			}
			// For column SEG_80600
			// For column SEG_80600
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(35);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(36,tempBigDecimal);
				else
					pstmt.setNull(36,java.sql.Types.NUMERIC);
			}
			// For column SEG_80700
			// For column SEG_80700
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(36);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(37,tempBigDecimal);
				else
					pstmt.setNull(37,java.sql.Types.NUMERIC);
			}
			// For column SEG_90200
			// For column SEG_90200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(37);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(38,tempBigDecimal);
				else
					pstmt.setNull(38,java.sql.Types.NUMERIC);
			}
			// For column SEG_99900
			// For column SEG_99900
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(38);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(39,tempBigDecimal);
				else
					pstmt.setNull(39,java.sql.Types.NUMERIC);
			}
			// For column DESVIN
			// For column DESVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(39);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(40,tempBigDecimal);
				else
					pstmt.setNull(40,java.sql.Types.NUMERIC);
			}
			// For column POCOVIN
			// For column POCOVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(40);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(41,tempBigDecimal);
				else
					pstmt.setNull(41,java.sql.Types.NUMERIC);
			}
			// For column VIN
			// For column VIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(41);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(42,tempBigDecimal);
				else
					pstmt.setNull(42,java.sql.Types.NUMERIC);
			}
			// For column MUYVIN
			// For column MUYVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(42);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(43,tempBigDecimal);
				else
					pstmt.setNull(43,java.sql.Types.NUMERIC);
			}
			// For column NATDESVIN
			// For column NATDESVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(43);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(44,tempBigDecimal);
				else
					pstmt.setNull(44,java.sql.Types.NUMERIC);
			}
			// For column NATVIN
			// For column NATVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(44);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(45,tempBigDecimal);
				else
					pstmt.setNull(45,java.sql.Types.NUMERIC);
			}
			// For column JURVIN
			// For column JURVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(45);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(46,tempBigDecimal);
				else
					pstmt.setNull(46,java.sql.Types.NUMERIC);
			}
			// For column AHOR_T
			// For column AHOR_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(46);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(47,tempBigDecimal);
				else
					pstmt.setNull(47,java.sql.Types.NUMERIC);
			}
			// For column AHSD_T
			// For column AHSD_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(47);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(48,tempBigDecimal);
				else
					pstmt.setNull(48,java.sql.Types.NUMERIC);
			}
			// For column AVAL_T
			// For column AVAL_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(48);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(49,tempBigDecimal);
				else
					pstmt.setNull(49,java.sql.Types.NUMERIC);
			}
			// For column B24_T
			// For column B24_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(49);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(50,tempBigDecimal);
				else
					pstmt.setNull(50,java.sql.Types.NUMERIC);
			}
			// For column CCTE_T
			// For column CCTE_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(50);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(51,tempBigDecimal);
				else
					pstmt.setNull(51,java.sql.Types.NUMERIC);
			}
			// For column CEXT_T
			// For column CEXT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(51);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(52,tempBigDecimal);
				else
					pstmt.setNull(52,java.sql.Types.NUMERIC);
			}
			// For column CLOC_T
			// For column CLOC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(52);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(53,tempBigDecimal);
				else
					pstmt.setNull(53,java.sql.Types.NUMERIC);
			}
			// For column COLB_T
			// For column COLB_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(53);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(54,tempBigDecimal);
				else
					pstmt.setNull(54,java.sql.Types.NUMERIC);
			}
			// For column CPTE_T
			// For column CPTE_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(54);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(55,tempBigDecimal);
				else
					pstmt.setNull(55,java.sql.Types.NUMERIC);
			}
			// For column CTS_T
			// For column CTS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(55);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(56,tempBigDecimal);
				else
					pstmt.setNull(56,java.sql.Types.NUMERIC);
			}
			// For column CTSD_T
			// For column CTSD_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(56);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(57,tempBigDecimal);
				else
					pstmt.setNull(57,java.sql.Types.NUMERIC);
			}
			// For column VIP_T
			// For column VIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(57);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(58,tempBigDecimal);
				else
					pstmt.setNull(58,java.sql.Types.NUMERIC);
			}
			// For column DSCT_T
			// For column DSCT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(58);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(59,tempBigDecimal);
				else
					pstmt.setNull(59,java.sql.Types.NUMERIC);
			}
			// For column FCEX_T
			// For column FCEX_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(59);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(60,tempBigDecimal);
				else
					pstmt.setNull(60,java.sql.Types.NUMERIC);
			}
			// For column FMUT_T
			// For column FMUT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(60);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(61,tempBigDecimal);
				else
					pstmt.setNull(61,java.sql.Types.NUMERIC);
			}
			// For column LCTA_T
			// For column LCTA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(61);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(62,tempBigDecimal);
				else
					pstmt.setNull(62,java.sql.Types.NUMERIC);
			}
			// For column LEAS_T
			// For column LEAS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(62);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(63,tempBigDecimal);
				else
					pstmt.setNull(63,java.sql.Types.NUMERIC);
			}
			// For column MCLA_T
			// For column MCLA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(63);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(64,tempBigDecimal);
				else
					pstmt.setNull(64,java.sql.Types.NUMERIC);
			}
			// For column MORO_T
			// For column MORO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(64);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(65,tempBigDecimal);
				else
					pstmt.setNull(65,java.sql.Types.NUMERIC);
			}
			// For column MP_T
			// For column MP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(65);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(66,tempBigDecimal);
				else
					pstmt.setNull(66,java.sql.Types.NUMERIC);
			}
			// For column PAUT_T
			// For column PAUT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(66);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(67,tempBigDecimal);
				else
					pstmt.setNull(67,java.sql.Types.NUMERIC);
			}
			// For column PCOM_T
			// For column PCOM_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(67);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(68,tempBigDecimal);
				else
					pstmt.setNull(68,java.sql.Types.NUMERIC);
			}
			// For column PER_T
			// For column PER_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(68);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(69,tempBigDecimal);
				else
					pstmt.setNull(69,java.sql.Types.NUMERIC);
			}
			// For column PH_T
			// For column PH_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(69);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(70,tempBigDecimal);
				else
					pstmt.setNull(70,java.sql.Types.NUMERIC);
			}
			// For column PHIP_T
			// For column PHIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(70);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(71,tempBigDecimal);
				else
					pstmt.setNull(71,java.sql.Types.NUMERIC);
			}
			// For column PLZO_T
			// For column PLZO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(71);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(72,tempBigDecimal);
				else
					pstmt.setNull(72,java.sql.Types.NUMERIC);
			}
			// For column PMAS_T
			// For column PMAS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(72);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(73,tempBigDecimal);
				else
					pstmt.setNull(73,java.sql.Types.NUMERIC);
			}
			// For column PMIV_T
			// For column PMIV_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(73);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(74,tempBigDecimal);
				else
					pstmt.setNull(74,java.sql.Types.NUMERIC);
			}
			// For column PPER_T
			// For column PPER_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(74);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(75,tempBigDecimal);
				else
					pstmt.setNull(75,java.sql.Types.NUMERIC);
			}
			// For column PPPER_T
			// For column PPPER_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(75);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(76,tempBigDecimal);
				else
					pstmt.setNull(76,java.sql.Types.NUMERIC);
			}
			// For column PREF_T
			// For column PREF_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(76);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(77,tempBigDecimal);
				else
					pstmt.setNull(77,java.sql.Types.NUMERIC);
			}
			// For column PROM_T
			// For column PROM_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(77);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(78,tempBigDecimal);
				else
					pstmt.setNull(78,java.sql.Types.NUMERIC);
			}
			// For column PSER_T
			// For column PSER_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(78);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(79,tempBigDecimal);
				else
					pstmt.setNull(79,java.sql.Types.NUMERIC);
			}
			// For column PSERV_T
			// For column PSERV_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(79);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(80,tempBigDecimal);
				else
					pstmt.setNull(80,java.sql.Types.NUMERIC);
			}
			// For column DEP_T
			// For column DEP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(80);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(81,tempBigDecimal);
				else
					pstmt.setNull(81,java.sql.Types.NUMERIC);
			}
			// For column SDEP_T
			// For column SDEP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(81);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(82,tempBigDecimal);
				else
					pstmt.setNull(82,java.sql.Types.NUMERIC);
			}
			// For column SEXT_T
			// For column SEXT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(82);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(83,tempBigDecimal);
				else
					pstmt.setNull(83,java.sql.Types.NUMERIC);
			}
			// For column SONC_T
			// For column SONC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(83);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(84,tempBigDecimal);
				else
					pstmt.setNull(84,java.sql.Types.NUMERIC);
			}
			// For column SPRO_T
			// For column SPRO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(84);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(85,tempBigDecimal);
				else
					pstmt.setNull(85,java.sql.Types.NUMERIC);
			}
			// For column VID_T
			// For column VID_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(85);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(86,tempBigDecimal);
				else
					pstmt.setNull(86,java.sql.Types.NUMERIC);
			}
			// For column SVID_T
			// For column SVID_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(86);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(87,tempBigDecimal);
				else
					pstmt.setNull(87,java.sql.Types.NUMERIC);
			}
			// For column TDE_T
			// For column TDE_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(87);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(88,tempBigDecimal);
				else
					pstmt.setNull(88,java.sql.Types.NUMERIC);
			}
			// For column SVIP_T
			// For column SVIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(88);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(89,tempBigDecimal);
				else
					pstmt.setNull(89,java.sql.Types.NUMERIC);
			}
			// For column TVIP_T
			// For column TVIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(89);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(90,tempBigDecimal);
				else
					pstmt.setNull(90,java.sql.Types.NUMERIC);
			}
			// For column VARC_T
			// For column VARC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(90);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(91,tempBigDecimal);
				else
					pstmt.setNull(91,java.sql.Types.NUMERIC);
			}
			// For column VCLA_T
			// For column VCLA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(91);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(92,tempBigDecimal);
				else
					pstmt.setNull(92,java.sql.Types.NUMERIC);
			}
			// For column VCTR_T
			// For column VCTR_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(92);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(93,tempBigDecimal);
				else
					pstmt.setNull(93,java.sql.Types.NUMERIC);
			}
			// For column VEMP_T
			// For column VEMP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(93);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(94,tempBigDecimal);
				else
					pstmt.setNull(94,java.sql.Types.NUMERIC);
			}
			// For column VNAC_T
			// For column VNAC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(94);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(95,tempBigDecimal);
				else
					pstmt.setNull(95,java.sql.Types.NUMERIC);
			}
			// For column VORO_T
			// For column VORO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(95);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(96,tempBigDecimal);
				else
					pstmt.setNull(96,java.sql.Types.NUMERIC);
			}
			// For column VPLA_T
			// For column VPLA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(96);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(97,tempBigDecimal);
				else
					pstmt.setNull(97,java.sql.Types.NUMERIC);
			}
			// For column VPOLA_T
			// For column VPOLA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(97);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(98,tempBigDecimal);
				else
					pstmt.setNull(98,java.sql.Types.NUMERIC);
			}
			// For column VREP_T
			// For column VREP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(98);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(99,tempBigDecimal);
				else
					pstmt.setNull(99,java.sql.Types.NUMERIC);
			}
			// For column TDEB_T
			// For column TDEB_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(99);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(100,tempBigDecimal);
				else
					pstmt.setNull(100,java.sql.Types.NUMERIC);
			}
			// For column CNET_T
			// For column CNET_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(100);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(101,tempBigDecimal);
				else
					pstmt.setNull(101,java.sql.Types.NUMERIC);
			}
			// For column LINCO_T
			// For column LINCO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(101);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(102,tempBigDecimal);
				else
					pstmt.setNull(102,java.sql.Types.NUMERIC);
			}
			// For column POS_T
			// For column POS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(102);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(103,tempBigDecimal);
				else
					pstmt.setNull(103,java.sql.Types.NUMERIC);
			}
			// For column EMPH_T
			// For column EMPH_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(103);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(104,tempBigDecimal);
				else
					pstmt.setNull(104,java.sql.Types.NUMERIC);
			}
			// For column RIESGO_D_T
			// For column RIESGO_D_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(104);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(105,tempBigDecimal);
				else
					pstmt.setNull(105,java.sql.Types.NUMERIC);
			}
			// For column RIESGO_I_T
			// For column RIESGO_I_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(105);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(106,tempBigDecimal);
				else
					pstmt.setNull(106,java.sql.Types.NUMERIC);
			}
			// For column RIESGO_T
			// For column RIESGO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(106);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(107,tempBigDecimal);
				else
					pstmt.setNull(107,java.sql.Types.NUMERIC);
			}
			// For column PASIVO_T
			// For column PASIVO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(107);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(108,tempBigDecimal);
				else
					pstmt.setNull(108,java.sql.Types.NUMERIC);
			}
			// For column VOLUMEN_T
			// For column VOLUMEN_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(108);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(109,tempBigDecimal);
				else
					pstmt.setNull(109,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT
			// For column SUM_T_ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(109);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(110,tempBigDecimal);
				else
					pstmt.setNull(110,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT1
			// For column SUM_T_ACT1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(110);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(111,tempBigDecimal);
				else
					pstmt.setNull(111,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT2
			// For column SUM_T_ACT2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(111);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(112,tempBigDecimal);
				else
					pstmt.setNull(112,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT3
			// For column SUM_T_ACT3
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(112);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(113,tempBigDecimal);
				else
					pstmt.setNull(113,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT4
			// For column SUM_T_ACT4
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(113);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(114,tempBigDecimal);
				else
					pstmt.setNull(114,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT5
			// For column SUM_T_ACT5
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(114);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(115,tempBigDecimal);
				else
					pstmt.setNull(115,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT6
			// For column SUM_T_ACT6
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(115);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(116,tempBigDecimal);
				else
					pstmt.setNull(116,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CTO
			// For column SUM_ACT_CTO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(116);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(117,tempBigDecimal);
				else
					pstmt.setNull(117,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT1
			// For column SUM_ACT_CT1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(117);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(118,tempBigDecimal);
				else
					pstmt.setNull(118,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT2
			// For column SUM_ACT_CT2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(118);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(119,tempBigDecimal);
				else
					pstmt.setNull(119,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT3
			// For column SUM_ACT_CT3
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(119);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(120,tempBigDecimal);
				else
					pstmt.setNull(120,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT4
			// For column SUM_ACT_CT4
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(120);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(121,tempBigDecimal);
				else
					pstmt.setNull(121,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT5
			// For column SUM_ACT_CT5
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(121);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(122,tempBigDecimal);
				else
					pstmt.setNull(122,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT6
			// For column SUM_ACT_CT6
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(122);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(123,tempBigDecimal);
				else
					pstmt.setNull(123,java.sql.Types.NUMERIC);
			}
			// For column CEMP_T
			// For column CEMP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(123);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(124,tempBigDecimal);
				else
					pstmt.setNull(124,java.sql.Types.NUMERIC);
			}
			// For column CVIP_T
			// For column CVIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(124);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(125,tempBigDecimal);
				else
					pstmt.setNull(125,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE00
			// For column ICALICTE00
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(125);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(126,tempBigDecimal);
				else
					pstmt.setNull(126,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE10
			// For column ICALICTE10
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(126);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(127,tempBigDecimal);
				else
					pstmt.setNull(127,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE20
			// For column ICALICTE20
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(127);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(128,tempBigDecimal);
				else
					pstmt.setNull(128,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE30
			// For column ICALICTE30
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(128);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(129,tempBigDecimal);
				else
					pstmt.setNull(129,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE40
			// For column ICALICTE40
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(129);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(130,tempBigDecimal);
				else
					pstmt.setNull(130,java.sql.Types.NUMERIC);
			}
			// For column MOFACTV_T
			// For column MOFACTV_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(130);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(131,tempBigDecimal);
				else
					pstmt.setNull(131,java.sql.Types.NUMERIC);
			}
			// For column CS000LINEAMAXTC_T
			// For column CS000LINEAMAXTC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(131);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(132,tempBigDecimal);
				else
					pstmt.setNull(132,java.sql.Types.NUMERIC);
			}
			// For column CS000MTOPRESTAMO_T
			// For column CS000MTOPRESTAMO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(132);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(133,tempBigDecimal);
				else
					pstmt.setNull(133,java.sql.Types.NUMERIC);
			}
			// For column MONTOVEHICULAR_T
			// For column MONTOVEHICULAR_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(133);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(134,tempBigDecimal);
				else
					pstmt.setNull(134,java.sql.Types.NUMERIC);
			}
			// For column MONTOHIPOTECARIO_T
			// For column MONTOHIPOTECARIO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(134);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(135,tempBigDecimal);
				else
					pstmt.setNull(135,java.sql.Types.NUMERIC);
			}
			// For column MONTOSUBROGADOS_T
			// For column MONTOSUBROGADOS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(135);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(136,tempBigDecimal);
				else
					pstmt.setNull(136,java.sql.Types.NUMERIC);
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
	private static String RemoveQuery_0 = "DELETE FROM IILC.TIILC_TOTAL  WHERE COD_TOTAL = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column COD_TOTAL
			// For column COD_TOTAL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(0);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(1,tempBigDecimal);
				else
					pstmt.setNull(1,java.sql.Types.NUMERIC);
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
	private static String StoreQuery_0 = "UPDATE IILC.TIILC_TOTAL  SET COD_TERRITORIO = ?, IND_REGISTRO = ?, COD_OFICINA = ?, COD_GESTOR = ?, CLIXGEST = ?, SEG_10100 = ?, SEG_10200 = ?, SEG_20100 = ?, SEG_20200 = ?, SEG_20300 = ?, SEG_20400 = ?, SEG_20500 = ?, SEG_20600 = ?, SEG_30100 = ?, SEG_30200 = ?, SEG_30300 = ?, SEG_30400 = ?, SEG_40100 = ?, SEG_40200 = ?, SEG_40300 = ?, SEG_40400 = ?, SEG_50100 = ?, SEG_50200 = ?, SEG_50300 = ?, SEG_50400 = ?, SEG_60100 = ?, SEG_60200 = ?, SEG_60300 = ?, SEG_60400 = ?, SEG_80100 = ?, SEG_80200 = ?, SEG_80300 = ?, SEG_80400 = ?, SEG_80500 = ?, SEG_80600 = ?, SEG_80700 = ?, SEG_90200 = ?, SEG_99900 = ?, DESVIN = ?, POCOVIN = ?, VIN = ?, MUYVIN = ?, NATDESVIN = ?, NATVIN = ?, JURVIN = ?, AHOR_T = ?, AHSD_T = ?, AVAL_T = ?, B24_T = ?, CCTE_T = ?, CEXT_T = ?, CLOC_T = ?, COLB_T = ?, CPTE_T = ?, CTS_T = ?, CTSD_T = ?, VIP_T = ?, DSCT_T = ?, FCEX_T = ?, FMUT_T = ?, LCTA_T = ?, LEAS_T = ?, MCLA_T = ?, MORO_T = ?, MP_T = ?, PAUT_T = ?, PCOM_T = ?, PER_T = ?, PH_T = ?, PHIP_T = ?, PLZO_T = ?, PMAS_T = ?, PMIV_T = ?, PPER_T = ?, PPPER_T = ?, PREF_T = ?, PROM_T = ?, PSER_T = ?, PSERV_T = ?, DEP_T = ?, SDEP_T = ?, SEXT_T = ?, SONC_T = ?, SPRO_T = ?, VID_T = ?, SVID_T = ?, TDE_T = ?, SVIP_T = ?, TVIP_T = ?, VARC_T = ?, VCLA_T = ?, VCTR_T = ?, VEMP_T = ?, VNAC_T = ?, VORO_T = ?, VPLA_T = ?, VPOLA_T = ?, VREP_T = ?, TDEB_T = ?, CNET_T = ?, LINCO_T = ?, POS_T = ?, EMPH_T = ?, RIESGO_D_T = ?, RIESGO_I_T = ?, RIESGO_T = ?, PASIVO_T = ?, VOLUMEN_T = ?, SUM_T_ACT = ?, SUM_T_ACT1 = ?, SUM_T_ACT2 = ?, SUM_T_ACT3 = ?, SUM_T_ACT4 = ?, SUM_T_ACT5 = ?, SUM_T_ACT6 = ?, SUM_ACT_CTO = ?, SUM_ACT_CT1 = ?, SUM_ACT_CT2 = ?, SUM_ACT_CT3 = ?, SUM_ACT_CT4 = ?, SUM_ACT_CT5 = ?, SUM_ACT_CT6 = ?, CEMP_T = ?, CVIP_T = ?, ICALICTE00 = ?, ICALICTE10 = ?, ICALICTE20 = ?, ICALICTE30 = ?, ICALICTE40 = ?, MOFACTV_T = ?, CS000LINEAMAXTC_T = ?, CS000MTOPRESTAMO_T = ?, MONTOVEHICULAR_T = ?, MONTOHIPOTECARIO_T = ?, MONTOSUBROGADOS_T = ? WHERE COD_TOTAL = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column COD_TOTAL
			// For column COD_TOTAL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(0);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(136,tempBigDecimal);
				else
					pstmt.setNull(136,java.sql.Types.NUMERIC);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column IND_REGISTRO
			// For column IND_REGISTRO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
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
			// For column CLIXGEST
			// For column CLIXGEST
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(5,tempBigDecimal);
				else
					pstmt.setNull(5,java.sql.Types.NUMERIC);
			}
			// For column SEG_10100
			// For column SEG_10100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(6);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(6,tempBigDecimal);
				else
					pstmt.setNull(6,java.sql.Types.NUMERIC);
			}
			// For column SEG_10200
			// For column SEG_10200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(7,tempBigDecimal);
				else
					pstmt.setNull(7,java.sql.Types.NUMERIC);
			}
			// For column SEG_20100
			// For column SEG_20100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(8);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(8,tempBigDecimal);
				else
					pstmt.setNull(8,java.sql.Types.NUMERIC);
			}
			// For column SEG_20200
			// For column SEG_20200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(9);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(9,tempBigDecimal);
				else
					pstmt.setNull(9,java.sql.Types.NUMERIC);
			}
			// For column SEG_20300
			// For column SEG_20300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(10,tempBigDecimal);
				else
					pstmt.setNull(10,java.sql.Types.NUMERIC);
			}
			// For column SEG_20400
			// For column SEG_20400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(11,tempBigDecimal);
				else
					pstmt.setNull(11,java.sql.Types.NUMERIC);
			}
			// For column SEG_20500
			// For column SEG_20500
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(12);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(12,tempBigDecimal);
				else
					pstmt.setNull(12,java.sql.Types.NUMERIC);
			}
			// For column SEG_20600
			// For column SEG_20600
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(13);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(13,tempBigDecimal);
				else
					pstmt.setNull(13,java.sql.Types.NUMERIC);
			}
			// For column SEG_30100
			// For column SEG_30100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(14);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(14,tempBigDecimal);
				else
					pstmt.setNull(14,java.sql.Types.NUMERIC);
			}
			// For column SEG_30200
			// For column SEG_30200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(15);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(15,tempBigDecimal);
				else
					pstmt.setNull(15,java.sql.Types.NUMERIC);
			}
			// For column SEG_30300
			// For column SEG_30300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(16);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(16,tempBigDecimal);
				else
					pstmt.setNull(16,java.sql.Types.NUMERIC);
			}
			// For column SEG_30400
			// For column SEG_30400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(17);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(17,tempBigDecimal);
				else
					pstmt.setNull(17,java.sql.Types.NUMERIC);
			}
			// For column SEG_40100
			// For column SEG_40100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(18);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(18,tempBigDecimal);
				else
					pstmt.setNull(18,java.sql.Types.NUMERIC);
			}
			// For column SEG_40200
			// For column SEG_40200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(19);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(19,tempBigDecimal);
				else
					pstmt.setNull(19,java.sql.Types.NUMERIC);
			}
			// For column SEG_40300
			// For column SEG_40300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(20);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(20,tempBigDecimal);
				else
					pstmt.setNull(20,java.sql.Types.NUMERIC);
			}
			// For column SEG_40400
			// For column SEG_40400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(21);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(21,tempBigDecimal);
				else
					pstmt.setNull(21,java.sql.Types.NUMERIC);
			}
			// For column SEG_50100
			// For column SEG_50100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(22);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(22,tempBigDecimal);
				else
					pstmt.setNull(22,java.sql.Types.NUMERIC);
			}
			// For column SEG_50200
			// For column SEG_50200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(23);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(23,tempBigDecimal);
				else
					pstmt.setNull(23,java.sql.Types.NUMERIC);
			}
			// For column SEG_50300
			// For column SEG_50300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(24);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(24,tempBigDecimal);
				else
					pstmt.setNull(24,java.sql.Types.NUMERIC);
			}
			// For column SEG_50400
			// For column SEG_50400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(25);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(25,tempBigDecimal);
				else
					pstmt.setNull(25,java.sql.Types.NUMERIC);
			}
			// For column SEG_60100
			// For column SEG_60100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(26);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(26,tempBigDecimal);
				else
					pstmt.setNull(26,java.sql.Types.NUMERIC);
			}
			// For column SEG_60200
			// For column SEG_60200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(27);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(27,tempBigDecimal);
				else
					pstmt.setNull(27,java.sql.Types.NUMERIC);
			}
			// For column SEG_60300
			// For column SEG_60300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(28);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(28,tempBigDecimal);
				else
					pstmt.setNull(28,java.sql.Types.NUMERIC);
			}
			// For column SEG_60400
			// For column SEG_60400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(29);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(29,tempBigDecimal);
				else
					pstmt.setNull(29,java.sql.Types.NUMERIC);
			}
			// For column SEG_80100
			// For column SEG_80100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(30);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(30,tempBigDecimal);
				else
					pstmt.setNull(30,java.sql.Types.NUMERIC);
			}
			// For column SEG_80200
			// For column SEG_80200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(31);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(31,tempBigDecimal);
				else
					pstmt.setNull(31,java.sql.Types.NUMERIC);
			}
			// For column SEG_80300
			// For column SEG_80300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(32);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(32,tempBigDecimal);
				else
					pstmt.setNull(32,java.sql.Types.NUMERIC);
			}
			// For column SEG_80400
			// For column SEG_80400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(33);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(33,tempBigDecimal);
				else
					pstmt.setNull(33,java.sql.Types.NUMERIC);
			}
			// For column SEG_80500
			// For column SEG_80500
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(34);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(34,tempBigDecimal);
				else
					pstmt.setNull(34,java.sql.Types.NUMERIC);
			}
			// For column SEG_80600
			// For column SEG_80600
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(35);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(35,tempBigDecimal);
				else
					pstmt.setNull(35,java.sql.Types.NUMERIC);
			}
			// For column SEG_80700
			// For column SEG_80700
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(36);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(36,tempBigDecimal);
				else
					pstmt.setNull(36,java.sql.Types.NUMERIC);
			}
			// For column SEG_90200
			// For column SEG_90200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(37);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(37,tempBigDecimal);
				else
					pstmt.setNull(37,java.sql.Types.NUMERIC);
			}
			// For column SEG_99900
			// For column SEG_99900
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(38);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(38,tempBigDecimal);
				else
					pstmt.setNull(38,java.sql.Types.NUMERIC);
			}
			// For column DESVIN
			// For column DESVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(39);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(39,tempBigDecimal);
				else
					pstmt.setNull(39,java.sql.Types.NUMERIC);
			}
			// For column POCOVIN
			// For column POCOVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(40);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(40,tempBigDecimal);
				else
					pstmt.setNull(40,java.sql.Types.NUMERIC);
			}
			// For column VIN
			// For column VIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(41);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(41,tempBigDecimal);
				else
					pstmt.setNull(41,java.sql.Types.NUMERIC);
			}
			// For column MUYVIN
			// For column MUYVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(42);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(42,tempBigDecimal);
				else
					pstmt.setNull(42,java.sql.Types.NUMERIC);
			}
			// For column NATDESVIN
			// For column NATDESVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(43);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(43,tempBigDecimal);
				else
					pstmt.setNull(43,java.sql.Types.NUMERIC);
			}
			// For column NATVIN
			// For column NATVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(44);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(44,tempBigDecimal);
				else
					pstmt.setNull(44,java.sql.Types.NUMERIC);
			}
			// For column JURVIN
			// For column JURVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(45);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(45,tempBigDecimal);
				else
					pstmt.setNull(45,java.sql.Types.NUMERIC);
			}
			// For column AHOR_T
			// For column AHOR_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(46);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(46,tempBigDecimal);
				else
					pstmt.setNull(46,java.sql.Types.NUMERIC);
			}
			// For column AHSD_T
			// For column AHSD_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(47);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(47,tempBigDecimal);
				else
					pstmt.setNull(47,java.sql.Types.NUMERIC);
			}
			// For column AVAL_T
			// For column AVAL_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(48);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(48,tempBigDecimal);
				else
					pstmt.setNull(48,java.sql.Types.NUMERIC);
			}
			// For column B24_T
			// For column B24_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(49);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(49,tempBigDecimal);
				else
					pstmt.setNull(49,java.sql.Types.NUMERIC);
			}
			// For column CCTE_T
			// For column CCTE_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(50);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(50,tempBigDecimal);
				else
					pstmt.setNull(50,java.sql.Types.NUMERIC);
			}
			// For column CEXT_T
			// For column CEXT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(51);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(51,tempBigDecimal);
				else
					pstmt.setNull(51,java.sql.Types.NUMERIC);
			}
			// For column CLOC_T
			// For column CLOC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(52);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(52,tempBigDecimal);
				else
					pstmt.setNull(52,java.sql.Types.NUMERIC);
			}
			// For column COLB_T
			// For column COLB_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(53);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(53,tempBigDecimal);
				else
					pstmt.setNull(53,java.sql.Types.NUMERIC);
			}
			// For column CPTE_T
			// For column CPTE_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(54);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(54,tempBigDecimal);
				else
					pstmt.setNull(54,java.sql.Types.NUMERIC);
			}
			// For column CTS_T
			// For column CTS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(55);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(55,tempBigDecimal);
				else
					pstmt.setNull(55,java.sql.Types.NUMERIC);
			}
			// For column CTSD_T
			// For column CTSD_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(56);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(56,tempBigDecimal);
				else
					pstmt.setNull(56,java.sql.Types.NUMERIC);
			}
			// For column VIP_T
			// For column VIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(57);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(57,tempBigDecimal);
				else
					pstmt.setNull(57,java.sql.Types.NUMERIC);
			}
			// For column DSCT_T
			// For column DSCT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(58);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(58,tempBigDecimal);
				else
					pstmt.setNull(58,java.sql.Types.NUMERIC);
			}
			// For column FCEX_T
			// For column FCEX_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(59);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(59,tempBigDecimal);
				else
					pstmt.setNull(59,java.sql.Types.NUMERIC);
			}
			// For column FMUT_T
			// For column FMUT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(60);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(60,tempBigDecimal);
				else
					pstmt.setNull(60,java.sql.Types.NUMERIC);
			}
			// For column LCTA_T
			// For column LCTA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(61);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(61,tempBigDecimal);
				else
					pstmt.setNull(61,java.sql.Types.NUMERIC);
			}
			// For column LEAS_T
			// For column LEAS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(62);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(62,tempBigDecimal);
				else
					pstmt.setNull(62,java.sql.Types.NUMERIC);
			}
			// For column MCLA_T
			// For column MCLA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(63);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(63,tempBigDecimal);
				else
					pstmt.setNull(63,java.sql.Types.NUMERIC);
			}
			// For column MORO_T
			// For column MORO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(64);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(64,tempBigDecimal);
				else
					pstmt.setNull(64,java.sql.Types.NUMERIC);
			}
			// For column MP_T
			// For column MP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(65);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(65,tempBigDecimal);
				else
					pstmt.setNull(65,java.sql.Types.NUMERIC);
			}
			// For column PAUT_T
			// For column PAUT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(66);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(66,tempBigDecimal);
				else
					pstmt.setNull(66,java.sql.Types.NUMERIC);
			}
			// For column PCOM_T
			// For column PCOM_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(67);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(67,tempBigDecimal);
				else
					pstmt.setNull(67,java.sql.Types.NUMERIC);
			}
			// For column PER_T
			// For column PER_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(68);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(68,tempBigDecimal);
				else
					pstmt.setNull(68,java.sql.Types.NUMERIC);
			}
			// For column PH_T
			// For column PH_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(69);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(69,tempBigDecimal);
				else
					pstmt.setNull(69,java.sql.Types.NUMERIC);
			}
			// For column PHIP_T
			// For column PHIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(70);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(70,tempBigDecimal);
				else
					pstmt.setNull(70,java.sql.Types.NUMERIC);
			}
			// For column PLZO_T
			// For column PLZO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(71);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(71,tempBigDecimal);
				else
					pstmt.setNull(71,java.sql.Types.NUMERIC);
			}
			// For column PMAS_T
			// For column PMAS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(72);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(72,tempBigDecimal);
				else
					pstmt.setNull(72,java.sql.Types.NUMERIC);
			}
			// For column PMIV_T
			// For column PMIV_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(73);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(73,tempBigDecimal);
				else
					pstmt.setNull(73,java.sql.Types.NUMERIC);
			}
			// For column PPER_T
			// For column PPER_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(74);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(74,tempBigDecimal);
				else
					pstmt.setNull(74,java.sql.Types.NUMERIC);
			}
			// For column PPPER_T
			// For column PPPER_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(75);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(75,tempBigDecimal);
				else
					pstmt.setNull(75,java.sql.Types.NUMERIC);
			}
			// For column PREF_T
			// For column PREF_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(76);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(76,tempBigDecimal);
				else
					pstmt.setNull(76,java.sql.Types.NUMERIC);
			}
			// For column PROM_T
			// For column PROM_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(77);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(77,tempBigDecimal);
				else
					pstmt.setNull(77,java.sql.Types.NUMERIC);
			}
			// For column PSER_T
			// For column PSER_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(78);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(78,tempBigDecimal);
				else
					pstmt.setNull(78,java.sql.Types.NUMERIC);
			}
			// For column PSERV_T
			// For column PSERV_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(79);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(79,tempBigDecimal);
				else
					pstmt.setNull(79,java.sql.Types.NUMERIC);
			}
			// For column DEP_T
			// For column DEP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(80);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(80,tempBigDecimal);
				else
					pstmt.setNull(80,java.sql.Types.NUMERIC);
			}
			// For column SDEP_T
			// For column SDEP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(81);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(81,tempBigDecimal);
				else
					pstmt.setNull(81,java.sql.Types.NUMERIC);
			}
			// For column SEXT_T
			// For column SEXT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(82);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(82,tempBigDecimal);
				else
					pstmt.setNull(82,java.sql.Types.NUMERIC);
			}
			// For column SONC_T
			// For column SONC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(83);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(83,tempBigDecimal);
				else
					pstmt.setNull(83,java.sql.Types.NUMERIC);
			}
			// For column SPRO_T
			// For column SPRO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(84);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(84,tempBigDecimal);
				else
					pstmt.setNull(84,java.sql.Types.NUMERIC);
			}
			// For column VID_T
			// For column VID_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(85);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(85,tempBigDecimal);
				else
					pstmt.setNull(85,java.sql.Types.NUMERIC);
			}
			// For column SVID_T
			// For column SVID_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(86);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(86,tempBigDecimal);
				else
					pstmt.setNull(86,java.sql.Types.NUMERIC);
			}
			// For column TDE_T
			// For column TDE_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(87);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(87,tempBigDecimal);
				else
					pstmt.setNull(87,java.sql.Types.NUMERIC);
			}
			// For column SVIP_T
			// For column SVIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(88);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(88,tempBigDecimal);
				else
					pstmt.setNull(88,java.sql.Types.NUMERIC);
			}
			// For column TVIP_T
			// For column TVIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(89);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(89,tempBigDecimal);
				else
					pstmt.setNull(89,java.sql.Types.NUMERIC);
			}
			// For column VARC_T
			// For column VARC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(90);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(90,tempBigDecimal);
				else
					pstmt.setNull(90,java.sql.Types.NUMERIC);
			}
			// For column VCLA_T
			// For column VCLA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(91);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(91,tempBigDecimal);
				else
					pstmt.setNull(91,java.sql.Types.NUMERIC);
			}
			// For column VCTR_T
			// For column VCTR_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(92);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(92,tempBigDecimal);
				else
					pstmt.setNull(92,java.sql.Types.NUMERIC);
			}
			// For column VEMP_T
			// For column VEMP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(93);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(93,tempBigDecimal);
				else
					pstmt.setNull(93,java.sql.Types.NUMERIC);
			}
			// For column VNAC_T
			// For column VNAC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(94);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(94,tempBigDecimal);
				else
					pstmt.setNull(94,java.sql.Types.NUMERIC);
			}
			// For column VORO_T
			// For column VORO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(95);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(95,tempBigDecimal);
				else
					pstmt.setNull(95,java.sql.Types.NUMERIC);
			}
			// For column VPLA_T
			// For column VPLA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(96);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(96,tempBigDecimal);
				else
					pstmt.setNull(96,java.sql.Types.NUMERIC);
			}
			// For column VPOLA_T
			// For column VPOLA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(97);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(97,tempBigDecimal);
				else
					pstmt.setNull(97,java.sql.Types.NUMERIC);
			}
			// For column VREP_T
			// For column VREP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(98);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(98,tempBigDecimal);
				else
					pstmt.setNull(98,java.sql.Types.NUMERIC);
			}
			// For column TDEB_T
			// For column TDEB_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(99);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(99,tempBigDecimal);
				else
					pstmt.setNull(99,java.sql.Types.NUMERIC);
			}
			// For column CNET_T
			// For column CNET_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(100);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(100,tempBigDecimal);
				else
					pstmt.setNull(100,java.sql.Types.NUMERIC);
			}
			// For column LINCO_T
			// For column LINCO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(101);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(101,tempBigDecimal);
				else
					pstmt.setNull(101,java.sql.Types.NUMERIC);
			}
			// For column POS_T
			// For column POS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(102);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(102,tempBigDecimal);
				else
					pstmt.setNull(102,java.sql.Types.NUMERIC);
			}
			// For column EMPH_T
			// For column EMPH_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(103);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(103,tempBigDecimal);
				else
					pstmt.setNull(103,java.sql.Types.NUMERIC);
			}
			// For column RIESGO_D_T
			// For column RIESGO_D_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(104);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(104,tempBigDecimal);
				else
					pstmt.setNull(104,java.sql.Types.NUMERIC);
			}
			// For column RIESGO_I_T
			// For column RIESGO_I_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(105);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(105,tempBigDecimal);
				else
					pstmt.setNull(105,java.sql.Types.NUMERIC);
			}
			// For column RIESGO_T
			// For column RIESGO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(106);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(106,tempBigDecimal);
				else
					pstmt.setNull(106,java.sql.Types.NUMERIC);
			}
			// For column PASIVO_T
			// For column PASIVO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(107);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(107,tempBigDecimal);
				else
					pstmt.setNull(107,java.sql.Types.NUMERIC);
			}
			// For column VOLUMEN_T
			// For column VOLUMEN_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(108);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(108,tempBigDecimal);
				else
					pstmt.setNull(108,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT
			// For column SUM_T_ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(109);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(109,tempBigDecimal);
				else
					pstmt.setNull(109,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT1
			// For column SUM_T_ACT1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(110);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(110,tempBigDecimal);
				else
					pstmt.setNull(110,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT2
			// For column SUM_T_ACT2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(111);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(111,tempBigDecimal);
				else
					pstmt.setNull(111,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT3
			// For column SUM_T_ACT3
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(112);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(112,tempBigDecimal);
				else
					pstmt.setNull(112,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT4
			// For column SUM_T_ACT4
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(113);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(113,tempBigDecimal);
				else
					pstmt.setNull(113,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT5
			// For column SUM_T_ACT5
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(114);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(114,tempBigDecimal);
				else
					pstmt.setNull(114,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT6
			// For column SUM_T_ACT6
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(115);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(115,tempBigDecimal);
				else
					pstmt.setNull(115,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CTO
			// For column SUM_ACT_CTO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(116);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(116,tempBigDecimal);
				else
					pstmt.setNull(116,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT1
			// For column SUM_ACT_CT1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(117);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(117,tempBigDecimal);
				else
					pstmt.setNull(117,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT2
			// For column SUM_ACT_CT2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(118);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(118,tempBigDecimal);
				else
					pstmt.setNull(118,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT3
			// For column SUM_ACT_CT3
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(119);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(119,tempBigDecimal);
				else
					pstmt.setNull(119,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT4
			// For column SUM_ACT_CT4
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(120);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(120,tempBigDecimal);
				else
					pstmt.setNull(120,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT5
			// For column SUM_ACT_CT5
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(121);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(121,tempBigDecimal);
				else
					pstmt.setNull(121,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT6
			// For column SUM_ACT_CT6
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(122);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(122,tempBigDecimal);
				else
					pstmt.setNull(122,java.sql.Types.NUMERIC);
			}
			// For column CEMP_T
			// For column CEMP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(123);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(123,tempBigDecimal);
				else
					pstmt.setNull(123,java.sql.Types.NUMERIC);
			}
			// For column CVIP_T
			// For column CVIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(124);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(124,tempBigDecimal);
				else
					pstmt.setNull(124,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE00
			// For column ICALICTE00
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(125);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(125,tempBigDecimal);
				else
					pstmt.setNull(125,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE10
			// For column ICALICTE10
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(126);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(126,tempBigDecimal);
				else
					pstmt.setNull(126,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE20
			// For column ICALICTE20
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(127);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(127,tempBigDecimal);
				else
					pstmt.setNull(127,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE30
			// For column ICALICTE30
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(128);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(128,tempBigDecimal);
				else
					pstmt.setNull(128,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE40
			// For column ICALICTE40
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(129);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(129,tempBigDecimal);
				else
					pstmt.setNull(129,java.sql.Types.NUMERIC);
			}
			// For column MOFACTV_T
			// For column MOFACTV_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(130);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(130,tempBigDecimal);
				else
					pstmt.setNull(130,java.sql.Types.NUMERIC);
			}
			// For column CS000LINEAMAXTC_T
			// For column CS000LINEAMAXTC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(131);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(131,tempBigDecimal);
				else
					pstmt.setNull(131,java.sql.Types.NUMERIC);
			}
			// For column CS000MTOPRESTAMO_T
			// For column CS000MTOPRESTAMO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(132);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(132,tempBigDecimal);
				else
					pstmt.setNull(132,java.sql.Types.NUMERIC);
			}
			// For column MONTOVEHICULAR_T
			// For column MONTOVEHICULAR_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(133);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(133,tempBigDecimal);
				else
					pstmt.setNull(133,java.sql.Types.NUMERIC);
			}
			// For column MONTOHIPOTECARIO_T
			// For column MONTOHIPOTECARIO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(134);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(134,tempBigDecimal);
				else
					pstmt.setNull(134,java.sql.Types.NUMERIC);
			}
			// For column MONTOSUBROGADOS_T
			// For column MONTOSUBROGADOS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(135);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(135,tempBigDecimal);
				else
					pstmt.setNull(135,java.sql.Types.NUMERIC);
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
	private static String StoreOCCQuery_0 = "UPDATE IILC.TIILC_TOTAL  SET COD_TERRITORIO = ?, IND_REGISTRO = ?, COD_OFICINA = ?, COD_GESTOR = ?, CLIXGEST = ?, SEG_10100 = ?, SEG_10200 = ?, SEG_20100 = ?, SEG_20200 = ?, SEG_20300 = ?, SEG_20400 = ?, SEG_20500 = ?, SEG_20600 = ?, SEG_30100 = ?, SEG_30200 = ?, SEG_30300 = ?, SEG_30400 = ?, SEG_40100 = ?, SEG_40200 = ?, SEG_40300 = ?, SEG_40400 = ?, SEG_50100 = ?, SEG_50200 = ?, SEG_50300 = ?, SEG_50400 = ?, SEG_60100 = ?, SEG_60200 = ?, SEG_60300 = ?, SEG_60400 = ?, SEG_80100 = ?, SEG_80200 = ?, SEG_80300 = ?, SEG_80400 = ?, SEG_80500 = ?, SEG_80600 = ?, SEG_80700 = ?, SEG_90200 = ?, SEG_99900 = ?, DESVIN = ?, POCOVIN = ?, VIN = ?, MUYVIN = ?, NATDESVIN = ?, NATVIN = ?, JURVIN = ?, AHOR_T = ?, AHSD_T = ?, AVAL_T = ?, B24_T = ?, CCTE_T = ?, CEXT_T = ?, CLOC_T = ?, COLB_T = ?, CPTE_T = ?, CTS_T = ?, CTSD_T = ?, VIP_T = ?, DSCT_T = ?, FCEX_T = ?, FMUT_T = ?, LCTA_T = ?, LEAS_T = ?, MCLA_T = ?, MORO_T = ?, MP_T = ?, PAUT_T = ?, PCOM_T = ?, PER_T = ?, PH_T = ?, PHIP_T = ?, PLZO_T = ?, PMAS_T = ?, PMIV_T = ?, PPER_T = ?, PPPER_T = ?, PREF_T = ?, PROM_T = ?, PSER_T = ?, PSERV_T = ?, DEP_T = ?, SDEP_T = ?, SEXT_T = ?, SONC_T = ?, SPRO_T = ?, VID_T = ?, SVID_T = ?, TDE_T = ?, SVIP_T = ?, TVIP_T = ?, VARC_T = ?, VCLA_T = ?, VCTR_T = ?, VEMP_T = ?, VNAC_T = ?, VORO_T = ?, VPLA_T = ?, VPOLA_T = ?, VREP_T = ?, TDEB_T = ?, CNET_T = ?, LINCO_T = ?, POS_T = ?, EMPH_T = ?, RIESGO_D_T = ?, RIESGO_I_T = ?, RIESGO_T = ?, PASIVO_T = ?, VOLUMEN_T = ?, SUM_T_ACT = ?, SUM_T_ACT1 = ?, SUM_T_ACT2 = ?, SUM_T_ACT3 = ?, SUM_T_ACT4 = ?, SUM_T_ACT5 = ?, SUM_T_ACT6 = ?, SUM_ACT_CTO = ?, SUM_ACT_CT1 = ?, SUM_ACT_CT2 = ?, SUM_ACT_CT3 = ?, SUM_ACT_CT4 = ?, SUM_ACT_CT5 = ?, SUM_ACT_CT6 = ?, CEMP_T = ?, CVIP_T = ?, ICALICTE00 = ?, ICALICTE10 = ?, ICALICTE20 = ?, ICALICTE30 = ?, ICALICTE40 = ?, MOFACTV_T = ?, CS000LINEAMAXTC_T = ?, CS000MTOPRESTAMO_T = ?, MONTOVEHICULAR_T = ?, MONTOHIPOTECARIO_T = ?, MONTOSUBROGADOS_T = ? WHERE COD_TOTAL = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column COD_TOTAL
			// For column COD_TOTAL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(0);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(136,tempBigDecimal);
				else
					pstmt.setNull(136,java.sql.Types.NUMERIC);
			}
			// For column COD_TERRITORIO
			// For column COD_TERRITORIO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column IND_REGISTRO
			// For column IND_REGISTRO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
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
			// For column CLIXGEST
			// For column CLIXGEST
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(5,tempBigDecimal);
				else
					pstmt.setNull(5,java.sql.Types.NUMERIC);
			}
			// For column SEG_10100
			// For column SEG_10100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(6);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(6,tempBigDecimal);
				else
					pstmt.setNull(6,java.sql.Types.NUMERIC);
			}
			// For column SEG_10200
			// For column SEG_10200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(7,tempBigDecimal);
				else
					pstmt.setNull(7,java.sql.Types.NUMERIC);
			}
			// For column SEG_20100
			// For column SEG_20100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(8);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(8,tempBigDecimal);
				else
					pstmt.setNull(8,java.sql.Types.NUMERIC);
			}
			// For column SEG_20200
			// For column SEG_20200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(9);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(9,tempBigDecimal);
				else
					pstmt.setNull(9,java.sql.Types.NUMERIC);
			}
			// For column SEG_20300
			// For column SEG_20300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(10);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(10,tempBigDecimal);
				else
					pstmt.setNull(10,java.sql.Types.NUMERIC);
			}
			// For column SEG_20400
			// For column SEG_20400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(11,tempBigDecimal);
				else
					pstmt.setNull(11,java.sql.Types.NUMERIC);
			}
			// For column SEG_20500
			// For column SEG_20500
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(12);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(12,tempBigDecimal);
				else
					pstmt.setNull(12,java.sql.Types.NUMERIC);
			}
			// For column SEG_20600
			// For column SEG_20600
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(13);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(13,tempBigDecimal);
				else
					pstmt.setNull(13,java.sql.Types.NUMERIC);
			}
			// For column SEG_30100
			// For column SEG_30100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(14);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(14,tempBigDecimal);
				else
					pstmt.setNull(14,java.sql.Types.NUMERIC);
			}
			// For column SEG_30200
			// For column SEG_30200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(15);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(15,tempBigDecimal);
				else
					pstmt.setNull(15,java.sql.Types.NUMERIC);
			}
			// For column SEG_30300
			// For column SEG_30300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(16);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(16,tempBigDecimal);
				else
					pstmt.setNull(16,java.sql.Types.NUMERIC);
			}
			// For column SEG_30400
			// For column SEG_30400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(17);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(17,tempBigDecimal);
				else
					pstmt.setNull(17,java.sql.Types.NUMERIC);
			}
			// For column SEG_40100
			// For column SEG_40100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(18);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(18,tempBigDecimal);
				else
					pstmt.setNull(18,java.sql.Types.NUMERIC);
			}
			// For column SEG_40200
			// For column SEG_40200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(19);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(19,tempBigDecimal);
				else
					pstmt.setNull(19,java.sql.Types.NUMERIC);
			}
			// For column SEG_40300
			// For column SEG_40300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(20);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(20,tempBigDecimal);
				else
					pstmt.setNull(20,java.sql.Types.NUMERIC);
			}
			// For column SEG_40400
			// For column SEG_40400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(21);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(21,tempBigDecimal);
				else
					pstmt.setNull(21,java.sql.Types.NUMERIC);
			}
			// For column SEG_50100
			// For column SEG_50100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(22);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(22,tempBigDecimal);
				else
					pstmt.setNull(22,java.sql.Types.NUMERIC);
			}
			// For column SEG_50200
			// For column SEG_50200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(23);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(23,tempBigDecimal);
				else
					pstmt.setNull(23,java.sql.Types.NUMERIC);
			}
			// For column SEG_50300
			// For column SEG_50300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(24);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(24,tempBigDecimal);
				else
					pstmt.setNull(24,java.sql.Types.NUMERIC);
			}
			// For column SEG_50400
			// For column SEG_50400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(25);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(25,tempBigDecimal);
				else
					pstmt.setNull(25,java.sql.Types.NUMERIC);
			}
			// For column SEG_60100
			// For column SEG_60100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(26);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(26,tempBigDecimal);
				else
					pstmt.setNull(26,java.sql.Types.NUMERIC);
			}
			// For column SEG_60200
			// For column SEG_60200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(27);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(27,tempBigDecimal);
				else
					pstmt.setNull(27,java.sql.Types.NUMERIC);
			}
			// For column SEG_60300
			// For column SEG_60300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(28);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(28,tempBigDecimal);
				else
					pstmt.setNull(28,java.sql.Types.NUMERIC);
			}
			// For column SEG_60400
			// For column SEG_60400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(29);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(29,tempBigDecimal);
				else
					pstmt.setNull(29,java.sql.Types.NUMERIC);
			}
			// For column SEG_80100
			// For column SEG_80100
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(30);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(30,tempBigDecimal);
				else
					pstmt.setNull(30,java.sql.Types.NUMERIC);
			}
			// For column SEG_80200
			// For column SEG_80200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(31);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(31,tempBigDecimal);
				else
					pstmt.setNull(31,java.sql.Types.NUMERIC);
			}
			// For column SEG_80300
			// For column SEG_80300
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(32);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(32,tempBigDecimal);
				else
					pstmt.setNull(32,java.sql.Types.NUMERIC);
			}
			// For column SEG_80400
			// For column SEG_80400
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(33);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(33,tempBigDecimal);
				else
					pstmt.setNull(33,java.sql.Types.NUMERIC);
			}
			// For column SEG_80500
			// For column SEG_80500
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(34);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(34,tempBigDecimal);
				else
					pstmt.setNull(34,java.sql.Types.NUMERIC);
			}
			// For column SEG_80600
			// For column SEG_80600
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(35);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(35,tempBigDecimal);
				else
					pstmt.setNull(35,java.sql.Types.NUMERIC);
			}
			// For column SEG_80700
			// For column SEG_80700
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(36);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(36,tempBigDecimal);
				else
					pstmt.setNull(36,java.sql.Types.NUMERIC);
			}
			// For column SEG_90200
			// For column SEG_90200
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(37);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(37,tempBigDecimal);
				else
					pstmt.setNull(37,java.sql.Types.NUMERIC);
			}
			// For column SEG_99900
			// For column SEG_99900
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(38);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(38,tempBigDecimal);
				else
					pstmt.setNull(38,java.sql.Types.NUMERIC);
			}
			// For column DESVIN
			// For column DESVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(39);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(39,tempBigDecimal);
				else
					pstmt.setNull(39,java.sql.Types.NUMERIC);
			}
			// For column POCOVIN
			// For column POCOVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(40);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(40,tempBigDecimal);
				else
					pstmt.setNull(40,java.sql.Types.NUMERIC);
			}
			// For column VIN
			// For column VIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(41);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(41,tempBigDecimal);
				else
					pstmt.setNull(41,java.sql.Types.NUMERIC);
			}
			// For column MUYVIN
			// For column MUYVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(42);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(42,tempBigDecimal);
				else
					pstmt.setNull(42,java.sql.Types.NUMERIC);
			}
			// For column NATDESVIN
			// For column NATDESVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(43);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(43,tempBigDecimal);
				else
					pstmt.setNull(43,java.sql.Types.NUMERIC);
			}
			// For column NATVIN
			// For column NATVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(44);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(44,tempBigDecimal);
				else
					pstmt.setNull(44,java.sql.Types.NUMERIC);
			}
			// For column JURVIN
			// For column JURVIN
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(45);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(45,tempBigDecimal);
				else
					pstmt.setNull(45,java.sql.Types.NUMERIC);
			}
			// For column AHOR_T
			// For column AHOR_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(46);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(46,tempBigDecimal);
				else
					pstmt.setNull(46,java.sql.Types.NUMERIC);
			}
			// For column AHSD_T
			// For column AHSD_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(47);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(47,tempBigDecimal);
				else
					pstmt.setNull(47,java.sql.Types.NUMERIC);
			}
			// For column AVAL_T
			// For column AVAL_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(48);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(48,tempBigDecimal);
				else
					pstmt.setNull(48,java.sql.Types.NUMERIC);
			}
			// For column B24_T
			// For column B24_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(49);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(49,tempBigDecimal);
				else
					pstmt.setNull(49,java.sql.Types.NUMERIC);
			}
			// For column CCTE_T
			// For column CCTE_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(50);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(50,tempBigDecimal);
				else
					pstmt.setNull(50,java.sql.Types.NUMERIC);
			}
			// For column CEXT_T
			// For column CEXT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(51);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(51,tempBigDecimal);
				else
					pstmt.setNull(51,java.sql.Types.NUMERIC);
			}
			// For column CLOC_T
			// For column CLOC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(52);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(52,tempBigDecimal);
				else
					pstmt.setNull(52,java.sql.Types.NUMERIC);
			}
			// For column COLB_T
			// For column COLB_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(53);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(53,tempBigDecimal);
				else
					pstmt.setNull(53,java.sql.Types.NUMERIC);
			}
			// For column CPTE_T
			// For column CPTE_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(54);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(54,tempBigDecimal);
				else
					pstmt.setNull(54,java.sql.Types.NUMERIC);
			}
			// For column CTS_T
			// For column CTS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(55);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(55,tempBigDecimal);
				else
					pstmt.setNull(55,java.sql.Types.NUMERIC);
			}
			// For column CTSD_T
			// For column CTSD_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(56);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(56,tempBigDecimal);
				else
					pstmt.setNull(56,java.sql.Types.NUMERIC);
			}
			// For column VIP_T
			// For column VIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(57);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(57,tempBigDecimal);
				else
					pstmt.setNull(57,java.sql.Types.NUMERIC);
			}
			// For column DSCT_T
			// For column DSCT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(58);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(58,tempBigDecimal);
				else
					pstmt.setNull(58,java.sql.Types.NUMERIC);
			}
			// For column FCEX_T
			// For column FCEX_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(59);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(59,tempBigDecimal);
				else
					pstmt.setNull(59,java.sql.Types.NUMERIC);
			}
			// For column FMUT_T
			// For column FMUT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(60);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(60,tempBigDecimal);
				else
					pstmt.setNull(60,java.sql.Types.NUMERIC);
			}
			// For column LCTA_T
			// For column LCTA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(61);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(61,tempBigDecimal);
				else
					pstmt.setNull(61,java.sql.Types.NUMERIC);
			}
			// For column LEAS_T
			// For column LEAS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(62);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(62,tempBigDecimal);
				else
					pstmt.setNull(62,java.sql.Types.NUMERIC);
			}
			// For column MCLA_T
			// For column MCLA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(63);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(63,tempBigDecimal);
				else
					pstmt.setNull(63,java.sql.Types.NUMERIC);
			}
			// For column MORO_T
			// For column MORO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(64);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(64,tempBigDecimal);
				else
					pstmt.setNull(64,java.sql.Types.NUMERIC);
			}
			// For column MP_T
			// For column MP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(65);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(65,tempBigDecimal);
				else
					pstmt.setNull(65,java.sql.Types.NUMERIC);
			}
			// For column PAUT_T
			// For column PAUT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(66);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(66,tempBigDecimal);
				else
					pstmt.setNull(66,java.sql.Types.NUMERIC);
			}
			// For column PCOM_T
			// For column PCOM_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(67);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(67,tempBigDecimal);
				else
					pstmt.setNull(67,java.sql.Types.NUMERIC);
			}
			// For column PER_T
			// For column PER_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(68);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(68,tempBigDecimal);
				else
					pstmt.setNull(68,java.sql.Types.NUMERIC);
			}
			// For column PH_T
			// For column PH_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(69);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(69,tempBigDecimal);
				else
					pstmt.setNull(69,java.sql.Types.NUMERIC);
			}
			// For column PHIP_T
			// For column PHIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(70);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(70,tempBigDecimal);
				else
					pstmt.setNull(70,java.sql.Types.NUMERIC);
			}
			// For column PLZO_T
			// For column PLZO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(71);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(71,tempBigDecimal);
				else
					pstmt.setNull(71,java.sql.Types.NUMERIC);
			}
			// For column PMAS_T
			// For column PMAS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(72);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(72,tempBigDecimal);
				else
					pstmt.setNull(72,java.sql.Types.NUMERIC);
			}
			// For column PMIV_T
			// For column PMIV_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(73);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(73,tempBigDecimal);
				else
					pstmt.setNull(73,java.sql.Types.NUMERIC);
			}
			// For column PPER_T
			// For column PPER_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(74);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(74,tempBigDecimal);
				else
					pstmt.setNull(74,java.sql.Types.NUMERIC);
			}
			// For column PPPER_T
			// For column PPPER_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(75);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(75,tempBigDecimal);
				else
					pstmt.setNull(75,java.sql.Types.NUMERIC);
			}
			// For column PREF_T
			// For column PREF_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(76);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(76,tempBigDecimal);
				else
					pstmt.setNull(76,java.sql.Types.NUMERIC);
			}
			// For column PROM_T
			// For column PROM_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(77);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(77,tempBigDecimal);
				else
					pstmt.setNull(77,java.sql.Types.NUMERIC);
			}
			// For column PSER_T
			// For column PSER_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(78);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(78,tempBigDecimal);
				else
					pstmt.setNull(78,java.sql.Types.NUMERIC);
			}
			// For column PSERV_T
			// For column PSERV_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(79);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(79,tempBigDecimal);
				else
					pstmt.setNull(79,java.sql.Types.NUMERIC);
			}
			// For column DEP_T
			// For column DEP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(80);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(80,tempBigDecimal);
				else
					pstmt.setNull(80,java.sql.Types.NUMERIC);
			}
			// For column SDEP_T
			// For column SDEP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(81);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(81,tempBigDecimal);
				else
					pstmt.setNull(81,java.sql.Types.NUMERIC);
			}
			// For column SEXT_T
			// For column SEXT_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(82);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(82,tempBigDecimal);
				else
					pstmt.setNull(82,java.sql.Types.NUMERIC);
			}
			// For column SONC_T
			// For column SONC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(83);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(83,tempBigDecimal);
				else
					pstmt.setNull(83,java.sql.Types.NUMERIC);
			}
			// For column SPRO_T
			// For column SPRO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(84);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(84,tempBigDecimal);
				else
					pstmt.setNull(84,java.sql.Types.NUMERIC);
			}
			// For column VID_T
			// For column VID_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(85);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(85,tempBigDecimal);
				else
					pstmt.setNull(85,java.sql.Types.NUMERIC);
			}
			// For column SVID_T
			// For column SVID_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(86);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(86,tempBigDecimal);
				else
					pstmt.setNull(86,java.sql.Types.NUMERIC);
			}
			// For column TDE_T
			// For column TDE_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(87);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(87,tempBigDecimal);
				else
					pstmt.setNull(87,java.sql.Types.NUMERIC);
			}
			// For column SVIP_T
			// For column SVIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(88);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(88,tempBigDecimal);
				else
					pstmt.setNull(88,java.sql.Types.NUMERIC);
			}
			// For column TVIP_T
			// For column TVIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(89);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(89,tempBigDecimal);
				else
					pstmt.setNull(89,java.sql.Types.NUMERIC);
			}
			// For column VARC_T
			// For column VARC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(90);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(90,tempBigDecimal);
				else
					pstmt.setNull(90,java.sql.Types.NUMERIC);
			}
			// For column VCLA_T
			// For column VCLA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(91);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(91,tempBigDecimal);
				else
					pstmt.setNull(91,java.sql.Types.NUMERIC);
			}
			// For column VCTR_T
			// For column VCTR_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(92);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(92,tempBigDecimal);
				else
					pstmt.setNull(92,java.sql.Types.NUMERIC);
			}
			// For column VEMP_T
			// For column VEMP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(93);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(93,tempBigDecimal);
				else
					pstmt.setNull(93,java.sql.Types.NUMERIC);
			}
			// For column VNAC_T
			// For column VNAC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(94);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(94,tempBigDecimal);
				else
					pstmt.setNull(94,java.sql.Types.NUMERIC);
			}
			// For column VORO_T
			// For column VORO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(95);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(95,tempBigDecimal);
				else
					pstmt.setNull(95,java.sql.Types.NUMERIC);
			}
			// For column VPLA_T
			// For column VPLA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(96);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(96,tempBigDecimal);
				else
					pstmt.setNull(96,java.sql.Types.NUMERIC);
			}
			// For column VPOLA_T
			// For column VPOLA_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(97);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(97,tempBigDecimal);
				else
					pstmt.setNull(97,java.sql.Types.NUMERIC);
			}
			// For column VREP_T
			// For column VREP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(98);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(98,tempBigDecimal);
				else
					pstmt.setNull(98,java.sql.Types.NUMERIC);
			}
			// For column TDEB_T
			// For column TDEB_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(99);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(99,tempBigDecimal);
				else
					pstmt.setNull(99,java.sql.Types.NUMERIC);
			}
			// For column CNET_T
			// For column CNET_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(100);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(100,tempBigDecimal);
				else
					pstmt.setNull(100,java.sql.Types.NUMERIC);
			}
			// For column LINCO_T
			// For column LINCO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(101);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(101,tempBigDecimal);
				else
					pstmt.setNull(101,java.sql.Types.NUMERIC);
			}
			// For column POS_T
			// For column POS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(102);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(102,tempBigDecimal);
				else
					pstmt.setNull(102,java.sql.Types.NUMERIC);
			}
			// For column EMPH_T
			// For column EMPH_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(103);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(103,tempBigDecimal);
				else
					pstmt.setNull(103,java.sql.Types.NUMERIC);
			}
			// For column RIESGO_D_T
			// For column RIESGO_D_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(104);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(104,tempBigDecimal);
				else
					pstmt.setNull(104,java.sql.Types.NUMERIC);
			}
			// For column RIESGO_I_T
			// For column RIESGO_I_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(105);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(105,tempBigDecimal);
				else
					pstmt.setNull(105,java.sql.Types.NUMERIC);
			}
			// For column RIESGO_T
			// For column RIESGO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(106);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(106,tempBigDecimal);
				else
					pstmt.setNull(106,java.sql.Types.NUMERIC);
			}
			// For column PASIVO_T
			// For column PASIVO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(107);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(107,tempBigDecimal);
				else
					pstmt.setNull(107,java.sql.Types.NUMERIC);
			}
			// For column VOLUMEN_T
			// For column VOLUMEN_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(108);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(108,tempBigDecimal);
				else
					pstmt.setNull(108,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT
			// For column SUM_T_ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(109);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(109,tempBigDecimal);
				else
					pstmt.setNull(109,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT1
			// For column SUM_T_ACT1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(110);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(110,tempBigDecimal);
				else
					pstmt.setNull(110,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT2
			// For column SUM_T_ACT2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(111);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(111,tempBigDecimal);
				else
					pstmt.setNull(111,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT3
			// For column SUM_T_ACT3
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(112);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(112,tempBigDecimal);
				else
					pstmt.setNull(112,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT4
			// For column SUM_T_ACT4
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(113);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(113,tempBigDecimal);
				else
					pstmt.setNull(113,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT5
			// For column SUM_T_ACT5
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(114);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(114,tempBigDecimal);
				else
					pstmt.setNull(114,java.sql.Types.NUMERIC);
			}
			// For column SUM_T_ACT6
			// For column SUM_T_ACT6
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(115);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(115,tempBigDecimal);
				else
					pstmt.setNull(115,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CTO
			// For column SUM_ACT_CTO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(116);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(116,tempBigDecimal);
				else
					pstmt.setNull(116,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT1
			// For column SUM_ACT_CT1
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(117);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(117,tempBigDecimal);
				else
					pstmt.setNull(117,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT2
			// For column SUM_ACT_CT2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(118);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(118,tempBigDecimal);
				else
					pstmt.setNull(118,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT3
			// For column SUM_ACT_CT3
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(119);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(119,tempBigDecimal);
				else
					pstmt.setNull(119,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT4
			// For column SUM_ACT_CT4
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(120);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(120,tempBigDecimal);
				else
					pstmt.setNull(120,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT5
			// For column SUM_ACT_CT5
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(121);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(121,tempBigDecimal);
				else
					pstmt.setNull(121,java.sql.Types.NUMERIC);
			}
			// For column SUM_ACT_CT6
			// For column SUM_ACT_CT6
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(122);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(122,tempBigDecimal);
				else
					pstmt.setNull(122,java.sql.Types.NUMERIC);
			}
			// For column CEMP_T
			// For column CEMP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(123);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(123,tempBigDecimal);
				else
					pstmt.setNull(123,java.sql.Types.NUMERIC);
			}
			// For column CVIP_T
			// For column CVIP_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(124);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(124,tempBigDecimal);
				else
					pstmt.setNull(124,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE00
			// For column ICALICTE00
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(125);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(125,tempBigDecimal);
				else
					pstmt.setNull(125,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE10
			// For column ICALICTE10
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(126);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(126,tempBigDecimal);
				else
					pstmt.setNull(126,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE20
			// For column ICALICTE20
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(127);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(127,tempBigDecimal);
				else
					pstmt.setNull(127,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE30
			// For column ICALICTE30
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(128);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(128,tempBigDecimal);
				else
					pstmt.setNull(128,java.sql.Types.NUMERIC);
			}
			// For column ICALICTE40
			// For column ICALICTE40
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(129);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(129,tempBigDecimal);
				else
					pstmt.setNull(129,java.sql.Types.NUMERIC);
			}
			// For column MOFACTV_T
			// For column MOFACTV_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(130);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(130,tempBigDecimal);
				else
					pstmt.setNull(130,java.sql.Types.NUMERIC);
			}
			// For column CS000LINEAMAXTC_T
			// For column CS000LINEAMAXTC_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(131);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(131,tempBigDecimal);
				else
					pstmt.setNull(131,java.sql.Types.NUMERIC);
			}
			// For column CS000MTOPRESTAMO_T
			// For column CS000MTOPRESTAMO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(132);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(132,tempBigDecimal);
				else
					pstmt.setNull(132,java.sql.Types.NUMERIC);
			}
			// For column MONTOVEHICULAR_T
			// For column MONTOVEHICULAR_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(133);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(133,tempBigDecimal);
				else
					pstmt.setNull(133,java.sql.Types.NUMERIC);
			}
			// For column MONTOHIPOTECARIO_T
			// For column MONTOHIPOTECARIO_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(134);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(134,tempBigDecimal);
				else
					pstmt.setNull(134,java.sql.Types.NUMERIC);
			}
			// For column MONTOSUBROGADOS_T
			// For column MONTOSUBROGADOS_T
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(135);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(135,tempBigDecimal);
				else
					pstmt.setNull(135,java.sql.Types.NUMERIC);
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
	private static String findTotalxGexOfxTeQuery_0 = " select  q1.\"COD_TOTAL\",  q1.\"COD_TERRITORIO\",  q1.\"IND_REGISTRO\",  q1.\"COD_OFICINA\",  q1.\"COD_GESTOR\",  q1.\"CLIXGEST\",  q1.\"SEG_10100\",  q1.\"SEG_10200\",  q1.\"SEG_20100\",  q1.\"SEG_20200\",  q1.\"SEG_20300\",  q1.\"SEG_20400\",  q1.\"SEG_20500\",  q1.\"SEG_20600\",  q1.\"SEG_30100\",  q1.\"SEG_30200\",  q1.\"SEG_30300\",  q1.\"SEG_30400\",  q1.\"SEG_40100\",  q1.\"SEG_40200\",  q1.\"SEG_40300\",  q1.\"SEG_40400\",  q1.\"SEG_50100\",  q1.\"SEG_50200\",  q1.\"SEG_50300\",  q1.\"SEG_50400\",  q1.\"SEG_60100\",  q1.\"SEG_60200\",  q1.\"SEG_60300\",  q1.\"SEG_60400\",  q1.\"SEG_80100\",  q1.\"SEG_80200\",  q1.\"SEG_80300\",  q1.\"SEG_80400\",  q1.\"SEG_80500\",  q1.\"SEG_80600\",  q1.\"SEG_80700\",  q1.\"SEG_90200\",  q1.\"SEG_99900\",  q1.\"DESVIN\",  q1.\"POCOVIN\",  q1.\"VIN\",  q1.\"MUYVIN\",  q1.\"NATDESVIN\",  q1.\"NATVIN\",  q1.\"JURVIN\",  q1.\"AHOR_T\",  q1.\"AHSD_T\",  q1.\"AVAL_T\",  q1.\"B24_T\",  q1.\"CCTE_T\",  q1.\"CEXT_T\",  q1.\"CLOC_T\",  q1.\"COLB_T\",  q1.\"CPTE_T\",  q1.\"CTS_T\",  q1.\"CTSD_T\",  q1.\"VIP_T\",  q1.\"DSCT_T\",  q1.\"FCEX_T\",  q1.\"FMUT_T\",  q1.\"LCTA_T\",  q1.\"LEAS_T\",  q1.\"MCLA_T\",  q1.\"MORO_T\",  q1.\"MP_T\",  q1.\"PAUT_T\",  q1.\"PCOM_T\",  q1.\"PER_T\",  q1.\"PH_T\",  q1.\"PHIP_T\",  q1.\"PLZO_T\",  q1.\"PMAS_T\",  q1.\"PMIV_T\",  q1.\"PPER_T\",  q1.\"PPPER_T\",  q1.\"PREF_T\",  q1.\"PROM_T\",  q1.\"PSER_T\",  q1.\"PSERV_T\",  q1.\"DEP_T\",  q1.\"SDEP_T\",  q1.\"SEXT_T\",  q1.\"SONC_T\",  q1.\"SPRO_T\",  q1.\"VID_T\",  q1.\"SVID_T\",  q1.\"TDE_T\",  q1.\"SVIP_T\",  q1.\"TVIP_T\",  q1.\"VARC_T\",  q1.\"VCLA_T\",  q1.\"VCTR_T\",  q1.\"VEMP_T\",  q1.\"VNAC_T\",  q1.\"VORO_T\",  q1.\"VPLA_T\",  q1.\"VPOLA_T\",  q1.\"VREP_T\",  q1.\"TDEB_T\",  q1.\"CNET_T\",  q1.\"LINCO_T\",  q1.\"POS_T\",  q1.\"EMPH_T\",  q1.\"RIESGO_D_T\",  q1.\"RIESGO_I_T\",  q1.\"RIESGO_T\",  q1.\"PASIVO_T\",  q1.\"VOLUMEN_T\",  q1.\"SUM_T_ACT\",  q1.\"SUM_T_ACT1\",  q1.\"SUM_T_ACT2\",  q1.\"SUM_T_ACT3\",  q1.\"SUM_T_ACT4\",  q1.\"SUM_T_ACT5\",  q1.\"SUM_T_ACT6\",  q1.\"SUM_ACT_CTO\",  q1.\"SUM_ACT_CT1\",  q1.\"SUM_ACT_CT2\",  q1.\"SUM_ACT_CT3\",  q1.\"SUM_ACT_CT4\",  q1.\"SUM_ACT_CT5\",  q1.\"SUM_ACT_CT6\",  q1.\"CEMP_T\",  q1.\"CVIP_T\",  q1.\"ICALICTE00\",  q1.\"ICALICTE10\",  q1.\"ICALICTE20\",  q1.\"ICALICTE30\",  q1.\"ICALICTE40\",  q1.\"MOFACTV_T\",  q1.\"CS000LINEAMAXTC_T\",  q1.\"CS000MTOPRESTAMO_T\",  q1.\"MONTOVEHICULAR_T\",  q1.\"MONTOHIPOTECARIO_T\",  q1.\"MONTOSUBROGADOS_T\" from IILC.TIILC_TOTAL q1 where  ( q1.\"IND_REGISTRO\" LIKE ?)  and  ( q1.\"COD_TERRITORIO\" LIKE ?)  and  ( q1.\"COD_OFICINA\" LIKE ?)  and  ( q1.\"COD_GESTOR\" LIKE ?) ";
	/**
	 * FindTotalxGexOfxTe
	 */
	public javax.resource.cci.Record FindTotalxGexOfxTe(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_total o where  o.ind_registro like ?1 AND o.cod_territorio like ?2 AND o.cod_oficina like ?3 AND o.cod_gestor like ?4 */
			pstmt = prepareStatement(connection, findTotalxGexOfxTeQuery_0);

			// For ?1 (ind_registro)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (cod_territorio)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (cod_oficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (cod_gestor)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findTotalxGexOfxTeQuery_0);

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
	private static String findTotalxGexOfxTeForUpdateQuery_0 = " select  q1.\"COD_TOTAL\",  q1.\"COD_TERRITORIO\",  q1.\"IND_REGISTRO\",  q1.\"COD_OFICINA\",  q1.\"COD_GESTOR\",  q1.\"CLIXGEST\",  q1.\"SEG_10100\",  q1.\"SEG_10200\",  q1.\"SEG_20100\",  q1.\"SEG_20200\",  q1.\"SEG_20300\",  q1.\"SEG_20400\",  q1.\"SEG_20500\",  q1.\"SEG_20600\",  q1.\"SEG_30100\",  q1.\"SEG_30200\",  q1.\"SEG_30300\",  q1.\"SEG_30400\",  q1.\"SEG_40100\",  q1.\"SEG_40200\",  q1.\"SEG_40300\",  q1.\"SEG_40400\",  q1.\"SEG_50100\",  q1.\"SEG_50200\",  q1.\"SEG_50300\",  q1.\"SEG_50400\",  q1.\"SEG_60100\",  q1.\"SEG_60200\",  q1.\"SEG_60300\",  q1.\"SEG_60400\",  q1.\"SEG_80100\",  q1.\"SEG_80200\",  q1.\"SEG_80300\",  q1.\"SEG_80400\",  q1.\"SEG_80500\",  q1.\"SEG_80600\",  q1.\"SEG_80700\",  q1.\"SEG_90200\",  q1.\"SEG_99900\",  q1.\"DESVIN\",  q1.\"POCOVIN\",  q1.\"VIN\",  q1.\"MUYVIN\",  q1.\"NATDESVIN\",  q1.\"NATVIN\",  q1.\"JURVIN\",  q1.\"AHOR_T\",  q1.\"AHSD_T\",  q1.\"AVAL_T\",  q1.\"B24_T\",  q1.\"CCTE_T\",  q1.\"CEXT_T\",  q1.\"CLOC_T\",  q1.\"COLB_T\",  q1.\"CPTE_T\",  q1.\"CTS_T\",  q1.\"CTSD_T\",  q1.\"VIP_T\",  q1.\"DSCT_T\",  q1.\"FCEX_T\",  q1.\"FMUT_T\",  q1.\"LCTA_T\",  q1.\"LEAS_T\",  q1.\"MCLA_T\",  q1.\"MORO_T\",  q1.\"MP_T\",  q1.\"PAUT_T\",  q1.\"PCOM_T\",  q1.\"PER_T\",  q1.\"PH_T\",  q1.\"PHIP_T\",  q1.\"PLZO_T\",  q1.\"PMAS_T\",  q1.\"PMIV_T\",  q1.\"PPER_T\",  q1.\"PPPER_T\",  q1.\"PREF_T\",  q1.\"PROM_T\",  q1.\"PSER_T\",  q1.\"PSERV_T\",  q1.\"DEP_T\",  q1.\"SDEP_T\",  q1.\"SEXT_T\",  q1.\"SONC_T\",  q1.\"SPRO_T\",  q1.\"VID_T\",  q1.\"SVID_T\",  q1.\"TDE_T\",  q1.\"SVIP_T\",  q1.\"TVIP_T\",  q1.\"VARC_T\",  q1.\"VCLA_T\",  q1.\"VCTR_T\",  q1.\"VEMP_T\",  q1.\"VNAC_T\",  q1.\"VORO_T\",  q1.\"VPLA_T\",  q1.\"VPOLA_T\",  q1.\"VREP_T\",  q1.\"TDEB_T\",  q1.\"CNET_T\",  q1.\"LINCO_T\",  q1.\"POS_T\",  q1.\"EMPH_T\",  q1.\"RIESGO_D_T\",  q1.\"RIESGO_I_T\",  q1.\"RIESGO_T\",  q1.\"PASIVO_T\",  q1.\"VOLUMEN_T\",  q1.\"SUM_T_ACT\",  q1.\"SUM_T_ACT1\",  q1.\"SUM_T_ACT2\",  q1.\"SUM_T_ACT3\",  q1.\"SUM_T_ACT4\",  q1.\"SUM_T_ACT5\",  q1.\"SUM_T_ACT6\",  q1.\"SUM_ACT_CTO\",  q1.\"SUM_ACT_CT1\",  q1.\"SUM_ACT_CT2\",  q1.\"SUM_ACT_CT3\",  q1.\"SUM_ACT_CT4\",  q1.\"SUM_ACT_CT5\",  q1.\"SUM_ACT_CT6\",  q1.\"CEMP_T\",  q1.\"CVIP_T\",  q1.\"ICALICTE00\",  q1.\"ICALICTE10\",  q1.\"ICALICTE20\",  q1.\"ICALICTE30\",  q1.\"ICALICTE40\",  q1.\"MOFACTV_T\",  q1.\"CS000LINEAMAXTC_T\",  q1.\"CS000MTOPRESTAMO_T\",  q1.\"MONTOVEHICULAR_T\",  q1.\"MONTOHIPOTECARIO_T\",  q1.\"MONTOSUBROGADOS_T\" from IILC.TIILC_TOTAL q1 where  ( q1.\"IND_REGISTRO\" LIKE ?)  and  ( q1.\"COD_TERRITORIO\" LIKE ?)  and  ( q1.\"COD_OFICINA\" LIKE ?)  and  ( q1.\"COD_GESTOR\" LIKE ?)  for update ";
	/**
	 * FindTotalxGexOfxTe444Update
	 */
	public javax.resource.cci.Record FindTotalxGexOfxTe444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiilc_total o where  o.ind_registro like ?1 AND o.cod_territorio like ?2 AND o.cod_oficina like ?3 AND o.cod_gestor like ?4 */
			pstmt = prepareStatement(connection, findTotalxGexOfxTeForUpdateQuery_0);

			// For ?1 (ind_registro)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (cod_territorio)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (cod_oficina)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (cod_gestor)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findTotalxGexOfxTeForUpdateQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.COD_TOTAL, T1.COD_TERRITORIO, T1.IND_REGISTRO, T1.COD_OFICINA, T1.COD_GESTOR, T1.CLIXGEST, T1.SEG_10100, T1.SEG_10200, T1.SEG_20100, T1.SEG_20200, T1.SEG_20300, T1.SEG_20400, T1.SEG_20500, T1.SEG_20600, T1.SEG_30100, T1.SEG_30200, T1.SEG_30300, T1.SEG_30400, T1.SEG_40100, T1.SEG_40200, T1.SEG_40300, T1.SEG_40400, T1.SEG_50100, T1.SEG_50200, T1.SEG_50300, T1.SEG_50400, T1.SEG_60100, T1.SEG_60200, T1.SEG_60300, T1.SEG_60400, T1.SEG_80100, T1.SEG_80200, T1.SEG_80300, T1.SEG_80400, T1.SEG_80500, T1.SEG_80600, T1.SEG_80700, T1.SEG_90200, T1.SEG_99900, T1.DESVIN, T1.POCOVIN, T1.VIN, T1.MUYVIN, T1.NATDESVIN, T1.NATVIN, T1.JURVIN, T1.AHOR_T, T1.AHSD_T, T1.AVAL_T, T1.B24_T, T1.CCTE_T, T1.CEXT_T, T1.CLOC_T, T1.COLB_T, T1.CPTE_T, T1.CTS_T, T1.CTSD_T, T1.VIP_T, T1.DSCT_T, T1.FCEX_T, T1.FMUT_T, T1.LCTA_T, T1.LEAS_T, T1.MCLA_T, T1.MORO_T, T1.MP_T, T1.PAUT_T, T1.PCOM_T, T1.PER_T, T1.PH_T, T1.PHIP_T, T1.PLZO_T, T1.PMAS_T, T1.PMIV_T, T1.PPER_T, T1.PPPER_T, T1.PREF_T, T1.PROM_T, T1.PSER_T, T1.PSERV_T, T1.DEP_T, T1.SDEP_T, T1.SEXT_T, T1.SONC_T, T1.SPRO_T, T1.VID_T, T1.SVID_T, T1.TDE_T, T1.SVIP_T, T1.TVIP_T, T1.VARC_T, T1.VCLA_T, T1.VCTR_T, T1.VEMP_T, T1.VNAC_T, T1.VORO_T, T1.VPLA_T, T1.VPOLA_T, T1.VREP_T, T1.TDEB_T, T1.CNET_T, T1.LINCO_T, T1.POS_T, T1.EMPH_T, T1.RIESGO_D_T, T1.RIESGO_I_T, T1.RIESGO_T, T1.PASIVO_T, T1.VOLUMEN_T, T1.SUM_T_ACT, T1.SUM_T_ACT1, T1.SUM_T_ACT2, T1.SUM_T_ACT3, T1.SUM_T_ACT4, T1.SUM_T_ACT5, T1.SUM_T_ACT6, T1.SUM_ACT_CTO, T1.SUM_ACT_CT1, T1.SUM_ACT_CT2, T1.SUM_ACT_CT3, T1.SUM_ACT_CT4, T1.SUM_ACT_CT5, T1.SUM_ACT_CT6, T1.CEMP_T, T1.CVIP_T, T1.ICALICTE00, T1.ICALICTE10, T1.ICALICTE20, T1.ICALICTE30, T1.ICALICTE40, T1.MOFACTV_T, T1.CS000LINEAMAXTC_T, T1.CS000MTOPRESTAMO_T, T1.MONTOVEHICULAR_T, T1.MONTOHIPOTECARIO_T, T1.MONTOSUBROGADOS_T FROM IILC.TIILC_TOTAL  T1 WHERE T1.COD_TOTAL = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column COD_TOTAL
			// For column COD_TOTAL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(0);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(1,tempBigDecimal);
				else
					pstmt.setNull(1,java.sql.Types.NUMERIC);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.COD_TOTAL, T1.COD_TERRITORIO, T1.IND_REGISTRO, T1.COD_OFICINA, T1.COD_GESTOR, T1.CLIXGEST, T1.SEG_10100, T1.SEG_10200, T1.SEG_20100, T1.SEG_20200, T1.SEG_20300, T1.SEG_20400, T1.SEG_20500, T1.SEG_20600, T1.SEG_30100, T1.SEG_30200, T1.SEG_30300, T1.SEG_30400, T1.SEG_40100, T1.SEG_40200, T1.SEG_40300, T1.SEG_40400, T1.SEG_50100, T1.SEG_50200, T1.SEG_50300, T1.SEG_50400, T1.SEG_60100, T1.SEG_60200, T1.SEG_60300, T1.SEG_60400, T1.SEG_80100, T1.SEG_80200, T1.SEG_80300, T1.SEG_80400, T1.SEG_80500, T1.SEG_80600, T1.SEG_80700, T1.SEG_90200, T1.SEG_99900, T1.DESVIN, T1.POCOVIN, T1.VIN, T1.MUYVIN, T1.NATDESVIN, T1.NATVIN, T1.JURVIN, T1.AHOR_T, T1.AHSD_T, T1.AVAL_T, T1.B24_T, T1.CCTE_T, T1.CEXT_T, T1.CLOC_T, T1.COLB_T, T1.CPTE_T, T1.CTS_T, T1.CTSD_T, T1.VIP_T, T1.DSCT_T, T1.FCEX_T, T1.FMUT_T, T1.LCTA_T, T1.LEAS_T, T1.MCLA_T, T1.MORO_T, T1.MP_T, T1.PAUT_T, T1.PCOM_T, T1.PER_T, T1.PH_T, T1.PHIP_T, T1.PLZO_T, T1.PMAS_T, T1.PMIV_T, T1.PPER_T, T1.PPPER_T, T1.PREF_T, T1.PROM_T, T1.PSER_T, T1.PSERV_T, T1.DEP_T, T1.SDEP_T, T1.SEXT_T, T1.SONC_T, T1.SPRO_T, T1.VID_T, T1.SVID_T, T1.TDE_T, T1.SVIP_T, T1.TVIP_T, T1.VARC_T, T1.VCLA_T, T1.VCTR_T, T1.VEMP_T, T1.VNAC_T, T1.VORO_T, T1.VPLA_T, T1.VPOLA_T, T1.VREP_T, T1.TDEB_T, T1.CNET_T, T1.LINCO_T, T1.POS_T, T1.EMPH_T, T1.RIESGO_D_T, T1.RIESGO_I_T, T1.RIESGO_T, T1.PASIVO_T, T1.VOLUMEN_T, T1.SUM_T_ACT, T1.SUM_T_ACT1, T1.SUM_T_ACT2, T1.SUM_T_ACT3, T1.SUM_T_ACT4, T1.SUM_T_ACT5, T1.SUM_T_ACT6, T1.SUM_ACT_CTO, T1.SUM_ACT_CT1, T1.SUM_ACT_CT2, T1.SUM_ACT_CT3, T1.SUM_ACT_CT4, T1.SUM_ACT_CT5, T1.SUM_ACT_CT6, T1.CEMP_T, T1.CVIP_T, T1.ICALICTE00, T1.ICALICTE10, T1.ICALICTE20, T1.ICALICTE30, T1.ICALICTE40, T1.MOFACTV_T, T1.CS000LINEAMAXTC_T, T1.CS000MTOPRESTAMO_T, T1.MONTOVEHICULAR_T, T1.MONTOHIPOTECARIO_T, T1.MONTOSUBROGADOS_T FROM IILC.TIILC_TOTAL  T1 WHERE T1.COD_TOTAL = ? FOR UPDATE ";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column COD_TOTAL
			// For column COD_TOTAL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(0);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(1,tempBigDecimal);
				else
					pstmt.setNull(1,java.sql.Types.NUMERIC);
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
	/**
	 * Tiilc_totalBeanFunctionSet_40ed895e
	 */
	public Tiilc_totalBeanFunctionSet_40ed895e() {
		functionHash=new java.util.HashMap(12);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindTotalxGexOfxTe",new Integer(4));
		functionHash.put("FindTotalxGexOfxTe444Update",new Integer(5));
		functionHash.put("FindByPrimaryKey",new Integer(6));
		functionHash.put("FindByPrimaryKey444Update",new Integer(7));
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
			outputRecord=FindTotalxGexOfxTe(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindTotalxGexOfxTe444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM IILC.TIILC_TOTAL  T1 WHERE T1.COD_TOTAL = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column COD_TOTAL
			// For column COD_TOTAL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(0);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(1,tempBigDecimal);
				else
					pstmt.setNull(1,java.sql.Types.NUMERIC);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM IILC.TIILC_TOTAL  T1 WHERE T1.COD_TOTAL = ? FOR UPDATE ";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column COD_TOTAL
			// For column COD_TOTAL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(0);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(1,tempBigDecimal);
				else
					pstmt.setNull(1,java.sql.Types.NUMERIC);
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
		updateTemplateList = Tiilc_totalBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column COD_TERRITORIO
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
						// For column IND_REGISTRO
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
						// For column COD_OFICINA
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
						// For column CLIXGEST
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column SEG_10100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(6);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column SEG_10200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column SEG_20100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(8);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column SEG_20200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(9);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column SEG_20300
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
						// For column SEG_20400
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column SEG_20500
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(12);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column SEG_20600
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(13);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column SEG_30100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(14);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column SEG_30200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(15);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column SEG_30300
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(16);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column SEG_30400
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(17);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column SEG_40100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(18);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column SEG_40200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(19);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column SEG_40300
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(20);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column SEG_40400
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(21);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column SEG_50100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(22);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column SEG_50200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(23);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column SEG_50300
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(24);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[25])
					{
						// For column SEG_50400
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(25);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[26])
					{
						// For column SEG_60100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(26);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column SEG_60200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(27);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[28])
					{
						// For column SEG_60300
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(28);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[29])
					{
						// For column SEG_60400
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(29);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[30])
					{
						// For column SEG_80100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(30);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[31])
					{
						// For column SEG_80200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(31);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[32])
					{
						// For column SEG_80300
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(32);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[33])
					{
						// For column SEG_80400
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(33);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[34])
					{
						// For column SEG_80500
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(34);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[35])
					{
						// For column SEG_80600
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(35);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[36])
					{
						// For column SEG_80700
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(36);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[37])
					{
						// For column SEG_90200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(37);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[38])
					{
						// For column SEG_99900
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(38);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[39])
					{
						// For column DESVIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(39);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[40])
					{
						// For column POCOVIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(40);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[41])
					{
						// For column VIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(41);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[42])
					{
						// For column MUYVIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(42);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[43])
					{
						// For column NATDESVIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(43);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[44])
					{
						// For column NATVIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(44);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[45])
					{
						// For column JURVIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(45);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[46])
					{
						// For column AHOR_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(46);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[47])
					{
						// For column AHSD_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(47);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[48])
					{
						// For column AVAL_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(48);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[49])
					{
						// For column B24_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(49);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[50])
					{
						// For column CCTE_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(50);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[51])
					{
						// For column CEXT_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(51);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[52])
					{
						// For column CLOC_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(52);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[53])
					{
						// For column COLB_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(53);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[54])
					{
						// For column CPTE_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(54);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[55])
					{
						// For column CTS_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(55);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[56])
					{
						// For column CTSD_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(56);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[57])
					{
						// For column VIP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(57);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[58])
					{
						// For column DSCT_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(58);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[59])
					{
						// For column FCEX_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(59);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[60])
					{
						// For column FMUT_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(60);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[61])
					{
						// For column LCTA_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(61);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[62])
					{
						// For column LEAS_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(62);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[63])
					{
						// For column MCLA_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(63);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[64])
					{
						// For column MORO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(64);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[65])
					{
						// For column MP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(65);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[66])
					{
						// For column PAUT_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(66);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[67])
					{
						// For column PCOM_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(67);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[68])
					{
						// For column PER_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(68);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[69])
					{
						// For column PH_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(69);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[70])
					{
						// For column PHIP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(70);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[71])
					{
						// For column PLZO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(71);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[72])
					{
						// For column PMAS_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(72);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[73])
					{
						// For column PMIV_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(73);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[74])
					{
						// For column PPER_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(74);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[75])
					{
						// For column PPPER_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(75);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[76])
					{
						// For column PREF_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(76);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[77])
					{
						// For column PROM_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(77);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[78])
					{
						// For column PSER_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(78);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[79])
					{
						// For column PSERV_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(79);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[80])
					{
						// For column DEP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(80);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[81])
					{
						// For column SDEP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(81);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[82])
					{
						// For column SEXT_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(82);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[83])
					{
						// For column SONC_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(83);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[84])
					{
						// For column SPRO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(84);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[85])
					{
						// For column VID_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(85);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[86])
					{
						// For column SVID_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(86);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[87])
					{
						// For column TDE_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(87);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[88])
					{
						// For column SVIP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(88);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[89])
					{
						// For column TVIP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(89);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[90])
					{
						// For column VARC_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(90);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[91])
					{
						// For column VCLA_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(91);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[92])
					{
						// For column VCTR_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(92);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[93])
					{
						// For column VEMP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(93);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[94])
					{
						// For column VNAC_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(94);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[95])
					{
						// For column VORO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(95);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[96])
					{
						// For column VPLA_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(96);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[97])
					{
						// For column VPOLA_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(97);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[98])
					{
						// For column VREP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(98);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[99])
					{
						// For column TDEB_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(99);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[100])
					{
						// For column CNET_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(100);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[101])
					{
						// For column LINCO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(101);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[102])
					{
						// For column POS_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(102);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[103])
					{
						// For column EMPH_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(103);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[104])
					{
						// For column RIESGO_D_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(104);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[105])
					{
						// For column RIESGO_I_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(105);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[106])
					{
						// For column RIESGO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(106);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[107])
					{
						// For column PASIVO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(107);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[108])
					{
						// For column VOLUMEN_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(108);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[109])
					{
						// For column SUM_T_ACT
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(109);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[110])
					{
						// For column SUM_T_ACT1
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(110);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[111])
					{
						// For column SUM_T_ACT2
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(111);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[112])
					{
						// For column SUM_T_ACT3
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(112);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[113])
					{
						// For column SUM_T_ACT4
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(113);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[114])
					{
						// For column SUM_T_ACT5
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(114);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[115])
					{
						// For column SUM_T_ACT6
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(115);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[116])
					{
						// For column SUM_ACT_CTO
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(116);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[117])
					{
						// For column SUM_ACT_CT1
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(117);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[118])
					{
						// For column SUM_ACT_CT2
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(118);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[119])
					{
						// For column SUM_ACT_CT3
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(119);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[120])
					{
						// For column SUM_ACT_CT4
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(120);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[121])
					{
						// For column SUM_ACT_CT5
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(121);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[122])
					{
						// For column SUM_ACT_CT6
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(122);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[123])
					{
						// For column CEMP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(123);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[124])
					{
						// For column CVIP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(124);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[125])
					{
						// For column ICALICTE00
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(125);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[126])
					{
						// For column ICALICTE10
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(126);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[127])
					{
						// For column ICALICTE20
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(127);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[128])
					{
						// For column ICALICTE30
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(128);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[129])
					{
						// For column ICALICTE40
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(129);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[130])
					{
						// For column MOFACTV_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(130);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[131])
					{
						// For column CS000LINEAMAXTC_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(131);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[132])
					{
						// For column CS000MTOPRESTAMO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(132);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[133])
					{
						// For column MONTOVEHICULAR_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(133);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[134])
					{
						// For column MONTOHIPOTECARIO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(134);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[135])
					{
						// For column MONTOSUBROGADOS_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(135);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_TOTAL
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(0);
						pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
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
						// For column COD_TERRITORIO
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
						// For column IND_REGISTRO
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
						// For column COD_OFICINA
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
						// For column CLIXGEST
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(5);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column SEG_10100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(6);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column SEG_10200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column SEG_20100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(8);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column SEG_20200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(9);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column SEG_20300
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
						// For column SEG_20400
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(11);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column SEG_20500
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(12);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column SEG_20600
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(13);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column SEG_30100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(14);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column SEG_30200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(15);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column SEG_30300
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(16);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column SEG_30400
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(17);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column SEG_40100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(18);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column SEG_40200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(19);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column SEG_40300
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(20);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column SEG_40400
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(21);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column SEG_50100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(22);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column SEG_50200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(23);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column SEG_50300
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(24);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[25])
					{
						// For column SEG_50400
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(25);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[26])
					{
						// For column SEG_60100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(26);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column SEG_60200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(27);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[28])
					{
						// For column SEG_60300
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(28);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[29])
					{
						// For column SEG_60400
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(29);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[30])
					{
						// For column SEG_80100
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(30);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[31])
					{
						// For column SEG_80200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(31);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[32])
					{
						// For column SEG_80300
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(32);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[33])
					{
						// For column SEG_80400
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(33);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[34])
					{
						// For column SEG_80500
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(34);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[35])
					{
						// For column SEG_80600
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(35);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[36])
					{
						// For column SEG_80700
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(36);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[37])
					{
						// For column SEG_90200
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(37);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[38])
					{
						// For column SEG_99900
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(38);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[39])
					{
						// For column DESVIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(39);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[40])
					{
						// For column POCOVIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(40);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[41])
					{
						// For column VIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(41);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[42])
					{
						// For column MUYVIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(42);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[43])
					{
						// For column NATDESVIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(43);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[44])
					{
						// For column NATVIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(44);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[45])
					{
						// For column JURVIN
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(45);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[46])
					{
						// For column AHOR_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(46);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[47])
					{
						// For column AHSD_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(47);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[48])
					{
						// For column AVAL_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(48);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[49])
					{
						// For column B24_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(49);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[50])
					{
						// For column CCTE_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(50);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[51])
					{
						// For column CEXT_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(51);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[52])
					{
						// For column CLOC_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(52);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[53])
					{
						// For column COLB_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(53);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[54])
					{
						// For column CPTE_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(54);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[55])
					{
						// For column CTS_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(55);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[56])
					{
						// For column CTSD_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(56);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[57])
					{
						// For column VIP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(57);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[58])
					{
						// For column DSCT_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(58);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[59])
					{
						// For column FCEX_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(59);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[60])
					{
						// For column FMUT_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(60);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[61])
					{
						// For column LCTA_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(61);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[62])
					{
						// For column LEAS_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(62);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[63])
					{
						// For column MCLA_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(63);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[64])
					{
						// For column MORO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(64);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[65])
					{
						// For column MP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(65);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[66])
					{
						// For column PAUT_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(66);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[67])
					{
						// For column PCOM_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(67);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[68])
					{
						// For column PER_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(68);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[69])
					{
						// For column PH_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(69);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[70])
					{
						// For column PHIP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(70);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[71])
					{
						// For column PLZO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(71);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[72])
					{
						// For column PMAS_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(72);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[73])
					{
						// For column PMIV_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(73);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[74])
					{
						// For column PPER_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(74);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[75])
					{
						// For column PPPER_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(75);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[76])
					{
						// For column PREF_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(76);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[77])
					{
						// For column PROM_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(77);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[78])
					{
						// For column PSER_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(78);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[79])
					{
						// For column PSERV_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(79);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[80])
					{
						// For column DEP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(80);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[81])
					{
						// For column SDEP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(81);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[82])
					{
						// For column SEXT_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(82);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[83])
					{
						// For column SONC_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(83);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[84])
					{
						// For column SPRO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(84);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[85])
					{
						// For column VID_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(85);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[86])
					{
						// For column SVID_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(86);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[87])
					{
						// For column TDE_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(87);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[88])
					{
						// For column SVIP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(88);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[89])
					{
						// For column TVIP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(89);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[90])
					{
						// For column VARC_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(90);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[91])
					{
						// For column VCLA_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(91);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[92])
					{
						// For column VCTR_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(92);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[93])
					{
						// For column VEMP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(93);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[94])
					{
						// For column VNAC_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(94);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[95])
					{
						// For column VORO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(95);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[96])
					{
						// For column VPLA_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(96);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[97])
					{
						// For column VPOLA_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(97);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[98])
					{
						// For column VREP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(98);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[99])
					{
						// For column TDEB_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(99);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[100])
					{
						// For column CNET_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(100);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[101])
					{
						// For column LINCO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(101);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[102])
					{
						// For column POS_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(102);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[103])
					{
						// For column EMPH_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(103);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[104])
					{
						// For column RIESGO_D_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(104);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[105])
					{
						// For column RIESGO_I_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(105);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[106])
					{
						// For column RIESGO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(106);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[107])
					{
						// For column PASIVO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(107);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[108])
					{
						// For column VOLUMEN_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(108);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[109])
					{
						// For column SUM_T_ACT
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(109);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[110])
					{
						// For column SUM_T_ACT1
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(110);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[111])
					{
						// For column SUM_T_ACT2
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(111);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[112])
					{
						// For column SUM_T_ACT3
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(112);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[113])
					{
						// For column SUM_T_ACT4
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(113);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[114])
					{
						// For column SUM_T_ACT5
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(114);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[115])
					{
						// For column SUM_T_ACT6
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(115);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[116])
					{
						// For column SUM_ACT_CTO
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(116);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[117])
					{
						// For column SUM_ACT_CT1
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(117);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[118])
					{
						// For column SUM_ACT_CT2
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(118);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[119])
					{
						// For column SUM_ACT_CT3
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(119);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[120])
					{
						// For column SUM_ACT_CT4
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(120);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[121])
					{
						// For column SUM_ACT_CT5
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(121);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[122])
					{
						// For column SUM_ACT_CT6
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(122);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[123])
					{
						// For column CEMP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(123);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[124])
					{
						// For column CVIP_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(124);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[125])
					{
						// For column ICALICTE00
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(125);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[126])
					{
						// For column ICALICTE10
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(126);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[127])
					{
						// For column ICALICTE20
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(127);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[128])
					{
						// For column ICALICTE30
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(128);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[129])
					{
						// For column ICALICTE40
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(129);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[130])
					{
						// For column MOFACTV_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(130);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[131])
					{
						// For column CS000LINEAMAXTC_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(131);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[132])
					{
						// For column CS000MTOPRESTAMO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(132);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[133])
					{
						// For column MONTOVEHICULAR_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(133);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[134])
					{
						// For column MONTOHIPOTECARIO_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(134);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[135])
					{
						// For column MONTOSUBROGADOS_T
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(135);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_TOTAL
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(0);
						pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
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
