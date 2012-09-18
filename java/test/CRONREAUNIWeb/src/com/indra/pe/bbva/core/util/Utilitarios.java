package com.indra.pe.bbva.core.util;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;

@SuppressWarnings({"rawtypes", "unused", "unchecked"})
public class Utilitarios {
	private static Logger logger = Logger.getLogger(Utilitarios.class);

    public static class General {

        public static void ordena(List lista, final String propiedad) {
            Collections.sort(lista, new Comparator() {

                public int compare(Object obj1, Object obj2) {

                    Class clase = obj1.getClass();
                    String getter = "get" + Character.toUpperCase(propiedad.charAt(0)) + propiedad.substring(1);
                    try {
                        Method getPropiedad = clase.getMethod(getter);

                        Object propiedad1 = getPropiedad.invoke(obj1);
                        Object propiedad2 = getPropiedad.invoke(obj2);

                        if (propiedad1 instanceof Comparable && propiedad2 instanceof Comparable) {
                            Comparable prop1 = (Comparable) propiedad1;
                            Comparable prop2 = (Comparable) propiedad2;
                            return prop1.compareTo(prop2);
                        }//CASO DE QUE NO SEA COMPARABLE  
                        else {
                            if (propiedad1.equals(propiedad2)) {
                                return 0;
                            } else {
                                return 1;
                            }

                        }

                    } catch (Exception e) {
                        logger.error("Error en utilitario ", e);
                    }
                    return 0;
                }
            });
        }

        public static String obtenerSeparadorDirectorioOS() {
            String separador = File.separator;
            return separador;
        }

        public static String obtenerRutaJavaHome() {
            String ruta = null;
            ruta = System.getProperty("java.home");
            return ruta;
        }

        public static String obtenerSistemaOperativo() {
            String plataforma = "";
            String tmp = System.getProperty("os.name").toUpperCase();

            if (tmp.indexOf("WINDOWS") != -1) {
                plataforma = "WINDOWS";
            } else if (tmp.indexOf("LINUX") != -1) {
                plataforma = "LINUX";
            } else {
                plataforma = "OTHERS";
            }

            return plataforma;
        }

        public static boolean in(Object valor, Object... in) {
            boolean retorno = false;
            for (Object o : in) {
                if (o.equals(valor)) {
                    retorno = true;
                }
            }
            return retorno;
        }

        public static String obtenerVersionJava() {
            String plataforma = "";

            plataforma = System.getProperty("java.version");

            return plataforma;
        }
    }

    public static class Fecha {

        /**
         * Retorna diferencia en dias entre dos fechas
         * @param antes
         * @param despues
         * @return 
         */
        public static int diferenciaDiasFechas(Date antes, Date despues) {
            long diff = despues.getTime() - antes.getTime();
            return Math.round(diff / (1000 * 60 * 60 * 24.0f));
        }
        
        public static int diferenciaFechasSegundos(Date antes, Date despues) {
        	if (despues == null) {
        		despues = Fecha.obtenerFechaActualDate();
        	}
            long diff = despues.getTime() - antes.getTime();
            return Math.round(diff / (1000));
        }
        
        public static int diferenciaFechasMinutos(Date antes, Date despues) {
            long diff = despues.getTime() - antes.getTime();
            return Math.round(diff / (1000*60));
        }

        public static String obtenerFechaActual() { // sacar el fecha de hoy
            Calendar calendario = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(Constantes.formatoFecha);
            return sdf.format(calendario.getTime());
        }

        public static String obtenerFechaHoraActual() { // sacar el fecha de hoy
            Calendar calendario = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(Constantes.formatoFechaHora);
            return sdf.format(calendario.getTime());
        }

        public static Date obtenerFechaActualDate() { // sacar el fecha de hoy
            Calendar calendario = Calendar.getInstance();
            return calendario.getTime();
        }

        public static String formatearFecha(Date fecha, String formato) {
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            return sdf.format(fecha);
        }

        public static String obtenerHoraActual() { // sacar la hora actual
            Calendar calendario = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(Constantes.formatoHora);
            return sdf.format(calendario.getTime());
        }

        public static int obtenerMesActual() {
            Calendar calendario = Calendar.getInstance();
            calendario = Calendar.getInstance();
            return calendario.get(Calendar.MONTH);
        }

        public static int obtenerDiaActual() {
            Calendar calendario = Calendar.getInstance();
            calendario = Calendar.getInstance();
            return calendario.get(Calendar.DATE);
        }

        public static int obtenerAnioActual() {
            Calendar calendario = Calendar.getInstance();
            calendario = Calendar.getInstance();
            return calendario.get(Calendar.YEAR);
        }

        public static Date construirFecha(int ano, int mes, int dia) {
            Calendar calendario = Calendar.getInstance();
            calendario.set(ano, mes, dia);
            return calendario.getTime();
        }

        public static Date construirFecha(int ano, int mes, int dia, int hora, int min, int seg) {
            Calendar calendario = Calendar.getInstance();
            calendario.set(ano, mes, dia, hora, min, seg);
            return calendario.getTime();
        }

        public static String agregarDiasFechaActual(int dias) {
            Calendar calendario = Calendar.getInstance();
            calendario.add(Calendar.DATE, dias);
            SimpleDateFormat sdf = new SimpleDateFormat(Constantes.formatoFecha);
            return sdf.format(calendario.getTime());
        }

        public static Date agregarDiasFechaActualDate(int dias) {
            Calendar calendario = Calendar.getInstance();
            calendario.add(Calendar.DATE, dias);
            return calendario.getTime();
        }

        public static Date agregarDiasFechaDate(Date fecha, int dias) {
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fecha);
            calendario.add(Calendar.DATE, dias);
            return calendario.getTime();
        }

        public static Date agregarMesesFecha(Date date, int meses) {
            Calendar calendario = Calendar.getInstance();
            Date retorno = null;
            calendario.setTime(date);
            calendario.add(Calendar.MONTH, meses);
            retorno = calendario.getTime();
            return retorno;
        }

        public static Date agregarAniosFecha(Date date, int anios) {
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(date);
            calendario.add(Calendar.YEAR, anios);
            return calendario.getTime();
        }
    }

    public static class Cadena {

        public static String rPad(String s, int total, char c) {
            int longitud = s.length();
            if (longitud < total) {
                int falta = total - longitud;
                for (int i = 0; i < falta; i++) {
                    s += c;
                }
            }
            return s;
        }

        /** Concatena caracteres por la izquierda */
        public static String lPad(String s, int total, char c) {
            int longitud = s.length();
            String cadena1 = "";
            if (longitud < total) {
                int falta = total - longitud;
                for (int i = 0; i < falta; i++) {
                    cadena1 += c;
                }
            }
            cadena1 += s;
            return cadena1;
        }

        /** Elimina caracteres encontrados */
        public static String eliminarCaracter(String cad, char car) {
            String s = "";
            char c;
            for (int i = 0; i < cad.length(); i++) {
                c = cad.charAt(i);
                if (c != car) {
                    s += c;
                }
            }
            return s;
        }

        /** Retorna una l�nea de caracteres de longitud especificada. */
        public static String formarCadena(char c, int n) {
            char x[] = new char[n];
            if (n <= 0) {
                return "";
            }
            int j = 0;
            while (j < n) {
                x[j] = c;
                j++;
            }
            String s = new String(x);
            return s;
        }
    }

    public static class Propiedades {

        public static String obtenerValorKeyPropertie(String archivoPropertie, String clave) {
            String retorno = "";
            Properties prop = new Properties();
            InputStream is = null;

            try {
                String rutaArchivo = Constantes.directorioPrincipal + archivoPropertie;
                is = new FileInputStream(rutaArchivo);
                prop.load(is);
                retorno = prop.getProperty(clave);
            } catch (IOException ioe) {
                logger.error("Error en utilitario " + ioe.getMessage());
            }
            return retorno;
        }

        public static Properties obtenerArchivoPropertie(String archivo) {
            Properties prop = new Properties();
            InputStream is = null;
            try {
                is = new FileInputStream(archivo);
                prop.load(is);
            } catch (FileNotFoundException e) {
                prop = null;
            } catch (IOException e) {
                prop = null;
            }
            return prop;

        }

        public static String obtenerValorPropertie(String archivo, String key) {
            String valor = null;
            Properties prop = obtenerArchivoPropertie(archivo);

            try {
                valor = prop.getProperty(key);
            } catch (Exception e) {
                valor = null;
            }

            return valor;

        }

        public static String obtenerValorPropertie(String key) {
            String valor = null;
            Properties prop = obtenerArchivoPropertie(Constantes.archivoConfiguracion);

            try {
                valor = prop.getProperty(key);
            } catch (Exception e) {
                valor = null;
            }

            return valor;

        }
    }

    public static class Debug {

        public static int getLineaActual() {
            return Thread.currentThread().getStackTrace()[2].getLineNumber();
        }

        public static String getMetodoActual() {
            return Thread.currentThread().getStackTrace()[2].getMethodName();
        }

        public static String getClaseActual() {
            return Thread.currentThread().getStackTrace()[2].getClassName();
        }

        public static int getLineaAnterior() {
            return Thread.currentThread().getStackTrace()[3].getLineNumber();
        }

        public static String getMetodoAnterior() {
            return Thread.currentThread().getStackTrace()[3].getMethodName();
        }

        public static String getClaseAnterior() {
            return Thread.currentThread().getStackTrace()[3].getClassName();
        }
    }

    public static class Numero {

        public static double round(double val, int places) {
            long factor = (long) Math.pow(10, places);

            // Shift the decimal the correct number of places
            // to the right.
            val = val * factor;

            // Round to the nearest integer.
            long tmp = Math.round(val);

            // Shift the decimal the correct number of places
            // back to the left.
            return (double) tmp / factor;
        }

        public static Float round(Float val, int places) {
            double d = round(val.doubleValue(), places);
            return new Float(d);
            // return new Float(tmp / factor);
        }

        public static String redondear(double numero) { // redonear un n�mero real a
            // 2 d�gitos decimales
            return Constantes.dfDouble.format(numero);
        }

        public static Double redondear(Double numero) { // redonear un n�mero real a
            // 2 d�gitos decimales
            return Double.parseDouble(Constantes.dfDouble.format(numero));
        }

        public static String redondear(int numero) {
            return Constantes.dfInteger.format(numero);
        }

        public static String redondear(long numero) {
            return Constantes.dfInteger.format(numero);
        }

        public static String formatearDouble(String patron, double dato) {
            DecimalFormat formato = new DecimalFormat(patron);
            String salida = formato.format(dato);
            return salida;
        }
    }

    public static class Mail {

        public static String enviarEmail(String asunto, String cuerpo,
                InternetAddress... destinos) {
            String retorno = null;
            try {
                Session session = obtenerSession(obtenerConfiguracion());
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("sion.e.a.s@gmail.com"));
                //msg.setHeader("X-Mailer", "sendhtml");

                // message.setRecipients(Message.RecipientType.TO,
                // InternetAddress.parse("rchang@axlefinancial.com"));

                message.setRecipients(Message.RecipientType.TO, destinos);
                message.setSubject(asunto);
                message.setText(cuerpo);
                message.removeHeader("Content-Type");
                message.addHeader("Content-Type", "text/html");
                Transport.send(message);

                retorno = "Envio de email satisfactorio!!!";

            } catch (MessagingException e) {
                retorno = e.getMessage();
            }
            return retorno;
        }

        public static String enviarEmail(String asunto, String cuerpo,
                File archivoAdjunto, InternetAddress... destinos) {
            String retorno = null;
            try {
                Session session = obtenerSession(obtenerConfiguracion());
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("sion.e.a.s@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, destinos);
                message.setSubject(asunto);
                message.setText(cuerpo);
                message.removeHeader("Content-Type");
                message.addHeader("Content-Type", "text/html");

                Multipart mp = new MimeMultipart();

                FileDataSource fds = new FileDataSource(archivoAdjunto);
                MimeBodyPart mbp = new MimeBodyPart();
                mbp.setDataHandler(new DataHandler(fds));
                mbp.setFileName(fds.getName());
                mp.addBodyPart(mbp);
                message.setContent(mp);

                Transport.send(message);

                retorno = "Envio de email satisfactorio!!!";

            } catch (MessagingException e) {
                retorno = e.getMessage();
            }
            return retorno;
        }

        private static Properties obtenerConfiguracion() {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            return props;
        }

        private static Session obtenerSession(Properties props) {
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {

                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("sion.e.a.s",
                                    "pashercno");
                        }
                    });

            return session;
        }
    }

    public static class Seguridad {

        public static void encriptarArchivo(String archivo) {
            try {
                File desFile = new File(archivo);
                FileInputStream fis;
                FileOutputStream fos;
                CipherInputStream cis;
                // Creaciòn de llave sercreta
                byte key[] = "abcdEFGH".getBytes();
                SecretKeySpec secretKey = new SecretKeySpec(key, "DES");
                // Creacion de objetos de cifrado
                Cipher encrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
                encrypt.init(Cipher.ENCRYPT_MODE, secretKey);
                // abriendo el archivo Plaintext
                fis = new FileInputStream(desFile);
                cis = new CipherInputStream(fis, encrypt);

                // Escribiendo el archivo encriptado

                fos = new FileOutputStream(desFile.getParent() + desFile.getName()
                        + ".sion");
                byte[] b = new byte[8];
                int i = cis.read(b);
                while (i != -1) {
                    fos.write(b, 0, i);
                    i = cis.read(b);
                }
                fos.flush();
                fos.close();
                cis.close();
                fis.close();
            } catch (Exception e) {
                logger.error("Error en utilitario ", e);
                javax.swing.JOptionPane.showMessageDialog(null,
                        "Imposible abrir el archivo!!!, o nombre incorrecto");
            }
        }

        public static void desencriptarArchivo(String archivoEncriptado,
                String archivoDesencriptado) {
            try {
                File desFile = new File(archivoEncriptado);
                File desFileBis = new File(archivoDesencriptado);
                FileInputStream fis;
                FileOutputStream fos;
                CipherInputStream cis;

                byte key[] = "abcdEFGH".getBytes();
                SecretKeySpec secretKey = new SecretKeySpec(key, "DES");
                Cipher decrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
                decrypt.init(Cipher.DECRYPT_MODE, secretKey);
                fis = new FileInputStream(desFile);
                cis = new CipherInputStream(fis, decrypt);
                fos = new FileOutputStream(desFileBis);
                byte[] b = new byte[8];
                int i = cis.read(b);
                while (i != -1) {
                    fos.write(b, 0, i);
                    i = cis.read(b);
                }
                fos.flush();
                fos.close();
                cis.close();
                fis.close();

            } catch (Exception e) {
                logger.error("Error en utilitario ", e);
            }
        }
        private static final byte[] SALT_BYTES = {(byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03};
        private static final int ITERATION_COUNT = 19;
        private static String sKeyPhrase = "abcdEFGH";

        public static String encriptarTexto(String textoDesencriptado) {
            Cipher oECipher = null;
            Cipher oDCipher = null;
            String sStringValue = textoDesencriptado;
            try {
                // Crear la key
                KeySpec oKeySpec = new PBEKeySpec(sKeyPhrase.toCharArray(), SALT_BYTES, ITERATION_COUNT);
                SecretKey oKey = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(oKeySpec);
                oECipher = Cipher.getInstance(oKey.getAlgorithm());
                oDCipher = Cipher.getInstance(oKey.getAlgorithm());

                // Preparar los parametros para los ciphers
                AlgorithmParameterSpec oaramSpec = new PBEParameterSpec(SALT_BYTES, ITERATION_COUNT);

                // Crear los ciphers
                oECipher.init(Cipher.ENCRYPT_MODE, oKey, oaramSpec);
                oDCipher.init(Cipher.DECRYPT_MODE, oKey, oaramSpec);

                // Encodear la cadena a bytes usando UTF-8
                byte[] oUTF8 = sStringValue.getBytes("UTF8");

                // Encriptar
                byte[] oEnc = oECipher.doFinal(oUTF8);

                // Encodear bytes a base64 para obtener cadena
                return new BASE64Encoder().encode(oEnc);
            } catch (Exception oE1) {
            	logger.error("Error en utilitario " + oE1.getMessage());
            }
            return null;
        }

        public static String desencriptarTexto(String textoEncriptado) {
            Cipher oECipher = null;
            Cipher oDCipher = null;
            String sStringValue = textoEncriptado;
            try {
                // Crear la key
                KeySpec oKeySpec = new PBEKeySpec(sKeyPhrase.toCharArray(), SALT_BYTES, ITERATION_COUNT);
                SecretKey oKey = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(oKeySpec);
                oECipher = Cipher.getInstance(oKey.getAlgorithm());
                oDCipher = Cipher.getInstance(oKey.getAlgorithm());

                // Preparar los parametros para los ciphers
                AlgorithmParameterSpec oParamSpec = new PBEParameterSpec(SALT_BYTES, ITERATION_COUNT);

                // Crear los ciphers
                oECipher.init(Cipher.ENCRYPT_MODE, oKey, oParamSpec);
                oDCipher.init(Cipher.DECRYPT_MODE, oKey, oParamSpec);

                // Decodear base64 y obtener bytes
                byte[] oDec = new sun.misc.BASE64Decoder().decodeBuffer(sStringValue);

                // Desencriptar
                byte[] oUTF8 = oDCipher.doFinal(oDec);

                // Decodear usando UTF-8
                return new String(oUTF8, "UTF8");
            } catch (Exception oE1) {
            	logger.error("Error en utilitario " + oE1.getMessage());
            }
            return null;
        }
    }

    public static class Archivo {

        public static String obtenerExtensionArchivo(File file) {
            String nombreConExtension = file.getName();
            int tamanoCompleto = nombreConExtension.length();
            return "";
        }

        public static void renombrarArchivo(File archivoInicial, String nombreFinal) {
            File newFile = new File(archivoInicial.getParent() + nombreFinal);
            archivoInicial.renameTo(newFile);
        }

        public static void renombrarDirectorio(File directorioInicial, String nombreFinal) {

            File newDirectorio = new File(directorioInicial.getParent() + nombreFinal);
            directorioInicial.renameTo(newDirectorio);
        }

        public static File convertirStringToFile(String cadena) {
            File f = null;

            return f;
        }

        public static String convertirFileToString(File archivo) {
            String f = null;
            return f;
        }

        public static void comprimirArchivo(String archivoDescomprimido) {
            try {
                File f = new File(archivoDescomprimido);
                ZipOutputStream os = new ZipOutputStream(new FileOutputStream(f.getParent() + f.getName()
                        + ".zip"));
                os.setLevel(Deflater.DEFAULT_COMPRESSION);
                os.setMethod(Deflater.DEFLATED);

                ZipEntry entrada = new ZipEntry(new File(archivoDescomprimido).getName());
                os.putNextEntry(entrada);

                FileInputStream fis = new FileInputStream(archivoDescomprimido);
                byte[] buffer = new byte[1024];
                int leido = 0;
                while (0 < (leido = fis.read(buffer))) {
                    os.write(buffer, 0, leido);
                }

                fis.close();
                os.closeEntry();

                os.close();

            } catch (FileNotFoundException e) {
                logger.error("Error en utilitario ", e);
            } catch (IOException e) {
                logger.error("Error en utilitario ", e);
            }
        }

        public static String obtenerUltimoNivel(String rutaInicial) {
            File f = new File(rutaInicial);
            File fN = new File(rutaInicial + "\\" + f.list()[0]);
            String salida = "";

            if (fN.isDirectory()) {
                salida = obtenerUltimoNivel(fN.getAbsolutePath());
            } else {
                return fN.getParent();
            }
            return salida;

        }

        public static String[] archivosAComprimir() {
            File f = new File("D:\\test\\");
            String[] sL = new String[f.list().length];
            for (int i = 0; i < f.list().length; i++) {
                sL[i] = "D:/test/" + f.list()[i];

            }
            comprimirArchivo("D:\\test\\tres.zip", sL);
            return f.list();


        }

        public static void comprimirArchivo(String salidaComprimido, String... archivosDescomprimidos) {
            try {
                File f = new File(salidaComprimido);
                ZipOutputStream os = new ZipOutputStream(new FileOutputStream(f.getParent() + f.getName()));
                os.setLevel(Deflater.DEFAULT_COMPRESSION);
                os.setMethod(Deflater.DEFLATED);

                for (String arc : archivosDescomprimidos) {
                    ZipEntry entrada = new ZipEntry(new File(arc).getName());
                    os.putNextEntry(entrada);

                    FileInputStream fis = new FileInputStream(arc);
                    byte[] buffer = new byte[1024];
                    int leido = 0;
                    while (0 < (leido = fis.read(buffer))) {
                        os.write(buffer, 0, leido);
                    }

                    fis.close();
                    os.closeEntry();
                }
                os.close();

            } catch (FileNotFoundException e) {
                Log.error(e);
            } catch (IOException e) {
                Log.error(e);
            }
        }

        public static void descomprimirArchivo(String archivoComprimido) {
            try {

                ZipInputStream zis = new ZipInputStream(new FileInputStream(archivoComprimido));
                ZipEntry entrada;
                while (null != (entrada = zis.getNextEntry())) {
                    FileOutputStream fos = new FileOutputStream(new File(archivoComprimido).getParent() + entrada.getName());
                    int leido;
                    byte[] buffer = new byte[1024];
                    while (0 < (leido = zis.read(buffer))) {
                        fos.write(buffer, 0, leido);
                    }
                    fos.close();
                    zis.closeEntry();
                }
                zis.close();


            } catch (FileNotFoundException e) {
                Log.error(e);
            } catch (IOException e) {
                Log.error(e);
            }
        }

        /**
         *
         * @param archivoDestino
         *            Archivo donde copiar el Archivo Origen
         * @param archivoOrigen
         *            Archivo a copiar
         * @throws IOException
         */
        public static void copiarArchivoHD(File archivoDestino, File archivoOrigen) {
            FileOutputStream fos;
            try {
                fos = new FileOutputStream(archivoDestino);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                FileInputStream isr = new FileInputStream(archivoOrigen);
                BufferedInputStream bis = new BufferedInputStream(isr);
                int i;
                while ((i = bis.read()) != -1) {
                    bos.write(i);
                }
                isr.close();
                bis.close();
                bos.close();
                bos.flush();
            } catch (FileNotFoundException e) {
                logger.error("Error en utilitario ", e);
            } catch (IOException e) {
                logger.error("Error en utilitario ", e);
            }
        }

        public static void copiarArchivoHD(File archivoDestino, byte[] archivo) {
            FileOutputStream fos;
            BufferedOutputStream bos;
            try {
                fos = new FileOutputStream(archivoDestino);
                bos = new BufferedOutputStream(fos);
                fos.write(archivo);
                bos.close();
                bos.flush();
            } catch (FileNotFoundException e) {
                logger.error("Error en utilitario ", e);
            } catch (IOException e) {
                logger.error("Error en utilitario ", e);
            }
        }

        static public void comprimirCarpeta(String carpetaComprimir, String zipSalida) throws Exception {
            ZipOutputStream zip = null;
            FileOutputStream fileWriter = null;

            fileWriter = new FileOutputStream(zipSalida);
            zip = new ZipOutputStream(fileWriter);

            addFolderToZip("", carpetaComprimir, zip);
            zip.flush();
            zip.close();
        }

        static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
                throws Exception {

            File folder = new File(srcFile);
            if (folder.isDirectory()) {
                addFolderToZip(path, srcFile, zip);
            } else {
                byte[] buf = new byte[1024];
                int len;
                FileInputStream in = new FileInputStream(srcFile);
                zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
                while ((len = in.read(buf)) > 0) {
                    zip.write(buf, 0, len);
                }
            }
        }

        static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
                throws Exception {
            File folder = new File(srcFolder);

            for (String fileName : folder.list()) {
                if (path.equals("")) {
                    addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
                } else {
                    addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
                }
            }
        }
    }

    public static class Internacionalizacion {

        private static ClassLoader getCurrentClassLoader(Object defaultObject) {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            if (loader == null) {
                loader = defaultObject.getClass().getClassLoader();
            }
            return loader;
        }

        private static String getMessageResourceString(String bundleName,
                String key, Object params[], Locale locale) {
            String text = null;
            ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale,
                    getCurrentClassLoader(params));
            try {
                text = bundle.getString(key);
            } catch (MissingResourceException e) {
                text = "?? key " + key + " not found ??";
            }
            if (params != null) {
                MessageFormat mf = new MessageFormat(text, locale);
                text = mf.format(params, new StringBuffer(), null).toString();
            }
            return text;
        }

        public static String getMensajeInternacional(String key, Object params[]) {
            String msj = "";
            FacesContext context = FacesContext.getCurrentInstance();

            String text = getMessageResourceString(context.getApplication().getMessageBundle(), key, params, context.getViewRoot().getLocale());
            msj = text;
            return msj;
        }

        public static String getMensajeInternacional(String key, String... parametros) {
            String msj = "";
            FacesContext context = FacesContext.getCurrentInstance();

            String text = getMessageResourceString(context.getApplication().getMessageBundle(), key, parametros, context.getViewRoot().getLocale());
            msj = text;
            return msj;
        }
    }

    public static class Web {

        public static void addInfo(String msjResumen) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, msjResumen, null);
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }

        public static void addInfo(String msjResumen, String msjDetalle) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, msjResumen, msjDetalle);
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }

        public static void addWarn(String msjResumen) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_WARN, msjResumen, null);
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }

        public static void addWarn(String msjResumen, String msjDetalle) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_WARN, msjResumen, msjDetalle);
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }

        public static void addError(String msjResumen) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, msjResumen, null);
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }

        public static void addError(String msjResumen, String msjDetalle) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, msjResumen, msjDetalle);
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }

        public static void addFatal(String msjResumen) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_FATAL, msjResumen, null);
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }

        public static void addFatal(String msjResumen, String msjDetalle) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_FATAL, msjResumen, msjDetalle);
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }

    public static class Log {

        public static void error(Exception ex, String... mensajes) {
            if (Constantes.logError) {
                StringBuilder sb = new StringBuilder();
                sb.append("[ERROR-SION]-");
                sb.append(Fecha.obtenerFechaHoraActual());
                sb.append("[CLASE = ");
                sb.append(ex.getStackTrace()[0].getClassName());
                sb.append("][METODO = ");
                sb.append(ex.getStackTrace()[0].getMethodName());
                sb.append("][LINEA = ");
                sb.append(ex.getStackTrace()[0].getLineNumber());
                sb.append("]");
                for (String msj : mensajes) {
                    sb.append(Constantes.separadorLog);
                    sb.append(msj);
                }
                sb.append("\n");
                sb.append(ex);
                sb.append("\n\n");
                System.err.println(sb);
            }
        }

        public static void error(String... mensajes) {
            if (Constantes.logError) {
                StringBuilder sb = new StringBuilder();
                sb.append("[ERROR-SION]-");
                sb.append(Fecha.obtenerFechaHoraActual());
                sb.append("[CLASE = ");
                sb.append(Debug.getClaseAnterior());
                sb.append("][METODO = ");
                sb.append(Debug.getMetodoAnterior());
                sb.append("][LINEA = ");
                sb.append(Debug.getLineaAnterior());
                sb.append("]");
                for (String msj : mensajes) {
                    sb.append(Constantes.separadorLog);
                    sb.append(msj);
                }
                sb.append("\n\n");
                System.err.println(sb);
            }
        }

        public static void debug(String... mensajes) {
            if (Constantes.logDebug) {
                StringBuilder sb = new StringBuilder();
                sb.append("[DEBUG-SION]-");
                sb.append(Fecha.obtenerFechaHoraActual());
                sb.append("[CLASE = ");
                sb.append(Debug.getClaseAnterior());
                sb.append("][METODO = ");
                sb.append(Debug.getMetodoAnterior());
                sb.append("][LINEA = ");
                sb.append(Debug.getLineaAnterior());
                sb.append("]");
                for (String msj : mensajes) {
                    sb.append(Constantes.separadorLog);
                    sb.append(msj);
                }
                sb.append("\n\n");


            }
        }

        public static void info(String... mensajes) {
            if (Constantes.logInfo) {
                StringBuilder sb = new StringBuilder();
                sb.append("[INFO-SION]-");
                sb.append(Fecha.obtenerFechaHoraActual());
                sb.append("[CLASE = ");
                sb.append(Debug.getClaseAnterior());
                sb.append("][METODO = ");
                sb.append(Debug.getMetodoAnterior());
                sb.append("][LINEA = ");
                sb.append(Debug.getLineaAnterior());
                sb.append("]");
                for (String msj : mensajes) {
                    sb.append(Constantes.separadorLog);
                    sb.append(msj);
                }
                sb.append("\n\n");


            }
        }

        public static void warn(String... mensajes) {
            if (Constantes.logWarn) {
                StringBuilder sb = new StringBuilder();
                sb.append("[WARN-SION]-");
                sb.append(Fecha.obtenerFechaHoraActual());
                sb.append("[CLASE = ");
                sb.append(Debug.getClaseAnterior());
                sb.append("][METODO = ");
                sb.append(Debug.getMetodoAnterior());
                sb.append("][LINEA = ");
                sb.append(Debug.getLineaAnterior());
                sb.append("]");
                for (String msj : mensajes) {
                    sb.append(Constantes.separadorLog);
                    sb.append(msj);
                }
                sb.append("\n\n");

            }
        }
    }

    public static class Validacion {

        public static boolean esEntero(String s) {
            Pattern p = Pattern.compile(Constantes.ES_FORMATO_ENTERO);
            Matcher m = p.matcher(s);
            return m.matches();
        }

        /*
         * Devuelve true si la cadena tiene s�lo un n�mero entero con o sin signo,
         * de lo contrario devuelve false.
         */
        public static boolean esEnteroConSigno(String s) {
            Pattern p = Pattern.compile(Constantes.ES_FORMATO_ENTERO);
            Matcher m = p.matcher(s);
            return m.matches();
        }

        /*
         * Devuelve true si la cadena tiene un n�mero entero o real con o sin signo,
         * de lo contrario devuelve false.
         */
        public static boolean esReal(String s) {
            Pattern p = Pattern.compile(Constantes.ES_FORMATO_REAL);
            Matcher m = p.matcher(s);
            return m.matches();
        }

        /*
         * Devuelve true si la cadena tiene un n�mero entero o real, de lo contrario
         * devuelve false.
         */
        public static boolean esRealConSigno(String s) {
            Pattern p = Pattern.compile(Constantes.ES_FORMATO_REAL_SIGNO);
            Matcher m = p.matcher(s);
            return m.matches();
        }

        /*
         * Devuelve true si la cadena representa un email correcto, de lo contrario
         * devuelve false.
         */
        public static boolean esEmail(String s) {
            Pattern p = Pattern.compile(Constantes.ES_FORMATO_EMAIL);
            Matcher m = p.matcher(s);
            return m.matches();
        }

        /*
         * Devuelve true si la cadena tiene s�lo n�meros, letras o espacios en
         * blanco, de lo contrario devuelve false.
         */
        public static boolean esAlphaNumerico(String s) {
            Pattern p = Pattern.compile(Constantes.ES_FORMATO_ALFA_NUMERICO);
            Matcher m = p.matcher(s);
            return m.matches();
        }

        /*
         * Devuelve true si la cadena tiene s�lo letras o espacios en blanco, de lo
         * contrario devuelve false.
         */
        public static boolean esCadena(String s) {
            Pattern p = Pattern.compile(Constantes.ES_FORMATO_TEXTO);
            Matcher m = p.matcher(s);
            return m.matches();
        }

        /*
         * Devuelve una cadena sin los caracteres que no sean n�meros, letras o
         * espacios en blanco en la cadena original.
         */
        public static String soloAlphaNumerico(String s) {
            Pattern p = Pattern.compile(Constantes.ES_FORMATO_SOLO_ALFA_NUMERICO);
            Matcher m = p.matcher(s);
            return m.replaceAll("");
        }

        /*
         * Devuelve true si la cadena tiene el formato de una hora (hh:mm), de lo
         * contrario devuelve false.
         */
        public static boolean esHora(String texto) {
            Pattern p = Pattern.compile(Constantes.ES_FORMATO_HORA);
            Matcher m = p.matcher(texto);
            boolean valor = m.matches();

            if (valor == true) {
                return true;
            }
            return false;
        }

        public static boolean esFormatoFecha(String fecha, String separador) {
            String campo = fecha;

            if (campo.length() > 0) {
                if (campo.length() != 10) {

                    return false;
                }
                // saca de la fecha dia, mes y a�o
                String[] fech1 = campo.split("[" + separador + "]");
                // comprueba que haya introducido el formato dd-mm-yyyy, con el
                // separador
                // especificado
                if (fech1.length < 3) {

                    return false;
                }
                int dia = new Integer(fech1[0]).intValue();
                int mes = new Integer(fech1[1]).intValue();
                int anio = new Integer(fech1[2]).intValue();
                // el mes debe estar entre 1 y 12
                if (mes < 1 || mes > 12) {

                    return false;
                }
                // comprueba que el a�o este entre 1900 y 2099
                if (anio < 1000 || anio > 9999) {

                    return false;
                }
                // comprueba el numero de dias dependiendo del mes
                if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8
                        || mes == 10 || mes == 12) {
                    if (dia < 1 || dia > 31) {

                        return false;
                    }
                }
                if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    if (dia < 1 || dia > 30) {

                        return false;
                    }
                }
                if (mes == 2) {
                    if (anio % 4 == 0) {
                        if (dia > 29) {

                            return false;
                        }
                    } else if (anio % 100 == 0 && anio % 400 > 0) {
                        if (dia > 29) {

                            return false;
                        }
                    } else {
                        if (dia > 28) {

                            return false;
                        }
                    }
                }
            } else {
                return false;
            }
            return true;

        }
    }

    public static class ConvertirNumeroATexto {

        public static String convertNumberToLetter(String number) {
            return convertNumberToLetter(Double.parseDouble(number));
        }

        /**
         * Convierte un numero en representacion numerica a uno en representacion de
         * texto. El numero es valido si esta entre 0 y 999'999.999
         * <p>
         * Creation date 3/05/2006 - 05:37:47 PM
         * 
         * @param number
         *            Numero a convertir
         * @return Numero convertido a texto
         * @throws NumberFormatException
         *             Si el numero esta fuera del rango
         * @since 1.0
         */
        public static String convertNumberToLetter(double number)
                throws NumberFormatException {
            String converted = new String();

            // Validamos que sea un numero legal
            double doubleNumber = number;// Math.round(number);
            if (doubleNumber > 999999999) {
                throw new NumberFormatException(
                        "El numero es mayor de 999'999.999, "
                        + "no es posible convertirlo");
            }

            String splitNumber[] = String.valueOf(doubleNumber).replace('.', '#').split("#");

            // Descompone el trio de millones - �SGT!
            int millon = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
                    8))
                    + String.valueOf(getDigitAt(splitNumber[0], 7))
                    + String.valueOf(getDigitAt(splitNumber[0], 6)));
            if (millon == 1) {
                converted = "UN MILLON ";
            }
            if (millon > 1) {
                converted = convertNumber(String.valueOf(millon)) + "MILLONES ";
            }

            // Descompone el trio de miles - �SGT!
            int miles = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
                    5))
                    + String.valueOf(getDigitAt(splitNumber[0], 4))
                    + String.valueOf(getDigitAt(splitNumber[0], 3)));
            if (miles == 1) {
                converted += "MIL ";
            }
            if (miles > 1) {
                converted += convertNumber(String.valueOf(miles)) + "MIL ";
            }

            // Descompone el ultimo trio de unidades - �SGT!
            int cientos = Integer.parseInt(String.valueOf(getDigitAt(
                    splitNumber[0], 2))
                    + String.valueOf(getDigitAt(splitNumber[0], 1))
                    + String.valueOf(getDigitAt(splitNumber[0], 0)));
            if (cientos == 1) {
                converted += "UN";
            }

            if (millon + miles + cientos == 0) {
                converted += "CERO";
            }
            if (cientos > 1) {
                converted += convertNumber(String.valueOf(cientos));
            }

            // converted += "PESOS"; //moneda
            // converted += "CON"; //moneda

            // Descompone los centavos - Camilo
            int centavos = Integer.parseInt(String.valueOf(getDigitAt(
                    splitNumber[1], 2))
                    + String.valueOf(getDigitAt(splitNumber[1], 1))
                    + String.valueOf(getDigitAt(splitNumber[1], 0)));
            if (centavos == 0) // converted += " CON 1 CENTAVO";
            {
                converted += " CON 00/100";
            }
            if (centavos >= 1 && centavos < 10) // converted += " CON " + convertNumber(String.valueOf(centavos)) +
            // "CENTAVOS";
            {
                converted += " CON 0" + centavos + "/100";
            }
            if (centavos >= 10) {
                converted += " CON " + centavos + "/100";
            }

            return converted;
        }

        public static String convertNumberToLetter(Double number)
                throws NumberFormatException {
            String converted = new String();

            // Validamos que sea un numero legal
            double doubleNumber = number;// Math.round(number);
            if (doubleNumber > 999999999) {
                throw new NumberFormatException(
                        "El numero es mayor de 999'999.999, "
                        + "no es posible convertirlo");
            }

            String splitNumber[] = String.valueOf(doubleNumber).replace('.', '#').split("#");

            // Descompone el trio de millones - �SGT!
            int millon = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
                    8))
                    + String.valueOf(getDigitAt(splitNumber[0], 7))
                    + String.valueOf(getDigitAt(splitNumber[0], 6)));
            if (millon == 1) {
                converted = "UN MILLON ";
            }
            if (millon > 1) {
                converted = convertNumber(String.valueOf(millon)) + "MILLONES ";
            }

            // Descompone el trio de miles - �SGT!
            int miles = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
                    5))
                    + String.valueOf(getDigitAt(splitNumber[0], 4))
                    + String.valueOf(getDigitAt(splitNumber[0], 3)));
            if (miles == 1) {
                converted += "MIL ";
            }
            if (miles > 1) {
                converted += convertNumber(String.valueOf(miles)) + "MIL ";
            }

            // Descompone el ultimo trio de unidades - �SGT!
            int cientos = Integer.parseInt(String.valueOf(getDigitAt(
                    splitNumber[0], 2))
                    + String.valueOf(getDigitAt(splitNumber[0], 1))
                    + String.valueOf(getDigitAt(splitNumber[0], 0)));
            if (cientos == 1) {
                converted += "UN";
            }

            if (millon + miles + cientos == 0) {
                converted += "CERO";
            }
            if (cientos > 1) {
                converted += convertNumber(String.valueOf(cientos));
            }

            // converted += "PESOS"; //moneda
            // converted += "CON"; //moneda

            // Descompone los centavos - Camilo
            int centavos = Integer.parseInt(String.valueOf(getDigitAt(
                    splitNumber[1], 2))
                    + String.valueOf(getDigitAt(splitNumber[1], 1))
                    + String.valueOf(getDigitAt(splitNumber[1], 0)));
            if (centavos == 0) // converted += " CON 1 CENTAVO";
            {
                converted += " CON 00/100";
            }
            if (centavos >= 1 && centavos < 10) // converted += " CON " + convertNumber(String.valueOf(centavos)) +
            // "CENTAVOS";
            {
                converted += " CON 0" + centavos + "/100";
            }
            if (centavos >= 10) {
                converted += " CON " + centavos + "/100";
            }

            return converted;
        }

        public static String convertNumberToLetter(Double number, String moneda)
                throws NumberFormatException {
            String converted = new String();

            // Validamos que sea un numero legal
            double doubleNumber = Numero.round(number, 2);// Math.round(number);
            if (doubleNumber > 999999999) {
                throw new NumberFormatException(
                        "El numero es mayor de 999'999.999, "
                        + "no es posible convertirlo");
            }

            String splitNumber[] = String.valueOf(doubleNumber).replace('.', '#').split("#");

            // Descompone el trio de millones - �SGT!
            int millon = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
                    8))
                    + String.valueOf(getDigitAt(splitNumber[0], 7))
                    + String.valueOf(getDigitAt(splitNumber[0], 6)));
            if (millon == 1) {
                converted = "UN MILLON ";
            }
            if (millon > 1) {
                converted = convertNumber(String.valueOf(millon)) + "MILLONES ";
            }

            // Descompone el trio de miles - �SGT!
            int miles = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
                    5))
                    + String.valueOf(getDigitAt(splitNumber[0], 4))
                    + String.valueOf(getDigitAt(splitNumber[0], 3)));
            if (miles == 1) {
                converted += "MIL ";
            }
            if (miles > 1) {
                converted += convertNumber(String.valueOf(miles)) + "MIL ";
            }

            // Descompone el ultimo trio de unidades - �SGT!
            int cientos = Integer.parseInt(String.valueOf(getDigitAt(
                    splitNumber[0], 2))
                    + String.valueOf(getDigitAt(splitNumber[0], 1))
                    + String.valueOf(getDigitAt(splitNumber[0], 0)));
            if (cientos == 1) {
                converted += "UN";
            }

            if (millon + miles + cientos == 0) {
                converted += "CERO";
            }
            if (cientos > 1) {
                converted += convertNumber(String.valueOf(cientos));
            }

            // converted += "PESOS"; //moneda
            // converted += "CON"; //moneda

            // Descompone los centavos - Camilo
            int centavos = Integer.parseInt(String.valueOf(getDigitAt(
                    splitNumber[1], 2))
                    + String.valueOf(getDigitAt(splitNumber[1], 1))
                    + String.valueOf(getDigitAt(splitNumber[1], 0)));

            if (centavos == 0) // converted += " CON 1 CENTAVO";
            {
                converted += " CON 00/100 " + moneda;
            }
            if (centavos >= 1 && centavos < 10) // converted += " CON " + convertNumber(String.valueOf(centavos)) +
            // "CENTAVOS";
            {
                converted += " CON 0" + centavos + "/100 " + moneda;
            }
            if (centavos >= 10) {
                converted += " CON " + centavos + "/100 " + moneda;
            }

            return converted;
        }

        public static String convertNumberToLetter(Float number, String moneda)
                throws NumberFormatException {
            String converted = new String();

            // Validamos que sea un numero legal
            double doubleNumber = Numero.round(number, 2).doubleValue();// Math.round(number);
            if (doubleNumber > 999999999) {
                throw new NumberFormatException(
                        "El numero es mayor de 999'999.999, "
                        + "no es posible convertirlo");
            }

            String splitNumber[] = String.valueOf(doubleNumber).replace('.', '#').split("#");

            // Descompone el trio de millones - �SGT!
            int millon = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
                    8))
                    + String.valueOf(getDigitAt(splitNumber[0], 7))
                    + String.valueOf(getDigitAt(splitNumber[0], 6)));
            if (millon == 1) {
                converted = "UN MILLON ";
            }
            if (millon > 1) {
                converted = convertNumber(String.valueOf(millon)) + "MILLONES ";
            }

            // Descompone el trio de miles - �SGT!
            int miles = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
                    5))
                    + String.valueOf(getDigitAt(splitNumber[0], 4))
                    + String.valueOf(getDigitAt(splitNumber[0], 3)));
            if (miles == 1) {
                converted += "MIL ";
            }
            if (miles > 1) {
                converted += convertNumber(String.valueOf(miles)) + "MIL ";
            }

            // Descompone el ultimo trio de unidades - �SGT!
            int cientos = Integer.parseInt(String.valueOf(getDigitAt(
                    splitNumber[0], 2))
                    + String.valueOf(getDigitAt(splitNumber[0], 1))
                    + String.valueOf(getDigitAt(splitNumber[0], 0)));
            if (cientos == 1) {
                converted += "UN";
            }

            if (millon + miles + cientos == 0) {
                converted += "CERO";
            }
            if (cientos > 1) {
                converted += convertNumber(String.valueOf(cientos));
            }

            // converted += "PESOS"; //moneda
            // converted += "CON"; //moneda

            // Descompone los centavos - Camilo
            int centavos = Integer.parseInt(String.valueOf(getDigitAt(
                    splitNumber[1], 2))
                    + String.valueOf(getDigitAt(splitNumber[1], 1))
                    + String.valueOf(getDigitAt(splitNumber[1], 0)));

            int parteEntera = Integer.parseInt(splitNumber[0]);
            double parteDecimal = doubleNumber % parteEntera;
            parteDecimal = Numero.round(parteDecimal, 2);

            if (parteDecimal != 0.29) {
                centavos = (int) (parteDecimal * 100);
            } else {
                centavos = 29;
            }
            if (centavos == 0) // converted += " CON 1 CENTAVO";
            {
                converted += " CON 00/100 " + moneda;
            }
            if (centavos >= 1 && centavos < 10) // converted += " CON " + convertNumber(String.valueOf(centavos)) +
            // "CENTAVOS";
            {
                converted += " CON 0" + centavos + "/100 " + moneda;
            }
            if (centavos >= 10) {
                converted += " CON " + centavos + "/100 " + moneda;
            }

            return converted;
        }

        /**
         * Convierte los trios de numeros que componen las unidades, las decenas y
         * las centenas del numero.
         * <p>
         * Creation date 3/05/2006 - 05:33:40 PM
         * 
         * @param number
         *            Numero a convetir en digitos
         * @return Numero convertido en letras
         * @since 1.0
         */
        private static String convertNumber(String number) {
            if (number.length() > 3) {
                throw new NumberFormatException(
                        "La longitud maxima debe ser 3 digitos");
            }

            String output = new String();
            if (getDigitAt(number, 2) != 0) {
                output = Constantes.CENTENAS[getDigitAt(number, 2) - 1];
            }

            int k = Integer.parseInt(String.valueOf(getDigitAt(number, 1))
                    + String.valueOf(getDigitAt(number, 0)));

            if (k <= 20) {
                output += Constantes.UNIDADES[k];
            } else {
                if (k > 30 && getDigitAt(number, 0) != 0) {
                    output += Constantes.DECENAS[getDigitAt(number, 1) - 2] + "Y "
                            + Constantes.UNIDADES[getDigitAt(number, 0)];
                } else {
                    output += Constantes.DECENAS[getDigitAt(number, 1) - 2]
                            + Constantes.UNIDADES[getDigitAt(number, 0)];
                }
            }

            // Caso especial con el 100
            if (getDigitAt(number, 2) == 1 && k == 0) {
                output = "CIEN";
            }

            return output;
        }

        /**
         * Retorna el digito numerico en la posicion indicada de derecha a izquierda
         * <p>
         * Creation date 3/05/2006 - 05:26:03 PM
         * 
         * @param origin
         *            Cadena en la cual se busca el digito
         * @param position
         *            Posicion de derecha a izquierda a retornar
         * @return Digito ubicado en la posicion indicada
         * @since 1.0
         */
        private static int getDigitAt(String origin, int position) {
            if (origin.length() > position && position >= 0) {
                return origin.charAt(origin.length() - position - 1) - 48;
            }
            return 0;
        }

        public static int numCifras(int x) {
            int total = 0;
            while (x != 0) {
                x = x / 10;
                total += 1; // incrementamos el contador }
            }
            return total;
        }
    }

    public static class ConvertirObjeto {

        public static Map<String, Object> crearObjetoDtoToMap(Object object) {
            Class cls = object.getClass();
            Map<String, Object> map = new HashMap<String, Object>();
            Field[] atributos = cls.getDeclaredFields();
            Class[] c = null;
            Object[] o = null;
            
            for (Field f : atributos) {
                Method metodoGet = null;

                try {
                    metodoGet = cls.getMethod("get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1), c);
                } catch (SecurityException e) {
                    logger.error("Error en utilitario ", e);
                } catch (NoSuchMethodException e) {
                    logger.error("Error en utilitario ", e);
                }
                try {

                    map.put(f.getName(), metodoGet.invoke(object, o));

                } catch (IllegalArgumentException e) {
                    logger.error("Error en utilitario ", e);
                } catch (IllegalAccessException e) {
                    logger.error("Error en utilitario ", e);
                } catch (InvocationTargetException e) {
                    logger.error("Error en utilitario ", e);
                }
            }
            Field[] atributosSuper = cls.getSuperclass().getDeclaredFields();

            for (Field f : atributosSuper) {
                Method metodoGet = null;

                try {
                    metodoGet = cls.getSuperclass().getMethod("get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1), c);
                } catch (SecurityException e) {
                    logger.error("Error en utilitario ", e);
                } catch (NoSuchMethodException e) {
                    logger.error("Error en utilitario ", e);
                }
                try {
                    map.put(f.getName(), metodoGet.invoke(object, o));
                } catch (IllegalArgumentException e) {
                    logger.error("Error en utilitario ", e);
                } catch (IllegalAccessException e) {
                    logger.error("Error en utilitario ", e);
                } catch (InvocationTargetException e) {
                    logger.error("Error en utilitario ", e);
                }
            }

            return map;
        }

        public static Object crearMapToObjectDto(Map map, Object objetoDto) {

            Class cls = objetoDto.getClass();

            Field[] atributos = cls.getDeclaredFields();

            for (Field f : atributos) {
                Method metodoGet = null;
                try {
                    Class a[] = new Class[1];
                    metodoGet = cls.getMethod("set"
                            + f.getName().substring(0, 1).toUpperCase()
                            + f.getName().substring(1), a);
                } catch (SecurityException e) {
                    logger.error("Error en utilitario ", e);
                } catch (NoSuchMethodException e) {
                    logger.error("Error en utilitario ", e);
                }
                try {

                    Object a[] = new Object[1];
                    try {
                        a[0] = map.get(f.getName());
                    } catch (Exception e) {
                        a[0] = null;
                    }
                    metodoGet.invoke(objetoDto, a);

                } catch (IllegalArgumentException e) {
                    logger.error("Error en utilitario ", e);
                } catch (IllegalAccessException e) {
                    logger.error("Error en utilitario ", e);
                } catch (InvocationTargetException e) {
                    logger.error("Error en utilitario ", e);
                }
            }

            return objetoDto;
        }
    }
	
}
