package com.indra.pe.bbva.reauni.view.mbean;

import org.apache.log4j.Logger;
import org.primefaces.component.menubar.Menubar;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.indra.pe.bbva.core.view.GenericMBean;
import com.indra.pe.bbva.reauni.view.helper.MenuBarHelper;

@Controller("menuMBean")
@Scope("session")
public class MenuMBean extends GenericMBean{

	private static Logger logger = Logger.getLogger(MenuMBean.class);
	
	private Menubar principalMenuBar;
	
	public MenuMBean() {
	}
	
	private void cargarMenuBar(){
		try {
			this.principalMenuBar = MenuBarHelper.getMenuBar(null);
		} catch (Exception e) {
			String msg = "no se pudo crear el componente menubar";
			showError(msg);
			logger.error(msg, e);
		}
	}
	
	public Menubar getPrincipalMenuBar() {
		cargarMenuBar();
		return principalMenuBar;
	}

	public void setPrincipalMenuBar(Menubar principalMenuBar) {
		this.principalMenuBar = principalMenuBar;
	}
 
	public String metodoPrueba(){
		return "";
	}
}
