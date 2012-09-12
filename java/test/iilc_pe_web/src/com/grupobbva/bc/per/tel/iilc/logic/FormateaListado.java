/*
 * @author: Maria Paula Tomaylla
 * codigo : P020795
 * fecha  : 29/11/2007
 */
package com.grupobbva.bc.per.tel.iilc.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionEJB;
import com.grupobbva.bc.per.tel.iilc.conexionEJB.Connection;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;
import com.grupobbva.bc.per.tel.iilc.serializable.Total;

/**
 * @author: Maria Paula Tomaylla
 * codigo : P020795
 * fecha  : 29/11/2007
 */
public class FormateaListado {

	private Logger logger = Logger.getLogger(FormateaListado.class);
    private String cod_perfil;
    private String cod_gestor_log;
    private String cod_territorio;
    private String cod_oficina;
    private String cod_gestor;
    private String nivel_vinculacion;
    private String clasificacion;
    private String margen_ordinario;
    private String etiqueta;
    private String edad;
    private String porcrie;
    private String cod_empresa;
    private String tipo_cliente;
    private String cod_cliente;
    private String col_orden ;
    private int num_registros;
    private int num_registros_x_pag;
    private int num_paginas;
    private Cliente totalFiltro;
    private Total totalPerfil;
    private String label;
    private int tipoOpcion; 
    private boolean exportacion;
    
    public FormateaListado(String cod_perfil, String cod_gestor_log, String cod_territorio, String cod_oficina, String cod_gestor, String nivel_vinculacion, String clasificacion, String margen_ordinario, String etiqueta, String edad, String cuota_riesgo_total, String cod_empresa, String tipo_cliente, String cod_cliente, String col_orden, int num_registros_x_pag, int tipoOpcion){
        if (cod_territorio.trim().equals(""))
			this.cod_territorio = "-1";
		else
			this.cod_territorio = cod_territorio;
		
		if (cod_oficina.trim().equals(""))
			this.cod_oficina = "-1";
		else
			this.cod_oficina = cod_oficina;
		
		if (cod_gestor==null || cod_gestor.trim().equals(""))
			this.cod_gestor = "-1";
		else
			this.cod_gestor = cod_gestor;
		
		if (nivel_vinculacion==null||nivel_vinculacion.trim().equals(""))
			this.nivel_vinculacion = "-1";
		else
			this.nivel_vinculacion = nivel_vinculacion;
		
		if (clasificacion.trim().equals(""))
			this.clasificacion = "-1";
		else
			this.clasificacion = clasificacion;
		
		if (margen_ordinario.trim().equals(""))
		    this.margen_ordinario = "-1";
		else
			this.margen_ordinario = margen_ordinario;
		
		if (etiqueta.trim().equals(""))
			this.etiqueta = "-1";
		else
			this.etiqueta = etiqueta;
		
		if (edad.trim().equals(""))
		    this.edad = "-1";
		else
		    this.edad = edad;
		
		if (cuota_riesgo_total.trim().equals(""))
		    this.porcrie = "-1";
		else
		    this.porcrie = cuota_riesgo_total;
		
		if (cod_empresa==null||cod_empresa.trim().equals(""))
			this.cod_empresa = "-1";
		else
			this.cod_empresa = cod_empresa;
		
		this.cod_perfil = cod_perfil;
		this.cod_gestor_log = cod_gestor_log;
		
		if (tipo_cliente==null || tipo_cliente.trim().equals(""))
			this.tipo_cliente = "-1";
		else
			this.tipo_cliente = tipo_cliente;
		
		if (cod_cliente==null || cod_cliente.trim().equals(""))
			this.cod_cliente = "-1";
		else
			this.cod_cliente = cod_cliente;
		
		this.col_orden = col_orden;
		this.tipoOpcion = tipoOpcion;
		this.num_registros_x_pag = num_registros_x_pag;
		this.totalPerfil = calculaTotalxPerfil();
		
		exportacion = false;
    }
    
    public  Cliente calculaTotalxFiltro(){
        Cliente total = new Cliente();
        ConexionEJB ejb = new ConexionEJB();
		try {
			total = ejb.findTotalClientebyFilter(cod_territorio, cod_oficina, cod_gestor, nivel_vinculacion, clasificacion, margen_ordinario, etiqueta, edad, porcrie, cod_empresa, tipo_cliente, cod_cliente, tipoOpcion);
		} catch (Exception e) {
			logger.error("Error calculo de totales");
			logger.error(e);
		}

		return total;
	}
    
    private  Total calculaTotalxPerfil(){
        Total total = new Total();
        Connection conexion = new Connection();
        
        logger.info("Perfil: " + cod_perfil.substring(2,4));
        
        try {
            switch (Integer.parseInt(cod_perfil.substring(2,4))){
	            case 4:
	                label = Constantes.LBL_TOTALES_GESTOR;
	                total = conexion.findTotal("G", cod_territorio, cod_oficina, cod_gestor_log);
	                
	                if (this.nivel_vinculacion.equals("-1") 
	                		&& this.clasificacion.equals("-1") 
	                		&& this.margen_ordinario.equals("-1") 
	                		&& this.etiqueta.equals("-1") 
	                		&& this.edad.equals("-1") 
	                		&& this.porcrie.equals("-1") 
	                		&& this.cod_empresa.equals("-1")
	                		&& this.tipo_cliente.equals("-1")
	                		&& this.cod_cliente.equals("-1")){
                		if (this.cod_gestor.equals("-1")){
                			this.totalFiltro = null;
	                		num_registros = conexion.countClientebyOficina(this.cod_territorio,this.cod_oficina, this.tipoOpcion);
	                	}else{
	                		this.totalFiltro = copiarTotal(conexion.findTotal("G", cod_territorio, cod_oficina, cod_gestor),"TOTALES FILTRO");
	                		num_registros = conexion.countClientebyGestor(this.cod_territorio,this.cod_oficina, this.cod_gestor, this.tipoOpcion);
	                	}
                    }else{
                    	this.totalFiltro = calculaTotalxFiltro();
                    	num_registros = Integer.parseInt(totalFiltro.getCodigo().trim());
                    	totalFiltro.setCodigo("TOTALES FILTRO");
                    }
	                
	                break;
	            case 3:
	                label = Constantes.LBL_TOTALES_OFICINA;
	                total = conexion.findTotal("O", cod_territorio, cod_oficina, " ");
	                if (this.nivel_vinculacion.equals("-1") 
	                		&& this.clasificacion.equals("-1") 
	                		&& this.margen_ordinario.equals("-1") 
	                		&& this.etiqueta.equals("-1") 
	                		&& this.edad.equals("-1") 
	                		&& this.porcrie.equals("-1") 
	                		&& this.cod_empresa.equals("-1")
	                		&& this.tipo_cliente.equals("-1")
	                		&& this.cod_cliente.equals("-1")){
                		if (this.cod_gestor.equals("-1")){
	                		this.totalFiltro = null;
	                		num_registros = conexion.countClientebyOficina(this.cod_territorio,this.cod_oficina, this.tipoOpcion);
	                	}else{
	                		this.totalFiltro = copiarTotal(conexion.findTotal("G", cod_territorio, cod_oficina, cod_gestor),"TOTALES GESTOR");
	                		num_registros = conexion.countClientebyGestor(this.cod_territorio,this.cod_oficina, this.cod_gestor, this.tipoOpcion);
	                	}
                    }else{
                    	this.totalFiltro = calculaTotalxFiltro();
                    	num_registros = Integer.parseInt(totalFiltro.getCodigo().trim());
                    	totalFiltro.setCodigo("TOTALES FILTRO");
                    }
	                break;
	            case 2:
	                label = Constantes.LBL_TOTALES_TERRITORIO;	                
	                total = conexion.findTotal("T", cod_territorio, " ", " ");
	                
	                if (this.nivel_vinculacion.equals("-1") 
	                		&& this.clasificacion.equals("-1") 
	                		&& this.margen_ordinario.equals("-1") 
	                		&& this.etiqueta.equals("-1") 
	                		&& this.edad.equals("-1") 
	                		&& this.porcrie.equals("-1") 
	                		&& this.cod_empresa.equals("-1")
	                		&& this.tipo_cliente.equals("-1")
	                		&& this.cod_cliente.equals("-1")){
                		if (this.cod_oficina.equals("-1")){
	                		this.totalFiltro = null;
	                		num_registros = conexion.countClientebyTerritorio(this.cod_territorio, this.tipoOpcion);
	                	}else{
	                		if (this.cod_gestor.equals("-1")){
		                		this.totalFiltro = copiarTotal(conexion.findTotal("O", cod_territorio, cod_oficina, " "),"TOTALES OFICINA");
		                		num_registros = conexion.countClientebyOficina(this.cod_territorio,this.cod_oficina, this.tipoOpcion);
		                	}else{
		                		this.totalFiltro = copiarTotal(conexion.findTotal("G", cod_territorio, cod_oficina, cod_gestor),"TOTALES GESTOR");
		                		num_registros = conexion.countClientebyGestor(this.cod_territorio,this.cod_oficina, this.cod_gestor, this.tipoOpcion);
		                	}
	                	}
                    }else{
                    	this.totalFiltro = calculaTotalxFiltro();
                    	num_registros = Integer.parseInt(totalFiltro.getCodigo().trim());
                    	totalFiltro.setCodigo("TOTALES FILTRO");
                    }
	                break;
	            case 6:
	                label = Constantes.LBL_TOTALES_BANCO;
	                total = conexion.findTotal("T", "%", " ", " ");
	            	
	                if (this.nivel_vinculacion.equals("-1") 
	                		&& this.clasificacion.equals("-1") 
	                		&& this.margen_ordinario.equals("-1") 
	                		&& this.etiqueta.equals("-1") 
	                		&& this.edad.equals("-1") 
	                		&& this.porcrie.equals("-1") 
	                		&& this.cod_empresa.equals("-1")
	                		&& this.tipo_cliente.equals("-1")
	                		&& this.cod_cliente.equals("-1")){
                		if (this.cod_gestor.equals("-1")){
                			this.totalFiltro = null;
	                		num_registros = conexion.countClientebyOficina(this.cod_territorio,this.cod_oficina, this.tipoOpcion);
	                	}else{
	                		num_registros = conexion.countClientebyGestor(this.cod_territorio,this.cod_oficina, this.cod_gestor, this.tipoOpcion);
	                	}
                    }else{
                    	this.totalFiltro = calculaTotalxFiltro();
                    	num_registros = Integer.parseInt(totalFiltro.getCodigo().trim());
                    	totalFiltro.setCodigo("TOTALES FILTRO");
                    }
	                
	                break;
	            case 1:
	                label = Constantes.LBL_TOTALES_BANCO;
	                total = conexion.findTotal("T", "%", " ", " ");
	                
	                if (this.nivel_vinculacion.equals("-1") 
	                		&& this.clasificacion.equals("-1") 
	                		&& this.margen_ordinario.equals("-1") 
	                		&& this.etiqueta.equals("-1") 
	                		&& this.edad.equals("-1") 
	                		&& this.porcrie.equals("-1") 
	                		&& this.cod_empresa.equals("-1")
	                		&& this.tipo_cliente.equals("-1")
	                		&& this.cod_cliente.equals("-1")){
	                	if (this.cod_territorio.equals("-1")){
	                		this.totalFiltro = null;
	                		num_registros = conexion.countCliente(this.tipoOpcion);
	                	}else{
	                		if (this.cod_oficina.equals("-1")){
		                		this.totalFiltro = copiarTotal(conexion.findTotal("T", cod_territorio, " ", " "),"TOTALES TERRITORIO");
		                		num_registros = conexion.countClientebyTerritorio(this.cod_territorio, this.tipoOpcion);
		                	}else{
		                		if (this.cod_gestor.equals("-1")){
			                		this.totalFiltro = copiarTotal(conexion.findTotal("O", cod_territorio, cod_oficina, " "),"TOTALES OFICINA");
			                		num_registros = conexion.countClientebyOficina(this.cod_territorio,this.cod_oficina, this.tipoOpcion);
			                	}else{
			                		this.totalFiltro = copiarTotal(conexion.findTotal("G", cod_territorio, cod_oficina, cod_gestor),"TOTALES GESTOR");
			                		num_registros = conexion.countClientebyGestor(this.cod_territorio,this.cod_oficina, this.cod_gestor, this.tipoOpcion);
			                	}
		                	}
	                	}
                    }else{
                    	this.totalFiltro = calculaTotalxFiltro();
                    	num_registros = Integer.parseInt(totalFiltro.getCodigo().trim());
                    	totalFiltro.setCodigo("TOTALES FILTRO");
                    }
            		break;
            }
            // num_paginas = num_registros / Constantes.TOT_REGXPAG;
    		// if ((Constantes.TOT_REGXPAG * num_paginas) < num_registros) num_paginas++;
            // TODO Revisar paginacion
            num_paginas = num_registros / num_registros_x_pag;
            if ((num_registros_x_pag * num_paginas) < num_registros) num_paginas++;
            
		} catch (Exception e) {
			logger.error("Error calculo de totales");
			logger.error(e);
		}

		return total;
	}

    public Vector<Cliente> obtenerListadoAll(boolean pestanaTodos, int maxResult) {
        Vector<Cliente> listadoConduccion = new Vector<Cliente>(); 
        ConexionEJB ejb = new ConexionEJB();
        try {
        	int xreg = -1;
        	if(getNum_registros() > maxResult) {
        		xreg = maxResult;
        	}
		    
        	listadoConduccion = ejb.findAllClientebyFilter(-1, xreg, cod_territorio, cod_oficina, cod_gestor, nivel_vinculacion, clasificacion, margen_ordinario, etiqueta, edad, porcrie, cod_empresa, tipo_cliente, cod_cliente, col_orden, pestanaTodos, tipoOpcion);
			 
		    if (listadoConduccion == null || listadoConduccion.size() == 0) {
		    	return null;
		    }
		    
	    	if (totalFiltro!= null){
	    		listadoConduccion.add(totalFiltro);
	    	}
	    	listadoConduccion.add(copiarTotal(totalPerfil, label));
		} catch (Exception e) {
		    logger.error("obtenerListadoAll", e);
		}

		return listadoConduccion;
	}
    
    public Vector<Cliente> obtenerListado(int pagina, boolean pestanaTodos) {
        Vector<Cliente> listadoConduccion = new Vector<Cliente>(); 
        ConexionEJB ejb = new ConexionEJB();
        try {
		    // int pos_ini = pagina * Constantes.TOT_REGXPAG - Constantes.TOT_REGXPAG + 1;
		    // int pos_fin = pagina * Constantes.TOT_REGXPAG;
        	int pos_ini = pagina * num_registros_x_pag - num_registros_x_pag + 1;
        	int pos_fin = pagina * num_registros_x_pag;
        	
    		if(this.num_registros_x_pag > 0) {
    			num_paginas = num_registros / num_registros_x_pag;
    			if ((num_registros_x_pag * num_paginas) < num_registros) num_paginas++;
    			if (num_paginas == 0) num_paginas++; 
    		}
        	
		    // TODO Modificado, posibles errores hay que tener en cuenta este punto
		    listadoConduccion = ejb.findAllClientebyFilter(pos_ini, pos_fin, cod_territorio, cod_oficina, cod_gestor, nivel_vinculacion, clasificacion, margen_ordinario, etiqueta, edad, porcrie, cod_empresa, tipo_cliente, cod_cliente, col_orden, pestanaTodos, tipoOpcion);
			 
		    if (listadoConduccion==null || listadoConduccion.size() == 0) return null;
		    
		    if (!isExportacion()){
		    	if (totalFiltro!= null){
		    		listadoConduccion.add(totalFiltro);
		    	}
		    	listadoConduccion.add(copiarTotal(totalPerfil, label));
		    }else if (pagina == num_paginas){
		    	if (totalFiltro!= null){
		    		listadoConduccion.add(totalFiltro);
		    	}
		    	listadoConduccion.add(copiarTotal(totalPerfil, label));
	    	}
		} catch (Exception e) {
		    logger.error(e);
		}

		return listadoConduccion;

	}
    
    public List<Multitabla> obtenerCabecera(String codigo) {
        List<Multitabla> lista = new ArrayList<Multitabla>(); 
        ConexionEJB ejb = new ConexionEJB();
        try {
        	lista = ejb.findAllCabeceras(codigo);
		} catch (Exception e) {
		    logger.error(e);
		}

		return lista;
	}
    
    private  Cliente copiarTotal(Total total, String label){
        Cliente cliente = new Cliente();
        cliente.setCodigo(label);
        cliente.setT_act_ct2(total.getSum_act_ct2());     
        cliente.setT_act_ct3(total.getSum_act_ct3());     
        cliente.setT_act_ct4(total.getSum_act_ct4());     
        cliente.setT_act_ct5(total.getSum_act_ct5());     
        // cliente.setT_act_ct6(String.valueOf(total.getSum_act_ct6()));     
        cliente.setT_act_ct6("");

        cliente.setBcorid(total.getRiesgo_d_t());         
        cliente.setBcorii(total.getRiesgo_i_t());         
        cliente.setBcorie(total.getRiesgo_t());         
        cliente.setBcopas(total.getPasivo_t());         
        cliente.setBcovol(total.getVolumen_t());         

        cliente.setPper(total.getPper_t());      
        cliente.setPaut(total.getPaut_t());      
        cliente.setPhip(total.getPhip_t());      
        cliente.setPmiv(total.getPmiv_t());      
        cliente.setCpte(total.getCpte_t());      
        cliente.setPmas(total.getPmas_t());      
        cliente.setPcom(total.getPcom_t());      
        cliente.setDsct(total.getDsct_t());      
        cliente.setLeas(total.getLeas_t());      
        cliente.setCloc(total.getCloc_t());      
        cliente.setPref(total.getPref_t());      
        cliente.setLcta(total.getLcta_t());      
        cliente.setProm(total.getProm_t());      
        cliente.setFcex(total.getFcex_t());      
        cliente.setAval(total.getAval_t());      
        cliente.setT_act2(total.getSum_t_act2());

        cliente.setVnac(total.getVnac_t());      
        cliente.setVarc(total.getVarc_t());      
        cliente.setVcla(total.getVcla_t());      
        cliente.setVrep(total.getVrep_t());      
        cliente.setVoro(total.getVoro_t());      
        cliente.setVpla(total.getVpla_t());      
        cliente.setVemp(total.getVemp_t());      
        cliente.setVctr(total.getVctr_t());      
        cliente.setMcla(total.getMcla_t());      
        cliente.setMoro(total.getMoro_t());      
        cliente.setT_act3(total.getSum_t_act3());   
        
        cliente.setCcte(total.getCcte_t());        
        cliente.setCemp(String.valueOf(total.getCemp_t()));        
        cliente.setCvip(total.getCvip_t());        
        cliente.setAhsd(total.getAhsd_t());        
        cliente.setAhor(total.getAhor_t());        
        cliente.setPlzo(total.getPlzo_t());        
        cliente.setSdep(total.getSdep_t());        
        cliente.setFmut(total.getFmut_t());        
        cliente.setCts(total.getCts_t());          
        cliente.setCtsd(total.getCtsd_t());        
        cliente.setT_act4(total.getSum_t_act4());  

        cliente.setColb(total.getColb_t());        
        cliente.setCext(total.getCext_t());        
        cliente.setSvid(total.getSvid_t());        
        cliente.setSonc(total.getSonc_t());        
        cliente.setSpro(total.getSpro_t());        
        cliente.setPserv(total.getPserv_t());      
        cliente.setPh(total.getPh_t());            
        cliente.setEmph(total.getEmph_t());        
        cliente.setTdeb(total.getTdeb_t());        
        cliente.setTvip(total.getTvip_t());        
        cliente.setT_act5(total.getSum_t_act5());  

        /*
        cliente.setCnet(String.valueOf(total.getCnet_t()));      
        cliente.setCemp(String.valueOf(total.getCemp_t()));      
        cliente.setLinco(String.valueOf(total.getLinco_t()));    
        cliente.setB24(String.valueOf(total.getB24_t()));        
        cliente.setPos(String.valueOf(total.getPos_t()));
        */
        
        cliente.setCnet("");      
        cliente.setCemp("");      
        cliente.setLinco("");    
        cliente.setB24("");        
        cliente.setPos("");
        
        cliente.setT_act6(total.getSum_t_act6());
        
        // Nuevos campos totalizadores
        cliente.setMofactv(total.getMofactv_t());
        cliente.setCs000lineamaxtc(total.getCs000lineamaxtc_t());
        cliente.setCs000mtoprestamo(total.getCs000mtoprestamo_t());
        cliente.setMontovehicular(total.getMontovehicular_t());
        cliente.setMontohipotecario(total.getMontohipotecario_t());
        cliente.setMontosubrogados(total.getMontosubrogados_t());

        // Campos oferta vacios (varchars->null, number->0)
        cliente.setTconsactv(new BigDecimal("0"));
        cliente.setTsubactv(new BigDecimal("0"));
        cliente.setThipotactv(new BigDecimal("0"));
        cliente.setTvehicactv(new BigDecimal("0"));
        //cliente.setCs000montocta36(new BigDecimal("0"));
        cliente.setTcuot36act(new BigDecimal("0"));
        //cliente.setCs000montocta48(new BigDecimal("0"));
        cliente.setTcuot48act(new BigDecimal("0"));
        cliente.setCs000montocta60(new BigDecimal("0"));
        cliente.setTcuot60act(new BigDecimal("0"));
        cliente.setCs000presmena5000(new BigDecimal("0"));
        cliente.setCs000comisdesemen5000(new BigDecimal("0"));
        cliente.setCs000pres5000a15000(new BigDecimal("0"));
        cliente.setC5000comdes15000act(new BigDecimal("0"));
        cliente.setCs000presmaya15000(new BigDecimal("0"));
        cliente.setComdes15000ac(new BigDecimal("0"));
        /*cliente.setCs000linminadqtc(new BigDecimal("0"));
        cliente.setCs000mixmonprest(new BigDecimal("0"));
        cliente.setCs000mixlinasistc(new BigDecimal("0"));*/
        cliente.setCs000prestcmena5000(new BigDecimal("0"));
        cliente.setCs000prestc500015000(new BigDecimal("0"));
        cliente.setCs000prestcmaya15000(new BigDecimal("0"));
        
        return cliente;
    }
    /**
     * @return Returns the clasificacion.
     */
    public String getClasificacion() {
        return clasificacion;
    }
    /**
     * @param clasificacion The clasificacion to set.
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    /**
     * @return Returns the cod_gestor.
     */
    public String getCod_gestor() {
        return cod_gestor;
    }
    /**
     * @param cod_gestor The cod_gestor to set.
     */
    public void setCod_gestor(String cod_gestor) {
        this.cod_gestor = cod_gestor;
    }
    /**
     * @return Returns the cod_oficina.
     */
    public String getCod_oficina() {
        return cod_oficina;
    }
    /**
     * @param cod_oficina The cod_oficina to set.
     */
    public void setCod_oficina(String cod_oficina) {
        this.cod_oficina = cod_oficina;
    }
    /**
     * @return Returns the cod_perfil.
     */
    public String getCod_perfil() {
        return cod_perfil;
    }
    /**
     * @param cod_perfil The cod_perfil to set.
     */
    public void setCod_perfil(String cod_perfil) {
        this.cod_perfil = cod_perfil;
    }
    /**
     * @return Returns the cod_territorio.
     */
    public String getCod_territorio() {
        return cod_territorio;
    }
    /**
     * @param cod_territorio The cod_territorio to set.
     */
    public void setCod_territorio(String cod_territorio) {
        this.cod_territorio = cod_territorio;
    }
    /**
     * @return Returns the etiqueta.
     */
    public String getEtiqueta() {
        return etiqueta;
    }
    /**
     * @param etiqueta The etiqueta to set.
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
	/**
	 * @return Returns the cod_empresa.
	 */
	public String getCod_empresa() {
		return cod_empresa;
	}
	/**
	 * @param cod_empresa The cod_empresa to set.
	 */
	public void setCod_empresa(String cod_empresa) {
		this.cod_empresa = cod_empresa;
	}
	/**
	 * @return Returns the cod_gestor_log.
	 */
	public String getCod_gestor_log() {
		return cod_gestor_log;
	}
	/**
	 * @param cod_gestor_log The cod_gestor_log to set.
	 */
	public void setCod_gestor_log(String cod_gestor_log) {
		this.cod_gestor_log = cod_gestor_log;
	}
	/**
	 * @return Returns the edad.
	 */
	public String getEdad() {
		return edad;
	}
	/**
	 * @param edad The edad to set.
	 */
	public void setEdad(String edad) {
		this.edad = edad;
	}
	/**
	 * @return Returns the label.
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label The label to set.
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return Returns the margen_ordinario.
	 */
	public String getMargen_ordinario() {
		return margen_ordinario;
	}
	/**
	 * @param margen_ordinario The margen_ordinario to set.
	 */
	public void setMargen_ordinario(String margen_ordinario) {
		this.margen_ordinario = margen_ordinario;
	}
	/**
	 * @return Returns the porcrie.
	 */
	public String getPorcrie() {
		return porcrie;
	}
	/**
	 * @param porcrie The porcrie to set.
	 */
	public void setPorcrie(String porcrie) {
		this.porcrie = porcrie;
	}
    /**
     * @return Returns the nivel_vinculacion.
     */
    public String getNivel_vinculacion() {
        return nivel_vinculacion;
    }
    /**
     * @param nivel_vinculacion The nivel_vinculacion to set.
     */
    public void setNivel_vinculacion(String nivel_vinculacion) {
        this.nivel_vinculacion = nivel_vinculacion;
    }
    /**
     * @return Returns the num_paginas.
     */
    public int getNum_paginas() {
        return num_paginas;
    }
    /**
     * @param num_paginas The num_paginas to set.
     */
    public void setNum_paginas(int num_paginas) {
        this.num_paginas = num_paginas;
    }
    /**
     * @return Returns the num_registros.
     */
    public int getNum_registros() {
        return num_registros;
    }
    /**
     * @param num_registros The num_registros to set.
     */
    public void setNum_registros(int num_registros) {
        this.num_registros = num_registros;
    }
    /**
     * @return Returns the totalFiltro.
     */
    public Cliente getTotalFiltro() {
        return totalFiltro;
    }
    /**
     * @param totalFiltro The totalFiltro to set.
     */
    public void setTotalFiltro(Cliente totalFiltro) {
        this.totalFiltro = totalFiltro;
    }
    /**
     * @return Returns the totalPerfil.
     */
    public Total getTotalPerfil() {
        return totalPerfil;
    }
    /**
     * @param totalPerfil The totalPerfil to set.
     */
    public void setTotalPerfil(Total totalPerfil) {
        this.totalPerfil = totalPerfil;
    }
	public boolean isExportacion() {
		return exportacion;
	}
	public void setExportacion(boolean exportacion) {
		this.exportacion = exportacion;
	}

	public String getTipo_cliente() {
		return tipo_cliente;
	}

	public void setTipo_cliente(String tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}

	public String getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public int getNum_registros_x_pag() {
		return num_registros_x_pag;
	}

	public void setNum_registros_x_pag(int num_registros_x_pag) {
		this.num_registros_x_pag = num_registros_x_pag;
	}

	public String getCol_orden() {
		return col_orden;
	}

	public void setCol_orden(String col_orden) {
		this.col_orden = col_orden;
	}

	public int getTipoOpcion() {
		return tipoOpcion;
	}

	public void setTipoOpcion(int tipoOpcion) {
		this.tipoOpcion = tipoOpcion;
	}
}
