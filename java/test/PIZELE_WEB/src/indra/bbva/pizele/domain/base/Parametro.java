package indra.bbva.pizele.domain.base;

import indra.core.GenericBean;

import java.io.Serializable;

public class Parametro extends GenericBean implements Serializable 
{

	private static final long serialVersionUID = 8751245105532159742L;
	
	private Long idTipoParametro;
	private String nombre;
	private String nombreTipoParametro;
	private Long idParametroPadre;
	private String nombreParametroPadre;
	private String estadoParametroPadre;
	private Long valorEntero;
	private double valorDecimal;
	private String valorTexto;
	private String codigo;	
	private String estadoRegistro;
	private String descripcion;
	
	private Long IdParametroDif;
	private Long idTipoParametroDif;
	
		
	public String getEstadoParametroPadre() {
		return estadoParametroPadre;
	}
	public void setEstadoParametroPadre(String estadoParametroPadre) {
		this.estadoParametroPadre = estadoParametroPadre;
	}
	public Long getIdTipoParametroDif() {
		return idTipoParametroDif;
	}
	public void setIdTipoParametroDif(Long idTipoParametroDif) {
		this.idTipoParametroDif = idTipoParametroDif;
	}
	public Long getIdParametroDif() {
		return IdParametroDif;
	}
	public void setIdParametroDif(Long idParametroDif) {
		IdParametroDif = idParametroDif;
	}
	
	public Long getIdTipoParametro() {
		return idTipoParametro;
	}
	public void setIdTipoParametro(Long idTipoParametro) {
		this.idTipoParametro = idTipoParametro;
	}
	public void setIdTipoParametroString(String idTipoParametro) {
		if(idTipoParametro == null || idTipoParametro.length() == 0)
			this.setIdTipoParametro(0L);
		else
			this.setIdTipoParametro(Long.parseLong(idTipoParametro));		
	}	
	public String getIdTipoParametroString()
	{
		if(this.getIdTipoParametro() == 0)
			return "";
		else
			return String.valueOf(this.getIdTipoParametro());
	}
	
	
	public Long getIdParametroPadre() {
		return idParametroPadre;
	}
	public void setIdParametroPadre(Long idParametroPadre) {
		this.idParametroPadre = idParametroPadre;
	}
	public void setIdParametroPadreString(String idParametroPadre) {
		if(idParametroPadre == null || idParametroPadre.length() == 0)
			this.setIdParametroPadre(0L);
		else
			this.setIdParametroPadre(Long.parseLong(idParametroPadre));		
	}	
	public String getIdParametroPadreString()
	{
		if(this.getIdParametroPadre() == 0)
			return "";
		else
			return String.valueOf(this.getIdParametroPadre());
	}
	
	
	public Long getValorEntero() {
		return valorEntero;
	}
	public void setValorEntero(Long valorEntero) {
		this.valorEntero = valorEntero;
	}
	public double getValorDecimal() {
		return valorDecimal;
	}
	public void setValorDecimal(double valorDecimal) {
		this.valorDecimal = valorDecimal;
	}
	public String getValorTexto() {
		return valorTexto;
	}
	public void setValorTexto(String valorTexto) {
		this.valorTexto = valorTexto;
	}	
	
	public String getNombreParametroPadre() {
		return nombreParametroPadre;
	}
	public void setNombreParametroPadre(String nombreParametroPadre) {
		this.nombreParametroPadre = nombreParametroPadre;
	}
	
	public String getNombreTipoParametro() {
		return nombreTipoParametro;
	}
	public void setNombreTipoParametro(String nombreTipoParametro) {
		this.nombreTipoParametro = nombreTipoParametro;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	public String getCodValText()
	{
		if(this.getCodigo() != null && this.getCodigo().length() > 0 && this.getValorTexto() != null && this.getValorTexto().length() > 0)
			return this.getCodigo() + "|" + this.getValorTexto();
		else
			return "";
	}
	
	public void setCodValText(String codValText)
	{
		if(codValText != null && codValText.length() > 0)
		{
			this.setCodigo(codValText.split("\\|")[0]);
			this.setValorTexto(codValText.split("\\|")[1]);
		}
		else
		{
			this.setCodigo("");
			this.setValorTexto("");
		}
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
