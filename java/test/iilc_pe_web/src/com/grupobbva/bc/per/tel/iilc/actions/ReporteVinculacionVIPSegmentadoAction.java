package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.dao.ReporteVinculacionDAO;
import com.grupobbva.bc.per.tel.iilc.serializable.AdministracionCargaVinculacion;

public class ReporteVinculacionVIPSegmentadoAction extends Action {

	static Logger logger = Logger.getLogger(ReporteVinculacionVIPSegmentadoAction.class
			.getName());

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try{
			List reporteSegmentado=new ArrayList();
			ReporteVinculacionDAO dao=new ReporteVinculacionDAO(); 
			String segmento=request.getParameter("segmento");
			String cargo=request.getSession().getAttribute("codperfil").toString();
			String filtro="";
			if(cargo.equals("LC03")){
				filtro="'"+request.getSession().getAttribute("cod_oficina").toString()+"'";
			}else if(cargo.equals("LC02")){
				filtro="'"+request.getSession().getAttribute("cod_territorio").toString()+"'";
			}else if(cargo.equals("LC04")){
				filtro="'"+request.getSession().getAttribute("gestor").toString()+"'";
			} 
		
			AdministracionCargaVinculacion objBean=new AdministracionCargaVinculacion();
			objBean.setTipo(Integer.parseInt(Constantes.CODIGO_VIP));//Pendiente
			ConexionDAO conDao=new ConexionDAO();
			
			
			int estado=conDao.verificarExistenciaCargaSinFecha(objBean);
			
			if(estado!=1){
				reporteSegmentado=dao.construirSelectVinculacionVIPSegmentado(segmento,cargo,filtro);
			}else{
				request.setAttribute("mensaje", Constantes.MENASJE_PROCESANDO+Constantes.VIP_DESCRIPCION);
			}
			request.setAttribute("hayResultados",reporteSegmentado.size()>0?true:false);
			request.setAttribute("reporteSegmentado",reporteSegmentado);
			request.getSession().setAttribute("listadoDetalle",reporteSegmentado);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mapping.findForward("reporteSegmentado");
	}

}
