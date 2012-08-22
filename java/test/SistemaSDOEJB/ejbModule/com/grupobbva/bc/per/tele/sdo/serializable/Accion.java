package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Accion implements Serializable{

	int TotalClientes;
	int numeroGestiones1;
	int numeroConcretados1;
	int monto1;	
	int numeroGestiones2;
	int numeroConcretados2;
	int monto2;	
	int totalNumeroGestiones;
	int totalNumeroConcretados;
	int totalMonto;
	int totalCompGestor;
	int estado;
	
	String nomCampania;
	String porc_asig;
	String Anho;
	String codEpigrafe;
	String orden;
	String nomEpigrafe;
	String codAccion;	
	String nomAccion;
	String numeroCliente;
	String compGestor;	
	String fec_segu_1;
	String fec_segu_1_camp_det;
	String fec_segu_2;
	String fec_segu_2_camp_det;
	String codOficina;
	String codGestor;
	String fec_regi;
	String fec_regi_Acc;
	
	/**
	 * @return Returns the anho.
	 */
	public String getAnho() {
		return Anho;
	}
	/**
	 * @param anho The anho to set.
	 */
	public void setAnho(String anho) {
		Anho = anho;
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
	 * @return Returns the monto1.
	 */
	public int getMonto1() {
		return monto1;
	}
	/**
	 * @param monto1 The monto1 to set.
	 */
	public void setMonto1(int monto1) {
		this.monto1 = monto1;
	}
	/**
	 * @return Returns the monto2.
	 */
	public int getMonto2() {
		return monto2;
	}
	/**
	 * @param monto2 The monto2 to set.
	 */
	public void setMonto2(int monto2) {
		this.monto2 = monto2;
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
	 * @return Returns the numeroCliente.
	 */
	public String getNumeroCliente() {
		return numeroCliente;
	}
	/**
	 * @param numeroCliente The numeroCliente to set.
	 */
	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	/**
	 * @return Returns the numeroConcretados1.
	 */
	public int getNumeroConcretados1() {
		return numeroConcretados1;
	}
	/**
	 * @param numeroConcretados1 The numeroConcretados1 to set.
	 */
	public void setNumeroConcretados1(int numeroConcretados1) {
		this.numeroConcretados1 = numeroConcretados1;
	}
	/**
	 * @return Returns the numeroConcretados2.
	 */
	public int getNumeroConcretados2() {
		return numeroConcretados2;
	}
	/**
	 * @param numeroConcretados2 The numeroConcretados2 to set.
	 */
	public void setNumeroConcretados2(int numeroConcretados2) {
		this.numeroConcretados2 = numeroConcretados2;
	}
	/**
	 * @return Returns the numeroGestiones1.
	 */
	public int getNumeroGestiones1() {
		return numeroGestiones1;
	}
	/**
	 * @param numeroGestiones1 The numeroGestiones1 to set.
	 */
	public void setNumeroGestiones1(int numeroGestiones1) {
		this.numeroGestiones1 = numeroGestiones1;
	}
	/**
	 * @return Returns the numeroGestiones2.
	 */
	public int getNumeroGestiones2() {
		return numeroGestiones2;
	}
	/**
	 * @param numeroGestiones2 The numeroGestiones2 to set.
	 */
	public void setNumeroGestiones2(int numeroGestiones2) {
		this.numeroGestiones2 = numeroGestiones2;
	}
	/**
	 * @return Returns the totalMonto.
	 */
	public int getTotalMonto() {
		return totalMonto;
	}
	/**
	 * @param totalMonto The totalMonto to set.
	 */
	public void setTotalMonto(int totalMonto) {
		this.totalMonto = totalMonto;
	}
	/**
	 * @return Returns the totalNumeroConcretados.
	 */
	public int getTotalNumeroConcretados() {
		return totalNumeroConcretados;
	}
	/**
	 * @param totalNumeroConcretados The totalNumeroConcretados to set.
	 */
	public void setTotalNumeroConcretados(int totalNumeroConcretados) {
		this.totalNumeroConcretados = totalNumeroConcretados;
	}
	/**
	 * @return Returns the totalNumeroGestiones.
	 */
	public int getTotalNumeroGestiones() {
		return totalNumeroGestiones;
	}
	/**
	 * @param totalNumeroGestiones The totalNumeroGestiones to set.
	 */
	public void setTotalNumeroGestiones(int totalNumeroGestiones) {
		this.totalNumeroGestiones = totalNumeroGestiones;
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
	 * @return Returns the fec_regi.
	 */
	public String getFec_regi() {
		return fec_regi;
	}
	/**
	 * @param fec_regi The fec_regi to set.
	 */
	public void setFec_regi(String fec_regi) {
		this.fec_regi = fec_regi;
	}
	/**
	 * @return Returns the fec_regi_Acc.
	 */
	public String getFec_regi_Acc() {
		return fec_regi_Acc;
	}
	/**
	 * @param fec_regi_Acc The fec_regi_Acc to set.
	 */
	public void setFec_regi_Acc(String fec_regi_Acc) {
		this.fec_regi_Acc = fec_regi_Acc;
	}
	/**
	 * @return Returns the fec_segu_1.
	 */
	public String getFec_segu_1() {
		return fec_segu_1;
	}
	/**
	 * @param fec_segu_1 The fec_segu_1 to set.
	 */
	public void setFec_segu_1(String fec_segu_1) {
		this.fec_segu_1 = fec_segu_1;
	}
	/**
	 * @return Returns the fec_segu_1_camp_det.
	 */
	public String getFec_segu_1_camp_det() {
		return fec_segu_1_camp_det;
	}
	/**
	 * @param fec_segu_1_camp_det The fec_segu_1_camp_det to set.
	 */
	public void setFec_segu_1_camp_det(String fec_segu_1_camp_det) {
		this.fec_segu_1_camp_det = fec_segu_1_camp_det;
	}
	/**
	 * @return Returns the fec_segu_2.
	 */
	public String getFec_segu_2() {
		return fec_segu_2;
	}
	/**
	 * @param fec_segu_2 The fec_segu_2 to set.
	 */
	public void setFec_segu_2(String fec_segu_2) {
		this.fec_segu_2 = fec_segu_2;
	}
	/**
	 * @return Returns the fec_segu_2_camp_det.
	 */
	public String getFec_segu_2_camp_det() {
		return fec_segu_2_camp_det;
	}
	/**
	 * @param fec_segu_2_camp_det The fec_segu_2_camp_det to set.
	 */
	public void setFec_segu_2_camp_det(String fec_segu_2_camp_det) {
		this.fec_segu_2_camp_det = fec_segu_2_camp_det;
	}
	/**
	 * @return Returns the nomCampania.
	 */
	public String getNomCampania() {
		return nomCampania;
	}
	/**
	 * @param nomCampania The nomCampania to set.
	 */
	public void setNomCampania(String nomCampania) {
		this.nomCampania = nomCampania;
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
	 * @return Returns the orden.
	 */
	public String getOrden() {
		return orden;
	}
	/**
	 * @param orden The orden to set.
	 */
	public void setOrden(String orden) {
		this.orden = orden;
	}
	/**
	 * @return Returns the porc_asig.
	 */
	public String getPorc_asig() {
		return porc_asig;
	}
	/**
	 * @param porc_asig The porc_asig to set.
	 */
	public void setPorc_asig(String porc_asig) {
		this.porc_asig = porc_asig;
	}
	/**
	 * @return Returns the totalClientes.
	 */
	public int getTotalClientes() {
		return TotalClientes;
	}
	/**
	 * @param totalClientes The totalClientes to set.
	 */
	public void setTotalClientes(int totalClientes) {
		TotalClientes = totalClientes;
	}
	/**
	 * @return Returns the totalCompGestor.
	 */
	public int getTotalCompGestor() {
		return totalCompGestor;
	}
	/**
	 * @param totalCompGestor The totalCompGestor to set.
	 */
	public void setTotalCompGestor(int totalCompGestor) {
		this.totalCompGestor = totalCompGestor;
	}
	/**
	 * @return Returns the estado.
	 */
	public int getEstado() {
		return estado;
	}
	/**
	 * @param estado The estado to set.
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}
}
