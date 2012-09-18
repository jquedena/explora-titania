
package com.indra.pe.bbva.reauni.model.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author INDRA PERU SAC
 */
@Entity
@Table(name = "TREAUNI_INVOLUCRADO",schema="REAUNI")
public class InvolucradoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_INVOLUCRADO")
	@TableGenerator(name = "SEQ_INVOLUCRADO", schema = "REAUNI", table = "TREAUNI_ENTIDAD", pkColumnName = "NOMBRE", valueColumnName = "CORRELATIVO", pkColumnValue = "TREAUNI_INVOLUCRADO", allocationSize = 1)
    private Long id;
    @Column(name = "REGISTRO")
    private String registro;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Column(name = "CARGO")
    private String cargo;
    @Column(name = "DESCRIPCION_CARGO")
    private String descripcionCargo;
    
    @Column(name = "EMAIL")
    private String email;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "involucradoDto", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OficinaInvolucradoDto> listaOficinaInvolucrados;

    public InvolucradoDto() {
    }

    public InvolucradoDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcionCargo() {
        return descripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        this.descripcionCargo = descripcionCargo;
    }

    

	public List<OficinaInvolucradoDto> getListaOficinaInvolucrados() {
		return listaOficinaInvolucrados;
	}

	public void setListaOficinaInvolucrados(
			List<OficinaInvolucradoDto> listaOficinaInvolucrados) {
		this.listaOficinaInvolucrados = listaOficinaInvolucrados;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof InvolucradoDto)) {
            return false;
        }
        InvolucradoDto other = (InvolucradoDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.indra.pe.bbva.reauni.entidad.InvolucradoDto[ id=" + id + " ]";
    }
    
}
