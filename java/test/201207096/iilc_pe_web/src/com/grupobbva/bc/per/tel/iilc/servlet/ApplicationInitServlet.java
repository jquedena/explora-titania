package com.grupobbva.bc.per.tel.iilc.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.common.Fecha;
import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection;
import com.grupobbva.bc.per.tel.iilc.logic.CargaATOG;
import com.grupobbva.bc.per.tel.iilc.logic.CargaVinculacion;
import com.grupobbva.bc.per.tel.iilc.logic.ThreadCargaCliente;
import com.grupobbva.bc.per.tel.iilc.logic.ThreadCargaVinculacionGCO;
import com.grupobbva.bc.per.tel.iilc.logic.ThreadCargaVinculacionPH;
import com.grupobbva.bc.per.tel.iilc.logic.ThreadCargaVinculacionVIP;
import com.grupobbva.bc.per.tel.iilc.serializable.AdministracionCargaVinculacion;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;

@SuppressWarnings("serial")
public class ApplicationInitServlet extends HttpServlet {
	public int num1 = 0;
	static Logger logger = Logger.getLogger(ApplicationInitServlet.class);
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		long delay = 20;
		long period = 60;
		
		String strDelayTime = config.getInitParameter("delayTime");
		String strPeriodTime = config.getInitParameter("periodTime");
		
		if (strDelayTime != null && !strDelayTime.trim().equals("")) {
			try {
				delay = Long.parseLong(strDelayTime);

			} catch (Exception e) {
				logger.error("Error al convertir el parametro delayTime.");
				logger.error("Usando el valor por defecto, " + delay);
			}
		}
		if (strPeriodTime != null && !strPeriodTime.trim().equals("")) {
			try {
				period = Long.parseLong(strPeriodTime);
			} catch (Exception e) {
				logger.error("Error al convertir el parametro periodTime.");
				logger.error("Usando el valor por defecto, " + period);
			}
		}

		//startUpTimerCargasLocales(delay, period);
		//startUpTimerCargaClientes(delay, period);
		startUpTimerCargaVinculacionVIP(delay, period);
		startUpTimerCargaVinculacionPH(delay, period);
		startUpTimerCargaVinculacionGCO(delay, period);
	
	}

	protected void startUpTimerCargaVinculacionVIP(long delay, long period) {
		Timer timer = new Timer();
		logger.info("iniciando tarea startUpTimerCargaVinculacionVIP");
		TimerTask task = new TimerTask() {

			public void run() 
			{
				try{
					Calendar hoy = Calendar.getInstance();
					ConexionDAO con = new ConexionDAO();
					String fechaActual=	Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"/"+Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"/"+hoy.get(Calendar.YEAR)+"/"+
					Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY))+"/" + Utilitario.dosCeros(hoy.get(Calendar.MINUTE));
 
					AdministracionCargaVinculacion horario = con.obtenerProgramacionCargaVinculacion(fechaActual,"1");
					if(horario!=null){
						ThreadCargaVinculacionVIP thCargaVIP = new ThreadCargaVinculacionVIP();
						con.actualizarEstadoCarga(horario,Constantes.INDICADOR_PROCESANDO_VINCULACION,Constantes.ID_ESTADO_CARGA_VINCULACION_ENPROCESO);
						try {
							thCargaVIP.setIdRegistroCargaVIP(horario.getId_registro());
							thCargaVIP.setHorario(horario);
							thCargaVIP.start();
						} catch (Throwable e1) {
							logger.error("Error no esperado en el procedimiento de carga automatica vinculacion VIP... ");
							e1.printStackTrace();
						}
						
					}
				}
				catch(Throwable e){
					logger.error("Error al leer el cronograma de carga");
					e.printStackTrace();
				}
			}
		};
		 timer.scheduleAtFixedRate(task, delay * 1000, period * 1000);
	}

	
	protected void startUpTimerCargaVinculacionPH(long delay, long period) {
		Timer timer = new Timer();
		logger.info("iniciando tarea startUpTimerCargaVinculacionPH");
		TimerTask task = new TimerTask() {

			public void run() 
			{
				try{
					Calendar hoy = Calendar.getInstance();
					ConexionDAO con = new ConexionDAO();
					String fechaActual=	Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"/"+Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"/"+hoy.get(Calendar.YEAR)+"/"+
					Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY))+"/" + Utilitario.dosCeros(hoy.get(Calendar.MINUTE));
 
					AdministracionCargaVinculacion horario = con.obtenerProgramacionCargaVinculacion(fechaActual,"3");
					if(horario!=null){
						ThreadCargaVinculacionPH thCargaPH = new ThreadCargaVinculacionPH();
						con.actualizarEstadoCarga(horario,Constantes.INDICADOR_PROCESANDO_VINCULACION,Constantes.ID_ESTADO_CARGA_VINCULACION_ENPROCESO);//marca la constante en multitabla como procesando
							try {
								thCargaPH.setHorario(horario);
								thCargaPH.setIdRegistroCargaPH(horario.getId_registro());
								thCargaPH.start();
							} catch (Exception e) {
								logger.error("Error no esperado en el procedimiento de carga automatica vinculacion PH... ", e);
							}
							
					}
				}
				catch(Exception e){
					logger.error("Error al leer el cronograma de carga", e);
				}
			}
		};
		timer.scheduleAtFixedRate(task, delay * 1000, period * 1000);
	}

	
	protected void startUpTimerCargaVinculacionGCO(long delay, long period) {
		Timer timer = new Timer();
		logger.info("iniciando tarea startUpTimerCargaVinculacionGCO");
		TimerTask task = new TimerTask() {

			public void run() 
			{
				try{
					Calendar hoy = Calendar.getInstance();
					ConexionDAO con = new ConexionDAO();
					String fechaActual=	Utilitario.dosCeros(hoy.get(Calendar.DAY_OF_MONTH))+"/"+Utilitario.dosCeros((hoy.get(Calendar.MONTH)+1))+"/"+hoy.get(Calendar.YEAR)+"/"+
					Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY))+"/" + Utilitario.dosCeros(hoy.get(Calendar.MINUTE));
 
					AdministracionCargaVinculacion horario = con.obtenerProgramacionCargaVinculacion(fechaActual,"2");
					if(horario!=null){
						ThreadCargaVinculacionGCO thCargaGCO = new ThreadCargaVinculacionGCO();
						con.actualizarEstadoCarga(horario,Constantes.INDICADOR_PROCESANDO_VINCULACION,Constantes.ID_ESTADO_CARGA_VINCULACION_ENPROCESO);//marca la constante en multitabla como procesando
							try {
								thCargaGCO.setIdRegistroCargaGCO(horario.getId_registro());
								thCargaGCO.setHorario(horario);
								thCargaGCO.start();
							} catch (Throwable e1) {
								logger.error("Error no esperado en el procedimiento de carga automatica vinculacion GCO... ");
								e1.printStackTrace();
							}
							
					}
				}
				catch(Throwable e){
					logger.error("Error al leer el cronograma de carga");
					e.printStackTrace();
				}
			}
		};
		 timer.scheduleAtFixedRate(task, delay * 1000, period * 1000);
	}

	protected void startUpTimerCargaClientes(long delay, long period) {
		Timer timer = new Timer();

		TimerTask task = new TimerTask() {

			public void run() {
				try{
					Calendar hoy = Calendar.getInstance();
					String codHoraMinHoy = "";
					String codHoraMinCarga = "";
					boolean diaSemana = false;
					
					ConexionDAO con = new ConexionDAO();
					Multitabla horario = con.findRecord("T00CARGA0");
					Connection conexion = new Connection();
					
					if(horario!=null){
						codHoraMinHoy = Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY)) + Utilitario.dosCeros(hoy.get(Calendar.MINUTE));
						codHoraMinCarga = horario.getValor2() + horario.getValor3();
						diaSemana = (horario.getValor1().substring(hoy.get(Calendar.DAY_OF_WEEK)-1,hoy.get(Calendar.DAY_OF_WEEK)).equals("1"));
						
						if((codHoraMinHoy.equals(codHoraMinCarga) && diaSemana )  && !horario.getValor4().trim().equals("1") ){
							horario.setValor4("1");
							conexion.updateMultitabla(horario);
								try {
									ThreadCargaCliente th = new ThreadCargaCliente();
									th.start();
									
								} catch (Throwable e1) {
									logger.error("Error no esperado en llamado a carga de clientes iilc en oracle... o_o");
									e1.printStackTrace();
								}
								Thread.sleep(120000); 
								horario.setValor4("0");
								conexion.updateMultitabla(horario);
						}
					}
				}
				catch(Throwable e){
					logger.info("Error al leer el cronograma de carga de clientes");
					e.printStackTrace();
				}
			}

		};
		timer.scheduleAtFixedRate(task, delay * 1000, period * 1000);
	}

	protected void startUpTimerCargasLocales(long delay, long period) {
		Timer timer = new Timer();

		TimerTask task = new TimerTask() {

			public void run() {
				try{
					Calendar hoy = Calendar.getInstance();
					String codHoraMinHoy = "";
					String codHoraMinCarga = "";
					String codHoraMinLimpieza = "";
					
					ConexionDAO con = new ConexionDAO();
					Multitabla horario = con.findRecord("T00CARGA1");
					
					if(horario!=null){
						codHoraMinHoy = Utilitario.dosCeros(hoy.get(Calendar.HOUR_OF_DAY)) + Utilitario.dosCeros(hoy.get(Calendar.MINUTE));
						codHoraMinCarga = horario.getValor1() + horario.getValor2();
						codHoraMinLimpieza = horario.getValor3() + horario.getValor4();
						if(codHoraMinHoy.equals(codHoraMinCarga)){
							
							String path = con.findRecord(Constantes.PATH).getValor1().trim();
							Multitabla nombres = con.findRecord("T00CARGA2");
							try {
								cargaEnSecuencia(path,nombres);
								
							} catch (Throwable e1) {
								logger.error("Error no esperado en el procedimiento de carga automatica iilc... ");
								logger.error(e1.getMessage());
								e1.printStackTrace();
							}
						}
						
						if(codHoraMinHoy.equals(codHoraMinLimpieza)){
							
							String path = con.findRecord(Constantes.PATH).getValor1().trim();
					        try {
								limpieza(path);
								
							} catch (Throwable e2) {
								logger.error("Error no esperado en la limpieza de temporales iilc...");
								e2.printStackTrace();
							}
						}
					}
				}
				catch(Throwable e){
					logger.error("Error al leer el cronograma de carga");
					e.printStackTrace();
				}
			}

		};
		timer.scheduleAtFixedRate(task, delay * 1000, period * 1000);
	}
	
	private void cargaEnSecuencia(String path, Multitabla nombres){
		//empezando carga de datos, listado de conduccion

	    File filePath = new File(path+"/uploads/");
	    try {
			FileOutputStream temp = new FileOutputStream(path+"/temp/iilc.log");
			temp.close();
		} catch (FileNotFoundException e1) {
			logger.error(e1.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());

		}
	    File[] listaArchivos =  filePath.listFiles();
	    if (listaArchivos!=null){
	        if (listaArchivos.length > 0){
	        	logger.info("Total de archivos: "+ listaArchivos.length);
	        	//File data = null;
	        	File terr_ofic = null;
	        	File gestor = null;
	        	File empresa = null;
	        	for(int k = 0; k<listaArchivos.length; k++){
	        		/*if (listaArchivos[k].getName().toLowerCase().equals(nombres.getValor1().toLowerCase())){ 
	        			data = listaArchivos[k];
	        			logger.info("Archivo " + listaArchivos[k].getName() + " encontrado.");
	        		}*/
	        		if (listaArchivos[k].getName().toLowerCase().equals(nombres.getValor2().toLowerCase())){
	        			terr_ofic = listaArchivos[k];
	        			logger.info("Archivo " + listaArchivos[k].getName() + " encontrado.");
	        		}
	        		if (listaArchivos[k].getName().toLowerCase().equals(nombres.getValor3().toLowerCase())){
	        			gestor = listaArchivos[k];
	        			logger.info("Archivo " + listaArchivos[k].getName() + " encontrado.");
	        		}
	        		if (listaArchivos[k].getName().toLowerCase().equals(nombres.getValor4().toLowerCase())){
	        			empresa = listaArchivos[k];
	        			logger.info("Archivo " + listaArchivos[k].getName() + " encontrado.");
	        		}
	        	}
	        	
		        
		        Fecha fechaHoy = new Fecha();
		        logger.info("Empieza carga del dia: "+ fechaHoy.stringFormat(fechaHoy.today()));
		        try{
		        	/*if (data != null){
		        		CargaLC cargaLC = new CargaLC();
		        		cargaLC.setArchivo(data);
		        		if (cargaLC.isEstado())
		        			if (cargaLC.cargaMasiva())
		        				logger.error("El Archivo "+ data.getName()+" se cargo con exito");
		        	}*/
			        
			        if (terr_ofic != null){
		            	CargaATOG cargaATOG = new CargaATOG('T');
                    	cargaATOG.setArchivo(terr_ofic);
                    	if(cargaATOG.isEstado())
                    		if(cargaATOG.cargaMasiva())
                    			logger.info("El Archivo "+ terr_ofic.getName()+" se cargo con exito");
		            }
		            
		            if (gestor != null){
		            	CargaATOG cargaATOG = new CargaATOG('G');
                    	cargaATOG.setArchivo(gestor);
                    	if(cargaATOG.isEstado())
                    		if(cargaATOG.cargaMasiva())
                    			logger.info("El Archivo "+ gestor.getName()+" se cargo con exito");
		            }
		            
		            if (empresa != null){
		            	CargaATOG cargaATOG = new CargaATOG('E');
                    	cargaATOG.setArchivo(empresa);
                    	if(cargaATOG.isEstado())
                    		if(cargaATOG.cargaMasiva())
                    			logger.info("El Archivo "+ gestor.getName()+" se cargo con exito");
		            }
		            
		            logger.info("Eliminando archivos de respaldo");
				    File fileRespaldo = new File(path+"/backups/");
				    File[] files = fileRespaldo.listFiles();
				    for(int l=0;l<files.length;l++){
				        if (!(files[l].isDirectory()))
				        	files[l].delete();
				    }
				    
				    logger.info("Almacenando nuevos archivos de respaldo");
				    for(int m = 0; m<listaArchivos.length; m++){
    		   			//copiando
	        			FileInputStream inputstream = new FileInputStream(listaArchivos[m]); 
	        		    FileOutputStream outputfile = new FileOutputStream(path+"/backups/"+listaArchivos[m].getName());
	        		    int c = 0; c = inputstream.read();

	        			while (c != -1) {
	        			    outputfile.write(c);
	        				c = inputstream.read();
	        			}
	        			outputfile.flush();
	        			outputfile.close();
	        			inputstream.close();
		        	}
				    
				    /*if (data!= null){
				    	logger.info("Eliminando archivo de carga cliente");
				    	data.delete();
				    }*/
				    if (terr_ofic!= null){
				    	logger.info("Eliminando archivo de carga territorio oficina");
				    	terr_ofic.delete();
				    }
		            if (gestor!= null){
		            	logger.info("Eliminando archivo de carga gestor");
		            	gestor.delete();
		            }
		            if (empresa!= null){
		            	logger.info("Eliminando archivo de carga empresa");
		            	empresa.delete();
		            }
		        }catch(Exception e){
		        	logger.info("Error en la carga del archivo "+e.toString());
		        }
	        }
	    }else{
	    	logger.info("No se encuentran archivos en el directorio de carga");
        }
	}
	
	
	
	@SuppressWarnings("unused")
	private void cargaEnSecuenciaVinculacion(String path, Multitabla nombres,ConexionDAO con,char tipo,AdministracionCargaVinculacion  auditor) throws Exception {
		//empezando carga de datos, listado de conduccion

	    File filePath = new File(path);
 
	    File[] listaArchivos =  filePath.listFiles();
	    logger.error("archivos " + listaArchivos.length);
	    if (listaArchivos!=null){
	        if (listaArchivos.length > 0){
	        	logger.info("Total de archivos de vinculacion: "+ listaArchivos.length);

	        	File archivo = null;
	        	for(int k = 0; k<listaArchivos.length; k++){
	        		logger.error(listaArchivos[k].getName().toLowerCase()+" "+nombres.getValor2() );
	        		if (listaArchivos[k].getName().toLowerCase().equals(nombres.getValor2().toLowerCase())){
	        			archivo = listaArchivos[k]; 
	        			logger.info("Archivo " + listaArchivos[k].getName() + " encontrado.");
	        		}
	        	}
	        	
		        Fecha fechaHoy = new Fecha();
		        logger.info("Empieza carga del dia: "+ fechaHoy.stringFormat(fechaHoy.today()));
		        try{
 
			        
			        if (archivo != null){
			        	auditor.setArchivo_carga(1);
			        	CargaVinculacion carga = new CargaVinculacion(tipo,auditor);
		            	carga.setArchivo(archivo);
                    	if(carga.isEstado())
                    		if(carga.cargaMasiva())
                    			logger.info("El Archivo "+ archivo.getName()+" se cargo con exito");
		            } else{
		            	auditor.setArchivo_carga(0);
		            	con.actualizarAuditoria(auditor);
		            }
		      
		        	
		        	
		        }catch(Exception e){
		        	logger.info("Error en la carga del archivo "+e.toString());
		        }
	        }
	    }else{
	    	logger.info("No se encuentran archivos en el directorio de carga");
        }
	}
	
	
	
	
	
	protected void limpieza(String path){
	    logger.info("Eliminando archivos de descarga");
	    long bytes = 0;
    	File downloads = new File(path+"/downloads/");
    	int j = 0;
	    File[] listaDownloads =  downloads.listFiles();
	    for (j=0; j<listaDownloads.length; j++){
	    	bytes+=listaDownloads[j].length();
	    	listaDownloads[j].delete();
	    }
	    String res = j + " archivos fueron eliminados.  Espacio recuperado : " + bytes + " bytes.";
	    logger.info(res);
	}

	/**
	 * Destroys the servlet.
	 */
	public void destroy() {
	}

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 */
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 */
	public String getServletInfo() {
		return "Short description";
	}

}
