package indra.bbva.pizele.domain.base;

import indra.core.GenericBean;

import java.io.Serializable;


public class Semaforo extends GenericBean implements Serializable {
	
   private static final long serialVersionUID = 8751245105532159742L;
	
   private Long rango1;
   private Long rango2;
   private String  color;
   
     
			public Long getRango1() {
				return rango1;
			}
			public void setRango1(Long rango1) {
				this.rango1 = rango1;
			}
			public Long getRango2() {
				return rango2;
			}
			public void setRango2(Long rango2) {
				this.rango2 = rango2;
			}
			public String getColor() {
				return color;
			}
			public void setColor(String color) {
				this.color = color;
			}
			
 }
