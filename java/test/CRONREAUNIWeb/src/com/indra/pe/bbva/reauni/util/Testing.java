package com.indra.pe.bbva.reauni.util;

import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;

import com.indra.pe.bbva.core.exception.DAOException;

public class Testing {
	public static void main(String[] a) throws DAOException {
		
		Calendar calendario = Calendar.getInstance();
		String fechaActual = calendario.get(Calendar.DAY_OF_MONTH)+"-"+calendario.get(Calendar.MONTH)+"-"+calendario.get(Calendar.YEAR);
		System.out.println(fechaActual);
	}

	public static void findByParams(Class c, Map<String, Object> maparib_val)
			throws DAOException {
		String criterio = " ";
		String query = "from " + c.getSimpleName() + " ";
		if (maparib_val != null && !maparib_val.isEmpty()) {
			criterio = " where ";
			for (Entry<String, Object> entri : maparib_val.entrySet())
				if (entri.getValue() instanceof String) {
					criterio = criterio + " " + entri.getKey() + " = '"
							+ entri.getValue() + "' and";
				} else {
					criterio = criterio + " " + entri.getKey() + " = "
							+ entri.getValue() + " and";
				}
			criterio = criterio.substring(0, criterio.length() - 3);
		}
		// list = getHibernateTemplate().find(query+criterio);
		
	}
}
