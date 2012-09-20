package indra.ldap2db.conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.grupobbva.bc.per.tele.ldap.serializable.IILDPeCargo;
import com.grupobbva.bc.per.tele.ldap.serializable.IILDPeEmpresa;
import com.grupobbva.bc.per.tele.ldap.serializable.IILDPeOficina;
import com.grupobbva.bc.per.tele.ldap.serializable.IILDPePais;
import com.grupobbva.bc.per.tele.ldap.serializable.IILDPeUnidadOrganizativa;
import com.grupobbva.bc.per.tele.ldap.serializable.IILDPeUsuario;

public class zConexion {
	private static final String DATASOURCE_CONTEXT = "java:comp/env/jdbc/ORA_Biiwx001";

	private List<IILDPeUsuario> resultadosConsulta(String sql, int limite) {
		List<IILDPeUsuario> res = null;
		IILDPeUsuario ldapperu = null;

		Connection con = null;
		ResultSet rst = null;
		int i = 0;
		try {
			Context initialContext = new InitialContext();
			DataSource datasource = (DataSource) initialContext.lookup(zConexion.DATASOURCE_CONTEXT);
			con = datasource.getConnection();
			Statement s = con.createStatement();
			try {
				rst = s.executeQuery(sql);
				while (rst.next()) {
					ldapperu = new IILDPeUsuario();
					if (res == null)
						res = new ArrayList<IILDPeUsuario>();
					ldapperu = new IILDPeUsuario();
					ldapperu.setRegistroU(rst.getString("REGISTROU"));
					ldapperu.setRegistroP(rst.getString("REGISTROP"));
					ldapperu.setPais(new IILDPePais(rst.getString("CODPAIS"), rst.getString("DESPAIS")));
					ldapperu.setEmpresa(new IILDPeEmpresa(rst.getString("CODEMP"), rst.getString("DESEMP")));
					ldapperu.setMatricula(rst.getString("NUMMAT"));
					ldapperu.setUID(rst.getString("CODUSU"));
					ldapperu.setNombre(rst.getString("NOMBRE"));
					ldapperu.setApellido1(rst.getString("APEPAT"));
					ldapperu.setApellido2(rst.getString("APEMAT"));
					ldapperu.setSexo(rst.getString("SEXO"));
					ldapperu.setFechaNacimiento(rst.getString("FECNAC"));
					ldapperu.setTipDoc(rst.getString("TIPDOC"));
					ldapperu.setNumDoc(rst.getString("NUMDOC"));
					ldapperu.setTelefono(rst.getString("TELEFONO1"));
					ldapperu.setMovil(rst.getString("TELEFONO2"));
					ldapperu.setEmail(rst.getString("CORELEC"));
					ldapperu.setCargo(new IILDPeCargo(rst.getString("CODCARGO"), rst.getString("NOMCARGO")));
					ldapperu.setCodEmpAnt(rst.getString("CODEMPANT"));
					ldapperu.setBancoOficina(new IILDPeOficina(rst.getString("CODOFI"), rst.getString("DESOFI"), rst.getString("TIPOFI"), rst.getString("TELOFI1"), rst.getString("TELOFI2")));
					ldapperu.setGesPer(rst.getString("GESPER"));
					ldapperu.setFecInig(rst.getString("FECING"));
					ldapperu.setNHijosEscolar(rst.getInt("NROHIJOS"));
					ldapperu.setCodGer(rst.getString("CODGER"));
					ldapperu.setNomGer(rst.getString("NOMGER"));
					ldapperu.setCarBlan(rst.getString("CARBLAN"));
					ldapperu.setProInf(rst.getString("PROINF"));
					ldapperu.setUIDJefe(rst.getString("CODUSUJEFE"));
					ldapperu.setUnidadOrganizativa(new IILDPeUnidadOrganizativa(rst.getString("CODUNIORG"), rst.getString("DESUNIORG")));
					ldapperu.setNivel1(new IILDPeUnidadOrganizativa(rst.getString("CODNIVEL1"), rst.getString("DESNIVEL1")));
					ldapperu.setNivel2(new IILDPeUnidadOrganizativa(rst.getString("CODNIVEL2"), rst.getString("DESNIVEL2")));
					ldapperu.setNivel3(new IILDPeUnidadOrganizativa(rst.getString("CODNIVEL3"), rst.getString("DESNIVEL3")));
					ldapperu.setNivel4(new IILDPeUnidadOrganizativa(rst.getString("CODNIVEL4"), rst.getString("DESNIVEL4")));
					ldapperu.setNivel5(new IILDPeUnidadOrganizativa(rst.getString("CODNIVEL5"), rst.getString("DESNIVEL5")));
					ldapperu.setNivel6(new IILDPeUnidadOrganizativa(rst.getString("CODNIVEL6"), rst.getString("DESNIVEL6")));
					ldapperu.setNivel7(new IILDPeUnidadOrganizativa(rst.getString("CODNIVEL7"), rst.getString("DESNIVEL7")));
					ldapperu.setNivel8(new IILDPeUnidadOrganizativa(rst.getString("CODNIVEL8"), rst.getString("DESNIVEL8")));
					ldapperu.setNivel9(new IILDPeUnidadOrganizativa(rst.getString("CODNIVEL9"), rst.getString("DESNIVEL9")));
					ldapperu.setNivel10(new IILDPeUnidadOrganizativa(rst.getString("CODNIVEL10"), rst.getString("DESNIVEL10")));
					ldapperu.setUsoFut1(rst.getString("USOFUT1"));
					ldapperu.setUsoFut2(rst.getString("USOFUT2"));
					ldapperu.setUsoFut3(rst.getString("USOFUT3"));
					ldapperu.setUsoFut4(rst.getString("USOFUT4"));
					ldapperu.setUsoFut5(rst.getString("USOFUT5"));
					ldapperu.setUsoFut6(rst.getString("USOFUT6"));
					ldapperu.setUsoFut7(rst.getString("USOFUT7"));
					ldapperu.setUsoFut8(rst.getString("USOFUT8"));
					ldapperu.setUsoFut9(rst.getString("USOFUT9"));
					ldapperu.setUsoFut10(rst.getString("USOFUT10"));
					res.add(ldapperu);

					if (limite > 0) {
						i++;
						if (i >= limite)
							break;
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			s.close();
			con.close();
			initialContext.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	public IILDPeUsuario recuperarUsuario(String identificador) {
		IILDPeUsuario res = null;

		String sql = "select * from Ldapperu2 where codusu = '" + identificador + "' ORDER BY codusu DESC";
		List<IILDPeUsuario> consulta = resultadosConsulta(sql, 1);
		if (consulta != null) {
			res = (IILDPeUsuario) consulta.get(0);
		}
		return res;
	}
}
