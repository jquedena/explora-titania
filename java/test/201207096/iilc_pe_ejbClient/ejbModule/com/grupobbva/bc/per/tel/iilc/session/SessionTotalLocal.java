package com.grupobbva.bc.per.tel.iilc.session;
import javax.ejb.FinderException;
import com.grupobbva.bc.per.tel.iilc.serializable.Total;
/**
 * Local interface for Enterprise Bean: SessionTotal
 */
public interface SessionTotalLocal extends javax.ejb.EJBLocalObject {
	public Total findTotal(
		String ind_registro,
		String cod_territorio,
		String cod_oficina,
		String cod_gestor) throws FinderException;
}
