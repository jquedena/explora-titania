package com.grupobbva.bc.per.tel.iilc.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.serializable.AdministracionCargaVinculacion;
import com.grupobbva.bc.per.tel.iilc.serializable.VinculacionGco;
import com.grupobbva.bc.per.tel.iilc.serializable.VinculacionPh;
import com.grupobbva.bc.per.tel.iilc.serializable.VinculacionVip;

public class CargaVinculacion {
	private File archivo;

	private InputStream isarchivo;

	private boolean estado;

	private long registros_leidos=0;

	private char tipo;

	private VinculacionVip vinculacionVip;
	private VinculacionGco vinculacionGco;
	private VinculacionPh vinculacionPh;
	private AdministracionCargaVinculacion auditor;
	private long vip_insertados=0;
	private long vip_no_insertados=0;

	
	private ConexionDAO con;

	static Logger logger = Logger.getLogger(CargaATOG.class);
	
	public CargaVinculacion(char tipo,AdministracionCargaVinculacion auditor_param)  {
		this.tipo = tipo;
		this.archivo = null;
		this.isarchivo = null;
		vinculacionVip = null;
		auditor=auditor_param;
		this.estado = true;
		
		con = new ConexionDAO();
		
		switch (tipo) {
		
		case Constantes.VIP:
			logger.info("Borrando data vinculacion vip");
			estado = con.deleteVinculacion("V");
			estado = con.deleteLogVinculacion(auditor_param.getId_registro());
			
			break;
			
		case Constantes.PH:
			logger.info("Borrando data vinculacion ph");
			estado = con.deleteVinculacion("P");
			estado = con.deleteLogVinculacion(auditor_param.getId_registro());
			break;
			
		case Constantes.GCO:
			logger.info("Borrando data vinculacion gco");
			estado = con.deleteVinculacion("G");
			estado = con.deleteLogVinculacion(auditor_param.getId_registro());
			break;

		}

	}

	public boolean cargaMasiva() {
		//cargando listado de conduccion del mes
		String linea = "";
		try {
			FileInputStream inputStream = null;
			BufferedReader d = null;
			if (archivo != null) {
				inputStream = new FileInputStream(archivo);
				d = new BufferedReader(new InputStreamReader(inputStream));
			} else {
				d = new BufferedReader(new InputStreamReader(isarchivo));
			}
			if (d == null)
				return false;
			
			logger.info("Empieza la carga masiva TIPO: " +tipo);
			//procesando contenido del reporte
			do {
				linea = d.readLine();
				if (linea!=null){ 
					registros_leidos++;
					switch (tipo) {
					case Constantes.VIP:
						procesaVip(linea);
						break;
					case Constantes.GCO:
						procesaGCO(linea);
						break;
					case Constantes.PH:
						procesaPH(linea);
						break;
					
					}

					
				}
			} while (linea != null);

			if (archivo != null)
				inputStream.close();
			else
				isarchivo.close();

		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}catch (SQLException e) {
			return false;
		}

		return true;
	}

	

	private void procesaVip(String linea) throws SQLException {
		auditor.setFilas_leidas(registros_leidos);
            try {
            	vinculacionVip = new VinculacionVip(); 
            	String arreglo[] =linea.split("[|]",-1);
            	
            	if(arreglo.length<34){
            		vip_no_insertados++;
    				auditor.setFilas_no_procesadas(vip_no_insertados);
    				con.registrarLogError(linea, Constantes.ERROR_CANTIDAD_CAMPOS,registros_leidos, auditor.getId_registro());
    				con.actualizarAuditoria(auditor);	
            	}else{
		            	
		            	int posicion=0;
		            	vinculacionVip.setCod_territorio(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setCod_oficina(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setCodigo_cliente(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setCod_gestor(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setNombre_cliente(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setNom_gestor(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setSegmento(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setAhorro_cta_cero(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setCuenta_cte_vip(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setAhorro_cta_gan(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setOtras_ctas_ahorro(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setFamilia1(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setPlazo(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setFondos_mutuos(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setBolsa(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setCts(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setFamilia2(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setPres_libre_dis(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setPres_auto(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setPres_hipotecario(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setTc_activas(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setFamilia3(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setInfomail(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setHaberes(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setBca_internet(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setDomiciliado(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setFamilia4(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setVida(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setOnc_dent(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setProteccion_tc(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setOtros_seguros(getStringNullable(arreglo[posicion++])	);
		            	vinculacionVip.setFamilia5(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setTotal_puntos(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setPerfil(getStringNullable(arreglo[posicion++]));
		            	vinculacionVip.setUsureg("WAS");
							try {
								con.insertarVinculacionVip(vinculacionVip);
								vip_insertados++;
								auditor.setFilas_procesadas(vip_insertados);
							}catch (Exception e){
								logger.info("Error en creacion del registro : " +vip_insertados);
								con.registrarLogError(linea, Constantes.ERROR_REGISTRAR_LINEA,registros_leidos, auditor.getId_registro());
								vip_no_insertados++;
							}
						auditor.setFilas_leidas(registros_leidos);
						con.actualizarAuditoria(auditor);
            	}
            } catch (Exception e) {
                e.printStackTrace();
				vip_no_insertados++;
				auditor.setFilas_no_procesadas(vip_no_insertados);
				con.registrarLogError(linea, Constantes.ERROR_LEER_CAMPOS,registros_leidos, auditor.getId_registro());
				con.actualizarAuditoria(auditor);
            } 
	}
	
	
	public String getStringNullable(String cadena){
		if(cadena==null || cadena.length()<1){
			return "null";
		}
		return cadena;
	}
	
	
	private void procesaPH(String linea) throws SQLException {
		 
			auditor.setFilas_leidas(registros_leidos);
            try {
            	
            	vinculacionPh = new VinculacionPh();   
            	String arreglo[] =linea.split("[|]",-1);
            	
            	if(arreglo.length<48){
    				vip_no_insertados++;
    				con.registrarLogError(linea, Constantes.ERROR_CANTIDAD_CAMPOS,registros_leidos, auditor.getId_registro());
    				auditor.setFilas_no_procesadas(vip_no_insertados);
    				con.actualizarAuditoria(auditor);

            	}else{
		            	int posicion=0;
		            	vinculacionPh.setCod_territorio(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setCod_oficina(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setCodigo_cliente(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setCod_gestor(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setDes_territorio(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setDes_oficina(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setCodcli_emisora(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setNom_emisora(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setNombre(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setApellido1(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setApellido2(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setTipdoc_identidad(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setDoc_identidad(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setFecha_nacimiento(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setTipo_tlf1(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setCod_ciudad_tlf1(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setNro_tlf1(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setTipo_tlf2(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setCod_ciudad_tlf2(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setNro_tlf2(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setTipo_tlf3(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setCod_ciudad_tlf3(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setNro_tlf3(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setSegmento(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setClasificacion_rcc(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setRango_ingreso(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setSm_prest_consumo(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setNro_prest_consumo(getStringNullable(arreglo[posicion++]));
		             	vinculacionPh.setSm_prest_hipo(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setNro_prest_hipo(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setSm_tarj_cred(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setNro_plasticos(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setTarj_creditos(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setNro_ctas_ahorro(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setNro_ctas_vista(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setNro_ctas_fmutuos(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setNro_ctas_plazo(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setNro_ctas_cts(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setMargen_ordinario(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setMargen_ordinario_acum(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setTipo_oferta(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setImp_oferta_consumo(getStringNullable(arreglo[posicion++])	);
		            	vinculacionPh.setTasa1(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setTasa2(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setTasa3(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setImp_oferta_tarjeta(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setLinea_tc(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setCanal(getStringNullable(arreglo[posicion++]));
		            	vinculacionPh.setUsureg("WAS");
						try {
							con.insertarVinculacionPh(vinculacionPh);
							vip_insertados++;
							auditor.setFilas_procesadas(vip_insertados);
						}catch (Exception e){
							e.printStackTrace();
							logger.info("Error en creacion del registro : " +vip_insertados);
							vip_no_insertados++;
							con.registrarLogError(linea, Constantes.ERROR_REGISTRAR_LINEA,registros_leidos, auditor.getId_registro());
							auditor.setFilas_no_procesadas(vip_no_insertados);
						}
						auditor.setFilas_leidas(registros_leidos);
						con.actualizarAuditoria(auditor);
						
            	}
            } catch (Exception e) {
            	logger.error(e.getMessage());

				vip_no_insertados++;
				con.registrarLogError(linea,Constantes.ERROR_LEER_CAMPOS,registros_leidos, auditor.getId_registro());
				auditor.setFilas_no_procesadas(vip_no_insertados);
				con.actualizarAuditoria(auditor);
            }
        
	}
	
	
	
	
	private void procesaGCO(String linea) throws SQLException {
			auditor.setFilas_leidas(registros_leidos);
            try {
            	vinculacionGco = new VinculacionGco();   
            	String arreglo[] =linea.split("[|]",-1);
            	int posicion=0;
            	
            	if(arreglo.length<44){
    				vip_no_insertados++;
    				con.registrarLogError(linea,Constantes.ERROR_CANTIDAD_CAMPOS,registros_leidos, auditor.getId_registro());
    				auditor.setFilas_no_procesadas(vip_no_insertados);
    				con.actualizarAuditoria(auditor);
            	}else{
            	
		            	vinculacionGco.setCod_territorio(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setCod_oficina(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setCodigo_cliente(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setCod_gestor(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setNombre_cliente(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setNom_gestor(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setSegmento(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setBloque(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPres_com_letras(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setCom_exterior(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setLeasing(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setRiesgo_firma(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setTarjeta_cap_tra(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setTotal_tar_empre(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setHipo_autos(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setCta_plazo(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setFmutuos(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setCta_cte_ahorro(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setTotal_sal_pa_py(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setBolsa(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setHaberes(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setProveedores(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setRecaudacion(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setBanca_internet(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setSeguros(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_prescom_letras(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_com_ext(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_leasing(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_riesgo_firma(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_tarj_cap_trab(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_tarj_emp(getStringNullable(arreglo[posicion++])	);
		            	vinculacionGco.setPtos_hipo_autos(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_cta_cte_ahorro(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_fmutuos(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_tot_pas_pym(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_bolsa(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_pago_haberes(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_pago_prov(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_recaudaciones(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_banca_internet(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setPtos_seguros(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setTotal_puntos(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setVinculado(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setRango_vinculacion(getStringNullable(arreglo[posicion++]));
		            	vinculacionGco.setUsureg("WAS");
							try {
								 
								con.insertarVinculacionGco(vinculacionGco);
								vip_insertados++;
								auditor.setFilas_procesadas(vip_insertados);
							}catch (Exception e){
								logger.info("Error en creacion del registro : " +vip_insertados);
								vip_no_insertados++;
								con.registrarLogError(linea, Constantes.ERROR_REGISTRAR_LINEA,registros_leidos, auditor.getId_registro());
								auditor.setFilas_no_procesadas(vip_no_insertados);
							}
							auditor.setFilas_leidas(registros_leidos);
							con.actualizarAuditoria(auditor);
							
		            	}
            } catch (Exception e) {
                e.printStackTrace();
				vip_no_insertados++;
				con.registrarLogError(linea,Constantes.ERROR_LEER_CAMPOS,registros_leidos, auditor.getId_registro());
				auditor.setFilas_no_procesadas(vip_no_insertados);
				con.actualizarAuditoria(auditor);
            } 
	}
	
	 
 

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

	public InputStream getIsarchivo() {
		return isarchivo;
	}

	public void setIsarchivo(InputStream isarchivo) {
		this.isarchivo = isarchivo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public long getRegistros_leidos() {
		return registros_leidos;
	}

	public void setRegistros_leidos(long registros_leidos) {
		this.registros_leidos = registros_leidos;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
 
	

	public VinculacionVip getVinculacionVip() {
		return vinculacionVip;
	}

	public void setVinculacionVip(VinculacionVip vinculacionVip) {
		this.vinculacionVip = vinculacionVip;
	}

	public long getVip_insertados() {
		return vip_insertados;
	}

	public void setVip_insertados(long vip_insertados) {
		this.vip_insertados = vip_insertados;
	}

	public ConexionDAO getCon() {
		return con;
	}

	public void setCon(ConexionDAO con) {
		this.con = con;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		CargaVinculacion.logger = logger;
	}

	
	

	
}
