package com.grupobbva.bc.per.tel.iilc.session;
import javax.ejb.FinderException;
import java.util.Vector;
import com.grupobbva.bc.per.tel.iilc.serializable.Territorio;
/**
 * Local interface for Enterprise Bean: SessionTerritorio
 */
public interface SessionTerritorioLocal extends javax.ejb.EJBLocalObject {
	public Territorio datosTerritorio(String codigo);

	/**
	 * @param cod_area
	 * @return
	 * @throws FinderException
	 */
	public Vector<Territorio> findAllTerritorio(String cod_area)
			throws FinderException;
}
