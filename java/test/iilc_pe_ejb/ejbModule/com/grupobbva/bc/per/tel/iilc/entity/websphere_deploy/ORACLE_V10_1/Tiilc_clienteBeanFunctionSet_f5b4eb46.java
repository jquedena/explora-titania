package com.grupobbva.bc.per.tel.iilc.entity.websphere_deploy.ORACLE_V10_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * Tiilc_clienteBeanFunctionSet_f5b4eb46
 */
public class Tiilc_clienteBeanFunctionSet_f5b4eb46 extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO IILC.TIILC_CLIENTE (COD_CLIENTE, CODIGO, COD_OFICINA, COD_GESTOR, NOMBRE, COD_TERRITORIO, SEGMENT1, EDAD, ESTCIVIL, CALLE, NRO, PERFIL, DIREC1, DISTRITO, PROVINCIA, DEPARTAMENTO, TIPO_PERSONA, CLASIFICACION, TELEFONO, VINCULACION, PPER, PCOM, VNAC, CCTE, COLB, CNET, PAUT, DSCT, VARC, CEMP, SDEP, CEXT, PHIP, LEAS, VCLA, CVIP, SVID, LINCO, PMIV, CLOC, VREP, AHSD, SONC, TCO, B24, CPTE, PREF, VORO, AHOR, SPRO, POS, T_ACT2, PMAS, T_ACT3, LCTA, T_ACT4, VPLA, T_ACT5, PLZO, T_ACT6, PSERV, TPR, PROM, T_ACT_CT2, VEMP, T_ACT_CT3, PH, T_ACT_CT4, FCEX, T_ACT_CT5, VCTR, T_ACT_CT6, FMUT, MARGENO, NRO_DOCUMENTO, BCORIE, EMPH, BCORID, AVAL, BCORII, MCLA, BCOPAS, CTS, BCOVOL, TDEB, PORCRIE, MORO, PORCRID, CTSD, PORCRII, TVIP, SBSRIE, SBSRID, SBSRII, SBSJUD, COD_EMPRESA, DES_EMPRESA, INTERVPAS, MOFACTV, CS000LINEAMAXTC, MOFPASV, MOFSERV, MOFCANAL, MPHPASV, CS000MTOPRESTAMO, MONTOVEHICULAR, CTACTEOFERTA, CTAAHOFERTA, CTAPOFERTA, FMUTUOOFERT, CTACTSOFERT, TCONSACTV, MONTOSUBROGADOS, TSUBACTV, THIPOTACTV, TVEHICACTV, TCUOT36ACT, TCUOT48ACT, CS000MONTOCTA60, TCUOT60ACT, CSS000PRESMENA5000, CS000COMISDESEMEN5000, CS000PRES5000A15000, C5000COMDES15000ACT, CS000PRESMAYA15000, COMDES15000AC, CS000LINMINADQTC, CS000TIPODECREDITO, CS000MIXMONPREST, CS000MIXLINASISTC, CS000MIXTIPOTC, CS000PRESTCMENA5000, CS000PRESTC500015000, CS000PRESTCMAYA15000, ATRIBCTACTEPASV, ATRIBCTAAHPASV, ATRIBCTAPLAZPASV, ATRIBCTSPASV, ATRIBFMUTUOPASV, COBOFSERV, SVIDOFSERV, SONCOFSERV, SVINCOFSERV, PHOFSERV, DEBOFSERV, VIPOFSERV, OFCNETCAN, OFCEMPCAN, OFLINCOCAN, OFB24CAN, OFPOSCAN, PREFIJO, MONTOHIPOTECARIO, CS000MONTOCTA36, CS000MONTOCTA48) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column COD_CLIENTE
			// For column COD_CLIENTE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(0);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(1,tempBigDecimal);
				else
					pstmt.setNull(1,java.sql.Types.NUMERIC);
			}
			// For column CODIGO
			// For column CODIGO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column NOMBRE
			// For column NOMBRE
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
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
			// For column SEGMENT1
			// For column SEGMENT1
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column EDAD
			// For column EDAD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(8,tempBigDecimal);
				else
					pstmt.setNull(8,java.sql.Types.NUMERIC);
			}
			// For column ESTCIVIL
			// For column ESTCIVIL
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.VARCHAR);
			}
			// For column CALLE
			// For column CALLE
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.VARCHAR);
			}
			// For column NRO
			// For column NRO
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column PERFIL
			// For column PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column DIREC1
			// For column DIREC1
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.VARCHAR);
			}
			// For column DISTRITO
			// For column DISTRITO
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.VARCHAR);
			}
			// For column PROVINCIA
			// For column PROVINCIA
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.VARCHAR);
			}
			// For column DEPARTAMENTO
			// For column DEPARTAMENTO
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.VARCHAR);
			}
			// For column TIPO_PERSONA
			// For column TIPO_PERSONA
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.VARCHAR);
			}
			// For column CLASIFICACION
			// For column CLASIFICACION
			{
				String tempString;


				tempString=(String)inputRecord.get(17);
				if(tempString != null)
					pstmt.setString(18,tempString);
				else
					pstmt.setNull(18,java.sql.Types.VARCHAR);
			}
			// For column TELEFONO
			// For column TELEFONO
			{
				String tempString;


				tempString=(String)inputRecord.get(18);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.VARCHAR);
			}
			// For column VINCULACION
			// For column VINCULACION
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(20,tempString);
				else
					pstmt.setNull(20,java.sql.Types.VARCHAR);
			}
			// For column PPER
			// For column PPER
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(20);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(21,tempBigDecimal);
				else
					pstmt.setNull(21,java.sql.Types.NUMERIC);
			}
			// For column PCOM
			// For column PCOM
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(21);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(22,tempBigDecimal);
				else
					pstmt.setNull(22,java.sql.Types.NUMERIC);
			}
			// For column VNAC
			// For column VNAC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(22);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(23,tempBigDecimal);
				else
					pstmt.setNull(23,java.sql.Types.NUMERIC);
			}
			// For column CCTE
			// For column CCTE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(23);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(24,tempBigDecimal);
				else
					pstmt.setNull(24,java.sql.Types.NUMERIC);
			}
			// For column COLB
			// For column COLB
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(24);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(25,tempBigDecimal);
				else
					pstmt.setNull(25,java.sql.Types.NUMERIC);
			}
			// For column CNET
			// For column CNET
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(25);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(26,tempBigDecimal);
				else
					pstmt.setNull(26,java.sql.Types.NUMERIC);
			}
			// For column PAUT
			// For column PAUT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(26);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(27,tempBigDecimal);
				else
					pstmt.setNull(27,java.sql.Types.NUMERIC);
			}
			// For column DSCT
			// For column DSCT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(27);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(28,tempBigDecimal);
				else
					pstmt.setNull(28,java.sql.Types.NUMERIC);
			}
			// For column VARC
			// For column VARC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(28);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(29,tempBigDecimal);
				else
					pstmt.setNull(29,java.sql.Types.NUMERIC);
			}
			// For column CEMP
			// For column CEMP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(29);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(30,tempBigDecimal);
				else
					pstmt.setNull(30,java.sql.Types.NUMERIC);
			}
			// For column SDEP
			// For column SDEP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(30);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(31,tempBigDecimal);
				else
					pstmt.setNull(31,java.sql.Types.NUMERIC);
			}
			// For column CEXT
			// For column CEXT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(31);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(32,tempBigDecimal);
				else
					pstmt.setNull(32,java.sql.Types.NUMERIC);
			}
			// For column PHIP
			// For column PHIP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(32);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(33,tempBigDecimal);
				else
					pstmt.setNull(33,java.sql.Types.NUMERIC);
			}
			// For column LEAS
			// For column LEAS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(33);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(34,tempBigDecimal);
				else
					pstmt.setNull(34,java.sql.Types.NUMERIC);
			}
			// For column VCLA
			// For column VCLA
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(34);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(35,tempBigDecimal);
				else
					pstmt.setNull(35,java.sql.Types.NUMERIC);
			}
			// For column CVIP
			// For column CVIP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(35);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(36,tempBigDecimal);
				else
					pstmt.setNull(36,java.sql.Types.NUMERIC);
			}
			// For column SVID
			// For column SVID
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(36);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(37,tempBigDecimal);
				else
					pstmt.setNull(37,java.sql.Types.NUMERIC);
			}
			// For column LINCO
			// For column LINCO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(37);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(38,tempBigDecimal);
				else
					pstmt.setNull(38,java.sql.Types.NUMERIC);
			}
			// For column PMIV
			// For column PMIV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(38);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(39,tempBigDecimal);
				else
					pstmt.setNull(39,java.sql.Types.NUMERIC);
			}
			// For column CLOC
			// For column CLOC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(39);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(40,tempBigDecimal);
				else
					pstmt.setNull(40,java.sql.Types.NUMERIC);
			}
			// For column VREP
			// For column VREP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(40);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(41,tempBigDecimal);
				else
					pstmt.setNull(41,java.sql.Types.NUMERIC);
			}
			// For column AHSD
			// For column AHSD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(41);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(42,tempBigDecimal);
				else
					pstmt.setNull(42,java.sql.Types.NUMERIC);
			}
			// For column SONC
			// For column SONC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(42);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(43,tempBigDecimal);
				else
					pstmt.setNull(43,java.sql.Types.NUMERIC);
			}
			// For column TCO
			// For column TCO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(43);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(44,tempBigDecimal);
				else
					pstmt.setNull(44,java.sql.Types.NUMERIC);
			}
			// For column B24
			// For column B24
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(44);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(45,tempBigDecimal);
				else
					pstmt.setNull(45,java.sql.Types.NUMERIC);
			}
			// For column CPTE
			// For column CPTE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(45);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(46,tempBigDecimal);
				else
					pstmt.setNull(46,java.sql.Types.NUMERIC);
			}
			// For column PREF
			// For column PREF
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(46);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(47,tempBigDecimal);
				else
					pstmt.setNull(47,java.sql.Types.NUMERIC);
			}
			// For column VORO
			// For column VORO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(47);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(48,tempBigDecimal);
				else
					pstmt.setNull(48,java.sql.Types.NUMERIC);
			}
			// For column AHOR
			// For column AHOR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(48);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(49,tempBigDecimal);
				else
					pstmt.setNull(49,java.sql.Types.NUMERIC);
			}
			// For column SPRO
			// For column SPRO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(49);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(50,tempBigDecimal);
				else
					pstmt.setNull(50,java.sql.Types.NUMERIC);
			}
			// For column POS
			// For column POS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(50);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(51,tempBigDecimal);
				else
					pstmt.setNull(51,java.sql.Types.NUMERIC);
			}
			// For column T_ACT2
			// For column T_ACT2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(51);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(52,tempBigDecimal);
				else
					pstmt.setNull(52,java.sql.Types.NUMERIC);
			}
			// For column PMAS
			// For column PMAS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(52);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(53,tempBigDecimal);
				else
					pstmt.setNull(53,java.sql.Types.NUMERIC);
			}
			// For column T_ACT3
			// For column T_ACT3
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(53);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(54,tempBigDecimal);
				else
					pstmt.setNull(54,java.sql.Types.NUMERIC);
			}
			// For column LCTA
			// For column LCTA
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(54);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(55,tempBigDecimal);
				else
					pstmt.setNull(55,java.sql.Types.NUMERIC);
			}
			// For column T_ACT4
			// For column T_ACT4
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(55);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(56,tempBigDecimal);
				else
					pstmt.setNull(56,java.sql.Types.NUMERIC);
			}
			// For column VPLA
			// For column VPLA
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(56);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(57,tempBigDecimal);
				else
					pstmt.setNull(57,java.sql.Types.NUMERIC);
			}
			// For column T_ACT5
			// For column T_ACT5
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(57);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(58,tempBigDecimal);
				else
					pstmt.setNull(58,java.sql.Types.NUMERIC);
			}
			// For column PLZO
			// For column PLZO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(58);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(59,tempBigDecimal);
				else
					pstmt.setNull(59,java.sql.Types.NUMERIC);
			}
			// For column T_ACT6
			// For column T_ACT6
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(59);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(60,tempBigDecimal);
				else
					pstmt.setNull(60,java.sql.Types.NUMERIC);
			}
			// For column PSERV
			// For column PSERV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(60);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(61,tempBigDecimal);
				else
					pstmt.setNull(61,java.sql.Types.NUMERIC);
			}
			// For column TPR
			// For column TPR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(61);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(62,tempBigDecimal);
				else
					pstmt.setNull(62,java.sql.Types.NUMERIC);
			}
			// For column PROM
			// For column PROM
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(62);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(63,tempBigDecimal);
				else
					pstmt.setNull(63,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT2
			// For column T_ACT_CT2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(63);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(64,tempBigDecimal);
				else
					pstmt.setNull(64,java.sql.Types.NUMERIC);
			}
			// For column VEMP
			// For column VEMP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(64);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(65,tempBigDecimal);
				else
					pstmt.setNull(65,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT3
			// For column T_ACT_CT3
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(65);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(66,tempBigDecimal);
				else
					pstmt.setNull(66,java.sql.Types.NUMERIC);
			}
			// For column PH
			// For column PH
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(66);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(67,tempBigDecimal);
				else
					pstmt.setNull(67,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT4
			// For column T_ACT_CT4
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(67);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(68,tempBigDecimal);
				else
					pstmt.setNull(68,java.sql.Types.NUMERIC);
			}
			// For column FCEX
			// For column FCEX
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(68);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(69,tempBigDecimal);
				else
					pstmt.setNull(69,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT5
			// For column T_ACT_CT5
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(69);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(70,tempBigDecimal);
				else
					pstmt.setNull(70,java.sql.Types.NUMERIC);
			}
			// For column VCTR
			// For column VCTR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(70);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(71,tempBigDecimal);
				else
					pstmt.setNull(71,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT6
			// For column T_ACT_CT6
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(71);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(72,tempBigDecimal);
				else
					pstmt.setNull(72,java.sql.Types.NUMERIC);
			}
			// For column FMUT
			// For column FMUT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(72);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(73,tempBigDecimal);
				else
					pstmt.setNull(73,java.sql.Types.NUMERIC);
			}
			// For column MARGENO
			// For column MARGENO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(73);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(74,tempBigDecimal);
				else
					pstmt.setNull(74,java.sql.Types.NUMERIC);
			}
			// For column NRO_DOCUMENTO
			// For column NRO_DOCUMENTO
			{
				String tempString;


				tempString=(String)inputRecord.get(74);
				if(tempString != null)
					pstmt.setString(75,tempString);
				else
					pstmt.setNull(75,java.sql.Types.VARCHAR);
			}
			// For column BCORIE
			// For column BCORIE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(75);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(76,tempBigDecimal);
				else
					pstmt.setNull(76,java.sql.Types.NUMERIC);
			}
			// For column EMPH
			// For column EMPH
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(76);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(77,tempBigDecimal);
				else
					pstmt.setNull(77,java.sql.Types.NUMERIC);
			}
			// For column BCORID
			// For column BCORID
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(77);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(78,tempBigDecimal);
				else
					pstmt.setNull(78,java.sql.Types.NUMERIC);
			}
			// For column AVAL
			// For column AVAL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(78);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(79,tempBigDecimal);
				else
					pstmt.setNull(79,java.sql.Types.NUMERIC);
			}
			// For column BCORII
			// For column BCORII
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(79);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(80,tempBigDecimal);
				else
					pstmt.setNull(80,java.sql.Types.NUMERIC);
			}
			// For column MCLA
			// For column MCLA
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(80);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(81,tempBigDecimal);
				else
					pstmt.setNull(81,java.sql.Types.NUMERIC);
			}
			// For column BCOPAS
			// For column BCOPAS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(81);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(82,tempBigDecimal);
				else
					pstmt.setNull(82,java.sql.Types.NUMERIC);
			}
			// For column CTS
			// For column CTS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(82);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(83,tempBigDecimal);
				else
					pstmt.setNull(83,java.sql.Types.NUMERIC);
			}
			// For column BCOVOL
			// For column BCOVOL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(83);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(84,tempBigDecimal);
				else
					pstmt.setNull(84,java.sql.Types.NUMERIC);
			}
			// For column TDEB
			// For column TDEB
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(84);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(85,tempBigDecimal);
				else
					pstmt.setNull(85,java.sql.Types.NUMERIC);
			}
			// For column PORCRIE
			// For column PORCRIE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(85);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(86,tempBigDecimal);
				else
					pstmt.setNull(86,java.sql.Types.NUMERIC);
			}
			// For column MORO
			// For column MORO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(86);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(87,tempBigDecimal);
				else
					pstmt.setNull(87,java.sql.Types.NUMERIC);
			}
			// For column PORCRID
			// For column PORCRID
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(87);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(88,tempBigDecimal);
				else
					pstmt.setNull(88,java.sql.Types.NUMERIC);
			}
			// For column CTSD
			// For column CTSD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(88);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(89,tempBigDecimal);
				else
					pstmt.setNull(89,java.sql.Types.NUMERIC);
			}
			// For column PORCRII
			// For column PORCRII
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(89);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(90,tempBigDecimal);
				else
					pstmt.setNull(90,java.sql.Types.NUMERIC);
			}
			// For column TVIP
			// For column TVIP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(90);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(91,tempBigDecimal);
				else
					pstmt.setNull(91,java.sql.Types.NUMERIC);
			}
			// For column SBSRIE
			// For column SBSRIE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(91);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(92,tempBigDecimal);
				else
					pstmt.setNull(92,java.sql.Types.NUMERIC);
			}
			// For column SBSRID
			// For column SBSRID
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(92);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(93,tempBigDecimal);
				else
					pstmt.setNull(93,java.sql.Types.NUMERIC);
			}
			// For column SBSRII
			// For column SBSRII
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(93);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(94,tempBigDecimal);
				else
					pstmt.setNull(94,java.sql.Types.NUMERIC);
			}
			// For column SBSJUD
			// For column SBSJUD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(94);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(95,tempBigDecimal);
				else
					pstmt.setNull(95,java.sql.Types.NUMERIC);
			}
			// For column COD_EMPRESA
			// For column COD_EMPRESA
			{
				String tempString;


				tempString=(String)inputRecord.get(95);
				if(tempString != null)
					pstmt.setString(96,tempString);
				else
					pstmt.setNull(96,java.sql.Types.VARCHAR);
			}
			// For column DES_EMPRESA
			// For column DES_EMPRESA
			{
				String tempString;


				tempString=(String)inputRecord.get(96);
				if(tempString != null)
					pstmt.setString(97,tempString);
				else
					pstmt.setNull(97,java.sql.Types.VARCHAR);
			}
			// For column INTERVPAS
			// For column INTERVPAS
			{
				String tempString;


				tempString=(String)inputRecord.get(97);
				if(tempString != null)
					pstmt.setString(98,tempString);
				else
					pstmt.setNull(98,java.sql.Types.VARCHAR);
			}
			// For column MOFACTV
			// For column MOFACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(98);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(99,tempBigDecimal);
				else
					pstmt.setNull(99,java.sql.Types.NUMERIC);
			}
			// For column CS000LINEAMAXTC
			// For column CS000LINEAMAXTC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(99);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(100,tempBigDecimal);
				else
					pstmt.setNull(100,java.sql.Types.NUMERIC);
			}
			// For column MOFPASV
			// For column MOFPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(100);
				if(tempString != null)
					pstmt.setString(101,tempString);
				else
					pstmt.setNull(101,java.sql.Types.VARCHAR);
			}
			// For column MOFSERV
			// For column MOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(101);
				if(tempString != null)
					pstmt.setString(102,tempString);
				else
					pstmt.setNull(102,java.sql.Types.VARCHAR);
			}
			// For column MOFCANAL
			// For column MOFCANAL
			{
				String tempString;


				tempString=(String)inputRecord.get(102);
				if(tempString != null)
					pstmt.setString(103,tempString);
				else
					pstmt.setNull(103,java.sql.Types.VARCHAR);
			}
			// For column MPHPASV
			// For column MPHPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(103);
				if(tempString != null)
					pstmt.setString(104,tempString);
				else
					pstmt.setNull(104,java.sql.Types.VARCHAR);
			}
			// For column CS000MTOPRESTAMO
			// For column CS000MTOPRESTAMO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(104);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(105,tempBigDecimal);
				else
					pstmt.setNull(105,java.sql.Types.NUMERIC);
			}
			// For column MONTOVEHICULAR
			// For column MONTOVEHICULAR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(105);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(106,tempBigDecimal);
				else
					pstmt.setNull(106,java.sql.Types.NUMERIC);
			}
			// For column CTACTEOFERTA
			// For column CTACTEOFERTA
			{
				String tempString;


				tempString=(String)inputRecord.get(106);
				if(tempString != null)
					pstmt.setString(107,tempString);
				else
					pstmt.setNull(107,java.sql.Types.VARCHAR);
			}
			// For column CTAAHOFERTA
			// For column CTAAHOFERTA
			{
				String tempString;


				tempString=(String)inputRecord.get(107);
				if(tempString != null)
					pstmt.setString(108,tempString);
				else
					pstmt.setNull(108,java.sql.Types.VARCHAR);
			}
			// For column CTAPOFERTA
			// For column CTAPOFERTA
			{
				String tempString;


				tempString=(String)inputRecord.get(108);
				if(tempString != null)
					pstmt.setString(109,tempString);
				else
					pstmt.setNull(109,java.sql.Types.VARCHAR);
			}
			// For column FMUTUOOFERT
			// For column FMUTUOOFERT
			{
				String tempString;


				tempString=(String)inputRecord.get(109);
				if(tempString != null)
					pstmt.setString(110,tempString);
				else
					pstmt.setNull(110,java.sql.Types.VARCHAR);
			}
			// For column CTACTSOFERT
			// For column CTACTSOFERT
			{
				String tempString;


				tempString=(String)inputRecord.get(110);
				if(tempString != null)
					pstmt.setString(111,tempString);
				else
					pstmt.setNull(111,java.sql.Types.VARCHAR);
			}
			// For column TCONSACTV
			// For column TCONSACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(111);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(112,tempBigDecimal);
				else
					pstmt.setNull(112,java.sql.Types.NUMERIC);
			}
			// For column MONTOSUBROGADOS
			// For column MONTOSUBROGADOS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(112);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(113,tempBigDecimal);
				else
					pstmt.setNull(113,java.sql.Types.NUMERIC);
			}
			// For column TSUBACTV
			// For column TSUBACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(113);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(114,tempBigDecimal);
				else
					pstmt.setNull(114,java.sql.Types.NUMERIC);
			}
			// For column THIPOTACTV
			// For column THIPOTACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(114);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(115,tempBigDecimal);
				else
					pstmt.setNull(115,java.sql.Types.NUMERIC);
			}
			// For column TVEHICACTV
			// For column TVEHICACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(115);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(116,tempBigDecimal);
				else
					pstmt.setNull(116,java.sql.Types.NUMERIC);
			}
			// For column TCUOT36ACT
			// For column TCUOT36ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(116);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(117,tempBigDecimal);
				else
					pstmt.setNull(117,java.sql.Types.NUMERIC);
			}
			// For column TCUOT48ACT
			// For column TCUOT48ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(117);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(118,tempBigDecimal);
				else
					pstmt.setNull(118,java.sql.Types.NUMERIC);
			}
			// For column CS000MONTOCTA60
			// For column CS000MONTOCTA60
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(118);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(119,tempBigDecimal);
				else
					pstmt.setNull(119,java.sql.Types.NUMERIC);
			}
			// For column TCUOT60ACT
			// For column TCUOT60ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(119);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(120,tempBigDecimal);
				else
					pstmt.setNull(120,java.sql.Types.NUMERIC);
			}
			// For column CSS000PRESMENA5000
			// For column CSS000PRESMENA5000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(120);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(121,tempBigDecimal);
				else
					pstmt.setNull(121,java.sql.Types.NUMERIC);
			}
			// For column CS000COMISDESEMEN5000
			// For column CS000COMISDESEMEN5000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(121);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(122,tempBigDecimal);
				else
					pstmt.setNull(122,java.sql.Types.NUMERIC);
			}
			// For column CS000PRES5000A15000
			// For column CS000PRES5000A15000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(122);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(123,tempBigDecimal);
				else
					pstmt.setNull(123,java.sql.Types.NUMERIC);
			}
			// For column C5000COMDES15000ACT
			// For column C5000COMDES15000ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(123);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(124,tempBigDecimal);
				else
					pstmt.setNull(124,java.sql.Types.NUMERIC);
			}
			// For column CS000PRESMAYA15000
			// For column CS000PRESMAYA15000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(124);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(125,tempBigDecimal);
				else
					pstmt.setNull(125,java.sql.Types.NUMERIC);
			}
			// For column COMDES15000AC
			// For column COMDES15000AC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(125);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(126,tempBigDecimal);
				else
					pstmt.setNull(126,java.sql.Types.NUMERIC);
			}
			// For column CS000LINMINADQTC
			// For column CS000LINMINADQTC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(126);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(127,tempBigDecimal);
				else
					pstmt.setNull(127,java.sql.Types.NUMERIC);
			}
			// For column CS000TIPODECREDITO
			// For column CS000TIPODECREDITO
			{
				String tempString;


				tempString=(String)inputRecord.get(127);
				if(tempString != null)
					pstmt.setString(128,tempString);
				else
					pstmt.setNull(128,java.sql.Types.VARCHAR);
			}
			// For column CS000MIXMONPREST
			// For column CS000MIXMONPREST
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(128);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(129,tempBigDecimal);
				else
					pstmt.setNull(129,java.sql.Types.NUMERIC);
			}
			// For column CS000MIXLINASISTC
			// For column CS000MIXLINASISTC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(129);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(130,tempBigDecimal);
				else
					pstmt.setNull(130,java.sql.Types.NUMERIC);
			}
			// For column CS000MIXTIPOTC
			// For column CS000MIXTIPOTC
			{
				String tempString;


				tempString=(String)inputRecord.get(130);
				if(tempString != null)
					pstmt.setString(131,tempString);
				else
					pstmt.setNull(131,java.sql.Types.VARCHAR);
			}
			// For column CS000PRESTCMENA5000
			// For column CS000PRESTCMENA5000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(131);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(132,tempBigDecimal);
				else
					pstmt.setNull(132,java.sql.Types.NUMERIC);
			}
			// For column CS000PRESTC500015000
			// For column CS000PRESTC500015000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(132);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(133,tempBigDecimal);
				else
					pstmt.setNull(133,java.sql.Types.NUMERIC);
			}
			// For column CS000PRESTCMAYA15000
			// For column CS000PRESTCMAYA15000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(133);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(134,tempBigDecimal);
				else
					pstmt.setNull(134,java.sql.Types.NUMERIC);
			}
			// For column ATRIBCTACTEPASV
			// For column ATRIBCTACTEPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(134);
				if(tempString != null)
					pstmt.setString(135,tempString);
				else
					pstmt.setNull(135,java.sql.Types.VARCHAR);
			}
			// For column ATRIBCTAAHPASV
			// For column ATRIBCTAAHPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(135);
				if(tempString != null)
					pstmt.setString(136,tempString);
				else
					pstmt.setNull(136,java.sql.Types.VARCHAR);
			}
			// For column ATRIBCTAPLAZPASV
			// For column ATRIBCTAPLAZPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(136);
				if(tempString != null)
					pstmt.setString(137,tempString);
				else
					pstmt.setNull(137,java.sql.Types.VARCHAR);
			}
			// For column ATRIBCTSPASV
			// For column ATRIBCTSPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(137);
				if(tempString != null)
					pstmt.setString(138,tempString);
				else
					pstmt.setNull(138,java.sql.Types.VARCHAR);
			}
			// For column ATRIBFMUTUOPASV
			// For column ATRIBFMUTUOPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(138);
				if(tempString != null)
					pstmt.setString(139,tempString);
				else
					pstmt.setNull(139,java.sql.Types.VARCHAR);
			}
			// For column COBOFSERV
			// For column COBOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(139);
				if(tempString != null)
					pstmt.setString(140,tempString);
				else
					pstmt.setNull(140,java.sql.Types.VARCHAR);
			}
			// For column SVIDOFSERV
			// For column SVIDOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(140);
				if(tempString != null)
					pstmt.setString(141,tempString);
				else
					pstmt.setNull(141,java.sql.Types.VARCHAR);
			}
			// For column SONCOFSERV
			// For column SONCOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(141);
				if(tempString != null)
					pstmt.setString(142,tempString);
				else
					pstmt.setNull(142,java.sql.Types.VARCHAR);
			}
			// For column SVINCOFSERV
			// For column SVINCOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(142);
				if(tempString != null)
					pstmt.setString(143,tempString);
				else
					pstmt.setNull(143,java.sql.Types.VARCHAR);
			}
			// For column PHOFSERV
			// For column PHOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(143);
				if(tempString != null)
					pstmt.setString(144,tempString);
				else
					pstmt.setNull(144,java.sql.Types.VARCHAR);
			}
			// For column DEBOFSERV
			// For column DEBOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(144);
				if(tempString != null)
					pstmt.setString(145,tempString);
				else
					pstmt.setNull(145,java.sql.Types.VARCHAR);
			}
			// For column VIPOFSERV
			// For column VIPOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(145);
				if(tempString != null)
					pstmt.setString(146,tempString);
				else
					pstmt.setNull(146,java.sql.Types.VARCHAR);
			}
			// For column OFCNETCAN
			// For column OFCNETCAN
			{
				String tempString;


				tempString=(String)inputRecord.get(146);
				if(tempString != null)
					pstmt.setString(147,tempString);
				else
					pstmt.setNull(147,java.sql.Types.VARCHAR);
			}
			// For column OFCEMPCAN
			// For column OFCEMPCAN
			{
				String tempString;


				tempString=(String)inputRecord.get(147);
				if(tempString != null)
					pstmt.setString(148,tempString);
				else
					pstmt.setNull(148,java.sql.Types.VARCHAR);
			}
			// For column OFLINCOCAN
			// For column OFLINCOCAN
			{
				String tempString;


				tempString=(String)inputRecord.get(148);
				if(tempString != null)
					pstmt.setString(149,tempString);
				else
					pstmt.setNull(149,java.sql.Types.VARCHAR);
			}
			// For column OFB24CAN
			// For column OFB24CAN
			{
				String tempString;


				tempString=(String)inputRecord.get(149);
				if(tempString != null)
					pstmt.setString(150,tempString);
				else
					pstmt.setNull(150,java.sql.Types.VARCHAR);
			}
			// For column OFPOSCAN
			// For column OFPOSCAN
			{
				String tempString;


				tempString=(String)inputRecord.get(150);
				if(tempString != null)
					pstmt.setString(151,tempString);
				else
					pstmt.setNull(151,java.sql.Types.VARCHAR);
			}
			// For column PREFIJO
			// For column PREFIJO
			{
				String tempString;


				tempString=(String)inputRecord.get(151);
				if(tempString != null)
					pstmt.setString(152,tempString);
				else
					pstmt.setNull(152,java.sql.Types.VARCHAR);
			}
			// For column MONTOHIPOTECARIO
			// For column MONTOHIPOTECARIO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(152);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(153,tempBigDecimal);
				else
					pstmt.setNull(153,java.sql.Types.NUMERIC);
			}
			// For column CS000MONTOCTA36
			// For column CS000MONTOCTA36
			{
				String tempString;


				tempString=(String)inputRecord.get(153);
				if(tempString != null)
					pstmt.setString(154,tempString);
				else
					pstmt.setNull(154,java.sql.Types.VARCHAR);
			}
			// For column CS000MONTOCTA48
			// For column CS000MONTOCTA48
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(154);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(155,tempBigDecimal);
				else
					pstmt.setNull(155,java.sql.Types.NUMERIC);
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
	private static String RemoveQuery_0 = "DELETE FROM IILC.TIILC_CLIENTE  WHERE COD_CLIENTE = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column COD_CLIENTE
			// For column COD_CLIENTE
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
	private static String StoreQuery_0 = "UPDATE IILC.TIILC_CLIENTE  SET CODIGO = ?, COD_OFICINA = ?, COD_GESTOR = ?, NOMBRE = ?, COD_TERRITORIO = ?, SEGMENT1 = ?, EDAD = ?, ESTCIVIL = ?, CALLE = ?, NRO = ?, PERFIL = ?, DIREC1 = ?, DISTRITO = ?, PROVINCIA = ?, DEPARTAMENTO = ?, TIPO_PERSONA = ?, CLASIFICACION = ?, TELEFONO = ?, VINCULACION = ?, PPER = ?, PCOM = ?, VNAC = ?, CCTE = ?, COLB = ?, CNET = ?, PAUT = ?, DSCT = ?, VARC = ?, CEMP = ?, SDEP = ?, CEXT = ?, PHIP = ?, LEAS = ?, VCLA = ?, CVIP = ?, SVID = ?, LINCO = ?, PMIV = ?, CLOC = ?, VREP = ?, AHSD = ?, SONC = ?, TCO = ?, B24 = ?, CPTE = ?, PREF = ?, VORO = ?, AHOR = ?, SPRO = ?, POS = ?, T_ACT2 = ?, PMAS = ?, T_ACT3 = ?, LCTA = ?, T_ACT4 = ?, VPLA = ?, T_ACT5 = ?, PLZO = ?, T_ACT6 = ?, PSERV = ?, TPR = ?, PROM = ?, T_ACT_CT2 = ?, VEMP = ?, T_ACT_CT3 = ?, PH = ?, T_ACT_CT4 = ?, FCEX = ?, T_ACT_CT5 = ?, VCTR = ?, T_ACT_CT6 = ?, FMUT = ?, MARGENO = ?, NRO_DOCUMENTO = ?, BCORIE = ?, EMPH = ?, BCORID = ?, AVAL = ?, BCORII = ?, MCLA = ?, BCOPAS = ?, CTS = ?, BCOVOL = ?, TDEB = ?, PORCRIE = ?, MORO = ?, PORCRID = ?, CTSD = ?, PORCRII = ?, TVIP = ?, SBSRIE = ?, SBSRID = ?, SBSRII = ?, SBSJUD = ?, COD_EMPRESA = ?, DES_EMPRESA = ?, INTERVPAS = ?, MOFACTV = ?, CS000LINEAMAXTC = ?, MOFPASV = ?, MOFSERV = ?, MOFCANAL = ?, MPHPASV = ?, CS000MTOPRESTAMO = ?, MONTOVEHICULAR = ?, CTACTEOFERTA = ?, CTAAHOFERTA = ?, CTAPOFERTA = ?, FMUTUOOFERT = ?, CTACTSOFERT = ?, TCONSACTV = ?, MONTOSUBROGADOS = ?, TSUBACTV = ?, THIPOTACTV = ?, TVEHICACTV = ?, TCUOT36ACT = ?, TCUOT48ACT = ?, CS000MONTOCTA60 = ?, TCUOT60ACT = ?, CSS000PRESMENA5000 = ?, CS000COMISDESEMEN5000 = ?, CS000PRES5000A15000 = ?, C5000COMDES15000ACT = ?, CS000PRESMAYA15000 = ?, COMDES15000AC = ?, CS000LINMINADQTC = ?, CS000TIPODECREDITO = ?, CS000MIXMONPREST = ?, CS000MIXLINASISTC = ?, CS000MIXTIPOTC = ?, CS000PRESTCMENA5000 = ?, CS000PRESTC500015000 = ?, CS000PRESTCMAYA15000 = ?, ATRIBCTACTEPASV = ?, ATRIBCTAAHPASV = ?, ATRIBCTAPLAZPASV = ?, ATRIBCTSPASV = ?, ATRIBFMUTUOPASV = ?, COBOFSERV = ?, SVIDOFSERV = ?, SONCOFSERV = ?, SVINCOFSERV = ?, PHOFSERV = ?, DEBOFSERV = ?, VIPOFSERV = ?, OFCNETCAN = ?, OFCEMPCAN = ?, OFLINCOCAN = ?, OFB24CAN = ?, OFPOSCAN = ?, PREFIJO = ?, MONTOHIPOTECARIO = ?, CS000MONTOCTA36 = ?, CS000MONTOCTA48 = ? WHERE COD_CLIENTE = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column COD_CLIENTE
			// For column COD_CLIENTE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(0);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(155,tempBigDecimal);
				else
					pstmt.setNull(155,java.sql.Types.NUMERIC);
			}
			// For column CODIGO
			// For column CODIGO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column NOMBRE
			// For column NOMBRE
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
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column SEGMENT1
			// For column SEGMENT1
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column EDAD
			// For column EDAD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(7,tempBigDecimal);
				else
					pstmt.setNull(7,java.sql.Types.NUMERIC);
			}
			// For column ESTCIVIL
			// For column ESTCIVIL
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column CALLE
			// For column CALLE
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.VARCHAR);
			}
			// For column NRO
			// For column NRO
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.VARCHAR);
			}
			// For column PERFIL
			// For column PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column DIREC1
			// For column DIREC1
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column DISTRITO
			// For column DISTRITO
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.VARCHAR);
			}
			// For column PROVINCIA
			// For column PROVINCIA
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.VARCHAR);
			}
			// For column DEPARTAMENTO
			// For column DEPARTAMENTO
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.VARCHAR);
			}
			// For column TIPO_PERSONA
			// For column TIPO_PERSONA
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.VARCHAR);
			}
			// For column CLASIFICACION
			// For column CLASIFICACION
			{
				String tempString;


				tempString=(String)inputRecord.get(17);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.VARCHAR);
			}
			// For column TELEFONO
			// For column TELEFONO
			{
				String tempString;


				tempString=(String)inputRecord.get(18);
				if(tempString != null)
					pstmt.setString(18,tempString);
				else
					pstmt.setNull(18,java.sql.Types.VARCHAR);
			}
			// For column VINCULACION
			// For column VINCULACION
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.VARCHAR);
			}
			// For column PPER
			// For column PPER
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(20);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(20,tempBigDecimal);
				else
					pstmt.setNull(20,java.sql.Types.NUMERIC);
			}
			// For column PCOM
			// For column PCOM
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(21);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(21,tempBigDecimal);
				else
					pstmt.setNull(21,java.sql.Types.NUMERIC);
			}
			// For column VNAC
			// For column VNAC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(22);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(22,tempBigDecimal);
				else
					pstmt.setNull(22,java.sql.Types.NUMERIC);
			}
			// For column CCTE
			// For column CCTE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(23);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(23,tempBigDecimal);
				else
					pstmt.setNull(23,java.sql.Types.NUMERIC);
			}
			// For column COLB
			// For column COLB
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(24);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(24,tempBigDecimal);
				else
					pstmt.setNull(24,java.sql.Types.NUMERIC);
			}
			// For column CNET
			// For column CNET
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(25);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(25,tempBigDecimal);
				else
					pstmt.setNull(25,java.sql.Types.NUMERIC);
			}
			// For column PAUT
			// For column PAUT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(26);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(26,tempBigDecimal);
				else
					pstmt.setNull(26,java.sql.Types.NUMERIC);
			}
			// For column DSCT
			// For column DSCT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(27);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(27,tempBigDecimal);
				else
					pstmt.setNull(27,java.sql.Types.NUMERIC);
			}
			// For column VARC
			// For column VARC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(28);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(28,tempBigDecimal);
				else
					pstmt.setNull(28,java.sql.Types.NUMERIC);
			}
			// For column CEMP
			// For column CEMP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(29);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(29,tempBigDecimal);
				else
					pstmt.setNull(29,java.sql.Types.NUMERIC);
			}
			// For column SDEP
			// For column SDEP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(30);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(30,tempBigDecimal);
				else
					pstmt.setNull(30,java.sql.Types.NUMERIC);
			}
			// For column CEXT
			// For column CEXT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(31);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(31,tempBigDecimal);
				else
					pstmt.setNull(31,java.sql.Types.NUMERIC);
			}
			// For column PHIP
			// For column PHIP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(32);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(32,tempBigDecimal);
				else
					pstmt.setNull(32,java.sql.Types.NUMERIC);
			}
			// For column LEAS
			// For column LEAS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(33);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(33,tempBigDecimal);
				else
					pstmt.setNull(33,java.sql.Types.NUMERIC);
			}
			// For column VCLA
			// For column VCLA
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(34);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(34,tempBigDecimal);
				else
					pstmt.setNull(34,java.sql.Types.NUMERIC);
			}
			// For column CVIP
			// For column CVIP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(35);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(35,tempBigDecimal);
				else
					pstmt.setNull(35,java.sql.Types.NUMERIC);
			}
			// For column SVID
			// For column SVID
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(36);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(36,tempBigDecimal);
				else
					pstmt.setNull(36,java.sql.Types.NUMERIC);
			}
			// For column LINCO
			// For column LINCO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(37);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(37,tempBigDecimal);
				else
					pstmt.setNull(37,java.sql.Types.NUMERIC);
			}
			// For column PMIV
			// For column PMIV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(38);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(38,tempBigDecimal);
				else
					pstmt.setNull(38,java.sql.Types.NUMERIC);
			}
			// For column CLOC
			// For column CLOC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(39);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(39,tempBigDecimal);
				else
					pstmt.setNull(39,java.sql.Types.NUMERIC);
			}
			// For column VREP
			// For column VREP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(40);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(40,tempBigDecimal);
				else
					pstmt.setNull(40,java.sql.Types.NUMERIC);
			}
			// For column AHSD
			// For column AHSD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(41);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(41,tempBigDecimal);
				else
					pstmt.setNull(41,java.sql.Types.NUMERIC);
			}
			// For column SONC
			// For column SONC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(42);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(42,tempBigDecimal);
				else
					pstmt.setNull(42,java.sql.Types.NUMERIC);
			}
			// For column TCO
			// For column TCO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(43);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(43,tempBigDecimal);
				else
					pstmt.setNull(43,java.sql.Types.NUMERIC);
			}
			// For column B24
			// For column B24
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(44);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(44,tempBigDecimal);
				else
					pstmt.setNull(44,java.sql.Types.NUMERIC);
			}
			// For column CPTE
			// For column CPTE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(45);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(45,tempBigDecimal);
				else
					pstmt.setNull(45,java.sql.Types.NUMERIC);
			}
			// For column PREF
			// For column PREF
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(46);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(46,tempBigDecimal);
				else
					pstmt.setNull(46,java.sql.Types.NUMERIC);
			}
			// For column VORO
			// For column VORO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(47);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(47,tempBigDecimal);
				else
					pstmt.setNull(47,java.sql.Types.NUMERIC);
			}
			// For column AHOR
			// For column AHOR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(48);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(48,tempBigDecimal);
				else
					pstmt.setNull(48,java.sql.Types.NUMERIC);
			}
			// For column SPRO
			// For column SPRO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(49);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(49,tempBigDecimal);
				else
					pstmt.setNull(49,java.sql.Types.NUMERIC);
			}
			// For column POS
			// For column POS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(50);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(50,tempBigDecimal);
				else
					pstmt.setNull(50,java.sql.Types.NUMERIC);
			}
			// For column T_ACT2
			// For column T_ACT2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(51);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(51,tempBigDecimal);
				else
					pstmt.setNull(51,java.sql.Types.NUMERIC);
			}
			// For column PMAS
			// For column PMAS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(52);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(52,tempBigDecimal);
				else
					pstmt.setNull(52,java.sql.Types.NUMERIC);
			}
			// For column T_ACT3
			// For column T_ACT3
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(53);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(53,tempBigDecimal);
				else
					pstmt.setNull(53,java.sql.Types.NUMERIC);
			}
			// For column LCTA
			// For column LCTA
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(54);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(54,tempBigDecimal);
				else
					pstmt.setNull(54,java.sql.Types.NUMERIC);
			}
			// For column T_ACT4
			// For column T_ACT4
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(55);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(55,tempBigDecimal);
				else
					pstmt.setNull(55,java.sql.Types.NUMERIC);
			}
			// For column VPLA
			// For column VPLA
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(56);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(56,tempBigDecimal);
				else
					pstmt.setNull(56,java.sql.Types.NUMERIC);
			}
			// For column T_ACT5
			// For column T_ACT5
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(57);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(57,tempBigDecimal);
				else
					pstmt.setNull(57,java.sql.Types.NUMERIC);
			}
			// For column PLZO
			// For column PLZO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(58);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(58,tempBigDecimal);
				else
					pstmt.setNull(58,java.sql.Types.NUMERIC);
			}
			// For column T_ACT6
			// For column T_ACT6
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(59);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(59,tempBigDecimal);
				else
					pstmt.setNull(59,java.sql.Types.NUMERIC);
			}
			// For column PSERV
			// For column PSERV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(60);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(60,tempBigDecimal);
				else
					pstmt.setNull(60,java.sql.Types.NUMERIC);
			}
			// For column TPR
			// For column TPR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(61);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(61,tempBigDecimal);
				else
					pstmt.setNull(61,java.sql.Types.NUMERIC);
			}
			// For column PROM
			// For column PROM
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(62);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(62,tempBigDecimal);
				else
					pstmt.setNull(62,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT2
			// For column T_ACT_CT2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(63);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(63,tempBigDecimal);
				else
					pstmt.setNull(63,java.sql.Types.NUMERIC);
			}
			// For column VEMP
			// For column VEMP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(64);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(64,tempBigDecimal);
				else
					pstmt.setNull(64,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT3
			// For column T_ACT_CT3
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(65);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(65,tempBigDecimal);
				else
					pstmt.setNull(65,java.sql.Types.NUMERIC);
			}
			// For column PH
			// For column PH
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(66);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(66,tempBigDecimal);
				else
					pstmt.setNull(66,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT4
			// For column T_ACT_CT4
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(67);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(67,tempBigDecimal);
				else
					pstmt.setNull(67,java.sql.Types.NUMERIC);
			}
			// For column FCEX
			// For column FCEX
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(68);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(68,tempBigDecimal);
				else
					pstmt.setNull(68,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT5
			// For column T_ACT_CT5
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(69);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(69,tempBigDecimal);
				else
					pstmt.setNull(69,java.sql.Types.NUMERIC);
			}
			// For column VCTR
			// For column VCTR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(70);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(70,tempBigDecimal);
				else
					pstmt.setNull(70,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT6
			// For column T_ACT_CT6
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(71);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(71,tempBigDecimal);
				else
					pstmt.setNull(71,java.sql.Types.NUMERIC);
			}
			// For column FMUT
			// For column FMUT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(72);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(72,tempBigDecimal);
				else
					pstmt.setNull(72,java.sql.Types.NUMERIC);
			}
			// For column MARGENO
			// For column MARGENO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(73);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(73,tempBigDecimal);
				else
					pstmt.setNull(73,java.sql.Types.NUMERIC);
			}
			// For column NRO_DOCUMENTO
			// For column NRO_DOCUMENTO
			{
				String tempString;


				tempString=(String)inputRecord.get(74);
				if(tempString != null)
					pstmt.setString(74,tempString);
				else
					pstmt.setNull(74,java.sql.Types.VARCHAR);
			}
			// For column BCORIE
			// For column BCORIE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(75);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(75,tempBigDecimal);
				else
					pstmt.setNull(75,java.sql.Types.NUMERIC);
			}
			// For column EMPH
			// For column EMPH
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(76);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(76,tempBigDecimal);
				else
					pstmt.setNull(76,java.sql.Types.NUMERIC);
			}
			// For column BCORID
			// For column BCORID
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(77);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(77,tempBigDecimal);
				else
					pstmt.setNull(77,java.sql.Types.NUMERIC);
			}
			// For column AVAL
			// For column AVAL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(78);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(78,tempBigDecimal);
				else
					pstmt.setNull(78,java.sql.Types.NUMERIC);
			}
			// For column BCORII
			// For column BCORII
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(79);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(79,tempBigDecimal);
				else
					pstmt.setNull(79,java.sql.Types.NUMERIC);
			}
			// For column MCLA
			// For column MCLA
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(80);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(80,tempBigDecimal);
				else
					pstmt.setNull(80,java.sql.Types.NUMERIC);
			}
			// For column BCOPAS
			// For column BCOPAS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(81);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(81,tempBigDecimal);
				else
					pstmt.setNull(81,java.sql.Types.NUMERIC);
			}
			// For column CTS
			// For column CTS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(82);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(82,tempBigDecimal);
				else
					pstmt.setNull(82,java.sql.Types.NUMERIC);
			}
			// For column BCOVOL
			// For column BCOVOL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(83);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(83,tempBigDecimal);
				else
					pstmt.setNull(83,java.sql.Types.NUMERIC);
			}
			// For column TDEB
			// For column TDEB
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(84);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(84,tempBigDecimal);
				else
					pstmt.setNull(84,java.sql.Types.NUMERIC);
			}
			// For column PORCRIE
			// For column PORCRIE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(85);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(85,tempBigDecimal);
				else
					pstmt.setNull(85,java.sql.Types.NUMERIC);
			}
			// For column MORO
			// For column MORO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(86);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(86,tempBigDecimal);
				else
					pstmt.setNull(86,java.sql.Types.NUMERIC);
			}
			// For column PORCRID
			// For column PORCRID
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(87);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(87,tempBigDecimal);
				else
					pstmt.setNull(87,java.sql.Types.NUMERIC);
			}
			// For column CTSD
			// For column CTSD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(88);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(88,tempBigDecimal);
				else
					pstmt.setNull(88,java.sql.Types.NUMERIC);
			}
			// For column PORCRII
			// For column PORCRII
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(89);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(89,tempBigDecimal);
				else
					pstmt.setNull(89,java.sql.Types.NUMERIC);
			}
			// For column TVIP
			// For column TVIP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(90);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(90,tempBigDecimal);
				else
					pstmt.setNull(90,java.sql.Types.NUMERIC);
			}
			// For column SBSRIE
			// For column SBSRIE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(91);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(91,tempBigDecimal);
				else
					pstmt.setNull(91,java.sql.Types.NUMERIC);
			}
			// For column SBSRID
			// For column SBSRID
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(92);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(92,tempBigDecimal);
				else
					pstmt.setNull(92,java.sql.Types.NUMERIC);
			}
			// For column SBSRII
			// For column SBSRII
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(93);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(93,tempBigDecimal);
				else
					pstmt.setNull(93,java.sql.Types.NUMERIC);
			}
			// For column SBSJUD
			// For column SBSJUD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(94);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(94,tempBigDecimal);
				else
					pstmt.setNull(94,java.sql.Types.NUMERIC);
			}
			// For column COD_EMPRESA
			// For column COD_EMPRESA
			{
				String tempString;


				tempString=(String)inputRecord.get(95);
				if(tempString != null)
					pstmt.setString(95,tempString);
				else
					pstmt.setNull(95,java.sql.Types.VARCHAR);
			}
			// For column DES_EMPRESA
			// For column DES_EMPRESA
			{
				String tempString;


				tempString=(String)inputRecord.get(96);
				if(tempString != null)
					pstmt.setString(96,tempString);
				else
					pstmt.setNull(96,java.sql.Types.VARCHAR);
			}
			// For column INTERVPAS
			// For column INTERVPAS
			{
				String tempString;


				tempString=(String)inputRecord.get(97);
				if(tempString != null)
					pstmt.setString(97,tempString);
				else
					pstmt.setNull(97,java.sql.Types.VARCHAR);
			}
			// For column MOFACTV
			// For column MOFACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(98);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(98,tempBigDecimal);
				else
					pstmt.setNull(98,java.sql.Types.NUMERIC);
			}
			// For column CS000LINEAMAXTC
			// For column CS000LINEAMAXTC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(99);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(99,tempBigDecimal);
				else
					pstmt.setNull(99,java.sql.Types.NUMERIC);
			}
			// For column MOFPASV
			// For column MOFPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(100);
				if(tempString != null)
					pstmt.setString(100,tempString);
				else
					pstmt.setNull(100,java.sql.Types.VARCHAR);
			}
			// For column MOFSERV
			// For column MOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(101);
				if(tempString != null)
					pstmt.setString(101,tempString);
				else
					pstmt.setNull(101,java.sql.Types.VARCHAR);
			}
			// For column MOFCANAL
			// For column MOFCANAL
			{
				String tempString;


				tempString=(String)inputRecord.get(102);
				if(tempString != null)
					pstmt.setString(102,tempString);
				else
					pstmt.setNull(102,java.sql.Types.VARCHAR);
			}
			// For column MPHPASV
			// For column MPHPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(103);
				if(tempString != null)
					pstmt.setString(103,tempString);
				else
					pstmt.setNull(103,java.sql.Types.VARCHAR);
			}
			// For column CS000MTOPRESTAMO
			// For column CS000MTOPRESTAMO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(104);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(104,tempBigDecimal);
				else
					pstmt.setNull(104,java.sql.Types.NUMERIC);
			}
			// For column MONTOVEHICULAR
			// For column MONTOVEHICULAR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(105);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(105,tempBigDecimal);
				else
					pstmt.setNull(105,java.sql.Types.NUMERIC);
			}
			// For column CTACTEOFERTA
			// For column CTACTEOFERTA
			{
				String tempString;


				tempString=(String)inputRecord.get(106);
				if(tempString != null)
					pstmt.setString(106,tempString);
				else
					pstmt.setNull(106,java.sql.Types.VARCHAR);
			}
			// For column CTAAHOFERTA
			// For column CTAAHOFERTA
			{
				String tempString;


				tempString=(String)inputRecord.get(107);
				if(tempString != null)
					pstmt.setString(107,tempString);
				else
					pstmt.setNull(107,java.sql.Types.VARCHAR);
			}
			// For column CTAPOFERTA
			// For column CTAPOFERTA
			{
				String tempString;


				tempString=(String)inputRecord.get(108);
				if(tempString != null)
					pstmt.setString(108,tempString);
				else
					pstmt.setNull(108,java.sql.Types.VARCHAR);
			}
			// For column FMUTUOOFERT
			// For column FMUTUOOFERT
			{
				String tempString;


				tempString=(String)inputRecord.get(109);
				if(tempString != null)
					pstmt.setString(109,tempString);
				else
					pstmt.setNull(109,java.sql.Types.VARCHAR);
			}
			// For column CTACTSOFERT
			// For column CTACTSOFERT
			{
				String tempString;


				tempString=(String)inputRecord.get(110);
				if(tempString != null)
					pstmt.setString(110,tempString);
				else
					pstmt.setNull(110,java.sql.Types.VARCHAR);
			}
			// For column TCONSACTV
			// For column TCONSACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(111);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(111,tempBigDecimal);
				else
					pstmt.setNull(111,java.sql.Types.NUMERIC);
			}
			// For column MONTOSUBROGADOS
			// For column MONTOSUBROGADOS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(112);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(112,tempBigDecimal);
				else
					pstmt.setNull(112,java.sql.Types.NUMERIC);
			}
			// For column TSUBACTV
			// For column TSUBACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(113);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(113,tempBigDecimal);
				else
					pstmt.setNull(113,java.sql.Types.NUMERIC);
			}
			// For column THIPOTACTV
			// For column THIPOTACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(114);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(114,tempBigDecimal);
				else
					pstmt.setNull(114,java.sql.Types.NUMERIC);
			}
			// For column TVEHICACTV
			// For column TVEHICACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(115);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(115,tempBigDecimal);
				else
					pstmt.setNull(115,java.sql.Types.NUMERIC);
			}
			// For column TCUOT36ACT
			// For column TCUOT36ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(116);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(116,tempBigDecimal);
				else
					pstmt.setNull(116,java.sql.Types.NUMERIC);
			}
			// For column TCUOT48ACT
			// For column TCUOT48ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(117);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(117,tempBigDecimal);
				else
					pstmt.setNull(117,java.sql.Types.NUMERIC);
			}
			// For column CS000MONTOCTA60
			// For column CS000MONTOCTA60
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(118);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(118,tempBigDecimal);
				else
					pstmt.setNull(118,java.sql.Types.NUMERIC);
			}
			// For column TCUOT60ACT
			// For column TCUOT60ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(119);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(119,tempBigDecimal);
				else
					pstmt.setNull(119,java.sql.Types.NUMERIC);
			}
			// For column CSS000PRESMENA5000
			// For column CSS000PRESMENA5000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(120);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(120,tempBigDecimal);
				else
					pstmt.setNull(120,java.sql.Types.NUMERIC);
			}
			// For column CS000COMISDESEMEN5000
			// For column CS000COMISDESEMEN5000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(121);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(121,tempBigDecimal);
				else
					pstmt.setNull(121,java.sql.Types.NUMERIC);
			}
			// For column CS000PRES5000A15000
			// For column CS000PRES5000A15000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(122);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(122,tempBigDecimal);
				else
					pstmt.setNull(122,java.sql.Types.NUMERIC);
			}
			// For column C5000COMDES15000ACT
			// For column C5000COMDES15000ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(123);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(123,tempBigDecimal);
				else
					pstmt.setNull(123,java.sql.Types.NUMERIC);
			}
			// For column CS000PRESMAYA15000
			// For column CS000PRESMAYA15000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(124);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(124,tempBigDecimal);
				else
					pstmt.setNull(124,java.sql.Types.NUMERIC);
			}
			// For column COMDES15000AC
			// For column COMDES15000AC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(125);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(125,tempBigDecimal);
				else
					pstmt.setNull(125,java.sql.Types.NUMERIC);
			}
			// For column CS000LINMINADQTC
			// For column CS000LINMINADQTC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(126);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(126,tempBigDecimal);
				else
					pstmt.setNull(126,java.sql.Types.NUMERIC);
			}
			// For column CS000TIPODECREDITO
			// For column CS000TIPODECREDITO
			{
				String tempString;


				tempString=(String)inputRecord.get(127);
				if(tempString != null)
					pstmt.setString(127,tempString);
				else
					pstmt.setNull(127,java.sql.Types.VARCHAR);
			}
			// For column CS000MIXMONPREST
			// For column CS000MIXMONPREST
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(128);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(128,tempBigDecimal);
				else
					pstmt.setNull(128,java.sql.Types.NUMERIC);
			}
			// For column CS000MIXLINASISTC
			// For column CS000MIXLINASISTC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(129);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(129,tempBigDecimal);
				else
					pstmt.setNull(129,java.sql.Types.NUMERIC);
			}
			// For column CS000MIXTIPOTC
			// For column CS000MIXTIPOTC
			{
				String tempString;


				tempString=(String)inputRecord.get(130);
				if(tempString != null)
					pstmt.setString(130,tempString);
				else
					pstmt.setNull(130,java.sql.Types.VARCHAR);
			}
			// For column CS000PRESTCMENA5000
			// For column CS000PRESTCMENA5000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(131);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(131,tempBigDecimal);
				else
					pstmt.setNull(131,java.sql.Types.NUMERIC);
			}
			// For column CS000PRESTC500015000
			// For column CS000PRESTC500015000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(132);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(132,tempBigDecimal);
				else
					pstmt.setNull(132,java.sql.Types.NUMERIC);
			}
			// For column CS000PRESTCMAYA15000
			// For column CS000PRESTCMAYA15000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(133);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(133,tempBigDecimal);
				else
					pstmt.setNull(133,java.sql.Types.NUMERIC);
			}
			// For column ATRIBCTACTEPASV
			// For column ATRIBCTACTEPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(134);
				if(tempString != null)
					pstmt.setString(134,tempString);
				else
					pstmt.setNull(134,java.sql.Types.VARCHAR);
			}
			// For column ATRIBCTAAHPASV
			// For column ATRIBCTAAHPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(135);
				if(tempString != null)
					pstmt.setString(135,tempString);
				else
					pstmt.setNull(135,java.sql.Types.VARCHAR);
			}
			// For column ATRIBCTAPLAZPASV
			// For column ATRIBCTAPLAZPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(136);
				if(tempString != null)
					pstmt.setString(136,tempString);
				else
					pstmt.setNull(136,java.sql.Types.VARCHAR);
			}
			// For column ATRIBCTSPASV
			// For column ATRIBCTSPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(137);
				if(tempString != null)
					pstmt.setString(137,tempString);
				else
					pstmt.setNull(137,java.sql.Types.VARCHAR);
			}
			// For column ATRIBFMUTUOPASV
			// For column ATRIBFMUTUOPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(138);
				if(tempString != null)
					pstmt.setString(138,tempString);
				else
					pstmt.setNull(138,java.sql.Types.VARCHAR);
			}
			// For column COBOFSERV
			// For column COBOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(139);
				if(tempString != null)
					pstmt.setString(139,tempString);
				else
					pstmt.setNull(139,java.sql.Types.VARCHAR);
			}
			// For column SVIDOFSERV
			// For column SVIDOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(140);
				if(tempString != null)
					pstmt.setString(140,tempString);
				else
					pstmt.setNull(140,java.sql.Types.VARCHAR);
			}
			// For column SONCOFSERV
			// For column SONCOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(141);
				if(tempString != null)
					pstmt.setString(141,tempString);
				else
					pstmt.setNull(141,java.sql.Types.VARCHAR);
			}
			// For column SVINCOFSERV
			// For column SVINCOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(142);
				if(tempString != null)
					pstmt.setString(142,tempString);
				else
					pstmt.setNull(142,java.sql.Types.VARCHAR);
			}
			// For column PHOFSERV
			// For column PHOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(143);
				if(tempString != null)
					pstmt.setString(143,tempString);
				else
					pstmt.setNull(143,java.sql.Types.VARCHAR);
			}
			// For column DEBOFSERV
			// For column DEBOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(144);
				if(tempString != null)
					pstmt.setString(144,tempString);
				else
					pstmt.setNull(144,java.sql.Types.VARCHAR);
			}
			// For column VIPOFSERV
			// For column VIPOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(145);
				if(tempString != null)
					pstmt.setString(145,tempString);
				else
					pstmt.setNull(145,java.sql.Types.VARCHAR);
			}
			// For column OFCNETCAN
			// For column OFCNETCAN
			{
				String tempString;


				tempString=(String)inputRecord.get(146);
				if(tempString != null)
					pstmt.setString(146,tempString);
				else
					pstmt.setNull(146,java.sql.Types.VARCHAR);
			}
			// For column OFCEMPCAN
			// For column OFCEMPCAN
			{
				String tempString;


				tempString=(String)inputRecord.get(147);
				if(tempString != null)
					pstmt.setString(147,tempString);
				else
					pstmt.setNull(147,java.sql.Types.VARCHAR);
			}
			// For column OFLINCOCAN
			// For column OFLINCOCAN
			{
				String tempString;


				tempString=(String)inputRecord.get(148);
				if(tempString != null)
					pstmt.setString(148,tempString);
				else
					pstmt.setNull(148,java.sql.Types.VARCHAR);
			}
			// For column OFB24CAN
			// For column OFB24CAN
			{
				String tempString;


				tempString=(String)inputRecord.get(149);
				if(tempString != null)
					pstmt.setString(149,tempString);
				else
					pstmt.setNull(149,java.sql.Types.VARCHAR);
			}
			// For column OFPOSCAN
			// For column OFPOSCAN
			{
				String tempString;


				tempString=(String)inputRecord.get(150);
				if(tempString != null)
					pstmt.setString(150,tempString);
				else
					pstmt.setNull(150,java.sql.Types.VARCHAR);
			}
			// For column PREFIJO
			// For column PREFIJO
			{
				String tempString;


				tempString=(String)inputRecord.get(151);
				if(tempString != null)
					pstmt.setString(151,tempString);
				else
					pstmt.setNull(151,java.sql.Types.VARCHAR);
			}
			// For column MONTOHIPOTECARIO
			// For column MONTOHIPOTECARIO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(152);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(152,tempBigDecimal);
				else
					pstmt.setNull(152,java.sql.Types.NUMERIC);
			}
			// For column CS000MONTOCTA36
			// For column CS000MONTOCTA36
			{
				String tempString;


				tempString=(String)inputRecord.get(153);
				if(tempString != null)
					pstmt.setString(153,tempString);
				else
					pstmt.setNull(153,java.sql.Types.VARCHAR);
			}
			// For column CS000MONTOCTA48
			// For column CS000MONTOCTA48
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(154);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(154,tempBigDecimal);
				else
					pstmt.setNull(154,java.sql.Types.NUMERIC);
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
	private static String StoreOCCQuery_0 = "UPDATE IILC.TIILC_CLIENTE  SET CODIGO = ?, COD_OFICINA = ?, COD_GESTOR = ?, NOMBRE = ?, COD_TERRITORIO = ?, SEGMENT1 = ?, EDAD = ?, ESTCIVIL = ?, CALLE = ?, NRO = ?, PERFIL = ?, DIREC1 = ?, DISTRITO = ?, PROVINCIA = ?, DEPARTAMENTO = ?, TIPO_PERSONA = ?, CLASIFICACION = ?, TELEFONO = ?, VINCULACION = ?, PPER = ?, PCOM = ?, VNAC = ?, CCTE = ?, COLB = ?, CNET = ?, PAUT = ?, DSCT = ?, VARC = ?, CEMP = ?, SDEP = ?, CEXT = ?, PHIP = ?, LEAS = ?, VCLA = ?, CVIP = ?, SVID = ?, LINCO = ?, PMIV = ?, CLOC = ?, VREP = ?, AHSD = ?, SONC = ?, TCO = ?, B24 = ?, CPTE = ?, PREF = ?, VORO = ?, AHOR = ?, SPRO = ?, POS = ?, T_ACT2 = ?, PMAS = ?, T_ACT3 = ?, LCTA = ?, T_ACT4 = ?, VPLA = ?, T_ACT5 = ?, PLZO = ?, T_ACT6 = ?, PSERV = ?, TPR = ?, PROM = ?, T_ACT_CT2 = ?, VEMP = ?, T_ACT_CT3 = ?, PH = ?, T_ACT_CT4 = ?, FCEX = ?, T_ACT_CT5 = ?, VCTR = ?, T_ACT_CT6 = ?, FMUT = ?, MARGENO = ?, NRO_DOCUMENTO = ?, BCORIE = ?, EMPH = ?, BCORID = ?, AVAL = ?, BCORII = ?, MCLA = ?, BCOPAS = ?, CTS = ?, BCOVOL = ?, TDEB = ?, PORCRIE = ?, MORO = ?, PORCRID = ?, CTSD = ?, PORCRII = ?, TVIP = ?, SBSRIE = ?, SBSRID = ?, SBSRII = ?, SBSJUD = ?, COD_EMPRESA = ?, DES_EMPRESA = ?, INTERVPAS = ?, MOFACTV = ?, CS000LINEAMAXTC = ?, MOFPASV = ?, MOFSERV = ?, MOFCANAL = ?, MPHPASV = ?, CS000MTOPRESTAMO = ?, MONTOVEHICULAR = ?, CTACTEOFERTA = ?, CTAAHOFERTA = ?, CTAPOFERTA = ?, FMUTUOOFERT = ?, CTACTSOFERT = ?, TCONSACTV = ?, MONTOSUBROGADOS = ?, TSUBACTV = ?, THIPOTACTV = ?, TVEHICACTV = ?, TCUOT36ACT = ?, TCUOT48ACT = ?, CS000MONTOCTA60 = ?, TCUOT60ACT = ?, CSS000PRESMENA5000 = ?, CS000COMISDESEMEN5000 = ?, CS000PRES5000A15000 = ?, C5000COMDES15000ACT = ?, CS000PRESMAYA15000 = ?, COMDES15000AC = ?, CS000LINMINADQTC = ?, CS000TIPODECREDITO = ?, CS000MIXMONPREST = ?, CS000MIXLINASISTC = ?, CS000MIXTIPOTC = ?, CS000PRESTCMENA5000 = ?, CS000PRESTC500015000 = ?, CS000PRESTCMAYA15000 = ?, ATRIBCTACTEPASV = ?, ATRIBCTAAHPASV = ?, ATRIBCTAPLAZPASV = ?, ATRIBCTSPASV = ?, ATRIBFMUTUOPASV = ?, COBOFSERV = ?, SVIDOFSERV = ?, SONCOFSERV = ?, SVINCOFSERV = ?, PHOFSERV = ?, DEBOFSERV = ?, VIPOFSERV = ?, OFCNETCAN = ?, OFCEMPCAN = ?, OFLINCOCAN = ?, OFB24CAN = ?, OFPOSCAN = ?, PREFIJO = ?, MONTOHIPOTECARIO = ?, CS000MONTOCTA36 = ?, CS000MONTOCTA48 = ? WHERE COD_CLIENTE = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column COD_CLIENTE
			// For column COD_CLIENTE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(0);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(155,tempBigDecimal);
				else
					pstmt.setNull(155,java.sql.Types.NUMERIC);
			}
			// For column CODIGO
			// For column CODIGO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column COD_OFICINA
			// For column COD_OFICINA
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column COD_GESTOR
			// For column COD_GESTOR
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column NOMBRE
			// For column NOMBRE
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
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column SEGMENT1
			// For column SEGMENT1
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column EDAD
			// For column EDAD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(7);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(7,tempBigDecimal);
				else
					pstmt.setNull(7,java.sql.Types.NUMERIC);
			}
			// For column ESTCIVIL
			// For column ESTCIVIL
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column CALLE
			// For column CALLE
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.VARCHAR);
			}
			// For column NRO
			// For column NRO
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.VARCHAR);
			}
			// For column PERFIL
			// For column PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column DIREC1
			// For column DIREC1
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column DISTRITO
			// For column DISTRITO
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.VARCHAR);
			}
			// For column PROVINCIA
			// For column PROVINCIA
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.VARCHAR);
			}
			// For column DEPARTAMENTO
			// For column DEPARTAMENTO
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.VARCHAR);
			}
			// For column TIPO_PERSONA
			// For column TIPO_PERSONA
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.VARCHAR);
			}
			// For column CLASIFICACION
			// For column CLASIFICACION
			{
				String tempString;


				tempString=(String)inputRecord.get(17);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.VARCHAR);
			}
			// For column TELEFONO
			// For column TELEFONO
			{
				String tempString;


				tempString=(String)inputRecord.get(18);
				if(tempString != null)
					pstmt.setString(18,tempString);
				else
					pstmt.setNull(18,java.sql.Types.VARCHAR);
			}
			// For column VINCULACION
			// For column VINCULACION
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.VARCHAR);
			}
			// For column PPER
			// For column PPER
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(20);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(20,tempBigDecimal);
				else
					pstmt.setNull(20,java.sql.Types.NUMERIC);
			}
			// For column PCOM
			// For column PCOM
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(21);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(21,tempBigDecimal);
				else
					pstmt.setNull(21,java.sql.Types.NUMERIC);
			}
			// For column VNAC
			// For column VNAC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(22);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(22,tempBigDecimal);
				else
					pstmt.setNull(22,java.sql.Types.NUMERIC);
			}
			// For column CCTE
			// For column CCTE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(23);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(23,tempBigDecimal);
				else
					pstmt.setNull(23,java.sql.Types.NUMERIC);
			}
			// For column COLB
			// For column COLB
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(24);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(24,tempBigDecimal);
				else
					pstmt.setNull(24,java.sql.Types.NUMERIC);
			}
			// For column CNET
			// For column CNET
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(25);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(25,tempBigDecimal);
				else
					pstmt.setNull(25,java.sql.Types.NUMERIC);
			}
			// For column PAUT
			// For column PAUT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(26);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(26,tempBigDecimal);
				else
					pstmt.setNull(26,java.sql.Types.NUMERIC);
			}
			// For column DSCT
			// For column DSCT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(27);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(27,tempBigDecimal);
				else
					pstmt.setNull(27,java.sql.Types.NUMERIC);
			}
			// For column VARC
			// For column VARC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(28);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(28,tempBigDecimal);
				else
					pstmt.setNull(28,java.sql.Types.NUMERIC);
			}
			// For column CEMP
			// For column CEMP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(29);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(29,tempBigDecimal);
				else
					pstmt.setNull(29,java.sql.Types.NUMERIC);
			}
			// For column SDEP
			// For column SDEP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(30);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(30,tempBigDecimal);
				else
					pstmt.setNull(30,java.sql.Types.NUMERIC);
			}
			// For column CEXT
			// For column CEXT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(31);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(31,tempBigDecimal);
				else
					pstmt.setNull(31,java.sql.Types.NUMERIC);
			}
			// For column PHIP
			// For column PHIP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(32);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(32,tempBigDecimal);
				else
					pstmt.setNull(32,java.sql.Types.NUMERIC);
			}
			// For column LEAS
			// For column LEAS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(33);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(33,tempBigDecimal);
				else
					pstmt.setNull(33,java.sql.Types.NUMERIC);
			}
			// For column VCLA
			// For column VCLA
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(34);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(34,tempBigDecimal);
				else
					pstmt.setNull(34,java.sql.Types.NUMERIC);
			}
			// For column CVIP
			// For column CVIP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(35);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(35,tempBigDecimal);
				else
					pstmt.setNull(35,java.sql.Types.NUMERIC);
			}
			// For column SVID
			// For column SVID
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(36);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(36,tempBigDecimal);
				else
					pstmt.setNull(36,java.sql.Types.NUMERIC);
			}
			// For column LINCO
			// For column LINCO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(37);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(37,tempBigDecimal);
				else
					pstmt.setNull(37,java.sql.Types.NUMERIC);
			}
			// For column PMIV
			// For column PMIV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(38);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(38,tempBigDecimal);
				else
					pstmt.setNull(38,java.sql.Types.NUMERIC);
			}
			// For column CLOC
			// For column CLOC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(39);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(39,tempBigDecimal);
				else
					pstmt.setNull(39,java.sql.Types.NUMERIC);
			}
			// For column VREP
			// For column VREP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(40);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(40,tempBigDecimal);
				else
					pstmt.setNull(40,java.sql.Types.NUMERIC);
			}
			// For column AHSD
			// For column AHSD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(41);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(41,tempBigDecimal);
				else
					pstmt.setNull(41,java.sql.Types.NUMERIC);
			}
			// For column SONC
			// For column SONC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(42);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(42,tempBigDecimal);
				else
					pstmt.setNull(42,java.sql.Types.NUMERIC);
			}
			// For column TCO
			// For column TCO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(43);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(43,tempBigDecimal);
				else
					pstmt.setNull(43,java.sql.Types.NUMERIC);
			}
			// For column B24
			// For column B24
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(44);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(44,tempBigDecimal);
				else
					pstmt.setNull(44,java.sql.Types.NUMERIC);
			}
			// For column CPTE
			// For column CPTE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(45);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(45,tempBigDecimal);
				else
					pstmt.setNull(45,java.sql.Types.NUMERIC);
			}
			// For column PREF
			// For column PREF
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(46);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(46,tempBigDecimal);
				else
					pstmt.setNull(46,java.sql.Types.NUMERIC);
			}
			// For column VORO
			// For column VORO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(47);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(47,tempBigDecimal);
				else
					pstmt.setNull(47,java.sql.Types.NUMERIC);
			}
			// For column AHOR
			// For column AHOR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(48);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(48,tempBigDecimal);
				else
					pstmt.setNull(48,java.sql.Types.NUMERIC);
			}
			// For column SPRO
			// For column SPRO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(49);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(49,tempBigDecimal);
				else
					pstmt.setNull(49,java.sql.Types.NUMERIC);
			}
			// For column POS
			// For column POS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(50);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(50,tempBigDecimal);
				else
					pstmt.setNull(50,java.sql.Types.NUMERIC);
			}
			// For column T_ACT2
			// For column T_ACT2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(51);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(51,tempBigDecimal);
				else
					pstmt.setNull(51,java.sql.Types.NUMERIC);
			}
			// For column PMAS
			// For column PMAS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(52);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(52,tempBigDecimal);
				else
					pstmt.setNull(52,java.sql.Types.NUMERIC);
			}
			// For column T_ACT3
			// For column T_ACT3
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(53);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(53,tempBigDecimal);
				else
					pstmt.setNull(53,java.sql.Types.NUMERIC);
			}
			// For column LCTA
			// For column LCTA
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(54);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(54,tempBigDecimal);
				else
					pstmt.setNull(54,java.sql.Types.NUMERIC);
			}
			// For column T_ACT4
			// For column T_ACT4
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(55);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(55,tempBigDecimal);
				else
					pstmt.setNull(55,java.sql.Types.NUMERIC);
			}
			// For column VPLA
			// For column VPLA
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(56);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(56,tempBigDecimal);
				else
					pstmt.setNull(56,java.sql.Types.NUMERIC);
			}
			// For column T_ACT5
			// For column T_ACT5
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(57);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(57,tempBigDecimal);
				else
					pstmt.setNull(57,java.sql.Types.NUMERIC);
			}
			// For column PLZO
			// For column PLZO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(58);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(58,tempBigDecimal);
				else
					pstmt.setNull(58,java.sql.Types.NUMERIC);
			}
			// For column T_ACT6
			// For column T_ACT6
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(59);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(59,tempBigDecimal);
				else
					pstmt.setNull(59,java.sql.Types.NUMERIC);
			}
			// For column PSERV
			// For column PSERV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(60);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(60,tempBigDecimal);
				else
					pstmt.setNull(60,java.sql.Types.NUMERIC);
			}
			// For column TPR
			// For column TPR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(61);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(61,tempBigDecimal);
				else
					pstmt.setNull(61,java.sql.Types.NUMERIC);
			}
			// For column PROM
			// For column PROM
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(62);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(62,tempBigDecimal);
				else
					pstmt.setNull(62,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT2
			// For column T_ACT_CT2
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(63);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(63,tempBigDecimal);
				else
					pstmt.setNull(63,java.sql.Types.NUMERIC);
			}
			// For column VEMP
			// For column VEMP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(64);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(64,tempBigDecimal);
				else
					pstmt.setNull(64,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT3
			// For column T_ACT_CT3
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(65);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(65,tempBigDecimal);
				else
					pstmt.setNull(65,java.sql.Types.NUMERIC);
			}
			// For column PH
			// For column PH
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(66);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(66,tempBigDecimal);
				else
					pstmt.setNull(66,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT4
			// For column T_ACT_CT4
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(67);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(67,tempBigDecimal);
				else
					pstmt.setNull(67,java.sql.Types.NUMERIC);
			}
			// For column FCEX
			// For column FCEX
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(68);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(68,tempBigDecimal);
				else
					pstmt.setNull(68,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT5
			// For column T_ACT_CT5
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(69);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(69,tempBigDecimal);
				else
					pstmt.setNull(69,java.sql.Types.NUMERIC);
			}
			// For column VCTR
			// For column VCTR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(70);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(70,tempBigDecimal);
				else
					pstmt.setNull(70,java.sql.Types.NUMERIC);
			}
			// For column T_ACT_CT6
			// For column T_ACT_CT6
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(71);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(71,tempBigDecimal);
				else
					pstmt.setNull(71,java.sql.Types.NUMERIC);
			}
			// For column FMUT
			// For column FMUT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(72);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(72,tempBigDecimal);
				else
					pstmt.setNull(72,java.sql.Types.NUMERIC);
			}
			// For column MARGENO
			// For column MARGENO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(73);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(73,tempBigDecimal);
				else
					pstmt.setNull(73,java.sql.Types.NUMERIC);
			}
			// For column NRO_DOCUMENTO
			// For column NRO_DOCUMENTO
			{
				String tempString;


				tempString=(String)inputRecord.get(74);
				if(tempString != null)
					pstmt.setString(74,tempString);
				else
					pstmt.setNull(74,java.sql.Types.VARCHAR);
			}
			// For column BCORIE
			// For column BCORIE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(75);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(75,tempBigDecimal);
				else
					pstmt.setNull(75,java.sql.Types.NUMERIC);
			}
			// For column EMPH
			// For column EMPH
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(76);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(76,tempBigDecimal);
				else
					pstmt.setNull(76,java.sql.Types.NUMERIC);
			}
			// For column BCORID
			// For column BCORID
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(77);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(77,tempBigDecimal);
				else
					pstmt.setNull(77,java.sql.Types.NUMERIC);
			}
			// For column AVAL
			// For column AVAL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(78);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(78,tempBigDecimal);
				else
					pstmt.setNull(78,java.sql.Types.NUMERIC);
			}
			// For column BCORII
			// For column BCORII
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(79);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(79,tempBigDecimal);
				else
					pstmt.setNull(79,java.sql.Types.NUMERIC);
			}
			// For column MCLA
			// For column MCLA
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(80);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(80,tempBigDecimal);
				else
					pstmt.setNull(80,java.sql.Types.NUMERIC);
			}
			// For column BCOPAS
			// For column BCOPAS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(81);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(81,tempBigDecimal);
				else
					pstmt.setNull(81,java.sql.Types.NUMERIC);
			}
			// For column CTS
			// For column CTS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(82);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(82,tempBigDecimal);
				else
					pstmt.setNull(82,java.sql.Types.NUMERIC);
			}
			// For column BCOVOL
			// For column BCOVOL
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(83);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(83,tempBigDecimal);
				else
					pstmt.setNull(83,java.sql.Types.NUMERIC);
			}
			// For column TDEB
			// For column TDEB
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(84);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(84,tempBigDecimal);
				else
					pstmt.setNull(84,java.sql.Types.NUMERIC);
			}
			// For column PORCRIE
			// For column PORCRIE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(85);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(85,tempBigDecimal);
				else
					pstmt.setNull(85,java.sql.Types.NUMERIC);
			}
			// For column MORO
			// For column MORO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(86);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(86,tempBigDecimal);
				else
					pstmt.setNull(86,java.sql.Types.NUMERIC);
			}
			// For column PORCRID
			// For column PORCRID
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(87);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(87,tempBigDecimal);
				else
					pstmt.setNull(87,java.sql.Types.NUMERIC);
			}
			// For column CTSD
			// For column CTSD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(88);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(88,tempBigDecimal);
				else
					pstmt.setNull(88,java.sql.Types.NUMERIC);
			}
			// For column PORCRII
			// For column PORCRII
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(89);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(89,tempBigDecimal);
				else
					pstmt.setNull(89,java.sql.Types.NUMERIC);
			}
			// For column TVIP
			// For column TVIP
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(90);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(90,tempBigDecimal);
				else
					pstmt.setNull(90,java.sql.Types.NUMERIC);
			}
			// For column SBSRIE
			// For column SBSRIE
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(91);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(91,tempBigDecimal);
				else
					pstmt.setNull(91,java.sql.Types.NUMERIC);
			}
			// For column SBSRID
			// For column SBSRID
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(92);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(92,tempBigDecimal);
				else
					pstmt.setNull(92,java.sql.Types.NUMERIC);
			}
			// For column SBSRII
			// For column SBSRII
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(93);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(93,tempBigDecimal);
				else
					pstmt.setNull(93,java.sql.Types.NUMERIC);
			}
			// For column SBSJUD
			// For column SBSJUD
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(94);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(94,tempBigDecimal);
				else
					pstmt.setNull(94,java.sql.Types.NUMERIC);
			}
			// For column COD_EMPRESA
			// For column COD_EMPRESA
			{
				String tempString;


				tempString=(String)inputRecord.get(95);
				if(tempString != null)
					pstmt.setString(95,tempString);
				else
					pstmt.setNull(95,java.sql.Types.VARCHAR);
			}
			// For column DES_EMPRESA
			// For column DES_EMPRESA
			{
				String tempString;


				tempString=(String)inputRecord.get(96);
				if(tempString != null)
					pstmt.setString(96,tempString);
				else
					pstmt.setNull(96,java.sql.Types.VARCHAR);
			}
			// For column INTERVPAS
			// For column INTERVPAS
			{
				String tempString;


				tempString=(String)inputRecord.get(97);
				if(tempString != null)
					pstmt.setString(97,tempString);
				else
					pstmt.setNull(97,java.sql.Types.VARCHAR);
			}
			// For column MOFACTV
			// For column MOFACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(98);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(98,tempBigDecimal);
				else
					pstmt.setNull(98,java.sql.Types.NUMERIC);
			}
			// For column CS000LINEAMAXTC
			// For column CS000LINEAMAXTC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(99);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(99,tempBigDecimal);
				else
					pstmt.setNull(99,java.sql.Types.NUMERIC);
			}
			// For column MOFPASV
			// For column MOFPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(100);
				if(tempString != null)
					pstmt.setString(100,tempString);
				else
					pstmt.setNull(100,java.sql.Types.VARCHAR);
			}
			// For column MOFSERV
			// For column MOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(101);
				if(tempString != null)
					pstmt.setString(101,tempString);
				else
					pstmt.setNull(101,java.sql.Types.VARCHAR);
			}
			// For column MOFCANAL
			// For column MOFCANAL
			{
				String tempString;


				tempString=(String)inputRecord.get(102);
				if(tempString != null)
					pstmt.setString(102,tempString);
				else
					pstmt.setNull(102,java.sql.Types.VARCHAR);
			}
			// For column MPHPASV
			// For column MPHPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(103);
				if(tempString != null)
					pstmt.setString(103,tempString);
				else
					pstmt.setNull(103,java.sql.Types.VARCHAR);
			}
			// For column CS000MTOPRESTAMO
			// For column CS000MTOPRESTAMO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(104);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(104,tempBigDecimal);
				else
					pstmt.setNull(104,java.sql.Types.NUMERIC);
			}
			// For column MONTOVEHICULAR
			// For column MONTOVEHICULAR
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(105);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(105,tempBigDecimal);
				else
					pstmt.setNull(105,java.sql.Types.NUMERIC);
			}
			// For column CTACTEOFERTA
			// For column CTACTEOFERTA
			{
				String tempString;


				tempString=(String)inputRecord.get(106);
				if(tempString != null)
					pstmt.setString(106,tempString);
				else
					pstmt.setNull(106,java.sql.Types.VARCHAR);
			}
			// For column CTAAHOFERTA
			// For column CTAAHOFERTA
			{
				String tempString;


				tempString=(String)inputRecord.get(107);
				if(tempString != null)
					pstmt.setString(107,tempString);
				else
					pstmt.setNull(107,java.sql.Types.VARCHAR);
			}
			// For column CTAPOFERTA
			// For column CTAPOFERTA
			{
				String tempString;


				tempString=(String)inputRecord.get(108);
				if(tempString != null)
					pstmt.setString(108,tempString);
				else
					pstmt.setNull(108,java.sql.Types.VARCHAR);
			}
			// For column FMUTUOOFERT
			// For column FMUTUOOFERT
			{
				String tempString;


				tempString=(String)inputRecord.get(109);
				if(tempString != null)
					pstmt.setString(109,tempString);
				else
					pstmt.setNull(109,java.sql.Types.VARCHAR);
			}
			// For column CTACTSOFERT
			// For column CTACTSOFERT
			{
				String tempString;


				tempString=(String)inputRecord.get(110);
				if(tempString != null)
					pstmt.setString(110,tempString);
				else
					pstmt.setNull(110,java.sql.Types.VARCHAR);
			}
			// For column TCONSACTV
			// For column TCONSACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(111);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(111,tempBigDecimal);
				else
					pstmt.setNull(111,java.sql.Types.NUMERIC);
			}
			// For column MONTOSUBROGADOS
			// For column MONTOSUBROGADOS
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(112);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(112,tempBigDecimal);
				else
					pstmt.setNull(112,java.sql.Types.NUMERIC);
			}
			// For column TSUBACTV
			// For column TSUBACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(113);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(113,tempBigDecimal);
				else
					pstmt.setNull(113,java.sql.Types.NUMERIC);
			}
			// For column THIPOTACTV
			// For column THIPOTACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(114);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(114,tempBigDecimal);
				else
					pstmt.setNull(114,java.sql.Types.NUMERIC);
			}
			// For column TVEHICACTV
			// For column TVEHICACTV
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(115);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(115,tempBigDecimal);
				else
					pstmt.setNull(115,java.sql.Types.NUMERIC);
			}
			// For column TCUOT36ACT
			// For column TCUOT36ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(116);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(116,tempBigDecimal);
				else
					pstmt.setNull(116,java.sql.Types.NUMERIC);
			}
			// For column TCUOT48ACT
			// For column TCUOT48ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(117);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(117,tempBigDecimal);
				else
					pstmt.setNull(117,java.sql.Types.NUMERIC);
			}
			// For column CS000MONTOCTA60
			// For column CS000MONTOCTA60
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(118);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(118,tempBigDecimal);
				else
					pstmt.setNull(118,java.sql.Types.NUMERIC);
			}
			// For column TCUOT60ACT
			// For column TCUOT60ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(119);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(119,tempBigDecimal);
				else
					pstmt.setNull(119,java.sql.Types.NUMERIC);
			}
			// For column CSS000PRESMENA5000
			// For column CSS000PRESMENA5000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(120);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(120,tempBigDecimal);
				else
					pstmt.setNull(120,java.sql.Types.NUMERIC);
			}
			// For column CS000COMISDESEMEN5000
			// For column CS000COMISDESEMEN5000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(121);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(121,tempBigDecimal);
				else
					pstmt.setNull(121,java.sql.Types.NUMERIC);
			}
			// For column CS000PRES5000A15000
			// For column CS000PRES5000A15000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(122);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(122,tempBigDecimal);
				else
					pstmt.setNull(122,java.sql.Types.NUMERIC);
			}
			// For column C5000COMDES15000ACT
			// For column C5000COMDES15000ACT
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(123);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(123,tempBigDecimal);
				else
					pstmt.setNull(123,java.sql.Types.NUMERIC);
			}
			// For column CS000PRESMAYA15000
			// For column CS000PRESMAYA15000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(124);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(124,tempBigDecimal);
				else
					pstmt.setNull(124,java.sql.Types.NUMERIC);
			}
			// For column COMDES15000AC
			// For column COMDES15000AC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(125);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(125,tempBigDecimal);
				else
					pstmt.setNull(125,java.sql.Types.NUMERIC);
			}
			// For column CS000LINMINADQTC
			// For column CS000LINMINADQTC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(126);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(126,tempBigDecimal);
				else
					pstmt.setNull(126,java.sql.Types.NUMERIC);
			}
			// For column CS000TIPODECREDITO
			// For column CS000TIPODECREDITO
			{
				String tempString;


				tempString=(String)inputRecord.get(127);
				if(tempString != null)
					pstmt.setString(127,tempString);
				else
					pstmt.setNull(127,java.sql.Types.VARCHAR);
			}
			// For column CS000MIXMONPREST
			// For column CS000MIXMONPREST
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(128);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(128,tempBigDecimal);
				else
					pstmt.setNull(128,java.sql.Types.NUMERIC);
			}
			// For column CS000MIXLINASISTC
			// For column CS000MIXLINASISTC
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(129);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(129,tempBigDecimal);
				else
					pstmt.setNull(129,java.sql.Types.NUMERIC);
			}
			// For column CS000MIXTIPOTC
			// For column CS000MIXTIPOTC
			{
				String tempString;


				tempString=(String)inputRecord.get(130);
				if(tempString != null)
					pstmt.setString(130,tempString);
				else
					pstmt.setNull(130,java.sql.Types.VARCHAR);
			}
			// For column CS000PRESTCMENA5000
			// For column CS000PRESTCMENA5000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(131);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(131,tempBigDecimal);
				else
					pstmt.setNull(131,java.sql.Types.NUMERIC);
			}
			// For column CS000PRESTC500015000
			// For column CS000PRESTC500015000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(132);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(132,tempBigDecimal);
				else
					pstmt.setNull(132,java.sql.Types.NUMERIC);
			}
			// For column CS000PRESTCMAYA15000
			// For column CS000PRESTCMAYA15000
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(133);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(133,tempBigDecimal);
				else
					pstmt.setNull(133,java.sql.Types.NUMERIC);
			}
			// For column ATRIBCTACTEPASV
			// For column ATRIBCTACTEPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(134);
				if(tempString != null)
					pstmt.setString(134,tempString);
				else
					pstmt.setNull(134,java.sql.Types.VARCHAR);
			}
			// For column ATRIBCTAAHPASV
			// For column ATRIBCTAAHPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(135);
				if(tempString != null)
					pstmt.setString(135,tempString);
				else
					pstmt.setNull(135,java.sql.Types.VARCHAR);
			}
			// For column ATRIBCTAPLAZPASV
			// For column ATRIBCTAPLAZPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(136);
				if(tempString != null)
					pstmt.setString(136,tempString);
				else
					pstmt.setNull(136,java.sql.Types.VARCHAR);
			}
			// For column ATRIBCTSPASV
			// For column ATRIBCTSPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(137);
				if(tempString != null)
					pstmt.setString(137,tempString);
				else
					pstmt.setNull(137,java.sql.Types.VARCHAR);
			}
			// For column ATRIBFMUTUOPASV
			// For column ATRIBFMUTUOPASV
			{
				String tempString;


				tempString=(String)inputRecord.get(138);
				if(tempString != null)
					pstmt.setString(138,tempString);
				else
					pstmt.setNull(138,java.sql.Types.VARCHAR);
			}
			// For column COBOFSERV
			// For column COBOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(139);
				if(tempString != null)
					pstmt.setString(139,tempString);
				else
					pstmt.setNull(139,java.sql.Types.VARCHAR);
			}
			// For column SVIDOFSERV
			// For column SVIDOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(140);
				if(tempString != null)
					pstmt.setString(140,tempString);
				else
					pstmt.setNull(140,java.sql.Types.VARCHAR);
			}
			// For column SONCOFSERV
			// For column SONCOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(141);
				if(tempString != null)
					pstmt.setString(141,tempString);
				else
					pstmt.setNull(141,java.sql.Types.VARCHAR);
			}
			// For column SVINCOFSERV
			// For column SVINCOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(142);
				if(tempString != null)
					pstmt.setString(142,tempString);
				else
					pstmt.setNull(142,java.sql.Types.VARCHAR);
			}
			// For column PHOFSERV
			// For column PHOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(143);
				if(tempString != null)
					pstmt.setString(143,tempString);
				else
					pstmt.setNull(143,java.sql.Types.VARCHAR);
			}
			// For column DEBOFSERV
			// For column DEBOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(144);
				if(tempString != null)
					pstmt.setString(144,tempString);
				else
					pstmt.setNull(144,java.sql.Types.VARCHAR);
			}
			// For column VIPOFSERV
			// For column VIPOFSERV
			{
				String tempString;


				tempString=(String)inputRecord.get(145);
				if(tempString != null)
					pstmt.setString(145,tempString);
				else
					pstmt.setNull(145,java.sql.Types.VARCHAR);
			}
			// For column OFCNETCAN
			// For column OFCNETCAN
			{
				String tempString;


				tempString=(String)inputRecord.get(146);
				if(tempString != null)
					pstmt.setString(146,tempString);
				else
					pstmt.setNull(146,java.sql.Types.VARCHAR);
			}
			// For column OFCEMPCAN
			// For column OFCEMPCAN
			{
				String tempString;


				tempString=(String)inputRecord.get(147);
				if(tempString != null)
					pstmt.setString(147,tempString);
				else
					pstmt.setNull(147,java.sql.Types.VARCHAR);
			}
			// For column OFLINCOCAN
			// For column OFLINCOCAN
			{
				String tempString;


				tempString=(String)inputRecord.get(148);
				if(tempString != null)
					pstmt.setString(148,tempString);
				else
					pstmt.setNull(148,java.sql.Types.VARCHAR);
			}
			// For column OFB24CAN
			// For column OFB24CAN
			{
				String tempString;


				tempString=(String)inputRecord.get(149);
				if(tempString != null)
					pstmt.setString(149,tempString);
				else
					pstmt.setNull(149,java.sql.Types.VARCHAR);
			}
			// For column OFPOSCAN
			// For column OFPOSCAN
			{
				String tempString;


				tempString=(String)inputRecord.get(150);
				if(tempString != null)
					pstmt.setString(150,tempString);
				else
					pstmt.setNull(150,java.sql.Types.VARCHAR);
			}
			// For column PREFIJO
			// For column PREFIJO
			{
				String tempString;


				tempString=(String)inputRecord.get(151);
				if(tempString != null)
					pstmt.setString(151,tempString);
				else
					pstmt.setNull(151,java.sql.Types.VARCHAR);
			}
			// For column MONTOHIPOTECARIO
			// For column MONTOHIPOTECARIO
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(152);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(152,tempBigDecimal);
				else
					pstmt.setNull(152,java.sql.Types.NUMERIC);
			}
			// For column CS000MONTOCTA36
			// For column CS000MONTOCTA36
			{
				String tempString;


				tempString=(String)inputRecord.get(153);
				if(tempString != null)
					pstmt.setString(153,tempString);
				else
					pstmt.setNull(153,java.sql.Types.VARCHAR);
			}
			// For column CS000MONTOCTA48
			// For column CS000MONTOCTA48
			{
				java.math.BigDecimal tempBigDecimal;


				tempBigDecimal=(java.math.BigDecimal)inputRecord.get(154);
				if(tempBigDecimal != null)
					pstmt.setBigDecimal(154,tempBigDecimal);
				else
					pstmt.setNull(154,java.sql.Types.NUMERIC);
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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.COD_CLIENTE, T1.CODIGO, T1.COD_OFICINA, T1.COD_GESTOR, T1.NOMBRE, T1.COD_TERRITORIO, T1.SEGMENT1, T1.EDAD, T1.ESTCIVIL, T1.CALLE, T1.NRO, T1.PERFIL, T1.DIREC1, T1.DISTRITO, T1.PROVINCIA, T1.DEPARTAMENTO, T1.TIPO_PERSONA, T1.CLASIFICACION, T1.TELEFONO, T1.VINCULACION, T1.PPER, T1.PCOM, T1.VNAC, T1.CCTE, T1.COLB, T1.CNET, T1.PAUT, T1.DSCT, T1.VARC, T1.CEMP, T1.SDEP, T1.CEXT, T1.PHIP, T1.LEAS, T1.VCLA, T1.CVIP, T1.SVID, T1.LINCO, T1.PMIV, T1.CLOC, T1.VREP, T1.AHSD, T1.SONC, T1.TCO, T1.B24, T1.CPTE, T1.PREF, T1.VORO, T1.AHOR, T1.SPRO, T1.POS, T1.T_ACT2, T1.PMAS, T1.T_ACT3, T1.LCTA, T1.T_ACT4, T1.VPLA, T1.T_ACT5, T1.PLZO, T1.T_ACT6, T1.PSERV, T1.TPR, T1.PROM, T1.T_ACT_CT2, T1.VEMP, T1.T_ACT_CT3, T1.PH, T1.T_ACT_CT4, T1.FCEX, T1.T_ACT_CT5, T1.VCTR, T1.T_ACT_CT6, T1.FMUT, T1.MARGENO, T1.NRO_DOCUMENTO, T1.BCORIE, T1.EMPH, T1.BCORID, T1.AVAL, T1.BCORII, T1.MCLA, T1.BCOPAS, T1.CTS, T1.BCOVOL, T1.TDEB, T1.PORCRIE, T1.MORO, T1.PORCRID, T1.CTSD, T1.PORCRII, T1.TVIP, T1.SBSRIE, T1.SBSRID, T1.SBSRII, T1.SBSJUD, T1.COD_EMPRESA, T1.DES_EMPRESA, T1.INTERVPAS, T1.MOFACTV, T1.CS000LINEAMAXTC, T1.MOFPASV, T1.MOFSERV, T1.MOFCANAL, T1.MPHPASV, T1.CS000MTOPRESTAMO, T1.MONTOVEHICULAR, T1.CTACTEOFERTA, T1.CTAAHOFERTA, T1.CTAPOFERTA, T1.FMUTUOOFERT, T1.CTACTSOFERT, T1.TCONSACTV, T1.MONTOSUBROGADOS, T1.TSUBACTV, T1.THIPOTACTV, T1.TVEHICACTV, T1.TCUOT36ACT, T1.TCUOT48ACT, T1.CS000MONTOCTA60, T1.TCUOT60ACT, T1.CSS000PRESMENA5000, T1.CS000COMISDESEMEN5000, T1.CS000PRES5000A15000, T1.C5000COMDES15000ACT, T1.CS000PRESMAYA15000, T1.COMDES15000AC, T1.CS000LINMINADQTC, T1.CS000TIPODECREDITO, T1.CS000MIXMONPREST, T1.CS000MIXLINASISTC, T1.CS000MIXTIPOTC, T1.CS000PRESTCMENA5000, T1.CS000PRESTC500015000, T1.CS000PRESTCMAYA15000, T1.ATRIBCTACTEPASV, T1.ATRIBCTAAHPASV, T1.ATRIBCTAPLAZPASV, T1.ATRIBCTSPASV, T1.ATRIBFMUTUOPASV, T1.COBOFSERV, T1.SVIDOFSERV, T1.SONCOFSERV, T1.SVINCOFSERV, T1.PHOFSERV, T1.DEBOFSERV, T1.VIPOFSERV, T1.OFCNETCAN, T1.OFCEMPCAN, T1.OFLINCOCAN, T1.OFB24CAN, T1.OFPOSCAN, T1.PREFIJO, T1.MONTOHIPOTECARIO, T1.CS000MONTOCTA36, T1.CS000MONTOCTA48 FROM IILC.TIILC_CLIENTE  T1 WHERE T1.COD_CLIENTE = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column COD_CLIENTE
			// For column COD_CLIENTE
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.COD_CLIENTE, T1.CODIGO, T1.COD_OFICINA, T1.COD_GESTOR, T1.NOMBRE, T1.COD_TERRITORIO, T1.SEGMENT1, T1.EDAD, T1.ESTCIVIL, T1.CALLE, T1.NRO, T1.PERFIL, T1.DIREC1, T1.DISTRITO, T1.PROVINCIA, T1.DEPARTAMENTO, T1.TIPO_PERSONA, T1.CLASIFICACION, T1.TELEFONO, T1.VINCULACION, T1.PPER, T1.PCOM, T1.VNAC, T1.CCTE, T1.COLB, T1.CNET, T1.PAUT, T1.DSCT, T1.VARC, T1.CEMP, T1.SDEP, T1.CEXT, T1.PHIP, T1.LEAS, T1.VCLA, T1.CVIP, T1.SVID, T1.LINCO, T1.PMIV, T1.CLOC, T1.VREP, T1.AHSD, T1.SONC, T1.TCO, T1.B24, T1.CPTE, T1.PREF, T1.VORO, T1.AHOR, T1.SPRO, T1.POS, T1.T_ACT2, T1.PMAS, T1.T_ACT3, T1.LCTA, T1.T_ACT4, T1.VPLA, T1.T_ACT5, T1.PLZO, T1.T_ACT6, T1.PSERV, T1.TPR, T1.PROM, T1.T_ACT_CT2, T1.VEMP, T1.T_ACT_CT3, T1.PH, T1.T_ACT_CT4, T1.FCEX, T1.T_ACT_CT5, T1.VCTR, T1.T_ACT_CT6, T1.FMUT, T1.MARGENO, T1.NRO_DOCUMENTO, T1.BCORIE, T1.EMPH, T1.BCORID, T1.AVAL, T1.BCORII, T1.MCLA, T1.BCOPAS, T1.CTS, T1.BCOVOL, T1.TDEB, T1.PORCRIE, T1.MORO, T1.PORCRID, T1.CTSD, T1.PORCRII, T1.TVIP, T1.SBSRIE, T1.SBSRID, T1.SBSRII, T1.SBSJUD, T1.COD_EMPRESA, T1.DES_EMPRESA, T1.INTERVPAS, T1.MOFACTV, T1.CS000LINEAMAXTC, T1.MOFPASV, T1.MOFSERV, T1.MOFCANAL, T1.MPHPASV, T1.CS000MTOPRESTAMO, T1.MONTOVEHICULAR, T1.CTACTEOFERTA, T1.CTAAHOFERTA, T1.CTAPOFERTA, T1.FMUTUOOFERT, T1.CTACTSOFERT, T1.TCONSACTV, T1.MONTOSUBROGADOS, T1.TSUBACTV, T1.THIPOTACTV, T1.TVEHICACTV, T1.TCUOT36ACT, T1.TCUOT48ACT, T1.CS000MONTOCTA60, T1.TCUOT60ACT, T1.CSS000PRESMENA5000, T1.CS000COMISDESEMEN5000, T1.CS000PRES5000A15000, T1.C5000COMDES15000ACT, T1.CS000PRESMAYA15000, T1.COMDES15000AC, T1.CS000LINMINADQTC, T1.CS000TIPODECREDITO, T1.CS000MIXMONPREST, T1.CS000MIXLINASISTC, T1.CS000MIXTIPOTC, T1.CS000PRESTCMENA5000, T1.CS000PRESTC500015000, T1.CS000PRESTCMAYA15000, T1.ATRIBCTACTEPASV, T1.ATRIBCTAAHPASV, T1.ATRIBCTAPLAZPASV, T1.ATRIBCTSPASV, T1.ATRIBFMUTUOPASV, T1.COBOFSERV, T1.SVIDOFSERV, T1.SONCOFSERV, T1.SVINCOFSERV, T1.PHOFSERV, T1.DEBOFSERV, T1.VIPOFSERV, T1.OFCNETCAN, T1.OFCEMPCAN, T1.OFLINCOCAN, T1.OFB24CAN, T1.OFPOSCAN, T1.PREFIJO, T1.MONTOHIPOTECARIO, T1.CS000MONTOCTA36, T1.CS000MONTOCTA48 FROM IILC.TIILC_CLIENTE  T1 WHERE T1.COD_CLIENTE = ? FOR UPDATE ";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column COD_CLIENTE
			// For column COD_CLIENTE
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
	 * Tiilc_clienteBeanFunctionSet_f5b4eb46
	 */
	public Tiilc_clienteBeanFunctionSet_f5b4eb46() {
		functionHash=new java.util.HashMap(10);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByPrimaryKey",new Integer(4));
		functionHash.put("FindByPrimaryKey444Update",new Integer(5));
		functionHash.put("ReadReadChecking",new Integer(6));
		functionHash.put("ReadReadCheckingForUpdate",new Integer(7));
		functionHash.put("PartialStore",new Integer(8));
		functionHash.put("PartialStoreUsingOCC",new Integer(9));
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
			ReadReadChecking(inputRecord,connection,interactionSpec);
			break;
		case 7:
			ReadReadCheckingForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 8:
			PartialStore(inputRecord,connection,interactionSpec);
			break;
		case 9:
			PartialStoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
	private static String ReadReadQuery_0 = " SELECT 1 FROM IILC.TIILC_CLIENTE  T1 WHERE T1.COD_CLIENTE = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column COD_CLIENTE
			// For column COD_CLIENTE
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM IILC.TIILC_CLIENTE  T1 WHERE T1.COD_CLIENTE = ? FOR UPDATE ";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column COD_CLIENTE
			// For column COD_CLIENTE
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
		updateTemplateList = Tiilc_clienteBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column CODIGO
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
						// For column COD_OFICINA
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
						// For column COD_GESTOR
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
						// For column NOMBRE
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
						// For column COD_TERRITORIO
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
						// For column SEGMENT1
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
						// For column EDAD
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
						// For column ESTCIVIL
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
						// For column CALLE
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
						// For column NRO
						String tempString;


						tempString=(String)inputRecord.get(10);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column PERFIL
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column DIREC1
						String tempString;


						tempString=(String)inputRecord.get(12);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column DISTRITO
						String tempString;


						tempString=(String)inputRecord.get(13);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column PROVINCIA
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
						// For column DEPARTAMENTO
						String tempString;


						tempString=(String)inputRecord.get(15);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column TIPO_PERSONA
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
						// For column CLASIFICACION
						String tempString;


						tempString=(String)inputRecord.get(17);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column TELEFONO
						String tempString;


						tempString=(String)inputRecord.get(18);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column VINCULACION
						String tempString;


						tempString=(String)inputRecord.get(19);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column PPER
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
						// For column PCOM
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
						// For column VNAC
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
						// For column CCTE
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
						// For column COLB
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
						// For column CNET
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
						// For column PAUT
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
						// For column DSCT
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
						// For column VARC
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
						// For column CEMP
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
						// For column SDEP
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
						// For column CEXT
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
						// For column PHIP
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
						// For column LEAS
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
						// For column VCLA
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
						// For column CVIP
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
						// For column SVID
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
						// For column LINCO
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
						// For column PMIV
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
						// For column CLOC
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
						// For column VREP
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
						// For column AHSD
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
						// For column SONC
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
						// For column TCO
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
						// For column B24
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
						// For column CPTE
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
						// For column PREF
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
						// For column VORO
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
						// For column AHOR
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
						// For column SPRO
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
						// For column POS
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
						// For column T_ACT2
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
						// For column PMAS
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
						// For column T_ACT3
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
						// For column LCTA
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
						// For column T_ACT4
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
						// For column VPLA
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
						// For column T_ACT5
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
						// For column PLZO
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
						// For column T_ACT6
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
						// For column PSERV
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
						// For column TPR
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
						// For column PROM
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
						// For column T_ACT_CT2
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
						// For column VEMP
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
						// For column T_ACT_CT3
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
						// For column PH
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
						// For column T_ACT_CT4
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
						// For column FCEX
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
						// For column T_ACT_CT5
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
						// For column VCTR
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
						// For column T_ACT_CT6
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
						// For column FMUT
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
						// For column MARGENO
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
						// For column NRO_DOCUMENTO
						String tempString;


						tempString=(String)inputRecord.get(74);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[75])
					{
						// For column BCORIE
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
						// For column EMPH
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
						// For column BCORID
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
						// For column AVAL
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
						// For column BCORII
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
						// For column MCLA
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
						// For column BCOPAS
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
						// For column CTS
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
						// For column BCOVOL
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
						// For column TDEB
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
						// For column PORCRIE
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
						// For column MORO
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
						// For column PORCRID
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
						// For column CTSD
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
						// For column PORCRII
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
						// For column TVIP
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
						// For column SBSRIE
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
						// For column SBSRID
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
						// For column SBSRII
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
						// For column SBSJUD
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
						// For column COD_EMPRESA
						String tempString;


						tempString=(String)inputRecord.get(95);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[96])
					{
						// For column DES_EMPRESA
						String tempString;


						tempString=(String)inputRecord.get(96);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[97])
					{
						// For column INTERVPAS
						String tempString;


						tempString=(String)inputRecord.get(97);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[98])
					{
						// For column MOFACTV
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
						// For column CS000LINEAMAXTC
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
						// For column MOFPASV
						String tempString;


						tempString=(String)inputRecord.get(100);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[101])
					{
						// For column MOFSERV
						String tempString;


						tempString=(String)inputRecord.get(101);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[102])
					{
						// For column MOFCANAL
						String tempString;


						tempString=(String)inputRecord.get(102);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[103])
					{
						// For column MPHPASV
						String tempString;


						tempString=(String)inputRecord.get(103);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[104])
					{
						// For column CS000MTOPRESTAMO
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
						// For column MONTOVEHICULAR
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(105);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[107])
					{
						// For column CTACTEOFERTA
						String tempString;


						tempString=(String)inputRecord.get(106);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[108])
					{
						// For column CTAAHOFERTA
						String tempString;


						tempString=(String)inputRecord.get(107);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[109])
					{
						// For column CTAPOFERTA
						String tempString;


						tempString=(String)inputRecord.get(108);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[110])
					{
						// For column FMUTUOOFERT
						String tempString;


						tempString=(String)inputRecord.get(109);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[111])
					{
						// For column CTACTSOFERT
						String tempString;


						tempString=(String)inputRecord.get(110);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[112])
					{
						// For column TCONSACTV
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(111);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[113])
					{
						// For column MONTOSUBROGADOS
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(112);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[114])
					{
						// For column TSUBACTV
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(113);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[115])
					{
						// For column THIPOTACTV
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(114);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[116])
					{
						// For column TVEHICACTV
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(115);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[118])
					{
						// For column TCUOT36ACT
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(116);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[120])
					{
						// For column TCUOT48ACT
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(117);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[121])
					{
						// For column CS000MONTOCTA60
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(118);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[122])
					{
						// For column TCUOT60ACT
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(119);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[123])
					{
						// For column CSS000PRESMENA5000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(120);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[124])
					{
						// For column CS000COMISDESEMEN5000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(121);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[125])
					{
						// For column CS000PRES5000A15000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(122);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[126])
					{
						// For column C5000COMDES15000ACT
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(123);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[127])
					{
						// For column CS000PRESMAYA15000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(124);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[128])
					{
						// For column COMDES15000AC
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(125);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[129])
					{
						// For column CS000LINMINADQTC
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(126);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[130])
					{
						// For column CS000TIPODECREDITO
						String tempString;


						tempString=(String)inputRecord.get(127);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[131])
					{
						// For column CS000MIXMONPREST
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(128);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[132])
					{
						// For column CS000MIXLINASISTC
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(129);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[133])
					{
						// For column CS000MIXTIPOTC
						String tempString;


						tempString=(String)inputRecord.get(130);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[134])
					{
						// For column CS000PRESTCMENA5000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(131);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[135])
					{
						// For column CS000PRESTC500015000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(132);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[136])
					{
						// For column CS000PRESTCMAYA15000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(133);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[137])
					{
						// For column ATRIBCTACTEPASV
						String tempString;


						tempString=(String)inputRecord.get(134);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[138])
					{
						// For column ATRIBCTAAHPASV
						String tempString;


						tempString=(String)inputRecord.get(135);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[139])
					{
						// For column ATRIBCTAPLAZPASV
						String tempString;


						tempString=(String)inputRecord.get(136);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[140])
					{
						// For column ATRIBCTSPASV
						String tempString;


						tempString=(String)inputRecord.get(137);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[141])
					{
						// For column ATRIBFMUTUOPASV
						String tempString;


						tempString=(String)inputRecord.get(138);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[142])
					{
						// For column COBOFSERV
						String tempString;


						tempString=(String)inputRecord.get(139);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[143])
					{
						// For column SVIDOFSERV
						String tempString;


						tempString=(String)inputRecord.get(140);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[144])
					{
						// For column SONCOFSERV
						String tempString;


						tempString=(String)inputRecord.get(141);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[145])
					{
						// For column SVINCOFSERV
						String tempString;


						tempString=(String)inputRecord.get(142);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[146])
					{
						// For column PHOFSERV
						String tempString;


						tempString=(String)inputRecord.get(143);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[147])
					{
						// For column DEBOFSERV
						String tempString;


						tempString=(String)inputRecord.get(144);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[148])
					{
						// For column VIPOFSERV
						String tempString;


						tempString=(String)inputRecord.get(145);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[149])
					{
						// For column OFCNETCAN
						String tempString;


						tempString=(String)inputRecord.get(146);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[150])
					{
						// For column OFCEMPCAN
						String tempString;


						tempString=(String)inputRecord.get(147);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[151])
					{
						// For column OFLINCOCAN
						String tempString;


						tempString=(String)inputRecord.get(148);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[152])
					{
						// For column OFB24CAN
						String tempString;


						tempString=(String)inputRecord.get(149);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[153])
					{
						// For column OFPOSCAN
						String tempString;


						tempString=(String)inputRecord.get(150);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[154])
					{
						// For column PREFIJO
						String tempString;


						tempString=(String)inputRecord.get(151);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[106])
					{
						// For column MONTOHIPOTECARIO
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(152);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[117])
					{
						// For column CS000MONTOCTA36
						String tempString;


						tempString=(String)inputRecord.get(153);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[119])
					{
						// For column CS000MONTOCTA48
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(154);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_CLIENTE
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
						// For column CODIGO
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
						// For column COD_OFICINA
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
						// For column COD_GESTOR
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
						// For column NOMBRE
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
						// For column COD_TERRITORIO
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
						// For column SEGMENT1
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
						// For column EDAD
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
						// For column ESTCIVIL
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
						// For column CALLE
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
						// For column NRO
						String tempString;


						tempString=(String)inputRecord.get(10);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column PERFIL
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column DIREC1
						String tempString;


						tempString=(String)inputRecord.get(12);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column DISTRITO
						String tempString;


						tempString=(String)inputRecord.get(13);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column PROVINCIA
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
						// For column DEPARTAMENTO
						String tempString;


						tempString=(String)inputRecord.get(15);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column TIPO_PERSONA
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
						// For column CLASIFICACION
						String tempString;


						tempString=(String)inputRecord.get(17);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column TELEFONO
						String tempString;


						tempString=(String)inputRecord.get(18);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column VINCULACION
						String tempString;


						tempString=(String)inputRecord.get(19);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column PPER
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
						// For column PCOM
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
						// For column VNAC
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
						// For column CCTE
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
						// For column COLB
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
						// For column CNET
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
						// For column PAUT
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
						// For column DSCT
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
						// For column VARC
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
						// For column CEMP
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
						// For column SDEP
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
						// For column CEXT
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
						// For column PHIP
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
						// For column LEAS
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
						// For column VCLA
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
						// For column CVIP
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
						// For column SVID
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
						// For column LINCO
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
						// For column PMIV
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
						// For column CLOC
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
						// For column VREP
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
						// For column AHSD
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
						// For column SONC
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
						// For column TCO
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
						// For column B24
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
						// For column CPTE
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
						// For column PREF
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
						// For column VORO
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
						// For column AHOR
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
						// For column SPRO
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
						// For column POS
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
						// For column T_ACT2
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
						// For column PMAS
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
						// For column T_ACT3
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
						// For column LCTA
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
						// For column T_ACT4
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
						// For column VPLA
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
						// For column T_ACT5
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
						// For column PLZO
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
						// For column T_ACT6
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
						// For column PSERV
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
						// For column TPR
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
						// For column PROM
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
						// For column T_ACT_CT2
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
						// For column VEMP
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
						// For column T_ACT_CT3
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
						// For column PH
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
						// For column T_ACT_CT4
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
						// For column FCEX
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
						// For column T_ACT_CT5
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
						// For column VCTR
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
						// For column T_ACT_CT6
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
						// For column FMUT
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
						// For column MARGENO
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
						// For column NRO_DOCUMENTO
						String tempString;


						tempString=(String)inputRecord.get(74);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[75])
					{
						// For column BCORIE
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
						// For column EMPH
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
						// For column BCORID
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
						// For column AVAL
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
						// For column BCORII
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
						// For column MCLA
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
						// For column BCOPAS
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
						// For column CTS
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
						// For column BCOVOL
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
						// For column TDEB
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
						// For column PORCRIE
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
						// For column MORO
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
						// For column PORCRID
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
						// For column CTSD
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
						// For column PORCRII
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
						// For column TVIP
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
						// For column SBSRIE
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
						// For column SBSRID
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
						// For column SBSRII
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
						// For column SBSJUD
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
						// For column COD_EMPRESA
						String tempString;


						tempString=(String)inputRecord.get(95);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[96])
					{
						// For column DES_EMPRESA
						String tempString;


						tempString=(String)inputRecord.get(96);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[97])
					{
						// For column INTERVPAS
						String tempString;


						tempString=(String)inputRecord.get(97);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[98])
					{
						// For column MOFACTV
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
						// For column CS000LINEAMAXTC
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
						// For column MOFPASV
						String tempString;


						tempString=(String)inputRecord.get(100);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[101])
					{
						// For column MOFSERV
						String tempString;


						tempString=(String)inputRecord.get(101);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[102])
					{
						// For column MOFCANAL
						String tempString;


						tempString=(String)inputRecord.get(102);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[103])
					{
						// For column MPHPASV
						String tempString;


						tempString=(String)inputRecord.get(103);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[104])
					{
						// For column CS000MTOPRESTAMO
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
						// For column MONTOVEHICULAR
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(105);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[107])
					{
						// For column CTACTEOFERTA
						String tempString;


						tempString=(String)inputRecord.get(106);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[108])
					{
						// For column CTAAHOFERTA
						String tempString;


						tempString=(String)inputRecord.get(107);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[109])
					{
						// For column CTAPOFERTA
						String tempString;


						tempString=(String)inputRecord.get(108);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[110])
					{
						// For column FMUTUOOFERT
						String tempString;


						tempString=(String)inputRecord.get(109);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[111])
					{
						// For column CTACTSOFERT
						String tempString;


						tempString=(String)inputRecord.get(110);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[112])
					{
						// For column TCONSACTV
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(111);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[113])
					{
						// For column MONTOSUBROGADOS
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(112);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[114])
					{
						// For column TSUBACTV
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(113);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[115])
					{
						// For column THIPOTACTV
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(114);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[116])
					{
						// For column TVEHICACTV
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(115);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[118])
					{
						// For column TCUOT36ACT
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(116);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[120])
					{
						// For column TCUOT48ACT
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(117);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[121])
					{
						// For column CS000MONTOCTA60
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(118);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[122])
					{
						// For column TCUOT60ACT
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(119);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[123])
					{
						// For column CSS000PRESMENA5000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(120);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[124])
					{
						// For column CS000COMISDESEMEN5000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(121);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[125])
					{
						// For column CS000PRES5000A15000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(122);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[126])
					{
						// For column C5000COMDES15000ACT
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(123);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[127])
					{
						// For column CS000PRESMAYA15000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(124);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[128])
					{
						// For column COMDES15000AC
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(125);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[129])
					{
						// For column CS000LINMINADQTC
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(126);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[130])
					{
						// For column CS000TIPODECREDITO
						String tempString;


						tempString=(String)inputRecord.get(127);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[131])
					{
						// For column CS000MIXMONPREST
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(128);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[132])
					{
						// For column CS000MIXLINASISTC
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(129);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[133])
					{
						// For column CS000MIXTIPOTC
						String tempString;


						tempString=(String)inputRecord.get(130);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[134])
					{
						// For column CS000PRESTCMENA5000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(131);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[135])
					{
						// For column CS000PRESTC500015000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(132);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[136])
					{
						// For column CS000PRESTCMAYA15000
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(133);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[137])
					{
						// For column ATRIBCTACTEPASV
						String tempString;


						tempString=(String)inputRecord.get(134);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[138])
					{
						// For column ATRIBCTAAHPASV
						String tempString;


						tempString=(String)inputRecord.get(135);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[139])
					{
						// For column ATRIBCTAPLAZPASV
						String tempString;


						tempString=(String)inputRecord.get(136);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[140])
					{
						// For column ATRIBCTSPASV
						String tempString;


						tempString=(String)inputRecord.get(137);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[141])
					{
						// For column ATRIBFMUTUOPASV
						String tempString;


						tempString=(String)inputRecord.get(138);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[142])
					{
						// For column COBOFSERV
						String tempString;


						tempString=(String)inputRecord.get(139);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[143])
					{
						// For column SVIDOFSERV
						String tempString;


						tempString=(String)inputRecord.get(140);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[144])
					{
						// For column SONCOFSERV
						String tempString;


						tempString=(String)inputRecord.get(141);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[145])
					{
						// For column SVINCOFSERV
						String tempString;


						tempString=(String)inputRecord.get(142);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[146])
					{
						// For column PHOFSERV
						String tempString;


						tempString=(String)inputRecord.get(143);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[147])
					{
						// For column DEBOFSERV
						String tempString;


						tempString=(String)inputRecord.get(144);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[148])
					{
						// For column VIPOFSERV
						String tempString;


						tempString=(String)inputRecord.get(145);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[149])
					{
						// For column OFCNETCAN
						String tempString;


						tempString=(String)inputRecord.get(146);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[150])
					{
						// For column OFCEMPCAN
						String tempString;


						tempString=(String)inputRecord.get(147);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[151])
					{
						// For column OFLINCOCAN
						String tempString;


						tempString=(String)inputRecord.get(148);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[152])
					{
						// For column OFB24CAN
						String tempString;


						tempString=(String)inputRecord.get(149);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[153])
					{
						// For column OFPOSCAN
						String tempString;


						tempString=(String)inputRecord.get(150);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[154])
					{
						// For column PREFIJO
						String tempString;


						tempString=(String)inputRecord.get(151);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[106])
					{
						// For column MONTOHIPOTECARIO
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(152);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					if (changedFieldIndexes[117])
					{
						// For column CS000MONTOCTA36
						String tempString;


						tempString=(String)inputRecord.get(153);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[119])
					{
						// For column CS000MONTOCTA48
						java.math.BigDecimal tempBigDecimal;


						tempBigDecimal=(java.math.BigDecimal)inputRecord.get(154);
						if(tempBigDecimal != null){
							pstmt.setBigDecimal(stmtIndex,tempBigDecimal);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.NUMERIC);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_CLIENTE
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
