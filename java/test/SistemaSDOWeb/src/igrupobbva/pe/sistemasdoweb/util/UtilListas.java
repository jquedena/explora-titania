/*
 * Created on 30/01/2009
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package igrupobbva.pe.sistemasdoweb.util;

import java.math.BigDecimal;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.log4j.Logger;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeCriterioBusqueda;
import com.grupobbva.bc.per.tele.ldap.directorio.IILDPeUsuario;
import com.grupobbva.bc.per.tele.sdo.serializable.CampaniasGeneral;
import com.grupobbva.bc.per.tele.sdo.serializable.Equivalencia;
import com.grupobbva.bc.per.tele.sdo.serializable.Gestor;
import com.grupobbva.bc.per.tele.sdo.serializable.MetasGestor;
import com.grupobbva.bc.per.tele.sdo.serializable.Multitabla;
import com.grupobbva.bc.per.tele.sdo.serializable.Oficina;
import com.grupobbva.bc.per.tele.sdo.serializable.PlanesAcciones;
import com.grupobbva.bc.per.tele.sdo.serializable.UsuarioLDAP;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;
/**
 * @author Stefanini
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings({"unchecked","unused"})
public class UtilListas {
	private static Logger log = Logger.getLogger(UtilListas.class);
	
	Connection conexion = new Connection();

	public Vector obtenerListAnhos(String anho, int rango) {
		Vector anhos = new Vector();
		
		// log.info("[UtilListas :: obtenerListAnhos] Inicio");
		
		for (int i = 0; i < rango; i++) {
			Multitabla multiAnho = new Multitabla();
			multiAnho.setCodMult("1");
			multiAnho.setCodelem(String.valueOf(Integer.parseInt(anho) - i));
			multiAnho.setValor1(String.valueOf(Integer.parseInt(anho) - i));
			anhos.add(multiAnho);
		}
		
		// log.info("[UtilListas :: obtenerListAnhos] Fin");
		
		return anhos;
	}

	public static String[] getArrayStrings(String cadena, String delim) {
		// log.info("[UtilListas :: getArrayStrings] Inicio");
		
		if (isStringBlank(cadena))
			return new String[0];
		
		StringTokenizer st = new StringTokenizer(cadena, delim);
		String[] array = new String[st.countTokens()];
		int indice = 0;
		while (st.hasMoreTokens()) {
			array[indice] = st.nextToken();
			indice++;
		}
		
		// log.info("[UtilListas :: getArrayStrings] Fin");
		return array;
	}

	public static boolean isStringBlank(String cadena) {
		boolean b = false;
		
		// log.info("[UtilListas :: isStringBlank] Inicio");
		if (cadena == null || cadena.trim().length() == 0)
			b = true;
		
		// log.info("[UtilListas :: isStringBlank] Fin");
		
		return b;
	}

	public Vector obtenerListPresup(String mes, String codPerfil) {
		int rango = 2;
		String valor2 = "2";
		Vector listPresup = new Vector();
		
		// log.info("[UtilListas :: obtenerListPresup] Inicio");
		
		int primerMesPresupuesto = conexion.obtenerPrimerMesPresup();

		if (codPerfil.equals("GTE")) {
			if (Integer.parseInt(mes) <= primerMesPresupuesto) {
				valor2 = "1";
				rango = 1;
			}
		} else {
			if (Integer.parseInt(mes) <= primerMesPresupuesto) {
				valor2 = "3";
				rango = 1;
			} else {
				valor2 = "4";
				rango = 1;
			}
		}
		try {
			listPresup = conexion.findByCodMulti("T14");
//			listPresup = conexion.findByMultiForPresup("T03", valor2);
		} catch (Exception e) {
			log.error("[UtilListas :: obtenerListPresup] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		// log.info("[UtilListas :: obtenerListPresup] Fin");
		
		return listPresup;
	}
	
	public String obtenerNomMesAnterior(String mes) {
		String mesAnterior = mes;
		
		// log.info("[UtilListas :: obtenerNomMesAnterior] Inicio");
		
		if (mes.equals("01")) {
			mesAnterior = "12";
		} else {
			if (Integer.parseInt(mes) > 10) {
				mesAnterior = String.valueOf(Integer.parseInt(mes) - 1);
			} else {
				mesAnterior = "0" + String.valueOf(Integer.parseInt(mes) - 1);
			}
		}
		
		// log.info("[UtilListas :: obtenerNomMesAnterior] Fin");
		
		return obtenerNomMes(mesAnterior);
	}

	public String obtenerNomMes(String mes) {
		String mesMostrar = "";
		
		// log.info("[UtilListas :: obtenerNomMes] Inicio");
		
		switch (Integer.parseInt(mes)) {
		case 1:
			mesMostrar = "Enero";
			break;
		case 2:
			mesMostrar = "Febrero";
			break;
		case 3:
			mesMostrar = "Marzo";
			break;
		case 4:
			mesMostrar = "Abril";
			break;
		case 5:
			mesMostrar = "Mayo";
			break;
		case 6:
			mesMostrar = "Junio";
			break;
		case 7:
			mesMostrar = "Julio";
			break;
		case 8:
			mesMostrar = "Agosto";
			break;
		case 9:
			mesMostrar = "Setiembre";
			break;
		case 10:
			mesMostrar = "Octubre";
			break;
		case 11:
			mesMostrar = "Noviembre";
			break;
		case 12:
			mesMostrar = "Diciembre";
			break;
		}
		
		// log.info("[UtilListas :: obtenerNomMes] Fin");
		
		return mesMostrar;
	}

	public Gestor buscarGestor(String codigoUsuario) {
		Gestor gestor = null;
		
		try {
			// log.info("[UtilListas :: buscarGestor] Inicio");
			
			IILDPeUsuario user = IILDPeUsuario.recuperarUsuario(codigoUsuario);

			String NombreGestor = user.getNombreCompleto();
			String codigoCargo = user.getCargo().getCodigo();

			Equivalencia equivalencia = conexion.findEquivalenciaByCodCargo(codigoCargo);
			if (equivalencia != null) {
				String codigoPerfil = equivalencia.getCodPerfil();
				String perfilMostrar = equivalencia.getPerfil();
				String codigoOficina = user.getBancoOficina().getCodigo();
				Oficina oficina = conexion.findByCodOficina(codigoOficina);
				gestor = new Gestor();
				gestor.setCodigoGestor(codigoUsuario);
				gestor.setPasswordGestor("");
				gestor.setNombreGestor(NombreGestor);
				gestor.setCodigoPerfil(codigoPerfil);
				gestor.setPerfilMostrar(perfilMostrar);
				gestor.setCodigoOficina(codigoOficina);
				gestor.setCodigoTerritorio(oficina.getTerr().getCodTerr());
			}
			
			// log.info("[UtilListas :: buscarGestor] Fin");
		} catch (Exception e) {
			log.error("[UtilListas :: buscarGestor] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		return gestor;
	}

	public Vector listarGestoresNormal(String codOficina) {
		Vector vistaGestores = new Vector();
		String condicion = "GOF";
		Connection con = new Connection();
		
		try {
			// log.info("[UtilListas :: listarGestoresNormal] Inicio");
			
			IILDPeCriterioBusqueda cb = new IILDPeCriterioBusqueda();
			cb.setCodigoOficina(codOficina);
			cb.setCodigoEmpresa(getOficinaBanco());
			cb.setLimiteOcurrencias(100);
			Vector vectorGestores = con.buscarUsuariosLDAP(codOficina, getOficinaBanco(), 100);
			if (vectorGestores != null) {
				for (int j = 0; j < 5; j++) {
					switch (j) {
					case 1:
						condicion = "GPE";
						break;
					case 2:
						condicion = "GCO";
						break;
					case 3:
						condicion = "GPT";
						break;
					case 4:
						condicion = "EEM";
						break;
					}
					for (int i = 0; i < vectorGestores.size(); i++) {
						UsuarioLDAP usuarioEncontrado = (UsuarioLDAP) vectorGestores.elementAt(i);
						Gestor gestor = new Gestor();
						gestor.setCodigoGestor(usuarioEncontrado.getUID());
						gestor.setNombreGestor(usuarioEncontrado.getNombreCompleto());
						Equivalencia equivalencia = conexion.findEquivalenciaByCodCargo(usuarioEncontrado.getCodigoCargo());
						if (equivalencia != null) {
							if (equivalencia.getCodPerfil() != null) {
								if (equivalencia.getCodPerfil().equals(condicion)) {
									String codigoPerfil = equivalencia.getCodPerfil();
									String perfilMostrar = equivalencia.getPerfil();
									Oficina oficina = conexion.findByCodOficina(codOficina);
									gestor.setCodigoPerfil(codigoPerfil);
									gestor.setPerfilMostrar(perfilMostrar);
									gestor.setCodigoOficina(codOficina);
									gestor.setCodigoTerritorio(oficina.getTerr().getCodTerr());
									vistaGestores.addElement(gestor);
								}
							}
						}
					}
				}
			}
			
			// log.info("[UtilListas :: listarGestoresNormal] Fin");
			return vistaGestores;
		} catch (Exception e) {
			log.error("[UtilListas :: listarGestoresNormal] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
	}

	public Vector listarGestores(String codigoOficina, String codEpigrafe, String mes, String anho) {
		Vector vistaGestores = new Vector();
		String condicion = "GOF";
		Connection con = new Connection();

		try {
			// log.info("[UtilListas :: listarGestores] Inicio");
			
			IILDPeCriterioBusqueda cb = new IILDPeCriterioBusqueda();
			cb.setCodigoOficina(codigoOficina);
			cb.setCodigoEmpresa(getOficinaBanco());
			cb.setLimiteOcurrencias(5);
			Vector vectorGestores = con.buscarUsuariosLDAP(codigoOficina, getOficinaBanco(), 100);
			if (vectorGestores != null) {
				for (int j = 0; j < 5; j++) {
					switch (j) {
					case 1:
						condicion = "GPE";
						break;
					case 2:
						condicion = "GCO";
						break;
					case 3:
						condicion = "GPT";
						break;
					case 4:
						condicion = "EEM";
						break;
					}
					for (int i = 0; i < vectorGestores.size(); i++) {
						UsuarioLDAP usuarioEncontrado = (UsuarioLDAP) vectorGestores.elementAt(i);
						Gestor gestor = new Gestor();
						gestor.setCodigoGestor(usuarioEncontrado.getUID());
						gestor.setNombreGestor(usuarioEncontrado.getNombreCompleto());
						Equivalencia equivalencia = conexion.findEquivalenciaByCodCargo(usuarioEncontrado.getCodigoCargo());
						MetasGestor metaGestor = new MetasGestor();
						BigDecimal prom = BigDecimal.ZERO;
						if (equivalencia != null) {
							if (equivalencia.getCodPerfil() != null) {
								if (equivalencia.getCodPerfil().equals(condicion)) {
									gestor.setCodigoPerfil(equivalencia.getCodPerfil());
									gestor.setPerfilMostrar(equivalencia.getPerfil());
									Oficina oficina = conexion.findByCodOficina(usuarioEncontrado.getCodigoOficina());
									if(oficina !=null){
										if(oficina.getCodOfic()!=null){
											gestor.setCodigoTerritorio(oficina.getTerr().getCodTerr());
											gestor.setCodigoOficina(oficina.getCodOfic());
										}else{
											// log.info("[UtilListas :: listarGestores] cod oficina" + usuarioEncontrado.getCodigoOficina());
										}
									}
									metaGestor = conexion.findMetGestorByPrimaryKey(codEpigrafe, anho, usuarioEncontrado.getCodigoOficina(), mes, gestor.getCodigoGestor());
									prom = conexion.promedioMensual(anho, mes, usuarioEncontrado.getCodigoOficina(), "codTerr", codEpigrafe, gestor.getCodigoGestor());
									gestor.setPromedio6m(prom);
									if (metaGestor != null) {
										if (metaGestor.getPorcAsignado() != null) {
											gestor.setMetaGestor(metaGestor);
											gestor.setPorcAsignado(metaGestor.getPorcAsignado());
										} else {
											gestor.setPorcAsignado(new BigDecimal("0"));
										}
									} else {
										gestor.setPorcAsignado(new BigDecimal("0"));
									}
									
									// log.info("[UtilListas :: listarGestores] porcentaje" + gestor.getPorcAsignado());
									vistaGestores.add(gestor);
								}
							}
						}
					}
				}
			}
			
			// log.info("[UtilListas :: listarGestores] Fin");
			return vistaGestores;
		} catch (Exception e) {
			log.error("[UtilListas :: listarGestores] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
	}

	public Vector consultarPLanesAccion(String codigoOficina, String mes,
			String anho, String codigoGestor) {
		Vector aux = new Vector();
		Vector finalPlanesAccion = new Vector();
		
		try {
			// log.info("[UtilListas :: consultarPLanesAccion] Inicio");
			
			aux = conexion.consultarPLanesAccion(codigoOficina, mes, anho,
					codigoGestor);
			if (aux != null) {
				for (int i = 0; i < aux.size(); i++) {
					PlanesAcciones planAccion = (PlanesAcciones) aux
							.elementAt(i);
					IILDPeUsuario user = IILDPeUsuario
							.recuperarUsuario(planAccion.getCodigoGestor());
					String codCargo = user.getCargo().getCodigo();
					Equivalencia equivalencia = conexion
							.findEquivalenciaByCodCargo(codCargo);
					String codigoPerfil = equivalencia.getCodPerfil();
					planAccion.setCodigoPerfil(codigoPerfil);
					planAccion.setNombreGestor(user.getNombreCompleto());
					finalPlanesAccion.add(planAccion);
				}
			}
			
			// log.info("[UtilListas :: consultarPLanesAccion] Fin");
			
			return finalPlanesAccion;
		} catch (Exception e) {
			log.error("[UtilListas :: consultarPLanesAccion] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
	}

	public Vector consultarPlanesAccionesPPG(String codigoOficina, String mes,
			String anho, String codigoGestor) {
		Vector aux = new Vector();
		Vector finalPlanesAccion = new Vector();
		
		try {
			// log.info("[UtilListas :: consultarPlanesAccionesPPG] Inicio");
			
			aux = conexion.consultarCampaniasDetallesPGG(codigoOficina, mes,
					anho, codigoGestor);
			if (aux != null) {
				for (int i = 0; i < aux.size(); i++) {
					PlanesAcciones planAccion = (PlanesAcciones) aux
							.elementAt(i);
					IILDPeUsuario user = IILDPeUsuario
							.recuperarUsuario(planAccion.getCodigoGestor());
					String codCargo = user.getCargo().getCodigo();
					Equivalencia equivalencia = conexion
							.findEquivalenciaByCodCargo(codCargo);
					String codigoPerfil = equivalencia.getCodPerfil();
					planAccion.setCodigoPerfil(codigoPerfil);
					planAccion.setNombreGestor(user.getNombreCompleto());
					finalPlanesAccion.add(planAccion);
				}
			}
			
			// log.info("[UtilListas :: consultarPlanesAccionesPPG] Fin");
			
			return finalPlanesAccion;
		} catch (Exception e) {
			log.error("[UtilListas :: consultarPlanesAccionesPPG] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
	}

	public Vector consultarCampaniasDetalles(String codigoOficina, String mes,
			String anho, String codigoGestor) {
		Vector aux = new Vector();
		Vector finalCampDetalle = new Vector();
		
		try {
			// log.info("[UtilListas :: consultarCampaniasDetalles] Inicio");
			
			aux = conexion.consultarCampaniasDetalles(codigoOficina, mes, anho,
					codigoGestor);
			if (aux != null) {
				for (int i = 0; i < aux.size(); i++) {
					CampaniasGeneral campGeneral = (CampaniasGeneral) aux
							.elementAt(i);
					IILDPeUsuario user = IILDPeUsuario
							.recuperarUsuario(campGeneral.getCodigoGestor());
					String codCargo = user.getCargo().getCodigo();
					Equivalencia equivalencia = conexion
							.findEquivalenciaByCodCargo(codCargo);
					String codigoPerfil = equivalencia.getCodPerfil();
					campGeneral.setCodigoPerfil(codigoPerfil);
					campGeneral.setNombreGestor(user.getNombreCompleto());
					finalCampDetalle.add(campGeneral);
				}
			}
			// log.info("[UtilListas :: consultarCampaniasDetalles] Fin");
			
			return finalCampDetalle;
		} catch (Exception e) {
			log.error("[UtilListas :: consultarCampaniasDetalles] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
	}

	public Vector consultarCampaniasDetallesPGG(String codigoOficina,
			String mes, String anho, String codigoGestor) {
		Vector aux = new Vector();
		Vector finalCampDetalle = new Vector();
		
		try {
			// log.info("[UtilListas :: consultarCampaniasDetallesPGG] Inicio");
			
			aux = conexion.consultarCampaniasDetallesPGG(codigoOficina, mes,
					anho, codigoGestor);
			if (aux != null) {
				for (int i = 0; i < aux.size(); i++) {
					CampaniasGeneral campGeneral = (CampaniasGeneral) aux
							.elementAt(i);
					IILDPeUsuario user = IILDPeUsuario
							.recuperarUsuario(campGeneral.getCodigoGestor());
					String codCargo = user.getCargo().getCodigo();
					Equivalencia equivalencia = conexion
							.findEquivalenciaByCodCargo(codCargo);
					String codigoPerfil = equivalencia.getCodPerfil();
					campGeneral.setCodigoPerfil(codigoPerfil);
					campGeneral.setNombreGestor(user.getNombreCompleto());
					finalCampDetalle.add(campGeneral);
				}
			}
			// log.info("[UtilListas :: consultarCampaniasDetallesPGG] Fin");
			
			return finalCampDetalle;
		} catch (Exception e) {
			log.error("[UtilListas :: consultarCampaniasDetallesPGG] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
	}

	public String getOficinaBanco() {
		return "0081";
	}

	/**
	 * Funcion que setea la cadena con los caracteres especificados
	 * 
	 * @param cadena:
	 *            Cadena a ser seteado
	 * @param c:
	 *            Caracter a utilizar para completar la cadena
	 * @param num:
	 *            Numero de Caracteres a tomar en cuenta en la cadena
	 * @return: Retorna la cadena con la cantidad de caracteres y con los
	 *          caracteres indicados
	 */

	public static String setearCaracterLeft(String cadena, char c, int num) {
		// log.info("[UtilListas :: setearCaracterLeft] Inicio");
		
		String temp = "";
		if (cadena == null)
			cadena = "";

		for (int i = 0; i < num; i++)
			temp += c;
		temp += cadena;

		// log.info("[UtilListas :: setearCaracterLeft] Fin");	
		
		return temp;
	}

	/**
	 * FUNCION QUE CONVIERTE UN TEXTO SIN DECIMALES A UN TIPO BIGDECIMAL CON
	 * DECIMALES
	 * 
	 * @param numeroTrama:
	 *            Cadena a convertir a BigDecimal (12556)
	 * @param decimales:
	 *            La cantidad de Decimales a ser considerados (2)
	 * @return : Retorna un BigDecimal con decimales (125.56)
	 */
	public static BigDecimal tramaToBigDecimal(String numeroTrama, int decimales) {
		boolean numPositivo = true;
		int longTrama = 0;
		int numero = 0;

		// log.info("[UtilListas :: tramaToBigDecimal] Inicio");
		
		if (numeroTrama == null) {
			return new BigDecimal(0.00);
		}

		try {
			numero = Integer.parseInt(numeroTrama);

			if (numero < 0) {
				numero *= -1;
				numeroTrama = String.valueOf(numero);
				numPositivo = false;
			}
		} catch (Exception e) {
			log.error("[UtilListas :: tramaToBigDecimal] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}

		if (numeroTrama.length() < 15) {
			longTrama = 15 - numeroTrama.length();
			numeroTrama = UtilListas.setearCaracterLeft(numeroTrama, '0',
					longTrama);
		}

		int enteros = 15 - decimales;
		numeroTrama = numeroTrama.substring(0, enteros) + "."
				+ numeroTrama.substring(enteros);

		BigDecimal bd = new BigDecimal(numeroTrama);

		if (!numPositivo) {
			bd = bd.negate();
		}

		bd.setScale(decimales);
		
		// log.info("[UtilListas :: tramaToBigDecimal] Fin");

		return bd;
	}
	
	public Vector listarGestoresSinMontos(String codigoOficina) {
		Vector vistaGestores = new Vector();
		String condicion = "GOF";
		Connection con = new Connection();

		try {
			// log.info("[UtilListas :: listarGestoresSinMontos] Inicio");
			
			IILDPeCriterioBusqueda cb = new IILDPeCriterioBusqueda();
			cb.setCodigoOficina(codigoOficina);
			cb.setCodigoEmpresa(getOficinaBanco());
			cb.setLimiteOcurrencias(5);
			Vector vectorGestores = con.buscarUsuariosLDAP(codigoOficina, getOficinaBanco(), 100);
			if (vectorGestores != null) {
				for (int j = 0; j < 5; j++) {
					switch (j) {
					case 1:
						condicion = "GPE";
						break;
					case 2:
						condicion = "GCO";
						break;
					case 3:
						condicion = "GPT";
						break;
					case 4:
						condicion = "EEM";
						break;
					}
					for (int i = 0; i < vectorGestores.size(); i++) {
						UsuarioLDAP usuarioEncontrado = (UsuarioLDAP) vectorGestores.elementAt(i);
						Gestor gestor = new Gestor();
						gestor.setCodigoGestor(usuarioEncontrado.getUID());
						gestor.setNombreGestor(usuarioEncontrado.getNombreCompleto());
						Equivalencia equivalencia = conexion.findEquivalenciaByCodCargo(usuarioEncontrado.getCodigoCargo());

						MetasGestor metaGestor = new MetasGestor();
						if (equivalencia != null) {
							if (equivalencia.getCodPerfil() != null) {
								if (equivalencia.getCodPerfil().equals(condicion)) {
									gestor.setCodigoPerfil(equivalencia.getCodPerfil());
									gestor.setPerfilMostrar(equivalencia.getPerfil());
									Oficina oficina = conexion.findByCodOficina(usuarioEncontrado.getCodigoOficina());
									if(oficina !=null){
										if(oficina.getCodOfic()!=null){
											gestor.setCodigoTerritorio(oficina.getTerr().getCodTerr());
											gestor.setCodigoOficina(oficina.getCodOfic());
										}else{
											// log.info("[UtilListas :: listarGestoresSinMontos] cod oficina:"+ usuarioEncontrado.getCodigoOficina());
										}
									}
									
									// log.info("[UtilListas :: listarGestoresSinMontos] porcentaje: "+ gestor.getPorcAsignado());
									vistaGestores.add(gestor);
								}
							}
						}
					}
				}
			}
			
			// log.info("[UtilListas :: listarGestoresSinMontos] Fin");
			
			return vistaGestores;
		} catch (Exception e) {
			log.error("[UtilListas :: listarGestoresSinMontos] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return null;
		}
	}
}