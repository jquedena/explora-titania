/**
 * @author: Maria Paula Tomaylla codigo : P020795 fecha : 29/10/2007
 * 
 */
package com.grupobbva.bc.per.tel.iilc.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Vector;

import org.apache.log4j.Logger;


import com.grupobbva.bc.per.tel.iilc.common.Utilitario;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.serializable.Total;
import com.grupobbva.bc.per.tel.iilc.session.SessionServiceLocal;
import com.grupobbva.bc.per.tel.iilc.session.SessionServiceLocalHome;
import com.ibm.etools.service.locator.ServiceLocatorManager;
public class CargaLC {

	private File archivo;

	private InputStream isarchivo;

	private Cliente cliente;

	private Total total;

	private boolean condicion;

	private Connection con;

	private boolean estado;

	private int registros_leidos;
	private int registros1_leidos;
	private int registros2_leidos;
	private int registros3_leidos;
	private int registros4_leidos;
	private int registros5_leidos;
	private int registros6_leidos;
	private int registros7_leidos;

	private int clientes_insertados;

	private int totales_insertados;
	
	Vector<Multitabla> paramCliente = null;
	Vector<Multitabla> paramTotal1 = null;
	Vector<Multitabla> paramTotal2 = null;

	static Logger logger = Logger.getLogger(CargaLC.class);
	private final static String STATIC_SessionServiceLocalHome_REF_NAME = "ejb/SessionService";
	private final static Class STATIC_SessionServiceLocalHome_CLASS = SessionServiceLocalHome.class;
	public CargaLC() {
		this.archivo = null;
		this.isarchivo = null;
		this.cliente = null;
		this.total = null;
		this.condicion = false;
		con = new Connection();
		logger.info("Borrando data Clientes");
		estado = con.deleteClientes();
		if (estado){
			//System.out.println("Borrando datos Totales");
			logger.info("Borrando data Totales");
			con.deleteTotales();
			//System.out.println("Datos Totales borrados");
		}
		estado = true;
		registros_leidos = 0;
		registros1_leidos = 0;
		registros2_leidos = 0;
		registros3_leidos = 0;
		registros4_leidos = 0;
		registros5_leidos = 0;
		registros6_leidos = 0;
		registros7_leidos = 0;
		clientes_insertados = 0;
		totales_insertados = 0;
		
		parametrosCarga();
	}
	
	private void parametrosCarga(){
		Connection con = new Connection();
		
		paramCliente = con.findAllRecord("T91");
		paramTotal1 = con.findAllRecord("T92");
		paramTotal2 = con.findAllRecord("T93");
	}

	public boolean cargaMasiva() {
		//cargando listado de conduccion del mes
		String linea = "";
		int contador = 0;

		try {
			FileInputStream inputStream = null;
			
			//DataInputStream dataInputStream = null;
			BufferedReader d = null;
			
			if (archivo != null) {
				inputStream = new FileInputStream(archivo);
				//dataInputStream = new DataInputStream(inputStream);
				d = new BufferedReader(new InputStreamReader(inputStream));
			} else {
				d = new BufferedReader(new InputStreamReader(isarchivo));
			}
			if (d == null)
				return false;

			logger.info("Empieza la carga masiva");
			//procesando contenido del reporte
			clientes_insertados = 1;
			int lul = 0;
			do {
				//linea = dataInputStream.readLine();
				linea = d.readLine();
				contador++;
				
				//Descarta lineas con longitudes minimas (basura en ultima linea)
				if(linea != null){
					if(linea.length()<100)
						linea = null;
				}
				
				if (linea != null) {
					registros_leidos++;
					int tip_registro = Integer.parseInt(linea.substring(0, 1));
					switch (tip_registro) {
					case 1:
						registros1_leidos++;
						procesaCliente(linea);
						break;
					case 2:
						registros2_leidos++;
						procesaTotal(linea, 'G', 1);
						break;
					case 3:
						registros3_leidos++;
						procesaTotal(linea, 'G', 2);
						break;
					case 4:
						registros4_leidos++;
						procesaTotal(linea, 'O', 1);
						break;
					case 5:
						registros5_leidos++;
						procesaTotal(linea, 'O', 2);
						break;
					case 6:
						registros6_leidos++;
						procesaTotal(linea, 'T', 1);
						break;
					case 7:
						registros7_leidos++;
						procesaTotal(linea, 'T', 2);
						break;

					}
					
					lul++;
					//if (lul%1000==0){
					//	System.out.println(lul + " insertados hasta ahora...");
					//}
				}
			} while (linea != null);
			//System.out.println("Ultima linea procesada : " + lul);
			//System.out.println("Fin de carga : " + lul);
			
            if (archivo != null) inputStream.close();
        	else isarchivo.close();
            
            logger.info("Termino la carga masiva");
            clientes_insertados--;
            logger.info("Registros leidos: " + registros_leidos);
            logger.info("Registros tipo 1: " + registros1_leidos);
            logger.info("Registros tipo 2: " + registros2_leidos);
            logger.info("Registros tipo 3: " + registros3_leidos);
            logger.info("Registros tipo 4: " + registros4_leidos);
            logger.info("Registros tipo 5: " + registros5_leidos);
            logger.info("Registros tipo 6: " + registros6_leidos);
            logger.info("Registros tipo 7: " + registros7_leidos);
            logger.info("Clientes insertados: " + clientes_insertados + " de " + registros1_leidos);
            logger.info("Totales insertados: " + totales_insertados + " de " + (registros2_leidos+registros4_leidos+registros6_leidos));
            
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
        	e.printStackTrace();
            return false;
        }
        return true;
    }
	
	private void procesaTotal(String linea, char tipo, int parte) {
		java.lang.reflect.Method methodInvoked1 = null;
		Multitabla param = null;
		String texto = null;
		Object valor = null;
        int posicion = 0;
        int longitud = 0;
		
		if (linea != null) {
			try {
				if (cliente != null) {
					switch (parte) {
						case 1: {
							total = new Total();
							total.setInd_registro("" + tipo);
							switch (tipo) {
							case 'G':
								total.setCod_gestor(cliente.getCod_gestor());
								total.setCod_oficina(cliente.getCod_oficina());
								total.setCod_territorio(cliente.getCod_territorio());
								break;
							case 'O':
								total.setCod_gestor(" ");
								total.setCod_oficina(cliente.getCod_oficina());
								total.setCod_territorio(cliente.getCod_territorio());
								break;
							case 'T':
								total.setCod_gestor(" ");
								total.setCod_oficina(" ");
								total.setCod_territorio(cliente.getCod_territorio());
								break;
	
							}
	
							//seteando todos los datos del total parte 1
			                for(int i=0; i<paramTotal1.size(); i++){
			                	param = paramTotal1.elementAt(i);
			                	posicion = Integer.parseInt(param.getValor2());
			                	longitud = Integer.parseInt(param.getValor3());
			                	texto = linea.substring(posicion-1,posicion-1+longitud).trim();
			                	if(param.getValor4().equals("1")){
			                		valor = texto; 
			                		methodInvoked1 = total.getClass().getDeclaredMethod(
			                				"set" + param.getValor1(),
											new Class[] { Class.forName("java.lang.String") });
			                	}
			                	else if(param.getValor4().equals("2")){
			                		valor = new Integer(Integer.parseInt(texto));
			                		methodInvoked1 = total.getClass().getDeclaredMethod(
			                				"set" + param.getValor1(),
											new Class[] { Integer.TYPE } );
			                	}
			                	else if(param.getValor4().equals("3")){
			                		valor = Long.valueOf(texto);
			                		methodInvoked1 = total.getClass().getDeclaredMethod(
			                				"set" + param.getValor1(),
											new Class[] { Long.TYPE } );
			                	}
			                	else if(param.getValor4().equals("4")){
			                		valor = new BigDecimal(texto);
			                		methodInvoked1 = total.getClass().getDeclaredMethod(
			                				"set" + param.getValor1(),
											new Class[] { Class.forName("java.math.BigDecimal") });
			                	}
			                	methodInvoked1.invoke(total,new Object[] { valor });
			                }
							condicion = true;
							break;
						}
						case 2: {
							if (condicion) {
								//seteando todos los datos del total parte 2
								for(int i=0; i<paramTotal2.size(); i++){
				                	param = paramTotal2.elementAt(i);
				                	posicion = Integer.parseInt(param.getValor2());
				                	longitud = Integer.parseInt(param.getValor3());
				                	texto = linea.substring(posicion-1,posicion-1+longitud).trim();
				                	if(param.getValor4().equals("1")){
				                		valor = texto; 
				                		methodInvoked1 = total.getClass().getDeclaredMethod(
				                				"set" + param.getValor1(),
												new Class[] { Class.forName("java.lang.String") });
				                	}
				                	else if(param.getValor4().equals("2")){
				                		valor = new Integer(Integer.parseInt(texto));
				                		methodInvoked1 = total.getClass().getDeclaredMethod(
				                				"set" + param.getValor1(),
												new Class[] { Integer.TYPE } );
				                	}
				                	else if(param.getValor4().equals("3")){
				                		valor = Long.valueOf(texto);
				                		methodInvoked1 = total.getClass().getDeclaredMethod(
				                				"set" + param.getValor1(),
												new Class[] { Long.TYPE } );
				                	}
				                	else if(param.getValor4().equals("4")){
				                		valor = new BigDecimal(texto);
				                		methodInvoked1 = total.getClass().getDeclaredMethod(
				                				"set" + param.getValor1(),
												new Class[] { Class.forName("java.math.BigDecimal") });
				                	}
				                	methodInvoked1.invoke(total,new Object[] { valor });
				                }
								
								//creando registro del total
								try {
									if(con.createTotal(total)){
										totales_insertados++;
									}
	                            }catch(Exception e){
	                            	logger.info("Error en creacion del total: " +total.getCod_gestor() + total.getCod_oficina() + total.getCod_territorio());
	                            }
	                            condicion = false;
	                        }
	                        break;
	                    }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	/**
     * @param linea
     */
    private void procesaCliente(String linea) {
    	Connection con = new Connection();
        if (linea != null) {
        	if (linea.length()<1501){
        		linea = Utilitario.longitudMinima(linea,1500);
        	}
            
        	try {
        		java.lang.reflect.Method methodInvoked1 = null;
        		Multitabla param = null;
        		String texto = null;
        		Object valor = null;
                cliente = new Cliente();
                int posicion = 0;
                int longitud = 0;
                
                //seteando todos los datos del cliente
                for(int i=0; i<paramCliente.size(); i++){
                	param = paramCliente.elementAt(i);
                	posicion = Integer.parseInt(param.getValor2());
                	longitud = Integer.parseInt(param.getValor3());
                	texto = linea.substring(posicion-1,posicion-1+longitud).trim();
                	if(param.getValor4().equals("1")){
                		valor = texto; 
                		methodInvoked1 = cliente.getClass().getDeclaredMethod(
                				"set" + param.getValor1(),
								new Class[] { Class.forName("java.lang.String") });
                	}
                	else if(param.getValor4().equals("2")){
                		valor = new Integer(Integer.parseInt(texto));
                		methodInvoked1 = cliente.getClass().getDeclaredMethod(
                				"set" + param.getValor1(),
								new Class[] { Integer.TYPE } );
                	}
                	else if(param.getValor4().equals("3")){
                		valor = Long.valueOf(texto);
                		methodInvoked1 = cliente.getClass().getDeclaredMethod(
                				"set" + param.getValor1(),
								new Class[] { Long.TYPE } );
                	}
                	else if(param.getValor4().equals("4")){
                		valor = new BigDecimal(texto);
                		methodInvoked1 = cliente.getClass().getDeclaredMethod(
                				"set" + param.getValor1(),
								new Class[] { Class.forName("java.math.BigDecimal") });
                	}
                	methodInvoked1.invoke(cliente,new Object[] { valor });
                }
                
                
				//creando registro de cliente
                try{
                    //Reemplazos de informacion
                    reemplazos();
                	
                	cliente.setCod_cliente(clientes_insertados);
                	//conexion.createCliente(cliente);
                	if(con.createCliente(cliente)){
                		clientes_insertados++;
                	}
                }catch(Exception e){
                	logger.info("Error en creacion del cliente: " +total.getCod_gestor() + total.getCod_oficina() + total.getCod_territorio());
                }

            } catch (Exception e) {
            	logger.info("Error en lectura de registro: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
	private void reemplazos() {
		//predeterminado cuando el valor es vacio
		cliente.setCod_empresa(Utilitario.nonEmptyString(cliente.getCod_empresa(),"00000000"));
        cliente.setClasificacion(Utilitario.nonEmptyString(cliente.getClasificacion(),"-"));
    	cliente.setCod_territorio(Utilitario.nonEmptyString(cliente.getCod_territorio()," "));
    	cliente.setCod_oficina(Utilitario.nonEmptyString(cliente.getCod_oficina()," "));
    	cliente.setCod_gestor(Utilitario.nonEmptyString(cliente.getCod_gestor()," "));
    	cliente.setVinculacion(Utilitario.nonEmptyString(cliente.getVinculacion()," "));
    	
    	//vacio cuando el valor es predeterminado
    	cliente.setMofpasv(cliente.getMofpasv().replaceAll("00000000000000000000"," "));
		cliente.setMofserv(cliente.getMofserv().replaceAll("00000000000000000000"," "));
		cliente.setMofcanal(cliente.getMofcanal().replaceAll("00000000000000000000"," "));
    	cliente.setCtacteoferta(cliente.getCtacteoferta().replaceAll("00000000000000000000"," "));
    	cliente.setCtaahoferta(cliente.getCtaahoferta().replaceAll("00000000000000000000"," "));
    	cliente.setCtapoferta(cliente.getCtapoferta().replaceAll("00000000000000000000"," "));
    	cliente.setFmutuoofert(cliente.getFmutuoofert().replaceAll("00000000000000000000"," "));
    	cliente.setCtactsofert(cliente.getCtactsofert().replaceAll("00000000000000000000"," "));
    	cliente.setAtribctactepasv(cliente.getAtribctactepasv().replaceAll("00000000000000000000"," "));
    	cliente.setAtribctaahpasv(cliente.getAtribctaahpasv().replaceAll("00000000000000000000"," "));
    	cliente.setAtribctaplazpasv(cliente.getAtribctaplazpasv().replaceAll("00000000000000000000"," "));
    	cliente.setAtribctspasv(cliente.getAtribctspasv().replaceAll("00000000000000000000"," "));
    	cliente.setAtribfmutuopasv(cliente.getAtribfmutuopasv().replaceAll("00000000000000000000"," "));
    	cliente.setCobofserv(cliente.getCobofserv().replaceAll("00000000000000000000"," "));
    	cliente.setSvidofserv(cliente.getSvidofserv().replaceAll("00000000000000000000"," "));
    	cliente.setSoncofserv(cliente.getSoncofserv().replaceAll("00000000000000000000"," "));
    	cliente.setSvincofserv(cliente.getSvincofserv().replaceAll("00000000000000000000"," "));
    	cliente.setPhofserv(cliente.getPhofserv().replaceAll("00000000000000000000"," "));
    	cliente.setDebofserv(cliente.getDebofserv().replaceAll("00000000000000000000"," "));
    	cliente.setVipofserv(cliente.getVipofserv().replaceAll("00000000000000000000"," "));
    	cliente.setOfcnetcan(cliente.getOfcnetcan().replaceAll("00000000000000000000"," "));
    	cliente.setOfcempcan(cliente.getOfcempcan().replaceAll("00000000000000000000"," "));
    	cliente.setOflincocan(cliente.getOflincocan().replaceAll("00000000000000000000"," "));
    	cliente.setOfb24can(cliente.getOfb24can().replaceAll("00000000000000000000"," "));
    	cliente.setOfposcan(cliente.getOfposcan().replaceAll("00000000000000000000"," "));
	}

	/**
     * @return Returns the estado.
     */
    public boolean isEstado() {
        return estado;
    }
    /**
     * @param estado The estado to set.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
	/**
	 * @return Returns the archivo.
	 */
	public File getArchivo() {
		return archivo;
	}
	/**
	 * @param archivo The archivo to set.
	 */
	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}
	/**
	 * @return Returns the isarchivo.
	 */
	public InputStream getIsarchivo() {
		return isarchivo;
	}
	/**
	 * @param isarchivo The isarchivo to set.
	 */
	public void setIsarchivo(InputStream isarchivo) {
		this.isarchivo = isarchivo;
	}
	/**
	 * @return Returns the clientes_insertados.
	 */
	public int getClientes_insertados() {
		return clientes_insertados;
	}
	/**
	 * @param clientes_insertados The clientes_insertados to set.
	 */
	public void setClientes_insertados(int clientes_insertados) {
		this.clientes_insertados = clientes_insertados;
	}
	/**
	 * @return Returns the registros_leidos.
	 */
	public int getRegistros_leidos() {
		return registros_leidos;
	}
	/**
	 * @param registros_leidos The registros_leidos to set.
	 */
	public void setRegistros_leidos(int registros_leidos) {
		this.registros_leidos = registros_leidos;
	}
	/**
	 * @return Returns the totales_insertados.
	 */
	public int getTotales_insertados() {
		return totales_insertados;
	}
	/**
	 * @return Returns the registros1_leidos.
	 */
	public int getRegistros1_leidos() {
		return registros1_leidos;
	}
	/**
	 * @return Returns the registros2_leidos.
	 */
	public int getRegistros2_leidos() {
		return registros2_leidos;
	}
	/**
	 * @return Returns the registros3_leidos.
	 */
	public int getRegistros3_leidos() {
		return registros3_leidos;
	}
	/**
	 * @return Returns the registros4_leidos.
	 */
	public int getRegistros4_leidos() {
		return registros4_leidos;
	}
	/**
	 * @return Returns the registros5_leidos.
	 */
	public int getRegistros5_leidos() {
		return registros5_leidos;
	}
	/**
	 * @return Returns the registros6_leidos.
	 */
	public int getRegistros6_leidos() {
		return registros6_leidos;
	}
	/**
	 * @return Returns the registros7_leidos.
	 */
	public int getRegistros7_leidos() {
		return registros7_leidos;
	}
	/**
	 * @param totales_insertados The totales_insertados to set.
	 */
	public void setTotales_insertados(int totales_insertados) {
		this.totales_insertados = totales_insertados;
	}
	protected SessionServiceLocal createSessionServiceLocal() {
		SessionServiceLocalHome aSessionServiceLocalHome = (SessionServiceLocalHome) ServiceLocatorManager
				.getLocalHome(STATIC_SessionServiceLocalHome_REF_NAME,
						STATIC_SessionServiceLocalHome_CLASS);
		try {
			if (aSessionServiceLocalHome != null)
				return aSessionServiceLocalHome.create();
		} catch (javax.ejb.CreateException ce) {
			ce.printStackTrace();
		}
		return null;
	}
}