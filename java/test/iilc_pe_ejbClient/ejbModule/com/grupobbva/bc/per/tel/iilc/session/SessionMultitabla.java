package com.grupobbva.bc.per.tel.iilc.session;
import javax.ejb.FinderException;
import java.util.Vector;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.stefanini.pe.framework.collections.DataTable;
/**
 * Remote interface for Enterprise Bean: SessionMultitabla
 */
public interface SessionMultitabla extends javax.ejb.EJBObject {
    public Vector findAllRecord(String cod_mult)
        throws FinderException,
        java.rmi.RemoteException;
    public Multitabla findRecord(String codigo)
        throws FinderException,
        java.rmi.RemoteException;
    public Vector findMultitablaxValor2(String valor2)
        throws FinderException,
        java.rmi.RemoteException;
	public Vector findAllMultitabla()
		throws FinderException,
		java.rmi.RemoteException;
	public Multitabla findMultitabla(String cod_mult, String cod_ele)
		throws java.rmi.RemoteException;
	public boolean deleteMultitabla(String cod_mult, String cod_ele)
		throws java.rmi.RemoteException;
	public boolean updateMultitabla(Multitabla multitabla)
		throws java.rmi.RemoteException;
	//FIN - OSCAR CORTEZ - ETIQUETAS Y SEGMENTOS
	//	OSCAR CORTEZ - ETIQUETAS
	public Vector findEtiquetas() throws java.rmi.RemoteException;
	//	OSCAR CORTEZ - ETIQUETAS Y SEGMENTOS
	public DataTable findEtiquetasSegmentos(DataTable tablaBase)
		throws java.rmi.RemoteException;
	//FIN - OSCAR CORTEZ - ETIQUETAS Y SEGMENTOS

	public int findCantidadSegmentos() throws java.rmi.RemoteException;
	//	OSCAR CORTEZ - ETIQUETAS CON SEGMENTOS X CODMULT Y CODELEM
	public Vector findEtiSeg(String codMult, String codElem)
		throws java.rmi.RemoteException;
	//FIN - OSCAR CORTEZ - ETIQUETAS

	//	OSCAR CORTEZ - NIVEL DE VINCULACION CON SEGMENTOS X CODMULT Y CODELEM
	public Vector findNV(String codMult, String codElem)
		throws java.rmi.RemoteException;
	//FIN - OSCAR CORTEZ - NIVEL DE VINCULACION CON SEGMENTOS X CODMULT Y CODELEM

	//	OSCAR CORTEZ - NIVEL DE VINCULACION CON SEGMENTOS X CODMULT Y CODELEM
	public Vector findFamilias() throws java.rmi.RemoteException;
	public String[] listaEtiquetasPorCodigo(String codigo)
		throws java.rmi.RemoteException;
	public Vector listaDetalleFiltroSimple(String tipo, String[] codigos)
		throws java.rmi.RemoteException;
	/**
	 * @param tipo
	 * @param tipo2
	 * @param codigos
	 * @return
	 * @throws java.rmi.RemoteException
	 */
	public Vector<Multitabla> listaDetalleFiltroComplejo(String tipo,
			String tipo2, String[] codigos) throws java.rmi.RemoteException;
}
