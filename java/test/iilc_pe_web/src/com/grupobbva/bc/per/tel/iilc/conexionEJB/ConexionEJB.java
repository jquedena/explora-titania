/*
 * Created on 07/07/2008
 */
package com.grupobbva.bc.per.tel.iilc.conexionEJB;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.grupobbva.bc.per.tel.iilc.dao.impl.ClienteDAOImpl;
import com.grupobbva.bc.per.tel.iilc.serializable.Cliente;
import com.grupobbva.bc.per.tel.iilc.serializable.Empresa;
import com.grupobbva.bc.per.tel.iilc.serializable.EstadoCarga;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;

/**
 * @author P020796
 */
public class ConexionEJB {
	
	ClienteDAOImpl clienteDAO;
	
	public ConexionEJB() {
		clienteDAO = new ClienteDAOImpl();
	}
	
	public Vector<Cliente> findAllClientebyFilter(int pos_ini, int pos_fin, String cod_territorio, String cod_oficina, String cod_gestor, String nivel_vinculacion, String clasificacion, String margen, String etiqueta, String edad, String porcrie, String cod_empresa, String tipo_cliente, String cod_cliente, String orden, boolean pestanaTodos, int tipoOpcion) {
		Vector<Cliente> res = clienteDAO.findAllClientebyFilter(pos_ini, pos_fin, cod_territorio, cod_oficina, cod_gestor, nivel_vinculacion, clasificacion, margen, etiqueta, edad, porcrie, cod_empresa, tipo_cliente, cod_cliente, orden, pestanaTodos, tipoOpcion);
		return res;
	}
	
	public List<Multitabla> findAllCabeceras(String codigo) {
		List<Multitabla> res = clienteDAO.findAllCabeceras(codigo);
		return res;
	}
	
	public Map<String, String> findCliente(String cod_cliente) {
		return clienteDAO.findCliente(cod_cliente);
	}
	
	public Cliente findTotalClientebyFilter(String cod_territorio, String cod_oficina, String cod_gestor, String nivel_vinculacion, String clasificacion, String margen, String etiqueta, String edad, String porcrie, String cod_empresa, String tipo_cliente, String cod_cliente, int tipoOpcion) {
		Cliente res = clienteDAO.findTotalClientebyFilter(cod_territorio, cod_oficina, cod_gestor, nivel_vinculacion, clasificacion, margen, etiqueta, edad, porcrie, cod_empresa, tipo_cliente, cod_cliente, tipoOpcion);
		return res;
	}
	
	public Vector<Empresa> findAllEmpresasbyFilter(String cod_territorio, String cod_oficina, String cod_gestor, String nivel_vinculacion, String clasificacion, String margen, String etiqueta, String edad, String porcrie, String tipo_cliente, String cod_cliente) {
		Vector<Empresa> res = clienteDAO.findAllEmpresasbyFilter(cod_territorio, cod_oficina, cod_gestor, nivel_vinculacion, clasificacion, margen, etiqueta, edad, porcrie, tipo_cliente, cod_cliente);
		return res;
	}

	public EstadoCarga ultimoFechaCarga() {
		EstadoCarga res = clienteDAO.ultimoFechaCarga();  
		return res;
	}
	
	public EstadoCarga ultimoEstadoCarga() {
		EstadoCarga res = clienteDAO.ultimoEstadoCarga();  
		return res;
	}
}