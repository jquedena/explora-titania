package com.indra.pe.bbva.core.util;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Calendar;

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

	public static final String RUTA_REPOSITORIO_REPORTES = "C:/Documents and Settings/mchavezc/Escritorio/BKP_15032012/";
	public static final String CABECERA_OFICINA = "C�digo Oficina|Nombre de la Oficina |Nro  Sol. En Creaci�n|Nro  Sol. Anuladas |Nro  Sol. En Evaluaci�n  |Nro  Sol. Desaprobada |Nro  Sol. Aprobadas|Nro Sol con Silencio Administrativo|Nro Sol. En Proceso |Nro Sol. Procesada|Nro Sol. Proceso c/Obs   |Nro contratos pendientes|Nro contratos procesados|Nro contratos observados|Nro contratos con File Pend. Traslado|Nro contratos con Files Trasladados |Num. Sol. Como Ofic. Solicitante|Num. Sol. Como Ofic. Receptora|Num. Sol. Como Ofic. Cedente|Num. contratos. Como Ofic. Solicitante|Num. Contratos  Como Ofic. Receptora|Num. Contratos . Como Ofic. Cedente|Total Activo de Contratos Cedidos|Total Pasivo de Contratos Cedidos|Total Activo de Contratos Cedidos C/Ajustes|Total Pasivo de Contratos Cedidos C/Ajustes|Total Activo de Contratos Recibidos|Total Pasivo de Contratos Recibidos|";
	public static final String CABECERA_TERRITORIO = "C�digo Territorio|Nombre del Territorio|Nro  Sol. En Creaci�n|Nro  Sol. Anuladas |Nro  Sol. En Evaluaci�n|Nro  Sol. Desaprobada |Nro  Sol. Aprobadas|Nro Sol con Silencio Administrativo|Nro Sol. En Proceso |Nro Sol. Procesada|Nro Sol. Proceso c/Obs|Nro contratos pendientes|Nro contratos procesados|Nro contratos observados|Nro contratos con File Pend. Traslado|Nro contratos con Files Trasladados |Num. Sol. Como Ofic. Solicitante|Num. Sol. Como Ofic. Receptora|Num. Sol. Como Ofic. Cedente|Num. contratos. Como Ofic. Solicitante|Num. Contratos  Como Ofic. Receptora|Num. Contratos . Como Ofic. Cedente|Total Activo de Contratos Cedidos|Total Pasivo de Contratos Cedidos|Total Activo de Contratos Cedidos C/Ajustes|Total Pasivo de Contratos Cedidos C/Ajustes|Total Activo de Contratos Recibidos|Total Pasivo de Contratos Recibidos|";
	public static final String CABECERA_TRAMITE = "C�digo de Territorio|Nombre de Territorio|Tipo de solicitud|Tiempo promedio en Definici�n (D�as)|Tiempo promedio en Evaluaci�n (D�as) |Tiempo promedio en evaluaci�n GT � JPN (D�as)|Tiempo Promedio en Proceso (Aprobada, En proceso, Procesada, Proceso c/Obs) (D�as)|Tiempo Promedio Total de la Solicitud (D�as)|Tiempo Promedio de Traslado de Contratos (D�as)|";
	public static final String CABECERA_SOLICITUD = "Registro|Nombre del Solicitante|Cod. Oficina del Solicitante|Nombre de la Oficina|Cod. Territorio Solicitante|Nombre del Territorio|Nro  Sol. En Creaci�n|Nro  Sol. Anuladas |Nro  Sol. En Evaluaci�n|Nro  Sol. Desaprobada |Nro  Sol. Aprobadas|Nro Sol con Silencio Administrativo|Nro Sol. En Proceso |Nro Sol. Procesada|Nro Sol. Proceso c/Obs|Nro contratos pendientes|Nro contratos procesados|Nro contratos observados|Nro contratos con File Pend. Traslado|Nro contratos con Files Trasladados |Num. Sol. Como Ofic. Solicitante|Num. Sol. Como Ofic. Receptora|Num. Sol. Como Ofic. Cedente|Num. contratos. Como Ofic. Solicitante|Num. Contratos  Como Ofic. Receptora|Num. Contratos . Como Ofic. Cedente|Total Activo de Contratos Cedidos|Total Pasivo de Contratos Cedidos|Total Activo de Contratos Cedidos C/Ajustes|Total Pasivo de Contratos Cedidos C/Ajustes|Total Activo de Contratos Recibidos|Total Pasivo de Contratos Recibidos|";
	
	public static final String TIPO_OFICINA = "OFI";
	public static final String TIPO_TERRITORIO = "TERR";
	public static final String TIPO_TRAMITE = "TRAM";
	public static final String TIPO_SOLICITUD = "SOLI";


}
