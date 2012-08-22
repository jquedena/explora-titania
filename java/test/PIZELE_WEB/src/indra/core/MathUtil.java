package indra.core;

import java.math.BigDecimal;


public class MathUtil {

	public static long sumar(long[] datos){
		long suma = 0;
		
		for (long d : datos) {
			suma += d;
		}
		
		return suma;
	}
	
	public static BigDecimal sumar(BigDecimal[] datos){
		BigDecimal suma = new BigDecimal(0);
		
		for (BigDecimal d : datos) {
			suma.add(d);
		}
		
		return suma;
	}
}