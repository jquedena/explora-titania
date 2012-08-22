package igrupobbva.pe.sistemasdoweb.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

import pe.com.stefanini.common.exception.BaseException;
import pe.com.stefanini.common.exception.handling.ErrorMessagePreparer;
import pe.com.stefanini.common.exception.handling.impl.ErrorMessagePreparerFactory;
import proxy.load.Connection;

;

public class BaseLoadDataAction extends DispatchAction
{
    private static Logger log = Logger.getLogger(AccesoAction.class);
    protected Connection conexion = new Connection();
    protected ActionForward forward = null;
    protected ErrorMessagePreparer errorMessagePreparer=ErrorMessagePreparerFactory.getInstance();
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        try
        {
        	log.info("[BaseLoadDataAction :: execute] Inicio");
        	
            forward = super.execute(mapping, form, request, response);
            
            log.info("[BaseLoadDataAction :: execute] Fin");
        }
        catch (BaseException e)
        {
        	log.error("[BaseLoadDataAction :: execute] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
            
            request.setAttribute(ErrorMessagePreparer.ERROR_MESSAGE, errorMessagePreparer.prepareErrorMessage(request, e));
        }
        catch (Exception e)
        {
        	log.error("[BaseLoadDataAction :: execute] ");
        	ConstantesUtil.mostrarMensajeExcepcion(e);
        	
            request.setAttribute(ErrorMessagePreparer.ERROR_MESSAGE, errorMessagePreparer.prepareErrorMessage(request, e));
        }
        return forward;
    }
}
