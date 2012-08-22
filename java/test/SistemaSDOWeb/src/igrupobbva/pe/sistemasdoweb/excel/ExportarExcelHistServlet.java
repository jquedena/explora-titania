package igrupobbva.pe.sistemasdoweb.excel;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.CellView;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.PageOrientation;
import jxl.format.PaperSize;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.log4j.Logger;

import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

@SuppressWarnings({"serial","unused"})
public class ExportarExcelHistServlet extends HttpServlet implements Servlet {
	private static Logger log = Logger.getLogger(ExportarExcelHistServlet.class);
	
	public ExportarExcelHistServlet() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doPost(req,res);
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		try {
			log.info("[ExportarExcelHistServlet :: doPost] Inicio");
			
			String contents=req.getParameter("tablaExcel");
			
			if(contents.length()>0 && !contents.substring(0,1).equals("<")){
				contents = URLDecoder.decode(contents,"ISO-8859-1");
			}
			res.setContentType("application/vnd.ms-excel");
			res.setHeader("Content-Disposition",
			   "attachment; filename=PlanificacionHistorial.xls");
			
		    WorkbookSettings ws = new WorkbookSettings();
		    WritableWorkbook workbook;
			workbook = Workbook.createWorkbook(res.getOutputStream());//new File("Reporte.xls"));
			WritableSheet sheet = workbook.createSheet("Reporte", 0);
			
			/*** Estilo Cabecera ***/
	          //Setting Background colour for Cells
	          Colour bckcolor = Colour.GRAY_25;
	          WritableCellFormat cellFormat = new WritableCellFormat();
	          cellFormat.setBackground(bckcolor);
	          cellFormat.setAlignment(Alignment.CENTRE);
	          cellFormat.setWrap(true);
	          //Setting Colour & Font for the Text
	          WritableFont font = new WritableFont(WritableFont.ARIAL);
	          font.setColour(Colour.BLACK);
	          font.setPointSize(8);
	          cellFormat.setFont(font);
	          cellFormat.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
	          cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
	          
	          WritableCellFormat cellFormat_ = new WritableCellFormat();
	          cellFormat_.setBackground(bckcolor);
	          cellFormat_.setAlignment(Alignment.CENTRE);
	          cellFormat_.setWrap(true);
	          //Setting Colour & Font for the Text
	          WritableFont font_ = new WritableFont(WritableFont.ARIAL);
	          font_.setColour(Colour.BLACK);
	          font_.setPointSize(7);
	          cellFormat_.setFont(font_);
	          cellFormat_.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
	          cellFormat_.setVerticalAlignment(VerticalAlignment.CENTRE);
	          
		    /*** Estilo Contenido ***/   
	          WritableCellFormat cellFormat2 = new WritableCellFormat();
	          WritableFont font2 = new WritableFont(WritableFont.ARIAL);
	          font2.setColour(Colour.BLACK);
	          font2.setPointSize(8);
	          cellFormat2.setFont(font2);
	          cellFormat2.setBorder(Border.ALL, BorderLineStyle.THIN);
	          cellFormat2.setAlignment(Alignment.RIGHT);
	          cellFormat2.setVerticalAlignment(VerticalAlignment.CENTRE);
	          
			/*** Estilo Contenido Centrado***/   
	          WritableCellFormat cellFormat2_ = new WritableCellFormat();
	          cellFormat2_.setFont(font2);
	          cellFormat2_.setBorder(Border.ALL, BorderLineStyle.THIN);
	          cellFormat2_.setAlignment(Alignment.CENTRE);	
	          cellFormat2_.setVerticalAlignment(VerticalAlignment.CENTRE);
	          
		    /*** Estilo Contenido Particular Columna 2 ***/   
	          WritableCellFormat cellFormat3 = new WritableCellFormat();
	          WritableFont font3 = new WritableFont(WritableFont.ARIAL);
	          font3.setColour(Colour.BLACK);
	          font3.setPointSize(8);
	          cellFormat3.setFont(font3);
	          cellFormat3.setBorder(Border.ALL, BorderLineStyle.THIN);
	          cellFormat3.setWrap(true);
	          
	          /*** Estilo Contenido Izquierda ***/   
	          WritableCellFormat cellFormat4 = new WritableCellFormat();
	          cellFormat4.setFont(font2);
	          cellFormat4.setBorder(Border.ALL, BorderLineStyle.THIN);
	          cellFormat4.setAlignment(Alignment.GENERAL);	
	          cellFormat4.setVerticalAlignment(VerticalAlignment.CENTRE);  
	          
	        CellView cv = new CellView();
	        cv.setAutosize(true);
		        
		    /*** Estilo Contenido Particular Otras Columnas ***/   
		        CellView cv_a = new CellView();
		        cv_a.setDimension(4);	   
		        CellView cv_b = new CellView();
		        cv_b.setDimension(7);
		        CellView cv_c = new CellView();
		        cv_c.setDimension(12);

	          /*** Datos Variables de Cabecera ***/
		      String variable1="";
		      String variable2="";
		      String tempMes="";
		      int in=0;
		      int fn=0;
		      tempMes=contents.substring(contents.indexOf("excelMes1")+9);
		      in=tempMes.indexOf(">")+1;
		      fn=tempMes.indexOf("<");
		      variable1=tempMes.substring(in,fn);
		      tempMes=contents.substring(contents.indexOf("excelMes2")+9);
		      in=tempMes.indexOf(">")+1;
		      fn=tempMes.indexOf("<");
		      variable2=tempMes.substring(in,fn);
	          /*** Cabeceras ***/	          
	          String Header[] = new String[27];
	          Header[0] = "Epigrafe";	  
	          
	          Header[1] = "Dici";
	          Header[2] = "% Avan";
	          Header[3] = "Novi";
	          Header[4] = "% Avan";
	          Header[5] = "Octu";
	          Header[6] = "% Avan";
	          Header[7] = "Seti";
	          Header[8] = "% Avan";
	          Header[9] = "Agos";
	          Header[10] = "% Avan";
	          Header[11] = "Juli";
	          Header[12] = "% Avan";
	          Header[13] = "Juni";
	          Header[14] = "% Avan";
	          Header[15] = "Mayo";
	          Header[16] = "% Avan";
	          Header[17] = "Abri";
	          Header[18] = "% Avan";
	          Header[19] = "Marz";
	          Header[20] = "% Avan";
	          Header[21] = "Febr";
	          Header[22] = "% Avan";
	          Header[23] = "Ener";
	          Header[24] = "% Avan";	          
	          
	          Header[25] = "";
	          Header[26] = "";
	          
	          
              Label labelBase1 = new Label(0, 0, "Presupuesto - A" + (char) 241 + "o Historial");
              labelBase1.setCellFormat(cellFormat);
              sheet.addCell(labelBase1);
              sheet.mergeCells(0,0,24,0);
              
              Label labelBase2 = new Label(25, 0, "Total S/.");
              labelBase2.setCellFormat(cellFormat);
              sheet.addCell(labelBase2);
              //sheet.mergeCells(25,0,25,0);
              
              Label labelBase3 = new Label(26, 0, "Total %");
              labelBase3.setCellFormat(cellFormat);
              sheet.addCell(labelBase3);
              //sheet.mergeCells(26,0,26,0);
              /***/
              
              Label labelBase4 = new Label(0, 1, "Expresado miles de soles");
              labelBase4.setCellFormat(cellFormat);
              sheet.addCell(labelBase4);
              sheet.mergeCells(0,1,26,1);              
              
	          
	          for (int i = 0; i < Header.length; i++) {
	              Label label = new Label(i, 2, Header[i]);
	              label.setCellFormat(cellFormat);
	              sheet.addCell(label);
	              if(i==0 ){/*Son las columnas especiales AUTOSIZE*/
	              	sheet.setColumnView(i,cv);
	              }
	              /*if(i==0 ){//Son las columnas especiales AUTOSIZE
	              	sheet.setColumnView(i,cv_a);
	              }*/
				  /*
	              if(i==4 ||i==5 ||i==6 ||i==7 ||i==9 ){//Son las columnas especiales AUTOSIZE
	              	sheet.setColumnView(i,cv_b);
	              }*/
	              //sheet.setColumnView(i,cv);
	              //WritableCell cell = sheet.getWritableCell(i, 0);
	              //cell.setCellFormat(cellFormat);
	          }
	          /*** Se hace merge de la columna 12 y 13 de las cabeceras***/
              //sheet.mergeCells(25,0,25,1);
              //sheet.mergeCells(12,0,12,1);
              /*** FIN: Cabeceras ***/
			


		
			/**** Se inicia la extraccion de los valores de la tabla***/
			
			String[] registros=contents.toString().split("<TR class=cuerpoTabla>");
			for (int i=1;i<registros.length;i++){
				
				if(registros[i].indexOf("<TD ")>-1){
					String[] campos=registros[i].split("<TD");
					for (int f=1;f<campos.length;f++){
						String valor="";
						if(campos[f].indexOf("<INPUT")>-1){
							String[] elemento=campos[f].split("<INPUT");
							for (int k=1;k<elemento.length;k++){
								if(elemento[k].indexOf("hidden")==-1){
									if(elemento[k].indexOf("value=")!=-1){
										int inicio=elemento[k].indexOf("value=")+6;
										String recorte=elemento[k].substring(inicio);
										int espacio=recorte.indexOf(" ");
										valor=recorte.substring(0,espacio);
									}
								}
							}
							if(valor.equals("")){
								valor="_EMPTY";
							}
						}
						if(valor.equals("_EMPTY")){
							valor=" ";
						}else if(valor.equals("")){
							int inicio=campos[f].indexOf(">")+1;
							int fin=campos[f].indexOf("</");
							valor=campos[f].substring(inicio,fin);						
						}
						
						/*** Se crean las celdas ***/
						Label label=null;
						if(f==1){/*Son las columnas especiales WRAP*/
							label = new Label(f-1, i+1 + 1, valor,cellFormat4);
						}else {
							if(f==6 || f==8 || f==10 || f==16){
								label = new Label(f-1 , i+1 + 1, valor,cellFormat2);
							}else{
								label = new Label(f-1 , i+1 + 1, valor,cellFormat2);
							}

						}
		                sheet.addCell(label);
						/*** FIN: Se crean las celdas ***/		                  
					}
				}
			}
		
		
	        PageOrientation po= PageOrientation.LANDSCAPE;
	        PaperSize ps=PaperSize.A4;
	        sheet.setPageSetup(po,ps,0,0);
	        SheetSettings sheets = sheet.getSettings();
	        sheets.setLeftMargin(0.2);
	        sheets.setRightMargin(0.2);
	        sheets.setHorizontalCentre(true);
	        workbook.write();
	        workbook.close();
	        
	        log.info("[ExportarExcelHistServlet :: doPost] Fin");
		} catch (IOException e) {
			log.error("[ExportarExcelHistServlet :: doPost] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (WriteException e) {
			log.error("[ExportarExcelHistServlet :: doPost] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[ExportarExcelHistServlet :: doPost] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
	}
}