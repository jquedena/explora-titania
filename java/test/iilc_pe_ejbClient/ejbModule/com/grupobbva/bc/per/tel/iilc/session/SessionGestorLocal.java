package com.grupobbva.bc.per.tel.iilc.session;
import javax.ejb.FinderException;
import java.util.Vector;
import com.grupobbva.bc.per.tel.iilc.serializable.Gestor;
/**
 * Local interface for Enterprise Bean: SessionGestor
 */
public interface SessionGestorLocal extends javax.ejb.EJBLocalObject {
	public boolean deleteAllGestor(String cod_area);
	//	OSCAR CORTEZ - Gestor x Registro
	public Vector findGestorxRegistro(
		String registro,
		String codTerritorio,
		String codOficina);
	public Gestor datosGestor(String codigo);
	/**
	 * @param cod_usuario
	 * @return
	 * @throws FinderException
	 */
	public Vector<String> findATOG(String cod_usuario) throws FinderException;
	/**
	 * @param cod_oficina
	 * @return
	 */
	public String findGestorMasaOficina(String cod_oficina);
	/**
	 * @param cod_area
	 * @param cod_territorio
	 * @param cod_oficina
	 * @return
	 * @throws FinderException
	 */
	public Vector<Gestor> findAllGestorxOfxTe(String cod_area,
			String cod_territorio, String cod_oficina) throws FinderException;
}
