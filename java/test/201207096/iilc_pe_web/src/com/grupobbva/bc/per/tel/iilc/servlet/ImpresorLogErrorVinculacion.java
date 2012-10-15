package com.grupobbva.bc.per.tel.iilc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.conexionEJB.ConexionDAO;

public class ImpresorLogErrorVinculacion extends HttpServlet {

	private static final long serialVersionUID = 3003833279378928338L;
	public int num1 = 0;
	static Logger logger = Logger.getLogger(ImpresorLogErrorVinculacion.class);

	@SuppressWarnings("unchecked")
	public void service(HttpServletRequest request, HttpServletResponse res)
			throws ServletException, IOException {

		String tipo = request.getParameter("tipo");

		ConexionDAO con = new ConexionDAO();

		try {

			List lista = con.listarLogVinculacion(tipo);

			for (int i = 0; i < lista.size(); i++) {

				lista.get(i);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}