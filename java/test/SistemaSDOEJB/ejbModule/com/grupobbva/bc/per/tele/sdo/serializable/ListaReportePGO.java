/*
 * Created on 14-abr-2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ListaReportePGO implements Serializable{
	
	String codEpigrafe;
	String nomEpigrafe;
	String codOficina;
	String mesPlan;
	String anoPlan;
	String metMesSaldPuntual;
	String prioridad;
	String metGestOficina;
	String nomAccion;
	String codGestor;
	String nroCliente;
	String compGestor;
	String nroGestSeg1;
	String nroConcSeg1;
	String montSeg1;
	String nroGestSeg2;
	String nroConcSeg2;
	String montSeg1_1;
	String codAccion;
	String indAfecta;
	String porAsignado;	
	String desv1;
	String desv2;
	String codPerfil;
	String nomGestor;
	boolean resumenPorEpigrafe;
	String backgroundColor;
	
	/**
	 * @return Returns the codPerfil.
	 */
	public String getCodPerfil() {
		return codPerfil;
	}
	/**
	 * @param codPerfil The codPerfil to set.
	 */
	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
	}
	/**
	 * @return Returns the nomGestor.
	 */
	public String getNomGestor() {
		return nomGestor;
	}
	/**
	 * @param nomGestor The nomGestor to set.
	 */
	public void setNomGestor(String nomGestor) {
		this.nomGestor = nomGestor;
	}
	int TotalnumeroCliente;
	int TotalcompGestor;
	int TotalnumeroGest1;
	int TotalnumeroConcr1;
	int Totalmonto1;
	int TotalnumeroGest2;
	int TotalnumeroConcr2;
	int Totalmonto2;
	int Totaldesv1;
	int Totaldesv2;
	
	
	/**
	 * @return Returns the desv1.
	 */
	public String getDesv1() {
		return desv1;
	}
	/**
	 * @param desv1 The desv1 to set.
	 */
	public void setDesv1(String desv1) {
		this.desv1 = desv1;
	}
	/**
	 * @return Returns the desv2.
	 */
	public String getDesv2() {
		return desv2;
	}
	/**
	 * @param desv2 The desv2 to set.
	 */
	public void setDesv2(String desv2) {
		this.desv2 = desv2;
	}
	/**
	 * @return Returns the totaldesv1.
	 */
	public int getTotaldesv1() {
		return Totaldesv1;
	}
	/**
	 * @param totaldesv1 The totaldesv1 to set.
	 */
	public void setTotaldesv1(int totaldesv1) {
		Totaldesv1 = totaldesv1;
	}
	/**
	 * @return Returns the totaldesv2.
	 */
	public int getTotaldesv2() {
		return Totaldesv2;
	}
	/**
	 * @param totaldesv2 The totaldesv2 to set.
	 */
	public void setTotaldesv2(int totaldesv2) {
		Totaldesv2 = totaldesv2;
	}

	
	/**
	 * @return Returns the totalcompGestor.
	 */
	public int getTotalcompGestor() {
		return TotalcompGestor;
	}
	/**
	 * @param totalcompGestor The totalcompGestor to set.
	 */
	public void setTotalcompGestor(int totalcompGestor) {
		TotalcompGestor = totalcompGestor;
	}
	/**
	 * @return Returns the totalmonto1.
	 */
	public int getTotalmonto1() {
		return Totalmonto1;
	}
	/**
	 * @param totalmonto1 The totalmonto1 to set.
	 */
	public void setTotalmonto1(int totalmonto1) {
		Totalmonto1 = totalmonto1;
	}
	/**
	 * @return Returns the totalmonto2.
	 */
	public int getTotalmonto2() {
		return Totalmonto2;
	}
	/**
	 * @param totalmonto2 The totalmonto2 to set.
	 */
	public void setTotalmonto2(int totalmonto2) {
		Totalmonto2 = totalmonto2;
	}
	/**
	 * @return Returns the totalnumeroCliente.
	 */
	public int getTotalnumeroCliente() {
		return TotalnumeroCliente;
	}
	/**
	 * @param totalnumeroCliente The totalnumeroCliente to set.
	 */
	public void setTotalnumeroCliente(int totalnumeroCliente) {
		TotalnumeroCliente = totalnumeroCliente;
	}
	/**
	 * @return Returns the totalnumeroConcr1.
	 */
	public int getTotalnumeroConcr1() {
		return TotalnumeroConcr1;
	}
	/**
	 * @param totalnumeroConcr1 The totalnumeroConcr1 to set.
	 */
	public void setTotalnumeroConcr1(int totalnumeroConcr1) {
		TotalnumeroConcr1 = totalnumeroConcr1;
	}
	/**
	 * @return Returns the totalnumeroConcr2.
	 */
	public int getTotalnumeroConcr2() {
		return TotalnumeroConcr2;
	}
	/**
	 * @param totalnumeroConcr2 The totalnumeroConcr2 to set.
	 */
	public void setTotalnumeroConcr2(int totalnumeroConcr2) {
		TotalnumeroConcr2 = totalnumeroConcr2;
	}
	/**
	 * @return Returns the totalnumeroGest1.
	 */
	public int getTotalnumeroGest1() {
		return TotalnumeroGest1;
	}
	/**
	 * @param totalnumeroGest1 The totalnumeroGest1 to set.
	 */
	public void setTotalnumeroGest1(int totalnumeroGest1) {
		TotalnumeroGest1 = totalnumeroGest1;
	}
	/**
	 * @return Returns the totalnumeroGest2.
	 */
	public int getTotalnumeroGest2() {
		return TotalnumeroGest2;
	}
	/**
	 * @param totalnumeroGest2 The totalnumeroGest2 to set.
	 */
	public void setTotalnumeroGest2(int totalnumeroGest2) {
		TotalnumeroGest2 = totalnumeroGest2;
	}


	/**
	 * @return Returns the anoPlan.
	 */
	public String getAnoPlan() {
		return anoPlan;
	}
	/**
	 * @param anoPlan The anoPlan to set.
	 */
	public void setAnoPlan(String anoPlan) {
		this.anoPlan = anoPlan;
	}
	/**
	 * @return Returns the codAccion.
	 */
	public String getCodAccion() {
		return codAccion;
	}
	/**
	 * @param codAccion The codAccion to set.
	 */
	public void setCodAccion(String codAccion) {
		this.codAccion = codAccion;
	}
	/**
	 * @return Returns the codEpigrafe.
	 */
	public String getCodEpigrafe() {
		return codEpigrafe;
	}
	/**
	 * @param codEpigrafe The codEpigrafe to set.
	 */
	public void setCodEpigrafe(String codEpigrafe) {
		this.codEpigrafe = codEpigrafe;
	}
	/**
	 * @return Returns the codGestor.
	 */
	public String getCodGestor() {
		return codGestor;
	}
	/**
	 * @param codGestor The codGestor to set.
	 */
	public void setCodGestor(String codGestor) {
		this.codGestor = codGestor;
	}
	/**
	 * @return Returns the codOficina.
	 */
	public String getCodOficina() {
		return codOficina;
	}
	/**
	 * @param codOficina The codOficina to set.
	 */
	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}
	/**
	 * @return Returns the compGestor.
	 */
	public String getCompGestor() {
		return compGestor;
	}
	/**
	 * @param compGestor The compGestor to set.
	 */
	public void setCompGestor(String compGestor) {
		this.compGestor = compGestor;
	}
	/**
	 * @return Returns the indAfecta.
	 */
	public String getIndAfecta() {
		return indAfecta;
	}
	/**
	 * @param indAfecta The indAfecta to set.
	 */
	public void setIndAfecta(String indAfecta) {
		this.indAfecta = indAfecta;
	}
	/**
	 * @return Returns the mesPlan.
	 */
	public String getMesPlan() {
		return mesPlan;
	}
	/**
	 * @param mesPlan The mesPlan to set.
	 */
	public void setMesPlan(String mesPlan) {
		this.mesPlan = mesPlan;
	}
	/**
	 * @return Returns the metGestOficina.
	 */
	public String getMetGestOficina() {
		return metGestOficina;
	}
	/**
	 * @param metGestOficina The metGestOficina to set.
	 */
	public void setMetGestOficina(String metGestOficina) {
		this.metGestOficina = metGestOficina;
	}
	/**
	 * @return Returns the metMesSaldPuntual.
	 */
	public String getMetMesSaldPuntual() {
		return metMesSaldPuntual;
	}
	/**
	 * @param metMesSaldPuntual The metMesSaldPuntual to set.
	 */
	public void setMetMesSaldPuntual(String metMesSaldPuntual) {
		this.metMesSaldPuntual = metMesSaldPuntual;
	}
	/**
	 * @return Returns the montSeg1.
	 */
	public String getMontSeg1() {
		return montSeg1;
	}
	/**
	 * @param montSeg1 The montSeg1 to set.
	 */
	public void setMontSeg1(String montSeg1) {
		this.montSeg1 = montSeg1;
	}
	/**
	 * @return Returns the montSeg1_1.
	 */
	public String getMontSeg1_1() {
		return montSeg1_1;
	}
	/**
	 * @param montSeg1_1 The montSeg1_1 to set.
	 */
	public void setMontSeg1_1(String montSeg1_1) {
		this.montSeg1_1 = montSeg1_1;
	}
	/**
	 * @return Returns the nomAccion.
	 */
	public String getNomAccion() {
		return nomAccion;
	}
	/**
	 * @param nomAccion The nomAccion to set.
	 */
	public void setNomAccion(String nomAccion) {
		this.nomAccion = nomAccion;
	}
	/**
	 * @return Returns the nomEpigrafe.
	 */
	public String getNomEpigrafe() {
		return nomEpigrafe;
	}
	/**
	 * @param nomEpigrafe The nomEpigrafe to set.
	 */
	public void setNomEpigrafe(String nomEpigrafe) {
		this.nomEpigrafe = nomEpigrafe;
	}
	/**
	 * @return Returns the nroCliente.
	 */
	public String getNroCliente() {
		return nroCliente;
	}
	/**
	 * @param nroCliente The nroCliente to set.
	 */
	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}
	/**
	 * @return Returns the nroConcSeg1.
	 */
	public String getNroConcSeg1() {
		return nroConcSeg1;
	}
	/**
	 * @param nroConcSeg1 The nroConcSeg1 to set.
	 */
	public void setNroConcSeg1(String nroConcSeg1) {
		this.nroConcSeg1 = nroConcSeg1;
	}
	/**
	 * @return Returns the nroConcSeg2.
	 */
	public String getNroConcSeg2() {
		return nroConcSeg2;
	}
	/**
	 * @param nroConcSeg2 The nroConcSeg2 to set.
	 */
	public void setNroConcSeg2(String nroConcSeg2) {
		this.nroConcSeg2 = nroConcSeg2;
	}
	/**
	 * @return Returns the nroGestSeg1.
	 */
	public String getNroGestSeg1() {
		return nroGestSeg1;
	}
	/**
	 * @param nroGestSeg1 The nroGestSeg1 to set.
	 */
	public void setNroGestSeg1(String nroGestSeg1) {
		this.nroGestSeg1 = nroGestSeg1;
	}
	/**
	 * @return Returns the nroGestSeg2.
	 */
	public String getNroGestSeg2() {
		return nroGestSeg2;
	}
	/**
	 * @param nroGestSeg2 The nroGestSeg2 to set.
	 */
	public void setNroGestSeg2(String nroGestSeg2) {
		this.nroGestSeg2 = nroGestSeg2;
	}
	/**
	 * @return Returns the porAsignado.
	 */
	public String getPorAsignado() {
		return porAsignado;
	}
	/**
	 * @param porAsignado The porAsignado to set.
	 */
	public void setPorAsignado(String porAsignado) {
		this.porAsignado = porAsignado;
	}
	/**
	 * @return Returns the prioridad.
	 */
	public String getPrioridad() {
		return prioridad;
	}
	/**
	 * @param prioridad The prioridad to set.
	 */
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	public boolean isResumenPorEpigrafe() {
		return resumenPorEpigrafe;
	}
	public void setResumenPorEpigrafe(boolean resumenPorEpigrafe) {
		this.resumenPorEpigrafe = resumenPorEpigrafe;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	
}
