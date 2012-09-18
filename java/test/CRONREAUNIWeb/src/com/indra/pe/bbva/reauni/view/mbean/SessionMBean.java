package com.indra.pe.bbva.reauni.view.mbean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.reauni.model.entidad.PerfilDto;

@Controller("sessionMBean")
@Scope("session")
public class SessionMBean {	
	
	public static String registro;	
	public static String codCargo;
	public static String desCargo;
	public static String nombresApellidos;
	public static int ACCION = 0;// 0 Listar 1:nuevo 2:editar 3:ver
	public static int CANTIDAD_REGISTROS = 10;
	private String formatoFecha = "dd/MM/yyyy";
	private String formatoHora = "HH:mm:ss";
	
	public static PerfilDto perfilDto;

	public static String tema = "redmond";
	public static String titulo;
	
	public SessionMBean() {
	}

	public String getCodCargo() {
		return codCargo;
	}

	public  void setCodCargo(String codCargo) {
		SessionMBean.codCargo = codCargo;
	}

	public String getDesCargo() {
		return desCargo;
	}

	public void setDesCargo(String desCargo) {
		SessionMBean.desCargo = desCargo;
	}

	public String getRegistro() {
		return registro;
	}
	
	public void setRegistro(String registro) {
		SessionMBean.registro = registro;
	}
	
	public String getNombresApellidos() {
		return nombresApellidos;
	}
	
	public void setNombresApellidos(String nombresApellidos) {
		SessionMBean.nombresApellidos = nombresApellidos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		SessionMBean.titulo = titulo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		SessionMBean.tema = tema;
	}

	public PerfilDto getPerfilDto() {
		return perfilDto;
	}

	public void setPerfilDto(PerfilDto perfilDto) {
		SessionMBean.perfilDto = perfilDto;
	}
	
	public int getCANTIDAD_REGISTROS() {
		return CANTIDAD_REGISTROS;
	}

	public void setCANTIDAD_REGISTROS(int cANTIDAD_REGISTROS) {
		CANTIDAD_REGISTROS = cANTIDAD_REGISTROS;
	}
	

    public int getACCION() {
        return ACCION;
    }

    public void setACCION(int ACCION) {
        SessionMBean.ACCION = ACCION;
    }

	public String getFormatoFecha() {
		return formatoFecha;
	}

	public void setFormatoFecha(String formatoFecha) {
		this.formatoFecha = formatoFecha;
	}

	public String getFormatoHora() {
		return formatoHora;
	}

	public void setFormatoHora(String formatoHora) {
		this.formatoHora = formatoHora;
	}


    
    
}
