package com.indra.pe.bbva.reauni.view.helper;

import java.util.List;

import org.primefaces.component.menubar.Menubar;
import org.primefaces.component.menuitem.MenuItem;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.reauni.model.entidad.OpcionMenuDto;
import com.indra.pe.bbva.reauni.util.Constantes;

@Controller("menuBarHelper")
public class MenuBarHelper {

	public MenuBarHelper() {
	}
	
	public static Menubar getMenuBar(List<OpcionMenuDto> listaOpcionMenu)throws Exception{
		Menubar menuBar =  new Menubar();
		MenuItem menuItem = null;
		menuItem = new MenuItem();
		menuItem.setId(Constantes.VARIABLE_ID_MENU_ITEM + "Inicio");
		menuItem.setValue("INICIO");
		menuItem.setUrl("/faces/pages/principal.xhtml");
		menuItem.setIcon("ui-icon ui-icon-home");
		menuBar.getChildren().add(menuItem);
		
		/*
		menuItem = new MenuItem();
		menuItem.setId(Constantes.VARIABLE_ID_MENU_ITEM + "GestionTareas");
		menuItem.setValue("GESTION DE TAREAS");
		menuItem.setUrl("/faces/pages/administracion/tarea/listaTareas.xhtml");
		menuItem.setIcon("ui-icon ui-icon-gear");
		menuBar.getChildren().add(menuItem);
		*/
		
		menuItem = new MenuItem();
		menuItem.setId(Constantes.VARIABLE_ID_MENU_ITEM + "VerCargas");
		menuItem.setValue("CARGAS EJECUTADAS");
		menuItem.setUrl("/faces/pages/administracion/cargas/listaCargas.xhtml");
		menuItem.setIcon("ui-icon ui-icon-gear");		
		menuBar.getChildren().add(menuItem);
		
		/*
		menuItem = new MenuItem();
		menuItem.setId(Constantes.VARIABLE_ID_MENU_ITEM + "Ayuda");
		menuItem.setValue("AYUDA");
		menuItem.setUrl("/faces/pages/ayuda.xhtml");
		menuItem.setIcon("ui-icon ui-icon-help");
		menuBar.getChildren().add(menuItem);
		*/
		
		menuItem = new MenuItem();
		menuItem.setId(Constantes.VARIABLE_ID_MENU_ITEM + "Salir");
		menuItem.setValue("SALIR");
		menuItem.setOnclick("return cerrar()");
		menuItem.setIcon("ui-icon ui-icon-close");
		menuBar.getChildren().add(menuItem);
		return menuBar;
	}
}

 