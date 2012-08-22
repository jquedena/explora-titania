package indra.core;


import indra.bbva.pizele.common.Constantes;
import indra.bbva.pizele.common.CurrentUser;
import indra.bbva.pizele.common.Resultado;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext; 
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class GenericAction extends ActionSupport 
{
	
	private boolean clearPaging;
	
	private CurrentUser currentUser;
	
	/**
	 * Metodo para obtener un bean de spring
	 * @param name
	 * @return
	 */
	public static Object getSpringBean(String name){
		WebApplicationContext context =
			WebApplicationContextUtils.getRequiredWebApplicationContext(
                                    ServletActionContext.getServletContext()
                        );
		return context.getBean(name);
	}
	
	/**
	 * Metodo para obtener datos de session
	 * @param nombre
	 * @return
	 */
	public static Object getObjectSession(String nombre){
		Map<String, Object>  sessionparam =  ActionContext.getContext().getSession();
		Object  obj = sessionparam.get(nombre);
		return obj;
	}
	
	/**
	 * Metodos para enviar datos a session
	 * @param nombre
	 * @param valor
	 */
	public static void  setObjectSession(String nombre, Object valor){
		Map<String, Object> sessionparam = ActionContext.getContext().getSession();
		sessionparam.put(nombre, valor);
	}
		
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	public ServletContext getServletContext(){
		return ServletActionContext.getServletContext();
	}
	
	public HttpSession getSession(boolean create){
		return getRequest().getSession(create);
	}
	
	public String getMensaje(String key) throws FileNotFoundException, IOException
	{
 
		Properties properties = new Properties();
		InputStream is = this.getClass().getResourceAsStream("/mensajes.properties");   
		properties.load(is);	
		return properties.getProperty(key);
	}
	
	public void renderListaObjetosJson(Object listaObjetos) throws IOException
	{
		this.getResponse().setContentType("text/json"); 
		PrintWriter out = getResponse().getWriter(); 
		JSONArray jsonArray = JSONArray.fromObject(listaObjetos);		
		out.write("{\"listaObjetos\":" + jsonArray.toString() + "}");  
		out.flush();  
		out.close(); 
	}
	
	public void renderObjetoJson(Object objeto) throws IOException
	{
		this.getResponse().setContentType("text/json"); 
		PrintWriter out = getResponse().getWriter(); 
		JSONArray jsonArray = JSONArray.fromObject(objeto);
		out.write(jsonArray.getJSONObject(0).toString());  
		out.flush();  
		out.close(); 
	}
	
	public void renderJsonEXITO_OBJETO(String msg, Object objeto) throws IOException
	{
		this.getResponse().setContentType("text/json"); 
		PrintWriter out = getResponse().getWriter();
		
		JSONArray jsonArray = JSONArray.fromObject(objeto);
		
		StringBuffer sbJson = new StringBuffer();
		sbJson.append("{\"objeto\":" + jsonArray.getJSONObject(0).toString() + ",");
		sbJson.append("\"mensaje\":\"" + msg + "\",");
		sbJson.append("\"resultado\":\"" + Constantes.TipoResultado.EXITO + "\"}");
		out.write(sbJson.toString());
			
		out.flush();  
		out.close();
	}
	
	public void renderJsonERROR(String msg) throws IOException
	{
		this.getResponse().setContentType("text/json"); 
		PrintWriter out = getResponse().getWriter(); 
		Resultado objResultado = new Resultado();
		objResultado.setResultado(Constantes.TipoResultado.ERROR);
		if(msg == null) {
			msg = "No se pudo recuperar la excepción ocurrida.";
		}
		objResultado.setMensaje(msg);
		JSONArray jsonArray = JSONArray.fromObject(objResultado);
		out.write(jsonArray.getJSONObject(0).toString());  
		out.flush();  
		out.close();
	}
	
	public void renderJsonRESULTADO(String msg, String tipoResultado) throws IOException
	{
		this.getResponse().setContentType("text/json"); 
		PrintWriter out = getResponse().getWriter(); 
		Resultado objResultado = new Resultado();
		objResultado.setResultado(tipoResultado);
		objResultado.setMensaje(msg);
		JSONArray jsonArray = JSONArray.fromObject(objResultado);
		out.write(jsonArray.getJSONObject(0).toString());  
		out.flush();  
		out.close();
	}
	
	public void renderJsonPREGUNTA(String msg) throws IOException
	{
		this.getResponse().setContentType("text/json"); 
		PrintWriter out = getResponse().getWriter(); 
		Resultado objResultado = new Resultado();
		objResultado.setResultado(Constantes.TipoResultado.PREGUNTA);
		objResultado.setMensaje(msg);
		JSONArray jsonArray = JSONArray.fromObject(objResultado);
		out.write(jsonArray.getJSONObject(0).toString());  
		out.flush();  
		out.close();
	}
	
	public void renderJsonEXITO(String msg) throws IOException
	{
		this.getResponse().setContentType("text/json"); 
		PrintWriter out = getResponse().getWriter(); 
		Resultado objResultado = new Resultado();
		objResultado.setResultado(Constantes.TipoResultado.EXITO);
		objResultado.setMensaje(msg);
		JSONArray jsonArray = JSONArray.fromObject(objResultado);
		out.write(jsonArray.getJSONObject(0).toString());  
		out.flush();  
		out.close();
	}
		
	public void renderJsonEXITO_LISTA(String msg, Object lista) throws IOException
	{
		this.getResponse().setContentType("text/json"); 
		PrintWriter out = getResponse().getWriter();
		
		JSONArray jsonArrayLista = JSONArray.fromObject(lista);
		
		StringBuffer sbJson = new StringBuffer();
		sbJson.append("{\"listaObjetos\":" + jsonArrayLista.toString() + ",");
		sbJson.append("\"mensaje\":\"" + msg + "\",");
		sbJson.append("\"resultado\":\"" + Constantes.TipoResultado.EXITO + "\"}");
		out.write(sbJson.toString());
			
		out.flush();  
		out.close();
	}
	
	public void renderJsonEXITO_LISTA_DOBLE(Object lista1, Object lista2) throws IOException
	{
		this.getResponse().setContentType("text/json"); 
		PrintWriter out = getResponse().getWriter();
		
		JSONArray jsonArrayLista1 = JSONArray.fromObject(lista1);
		JSONArray jsonArrayLista2 = JSONArray.fromObject(lista2);
		
		StringBuffer sbJson = new StringBuffer();
		sbJson.append("{\"listaObjetos1\":" + jsonArrayLista1.toString() + ",");
		sbJson.append("\"listaObjetos2\":" + jsonArrayLista2.toString() + ",");
		sbJson.append("\"resultado\":\"" + Constantes.TipoResultado.EXITO + "\"}");
		
		out.write(sbJson.toString());
			
		out.flush();  
		out.close();
	}
		
	public void renderJsonEXITO_LISTA_DOBLE(Object lista1, Object lista2, String msg) throws IOException
	{
		this.getResponse().setContentType("text/json"); 
		PrintWriter out = getResponse().getWriter();
		
		JSONArray jsonArrayLista1 = JSONArray.fromObject(lista1);
		JSONArray jsonArrayLista2 = JSONArray.fromObject(lista2);
		
		StringBuffer sbJson = new StringBuffer();
		sbJson.append("{\"listaObjetos1\":" + jsonArrayLista1.toString() + ",");
		sbJson.append("\"listaObjetos2\":" + jsonArrayLista2.toString() + ",");
		sbJson.append("\"mensaje\":\"" + msg + "\",");
		sbJson.append("\"resultado\":\"" + Constantes.TipoResultado.EXITO + "\"}");
		
		out.write(sbJson.toString());
			
		out.flush();  
		out.close();
	}
	
	public void renderJsonEXITO_LISTAS(List<Object> listas, String msg) throws IOException
	{
		this.getResponse().setContentType("text/json"); 
		PrintWriter out = getResponse().getWriter();
		StringBuffer sbJson = new StringBuffer();
		JSONArray jsonArrayLista = null;
		
		sbJson.append("{");
		
		for(int index = 0; index < listas.size(); index++)
		{
			jsonArrayLista = JSONArray.fromObject(listas.get(index));
			sbJson.append("\"listaObjetos" + (index + 1) + "\":" + jsonArrayLista.toString() + ",");
		}
		sbJson.append("\"mensaje\":\"" + msg + "\",");
		sbJson.append("\"resultado\":\"" + Constantes.TipoResultado.EXITO + "\"}");
		
		out.write(sbJson.toString());
		
		out.flush();  
		out.close();
	}
	
	public void renderJson_LISTAS(List<Object> listas, String msg, String tipoResultado) throws IOException
	{
		this.getResponse().setContentType("text/json"); 
		PrintWriter out = getResponse().getWriter();
		StringBuffer sbJson = new StringBuffer();
		JSONArray jsonArrayLista = null;
		
		sbJson.append("{");
		
		for(int index = 0; index < listas.size(); index++)
		{
			jsonArrayLista = JSONArray.fromObject(listas.get(index));
			sbJson.append("\"listaObjetos" + (index + 1) + "\":" + jsonArrayLista.toString() + ",");
		}
		sbJson.append("\"mensaje\":\"" + msg + "\",");
		sbJson.append("\"resultado\":\"" + tipoResultado + "\"}");
		
		out.write(sbJson.toString());
		
		out.flush();  
		out.close();
	}
	
	public boolean isClearPaging() {
		return clearPaging;
	}

	public void setClearPaging(boolean clearPaging) {
		this.clearPaging = clearPaging;
	}

	public CurrentUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CurrentUser currentUser) {
		this.currentUser = currentUser;
	}
	
}
