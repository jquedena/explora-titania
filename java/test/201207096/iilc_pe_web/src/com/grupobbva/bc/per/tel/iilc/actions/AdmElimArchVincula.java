package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.serializable.AdministracionCargaVinculacion;

public class AdmElimArchVincula extends Action  {

 	@SuppressWarnings({"unchecked","unused"})
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
         HttpServletRequest request, HttpServletResponse response) throws IOException, 
                                              ServletException {
     
 	ConexionDAO con = new ConexionDAO();
 	AdministracionCargaVinculacion objBean=new AdministracionCargaVinculacion();
 	
 	try {

 		String usuario=request.getSession().getAttribute("usuario").toString();
 		String tipo = request.getParameter("tipo");
 		String tipo_numerico = "";
		if(tipo.equals("V")){
			tipo_numerico="1";
		}else if(tipo.equals("G")){
			tipo_numerico="2";
		}else if(tipo.equals("P")){
			tipo_numerico="3";
		}
		
		
 		if(request.getParameter("eliminar")!=null){
 			
 			String arreglo[]=request.getParameterValues("arregloEliminar");
 				if(arreglo!=null  && arreglo.length>0){
		 			for(int i=0;i<arreglo.length;i++){
		 				objBean.setTipo(Integer.parseInt(tipo_numerico));
		 				objBean.setFecha(arreglo[i]);
		 				if(con.verificarExistenciaCarga(objBean)==1){
		 					request.setAttribute("mensaje", "Se estan intentando eliminar cargas que se encuentran en proceso");
		 				}else{
		 					con.eliminarCargaVinculacion(arreglo[i],tipo_numerico);
		 				}
		 			}
 				}
 			
 		} 
 		
 		List lista=con.listarCargasVinculacion(tipo_numerico);
 
		request.getSession().setAttribute("listaCargas", lista);
		request.setAttribute("tipo", tipo);
		
 
	
	} catch (Exception e) {
		request.setAttribute("mensaje","error");
		e.printStackTrace();
	}
	

	return mapping.findForward("listar");
	
	}

}