package com.grupobbva.bc.per.tel.iilc.session;
import java.util.Vector;
import com.grupobbva.bc.per.tel.iilc.serializable.Empresa;
/**
 * Local interface for Enterprise Bean: SessionEmpresa
 */
public interface SessionEmpresaLocal extends javax.ejb.EJBLocalObject {
    /**
     * 
     * @author P060049 Edgar Zavaleta Sierralta
     *
     */
    public Vector findAllEmpresa();
	public Empresa datosEmpresa(String codigo);
}
