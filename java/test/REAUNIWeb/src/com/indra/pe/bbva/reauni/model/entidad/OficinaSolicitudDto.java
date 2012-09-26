package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.util.Utilitarios;
import com.indra.pe.bbva.reauni.view.mbean.SessionMBean;

@Entity
@Table(name = "TREAUNI_OFICINA_SOLICITUD", schema = "REAUNI")
public class OficinaSolicitudDto implements Serializable {

	private static Logger logger = Logger.getLogger(OficinaSolicitudDto.class);
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_OFICINA_SOLICITUD")
	@TableGenerator(name = "SEQ_OFICINA_SOLICITUD", schema = "REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_OFICINA_SOLICITUD", allocationSize = 1)
	private Long id;

	@JoinColumn(name = "CODIGO_OFICINA", referencedColumnName = "COD_OFICINA")
	@ManyToOne(fetch = FetchType.LAZY)
	@LazyToOne(LazyToOneOption.FALSE)
	private OficinaDto oficinaDto;

	@JoinColumn(name = "TIPO_OFICINA", referencedColumnName = "ID")
	@ManyToOne
	private ParametroDto tipoOficinaDto;

	@Column(name = "TIPO_OFICINA", insertable = false, nullable = true, updatable = false)
	private Long tipoOficina;

	@Column(name = "TOTAL_PASIVO")
	private BigDecimal totalPasivo;
	
	@Column(name = "TOTAL_ACTIVO")
	private BigDecimal totalActivo;
	
	@Column(name = "ESTADO_EVALUACION")
	private Boolean estadoEvaluacion;
	
	@Column(name = "USUARIO_EVALUACION")
	private String usuarioEvaluacion;
	
	@Column(name = "FECHA_EVALUACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEvaluacion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "oficinaSolicitudDto")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<OficinaInvolucradoDto> listaInvolucrados;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "oficinaSolicitudDto", fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ContratoDto> listaContratos;

	@JoinColumn(name = "SOLICITUD", referencedColumnName = "ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private SolicitudDto solicitudDto;

	@JoinColumn(name = "ESTADO_APROBACION_AJU_BON", referencedColumnName = "ID")
	@ManyToOne
	private ParametroDto estadoAprobacionAjuBonDto;

	@Transient
	private Boolean habilitarEvaluacion;

	@Column(name = "SILENCIO_ADMINISTRATIVO")
	private Boolean silencioAdministrativo;

	@Column(name = "ENVIO_GESTION_FILE")
	private BigDecimal envioGestionFile;
	
	@Column(name = "FECHA_ENVIO_GESTION_FILE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEnvioGestionFile;

	public OficinaSolicitudDto() {
	}

	public OficinaSolicitudDto(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotalPasivo() {
		return totalPasivo;
	}

	public void setTotalPasivo(BigDecimal totalPasivo) {
		this.totalPasivo = totalPasivo;
	}

	public BigDecimal getTotalActivo() {
		return totalActivo;
	}

	public void setTotalActivo(BigDecimal totalActivo) {
		this.totalActivo = totalActivo;
	}

	public Boolean getEstadoEvaluacion() {
		return estadoEvaluacion;
	}

	public void setEstadoEvaluacion(Boolean estadoEvaluacion) {
		this.estadoEvaluacion = estadoEvaluacion;
	}

	public String getUsuarioEvaluacion() {
		return usuarioEvaluacion;
	}

	public void setUsuarioEvaluacion(String usuarioEvaluacion) {
		this.usuarioEvaluacion = usuarioEvaluacion;
	}

	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	public SolicitudDto getSolicitudDto() {
		return solicitudDto;
	}

	public void setSolicitudDto(SolicitudDto solicitudDto) {
		this.solicitudDto = solicitudDto;
	}

	public List<OficinaInvolucradoDto> getListaInvolucrados() {
		if (this.listaInvolucrados == null)
			this.listaInvolucrados = new ArrayList<OficinaInvolucradoDto>();
		Utilitarios.General.ordena(this.listaInvolucrados, "orden");
		return listaInvolucrados;
	}

	public void setListaInvolucrados(
			List<OficinaInvolucradoDto> listaInvolucrados) {
		this.listaInvolucrados = listaInvolucrados;
	}

	public List<ContratoDto> getListaContratos() {
		if (this.listaContratos == null)
			this.listaContratos = new ArrayList<ContratoDto>();
		Utilitarios.General.ordena(this.listaContratos, "codigoContrato");
		return listaContratos;
	}

	public void setListaContratos(List<ContratoDto> listaContratos) {
		this.listaContratos = listaContratos;
	}

	public OficinaDto getOficinaDto() {
		return oficinaDto;
	}

	public void setOficinaDto(OficinaDto oficinaDto) {
		this.oficinaDto = oficinaDto;
	}

	public ParametroDto getTipoOficinaDto() {
		return tipoOficinaDto;
	}

	public void setTipoOficinaDto(ParametroDto tipoOficinaDto) {
		this.tipoOficinaDto = tipoOficinaDto;
		if (this.tipoOficinaDto != null) {
			this.tipoOficina = this.tipoOficinaDto.getId();
		}
	}

	public ParametroDto getEstadoAprobacionAjuBonDto() {
		return estadoAprobacionAjuBonDto;
	}

	public void setEstadoAprobacionAjuBonDto(ParametroDto estadoAprobacionAjuBonDto) {
		this.estadoAprobacionAjuBonDto = estadoAprobacionAjuBonDto;
	}

	public Boolean getHabilitarEvaluacion() {
		SessionMBean sessionMBean = (SessionMBean) WebServletContextListener.getApplicationContext().getBean("sessionMBean");

		for (OficinaInvolucradoDto oi : listaInvolucrados) {
			if (oi.getInvolucradoDto().getRegistro().equals(sessionMBean.getRegistro())) {
				this.habilitarEvaluacion = Boolean.TRUE;
				break;
			}
			this.habilitarEvaluacion = Boolean.FALSE;
		}

		return habilitarEvaluacion;
	}

	public void setHabilitarEvaluacion(Boolean habilitarEvaluacion) {
		this.habilitarEvaluacion = habilitarEvaluacion;
	}

	public Boolean getSilencioAdministrativo() {
		return silencioAdministrativo;
	}

	public void setSilencioAdministrativo(Boolean silencioAdministrativo) {
		this.silencioAdministrativo = silencioAdministrativo;
	}

	public Long getTipoOficina() {
		if (tipoOficina == null) {
			tipoOficina = 0L;
		}
		return tipoOficina;
	}

	public void setTipoOficina(Long tipoOficina) {
		this.tipoOficina = tipoOficina;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OficinaSolicitudDto)) {
			return false;
		}
		OficinaSolicitudDto other = (OficinaSolicitudDto) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.indra.pe.bbva.reauni.entidad.OficinaSolicitudDto[ id=" + id
				+ " ]";
	}

	public Boolean getRealizoVotoTerritorial() {
		String territorio = getOficinaDto().getTerritorioDto().getCodTerritorio();
		int votoTerritorial = getRealizoVoto(OficinaInvolucradoDto.GERENTE_TERRITORIAL + territorio);
		if (votoTerritorial <= 0) {
			votoTerritorial = getRealizoVoto(OficinaInvolucradoDto.JEFE_PROMOCION_NEGOCIOS + territorio);
			if (votoTerritorial == -1) {
				@SuppressWarnings("unchecked")
				DAOGenerico<OficinaInvolucradoDto> dao = (DAOGenerico<OficinaInvolucradoDto>) WebServletContextListener.getApplicationContext().getBean("daoGenerico");

				try {
					List<OficinaInvolucradoDto> involucrado = null;
					String query = "";
					query += "select o from OficinaInvolucradoDto o join o.oficinaSolicitudDto os join os.solicitudDto s, PermisoPerfilDto e ";
					query += "where e.tipoAcceso=1027 and e.perfil.id=3 and e.valor=o.involucradoDto.registro and os.tipoOficinaDto.id=" + this.getTipoOficina();
					query += " and os.oficinaDto.territorioDto.codTerritorio='" + territorio + "' and s.id=" + this.getSolicitudDto().getId();
					involucrado = dao.ejecutarQuery(query);

					if (involucrado != null && involucrado.size() > 0) {
						votoTerritorial = involucrado.get(0).getRealizoVoto() ? 1 : 0;
					}

				} catch (Exception e) {
					logger.error("Obteniendo el cargo del territorial", e);
				}
			}
		}

		return (votoTerritorial == 1);
	}

	private int buscarInvolucrado(String registro) {
		OficinaInvolucradoDto os;
		int i = -1;
		for (i = 0; i < getListaInvolucrados().size(); i++) {
			os = getListaInvolucrados().get(i);
			if (os.getInvolucradoDto().getRegistro().equalsIgnoreCase(registro)) {
				return i;
			}
		}
		return -1;
	}
	
	private int buscarInvolucradoPorCargo(String cargoTerritorio) {
		OficinaInvolucradoDto os;
		int i = -1;
		for (i = 0; i < getListaInvolucrados().size(); i++) {
			os = getListaInvolucrados().get(i);
			if ((os.getInvolucradoDto().getCargo() + os.getOficinaSolicitudDto().getOficinaDto().getTerritorioDto().getCodTerritorio()).equalsIgnoreCase(cargoTerritorio)) {
				return i;
			}
		}
		return -1;
	}

	public Boolean getRealizoVoto() {
		Boolean realizoVoto = Boolean.TRUE;

		if (!getSilencioAdministrativo()) {
			SessionMBean sessionMBean = (SessionMBean) WebServletContextListener.getApplicationContext().getBean("sessionMBean");
			String codIdUsuario = sessionMBean.getRegistro();
			String codIdSolicitante = getSolicitudDto().getResponsableSolicitante();
			int indexInvolucrado = buscarInvolucrado(sessionMBean.getRegistro());

			if(codIdUsuario.equalsIgnoreCase(codIdSolicitante)) {
				realizoVoto = Boolean.FALSE;
			} else {
				if (indexInvolucrado > -1 && indexInvolucrado < getListaInvolucrados().size()) {
					OficinaInvolucradoDto o = getListaInvolucrados().get(indexInvolucrado);
					realizoVoto = o.getRealizoVoto();
				}
			}
		}

		return realizoVoto;
	}

	public int getRealizoVoto(String cargoTerritorio) {
		int realizoVoto = 1;
		if (!getSilencioAdministrativo()) {
			int indexInvolucrado = buscarInvolucradoPorCargo(cargoTerritorio);

			if (indexInvolucrado > 0 && indexInvolucrado < getListaInvolucrados().size()) {
				OficinaInvolucradoDto o = getListaInvolucrados().get(indexInvolucrado);
				realizoVoto = o.getRealizoVoto() ? 1 : 0;
			} else {
				realizoVoto = -1;
			}
		}

		return realizoVoto;
	}

	public Boolean getHabilitarDeclaracionJurada() {
		SessionMBean sessionMBean = (SessionMBean) WebServletContextListener.getApplicationContext().getBean("sessionMBean");
		String codOficinaInv = getOficinaDto().getCodOficina();
		String codTerritorioInv = getOficinaDto().getTerritorioDto().getCodTerritorio();
		String codOficinaUsr = sessionMBean.getCodOficina();
		String codIdUsuario = sessionMBean.getRegistro();
		String codIdSolicitante = getSolicitudDto().getResponsableSolicitante();
		Boolean result = Boolean.TRUE; // Disabled

		if (!getSilencioAdministrativo()) {
			if (!getRealizoVotoTerritorial()) {
				if (!getRealizoVoto()) {
					if (codIdUsuario.equalsIgnoreCase(codIdSolicitante)
							|| (sessionMBean.getEsGerenteTerritorial() && (codOficinaUsr
									.equalsIgnoreCase(codOficinaInv) || codOficinaUsr
									.equalsIgnoreCase(codTerritorioInv)))) {
						result = Boolean.FALSE;
					}
				}
			}
		}

		return result;
	}
	
	public Date getFechaEnvioGestionFile() {
		return fechaEnvioGestionFile;
	}

	public void setFechaEnvioGestionFile(Date fechaEnvioGestionFile) {
		this.fechaEnvioGestionFile = fechaEnvioGestionFile;
	}
	
	public BigDecimal getEnvioGestionFile() {
		return envioGestionFile;
	}

	public void setEnvioGestionFile(BigDecimal envioGestionFile) {
		this.envioGestionFile = envioGestionFile;
	}

	public static final Comparator<OficinaSolicitudDto> COMPARATOR_TIPO_OFICINA = new Comparator<OficinaSolicitudDto>() {

		@Override
		public int compare(OficinaSolicitudDto o1, OficinaSolicitudDto o2) {
			int result = 0;
			if (o1 != null && o2 != null) {
				String tipoOficina1 = o1.getTipoOficina().toString();
				if (o1.getOficinaDto() == null) {
					tipoOficina1 += "00000000";
				} else {
					if (o1.getOficinaDto().getTerritorioDto() == null) {
						tipoOficina1 += "0000";
					} else {
						tipoOficina1 += o1.getOficinaDto().getTerritorioDto().getCodTerritorio();
					}
					if (o1.getOficinaDto().getCodOficina() == null) {
						tipoOficina1 += "0000";
					} else {
						tipoOficina1 += o1.getOficinaDto().getCodOficina();
					}
				}

				String tipoOficina2 = o2.getTipoOficina().toString();
				if (o2.getOficinaDto() == null) {
					tipoOficina2 += "00000000";
				} else {
					if (o2.getOficinaDto().getTerritorioDto() == null) {
						tipoOficina2 += "0000";
					} else {
						tipoOficina2 += o2.getOficinaDto().getTerritorioDto().getCodTerritorio();
					}
					if (o2.getOficinaDto().getCodOficina() == null) {
						tipoOficina2 += "0000";
					} else {
						tipoOficina2 += o2.getOficinaDto().getCodOficina();
					}
				}
				result = tipoOficina1.compareTo(tipoOficina2);
			}
			return result;
		}
	};
}
