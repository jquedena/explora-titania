package igrupobbva.pe.sistemasdoweb.actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class RegistraValorDefecto {
	
	private Logger log = Logger.getLogger(RegistraValorDefecto.class);
	private static RegistraValorDefecto instancia = null;
	
	public static SimpleDateFormat FORMATO_ANHO = new SimpleDateFormat("yyyy");
	public static SimpleDateFormat FORMATO_MES = new SimpleDateFormat("MM");
	
	
	private synchronized static void crearInstancia() {
		if (instancia == null) {
			instancia = new RegistraValorDefecto();
		}
	}

	public synchronized static RegistraValorDefecto getInstancia() {
		crearInstancia();
		return instancia;
	}
	
	public void registrar(HttpServletRequest request, String anho, String mes, String oficina) {
		HttpSession session = request.getSession();
		String urlAct = request.getServletPath() + (request.getParameter("method") == null ? "" : request.getParameter("method"));
		
		if(anho != null || mes != null || oficina != null) {
			session.setAttribute("valor_defecto_url", urlAct);
		} else {
			session.setAttribute("valor_defecto_url", urlAct + "NULL");
		}
		
		if(anho != null) {
			session.setAttribute("valor_defecto_anho", anho);
		}
		
		if(mes != null) {
			session.setAttribute("valor_defecto_mes", mes);
		}
		
		if(oficina != null) {
			session.setAttribute("valor_defecto_oficina", oficina);
		}
		
		log.info("valor_defecto_url:" + urlAct);
		log.info("valor_defecto_anho:" + anho);
		log.info("valor_defecto_mes:" + mes);
		log.info("valor_defecto_oficina:" + oficina);
	}
	
	public ValorDefecto leer(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ValorDefecto result = new ValorDefecto();
		
		Calendar calendario = Calendar.getInstance();
		Date hoy = calendario.getTime();
		
		String urlOld = session.getAttribute("valor_defecto_url") == null ? "" : (String) session.getAttribute("valor_defecto_url");
		String urlAct = request.getServletPath() + (request.getParameter("method") == null ? "" : request.getParameter("method"));
		boolean carga = !urlOld.equalsIgnoreCase(urlAct);
		
		result.setCargarPorDefecto(carga);		
		result.setAnho(session.getAttribute("valor_defecto_anho") == null ? RegistraValorDefecto.FORMATO_ANHO.format(hoy) : (String) session.getAttribute("valor_defecto_anho"));
		result.setMes(session.getAttribute("valor_defecto_mes") == null ? RegistraValorDefecto.FORMATO_MES.format(hoy) : (String) session.getAttribute("valor_defecto_mes"));
		result.setOficina(session.getAttribute("valor_defecto_oficina") == null ? null : (String) session.getAttribute("valor_defecto_oficina"));
		
		log.info("valor_defecto_url old:" + urlOld);
		log.info("valor_defecto_url:" + urlAct);
		log.info("valor_defecto_anho:" + result.getAnho());
		log.info("valor_defecto_mes:" + result.getMes());
		log.info("valor_defecto_oficina:" + result.getOficina());
		
		return result;
	}
}