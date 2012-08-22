package pe.com.bbva.model.entity;

public class Log implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long idlog;
	private Long nroLinea;
	private Long iderror;
	private String descError;
	private String fecha;

	public Log() {
	}

	public Log(long idlog) {
		this.idlog = idlog;
	}

	public Log(long idlog, Long nroLinea, Long iderror, String descError,
			String fecha) {
		this.idlog = idlog;
		this.nroLinea = nroLinea;
		this.iderror = iderror;
		this.descError = descError;
		this.fecha = fecha;
	}

	public long getIdlog() {
		return this.idlog;
	}

	public void setIdlog(long idlog) {
		this.idlog = idlog;
	}

	public Long getNroLinea() {
		return this.nroLinea;
	}

	public void setNroLinea(Long nroLinea) {
		this.nroLinea = nroLinea;
	}

	public Long getIderror() {
		return this.iderror;
	}

	public void setIderror(Long iderror) {
		this.iderror = iderror;
	}

	public String getDescError() {
		return this.descError;
	}

	public void setDescError(String descError) {
		this.descError = descError;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Fecha: " + fecha + ", Error Nro.: " + idlog + ", Linea: "
				+ nroLinea + ", Tipo Error: " + iderror + ", Error: "
				+ descError;
	}
}
