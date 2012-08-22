package indra.bbva.pizele.common;

public class Constantes 
{

	public static class Sesion
	{	
		public static final String CURRENT_USER = "__current_user__";		
	}
	
	public static class ParmetroID
	{
		public static final Long ID_RUTA_NOMBRE_LOG = 5L;
		public static final Long MES = 6L;
		public static final Long CARGOS_BACKUP = 28L;
	}
	
	public static class Perfil
	{
		public static final String ADMINISTRADOR = "ADM";
		public static final String GERENTE_TERRITORIO = "GTE";
		public static final String JEFE_PROMOCION_NEGOCIOS = "JPR";
		public static final String GERENTE_OFICINA = "GOF";
		public static final String GESTORES_NO_PERSONALIZADOS = "EBP";
	}
	
	public static class Opcion_Menu
	{
		public static final Long CONFIG_META_MENSUAL = 2L;
		public static final Long CONFIG_BASICA = 12L;
		public static final Long CONFIG_BACKUP_SUPLENTE = 16L;	
		public static final Long CONFIG_REGISTRO_LOGRO = 4L;
	}
	
	public static class TipoResultado
	{
		public static final String EXITO = "EXITO";
		public static final String ERROR = "ERROR";
		public static final String ADVERTENCIA = "ADVERTENCIA";
		public static final String PREGUNTA = "PREGUNTA";
		public static final String NO_DATA = "NO_DATA";
	}
	
	public static class TipoAcceso
	{
		public static final String SOLO_LECTURA = "L";
		public static final String TOTAL = "T";
	}
	
	public static class Semaforo
	{
		public static final Long RANGO_1 = 1L;
		public static final Long RANGO_2 = 2L;
		public static final Long RANGO_3 = 3L;
	}
	
	public static class TipoRubro
	{
		public static final String Fijo = "F";
		public static final String Adicional = "A";
	}
	
	public static class ProcesoCargaLogrosMIS
	{
		public static final Long FLAG_EJECUCION = 28L;
		public static final Long HORA_EJECUCION = 29L;
		public static final Long DIAS_EJECUCION = 30L;
	}
	
	public static class ProcesoAutomaticoEstado
	{
		public static final Long Pendiente = 39L;
		public static final Long Terminado = 40L;
		public static final Long Terminado_Error = 41L;
	}

	public static class ProcesoAutomaticoTipo
	{
		public static final Long CargaLogrosEpigrafesMIS = 43L;
	}
	
	public static class RubroFijosNoDesasignables
	{
		public static final Long CONTACTOS = 1L;
		public static final Long VISITAS = 2L;
	}
	
}
