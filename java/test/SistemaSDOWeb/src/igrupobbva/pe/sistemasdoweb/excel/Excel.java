package igrupobbva.pe.sistemasdoweb.excel;

import java.io.File;
import java.math.BigDecimal;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.Orientation;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.log4j.Logger;

public class Excel {
	
	protected static Logger log = Logger.getLogger(Excel.class);
	protected static WritableFont BOLD_WHITE_10PX = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
	protected static WritableFont BOLD_BLACK_10PX = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
	protected static WritableFont BOLD_BLACK_14PX = new WritableFont(WritableFont.createFont("Calibri"), 14, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
	protected static WritableFont NORMAL_BLACK_10PX = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
	protected static NumberFormat NUMBER_FORMAT = new NumberFormat("0");
	protected static NumberFormat OFICINA_FORMAT = new NumberFormat("0000");
	protected static WritableCellFormat HEADER_DARK_BLUE = new WritableCellFormat(BOLD_WHITE_10PX);
	protected static WritableCellFormat HEADER_DARK_BLUE_PLUS_90 = new WritableCellFormat(BOLD_WHITE_10PX);
	protected static WritableCellFormat TITLE = new WritableCellFormat(BOLD_BLACK_14PX);
	protected static WritableCellFormat CELL_TEXT = new WritableCellFormat(NORMAL_BLACK_10PX);
	protected static WritableCellFormat CELL_TEXT_GRAY25 = new WritableCellFormat(NORMAL_BLACK_10PX);
	protected static WritableCellFormat CELL_TEXT_AQUA = new WritableCellFormat(NORMAL_BLACK_10PX);
	protected static WritableCellFormat CELL_NUMBER = new WritableCellFormat (NORMAL_BLACK_10PX, NUMBER_FORMAT);
	protected static WritableCellFormat CELL_NUMBER2 = new WritableCellFormat (NORMAL_BLACK_10PX, NUMBER_FORMAT);
	protected static WritableCellFormat CELL_NUMBER3 = new WritableCellFormat (NORMAL_BLACK_10PX, OFICINA_FORMAT);
	protected static WritableCellFormat CELL_NUMBER4 = new WritableCellFormat (BOLD_BLACK_10PX, NUMBER_FORMAT);
	
	private WritableWorkbook writableWorkbook = null;
	private WorkbookSettings workbookSettings = null;
	private WritableSheet writableSheet= null;
	
	
	public Excel() {
		Excel.BOLD_WHITE_10PX = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
		Excel.BOLD_BLACK_10PX = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		Excel.BOLD_BLACK_14PX = new WritableFont(WritableFont.createFont("Calibri"), 14, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		Excel.NORMAL_BLACK_10PX = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		Excel.NUMBER_FORMAT = new NumberFormat("0");
		Excel.OFICINA_FORMAT = new NumberFormat("0000");
		Excel.HEADER_DARK_BLUE = new WritableCellFormat(BOLD_WHITE_10PX);
		Excel.HEADER_DARK_BLUE_PLUS_90 = new WritableCellFormat(BOLD_WHITE_10PX);
		Excel.TITLE = new WritableCellFormat(BOLD_BLACK_14PX);
		Excel.CELL_TEXT = new WritableCellFormat(NORMAL_BLACK_10PX);
		Excel.CELL_TEXT_GRAY25 = new WritableCellFormat(NORMAL_BLACK_10PX);
		Excel.CELL_TEXT_AQUA = new WritableCellFormat(NORMAL_BLACK_10PX);
		Excel.CELL_NUMBER = new WritableCellFormat (NORMAL_BLACK_10PX, NUMBER_FORMAT);
		Excel.CELL_NUMBER2 = new WritableCellFormat (NORMAL_BLACK_10PX, NUMBER_FORMAT);
		Excel.CELL_NUMBER3 = new WritableCellFormat (NORMAL_BLACK_10PX, OFICINA_FORMAT);
		Excel.CELL_NUMBER4 = new WritableCellFormat (BOLD_BLACK_10PX, NUMBER_FORMAT);
		
		try {
			Excel.HEADER_DARK_BLUE.setAlignment(Alignment.CENTRE);
			Excel.HEADER_DARK_BLUE.setBorder(Border.ALL, BorderLineStyle.THIN);
			Excel.HEADER_DARK_BLUE.setBackground(Colour.DARK_BLUE);
		
			Excel.HEADER_DARK_BLUE_PLUS_90.setAlignment(Alignment.CENTRE);
			Excel.HEADER_DARK_BLUE_PLUS_90.setBorder(Border.ALL, BorderLineStyle.THIN);
			Excel.HEADER_DARK_BLUE_PLUS_90.setBackground(Colour.DARK_BLUE);
			Excel.HEADER_DARK_BLUE_PLUS_90.setOrientation(Orientation.PLUS_90);
			
			Excel.TITLE.setAlignment(Alignment.CENTRE);
			
			Excel.CELL_TEXT.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			Excel.CELL_TEXT_GRAY25.setBorder(Border.ALL, BorderLineStyle.THIN);
			Excel.CELL_TEXT_GRAY25.setBackground(Colour.GRAY_25);
			
			Excel.CELL_TEXT_AQUA.setBorder(Border.ALL, BorderLineStyle.THIN);
			Excel.CELL_TEXT_AQUA.setBackground(Colour.AQUA);
			
			Excel.CELL_NUMBER.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			Excel.CELL_NUMBER2.setBorder(Border.ALL, BorderLineStyle.THIN);
			Excel.CELL_NUMBER2.setAlignment(Alignment.RIGHT);
			Excel.CELL_NUMBER2.setBackground(Colour.AQUA);
			
			Excel.CELL_NUMBER3.setBorder(Border.ALL, BorderLineStyle.THIN);
			Excel.CELL_NUMBER3.setAlignment(Alignment.CENTRE);
			
			Excel.CELL_NUMBER4.setBorder(Border.ALL, BorderLineStyle.THIN);
			Excel.CELL_NUMBER4.setAlignment(Alignment.CENTRE);
			Excel.CELL_NUMBER4.setBackground(Colour.AQUA);
		} catch (WriteException e) {
			log.error("Excel - Static", e);
		}
	}
	
	public Excel(File file, String sheetName) {
		this();
		try {
			workbookSettings = new WorkbookSettings();
			workbookSettings.setLocale(java.util.Locale.US);
		
			writableWorkbook = Workbook.createWorkbook(file, workbookSettings);
			writableSheet = writableWorkbook.createSheet(sheetName, 0);
		} catch(Exception e) {
			log.error("Excel - Construct", e);
		}
	}

	public Excel(String fileName, String sheetName) {
		this();
		try {
			workbookSettings = new WorkbookSettings();
			workbookSettings.setLocale(java.util.Locale.US);
		
			writableWorkbook = Workbook.createWorkbook(new File(fileName), workbookSettings);
			writableSheet = writableWorkbook.createSheet(sheetName, 0);
		} catch(Exception e) {
			log.error("Excel - Construct", e);
		}
	}
	
	public void addCell(int col, int row, String value, WritableCellFormat format) {
		try {
			if(value!=null) {
				if(value.equalsIgnoreCase("***")) {
					value = "";
				}
			}
			Label label = new Label(col, row, value, format);
			writableSheet.addCell(label);
		} catch (RowsExceededException e) {
			log.error(e);
		} catch (WriteException e) {
			log.error(e);
		}
	}
	
	public void addCell(int col, int row, double value, WritableCellFormat format) {
		try {
			Number label = new Number(col, row, value, format);
			writableSheet.addCell(label);
		} catch (RowsExceededException e) {
			log.error("addCell", e);
		} catch (WriteException e) {
			log.error("addCell", e);
		}
	}
	
	public void addCellHeader(int col, int row, String value) {
		addCell(col, row, value, Excel.HEADER_DARK_BLUE);
	}

	public void addCellHeader(int col, int row, String value, WritableCellFormat format) {
		addCell(col, row, value, format);
	}

	public void addCell(int col, int row, String value) {
		addCell(col, row, value, Excel.CELL_TEXT);
	}

	public void addCellObject(int col, int row, Object value) {
		if(value == null) value = "";
		addCell(col, row, value.toString(), Excel.CELL_TEXT);
	}

	public void addCellObject(int col, int row, Object value, WritableCellFormat format) {
		if(value == null) value = "";
		
		if(value.toString().trim().length() == 0) {
			addCell(col, row, value.toString());
		} else {
			addCell(col, row, value.toString(), format);
		}
	}
	
	public void addCellObjectToDecimal(int col, int row, Object value, WritableCellFormat format) {
		BigDecimal number = BigDecimal.ZERO;
		try {
			addCell(col, row, "", format);

			if(value != null) {
				number = new BigDecimal(value.toString());
				if(!number.equals(BigDecimal.ZERO)) {
					addCell(col, row, number, format);
				}
			}
		} catch(NumberFormatException e) {
			addCell(col, row, "");
		} catch(NullPointerException e) {
			addCell(col, row, "");
		} catch(Exception e) {
			addCell(col, row, "");
			log.error("Excel - addCellObjectToDecimal", e);
		}
	}
	
	public void addCellObjectToDecimal(int col, int row, Object value) {
		addCellObjectToDecimal(col, row, value, Excel.CELL_NUMBER);
	}
	
	public void addCell(int col, int row, BigDecimal value, WritableCellFormat format) {
		addCell(col, row, value.doubleValue(), format);
	}
	
	public void addCell(int col, int row, BigDecimal value) {
		addCell(col, row, value.doubleValue(), Excel.CELL_NUMBER);
	}
	
	public void addMergeCell(int colX, int rowX, int colY, int rowY, String value, WritableCellFormat format) {
	 	try {
			writableSheet.mergeCells(colX, rowX, colY, rowY);
		} catch (RowsExceededException e) {
			log.error("Excel - addMergeCell", e);
		} catch (WriteException e) {
			log.error("Excel - addMergeCell", e);
		}	
		
		addCell(colX, rowY, value, format);
	}
	
	public void addMergeCell(int colX, int rowX, int colY, int rowY, String value) {
	 	try {
			writableSheet.mergeCells(colX, rowX, colY, rowY);
		} catch (RowsExceededException e) {
			log.error("Excel - addMergeCell", e);
		} catch (WriteException e) {
			log.error("Excel - addMergeCell", e);
		}	
		
		addCell(colX, rowY, value, Excel.CELL_TEXT);
	}
	
	public void formatRange(int cols[], int row, WritableCellFormat format) {
		for(int col = cols[0]; col <cols[1]; col++){
			addCell(col, row, "", format);
		}
	}
	
	public void formatRange(int cols[], int row) {
		formatRange(cols, row, Excel.CELL_TEXT);
	}
	
	public void save() {
		if(writableWorkbook != null) {
			try { 
				writableWorkbook.write();
				writableWorkbook.close();
			} catch(Exception e) {
				log.error("Excel - Save", e);
			}
		}
	}
	
	public void autoSize(int colInicial, int colFinal) {
		CellView cellView = new CellView();
		cellView.setAutosize(true);
		int i = 0;
		for(i = colInicial; i < colFinal; i++) {
			writableSheet.setColumnView(0, cellView);
		}
	}
}