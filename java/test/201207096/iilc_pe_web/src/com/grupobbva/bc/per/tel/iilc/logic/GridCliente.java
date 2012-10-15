package com.grupobbva.bc.per.tel.iilc.logic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_conf_cabeceras_rep;
import com.grupobbva.bc.per.tel.iilc.common.NumeroUtil;
import com.grupobbva.bc.per.tel.iilc.dao.AdmDescCabRepDAO;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;


public class GridCliente {
	
	private static Logger log = Logger.getLogger(GridCliente.class);
	private Map<String, Tiilc_conf_cabeceras_rep> mapCarpeta;
	
	public Map<String, Tiilc_conf_cabeceras_rep> getListaCarpeta() {
		return mapCarpeta;
	}

	public Multitabla[] datosCabeceras(long tipoDetalle) {
		return datosCabeceras(tipoDetalle, true);
	}
	
	@SuppressWarnings("unchecked")
	public Multitabla[] datosCabeceras(long tipoDetalle, boolean link) {
		int i;
		Multitabla[] result = new Multitabla[0];

		String tipo = String.valueOf(7 + tipoDetalle);
		AdmDescCabRepDAO daolistado = new AdmDescCabRepDAO();
		List<Tiilc_conf_cabeceras_rep> tempCarpeta = daolistado.obtenerDescripcion(tipo);
		List<Tiilc_conf_cabeceras_rep> listaCarpeta = new ArrayList<Tiilc_conf_cabeceras_rep>();
		mapCarpeta = new HashMap<String, Tiilc_conf_cabeceras_rep>(); 
		
		if(tempCarpeta != null) {
			for(Tiilc_conf_cabeceras_rep o : tempCarpeta) {
				if(!o.getOculto().equalsIgnoreCase("1")) {
					listaCarpeta.add(o);
				}
			}
			
			result = new Multitabla[listaCarpeta.size()];
			for(i = 0; i < result.length; i++) {
				
				mapCarpeta.put(listaCarpeta.get(i).getFuncion(), listaCarpeta.get(i));
				
				result[i] = new Multitabla();
				if(link) {
					result[i].setValor1("<a asc='1' title='" + listaCarpeta.get(i).getDeslarga() +  "' colName='" + listaCarpeta.get(i).getFuncion().substring(3, listaCarpeta.get(i).getFuncion().length()) + "' class='sortHeader' href='javascript:void(0);' onclick='sortHeader($(this));'>" + listaCarpeta.get(i).getDescorta() + "</a>");
				} else {
					result[i].setValor1(listaCarpeta.get(i).getDescorta());
				}
				
				if(link) {
					String estilo[] = listaCarpeta.get(i).getEstilo().split(","); 
					result[i].setValor2(estilo[0]);
					result[i].setValor3(estilo[1]);
				} else {
					result[i].setValor2(listaCarpeta.get(i).getAgrupador1());
					result[i].setValor3(listaCarpeta.get(i).getAgrupador2());
				}
				
				result[i].setValor4(listaCarpeta.get(i).getFuncion());
			}
		}
		
		// log.info("Columnas: " + listaCarpeta.size());
		return result;
	}
	
	public String[][] datosResultados(Vector<Cliente> lista, int numColumnas, int numTab, Multitabla[] cabecera) {
		int i;
		int j;
		int numFilas = lista.size();
		String[][] resultados = new String[numFilas][numColumnas];

		Class<?> object;	
		Class<?> parameterType[] = {};
		Object arguments[] ={};
		Object value;
		Object value2;
		String string;
		BigDecimal number;
		Method method;
		String temp;
		
		for(i = 0; i < numFilas; i++) {
			Cliente bean = lista.elementAt(i);

			for(j = 0; j < cabecera.length; j++) {
				value = "";
				
				try {
					object = bean.getClass();
					method = object.getMethod(cabecera[j].getValor4(), parameterType);
					value = method.invoke(bean, arguments);
					
					temp = cabecera[j].getValor4();
					if(temp == null) {
						temp = "";
					}
					if(temp.equalsIgnoreCase("getCodigo") && value.toString().toLowerCase().indexOf("total") == -1) {
						value = "<a href='javascript:void(0);' class='linkDetalle' onclick='verDetalle($(this));'>"  + value.toString() + "</a>";
					}
					
					if((temp.equalsIgnoreCase("getph") || temp.equalsIgnoreCase("getmphpasv"))) {
						try {
							if(temp.equalsIgnoreCase("getph")) {
								number = new BigDecimal(value.toString());
								method = object.getMethod("getMphpasv", parameterType);
								value2 = method.invoke(bean, arguments);
								if(value2 == null) {
									value2 = "";
								}
								string = value2.toString();
							} else {
								string = value.toString();
								method = object.getMethod("getPh", parameterType);
								value2 = method.invoke(bean, arguments);
								if(value2 == null) {
									value2 = "0.00";
								}
								number = new BigDecimal(value2.toString());
							}							
						} catch(NumberFormatException e) {
							number = BigDecimal.ZERO;
							string = "";
						} catch(NullPointerException e) {
							// log.error(e);
							number = BigDecimal.ZERO;
							string = "";
						}
												
						if (number.compareTo(BigDecimal.ZERO) == 0 && (string != null && !string.equals(""))) {
							value = "<div style='color:#000000; background: #FFFF66;' >" + value.toString() + "</div>";
						}
					}
					
					if(temp.equalsIgnoreCase("getTconsactv") 
							|| temp.equalsIgnoreCase("getTsubactv")
							|| temp.equalsIgnoreCase("getThipotactv")
							|| temp.equalsIgnoreCase("getTvehicactv")
							|| temp.equalsIgnoreCase("getTcuot36act")
							|| temp.equalsIgnoreCase("getTcuot48act")
							|| temp.equalsIgnoreCase("getCs000montocta60")
							|| temp.equalsIgnoreCase("getTcuot60act")
							|| temp.equalsIgnoreCase("getCs000presmena5000")
							|| temp.equalsIgnoreCase("getCs000comisdesemen5000")
							|| temp.equalsIgnoreCase("getCs000pres5000a15000")
							|| temp.equalsIgnoreCase("getC5000comdes15000act")
							|| temp.equalsIgnoreCase("getCs000presmaya15000")
							|| temp.equalsIgnoreCase("getComdes15000ac")
							|| temp.equalsIgnoreCase("getCs000prestcmena5000")
							|| temp.equalsIgnoreCase("getCs000prestc500015000")
							|| temp.equalsIgnoreCase("getCs000prestcmaya15000")) {
						
						try {
							number = new BigDecimal(value.toString());
						} catch(NumberFormatException e) {
							log.error(e);
							number = BigDecimal.ZERO;
						}
						
						value = NumeroUtil.redondeaAString(number, 2);
					}
					// log.info("{row: " + i + ", col: " + j + ", method: " + method.getName() + ", Valor obtenido por invoke: " + value + "},");
					
				} catch (SecurityException e) {
					log.error("datosResultados", e);
				} catch (NoSuchMethodException e) {
					log.error("datosResultados", e);
				} catch (IllegalArgumentException e) {
					log.error("datosResultados", e);
				} catch (IllegalAccessException e) {
					log.error("datosResultados", e);
				} catch (InvocationTargetException e) {
					log.error("datosResultados", e);
				} catch (NullPointerException e) {
					log.error("datosResultados", e);
					value = "";
				} finally {
					if(value == null){
						value = "";
					}
					resultados[i][j] = value.toString();				
				}
			}
		}

		return resultados;
	}
	
	public Multitabla[] validacion_cabecera(Cliente total, int numColumnas, int numTab, Multitabla[] cabecera, boolean todos) {
		List<Multitabla> result = new ArrayList<Multitabla>();

		int i = 0;
		
		Class<?> object;	
		Class<?> parameterType[] = {};
		Object arguments[] ={};
		Object value;
		Method method = null;
		BigDecimal val;
		String temp;
		
		for(i = 0; i < cabecera.length; i++) {
			Tiilc_conf_cabeceras_rep header = mapCarpeta.get(cabecera[i].getValor4());
			try {
				value = 0;
				try {
					object = total.getClass();
					method = object.getMethod(cabecera[i].getValor4(), parameterType);
					value = method.invoke(total, arguments);
					
					if(header.getDetalle().indexOf(",1")>-1) {
						try {
							if(value != null) {
								val = new BigDecimal(value.toString());
							} else {
								val = BigDecimal.ZERO;
							}
						} catch(NumberFormatException e) {
							val = BigDecimal.ZERO;
						} catch(Exception e) {
							log.error(e);
							val = BigDecimal.ZERO;
						}
						
						if(val.compareTo(BigDecimal.ZERO) == 1) {
							result.add(cabecera[i]);
						}
						
					} else if(header.getDetalle().indexOf(",-1")>-1) {
						String[] col = header.getDetalle().split(","); 
						method = object.getMethod(col[2], parameterType);
						value = method.invoke(total, arguments);
						try {
							val = new BigDecimal(value.toString());
						} catch(Exception e) {
							log.error(e);
							val = BigDecimal.ZERO;
						}
						
						if(val.compareTo(BigDecimal.ZERO) == 1) {
							result.add(cabecera[i]);
						}
					} else {
						if(todos) {
							String tempCol = cabecera[i].getValor4();
							if(tempCol == null) {
								tempCol = "";
							}
							if(value != null && !(tempCol.equalsIgnoreCase("getCodigo") 
									|| tempCol.equalsIgnoreCase("getNombre")
									|| tempCol.equalsIgnoreCase("getTipo_persona")
									|| tempCol.equalsIgnoreCase("getEstcivil")
									|| tempCol.equalsIgnoreCase("getPrefijo")
									|| tempCol.equalsIgnoreCase("getTelefono")
									|| tempCol.equalsIgnoreCase("getSegment1")
									|| tempCol.equalsIgnoreCase("getVinculacion")) ) {
								temp = value.toString();
								if( temp.length() > 0 && !temp.equalsIgnoreCase("0")) {
									result.add(cabecera[i]);
								}
								//--> log.info("col: " + i + ", method: " + method.getName() + ", Valor obtenido por invoke: " + value);
							}
						} else {
							result.add(cabecera[i]);
						}
						
					}
					
				} catch (SecurityException e) {
					log.error(e);
				} catch (NoSuchMethodException e) {
					log.error(e);
				} catch (IllegalArgumentException e) {
					log.error(e);
				} catch (IllegalAccessException e) {
					log.error(e);
				} catch (InvocationTargetException e) {
					log.error(e);
				} catch (NullPointerException e) {
					log.error(e);
				}
				// log.info(header.getDetalle());
			} catch(NullPointerException e) {
				log.error(e);
			}
		}
		
		Multitabla[] o = new Multitabla[0];
		return result.toArray(o);
	}
	
	public Multitabla[] validacion_cabecera(Vector<Cliente> lista, int numColumnas, int numTab, Multitabla[] cabecera) {
		int numFilas = lista.size();
		int posicion_totales = 1;
		if (lista.elementAt(lista.size() - 2).getCodigo().substring(0, 1).equals("T")) {
			posicion_totales = 2;
		}
		int indexTotal = numFilas - posicion_totales;
		Cliente total = lista.get(indexTotal);
		
		return validacion_cabecera(total, numColumnas, numTab, cabecera, false);
	}
	
	@SuppressWarnings("unchecked")
	public Multitabla[] obtieneCabeceraExcel(long tipoDetalle, Vector<Cliente> lista) {
		int i;
		Multitabla[] multitabla = new Multitabla[0];
		String tipo = String.valueOf(7 + tipoDetalle);
		AdmDescCabRepDAO daolistado = new AdmDescCabRepDAO();
		List<Tiilc_conf_cabeceras_rep> tempCarpeta = daolistado.obtenerDescripcion(tipo);
		List<Tiilc_conf_cabeceras_rep> listaCarpeta = new ArrayList<Tiilc_conf_cabeceras_rep>();
		mapCarpeta = new HashMap<String, Tiilc_conf_cabeceras_rep>(); 
		
		if(tempCarpeta != null) {
			for(Tiilc_conf_cabeceras_rep o : tempCarpeta) {
				if(!o.getOculto().equalsIgnoreCase("1")) {
					listaCarpeta.add(o);
				}
			}
			
			multitabla = new Multitabla[listaCarpeta.size()];
			for(i = 0; i < multitabla.length; i++) {
				mapCarpeta.put(listaCarpeta.get(i).getFuncion(), listaCarpeta.get(i));
				
				multitabla[i] = new Multitabla();
				multitabla[i].setValor1(listaCarpeta.get(i).getDeslarga());
				multitabla[i].setValor2(listaCarpeta.get(i).getAgrupador1() == null ? "" : listaCarpeta.get(i).getAgrupador1());
				multitabla[i].setValor3(listaCarpeta.get(i).getAgrupador2() == null ? "" : listaCarpeta.get(i).getAgrupador2());
				multitabla[i].setValor4(listaCarpeta.get(i).getFuncion());
			}
		}
		
		Multitabla[] cabecera = validacion_cabecera(lista, 0, 0, multitabla);
		return cabecera;
	}
}
