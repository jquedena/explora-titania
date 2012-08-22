package indra.bbva.pizele.domain.base;

import java.io.Serializable;
import java.util.List;

public class OpcionMenu implements Serializable 
{

	private static final long serialVersionUID = 8751282105532159742L;
	
	private Long codigo;
	private String nombre;
	private String url;
	private Long codigoPadre = null;
	private String modo;

	private List<OpcionMenu> opcionesHijas;
	
	public Long getCodigo() {	
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<OpcionMenu> getOpcionesHijas() {
		return opcionesHijas;
	}
	public void setOpcionesHijas(List<OpcionMenu> opcionesHijas) {
		this.opcionesHijas = opcionesHijas;
	}
		
	public Long getCodigoPadre() {
		return codigoPadre;
	}
	public void setCodigoPadre(Long codigoPadre) {
		this.codigoPadre = codigoPadre;
	}
	
	public String getModo() {
		return modo;
	}
	public void setModo(String modo) {
		this.modo = modo;
	}
	
	public String getHTML() 
	{
				
		StringBuffer sbHtml = new StringBuffer();
		
		if(this.getCodigoPadre() == null)
		{
			sbHtml.append("<a ");
			sbHtml.append("tabindex=\"0\" ");
			
			sbHtml.append("href=\"" + this.getUrl() + "\" ");
			
			sbHtml.append("class=\"fg-button fg-button-icon-right ui-widget ui-state-default ui-corner-all\" ");
											
			sbHtml.append("id=\"flyout" + this.getCodigo() + "\">");
			
			if(this.getOpcionesHijas() == null || this.getOpcionesHijas().size() == 0)
				sbHtml.append("<span></span>");
			else
				sbHtml.append("<span class=\"ui-icon ui-icon-triangle-1-s\"></span>");
						
			sbHtml.append(this.getNombre());
			sbHtml.append("</a>");	
			
			if(this.getOpcionesHijas() != null && this.getOpcionesHijas().size() > 0)
			{
				sbHtml.append("<div class=\"hidden\">");
				sbHtml.append("<ul>");
				for(int index = 0; index < this.getOpcionesHijas().size(); index++)
				{					
					sbHtml.append(this.getOpcionesHijas().get(index).getHTML());
				}
				sbHtml.append("</li>");
				sbHtml.append("</ul>");				
			}
								
		}
				
		if(this.getCodigoPadre() != null)
		{
			sbHtml.append("<li>");
			sbHtml.append("<a ");			
			sbHtml.append("href=\"" + this.getUrl() + "\">");							
			sbHtml.append(this.getNombre());
			sbHtml.append("</a>");								
		}
		
		if(this.getCodigoPadre() != null && this.getOpcionesHijas() != null && this.getOpcionesHijas().size() > 0)
		{
			sbHtml.append("<ul>");
			
			for(int index = 0; index < this.getOpcionesHijas().size(); index++)
			{
				sbHtml.append(this.getOpcionesHijas().get(index).getHTML());
			}
			
			sbHtml.append("</li>");
			sbHtml.append("</ul>");
		}
					
		if(this.getCodigoPadre() == null && this.getOpcionesHijas() != null && this.getOpcionesHijas().size() > 0)
		{
			sbHtml.append("</div>");
		}
			
		return sbHtml.toString();
		
	}
	
	
}
