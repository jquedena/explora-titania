package com.indra.pe.bbva.reauni.util;

public class Constantes {
	public static final String VARIABLE_ID_MENU = "SubMenu";
	public static final String VARIABLE_ID_MENU_ITEM = "MenuItem";
	public static final String LOG_REAUNI = "/cronreauni.log";
	
	public static class VariablesCatalogoParametros{
		public static final Long VARIABLE_ID_TIPO_ACCESO = 1001L;
		public static final Long VARIABLE_ID_ESTADOS = 1002L;
		public static final Long VARIABLE_ID_LOG = 1003L;
	}
	
	public static class VariablesParametros{
		public static final Long VARIABLE_ID_TIPO_ACCESO = 1001L;
		public static final Long VARIABLE_ID_ESTADOS = 1002L;
		public static final Long VARIABLE_ID_LOG = 1003L;
	}
	
	
	public static class Formulario{
		public static final int NUEVO  = 1;
		public static final int EDITAR = 2;
		public static final int VER    = 3;
	}
	
	public static class UrlNavegacion{
		public static final String URL_USUARIO = "/faces/pages/administracion/usuarios/usuario.xhtml";
		public static final String URL_LISTA_USUARIOS = "/faces/pages/administracion/usuarios/listaUsuario.xhtml";
		
		public static final String URL_SITUACIONES = "/faces/pages/administracion/situaciones/situaciones.xhtml";
		public static final String URL_LISTA_SITUACIONES = "/faces/pages/administracion/situaciones/listaSituaciones.xhtml";
		
		public static final String URL_FECHA_CORTE = "/faces/pages/administracion/fechaCorte/fechaCorte.xhtml";
		public static final String URL_LISTA_FECHA_CORTE = "/faces/pages/administracion/fechaCorte/listaFechaCorte.xhtml";
		
		public static final String URL_ACCESO_FECHA_CORTE = "/faces/pages/administracion/fechaCorte/accesoFechaCorte.xhtml";
		public static final String URL_LISTA_ACCESO_FECHA_CORTE = "/faces/pages/administracion/fechaCorte/listaAccesoFechaCorte.xhtml";
		
		public static final String URL_OPERACIONES_CENTRALES = "/faces/pages/administracion/opeCentrales/opeCentrales.xhtml";
		public static final String URL_LISTA_OPERACIONES_CENTRALES = "/faces/pages/administracion/opeCentrales/listaOpeCentrales.xhtml";
		
		public static final String URL_TIPO_PRESTAMO = "/faces/pages/administracion/tipoPrestamo/tipoPrestamo.xhtml";
		public static final String URL_LISTA_TIPO_PRESTAMO = "/faces/pages/administracion/tipoPrestamo/listaTipoPrestamo.xhtml";
		
		public static final String URL_CATALOGO_PARAMETRO ="/pages/administracion/parametro/listaCatalogosParametro";
		public static final String URL_LISTA_CATALOGO_PARAMETRO = "/pages/administracion/parametro/catalogoParametro";
		public static final String URL_PARAMETRO = "/pages/administracion/parametro/parametro";
		
		public static final String URL_TAREA ="/pages/administracion/tarea/tarea";
		public static final String URL_LISTA_TAREA = "/pages/administracion/tarea/listaTareas";
		
		public static final String URL_LISTA_CARGA = "/pages/administracion/cargas/listaCargas";
		
	}
	
}
