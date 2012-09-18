package com.indra.pe.bbva.core.mail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.indra.pe.bbva.core.exception.ServiceException;
import com.indra.pe.bbva.reauni.mail.Correo;
import com.indra.pe.bbva.reauni.view.helper.ApplicationHelper;

@Component("correoElectronico") 
public class CorreoElectronico {
	
	private static Logger logger = Logger.getLogger(CorreoElectronico.class);
	
	private String servidorCorreo;
	private String emailFrom;
	
	public CorreoElectronico() {
	}

	private BodyPart cuerpoMensaje(String mensaje, MimeMultipart mimeMultipart) throws Exception {
		BodyPart body = new MimeBodyPart();
		body.setContent(mensaje, "text/html");
		mimeMultipart.addBodyPart(body);
		return body;
	}
	
	private BodyPart cuerpoMensaje(File file) throws Exception {
		BodyPart body = new MimeBodyPart();
		try {
	    	body.setDataHandler(new DataHandler(new FileDataSource(file)));
	    	body.setFileName(file.getName());
		} catch (MessagingException e) {
			throw new Exception(e);
		}
		return body;
	}
	
	
	
	public MimeMultipart adjuntarArchivo(String mensaje, MimeMultipart mimeMultipart, String fileName) throws Exception{
		
		if(mensaje != null && mensaje.trim().length() > 0 && fileName != null && fileName.length() > 0) {
			File file = null;
			file = new File(fileName);					
			file.createNewFile(); 
			
			try {
				FileOutputStream out = new FileOutputStream(file);
				out.write(mensaje.getBytes());
				out.close();
			    
			    if (file!=null) {
			    	mimeMultipart.addBodyPart(cuerpoMensaje(file));
			    }
			} catch (MessagingException e) {
				throw new Exception(e);
			}catch (IOException e){
				throw new Exception(e);
			}
		}
		
		return mimeMultipart;
	}
	
	public MimeMultipart adjuntarArchivo(File file, MimeMultipart mimeMultipart) throws Exception{
		
		if (file != null) {
			try { 			     
				mimeMultipart.addBodyPart(cuerpoMensaje(file));
			} catch (MessagingException e) {
				throw new Exception(e);
			}
		}
		
		return mimeMultipart;
	}
	
	public void enviar(Correo beanCorreo) throws ServiceException {
		try {
			this.servidorCorreo = ApplicationHelper.obtenerParametroPorId(1041L).getValorCadena();
			this.emailFrom = ApplicationHelper.obtenerParametroPorId(1042L).getValorCadena();	
			String puerto = ApplicationHelper.obtenerParametroPorId(1043L).getValorCadena();
			
			if (puerto==null || puerto.length()==0) {
				puerto = "25";
			}
			
			Properties propiedades =   new Properties();
			propiedades.put("mail.smtp.host", servidorCorreo);
			propiedades.put("mail.smtp.auth", "true");
			propiedades.put("mail.debug", "false");
			propiedades.put("mail.smtp.port", puerto);

			Session session = Session.getInstance(propiedades, 
					new javax.mail.Authenticator() { 
						protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(emailFrom, "");
					}
				}
			);
			
			MimeMessage message = new MimeMessage(session);
			if(beanCorreo.getEmailFrom() == null) {
				message.setFrom(new InternetAddress(emailFrom,"REASIGNACIÓN Y UNIFICACIÓN ONLINE"));
			} else {
				message.setFrom(new InternetAddress(beanCorreo.getEmailFrom(), beanCorreo.getFrom()));
			}
			
			message.addRecipients(Message.RecipientType.TO,beanCorreo.getListaTo());
			
			if(beanCorreo.getListaCc() != null && beanCorreo.getListaCc().length() > 0) {
				message.addRecipients(Message.RecipientType.CC,beanCorreo.getListaCc());
			}
			
			message.setSubject(beanCorreo.getAsunto());
			
			MimeMultipart cuerpo = new MimeMultipart();
			if(beanCorreo.getMensajeAdjunto() != null) {
				cuerpoMensaje(beanCorreo.getMensaje() + "<p>&nbsp;</p>" + beanCorreo.getMensajeAdjunto(), cuerpo);
			} else {
				cuerpoMensaje(beanCorreo.getMensaje(), cuerpo);
			}
			// adjuntarArchivo(beanCorreo.getMensajeAdjunto(), cuerpo, beanCorreo.getFileName());
			adjuntarArchivo(beanCorreo.getMensajeAdjuntoExcel(), cuerpo);
			adjuntarArchivo(beanCorreo.getMensajeAdjuntoExcel2(), cuerpo);
			
			message.setContent(cuerpo);
			
			Transport.send(message);
		}  catch (MessagingException e) {
			logger.error("Error en la creacion del mensaje en el envio de correo ", e);
			throw new ServiceException(e.getMessage(),e);
		}  catch (UnsupportedEncodingException e) {
			logger.error("Error de codificacion en el envio de correo ", e);
			throw new ServiceException(e.getMessage(), e);
		}  catch (Exception e) {
			logger.error("Error al enviar el correo ", e);
			throw new ServiceException(e.getMessage(), e);
		}
	}
}