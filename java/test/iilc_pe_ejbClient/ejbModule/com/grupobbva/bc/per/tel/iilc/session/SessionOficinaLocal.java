package com.grupobbva.bc.per.tel.iilc.session;
import javax.ejb.FinderException;
import java.util.Vector;
import com.grupobbva.bc.per.tel.iilc.serializable.Oficina;
/**
 * Local interface for Enterprise Bean: SessionOficina
 */
public interface SessionOficinaLocal extends javax.ejb.EJBLocalObject {
	public Vector findAllOficinaxTe(String cod_area, String cod_territorio)
		throws FinderException;
	public Oficina datosOficina(String codigo);
	/**
	 * @param cod_territorio
	 * @return
	 * @throws FinderException
	 */
	public Vector<Oficina> findAllOficinaxTerr(String cod_territorio)
			throws FinderException;
}
