/*
 * Created on 27-ene-2010
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package igrupobbva.pe.sistemasdoweb.migracion;

import java.util.Date;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForward;

import proxy.load.Connection;

import com.grupobbva.bc.per.tele.sdo.serializable.TAcciones;
import com.grupobbva.bc.per.tele.sdo.serializable.TCampanhas;
import com.grupobbva.bc.per.tele.sdo.serializable.TCampanhasDetalle;
import com.grupobbva.bc.per.tele.sdo.serializable.TEpigrafes;
import com.grupobbva.bc.per.tele.sdo.serializable.TEquivalencias;
import com.grupobbva.bc.per.tele.sdo.serializable.TFirmas;
import com.grupobbva.bc.per.tele.sdo.serializable.TMaestroPlanes;
import com.grupobbva.bc.per.tele.sdo.serializable.TMetasGestor;
import com.grupobbva.bc.per.tele.sdo.serializable.TOficina;
import com.grupobbva.bc.per.tele.sdo.serializable.TParametros;
import com.grupobbva.bc.per.tele.sdo.serializable.TPerfiles;
import com.grupobbva.bc.per.tele.sdo.serializable.TPlanes;
import com.grupobbva.bc.per.tele.sdo.serializable.TTerritorio;

/**
 * @author ocortez
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
@SuppressWarnings({"unchecked", "unused"})
public class migracionData {
	private static Logger logger = Logger.getLogger(migracionData.class);
	public void migracion1 (){
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection ejb = new Connection();		
		TEpigrafes beanEpigrafes = null;
		TTerritorio beanTerritorio = null;
		TOficina beanOficina = null;

		int contMes=0;
		String contadorMes="";
		
		String sMensaje;
		int indicador=0;
		int contador=0;

		/*EPIGRAFES*/
		String codigoepigrafe="";
		String nombreepigrafe="";		
		String indicadorclase="";
		String indicadorsubclase="";
		String orden="";
		String indicadorgrupo="";
		String abreviatura="";
		String indicadorhijo="";
		String indicadorafecta="";
		String anho="";

		logger.info("TABLA EPIGRAFES");
		Vector osc=null;
		contador=0;	
		osc=ejb.xBusAllTablaEpigrafesAntiguo();
		if(osc!=null){
			for(int i=0; i<osc.size(); i++)
			{
				beanEpigrafes=(TEpigrafes)osc.elementAt(i);
				
				codigoepigrafe=beanEpigrafes.getCodigoepigrafe();
				nombreepigrafe=beanEpigrafes.getNombreepigrafe().trim();
				anho=beanEpigrafes.getAnho();
				indicadorclase=beanEpigrafes.getIndicadorclase();
				indicadorsubclase=beanEpigrafes.getIndicadorsubclase();
				orden=beanEpigrafes.getOrden();
				indicadorgrupo=beanEpigrafes.getIndicadorgrupo();
				abreviatura=beanEpigrafes.getAbreviatura().trim();
				indicadorhijo=beanEpigrafes.getIndicadorhijo();
				indicadorafecta=beanEpigrafes.getIndicadorafecta();
				
				indicador=ejb.xInsertarTEpigrafes(codigoepigrafe,nombreepigrafe, anho, indicadorclase, 
						indicadorsubclase, orden, indicadorgrupo,abreviatura, indicadorhijo, 
						indicadorafecta);
			}
		}
		/*TERRITORIO*/
		String codigoTerritorio="";
		String nombreTerritorio="";		
		indicador=0;
		logger.info("TABLA TERRITORIO");
		osc=null;
		osc=ejb.xBusAllTablaTerritorioAntiguo();
		indicador=0;
		contador=0;
		if(osc!=null){
			for(int i=0; i<osc.size(); i++)
			{
				beanTerritorio=(TTerritorio)osc.elementAt(i);
				
				codigoTerritorio=beanTerritorio.getCodigoTerritorio();
				nombreTerritorio=beanTerritorio.getNombreTerritorio().trim();
				
				indicador=ejb.xInsertarTTerritorio(codigoTerritorio,nombreTerritorio);
				contador=contador+indicador;
			}
		}
		if(contador==0){			
			sMensaje="error";
			logger.info("error TablaTerritorio");
		}else{
			sMensaje="exito";
			logger.info("exito TablaTerritorio");
		}
		/*OFICINA*/
		String codigoOficina="";
		String nombreOficina="";
		indicador=0;
		logger.info("TABLA OFICINA");
		osc=null;
		osc=ejb.xBusAllTablaOficinaAntiguo();
		indicador=0;
		contador=0;
		if(osc!=null){
			for(int i=0; i<osc.size(); i++)
			{
				beanOficina=(TOficina)osc.elementAt(i);
				
				codigoOficina=beanOficina.getCodigoOficina();
				nombreOficina=beanOficina.getNombreOficina().trim();
				codigoTerritorio=beanOficina.getCodigoTerritorio();
				
				indicador=ejb.xInsertarTOficina(codigoTerritorio, nombreOficina, codigoOficina);			
			}
		}
	}		
		
		public void migracion1A1 (){
			
		String territorio;
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection ejb = new Connection();
		TAcciones beanAcciones = null;
		/*ACCIONES*/
		String codigoAccion;
		String nomberAccion;
		String codigoGestor;
		String mes;
		String anho;
		String codigoOficina;
		
		int nroClientes;
		int compromisoGestor;
		int nroGestorSeguimiento1;
		int nroConcSeguimiento1;
		int montoSeguimiento1;
		int nroGestorSeguimiento2;
		int nroConcSeguimiento2;
		int montoSeguimiento2;
		
		String codigoEpigrafe;
		Date fechaSeg1;
		Date fechaSeg2;
		Date fechaGrabacion;
		int contMes=0;
		String contadorMes="";
		logger.info("TABLA ACCIONES");
		int indicador=0;
		int contador=0;
		Vector osc=null;
		String anhoBus="";
		
		for(contMes=1;contMes<7;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}
				if(contadorMes.equals("06") || contadorMes.equals("05")){					
					anhoBus="2007";			
					osc=ejb.xBusAllTablaAccionesAntiguo(contadorMes,anhoBus);
					
				}
				else{
				anho="";
				osc=ejb.xBusAllTablaAccionesAntiguo(contadorMes,anho);
				}
				
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
		if(osc!=null){
			for(int i=0; i<osc.size(); i++)
			{
				beanAcciones=(TAcciones)osc.elementAt(i);
				
				codigoAccion=beanAcciones.getCodigoAccion();
				nomberAccion=beanAcciones.getNombreAccion();
				codigoGestor=beanAcciones.getCodigoGestor();
				mes=beanAcciones.getMes();
				anho=beanAcciones.getAnho();
				nroClientes=beanAcciones.getNroClientes();
				compromisoGestor=beanAcciones.getCompromisoGestor();
				nroGestorSeguimiento1=beanAcciones.getNroGestorSeguimiento1();
				nroConcSeguimiento1=beanAcciones.getNroConcSeguimiento1();
				montoSeguimiento1=beanAcciones.getMontoSeguimiento1();
				nroGestorSeguimiento2=beanAcciones.getNroGestorSeguimiento2();
				nroConcSeguimiento2=beanAcciones.getNroConcSeguimiento2();
				montoSeguimiento2=beanAcciones.getMontoSeguimiento2();
				codigoOficina=beanAcciones.getCodigoOficina();
				codigoEpigrafe=beanAcciones.getCodigoEpigrafe();
				fechaSeg1=beanAcciones.getFechaSeg1();
				fechaSeg2=beanAcciones.getFechaSeg2();
				fechaGrabacion=beanAcciones.getFechaGrabacion();
				
				territorio=ejb.xDameTerritorio(codigoOficina);
				
				indicador=ejb.xInsertarTAcciones(codigoAccion, nomberAccion, codigoGestor, 
				mes,anho, nroClientes, compromisoGestor, nroGestorSeguimiento1,
				nroConcSeguimiento1, montoSeguimiento1, nroGestorSeguimiento2, nroConcSeguimiento2,
				montoSeguimiento2, codigoOficina, codigoEpigrafe, fechaSeg1, fechaSeg2,
				fechaGrabacion, territorio);
				logger.info("TABLA ACCIONESSSSSSSS 11111111111111111111111111111111111111111111111");
			}
		}
		
		if(contadorMes.equals("06") || contadorMes.equals("05")){					
			anhoBus="2008";
			osc=null;
			osc=ejb.xBusAllTablaAccionesAntiguo(contadorMes,anhoBus);
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanAcciones=(TAcciones)osc.elementAt(i);
					
					codigoAccion=beanAcciones.getCodigoAccion();
					nomberAccion=beanAcciones.getNombreAccion();
					codigoGestor=beanAcciones.getCodigoGestor();
					mes=beanAcciones.getMes();
					anho=beanAcciones.getAnho();
					nroClientes=beanAcciones.getNroClientes();
					compromisoGestor=beanAcciones.getCompromisoGestor();
					nroGestorSeguimiento1=beanAcciones.getNroGestorSeguimiento1();
					nroConcSeguimiento1=beanAcciones.getNroConcSeguimiento1();
					montoSeguimiento1=beanAcciones.getMontoSeguimiento1();
					nroGestorSeguimiento2=beanAcciones.getNroGestorSeguimiento2();
					nroConcSeguimiento2=beanAcciones.getNroConcSeguimiento2();
					montoSeguimiento2=beanAcciones.getMontoSeguimiento2();
					codigoOficina=beanAcciones.getCodigoOficina();
					codigoEpigrafe=beanAcciones.getCodigoEpigrafe();
					fechaSeg1=beanAcciones.getFechaSeg1();
					fechaSeg2=beanAcciones.getFechaSeg2();
					fechaGrabacion=beanAcciones.getFechaGrabacion();
					
					territorio=ejb.xDameTerritorio(codigoOficina);
					
					indicador=ejb.xInsertarTAcciones(codigoAccion, nomberAccion, codigoGestor, 
					mes,anho, nroClientes, compromisoGestor, nroGestorSeguimiento1,
					nroConcSeguimiento1, montoSeguimiento1, nroGestorSeguimiento2, nroConcSeguimiento2,
					montoSeguimiento2, codigoOficina, codigoEpigrafe, fechaSeg1, fechaSeg2,
					fechaGrabacion, territorio);
					logger.info("TABLA ACCIONESSSSSSSS 1111111111111111" + "MESSSSSSSSSSSSSSSSSSSSSSSSSSSSSS 06");
				}
			}
			
		}
		if(contadorMes.equals("06")){					
			anhoBus="2006";
			osc=null;
			osc=ejb.xBusAllTablaAccionesAntiguo(contadorMes,anhoBus);
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanAcciones=(TAcciones)osc.elementAt(i);
					
					codigoAccion=beanAcciones.getCodigoAccion();
					nomberAccion=beanAcciones.getNombreAccion();
					codigoGestor=beanAcciones.getCodigoGestor();
					mes=beanAcciones.getMes();
					anho=beanAcciones.getAnho();
					nroClientes=beanAcciones.getNroClientes();
					compromisoGestor=beanAcciones.getCompromisoGestor();
					nroGestorSeguimiento1=beanAcciones.getNroGestorSeguimiento1();
					nroConcSeguimiento1=beanAcciones.getNroConcSeguimiento1();
					montoSeguimiento1=beanAcciones.getMontoSeguimiento1();
					nroGestorSeguimiento2=beanAcciones.getNroGestorSeguimiento2();
					nroConcSeguimiento2=beanAcciones.getNroConcSeguimiento2();
					montoSeguimiento2=beanAcciones.getMontoSeguimiento2();
					codigoOficina=beanAcciones.getCodigoOficina();
					codigoEpigrafe=beanAcciones.getCodigoEpigrafe();
					fechaSeg1=beanAcciones.getFechaSeg1();
					fechaSeg2=beanAcciones.getFechaSeg2();
					fechaGrabacion=beanAcciones.getFechaGrabacion();
					
					territorio=ejb.xDameTerritorio(codigoOficina);
					
					indicador=ejb.xInsertarTAcciones(codigoAccion, nomberAccion, codigoGestor, 
					mes,anho, nroClientes, compromisoGestor, nroGestorSeguimiento1,
					nroConcSeguimiento1, montoSeguimiento1, nroGestorSeguimiento2, nroConcSeguimiento2,
					montoSeguimiento2, codigoOficina, codigoEpigrafe, fechaSeg1, fechaSeg2,
					fechaGrabacion, territorio);
					logger.info("TABLA ACCIONESSSSSSSS 1111111111111111" + "MESSSSSSSSSSSSSSSSSSSSSSSSSSSSSS 06");
				}
			}
			
		}
		
		}
		
	}				
		public void migracion1A2 (){
			
		String territorio;
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		Connection ejb = new Connection();
		TAcciones beanAcciones = null;
		/*ACCIONES*/
		String codigoAccion;
		String nomberAccion;
		String codigoGestor;
		String mes;
		String anho;
		String codigoOficina;
		
		int nroClientes;
		int compromisoGestor;
		int nroGestorSeguimiento1;
		int nroConcSeguimiento1;
		int montoSeguimiento1;
		int nroGestorSeguimiento2;
		int nroConcSeguimiento2;
		int montoSeguimiento2;
		
		String codigoEpigrafe;
		Date fechaSeg1;
		Date fechaSeg2;
		Date fechaGrabacion;
		int contMes=0;
		String contadorMes="";
		logger.info("TABLA ACCIONES");
		int indicador=0;
		int contador=0;
		Vector osc=null;
		String anhoBus="";
		
		for(contMes=7;contMes<13;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}
			if(contadorMes.equals("07") || contadorMes.equals("08") || contadorMes.equals("09") || contadorMes.equals("10") || contadorMes.equals("11") || contadorMes.equals("12")){					
				anhoBus="2006";			
				osc=ejb.xBusAllTablaAccionesAntiguo(contadorMes,anhoBus);
				
			}
			else{
			anho="";
			osc=ejb.xBusAllTablaAccionesAntiguo(contadorMes,anho);
			}		
		
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
		if(osc!=null){
			for(int i=0; i<osc.size(); i++)
			{
				beanAcciones=(TAcciones)osc.elementAt(i);
				
				codigoAccion=beanAcciones.getCodigoAccion();
				nomberAccion=beanAcciones.getNombreAccion();
				codigoGestor=beanAcciones.getCodigoGestor();
				mes=beanAcciones.getMes();
				anho=beanAcciones.getAnho();
				nroClientes=beanAcciones.getNroClientes();
				compromisoGestor=beanAcciones.getCompromisoGestor();
				nroGestorSeguimiento1=beanAcciones.getNroGestorSeguimiento1();
				nroConcSeguimiento1=beanAcciones.getNroConcSeguimiento1();
				montoSeguimiento1=beanAcciones.getMontoSeguimiento1();
				nroGestorSeguimiento2=beanAcciones.getNroGestorSeguimiento2();
				nroConcSeguimiento2=beanAcciones.getNroConcSeguimiento2();
				montoSeguimiento2=beanAcciones.getMontoSeguimiento2();
				codigoOficina=beanAcciones.getCodigoOficina();
				codigoEpigrafe=beanAcciones.getCodigoEpigrafe();
				fechaSeg1=beanAcciones.getFechaSeg1();
				fechaSeg2=beanAcciones.getFechaSeg2();
				fechaGrabacion=beanAcciones.getFechaGrabacion();
				
				territorio=ejb.xDameTerritorio(codigoOficina);
				
				indicador=ejb.xInsertarTAcciones(codigoAccion, nomberAccion, codigoGestor, 
				mes,anho, nroClientes, compromisoGestor, nroGestorSeguimiento1,
				nroConcSeguimiento1, montoSeguimiento1, nroGestorSeguimiento2, nroConcSeguimiento2,
				montoSeguimiento2, codigoOficina, codigoEpigrafe, fechaSeg1, fechaSeg2,
				fechaGrabacion, territorio);
				logger.info("TABLA ACCIONES 22222222222222222222222222222");
			}
		}
		if(contadorMes.equals("07") || contadorMes.equals("08") || contadorMes.equals("09") || contadorMes.equals("10") || contadorMes.equals("11") || contadorMes.equals("12")){					
			anhoBus="2007";
			osc=null;
			osc=ejb.xBusAllTablaAccionesAntiguo(contadorMes,anhoBus);
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanAcciones=(TAcciones)osc.elementAt(i);
					
					codigoAccion=beanAcciones.getCodigoAccion();
					nomberAccion=beanAcciones.getNombreAccion();
					codigoGestor=beanAcciones.getCodigoGestor();
					mes=beanAcciones.getMes();
					anho=beanAcciones.getAnho();
					nroClientes=beanAcciones.getNroClientes();
					compromisoGestor=beanAcciones.getCompromisoGestor();
					nroGestorSeguimiento1=beanAcciones.getNroGestorSeguimiento1();
					nroConcSeguimiento1=beanAcciones.getNroConcSeguimiento1();
					montoSeguimiento1=beanAcciones.getMontoSeguimiento1();
					nroGestorSeguimiento2=beanAcciones.getNroGestorSeguimiento2();
					nroConcSeguimiento2=beanAcciones.getNroConcSeguimiento2();
					montoSeguimiento2=beanAcciones.getMontoSeguimiento2();
					codigoOficina=beanAcciones.getCodigoOficina();
					codigoEpigrafe=beanAcciones.getCodigoEpigrafe();
					fechaSeg1=beanAcciones.getFechaSeg1();
					fechaSeg2=beanAcciones.getFechaSeg2();
					fechaGrabacion=beanAcciones.getFechaGrabacion();
					
					territorio=ejb.xDameTerritorio(codigoOficina);
					
					indicador=ejb.xInsertarTAcciones(codigoAccion, nomberAccion, codigoGestor, 
					mes,anho, nroClientes, compromisoGestor, nroGestorSeguimiento1,
					nroConcSeguimiento1, montoSeguimiento1, nroGestorSeguimiento2, nroConcSeguimiento2,
					montoSeguimiento2, codigoOficina, codigoEpigrafe, fechaSeg1, fechaSeg2,
					fechaGrabacion, territorio);
					logger.info("TABLA ACCIONESSSSSSSS 1111111111111111" + "MESSSSSSSSSSSSSSSSSSSSSSSSSSSSSS 07");
				}
			}
			
		}
		if(contadorMes.equals("07") || contadorMes.equals("08")  || contadorMes.equals("10") ){					
			anhoBus="2008";
			osc=null;
			osc=ejb.xBusAllTablaAccionesAntiguo(contadorMes,anhoBus);
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanAcciones=(TAcciones)osc.elementAt(i);
					
					codigoAccion=beanAcciones.getCodigoAccion();
					nomberAccion=beanAcciones.getNombreAccion();
					codigoGestor=beanAcciones.getCodigoGestor();
					mes=beanAcciones.getMes();
					anho=beanAcciones.getAnho();
					nroClientes=beanAcciones.getNroClientes();
					compromisoGestor=beanAcciones.getCompromisoGestor();
					nroGestorSeguimiento1=beanAcciones.getNroGestorSeguimiento1();
					nroConcSeguimiento1=beanAcciones.getNroConcSeguimiento1();
					montoSeguimiento1=beanAcciones.getMontoSeguimiento1();
					nroGestorSeguimiento2=beanAcciones.getNroGestorSeguimiento2();
					nroConcSeguimiento2=beanAcciones.getNroConcSeguimiento2();
					montoSeguimiento2=beanAcciones.getMontoSeguimiento2();
					codigoOficina=beanAcciones.getCodigoOficina();
					codigoEpigrafe=beanAcciones.getCodigoEpigrafe();
					fechaSeg1=beanAcciones.getFechaSeg1();
					fechaSeg2=beanAcciones.getFechaSeg2();
					fechaGrabacion=beanAcciones.getFechaGrabacion();
					
					territorio=ejb.xDameTerritorio(codigoOficina);
					
					indicador=ejb.xInsertarTAcciones(codigoAccion, nomberAccion, codigoGestor, 
					mes,anho, nroClientes, compromisoGestor, nroGestorSeguimiento1,
					nroConcSeguimiento1, montoSeguimiento1, nroGestorSeguimiento2, nroConcSeguimiento2,
					montoSeguimiento2, codigoOficina, codigoEpigrafe, fechaSeg1, fechaSeg2,
					fechaGrabacion, territorio);
					logger.info("TABLA ACCIONESSSSSSSS 1111111111111111" + "MESSSSSSSSSSSSSSSSSSSSSSSSSSSSSS 07");
				}
			}
			
		}
		
		}
		
	}		
		public void migracion2 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			
			TCampanhas beanCampanhas=null;
			TCampanhasDetalle beanCampanhasDetalle=null;
			TPerfiles beanPerfiles=null;			
		
		/*CAMPA�AS*/

		String codigoCampania;
		String anho;
		String mes;
		String nombreCampania;
		String codigoOficina;
		String codigoGestor;
		String orden;
		String gte;
		Date fechaGrabacion;
		String territorio;
		String sMensaje;
		logger.info("TABLA CAMPA�AS");
		int indicador=0;
		int contador=0;
		Vector osc=null;
		int numLetras=0;
		String anhoBus="2005";
		osc=ejb.xBusAllTablaCampanhasAntiguo(anhoBus);
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       ");
			
		}
		if(osc!=null){
			for(int i=0; i<osc.size(); i++)
			{
				beanCampanhas=(TCampanhas)osc.elementAt(i);
			
				codigoCampania=beanCampanhas.getCodigoCampania();
				anho=beanCampanhas.getAnho();
				mes=beanCampanhas.getMes();
				nombreCampania=beanCampanhas.getNombreCampania();
				if(nombreCampania!=null){
					nombreCampania=nombreCampania.trim();
					numLetras=nombreCampania.length();
					if(numLetras>78){
					nombreCampania=nombreCampania.substring(0,75);
					}
				}
				codigoOficina=beanCampanhas.getCodigoOficina();
				codigoGestor=beanCampanhas.getCodigoGestor();
				orden=beanCampanhas.getOrden();
				gte=beanCampanhas.getGte();
				fechaGrabacion=beanCampanhas.getFechaGrabacion();
				
				territorio=ejb.xDameTerritorio(codigoOficina);
				
				indicador=ejb.xInsertarTCampanhas(codigoCampania, anho, mes, nombreCampania, 
						codigoOficina, codigoGestor, orden, gte, fechaGrabacion, territorio);
			}
		}
		
		anhoBus="2006";
		osc=ejb.xBusAllTablaCampanhasAntiguo(anhoBus);
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       ");
			
		}
		if(osc!=null){
			for(int i=0; i<osc.size(); i++)
			{
				beanCampanhas=(TCampanhas)osc.elementAt(i);
			
				codigoCampania=beanCampanhas.getCodigoCampania();
				anho=beanCampanhas.getAnho();
				mes=beanCampanhas.getMes();
				nombreCampania=beanCampanhas.getNombreCampania();
				if(nombreCampania!=null){
					nombreCampania=nombreCampania.trim();
					numLetras=nombreCampania.length();
					if(numLetras>78){
					nombreCampania=nombreCampania.substring(0,75);
					}
				}
				codigoOficina=beanCampanhas.getCodigoOficina();
				codigoGestor=beanCampanhas.getCodigoGestor();
				orden=beanCampanhas.getOrden();
				gte=beanCampanhas.getGte();
				fechaGrabacion=beanCampanhas.getFechaGrabacion();
				
				territorio=ejb.xDameTerritorio(codigoOficina);
				
				indicador=ejb.xInsertarTCampanhas(codigoCampania, anho, mes, nombreCampania, 
						codigoOficina, codigoGestor, orden, gte, fechaGrabacion, territorio);
			}
		}
		
		anhoBus="2007";
		osc=ejb.xBusAllTablaCampanhasAntiguo(anhoBus);
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       ");
			
		}
		if(osc!=null){
			for(int i=0; i<osc.size(); i++)
			{
				beanCampanhas=(TCampanhas)osc.elementAt(i);
			
				codigoCampania=beanCampanhas.getCodigoCampania();
				anho=beanCampanhas.getAnho();
				mes=beanCampanhas.getMes();
				nombreCampania=beanCampanhas.getNombreCampania();
				if(nombreCampania!=null){
					nombreCampania=nombreCampania.trim();
					numLetras=nombreCampania.length();
					if(numLetras>78){
					nombreCampania=nombreCampania.substring(0,75);
					}
				}
				codigoOficina=beanCampanhas.getCodigoOficina();
				codigoGestor=beanCampanhas.getCodigoGestor();
				orden=beanCampanhas.getOrden();
				gte=beanCampanhas.getGte();
				fechaGrabacion=beanCampanhas.getFechaGrabacion();
				
				territorio=ejb.xDameTerritorio(codigoOficina);
				
				indicador=ejb.xInsertarTCampanhas(codigoCampania, anho, mes, nombreCampania, 
						codigoOficina, codigoGestor, orden, gte, fechaGrabacion, territorio);
			}
		}
		
		/*CAMPA�AS DETALLE*/

		String codigoCampanhaDetalle;
		String nombreCampanha;
		//String codigoGestor;
		//String mes;
		//String anho;
		int nroClientes;
		int compromisoGestor;
		int nroGestorSeguimiento1;
		int nroConcSeguimiento1;
		int montoSeguimiento1;
		int nroGestorSeguimiento2;
		int nroConcSeguimiento2;
		int montoSeguimiento2;
		//String codigoOficina;
		String codigoCampanha;
		//Date fechaGrabacion;
		Date fechaSeg1;
		Date fechaSeg2;
		
		logger.info("TABLA CAMPA�AS DETALLE");
		indicador=0;
		contador=0;
		osc=null;
		osc=ejb.xBusAllTablaCampanhasDetalleAntiguo();
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       ");
			
		}
		if(osc!=null){
			for(int i=0; i<osc.size(); i++)
			{
				beanCampanhasDetalle=(TCampanhasDetalle)osc.elementAt(i);			
				
				codigoCampanhaDetalle=beanCampanhasDetalle.getCodigoCampanhaDetalle();
				nombreCampanha=beanCampanhasDetalle.getNombreCampanha();
				if(nombreCampanha!=null){
					nombreCampanha=nombreCampanha.trim();
					numLetras=nombreCampanha.length();
					if(numLetras>78){
						nombreCampanha=nombreCampanha.substring(0,75);
					}
				}
				codigoGestor=beanCampanhasDetalle.getCodigoGestor();
				mes=beanCampanhasDetalle.getMes();
				anho=beanCampanhasDetalle.getAnho();
				nroClientes=beanCampanhasDetalle.getNroClientes();
				compromisoGestor=beanCampanhasDetalle.getCompromisoGestor();
				nroGestorSeguimiento1=beanCampanhasDetalle.getNroGestorSeguimiento1();
				nroConcSeguimiento1=beanCampanhasDetalle.getNroConcSeguimiento1();
				montoSeguimiento1=beanCampanhasDetalle.getMontoSeguimiento1();
				nroGestorSeguimiento2=beanCampanhasDetalle.getNroGestorSeguimiento2();
				nroConcSeguimiento2=beanCampanhasDetalle.getNroConcSeguimiento2();
				montoSeguimiento2=beanCampanhasDetalle.getMontoSeguimiento2();
				codigoOficina=beanCampanhasDetalle.getCodigoOficina();
				codigoCampanha=beanCampanhasDetalle.getCodigoCampanha();
				fechaGrabacion=beanCampanhasDetalle.getFechaGrabacion();
				fechaSeg1=beanCampanhasDetalle.getFechaSeg1();
				fechaSeg2=beanCampanhasDetalle.getFechaSeg2();
				
				territorio=ejb.xDameTerritorio(codigoOficina);
				
				indicador=ejb.xInsertarTCampanhasDetalle(codigoCampanhaDetalle,	nombreCampanha, codigoGestor,
						mes, anho, nroClientes, compromisoGestor, nroGestorSeguimiento1,
						nroConcSeguimiento1, montoSeguimiento1, nroGestorSeguimiento2,
						nroConcSeguimiento2, montoSeguimiento2, codigoOficina, codigoCampanha,
						fechaGrabacion, fechaSeg1, fechaSeg2, territorio);
			}
		}		
		/*PERFILES*/

		String codigoPerfil;
		String nombrePerfil;
		
		logger.info("TABLA PERFIL");
		indicador=0;
		contador=0;
		osc=null;
		osc=ejb.xBusAllTablaPerfiles();
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       ");
			
		}
		if(osc!=null){
			for(int i=0; i<osc.size(); i++)
			{
				beanPerfiles=(TPerfiles)osc.elementAt(i);
				
				codigoPerfil=beanPerfiles.getCodigoPerfil();
				nombrePerfil=beanPerfiles.getNombrePerfil();			
				
				indicador=ejb.xInsertarTPerfiles(codigoPerfil, nombrePerfil);
			}
		}

	}	
		public void migracion3 (){
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();			
			TFirmas beanFirmas=null;
			TMaestroPlanes beanMaestroPlanes=null;
			TEquivalencias beanEquivalencias=null;
			int contMes=0;
			String contadorMes="";			
			String sMensaje;
			int indicador=0;
			int contador=0;
			String territorio="";
		
		/*EQUIVALENCIAS*/

		String codigoCargo;
		String codigoPerfil;
		logger.info("TABLA EQUIVALENCIAS");
		indicador=0;
		contador=0;
		Vector osc=null;
		osc=ejb.xBusAllTablaEquivalencias();
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       ");
			
		}
		if(osc!=null){
			for(int i=0; i<osc.size(); i++)
			{
				beanEquivalencias=(TEquivalencias)osc.elementAt(i);
				
				codigoCargo=beanEquivalencias.getCodigoCargo();
				codigoPerfil=beanEquivalencias.getCodigoPerfil();			
				
				indicador=ejb.xInsertarTEquivalencias(codigoCargo, codigoPerfil);
			}
		}
		/*FIRMAS*/
		/*
		//String anho;
		//String mes;
		String item;
		//String codigoGestor;
		//String codigoOficina;
		String descripcion;
		Date fecha;
		
		logger.info("TABLA FIRMAS");
		indicador=0;
		osc=null;
		osc=ejb.xBusAllTablaFirmas();
		for(int i=0; i<osc.size(); i++)
		{
			beanFirmas=(TFirmas)osc.elementAt(i);
			
			anho=beanFirmas.getAnho();
			mes=beanFirmas.getMes();
			item=beanFirmas.getItem();
			codigoGestor=beanFirmas.getCodigoGestor();
			codigoOficina=beanFirmas.getCodigoOficina();
			descripcion=beanFirmas.getDescripcion();
			fecha=beanFirmas.getFecha();
			
			indicador=ejb.xInsertarTFirmas(anho, mes, item, codigoGestor, codigoOficina, descripcion, fecha);
		}
		if(indicador==0){			
			sMensaje="error";
			logger.info("error");
		}else{
			sMensaje="exito";
			logger.info("exito");
		}*/
		/*MAESTRO PLANES*/

		String codigoOficina;
		String mes;
		String anho;
		String codigoTerritorio;
		String prioridad;
		Date fechaGrabacion;
		
		logger.info("TABLA MAESTRO PLANES");
		indicador=0;
		contador=0;
		osc=null;
		contMes=0;
		contadorMes="";		
		for(contMes=1;contMes<13;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}
		osc=ejb.xBusAllTablaMaestroPlanes(contadorMes);
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanMaestroPlanes=(TMaestroPlanes)osc.elementAt(i);
					
					codigoOficina=beanMaestroPlanes.getCodigoOficina();
					mes=beanMaestroPlanes.getMes();
					anho=beanMaestroPlanes.getAnho();
					codigoTerritorio=beanMaestroPlanes.getCodigoTerritorio();
					prioridad=beanMaestroPlanes.getPrioridad();
					fechaGrabacion=beanMaestroPlanes.getFechaGrabacion();			
					indicador=ejb.xInsertarTMaestroPlanes(codigoOficina, mes, anho, codigoTerritorio, prioridad, fechaGrabacion);
				}
			}
		}		
	}		
		public void migracion4 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			/*METAS GESTOR*/	
		String codigoMetaGestor;
		String codigoEpigrafe;
		String codigoOficina;
		String codigoGestor;
		String anho;
		String mes;
		String orden;
		Date fecgaGrabacion;
		String porcAsignado;
		String nombreEpigrafe;
		String nombreGestor;		
				
		TMetasGestor beanMetasGestor=null;
		int contMes=0;
		String contadorMes="";			
		String sMensaje;
		int indicador=0;
		int contador=0;
		String territorio="";
		
		logger.info("TABLA METAS GESTOR");
		indicador=0;
		contador=0;
		Vector osc=null;
		contMes=0;
		contadorMes="";		
		for(contMes=1;contMes<13;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}
		osc=ejb.xBusAllTablaMetasGestor(contadorMes);
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanMetasGestor=(TMetasGestor)osc.elementAt(i);
					
					codigoMetaGestor=beanMetasGestor.getCodigoMetaGestor();
					codigoEpigrafe=beanMetasGestor.getCodigoEpigrafe();
					codigoOficina=beanMetasGestor.getCodigoOficina();
					codigoGestor=beanMetasGestor.getCodigoGestor();
					anho=beanMetasGestor.getAnho();
					mes=beanMetasGestor.getMes();
					orden=beanMetasGestor.getOrden()==null?"":beanMetasGestor.getOrden();
					fecgaGrabacion=beanMetasGestor.getFecgaGrabacion();
					porcAsignado=beanMetasGestor.getPorcAsignado();
					nombreEpigrafe=beanMetasGestor.getNombreEpigrafe().trim();
					nombreGestor=beanMetasGestor.getNombreGestor().trim();
					
					territorio=ejb.xDameTerritorio(codigoOficina);
					
					indicador=ejb.xInsertarTMetasGestor(codigoMetaGestor, codigoEpigrafe, codigoOficina, codigoGestor, anho, mes, orden, fecgaGrabacion, porcAsignado, nombreEpigrafe, nombreGestor, territorio);
				}
			}	
		}
	}	
		public void migracion5Planes1 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			
			TParametros beanTParametros=null;
			TPlanes beanTPlanes=null;
			
		/*PARAMETROS*/

		/*Date fechaAccion;
		Date fechaSeguimiento1;
		Date fechaSeguimiento2;
		String afectaAccion;
		String afectaSeguimiento;
		String afectaPlanificacion;
		Date fechaPlanificacion;
		
		logger.info("TABLA PARAMETROS");
		indicador=0;
		osc=null;
		osc=ejb.xBusAllTablaParametros();
		for(int i=0; i<osc.size(); i++)
		{
			beanTParametros=(TParametros)osc.elementAt(i);
			
			codigoMetaGestor=beanMetasGestor.getCodigoMetaGestor();

			fechaAccion=beanTParametros.getFechaAccion();
			fechaSeguimiento1=beanTParametros.getFechaSeguimiento1();
			fechaSeguimiento2=beanTParametros.getFechaSeguimiento2();
			afectaAccion=beanTParametros.getAfectaAccion();
			afectaSeguimiento=beanTParametros.getAfectaSeguimiento();
			afectaPlanificacion=beanTParametros.getAfectaPlanificacion();
			fechaPlanificacion=beanTParametros.getFechaPlanificacion();
			
			indicador=ejb.xInsertarTParametros(fechaAccion, fechaSeguimiento1, fechaSeguimiento2, afectaAccion, afectaSeguimiento, afectaPlanificacion, fechaPlanificacion);
		}
		if(indicador==0){			
			sMensaje="error";
			logger.info("error");
		}else{
			sMensaje="exito";
			logger.info("exito");
		}*/
		/*PLANES*/

		String codigoOficina;
		String mes;
		String anho;
		String codigoEpigrafe;
		String nombreEpigrafe;
		int pesodor;
		int monto;
		int porcAlcanzado;
		int desvpPto;
		int nroMesesFalt;
		int proyCrecMensual;
		int ajusteEstimadoTerr;
		int proyAjusteMensual;
		int saldoMedioJunio;
		int porcSaldoMedioJunio;
		int saldoDiciembreAnterior;
		int saldoMedioDiciembre;
		String codigoTerritorio;
		int porcSaldoMedioDiciembre;
		int factorAjusteSaldoPuntual;
		int historicoBajas;
		int metaMesSaldoPuntual;
		int metaGerenteOficina;
		int prioridadPlanes;
		String mesEvaluacion;
		String indicadorDor;
		int varMes;
		int ajustePspto;
		int desvPsptoAjustado;
		int factAjustTerritorial;
		int factAsignGteOf;
		int contMes=0;
		String sMensaje;
		String contadorMes="01";
		int indicador=0;
		int contador=0;
		Vector osc=null;
		String anhoBus="";
		
		/*for(contMes=1;contMes<3;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}*/
		anhoBus="2005";
		osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanTPlanes=(TPlanes)osc.elementAt(i);
					
					codigoOficina=beanTPlanes.getCodigoOficina();
					mes=beanTPlanes.getMes();
					anho=beanTPlanes.getAnho();
					codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
					nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
					pesodor=beanTPlanes.getPesodor();
					monto=beanTPlanes.getMonto();
					porcAlcanzado=beanTPlanes.getPorcAlcanzado();
					desvpPto=beanTPlanes.getDesvpPto();
					nroMesesFalt=beanTPlanes.getNroMesesFalt();
					proyCrecMensual=beanTPlanes.getProyCrecMensual();
					ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
					proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
					saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
					porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
					saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
					saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
					codigoTerritorio=beanTPlanes.getCodigoTerritorio();
					porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
					factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
					historicoBajas=beanTPlanes.getHistoricoBajas();
					metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
					metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
					prioridadPlanes=beanTPlanes.getPrioridad();
					mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
					indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
					varMes=beanTPlanes.getVarMes();
					ajustePspto=beanTPlanes.getAjustePspto();
					desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
					factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
					factAsignGteOf=beanTPlanes.getFactAsignGteOf();
					
					indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
							codigoEpigrafe, nombreEpigrafe, pesodor, monto,
							porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
							ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
							porcSaldoMedioJunio, saldoDiciembreAnterior,
							saldoMedioDiciembre, codigoTerritorio,
							porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
							historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
							prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
							factAsignGteOf);
					logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 111111111111111111111111111111111111111");
				}
			}
				anhoBus="2006";
				osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
				if(osc==null){
					
				logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
					
				}
					if(osc!=null){
						for(int i=0; i<osc.size(); i++)
						{
							beanTPlanes=(TPlanes)osc.elementAt(i);
							
							codigoOficina=beanTPlanes.getCodigoOficina();
							mes=beanTPlanes.getMes();
							anho=beanTPlanes.getAnho();
							codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
							nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
							pesodor=beanTPlanes.getPesodor();
							monto=beanTPlanes.getMonto();
							porcAlcanzado=beanTPlanes.getPorcAlcanzado();
							desvpPto=beanTPlanes.getDesvpPto();
							nroMesesFalt=beanTPlanes.getNroMesesFalt();
							proyCrecMensual=beanTPlanes.getProyCrecMensual();
							ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
							proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
							saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
							porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
							saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
							saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
							codigoTerritorio=beanTPlanes.getCodigoTerritorio();
							porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
							factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
							historicoBajas=beanTPlanes.getHistoricoBajas();
							metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
							metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
							prioridadPlanes=beanTPlanes.getPrioridad();
							mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
							indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
							varMes=beanTPlanes.getVarMes();
							ajustePspto=beanTPlanes.getAjustePspto();
							desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
							factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
							factAsignGteOf=beanTPlanes.getFactAsignGteOf();
							
							indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
									codigoEpigrafe, nombreEpigrafe, pesodor, monto,
									porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
									ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
									porcSaldoMedioJunio, saldoDiciembreAnterior,
									saldoMedioDiciembre, codigoTerritorio,
									porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
									historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
									prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
									ajustePspto, desvPsptoAjustado, factAjustTerritorial,
									factAsignGteOf);
							logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 111111111111111111111111111111111111111");
						}
					}
						anhoBus="2007";
						osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
						if(osc==null){
							
						logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
							
						}
							if(osc!=null){
								for(int i=0; i<osc.size(); i++)
								{
									beanTPlanes=(TPlanes)osc.elementAt(i);
									
									codigoOficina=beanTPlanes.getCodigoOficina();
									mes=beanTPlanes.getMes();
									anho=beanTPlanes.getAnho();
									codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
									nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
									pesodor=beanTPlanes.getPesodor();
									monto=beanTPlanes.getMonto();
									porcAlcanzado=beanTPlanes.getPorcAlcanzado();
									desvpPto=beanTPlanes.getDesvpPto();
									nroMesesFalt=beanTPlanes.getNroMesesFalt();
									proyCrecMensual=beanTPlanes.getProyCrecMensual();
									ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
									proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
									saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
									porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
									saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
									saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
									codigoTerritorio=beanTPlanes.getCodigoTerritorio();
									porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
									factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
									historicoBajas=beanTPlanes.getHistoricoBajas();
									metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
									metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
									prioridadPlanes=beanTPlanes.getPrioridad();
									mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
									indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
									varMes=beanTPlanes.getVarMes();
									ajustePspto=beanTPlanes.getAjustePspto();
									desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
									factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
									factAsignGteOf=beanTPlanes.getFactAsignGteOf();
									
									indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
											codigoEpigrafe, nombreEpigrafe, pesodor, monto,
											porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
											ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
											porcSaldoMedioJunio, saldoDiciembreAnterior,
											saldoMedioDiciembre, codigoTerritorio,
											porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
											historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
											prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
											ajustePspto, desvPsptoAjustado, factAjustTerritorial,
											factAsignGteOf);
									logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 111111111111111111111111111111111111111");
								}
							}
								anhoBus="2008";
								osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
								if(osc==null){
									
								logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
									
								}
									if(osc!=null){
										for(int i=0; i<osc.size(); i++)
										{
											beanTPlanes=(TPlanes)osc.elementAt(i);
											
											codigoOficina=beanTPlanes.getCodigoOficina();
											mes=beanTPlanes.getMes();
											anho=beanTPlanes.getAnho();
											codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
											nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
											pesodor=beanTPlanes.getPesodor();
											monto=beanTPlanes.getMonto();
											porcAlcanzado=beanTPlanes.getPorcAlcanzado();
											desvpPto=beanTPlanes.getDesvpPto();
											nroMesesFalt=beanTPlanes.getNroMesesFalt();
											proyCrecMensual=beanTPlanes.getProyCrecMensual();
											ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
											proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
											saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
											porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
											saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
											saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
											codigoTerritorio=beanTPlanes.getCodigoTerritorio();
											porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
											factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
											historicoBajas=beanTPlanes.getHistoricoBajas();
											metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
											metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
											prioridadPlanes=beanTPlanes.getPrioridad();
											mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
											indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
											varMes=beanTPlanes.getVarMes();
											ajustePspto=beanTPlanes.getAjustePspto();
											desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
											factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
											factAsignGteOf=beanTPlanes.getFactAsignGteOf();
											
											indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
													codigoEpigrafe, nombreEpigrafe, pesodor, monto,
													porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
													ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
													porcSaldoMedioJunio, saldoDiciembreAnterior,
													saldoMedioDiciembre, codigoTerritorio,
													porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
													historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
													prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
													ajustePspto, desvPsptoAjustado, factAjustTerritorial,
													factAsignGteOf);
											logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 111111111111111111111111111111111111111");
										}
									}
										anhoBus="2009";
										osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
										if(osc==null){
											
										logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
											
										}
											if(osc!=null){
												for(int i=0; i<osc.size(); i++)
												{
													beanTPlanes=(TPlanes)osc.elementAt(i);
													
													codigoOficina=beanTPlanes.getCodigoOficina();
													mes=beanTPlanes.getMes();
													anho=beanTPlanes.getAnho();
													codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
													nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
													pesodor=beanTPlanes.getPesodor();
													monto=beanTPlanes.getMonto();
													porcAlcanzado=beanTPlanes.getPorcAlcanzado();
													desvpPto=beanTPlanes.getDesvpPto();
													nroMesesFalt=beanTPlanes.getNroMesesFalt();
													proyCrecMensual=beanTPlanes.getProyCrecMensual();
													ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
													proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
													saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
													porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
													saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
													saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
													codigoTerritorio=beanTPlanes.getCodigoTerritorio();
													porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
													factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
													historicoBajas=beanTPlanes.getHistoricoBajas();
													metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
													metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
													prioridadPlanes=beanTPlanes.getPrioridad();
													mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
													indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
													varMes=beanTPlanes.getVarMes();
													ajustePspto=beanTPlanes.getAjustePspto();
													desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
													factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
													factAsignGteOf=beanTPlanes.getFactAsignGteOf();
													
													indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
															codigoEpigrafe, nombreEpigrafe, pesodor, monto,
															porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
															ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
															porcSaldoMedioJunio, saldoDiciembreAnterior,
															saldoMedioDiciembre, codigoTerritorio,
															porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
															historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
															prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
															ajustePspto, desvPsptoAjustado, factAjustTerritorial,
															factAsignGteOf);
													logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 111111111111111111111111111111111111111");
												}
						}
											/*SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
											 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
											 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
											 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
											 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
											 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
											 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
											 */
											
											if(osc!=null){
												for(int i=0; i<osc.size(); i++)
												{
													beanTPlanes=(TPlanes)osc.elementAt(i);
													
													codigoOficina=beanTPlanes.getCodigoOficina();
													mes=beanTPlanes.getMes();
													anho=beanTPlanes.getAnho();
													codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
													nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
													pesodor=beanTPlanes.getPesodor();
													monto=beanTPlanes.getMonto();
													porcAlcanzado=beanTPlanes.getPorcAlcanzado();
													desvpPto=beanTPlanes.getDesvpPto();
													nroMesesFalt=beanTPlanes.getNroMesesFalt();
													proyCrecMensual=beanTPlanes.getProyCrecMensual();
													ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
													proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
													saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
													porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
													saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
													saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
													codigoTerritorio=beanTPlanes.getCodigoTerritorio();
													porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
													factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
													historicoBajas=beanTPlanes.getHistoricoBajas();
													metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
													metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
													prioridadPlanes=beanTPlanes.getPrioridad();
													mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
													indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
													varMes=beanTPlanes.getVarMes();
													ajustePspto=beanTPlanes.getAjustePspto();
													desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
													factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
													factAsignGteOf=beanTPlanes.getFactAsignGteOf();
													
													indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
															codigoEpigrafe, nombreEpigrafe, pesodor, monto,
															porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
															ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
															porcSaldoMedioJunio, saldoDiciembreAnterior,
															saldoMedioDiciembre, codigoTerritorio,
															porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
															historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
															prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
															ajustePspto, desvPsptoAjustado, factAjustTerritorial,
															factAsignGteOf);
													logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 111111111111111111111111111111111111111");
												}
											}
												anhoBus="2006";
												osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
												if(osc==null){
													
												logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
													
												}
													if(osc!=null){
														for(int i=0; i<osc.size(); i++)
														{
															beanTPlanes=(TPlanes)osc.elementAt(i);
															
															codigoOficina=beanTPlanes.getCodigoOficina();
															mes=beanTPlanes.getMes();
															anho=beanTPlanes.getAnho();
															codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
															nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
															pesodor=beanTPlanes.getPesodor();
															monto=beanTPlanes.getMonto();
															porcAlcanzado=beanTPlanes.getPorcAlcanzado();
															desvpPto=beanTPlanes.getDesvpPto();
															nroMesesFalt=beanTPlanes.getNroMesesFalt();
															proyCrecMensual=beanTPlanes.getProyCrecMensual();
															ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
															proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
															saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
															porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
															saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
															saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
															codigoTerritorio=beanTPlanes.getCodigoTerritorio();
															porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
															factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
															historicoBajas=beanTPlanes.getHistoricoBajas();
															metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
															metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
															prioridadPlanes=beanTPlanes.getPrioridad();
															mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
															indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
															varMes=beanTPlanes.getVarMes();
															ajustePspto=beanTPlanes.getAjustePspto();
															desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
															factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
															factAsignGteOf=beanTPlanes.getFactAsignGteOf();
															
															indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																	codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																	porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																	ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																	porcSaldoMedioJunio, saldoDiciembreAnterior,
																	saldoMedioDiciembre, codigoTerritorio,
																	porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																	historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																	prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																	ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																	factAsignGteOf);
															logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 111111111111111111111111111111111111111");
														}
													}
														anhoBus="2007";
														osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
														if(osc==null){
															
														logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
															
														}
															if(osc!=null){
																for(int i=0; i<osc.size(); i++)
																{
																	beanTPlanes=(TPlanes)osc.elementAt(i);
																	
																	codigoOficina=beanTPlanes.getCodigoOficina();
																	mes=beanTPlanes.getMes();
																	anho=beanTPlanes.getAnho();
																	codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
																	nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
																	pesodor=beanTPlanes.getPesodor();
																	monto=beanTPlanes.getMonto();
																	porcAlcanzado=beanTPlanes.getPorcAlcanzado();
																	desvpPto=beanTPlanes.getDesvpPto();
																	nroMesesFalt=beanTPlanes.getNroMesesFalt();
																	proyCrecMensual=beanTPlanes.getProyCrecMensual();
																	ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
																	proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
																	saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
																	porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
																	saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
																	saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
																	codigoTerritorio=beanTPlanes.getCodigoTerritorio();
																	porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
																	factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
																	historicoBajas=beanTPlanes.getHistoricoBajas();
																	metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
																	metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
																	prioridadPlanes=beanTPlanes.getPrioridad();
																	mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
																	indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
																	varMes=beanTPlanes.getVarMes();
																	ajustePspto=beanTPlanes.getAjustePspto();
																	desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
																	factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
																	factAsignGteOf=beanTPlanes.getFactAsignGteOf();
																	
																	indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																			codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																			porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																			ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																			porcSaldoMedioJunio, saldoDiciembreAnterior,
																			saldoMedioDiciembre, codigoTerritorio,
																			porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																			historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																			prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																			ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																			factAsignGteOf);
																	logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 111111111111111111111111111111111111111");
																}
															}
																anhoBus="2008";
																osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
																if(osc==null){
																	
																logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
																	
																}
																	if(osc!=null){
																		for(int i=0; i<osc.size(); i++)
																		{
																			beanTPlanes=(TPlanes)osc.elementAt(i);
																			
																			codigoOficina=beanTPlanes.getCodigoOficina();
																			mes=beanTPlanes.getMes();
																			anho=beanTPlanes.getAnho();
																			codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
																			nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
																			pesodor=beanTPlanes.getPesodor();
																			monto=beanTPlanes.getMonto();
																			porcAlcanzado=beanTPlanes.getPorcAlcanzado();
																			desvpPto=beanTPlanes.getDesvpPto();
																			nroMesesFalt=beanTPlanes.getNroMesesFalt();
																			proyCrecMensual=beanTPlanes.getProyCrecMensual();
																			ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
																			proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
																			saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
																			porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
																			saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
																			saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
																			codigoTerritorio=beanTPlanes.getCodigoTerritorio();
																			porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
																			factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
																			historicoBajas=beanTPlanes.getHistoricoBajas();
																			metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
																			metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
																			prioridadPlanes=beanTPlanes.getPrioridad();
																			mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
																			indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
																			varMes=beanTPlanes.getVarMes();
																			ajustePspto=beanTPlanes.getAjustePspto();
																			desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
																			factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
																			factAsignGteOf=beanTPlanes.getFactAsignGteOf();
																			
																			indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																					codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																					porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																					ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																					porcSaldoMedioJunio, saldoDiciembreAnterior,
																					saldoMedioDiciembre, codigoTerritorio,
																					porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																					historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																					prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																					ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																					factAsignGteOf);
																			logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 111111111111111111111111111111111111111");
																		}
																	}
																		anhoBus="2009";
																		osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
																		if(osc==null){
																			
																		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
																			
																		}
																			if(osc!=null){
																				for(int i=0; i<osc.size(); i++)
																				{
																					beanTPlanes=(TPlanes)osc.elementAt(i);
																					
																					codigoOficina=beanTPlanes.getCodigoOficina();
																					mes=beanTPlanes.getMes();
																					anho=beanTPlanes.getAnho();
																					codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
																					nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
																					pesodor=beanTPlanes.getPesodor();
																					monto=beanTPlanes.getMonto();
																					porcAlcanzado=beanTPlanes.getPorcAlcanzado();
																					desvpPto=beanTPlanes.getDesvpPto();
																					nroMesesFalt=beanTPlanes.getNroMesesFalt();
																					proyCrecMensual=beanTPlanes.getProyCrecMensual();
																					ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
																					proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
																					saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
																					porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
																					saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
																					saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
																					codigoTerritorio=beanTPlanes.getCodigoTerritorio();
																					porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
																					factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
																					historicoBajas=beanTPlanes.getHistoricoBajas();
																					metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
																					metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
																					prioridadPlanes=beanTPlanes.getPrioridad();
																					mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
																					indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
																					varMes=beanTPlanes.getVarMes();
																					ajustePspto=beanTPlanes.getAjustePspto();
																					desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
																					factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
																					factAsignGteOf=beanTPlanes.getFactAsignGteOf();
																					
																					indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																							codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																							porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																							ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																							porcSaldoMedioJunio, saldoDiciembreAnterior,
																							saldoMedioDiciembre, codigoTerritorio,
																							porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																							historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																							prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																							factAsignGteOf);
																					logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 111111111111111111111111111111111111111");
																				}
														}
		}
	
		public void migracion5Planes2 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			
			TPlanes beanTPlanes=null;			

		/*PLANES*/

		String codigoOficina;
		String mes;
		String anho;
		String codigoEpigrafe;
		String nombreEpigrafe;
		int pesodor;
		int monto;
		int porcAlcanzado;
		int desvpPto;
		int nroMesesFalt;
		int proyCrecMensual;
		int ajusteEstimadoTerr;
		int proyAjusteMensual;
		int saldoMedioJunio;
		int porcSaldoMedioJunio;
		int saldoDiciembreAnterior;
		int saldoMedioDiciembre;
		String codigoTerritorio;
		int porcSaldoMedioDiciembre;
		int factorAjusteSaldoPuntual;
		int historicoBajas;
		int metaMesSaldoPuntual;
		int metaGerenteOficina;
		int prioridadPlanes;
		String mesEvaluacion;
		String indicadorDor;
		int varMes;
		int ajustePspto;
		int desvPsptoAjustado;
		int factAjustTerritorial;
		int factAsignGteOf;
		int contMes=0;
		String sMensaje;
		String contadorMes="02";
		int indicador=0;
		int contador=0;
		Vector osc=null;
		
		String anhoBus="";
		
		/*for(contMes=1;contMes<3;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}*/
		anhoBus="2005";
		osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanTPlanes=(TPlanes)osc.elementAt(i);
					
					codigoOficina=beanTPlanes.getCodigoOficina();
					mes=beanTPlanes.getMes();
					anho=beanTPlanes.getAnho();
					codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
					nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
					pesodor=beanTPlanes.getPesodor();
					monto=beanTPlanes.getMonto();
					porcAlcanzado=beanTPlanes.getPorcAlcanzado();
					desvpPto=beanTPlanes.getDesvpPto();
					nroMesesFalt=beanTPlanes.getNroMesesFalt();
					proyCrecMensual=beanTPlanes.getProyCrecMensual();
					ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
					proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
					saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
					porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
					saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
					saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
					codigoTerritorio=beanTPlanes.getCodigoTerritorio();
					porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
					factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
					historicoBajas=beanTPlanes.getHistoricoBajas();
					metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
					metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
					prioridadPlanes=beanTPlanes.getPrioridad();
					mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
					indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
					varMes=beanTPlanes.getVarMes();
					ajustePspto=beanTPlanes.getAjustePspto();
					desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
					factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
					factAsignGteOf=beanTPlanes.getFactAsignGteOf();
					
					indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
							codigoEpigrafe, nombreEpigrafe, pesodor, monto,
							porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
							ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
							porcSaldoMedioJunio, saldoDiciembreAnterior,
							saldoMedioDiciembre, codigoTerritorio,
							porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
							historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
							prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
							factAsignGteOf);
					logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 22222222222222222222222222222222222222");
				}
			//}
		}
			anhoBus="2006";
			osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
				if(osc!=null){
					for(int i=0; i<osc.size(); i++)
					{
						beanTPlanes=(TPlanes)osc.elementAt(i);
						
						codigoOficina=beanTPlanes.getCodigoOficina();
						mes=beanTPlanes.getMes();
						anho=beanTPlanes.getAnho();
						codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
						nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
						pesodor=beanTPlanes.getPesodor();
						monto=beanTPlanes.getMonto();
						porcAlcanzado=beanTPlanes.getPorcAlcanzado();
						desvpPto=beanTPlanes.getDesvpPto();
						nroMesesFalt=beanTPlanes.getNroMesesFalt();
						proyCrecMensual=beanTPlanes.getProyCrecMensual();
						ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
						proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
						saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
						porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
						saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
						saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
						codigoTerritorio=beanTPlanes.getCodigoTerritorio();
						porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
						factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
						historicoBajas=beanTPlanes.getHistoricoBajas();
						metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
						metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
						prioridadPlanes=beanTPlanes.getPrioridad();
						mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
						indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
						varMes=beanTPlanes.getVarMes();
						ajustePspto=beanTPlanes.getAjustePspto();
						desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
						factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
						factAsignGteOf=beanTPlanes.getFactAsignGteOf();
						
						indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
								codigoEpigrafe, nombreEpigrafe, pesodor, monto,
								porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
								ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
								porcSaldoMedioJunio, saldoDiciembreAnterior,
								saldoMedioDiciembre, codigoTerritorio,
								porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
								historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
								prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
								ajustePspto, desvPsptoAjustado, factAjustTerritorial,
								factAsignGteOf);
						logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 22222222222222222222222222222222222222");
					}
				//}
			}
				anhoBus="2007";
				osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
				if(osc==null){
					
				logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
					
				}
					if(osc!=null){
						for(int i=0; i<osc.size(); i++)
						{
							beanTPlanes=(TPlanes)osc.elementAt(i);
							
							codigoOficina=beanTPlanes.getCodigoOficina();
							mes=beanTPlanes.getMes();
							anho=beanTPlanes.getAnho();
							codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
							nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
							pesodor=beanTPlanes.getPesodor();
							monto=beanTPlanes.getMonto();
							porcAlcanzado=beanTPlanes.getPorcAlcanzado();
							desvpPto=beanTPlanes.getDesvpPto();
							nroMesesFalt=beanTPlanes.getNroMesesFalt();
							proyCrecMensual=beanTPlanes.getProyCrecMensual();
							ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
							proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
							saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
							porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
							saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
							saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
							codigoTerritorio=beanTPlanes.getCodigoTerritorio();
							porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
							factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
							historicoBajas=beanTPlanes.getHistoricoBajas();
							metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
							metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
							prioridadPlanes=beanTPlanes.getPrioridad();
							mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
							indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
							varMes=beanTPlanes.getVarMes();
							ajustePspto=beanTPlanes.getAjustePspto();
							desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
							factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
							factAsignGteOf=beanTPlanes.getFactAsignGteOf();
							
							indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
									codigoEpigrafe, nombreEpigrafe, pesodor, monto,
									porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
									ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
									porcSaldoMedioJunio, saldoDiciembreAnterior,
									saldoMedioDiciembre, codigoTerritorio,
									porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
									historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
									prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
									ajustePspto, desvPsptoAjustado, factAjustTerritorial,
									factAsignGteOf);
							logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 22222222222222222222222222222222222222");
						}
					//}
				}
					anhoBus="2008";
					osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
					if(osc==null){
						
					logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
						
					}
						if(osc!=null){
							for(int i=0; i<osc.size(); i++)
							{
								beanTPlanes=(TPlanes)osc.elementAt(i);
								
								codigoOficina=beanTPlanes.getCodigoOficina();
								mes=beanTPlanes.getMes();
								anho=beanTPlanes.getAnho();
								codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
								nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
								pesodor=beanTPlanes.getPesodor();
								monto=beanTPlanes.getMonto();
								porcAlcanzado=beanTPlanes.getPorcAlcanzado();
								desvpPto=beanTPlanes.getDesvpPto();
								nroMesesFalt=beanTPlanes.getNroMesesFalt();
								proyCrecMensual=beanTPlanes.getProyCrecMensual();
								ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
								proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
								saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
								porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
								saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
								saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
								codigoTerritorio=beanTPlanes.getCodigoTerritorio();
								porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
								factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
								historicoBajas=beanTPlanes.getHistoricoBajas();
								metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
								metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
								prioridadPlanes=beanTPlanes.getPrioridad();
								mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
								indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
								varMes=beanTPlanes.getVarMes();
								ajustePspto=beanTPlanes.getAjustePspto();
								desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
								factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
								factAsignGteOf=beanTPlanes.getFactAsignGteOf();
								
								indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
										codigoEpigrafe, nombreEpigrafe, pesodor, monto,
										porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
										ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
										porcSaldoMedioJunio, saldoDiciembreAnterior,
										saldoMedioDiciembre, codigoTerritorio,
										porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
										historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
										prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
										ajustePspto, desvPsptoAjustado, factAjustTerritorial,
										factAsignGteOf);
								logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 22222222222222222222222222222222222222");
							}
						//}
					}
						anhoBus="2009";
						osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
						if(osc==null){
							
						logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
							
						}
							if(osc!=null){
								for(int i=0; i<osc.size(); i++)
								{
									beanTPlanes=(TPlanes)osc.elementAt(i);
									
									codigoOficina=beanTPlanes.getCodigoOficina();
									mes=beanTPlanes.getMes();
									anho=beanTPlanes.getAnho();
									codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
									nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
									pesodor=beanTPlanes.getPesodor();
									monto=beanTPlanes.getMonto();
									porcAlcanzado=beanTPlanes.getPorcAlcanzado();
									desvpPto=beanTPlanes.getDesvpPto();
									nroMesesFalt=beanTPlanes.getNroMesesFalt();
									proyCrecMensual=beanTPlanes.getProyCrecMensual();
									ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
									proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
									saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
									porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
									saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
									saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
									codigoTerritorio=beanTPlanes.getCodigoTerritorio();
									porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
									factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
									historicoBajas=beanTPlanes.getHistoricoBajas();
									metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
									metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
									prioridadPlanes=beanTPlanes.getPrioridad();
									mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
									indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
									varMes=beanTPlanes.getVarMes();
									ajustePspto=beanTPlanes.getAjustePspto();
									desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
									factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
									factAsignGteOf=beanTPlanes.getFactAsignGteOf();
									
									indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
											codigoEpigrafe, nombreEpigrafe, pesodor, monto,
											porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
											ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
											porcSaldoMedioJunio, saldoDiciembreAnterior,
											saldoMedioDiciembre, codigoTerritorio,
											porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
											historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
											prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
											ajustePspto, desvPsptoAjustado, factAjustTerritorial,
											factAsignGteOf);
									logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 22222222222222222222222222222222222222");
								}
							//}
						}
							
							/* SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 */
							anhoBus="2005";
							osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
							if(osc!=null){
								for(int i=0; i<osc.size(); i++)
								{
									beanTPlanes=(TPlanes)osc.elementAt(i);
									
									codigoOficina=beanTPlanes.getCodigoOficina();
									mes=beanTPlanes.getMes();
									anho=beanTPlanes.getAnho();
									codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
									nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
									pesodor=beanTPlanes.getPesodor();
									monto=beanTPlanes.getMonto();
									porcAlcanzado=beanTPlanes.getPorcAlcanzado();
									desvpPto=beanTPlanes.getDesvpPto();
									nroMesesFalt=beanTPlanes.getNroMesesFalt();
									proyCrecMensual=beanTPlanes.getProyCrecMensual();
									ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
									proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
									saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
									porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
									saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
									saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
									codigoTerritorio=beanTPlanes.getCodigoTerritorio();
									porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
									factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
									historicoBajas=beanTPlanes.getHistoricoBajas();
									metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
									metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
									prioridadPlanes=beanTPlanes.getPrioridad();
									mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
									indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
									varMes=beanTPlanes.getVarMes();
									ajustePspto=beanTPlanes.getAjustePspto();
									desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
									factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
									factAsignGteOf=beanTPlanes.getFactAsignGteOf();
									
									indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
											codigoEpigrafe, nombreEpigrafe, pesodor, monto,
											porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
											ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
											porcSaldoMedioJunio, saldoDiciembreAnterior,
											saldoMedioDiciembre, codigoTerritorio,
											porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
											historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
											prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
											ajustePspto, desvPsptoAjustado, factAjustTerritorial,
											factAsignGteOf);
									logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 22222222222222222222222222222222222222");
								}
							//}
						}
							anhoBus="2006";
							osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
							if(osc==null){
								
							logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
								
							}
								if(osc!=null){
									for(int i=0; i<osc.size(); i++)
									{
										beanTPlanes=(TPlanes)osc.elementAt(i);
										
										codigoOficina=beanTPlanes.getCodigoOficina();
										mes=beanTPlanes.getMes();
										anho=beanTPlanes.getAnho();
										codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
										nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
										pesodor=beanTPlanes.getPesodor();
										monto=beanTPlanes.getMonto();
										porcAlcanzado=beanTPlanes.getPorcAlcanzado();
										desvpPto=beanTPlanes.getDesvpPto();
										nroMesesFalt=beanTPlanes.getNroMesesFalt();
										proyCrecMensual=beanTPlanes.getProyCrecMensual();
										ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
										proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
										saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
										porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
										saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
										saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
										codigoTerritorio=beanTPlanes.getCodigoTerritorio();
										porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
										factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
										historicoBajas=beanTPlanes.getHistoricoBajas();
										metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
										metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
										prioridadPlanes=beanTPlanes.getPrioridad();
										mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
										indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
										varMes=beanTPlanes.getVarMes();
										ajustePspto=beanTPlanes.getAjustePspto();
										desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
										factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
										factAsignGteOf=beanTPlanes.getFactAsignGteOf();
										
										indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
												codigoEpigrafe, nombreEpigrafe, pesodor, monto,
												porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
												ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
												porcSaldoMedioJunio, saldoDiciembreAnterior,
												saldoMedioDiciembre, codigoTerritorio,
												porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
												historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
												prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
												ajustePspto, desvPsptoAjustado, factAjustTerritorial,
												factAsignGteOf);
										logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 22222222222222222222222222222222222222");
									}
								//}
							}
								anhoBus="2007";
								osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
								if(osc==null){
									
								logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
									
								}
									if(osc!=null){
										for(int i=0; i<osc.size(); i++)
										{
											beanTPlanes=(TPlanes)osc.elementAt(i);
											
											codigoOficina=beanTPlanes.getCodigoOficina();
											mes=beanTPlanes.getMes();
											anho=beanTPlanes.getAnho();
											codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
											nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
											pesodor=beanTPlanes.getPesodor();
											monto=beanTPlanes.getMonto();
											porcAlcanzado=beanTPlanes.getPorcAlcanzado();
											desvpPto=beanTPlanes.getDesvpPto();
											nroMesesFalt=beanTPlanes.getNroMesesFalt();
											proyCrecMensual=beanTPlanes.getProyCrecMensual();
											ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
											proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
											saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
											porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
											saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
											saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
											codigoTerritorio=beanTPlanes.getCodigoTerritorio();
											porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
											factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
											historicoBajas=beanTPlanes.getHistoricoBajas();
											metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
											metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
											prioridadPlanes=beanTPlanes.getPrioridad();
											mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
											indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
											varMes=beanTPlanes.getVarMes();
											ajustePspto=beanTPlanes.getAjustePspto();
											desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
											factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
											factAsignGteOf=beanTPlanes.getFactAsignGteOf();
											
											indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
													codigoEpigrafe, nombreEpigrafe, pesodor, monto,
													porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
													ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
													porcSaldoMedioJunio, saldoDiciembreAnterior,
													saldoMedioDiciembre, codigoTerritorio,
													porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
													historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
													prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
													ajustePspto, desvPsptoAjustado, factAjustTerritorial,
													factAsignGteOf);
											logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 22222222222222222222222222222222222222");
										}
									//}
								}
									anhoBus="2008";
									osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
									if(osc==null){
										
									logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
										
									}
										if(osc!=null){
											for(int i=0; i<osc.size(); i++)
											{
												beanTPlanes=(TPlanes)osc.elementAt(i);
												
												codigoOficina=beanTPlanes.getCodigoOficina();
												mes=beanTPlanes.getMes();
												anho=beanTPlanes.getAnho();
												codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
												nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
												pesodor=beanTPlanes.getPesodor();
												monto=beanTPlanes.getMonto();
												porcAlcanzado=beanTPlanes.getPorcAlcanzado();
												desvpPto=beanTPlanes.getDesvpPto();
												nroMesesFalt=beanTPlanes.getNroMesesFalt();
												proyCrecMensual=beanTPlanes.getProyCrecMensual();
												ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
												proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
												saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
												porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
												saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
												saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
												codigoTerritorio=beanTPlanes.getCodigoTerritorio();
												porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
												factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
												historicoBajas=beanTPlanes.getHistoricoBajas();
												metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
												metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
												prioridadPlanes=beanTPlanes.getPrioridad();
												mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
												indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
												varMes=beanTPlanes.getVarMes();
												ajustePspto=beanTPlanes.getAjustePspto();
												desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
												factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
												factAsignGteOf=beanTPlanes.getFactAsignGteOf();
												
												indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
														codigoEpigrafe, nombreEpigrafe, pesodor, monto,
														porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
														ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
														porcSaldoMedioJunio, saldoDiciembreAnterior,
														saldoMedioDiciembre, codigoTerritorio,
														porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
														historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
														prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
														ajustePspto, desvPsptoAjustado, factAjustTerritorial,
														factAsignGteOf);
												logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 22222222222222222222222222222222222222");
											}
										//}
									}
										anhoBus="2009";
										osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
										if(osc==null){
											
										logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
											
										}
											if(osc!=null){
												for(int i=0; i<osc.size(); i++)
												{
													beanTPlanes=(TPlanes)osc.elementAt(i);
													
													codigoOficina=beanTPlanes.getCodigoOficina();
													mes=beanTPlanes.getMes();
													anho=beanTPlanes.getAnho();
													codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
													nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
													pesodor=beanTPlanes.getPesodor();
													monto=beanTPlanes.getMonto();
													porcAlcanzado=beanTPlanes.getPorcAlcanzado();
													desvpPto=beanTPlanes.getDesvpPto();
													nroMesesFalt=beanTPlanes.getNroMesesFalt();
													proyCrecMensual=beanTPlanes.getProyCrecMensual();
													ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
													proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
													saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
													porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
													saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
													saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
													codigoTerritorio=beanTPlanes.getCodigoTerritorio();
													porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
													factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
													historicoBajas=beanTPlanes.getHistoricoBajas();
													metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
													metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
													prioridadPlanes=beanTPlanes.getPrioridad();
													mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
													indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
													varMes=beanTPlanes.getVarMes();
													ajustePspto=beanTPlanes.getAjustePspto();
													desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
													factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
													factAsignGteOf=beanTPlanes.getFactAsignGteOf();
													
													indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
															codigoEpigrafe, nombreEpigrafe, pesodor, monto,
															porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
															ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
															porcSaldoMedioJunio, saldoDiciembreAnterior,
															saldoMedioDiciembre, codigoTerritorio,
															porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
															historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
															prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
															ajustePspto, desvPsptoAjustado, factAjustTerritorial,
															factAsignGteOf);
													logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 22222222222222222222222222222222222222");
												}
											//}
										}
							
							
							
	}
		public void migracion5Planes3 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			
			TPlanes beanTPlanes=null;			

		/*PLANES*/

		String codigoOficina;
		String mes;
		String anho;
		String codigoEpigrafe;
		String nombreEpigrafe;
		int pesodor;
		int monto;
		int porcAlcanzado;
		int desvpPto;
		int nroMesesFalt;
		int proyCrecMensual;
		int ajusteEstimadoTerr;
		int proyAjusteMensual;
		int saldoMedioJunio;
		int porcSaldoMedioJunio;
		int saldoDiciembreAnterior;
		int saldoMedioDiciembre;
		String codigoTerritorio;
		int porcSaldoMedioDiciembre;
		int factorAjusteSaldoPuntual;
		int historicoBajas;
		int metaMesSaldoPuntual;
		int metaGerenteOficina;
		int prioridadPlanes;
		String mesEvaluacion;
		String indicadorDor;
		int varMes;
		int ajustePspto;
		int desvPsptoAjustado;
		int factAjustTerritorial;
		int factAsignGteOf;
		int contMes=0;
		String sMensaje;
		String contadorMes="03";
		int indicador=0;
		int contador=0;
		Vector osc=null;
		
		String anhoBus="";
		
		/*for(contMes=1;contMes<3;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}*/
		anhoBus="2005";
		osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanTPlanes=(TPlanes)osc.elementAt(i);
					
					codigoOficina=beanTPlanes.getCodigoOficina();
					mes=beanTPlanes.getMes();
					anho=beanTPlanes.getAnho();
					codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
					nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
					pesodor=beanTPlanes.getPesodor();
					monto=beanTPlanes.getMonto();
					porcAlcanzado=beanTPlanes.getPorcAlcanzado();
					desvpPto=beanTPlanes.getDesvpPto();
					nroMesesFalt=beanTPlanes.getNroMesesFalt();
					proyCrecMensual=beanTPlanes.getProyCrecMensual();
					ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
					proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
					saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
					porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
					saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
					saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
					codigoTerritorio=beanTPlanes.getCodigoTerritorio();
					porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
					factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
					historicoBajas=beanTPlanes.getHistoricoBajas();
					metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
					metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
					prioridadPlanes=beanTPlanes.getPrioridad();
					mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
					indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
					varMes=beanTPlanes.getVarMes();
					ajustePspto=beanTPlanes.getAjustePspto();
					desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
					factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
					factAsignGteOf=beanTPlanes.getFactAsignGteOf();
					
					indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
							codigoEpigrafe, nombreEpigrafe, pesodor, monto,
							porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
							ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
							porcSaldoMedioJunio, saldoDiciembreAnterior,
							saldoMedioDiciembre, codigoTerritorio,
							porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
							historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
							prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
							factAsignGteOf);
					logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 333333333333333333333333333333333333333");
				}
			//}
		}
			anhoBus="2006";
			osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
				if(osc!=null){
					for(int i=0; i<osc.size(); i++)
					{
						beanTPlanes=(TPlanes)osc.elementAt(i);
						
						codigoOficina=beanTPlanes.getCodigoOficina();
						mes=beanTPlanes.getMes();
						anho=beanTPlanes.getAnho();
						codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
						nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
						pesodor=beanTPlanes.getPesodor();
						monto=beanTPlanes.getMonto();
						porcAlcanzado=beanTPlanes.getPorcAlcanzado();
						desvpPto=beanTPlanes.getDesvpPto();
						nroMesesFalt=beanTPlanes.getNroMesesFalt();
						proyCrecMensual=beanTPlanes.getProyCrecMensual();
						ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
						proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
						saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
						porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
						saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
						saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
						codigoTerritorio=beanTPlanes.getCodigoTerritorio();
						porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
						factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
						historicoBajas=beanTPlanes.getHistoricoBajas();
						metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
						metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
						prioridadPlanes=beanTPlanes.getPrioridad();
						mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
						indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
						varMes=beanTPlanes.getVarMes();
						ajustePspto=beanTPlanes.getAjustePspto();
						desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
						factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
						factAsignGteOf=beanTPlanes.getFactAsignGteOf();
						
						indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
								codigoEpigrafe, nombreEpigrafe, pesodor, monto,
								porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
								ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
								porcSaldoMedioJunio, saldoDiciembreAnterior,
								saldoMedioDiciembre, codigoTerritorio,
								porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
								historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
								prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
								ajustePspto, desvPsptoAjustado, factAjustTerritorial,
								factAsignGteOf);
						logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 333333333333333333333333333333333333333");
					}
				//}
			}
				anhoBus="2007";
				osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
				if(osc==null){
					
				logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
					
				}
					if(osc!=null){
						for(int i=0; i<osc.size(); i++)
						{
							beanTPlanes=(TPlanes)osc.elementAt(i);
							
							codigoOficina=beanTPlanes.getCodigoOficina();
							mes=beanTPlanes.getMes();
							anho=beanTPlanes.getAnho();
							codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
							nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
							pesodor=beanTPlanes.getPesodor();
							monto=beanTPlanes.getMonto();
							porcAlcanzado=beanTPlanes.getPorcAlcanzado();
							desvpPto=beanTPlanes.getDesvpPto();
							nroMesesFalt=beanTPlanes.getNroMesesFalt();
							proyCrecMensual=beanTPlanes.getProyCrecMensual();
							ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
							proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
							saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
							porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
							saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
							saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
							codigoTerritorio=beanTPlanes.getCodigoTerritorio();
							porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
							factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
							historicoBajas=beanTPlanes.getHistoricoBajas();
							metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
							metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
							prioridadPlanes=beanTPlanes.getPrioridad();
							mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
							indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
							varMes=beanTPlanes.getVarMes();
							ajustePspto=beanTPlanes.getAjustePspto();
							desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
							factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
							factAsignGteOf=beanTPlanes.getFactAsignGteOf();
							
							indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
									codigoEpigrafe, nombreEpigrafe, pesodor, monto,
									porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
									ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
									porcSaldoMedioJunio, saldoDiciembreAnterior,
									saldoMedioDiciembre, codigoTerritorio,
									porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
									historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
									prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
									ajustePspto, desvPsptoAjustado, factAjustTerritorial,
									factAsignGteOf);
							logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 333333333333333333333333333333333333333");
						}
					//}
				}
					anhoBus="2008";
					osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
					if(osc==null){
						
					logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
						
					}
						if(osc!=null){
							for(int i=0; i<osc.size(); i++)
							{
								beanTPlanes=(TPlanes)osc.elementAt(i);
								
								codigoOficina=beanTPlanes.getCodigoOficina();
								mes=beanTPlanes.getMes();
								anho=beanTPlanes.getAnho();
								codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
								nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
								pesodor=beanTPlanes.getPesodor();
								monto=beanTPlanes.getMonto();
								porcAlcanzado=beanTPlanes.getPorcAlcanzado();
								desvpPto=beanTPlanes.getDesvpPto();
								nroMesesFalt=beanTPlanes.getNroMesesFalt();
								proyCrecMensual=beanTPlanes.getProyCrecMensual();
								ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
								proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
								saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
								porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
								saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
								saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
								codigoTerritorio=beanTPlanes.getCodigoTerritorio();
								porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
								factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
								historicoBajas=beanTPlanes.getHistoricoBajas();
								metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
								metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
								prioridadPlanes=beanTPlanes.getPrioridad();
								mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
								indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
								varMes=beanTPlanes.getVarMes();
								ajustePspto=beanTPlanes.getAjustePspto();
								desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
								factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
								factAsignGteOf=beanTPlanes.getFactAsignGteOf();
								
								indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
										codigoEpigrafe, nombreEpigrafe, pesodor, monto,
										porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
										ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
										porcSaldoMedioJunio, saldoDiciembreAnterior,
										saldoMedioDiciembre, codigoTerritorio,
										porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
										historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
										prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
										ajustePspto, desvPsptoAjustado, factAjustTerritorial,
										factAsignGteOf);
								logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 333333333333333333333333333333333333333");
							}
						//}
					}
						anhoBus="2009";
						osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
						if(osc==null){
							
						logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
							
						}
							if(osc!=null){
								for(int i=0; i<osc.size(); i++)
								{
									beanTPlanes=(TPlanes)osc.elementAt(i);
									
									codigoOficina=beanTPlanes.getCodigoOficina();
									mes=beanTPlanes.getMes();
									anho=beanTPlanes.getAnho();
									codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
									nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
									pesodor=beanTPlanes.getPesodor();
									monto=beanTPlanes.getMonto();
									porcAlcanzado=beanTPlanes.getPorcAlcanzado();
									desvpPto=beanTPlanes.getDesvpPto();
									nroMesesFalt=beanTPlanes.getNroMesesFalt();
									proyCrecMensual=beanTPlanes.getProyCrecMensual();
									ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
									proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
									saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
									porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
									saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
									saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
									codigoTerritorio=beanTPlanes.getCodigoTerritorio();
									porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
									factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
									historicoBajas=beanTPlanes.getHistoricoBajas();
									metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
									metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
									prioridadPlanes=beanTPlanes.getPrioridad();
									mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
									indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
									varMes=beanTPlanes.getVarMes();
									ajustePspto=beanTPlanes.getAjustePspto();
									desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
									factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
									factAsignGteOf=beanTPlanes.getFactAsignGteOf();
									
									indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
											codigoEpigrafe, nombreEpigrafe, pesodor, monto,
											porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
											ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
											porcSaldoMedioJunio, saldoDiciembreAnterior,
											saldoMedioDiciembre, codigoTerritorio,
											porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
											historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
											prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
											ajustePspto, desvPsptoAjustado, factAjustTerritorial,
											factAsignGteOf);
									logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 333333333333333333333333333333333333333");
								}
							//}
						}
							
							
							/* SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 */
							
							anhoBus="2005";
							osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
							if(osc==null){
								
							logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
								
							}
								if(osc!=null){
									for(int i=0; i<osc.size(); i++)
									{
										beanTPlanes=(TPlanes)osc.elementAt(i);
										
										codigoOficina=beanTPlanes.getCodigoOficina();
										mes=beanTPlanes.getMes();
										anho=beanTPlanes.getAnho();
										codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
										nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
										pesodor=beanTPlanes.getPesodor();
										monto=beanTPlanes.getMonto();
										porcAlcanzado=beanTPlanes.getPorcAlcanzado();
										desvpPto=beanTPlanes.getDesvpPto();
										nroMesesFalt=beanTPlanes.getNroMesesFalt();
										proyCrecMensual=beanTPlanes.getProyCrecMensual();
										ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
										proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
										saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
										porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
										saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
										saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
										codigoTerritorio=beanTPlanes.getCodigoTerritorio();
										porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
										factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
										historicoBajas=beanTPlanes.getHistoricoBajas();
										metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
										metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
										prioridadPlanes=beanTPlanes.getPrioridad();
										mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
										indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
										varMes=beanTPlanes.getVarMes();
										ajustePspto=beanTPlanes.getAjustePspto();
										desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
										factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
										factAsignGteOf=beanTPlanes.getFactAsignGteOf();
										
										indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
												codigoEpigrafe, nombreEpigrafe, pesodor, monto,
												porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
												ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
												porcSaldoMedioJunio, saldoDiciembreAnterior,
												saldoMedioDiciembre, codigoTerritorio,
												porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
												historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
												prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
												ajustePspto, desvPsptoAjustado, factAjustTerritorial,
												factAsignGteOf);
										logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 333333333333333333333333333333333333333");
									}
								//}
							}
								anhoBus="2006";
								osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
								if(osc==null){
									
								logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
									
								}
									if(osc!=null){
										for(int i=0; i<osc.size(); i++)
										{
											beanTPlanes=(TPlanes)osc.elementAt(i);
											
											codigoOficina=beanTPlanes.getCodigoOficina();
											mes=beanTPlanes.getMes();
											anho=beanTPlanes.getAnho();
											codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
											nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
											pesodor=beanTPlanes.getPesodor();
											monto=beanTPlanes.getMonto();
											porcAlcanzado=beanTPlanes.getPorcAlcanzado();
											desvpPto=beanTPlanes.getDesvpPto();
											nroMesesFalt=beanTPlanes.getNroMesesFalt();
											proyCrecMensual=beanTPlanes.getProyCrecMensual();
											ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
											proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
											saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
											porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
											saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
											saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
											codigoTerritorio=beanTPlanes.getCodigoTerritorio();
											porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
											factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
											historicoBajas=beanTPlanes.getHistoricoBajas();
											metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
											metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
											prioridadPlanes=beanTPlanes.getPrioridad();
											mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
											indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
											varMes=beanTPlanes.getVarMes();
											ajustePspto=beanTPlanes.getAjustePspto();
											desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
											factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
											factAsignGteOf=beanTPlanes.getFactAsignGteOf();
											
											indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
													codigoEpigrafe, nombreEpigrafe, pesodor, monto,
													porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
													ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
													porcSaldoMedioJunio, saldoDiciembreAnterior,
													saldoMedioDiciembre, codigoTerritorio,
													porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
													historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
													prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
													ajustePspto, desvPsptoAjustado, factAjustTerritorial,
													factAsignGteOf);
											logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 333333333333333333333333333333333333333");
										}
									//}
								}
									anhoBus="2007";
									osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
									if(osc==null){
										
									logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
										
									}
										if(osc!=null){
											for(int i=0; i<osc.size(); i++)
											{
												beanTPlanes=(TPlanes)osc.elementAt(i);
												
												codigoOficina=beanTPlanes.getCodigoOficina();
												mes=beanTPlanes.getMes();
												anho=beanTPlanes.getAnho();
												codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
												nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
												pesodor=beanTPlanes.getPesodor();
												monto=beanTPlanes.getMonto();
												porcAlcanzado=beanTPlanes.getPorcAlcanzado();
												desvpPto=beanTPlanes.getDesvpPto();
												nroMesesFalt=beanTPlanes.getNroMesesFalt();
												proyCrecMensual=beanTPlanes.getProyCrecMensual();
												ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
												proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
												saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
												porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
												saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
												saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
												codigoTerritorio=beanTPlanes.getCodigoTerritorio();
												porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
												factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
												historicoBajas=beanTPlanes.getHistoricoBajas();
												metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
												metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
												prioridadPlanes=beanTPlanes.getPrioridad();
												mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
												indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
												varMes=beanTPlanes.getVarMes();
												ajustePspto=beanTPlanes.getAjustePspto();
												desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
												factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
												factAsignGteOf=beanTPlanes.getFactAsignGteOf();
												
												indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
														codigoEpigrafe, nombreEpigrafe, pesodor, monto,
														porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
														ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
														porcSaldoMedioJunio, saldoDiciembreAnterior,
														saldoMedioDiciembre, codigoTerritorio,
														porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
														historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
														prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
														ajustePspto, desvPsptoAjustado, factAjustTerritorial,
														factAsignGteOf);
												logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 333333333333333333333333333333333333333");
											}
										//}
									}
										anhoBus="2008";
										osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
										if(osc==null){
											
										logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
											
										}
											if(osc!=null){
												for(int i=0; i<osc.size(); i++)
												{
													beanTPlanes=(TPlanes)osc.elementAt(i);
													
													codigoOficina=beanTPlanes.getCodigoOficina();
													mes=beanTPlanes.getMes();
													anho=beanTPlanes.getAnho();
													codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
													nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
													pesodor=beanTPlanes.getPesodor();
													monto=beanTPlanes.getMonto();
													porcAlcanzado=beanTPlanes.getPorcAlcanzado();
													desvpPto=beanTPlanes.getDesvpPto();
													nroMesesFalt=beanTPlanes.getNroMesesFalt();
													proyCrecMensual=beanTPlanes.getProyCrecMensual();
													ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
													proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
													saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
													porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
													saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
													saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
													codigoTerritorio=beanTPlanes.getCodigoTerritorio();
													porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
													factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
													historicoBajas=beanTPlanes.getHistoricoBajas();
													metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
													metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
													prioridadPlanes=beanTPlanes.getPrioridad();
													mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
													indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
													varMes=beanTPlanes.getVarMes();
													ajustePspto=beanTPlanes.getAjustePspto();
													desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
													factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
													factAsignGteOf=beanTPlanes.getFactAsignGteOf();
													
													indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
															codigoEpigrafe, nombreEpigrafe, pesodor, monto,
															porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
															ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
															porcSaldoMedioJunio, saldoDiciembreAnterior,
															saldoMedioDiciembre, codigoTerritorio,
															porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
															historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
															prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
															ajustePspto, desvPsptoAjustado, factAjustTerritorial,
															factAsignGteOf);
													logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 333333333333333333333333333333333333333");
												}
											//}
										}
											anhoBus="2009";
											osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
											if(osc==null){
												
											logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
												
											}
												if(osc!=null){
													for(int i=0; i<osc.size(); i++)
													{
														beanTPlanes=(TPlanes)osc.elementAt(i);
														
														codigoOficina=beanTPlanes.getCodigoOficina();
														mes=beanTPlanes.getMes();
														anho=beanTPlanes.getAnho();
														codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
														nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
														pesodor=beanTPlanes.getPesodor();
														monto=beanTPlanes.getMonto();
														porcAlcanzado=beanTPlanes.getPorcAlcanzado();
														desvpPto=beanTPlanes.getDesvpPto();
														nroMesesFalt=beanTPlanes.getNroMesesFalt();
														proyCrecMensual=beanTPlanes.getProyCrecMensual();
														ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
														proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
														saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
														porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
														saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
														saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
														codigoTerritorio=beanTPlanes.getCodigoTerritorio();
														porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
														factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
														historicoBajas=beanTPlanes.getHistoricoBajas();
														metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
														metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
														prioridadPlanes=beanTPlanes.getPrioridad();
														mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
														indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
														varMes=beanTPlanes.getVarMes();
														ajustePspto=beanTPlanes.getAjustePspto();
														desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
														factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
														factAsignGteOf=beanTPlanes.getFactAsignGteOf();
														
														indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																porcSaldoMedioJunio, saldoDiciembreAnterior,
																saldoMedioDiciembre, codigoTerritorio,
																porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																factAsignGteOf);
														logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 333333333333333333333333333333333333333");
													}
												//}
											}
	}
		public void migracion5Planes4 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			
			TPlanes beanTPlanes=null;			

		/*PLANES*/

		String codigoOficina;
		String mes;
		String anho;
		String codigoEpigrafe;
		String nombreEpigrafe;
		int pesodor;
		int monto;
		int porcAlcanzado;
		int desvpPto;
		int nroMesesFalt;
		int proyCrecMensual;
		int ajusteEstimadoTerr;
		int proyAjusteMensual;
		int saldoMedioJunio;
		int porcSaldoMedioJunio;
		int saldoDiciembreAnterior;
		int saldoMedioDiciembre;
		String codigoTerritorio;
		int porcSaldoMedioDiciembre;
		int factorAjusteSaldoPuntual;
		int historicoBajas;
		int metaMesSaldoPuntual;
		int metaGerenteOficina;
		int prioridadPlanes;
		String mesEvaluacion;
		String indicadorDor;
		int varMes;
		int ajustePspto;
		int desvPsptoAjustado;
		int factAjustTerritorial;
		int factAsignGteOf;
		int contMes=0;
		String sMensaje;
		String contadorMes="04";
		int indicador=0;
		int contador=0;
		Vector osc=null;
		
		String anhoBus="";
		
		/*for(contMes=1;contMes<3;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}*/
		anhoBus="2005";
		osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanTPlanes=(TPlanes)osc.elementAt(i);
					
					codigoOficina=beanTPlanes.getCodigoOficina();
					mes=beanTPlanes.getMes();
					anho=beanTPlanes.getAnho();
					codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
					nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
					pesodor=beanTPlanes.getPesodor();
					monto=beanTPlanes.getMonto();
					porcAlcanzado=beanTPlanes.getPorcAlcanzado();
					desvpPto=beanTPlanes.getDesvpPto();
					nroMesesFalt=beanTPlanes.getNroMesesFalt();
					proyCrecMensual=beanTPlanes.getProyCrecMensual();
					ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
					proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
					saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
					porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
					saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
					saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
					codigoTerritorio=beanTPlanes.getCodigoTerritorio();
					porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
					factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
					historicoBajas=beanTPlanes.getHistoricoBajas();
					metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
					metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
					prioridadPlanes=beanTPlanes.getPrioridad();
					mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
					indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
					varMes=beanTPlanes.getVarMes();
					ajustePspto=beanTPlanes.getAjustePspto();
					desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
					factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
					factAsignGteOf=beanTPlanes.getFactAsignGteOf();
					
					indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
							codigoEpigrafe, nombreEpigrafe, pesodor, monto,
							porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
							ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
							porcSaldoMedioJunio, saldoDiciembreAnterior,
							saldoMedioDiciembre, codigoTerritorio,
							porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
							historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
							prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
							factAsignGteOf);
					logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 4444444444444444444444444444444");
				}
			//}
		}
			anhoBus="2006";
			osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
				if(osc!=null){
					for(int i=0; i<osc.size(); i++)
					{
						beanTPlanes=(TPlanes)osc.elementAt(i);
						
						codigoOficina=beanTPlanes.getCodigoOficina();
						mes=beanTPlanes.getMes();
						anho=beanTPlanes.getAnho();
						codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
						nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
						pesodor=beanTPlanes.getPesodor();
						monto=beanTPlanes.getMonto();
						porcAlcanzado=beanTPlanes.getPorcAlcanzado();
						desvpPto=beanTPlanes.getDesvpPto();
						nroMesesFalt=beanTPlanes.getNroMesesFalt();
						proyCrecMensual=beanTPlanes.getProyCrecMensual();
						ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
						proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
						saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
						porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
						saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
						saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
						codigoTerritorio=beanTPlanes.getCodigoTerritorio();
						porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
						factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
						historicoBajas=beanTPlanes.getHistoricoBajas();
						metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
						metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
						prioridadPlanes=beanTPlanes.getPrioridad();
						mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
						indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
						varMes=beanTPlanes.getVarMes();
						ajustePspto=beanTPlanes.getAjustePspto();
						desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
						factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
						factAsignGteOf=beanTPlanes.getFactAsignGteOf();
						
						indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
								codigoEpigrafe, nombreEpigrafe, pesodor, monto,
								porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
								ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
								porcSaldoMedioJunio, saldoDiciembreAnterior,
								saldoMedioDiciembre, codigoTerritorio,
								porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
								historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
								prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
								ajustePspto, desvPsptoAjustado, factAjustTerritorial,
								factAsignGteOf);
						logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 4444444444444444444444444444444");
					}
				//}
			}
				anhoBus="2007";
				osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
				if(osc==null){
					
				logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
					
				}
					if(osc!=null){
						for(int i=0; i<osc.size(); i++)
						{
							beanTPlanes=(TPlanes)osc.elementAt(i);
							
							codigoOficina=beanTPlanes.getCodigoOficina();
							mes=beanTPlanes.getMes();
							anho=beanTPlanes.getAnho();
							codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
							nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
							pesodor=beanTPlanes.getPesodor();
							monto=beanTPlanes.getMonto();
							porcAlcanzado=beanTPlanes.getPorcAlcanzado();
							desvpPto=beanTPlanes.getDesvpPto();
							nroMesesFalt=beanTPlanes.getNroMesesFalt();
							proyCrecMensual=beanTPlanes.getProyCrecMensual();
							ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
							proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
							saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
							porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
							saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
							saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
							codigoTerritorio=beanTPlanes.getCodigoTerritorio();
							porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
							factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
							historicoBajas=beanTPlanes.getHistoricoBajas();
							metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
							metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
							prioridadPlanes=beanTPlanes.getPrioridad();
							mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
							indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
							varMes=beanTPlanes.getVarMes();
							ajustePspto=beanTPlanes.getAjustePspto();
							desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
							factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
							factAsignGteOf=beanTPlanes.getFactAsignGteOf();
							
							indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
									codigoEpigrafe, nombreEpigrafe, pesodor, monto,
									porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
									ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
									porcSaldoMedioJunio, saldoDiciembreAnterior,
									saldoMedioDiciembre, codigoTerritorio,
									porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
									historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
									prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
									ajustePspto, desvPsptoAjustado, factAjustTerritorial,
									factAsignGteOf);
							logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 4444444444444444444444444444444");
						}
					//}
				}
					anhoBus="2008";
					osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
					if(osc==null){
						
					logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
						
					}
						if(osc!=null){
							for(int i=0; i<osc.size(); i++)
							{
								beanTPlanes=(TPlanes)osc.elementAt(i);
								
								codigoOficina=beanTPlanes.getCodigoOficina();
								mes=beanTPlanes.getMes();
								anho=beanTPlanes.getAnho();
								codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
								nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
								pesodor=beanTPlanes.getPesodor();
								monto=beanTPlanes.getMonto();
								porcAlcanzado=beanTPlanes.getPorcAlcanzado();
								desvpPto=beanTPlanes.getDesvpPto();
								nroMesesFalt=beanTPlanes.getNroMesesFalt();
								proyCrecMensual=beanTPlanes.getProyCrecMensual();
								ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
								proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
								saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
								porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
								saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
								saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
								codigoTerritorio=beanTPlanes.getCodigoTerritorio();
								porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
								factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
								historicoBajas=beanTPlanes.getHistoricoBajas();
								metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
								metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
								prioridadPlanes=beanTPlanes.getPrioridad();
								mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
								indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
								varMes=beanTPlanes.getVarMes();
								ajustePspto=beanTPlanes.getAjustePspto();
								desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
								factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
								factAsignGteOf=beanTPlanes.getFactAsignGteOf();
								
								indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
										codigoEpigrafe, nombreEpigrafe, pesodor, monto,
										porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
										ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
										porcSaldoMedioJunio, saldoDiciembreAnterior,
										saldoMedioDiciembre, codigoTerritorio,
										porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
										historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
										prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
										ajustePspto, desvPsptoAjustado, factAjustTerritorial,
										factAsignGteOf);
								logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 4444444444444444444444444444444");
							}
						//}
					}
						anhoBus="2009";
						osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
						if(osc==null){
							
						logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
							
						}
							if(osc!=null){
								for(int i=0; i<osc.size(); i++)
								{
									beanTPlanes=(TPlanes)osc.elementAt(i);
									
									codigoOficina=beanTPlanes.getCodigoOficina();
									mes=beanTPlanes.getMes();
									anho=beanTPlanes.getAnho();
									codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
									nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
									pesodor=beanTPlanes.getPesodor();
									monto=beanTPlanes.getMonto();
									porcAlcanzado=beanTPlanes.getPorcAlcanzado();
									desvpPto=beanTPlanes.getDesvpPto();
									nroMesesFalt=beanTPlanes.getNroMesesFalt();
									proyCrecMensual=beanTPlanes.getProyCrecMensual();
									ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
									proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
									saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
									porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
									saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
									saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
									codigoTerritorio=beanTPlanes.getCodigoTerritorio();
									porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
									factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
									historicoBajas=beanTPlanes.getHistoricoBajas();
									metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
									metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
									prioridadPlanes=beanTPlanes.getPrioridad();
									mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
									indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
									varMes=beanTPlanes.getVarMes();
									ajustePspto=beanTPlanes.getAjustePspto();
									desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
									factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
									factAsignGteOf=beanTPlanes.getFactAsignGteOf();
									
									indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
											codigoEpigrafe, nombreEpigrafe, pesodor, monto,
											porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
											ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
											porcSaldoMedioJunio, saldoDiciembreAnterior,
											saldoMedioDiciembre, codigoTerritorio,
											porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
											historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
											prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
											ajustePspto, desvPsptoAjustado, factAjustTerritorial,
											factAsignGteOf);
									logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 4444444444444444444444444444444");
								}
							//}
						}
							
							/* SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 */
							anhoBus="2005";
							osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
							if(osc==null){
								
							logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
								
							}
								if(osc!=null){
									for(int i=0; i<osc.size(); i++)
									{
										beanTPlanes=(TPlanes)osc.elementAt(i);
										
										codigoOficina=beanTPlanes.getCodigoOficina();
										mes=beanTPlanes.getMes();
										anho=beanTPlanes.getAnho();
										codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
										nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
										pesodor=beanTPlanes.getPesodor();
										monto=beanTPlanes.getMonto();
										porcAlcanzado=beanTPlanes.getPorcAlcanzado();
										desvpPto=beanTPlanes.getDesvpPto();
										nroMesesFalt=beanTPlanes.getNroMesesFalt();
										proyCrecMensual=beanTPlanes.getProyCrecMensual();
										ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
										proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
										saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
										porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
										saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
										saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
										codigoTerritorio=beanTPlanes.getCodigoTerritorio();
										porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
										factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
										historicoBajas=beanTPlanes.getHistoricoBajas();
										metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
										metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
										prioridadPlanes=beanTPlanes.getPrioridad();
										mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
										indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
										varMes=beanTPlanes.getVarMes();
										ajustePspto=beanTPlanes.getAjustePspto();
										desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
										factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
										factAsignGteOf=beanTPlanes.getFactAsignGteOf();
										
										indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
												codigoEpigrafe, nombreEpigrafe, pesodor, monto,
												porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
												ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
												porcSaldoMedioJunio, saldoDiciembreAnterior,
												saldoMedioDiciembre, codigoTerritorio,
												porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
												historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
												prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
												ajustePspto, desvPsptoAjustado, factAjustTerritorial,
												factAsignGteOf);
										logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 4444444444444444444444444444444");
									}
								//}
							}
								anhoBus="2006";
								osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
								if(osc==null){
									
								logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
									
								}
									if(osc!=null){
										for(int i=0; i<osc.size(); i++)
										{
											beanTPlanes=(TPlanes)osc.elementAt(i);
											
											codigoOficina=beanTPlanes.getCodigoOficina();
											mes=beanTPlanes.getMes();
											anho=beanTPlanes.getAnho();
											codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
											nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
											pesodor=beanTPlanes.getPesodor();
											monto=beanTPlanes.getMonto();
											porcAlcanzado=beanTPlanes.getPorcAlcanzado();
											desvpPto=beanTPlanes.getDesvpPto();
											nroMesesFalt=beanTPlanes.getNroMesesFalt();
											proyCrecMensual=beanTPlanes.getProyCrecMensual();
											ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
											proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
											saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
											porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
											saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
											saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
											codigoTerritorio=beanTPlanes.getCodigoTerritorio();
											porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
											factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
											historicoBajas=beanTPlanes.getHistoricoBajas();
											metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
											metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
											prioridadPlanes=beanTPlanes.getPrioridad();
											mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
											indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
											varMes=beanTPlanes.getVarMes();
											ajustePspto=beanTPlanes.getAjustePspto();
											desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
											factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
											factAsignGteOf=beanTPlanes.getFactAsignGteOf();
											
											indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
													codigoEpigrafe, nombreEpigrafe, pesodor, monto,
													porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
													ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
													porcSaldoMedioJunio, saldoDiciembreAnterior,
													saldoMedioDiciembre, codigoTerritorio,
													porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
													historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
													prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
													ajustePspto, desvPsptoAjustado, factAjustTerritorial,
													factAsignGteOf);
											logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 4444444444444444444444444444444");
										}
									//}
								}
									anhoBus="2007";
									osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
									if(osc==null){
										
									logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
										
									}
										if(osc!=null){
											for(int i=0; i<osc.size(); i++)
											{
												beanTPlanes=(TPlanes)osc.elementAt(i);
												
												codigoOficina=beanTPlanes.getCodigoOficina();
												mes=beanTPlanes.getMes();
												anho=beanTPlanes.getAnho();
												codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
												nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
												pesodor=beanTPlanes.getPesodor();
												monto=beanTPlanes.getMonto();
												porcAlcanzado=beanTPlanes.getPorcAlcanzado();
												desvpPto=beanTPlanes.getDesvpPto();
												nroMesesFalt=beanTPlanes.getNroMesesFalt();
												proyCrecMensual=beanTPlanes.getProyCrecMensual();
												ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
												proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
												saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
												porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
												saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
												saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
												codigoTerritorio=beanTPlanes.getCodigoTerritorio();
												porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
												factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
												historicoBajas=beanTPlanes.getHistoricoBajas();
												metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
												metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
												prioridadPlanes=beanTPlanes.getPrioridad();
												mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
												indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
												varMes=beanTPlanes.getVarMes();
												ajustePspto=beanTPlanes.getAjustePspto();
												desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
												factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
												factAsignGteOf=beanTPlanes.getFactAsignGteOf();
												
												indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
														codigoEpigrafe, nombreEpigrafe, pesodor, monto,
														porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
														ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
														porcSaldoMedioJunio, saldoDiciembreAnterior,
														saldoMedioDiciembre, codigoTerritorio,
														porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
														historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
														prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
														ajustePspto, desvPsptoAjustado, factAjustTerritorial,
														factAsignGteOf);
												logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 4444444444444444444444444444444");
											}
										//}
									}
										anhoBus="2008";
										osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
										if(osc==null){
											
										logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
											
										}
											if(osc!=null){
												for(int i=0; i<osc.size(); i++)
												{
													beanTPlanes=(TPlanes)osc.elementAt(i);
													
													codigoOficina=beanTPlanes.getCodigoOficina();
													mes=beanTPlanes.getMes();
													anho=beanTPlanes.getAnho();
													codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
													nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
													pesodor=beanTPlanes.getPesodor();
													monto=beanTPlanes.getMonto();
													porcAlcanzado=beanTPlanes.getPorcAlcanzado();
													desvpPto=beanTPlanes.getDesvpPto();
													nroMesesFalt=beanTPlanes.getNroMesesFalt();
													proyCrecMensual=beanTPlanes.getProyCrecMensual();
													ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
													proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
													saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
													porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
													saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
													saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
													codigoTerritorio=beanTPlanes.getCodigoTerritorio();
													porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
													factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
													historicoBajas=beanTPlanes.getHistoricoBajas();
													metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
													metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
													prioridadPlanes=beanTPlanes.getPrioridad();
													mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
													indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
													varMes=beanTPlanes.getVarMes();
													ajustePspto=beanTPlanes.getAjustePspto();
													desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
													factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
													factAsignGteOf=beanTPlanes.getFactAsignGteOf();
													
													indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
															codigoEpigrafe, nombreEpigrafe, pesodor, monto,
															porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
															ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
															porcSaldoMedioJunio, saldoDiciembreAnterior,
															saldoMedioDiciembre, codigoTerritorio,
															porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
															historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
															prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
															ajustePspto, desvPsptoAjustado, factAjustTerritorial,
															factAsignGteOf);
													logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 4444444444444444444444444444444");
												}
											//}
										}
											anhoBus="2009";
											osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
											if(osc==null){
												
											logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
												
											}
												if(osc!=null){
													for(int i=0; i<osc.size(); i++)
													{
														beanTPlanes=(TPlanes)osc.elementAt(i);
														
														codigoOficina=beanTPlanes.getCodigoOficina();
														mes=beanTPlanes.getMes();
														anho=beanTPlanes.getAnho();
														codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
														nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
														pesodor=beanTPlanes.getPesodor();
														monto=beanTPlanes.getMonto();
														porcAlcanzado=beanTPlanes.getPorcAlcanzado();
														desvpPto=beanTPlanes.getDesvpPto();
														nroMesesFalt=beanTPlanes.getNroMesesFalt();
														proyCrecMensual=beanTPlanes.getProyCrecMensual();
														ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
														proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
														saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
														porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
														saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
														saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
														codigoTerritorio=beanTPlanes.getCodigoTerritorio();
														porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
														factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
														historicoBajas=beanTPlanes.getHistoricoBajas();
														metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
														metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
														prioridadPlanes=beanTPlanes.getPrioridad();
														mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
														indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
														varMes=beanTPlanes.getVarMes();
														ajustePspto=beanTPlanes.getAjustePspto();
														desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
														factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
														factAsignGteOf=beanTPlanes.getFactAsignGteOf();
														
														indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																porcSaldoMedioJunio, saldoDiciembreAnterior,
																saldoMedioDiciembre, codigoTerritorio,
																porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																factAsignGteOf);
														logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 4444444444444444444444444444444");
													}
												//}
											}
							
		}
		public void migracion5Planes5 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			
			TPlanes beanTPlanes=null;			

		/*PLANES*/

		String codigoOficina;
		String mes;
		String anho;
		String codigoEpigrafe;
		String nombreEpigrafe;
		int pesodor;
		int monto;
		int porcAlcanzado;
		int desvpPto;
		int nroMesesFalt;
		int proyCrecMensual;
		int ajusteEstimadoTerr;
		int proyAjusteMensual;
		int saldoMedioJunio;
		int porcSaldoMedioJunio;
		int saldoDiciembreAnterior;
		int saldoMedioDiciembre;
		String codigoTerritorio;
		int porcSaldoMedioDiciembre;
		int factorAjusteSaldoPuntual;
		int historicoBajas;
		int metaMesSaldoPuntual;
		int metaGerenteOficina;
		int prioridadPlanes;
		String mesEvaluacion;
		String indicadorDor;
		int varMes;
		int ajustePspto;
		int desvPsptoAjustado;
		int factAjustTerritorial;
		int factAsignGteOf;
		int contMes=0;
		String sMensaje;
		String contadorMes="05";
		int indicador=0;
		int contador=0;
		Vector osc=null;
		String anhoBus="";
		
		/*for(contMes=1;contMes<3;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}*/
		anhoBus="2005";
		osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanTPlanes=(TPlanes)osc.elementAt(i);
					
					codigoOficina=beanTPlanes.getCodigoOficina();
					mes=beanTPlanes.getMes();
					anho=beanTPlanes.getAnho();
					codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
					nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
					pesodor=beanTPlanes.getPesodor();
					monto=beanTPlanes.getMonto();
					porcAlcanzado=beanTPlanes.getPorcAlcanzado();
					desvpPto=beanTPlanes.getDesvpPto();
					nroMesesFalt=beanTPlanes.getNroMesesFalt();
					proyCrecMensual=beanTPlanes.getProyCrecMensual();
					ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
					proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
					saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
					porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
					saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
					saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
					codigoTerritorio=beanTPlanes.getCodigoTerritorio();
					porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
					factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
					historicoBajas=beanTPlanes.getHistoricoBajas();
					metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
					metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
					prioridadPlanes=beanTPlanes.getPrioridad();
					mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
					indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
					varMes=beanTPlanes.getVarMes();
					ajustePspto=beanTPlanes.getAjustePspto();
					desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
					factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
					factAsignGteOf=beanTPlanes.getFactAsignGteOf();
					
					indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
							codigoEpigrafe, nombreEpigrafe, pesodor, monto,
							porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
							ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
							porcSaldoMedioJunio, saldoDiciembreAnterior,
							saldoMedioDiciembre, codigoTerritorio,
							porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
							historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
							prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
							factAsignGteOf);
					logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 55555555555555555555555555555");
				}
			//}
		}
			anhoBus="2006";
			osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
				if(osc!=null){
					for(int i=0; i<osc.size(); i++)
					{
						beanTPlanes=(TPlanes)osc.elementAt(i);
						
						codigoOficina=beanTPlanes.getCodigoOficina();
						mes=beanTPlanes.getMes();
						anho=beanTPlanes.getAnho();
						codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
						nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
						pesodor=beanTPlanes.getPesodor();
						monto=beanTPlanes.getMonto();
						porcAlcanzado=beanTPlanes.getPorcAlcanzado();
						desvpPto=beanTPlanes.getDesvpPto();
						nroMesesFalt=beanTPlanes.getNroMesesFalt();
						proyCrecMensual=beanTPlanes.getProyCrecMensual();
						ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
						proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
						saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
						porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
						saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
						saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
						codigoTerritorio=beanTPlanes.getCodigoTerritorio();
						porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
						factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
						historicoBajas=beanTPlanes.getHistoricoBajas();
						metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
						metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
						prioridadPlanes=beanTPlanes.getPrioridad();
						mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
						indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
						varMes=beanTPlanes.getVarMes();
						ajustePspto=beanTPlanes.getAjustePspto();
						desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
						factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
						factAsignGteOf=beanTPlanes.getFactAsignGteOf();
						
						indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
								codigoEpigrafe, nombreEpigrafe, pesodor, monto,
								porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
								ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
								porcSaldoMedioJunio, saldoDiciembreAnterior,
								saldoMedioDiciembre, codigoTerritorio,
								porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
								historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
								prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
								ajustePspto, desvPsptoAjustado, factAjustTerritorial,
								factAsignGteOf);
						logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 55555555555555555555555555555");
					}
				//}
			}
				anhoBus="2007";
				osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
				if(osc==null){
					
				logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
					
				}
					if(osc!=null){
						for(int i=0; i<osc.size(); i++)
						{
							beanTPlanes=(TPlanes)osc.elementAt(i);
							
							codigoOficina=beanTPlanes.getCodigoOficina();
							mes=beanTPlanes.getMes();
							anho=beanTPlanes.getAnho();
							codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
							nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
							pesodor=beanTPlanes.getPesodor();
							monto=beanTPlanes.getMonto();
							porcAlcanzado=beanTPlanes.getPorcAlcanzado();
							desvpPto=beanTPlanes.getDesvpPto();
							nroMesesFalt=beanTPlanes.getNroMesesFalt();
							proyCrecMensual=beanTPlanes.getProyCrecMensual();
							ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
							proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
							saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
							porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
							saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
							saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
							codigoTerritorio=beanTPlanes.getCodigoTerritorio();
							porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
							factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
							historicoBajas=beanTPlanes.getHistoricoBajas();
							metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
							metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
							prioridadPlanes=beanTPlanes.getPrioridad();
							mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
							indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
							varMes=beanTPlanes.getVarMes();
							ajustePspto=beanTPlanes.getAjustePspto();
							desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
							factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
							factAsignGteOf=beanTPlanes.getFactAsignGteOf();
							
							indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
									codigoEpigrafe, nombreEpigrafe, pesodor, monto,
									porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
									ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
									porcSaldoMedioJunio, saldoDiciembreAnterior,
									saldoMedioDiciembre, codigoTerritorio,
									porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
									historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
									prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
									ajustePspto, desvPsptoAjustado, factAjustTerritorial,
									factAsignGteOf);
							logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 55555555555555555555555555555");
						}
					//}
				}
					anhoBus="2008";
					osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
					if(osc==null){
						
					logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
						
					}
						if(osc!=null){
							for(int i=0; i<osc.size(); i++)
							{
								beanTPlanes=(TPlanes)osc.elementAt(i);
								
								codigoOficina=beanTPlanes.getCodigoOficina();
								mes=beanTPlanes.getMes();
								anho=beanTPlanes.getAnho();
								codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
								nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
								pesodor=beanTPlanes.getPesodor();
								monto=beanTPlanes.getMonto();
								porcAlcanzado=beanTPlanes.getPorcAlcanzado();
								desvpPto=beanTPlanes.getDesvpPto();
								nroMesesFalt=beanTPlanes.getNroMesesFalt();
								proyCrecMensual=beanTPlanes.getProyCrecMensual();
								ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
								proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
								saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
								porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
								saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
								saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
								codigoTerritorio=beanTPlanes.getCodigoTerritorio();
								porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
								factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
								historicoBajas=beanTPlanes.getHistoricoBajas();
								metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
								metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
								prioridadPlanes=beanTPlanes.getPrioridad();
								mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
								indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
								varMes=beanTPlanes.getVarMes();
								ajustePspto=beanTPlanes.getAjustePspto();
								desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
								factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
								factAsignGteOf=beanTPlanes.getFactAsignGteOf();
								
								indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
										codigoEpigrafe, nombreEpigrafe, pesodor, monto,
										porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
										ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
										porcSaldoMedioJunio, saldoDiciembreAnterior,
										saldoMedioDiciembre, codigoTerritorio,
										porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
										historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
										prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
										ajustePspto, desvPsptoAjustado, factAjustTerritorial,
										factAsignGteOf);
								logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 55555555555555555555555555555");
							}
						//}
					}
						anhoBus="2009";
						osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
						if(osc==null){
							
						logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
							
						}
							if(osc!=null){
								for(int i=0; i<osc.size(); i++)
								{
									beanTPlanes=(TPlanes)osc.elementAt(i);
									
									codigoOficina=beanTPlanes.getCodigoOficina();
									mes=beanTPlanes.getMes();
									anho=beanTPlanes.getAnho();
									codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
									nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
									pesodor=beanTPlanes.getPesodor();
									monto=beanTPlanes.getMonto();
									porcAlcanzado=beanTPlanes.getPorcAlcanzado();
									desvpPto=beanTPlanes.getDesvpPto();
									nroMesesFalt=beanTPlanes.getNroMesesFalt();
									proyCrecMensual=beanTPlanes.getProyCrecMensual();
									ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
									proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
									saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
									porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
									saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
									saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
									codigoTerritorio=beanTPlanes.getCodigoTerritorio();
									porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
									factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
									historicoBajas=beanTPlanes.getHistoricoBajas();
									metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
									metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
									prioridadPlanes=beanTPlanes.getPrioridad();
									mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
									indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
									varMes=beanTPlanes.getVarMes();
									ajustePspto=beanTPlanes.getAjustePspto();
									desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
									factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
									factAsignGteOf=beanTPlanes.getFactAsignGteOf();
									
									indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
											codigoEpigrafe, nombreEpigrafe, pesodor, monto,
											porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
											ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
											porcSaldoMedioJunio, saldoDiciembreAnterior,
											saldoMedioDiciembre, codigoTerritorio,
											porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
											historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
											prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
											ajustePspto, desvPsptoAjustado, factAjustTerritorial,
											factAsignGteOf);
									logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 55555555555555555555555555555");
								}
							//}
						}
							/* SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 */
							
							anhoBus="2005";
							osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
							if(osc==null){
								
							logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
								
							}
								if(osc!=null){
									for(int i=0; i<osc.size(); i++)
									{
										beanTPlanes=(TPlanes)osc.elementAt(i);
										
										codigoOficina=beanTPlanes.getCodigoOficina();
										mes=beanTPlanes.getMes();
										anho=beanTPlanes.getAnho();
										codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
										nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
										pesodor=beanTPlanes.getPesodor();
										monto=beanTPlanes.getMonto();
										porcAlcanzado=beanTPlanes.getPorcAlcanzado();
										desvpPto=beanTPlanes.getDesvpPto();
										nroMesesFalt=beanTPlanes.getNroMesesFalt();
										proyCrecMensual=beanTPlanes.getProyCrecMensual();
										ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
										proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
										saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
										porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
										saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
										saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
										codigoTerritorio=beanTPlanes.getCodigoTerritorio();
										porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
										factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
										historicoBajas=beanTPlanes.getHistoricoBajas();
										metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
										metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
										prioridadPlanes=beanTPlanes.getPrioridad();
										mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
										indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
										varMes=beanTPlanes.getVarMes();
										ajustePspto=beanTPlanes.getAjustePspto();
										desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
										factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
										factAsignGteOf=beanTPlanes.getFactAsignGteOf();
										
										indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
												codigoEpigrafe, nombreEpigrafe, pesodor, monto,
												porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
												ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
												porcSaldoMedioJunio, saldoDiciembreAnterior,
												saldoMedioDiciembre, codigoTerritorio,
												porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
												historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
												prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
												ajustePspto, desvPsptoAjustado, factAjustTerritorial,
												factAsignGteOf);
										logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 55555555555555555555555555555");
									}
								//}
							}
								anhoBus="2006";
								osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
								if(osc==null){
									
								logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
									
								}
									if(osc!=null){
										for(int i=0; i<osc.size(); i++)
										{
											beanTPlanes=(TPlanes)osc.elementAt(i);
											
											codigoOficina=beanTPlanes.getCodigoOficina();
											mes=beanTPlanes.getMes();
											anho=beanTPlanes.getAnho();
											codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
											nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
											pesodor=beanTPlanes.getPesodor();
											monto=beanTPlanes.getMonto();
											porcAlcanzado=beanTPlanes.getPorcAlcanzado();
											desvpPto=beanTPlanes.getDesvpPto();
											nroMesesFalt=beanTPlanes.getNroMesesFalt();
											proyCrecMensual=beanTPlanes.getProyCrecMensual();
											ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
											proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
											saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
											porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
											saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
											saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
											codigoTerritorio=beanTPlanes.getCodigoTerritorio();
											porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
											factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
											historicoBajas=beanTPlanes.getHistoricoBajas();
											metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
											metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
											prioridadPlanes=beanTPlanes.getPrioridad();
											mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
											indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
											varMes=beanTPlanes.getVarMes();
											ajustePspto=beanTPlanes.getAjustePspto();
											desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
											factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
											factAsignGteOf=beanTPlanes.getFactAsignGteOf();
											
											indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
													codigoEpigrafe, nombreEpigrafe, pesodor, monto,
													porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
													ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
													porcSaldoMedioJunio, saldoDiciembreAnterior,
													saldoMedioDiciembre, codigoTerritorio,
													porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
													historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
													prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
													ajustePspto, desvPsptoAjustado, factAjustTerritorial,
													factAsignGteOf);
											logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 55555555555555555555555555555");
										}
									//}
								}
									anhoBus="2007";
									osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
									if(osc==null){
										
									logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
										
									}
										if(osc!=null){
											for(int i=0; i<osc.size(); i++)
											{
												beanTPlanes=(TPlanes)osc.elementAt(i);
												
												codigoOficina=beanTPlanes.getCodigoOficina();
												mes=beanTPlanes.getMes();
												anho=beanTPlanes.getAnho();
												codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
												nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
												pesodor=beanTPlanes.getPesodor();
												monto=beanTPlanes.getMonto();
												porcAlcanzado=beanTPlanes.getPorcAlcanzado();
												desvpPto=beanTPlanes.getDesvpPto();
												nroMesesFalt=beanTPlanes.getNroMesesFalt();
												proyCrecMensual=beanTPlanes.getProyCrecMensual();
												ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
												proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
												saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
												porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
												saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
												saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
												codigoTerritorio=beanTPlanes.getCodigoTerritorio();
												porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
												factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
												historicoBajas=beanTPlanes.getHistoricoBajas();
												metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
												metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
												prioridadPlanes=beanTPlanes.getPrioridad();
												mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
												indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
												varMes=beanTPlanes.getVarMes();
												ajustePspto=beanTPlanes.getAjustePspto();
												desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
												factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
												factAsignGteOf=beanTPlanes.getFactAsignGteOf();
												
												indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
														codigoEpigrafe, nombreEpigrafe, pesodor, monto,
														porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
														ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
														porcSaldoMedioJunio, saldoDiciembreAnterior,
														saldoMedioDiciembre, codigoTerritorio,
														porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
														historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
														prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
														ajustePspto, desvPsptoAjustado, factAjustTerritorial,
														factAsignGteOf);
												logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 55555555555555555555555555555");
											}
										//}
									}
										anhoBus="2008";
										osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
										if(osc==null){
											
										logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
											
										}
											if(osc!=null){
												for(int i=0; i<osc.size(); i++)
												{
													beanTPlanes=(TPlanes)osc.elementAt(i);
													
													codigoOficina=beanTPlanes.getCodigoOficina();
													mes=beanTPlanes.getMes();
													anho=beanTPlanes.getAnho();
													codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
													nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
													pesodor=beanTPlanes.getPesodor();
													monto=beanTPlanes.getMonto();
													porcAlcanzado=beanTPlanes.getPorcAlcanzado();
													desvpPto=beanTPlanes.getDesvpPto();
													nroMesesFalt=beanTPlanes.getNroMesesFalt();
													proyCrecMensual=beanTPlanes.getProyCrecMensual();
													ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
													proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
													saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
													porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
													saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
													saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
													codigoTerritorio=beanTPlanes.getCodigoTerritorio();
													porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
													factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
													historicoBajas=beanTPlanes.getHistoricoBajas();
													metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
													metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
													prioridadPlanes=beanTPlanes.getPrioridad();
													mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
													indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
													varMes=beanTPlanes.getVarMes();
													ajustePspto=beanTPlanes.getAjustePspto();
													desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
													factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
													factAsignGteOf=beanTPlanes.getFactAsignGteOf();
													
													indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
															codigoEpigrafe, nombreEpigrafe, pesodor, monto,
															porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
															ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
															porcSaldoMedioJunio, saldoDiciembreAnterior,
															saldoMedioDiciembre, codigoTerritorio,
															porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
															historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
															prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
															ajustePspto, desvPsptoAjustado, factAjustTerritorial,
															factAsignGteOf);
													logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 55555555555555555555555555555");
												}
											//}
										}
											anhoBus="2009";
											osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
											if(osc==null){
												
											logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
												
											}
												if(osc!=null){
													for(int i=0; i<osc.size(); i++)
													{
														beanTPlanes=(TPlanes)osc.elementAt(i);
														
														codigoOficina=beanTPlanes.getCodigoOficina();
														mes=beanTPlanes.getMes();
														anho=beanTPlanes.getAnho();
														codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
														nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
														pesodor=beanTPlanes.getPesodor();
														monto=beanTPlanes.getMonto();
														porcAlcanzado=beanTPlanes.getPorcAlcanzado();
														desvpPto=beanTPlanes.getDesvpPto();
														nroMesesFalt=beanTPlanes.getNroMesesFalt();
														proyCrecMensual=beanTPlanes.getProyCrecMensual();
														ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
														proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
														saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
														porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
														saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
														saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
														codigoTerritorio=beanTPlanes.getCodigoTerritorio();
														porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
														factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
														historicoBajas=beanTPlanes.getHistoricoBajas();
														metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
														metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
														prioridadPlanes=beanTPlanes.getPrioridad();
														mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
														indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
														varMes=beanTPlanes.getVarMes();
														ajustePspto=beanTPlanes.getAjustePspto();
														desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
														factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
														factAsignGteOf=beanTPlanes.getFactAsignGteOf();
														
														indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																porcSaldoMedioJunio, saldoDiciembreAnterior,
																saldoMedioDiciembre, codigoTerritorio,
																porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																factAsignGteOf);
														logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 55555555555555555555555555555");
													}
												//}
											}
	}
		public void migracion5Planes6 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			
			TPlanes beanTPlanes=null;			

		/*PLANES*/

		String codigoOficina;
		String mes;
		String anho;
		String codigoEpigrafe;
		String nombreEpigrafe;
		int pesodor;
		int monto;
		int porcAlcanzado;
		int desvpPto;
		int nroMesesFalt;
		int proyCrecMensual;
		int ajusteEstimadoTerr;
		int proyAjusteMensual;
		int saldoMedioJunio;
		int porcSaldoMedioJunio;
		int saldoDiciembreAnterior;
		int saldoMedioDiciembre;
		String codigoTerritorio;
		int porcSaldoMedioDiciembre;
		int factorAjusteSaldoPuntual;
		int historicoBajas;
		int metaMesSaldoPuntual;
		int metaGerenteOficina;
		int prioridadPlanes;
		String mesEvaluacion;
		String indicadorDor;
		int varMes;
		int ajustePspto;
		int desvPsptoAjustado;
		int factAjustTerritorial;
		int factAsignGteOf;
		int contMes=0;
		String sMensaje;
		String contadorMes="06";
		int indicador=0;
		int contador=0;
		Vector osc=null;
		String anhoBus="";
		
		/*for(contMes=1;contMes<3;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}*/
		anhoBus="2005";
		osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanTPlanes=(TPlanes)osc.elementAt(i);
					
					codigoOficina=beanTPlanes.getCodigoOficina();
					mes=beanTPlanes.getMes();
					anho=beanTPlanes.getAnho();
					codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
					nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
					pesodor=beanTPlanes.getPesodor();
					monto=beanTPlanes.getMonto();
					porcAlcanzado=beanTPlanes.getPorcAlcanzado();
					desvpPto=beanTPlanes.getDesvpPto();
					nroMesesFalt=beanTPlanes.getNroMesesFalt();
					proyCrecMensual=beanTPlanes.getProyCrecMensual();
					ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
					proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
					saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
					porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
					saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
					saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
					codigoTerritorio=beanTPlanes.getCodigoTerritorio();
					porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
					factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
					historicoBajas=beanTPlanes.getHistoricoBajas();
					metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
					metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
					prioridadPlanes=beanTPlanes.getPrioridad();
					mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
					indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
					varMes=beanTPlanes.getVarMes();
					ajustePspto=beanTPlanes.getAjustePspto();
					desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
					factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
					factAsignGteOf=beanTPlanes.getFactAsignGteOf();
					
					indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
							codigoEpigrafe, nombreEpigrafe, pesodor, monto,
							porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
							ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
							porcSaldoMedioJunio, saldoDiciembreAnterior,
							saldoMedioDiciembre, codigoTerritorio,
							porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
							historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
							prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
							factAsignGteOf);
					logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 666666666666666666666666666666666666666");
				}
			//}
		}
			anhoBus="2006";
			osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
				if(osc!=null){
					for(int i=0; i<osc.size(); i++)
					{
						beanTPlanes=(TPlanes)osc.elementAt(i);
						
						codigoOficina=beanTPlanes.getCodigoOficina();
						mes=beanTPlanes.getMes();
						anho=beanTPlanes.getAnho();
						codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
						nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
						pesodor=beanTPlanes.getPesodor();
						monto=beanTPlanes.getMonto();
						porcAlcanzado=beanTPlanes.getPorcAlcanzado();
						desvpPto=beanTPlanes.getDesvpPto();
						nroMesesFalt=beanTPlanes.getNroMesesFalt();
						proyCrecMensual=beanTPlanes.getProyCrecMensual();
						ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
						proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
						saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
						porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
						saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
						saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
						codigoTerritorio=beanTPlanes.getCodigoTerritorio();
						porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
						factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
						historicoBajas=beanTPlanes.getHistoricoBajas();
						metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
						metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
						prioridadPlanes=beanTPlanes.getPrioridad();
						mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
						indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
						varMes=beanTPlanes.getVarMes();
						ajustePspto=beanTPlanes.getAjustePspto();
						desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
						factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
						factAsignGteOf=beanTPlanes.getFactAsignGteOf();
						
						indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
								codigoEpigrafe, nombreEpigrafe, pesodor, monto,
								porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
								ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
								porcSaldoMedioJunio, saldoDiciembreAnterior,
								saldoMedioDiciembre, codigoTerritorio,
								porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
								historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
								prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
								ajustePspto, desvPsptoAjustado, factAjustTerritorial,
								factAsignGteOf);
						logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 666666666666666666666666666666666666666");
					}
				//}
			}
				anhoBus="2007";
				osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
				if(osc==null){
					
				logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
					
				}
					if(osc!=null){
						for(int i=0; i<osc.size(); i++)
						{
							beanTPlanes=(TPlanes)osc.elementAt(i);
							
							codigoOficina=beanTPlanes.getCodigoOficina();
							mes=beanTPlanes.getMes();
							anho=beanTPlanes.getAnho();
							codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
							nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
							pesodor=beanTPlanes.getPesodor();
							monto=beanTPlanes.getMonto();
							porcAlcanzado=beanTPlanes.getPorcAlcanzado();
							desvpPto=beanTPlanes.getDesvpPto();
							nroMesesFalt=beanTPlanes.getNroMesesFalt();
							proyCrecMensual=beanTPlanes.getProyCrecMensual();
							ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
							proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
							saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
							porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
							saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
							saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
							codigoTerritorio=beanTPlanes.getCodigoTerritorio();
							porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
							factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
							historicoBajas=beanTPlanes.getHistoricoBajas();
							metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
							metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
							prioridadPlanes=beanTPlanes.getPrioridad();
							mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
							indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
							varMes=beanTPlanes.getVarMes();
							ajustePspto=beanTPlanes.getAjustePspto();
							desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
							factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
							factAsignGteOf=beanTPlanes.getFactAsignGteOf();
							
							indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
									codigoEpigrafe, nombreEpigrafe, pesodor, monto,
									porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
									ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
									porcSaldoMedioJunio, saldoDiciembreAnterior,
									saldoMedioDiciembre, codigoTerritorio,
									porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
									historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
									prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
									ajustePspto, desvPsptoAjustado, factAjustTerritorial,
									factAsignGteOf);
							logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 666666666666666666666666666666666666666");
						}
					//}
				}
					anhoBus="2008";
					osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
					if(osc==null){
						
					logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
						
					}
						if(osc!=null){
							for(int i=0; i<osc.size(); i++)
							{
								beanTPlanes=(TPlanes)osc.elementAt(i);
								
								codigoOficina=beanTPlanes.getCodigoOficina();
								mes=beanTPlanes.getMes();
								anho=beanTPlanes.getAnho();
								codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
								nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
								pesodor=beanTPlanes.getPesodor();
								monto=beanTPlanes.getMonto();
								porcAlcanzado=beanTPlanes.getPorcAlcanzado();
								desvpPto=beanTPlanes.getDesvpPto();
								nroMesesFalt=beanTPlanes.getNroMesesFalt();
								proyCrecMensual=beanTPlanes.getProyCrecMensual();
								ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
								proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
								saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
								porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
								saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
								saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
								codigoTerritorio=beanTPlanes.getCodigoTerritorio();
								porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
								factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
								historicoBajas=beanTPlanes.getHistoricoBajas();
								metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
								metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
								prioridadPlanes=beanTPlanes.getPrioridad();
								mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
								indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
								varMes=beanTPlanes.getVarMes();
								ajustePspto=beanTPlanes.getAjustePspto();
								desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
								factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
								factAsignGteOf=beanTPlanes.getFactAsignGteOf();
								
								indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
										codigoEpigrafe, nombreEpigrafe, pesodor, monto,
										porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
										ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
										porcSaldoMedioJunio, saldoDiciembreAnterior,
										saldoMedioDiciembre, codigoTerritorio,
										porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
										historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
										prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
										ajustePspto, desvPsptoAjustado, factAjustTerritorial,
										factAsignGteOf);
								logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 666666666666666666666666666666666666666");
							}
						//}
					}
						anhoBus="2009";
						osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
						if(osc==null){
							
						logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
							
						}
							if(osc!=null){
								for(int i=0; i<osc.size(); i++)
								{
									beanTPlanes=(TPlanes)osc.elementAt(i);
									
									codigoOficina=beanTPlanes.getCodigoOficina();
									mes=beanTPlanes.getMes();
									anho=beanTPlanes.getAnho();
									codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
									nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
									pesodor=beanTPlanes.getPesodor();
									monto=beanTPlanes.getMonto();
									porcAlcanzado=beanTPlanes.getPorcAlcanzado();
									desvpPto=beanTPlanes.getDesvpPto();
									nroMesesFalt=beanTPlanes.getNroMesesFalt();
									proyCrecMensual=beanTPlanes.getProyCrecMensual();
									ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
									proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
									saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
									porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
									saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
									saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
									codigoTerritorio=beanTPlanes.getCodigoTerritorio();
									porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
									factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
									historicoBajas=beanTPlanes.getHistoricoBajas();
									metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
									metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
									prioridadPlanes=beanTPlanes.getPrioridad();
									mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
									indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
									varMes=beanTPlanes.getVarMes();
									ajustePspto=beanTPlanes.getAjustePspto();
									desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
									factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
									factAsignGteOf=beanTPlanes.getFactAsignGteOf();
									
									indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
											codigoEpigrafe, nombreEpigrafe, pesodor, monto,
											porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
											ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
											porcSaldoMedioJunio, saldoDiciembreAnterior,
											saldoMedioDiciembre, codigoTerritorio,
											porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
											historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
											prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
											ajustePspto, desvPsptoAjustado, factAjustTerritorial,
											factAsignGteOf);
									logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 666666666666666666666666666666666666666");
								}
							//}
						}
							/* SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 */
							
							anhoBus="2005";
							osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
							if(osc==null){
								
							logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
								
							}
								if(osc!=null){
									for(int i=0; i<osc.size(); i++)
									{
										beanTPlanes=(TPlanes)osc.elementAt(i);
										
										codigoOficina=beanTPlanes.getCodigoOficina();
										mes=beanTPlanes.getMes();
										anho=beanTPlanes.getAnho();
										codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
										nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
										pesodor=beanTPlanes.getPesodor();
										monto=beanTPlanes.getMonto();
										porcAlcanzado=beanTPlanes.getPorcAlcanzado();
										desvpPto=beanTPlanes.getDesvpPto();
										nroMesesFalt=beanTPlanes.getNroMesesFalt();
										proyCrecMensual=beanTPlanes.getProyCrecMensual();
										ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
										proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
										saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
										porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
										saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
										saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
										codigoTerritorio=beanTPlanes.getCodigoTerritorio();
										porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
										factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
										historicoBajas=beanTPlanes.getHistoricoBajas();
										metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
										metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
										prioridadPlanes=beanTPlanes.getPrioridad();
										mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
										indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
										varMes=beanTPlanes.getVarMes();
										ajustePspto=beanTPlanes.getAjustePspto();
										desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
										factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
										factAsignGteOf=beanTPlanes.getFactAsignGteOf();
										
										indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
												codigoEpigrafe, nombreEpigrafe, pesodor, monto,
												porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
												ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
												porcSaldoMedioJunio, saldoDiciembreAnterior,
												saldoMedioDiciembre, codigoTerritorio,
												porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
												historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
												prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
												ajustePspto, desvPsptoAjustado, factAjustTerritorial,
												factAsignGteOf);
										logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 666666666666666666666666666666666666666");
									}
								//}
							}
								anhoBus="2006";
								osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
								if(osc==null){
									
								logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
									
								}
									if(osc!=null){
										for(int i=0; i<osc.size(); i++)
										{
											beanTPlanes=(TPlanes)osc.elementAt(i);
											
											codigoOficina=beanTPlanes.getCodigoOficina();
											mes=beanTPlanes.getMes();
											anho=beanTPlanes.getAnho();
											codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
											nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
											pesodor=beanTPlanes.getPesodor();
											monto=beanTPlanes.getMonto();
											porcAlcanzado=beanTPlanes.getPorcAlcanzado();
											desvpPto=beanTPlanes.getDesvpPto();
											nroMesesFalt=beanTPlanes.getNroMesesFalt();
											proyCrecMensual=beanTPlanes.getProyCrecMensual();
											ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
											proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
											saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
											porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
											saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
											saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
											codigoTerritorio=beanTPlanes.getCodigoTerritorio();
											porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
											factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
											historicoBajas=beanTPlanes.getHistoricoBajas();
											metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
											metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
											prioridadPlanes=beanTPlanes.getPrioridad();
											mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
											indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
											varMes=beanTPlanes.getVarMes();
											ajustePspto=beanTPlanes.getAjustePspto();
											desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
											factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
											factAsignGteOf=beanTPlanes.getFactAsignGteOf();
											
											indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
													codigoEpigrafe, nombreEpigrafe, pesodor, monto,
													porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
													ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
													porcSaldoMedioJunio, saldoDiciembreAnterior,
													saldoMedioDiciembre, codigoTerritorio,
													porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
													historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
													prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
													ajustePspto, desvPsptoAjustado, factAjustTerritorial,
													factAsignGteOf);
											logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 666666666666666666666666666666666666666");
										}
									//}
								}
									anhoBus="2007";
									osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
									if(osc==null){
										
									logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
										
									}
										if(osc!=null){
											for(int i=0; i<osc.size(); i++)
											{
												beanTPlanes=(TPlanes)osc.elementAt(i);
												
												codigoOficina=beanTPlanes.getCodigoOficina();
												mes=beanTPlanes.getMes();
												anho=beanTPlanes.getAnho();
												codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
												nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
												pesodor=beanTPlanes.getPesodor();
												monto=beanTPlanes.getMonto();
												porcAlcanzado=beanTPlanes.getPorcAlcanzado();
												desvpPto=beanTPlanes.getDesvpPto();
												nroMesesFalt=beanTPlanes.getNroMesesFalt();
												proyCrecMensual=beanTPlanes.getProyCrecMensual();
												ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
												proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
												saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
												porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
												saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
												saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
												codigoTerritorio=beanTPlanes.getCodigoTerritorio();
												porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
												factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
												historicoBajas=beanTPlanes.getHistoricoBajas();
												metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
												metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
												prioridadPlanes=beanTPlanes.getPrioridad();
												mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
												indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
												varMes=beanTPlanes.getVarMes();
												ajustePspto=beanTPlanes.getAjustePspto();
												desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
												factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
												factAsignGteOf=beanTPlanes.getFactAsignGteOf();
												
												indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
														codigoEpigrafe, nombreEpigrafe, pesodor, monto,
														porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
														ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
														porcSaldoMedioJunio, saldoDiciembreAnterior,
														saldoMedioDiciembre, codigoTerritorio,
														porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
														historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
														prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
														ajustePspto, desvPsptoAjustado, factAjustTerritorial,
														factAsignGteOf);
												logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 666666666666666666666666666666666666666");
											}
										//}
									}
										anhoBus="2008";
										osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
										if(osc==null){
											
										logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
											
										}
											if(osc!=null){
												for(int i=0; i<osc.size(); i++)
												{
													beanTPlanes=(TPlanes)osc.elementAt(i);
													
													codigoOficina=beanTPlanes.getCodigoOficina();
													mes=beanTPlanes.getMes();
													anho=beanTPlanes.getAnho();
													codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
													nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
													pesodor=beanTPlanes.getPesodor();
													monto=beanTPlanes.getMonto();
													porcAlcanzado=beanTPlanes.getPorcAlcanzado();
													desvpPto=beanTPlanes.getDesvpPto();
													nroMesesFalt=beanTPlanes.getNroMesesFalt();
													proyCrecMensual=beanTPlanes.getProyCrecMensual();
													ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
													proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
													saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
													porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
													saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
													saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
													codigoTerritorio=beanTPlanes.getCodigoTerritorio();
													porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
													factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
													historicoBajas=beanTPlanes.getHistoricoBajas();
													metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
													metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
													prioridadPlanes=beanTPlanes.getPrioridad();
													mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
													indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
													varMes=beanTPlanes.getVarMes();
													ajustePspto=beanTPlanes.getAjustePspto();
													desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
													factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
													factAsignGteOf=beanTPlanes.getFactAsignGteOf();
													
													indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
															codigoEpigrafe, nombreEpigrafe, pesodor, monto,
															porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
															ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
															porcSaldoMedioJunio, saldoDiciembreAnterior,
															saldoMedioDiciembre, codigoTerritorio,
															porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
															historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
															prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
															ajustePspto, desvPsptoAjustado, factAjustTerritorial,
															factAsignGteOf);
													logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 666666666666666666666666666666666666666");
												}
											//}
										}
											anhoBus="2009";
											osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
											if(osc==null){
												
											logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
												
											}
												if(osc!=null){
													for(int i=0; i<osc.size(); i++)
													{
														beanTPlanes=(TPlanes)osc.elementAt(i);
														
														codigoOficina=beanTPlanes.getCodigoOficina();
														mes=beanTPlanes.getMes();
														anho=beanTPlanes.getAnho();
														codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
														nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
														pesodor=beanTPlanes.getPesodor();
														monto=beanTPlanes.getMonto();
														porcAlcanzado=beanTPlanes.getPorcAlcanzado();
														desvpPto=beanTPlanes.getDesvpPto();
														nroMesesFalt=beanTPlanes.getNroMesesFalt();
														proyCrecMensual=beanTPlanes.getProyCrecMensual();
														ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
														proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
														saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
														porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
														saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
														saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
														codigoTerritorio=beanTPlanes.getCodigoTerritorio();
														porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
														factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
														historicoBajas=beanTPlanes.getHistoricoBajas();
														metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
														metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
														prioridadPlanes=beanTPlanes.getPrioridad();
														mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
														indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
														varMes=beanTPlanes.getVarMes();
														ajustePspto=beanTPlanes.getAjustePspto();
														desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
														factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
														factAsignGteOf=beanTPlanes.getFactAsignGteOf();
														
														indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																porcSaldoMedioJunio, saldoDiciembreAnterior,
																saldoMedioDiciembre, codigoTerritorio,
																porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																factAsignGteOf);
														logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 666666666666666666666666666666666666666");
													}
												//}
											}
							
	}
		public void migracion5Planes7 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			
			TPlanes beanTPlanes=null;			

		/*PLANES*/

		String codigoOficina;
		String mes;
		String anho;
		String codigoEpigrafe;
		String nombreEpigrafe;
		int pesodor;
		int monto;
		int porcAlcanzado;
		int desvpPto;
		int nroMesesFalt;
		int proyCrecMensual;
		int ajusteEstimadoTerr;
		int proyAjusteMensual;
		int saldoMedioJunio;
		int porcSaldoMedioJunio;
		int saldoDiciembreAnterior;
		int saldoMedioDiciembre;
		String codigoTerritorio;
		int porcSaldoMedioDiciembre;
		int factorAjusteSaldoPuntual;
		int historicoBajas;
		int metaMesSaldoPuntual;
		int metaGerenteOficina;
		int prioridadPlanes;
		String mesEvaluacion;
		String indicadorDor;
		int varMes;
		int ajustePspto;
		int desvPsptoAjustado;
		int factAjustTerritorial;
		int factAsignGteOf;
		int contMes=0;
		String sMensaje;
		String contadorMes="07";
		int indicador=0;
		int contador=0;
		Vector osc=null;
		String anhoBus="";
		
		/*for(contMes=1;contMes<3;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}*/
		anhoBus="2005";
		osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanTPlanes=(TPlanes)osc.elementAt(i);
					
					codigoOficina=beanTPlanes.getCodigoOficina();
					mes=beanTPlanes.getMes();
					anho=beanTPlanes.getAnho();
					codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
					nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
					pesodor=beanTPlanes.getPesodor();
					monto=beanTPlanes.getMonto();
					porcAlcanzado=beanTPlanes.getPorcAlcanzado();
					desvpPto=beanTPlanes.getDesvpPto();
					nroMesesFalt=beanTPlanes.getNroMesesFalt();
					proyCrecMensual=beanTPlanes.getProyCrecMensual();
					ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
					proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
					saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
					porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
					saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
					saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
					codigoTerritorio=beanTPlanes.getCodigoTerritorio();
					porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
					factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
					historicoBajas=beanTPlanes.getHistoricoBajas();
					metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
					metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
					prioridadPlanes=beanTPlanes.getPrioridad();
					mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
					indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
					varMes=beanTPlanes.getVarMes();
					ajustePspto=beanTPlanes.getAjustePspto();
					desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
					factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
					factAsignGteOf=beanTPlanes.getFactAsignGteOf();
					
					indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
							codigoEpigrafe, nombreEpigrafe, pesodor, monto,
							porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
							ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
							porcSaldoMedioJunio, saldoDiciembreAnterior,
							saldoMedioDiciembre, codigoTerritorio,
							porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
							historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
							prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
							factAsignGteOf);
					logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 7777777777777777777777777777777777777777777777777777");
				}
			//}
		}
			anhoBus="2006";
			osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
				if(osc!=null){
					for(int i=0; i<osc.size(); i++)
					{
						beanTPlanes=(TPlanes)osc.elementAt(i);
						
						codigoOficina=beanTPlanes.getCodigoOficina();
						mes=beanTPlanes.getMes();
						anho=beanTPlanes.getAnho();
						codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
						nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
						pesodor=beanTPlanes.getPesodor();
						monto=beanTPlanes.getMonto();
						porcAlcanzado=beanTPlanes.getPorcAlcanzado();
						desvpPto=beanTPlanes.getDesvpPto();
						nroMesesFalt=beanTPlanes.getNroMesesFalt();
						proyCrecMensual=beanTPlanes.getProyCrecMensual();
						ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
						proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
						saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
						porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
						saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
						saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
						codigoTerritorio=beanTPlanes.getCodigoTerritorio();
						porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
						factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
						historicoBajas=beanTPlanes.getHistoricoBajas();
						metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
						metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
						prioridadPlanes=beanTPlanes.getPrioridad();
						mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
						indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
						varMes=beanTPlanes.getVarMes();
						ajustePspto=beanTPlanes.getAjustePspto();
						desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
						factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
						factAsignGteOf=beanTPlanes.getFactAsignGteOf();
						
						indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
								codigoEpigrafe, nombreEpigrafe, pesodor, monto,
								porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
								ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
								porcSaldoMedioJunio, saldoDiciembreAnterior,
								saldoMedioDiciembre, codigoTerritorio,
								porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
								historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
								prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
								ajustePspto, desvPsptoAjustado, factAjustTerritorial,
								factAsignGteOf);
						logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 7777777777777777777777777777777777777777777777777777");
					}
				//}
			}
				anhoBus="2007";
				osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
				if(osc==null){
					
				logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
					
				}
					if(osc!=null){
						for(int i=0; i<osc.size(); i++)
						{
							beanTPlanes=(TPlanes)osc.elementAt(i);
							
							codigoOficina=beanTPlanes.getCodigoOficina();
							mes=beanTPlanes.getMes();
							anho=beanTPlanes.getAnho();
							codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
							nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
							pesodor=beanTPlanes.getPesodor();
							monto=beanTPlanes.getMonto();
							porcAlcanzado=beanTPlanes.getPorcAlcanzado();
							desvpPto=beanTPlanes.getDesvpPto();
							nroMesesFalt=beanTPlanes.getNroMesesFalt();
							proyCrecMensual=beanTPlanes.getProyCrecMensual();
							ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
							proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
							saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
							porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
							saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
							saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
							codigoTerritorio=beanTPlanes.getCodigoTerritorio();
							porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
							factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
							historicoBajas=beanTPlanes.getHistoricoBajas();
							metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
							metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
							prioridadPlanes=beanTPlanes.getPrioridad();
							mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
							indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
							varMes=beanTPlanes.getVarMes();
							ajustePspto=beanTPlanes.getAjustePspto();
							desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
							factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
							factAsignGteOf=beanTPlanes.getFactAsignGteOf();
							
							indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
									codigoEpigrafe, nombreEpigrafe, pesodor, monto,
									porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
									ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
									porcSaldoMedioJunio, saldoDiciembreAnterior,
									saldoMedioDiciembre, codigoTerritorio,
									porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
									historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
									prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
									ajustePspto, desvPsptoAjustado, factAjustTerritorial,
									factAsignGteOf);
							logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 7777777777777777777777777777777777777777777777777777");
						}
					//}
				}
					anhoBus="2008";
					osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
					if(osc==null){
						
					logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
						
					}
						if(osc!=null){
							for(int i=0; i<osc.size(); i++)
							{
								beanTPlanes=(TPlanes)osc.elementAt(i);
								
								codigoOficina=beanTPlanes.getCodigoOficina();
								mes=beanTPlanes.getMes();
								anho=beanTPlanes.getAnho();
								codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
								nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
								pesodor=beanTPlanes.getPesodor();
								monto=beanTPlanes.getMonto();
								porcAlcanzado=beanTPlanes.getPorcAlcanzado();
								desvpPto=beanTPlanes.getDesvpPto();
								nroMesesFalt=beanTPlanes.getNroMesesFalt();
								proyCrecMensual=beanTPlanes.getProyCrecMensual();
								ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
								proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
								saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
								porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
								saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
								saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
								codigoTerritorio=beanTPlanes.getCodigoTerritorio();
								porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
								factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
								historicoBajas=beanTPlanes.getHistoricoBajas();
								metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
								metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
								prioridadPlanes=beanTPlanes.getPrioridad();
								mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
								indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
								varMes=beanTPlanes.getVarMes();
								ajustePspto=beanTPlanes.getAjustePspto();
								desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
								factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
								factAsignGteOf=beanTPlanes.getFactAsignGteOf();
								
								indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
										codigoEpigrafe, nombreEpigrafe, pesodor, monto,
										porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
										ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
										porcSaldoMedioJunio, saldoDiciembreAnterior,
										saldoMedioDiciembre, codigoTerritorio,
										porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
										historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
										prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
										ajustePspto, desvPsptoAjustado, factAjustTerritorial,
										factAsignGteOf);
								logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 7777777777777777777777777777777777777777777777777777");
							}
						//}
					}
						anhoBus="2009";
						osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
						if(osc==null){
							
						logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
							
						}
							if(osc!=null){
								for(int i=0; i<osc.size(); i++)
								{
									beanTPlanes=(TPlanes)osc.elementAt(i);
									
									codigoOficina=beanTPlanes.getCodigoOficina();
									mes=beanTPlanes.getMes();
									anho=beanTPlanes.getAnho();
									codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
									nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
									pesodor=beanTPlanes.getPesodor();
									monto=beanTPlanes.getMonto();
									porcAlcanzado=beanTPlanes.getPorcAlcanzado();
									desvpPto=beanTPlanes.getDesvpPto();
									nroMesesFalt=beanTPlanes.getNroMesesFalt();
									proyCrecMensual=beanTPlanes.getProyCrecMensual();
									ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
									proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
									saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
									porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
									saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
									saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
									codigoTerritorio=beanTPlanes.getCodigoTerritorio();
									porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
									factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
									historicoBajas=beanTPlanes.getHistoricoBajas();
									metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
									metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
									prioridadPlanes=beanTPlanes.getPrioridad();
									mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
									indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
									varMes=beanTPlanes.getVarMes();
									ajustePspto=beanTPlanes.getAjustePspto();
									desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
									factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
									factAsignGteOf=beanTPlanes.getFactAsignGteOf();
									
									indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
											codigoEpigrafe, nombreEpigrafe, pesodor, monto,
											porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
											ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
											porcSaldoMedioJunio, saldoDiciembreAnterior,
											saldoMedioDiciembre, codigoTerritorio,
											porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
											historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
											prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
											ajustePspto, desvPsptoAjustado, factAjustTerritorial,
											factAsignGteOf);
									logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 7777777777777777777777777777777777777777777777777777");
								}
							//}
						}
							/* SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 */
							anhoBus="2005";
							osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
							if(osc==null){
								
							logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
								
							}
								if(osc!=null){
									for(int i=0; i<osc.size(); i++)
									{
										beanTPlanes=(TPlanes)osc.elementAt(i);
										
										codigoOficina=beanTPlanes.getCodigoOficina();
										mes=beanTPlanes.getMes();
										anho=beanTPlanes.getAnho();
										codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
										nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
										pesodor=beanTPlanes.getPesodor();
										monto=beanTPlanes.getMonto();
										porcAlcanzado=beanTPlanes.getPorcAlcanzado();
										desvpPto=beanTPlanes.getDesvpPto();
										nroMesesFalt=beanTPlanes.getNroMesesFalt();
										proyCrecMensual=beanTPlanes.getProyCrecMensual();
										ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
										proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
										saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
										porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
										saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
										saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
										codigoTerritorio=beanTPlanes.getCodigoTerritorio();
										porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
										factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
										historicoBajas=beanTPlanes.getHistoricoBajas();
										metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
										metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
										prioridadPlanes=beanTPlanes.getPrioridad();
										mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
										indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
										varMes=beanTPlanes.getVarMes();
										ajustePspto=beanTPlanes.getAjustePspto();
										desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
										factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
										factAsignGteOf=beanTPlanes.getFactAsignGteOf();
										
										indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
												codigoEpigrafe, nombreEpigrafe, pesodor, monto,
												porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
												ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
												porcSaldoMedioJunio, saldoDiciembreAnterior,
												saldoMedioDiciembre, codigoTerritorio,
												porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
												historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
												prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
												ajustePspto, desvPsptoAjustado, factAjustTerritorial,
												factAsignGteOf);
										logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 7777777777777777777777777777777777777777777777777777");
									}
								//}
							}
								anhoBus="2006";
								osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
								if(osc==null){
									
								logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
									
								}
									if(osc!=null){
										for(int i=0; i<osc.size(); i++)
										{
											beanTPlanes=(TPlanes)osc.elementAt(i);
											
											codigoOficina=beanTPlanes.getCodigoOficina();
											mes=beanTPlanes.getMes();
											anho=beanTPlanes.getAnho();
											codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
											nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
											pesodor=beanTPlanes.getPesodor();
											monto=beanTPlanes.getMonto();
											porcAlcanzado=beanTPlanes.getPorcAlcanzado();
											desvpPto=beanTPlanes.getDesvpPto();
											nroMesesFalt=beanTPlanes.getNroMesesFalt();
											proyCrecMensual=beanTPlanes.getProyCrecMensual();
											ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
											proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
											saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
											porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
											saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
											saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
											codigoTerritorio=beanTPlanes.getCodigoTerritorio();
											porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
											factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
											historicoBajas=beanTPlanes.getHistoricoBajas();
											metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
											metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
											prioridadPlanes=beanTPlanes.getPrioridad();
											mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
											indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
											varMes=beanTPlanes.getVarMes();
											ajustePspto=beanTPlanes.getAjustePspto();
											desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
											factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
											factAsignGteOf=beanTPlanes.getFactAsignGteOf();
											
											indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
													codigoEpigrafe, nombreEpigrafe, pesodor, monto,
													porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
													ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
													porcSaldoMedioJunio, saldoDiciembreAnterior,
													saldoMedioDiciembre, codigoTerritorio,
													porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
													historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
													prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
													ajustePspto, desvPsptoAjustado, factAjustTerritorial,
													factAsignGteOf);
											logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 7777777777777777777777777777777777777777777777777777");
										}
									//}
								}
									anhoBus="2007";
									osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
									if(osc==null){
										
									logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
										
									}
										if(osc!=null){
											for(int i=0; i<osc.size(); i++)
											{
												beanTPlanes=(TPlanes)osc.elementAt(i);
												
												codigoOficina=beanTPlanes.getCodigoOficina();
												mes=beanTPlanes.getMes();
												anho=beanTPlanes.getAnho();
												codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
												nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
												pesodor=beanTPlanes.getPesodor();
												monto=beanTPlanes.getMonto();
												porcAlcanzado=beanTPlanes.getPorcAlcanzado();
												desvpPto=beanTPlanes.getDesvpPto();
												nroMesesFalt=beanTPlanes.getNroMesesFalt();
												proyCrecMensual=beanTPlanes.getProyCrecMensual();
												ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
												proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
												saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
												porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
												saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
												saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
												codigoTerritorio=beanTPlanes.getCodigoTerritorio();
												porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
												factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
												historicoBajas=beanTPlanes.getHistoricoBajas();
												metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
												metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
												prioridadPlanes=beanTPlanes.getPrioridad();
												mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
												indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
												varMes=beanTPlanes.getVarMes();
												ajustePspto=beanTPlanes.getAjustePspto();
												desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
												factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
												factAsignGteOf=beanTPlanes.getFactAsignGteOf();
												
												indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
														codigoEpigrafe, nombreEpigrafe, pesodor, monto,
														porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
														ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
														porcSaldoMedioJunio, saldoDiciembreAnterior,
														saldoMedioDiciembre, codigoTerritorio,
														porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
														historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
														prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
														ajustePspto, desvPsptoAjustado, factAjustTerritorial,
														factAsignGteOf);
												logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 7777777777777777777777777777777777777777777777777777");
											}
										//}
									}
										anhoBus="2008";
										osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
										if(osc==null){
											
										logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
											
										}
											if(osc!=null){
												for(int i=0; i<osc.size(); i++)
												{
													beanTPlanes=(TPlanes)osc.elementAt(i);
													
													codigoOficina=beanTPlanes.getCodigoOficina();
													mes=beanTPlanes.getMes();
													anho=beanTPlanes.getAnho();
													codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
													nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
													pesodor=beanTPlanes.getPesodor();
													monto=beanTPlanes.getMonto();
													porcAlcanzado=beanTPlanes.getPorcAlcanzado();
													desvpPto=beanTPlanes.getDesvpPto();
													nroMesesFalt=beanTPlanes.getNroMesesFalt();
													proyCrecMensual=beanTPlanes.getProyCrecMensual();
													ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
													proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
													saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
													porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
													saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
													saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
													codigoTerritorio=beanTPlanes.getCodigoTerritorio();
													porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
													factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
													historicoBajas=beanTPlanes.getHistoricoBajas();
													metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
													metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
													prioridadPlanes=beanTPlanes.getPrioridad();
													mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
													indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
													varMes=beanTPlanes.getVarMes();
													ajustePspto=beanTPlanes.getAjustePspto();
													desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
													factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
													factAsignGteOf=beanTPlanes.getFactAsignGteOf();
													
													indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
															codigoEpigrafe, nombreEpigrafe, pesodor, monto,
															porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
															ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
															porcSaldoMedioJunio, saldoDiciembreAnterior,
															saldoMedioDiciembre, codigoTerritorio,
															porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
															historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
															prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
															ajustePspto, desvPsptoAjustado, factAjustTerritorial,
															factAsignGteOf);
													logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 7777777777777777777777777777777777777777777777777777");
												}
											//}
										}
											anhoBus="2009";
											osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
											if(osc==null){
												
											logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
												
											}
												if(osc!=null){
													for(int i=0; i<osc.size(); i++)
													{
														beanTPlanes=(TPlanes)osc.elementAt(i);
														
														codigoOficina=beanTPlanes.getCodigoOficina();
														mes=beanTPlanes.getMes();
														anho=beanTPlanes.getAnho();
														codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
														nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
														pesodor=beanTPlanes.getPesodor();
														monto=beanTPlanes.getMonto();
														porcAlcanzado=beanTPlanes.getPorcAlcanzado();
														desvpPto=beanTPlanes.getDesvpPto();
														nroMesesFalt=beanTPlanes.getNroMesesFalt();
														proyCrecMensual=beanTPlanes.getProyCrecMensual();
														ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
														proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
														saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
														porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
														saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
														saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
														codigoTerritorio=beanTPlanes.getCodigoTerritorio();
														porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
														factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
														historicoBajas=beanTPlanes.getHistoricoBajas();
														metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
														metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
														prioridadPlanes=beanTPlanes.getPrioridad();
														mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
														indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
														varMes=beanTPlanes.getVarMes();
														ajustePspto=beanTPlanes.getAjustePspto();
														desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
														factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
														factAsignGteOf=beanTPlanes.getFactAsignGteOf();
														
														indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																porcSaldoMedioJunio, saldoDiciembreAnterior,
																saldoMedioDiciembre, codigoTerritorio,
																porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																factAsignGteOf);
														logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 7777777777777777777777777777777777777777777777777777");
													}
												//}
											}
	}
		public void migracion5Planes8 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			
			TPlanes beanTPlanes=null;			

		/*PLANES*/

		String codigoOficina;
		String mes;
		String anho;
		String codigoEpigrafe;
		String nombreEpigrafe;
		int pesodor;
		int monto;
		int porcAlcanzado;
		int desvpPto;
		int nroMesesFalt;
		int proyCrecMensual;
		int ajusteEstimadoTerr;
		int proyAjusteMensual;
		int saldoMedioJunio;
		int porcSaldoMedioJunio;
		int saldoDiciembreAnterior;
		int saldoMedioDiciembre;
		String codigoTerritorio;
		int porcSaldoMedioDiciembre;
		int factorAjusteSaldoPuntual;
		int historicoBajas;
		int metaMesSaldoPuntual;
		int metaGerenteOficina;
		int prioridadPlanes;
		String mesEvaluacion;
		String indicadorDor;
		int varMes;
		int ajustePspto;
		int desvPsptoAjustado;
		int factAjustTerritorial;
		int factAsignGteOf;
		int contMes=0;
		String sMensaje;
		String contadorMes="08";
		int indicador=0;
		int contador=0;
		Vector osc=null;
		String anhoBus="";
		
		/*for(contMes=1;contMes<3;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}*/
		anhoBus="2005";
		osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanTPlanes=(TPlanes)osc.elementAt(i);
					
					codigoOficina=beanTPlanes.getCodigoOficina();
					mes=beanTPlanes.getMes();
					anho=beanTPlanes.getAnho();
					codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
					nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
					pesodor=beanTPlanes.getPesodor();
					monto=beanTPlanes.getMonto();
					porcAlcanzado=beanTPlanes.getPorcAlcanzado();
					desvpPto=beanTPlanes.getDesvpPto();
					nroMesesFalt=beanTPlanes.getNroMesesFalt();
					proyCrecMensual=beanTPlanes.getProyCrecMensual();
					ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
					proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
					saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
					porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
					saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
					saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
					codigoTerritorio=beanTPlanes.getCodigoTerritorio();
					porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
					factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
					historicoBajas=beanTPlanes.getHistoricoBajas();
					metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
					metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
					prioridadPlanes=beanTPlanes.getPrioridad();
					mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
					indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
					varMes=beanTPlanes.getVarMes();
					ajustePspto=beanTPlanes.getAjustePspto();
					desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
					factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
					factAsignGteOf=beanTPlanes.getFactAsignGteOf();
					
					indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
							codigoEpigrafe, nombreEpigrafe, pesodor, monto,
							porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
							ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
							porcSaldoMedioJunio, saldoDiciembreAnterior,
							saldoMedioDiciembre, codigoTerritorio,
							porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
							historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
							prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
							factAsignGteOf);
					logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 888888888888888888888888888888888888888888888");
				}
			//}
		}
			anhoBus="2006";
			osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
				if(osc!=null){
					for(int i=0; i<osc.size(); i++)
					{
						beanTPlanes=(TPlanes)osc.elementAt(i);
						
						codigoOficina=beanTPlanes.getCodigoOficina();
						mes=beanTPlanes.getMes();
						anho=beanTPlanes.getAnho();
						codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
						nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
						pesodor=beanTPlanes.getPesodor();
						monto=beanTPlanes.getMonto();
						porcAlcanzado=beanTPlanes.getPorcAlcanzado();
						desvpPto=beanTPlanes.getDesvpPto();
						nroMesesFalt=beanTPlanes.getNroMesesFalt();
						proyCrecMensual=beanTPlanes.getProyCrecMensual();
						ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
						proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
						saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
						porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
						saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
						saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
						codigoTerritorio=beanTPlanes.getCodigoTerritorio();
						porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
						factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
						historicoBajas=beanTPlanes.getHistoricoBajas();
						metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
						metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
						prioridadPlanes=beanTPlanes.getPrioridad();
						mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
						indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
						varMes=beanTPlanes.getVarMes();
						ajustePspto=beanTPlanes.getAjustePspto();
						desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
						factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
						factAsignGteOf=beanTPlanes.getFactAsignGteOf();
						
						indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
								codigoEpigrafe, nombreEpigrafe, pesodor, monto,
								porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
								ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
								porcSaldoMedioJunio, saldoDiciembreAnterior,
								saldoMedioDiciembre, codigoTerritorio,
								porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
								historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
								prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
								ajustePspto, desvPsptoAjustado, factAjustTerritorial,
								factAsignGteOf);
						logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 888888888888888888888888888888888888888888888");
					}
				//}
			}
				anhoBus="2007";
				osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
				if(osc==null){
					
				logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
					
				}
					if(osc!=null){
						for(int i=0; i<osc.size(); i++)
						{
							beanTPlanes=(TPlanes)osc.elementAt(i);
							
							codigoOficina=beanTPlanes.getCodigoOficina();
							mes=beanTPlanes.getMes();
							anho=beanTPlanes.getAnho();
							codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
							nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
							pesodor=beanTPlanes.getPesodor();
							monto=beanTPlanes.getMonto();
							porcAlcanzado=beanTPlanes.getPorcAlcanzado();
							desvpPto=beanTPlanes.getDesvpPto();
							nroMesesFalt=beanTPlanes.getNroMesesFalt();
							proyCrecMensual=beanTPlanes.getProyCrecMensual();
							ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
							proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
							saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
							porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
							saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
							saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
							codigoTerritorio=beanTPlanes.getCodigoTerritorio();
							porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
							factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
							historicoBajas=beanTPlanes.getHistoricoBajas();
							metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
							metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
							prioridadPlanes=beanTPlanes.getPrioridad();
							mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
							indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
							varMes=beanTPlanes.getVarMes();
							ajustePspto=beanTPlanes.getAjustePspto();
							desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
							factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
							factAsignGteOf=beanTPlanes.getFactAsignGteOf();
							
							indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
									codigoEpigrafe, nombreEpigrafe, pesodor, monto,
									porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
									ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
									porcSaldoMedioJunio, saldoDiciembreAnterior,
									saldoMedioDiciembre, codigoTerritorio,
									porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
									historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
									prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
									ajustePspto, desvPsptoAjustado, factAjustTerritorial,
									factAsignGteOf);
							logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 888888888888888888888888888888888888888888888");
						}
					//}
				}
					anhoBus="2008";
					osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
					if(osc==null){
						
					logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
						
					}
						if(osc!=null){
							for(int i=0; i<osc.size(); i++)
							{
								beanTPlanes=(TPlanes)osc.elementAt(i);
								
								codigoOficina=beanTPlanes.getCodigoOficina();
								mes=beanTPlanes.getMes();
								anho=beanTPlanes.getAnho();
								codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
								nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
								pesodor=beanTPlanes.getPesodor();
								monto=beanTPlanes.getMonto();
								porcAlcanzado=beanTPlanes.getPorcAlcanzado();
								desvpPto=beanTPlanes.getDesvpPto();
								nroMesesFalt=beanTPlanes.getNroMesesFalt();
								proyCrecMensual=beanTPlanes.getProyCrecMensual();
								ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
								proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
								saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
								porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
								saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
								saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
								codigoTerritorio=beanTPlanes.getCodigoTerritorio();
								porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
								factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
								historicoBajas=beanTPlanes.getHistoricoBajas();
								metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
								metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
								prioridadPlanes=beanTPlanes.getPrioridad();
								mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
								indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
								varMes=beanTPlanes.getVarMes();
								ajustePspto=beanTPlanes.getAjustePspto();
								desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
								factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
								factAsignGteOf=beanTPlanes.getFactAsignGteOf();
								
								indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
										codigoEpigrafe, nombreEpigrafe, pesodor, monto,
										porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
										ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
										porcSaldoMedioJunio, saldoDiciembreAnterior,
										saldoMedioDiciembre, codigoTerritorio,
										porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
										historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
										prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
										ajustePspto, desvPsptoAjustado, factAjustTerritorial,
										factAsignGteOf);
								logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 888888888888888888888888888888888888888888888");
							}
						//}
					}
						anhoBus="2009";
						osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
						if(osc==null){
							
						logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
							
						}
							if(osc!=null){
								for(int i=0; i<osc.size(); i++)
								{
									beanTPlanes=(TPlanes)osc.elementAt(i);
									
									codigoOficina=beanTPlanes.getCodigoOficina();
									mes=beanTPlanes.getMes();
									anho=beanTPlanes.getAnho();
									codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
									nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
									pesodor=beanTPlanes.getPesodor();
									monto=beanTPlanes.getMonto();
									porcAlcanzado=beanTPlanes.getPorcAlcanzado();
									desvpPto=beanTPlanes.getDesvpPto();
									nroMesesFalt=beanTPlanes.getNroMesesFalt();
									proyCrecMensual=beanTPlanes.getProyCrecMensual();
									ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
									proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
									saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
									porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
									saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
									saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
									codigoTerritorio=beanTPlanes.getCodigoTerritorio();
									porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
									factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
									historicoBajas=beanTPlanes.getHistoricoBajas();
									metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
									metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
									prioridadPlanes=beanTPlanes.getPrioridad();
									mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
									indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
									varMes=beanTPlanes.getVarMes();
									ajustePspto=beanTPlanes.getAjustePspto();
									desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
									factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
									factAsignGteOf=beanTPlanes.getFactAsignGteOf();
									
									indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
											codigoEpigrafe, nombreEpigrafe, pesodor, monto,
											porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
											ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
											porcSaldoMedioJunio, saldoDiciembreAnterior,
											saldoMedioDiciembre, codigoTerritorio,
											porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
											historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
											prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
											ajustePspto, desvPsptoAjustado, factAjustTerritorial,
											factAsignGteOf);
									logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 888888888888888888888888888888888888888888888");
								}
							//}
						}
							/* SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 */
							anhoBus="2005";
							osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
							if(osc==null){
								
							logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
								
							}
								if(osc!=null){
									for(int i=0; i<osc.size(); i++)
									{
										beanTPlanes=(TPlanes)osc.elementAt(i);
										
										codigoOficina=beanTPlanes.getCodigoOficina();
										mes=beanTPlanes.getMes();
										anho=beanTPlanes.getAnho();
										codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
										nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
										pesodor=beanTPlanes.getPesodor();
										monto=beanTPlanes.getMonto();
										porcAlcanzado=beanTPlanes.getPorcAlcanzado();
										desvpPto=beanTPlanes.getDesvpPto();
										nroMesesFalt=beanTPlanes.getNroMesesFalt();
										proyCrecMensual=beanTPlanes.getProyCrecMensual();
										ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
										proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
										saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
										porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
										saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
										saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
										codigoTerritorio=beanTPlanes.getCodigoTerritorio();
										porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
										factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
										historicoBajas=beanTPlanes.getHistoricoBajas();
										metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
										metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
										prioridadPlanes=beanTPlanes.getPrioridad();
										mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
										indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
										varMes=beanTPlanes.getVarMes();
										ajustePspto=beanTPlanes.getAjustePspto();
										desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
										factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
										factAsignGteOf=beanTPlanes.getFactAsignGteOf();
										
										indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
												codigoEpigrafe, nombreEpigrafe, pesodor, monto,
												porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
												ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
												porcSaldoMedioJunio, saldoDiciembreAnterior,
												saldoMedioDiciembre, codigoTerritorio,
												porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
												historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
												prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
												ajustePspto, desvPsptoAjustado, factAjustTerritorial,
												factAsignGteOf);
										logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 888888888888888888888888888888888888888888888");
									}
								//}
							}
								anhoBus="2006";
								osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
								if(osc==null){
									
								logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
									
								}
									if(osc!=null){
										for(int i=0; i<osc.size(); i++)
										{
											beanTPlanes=(TPlanes)osc.elementAt(i);
											
											codigoOficina=beanTPlanes.getCodigoOficina();
											mes=beanTPlanes.getMes();
											anho=beanTPlanes.getAnho();
											codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
											nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
											pesodor=beanTPlanes.getPesodor();
											monto=beanTPlanes.getMonto();
											porcAlcanzado=beanTPlanes.getPorcAlcanzado();
											desvpPto=beanTPlanes.getDesvpPto();
											nroMesesFalt=beanTPlanes.getNroMesesFalt();
											proyCrecMensual=beanTPlanes.getProyCrecMensual();
											ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
											proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
											saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
											porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
											saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
											saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
											codigoTerritorio=beanTPlanes.getCodigoTerritorio();
											porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
											factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
											historicoBajas=beanTPlanes.getHistoricoBajas();
											metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
											metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
											prioridadPlanes=beanTPlanes.getPrioridad();
											mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
											indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
											varMes=beanTPlanes.getVarMes();
											ajustePspto=beanTPlanes.getAjustePspto();
											desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
											factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
											factAsignGteOf=beanTPlanes.getFactAsignGteOf();
											
											indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
													codigoEpigrafe, nombreEpigrafe, pesodor, monto,
													porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
													ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
													porcSaldoMedioJunio, saldoDiciembreAnterior,
													saldoMedioDiciembre, codigoTerritorio,
													porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
													historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
													prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
													ajustePspto, desvPsptoAjustado, factAjustTerritorial,
													factAsignGteOf);
											logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 888888888888888888888888888888888888888888888");
										}
									//}
								}
									anhoBus="2007";
									osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
									if(osc==null){
										
									logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
										
									}
										if(osc!=null){
											for(int i=0; i<osc.size(); i++)
											{
												beanTPlanes=(TPlanes)osc.elementAt(i);
												
												codigoOficina=beanTPlanes.getCodigoOficina();
												mes=beanTPlanes.getMes();
												anho=beanTPlanes.getAnho();
												codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
												nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
												pesodor=beanTPlanes.getPesodor();
												monto=beanTPlanes.getMonto();
												porcAlcanzado=beanTPlanes.getPorcAlcanzado();
												desvpPto=beanTPlanes.getDesvpPto();
												nroMesesFalt=beanTPlanes.getNroMesesFalt();
												proyCrecMensual=beanTPlanes.getProyCrecMensual();
												ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
												proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
												saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
												porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
												saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
												saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
												codigoTerritorio=beanTPlanes.getCodigoTerritorio();
												porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
												factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
												historicoBajas=beanTPlanes.getHistoricoBajas();
												metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
												metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
												prioridadPlanes=beanTPlanes.getPrioridad();
												mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
												indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
												varMes=beanTPlanes.getVarMes();
												ajustePspto=beanTPlanes.getAjustePspto();
												desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
												factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
												factAsignGteOf=beanTPlanes.getFactAsignGteOf();
												
												indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
														codigoEpigrafe, nombreEpigrafe, pesodor, monto,
														porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
														ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
														porcSaldoMedioJunio, saldoDiciembreAnterior,
														saldoMedioDiciembre, codigoTerritorio,
														porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
														historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
														prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
														ajustePspto, desvPsptoAjustado, factAjustTerritorial,
														factAsignGteOf);
												logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 888888888888888888888888888888888888888888888");
											}
										//}
									}
										anhoBus="2008";
										osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
										if(osc==null){
											
										logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
											
										}
											if(osc!=null){
												for(int i=0; i<osc.size(); i++)
												{
													beanTPlanes=(TPlanes)osc.elementAt(i);
													
													codigoOficina=beanTPlanes.getCodigoOficina();
													mes=beanTPlanes.getMes();
													anho=beanTPlanes.getAnho();
													codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
													nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
													pesodor=beanTPlanes.getPesodor();
													monto=beanTPlanes.getMonto();
													porcAlcanzado=beanTPlanes.getPorcAlcanzado();
													desvpPto=beanTPlanes.getDesvpPto();
													nroMesesFalt=beanTPlanes.getNroMesesFalt();
													proyCrecMensual=beanTPlanes.getProyCrecMensual();
													ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
													proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
													saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
													porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
													saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
													saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
													codigoTerritorio=beanTPlanes.getCodigoTerritorio();
													porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
													factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
													historicoBajas=beanTPlanes.getHistoricoBajas();
													metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
													metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
													prioridadPlanes=beanTPlanes.getPrioridad();
													mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
													indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
													varMes=beanTPlanes.getVarMes();
													ajustePspto=beanTPlanes.getAjustePspto();
													desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
													factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
													factAsignGteOf=beanTPlanes.getFactAsignGteOf();
													
													indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
															codigoEpigrafe, nombreEpigrafe, pesodor, monto,
															porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
															ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
															porcSaldoMedioJunio, saldoDiciembreAnterior,
															saldoMedioDiciembre, codigoTerritorio,
															porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
															historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
															prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
															ajustePspto, desvPsptoAjustado, factAjustTerritorial,
															factAsignGteOf);
													logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 888888888888888888888888888888888888888888888");
												}
											//}
										}
											anhoBus="2009";
											osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
											if(osc==null){
												
											logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
												
											}
												if(osc!=null){
													for(int i=0; i<osc.size(); i++)
													{
														beanTPlanes=(TPlanes)osc.elementAt(i);
														
														codigoOficina=beanTPlanes.getCodigoOficina();
														mes=beanTPlanes.getMes();
														anho=beanTPlanes.getAnho();
														codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
														nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
														pesodor=beanTPlanes.getPesodor();
														monto=beanTPlanes.getMonto();
														porcAlcanzado=beanTPlanes.getPorcAlcanzado();
														desvpPto=beanTPlanes.getDesvpPto();
														nroMesesFalt=beanTPlanes.getNroMesesFalt();
														proyCrecMensual=beanTPlanes.getProyCrecMensual();
														ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
														proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
														saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
														porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
														saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
														saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
														codigoTerritorio=beanTPlanes.getCodigoTerritorio();
														porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
														factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
														historicoBajas=beanTPlanes.getHistoricoBajas();
														metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
														metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
														prioridadPlanes=beanTPlanes.getPrioridad();
														mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
														indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
														varMes=beanTPlanes.getVarMes();
														ajustePspto=beanTPlanes.getAjustePspto();
														desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
														factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
														factAsignGteOf=beanTPlanes.getFactAsignGteOf();
														
														indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																porcSaldoMedioJunio, saldoDiciembreAnterior,
																saldoMedioDiciembre, codigoTerritorio,
																porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																factAsignGteOf);
														logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 888888888888888888888888888888888888888888888");
													}
												//}
											}
							
	}
		public void migracion5Planes9 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			
			TPlanes beanTPlanes=null;			

		/*PLANES*/

		String codigoOficina;
		String mes;
		String anho;
		String codigoEpigrafe;
		String nombreEpigrafe;
		int pesodor;
		int monto;
		int porcAlcanzado;
		int desvpPto;
		int nroMesesFalt;
		int proyCrecMensual;
		int ajusteEstimadoTerr;
		int proyAjusteMensual;
		int saldoMedioJunio;
		int porcSaldoMedioJunio;
		int saldoDiciembreAnterior;
		int saldoMedioDiciembre;
		String codigoTerritorio;
		int porcSaldoMedioDiciembre;
		int factorAjusteSaldoPuntual;
		int historicoBajas;
		int metaMesSaldoPuntual;
		int metaGerenteOficina;
		int prioridadPlanes;
		String mesEvaluacion;
		String indicadorDor;
		int varMes;
		int ajustePspto;
		int desvPsptoAjustado;
		int factAjustTerritorial;
		int factAsignGteOf;
		int contMes=0;
		String sMensaje;
		String contadorMes="09";
		int indicador=0;
		int contador=0;
		Vector osc=null;
		String anhoBus="";
		
		/*for(contMes=1;contMes<3;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}*/
		anhoBus="2005";
		osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanTPlanes=(TPlanes)osc.elementAt(i);
					
					codigoOficina=beanTPlanes.getCodigoOficina();
					mes=beanTPlanes.getMes();
					anho=beanTPlanes.getAnho();
					codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
					nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
					pesodor=beanTPlanes.getPesodor();
					monto=beanTPlanes.getMonto();
					porcAlcanzado=beanTPlanes.getPorcAlcanzado();
					desvpPto=beanTPlanes.getDesvpPto();
					nroMesesFalt=beanTPlanes.getNroMesesFalt();
					proyCrecMensual=beanTPlanes.getProyCrecMensual();
					ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
					proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
					saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
					porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
					saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
					saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
					codigoTerritorio=beanTPlanes.getCodigoTerritorio();
					porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
					factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
					historicoBajas=beanTPlanes.getHistoricoBajas();
					metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
					metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
					prioridadPlanes=beanTPlanes.getPrioridad();
					mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
					indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
					varMes=beanTPlanes.getVarMes();
					ajustePspto=beanTPlanes.getAjustePspto();
					desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
					factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
					factAsignGteOf=beanTPlanes.getFactAsignGteOf();
					
					indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
							codigoEpigrafe, nombreEpigrafe, pesodor, monto,
							porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
							ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
							porcSaldoMedioJunio, saldoDiciembreAnterior,
							saldoMedioDiciembre, codigoTerritorio,
							porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
							historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
							prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
							factAsignGteOf);
					logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 99999999999999999999999999999999999999999999999999999");
				}
			//}
		}
			anhoBus="2006";
			osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
				if(osc!=null){
					for(int i=0; i<osc.size(); i++)
					{
						beanTPlanes=(TPlanes)osc.elementAt(i);
						
						codigoOficina=beanTPlanes.getCodigoOficina();
						mes=beanTPlanes.getMes();
						anho=beanTPlanes.getAnho();
						codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
						nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
						pesodor=beanTPlanes.getPesodor();
						monto=beanTPlanes.getMonto();
						porcAlcanzado=beanTPlanes.getPorcAlcanzado();
						desvpPto=beanTPlanes.getDesvpPto();
						nroMesesFalt=beanTPlanes.getNroMesesFalt();
						proyCrecMensual=beanTPlanes.getProyCrecMensual();
						ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
						proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
						saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
						porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
						saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
						saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
						codigoTerritorio=beanTPlanes.getCodigoTerritorio();
						porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
						factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
						historicoBajas=beanTPlanes.getHistoricoBajas();
						metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
						metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
						prioridadPlanes=beanTPlanes.getPrioridad();
						mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
						indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
						varMes=beanTPlanes.getVarMes();
						ajustePspto=beanTPlanes.getAjustePspto();
						desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
						factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
						factAsignGteOf=beanTPlanes.getFactAsignGteOf();
						
						indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
								codigoEpigrafe, nombreEpigrafe, pesodor, monto,
								porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
								ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
								porcSaldoMedioJunio, saldoDiciembreAnterior,
								saldoMedioDiciembre, codigoTerritorio,
								porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
								historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
								prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
								ajustePspto, desvPsptoAjustado, factAjustTerritorial,
								factAsignGteOf);
						logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 99999999999999999999999999999999999999999999999999999");
					}
				//}
			}
				anhoBus="2007";
				osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
				if(osc==null){
					
				logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
					
				}
					if(osc!=null){
						for(int i=0; i<osc.size(); i++)
						{
							beanTPlanes=(TPlanes)osc.elementAt(i);
							
							codigoOficina=beanTPlanes.getCodigoOficina();
							mes=beanTPlanes.getMes();
							anho=beanTPlanes.getAnho();
							codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
							nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
							pesodor=beanTPlanes.getPesodor();
							monto=beanTPlanes.getMonto();
							porcAlcanzado=beanTPlanes.getPorcAlcanzado();
							desvpPto=beanTPlanes.getDesvpPto();
							nroMesesFalt=beanTPlanes.getNroMesesFalt();
							proyCrecMensual=beanTPlanes.getProyCrecMensual();
							ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
							proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
							saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
							porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
							saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
							saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
							codigoTerritorio=beanTPlanes.getCodigoTerritorio();
							porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
							factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
							historicoBajas=beanTPlanes.getHistoricoBajas();
							metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
							metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
							prioridadPlanes=beanTPlanes.getPrioridad();
							mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
							indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
							varMes=beanTPlanes.getVarMes();
							ajustePspto=beanTPlanes.getAjustePspto();
							desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
							factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
							factAsignGteOf=beanTPlanes.getFactAsignGteOf();
							
							indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
									codigoEpigrafe, nombreEpigrafe, pesodor, monto,
									porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
									ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
									porcSaldoMedioJunio, saldoDiciembreAnterior,
									saldoMedioDiciembre, codigoTerritorio,
									porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
									historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
									prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
									ajustePspto, desvPsptoAjustado, factAjustTerritorial,
									factAsignGteOf);
							logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 99999999999999999999999999999999999999999999999999999");
						}
					//}
				}
					anhoBus="2008";
					osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
					if(osc==null){
						
					logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
						
					}
						if(osc!=null){
							for(int i=0; i<osc.size(); i++)
							{
								beanTPlanes=(TPlanes)osc.elementAt(i);
								
								codigoOficina=beanTPlanes.getCodigoOficina();
								mes=beanTPlanes.getMes();
								anho=beanTPlanes.getAnho();
								codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
								nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
								pesodor=beanTPlanes.getPesodor();
								monto=beanTPlanes.getMonto();
								porcAlcanzado=beanTPlanes.getPorcAlcanzado();
								desvpPto=beanTPlanes.getDesvpPto();
								nroMesesFalt=beanTPlanes.getNroMesesFalt();
								proyCrecMensual=beanTPlanes.getProyCrecMensual();
								ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
								proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
								saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
								porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
								saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
								saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
								codigoTerritorio=beanTPlanes.getCodigoTerritorio();
								porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
								factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
								historicoBajas=beanTPlanes.getHistoricoBajas();
								metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
								metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
								prioridadPlanes=beanTPlanes.getPrioridad();
								mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
								indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
								varMes=beanTPlanes.getVarMes();
								ajustePspto=beanTPlanes.getAjustePspto();
								desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
								factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
								factAsignGteOf=beanTPlanes.getFactAsignGteOf();
								
								indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
										codigoEpigrafe, nombreEpigrafe, pesodor, monto,
										porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
										ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
										porcSaldoMedioJunio, saldoDiciembreAnterior,
										saldoMedioDiciembre, codigoTerritorio,
										porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
										historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
										prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
										ajustePspto, desvPsptoAjustado, factAjustTerritorial,
										factAsignGteOf);
								logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 99999999999999999999999999999999999999999999999999999");
							}
						//}
					}
						anhoBus="2009";
						osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
						if(osc==null){
							
						logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
							
						}
							if(osc!=null){
								for(int i=0; i<osc.size(); i++)
								{
									beanTPlanes=(TPlanes)osc.elementAt(i);
									
									codigoOficina=beanTPlanes.getCodigoOficina();
									mes=beanTPlanes.getMes();
									anho=beanTPlanes.getAnho();
									codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
									nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
									pesodor=beanTPlanes.getPesodor();
									monto=beanTPlanes.getMonto();
									porcAlcanzado=beanTPlanes.getPorcAlcanzado();
									desvpPto=beanTPlanes.getDesvpPto();
									nroMesesFalt=beanTPlanes.getNroMesesFalt();
									proyCrecMensual=beanTPlanes.getProyCrecMensual();
									ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
									proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
									saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
									porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
									saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
									saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
									codigoTerritorio=beanTPlanes.getCodigoTerritorio();
									porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
									factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
									historicoBajas=beanTPlanes.getHistoricoBajas();
									metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
									metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
									prioridadPlanes=beanTPlanes.getPrioridad();
									mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
									indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
									varMes=beanTPlanes.getVarMes();
									ajustePspto=beanTPlanes.getAjustePspto();
									desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
									factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
									factAsignGteOf=beanTPlanes.getFactAsignGteOf();
									
									indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
											codigoEpigrafe, nombreEpigrafe, pesodor, monto,
											porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
											ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
											porcSaldoMedioJunio, saldoDiciembreAnterior,
											saldoMedioDiciembre, codigoTerritorio,
											porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
											historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
											prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
											ajustePspto, desvPsptoAjustado, factAjustTerritorial,
											factAsignGteOf);
									logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 99999999999999999999999999999999999999999999999999999");
								}
							//}
						}
							/* SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 */
							
							anhoBus="2005";
							osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
							if(osc==null){
								
							logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
								
							}
								if(osc!=null){
									for(int i=0; i<osc.size(); i++)
									{
										beanTPlanes=(TPlanes)osc.elementAt(i);
										
										codigoOficina=beanTPlanes.getCodigoOficina();
										mes=beanTPlanes.getMes();
										anho=beanTPlanes.getAnho();
										codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
										nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
										pesodor=beanTPlanes.getPesodor();
										monto=beanTPlanes.getMonto();
										porcAlcanzado=beanTPlanes.getPorcAlcanzado();
										desvpPto=beanTPlanes.getDesvpPto();
										nroMesesFalt=beanTPlanes.getNroMesesFalt();
										proyCrecMensual=beanTPlanes.getProyCrecMensual();
										ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
										proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
										saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
										porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
										saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
										saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
										codigoTerritorio=beanTPlanes.getCodigoTerritorio();
										porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
										factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
										historicoBajas=beanTPlanes.getHistoricoBajas();
										metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
										metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
										prioridadPlanes=beanTPlanes.getPrioridad();
										mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
										indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
										varMes=beanTPlanes.getVarMes();
										ajustePspto=beanTPlanes.getAjustePspto();
										desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
										factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
										factAsignGteOf=beanTPlanes.getFactAsignGteOf();
										
										indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
												codigoEpigrafe, nombreEpigrafe, pesodor, monto,
												porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
												ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
												porcSaldoMedioJunio, saldoDiciembreAnterior,
												saldoMedioDiciembre, codigoTerritorio,
												porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
												historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
												prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
												ajustePspto, desvPsptoAjustado, factAjustTerritorial,
												factAsignGteOf);
										logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 99999999999999999999999999999999999999999999999999999");
									}
								//}
							}
								anhoBus="2006";
								osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
								if(osc==null){
									
								logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
									
								}
									if(osc!=null){
										for(int i=0; i<osc.size(); i++)
										{
											beanTPlanes=(TPlanes)osc.elementAt(i);
											
											codigoOficina=beanTPlanes.getCodigoOficina();
											mes=beanTPlanes.getMes();
											anho=beanTPlanes.getAnho();
											codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
											nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
											pesodor=beanTPlanes.getPesodor();
											monto=beanTPlanes.getMonto();
											porcAlcanzado=beanTPlanes.getPorcAlcanzado();
											desvpPto=beanTPlanes.getDesvpPto();
											nroMesesFalt=beanTPlanes.getNroMesesFalt();
											proyCrecMensual=beanTPlanes.getProyCrecMensual();
											ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
											proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
											saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
											porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
											saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
											saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
											codigoTerritorio=beanTPlanes.getCodigoTerritorio();
											porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
											factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
											historicoBajas=beanTPlanes.getHistoricoBajas();
											metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
											metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
											prioridadPlanes=beanTPlanes.getPrioridad();
											mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
											indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
											varMes=beanTPlanes.getVarMes();
											ajustePspto=beanTPlanes.getAjustePspto();
											desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
											factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
											factAsignGteOf=beanTPlanes.getFactAsignGteOf();
											
											indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
													codigoEpigrafe, nombreEpigrafe, pesodor, monto,
													porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
													ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
													porcSaldoMedioJunio, saldoDiciembreAnterior,
													saldoMedioDiciembre, codigoTerritorio,
													porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
													historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
													prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
													ajustePspto, desvPsptoAjustado, factAjustTerritorial,
													factAsignGteOf);
											logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 99999999999999999999999999999999999999999999999999999");
										}
									//}
								}
									anhoBus="2007";
									osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
									if(osc==null){
										
									logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
										
									}
										if(osc!=null){
											for(int i=0; i<osc.size(); i++)
											{
												beanTPlanes=(TPlanes)osc.elementAt(i);
												
												codigoOficina=beanTPlanes.getCodigoOficina();
												mes=beanTPlanes.getMes();
												anho=beanTPlanes.getAnho();
												codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
												nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
												pesodor=beanTPlanes.getPesodor();
												monto=beanTPlanes.getMonto();
												porcAlcanzado=beanTPlanes.getPorcAlcanzado();
												desvpPto=beanTPlanes.getDesvpPto();
												nroMesesFalt=beanTPlanes.getNroMesesFalt();
												proyCrecMensual=beanTPlanes.getProyCrecMensual();
												ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
												proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
												saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
												porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
												saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
												saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
												codigoTerritorio=beanTPlanes.getCodigoTerritorio();
												porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
												factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
												historicoBajas=beanTPlanes.getHistoricoBajas();
												metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
												metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
												prioridadPlanes=beanTPlanes.getPrioridad();
												mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
												indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
												varMes=beanTPlanes.getVarMes();
												ajustePspto=beanTPlanes.getAjustePspto();
												desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
												factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
												factAsignGteOf=beanTPlanes.getFactAsignGteOf();
												
												indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
														codigoEpigrafe, nombreEpigrafe, pesodor, monto,
														porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
														ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
														porcSaldoMedioJunio, saldoDiciembreAnterior,
														saldoMedioDiciembre, codigoTerritorio,
														porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
														historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
														prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
														ajustePspto, desvPsptoAjustado, factAjustTerritorial,
														factAsignGteOf);
												logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 99999999999999999999999999999999999999999999999999999");
											}
										//}
									}
										anhoBus="2008";
										osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
										if(osc==null){
											
										logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
											
										}
											if(osc!=null){
												for(int i=0; i<osc.size(); i++)
												{
													beanTPlanes=(TPlanes)osc.elementAt(i);
													
													codigoOficina=beanTPlanes.getCodigoOficina();
													mes=beanTPlanes.getMes();
													anho=beanTPlanes.getAnho();
													codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
													nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
													pesodor=beanTPlanes.getPesodor();
													monto=beanTPlanes.getMonto();
													porcAlcanzado=beanTPlanes.getPorcAlcanzado();
													desvpPto=beanTPlanes.getDesvpPto();
													nroMesesFalt=beanTPlanes.getNroMesesFalt();
													proyCrecMensual=beanTPlanes.getProyCrecMensual();
													ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
													proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
													saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
													porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
													saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
													saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
													codigoTerritorio=beanTPlanes.getCodigoTerritorio();
													porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
													factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
													historicoBajas=beanTPlanes.getHistoricoBajas();
													metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
													metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
													prioridadPlanes=beanTPlanes.getPrioridad();
													mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
													indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
													varMes=beanTPlanes.getVarMes();
													ajustePspto=beanTPlanes.getAjustePspto();
													desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
													factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
													factAsignGteOf=beanTPlanes.getFactAsignGteOf();
													
													indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
															codigoEpigrafe, nombreEpigrafe, pesodor, monto,
															porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
															ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
															porcSaldoMedioJunio, saldoDiciembreAnterior,
															saldoMedioDiciembre, codigoTerritorio,
															porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
															historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
															prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
															ajustePspto, desvPsptoAjustado, factAjustTerritorial,
															factAsignGteOf);
													logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 99999999999999999999999999999999999999999999999999999");
												}
											//}
										}
											anhoBus="2009";
											osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
											if(osc==null){
												
											logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
												
											}
												if(osc!=null){
													for(int i=0; i<osc.size(); i++)
													{
														beanTPlanes=(TPlanes)osc.elementAt(i);
														
														codigoOficina=beanTPlanes.getCodigoOficina();
														mes=beanTPlanes.getMes();
														anho=beanTPlanes.getAnho();
														codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
														nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
														pesodor=beanTPlanes.getPesodor();
														monto=beanTPlanes.getMonto();
														porcAlcanzado=beanTPlanes.getPorcAlcanzado();
														desvpPto=beanTPlanes.getDesvpPto();
														nroMesesFalt=beanTPlanes.getNroMesesFalt();
														proyCrecMensual=beanTPlanes.getProyCrecMensual();
														ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
														proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
														saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
														porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
														saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
														saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
														codigoTerritorio=beanTPlanes.getCodigoTerritorio();
														porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
														factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
														historicoBajas=beanTPlanes.getHistoricoBajas();
														metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
														metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
														prioridadPlanes=beanTPlanes.getPrioridad();
														mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
														indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
														varMes=beanTPlanes.getVarMes();
														ajustePspto=beanTPlanes.getAjustePspto();
														desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
														factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
														factAsignGteOf=beanTPlanes.getFactAsignGteOf();
														
														indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																porcSaldoMedioJunio, saldoDiciembreAnterior,
																saldoMedioDiciembre, codigoTerritorio,
																porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																factAsignGteOf);
														logger.info("TABLA PLANESSSSSSSSSSSSSSSSSS 99999999999999999999999999999999999999999999999999999");
													}
												//}
											}
	}
		public void migracion5Planes10 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			
			TPlanes beanTPlanes=null;			

		/*PLANES*/

		String codigoOficina;
		String mes;
		String anho;
		String codigoEpigrafe;
		String nombreEpigrafe;
		int pesodor;
		int monto;
		int porcAlcanzado;
		int desvpPto;
		int nroMesesFalt;
		int proyCrecMensual;
		int ajusteEstimadoTerr;
		int proyAjusteMensual;
		int saldoMedioJunio;
		int porcSaldoMedioJunio;
		int saldoDiciembreAnterior;
		int saldoMedioDiciembre;
		String codigoTerritorio;
		int porcSaldoMedioDiciembre;
		int factorAjusteSaldoPuntual;
		int historicoBajas;
		int metaMesSaldoPuntual;
		int metaGerenteOficina;
		int prioridadPlanes;
		String mesEvaluacion;
		String indicadorDor;
		int varMes;
		int ajustePspto;
		int desvPsptoAjustado;
		int factAjustTerritorial;
		int factAsignGteOf;
		int contMes=0;
		String sMensaje;
		String contadorMes="10";
		int indicador=0;
		int contador=0;
		Vector osc=null;
		String anhoBus="";
		
		/*for(contMes=1;contMes<3;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}*/
		anhoBus="2005";
		osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanTPlanes=(TPlanes)osc.elementAt(i);
					
					codigoOficina=beanTPlanes.getCodigoOficina();
					mes=beanTPlanes.getMes();
					anho=beanTPlanes.getAnho();
					codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
					nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
					pesodor=beanTPlanes.getPesodor();
					monto=beanTPlanes.getMonto();
					porcAlcanzado=beanTPlanes.getPorcAlcanzado();
					desvpPto=beanTPlanes.getDesvpPto();
					nroMesesFalt=beanTPlanes.getNroMesesFalt();
					proyCrecMensual=beanTPlanes.getProyCrecMensual();
					ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
					proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
					saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
					porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
					saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
					saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
					codigoTerritorio=beanTPlanes.getCodigoTerritorio();
					porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
					factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
					historicoBajas=beanTPlanes.getHistoricoBajas();
					metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
					metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
					prioridadPlanes=beanTPlanes.getPrioridad();
					mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
					indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
					varMes=beanTPlanes.getVarMes();
					ajustePspto=beanTPlanes.getAjustePspto();
					desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
					factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
					factAsignGteOf=beanTPlanes.getFactAsignGteOf();
					
					indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
							codigoEpigrafe, nombreEpigrafe, pesodor, monto,
							porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
							ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
							porcSaldoMedioJunio, saldoDiciembreAnterior,
							saldoMedioDiciembre, codigoTerritorio,
							porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
							historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
							prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
							factAsignGteOf);
					
				}
			//}
		}
			anhoBus="2006";
			osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
				if(osc!=null){
					for(int i=0; i<osc.size(); i++)
					{
						beanTPlanes=(TPlanes)osc.elementAt(i);
						
						codigoOficina=beanTPlanes.getCodigoOficina();
						mes=beanTPlanes.getMes();
						anho=beanTPlanes.getAnho();
						codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
						nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
						pesodor=beanTPlanes.getPesodor();
						monto=beanTPlanes.getMonto();
						porcAlcanzado=beanTPlanes.getPorcAlcanzado();
						desvpPto=beanTPlanes.getDesvpPto();
						nroMesesFalt=beanTPlanes.getNroMesesFalt();
						proyCrecMensual=beanTPlanes.getProyCrecMensual();
						ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
						proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
						saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
						porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
						saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
						saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
						codigoTerritorio=beanTPlanes.getCodigoTerritorio();
						porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
						factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
						historicoBajas=beanTPlanes.getHistoricoBajas();
						metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
						metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
						prioridadPlanes=beanTPlanes.getPrioridad();
						mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
						indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
						varMes=beanTPlanes.getVarMes();
						ajustePspto=beanTPlanes.getAjustePspto();
						desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
						factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
						factAsignGteOf=beanTPlanes.getFactAsignGteOf();
						
						indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
								codigoEpigrafe, nombreEpigrafe, pesodor, monto,
								porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
								ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
								porcSaldoMedioJunio, saldoDiciembreAnterior,
								saldoMedioDiciembre, codigoTerritorio,
								porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
								historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
								prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
								ajustePspto, desvPsptoAjustado, factAjustTerritorial,
								factAsignGteOf);
						
					}
				//}
			}
				anhoBus="2007";
				osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
				if(osc==null){
					
				logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
					
				}
					if(osc!=null){
						for(int i=0; i<osc.size(); i++)
						{
							beanTPlanes=(TPlanes)osc.elementAt(i);
							
							codigoOficina=beanTPlanes.getCodigoOficina();
							mes=beanTPlanes.getMes();
							anho=beanTPlanes.getAnho();
							codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
							nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
							pesodor=beanTPlanes.getPesodor();
							monto=beanTPlanes.getMonto();
							porcAlcanzado=beanTPlanes.getPorcAlcanzado();
							desvpPto=beanTPlanes.getDesvpPto();
							nroMesesFalt=beanTPlanes.getNroMesesFalt();
							proyCrecMensual=beanTPlanes.getProyCrecMensual();
							ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
							proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
							saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
							porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
							saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
							saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
							codigoTerritorio=beanTPlanes.getCodigoTerritorio();
							porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
							factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
							historicoBajas=beanTPlanes.getHistoricoBajas();
							metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
							metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
							prioridadPlanes=beanTPlanes.getPrioridad();
							mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
							indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
							varMes=beanTPlanes.getVarMes();
							ajustePspto=beanTPlanes.getAjustePspto();
							desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
							factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
							factAsignGteOf=beanTPlanes.getFactAsignGteOf();
							
							indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
									codigoEpigrafe, nombreEpigrafe, pesodor, monto,
									porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
									ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
									porcSaldoMedioJunio, saldoDiciembreAnterior,
									saldoMedioDiciembre, codigoTerritorio,
									porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
									historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
									prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
									ajustePspto, desvPsptoAjustado, factAjustTerritorial,
									factAsignGteOf);
							
						}
					//}
				}
					anhoBus="2008";
					osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
					if(osc==null){
						
					logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
						
					}
						if(osc!=null){
							for(int i=0; i<osc.size(); i++)
							{
								beanTPlanes=(TPlanes)osc.elementAt(i);
								
								codigoOficina=beanTPlanes.getCodigoOficina();
								mes=beanTPlanes.getMes();
								anho=beanTPlanes.getAnho();
								codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
								nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
								pesodor=beanTPlanes.getPesodor();
								monto=beanTPlanes.getMonto();
								porcAlcanzado=beanTPlanes.getPorcAlcanzado();
								desvpPto=beanTPlanes.getDesvpPto();
								nroMesesFalt=beanTPlanes.getNroMesesFalt();
								proyCrecMensual=beanTPlanes.getProyCrecMensual();
								ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
								proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
								saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
								porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
								saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
								saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
								codigoTerritorio=beanTPlanes.getCodigoTerritorio();
								porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
								factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
								historicoBajas=beanTPlanes.getHistoricoBajas();
								metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
								metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
								prioridadPlanes=beanTPlanes.getPrioridad();
								mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
								indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
								varMes=beanTPlanes.getVarMes();
								ajustePspto=beanTPlanes.getAjustePspto();
								desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
								factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
								factAsignGteOf=beanTPlanes.getFactAsignGteOf();
								
								indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
										codigoEpigrafe, nombreEpigrafe, pesodor, monto,
										porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
										ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
										porcSaldoMedioJunio, saldoDiciembreAnterior,
										saldoMedioDiciembre, codigoTerritorio,
										porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
										historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
										prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
										ajustePspto, desvPsptoAjustado, factAjustTerritorial,
										factAsignGteOf);
								
							}
						//}
					}
						anhoBus="2009";
						osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
						if(osc==null){
							
						logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
							
						}
							if(osc!=null){
								for(int i=0; i<osc.size(); i++)
								{
									beanTPlanes=(TPlanes)osc.elementAt(i);
									
									codigoOficina=beanTPlanes.getCodigoOficina();
									mes=beanTPlanes.getMes();
									anho=beanTPlanes.getAnho();
									codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
									nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
									pesodor=beanTPlanes.getPesodor();
									monto=beanTPlanes.getMonto();
									porcAlcanzado=beanTPlanes.getPorcAlcanzado();
									desvpPto=beanTPlanes.getDesvpPto();
									nroMesesFalt=beanTPlanes.getNroMesesFalt();
									proyCrecMensual=beanTPlanes.getProyCrecMensual();
									ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
									proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
									saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
									porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
									saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
									saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
									codigoTerritorio=beanTPlanes.getCodigoTerritorio();
									porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
									factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
									historicoBajas=beanTPlanes.getHistoricoBajas();
									metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
									metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
									prioridadPlanes=beanTPlanes.getPrioridad();
									mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
									indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
									varMes=beanTPlanes.getVarMes();
									ajustePspto=beanTPlanes.getAjustePspto();
									desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
									factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
									factAsignGteOf=beanTPlanes.getFactAsignGteOf();
									
									indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
											codigoEpigrafe, nombreEpigrafe, pesodor, monto,
											porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
											ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
											porcSaldoMedioJunio, saldoDiciembreAnterior,
											saldoMedioDiciembre, codigoTerritorio,
											porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
											historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
											prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
											ajustePspto, desvPsptoAjustado, factAjustTerritorial,
											factAsignGteOf);
									
								}
							//}
						}
							
							/* SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 */
							anhoBus="2005";
							osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
							if(osc==null){
								
							logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
								
							}
								if(osc!=null){
									for(int i=0; i<osc.size(); i++)
									{
										beanTPlanes=(TPlanes)osc.elementAt(i);
										
										codigoOficina=beanTPlanes.getCodigoOficina();
										mes=beanTPlanes.getMes();
										anho=beanTPlanes.getAnho();
										codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
										nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
										pesodor=beanTPlanes.getPesodor();
										monto=beanTPlanes.getMonto();
										porcAlcanzado=beanTPlanes.getPorcAlcanzado();
										desvpPto=beanTPlanes.getDesvpPto();
										nroMesesFalt=beanTPlanes.getNroMesesFalt();
										proyCrecMensual=beanTPlanes.getProyCrecMensual();
										ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
										proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
										saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
										porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
										saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
										saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
										codigoTerritorio=beanTPlanes.getCodigoTerritorio();
										porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
										factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
										historicoBajas=beanTPlanes.getHistoricoBajas();
										metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
										metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
										prioridadPlanes=beanTPlanes.getPrioridad();
										mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
										indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
										varMes=beanTPlanes.getVarMes();
										ajustePspto=beanTPlanes.getAjustePspto();
										desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
										factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
										factAsignGteOf=beanTPlanes.getFactAsignGteOf();
										
										indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
												codigoEpigrafe, nombreEpigrafe, pesodor, monto,
												porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
												ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
												porcSaldoMedioJunio, saldoDiciembreAnterior,
												saldoMedioDiciembre, codigoTerritorio,
												porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
												historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
												prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
												ajustePspto, desvPsptoAjustado, factAjustTerritorial,
												factAsignGteOf);
										
									}
								//}
							}
								anhoBus="2006";
								osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
								if(osc==null){
									
								logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
									
								}
									if(osc!=null){
										for(int i=0; i<osc.size(); i++)
										{
											beanTPlanes=(TPlanes)osc.elementAt(i);
											
											codigoOficina=beanTPlanes.getCodigoOficina();
											mes=beanTPlanes.getMes();
											anho=beanTPlanes.getAnho();
											codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
											nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
											pesodor=beanTPlanes.getPesodor();
											monto=beanTPlanes.getMonto();
											porcAlcanzado=beanTPlanes.getPorcAlcanzado();
											desvpPto=beanTPlanes.getDesvpPto();
											nroMesesFalt=beanTPlanes.getNroMesesFalt();
											proyCrecMensual=beanTPlanes.getProyCrecMensual();
											ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
											proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
											saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
											porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
											saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
											saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
											codigoTerritorio=beanTPlanes.getCodigoTerritorio();
											porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
											factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
											historicoBajas=beanTPlanes.getHistoricoBajas();
											metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
											metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
											prioridadPlanes=beanTPlanes.getPrioridad();
											mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
											indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
											varMes=beanTPlanes.getVarMes();
											ajustePspto=beanTPlanes.getAjustePspto();
											desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
											factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
											factAsignGteOf=beanTPlanes.getFactAsignGteOf();
											
											indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
													codigoEpigrafe, nombreEpigrafe, pesodor, monto,
													porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
													ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
													porcSaldoMedioJunio, saldoDiciembreAnterior,
													saldoMedioDiciembre, codigoTerritorio,
													porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
													historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
													prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
													ajustePspto, desvPsptoAjustado, factAjustTerritorial,
													factAsignGteOf);
											
										}
									//}
								}
									anhoBus="2007";
									osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
									if(osc==null){
										
									logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
										
									}
										if(osc!=null){
											for(int i=0; i<osc.size(); i++)
											{
												beanTPlanes=(TPlanes)osc.elementAt(i);
												
												codigoOficina=beanTPlanes.getCodigoOficina();
												mes=beanTPlanes.getMes();
												anho=beanTPlanes.getAnho();
												codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
												nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
												pesodor=beanTPlanes.getPesodor();
												monto=beanTPlanes.getMonto();
												porcAlcanzado=beanTPlanes.getPorcAlcanzado();
												desvpPto=beanTPlanes.getDesvpPto();
												nroMesesFalt=beanTPlanes.getNroMesesFalt();
												proyCrecMensual=beanTPlanes.getProyCrecMensual();
												ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
												proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
												saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
												porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
												saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
												saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
												codigoTerritorio=beanTPlanes.getCodigoTerritorio();
												porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
												factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
												historicoBajas=beanTPlanes.getHistoricoBajas();
												metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
												metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
												prioridadPlanes=beanTPlanes.getPrioridad();
												mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
												indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
												varMes=beanTPlanes.getVarMes();
												ajustePspto=beanTPlanes.getAjustePspto();
												desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
												factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
												factAsignGteOf=beanTPlanes.getFactAsignGteOf();
												
												indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
														codigoEpigrafe, nombreEpigrafe, pesodor, monto,
														porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
														ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
														porcSaldoMedioJunio, saldoDiciembreAnterior,
														saldoMedioDiciembre, codigoTerritorio,
														porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
														historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
														prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
														ajustePspto, desvPsptoAjustado, factAjustTerritorial,
														factAsignGteOf);
												
											}
										//}
									}
										anhoBus="2008";
										osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
										if(osc==null){
											
										logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
											
										}
											if(osc!=null){
												for(int i=0; i<osc.size(); i++)
												{
													beanTPlanes=(TPlanes)osc.elementAt(i);
													
													codigoOficina=beanTPlanes.getCodigoOficina();
													mes=beanTPlanes.getMes();
													anho=beanTPlanes.getAnho();
													codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
													nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
													pesodor=beanTPlanes.getPesodor();
													monto=beanTPlanes.getMonto();
													porcAlcanzado=beanTPlanes.getPorcAlcanzado();
													desvpPto=beanTPlanes.getDesvpPto();
													nroMesesFalt=beanTPlanes.getNroMesesFalt();
													proyCrecMensual=beanTPlanes.getProyCrecMensual();
													ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
													proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
													saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
													porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
													saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
													saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
													codigoTerritorio=beanTPlanes.getCodigoTerritorio();
													porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
													factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
													historicoBajas=beanTPlanes.getHistoricoBajas();
													metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
													metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
													prioridadPlanes=beanTPlanes.getPrioridad();
													mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
													indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
													varMes=beanTPlanes.getVarMes();
													ajustePspto=beanTPlanes.getAjustePspto();
													desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
													factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
													factAsignGteOf=beanTPlanes.getFactAsignGteOf();
													
													indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
															codigoEpigrafe, nombreEpigrafe, pesodor, monto,
															porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
															ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
															porcSaldoMedioJunio, saldoDiciembreAnterior,
															saldoMedioDiciembre, codigoTerritorio,
															porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
															historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
															prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
															ajustePspto, desvPsptoAjustado, factAjustTerritorial,
															factAsignGteOf);
													
												}
											//}
										}
											anhoBus="2009";
											osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
											if(osc==null){
												
											logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
												
											}
												if(osc!=null){
													for(int i=0; i<osc.size(); i++)
													{
														beanTPlanes=(TPlanes)osc.elementAt(i);
														
														codigoOficina=beanTPlanes.getCodigoOficina();
														mes=beanTPlanes.getMes();
														anho=beanTPlanes.getAnho();
														codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
														nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
														pesodor=beanTPlanes.getPesodor();
														monto=beanTPlanes.getMonto();
														porcAlcanzado=beanTPlanes.getPorcAlcanzado();
														desvpPto=beanTPlanes.getDesvpPto();
														nroMesesFalt=beanTPlanes.getNroMesesFalt();
														proyCrecMensual=beanTPlanes.getProyCrecMensual();
														ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
														proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
														saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
														porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
														saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
														saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
														codigoTerritorio=beanTPlanes.getCodigoTerritorio();
														porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
														factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
														historicoBajas=beanTPlanes.getHistoricoBajas();
														metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
														metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
														prioridadPlanes=beanTPlanes.getPrioridad();
														mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
														indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
														varMes=beanTPlanes.getVarMes();
														ajustePspto=beanTPlanes.getAjustePspto();
														desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
														factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
														factAsignGteOf=beanTPlanes.getFactAsignGteOf();
														
														indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																porcSaldoMedioJunio, saldoDiciembreAnterior,
																saldoMedioDiciembre, codigoTerritorio,
																porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																factAsignGteOf);
														
													}
												//}
											}
							
	}
		public void migracion5Planes11 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			
			TPlanes beanTPlanes=null;			

		/*PLANES*/

		String codigoOficina;
		String mes;
		String anho;
		String codigoEpigrafe;
		String nombreEpigrafe;
		int pesodor;
		int monto;
		int porcAlcanzado;
		int desvpPto;
		int nroMesesFalt;
		int proyCrecMensual;
		int ajusteEstimadoTerr;
		int proyAjusteMensual;
		int saldoMedioJunio;
		int porcSaldoMedioJunio;
		int saldoDiciembreAnterior;
		int saldoMedioDiciembre;
		String codigoTerritorio;
		int porcSaldoMedioDiciembre;
		int factorAjusteSaldoPuntual;
		int historicoBajas;
		int metaMesSaldoPuntual;
		int metaGerenteOficina;
		int prioridadPlanes;
		String mesEvaluacion;
		String indicadorDor;
		int varMes;
		int ajustePspto;
		int desvPsptoAjustado;
		int factAjustTerritorial;
		int factAsignGteOf;
		int contMes=0;
		String sMensaje;
		String contadorMes="11";
		int indicador=0;
		int contador=0;
		Vector osc=null;
		String anhoBus="";
		
		/*for(contMes=1;contMes<3;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}*/
		anhoBus="2005";
		osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanTPlanes=(TPlanes)osc.elementAt(i);
					
					codigoOficina=beanTPlanes.getCodigoOficina();
					mes=beanTPlanes.getMes();
					anho=beanTPlanes.getAnho();
					codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
					nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
					pesodor=beanTPlanes.getPesodor();
					monto=beanTPlanes.getMonto();
					porcAlcanzado=beanTPlanes.getPorcAlcanzado();
					desvpPto=beanTPlanes.getDesvpPto();
					nroMesesFalt=beanTPlanes.getNroMesesFalt();
					proyCrecMensual=beanTPlanes.getProyCrecMensual();
					ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
					proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
					saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
					porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
					saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
					saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
					codigoTerritorio=beanTPlanes.getCodigoTerritorio();
					porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
					factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
					historicoBajas=beanTPlanes.getHistoricoBajas();
					metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
					metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
					prioridadPlanes=beanTPlanes.getPrioridad();
					mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
					indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
					varMes=beanTPlanes.getVarMes();
					ajustePspto=beanTPlanes.getAjustePspto();
					desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
					factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
					factAsignGteOf=beanTPlanes.getFactAsignGteOf();
					
					indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
							codigoEpigrafe, nombreEpigrafe, pesodor, monto,
							porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
							ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
							porcSaldoMedioJunio, saldoDiciembreAnterior,
							saldoMedioDiciembre, codigoTerritorio,
							porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
							historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
							prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
							factAsignGteOf);
					
				}
			//}
		}
			anhoBus="2006";
			osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
				if(osc!=null){
					for(int i=0; i<osc.size(); i++)
					{
						beanTPlanes=(TPlanes)osc.elementAt(i);
						
						codigoOficina=beanTPlanes.getCodigoOficina();
						mes=beanTPlanes.getMes();
						anho=beanTPlanes.getAnho();
						codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
						nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
						pesodor=beanTPlanes.getPesodor();
						monto=beanTPlanes.getMonto();
						porcAlcanzado=beanTPlanes.getPorcAlcanzado();
						desvpPto=beanTPlanes.getDesvpPto();
						nroMesesFalt=beanTPlanes.getNroMesesFalt();
						proyCrecMensual=beanTPlanes.getProyCrecMensual();
						ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
						proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
						saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
						porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
						saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
						saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
						codigoTerritorio=beanTPlanes.getCodigoTerritorio();
						porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
						factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
						historicoBajas=beanTPlanes.getHistoricoBajas();
						metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
						metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
						prioridadPlanes=beanTPlanes.getPrioridad();
						mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
						indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
						varMes=beanTPlanes.getVarMes();
						ajustePspto=beanTPlanes.getAjustePspto();
						desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
						factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
						factAsignGteOf=beanTPlanes.getFactAsignGteOf();
						
						indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
								codigoEpigrafe, nombreEpigrafe, pesodor, monto,
								porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
								ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
								porcSaldoMedioJunio, saldoDiciembreAnterior,
								saldoMedioDiciembre, codigoTerritorio,
								porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
								historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
								prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
								ajustePspto, desvPsptoAjustado, factAjustTerritorial,
								factAsignGteOf);
						
					}
				//}
			}
				anhoBus="2007";
				osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
				if(osc==null){
					
				logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
					
				}
					if(osc!=null){
						for(int i=0; i<osc.size(); i++)
						{
							beanTPlanes=(TPlanes)osc.elementAt(i);
							
							codigoOficina=beanTPlanes.getCodigoOficina();
							mes=beanTPlanes.getMes();
							anho=beanTPlanes.getAnho();
							codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
							nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
							pesodor=beanTPlanes.getPesodor();
							monto=beanTPlanes.getMonto();
							porcAlcanzado=beanTPlanes.getPorcAlcanzado();
							desvpPto=beanTPlanes.getDesvpPto();
							nroMesesFalt=beanTPlanes.getNroMesesFalt();
							proyCrecMensual=beanTPlanes.getProyCrecMensual();
							ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
							proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
							saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
							porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
							saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
							saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
							codigoTerritorio=beanTPlanes.getCodigoTerritorio();
							porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
							factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
							historicoBajas=beanTPlanes.getHistoricoBajas();
							metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
							metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
							prioridadPlanes=beanTPlanes.getPrioridad();
							mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
							indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
							varMes=beanTPlanes.getVarMes();
							ajustePspto=beanTPlanes.getAjustePspto();
							desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
							factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
							factAsignGteOf=beanTPlanes.getFactAsignGteOf();
							
							indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
									codigoEpigrafe, nombreEpigrafe, pesodor, monto,
									porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
									ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
									porcSaldoMedioJunio, saldoDiciembreAnterior,
									saldoMedioDiciembre, codigoTerritorio,
									porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
									historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
									prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
									ajustePspto, desvPsptoAjustado, factAjustTerritorial,
									factAsignGteOf);
							
						}
					//}
				}
					anhoBus="2008";
					osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
					if(osc==null){
						
					logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
						
					}
						if(osc!=null){
							for(int i=0; i<osc.size(); i++)
							{
								beanTPlanes=(TPlanes)osc.elementAt(i);
								
								codigoOficina=beanTPlanes.getCodigoOficina();
								mes=beanTPlanes.getMes();
								anho=beanTPlanes.getAnho();
								codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
								nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
								pesodor=beanTPlanes.getPesodor();
								monto=beanTPlanes.getMonto();
								porcAlcanzado=beanTPlanes.getPorcAlcanzado();
								desvpPto=beanTPlanes.getDesvpPto();
								nroMesesFalt=beanTPlanes.getNroMesesFalt();
								proyCrecMensual=beanTPlanes.getProyCrecMensual();
								ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
								proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
								saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
								porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
								saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
								saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
								codigoTerritorio=beanTPlanes.getCodigoTerritorio();
								porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
								factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
								historicoBajas=beanTPlanes.getHistoricoBajas();
								metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
								metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
								prioridadPlanes=beanTPlanes.getPrioridad();
								mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
								indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
								varMes=beanTPlanes.getVarMes();
								ajustePspto=beanTPlanes.getAjustePspto();
								desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
								factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
								factAsignGteOf=beanTPlanes.getFactAsignGteOf();
								
								indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
										codigoEpigrafe, nombreEpigrafe, pesodor, monto,
										porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
										ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
										porcSaldoMedioJunio, saldoDiciembreAnterior,
										saldoMedioDiciembre, codigoTerritorio,
										porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
										historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
										prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
										ajustePspto, desvPsptoAjustado, factAjustTerritorial,
										factAsignGteOf);
								
							}
						//}
					}
						anhoBus="2009";
						osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
						if(osc==null){
							
						logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
							
						}
							if(osc!=null){
								for(int i=0; i<osc.size(); i++)
								{
									beanTPlanes=(TPlanes)osc.elementAt(i);
									
									codigoOficina=beanTPlanes.getCodigoOficina();
									mes=beanTPlanes.getMes();
									anho=beanTPlanes.getAnho();
									codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
									nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
									pesodor=beanTPlanes.getPesodor();
									monto=beanTPlanes.getMonto();
									porcAlcanzado=beanTPlanes.getPorcAlcanzado();
									desvpPto=beanTPlanes.getDesvpPto();
									nroMesesFalt=beanTPlanes.getNroMesesFalt();
									proyCrecMensual=beanTPlanes.getProyCrecMensual();
									ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
									proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
									saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
									porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
									saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
									saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
									codigoTerritorio=beanTPlanes.getCodigoTerritorio();
									porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
									factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
									historicoBajas=beanTPlanes.getHistoricoBajas();
									metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
									metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
									prioridadPlanes=beanTPlanes.getPrioridad();
									mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
									indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
									varMes=beanTPlanes.getVarMes();
									ajustePspto=beanTPlanes.getAjustePspto();
									desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
									factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
									factAsignGteOf=beanTPlanes.getFactAsignGteOf();
									
									indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
											codigoEpigrafe, nombreEpigrafe, pesodor, monto,
											porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
											ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
											porcSaldoMedioJunio, saldoDiciembreAnterior,
											saldoMedioDiciembre, codigoTerritorio,
											porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
											historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
											prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
											ajustePspto, desvPsptoAjustado, factAjustTerritorial,
											factAsignGteOf);
									
								}
							//}
						}
							
							/* SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 */
							
							anhoBus="2005";
							osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
							if(osc==null){
								
							logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
								
							}
								if(osc!=null){
									for(int i=0; i<osc.size(); i++)
									{
										beanTPlanes=(TPlanes)osc.elementAt(i);
										
										codigoOficina=beanTPlanes.getCodigoOficina();
										mes=beanTPlanes.getMes();
										anho=beanTPlanes.getAnho();
										codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
										nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
										pesodor=beanTPlanes.getPesodor();
										monto=beanTPlanes.getMonto();
										porcAlcanzado=beanTPlanes.getPorcAlcanzado();
										desvpPto=beanTPlanes.getDesvpPto();
										nroMesesFalt=beanTPlanes.getNroMesesFalt();
										proyCrecMensual=beanTPlanes.getProyCrecMensual();
										ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
										proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
										saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
										porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
										saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
										saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
										codigoTerritorio=beanTPlanes.getCodigoTerritorio();
										porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
										factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
										historicoBajas=beanTPlanes.getHistoricoBajas();
										metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
										metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
										prioridadPlanes=beanTPlanes.getPrioridad();
										mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
										indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
										varMes=beanTPlanes.getVarMes();
										ajustePspto=beanTPlanes.getAjustePspto();
										desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
										factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
										factAsignGteOf=beanTPlanes.getFactAsignGteOf();
										
										indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
												codigoEpigrafe, nombreEpigrafe, pesodor, monto,
												porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
												ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
												porcSaldoMedioJunio, saldoDiciembreAnterior,
												saldoMedioDiciembre, codigoTerritorio,
												porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
												historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
												prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
												ajustePspto, desvPsptoAjustado, factAjustTerritorial,
												factAsignGteOf);
										
									}
								//}
							}
								anhoBus="2006";
								osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
								if(osc==null){
									
								logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
									
								}
									if(osc!=null){
										for(int i=0; i<osc.size(); i++)
										{
											beanTPlanes=(TPlanes)osc.elementAt(i);
											
											codigoOficina=beanTPlanes.getCodigoOficina();
											mes=beanTPlanes.getMes();
											anho=beanTPlanes.getAnho();
											codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
											nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
											pesodor=beanTPlanes.getPesodor();
											monto=beanTPlanes.getMonto();
											porcAlcanzado=beanTPlanes.getPorcAlcanzado();
											desvpPto=beanTPlanes.getDesvpPto();
											nroMesesFalt=beanTPlanes.getNroMesesFalt();
											proyCrecMensual=beanTPlanes.getProyCrecMensual();
											ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
											proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
											saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
											porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
											saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
											saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
											codigoTerritorio=beanTPlanes.getCodigoTerritorio();
											porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
											factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
											historicoBajas=beanTPlanes.getHistoricoBajas();
											metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
											metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
											prioridadPlanes=beanTPlanes.getPrioridad();
											mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
											indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
											varMes=beanTPlanes.getVarMes();
											ajustePspto=beanTPlanes.getAjustePspto();
											desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
											factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
											factAsignGteOf=beanTPlanes.getFactAsignGteOf();
											
											indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
													codigoEpigrafe, nombreEpigrafe, pesodor, monto,
													porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
													ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
													porcSaldoMedioJunio, saldoDiciembreAnterior,
													saldoMedioDiciembre, codigoTerritorio,
													porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
													historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
													prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
													ajustePspto, desvPsptoAjustado, factAjustTerritorial,
													factAsignGteOf);
											
										}
									//}
								}
									anhoBus="2007";
									osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
									if(osc==null){
										
									logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
										
									}
										if(osc!=null){
											for(int i=0; i<osc.size(); i++)
											{
												beanTPlanes=(TPlanes)osc.elementAt(i);
												
												codigoOficina=beanTPlanes.getCodigoOficina();
												mes=beanTPlanes.getMes();
												anho=beanTPlanes.getAnho();
												codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
												nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
												pesodor=beanTPlanes.getPesodor();
												monto=beanTPlanes.getMonto();
												porcAlcanzado=beanTPlanes.getPorcAlcanzado();
												desvpPto=beanTPlanes.getDesvpPto();
												nroMesesFalt=beanTPlanes.getNroMesesFalt();
												proyCrecMensual=beanTPlanes.getProyCrecMensual();
												ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
												proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
												saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
												porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
												saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
												saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
												codigoTerritorio=beanTPlanes.getCodigoTerritorio();
												porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
												factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
												historicoBajas=beanTPlanes.getHistoricoBajas();
												metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
												metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
												prioridadPlanes=beanTPlanes.getPrioridad();
												mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
												indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
												varMes=beanTPlanes.getVarMes();
												ajustePspto=beanTPlanes.getAjustePspto();
												desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
												factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
												factAsignGteOf=beanTPlanes.getFactAsignGteOf();
												
												indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
														codigoEpigrafe, nombreEpigrafe, pesodor, monto,
														porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
														ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
														porcSaldoMedioJunio, saldoDiciembreAnterior,
														saldoMedioDiciembre, codigoTerritorio,
														porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
														historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
														prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
														ajustePspto, desvPsptoAjustado, factAjustTerritorial,
														factAsignGteOf);
												
											}
										//}
									}
										anhoBus="2008";
										osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
										if(osc==null){
											
										logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
											
										}
											if(osc!=null){
												for(int i=0; i<osc.size(); i++)
												{
													beanTPlanes=(TPlanes)osc.elementAt(i);
													
													codigoOficina=beanTPlanes.getCodigoOficina();
													mes=beanTPlanes.getMes();
													anho=beanTPlanes.getAnho();
													codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
													nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
													pesodor=beanTPlanes.getPesodor();
													monto=beanTPlanes.getMonto();
													porcAlcanzado=beanTPlanes.getPorcAlcanzado();
													desvpPto=beanTPlanes.getDesvpPto();
													nroMesesFalt=beanTPlanes.getNroMesesFalt();
													proyCrecMensual=beanTPlanes.getProyCrecMensual();
													ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
													proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
													saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
													porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
													saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
													saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
													codigoTerritorio=beanTPlanes.getCodigoTerritorio();
													porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
													factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
													historicoBajas=beanTPlanes.getHistoricoBajas();
													metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
													metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
													prioridadPlanes=beanTPlanes.getPrioridad();
													mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
													indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
													varMes=beanTPlanes.getVarMes();
													ajustePspto=beanTPlanes.getAjustePspto();
													desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
													factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
													factAsignGteOf=beanTPlanes.getFactAsignGteOf();
													
													indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
															codigoEpigrafe, nombreEpigrafe, pesodor, monto,
															porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
															ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
															porcSaldoMedioJunio, saldoDiciembreAnterior,
															saldoMedioDiciembre, codigoTerritorio,
															porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
															historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
															prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
															ajustePspto, desvPsptoAjustado, factAjustTerritorial,
															factAsignGteOf);
													
												}
											//}
										}
											anhoBus="2009";
											osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
											if(osc==null){
												
											logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
												
											}
												if(osc!=null){
													for(int i=0; i<osc.size(); i++)
													{
														beanTPlanes=(TPlanes)osc.elementAt(i);
														
														codigoOficina=beanTPlanes.getCodigoOficina();
														mes=beanTPlanes.getMes();
														anho=beanTPlanes.getAnho();
														codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
														nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
														pesodor=beanTPlanes.getPesodor();
														monto=beanTPlanes.getMonto();
														porcAlcanzado=beanTPlanes.getPorcAlcanzado();
														desvpPto=beanTPlanes.getDesvpPto();
														nroMesesFalt=beanTPlanes.getNroMesesFalt();
														proyCrecMensual=beanTPlanes.getProyCrecMensual();
														ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
														proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
														saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
														porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
														saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
														saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
														codigoTerritorio=beanTPlanes.getCodigoTerritorio();
														porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
														factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
														historicoBajas=beanTPlanes.getHistoricoBajas();
														metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
														metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
														prioridadPlanes=beanTPlanes.getPrioridad();
														mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
														indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
														varMes=beanTPlanes.getVarMes();
														ajustePspto=beanTPlanes.getAjustePspto();
														desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
														factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
														factAsignGteOf=beanTPlanes.getFactAsignGteOf();
														
														indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																porcSaldoMedioJunio, saldoDiciembreAnterior,
																saldoMedioDiciembre, codigoTerritorio,
																porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																factAsignGteOf);
														
													}
												//}
											}
	}
		public void migracion5Planes12 (){
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			Connection ejb = new Connection();	
			
			TPlanes beanTPlanes=null;			

		/*PLANES*/

		String codigoOficina;
		String mes;
		String anho;
		String codigoEpigrafe;
		String nombreEpigrafe;
		int pesodor;
		int monto;
		int porcAlcanzado;
		int desvpPto;
		int nroMesesFalt;
		int proyCrecMensual;
		int ajusteEstimadoTerr;
		int proyAjusteMensual;
		int saldoMedioJunio;
		int porcSaldoMedioJunio;
		int saldoDiciembreAnterior;
		int saldoMedioDiciembre;
		String codigoTerritorio;
		int porcSaldoMedioDiciembre;
		int factorAjusteSaldoPuntual;
		int historicoBajas;
		int metaMesSaldoPuntual;
		int metaGerenteOficina;
		int prioridadPlanes;
		String mesEvaluacion;
		String indicadorDor;
		int varMes;
		int ajustePspto;
		int desvPsptoAjustado;
		int factAjustTerritorial;
		int factAsignGteOf;
		int contMes=0;
		String sMensaje;
		String contadorMes="12";
		int indicador=0;
		int contador=0;
		Vector osc=null;
		String anhoBus="";
		
		/*for(contMes=1;contMes<3;contMes++){
			if(contMes<10){
				contadorMes="0"+String.valueOf(contMes);
			}else{
				contadorMes=String.valueOf(contMes);
			}*/
		anhoBus="2005";
		osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
		if(osc==null){
			
		logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
			
		}
			if(osc!=null){
				for(int i=0; i<osc.size(); i++)
				{
					beanTPlanes=(TPlanes)osc.elementAt(i);
					
					codigoOficina=beanTPlanes.getCodigoOficina();
					mes=beanTPlanes.getMes();
					anho=beanTPlanes.getAnho();
					codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
					nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
					pesodor=beanTPlanes.getPesodor();
					monto=beanTPlanes.getMonto();
					porcAlcanzado=beanTPlanes.getPorcAlcanzado();
					desvpPto=beanTPlanes.getDesvpPto();
					nroMesesFalt=beanTPlanes.getNroMesesFalt();
					proyCrecMensual=beanTPlanes.getProyCrecMensual();
					ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
					proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
					saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
					porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
					saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
					saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
					codigoTerritorio=beanTPlanes.getCodigoTerritorio();
					porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
					factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
					historicoBajas=beanTPlanes.getHistoricoBajas();
					metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
					metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
					prioridadPlanes=beanTPlanes.getPrioridad();
					mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
					indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
					varMes=beanTPlanes.getVarMes();
					ajustePspto=beanTPlanes.getAjustePspto();
					desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
					factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
					factAsignGteOf=beanTPlanes.getFactAsignGteOf();
					
					indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
							codigoEpigrafe, nombreEpigrafe, pesodor, monto,
							porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
							ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
							porcSaldoMedioJunio, saldoDiciembreAnterior,
							saldoMedioDiciembre, codigoTerritorio,
							porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
							historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
							prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
							ajustePspto, desvPsptoAjustado, factAjustTerritorial,
							factAsignGteOf);
					
				}
			//}
		}
			anhoBus="2006";
			osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
			if(osc==null){
				
			logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
				
			}
				if(osc!=null){
					for(int i=0; i<osc.size(); i++)
					{
						beanTPlanes=(TPlanes)osc.elementAt(i);
						
						codigoOficina=beanTPlanes.getCodigoOficina();
						mes=beanTPlanes.getMes();
						anho=beanTPlanes.getAnho();
						codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
						nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
						pesodor=beanTPlanes.getPesodor();
						monto=beanTPlanes.getMonto();
						porcAlcanzado=beanTPlanes.getPorcAlcanzado();
						desvpPto=beanTPlanes.getDesvpPto();
						nroMesesFalt=beanTPlanes.getNroMesesFalt();
						proyCrecMensual=beanTPlanes.getProyCrecMensual();
						ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
						proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
						saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
						porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
						saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
						saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
						codigoTerritorio=beanTPlanes.getCodigoTerritorio();
						porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
						factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
						historicoBajas=beanTPlanes.getHistoricoBajas();
						metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
						metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
						prioridadPlanes=beanTPlanes.getPrioridad();
						mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
						indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
						varMes=beanTPlanes.getVarMes();
						ajustePspto=beanTPlanes.getAjustePspto();
						desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
						factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
						factAsignGteOf=beanTPlanes.getFactAsignGteOf();
						
						indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
								codigoEpigrafe, nombreEpigrafe, pesodor, monto,
								porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
								ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
								porcSaldoMedioJunio, saldoDiciembreAnterior,
								saldoMedioDiciembre, codigoTerritorio,
								porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
								historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
								prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
								ajustePspto, desvPsptoAjustado, factAjustTerritorial,
								factAsignGteOf);
						
					}
				//}
			}
				anhoBus="2007";
				osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
				if(osc==null){
					
				logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
					
				}
					if(osc!=null){
						for(int i=0; i<osc.size(); i++)
						{
							beanTPlanes=(TPlanes)osc.elementAt(i);
							
							codigoOficina=beanTPlanes.getCodigoOficina();
							mes=beanTPlanes.getMes();
							anho=beanTPlanes.getAnho();
							codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
							nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
							pesodor=beanTPlanes.getPesodor();
							monto=beanTPlanes.getMonto();
							porcAlcanzado=beanTPlanes.getPorcAlcanzado();
							desvpPto=beanTPlanes.getDesvpPto();
							nroMesesFalt=beanTPlanes.getNroMesesFalt();
							proyCrecMensual=beanTPlanes.getProyCrecMensual();
							ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
							proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
							saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
							porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
							saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
							saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
							codigoTerritorio=beanTPlanes.getCodigoTerritorio();
							porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
							factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
							historicoBajas=beanTPlanes.getHistoricoBajas();
							metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
							metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
							prioridadPlanes=beanTPlanes.getPrioridad();
							mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
							indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
							varMes=beanTPlanes.getVarMes();
							ajustePspto=beanTPlanes.getAjustePspto();
							desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
							factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
							factAsignGteOf=beanTPlanes.getFactAsignGteOf();
							
							indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
									codigoEpigrafe, nombreEpigrafe, pesodor, monto,
									porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
									ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
									porcSaldoMedioJunio, saldoDiciembreAnterior,
									saldoMedioDiciembre, codigoTerritorio,
									porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
									historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
									prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
									ajustePspto, desvPsptoAjustado, factAjustTerritorial,
									factAsignGteOf);
							
						}
					//}
				}
					anhoBus="2008";
					osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
					if(osc==null){
						
					logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
						
					}
						if(osc!=null){
							for(int i=0; i<osc.size(); i++)
							{
								beanTPlanes=(TPlanes)osc.elementAt(i);
								
								codigoOficina=beanTPlanes.getCodigoOficina();
								mes=beanTPlanes.getMes();
								anho=beanTPlanes.getAnho();
								codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
								nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
								pesodor=beanTPlanes.getPesodor();
								monto=beanTPlanes.getMonto();
								porcAlcanzado=beanTPlanes.getPorcAlcanzado();
								desvpPto=beanTPlanes.getDesvpPto();
								nroMesesFalt=beanTPlanes.getNroMesesFalt();
								proyCrecMensual=beanTPlanes.getProyCrecMensual();
								ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
								proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
								saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
								porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
								saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
								saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
								codigoTerritorio=beanTPlanes.getCodigoTerritorio();
								porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
								factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
								historicoBajas=beanTPlanes.getHistoricoBajas();
								metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
								metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
								prioridadPlanes=beanTPlanes.getPrioridad();
								mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
								indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
								varMes=beanTPlanes.getVarMes();
								ajustePspto=beanTPlanes.getAjustePspto();
								desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
								factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
								factAsignGteOf=beanTPlanes.getFactAsignGteOf();
								
								indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
										codigoEpigrafe, nombreEpigrafe, pesodor, monto,
										porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
										ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
										porcSaldoMedioJunio, saldoDiciembreAnterior,
										saldoMedioDiciembre, codigoTerritorio,
										porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
										historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
										prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
										ajustePspto, desvPsptoAjustado, factAjustTerritorial,
										factAsignGteOf);
								
							}
						//}
					}
						anhoBus="2009";
						osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"1");
						if(osc==null){
							
						logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
							
						}
							if(osc!=null){
								for(int i=0; i<osc.size(); i++)
								{
									beanTPlanes=(TPlanes)osc.elementAt(i);
									
									codigoOficina=beanTPlanes.getCodigoOficina();
									mes=beanTPlanes.getMes();
									anho=beanTPlanes.getAnho();
									codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
									nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
									pesodor=beanTPlanes.getPesodor();
									monto=beanTPlanes.getMonto();
									porcAlcanzado=beanTPlanes.getPorcAlcanzado();
									desvpPto=beanTPlanes.getDesvpPto();
									nroMesesFalt=beanTPlanes.getNroMesesFalt();
									proyCrecMensual=beanTPlanes.getProyCrecMensual();
									ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
									proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
									saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
									porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
									saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
									saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
									codigoTerritorio=beanTPlanes.getCodigoTerritorio();
									porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
									factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
									historicoBajas=beanTPlanes.getHistoricoBajas();
									metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
									metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
									prioridadPlanes=beanTPlanes.getPrioridad();
									mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
									indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
									varMes=beanTPlanes.getVarMes();
									ajustePspto=beanTPlanes.getAjustePspto();
									desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
									factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
									factAsignGteOf=beanTPlanes.getFactAsignGteOf();
									
									indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
											codigoEpigrafe, nombreEpigrafe, pesodor, monto,
											porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
											ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
											porcSaldoMedioJunio, saldoDiciembreAnterior,
											saldoMedioDiciembre, codigoTerritorio,
											porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
											historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
											prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
											ajustePspto, desvPsptoAjustado, factAjustTerritorial,
											factAsignGteOf);
									
								}
							//}
						}
							/* SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 * SEGUNDA VUELTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
							 */
							
							anhoBus="2005";
							osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
							if(osc==null){
								
							logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
								
							}
								if(osc!=null){
									for(int i=0; i<osc.size(); i++)
									{
										beanTPlanes=(TPlanes)osc.elementAt(i);
										
										codigoOficina=beanTPlanes.getCodigoOficina();
										mes=beanTPlanes.getMes();
										anho=beanTPlanes.getAnho();
										codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
										nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
										pesodor=beanTPlanes.getPesodor();
										monto=beanTPlanes.getMonto();
										porcAlcanzado=beanTPlanes.getPorcAlcanzado();
										desvpPto=beanTPlanes.getDesvpPto();
										nroMesesFalt=beanTPlanes.getNroMesesFalt();
										proyCrecMensual=beanTPlanes.getProyCrecMensual();
										ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
										proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
										saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
										porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
										saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
										saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
										codigoTerritorio=beanTPlanes.getCodigoTerritorio();
										porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
										factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
										historicoBajas=beanTPlanes.getHistoricoBajas();
										metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
										metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
										prioridadPlanes=beanTPlanes.getPrioridad();
										mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
										indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
										varMes=beanTPlanes.getVarMes();
										ajustePspto=beanTPlanes.getAjustePspto();
										desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
										factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
										factAsignGteOf=beanTPlanes.getFactAsignGteOf();
										
										indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
												codigoEpigrafe, nombreEpigrafe, pesodor, monto,
												porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
												ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
												porcSaldoMedioJunio, saldoDiciembreAnterior,
												saldoMedioDiciembre, codigoTerritorio,
												porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
												historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
												prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
												ajustePspto, desvPsptoAjustado, factAjustTerritorial,
												factAsignGteOf);
										
									}
								//}
							}
								anhoBus="2006";
								osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
								if(osc==null){
									
								logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
									
								}
									if(osc!=null){
										for(int i=0; i<osc.size(); i++)
										{
											beanTPlanes=(TPlanes)osc.elementAt(i);
											
											codigoOficina=beanTPlanes.getCodigoOficina();
											mes=beanTPlanes.getMes();
											anho=beanTPlanes.getAnho();
											codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
											nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
											pesodor=beanTPlanes.getPesodor();
											monto=beanTPlanes.getMonto();
											porcAlcanzado=beanTPlanes.getPorcAlcanzado();
											desvpPto=beanTPlanes.getDesvpPto();
											nroMesesFalt=beanTPlanes.getNroMesesFalt();
											proyCrecMensual=beanTPlanes.getProyCrecMensual();
											ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
											proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
											saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
											porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
											saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
											saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
											codigoTerritorio=beanTPlanes.getCodigoTerritorio();
											porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
											factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
											historicoBajas=beanTPlanes.getHistoricoBajas();
											metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
											metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
											prioridadPlanes=beanTPlanes.getPrioridad();
											mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
											indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
											varMes=beanTPlanes.getVarMes();
											ajustePspto=beanTPlanes.getAjustePspto();
											desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
											factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
											factAsignGteOf=beanTPlanes.getFactAsignGteOf();
											
											indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
													codigoEpigrafe, nombreEpigrafe, pesodor, monto,
													porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
													ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
													porcSaldoMedioJunio, saldoDiciembreAnterior,
													saldoMedioDiciembre, codigoTerritorio,
													porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
													historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
													prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
													ajustePspto, desvPsptoAjustado, factAjustTerritorial,
													factAsignGteOf);
											
										}
									//}
								}
									anhoBus="2007";
									osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
									if(osc==null){
										
									logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
										
									}
										if(osc!=null){
											for(int i=0; i<osc.size(); i++)
											{
												beanTPlanes=(TPlanes)osc.elementAt(i);
												
												codigoOficina=beanTPlanes.getCodigoOficina();
												mes=beanTPlanes.getMes();
												anho=beanTPlanes.getAnho();
												codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
												nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
												pesodor=beanTPlanes.getPesodor();
												monto=beanTPlanes.getMonto();
												porcAlcanzado=beanTPlanes.getPorcAlcanzado();
												desvpPto=beanTPlanes.getDesvpPto();
												nroMesesFalt=beanTPlanes.getNroMesesFalt();
												proyCrecMensual=beanTPlanes.getProyCrecMensual();
												ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
												proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
												saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
												porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
												saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
												saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
												codigoTerritorio=beanTPlanes.getCodigoTerritorio();
												porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
												factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
												historicoBajas=beanTPlanes.getHistoricoBajas();
												metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
												metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
												prioridadPlanes=beanTPlanes.getPrioridad();
												mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
												indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
												varMes=beanTPlanes.getVarMes();
												ajustePspto=beanTPlanes.getAjustePspto();
												desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
												factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
												factAsignGteOf=beanTPlanes.getFactAsignGteOf();
												
												indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
														codigoEpigrafe, nombreEpigrafe, pesodor, monto,
														porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
														ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
														porcSaldoMedioJunio, saldoDiciembreAnterior,
														saldoMedioDiciembre, codigoTerritorio,
														porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
														historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
														prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
														ajustePspto, desvPsptoAjustado, factAjustTerritorial,
														factAsignGteOf);
												
											}
										//}
									}
										anhoBus="2008";
										osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
										if(osc==null){
											
										logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
											
										}
											if(osc!=null){
												for(int i=0; i<osc.size(); i++)
												{
													beanTPlanes=(TPlanes)osc.elementAt(i);
													
													codigoOficina=beanTPlanes.getCodigoOficina();
													mes=beanTPlanes.getMes();
													anho=beanTPlanes.getAnho();
													codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
													nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
													pesodor=beanTPlanes.getPesodor();
													monto=beanTPlanes.getMonto();
													porcAlcanzado=beanTPlanes.getPorcAlcanzado();
													desvpPto=beanTPlanes.getDesvpPto();
													nroMesesFalt=beanTPlanes.getNroMesesFalt();
													proyCrecMensual=beanTPlanes.getProyCrecMensual();
													ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
													proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
													saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
													porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
													saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
													saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
													codigoTerritorio=beanTPlanes.getCodigoTerritorio();
													porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
													factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
													historicoBajas=beanTPlanes.getHistoricoBajas();
													metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
													metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
													prioridadPlanes=beanTPlanes.getPrioridad();
													mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
													indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
													varMes=beanTPlanes.getVarMes();
													ajustePspto=beanTPlanes.getAjustePspto();
													desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
													factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
													factAsignGteOf=beanTPlanes.getFactAsignGteOf();
													
													indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
															codigoEpigrafe, nombreEpigrafe, pesodor, monto,
															porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
															ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
															porcSaldoMedioJunio, saldoDiciembreAnterior,
															saldoMedioDiciembre, codigoTerritorio,
															porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
															historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
															prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
															ajustePspto, desvPsptoAjustado, factAjustTerritorial,
															factAsignGteOf);
													
												}
											//}
										}
											anhoBus="2009";
											osc=ejb.xBusAllTablaPlanes(contadorMes, anhoBus+"2");
											if(osc==null){
												
											logger.debug("VECTOR VACIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:       "+ contadorMes);
												
											}
												if(osc!=null){
													for(int i=0; i<osc.size(); i++)
													{
														beanTPlanes=(TPlanes)osc.elementAt(i);
														
														codigoOficina=beanTPlanes.getCodigoOficina();
														mes=beanTPlanes.getMes();
														anho=beanTPlanes.getAnho();
														codigoEpigrafe=beanTPlanes.getCodigoEpigrafe();
														nombreEpigrafe=beanTPlanes.getNombreEpigrafe().trim();
														pesodor=beanTPlanes.getPesodor();
														monto=beanTPlanes.getMonto();
														porcAlcanzado=beanTPlanes.getPorcAlcanzado();
														desvpPto=beanTPlanes.getDesvpPto();
														nroMesesFalt=beanTPlanes.getNroMesesFalt();
														proyCrecMensual=beanTPlanes.getProyCrecMensual();
														ajusteEstimadoTerr=beanTPlanes.getAjusteEstimadoTerr();
														proyAjusteMensual=beanTPlanes.getProyAjusteMensual();
														saldoMedioJunio=beanTPlanes.getSaldoMedioJunio();
														porcSaldoMedioJunio=beanTPlanes.getPorcSaldoMedioJunio();
														saldoDiciembreAnterior=beanTPlanes.getSaldoDiciembreAnterior();
														saldoMedioDiciembre=beanTPlanes.getSaldoMedioDiciembre();
														codigoTerritorio=beanTPlanes.getCodigoTerritorio();
														porcSaldoMedioDiciembre=beanTPlanes.getPorcSaldoMedioDiciembre();
														factorAjusteSaldoPuntual=beanTPlanes.getFactorAjusteSaldoPuntual();
														historicoBajas=beanTPlanes.getHistoricoBajas();
														metaMesSaldoPuntual=beanTPlanes.getMetaMesSaldoPuntual();
														metaGerenteOficina=beanTPlanes.getMetaGerenteOficina();
														prioridadPlanes=beanTPlanes.getPrioridad();
														mesEvaluacion=beanTPlanes.getMesEvaluacion()==null?"0":beanTPlanes.getMesEvaluacion();
														indicadorDor=beanTPlanes.getIndicadorDor()==null?"0":beanTPlanes.getIndicadorDor();
														varMes=beanTPlanes.getVarMes();
														ajustePspto=beanTPlanes.getAjustePspto();
														desvPsptoAjustado=beanTPlanes.getDesvPsptoAjustado();
														factAjustTerritorial=beanTPlanes.getFactAjustTerritorial();
														factAsignGteOf=beanTPlanes.getFactAsignGteOf();
														
														indicador=ejb.xInsertarTPlanes(codigoOficina, mes, anho,
																codigoEpigrafe, nombreEpigrafe, pesodor, monto,
																porcAlcanzado, desvpPto, nroMesesFalt, proyCrecMensual,
																ajusteEstimadoTerr, proyAjusteMensual, saldoMedioJunio,
																porcSaldoMedioJunio, saldoDiciembreAnterior,
																saldoMedioDiciembre, codigoTerritorio,
																porcSaldoMedioDiciembre, factorAjusteSaldoPuntual,
																historicoBajas, metaMesSaldoPuntual, metaGerenteOficina,
																prioridadPlanes, mesEvaluacion, indicadorDor, varMes,
																ajustePspto, desvPsptoAjustado, factAjustTerritorial,
																factAsignGteOf);
														
													}
												//}
											}

	}	
}
