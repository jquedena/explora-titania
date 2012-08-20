package com.grupobbva.bc.per.tel.iilc.common;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;


/*
 * @author Henry Tong - 12/01/2005
 * Funciones utilitarias para trabajar con numeros
 */
public class NumeroUtil
{
	
	/**
	 * Method redondea
	 * @param numero
	 * @param numeroDecimales
	 * @return BigDecimal
	 */
	public static BigDecimal redondea(BigDecimal numero, int numeroDecimales){
		if(numero != null)
			return numero.setScale(numeroDecimales,BigDecimal.ROUND_HALF_UP);
		
		return null;
	}
	
	//variables basicas
	private static DecimalFormatSymbols dSymbol = null;
	private static void init()	
	{
		//INICIALIAR valores por defecto
		if (NumeroUtil.dSymbol==null)
			{
				NumeroUtil.dSymbol = new DecimalFormatSymbols();
				NumeroUtil.dSymbol.setDecimalSeparator('.');  // diferente aqui
				NumeroUtil.dSymbol.setGroupingSeparator(',');
			}	
	}
	
	/**
	 * Method redondea
	 * @param d
	 * @param posiciones
	 * @return double
	 */
	public static double redondea(double d, int posiciones)
	{
		/* Metodo para redondear un double al numero de posiciones
		 * decimales especificado
		 * 
		 * Ejemplo:
		 * 
		 * redondea(2.2375 , 3) --resulta--> 2.238
		 * 
		 */
		long factor = (long)Math.pow(10, posiciones);
		d = d * factor;
		long tmp2 = Math.round(d);
		return ((double)tmp2 / factor);
	}
	
	/**
	 * Convertir un double primitivo a un String
	 * indicando cantidad de cifras decimales
	 * Henry Tong - mayo2005
	 */
	public static String redondeaAString(double d, int posiciones)
	{
		NumeroUtil.init();
		
		StringBuffer patron = new StringBuffer("#0.");
		for (int i = 1; i <=posiciones; i++)
		{
			patron.append("0");
		}
		DecimalFormat myFormatter = new DecimalFormat();
		if (posiciones>0)
			myFormatter.applyPattern(patron.toString());
		else
			myFormatter.applyPattern("#0");
		myFormatter.setDecimalFormatSymbols(NumeroUtil.dSymbol);
		return myFormatter.format(d);
	}
	/**
	 * Method redondeaAString
	 * @param D
	 * @param posiciones
	 * @return String
	 */
	public static String redondeaAString(Double D, int posiciones)
	{
		return NumeroUtil.redondeaAString(D.doubleValue(),posiciones);
	}	
	
	/**
	 * Convertir un BigDecimal a un String
	 * indicando cantidad de cifras decimales
	 * Henry Tong - mayo2005
	 */
	public static String redondeaAString(BigDecimal bd, int posiciones)
	{
		return ( bd.setScale(posiciones,BigDecimal.ROUND_HALF_UP) ).toString();
	}	
	
	/**
	 * Method setScale
	 * @param numero
	 * @param escala
	 * @return BigDecimal
	 */
	public static BigDecimal setScale(BigDecimal numero, int escala)
	{
		if (numero == null)
			return null;
		return numero.setScale(escala, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal cambiaNuloACero(BigDecimal numero)
	{
		if (numero == null)
			return new BigDecimal(0);
		return numero;
	}
	
	
	public static double truncar(double nD, int nDec)
	{
	  if(nD > 0)
	    nD = Math.floor(nD * Math.pow(10,nDec))/Math.pow(10,nDec);
	  else
	    nD = Math.ceil(nD * Math.pow(10,nDec))/Math.pow(10,nDec);

	  return nD;
	}

	
	/**
	 * Method calcularPorcentaje
	 * @param dividendo
	 * @param divisor
	 * @return BigDecimal
	 */
	public static BigDecimal calcularPorcentaje(BigDecimal dividendo, BigDecimal divisor)
	{
		return NumeroUtil.multiplicaDosNumeros(NumeroUtil.divideDosNumeros(dividendo, divisor), new BigDecimal(100));
	}
	
	/**
	 * Method multiplicaDosNumeros
	 * @param a
	 * @param b
	 * @return BigDecimal
	 */
	public static BigDecimal multiplicaDosNumeros(String a, String b)
	{
		if (a != null && b != null && (!"".equals(a.trim()) || !"".equals(b.trim())))
		{
			if ("".equals(a.trim()))
				a = "0";
			if ("".equals(b.trim()))
				b = "0";
			BigDecimal producto = new BigDecimal(a).multiply(new BigDecimal(b));
			//producto = producto.setScale(6, BigDecimal.ROUND_HALF_UP);
			return producto;
		}
		else
		{
			return null;
		}
	}
	/**
	 * Method stringDouble
	 * @param a
	 * @return Double
	 */
	public static Double stringDouble(String a)
	{
		Double dongs = null;
		if (a != null && !"".equals(a.trim()))
		{
			dongs = new Double(a.trim());
		}
		return dongs;
	}

	public static Double stringToDouble(String a, int enteros, int decimales)
	{
		Double dongs = null;
		if (a != null && !"".equals(a.trim()))
		{
			int indPunto = a.indexOf('.');
			if(indPunto != -1 )
			{
				if( a.substring(0, indPunto).length() <= enteros 
						&& a.substring(indPunto, a.length()).length() <= decimales )
				{
					dongs = new Double(a.trim());
				}				
			}else{
				dongs = new Double(a.trim());
			}
			
		}
		return dongs;
	}
	/**
	 * Method elevaPotencia
	 * @param numero
	 * @param potencia
	 * @return BigDecimal
	 */
	public static BigDecimal elevaPotencia(BigDecimal numero, int potencia){
		BigDecimal res=new BigDecimal(Math.pow(numero.doubleValue(),(double) potencia));
		res=res.setScale(6, BigDecimal.ROUND_HALF_UP);
		return res;
	}

	/**
	 * Method sacaRaiz
	 * @param numero
	 * @param raiz
	 * @return BigDecimal
	 */
	public static BigDecimal sacaRaiz(BigDecimal numero, int raiz){
		BigDecimal res=new BigDecimal(Math.pow(numero.doubleValue(),1d/(double) raiz));
		res=res.setScale(6, BigDecimal.ROUND_HALF_UP);
		return res;
	}

	/**
	 * Method multiplicaDosNumeros
	 * @param a
	 * @param b
	 * @return BigDecimal
	 */
	public static BigDecimal multiplicaDosNumeros(BigDecimal a, BigDecimal b)
	{
		if (a != null && b != null)
		{
			BigDecimal producto = a;
			producto = producto.multiply(b);
			//producto = producto.setScale(6, BigDecimal.ROUND_HALF_UP);
			return producto;
		}
		else
		{
			return null;
		}
	}
	/**
	 * Method multiplicaDosNumeros
	 * @param a
	 * @param b
	 * @return BigDecimal
	 */
	public static BigDecimal multiplicaDosNumeros(String a, BigDecimal b)
	{
		BigDecimal producto = null;
		if (a != null && !"".equals(a.trim()) && b != null)
		{
			producto = b;
			producto = producto.multiply(new BigDecimal(a.trim()));
			//  producto = producto.setScale(6, BigDecimal.ROUND_HALF_UP);
		}
		return producto;
	}
	/**
	 * Method sumaDosNumeros
	 * @param a
	 * @param b
	 * @return BigDecimal
	 */
	public static BigDecimal sumaDosNumeros(String a, String b)
	{
		if (a != null)
			a = a.trim();
		if (b != null)
			b = b.trim();
		if ((a != null || b != null) && (!"".equals(a) || !"".equals(b)))
		{
			if (a == null)
				a = "0";
			if (b == null)
				b = "0";
			if ("".equals(a))
				a = "0";
			if ("".equals(b))
				b = "0";
			BigDecimal suma = new BigDecimal(a).add(new BigDecimal(b));
			// suma = suma.setScale(6, BigDecimal.ROUND_HALF_UP);
			return suma;
		}
		else
			return null;
	}
	/**
	 * Method sumaDosNumeros
	 * @param a
	 * @param b
	 * @return BigDecimal
	 */
	public static BigDecimal sumaDosNumeros(BigDecimal a, BigDecimal b)
	{
		if (a != null || b != null)
		{
			if (a == null)
				a = new BigDecimal("0");
			if (b == null)
				b = new BigDecimal("0");
			BigDecimal suma = a;
			suma = suma.add(b);
			// suma = suma.setScale(6, BigDecimal.ROUND_HALF_UP);
			return suma;
		}
		else
			return null;
	}
	/**
	 * Method sumaDosNumeros
	 * @param a
	 * @param b
	 * @return BigDecimal
	 */
	public static BigDecimal sumaDosNumeros(String a, BigDecimal b)
	{
		if (a != null)
			a = a.trim();
		if ((a != null || b != null) && (!"".equals(a) || b != null))
		{
			if (a == null)
				a = "0";
			if ("".equals(a))
				a = "0";
			if (b == null)
				b = new BigDecimal("0");
			BigDecimal suma = new BigDecimal(a).add(b);
			// suma = suma.setScale(6, BigDecimal.ROUND_HALF_UP);
			return suma;
		}
		else
			return null;
	}
	/**
	 * Method restaDosNumeros
	 * @param minuendo
	 * @param substraendo
	 * @return BigDecimal
	 */
	public static BigDecimal restaDosNumeros(String minuendo, String substraendo)
	{
		if (minuendo != null)
			minuendo = minuendo.trim();
		if (substraendo != null)
			substraendo = substraendo.trim();
		if ((minuendo != null || substraendo != null) && (!"".equals(minuendo) || !"".equals(substraendo)))
		{
			if (minuendo == null)
				minuendo = "0";
			if (substraendo == null)
				substraendo = "0";
			if ("".equals(minuendo))
				minuendo = "0";
			if ("".equals(substraendo))
				substraendo = "0";
			BigDecimal resta = new BigDecimal(minuendo).subtract(new BigDecimal(substraendo));
			//resta = resta.setScale(6, BigDecimal.ROUND_HALF_UP);
			return resta;
		}
		else
			return null;
	}
	/**
	 * Method restaDosNumeros
	 * @param minuendo
	 * @param substraendo
	 * @return BigDecimal
	 */
	public static BigDecimal restaDosNumeros(BigDecimal minuendo, BigDecimal substraendo)
	{
		if (minuendo != null || substraendo != null)
		{
			if (minuendo == null)
				minuendo = new BigDecimal("0");
			if (substraendo == null)
				substraendo = new BigDecimal("0");
			BigDecimal resta = minuendo;
			resta = resta.subtract(substraendo);
			//	   resta = resta.setScale(6, BigDecimal.ROUND_HALF_UP);
			return resta;
		}
		else
			return null;
	}
	/**
	 * Method divideDosNumeros
	 * @param dividendo
	 * @param divisor
	 * @return BigDecimal
	 */
	public static BigDecimal divideDosNumeros(BigDecimal dividendo, BigDecimal divisor)
	{
		BigDecimal cociente = null;
		if (dividendo != null && divisor != null)
		{
			cociente = dividendo.divide(divisor, 10, BigDecimal.ROUND_HALF_EVEN);
		}
		return cociente;
	}
	/**
	 * Method divideDosNumeros
	 * @param dividendo
	 * @param divisor
	 * @return BigDecimal
	 */
	public static BigDecimal divideDosNumeros(String dividendo, BigDecimal divisor)
	{
		BigDecimal cociente = null;
		if (dividendo != null && !dividendo.trim().equals("") && divisor != null)
		{
			cociente = new BigDecimal(dividendo);
			cociente = cociente.divide(divisor, 10, BigDecimal.ROUND_HALF_EVEN);
		}
		return cociente;
	}
	
	
	/* Se evalua: primero < segundo */
	/**
	 * Method esMenor
	 * @param primero
	 * @param segundo
	 * @return boolean
	 */
	public static boolean esMenor(BigDecimal primero, BigDecimal segundo){
		if (primero == null)
			return true;
		if (segundo == null)
			return false;
		switch (primero.compareTo(segundo))
		{
			case -1 :
				return true;
			default :
				return false;
		}
	}
	/**
	 * Method esMenor
	 * @param primero
	 * @param segundo
	 * @return boolean
	 */
	public static boolean esMenor(BigDecimal primero, long segundo){
		if (primero == null)
			return true;
		BigDecimal segundoB = new BigDecimal(segundo);
		switch (primero.compareTo(segundoB))
		{
			case -1 :
				return true;
			default :
				return false;
		}
	}

	/* Se evalua: primero > segundo */
	/**
	 * Method esMayor
	 * @param primero
	 * @param segundo
	 * @return boolean
	 */
	public static boolean esMayor(BigDecimal primero, BigDecimal segundo){
		if (primero == null)
			return false;
		if (segundo == null)
			return true;
		switch (primero.compareTo(segundo))
		{
			case 1 :
				return true;
			default :
				return false;
		}
	}
	/**
	 * Method esMayor
	 * @param primero
	 * @param segundo
	 * @return boolean
	 */
	public static boolean esMayor(double primero, BigDecimal segundo)
	{
		BigDecimal primero1 = new BigDecimal(primero);
		if (segundo == null)
			return true;
		switch (primero1.compareTo(segundo))
		{
			case 1 :
				return true;
			default :
				return false;
		}
	}
	/**
	 * Method esMayor
	 * @param primero
	 * @param segundo
	 * @return boolean
	 */
	public static boolean esMayor(BigDecimal primero, int segundo)
	{
		BigDecimal segundoB = new BigDecimal(segundo);
		switch (primero.compareTo(segundoB))
		{
			case 1 :
				return true;
			default :
				return false;
		}
	}
	
	/**
	 * Method esIgual
	 * @param primero
	 * @param segundo
	 * @return boolean
	 */
	public static boolean esIgual(BigDecimal primero, BigDecimal segundo)
	{
		
		if(primero == null &&  segundo == null)
			return false;
			
		if(primero == null)
			return false;

		if(segundo == null)
			return false;
			
		switch(primero.compareTo(segundo)){
			case 0 :
				return true;
			default :
				return false;
		}
	}
	
	
	public static boolean esIgual(Long primero, Long segundo){
		
		if(primero == null &&  segundo == null)
			return false;
			
		if(primero == null)
			return false;

		if(segundo == null)
			return false;
			
		switch(primero.compareTo(segundo)){
			case 0 :
				return true;
			default :
				return false;
		}
	}
		
	/**
	 * Method stringToLong
	 * @param string
	 * @return Long
	 */
	public static Long stringToLong( String string )
	{	
		Long longs = null;
		if( string != null && !"".equals( string.trim() ) )
		{
			longs = new Long( string.trim() );
		}
		return longs;
	}
	/**
	 * Method stringToBigDecimal
	 * @param string
	 * @return BigDecimal
	 */
	public static BigDecimal stringToBigDecimal(String string)
	{
		BigDecimal longs = null;
		if (string != null && !"".equals(string.trim()))
		{
			longs = new BigDecimal(string.trim());
		}
		return longs;
	}
	/**
	 * @param string
	 * @return
	 */
	public static String eliminaDecimales(String string)
	{
		if (string != null && string.indexOf(".") > 0)
			return string.substring(0, string.indexOf("."));
		return string;
	}
	/**
	 * Method eliminaDecimales
	 * @param d
	 * @return String
	 */
	public static String eliminaDecimales(double d)
	{
		return NumeroUtil.eliminaDecimales(String.valueOf(d));
	}
	/**
	 * Method isInt
	 * @param string
	 * @return boolean
	 */
	public static boolean isInt(String string)
	{
		try
		{
			Integer.parseInt(string);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	/**
	 * Method sumaDosNumeros
	 * @param long1
	 * @param long2
	 * @return Long
	 */
	public static Long sumaDosNumeros(Long long1, Long long2)
	{
		long l1 = 0;
		long l2 = 0;
		if (long1 != null)
			l1 = long1.longValue();
		if (long2 != null)
			l2 = long2.longValue();
		return new Long(l1 + l2);
	}
	/**
	 * Method restaDosNumeros
	 * @param long1
	 * @param long2
	 * @return Long
	 */
	public static Long restaDosNumeros(Long long1, Long long2)
	{
		long l1 = 0;
		long l2 = 0;
		if (long1 != null)
			l1 = long1.longValue();
		if (long2 != null)
			l2 = long2.longValue();
		return new Long(l1 - l2);
	}
	/**
	 * Method sumaDosNumeros
	 * @param double1
	 * @param double2
	 * @return Double
	 */
	public static Double sumaDosNumeros(Double double1, Double double2)
	{
		double d1 = 0;
		double d2 = 0;
		if (double1 != null)
			d1 = double1.doubleValue();
		if (double2 != null)
			d2 = double2.doubleValue();
		return new Double(d1 + d2);
	}
	/**
	 * Method restaDosNumeros
	 * @param double1
	 * @param double2
	 * @return Double
	 */
	public static Double restaDosNumeros(Double double1, Double double2)
	{
		double d1 = 0;
		double d2 = 0;
		if (double1 != null)
			d1 = double1.doubleValue();
		if (double2 != null)
			d2 = double2.doubleValue();
		return new Double(d1 - d2);
	}
	

	/**
	 * busca un numero en un arreglo
	 * mayor o igual a cERO)
	 * 
	 * devuelve un numero negativo si no lo encuentra.
	 * 
	 * Henry Tong - marzo 2005
	 */
	public static int buscaEnArreglo(int numero, int[] arreglo)
	{
		for (int i = 0; i < arreglo.length; i++)
		{
			if (arreglo[i] == numero)
				return i;
		}
		return -9;
	}
	/**
	 * factorizar un numero en sus numeros primos
	 * Henry Tong - marzo 2005
	 */
	public static int[] factorizar(int numero)
	{
		//obtener los factores de un numero
		//ejemplo: 60 = 2*2*5*3
		boolean flag1 = true;
		int w;
		java.util.ArrayList<Integer> alisf = new java.util.ArrayList<Integer>();
		while (flag1)
		{
			for (int i = 2; i <= numero; i++)
			{
				w = numero % i;
				if (w == 0)
				{
					//encontra un factor
					alisf.add(new Integer(i));
					numero = (numero / i);
					if (numero == 1)
					{
						//romper while
						flag1 = false;
					}
					//romper for
					break;
				}
			}
		}
		int[] resultado = new int[alisf.size()];
		for (int i = 0; i < alisf.size(); i++)
		{
			Integer iii = (Integer)alisf.get(i);
			resultado[i] = iii.intValue();
		}
		return resultado;
	}
	
	/**
	 * Convertir un numero a su equivalente negativo
	 * (Valida que el parametro de entrada ya este en negativo)
	 */
	public static double valorNegativo(double numero)
	{
		if (numero<0)
			return numero;
		return numero*-1;
	}
	
	/**
	 * Convertir un numero a su equivalente positivo
	 */
	public static double valorPositivo(double numero)
	{
		if (numero>=0)
			return numero;
		return numero*-1;
	}
	
	public static boolean esNegativoOrCero(BigDecimal monto){
//	el monto es negativo		 
		if(monto == null)return false;
		
		if(monto.signum() < 1)return true;
		else return false;
	}	
	
	public static boolean excedeAlMaximoPermitido(BigDecimal monto, int maximoPermitido)
	{
//	monto excede maximo permitido		
		if(monto == null) return false;
		
		BigDecimal monto1 = NumeroUtil.redondea(monto, 0);
		if(monto1.toString().length() > maximoPermitido)
			return true;
		else
		   return false;
	}
	/*
	public static String getNumeroAsStringWithPattern(BigDecimal bd, String pattern){
		/*String cadena = "";
		if( bd == null ) return cadena;
		return getNumeroAsStringWithPattern(bd.doubleValue(),pattern);*/
	/*	return getNumeroAsStringWithPattern(bd,pattern); 
	}*/
	
	/*public static String getNumeroAsStringWithPattern(Double d, String pattern){
		/*String cadena = "";
		if( d == null ) return cadena;
		return getNumeroAsStringWithPattern(d.doubleValue(),pattern);*/
	/*	return getNumeroAsStringWithPattern(d,pattern);		
	}*/
		
	public static String getNumeroAsStringWithPattern(double d, String pattern){
		String cadena = "";		
		DecimalFormat decFormat = (DecimalFormat)NumberFormat.getInstance(Locale.US);
		decFormat.applyPattern(pattern);
		cadena = decFormat.format(d);		
		return cadena; 
	}  
	 
	/*public static String getNumeroAsStringWithPattern(Long l, String pattern){
			/*String cadena = "";
			if( l == null ) return cadena;		
			DecimalFormat decFormat = (DecimalFormat)NumberFormat.getInstance(Locale.US);
			decFormat.applyPattern(pattern);
			cadena = decFormat.format(l.longValue());		
			return cadena;*/
	/*		return getNumeroAsStringWithPattern(l,pattern);     
	}*/
	
	public static String getNumeroAsStringWithPattern(Object o, String pattern){
			String cadena = "";
			if( o == null ) return cadena;		
			DecimalFormat decFormat = (DecimalFormat)NumberFormat.getInstance(Locale.US);
			decFormat.applyPattern(pattern);
			cadena = decFormat.format(o);		
			return cadena;     
	}
	
	public static BigDecimal sumaArrayBigDecimal(List lstbigDecimal)
	{
		BigDecimal total = null;
		for (Iterator iter = lstbigDecimal.iterator(); iter.hasNext();)
		{
			
			total = sumaDosNumeros(total, (BigDecimal) iter.next());
		} 
		return total;
	}
	
	public static BigDecimal[] ordenaArrayASC(BigDecimal[] arraybigDecimal)
	{
		BigDecimal temp;
		boolean cambio = true;
		while (cambio){
			cambio = false;
			for (int j=0;j<arraybigDecimal.length-1;j++){
				if(NumeroUtil.esMayor(arraybigDecimal[j], arraybigDecimal[j+1])){
					temp=arraybigDecimal[j+1];
					arraybigDecimal[j+1]=arraybigDecimal[j];
					arraybigDecimal[j]=temp;
					cambio = true;
				}
			} 
		}
		return arraybigDecimal;
	}
	public static BigDecimal[] ordenaArrayDES(BigDecimal[] arraybigDecimal)
	{
		BigDecimal temp;
		boolean cambio = true;
		while (cambio){
			cambio = false;
			for (int j=0;j<arraybigDecimal.length-1;j++){
				if(NumeroUtil.esMenor(arraybigDecimal[j], arraybigDecimal[j+1])){
					temp=arraybigDecimal[j+1];
					arraybigDecimal[j+1]=arraybigDecimal[j];
					arraybigDecimal[j]=temp;
					
					cambio = true;
				}
			} 
		}
		return arraybigDecimal;
	}
}
