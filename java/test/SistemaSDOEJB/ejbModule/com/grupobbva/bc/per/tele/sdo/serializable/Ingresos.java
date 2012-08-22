package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Ingresos implements Serializable{
		
	String usuario;
	String nombreUsuario;
	String cargo;
	String nomTerritorio;
	String cod_oficina;
	String nom_oficina;
	String fecha;
	String mes;
	String anio;
	int totalIngreso;
	int planificacion;		
	int objetivos;
	int acciones;
	int seguimiento1;
	int seguimiento2;
	int total;
	int tipo;
	
	int contVeces;
	int contvalidoVeces;
	String Veces;
	String Valido_veces;
	int contGenVeces;
	int contGenvalidoVeces;
	int totalForms;
	
	int contPlanificacion;
	int contObjetivos;
	int contAcciones;
	int contSeguimiento1;
	int contSeguimiento2;
	int contTotalForms;
	
	int contGenPlanificacion;
	int contGenObjetivos;
	int contGenAcciones;
	int contGenSeguimiento1;
	int contGenSeguimiento2;
	int contGenTotalForms;
	
	/**
	 * @return Returns the contAcciones.
	 */
	public int getContAcciones() {
		return contAcciones;
	}
	/**
	 * @param contAcciones The contAcciones to set.
	 */
	public void setContAcciones(int contAcciones) {
		this.contAcciones = contAcciones;
	}
	/**
	 * @return Returns the contGenAcciones.
	 */
	public int getContGenAcciones() {
		return contGenAcciones;
	}
	/**
	 * @param contGenAcciones The contGenAcciones to set.
	 */
	public void setContGenAcciones(int contGenAcciones) {
		this.contGenAcciones = contGenAcciones;
	}
	/**
	 * @return Returns the contGenObjetivos.
	 */
	public int getContGenObjetivos() {
		return contGenObjetivos;
	}
	/**
	 * @param contGenObjetivos The contGenObjetivos to set.
	 */
	public void setContGenObjetivos(int contGenObjetivos) {
		this.contGenObjetivos = contGenObjetivos;
	}
	/**
	 * @return Returns the contGenPlanificacion.
	 */
	public int getContGenPlanificacion() {
		return contGenPlanificacion;
	}
	/**
	 * @param contGenPlanificacion The contGenPlanificacion to set.
	 */
	public void setContGenPlanificacion(int contGenPlanificacion) {
		this.contGenPlanificacion = contGenPlanificacion;
	}
	/**
	 * @return Returns the contGenSeguimiento1.
	 */
	public int getContGenSeguimiento1() {
		return contGenSeguimiento1;
	}
	/**
	 * @param contGenSeguimiento1 The contGenSeguimiento1 to set.
	 */
	public void setContGenSeguimiento1(int contGenSeguimiento1) {
		this.contGenSeguimiento1 = contGenSeguimiento1;
	}
	/**
	 * @return Returns the contGenSeguimiento2.
	 */
	public int getContGenSeguimiento2() {
		return contGenSeguimiento2;
	}
	/**
	 * @param contGenSeguimiento2 The contGenSeguimiento2 to set.
	 */
	public void setContGenSeguimiento2(int contGenSeguimiento2) {
		this.contGenSeguimiento2 = contGenSeguimiento2;
	}
	/**
	 * @return Returns the contGenTotalForms.
	 */
	public int getContGenTotalForms() {
		return contGenTotalForms;
	}
	/**
	 * @param contGenTotalForms The contGenTotalForms to set.
	 */
	public void setContGenTotalForms(int contGenTotalForms) {
		this.contGenTotalForms = contGenTotalForms;
	}
	/**
	 * @return Returns the contObjetivos.
	 */
	public int getContObjetivos() {
		return contObjetivos;
	}
	/**
	 * @param contObjetivos The contObjetivos to set.
	 */
	public void setContObjetivos(int contObjetivos) {
		this.contObjetivos = contObjetivos;
	}
	/**
	 * @return Returns the contPlanificacion.
	 */
	public int getContPlanificacion() {
		return contPlanificacion;
	}
	/**
	 * @param contPlanificacion The contPlanificacion to set.
	 */
	public void setContPlanificacion(int contPlanificacion) {
		this.contPlanificacion = contPlanificacion;
	}
	/**
	 * @return Returns the contSeguimiento1.
	 */
	public int getContSeguimiento1() {
		return contSeguimiento1;
	}
	/**
	 * @param contSeguimiento1 The contSeguimiento1 to set.
	 */
	public void setContSeguimiento1(int contSeguimiento1) {
		this.contSeguimiento1 = contSeguimiento1;
	}
	/**
	 * @return Returns the contSeguimiento2.
	 */
	public int getContSeguimiento2() {
		return contSeguimiento2;
	}
	/**
	 * @param contSeguimiento2 The contSeguimiento2 to set.
	 */
	public void setContSeguimiento2(int contSeguimiento2) {
		this.contSeguimiento2 = contSeguimiento2;
	}
	/**
	 * @return Returns the contTotalForms.
	 */
	public int getContTotalForms() {
		return contTotalForms;
	}
	/**
	 * @param contTotalForms The contTotalForms to set.
	 */
	public void setContTotalForms(int contTotalForms) {
		this.contTotalForms = contTotalForms;
	}
	
	
	/**
	 * @return Returns the cargo.
	 */
	public String getCargo() {
		return cargo;
	}
	/**
	 * @param cargo The cargo to set.
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	/**
	 * @return Returns the cod_oficina.
	 */
	public String getCod_oficina() {
		return cod_oficina;
	}
	/**
	 * @param cod_oficina The cod_oficina to set.
	 */
	public void setCod_oficina(String cod_oficina) {
		this.cod_oficina = cod_oficina;
	}
	/**
	 * @return Returns the fecha.
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha The fecha to set.
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
	 * @return Returns the usuario.
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario The usuario to set.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return Returns the contvalidoVeces.
	 */
	public int getContvalidoVeces() {
		return contvalidoVeces;
	}
	/**
	 * @param contvalidoVeces The contvalidoVeces to set.
	 */
	public void setContvalidoVeces(int contvalidoVeces) {
		this.contvalidoVeces = contvalidoVeces;
	}
	/**
	 * @return Returns the contVeces.
	 */
	public int getContVeces() {
		return contVeces;
	}
	/**
	 * @param contVeces The contVeces to set.
	 */
	public void setContVeces(int contVeces) {
		this.contVeces = contVeces;
	}

	/**
	 * @return Returns the veces.
	 */
	public String getVeces() {
		return Veces;
	}
	/**
	 * @param veces The veces to set.
	 */
	public void setVeces(String veces) {
		Veces = veces;
	}
	/**
	 * @return Returns the valido_veces.
	 */
	public String getValido_veces() {
		return Valido_veces;
	}
	/**
	 * @param valido_veces The valido_veces to set.
	 */
	public void setValido_veces(String valido_veces) {
		Valido_veces = valido_veces;
	}
	/**
	 * @return Returns the contGenvalidoVeces.
	 */
	public int getContGenvalidoVeces() {
		return contGenvalidoVeces;
	}
	/**
	 * @param contGenvalidoVeces The contGenvalidoVeces to set.
	 */
	public void setContGenvalidoVeces(int contGenvalidoVeces) {
		this.contGenvalidoVeces = contGenvalidoVeces;
	}
	/**
	 * @return Returns the contGenVeces.
	 */
	public int getContGenVeces() {
		return contGenVeces;
	}
	/**
	 * @param contGenVeces The contGenVeces to set.
	 */
	public void setContGenVeces(int contGenVeces) {
		this.contGenVeces = contGenVeces;
	}
	/**
	 * @return Returns the acciones.
	 */
	public int getAcciones() {
		return acciones;
	}
	/**
	 * @param acciones The acciones to set.
	 */
	public void setAcciones(int acciones) {
		this.acciones = acciones;
	}
	/**
	 * @return Returns the objetivos.
	 */
	public int getObjetivos() {
		return objetivos;
	}
	/**
	 * @param objetivos The objetivos to set.
	 */
	public void setObjetivos(int objetivos) {
		this.objetivos = objetivos;
	}
	/**
	 * @return Returns the seguimiento1.
	 */
	public int getSeguimiento1() {
		return seguimiento1;
	}
	/**
	 * @param seguimiento1 The seguimiento1 to set.
	 */
	public void setSeguimiento1(int seguimiento1) {
		this.seguimiento1 = seguimiento1;
	}
	/**
	 * @return Returns the seguimiento2.
	 */
	public int getSeguimiento2() {
		return seguimiento2;
	}
	/**
	 * @param seguimiento2 The seguimiento2 to set.
	 */
	public void setSeguimiento2(int seguimiento2) {
		this.seguimiento2 = seguimiento2;
	}
	
	/**
	 * @return Returns the planificacion.
	 */
	public int getPlanificacion() {
		return planificacion;
	}
	/**
	 * @param planificacion The planificacion to set.
	 */
	public void setPlanificacion(int planificacion) {
		this.planificacion = planificacion;
	}
	/**
	 * @return Returns the nom_oficina.
	 */
	public String getNom_oficina() {
		return nom_oficina;
	}
	/**
	 * @param nom_oficina The nom_oficina to set.
	 */
	public void setNom_oficina(String nom_oficina) {
		this.nom_oficina = nom_oficina;
	}
	/**
	 * @return Returns the totalForms.
	 */
	public int getTotalForms() {
		return totalForms;
	}
	/**
	 * @param totalForms The totalForms to set.
	 */
	public void setTotalForms(int totalForms) {
		this.totalForms = totalForms;
	}
	/**
	 * @return Returns the nombreUsuario.
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param nombreUsuario The nombreUsuario to set.
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	/**
	 * @return Returns the anio.
	 */
	public String getAnio() {
		return anio;
	}
	/**
	 * @param anio The anio to set.
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}
	/**
	 * @return Returns the mes.
	 */
	public String getMes() {
		return mes;
	}
	/**
	 * @param mes The mes to set.
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}
	/**
	 * @return Returns the totalIngreso.
	 */
	public int getTotalIngreso() {
		return totalIngreso;
	}
	/**
	 * @param totalIngreso The totalIngreso to set.
	 */
	public void setTotalIngreso(int totalIngreso) {
		this.totalIngreso = totalIngreso;
	}
	/**
	 * @return Returns the total.
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total The total to set.
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return Returns the tipo.
	 */
	public int getTipo() {
		return tipo;
	}
	/**
	 * @param tipo The tipo to set.
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
