package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection;
import com.grupobbva.bc.per.tel.iilc.forms.FormBeanConsulta;
import com.grupobbva.bc.per.tel.iilc.serializable.Gestor;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.serializable.Oficina;
import com.stefanini.pe.framework.collections.DataTable;

/**
 * @version 	1.0
 * @author
 */
public class CargaDatosAction extends DispatchAction

{

    public ActionForward cargaSelect(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionErrors errors = new ActionErrors();
        Connection conexion = new Connection();
        FormBeanConsulta formBeanConsulta = (FormBeanConsulta) form;

        String codArea = (String) formBeanConsulta.getAtog().get(0);
        String codTerritorio = request.getParameter("territorio");
        String codOficina = request.getParameter("oficina");
         
        char tipoSelect = request.getParameter("tipo").charAt(0);
        
        formBeanConsulta.setOficina(codOficina);
        formBeanConsulta.setTerritorio(codTerritorio);
        
        try {
            PrintWriter out = response.getWriter();
            String optionSelected = formBeanConsulta.getOficina();
            Vector options=new Vector();
            if (optionSelected!=null){
            	
                switch (tipoSelect){
              		case 'T':
              		    options= conexion.findAllOficinaxTe(codArea,codTerritorio);
              		    break;
              		case 'O':
              		    options= conexion.findAllGestorxOfxTe(codArea,codTerritorio,codOficina);
              		    break;
                }
              
              //Make a String representation where each option is seperated by '||' and a valua and a label by ';'
              String outLine = "";
              String par="";
              for(int i=0; i<options.size(); i++){
                  switch (tipoSelect){
            		case 'T':
            		    par = ((Oficina)options.get(i)).getCod_oficina() +"|"+((Oficina)options.get(i)).getDes_oficina();
            		    break;
            		case 'O':            			
            		   if(((Gestor)options.get(i)).getPerfil_gestor()!=null){
            		   	par = ((Gestor)options.get(i)).getCod_gestor() +"|"+((Gestor)options.get(i)).getNom_gestor()+" - "+((Gestor)options.get(i)).getPerfil_gestor();
            		   }else{
            		   	par = ((Gestor)options.get(i)).getCod_gestor() +"|"+((Gestor)options.get(i)).getNom_gestor();
            		   }            			
            		    //par = ((Gestor)options.get(i)).getCod_gestor() +"|"+"GOF"+" - "+((Gestor)options.get(i)).getNom_gestor();
            		    break;
                  }
                  
                  if (i == 0) outLine = par;
                  else outLine = outLine + "||" +par;
              }
              
              outLine = Utilitario.stringOracle(outLine);
              out.print(outLine);
            }

        } catch (Exception e) {
            // Report the error using the appropriate name and ID.
            errors.add("name", new ActionError("id"));
        }

        // If a message is required, save the specified key(s)
        // into the request for use by the <struts:errors> tag.

        if (!errors.isEmpty()) {
            saveErrors(request, errors);
        }
        
        // Finish with
        return null;

    }
    public ActionForward cargaEtiquetaSegmento(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

 		ActionErrors errors = new ActionErrors();
    	ActionForward forward = new ActionForward(); // return value
    	Connection ejb = new Connection();
    	Multitabla bean = null;
    	try{
			DataTable tablaBase = new DataTable();
			DataTable etiquetaSegmento = null;
			Vector<Multitabla> etiquetas=ejb.findEtiquetas();			
			int cantidadSegmentos=ejb.findCantidadSegmentos();
			String cantSegmento="";
			String etiqueta="";
			/*for(int j=1;j<=cantidadSegmentos;j++){
				cantSegmento=String.valueOf(j);
				tablaBase.getColumnas().add("SEGMENTO_"+cantSegmento);
			}*/
			if (etiquetas != null) {
				for (int i = 0; i < etiquetas.size(); i++) {
					bean = etiquetas.elementAt(i);					
					etiqueta = bean.getValor1() != null ? bean.getValor1() : "";
					tablaBase.getColumnas().add(etiqueta);
				}
			/*
			if (etiquetas != null) {
				for (int i = 0; i < etiquetas.size(); i++) {
					bean = (Multitabla) etiquetas.elementAt(i);					
					etiqueta = bean.getValor1() != null ? bean.getValor1() : "";					
					tablaBase.getColumnas().add(etiqueta);
			}*/
				
			etiquetaSegmento=ejb.findEtiquetasSegmentos(tablaBase);
    		request.setAttribute("listaEtiquetaSegmento",etiquetaSegmento);
    		cantSegmento=String.valueOf(cantidadSegmentos);
    		request.setAttribute("cantidadSegmentos",cantSegmento);
			}
    	}	catch (Exception e) {
			errors.add("name", new ActionError("id"));  //$NON-NLS-2$
		}
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
            // Forward control to the appropriate 'failure' URI (change name as desired)
            forward = mapping.findForward("error");
        } else {
            // Forward control to the appropriate 'success' URI (change name as desired)
            forward = mapping.findForward("listaEtiquetaSegmento");
            }
        // Finish with
        return (forward);  

    }
}
