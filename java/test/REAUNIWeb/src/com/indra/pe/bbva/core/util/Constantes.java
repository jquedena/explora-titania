package com.indra.pe.bbva.core.util;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.faces.model.SelectItem;

public class Constantes {
	
	public static final String FORMATO_FECHA_HORA = "dd-MM-yyyy HH:mm:ss";
	
	public static final String SEPARADOR_LOG = "::";
	
	public static final boolean logError = true;
    public static final boolean logDebug = true;
    public static final boolean logWarn = true;
    public static final boolean logInfo = true;
    public static final int nuevo = 1;
    public static final int editar = 2;
    public static final int ver = 3;
    public static final int lista = 0;
    public static final int listaDetalle = 4;
    public static final int cancelar = 5;
    public static final int reportar = 6;
    public static final BigInteger trxOk = new BigInteger("1");
    public static final BigInteger trxError = new BigInteger("-1");
    public static final String separadorLog = "::";
    public static String formatoFechaHora = "dd-MM-yyyy HH:mm:ss";
    public static String formatoFecha = "dd-MM-yyyy";
    public static String formatoHora = "HH:mm:ss";
    public static final String archivoConfiguracion = "D:\\ronald.chang\\SionProject\\SionArchivos\\sion.cfg";
    public static final String directorioPrincipal = "";
    public static final String separadorArchivoAbrir = "[";
    public static final String separadorArchivoCerrar = "]";
    public static final String DataSourceInitContext = "java:/comp/env";
    public static final String DataSourceEnvContext = "jdbc/siondb";
    public static DecimalFormat dfDouble, dfInteger;
    public static Calendar calendario = Calendar.getInstance();
    public static final String ES_FORMATO_EMAIL = "[a-zA-Z0-9_]+[.[a-zA-Z0-9]+]*@[[a-zA-Z0-9_]+.[a-zA-Z0-9]+]+";
    public static final String ES_FORMATO_ENTERO = "[0-9]+";
    public static final String ES_FORMATO_REAL = "[0-9]+|[0-9]+[.][0-9]+";
    public static final String ES_FORMATO_ENTERO_SIGNO = "[+-]*[0-9]+";
    public static final String ES_FORMATO_REAL_SIGNO = "[+-]*[0-9]+|[+-]*[0-9]+[.][0-9]+";
    public static final String ES_FORMATO_FECHA = "";
    public static final String ES_FORMATO_HORA = "[0-9]{2}:[0-9]{2}";
    public static final String ES_FORMATO_TEXTO = "[a-zA-Z������������ ]+";
    public static final String ES_FORMATO_ALFA_NUMERICO = "[0-9a-zA-Z������������ ]+";
    public static final String ES_FORMATO_SOLO_ALFA_NUMERICO = "[^0-9a-zA-Z������������ ]+";
    public static final String[] UNIDADES = {"", "UN ", "DOS ", "TRES ",
        "CUATRO ", "CINCO ", "SEIS ", "SIETE ", "OCHO ", "NUEVE ", "DIEZ ",
        "ONCE ", "DOCE ", "TRECE ", "CATORCE ", "QUINCE ", "DIECISEIS",
        "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE"};
    public static final String[] DECENAS = {"VENTI", "TREINTA ", "CUARENTA ",
        "CINCUENTA ", "SESENTA ", "SETENTA ", "OCHENTA ", "NOVENTA ",
        "CIEN "};
    public static final String[] CENTENAS = {"CIENTO ", "DOSCIENTOS ",
        "TRESCIENTOS ", "CUATROCIENTOS ", "QUINIENTOS ", "SEISCIENTOS ",
        "SETECIENTOS ", "OCHOCIENTOS ", "NOVECIENTOS "};
	
	public static class Form {
        public final static int NUEVO = 1;
        public final static int EDITAR = 2;
        public final static int VER = 3;
        public final static int LISTA = 0;
    }
	
	
	public static final Long TIPO_OFICINA_RECEPTORA = new Long("1032");
	public static final Long TIPO_OFICINA_CEDENTE = new Long("1031");
	
	public static final SelectItem TIPO_OFICINA = new SelectItem("OFI","Oficina");
	public static final SelectItem TIPO_TERRITORIO = new SelectItem("TERR","Territorio");
	public static final SelectItem TIPO_TRAMITE = new SelectItem("TRAM","Tiempo de tramite");
	public static final SelectItem TIPO_SOLICITUD = new SelectItem("SOLI","Tipo de solicitante");
	public static final String RUTA_REPOSITORIO_REPORTES = "C:/BKP_15032012/";	
	
	public static final String CABECERA_REPORTE_GESTION_FILES = "SOLICITUD|OF. CEDENTE|OF. RECEPTORA|GES.RECEPTOR|PRODUCTO|CONTRATO|F.APER.|TOTAL ACTIVO|TOTAL PASIVO|TIP. PRESTAMO|DET. SITUACION";
	
	public static final String CABECERA_REPORTE_UNIFICACION = 
		"Fecha de Registro Sol.|Código Central del Cliente|Nro Contrato|Fecha de Apertura del Contrato|" +
		"Cod. Ofic. Propietaria|Nom. Ofic. Propietaria|Cod. Gestor Propietario|Nom. Gestor Propietario|" +
		"Cod. Terr. Receptor|Nom. Terr. Receptor|Cod. Ofic. Receptora|Nom. Ofic. Receptora|" +
		"Cod. Gestor Receptor|Nom. Gestor Receptor|Cod. Producto|Nom. Producto|" +
		"Bonificación|Total Activo|Total Pasivo";

	public static final String CABECERA_REPORTE_REASIGNACION = 
		"Fecha de Registro Sol.|Código Central del Cliente|Nro Contrato|Fecha de Apertura del Contrato|" +
		"Cod. Ofic. Propietaria|Nom. Ofic. Propietaria|Cod. Gestor Propietario|Nom. Gestor Propietario|" +
		"Cod. Terr. Receptor|Nom. Terr. Receptor|Cod. Ofic. Receptora|Nom. Ofic. Receptora|" +
		"Cod. Gestor Receptor|Nom. Gestor Receptor|Cod. Producto|Nom. Producto|" +
		"Ajuste|Total Activo|Total Pasivo";
}
