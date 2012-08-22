package igrupobbva.pe.sistemasdoweb.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.CellView;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.PageOrientation;
import jxl.format.PaperSize;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

public class ExportGenericExcelServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(ExportGenericExcelServlet.class);
	private int rowIndex = 0;
	private ColourComponent colourComponent;
	
	private void prepareRowsJSON(List<CellComponent> rows, String json) {
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonArray array = null;
		CellComponent cell = null;
	    try {
		    array = parser.parse(json).getAsJsonArray();
		    for (JsonElement row : array) {
		    	cell = gson.fromJson(row, CellComponent.class);
		    	rows.add(cell);
		    	log.info(cell);
			}
	    } catch(IllegalStateException ex) {
	    	log.error(":(", ex);
	    } catch(JsonSyntaxException ex) {
	    	log.error(":(", ex);
	    }
	}
	
	private void prepareRowsExcel(List<CellComponent> rows, WritableSheet sheetWrite, WritableWorkbook book, String type){
		Label label = null;
		Number number = null;
		Map<Integer, Integer> rowspan = new HashMap<Integer, Integer>();
		int col = 0;
		int tmp = 0;
		WritableFont font;
		WritableCellFormat cellFormat;
		
		for(CellComponent row : rows) {
			
			if(tmp != row.getRow()) {
				tmp = row.getRow();
				col = 0;
				rowIndex++;
			} 
			
			while(rowspan.containsKey(col) && tmp !=0) {
				col++;
			}
			
			row.setRow(rowIndex);

			try {
				font = new WritableFont(WritableFont.TAHOMA);
				font.setColour(colourComponent.getColour(row.getColor(), book));
				font.setPointSize(9);
				if(row.getFontWeight().equalsIgnoreCase("bold") || row.getFontWeight().equalsIgnoreCase("700")) {
					font.setBoldStyle(WritableFont.BOLD);
				} else {
					font.setBoldStyle(WritableFont.NO_BOLD);
				}
				
				cellFormat = new WritableCellFormat();
				cellFormat.setBackground(colourComponent.getColour(row.getBackgroundColor(), book));
				cellFormat.setFont(font);
				cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
				cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
				if(type.equalsIgnoreCase("head")) {
					cellFormat.setAlignment(Alignment.CENTRE);
					cellFormat.setWrap(true);
				} else {
					cellFormat.setAlignment(Alignment.LEFT);
					cellFormat.setWrap(false);	
				}
				
				if(row.getType().equalsIgnoreCase("number")) {
					try {
						number = new Number(col, row.getRow(), Double.valueOf(row.getCaption().replaceAll(",", "")).doubleValue());
					} catch(NumberFormatException ex) {
						number = new Number(col, row.getRow(), 0);
					}
					cellFormat.setAlignment(Alignment.RIGHT);
					number.setCellFormat(cellFormat);
					sheetWrite.addCell(number);
				} else if(row.getType().equalsIgnoreCase("date")) {
					label = new Label(col, row.getRow(), row.getCaption());
					label.setCellFormat(cellFormat);
					sheetWrite.addCell(label);
				} else {
					label = new Label(col, row.getRow(), row.getCaption());
					label.setCellFormat(cellFormat);
					sheetWrite.addCell(label);
				}
				
				
			} catch (RowsExceededException ex) {
				log.error(":(", ex);
			} catch (WriteException ex) {
				log.error(":(", ex);
			}
			
			if(row.getColspan() > 0) {
				try {
					sheetWrite.mergeCells(col, row.getRow(), col + (row.getColspan() - 1), row.getRow());
				} catch (RowsExceededException ex) {
					log.error(":(", ex);
				} catch (WriteException ex) {
					log.error(":(", ex);
				}
				col += (row.getColspan() - 1);
			}
			
			if(row.getRowspan() > 0) {
				rowspan.put(col, row.getRowspan() -1);
				try {
					sheetWrite.mergeCells(col, row.getRow(), col, row.getRow() + row.getRowspan() - 1);
				} catch (RowsExceededException ex) {
					log.error(":(", ex);
				} catch (WriteException ex) {
					log.error(":(", ex);
				}
			}
			
			col++;
		}
	}
	
	/*
	 * (non-Java-doc)
	 * <fmt:formatNumber value="${objBean.porAlcanzado}" maxFractionDigits="0" minFractionDigits="0"/>
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0,
	 * HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest arg0,
	 * HttpServletResponse arg1)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			log.info("[ExportarExcelServlet :: doPost] Inicio");

			String header = request.getParameter("header"); // URLDecoder.decode(request.getParameter("header"), "ISO-8859-1");
			String rows = request.getParameter("rows"); // URLDecoder.decode(request.getParameter("rows"), "ISO-8859-1");
			String footer = request.getParameter("footer"); // URLDecoder.decode(request.getParameter("footer"), "ISO-8859-1");
		    String title = request.getParameter("title") == null ? "SDO" : request.getParameter("title");
		    String fileName = request.getParameter("file") == null ? "SDO" : request.getParameter("file");
		    colourComponent = new ColourComponent();
		    
		    List<CellComponent> th = new ArrayList<CellComponent>();
		    List<CellComponent> td = new ArrayList<CellComponent>();
		    List<CellComponent> tf = new ArrayList<CellComponent>();
		    
		    
		    // Header
		    if(header.length()>0) {
		    	this.prepareRowsJSON(th, header);
		    }
		    
		    // Rows
		    if(rows.length()>0) {
		    	this.prepareRowsJSON(td, rows);
		    }
		    
		    // Footer
		    if(footer.length()>0) {
		    	this.prepareRowsJSON(tf, footer);
		    }
		    
		    response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xls");
		    
			WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());
			WritableSheet sheet = workbook.createSheet(title, 0);
			
			rowIndex = 0;
			this.prepareRowsExcel(th, sheet, workbook, "HEAD");
			rowIndex++;
			this.prepareRowsExcel(td, sheet, workbook, "BODY");
			rowIndex++;
			this.prepareRowsExcel(tf, sheet, workbook, "FOOTER");
			
			CellView cellView = new CellView();
			cellView.setAutosize(true);
			for(int i = 0; i < sheet.getColumns(); i++) {
				sheet.setColumnView(i, cellView);
			}
			log.info(sheet.getColumns());
			
			PageOrientation pageOrientation = PageOrientation.LANDSCAPE;
			PaperSize paperSize = PaperSize.A4;
			sheet.setPageSetup(pageOrientation, paperSize, 0, 0);
			SheetSettings sheets = sheet.getSettings();
			sheets.setLeftMargin(0.2);
			sheets.setRightMargin(0.2);
			sheets.setHorizontalCentre(true);
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			log.error("[ExportarExcelServlet :: doPost] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
	}
}