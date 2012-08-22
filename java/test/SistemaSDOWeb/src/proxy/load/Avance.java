package proxy.load;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.log4j.Logger;

public class Avance {
	
	private static Logger log = Logger.getLogger(Avance.class);
	private static String VERDE = "textVerde";
	private static String AMBAR = "textAmbar";
	private static String ROJO = "textRojo";
	private static MathContext MATH_CONTEXT = new MathContext(8) ;
	private String codEpigrafe;
	private String nomEpigrafe;
	private String codOfic;
	private String nomOfic;
	private String codTerr;
	private String nomTerr;
	private String mes;
	private String anho;
	private String prioridad;
	private BigDecimal metGerOfi;
	private String codGest;
	private String nomGestor;
	private BigDecimal totalMIS;
	private BigDecimal monSegu1;
	private BigDecimal monSegu2;
	private BigDecimal porcentajeMin;
	private BigDecimal porcentajeMax;
	
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

	public String getNomOfic() {
		return nomOfic;
	}

	public void setNomOfic(String nomOfic) {
		this.nomOfic = nomOfic;
	}

	public String getCodTerr() {
		return codTerr;
	}

	public void setCodTerr(String codTerr) {
		this.codTerr = codTerr;
	}

	public String getNomTerr() {
		return nomTerr;
	}

	public void setNomTerr(String nomTerr) {
		this.nomTerr = nomTerr;
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
		this.metGerOfi = metGerOfi;
	}

	public String getCodGest() {
		return codGest;
	}

	public void setCodGest(String codGest) {
		this.codGest = codGest;
	}

	public String getNomGestor() {
		return nomGestor;
	}

	public void setNomGestor(String nomGestor) {
		this.nomGestor = nomGestor;
	}

	public BigDecimal getTotalMIS() {
		return totalMIS;
	}

	public void setTotalMIS(BigDecimal totalMIS) {
		this.totalMIS = totalMIS;
	}

	public BigDecimal getMonSegu1() {
		return monSegu1;
	}

	public void setMonSegu1(BigDecimal monSegu1) {
		this.monSegu1 = monSegu1;
	}

	public BigDecimal getMonSegu2() {
		return monSegu2;
	}

	public void setMonSegu2(BigDecimal monSegu2) {
		this.monSegu2 = monSegu2;
	}
	
	public BigDecimal getPorcentajeMin() {
		return porcentajeMin;
	}

	public void setPorcentajeMin(BigDecimal porcentajeMin) {
		this.porcentajeMin = porcentajeMin;
	}

	public BigDecimal getPorcentajeMax() {
		return porcentajeMax;
	}

	public void setPorcentajeMax(BigDecimal porcentajeMax) {
		this.porcentajeMax = porcentajeMax;
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

	public BigDecimal getDesvMontoMIS() {
		try {
			BigDecimal desviacion;
			desviacion = this.getTotalMIS().subtract(BigDecimal.valueOf(Math.abs(this.metGerOfi.doubleValue())), Avance.MATH_CONTEXT);
			if (this.nomEpigrafe.toLowerCase().indexOf("cartera atrasada") > -1) {
				desviacion = desviacion.multiply(BigDecimal.valueOf(-1));
			}
			return desviacion;
		} catch (Exception ex) {
			log.error(ex);
			return BigDecimal.ZERO;
		}
	}

	public BigDecimal getDesvPercentMIS() {
		try {		
			BigDecimal desviacion;
			desviacion = this.getTotalMIS().divide(BigDecimal.valueOf(Math.abs(this.metGerOfi.doubleValue())), Avance.MATH_CONTEXT);
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
	
	public String getSemaforoDesvPercentMIS() {
		String semaforo = "";
		try {
			if (this.getDesvPercentMIS().compareTo(this.getPorcentajeMin()) == -1) {
				semaforo = Avance.ROJO;
			} else if(this.getDesvPercentMIS().compareTo(this.getPorcentajeMin()) > -1  && this.getDesvPercentMIS().compareTo(this.getPorcentajeMax()) <= 0) {
				semaforo = Avance.AMBAR;
			} else if(this.getDesvPercentMIS().compareTo(this.getPorcentajeMax()) == 1) {
				semaforo = Avance.VERDE;
			}
		} catch(Exception ex) {
			log.error(ex);
			semaforo = "error";
		}
		return semaforo;
	}
	
	public BigDecimal getDesvMontoSeg() {
		try {
			BigDecimal desviacion;
			desviacion = this.getMonTotal().subtract(this.metGerOfi, Avance.MATH_CONTEXT);
			if (this.nomEpigrafe.toLowerCase().indexOf("cartera atrasada") > -1) {
				desviacion = desviacion.multiply(BigDecimal.valueOf(-1));
			}
			return desviacion;
		} catch (Exception ex) {
			log.error(ex);
			return BigDecimal.ZERO;
		}
	}

	public BigDecimal getDesvPercentSeg() {		
		try {		
			BigDecimal desviacion;
			desviacion = this.getMonTotal().divide(this.metGerOfi, Avance.MATH_CONTEXT);
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
	
	public String getSemaforoDesvPercentSeg() {
		String semaforo = "";
		try {
			if (this.getDesvPercentSeg().compareTo(this.getPorcentajeMin()) == -1) {
				semaforo = Avance.ROJO;
			} else if(this.getDesvPercentSeg().compareTo(this.getPorcentajeMin()) > -1  && this.getDesvPercentSeg().compareTo(this.getPorcentajeMax()) <= 0) {
				semaforo = Avance.AMBAR;
			} else if(this.getDesvPercentSeg().compareTo(this.getPorcentajeMax()) == 1) {
				semaforo = Avance.VERDE;
			}
		} catch(Exception ex) {
			log.error(ex);
			semaforo = "error";
		}
		return semaforo;
	}
}
