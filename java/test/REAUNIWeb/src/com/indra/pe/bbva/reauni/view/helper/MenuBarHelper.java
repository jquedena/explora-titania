package com.indra.pe.bbva.reauni.view.helper;

import java.util.List;

import javax.faces.context.FacesContext;

import org.primefaces.component.menubar.Menubar;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.reauni.model.entidad.OpcionMenuDto;
import com.indra.pe.bbva.reauni.util.Constantes;
import com.indra.pe.bbva.reauni.view.mbean.SessionMBean;

@SuppressWarnings({"deprecation"})
@Controller("menuBarHelper")
public class MenuBarHelper {
 

	public MenuBarHelper() {
	}
	
	public static Menubar getMenuBar(List<OpcionMenuDto> listaOpcionMenu)throws Exception{
		
		Menubar menuBar =  new Menubar();
		Submenu subMenu = null;
		MenuItem menuItem = null;
		menuItem = new MenuItem();
		menuItem.setId(Constantes.VARIABLE_ID_MENU_ITEM + "Inicio");
		menuItem.setValue("INICIO");
		menuItem.setStyleClass("claseMenuItem");		
		menuItem.setUrl("/faces/pages/principal.xhtml");
		menuItem.setIcon("ui-icon ui-icon-home");
		menuBar.getChildren().add(menuItem);

		for (OpcionMenuDto opcionMenuDto : listaOpcionMenu) {
			if(opcionMenuDto.getPadre()==null){
				subMenu =  new Submenu();
				subMenu.setId(Constantes.VARIABLE_ID_MENU + String.valueOf(opcionMenuDto.getId().intValue()));
				subMenu.setLabel(opcionMenuDto.getNombre());				
				subMenu.setIcon("ui-icon ui-icon-calculator");				
				menuBar.getChildren().add(subMenu);
			}
			cargarHijos(opcionMenuDto,subMenu);
		}

		menuItem = new MenuItem();
		menuItem.setId(Constantes.VARIABLE_ID_MENU_ITEM + "Salir");
		menuItem.setValue("SALIR");
		menuItem.setStyleClass("claseMenuItem");
		menuItem.setOnclick("return cerrar()");
		menuItem.setIcon("ui-icon ui-icon-close");
		menuBar.getChildren().add(menuItem);
		return menuBar;
	}
	
	private static void cargarHijos(OpcionMenuDto opcionMenuDto,Submenu subMenu)throws Exception{
		SessionMBean sessionMBean = (SessionMBean) WebServletContextListener.getApplicationContext().getBean("sessionMBean");
		
		MenuItem menuItem = null;
		Submenu subMenuHijo = null;
		for (OpcionMenuDto opcionMenuDtoHijo : opcionMenuDto.getOpcionMenuDtoList()) {
			if(opcionMenuDtoHijo.getTreauniPerfilOpcionMenuList(sessionMBean.getPerfilDto().getId())) {
				if(opcionMenuDtoHijo.getOpcionMenuDtoList().size()>=1){
					subMenuHijo =  new Submenu();
					subMenuHijo.setId(Constantes.VARIABLE_ID_MENU+String.valueOf(opcionMenuDtoHijo.getId().intValue()));
					subMenuHijo.setLabel(opcionMenuDtoHijo.getNombre());
					subMenu.getChildren().add(subMenuHijo);
					cargarHijos(opcionMenuDtoHijo,subMenuHijo);
				}else{
					menuItem = new MenuItem();
					menuItem.setId(Constantes.VARIABLE_ID_MENU_ITEM + String.valueOf(opcionMenuDtoHijo.getId().intValue()));
					menuItem.setValue(opcionMenuDtoHijo.getNombre());
					menuItem.setStyleClass("claseMenuItem");
					menuItem.setAction(FacesContext.getCurrentInstance().getApplication().createMethodBinding(opcionMenuDtoHijo.getAccion(), new Class[]{}));
					menuItem.setAjax(false);
					menuItem.setInView(true);
					subMenu.getChildren().add(menuItem);
				}
			}
		}
	}
}

 