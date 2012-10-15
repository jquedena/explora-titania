package com.grupobbva.bc.per.tel.iilc.session;
import javax.ejb.FinderException;
import java.util.Vector;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.stefanini.pe.framework.collections.DataTable;
/**
 * Local interface for Enterprise Bean: SessionMultitabla
 */
public interface SessionMultitablaLocal extends javax.ejb.EJBLocalObject {
	public Vector findAllRecord(String cod_mult) throws FinderException;
	public Multitabla findRecord(String codigo) throws FinderException;
	public Vector findMultitablaxValor2(String valor2) throws FinderException;
	public Vector findAllMultitabla() throws FinderException;
	public Multitabla findMultitabla(String cod_mult, String cod_ele);
	public boolean deleteMultitabla(String cod_mult, String cod_ele);
	public boolean updateMultitabla(Multitabla multitabla);
	//FIN - OSCAR CORTEZ - ETIQUETAS Y SEGMENTOS
	//	OSCAR CORTEZ - ETIQUETAS
	public Vector findEtiquetas();
	//	OSCAR CORTEZ - ETIQUETAS Y SEGMENTOS
	public DataTable findEtiquetasSegmentos(DataTable tablaBase);
	//FIN - OSCAR CORTEZ - ETIQUETAS Y SEGMENTOS

	public int findCantidadSegmentos();
	//	OSCAR CORTEZ - ETIQUETAS CON SEGMENTOS X CODMULT Y CODELEM
	public Vector findEtiSeg(String codMult, String codElem);
	//FIN - OSCAR CORTEZ - ETIQUETAS

	//	OSCAR CORTEZ - NIVEL DE VINCULACION CON SEGMENTOS X CODMULT Y CODELEM
	public Vector findNV(String codMult, String codElem);
	//FIN - OSCAR CORTEZ - NIVEL DE VINCULACION CON SEGMENTOS X CODMULT Y CODELEM

	//	OSCAR CORTEZ - NIVEL DE VINCULACION CON SEGMENTOS X CODMULT Y CODELEM
	public Vector findFamilias();
	public String[] listaEtiquetasPorCodigo(String codigo);
	public Vector listaDetalleFiltroSimple(String tipo, String[] codigos);
	/**
	 * @param tipo
	 * @param tipo2
	 * @param codigos
	 * @return
	 */
	public Vector<Multitabla> listaDetalleFiltroComplejo(String tipo,
			String tipo2, String[] codigos);
}
