package entities.websphere_deploy.ORACLE_V10_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * Tiido_permiso_perfilBeanFunctionSet_edfb184d
 */
public class Tiido_permiso_perfilBeanFunctionSet_edfb184d extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO IIDO.TIIDO_PERMISO_PERFIL (COD_PERFIL, TIP_ACCESO, VALOR_RCP, USUARIO, USU_REGI, FEC_REGI, USU_ACTU, FEC_ACTU) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column TIP_ACCESO
			// For column TIP_ACCESO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column USUARIO
			// For column USUARIO
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(5);
				if(tempTimestamp != null)
					pstmt.setTimestamp(6,tempTimestamp);
				else
					pstmt.setNull(6,java.sql.Types.TIMESTAMP);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setTimestamp(8,new java.sql.Timestamp(tempDate.getTime()));
				else
					pstmt.setNull(8,java.sql.Types.TIMESTAMP);
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
	private static String RemoveQuery_0 = "DELETE FROM IIDO.TIIDO_PERMISO_PERFIL  WHERE COD_PERFIL = ? AND TIP_ACCESO = ? AND VALOR_RCP = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column TIP_ACCESO
			// For column TIP_ACCESO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
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
	private static String StoreQuery_0 = "UPDATE IIDO.TIIDO_PERMISO_PERFIL  SET USUARIO = ?, USU_REGI = ?, FEC_REGI = ?, USU_ACTU = ?, FEC_ACTU = ? WHERE COD_PERFIL = ? AND TIP_ACCESO = ? AND VALOR_RCP = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column TIP_ACCESO
			// For column TIP_ACCESO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column USUARIO
			// For column USUARIO
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(5);
				if(tempTimestamp != null)
					pstmt.setTimestamp(3,tempTimestamp);
				else
					pstmt.setNull(3,java.sql.Types.TIMESTAMP);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setTimestamp(5,new java.sql.Timestamp(tempDate.getTime()));
				else
					pstmt.setNull(5,java.sql.Types.TIMESTAMP);
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
	private static String StoreOCCQuery_0 = "UPDATE IIDO.TIIDO_PERMISO_PERFIL  SET USUARIO = ?, USU_REGI = ?, FEC_REGI = ?, USU_ACTU = ?, FEC_ACTU = ? WHERE COD_PERFIL = ? AND TIP_ACCESO = ? AND VALOR_RCP = ? AND USUARIO = ? AND USU_REGI = ? AND FEC_REGI = ? AND USU_ACTU = ? AND FEC_ACTU = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column TIP_ACCESO
			// For column TIP_ACCESO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column USUARIO
			// For column USUARIO
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column USU_REGI
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			// For column FEC_REGI
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(5);
				if(tempTimestamp != null)
					pstmt.setTimestamp(3,tempTimestamp);
				else
					pstmt.setNull(3,java.sql.Types.TIMESTAMP);
			}
			// For column USU_ACTU
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setTimestamp(5,new java.sql.Timestamp(tempDate.getTime()));
				else
					pstmt.setNull(5,java.sql.Types.TIMESTAMP);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column USUARIO
			{
				String tempString;


				tempString=(String)oldRecord.get(3);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.VARCHAR);
			}
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)oldRecord.get(4);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)oldRecord.get(5);
				if(tempTimestamp != null)
					pstmt.setTimestamp(11,tempTimestamp);
				else
					pstmt.setNull(11,java.sql.Types.TIMESTAMP);
			}
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)oldRecord.get(6);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)oldRecord.get(7);
				if(tempDate != null)
					pstmt.setTimestamp(13,new java.sql.Timestamp(tempDate.getTime()));
				else
					pstmt.setNull(13,java.sql.Types.TIMESTAMP);
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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.COD_PERFIL, T1.TIP_ACCESO, T1.VALOR_RCP, T1.USUARIO, T1.USU_REGI, T1.FEC_REGI, T1.USU_ACTU, T1.FEC_ACTU FROM IIDO.TIIDO_PERMISO_PERFIL  T1 WHERE T1.COD_PERFIL = ? AND T1.TIP_ACCESO = ? AND T1.VALOR_RCP = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column TIP_ACCESO
			// For column TIP_ACCESO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.COD_PERFIL, T1.TIP_ACCESO, T1.VALOR_RCP, T1.USUARIO, T1.USU_REGI, T1.FEC_REGI, T1.USU_ACTU, T1.FEC_ACTU FROM IIDO.TIIDO_PERMISO_PERFIL  T1 WHERE T1.COD_PERFIL = ? AND T1.TIP_ACCESO = ? AND T1.VALOR_RCP = ? FOR UPDATE ";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column TIP_ACCESO
			// For column TIP_ACCESO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
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
	private static String findPermisoPerfilxTipAccxValorRCPQuery_0 = " select  q1.\"COD_PERFIL\",  q1.\"TIP_ACCESO\",  q1.\"VALOR_RCP\",  q1.\"USUARIO\",  q1.\"USU_REGI\",  q1.\"FEC_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_ACTU\" from IIDO.TIIDO_PERMISO_PERFIL q1 where  ( q1.\"TIP_ACCESO\" = ?)  and  ( q1.\"VALOR_RCP\" = ?)  order by  q1.\"COD_PERFIL\" asc";
	/**
	 * FindPermisoPerfilxTipAccxValorRCP
	 */
	public javax.resource.cci.Record FindPermisoPerfilxTipAccxValorRCP(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_permiso_perfil o where o.tip_acceso = ?1 and o.valor_rcp = ?2 order by o.cod_perfil asc */
			pstmt = prepareStatement(connection, findPermisoPerfilxTipAccxValorRCPQuery_0);

			// For ?1 (tipo_acceso)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (valor_rcp)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findPermisoPerfilxTipAccxValorRCPQuery_0);

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
	private static String findPermisoPerfilxTipAccxValorRCPForUpdateQuery_0 = " select  q1.\"COD_PERFIL\",  q1.\"TIP_ACCESO\",  q1.\"VALOR_RCP\",  q1.\"USUARIO\",  q1.\"USU_REGI\",  q1.\"FEC_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_ACTU\" from IIDO.TIIDO_PERMISO_PERFIL q1 where  ( q1.\"TIP_ACCESO\" = ?)  and  ( q1.\"VALOR_RCP\" = ?)  order by  q1.\"COD_PERFIL\" asc for update ";
	/**
	 * FindPermisoPerfilxTipAccxValorRCP444Update
	 */
	public javax.resource.cci.Record FindPermisoPerfilxTipAccxValorRCP444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_permiso_perfil o where o.tip_acceso = ?1 and o.valor_rcp = ?2 order by o.cod_perfil asc */
			pstmt = prepareStatement(connection, findPermisoPerfilxTipAccxValorRCPForUpdateQuery_0);

			// For ?1 (tipo_acceso)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (valor_rcp)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findPermisoPerfilxTipAccxValorRCPForUpdateQuery_0);

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
	private static String findAllPermisoPerfilQuery_0 = " select  q1.\"COD_PERFIL\",  q1.\"TIP_ACCESO\",  q1.\"VALOR_RCP\",  q1.\"USUARIO\",  q1.\"USU_REGI\",  q1.\"FEC_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_ACTU\" from IIDO.TIIDO_PERMISO_PERFIL q1 order by  q1.\"COD_PERFIL\" asc,  q1.\"TIP_ACCESO\" asc,  q1.\"VALOR_RCP\" asc";
	/**
	 * FindAllPermisoPerfil
	 */
	public javax.resource.cci.Record FindAllPermisoPerfil(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_permiso_perfil o order by o.cod_perfil asc, o.tip_acceso asc, o.valor_rcp asc */
			pstmt = prepareStatement(connection, findAllPermisoPerfilQuery_0);

			result = executeQuery(connection, pstmt, findAllPermisoPerfilQuery_0);

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
	private static String findAllPermisoPerfilForUpdateQuery_0 = " select  q1.\"COD_PERFIL\",  q1.\"TIP_ACCESO\",  q1.\"VALOR_RCP\",  q1.\"USUARIO\",  q1.\"USU_REGI\",  q1.\"FEC_REGI\",  q1.\"USU_ACTU\",  q1.\"FEC_ACTU\" from IIDO.TIIDO_PERMISO_PERFIL q1 order by  q1.\"COD_PERFIL\" asc,  q1.\"TIP_ACCESO\" asc,  q1.\"VALOR_RCP\" asc for update ";
	/**
	 * FindAllPermisoPerfil444Update
	 */
	public javax.resource.cci.Record FindAllPermisoPerfil444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Tiido_permiso_perfil o order by o.cod_perfil asc, o.tip_acceso asc, o.valor_rcp asc */
			pstmt = prepareStatement(connection, findAllPermisoPerfilForUpdateQuery_0);

			result = executeQuery(connection, pstmt, findAllPermisoPerfilForUpdateQuery_0);

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
	 * Tiido_permiso_perfilBeanFunctionSet_edfb184d
	 */
	public Tiido_permiso_perfilBeanFunctionSet_edfb184d() {
		functionHash=new java.util.HashMap(14);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByPrimaryKey",new Integer(4));
		functionHash.put("FindByPrimaryKey444Update",new Integer(5));
		functionHash.put("FindPermisoPerfilxTipAccxValorRCP",new Integer(6));
		functionHash.put("FindPermisoPerfilxTipAccxValorRCP444Update",new Integer(7));
		functionHash.put("FindAllPermisoPerfil",new Integer(8));
		functionHash.put("FindAllPermisoPerfil444Update",new Integer(9));
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
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindPermisoPerfilxTipAccxValorRCP(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindPermisoPerfilxTipAccxValorRCP444Update(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindAllPermisoPerfil(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindAllPermisoPerfil444Update(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM IIDO.TIIDO_PERMISO_PERFIL  T1 WHERE T1.COD_PERFIL = ? AND T1.TIP_ACCESO = ? AND T1.VALOR_RCP = ? AND T1.USUARIO = ? AND T1.USU_REGI = ? AND T1.FEC_REGI = ? AND T1.USU_ACTU = ? AND T1.FEC_ACTU = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column TIP_ACCESO
			// For column TIP_ACCESO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column USUARIO
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(5);
				if(tempTimestamp != null)
					pstmt.setTimestamp(6,tempTimestamp);
				else
					pstmt.setNull(6,java.sql.Types.TIMESTAMP);
			}
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setTimestamp(8,new java.sql.Timestamp(tempDate.getTime()));
				else
					pstmt.setNull(8,java.sql.Types.TIMESTAMP);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM IIDO.TIIDO_PERMISO_PERFIL  T1 WHERE T1.COD_PERFIL = ? AND T1.TIP_ACCESO = ? AND T1.VALOR_RCP = ? AND T1.USUARIO = ? AND T1.USU_REGI = ? AND T1.FEC_REGI = ? AND T1.USU_ACTU = ? AND T1.FEC_ACTU = ? FOR UPDATE ";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column COD_PERFIL
			// For column COD_PERFIL
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column TIP_ACCESO
			// For column TIP_ACCESO
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column VALOR_RCP
			// For column VALOR_RCP
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column USUARIO
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column USU_REGI
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column FEC_REGI
			{
				java.sql.Timestamp tempTimestamp;


				tempTimestamp=(java.sql.Timestamp)inputRecord.get(5);
				if(tempTimestamp != null)
					pstmt.setTimestamp(6,tempTimestamp);
				else
					pstmt.setNull(6,java.sql.Types.TIMESTAMP);
			}
			// For column USU_ACTU
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column FEC_ACTU
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setTimestamp(8,new java.sql.Timestamp(tempDate.getTime()));
				else
					pstmt.setNull(8,java.sql.Types.TIMESTAMP);
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
		updateTemplateList = Tiido_permiso_perfilBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column USUARIO
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
						// For column USU_REGI
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
						// For column FEC_REGI
						java.sql.Timestamp tempTimestamp;


						tempTimestamp=(java.sql.Timestamp)inputRecord.get(5);
						if(tempTimestamp != null){
							pstmt.setTimestamp(stmtIndex,tempTimestamp);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIMESTAMP);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column USU_ACTU
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
						// For column FEC_ACTU
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(7);
						if(tempDate != null){
							pstmt.setTimestamp(stmtIndex,new java.sql.Timestamp(tempDate.getTime()));
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIMESTAMP);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_PERFIL
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column TIP_ACCESO
						String tempString;


						tempString=(String)inputRecord.get(1);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column VALOR_RCP
						String tempString;


						tempString=(String)inputRecord.get(2);
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
				oldValues[0] = oldRecord.get(3);
				oldValues[1] = oldRecord.get(4);
				oldValues[2] = oldRecord.get(5);
				oldValues[3] = oldRecord.get(6);
				oldValues[4] = oldRecord.get(7);
				String updateQuery = aTemplate.nativeOptimisticQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[3])
					{
						// For column USUARIO
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
						// For column USU_REGI
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
						// For column FEC_REGI
						java.sql.Timestamp tempTimestamp;


						tempTimestamp=(java.sql.Timestamp)inputRecord.get(5);
						if(tempTimestamp != null){
							pstmt.setTimestamp(stmtIndex,tempTimestamp);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIMESTAMP);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column USU_ACTU
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
						// For column FEC_ACTU
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(7);
						if(tempDate != null){
							pstmt.setTimestamp(stmtIndex,new java.sql.Timestamp(tempDate.getTime()));
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIMESTAMP);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column COD_PERFIL
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column TIP_ACCESO
						String tempString;


						tempString=(String)inputRecord.get(1);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					{
						// For column VALOR_RCP
						String tempString;


						tempString=(String)inputRecord.get(2);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					// optimistic predicate columns
					{
						// For column USUARIO
						String tempString;


						tempString=(String)oldValues[0];
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
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
						// For column FEC_REGI
						java.sql.Timestamp tempTimestamp;


						tempTimestamp=(java.sql.Timestamp)oldValues[2];
						if(tempTimestamp != null){
							pstmt.setTimestamp(stmtIndex,tempTimestamp);
							stmtIndex++;
						}

					}
					{
						// For column USU_ACTU
						String tempString;


						tempString=(String)oldValues[3];
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
							stmtIndex++;
						}

					}
					{
						// For column FEC_ACTU
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)oldValues[4];
						if(tempDate != null){
							pstmt.setTimestamp(stmtIndex,new java.sql.Timestamp(tempDate.getTime()));
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
