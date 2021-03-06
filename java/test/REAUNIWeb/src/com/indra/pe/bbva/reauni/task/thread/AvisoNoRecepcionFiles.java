package com.indra.pe.bbva.reauni.task.thread;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;
import com.indra.pe.bbva.core.dao.DAOGenerico;
import com.indra.pe.bbva.core.mail.CorreoElectronico;
import com.indra.pe.bbva.reauni.mail.GestionCorreo;
import com.indra.pe.bbva.reauni.model.entidad.ParametroDto;
import com.indra.pe.bbva.reauni.model.entidad.SolicitudDto;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;

@SuppressWarnings({"rawtypes", "unchecked"})
public class AvisoNoRecepcionFiles  extends Thread  {
	private static Logger logger = Logger.getLogger(AvisoNoRecepcionFiles.class);
	private DAOGenerico<SolicitudDto> daoTarea;
	@Autowired
	private GestionCorreo gestionCorreo;
	
	@Override
	public void run() {
		try{
			ParametroDto dias = ApplicationHelper.obtenerParametroPorId(1075L);
			
			String sql = "SELECT * FROM reauni.vreauni_no_recepcion_email";
			Object row[] = null;
			List listaContratos = null;
			List lista_oficinas = getDaoTarea().ejecutarSQL(sql);
			
			if(lista_oficinas != null) {
				for(Iterator<Object[]> iter = lista_oficinas.iterator(); iter.hasNext();){
					row = iter.next();
					try {
						sql = "SELECT t.id, t.des_oficina, t.des_oficina_receptor, t.nom_gestor, t.producto, "
							+ "t.codigo_contrato, t.fecha_apertura, t.saldod, t.saldoa, t.tipo_prestamo, t.situacion "
							+ "FROM reauni.vreauni_no_recepcion_files t WHERE t.codigo_oficina = '" + row[0].toString() + "' or t.oficina_receptor = '" + row[0].toString() + "'";
						listaContratos = getDaoTarea().ejecutarSQL(sql);
						CorreoElectronico correoElectronico =  new CorreoElectronico();
						correoElectronico.enviar(getGestionCorreo().obtenerCorreoNoRecepcionFile(listaContratos, dias.getValorEntero(), row[1].toString()));
					}catch(Exception e){
						logger.error("Enviando correo - AvisoRecepcionFiles :: " + row[0].toString(), e);
					}
				}
			}
		}catch(Exception e){
			logger.error("AvisoNoRecepcionFiles",e);
		}
	}

	public GestionCorreo getGestionCorreo() {
		if(gestionCorreo ==  null){
			gestionCorreo = (GestionCorreo) WebServletContextListener.getApplicationContext().getBean("gestionCorreo");
		}
		return gestionCorreo;
	}	
	
	public DAOGenerico<SolicitudDto> getDaoTarea() {
		if(daoTarea ==  null){
			daoTarea = (DAOGenerico<SolicitudDto>) WebServletContextListener.getApplicationContext().getBean("daoGenerico");
		}
		return daoTarea;
	}	
}
