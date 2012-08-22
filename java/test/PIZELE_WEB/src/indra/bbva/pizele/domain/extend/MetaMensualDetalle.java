package indra.bbva.pizele.domain.extend;

import indra.bbva.pizele.domain.base.MetaMensual;

public class MetaMensualDetalle extends MetaMensual{
	
	private static final long serialVersionUID = 8751245105532159742L;
	
	private Integer cont_epigrafe_sdo;

	public Integer getCont_epigrafe_sdo() {
		return cont_epigrafe_sdo;
	}

	public void setCont_epigrafe_sdo(Integer cont_epigrafe_sdo) {
		this.cont_epigrafe_sdo = cont_epigrafe_sdo;
	}
	
}