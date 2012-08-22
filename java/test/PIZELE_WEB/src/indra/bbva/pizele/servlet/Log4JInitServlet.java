package indra.bbva.pizele.servlet;

import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.domain.base.Parametro;
import indra.bbva.pizele.service.ParametroService;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class Log4JInitServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	private WebApplicationContext contexto= null;
	
	public void init(ServletConfig config) throws ServletException 
	{
		
		this.contexto =  WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		
		ParametroService parametroService = (ParametroService) this.contexto.getBean("parametroService");
		
		Parametro objParametro = parametroService.obtenerParametro(Constantes.ParmetroID.ID_RUTA_NOMBRE_LOG);
		
		if(objParametro == null)
		{
			BasicConfigurator.configure();
		}
		else
		{
			File objLog4j = new File(objParametro.getValorTexto());
			if(!objLog4j.exists())
				BasicConfigurator.configure();
			else
			{
				PropertyConfigurator.configure(objParametro.getValorTexto());
				Logger.getLogger(this.getClass()).error("NO ERROR : LOG4J INICIALIZADO");
			}
		}

		super.init(config);
		
	}

	
}
