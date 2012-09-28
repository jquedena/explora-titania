package com.indra.pe.bbva.reauni.view.mbean;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.ldap.model.entidad.LdapDto;
import com.indra.pe.bbva.reauni.model.entidad.OperacionCentralizadaDto;
import com.indra.pe.bbva.reauni.model.entidad.PerfilDto;
import com.indra.pe.bbva.reauni.util.Constantes;

@Controller("sessionMBean")
@Scope("session")
public class SessionMBean {	
	
	private String registro;	
	private String codCargo;
	private String desCargo;
	private String nombresApellidos;
	private String codOficina;
	private String desOficina;
	private String codTerritorio;
	private String desTerritorio;
	private String email;
	
	private List<OperacionCentralizadaDto> productosOperacionesCentralizadas;
	private Boolean fechaCorte;
	private String mensajeFechaCorte;
	private int cantidadRestante;
	
	private Boolean esGerenteTerritorial;
	
	public List<OperacionCentralizadaDto> getProductosOperacionesCentralizadas() {
		return productosOperacionesCentralizadas;
	}

	public void setProductosOperacionesCentralizadas(
			List<OperacionCentralizadaDto> productosOperacionesCentralizadas) {
		this.productosOperacionesCentralizadas = productosOperacionesCentralizadas;
	}

	public String getCodTerritorio() {
		return codTerritorio;
	}

	public void setCodTerritorio(String codTerritorio) {
		this.codTerritorio = codTerritorio;
	}

	public String getDesTerritorio() {
		return desTerritorio;
	}

	public void setDesTerritorio(String desTerritorio) {
		this.desTerritorio = desTerritorio;
	}

	private int accion = 0;// 0 Listar 1:nuevo 2:editar 3:ver
	private int cantidadRegistros = 10;
	private Long tipoAcceso = 0L; // 0:Cargo 1:Registro
	private int editable = 0; 
	
	public PerfilDto perfilDto; //
	private LdapDto usuarioLdapSesion; //Usuario Session
	
	

	public String tema = "redmond";
	public String titulo;
	
	public SessionMBean() {
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodCargo() {
		return codCargo;
	}

	public  void setCodCargo(String codCargo) {
		this.codCargo = codCargo;
	}

	public String getDesCargo() {
		return desCargo;
	}

	public void setDesCargo(String desCargo) {
		this.desCargo = desCargo;
	}

	public String getRegistro() {
		return registro;
	}
	
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
	public String getNombresApellidos() {
		return nombresApellidos;
	}
	
	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public PerfilDto getPerfilDto() {
		return perfilDto;
	}

	public void setPerfilDto(PerfilDto perfilDto) {
		this.perfilDto = perfilDto;
	}
	
	public int getAccion() {
		return accion;
	}

	public void setAccion(int accion) {
		this.accion = accion;
	}

	public int getCantidadRegistros() {
		return cantidadRegistros;
	}

	public void setCantidadRegistros(int cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}

	public Long getTipoAcceso() {
		return tipoAcceso;
	}

	public void setTipoAcceso(Long tipoAcceso) {
		this.tipoAcceso = tipoAcceso;
	}

	public String getCodOficina() {
		return codOficina;
	}

	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}

	public String getDesOficina() {
		return desOficina;
	}

	public void setDesOficina(String desOficina) {
		this.desOficina = desOficina;
	}

	public int getEditable() {
		return editable;
	}

	public void setEditable(int editable) {
		this.editable = editable;
	}

	public LdapDto getUsuarioLdapSesion() {
		return usuarioLdapSesion;
	}

	public void setUsuarioLdapSesion(LdapDto usuarioLdapSesion) {
		this.usuarioLdapSesion = usuarioLdapSesion;
	}

	public Boolean getFechaCorte() {
		return fechaCorte;
	}

	public void setFechaCorte(Boolean fechaCorte) {
		this.fechaCorte = fechaCorte;
	}

	public String getMensajeFechaCorte() {
		return mensajeFechaCorte;
	}

	public void setMensajeFechaCorte(String mensajeFechaCorte) {
		this.mensajeFechaCorte = mensajeFechaCorte;
	}

	public int getCantidadRestante() {
		return cantidadRestante;
	}

	public void setCantidadRestante(int cantidadRestante) {
		this.cantidadRestante = cantidadRestante;
	}

	public Boolean getEsGerenteTerritorial() {
		if (this.getCodCargo().equals("CH1")||this.getCodCargo().equals("CH6")||this.getCodCargo().equals("OS8")) {
			this.esGerenteTerritorial=Boolean.TRUE;
		} else {
			if(this.perfilDto.getId() == 3) {
				this.esGerenteTerritorial=Boolean.TRUE;	
			} else {
				this.esGerenteTerritorial=Boolean.FALSE;
			}
		}
		return esGerenteTerritorial;
	}
	
	public int getRol() {
		int tipoPerfil;
		
		if(perfilDto.getId() == 5) {
			tipoPerfil = Constantes.Rol.ADM;
		} else if (perfilDto.getId() == 3) {
			tipoPerfil = Constantes.Rol.GTE;
		} else {
			tipoPerfil = Constantes.Rol.GOF;
		}
		
		return tipoPerfil;
	}    
}
