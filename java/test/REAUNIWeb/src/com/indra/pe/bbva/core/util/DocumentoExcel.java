package com.indra.pe.bbva.core.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

public class DocumentoExcel {

	private HSSFSheet sheet = null;
	private HSSFWorkbook wb = null;
	private HSSFCellStyle styleLabel = null;
	private HSSFCellStyle styleContent = null;
	private HSSFCellStyle styleContentCenter = null;
	private HSSFCellStyle styleContentCenterRojo = null;
	private HSSFCellStyle styleContentCenterVerde = null;
	private HSSFCellStyle styleContentCenterAmarillo = null;
	private HSSFCellStyle styleBarraTitulo = null;
	private HSSFCellStyle styleFooter = null;
	private HSSFCellStyle styleFooterRight = null;
	private HSSFCellStyle styleContentNO = null;
	private HSSFCellStyle styleContentSI = null;

	public DocumentoExcel(String filePath) throws InvalidFormatException,
			FileNotFoundException, IOException {

		File file = new File(filePath);
		this.setWb((HSSFWorkbook) WorkbookFactory.create(new FileInputStream(
				file)));
		this.setSheet((HSSFSheet) this.getWb().getSheetAt(0));
		this.crearContentStaticStyle();
		this.crearLabelStaticStyle();
		this.crearContentStaticStyleCenter();
		this.crearStyleBarraTitulo();
		this.crearStyleFooter();
		this.crearStyleFooterRight();
		this.crearContentStaticStyleCenterNO();
		this.crearContentStaticStyleCenterSI();
		this.crearContentStaticStyleRojo();
		this.crearContentStaticStyleVerde();
		this.crearContentStaticStyleAmarillo();
	}

	public void setLabelValue(int indexRow, int indexCell, String valor) {
		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);
		if (this.getSheet().getRow(indexRow).getCell(indexCell) == null)
			this.getSheet().getRow(indexRow).createCell(indexCell);

		this.getSheet().getRow(indexRow).getCell(indexCell).setCellStyle(
				this.getStyleLabel());
		this.getSheet().getRow(indexRow).getCell(indexCell).setCellValue(valor);
	}
	
	public void setContentValue(int indexRow, int indexCell, BigDecimal valor) {
		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);
		if (this.getSheet().getRow(indexRow).getCell(indexCell) == null)
			this.getSheet().getRow(indexRow).createCell(indexCell);

		this.getSheet().getRow(indexRow).getCell(indexCell).setCellStyle(this.getStyleContent());
		if(valor != null) {
			this.getSheet().getRow(indexRow).getCell(indexCell).setCellValue(valor.doubleValue());
		} else {
			this.getSheet().getRow(indexRow).getCell(indexCell).setCellValue("");
		}
	}

	public void setContentValue(int indexRow, int indexCell, String valor) {
		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);
		if (this.getSheet().getRow(indexRow).getCell(indexCell) == null)
			this.getSheet().getRow(indexRow).createCell(indexCell);

		this.getSheet().getRow(indexRow).getCell(indexCell).setCellStyle(this.getStyleContent());
		this.getSheet().getRow(indexRow).getCell(indexCell).setCellValue(valor);
	}

	public void setContentValue(int indexRow, int indexCell, String valor, HSSFCellStyle style) {

		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);
		if (this.getSheet().getRow(indexRow).getCell(indexCell) == null)
			this.getSheet().getRow(indexRow).createCell(indexCell);

		this.getSheet().getRow(indexRow).getCell(indexCell).setCellStyle(style);
		this.getSheet().getRow(indexRow).getCell(indexCell).setCellValue(valor);

	}

	public void setContentValueNO(int indexRow, int indexCell, String valor) {

		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);
		if (this.getSheet().getRow(indexRow).getCell(indexCell) == null)
			this.getSheet().getRow(indexRow).createCell(indexCell);

		this.getSheet().getRow(indexRow).getCell(indexCell).setCellStyle(this.getStyleContentNO());
		this.getSheet().getRow(indexRow).getCell(indexCell).setCellValue(valor);

	}

	public void setContentValueSI(int indexRow, int indexCell, String valor) {

		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);
		if (this.getSheet().getRow(indexRow).getCell(indexCell) == null)
			this.getSheet().getRow(indexRow).createCell(indexCell);

		this.getSheet().getRow(indexRow).getCell(indexCell).setCellStyle(this.getStyleContentSI());
		this.getSheet().getRow(indexRow).getCell(indexCell).setCellValue(valor);

	}

	public void setContentValue(int indexRow, int indexCellFrom,
			int indexCellTo, String titulo) {
		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);

		for (int index = indexCellFrom; index <= indexCellTo; index++) {
			if (this.getSheet().getRow(indexRow).getCell(index) == null)
				this.getSheet().getRow(indexRow).createCell(index);
		}

		this.getSheet().addMergedRegion(
				new CellRangeAddress(indexRow, indexRow, indexCellFrom,
						indexCellTo));

		this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellStyle(
				this.getStyleContent());
		this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellValue(
				titulo);
	}

	public void setContentValue(int indexRow, int indexCellFrom,
			int indexCellTo, String titulo, HSSFCellStyle style) {
		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);

		for (int index = indexCellFrom; index <= indexCellTo; index++) {
			if (this.getSheet().getRow(indexRow).getCell(index) == null)
				this.getSheet().getRow(indexRow).createCell(index);
		}

		this.getSheet().addMergedRegion(
				new CellRangeAddress(indexRow, indexRow, indexCellFrom, indexCellTo));

		this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellStyle(style);
		this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellValue(titulo);
	}
	
	public void setContentValueCenter(int indexRow, int indexCell, String valor) {

		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);
		if (this.getSheet().getRow(indexRow).getCell(indexCell) == null)
			this.getSheet().getRow(indexRow).createCell(indexCell);

		this.getSheet().getRow(indexRow).getCell(indexCell).setCellStyle(
				this.getStyleContentCenter());
		this.getSheet().getRow(indexRow).getCell(indexCell).setCellValue(valor);

	}

	public void setFooter(int indexRow, int indexCell, String valor) {

		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);
		if (this.getSheet().getRow(indexRow).getCell(indexCell) == null)
			this.getSheet().getRow(indexRow).createCell(indexCell);

		this.getSheet().getRow(indexRow).getCell(indexCell).setCellStyle(
				this.getStyleFooter());
		this.getSheet().getRow(indexRow).getCell(indexCell).setCellValue(valor);

	}

	public void setBarraTitulo(int indexRow, int indexCell, String valor) {

		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);
		if (this.getSheet().getRow(indexRow).getCell(indexCell) == null)
			this.getSheet().getRow(indexRow).createCell(indexCell);

		this.getSheet().getRow(indexRow).getCell(indexCell).setCellStyle(this.getStyleBarraTitulo());
		this.getSheet().getRow(indexRow).getCell(indexCell).setCellValue(valor);

	}
	
	public void setBarraTitulo(int indexRow, int indexCell, String valor, short color) {

		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);
		if (this.getSheet().getRow(indexRow).getCell(indexCell) == null)
			this.getSheet().getRow(indexRow).createCell(indexCell);

		this.getSheet().getRow(indexRow).getCell(indexCell).setCellStyle(this.getStyleBarraTitulo());
		this.getSheet().getRow(indexRow).getCell(indexCell).setCellValue(valor);

	}

	public void setFooter(int indexRow, int indexCellFrom, int indexCellTo,
			String titulo) {
		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);

		for (int index = indexCellFrom; index <= indexCellTo; index++) {
			if (this.getSheet().getRow(indexRow).getCell(index) == null)
				this.getSheet().getRow(indexRow).createCell(index);
		}

		this.getSheet().addMergedRegion(
				new CellRangeAddress(indexRow, indexRow, indexCellFrom,
						indexCellTo));

		this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellStyle(
				this.getStyleFooter());
		this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellValue(
				titulo);
	}

	public void setFooterRight(int indexRow, int indexCellFrom,
			int indexCellTo, String titulo) {
		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);

		for (int index = indexCellFrom; index <= indexCellTo; index++) {
			if (this.getSheet().getRow(indexRow).getCell(index) == null)
				this.getSheet().getRow(indexRow).createCell(index);
		}

		this.getSheet().addMergedRegion(
				new CellRangeAddress(indexRow, indexRow, indexCellFrom,
						indexCellTo));

		this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellStyle(this.getStyleFooterRight());
		this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellValue(titulo);
	}

	public void setBarraTitulo(int indexRow, int indexCellFrom, int indexCellTo, String titulo) {
		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);

		for (int index = indexCellFrom; index <= indexCellTo; index++) {
			if (this.getSheet().getRow(indexRow).getCell(index) == null)
				this.getSheet().getRow(indexRow).createCell(index);
		}

		this.getSheet().addMergedRegion(
				new CellRangeAddress(indexRow, indexRow, indexCellFrom,
						indexCellTo));

		this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellStyle(
				this.getStyleBarraTitulo());
		this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellValue(
				titulo);
	}

	public void setImagen(int indexRow, int indexCell, String pathImg)
			throws IOException {

		FileInputStream fis = new FileInputStream(pathImg);

		ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
		int b;
		while ((b = fis.read()) != -1)
			img_bytes.write(b);

		fis.close();
		HSSFClientAnchor anchor = new HSSFClientAnchor();
		anchor.setCol1(indexCell);
		anchor.setRow1(indexRow);
		int index = this.getWb().addPicture(img_bytes.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG);

		HSSFPatriarch patriarch = null;

		if (this.getSheet().getDrawingPatriarch() == null)
			patriarch = this.getSheet().createDrawingPatriarch();
		else
			patriarch = this.getSheet().getDrawingPatriarch();

		HSSFPicture picture = patriarch.createPicture(anchor, index);
		picture.setAnchor(picture.getPreferredSize());
	}

	public void setContentValueColor(int indexRow, int indexCellFrom,
			int indexCellTo, String texto, String color) {
		if (this.getSheet().getRow(indexRow) == null)
			this.getSheet().createRow(indexRow);

		for (int index = indexCellFrom; index <= indexCellTo; index++) {
			if (this.getSheet().getRow(indexRow).getCell(index) == null)
				this.getSheet().getRow(indexRow).createCell(index);
		}

		this.getSheet().addMergedRegion(new CellRangeAddress(indexRow, indexRow, indexCellFrom, indexCellTo));

		HSSFCellStyle verde = crearStyleDynamic(HSSFColor.DARK_GREEN.index, 214, 254, 217);
		HSSFCellStyle rojo = crearStyleDynamic(HSSFColor.DARK_RED.index, 255, 177, 177);
		HSSFCellStyle ambar = crearStyleDynamic(HSSFColor.DARK_YELLOW.index, 254, 254, 204);
		
		if (color == null || color.length() == 0)
			this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellStyle(this.getStyleContent());
		else if (color.equals("#00FF00"))
			this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellStyle(verde);
		else if (color.equals("#FFFF00"))
			this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellStyle(ambar);
		else if (color.equals("#FF0000"))
			this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellStyle(rojo);
		else
			this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellStyle(this.getStyleContent());

		this.getSheet().getRow(indexRow).getCell(indexCellFrom).setCellValue(texto);
	}

	public InputStream getExcelStream() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		this.getWb().write(baos);
		return new ByteArrayInputStream(baos.toByteArray());
	}

	public byte[] getExcelToByteArray() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		this.getWb().write(baos);
		return baos.toByteArray();
	}
	
	// ---- PRIVATE METHOD'S ----

	protected HSSFCell obtenerCelda(int indexRow, int indexCell) {
		HSSFRow filaExcel = sheet.getRow(indexRow);
		HSSFCell cellExcel = null;

		if (filaExcel == null)
			filaExcel = sheet.createRow(indexRow);

		cellExcel = filaExcel.getCell(indexCell);

		if (cellExcel == null)
			cellExcel = filaExcel.createCell(indexCell);

		return cellExcel;
	}

	private void crearLabelStaticStyle() {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);

		HSSFFont font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);

		this.setStyleLabel(style);

	}

	private void crearContentStaticStyle() {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);

		HSSFFont font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		style.setFont(font);

		this.setStyleContent(style);
	}

	private void crearContentStaticStyleCenter() {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		HSSFFont font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		style.setFont(font);

		this.setStyleContentCenter(style);
	}

	private void crearContentStaticStyleCenterNO() {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(HSSFColor.RED.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFFont font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		style.setFont(font);

		this.setStyleContentNO(style);
	}

	private void crearContentStaticStyleCenterSI() {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(HSSFColor.GREEN.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFFont font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		style.setFont(font);

		this.setStyleContentSI(style);
	}

	private void crearStyleBarraTitulo() {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFFont font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		this.setStyleBarraTitulo(style);
	}

	private void crearStyleFooter() {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFFont font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		this.setStyleFooter(style);
	}

	private void crearStyleFooterRight() {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		style.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFFont font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		this.setStyleFooterRight(style);
	}

	private void crearContentStaticStyleRojo() {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(HSSFColor.RED.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFFont font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		style.setFont(font);

		this.setStyleContentCenterRojo(style);
	}

	private void crearContentStaticStyleVerde() {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(HSSFColor.GREEN.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFFont font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		style.setFont(font);

		this.setStyleContentCenterVerde(style);
	}

	private void crearContentStaticStyleAmarillo() {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(HSSFColor.YELLOW.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFFont font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		style.setFont(font);

		this.setStyleContentCenterAmarillo(style);
	}

	private HSSFColor crearColor(short colorIndex, int red, int green, int blue) {
		HSSFPalette palette = wb.getCustomPalette();
		palette.setColorAtIndex(colorIndex, (byte) red, (byte) green, (byte) blue);
		return palette.getColor(colorIndex);
	}

	public HSSFCellStyle crearStyleDynamic(short align, short color, short colorFont, short fill, short fontSize) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(align);
		style.setFillForegroundColor(color);
		style.setFillPattern(fill);

		HSSFFont font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) fontSize);
		font.setColor(colorFont);
		style.setFont(font);

		return style;
	}
	
	public HSSFCellStyle crearStyleDynamic(short align, short colorIndex, int red, int green, int blue) {
		crearColor(colorIndex, red, green, blue);
		return crearStyleDynamic(align, colorIndex, HSSFColor.WHITE.index, HSSFCellStyle.SOLID_FOREGROUND, (short) 10);
	}

	public HSSFCellStyle crearStyleDynamic(short colorIndex, int red, int green, int blue) {
		crearColor(colorIndex, red, green, blue);
		return crearStyleDynamic(HSSFCellStyle.ALIGN_CENTER, colorIndex, HSSFColor.BLACK.index, HSSFCellStyle.SOLID_FOREGROUND, (short) 10);
	}
	
	// ---- GETTER'S AND SETTER'S ----

	public HSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(HSSFSheet sheet) {
		this.sheet = sheet;
	}

	public HSSFWorkbook getWb() {
		return wb;
	}

	public void setWb(HSSFWorkbook wb) {
		this.wb = wb;
	}

	public HSSFCellStyle getStyleLabel() {
		return styleLabel;
	}

	public void setStyleLabel(HSSFCellStyle styleLabel) {
		this.styleLabel = styleLabel;
	}

	public HSSFCellStyle getStyleContent() {
		return styleContent;
	}

	public void setStyleContent(HSSFCellStyle styleContent) {
		this.styleContent = styleContent;
	}

	public HSSFCellStyle getStyleContentCenter() {
		return styleContentCenter;
	}

	public void setStyleContentCenter(HSSFCellStyle styleContentCenter) {
		this.styleContentCenter = styleContentCenter;
	}

	public HSSFCellStyle getStyleBarraTitulo() {
		return styleBarraTitulo;
	}

	public void setStyleBarraTitulo(HSSFCellStyle styleBarraTitulo) {
		this.styleBarraTitulo = styleBarraTitulo;
	}

	public HSSFCellStyle getStyleFooter() {
		return styleFooter;
	}

	public void setStyleFooter(HSSFCellStyle styleFooter) {
		this.styleFooter = styleFooter;
	}

	public HSSFCellStyle getStyleFooterRight() {
		return styleFooterRight;
	}

	public void setStyleFooterRight(HSSFCellStyle styleFooterRight) {
		this.styleFooterRight = styleFooterRight;
	}

	public HSSFCellStyle getStyleContentNO() {
		return styleContentNO;
	}

	public void setStyleContentNO(HSSFCellStyle styleContentNO) {
		this.styleContentNO = styleContentNO;
	}

	public HSSFCellStyle getStyleContentCenterRojo() {
		return styleContentCenterRojo;
	}

	public void setStyleContentCenterRojo(HSSFCellStyle styleContentCenterRojo) {
		this.styleContentCenterRojo = styleContentCenterRojo;
	}

	public HSSFCellStyle getStyleContentCenterVerde() {
		return styleContentCenterVerde;
	}

	public void setStyleContentCenterVerde(HSSFCellStyle styleContentCenterVerde) {
		this.styleContentCenterVerde = styleContentCenterVerde;
	}

	public HSSFCellStyle getStyleContentCenterAmarillo() {
		return styleContentCenterAmarillo;
	}

	public void setStyleContentCenterAmarillo(
			HSSFCellStyle styleContentCenterAmarillo) {
		this.styleContentCenterAmarillo = styleContentCenterAmarillo;
	}

	public HSSFCellStyle getStyleContentSI() {
		return styleContentSI;
	}

	public void setStyleContentSI(HSSFCellStyle styleContentSI) {
		this.styleContentSI = styleContentSI;
	}

}