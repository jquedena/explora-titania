/**
 * @author: Maria Paula Tomaylla
 * codigo : P020795
 * fecha  : 29/10/2007
 */

package com.grupobbva.bc.per.tel.iilc.common;

public class Constantes {
    
    //ruta del archivo de carga
	//desarrollo
    //public static final String PATH = "d:/de/iilc/online/pe/web/files/";
    //produccion
    //public static final String PATH = "d:/pr/iilc/online/pe/web/files/";
	public static final String PATH = "T00PATH";
	public static final String PATHVINCULACION = "T00VINC";
	public static final String PATHUPLOADS = "T00UPLO";
	
	
	public static final String LINK1 = "T00LNK1";
	/*public static final String JDBC_URL = "T00JURL";
    public static final String JDBC_USER = "T00JUSR";
    public static final String JDBC_PASS = "T00JPSW";
    public static final String JDBC_NUMSINC = "T00JNSC";
    public static final String JDBC_DRIVER = "T00JDRV";*/
	
    // Total registros por pagina
    public static final int TOT_REGXPAG = 20;
    // Total registros maximo en un archivo excel
    public static final int TOT_REGEXCEL = 65530;

    /**
     * forward
     */
    public static final String ERROR_REGISTRAR_LINEA = "Error al registrar la l" + (char) 237 + "nea";
    public static final String ERROR_CANTIDAD_CAMPOS = "Cantidad inv" + (char) 225 + "lida de campos en el archivo";
    public static final String ERROR_LEER_CAMPOS = "Error al leer los campos de la l" + (char) 237 + "nea";
    
    public static final String ID_ESTADO_CARGA_VINCULACION_ENPROCESO = "2";
    public static final String ID_ESTADO_CARGA_VINCULACION_CULMINADO = "3";
    public static final String ID_ESTADO_CARGA_VINCULACION_CULMINADO_ERROR = "4";
    public static final String INDICADOR_PROCESANDO_VINCULACION = "1";
    public static final String INDICADOR_NO_PROCESANDO_VINCULACION = "0";
    public static final String CODIGO_NOMBRES_ARCHIVOS_VINCULACION_VIP= "T00CARGAV";
    public static final String CODIGO_NOMBRES_ARCHIVOS_VINCULACION_GCO= "T00CARGAG";
    public static final String CODIGO_NOMBRES_ARCHIVOS_VINCULACION_PH= "T00CARGAP";
    
    public static final String FW_ERROR = "error";
    public static final String FW_CONSULTA = "consulta";
    public static final String FW_PRINCIPAL = "principal";
    public static final String FW_ADMINISTRADOR = "administrador";
    public static final String FW_LOGIN = "login";
    public static final String FW_DESCARGA = "descarga";
    public static final String FW_ESPERA_EXPORTACION = "espera_exportacion";
    public static final String FW_ESPERA_IMPRESION = "espera_impresion";
    public static final String FW_CARGA_MASIVA = "carga_masiva";
    public static final String FW_MANTENIMIENTO_TABLAS = "mantenimiento_tablas";
    public static final String FW_REG_MOD_MULTITABLA = "reg_mod_multitabla";
    public static final String FW_REG_MOD_PERFIL = "reg_mod_perfil";
    public static final String FW_REG_MOD_PERMISO_PERFIL = "reg_mod_permiso_perfil";
    public static final String FW_VER_MULTITABLA = "ver_multitabla";
    public static final String FW_VER_PERFIL = "ver_perfil";
    public static final String FW_VER_PERMISO_PERFIL = "ver_permiso_perfil";
    public static final String FW_VER_EMPRESA = "ver_empresa";
    public static final String FW_ESTADO_CARGA = "estado_carga";
	
    public static final String FW_FECHAS_PROGRAMADAS = "fechas";
    public static final String FW_INTERVAOS = "intervalos";
    /**
     * ruta ejb
     */
    public static final String EJB_TERRITORIO			= "java:comp/env/ejb/Tiilc_territorio";
	public static final String EJB_EMPRESA				= "java:comp/env/ejb/Tiilc_empresa";
    public static final String EJB_OFICINA   			= "java:comp/env/ejb/Tiilc_oficina";
    public static final String EJB_GESTOR   			= "java:comp/env/ejb/Tiilc_gestor";
    public static final String EJB_MULTITABLA  			= "java:comp/env/ejb/Tiilc_multitabla";
    public static final String EJB_CLIENTE  			= "java:comp/env/ejb/Tiilc_cliente";
    public static final String EJB_TOTAL     			= "java:comp/env/ejb/Tiilc_total";
    public static final String EJB_PERFIL				= "java:comp/env/ejb/Tiilc_perfil";
    public static final String EJB_PERMISO_PERFIL		= "java:comp/env/ejb/Tiilc_permiso_perfil";

        
    /**
     * ruta session
     */
    public static final String SESSION_TERRITORIO    	= "ejb/com/grupobbva/bc/per/tel/iilc/session/SessionTerritorioHome";
    public static final String SESSION_OFICINA      	= "ejb/com/grupobbva/bc/per/tel/iilc/session/SessionOficinaHome";
    public static final String SESSION_GESTOR        	= "ejb/com/grupobbva/bc/per/tel/iilc/session/SessionGestorHome";
    public static final String SESSION_MULTITABLA     	= "ejb/com/grupobbva/bc/per/tel/iilc/session/SessionMultitablaHome";
    public static final String SESSION_CARGA        	= "ejb/com/grupobbva/bc/per/tel/iilc/session/SessionCargaHome";
    public static final String SESSION_CLIENTE       	= "ejb/com/grupobbva/bc/per/tel/iilc/session/SessionClienteHome";
    public static final String SESSION_TOTAL        	= "ejb/com/grupobbva/bc/per/tel/iilc/session/SessionTotalHome";
    public static final String SESSION_PERMISO_PERFIL  	= "ejb/com/grupobbva/bc/per/tel/iilc/session/SessionPermisoPerfilHome";
    public static final String SESSION_SERVICE		  	= "ejb/com/grupobbva/bc/per/tel/iilc/session/SessionServiceHome";    
    /**
     * tablas
     */
    public static final String TABLA_NIVEL_VINCULACION = "T01";
    public static final String TABLA_CLASIFICACION = "T02";
    public static final String TABLA_MARGEN_ORDINARIO = "T03";
    public static final String TABLA_ETIQUETA = "T04";
    public static final String TABLA_SEGMENTO_ETIQUETA = "T05";
    public static final String TABLA_EDAD = "T06";
    public static final String TABLA_CUOTA_RIESGO_TOTAL = "T07";
    
    /**
     * labels 
     */
    public static final String LBL_TOTALES_GESTOR = "TOTALES GESTOR";
    public static final String LBL_TOTALES_OFICINA = "TOTALES OFICINA";
    public static final String LBL_TOTALES_TERRITORIO = "TOTALES TERRITORIO";
    public static final String LBL_TOTALES_BANCO = "TOTALES BANCO";
    
    /**
     * detalle 
     */
    public static final String DT_GENERAL = "dt_general";
    public static final String DT_ACTIVO = "dt_activo";
    public static final String DT_TARJETAS = "dt_tarjetas";
    public static final String DT_PASIVO = "dt_pasivo";
    public static final String DT_SERVICIOS = "dt_servicios";
    public static final String DT_CANALES = "dt_canales";
    public static final String DT_OFERTAS = "dt_ofertas";
    public static final int TAB_GENERAL = 0;
    public static final int TAB_ACTIVO = 1;
    public static final int TAB_TARJETAS = 2;
    public static final int TAB_PASIVO = 3;
    public static final int TAB_SERVICIOS = 4;
    public static final int TAB_CANALES = 5;
    public static final int TAB_OFERTAS = 6;
    
    public static final int PAGINACION_VINCULACION  = 30;
    
    public static final int COLUMNAS_EXPORTAR_HISTORICO  = 24;
    public static final int COLUMNAS_EXPORTAR_VINCULACION_SEGMENTADA = 4;
    public static final int COLUMNAS_EXPORTAR_VINCULACION_VINCULADA = 4;
    /**
     * atog
     * @author P020795
     *
     */
    
    public static final char AREA = 'A';
    public static final char TERRITORIO = 'T';
    public static final char OFICINA = 'O';
    public static final char GESTOR = 'G';
    public static final char EMPRESA = 'E';
    
    public static final char MULTITABLA = 'M';
    public static final char PERFIL = 'P';
    public static final char PERMISO_PERFIL = 'S';
    
    public static final char AGREGAR = 'A';
    public static final char MODIFICAR = 'M';
    public static final char VER = 'V';
    public static final char ELIMINAR = 'E';
    
    
    public static final char VIP = 'V';
    public static final char PH = 'P';
    public static final char GCO = 'G';
    
    public static final String CODIGO_VIP = "1";
    public static final String CODIGO_VIP_SEGMENTADO = "5";
    public static final String CODIGO_VIP_VINCULADO = "4";
    public static final String CODIGO_GCO = "2";
    public static final String CODIGO_PH = "3";
    public static final String CODIGO_LCONDUCC = "7";
    public static final String CODIGO_GESTOR = "9";
    public static final String CODIGO_CENTRO = "8";
    public static final String CODIGO_ALMACCC = "12";
    public static final String CODIGO_ESTM = "13";
    public static final String CODIGO_COLECTIVO = "10";
    public static final String CODIGO_VARIOFER = "11";
    public static final String MENASJE_PROCESANDO = "Se est" + (char) 225 + " procesando una carga de un archivo de vinculaci" + (char) 243 + "n ";
    public static final String MENASJE_FECHA_ERRONEA = "La fecha y hora debe ser mayor en 10 minutos o m" + (char) 225 + "s a la fecha del servidor";
    public static final String MENASJE_ESPERAR_CULMINADO = "Esta carga se encuentra en proceso, esperar que el proceso este concluido";
    public static final String MENASJE_FECHA_EXISTE_ELIMINAR= "La fecha ya existe, debe eliminar primero la fecha existente";
    
    public static final String MENASJE_FECHA_EXISTE = "La fecha programada ya existe " + (char) 191 + "desea reemplazarla?";
    public static final String MENASJE_CARGA_PROCESO= "Esta carga se encuentra en proceso, esperar que el proceso este concluido";
    public static final String MENASJE_REGISTRAR_FECHA= "Debe registrar una fecha";
    public static final String MENASJE_ELIMINAR_PROCESO= "Se estan intentando eliminar cargas que se encuentran en proceso";
    public static final String MENASJE_MODIFICAR_PROCESO= "La programaci" + (char) 243 + "n se encuentra en proceso y no puede modificarse";
    public static final String MENASJE_MODIFICAR_PROCESO_POSTERIOR= "La programaci" + (char) 243 + "n seleccionada no se puede modificar, seleccionar una fecha posterior";
    
    

    public static final String CODIGO_HISTORICO_DIA="D";
    public static final String CODIGO_HISTORICO_TOTAL="T";
    
    
    public static final String VIP_DESCRIPCION ="VIP";
    public static final String VIP_SEGMENTADO_DESCRIPCION ="VIP_SEG";
    public static final String VIP_VINCULADO_DESCRIPCION ="VIP_VIN";
    public static final String PH_DESCRIPCION = "PH";
    public static final String GCO_DESCRIPCION = "GCO";
    
    
    public static final String HISTORICO_DIA_DESCRIPCION="HIS_DIA_";
    public static final String HISTORICO_TOTAL_DESCRIPCION ="HIS_TOT_";
    /**
     * @author P020796
     *
     */
    public static final String DATASOURCE_CONTEXT = "jdbc/ORA_BIILC";
    public static final String TODOS_TERRITORIOS = "9999";
    public static final String AJAXSPLIT = "iilc_ajaxsplit";
	public static final String EXPORTACION_ARCHIVO = "exportacion_archivo";
	public static final String EXPORTACION_RUTA = "exportacion_ruta";

	public static final String MENSAJE_INFORMACION_ACTUALIZACION_ADMINISTRACION = "Debe salir del sistema para ver los cambios registrados";
	
	
	public static final int MAXIMO_REGISTROS_REPORTE_EXCEL = 21000;
	
	public static final int ID_ESTADO_CARGA_PENDIENTE = 1;
	public static final int ID_ESTADO_CARGA_INICIO = 2;
	public static final int ID_ESTADO_CARGA_FIN = 3;
	public static final int ID_ESTADO_CARGA_ERROR = 4;
	
	
	public static final String TIPO_COD_MULT_INVERVALOS = "T11";
	public static final String TIPO_COD_MULT_CORREOS = "T12";
	
	
	public static final String JAVA_MAIL_HOST ="T13";
	public static final String JAVA_MAIL_PORT = "T14";
	public static final String JAVA_MAIL_USER = "T15";
	public static final String JAVA_MAIL_PASS = ""	;
	
	public static final String JAVA_MAIL_TITULO_INICIO_PROCESO = "Inicio carga "	;
	public static final String JAVA_MAIL_CUERPO_INICIO_PROCESO = "Se inici" + (char) 243 + " la carga  del archivo de "	;
	
	public static final String NOMBRE_VARIOFER = "VARIOFER";
	public static final String NOMBRE_ALMACCC = "ALMACCC";
	public static final String NOMBRE_ESTM = "ESTM";
	public static final String NOMBRE_LCONDUCC = "LCONDUCC";
	
	public static final String ESTADO_CARGA_ERROR = "1";
	public static final String ESTADO_CARGA_INICIO = "2";
	public static final String ESTADO_CARGA_FIN = "3";
	
	public static final int ESTADO_ARCHIVO_CARGA_EXITO = 1;
	
	public static final int LONGITUD_CAMPO_VINCULACION_CORTA  = 40;
	public static final int LONGITUD_CAMPO_VINCULACION_LARGA  = 100;
}
