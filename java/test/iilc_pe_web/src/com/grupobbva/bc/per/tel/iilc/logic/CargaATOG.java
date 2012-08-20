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

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection;
import com.grupobbva.bc.per.tel.iilc.serializable.Area;
import com.grupobbva.bc.per.tel.iilc.serializable.Empresa;
import com.grupobbva.bc.per.tel.iilc.serializable.Gestor;
import com.grupobbva.bc.per.tel.iilc.serializable.Oficina;
import com.grupobbva.bc.per.tel.iilc.serializable.Territorio;

public class CargaATOG {

	private File archivo;

	private InputStream isarchivo;

	private boolean estado;

	private int registros_leidos;

	private char tipo;

	private Area area;

	private Territorio territorio;

	private Oficina oficina;

	private Gestor gestor;
	
	private Empresa empresa;

	private int areas_insertados;

	private int territorios_insertados;

	private int oficinas_insertados;

	private int gestores_insertados;
	
	private int empresas_insertadas;
	
	private Connection con;

	static Logger logger = Logger.getLogger(CargaATOG.class);
	
	public CargaATOG(char tipo) {
		this.tipo = tipo;
		this.archivo = null;
		this.isarchivo = null;
		area = null;
		territorio = null;
		oficina = null;
		gestor = null;
		this.estado = true;

		con = new Connection();
		
		switch (tipo) {
		case Constantes.AREA:
			logger.info("Borrando data Areas");
			estado = con.deleteAreas();
			break;

		case Constantes.TERRITORIO:
			logger.info("Borrando data Gestor");
			estado = con.deleteGestores();
			logger.info("Borrando data Oficina");
			estado = con.deleteOficinas();
			logger.info("Borrando data Territorio");
			estado = con.deleteTerritorios();
			break;

		/*case Constantes.OFICINA:
			OficinaDAO oficinaDAO = new OficinaJdbcDAO();
			estado = oficinaDAO.deleteOficinas();
			break;
        */
		case Constantes.GESTOR:
/*			gestorDAO = new GestorJdbcDAO();
*/			logger.info("Borrando data Gestor");
			estado = con.deleteGestores();
			break;
		/**
         * P020795-INI Maria Paula Tomaylla 16/04/2008
         */
		case Constantes.EMPRESA:
			logger.info("Borrando data Empresa");
			estado = con.deleteEmpresas();
			break;
		}
		/**
         * P020795-FIN
         */
		registros_leidos = 0;
		areas_insertados = 0;
		territorios_insertados = 0;
		oficinas_insertados = 0;
		gestores_insertados = 0;
		/**
         * P020795-INI Maria Paula Tomaylla 16/04/2008
         */
		empresas_insertadas= 0;
		/**
         * P020795-FIN
         */
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
					case Constantes.AREA:
						procesaArea(linea);
						break;
	
					case Constantes.TERRITORIO:
						procesaTerritorio(linea);
						break;
	
					/*case Constantes.OFICINA:
						procesaOficina(linea);
						break;
	                */
					case Constantes.GESTOR:
						procesaGestor(linea);
						break;
						
					/**
		             * P020795-INI Maria Paula Tomaylla 16/04/2008
		             */
					case Constantes.EMPRESA:
						procesaEmpresa(linea);
						break;
					}
					/**
					 * P020795-FIN
					 */
					
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
		}
		logger.info("Termino carga masiva");
		logger.info("Territorio insertados: " + territorios_insertados);
        logger.info("Oficinas insertadas: " + oficinas_insertados);
        logger.info("Gestores insertados: " + gestores_insertados);
        logger.info("Empresa insertadas: " + empresas_insertadas);
		return true;
	}

	/**
     * P020795-INI Maria Paula Tomaylla 16/04/2008
     */
    private void procesaEmpresa(String linea) {
        /**
		 *	10 SAL-DESEMP		PIC X(40).
		 	10 SAL-CODEMP       PIC X(08).
		 */
		 if (linea.length() > 47) {
            try {
				empresa = new Empresa();
				empresa.setDes_empresa(linea.substring(0, 40).trim());
				empresa.setCod_empresa(linea.substring(40, 48).trim());
				
				try {
					con.createEmpresa(empresa);
					empresas_insertadas++;
				} catch (Exception e) {
					logger.info("Error en creacion del Empresa: "
							+ empresa.getCod_empresa());
				}
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

    }
    /**
     * P020795-FIN 
     */ 
    /**
	 * @param linea
	 */
	private void procesaGestor(String linea) {
		/**
		 *	10 SAL-CODGES		PIC X(06).
		 	10 SAL-DESGES       PIC X(01).
		 	10 SAL-NOMGES       PIC X(40).
		 	10 SAL-REGGES       PIC X(08).
		 	10 SAL-CENTRO       PIC X(04).
		 */
		 if (linea.length()>= 59) {
            try {
				gestor = new Gestor();
				if (linea.length()== 59) {
				gestor.setCod_gestor(linea.substring(0, 6).trim());
				gestor.setNom_gestor(linea.substring(7, 47).trim());
				gestor.setReg_gestor(linea.substring(47, 55).trim());
				gestor.setCod_oficina(linea.substring(55, linea.length()).trim());
				gestor.setPerfil_gestor("");
				}else if(linea.length()> 59){
					gestor.setCod_gestor(linea.substring(0, 6).trim());
					gestor.setNom_gestor(linea.substring(7, 47).trim());
					gestor.setReg_gestor(linea.substring(47, 55).trim());
					gestor.setCod_oficina(linea.substring(55, 59).trim());
					gestor.setPerfil_gestor(linea.substring(59, linea.length()).trim());
					if(gestor.getNom_gestor().equals("")) gestor.setNom_gestor("NN");
				}
				
				// _paleativo gestor masa
				if(linea.substring(6, 7).equals("M")){
					gestor.setPerfil_gestor("M");
				}
				// _paleativo gestor masa
				
				/*
				Codigo Gestor    PICX(06)
				Indicador        PICX(01)
				Descripcion      PICX(40)
				Registro         PICX(08)
				Oficina          PICX(04)
				Perfil Gestor    PICX(03) 
				*/

				try {
					con.createGestor(gestor);
					gestores_insertados++;
				} catch (Exception e) {
					logger.info("Error en creacion del Gestor: " + gestor.getCod_gestor(), e);
				}
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

	}

	/**
	 * @param linea
	 */
	@SuppressWarnings("unused")
	private void procesaOficina(String linea) {
		if (linea.length() > 11) {
            try {
            	oficina = new Oficina();
				oficina.setCod_area(linea.substring(0, 4).trim());
				oficina.setCod_territorio(linea.substring(4, 8).trim());
				oficina.setCod_oficina(linea.substring(8, 12).trim());
				oficina.setDes_oficina(linea.substring(12, linea.length()).trim());
				try {
					con.createOficina(oficina);
					oficinas_insertados++;
				} catch (Exception e) {
					logger.info("Error en creacion del Oficina: "
							+ oficina.getCod_oficina());
				}
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
	}

	/**
	 * @param linea
	 */
	private void procesaTerritorio(String linea) {
		
		/**
		 *	02 S01-CODOFI		PIC X(04). 
		 	02 S01-DOFI         PIC X(20). 
		 	02 S01-CODTERRI     PIC X(04). 
		 	02 S01-DTERRI       PIC X(20). 
		 */
		if (linea.length() > 27) {
            try {
				territorio = new Territorio();
				territorio.setCod_area("0664");
				territorio.setCod_territorio(linea.substring(24, 28).trim());
				territorio.setDes_territorio(linea.substring(28, linea.length()).trim());
				
				oficina = new Oficina();
				oficina.setCod_area("0664");
				oficina.setCod_territorio(linea.substring(24, 28).trim());
				oficina.setCod_oficina(linea.substring(0, 4).trim());
				oficina.setDes_oficina(linea.substring(4, 24).trim());
				
				
				try {
					con.createTerritorio(territorio);
					territorios_insertados++;
				} catch (Exception e) {
					logger.info("Error en creacion del Territorio: "
							+ territorio.getCod_territorio());
				}
				
				try {
					con.createOficina(oficina);
					oficinas_insertados++;
				} catch (Exception e) {
					logger.info("Error en creacion de la Oficina: "
							+ oficina.getCod_oficina());
				}
				
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
	}

	/**
	 * @param linea
	 */
	private void procesaArea(String linea) {
		if (linea.length() > 3) {
            try {
				area = new Area();
				area.setCod_area(linea.substring(0, 4).trim());
				area.setDes_area(linea.substring(4, linea.length()).trim());
				try {
					con.createArea(area);
					areas_insertados++;
				} catch (Exception e) {
					logger.info("Error en creacion del Area: "
							+ area.getCod_area());
				}
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
	}

	/**
	 * @param linea
	 */

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

	public int getAreas_insertados() {
		return areas_insertados;
	}

	public void setAreas_insertados(int areas_insertados) {
		this.areas_insertados = areas_insertados;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getGestores_insertados() {
		return gestores_insertados;
	}

	public void setGestores_insertados(int gestores_insertados) {
		this.gestores_insertados = gestores_insertados;
	}

	public InputStream getIsarchivo() {
		return isarchivo;
	}

	public void setIsarchivo(InputStream isarchivo) {
		this.isarchivo = isarchivo;
	}

	public int getOficinas_insertados() {
		return oficinas_insertados;
	}

	public void setOficinas_insertados(int oficinas_insertados) {
		this.oficinas_insertados = oficinas_insertados;
	}

	public int getRegistros_leidos() {
		return registros_leidos;
	}

	public void setRegistros_leidos(int registros_leidos) {
		this.registros_leidos = registros_leidos;
	}

	public int getTerritorios_insertados() {
		return territorios_insertados;
	}

	public void setTerritorios_insertados(int territorios_insertados) {
		this.territorios_insertados = territorios_insertados;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

    /**
     * @return Returns the empresas_insertadas.
     */
    public int getEmpresas_insertadas() {
        return empresas_insertadas;
    }
    /**
     * @param empresas_insertadas The empresas_insertadas to set.
     */
    public void setEmpresas_insertadas(int empresas_insertadas) {
        this.empresas_insertadas = empresas_insertadas;
    }
}