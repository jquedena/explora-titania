package com.indra.pe.bbva.ldap.model.entidad;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema="IIWX",name = "LDAPPERU2")
public class LdapDto implements Serializable{
	 
		private static final long serialVersionUID = 2422609718522455615L;

		@Column(name = "REGISTROU")
	    private String registrou;
	    
	    @Column(name = "REGISTROP")
	    private String registrop;
	    
	    @Column(name = "CODPAIS")
	    private String codpais;
	    
	    @Column(name = "DESPAIS")
	    private String despais;
	    
	    @Column(name = "CODEMP")
	    private String codemp;
	    
	    @Column(name = "DESEMP")
	    private String desemp;
	    
	    @Column(name = "NUMMAT")
	    private String nummat;
	    
	    @Id
	    @Basic(optional = false)
	    @Column(name = "CODUSU")
	    private String codusu;
	    
	    @Column(name = "NOMBRE")
	    private String nombre;
	    
	    @Column(name = "APEPAT")
	    private String apepat;
	    
	    @Column(name = "APEMAT")
	    private String apemat;
	    
	    @Column(name = "SEXO")
	    private String sexo;
	    
	    @Column(name = "FECNAC")
	    private String fecnac;
	    
	    @Column(name = "TIPDOC")
	    private String tipdoc;
	    
	    @Column(name = "NUMDOC")
	    private String numdoc;
	    
	    @Column(name = "TELEFONO1")
	    private String telefono1;
	    
	    @Column(name = "TELEFONO2")
	    private String telefono2;
	    
	    @Column(name = "CORELEC")
	    private String corelec;
	    
	    @Column(name = "CODCARGO")
	    private String codcargo;
	    
	    @Column(name = "NOMCARGO")
	    private String nomcargo;
	    
	    @Column(name = "CODEMPANT")
	    private String codempant;
	    
	    @Column(name = "CODOFI")
	    private String codofi;
	    @Column(name = "DESOFI")
	    private String desofi;
	    @Column(name = "TIPOFI")
	    private String tipofi;
	    @Column(name = "GESPER")
	    private String gesper;
	    @Column(name = "FECING")
	    private String fecing;
	    @Column(name = "NROHIJOS")
	    private Short nrohijos;
	    @Column(name = "CODGER")
	    private String codger;
	    @Column(name = "NOMGER")
	    private String nomger;
	    @Column(name = "TELOFI1")
	    private String telofi1;
	    @Column(name = "TELOFI2")
	    private String telofi2;
	    @Column(name = "CARBLAN")
	    private String carblan;
	    @Column(name = "PROINF")
	    private String proinf;
	    @Column(name = "CODUSUJEFE")
	    private String codusujefe;
	    @Column(name = "CODUNIORG")
	    private String coduniorg;
	    @Column(name = "DESUNIORG")
	    private String desuniorg;
	    @Column(name = "CODNIVEL1")
	    private String codnivel1;
	    @Column(name = "DESNIVEL1")
	    private String desnivel1;
	    @Column(name = "CODNIVEL2")
	    private String codnivel2;
	    @Column(name = "DESNIVEL2")
	    private String desnivel2;
	    @Column(name = "CODNIVEL3")
	    private String codnivel3;
	    @Column(name = "DESNIVEL3")
	    private String desnivel3;
	    @Column(name = "CODNIVEL4")
	    private String codnivel4;
	    @Column(name = "DESNIVEL4")
	    private String desnivel4;
	    @Column(name = "CODNIVEL5")
	    private String codnivel5;
	    @Column(name = "DESNIVEL5")
	    private String desnivel5;
	    @Column(name = "CODNIVEL6")
	    private String codnivel6;
	    @Column(name = "DESNIVEL6")
	    private String desnivel6;
	    @Column(name = "CODNIVEL7")
	    private String codnivel7;
	    @Column(name = "DESNIVEL7")
	    private String desnivel7;
	    @Column(name = "CODNIVEL8")
	    private String codnivel8;
	    @Column(name = "DESNIVEL8")
	    private String desnivel8;
	    @Column(name = "CODNIVEL9")
	    private String codnivel9;
	    @Column(name = "DESNIVEL9")
	    private String desnivel9;
	    @Column(name = "CODNIVEL10")
	    private String codnivel10;
	    @Column(name = "DESNIVEL10")
	    private String desnivel10;
	    @Column(name = "USOFUT1")
	    private String usofut1;
	    @Column(name = "USOFUT2")
	    private String usofut2;
	    @Column(name = "USOFUT3")
	    private String usofut3;
	    @Column(name = "USOFUT4")
	    private String usofut4;
	    @Column(name = "USOFUT5")
	    private String usofut5;
	    @Column(name = "USOFUT6")
	    private String usofut6;
	    @Column(name = "USOFUT7")
	    private String usofut7;
	    @Column(name = "USOFUT8")
	    private String usofut8;
	    @Column(name = "USOFUT9")
	    private String usofut9;
	    @Column(name = "USOFUT10")
	    private String usofut10;

	    public LdapDto() {
	    }

	    public LdapDto(String codusu) {
	        this.codusu = codusu;
	    }

	    public String getRegistrou() {
	        return registrou;
	    }

	    public void setRegistrou(String registrou) {
	        this.registrou = registrou;
	    }

	    public String getRegistrop() {
	        return registrop;
	    }

	    public void setRegistrop(String registrop) {
	        this.registrop = registrop;
	    }

	    public String getCodpais() {
	        return codpais;
	    }

	    public void setCodpais(String codpais) {
	        this.codpais = codpais;
	    }

	    public String getDespais() {
	        return despais;
	    }

	    public void setDespais(String despais) {
	        this.despais = despais;
	    }

	    public String getCodemp() {
	        return codemp;
	    }

	    public void setCodemp(String codemp) {
	        this.codemp = codemp;
	    }

	    public String getDesemp() {
	        return desemp;
	    }

	    public void setDesemp(String desemp) {
	        this.desemp = desemp;
	    }

	    public String getNummat() {
	        return nummat;
	    }

	    public void setNummat(String nummat) {
	        this.nummat = nummat;
	    }

	    public String getCodusu() {
	        return codusu;
	    }

	    public void setCodusu(String codusu) {
	        this.codusu = codusu;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApepat() {
	        return apepat;
	    }

	    public void setApepat(String apepat) {
	        this.apepat = apepat;
	    }

	    public String getApemat() {
	        return apemat;
	    }

	    public void setApemat(String apemat) {
	        this.apemat = apemat;
	    }

	    public String getSexo() {
	        return sexo;
	    }

	    public void setSexo(String sexo) {
	        this.sexo = sexo;
	    }

	    public String getFecnac() {
	        return fecnac;
	    }

	    public void setFecnac(String fecnac) {
	        this.fecnac = fecnac;
	    }

	    public String getTipdoc() {
	        return tipdoc;
	    }

	    public void setTipdoc(String tipdoc) {
	        this.tipdoc = tipdoc;
	    }

	    public String getNumdoc() {
	        return numdoc;
	    }

	    public void setNumdoc(String numdoc) {
	        this.numdoc = numdoc;
	    }

	    public String getTelefono1() {
	        return telefono1;
	    }

	    public void setTelefono1(String telefono1) {
	        this.telefono1 = telefono1;
	    }

	    public String getTelefono2() {
	        return telefono2;
	    }

	    public void setTelefono2(String telefono2) {
	        this.telefono2 = telefono2;
	    }

	    public String getCorelec() {
	        return corelec;
	    }

	    public void setCorelec(String corelec) {
	        this.corelec = corelec;
	    }

	    public String getCodcargo() {
	        return codcargo;
	    }

	    public void setCodcargo(String codcargo) {
	        this.codcargo = codcargo;
	    }

	    public String getNomcargo() {
	        return nomcargo;
	    }

	    public void setNomcargo(String nomcargo) {
	        this.nomcargo = nomcargo;
	    }

	    public String getCodempant() {
	        return codempant;
	    }

	    public void setCodempant(String codempant) {
	        this.codempant = codempant;
	    }

	    public String getCodofi() {
	        return codofi;
	    }

	    public void setCodofi(String codofi) {
	        this.codofi = codofi;
	    }

	    public String getDesofi() {
	        return desofi;
	    }

	    public void setDesofi(String desofi) {
	        this.desofi = desofi;
	    }

	    public String getTipofi() {
	        return tipofi;
	    }

	    public void setTipofi(String tipofi) {
	        this.tipofi = tipofi;
	    }

	    public String getGesper() {
	        return gesper;
	    }

	    public void setGesper(String gesper) {
	        this.gesper = gesper;
	    }

	    public String getFecing() {
	        return fecing;
	    }

	    public void setFecing(String fecing) {
	        this.fecing = fecing;
	    }

	    public Short getNrohijos() {
	        return nrohijos;
	    }

	    public void setNrohijos(Short nrohijos) {
	        this.nrohijos = nrohijos;
	    }

	    public String getCodger() {
	        return codger;
	    }

	    public void setCodger(String codger) {
	        this.codger = codger;
	    }

	    public String getNomger() {
	        return nomger;
	    }

	    public void setNomger(String nomger) {
	        this.nomger = nomger;
	    }

	    public String getTelofi1() {
	        return telofi1;
	    }

	    public void setTelofi1(String telofi1) {
	        this.telofi1 = telofi1;
	    }

	    public String getTelofi2() {
	        return telofi2;
	    }

	    public void setTelofi2(String telofi2) {
	        this.telofi2 = telofi2;
	    }

	    public String getCarblan() {
	        return carblan;
	    }

	    public void setCarblan(String carblan) {
	        this.carblan = carblan;
	    }

	    public String getProinf() {
	        return proinf;
	    }

	    public void setProinf(String proinf) {
	        this.proinf = proinf;
	    }

	    public String getCodusujefe() {
	        return codusujefe;
	    }

	    public void setCodusujefe(String codusujefe) {
	        this.codusujefe = codusujefe;
	    }

	    public String getCoduniorg() {
	        return coduniorg;
	    }

	    public void setCoduniorg(String coduniorg) {
	        this.coduniorg = coduniorg;
	    }

	    public String getDesuniorg() {
	        return desuniorg;
	    }

	    public void setDesuniorg(String desuniorg) {
	        this.desuniorg = desuniorg;
	    }

	    public String getCodnivel1() {
	        return codnivel1;
	    }

	    public void setCodnivel1(String codnivel1) {
	        this.codnivel1 = codnivel1;
	    }

	    public String getDesnivel1() {
	        return desnivel1;
	    }

	    public void setDesnivel1(String desnivel1) {
	        this.desnivel1 = desnivel1;
	    }

	    public String getCodnivel2() {
	        return codnivel2;
	    }

	    public void setCodnivel2(String codnivel2) {
	        this.codnivel2 = codnivel2;
	    }

	    public String getDesnivel2() {
	        return desnivel2;
	    }

	    public void setDesnivel2(String desnivel2) {
	        this.desnivel2 = desnivel2;
	    }

	    public String getCodnivel3() {
	        return codnivel3;
	    }

	    public void setCodnivel3(String codnivel3) {
	        this.codnivel3 = codnivel3;
	    }

	    public String getDesnivel3() {
	        return desnivel3;
	    }

	    public void setDesnivel3(String desnivel3) {
	        this.desnivel3 = desnivel3;
	    }

	    public String getCodnivel4() {
	        return codnivel4;
	    }

	    public void setCodnivel4(String codnivel4) {
	        this.codnivel4 = codnivel4;
	    }

	    public String getDesnivel4() {
	        return desnivel4;
	    }

	    public void setDesnivel4(String desnivel4) {
	        this.desnivel4 = desnivel4;
	    }

	    public String getCodnivel5() {
	        return codnivel5;
	    }

	    public void setCodnivel5(String codnivel5) {
	        this.codnivel5 = codnivel5;
	    }

	    public String getDesnivel5() {
	        return desnivel5;
	    }

	    public void setDesnivel5(String desnivel5) {
	        this.desnivel5 = desnivel5;
	    }

	    public String getCodnivel6() {
	        return codnivel6;
	    }

	    public void setCodnivel6(String codnivel6) {
	        this.codnivel6 = codnivel6;
	    }

	    public String getDesnivel6() {
	        return desnivel6;
	    }

	    public void setDesnivel6(String desnivel6) {
	        this.desnivel6 = desnivel6;
	    }

	    public String getCodnivel7() {
	        return codnivel7;
	    }

	    public void setCodnivel7(String codnivel7) {
	        this.codnivel7 = codnivel7;
	    }

	    public String getDesnivel7() {
	        return desnivel7;
	    }

	    public void setDesnivel7(String desnivel7) {
	        this.desnivel7 = desnivel7;
	    }

	    public String getCodnivel8() {
	        return codnivel8;
	    }

	    public void setCodnivel8(String codnivel8) {
	        this.codnivel8 = codnivel8;
	    }

	    public String getDesnivel8() {
	        return desnivel8;
	    }

	    public void setDesnivel8(String desnivel8) {
	        this.desnivel8 = desnivel8;
	    }

	    public String getCodnivel9() {
	        return codnivel9;
	    }

	    public void setCodnivel9(String codnivel9) {
	        this.codnivel9 = codnivel9;
	    }

	    public String getDesnivel9() {
	        return desnivel9;
	    }

	    public void setDesnivel9(String desnivel9) {
	        this.desnivel9 = desnivel9;
	    }

	    public String getCodnivel10() {
	        return codnivel10;
	    }

	    public void setCodnivel10(String codnivel10) {
	        this.codnivel10 = codnivel10;
	    }

	    public String getDesnivel10() {
	        return desnivel10;
	    }

	    public void setDesnivel10(String desnivel10) {
	        this.desnivel10 = desnivel10;
	    }

	    public String getUsofut1() {
	        return usofut1;
	    }

	    public void setUsofut1(String usofut1) {
	        this.usofut1 = usofut1;
	    }

	    public String getUsofut2() {
	        return usofut2;
	    }

	    public void setUsofut2(String usofut2) {
	        this.usofut2 = usofut2;
	    }

	    public String getUsofut3() {
	        return usofut3;
	    }

	    public void setUsofut3(String usofut3) {
	        this.usofut3 = usofut3;
	    }

	    public String getUsofut4() {
	        return usofut4;
	    }

	    public void setUsofut4(String usofut4) {
	        this.usofut4 = usofut4;
	    }

	    public String getUsofut5() {
	        return usofut5;
	    }

	    public void setUsofut5(String usofut5) {
	        this.usofut5 = usofut5;
	    }

	    public String getUsofut6() {
	        return usofut6;
	    }

	    public void setUsofut6(String usofut6) {
	        this.usofut6 = usofut6;
	    }

	    public String getUsofut7() {
	        return usofut7;
	    }

	    public void setUsofut7(String usofut7) {
	        this.usofut7 = usofut7;
	    }

	    public String getUsofut8() {
	        return usofut8;
	    }

	    public void setUsofut8(String usofut8) {
	        this.usofut8 = usofut8;
	    }

	    public String getUsofut9() {
	        return usofut9;
	    }

	    public void setUsofut9(String usofut9) {
	        this.usofut9 = usofut9;
	    }

	    public String getUsofut10() {
	        return usofut10;
	    }

	    public void setUsofut10(String usofut10) {
	        this.usofut10 = usofut10;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (codusu != null ? codusu.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        
	        if (!(object instanceof LdapDto)) {
	            return false;
	        }
	        LdapDto other = (LdapDto) object;
	        if ((this.codusu == null && other.codusu != null) || (this.codusu != null && !this.codusu.equals(other.codusu))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "javaapplication1.Ldapperu2[ codusu=" + codusu + " ]";
	    }
}
