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

import com.grupobbva.bc.per.tel.iilc.dao.AdmDescCabRepDAO;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanListadoVinculacionesGCO;

public class ListadoVinculacionesGCOAction extends Action {
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
                                                                      
       FormBeanListadoVinculacionesGCO actionForm = (FormBeanListadoVinculacionesGCO)form;  
       
       AdmDescCabRepDAO daolistado = new AdmDescCabRepDAO();
       
       
       List listadoDocumento = daolistado.obtenerDescripcion("2");
            if(listadoDocumento!=null){
            request.getSession().setAttribute("listadoVin2",listadoDocumento);
           
        }
        
        
        
        return mapping.findForward("consulta");
        
    }
}

