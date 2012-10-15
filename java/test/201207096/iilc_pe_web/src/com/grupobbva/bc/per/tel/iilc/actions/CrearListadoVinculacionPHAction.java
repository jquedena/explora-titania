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

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_conf_cabeceras_rep;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.dao.AdmDescCabRepDAO;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanCrearListadoVinculacionPH;

public class CrearListadoVinculacionPHAction extends Action {
    /**This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, 
                                 HttpServletRequest request, 
                                 HttpServletResponse response) throws IOException, 
                                                                      ServletException {
                                                                      
    	 FormBeanCrearListadoVinculacionPH actionForm = ( FormBeanCrearListadoVinculacionPH)form;  
       
       AdmDescCabRepDAO daolistado = new AdmDescCabRepDAO();
       
       
       List listadoE =   (List)request.getSession().getAttribute("listadoVin3");
       for(int i = 0; i < listadoE.size() ; i++){
    	   
    	   Tiilc_conf_cabeceras_rep e = new Tiilc_conf_cabeceras_rep();
           e = (Tiilc_conf_cabeceras_rep) listadoE.get(i);
    	    
           String corta = request.getParameter("corta_"+e.getOrden());
           String larga = request.getParameter("larga_"+e.getOrden());
           String usuario=request.getSession().getAttribute("usuario").toString();
    	   e.setUsuaModi(usuario);
           
           e.setDescorta(corta);
    	   e.setDeslarga(larga);
    	   
           daolistado.actualizarDescripcion(e);
        
       }
       request.getSession().removeAttribute("listadoVin3");
       request.setAttribute("mensaje",Constantes.MENSAJE_INFORMACION_ACTUALIZACION_ADMINISTRACION);
        return mapping.findForward("crear");
        
    }
}

