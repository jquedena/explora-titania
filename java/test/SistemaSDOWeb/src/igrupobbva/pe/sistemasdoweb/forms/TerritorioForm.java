/*
 * Created on 23/03/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package igrupobbva.pe.sistemasdoweb.forms;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.grupobbva.bc.per.tele.sdo.serializable.*;

/**
 * @author Stefanini
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TerritorioForm extends ActionForm{
private List listaTerritorio;
private String codTerritorio;
private String nomTerritorio;
private String estado;

private Territorio territorio = new Territorio();

/**
 * @return Returns the territorio.
 */
public Territorio getTerritorio() {
	return territorio;
}
/**
 * @param territorio The territorio to set.
 */
public void setTerritorio(Territorio territorio) {
	this.territorio = territorio;
}
/**
 * @return Returns the codTerritorio.
 */
public String getCodTerritorio() {
	return codTerritorio;
}
/**
 * @param codTerritorio The codTerritorio to set.
 */
public void setCodTerritorio(String codTerritorio) {
	this.codTerritorio = codTerritorio;
}

/**
 * @return Returns the nomTerritorio.
 */
public String getNomTerritorio() {
	return nomTerritorio;
}
/**
 * @param nomTerritorio The nomTerritorio to set.
 */
public void setNomTerritorio(String nomTerritorio) {
	this.nomTerritorio = nomTerritorio;
}
/**
 * @return Returns the listaTerritorio.
 */
public List getListaTerritorio() {
	return listaTerritorio;
}
/**
 * @param listaTerritorio The listaTerritorio to set.
 */
public void setListaTerritorio(List listaTerritorio) {
	this.listaTerritorio = listaTerritorio;
}
/**
 * @return Returns the estado.
 */
public String getEstado() {
	return estado;
}
/**
 * @param estado The estado to set.
 */
public void setEstado(String estado) {
	this.estado = estado;
}
}
