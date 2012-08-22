package igrupobbva.pe.sistemasdoweb.actions;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import igrupobbva.pe.sistemasdoweb.forms.PlaneacionForm;
import igrupobbva.pe.sistemasdoweb.forms.SimpleLoadForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.skife.csv.CSVReader;
import org.skife.csv.SimpleReader;

import pe.com.stefanini.common.*;
import pe.com.stefanini.common.bean.Message;
import pe.com.stefanini.common.bean.Message.Type;
import pe.com.stefanini.common.exception.handling.ErrorMessagePreparer;

import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.PermisoPerfil;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import org.apache.log4j.Logger;

public class CargaDataPermisosAction extends BaseLoadDataAction {
	private static Logger log = Logger
			.getLogger(CargaDataPermisosAction.class);

	public ActionForward inicioCarga(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {		
		return mapping.findForward("inicioCarga");
	}
	
	public ActionForward cargarData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {		
		SimpleLoadForm loadForm = (SimpleLoadForm) form;
		HttpSession sesion = null;
		Gestor gestor = null;
		
		try {
			log.info("[CargaDataPermisosAction :: cargarData] Inicio");
			
	        FormFile formFile = loadForm.getFileInput();
	        CSVReader reader = new SimpleReader();
	        InputStream inputStream = formFile.getInputStream();
	        List items = reader.parse(inputStream);
	        StringBuffer registrosIngresados = new StringBuffer();
	        StringBuffer registrosFallados = new StringBuffer();
	        sesion = request.getSession(false);
	        gestor = (Gestor)sesion.getAttribute("gestor"); 
	        
	        for (Iterator iterator = items.iterator(); iterator.hasNext();) {
				String[] row = (String[]) iterator.next();
				PermisoPerfil permisoPerfil = createPermisoPerfil(row);
				permisoPerfil.setUsuRegi(gestor.getCodigoGestor());
				
				int sucess = conexion.registrarPermisoPerfil(permisoPerfil);
				StringBuffer cadenaRow = new StringBuffer();
				
				for(int i = 0; i < row.length; i++) {
					cadenaRow.append(row[i]);
				}
				
				if(sucess > 0){
					registrosIngresados.append("<p>" + cadenaRow + "</p>");
				}else{
					registrosFallados.append("<p>" + cadenaRow + "</p>");
				}
			}        
	        
	        if(StringUtils.isNotBlank(registrosIngresados.toString())){
	        	request.setAttribute(ErrorMessagePreparer.ERROR_MESSAGE, 
	        			new Message(Type.INFO,"Se grabaron exitosamente los siguientes registros:" + 
	        					registrosIngresados.toString()));
	        }
	        if(StringUtils.isNotBlank(registrosFallados.toString())){
	        	request.setAttribute(ErrorMessagePreparer.ERROR_MESSAGE, 
	        			new Message(Type.INFO,"No se grabaron los siguientes registros:" + 
	        					registrosFallados.toString()));
	        }
	        
	        log.info("[CargaDataPermisosAction :: cargarData] Fin");
		} catch(Exception e) {
			log.error("[CargaDataPermisosAction :: xInsertarTTerritorio] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
        
		return mapping.findForward("inicioCarga");
	}
	
	private PermisoPerfil createPermisoPerfil(String[] arrayPermisoPerfil){
		PermisoPerfil permisoPerfil = new PermisoPerfil();
		
		log.info("[CargaDataPermisosAction :: createPermisoPerfil] Inicio");
		
		permisoPerfil.setCodPerfil(arrayPermisoPerfil[0]);
		permisoPerfil.setTipoAcceso(arrayPermisoPerfil[1]);
		permisoPerfil.setValorRCP(arrayPermisoPerfil[2]);
		permisoPerfil.setUsuario(arrayPermisoPerfil[3]);
		
		log.info("[CargaDataPermisosAction :: createPermisoPerfil] Fin");
		
		return permisoPerfil;
	}

}
