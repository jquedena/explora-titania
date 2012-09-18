package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("unused")
@Entity
@Table(name = "TREAUNI_PARAMETRO", schema = "REAUNI")
public class ParametroDto implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_PARAMETRO")
	@TableGenerator(name = "SEQ_PARAMETRO", schema = "REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_PARAMETRO", allocationSize = 1)
	private Long id;
	@Column(name = "COMENTARIO")
	private String comentario;
	@Basic(optional = false)
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "DESCRIPCION_CORTA")
	private String descripcionCorta;
	@Basic(optional = false)
	@Column(name = "ESTADO")
	private Boolean estado;
	@Column(name = "INLINESTALY")
	private String inlinestaly;
	@Basic(optional = false)
	@Column(name = "TIPO")
	private String tipo;
	@Column(name = "VALOR_BOOLEAN")
	private Boolean valorBoolean;
	@Column(name = "VALOR_CADENA")
	private String valorCadena;
	@Column(name = "VALOR_ENTERO")
	private Long valorEntero;
	@Column(name = "VALOR_FECHA")
	@Temporal(TemporalType.DATE)
	private Date valorFecha;
	@Column(name = "VALOR_REAL")
	private BigDecimal valorReal;

	@JoinColumn(name = "CATALOGO_PARAMETRO", referencedColumnName = "ID")
	@ManyToOne
	private CatalogoParametroDto catalogoParametroDto;

	@JoinColumn(name = "CATALOGO_PARAMETRO_PADRE", referencedColumnName = "ID")
	@ManyToOne
	private CatalogoParametroDto catalogoParametroPadreDto;
	
	@JoinColumn(name = "PARAMETRO_PADRE", referencedColumnName = "ID")
	@ManyToOne
	private ParametroDto parametroPadreDto;

	@Transient
	private String estadoTexto;
	@Transient
	private String valorBooleanTexto;

	public ParametroDto() {
	}

	public ParametroDto(Long id) {
		this.id = id;
	}

	public ParametroDto(Long id, String descripcion, Boolean estado, String tipo) {
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getInlinestaly() {
		return inlinestaly;
	}

	public void setInlinestaly(String inlinestaly) {
		this.inlinestaly = inlinestaly;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getValorBoolean() {
		return valorBoolean;
	}

	public void setValorBoolean(Boolean valorBoolean) {
		this.valorBoolean = valorBoolean;
	}

	public String getValorCadena() {
		return valorCadena;
	}

	public void setValorCadena(String valorCadena) {
		this.valorCadena = valorCadena;
	}

	public Long getValorEntero() {
		return valorEntero;
	}

	public void setValorEntero(Long valorEntero) {
		this.valorEntero = valorEntero;
	}

	public Date getValorFecha() {
		return valorFecha;
	}

	public void setValorFecha(Date valorFecha) {
		this.valorFecha = valorFecha;
	}

	public BigDecimal getValorReal() {
		return valorReal;
	}

	public void setValorReal(BigDecimal valorReal) {
		this.valorReal = valorReal;
	}

	public CatalogoParametroDto getCatalogoParametroDto() {
		return catalogoParametroDto;
	}

	public void setCatalogoParametroDto(
			CatalogoParametroDto catalogoParametroDto) {
		this.catalogoParametroDto = catalogoParametroDto;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof ParametroDto)) {
			return false;
		}
		ParametroDto other = (ParametroDto) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.indra.pe.bbva.reauni.entidad.ParametroDto[ id=" + id + " ]";
	}

	public String getEstadoTexto() {
		return (this.estado == Boolean.TRUE ? "SI" : "NO");
	}

	public void setEstadoTexto(String estadoTexto) {
		this.estadoTexto = estadoTexto;
	}

	public String getValorBooleanTexto() {
		return (this.valorBoolean == Boolean.TRUE ? "SI" : "NO");
	}

	public void setValorBooleanTexto(String valorBooleanTexto) {
		this.valorBooleanTexto = valorBooleanTexto;
	}

	public CatalogoParametroDto getCatalogoParametroPadreDto() {
		return catalogoParametroPadreDto;
	}

	public void setCatalogoParametroPadreDto(
			CatalogoParametroDto catalogoParametroPadreDto) {
		this.catalogoParametroPadreDto = catalogoParametroPadreDto;
	}

	public ParametroDto getParametroPadreDto() {
		return parametroPadreDto;
	}

	public void setParametroPadreDto(ParametroDto parametroPadreDto) {
		this.parametroPadreDto = parametroPadreDto;
	}

}
