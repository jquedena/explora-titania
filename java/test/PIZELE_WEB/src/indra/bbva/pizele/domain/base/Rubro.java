package indra.bbva.pizele.domain.base;

import indra.core.GenericBean;

import java.io.Serializable;

public class Rubro  extends GenericBean implements Serializable  {
	

	private static final long serialVersionUID = 8751245105532159742L;
	
	private  String  descrubro;
	private  String  tiprubro;
	private  String comp_nega;
	
	
	public String getDescrubro() {
		return descrubro;
	}
	public void setDescrubro(String descrubro) {
		this.descrubro = descrubro;
	}
	public String getTiprubro() {
		return tiprubro;
	}
	public void setTiprubro(String tiprubro) {
		this.tiprubro = tiprubro;
	}
	public String getComp_nega() {
		return comp_nega;
		
	}
	public void setComp_nega(String comp_nega) {
		this.comp_nega = comp_nega;
	}
	
	

}
