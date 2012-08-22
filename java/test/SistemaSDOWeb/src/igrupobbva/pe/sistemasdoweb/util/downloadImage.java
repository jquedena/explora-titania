package igrupobbva.pe.sistemasdoweb.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

public class downloadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(downloadImage.class);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		generarImagen(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		generarImagen(request, response);
	}

	protected void generarImagen(HttpServletRequest request,
			HttpServletResponse response) {
		File file = null;
		ServletOutputStream out = null;

		System.setProperty("java.awt.headless", "true");
		
		response.reset();
		response.setHeader("Cache-Control","no-store"); //HTTP 1.1
		response.setHeader("Pragma","no-cache"); //HTTP 1.0
		response.setDateHeader("Expires", 0); // prevents caching at the proxy server 
		response.setContentType("image/png");

		try {
			log.info("[downloadImage] Inicio");
			out = response.getOutputStream();
			file = new File(request.getParameter("file"));
			
			if(!file.exists()) {
				return;
			}
			
			ImageIcon iIcon = new ImageIcon(file.toURL());
			BufferedImage bImage = new BufferedImage(iIcon.getIconWidth(), iIcon.getIconHeight(), BufferedImage.TYPE_INT_RGB); 
			Graphics2D graphics = null;
			graphics = bImage.createGraphics();
			
			if(request.getParameter("file").length()==0 || !file.exists()) {
				 bImage = new BufferedImage(150, 170, BufferedImage.TYPE_INT_RGB); 
				graphics.setBackground(Color.WHITE);
				graphics.setColor(Color.BLACK);
				graphics.setFont(new Font("Arial", Font.ITALIC, 12));
				graphics.drawString("Imagen Invalida", 0, 0);
			} else {
				graphics.drawImage(iIcon.getImage(), 0, 0, iIcon.getImageObserver());
			}
			
			// GifEncoder encoder = new GifEncoder(screen, out);
			// encoder.encode();

			ImageIO.write(bImage, "png", out);
			
			out.flush();
			out.close();
			log.info("[downloadImage] Fin");
		} catch (Exception e) {
			log.error(e);
		}
	}
}
