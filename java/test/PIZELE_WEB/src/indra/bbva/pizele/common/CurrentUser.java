package indra.bbva.pizele.common;

import java.util.List;

import indra.bbva.pizele.domain.base.Oficina;
import indra.bbva.pizele.domain.base.OpcionMenu;
import indra.bbva.pizele.domain.base.Territorio;
import indra.core.GenericAction;
import indra.core.ObjetoRender;

public class CurrentUser 
{

	// --- FIELD'S ----
	
	private String nombreCompleto;
	private String codigoRegistro;
	private String codigoOficina;
	private String codigoPerfil;
	private String codigoCargo;
	
	private List<OpcionMenu> listaOpciones;
	private List<ObjetoRender> listaOpciones_html;
	private List<ObjetoRender> listaOpciones_js;
	
	private boolean esBackupSuplente = false;
	
	private String nombreCompletoGOF;
	private String codigoRegistroGOF;	
	private String codigoPerfilGOF;
	private String codigoCargoGOF;
	
	private Territorio territorio;
	private Oficina oficina;
	
	private CurrentUser(){}
	
	public static CurrentUser Instance()
	{
		if(GenericAction.getObjectSession(Constantes.Sesion.CURRENT_USER) == null)
			GenericAction.setObjectSession(Constantes.Sesion.CURRENT_USER, new CurrentUser());
		
		return (CurrentUser)GenericAction.getObjectSession(Constantes.Sesion.CURRENT_USER);
	}
	
	public static boolean isLogged()
	{
		if(GenericAction.getObjectSession(Constantes.Sesion.CURRENT_USER) == null)
			return false;
		else
			return true;
	}
	
	public static void LogOut()
	{
		GenericAction.setObjectSession(Constantes.Sesion.CURRENT_USER, null);
	}

	public String obtenerTipoAccesoOpcion(Long idOpcion)
	{		
		for(int index = 0; index < this.getListaOpciones().size(); index++)
		{
			if(this.getListaOpciones().get(index).getCodigo() == idOpcion)
				return this.getListaOpciones().get(index).getModo();
		}
		return "";
	}
	
	// --- GETTER'R AND SETTER'S ----
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getCodigoOficina() {
		return codigoOficina;
	}

	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}

	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	public boolean getEsBackupSuplente() {
		return esBackupSuplente;
	}

	public void setEsBackupSuplente(boolean esBackupSuplente) {
		this.esBackupSuplente = esBackupSuplente;
	}

	public String getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	public List<OpcionMenu> getListaOpciones() {
		return listaOpciones;
	}

	public void setListaOpciones(List<OpcionMenu> listaOpciones) {
		this.listaOpciones = listaOpciones;
	}

	public List<ObjetoRender> getListaOpciones_html() {
		return listaOpciones_html;
	}

	public void setListaOpciones_html(List<ObjetoRender> listaOpciones_html) {
		this.listaOpciones_html = listaOpciones_html;
	}

	public List<ObjetoRender> getListaOpciones_js() {
		return listaOpciones_js;
	}

	public void setListaOpciones_js(List<ObjetoRender> listaOpciones_js) {
		this.listaOpciones_js = listaOpciones_js;
	}

	public String getNombreCompletoGOF() {
		return nombreCompletoGOF;
	}

	public void setNombreCompletoGOF(String nombreCompletoGOF) {
		this.nombreCompletoGOF = nombreCompletoGOF;
	}

	public String getCodigoRegistroGOF() {
		return codigoRegistroGOF;
	}

	public void setCodigoRegistroGOF(String codigoRegistroGOF) {
		this.codigoRegistroGOF = codigoRegistroGOF;
	}

	public String getCodigoPerfilGOF() {
		return codigoPerfilGOF;
	}

	public void setCodigoPerfilGOF(String codigoPerfilGOF) {
		this.codigoPerfilGOF = codigoPerfilGOF;
	}

	public String getCodigoCargoGOF() {
		return codigoCargoGOF;
	}

	public void setCodigoCargoGOF(String codigoCargoGOF) {
		this.codigoCargoGOF = codigoCargoGOF;
	}

	public Territorio getTerritorio() {
		return territorio;
	}

	public void setTerritorio(Territorio territorio) {
		this.territorio = territorio;
	}

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
		
}
