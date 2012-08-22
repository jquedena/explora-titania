package com.grupobbva.bc.per.tele.sdo.serializable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.log4j.Logger;

@SuppressWarnings("unused")
public class Seguimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(Seguimiento.class);
	private static String VERDE = "textVerde";
	private static String AMBAR = "textAmbar";
	private static String ROJO = "textRojo";
	private static MathContext MATH_CONTEXT;
	private static MathContext DECIMAL_2;
	private String codEpigrafe; // varchar2(10)
	private String nomEpigrafe; // varchar2(50)
	private String codOfic; // varchar2(4)
	private String mes; // varchar2(20)
	private String anho; // varchar2(20)
	private String prioridad; // varchar2(40)
	private BigDecimal metGerOfi; // number
	private String nomAcci; // varchar2(80)
	private String codGest; // varchar2(20)
	private String nomGest; // varchar2(20)
	private BigDecimal nroClie; // number(5)
	private BigDecimal compGest; // number
	private BigDecimal nroGestSegu1; // number(4)
	private BigDecimal nroConcSegu1; // number(4)
	private BigDecimal monSegu1; // number(15,2)
	private BigDecimal nroGestSegu2; // number(4)
	private BigDecimal nroConcSegu2; // number(4)
	private BigDecimal monSegu2; // number(15,2)
	private BigDecimal codAcci; // number
	private String indAfecta; // varchar2(1)
	private BigDecimal porcAsig; // number
	private String codPerfil; // varchar2(5)
	private String orden; // varchar2(20)
	private String tipo; // char(3)
	private BigDecimal totalMIS;
	private BigDecimal porcentajeMin;
	private BigDecimal porcentajeMax;

	static {
		MATH_CONTEXT = new MathContext(8);
		DECIMAL_2 = new MathContext(2);
	}
	
	public String getNomGest() {
		return nomGest;
	}

	public void setNomGest(String nomGest) {
		this.nomGest = nomGest;
	}

	private BigDecimal valida(BigDecimal number) {
		return number == null ? BigDecimal.ZERO : number;
	}
	
	public String getCodEpigrafe() {
		return codEpigrafe;
	}

	public void setCodEpigrafe(String codEpigrafe) {
		this.codEpigrafe = codEpigrafe;
	}

	public String getNomEpigrafe() {
		return nomEpigrafe;
	}

	public void setNomEpigrafe(String nomEpigrafe) {
		this.nomEpigrafe = nomEpigrafe;
	}

	public String getCodOfic() {
		return codOfic;
	}

	public void setCodOfic(String codOfic) {
		this.codOfic = codOfic;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnho() {
		return anho;
	}

	public void setAnho(String anho) {
		this.anho = anho;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public BigDecimal getMetGerOfi() {
		return metGerOfi;
	}

	public void setMetGerOfi(BigDecimal metGerOfi) {
		this.metGerOfi = valida(metGerOfi);
	}

	public String getNomAcci() {
		return nomAcci;
	}

	public void setNomAcci(String nomAcci) {
		this.nomAcci = nomAcci;
	}

	public String getCodGest() {
		return codGest;
	}

	public void setCodGest(String codGest) {
		this.codGest = codGest;
	}

	public BigDecimal getNroClie() {
		return nroClie;
	}

	public void setNroClie(BigDecimal nroClie) {
		this.nroClie = valida(nroClie);
	}

	public BigDecimal getCompGest() {
		return compGest;
	}

	public void setCompGest(BigDecimal compGest) {
		this.compGest = valida(compGest);
	}

	public BigDecimal getNroGestSegu1() {
		return nroGestSegu1;
	}

	public void setNroGestSegu1(BigDecimal nroGestSegu1) {
		this.nroGestSegu1 = valida(nroGestSegu1);
	}

	public BigDecimal getNroConcSegu1() {
		return nroConcSegu1;
	}

	public void setNroConcSegu1(BigDecimal nroConcSegu1) {
		this.nroConcSegu1 = valida(nroConcSegu1);
	}

	public BigDecimal getMonSegu1() {
		return monSegu1;
	}

	public void setMonSegu1(BigDecimal monSegu1) {
		this.monSegu1 = valida(monSegu1);
	}

	public BigDecimal getNroGestSegu2() {
		return nroGestSegu2;
	}

	public void setNroGestSegu2(BigDecimal nroGestSegu2) {
		this.nroGestSegu2 = valida(nroGestSegu2);
	}

	public BigDecimal getNroConcSegu2() {
		return nroConcSegu2;
	}

	public void setNroConcSegu2(BigDecimal nroConcSegu2) {
		this.nroConcSegu2 = valida(nroConcSegu2);
	}

	public BigDecimal getMonSegu2() {
		return valida(monSegu2);
	}

	public void setMonSegu2(BigDecimal monSegu2) {
		this.monSegu2 = monSegu2;
	}

	public BigDecimal getCodAcci() {
		return codAcci;
	}

	public void setCodAcci(BigDecimal codAcci) {
		this.codAcci = codAcci;
	}

	public String getIndAfecta() {
		return indAfecta;
	}

	public void setIndAfecta(String indAfecta) {
		this.indAfecta = indAfecta;
	}

	public BigDecimal getPorcAsig() {
		return porcAsig;
	}

	public void setPorcAsig(BigDecimal porcAsig) {
		this.porcAsig = valida(porcAsig);
	}

	public String getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getTotalMIS() {
		return totalMIS;
	}

	public void setTotalMIS(BigDecimal totalMIS) {
		this.totalMIS = valida(totalMIS);
	}

	public BigDecimal getPorcentajeMin() {
		return porcentajeMin;
	}

	public void setPorcentajeMin(BigDecimal porcentajeMin) {
		this.porcentajeMin = valida(porcentajeMin);
	}

	public BigDecimal getPorcentajeMax() {
		return porcentajeMax;
	}

	public void setPorcentajeMax(BigDecimal porcentajeMax) {
		this.porcentajeMax = valida(porcentajeMax);
	}

	public BigDecimal getNroGestTotal() {
		try {
			return this.nroGestSegu1.add(this.nroGestSegu2);
		} catch (Exception ex) {
			return BigDecimal.ZERO;
		}
	}

	public BigDecimal getNroConcTotal() {
		try {
			return this.nroConcSegu1.add(this.nroConcSegu2);
		} catch (Exception ex) {
			return BigDecimal.ZERO;
		}
	}

	public BigDecimal getMonTotal() {
		try {
			double monSegu1 = this.getMonSegu1().doubleValue();
			double monSegu2 = this.getMonSegu2().doubleValue();
			double monTotal = monSegu1 + monSegu2;
			return BigDecimal.valueOf(monTotal);
		} catch (Exception ex) {
			log.error(ex);
			return BigDecimal.valueOf(-1) ;
		}
	}

	public BigDecimal getPorcConsecucion() {
		BigDecimal result = null;
		try {
			double divide = this.getMonTotal().doubleValue();
			double divisor = this.getCompGest().doubleValue();
			
			if(Double.valueOf(divisor).intValue() == 0) {
				return BigDecimal.ZERO;
			}
			
			double cociente = divide / divisor;
			
			result = new BigDecimal(cociente, Seguimiento.MATH_CONTEXT);
			
			if (this.nomEpigrafe.toLowerCase().indexOf("cartera atrasada") > -1) {
				result = BigDecimal.ONE.subtract(result);
			}
			
			result = result.multiply(BigDecimal.valueOf(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
			
			log.info("divide:" + divide);
			log.info("divisor:" + divisor);
			log.info("cociente:" + cociente);
			log.info(result.toString());
			
			return result;
		} catch (Exception ex) {
			log.error(ex);
			return BigDecimal.valueOf(-1) ;
		}
	}

	public BigDecimal getDesviacionMIS() {
		try {
			BigDecimal desviacion;
			desviacion = this.getTotalMIS().divide(BigDecimal.valueOf(Math.abs(this.metGerOfi.doubleValue())), Seguimiento.MATH_CONTEXT);
			if (this.nomEpigrafe.toLowerCase().indexOf("cartera atrasada") > -1) {
				desviacion = BigDecimal.ONE.subtract(desviacion);
			}
			
			desviacion = desviacion.multiply(BigDecimal.valueOf(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
			return desviacion;
		} catch (Exception ex) {
			log.error(ex);
			return BigDecimal.ZERO;
		}
	}	
	
	public String getSemaforoPorcConsecucion() {
		String semaforo = "";
		try {
			if (this.getPorcConsecucion().compareTo(this.getPorcentajeMin()) == -1) {
				semaforo = Seguimiento.ROJO;
			} else if(this.getPorcConsecucion().compareTo(this.getPorcentajeMin()) > -1  && this.getPorcConsecucion().compareTo(this.getPorcentajeMax()) <= 0) {
				semaforo = Seguimiento.AMBAR;
			} else if(this.getPorcConsecucion().compareTo(this.getPorcentajeMax()) == 1) {
				semaforo = Seguimiento.VERDE;
			}
		} catch(Exception ex) {
			log.error(ex);
			semaforo = "error";
		}
		return semaforo;
	}

	public String getSemaforoDesviacionMIS() {
		String semaforo = "";
		try {
			if (this.getDesviacionMIS().compareTo(this.getPorcentajeMin()) == -1) {
				semaforo = Seguimiento.ROJO;
			} else if(this.getDesviacionMIS().compareTo(this.getPorcentajeMin()) > -1  && this.getDesviacionMIS().compareTo(this.getPorcentajeMax()) <= 0) {
				semaforo = Seguimiento.AMBAR;
			} else if(this.getDesviacionMIS().compareTo(this.getPorcentajeMax()) == 1) {
				semaforo = Seguimiento.VERDE;
			}
		} catch(Exception ex) {
			log.error(ex);
			semaforo = "error";
		}
		return semaforo;
	}
	
	public BigDecimal getDesviacion() {
		BigDecimal result = null;
		try {
			double monto = this.getMonTotal().doubleValue();
			double compromiso = this.getCompGest().doubleValue();
			double desviacion = monto - compromiso;
			
			result = new BigDecimal(desviacion);			
			return result;
		} catch (Exception ex) {
			log.error(ex);
			return BigDecimal.valueOf(-1) ;
		}
	}
	
	public String getSemaforoDesviacion() {
		String semaforo = "";
		try {
			if (this.getDesviacion().compareTo(this.getPorcentajeMin()) == -1) {
				semaforo = Seguimiento.ROJO;
			} else if(this.getDesviacion().compareTo(this.getPorcentajeMin()) > -1  && this.getDesviacion().compareTo(this.getPorcentajeMax()) <= 0) {
				semaforo = Seguimiento.AMBAR;
			} else if(this.getDesviacion().compareTo(this.getPorcentajeMax()) == 1) {
				semaforo = Seguimiento.VERDE;
			}
		} catch(Exception ex) {
			log.error(ex);
			semaforo = "error";
		}
		return semaforo;
	}
}
