package com.grupobbva.bc.per.tel.iilc.task;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tel.iilc.beans.Tiilc_adm_carga_archivo;
import com.grupobbva.bc.per.tel.iilc.common.Constantes;
import com.grupobbva.bc.per.tel.iilc.config.SingletonBeanFactory;
import com.grupobbva.bc.per.tel.iilc.dao.ICargaDAO;
import com.grupobbva.bc.per.tel.iilc.dao.impl.CargaDAOImpl;
import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;

public class Mensajero {

	Logger logger = Logger.getLogger(Mensajero.class);
	private String host;
	private String starttls;
	private String user;
	private String auth;
	private String subject;
	private String text;
	private String password;
	private String transport;
	private String port;
	private List<InternetAddress> recipient;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getStarttls() {
		return starttls;
	}

	public void setStarttls(String starttls) {
		this.starttls = starttls;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void clearRecipient() {
		recipient.clear();
	}
	
	public void addRecipient(String user) {
		try {
			recipient.add(new InternetAddress(user));
		} catch (AddressException e) {
			logger.error("error en el envio de correo :" + e.getMessage());
		}
	}

	public Mensajero() {
		recipient = new ArrayList<InternetAddress>();
	}
	
	public void enviar() {
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", this.getHost());
		props.setProperty("mail.smtp.starttls.enable", this.getStarttls());
		props.setProperty("mail.smtp.port", this.getPort());
		props.setProperty("mail.smtp.user", this.getUser());
		props.setProperty("mail.smtp.auth", this.getAuth());
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.sendpartial", "true");
	
		Session session = Session.getInstance(props);
		session.setDebug(true);
	
		try {
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(this.user));
			
			for(InternetAddress user : this.recipient) {
				message.addRecipient(Message.RecipientType.TO, user);
			}
			
			message.setSubject(this.getSubject());
			message.setText(this.getText());
			logger.error(this.getText());
			
			Transport t = session.getTransport(this.getTransport());
			t.connect(this.getHost(), this.getUser(), this.getPassword());
			// t.sendMessage(message,message.getAllRecipients());
			Transport.send(message);
			t.close();
		} catch (AddressException e) {
			logger.error("AddressException - Error en el envio de correo :" + e.getMessage());
		} catch (MessagingException e) {
			logger.error("MessagingException - Error en el envio de correo :" + e.getMessage());
		}
	}
	
	public void enviarCorreo(String tipo,String estado,String fecha) {
		String nombre = "Desconocido";
		
		if(Constantes.CODIGO_VIP.equalsIgnoreCase(tipo))
			nombre = Constantes.VIP_DESCRIPCION;
		
		if(Constantes.CODIGO_VIP_SEGMENTADO.equalsIgnoreCase(tipo))
			nombre = Constantes.VIP_SEGMENTADO_DESCRIPCION;
		
		if(Constantes.CODIGO_VIP_VINCULADO.equalsIgnoreCase(tipo))
			nombre = Constantes.VIP_VINCULADO_DESCRIPCION;

		if(Constantes.CODIGO_GCO.equalsIgnoreCase(tipo))
			nombre = Constantes.GCO_DESCRIPCION;
		
		if(Constantes.CODIGO_PH.equalsIgnoreCase(tipo))
			nombre = Constantes.PH_DESCRIPCION;
		
		if(Constantes.CODIGO_LCONDUCC.equalsIgnoreCase(tipo))
			nombre = Constantes.NOMBRE_LCONDUCC;

		if(Constantes.CODIGO_GESTOR.equalsIgnoreCase(tipo))
			nombre = "Gestor";
			
		if(Constantes.CODIGO_CENTRO.equalsIgnoreCase(tipo))
			nombre = "Centro";
			
		if(Constantes.CODIGO_ALMACCC.equalsIgnoreCase(tipo))
			nombre = Constantes.NOMBRE_ALMACCC;
		
		if(Constantes.CODIGO_ESTM.equalsIgnoreCase(tipo))
			nombre = Constantes.NOMBRE_ESTM;
		
		if(Constantes.CODIGO_COLECTIVO.equalsIgnoreCase(tipo))
			nombre = "Colectivo";
		
		if(Constantes.CODIGO_VARIOFER.equalsIgnoreCase(tipo))
			nombre = Constantes.NOMBRE_VARIOFER;
		
		try{
			List<Multitabla> lista;
				
			Mensajero correo = new Mensajero();
			correo.setTransport("smtp");
			
			lista = findMultitablaAll(Constantes.JAVA_MAIL_HOST);
			correo.setHost(lista.get(0).getValor1());
			logger.error("JAVA_MAIL_HOST: " + correo.getHost());
			
			correo.setStarttls("true");
			
			lista = findMultitablaAll(Constantes.JAVA_MAIL_PORT);
			correo.setPort(lista.get(0).getValor1());
			logger.error("JAVA_MAIL_PORT: " + correo.getPort());
			
			correo.setAuth("false");
			
			lista = findMultitablaAll(Constantes.JAVA_MAIL_USER);
			correo.setUser(lista.get(0).getValor1());
			logger.error("JAVA_MAIL_USER: " + correo.getUser());
			
			correo.setPassword("");
				
			if(estado.equals(Constantes.ESTADO_CARGA_INICIO)){
				correo.setSubject("Inicio carga " + nombre);
				correo.setText("Se inici" + (char) 243 + " la carga  del archivo de "+nombre+", "+fecha+"");
			}else if(estado.equals(Constantes.ESTADO_CARGA_FIN)){
				ICargaDAO dao = SingletonBeanFactory.getInstancia().getCargaDAO();
				Tiilc_adm_carga_archivo bean = dao.listarCargaArchivo(tipo);
				correo.setSubject("Fin carga " + nombre);
				correo.setText("Se termino la carga  del archivo de "+nombre+", "+fecha+" \n"+
				"Total de Filas le" + (char) 237  + "das: " + bean.getFilas_leidas() + "\n"+
				"Total de Filas Cargadas: " + bean.getFilas_procesadas() + "\n");
				logger.info(correo.getText());
				
			}else if(estado.equals(Constantes.ESTADO_CARGA_ERROR)){
				correo.setSubject("Problemas en la carga " + nombre);
				correo.setText("No se pudo ejecutar el proceso de carga de " + nombre + " porque  no se encontr" + (char) 243 + " el archivo "+nombre+".TXT , "+fecha+"");
			}
			
			lista = findMultitablaAll(Constantes.TIPO_COD_MULT_CORREOS);
			for(Iterator<Multitabla> iter=lista.iterator(); iter.hasNext();){
				Multitabla multiBean=(Multitabla) iter.next();
				correo.clearRecipient();
				correo.addRecipient(multiBean.getValor1());
				logger.error("DESTINATARIO: " + multiBean.getValor1());
				correo.enviar();
			}

		}catch(Exception e){
			logger.error("Error en el envio de correo :" + e.getMessage());
			e.printStackTrace();
		}
	}

	protected java.sql.Connection getConnection(){
		java.sql.Connection connection = null;
		try {
			Context initialContext = new InitialContext();
			if (initialContext != null) {
				DataSource datasource = (DataSource) initialContext.lookup(Constantes.DATASOURCE_CONTEXT);
				if (datasource != null) {
					connection = datasource.getConnection();
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return connection;
	}
	
	public List<Multitabla> findMultitablaAll(String codMult) {
		String sql = "SELECT o.* FROM iilc.tiilc_multitabla o WHERE o.cod_mult=?";
		java.sql.Connection cnn = getConnection();
		CallableStatement stm;
		List<Multitabla> result = new ArrayList<Multitabla>();
		Multitabla multitabla = null;
		try {
			stm = cnn.prepareCall(sql);
			stm.setString(1, codMult);
			
			ResultSet rss = stm.executeQuery();
			
			while(rss.next()) {
				multitabla = new Multitabla();
				multitabla.setCod_mult(rss.getString("cod_mult"));
				multitabla.setCod_ele(rss.getString("cod_ele"));
				multitabla.setValor1(rss.getString("valor1"));
				multitabla.setValor2(rss.getString("valor2"));
				multitabla.setValor3(rss.getString("valor3"));
				multitabla.setValor4(rss.getString("valor4"));
				
				result.add(multitabla);
			}
			
			stm.close();
			cnn.close();
		} catch (SQLException e) {
			logger.error(e);
		} catch (NullPointerException e) {
			logger.error(e);
		}
		
		return result;
	}
	
	public Multitabla findMultitabla(String codMult) {
		List<Multitabla> multitabla = findMultitablaAll(codMult);
		Multitabla result = null;
		
		if(multitabla != null && multitabla.size()>0) {
			result = multitabla.get(0);
		}
				
		return result;
	}
}
