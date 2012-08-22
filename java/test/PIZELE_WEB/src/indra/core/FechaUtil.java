package indra.core;

import indra.bbva.pizele.domain.base.Semana;
import indra.bbva.pizele.service.ParametroService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class FechaUtil {

	public static final String  YYYYMMDD_HHMMSS = "yyyyMMdd-hhmmss";
	public static final int SEMANA_CON_TRES_DIAS_HABILES = 3;
	public static final int SEMANA_CON_CUARTO_DIAS_HABILES = 4;
	
	
	public static String getFechaActualString(){
		DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
		return dateFormat.format(new Date());
	}
	public static Date getFechaActualDate(){		
		return new Date();
	}
	
	public static String formatFecha(Date fecha,
									 String format){
		if(fecha != null)
		{
			Locale currentLocale = new Locale("pe","ES");
			DateFormat dateFormat = new SimpleDateFormat(format,
		    				 				 			 currentLocale);
			
			return dateFormat.format(fecha);
		}
		else
			return "";
	}
	
	public static Date formatoFechaDate(String fecha) throws ParseException{
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
		return formatoDelTexto.parse(fecha);
	}
	
	public static String obtenerDiaFinal(int anio, String mes) throws ParseException
	{
		String fecha = "01/" + mes + "/" + anio;
		Locale currentLocale = new Locale("pe","ES");
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy",currentLocale);		
		Calendar calendar = GregorianCalendar.getInstance(currentLocale);

		calendar.setTime(formatoDelTexto.parse(fecha));		
		int dia = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		if(dia < 10)
			return "0" + dia;
		else
			return String.valueOf(dia);		
	}
	
	public static String formatoFechaDate(String fecha,String formato) throws ParseException{
		Locale currentLocale = new Locale("pe","ES");
		DateFormat dateFormat = new SimpleDateFormat(formato,
	    				 				 			 currentLocale);
		
		return dateFormat.format(fecha);
	}
		
	public static int anioActual()
	{
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		return calendar.get(Calendar.YEAR);
	}
	
	public static int semanaActual()
	{
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}
	
	public static String anioActual_yy()
	{
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		return String.valueOf(calendar.get(Calendar.YEAR)).substring(2, 4);
	}
	
	public static String diaActual()
	{
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		if(dia < 10)
			return "0" + dia;
		else
			return String.valueOf(dia);
	}
	
	public static String mesActual()
	{
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		int mes = calendar.get(Calendar.MONTH);
		mes++;
		if(mes < 10)
			return "0" + mes;
		else
			return String.valueOf(mes);
	}
	
	/**
	 * compara dos fechas 
	 * si la primera fecha es menor retorna 1
	 * si las dos fechas son iguales retorna 0
	 * si la segunda fecha es menor retorna -1
	 * @param firstDate
	 * @param endDate
	 * @return
	 */	
	public static int compareDate(Date firstDate, 
								  Date endDate){
		//quitar la hora minutos y segundos
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(firstDate);
		Calendar calendarFirst = new GregorianCalendar(calendar.get(Calendar.YEAR),
													   calendar.get(Calendar.MONTH),
													   calendar.get(Calendar.DATE));
		calendar.setTime(endDate);
		Calendar calendarEnd = new GregorianCalendar(calendar.get(Calendar.YEAR),
													 calendar.get(Calendar.MONTH),
													 calendar.get(Calendar.DATE));
		
		if(calendarFirst.getTime().getTime() < calendarEnd.getTime().getTime()){
			return 1;
		}else if(calendarFirst.getTime().getTime() == calendarEnd.getTime().getTime()){
			return 0;
		}else{
			return -1;
		}
	}
		
	public static String format_yyyyMMdd(String fecha)
	{
		String[] nums = fecha.split("\\/");
		return nums[2] + nums[1] + nums[0]; 
	}
	
	public static int mesActualToInt()
	{
		return Integer.parseInt(mesActual());
	}
	
	public static int omitirPrimeraSemanaDelMesActual(int anio, int mes) {
		int[] diasHabiles = obtenerDiasUtiles(anio, mes);
		return diasHabiles[0]; 		
	}
	
	public static int[] obtenerDiasUtiles(int _anio, int _mes){
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		ParametroService parametroService = (ParametroService) context.getBean("parametroService");
		
		Long mes = Long.valueOf(_mes);
		Long anio = Long.valueOf(_anio);
		List<Semana> semanas = parametroService.diasHabiles(mes, anio);
		int[] diasUtilesArray = new int[semanas.size()];
		
		for(int i = 0; i < semanas.size(); i++) {
			diasUtilesArray[i] = semanas.get(i).getHabiles().intValue();
		}
		
		return diasUtilesArray;
	}
	
}
