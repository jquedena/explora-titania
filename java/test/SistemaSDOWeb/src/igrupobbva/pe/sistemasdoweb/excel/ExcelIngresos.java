package igrupobbva.pe.sistemasdoweb.excel;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import jxl.Range;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.log4j.Logger;

import pe.com.indra.component.model.MetaData;
import proxy.load.Connection;

import com.grupobbva.bc.per.tele.sdo.serializable.ReporteIngreso;
import com.grupobbva.bc.per.tele.sdo.util.ConstantesUtil;

@SuppressWarnings({"unused", "unchecked", "null"})
public class ExcelIngresos {
	
	protected static Logger log = Logger.getLogger(ExcelIngresos.class);

	private void agregarCabeceras(WritableSheet sheet, int fila, Label l, WritableCellFormat formato, 
			ArrayList listaDiasMesesReporte) {
		int i = 7;
		Iterator iter = null;
		
		try {
			log.info("[ExcelIngresos :: agregarCabeceras] Inicio");
			
			l = new Label(1, fila, "Usuario", formato); 
			sheet.addCell(l);
			
			l = new Label(2, fila, "Nombre", formato); 
			sheet.addCell(l);
			
			l = new Label(3, fila, "Cargo", formato); 
			sheet.addCell(l);
			
			l = new Label(4, fila, "Territorio", formato); 
			sheet.addCell(l);
			
			l = new Label(5, fila, "Oficina", formato); 
			sheet.addCell(l);
			
			l = new Label(6, fila, "Desc Ofic", formato); 
			sheet.addCell(l);
			
			l = new Label(7, fila, "Fechas", formato); 
			sheet.addCell(l);
			
			
			if(listaDiasMesesReporte != null && listaDiasMesesReporte.size() > 0) {
				iter = listaDiasMesesReporte.iterator();
				
				while(iter.hasNext()) {
					String diaMes = (String)iter.next();
					
					l = new Label(++i, fila, ConstantesUtil.fechaFormatText(diaMes), formato); 
					sheet.addCell(l);
				}
			}
			i++;
			
			l = new Label(i, fila, "Totales", formato); 
			sheet.addCell(l);
			
			log.info("[ExcelIngresos :: agregarCabeceras] Fin");
		} catch (RowsExceededException e) {
			log.error("[ExcelIngresos :: agregarCabeceras] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (WriteException e) {
			log.error("[ExcelIngresos :: agregarCabeceras] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		} catch (Exception e) {
			log.error("[ExcelIngresos :: agregarCabeceras] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
	}
	
	public boolean generarExcel(Vector datos, String path, String titulo, int dia, int mes, int anio) {
		boolean res = false;
		Workbook original = null;
		WritableWorkbook workbook = null;
		ReporteIngreso reporteIngreso;
		int fila;
		ArrayList listaTempDiasMesesReporte = null; 
		ArrayList listaDiasMesesReporte = null; 
		Iterator  iterListaColumnasVacias = null;
		ArrayList listaColumnasVacias = null;
		int colsAdicionales = 0;
		boolean esFilaNroIngresos = false;
		
		try {
			log.info("[ExcelIngresos :: generarExcel] Inicio");
			
			//verificaciones
			File test = null;
			
			//destino no existe
			test = new File(path);
			if (test.exists())
				//destino no esta bloqueado
				if (!test.delete()){
					log.info("[ExcelIngresos :: generarExcel] Archivo bloqueado : " + path);
					return false;
				}
			test = null;
			//fin de verificaciones
			
			WorkbookSettings settings = new WorkbookSettings();
			settings.setLocale(java.util.Locale.US);
			
			//nuevo workbook
			workbook = Workbook.createWorkbook(new File(path),settings);
			//nueva hoja
			WritableSheet sheet = workbook.createSheet("Reporte",0);
			
			Label label;
			Number number;
			
			// estilos
			WritableFont fuenteTitulo = new WritableFont(WritableFont.createFont("Calibri"), 14, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.AUTOMATIC); 
			WritableCellFormat formatoTitulo = new WritableCellFormat (fuenteTitulo);
				formatoTitulo.setAlignment(Alignment.CENTRE);
						
			WritableFont fuenteCeldaTitulo = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableFont fuenteCeldaTitulo2 = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableFont fuenteCeldaMensaje = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.DARK_BLUE);
			
			// Formato Titulo			
			WritableCellFormat formatoCeldaTituloAzulCentro = new WritableCellFormat (fuenteCeldaTitulo);
			formatoCeldaTituloAzulCentro.setAlignment(Alignment.CENTRE);
			formatoCeldaTituloAzulCentro.setBorder(Border.ALL, BorderLineStyle.THIN);
			formatoCeldaTituloAzulCentro.setBackground(Colour.DARK_BLUE);
			
			WritableCellFormat formatoCeldaTituloGrisCentro = new WritableCellFormat (fuenteCeldaTitulo2);
			formatoCeldaTituloGrisCentro.setAlignment(Alignment.CENTRE);
			formatoCeldaTituloGrisCentro.setBorder(Border.ALL, BorderLineStyle.THIN);
			formatoCeldaTituloGrisCentro.setBackground(Colour.GREY_25_PERCENT);
			
			WritableCellFormat formatoCeldaTituloDerecha = new WritableCellFormat (fuenteCeldaTitulo);
			formatoCeldaTituloDerecha.setAlignment(Alignment.RIGHT);
			formatoCeldaTituloDerecha.setBorder(Border.ALL, BorderLineStyle.THIN);
			formatoCeldaTituloDerecha.setBackground(Colour.GRAY_25);
				
			// Formato SubTitulo
			WritableFont fuenteSubTitulo = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.AUTOMATIC);
			
			WritableCellFormat formatoCeldaSubTituloCentro = new WritableCellFormat(fuenteSubTitulo);
			formatoCeldaSubTituloCentro.setAlignment(Alignment.CENTRE);
			formatoCeldaSubTituloCentro.setBorder(Border.ALL, BorderLineStyle.THIN);
			formatoCeldaSubTituloCentro.setBackground(Colour.GRAY_25);
				
			WritableCellFormat formatoCeldaSubTituloDerecha = new WritableCellFormat (fuenteSubTitulo);
			formatoCeldaSubTituloDerecha.setAlignment(Alignment.RIGHT);
			formatoCeldaSubTituloDerecha.setBorder(Border.ALL, BorderLineStyle.THIN);
			formatoCeldaSubTituloDerecha.setBackground(Colour.GRAY_25);
			
			// Formato Normal	
			WritableFont fuenteCeldaNormal = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.AUTOMATIC); 
			WritableCellFormat formatoCeldaNormalNoAlign = new WritableCellFormat (fuenteCeldaNormal);
				formatoCeldaNormalNoAlign.setBorder(Border.ALL, BorderLineStyle.THIN);
				
			WritableCellFormat formatoCeldaNormalSinBorde = new WritableCellFormat(fuenteCeldaNormal);
				formatoCeldaNormalSinBorde.setAlignment(Alignment.LEFT);
				formatoCeldaNormalSinBorde.setBorder(Border.ALL, BorderLineStyle.NONE);
			
			WritableCellFormat formatoCeldaNormalDerecha = new WritableCellFormat(fuenteCeldaNormal);
				formatoCeldaNormalDerecha.setAlignment(Alignment.RIGHT);
				formatoCeldaNormalDerecha.setBorder(Border.ALL, BorderLineStyle.THIN);
				
			WritableCellFormat formatoCeldaNormalCentro = new WritableCellFormat(fuenteCeldaNormal);
			formatoCeldaNormalCentro.setAlignment(Alignment.CENTRE);
			formatoCeldaNormalCentro.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			// Formato Normal Negrita	
			WritableFont fuenteCeldaNegritaNormal = new WritableFont(WritableFont.createFont("Calibri"), 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.AUTOMATIC);
			WritableCellFormat formatoCeldaNormalNegritaCentro = new WritableCellFormat(fuenteCeldaNegritaNormal);
			formatoCeldaNormalNegritaCentro.setAlignment(Alignment.CENTRE);
			formatoCeldaNormalNegritaCentro.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			WritableCellFormat formatoCeldaNormalVerdeDerecha = new WritableCellFormat(fuenteCeldaNormal);
			formatoCeldaNormalVerdeDerecha.setAlignment(Alignment.RIGHT);
			formatoCeldaNormalVerdeDerecha.setBorder(Border.ALL, BorderLineStyle.THIN);	
			formatoCeldaNormalVerdeDerecha.setBackground(Colour.AQUA);	
			
			WritableCellFormat formatoCeldaNegritaVerdeDerecha = new WritableCellFormat(fuenteCeldaNegritaNormal);
			formatoCeldaNormalVerdeDerecha.setAlignment(Alignment.RIGHT);
			formatoCeldaNormalVerdeDerecha.setBorder(Border.ALL, BorderLineStyle.THIN);	
			formatoCeldaNormalVerdeDerecha.setBackground(Colour.AQUA);
			
			WritableCellFormat formatoCeldaNegritaVerdeCentro = new WritableCellFormat(fuenteCeldaNegritaNormal);
			formatoCeldaNegritaVerdeCentro.setAlignment(Alignment.CENTRE);
			formatoCeldaNegritaVerdeCentro.setBorder(Border.ALL, BorderLineStyle.THIN);
			formatoCeldaNegritaVerdeCentro.setBackground(Colour.AQUA);
			
			WritableCellFormat formatoCeldaNormalVerdeCentro = new WritableCellFormat(fuenteCeldaNegritaNormal);
			formatoCeldaNormalVerdeCentro.setAlignment(Alignment.CENTRE);
			formatoCeldaNormalVerdeCentro.setBorder(Border.ALL, BorderLineStyle.THIN);
			formatoCeldaNormalVerdeCentro.setBackground(Colour.AQUA);
			
			// Formato Mensaje			
			WritableCellFormat formatoCeldaMensajeCentro = new WritableCellFormat(fuenteCeldaMensaje);
			formatoCeldaMensajeCentro.setAlignment(Alignment.CENTRE);
			formatoCeldaMensajeCentro.setBorder(Border.ALL, BorderLineStyle.THIN);
			formatoCeldaMensajeCentro.setBackground(Colour.WHITE);
			
			//titulo
			
			if(dia == -1 && mes == -1) {
				// por anio
				Connection con = new Connection();
				listaTempDiasMesesReporte = con.listarDiasMesesxAnio(anio);
				
			} else {
				if(dia == -1) {
					listaTempDiasMesesReporte = ConstantesUtil.diasMesesReporte(mes, anio);
				} else {
					listaTempDiasMesesReporte = ConstantesUtil.diaReporte(dia, mes, anio);
				}
			}
			
			colsAdicionales = listaTempDiasMesesReporte != null ? listaTempDiasMesesReporte.size() : 0;
			
			// eliminar Columnas Vacias
			listaColumnasVacias = eliminarColumnasVacias(datos);
			boolean bandEliminar = true;
			
			if(		(listaTempDiasMesesReporte != null && listaTempDiasMesesReporte.size() > 0) ) {
				listaDiasMesesReporte =  new ArrayList();
				
				for(int i = 0; i < colsAdicionales; i++) {
					bandEliminar = false;
					
					if(listaColumnasVacias != null && listaColumnasVacias.size() > 0) {
						iterListaColumnasVacias =  listaColumnasVacias.iterator();
						
						while(iterListaColumnasVacias.hasNext()) {
							String indColEliminar = (String) iterListaColumnasVacias.next();
							
							if(indColEliminar.equals(String.valueOf(i))) {
								bandEliminar = true;
								break;
							}
						}
					}
					
					if(bandEliminar) {
						continue;
					}
					
					listaDiasMesesReporte.add(listaTempDiasMesesReporte.get(i));
				}
			}
			
			
			colsAdicionales = listaDiasMesesReporte != null ? listaDiasMesesReporte.size() : 0;
			
			Range range1 = sheet.mergeCells(0, 0, 7, 0);	
			label = new Label(0,0,titulo, formatoTitulo); 
			sheet.addCell(label);
			
			sheet.setColumnView(0,3);
			sheet.setColumnView(1,10);
			sheet.setColumnView(2,35);
			sheet.setColumnView(3,8);
			sheet.setColumnView(4,25);
			sheet.setColumnView(5,8);
			sheet.setColumnView(6,20);
			sheet.setColumnView(7,15);
			
			int filaView = 7;
			for(int i = 0; i < colsAdicionales; i++) {
				sheet.setColumnView(++filaView, 15);
			}
			filaView++;
			
			sheet.setColumnView(filaView,10);
			
			// datos
			fila = 2;
			
			
			agregarCabeceras(sheet, fila,label, formatoCeldaTituloAzulCentro, listaDiasMesesReporte);
			fila++;
			int formato = -1;
			
			for(int i = 0; i < datos.size(); i++){
				reporteIngreso = (ReporteIngreso)datos.elementAt(i);
				
				if(		reporteIngreso.getTotal() != null && 
						!reporteIngreso.getTotal().equals("") && 
						Integer.parseInt(reporteIngreso.getTotal()) == 0) {
						continue;
				}
				
				formato = reporteIngreso.getFormato();
				
				//usuario
				label = new Label(1, fila, reporteIngreso.getCodUsuario(), 
						formato == 3 ? formatoCeldaNormalSinBorde : formatoCeldaNormalCentro); 
				sheet.addCell(label);
				
				// nombres
				label = new Label(2, fila, reporteIngreso.getNombres(), 
						formato == 3 ? formatoCeldaNormalSinBorde : formatoCeldaNormalNoAlign);
				sheet.addCell(label);
				
				// cargo
				label = new Label(3, fila, reporteIngreso.getCargo(), 
					formato == 3 ? formatoCeldaNormalSinBorde : formatoCeldaNormalNoAlign);
				sheet.addCell(label);
				
				// territorio
				label = new Label(4, fila, reporteIngreso.getNomTerritorio(), 
						formato == 3 ? formatoCeldaNormalSinBorde : formatoCeldaNormalNoAlign);
				sheet.addCell(label);
				
				// cod oficina
				label = new Label(5, fila, reporteIngreso.getCodOficina(), 
						formato == 3 ? formatoCeldaNormalSinBorde : formatoCeldaNormalDerecha);
				sheet.addCell(label);
				
				// desc oficina
				label = new Label(6, fila, reporteIngreso.getDescOficina(), 
						formato == 3 ? formatoCeldaNormalSinBorde : formatoCeldaNormalNoAlign);
				sheet.addCell(label);
				
				esFilaNroIngresos = false;
				if(	reporteIngreso.getEtiquetaFechas() != null && 
					reporteIngreso.getEtiquetaFechas().equals("N" + (char) 176 + " Ingresos")) {
					esFilaNroIngresos = true;
				}
				
				//	Fechas
				if(esFilaNroIngresos) {
					label = new Label(7, fila, reporteIngreso.getEtiquetaFechas(), 
							formato == 3 ? formatoCeldaNormalSinBorde : formatoCeldaNegritaVerdeCentro);
				} else {
					label = new Label(7, fila, reporteIngreso.getEtiquetaFechas(), 
							formato == 3 ? formatoCeldaNormalSinBorde : formatoCeldaTituloGrisCentro);
				}
				
				sheet.addCell(label);
				
				int col = 7;
				
				if(reporteIngreso.getListaDatos() != null & reporteIngreso.getListaDatos().size() > 0) {
					for(int j = 0; j < colsAdicionales; j++) {
						String valor = (String)reporteIngreso.getListaDatos().get(j);
						
						if(formato == 1) {
							if(esFilaNroIngresos) {
								label = new Label(++col, fila, valor, formatoCeldaNormalVerdeDerecha);
							} else {
								label = new Label(++col, fila, valor, formatoCeldaNormalDerecha);
							}
						} else {
							if(formato == 2) {
								label = new Label(++col, fila, valor, formatoCeldaNormalCentro);
							} else {
								label = new Label(++col, fila, valor, formatoCeldaNormalSinBorde);
							}
						}
						 
						sheet.addCell(label);
					}
				} else {
					for(int j = 0; j < colsAdicionales; j++) {
						if(formato == 1) {
							if(esFilaNroIngresos) {
								label = new Label(++col, fila, "", formatoCeldaNormalVerdeDerecha);
							} else {
								label = new Label(++col, fila, "", formatoCeldaNormalDerecha);
							}
						} else {
							if(formato == 2) {
								label = new Label(++col, fila, "", formatoCeldaNormalCentro);
							} else {
								label = new Label(++col, fila, "", formatoCeldaNormalSinBorde);
							}
						}
						 
						sheet.addCell(label);
					}
				}
				
				// Totales
				if(esFilaNroIngresos) {
					label = new Label(++col, fila, reporteIngreso.getTotal(), 
							formato == 3 ? formatoCeldaNormalSinBorde : formatoCeldaNormalVerdeDerecha);
				} else {
					label = new Label(++col, fila, reporteIngreso.getTotal(), 
							formato == 3 ? formatoCeldaNormalSinBorde : formatoCeldaNormalDerecha);
				}
				
				sheet.addCell(label);
				
				fila++;
			}
			
			fila++;
			res = true;
		} catch (IOException e) {
			log.error("[ExcelIngresos :: generarExcel] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			try {workbook.close();} catch (WriteException e1) {} catch (IOException e1) {} catch (RuntimeException e2) {}
			try {original.close();} catch (RuntimeException e2) {}
			return false;
		} catch (WriteException e) {
			log.error("[ExcelIngresos :: generarExcel] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			try {workbook.close();} catch (WriteException e1) {} catch (IOException e1) {} catch (RuntimeException e2) {}
			try {original.close();} catch (RuntimeException e2) {}
			return false;
		} catch (Exception e) {
			log.error("[ExcelIngresos :: generarExcel] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
			
			return false;
		} finally {
			if(workbook != null) {
				try { 
					workbook.write();
					workbook.close();
				} catch(Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			
			if(original != null) {
				try { 				
					original.close();
				} catch(Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		
		return res;
	}
	
	public ArrayList eliminarColumnasVacias(Vector listaRegistro) {
		Iterator iterListaRegistro =  null;
		ArrayList listaDatos = null;
		ArrayList nuevaListaDatos = null;
		ReporteIngreso reporteIngreso = null;
		int tamColumnas  = 0;
		boolean bandEliminar = true;
		ArrayList listaColEliminar = null;
		Iterator iterListaColEliminar =  null;
		Iterator iterListaDatos =  null;
		
		try {
			log.info("[ExcelIngresos :: eliminarColumnasVacias] Inicio");
			
			if(listaRegistro != null && listaRegistro.size() > 0) {
				reporteIngreso = (ReporteIngreso) listaRegistro.get(0);
				
				if(reporteIngreso != null) {
					listaColEliminar = new ArrayList();
					
					listaDatos = reporteIngreso.getListaDatos();
					if(listaDatos != null) {
						tamColumnas = reporteIngreso.getListaDatos().size();
					}
					
					for(int i = 0; i < tamColumnas; i++) {
						iterListaRegistro = listaRegistro.iterator();
						
						bandEliminar = true;
						
						while(iterListaRegistro.hasNext()) {
							reporteIngreso = (ReporteIngreso)iterListaRegistro.next();
							listaDatos = reporteIngreso.getListaDatos();
							
							if(listaDatos != null && listaDatos.size() > 0) {
								String valor = (String)listaDatos.get(i);
								
								if(valor != null && !valor.equals("")) {
									bandEliminar = false;
									break;
								}
							}
						}
						
						if(bandEliminar) {
							listaColEliminar.add(String.valueOf(i));
						}
					}
					
					iterListaRegistro = listaRegistro.iterator();
				}
				
				// Eliminar cols sin data
				if(listaColEliminar != null && listaColEliminar.size() > 0) {
					iterListaRegistro = listaRegistro.iterator();
					
					while(iterListaRegistro.hasNext()) {
						reporteIngreso = (ReporteIngreso)iterListaRegistro.next();
						listaDatos = reporteIngreso.getListaDatos();
						nuevaListaDatos =  new ArrayList();
						
						if(listaDatos != null && listaDatos.size() > 0) {
							for(int i = 0; i < tamColumnas; i++) {
								bandEliminar = false;
								iterListaColEliminar =  listaColEliminar.iterator();
								
								while(iterListaColEliminar.hasNext()) {
									String indColEliminar = (String) iterListaColEliminar.next();
									
									if(indColEliminar.equals(String.valueOf(i))) {
										bandEliminar = true;
										break;
									}
								}
								
								if(bandEliminar) {
									continue;
								}
								
								nuevaListaDatos.add(listaDatos.get(i));
							}
							
							reporteIngreso.setListaDatos(nuevaListaDatos);
						}
					}
				}
			}
			
			log.info("[ExcelIngresos :: eliminarColumnasVacias] Fin");
		} catch(Exception e) {
			log.error("[ExcelIngresos :: eliminarColumnasVacias] ");
			ConstantesUtil.mostrarMensajeExcepcion(e);
		}
		
		return listaColEliminar;
	}
	
	public void generarReporte(String fileName, String sheetName, List<Object[]> result, List<MetaData> cols, String title) {
		Excel excel = new Excel(fileName, sheetName);
		// A.COD_TERR,A.TIPO_FORM,A.COD_USUARIO,A.NOMBRES,A.CARGO,A.TERRITORIO,A.COD_OFI,A.DESC_OFI,A.COD_OFICINA_M,A.NOM_OFIC_M,A.COD_GESTOR_M,A.NOM_GESTOR_M,A.TIPO

		excel.addMergeCell(0, 0, 10, 0, title, Excel.TITLE);
		
		int row = 3;
		int col = 1;
		int i = 0;
		int j = 0;
		Object[] o = null;
		
		excel.addCellHeader(col++, row, "USUARIO");
		excel.addCellHeader(col++, row, "NOMBRE");
		excel.addCellHeader(col++, row, "CARGO");
		excel.addCellHeader(col++, row, "TERRITORIO");
		excel.addCellHeader(col++, row, "OFICINA");
		excel.addCellHeader(col++, row, "DESC. OFICINA");
		excel.addCellHeader(col++, row, "COD. OFICINA SEL.");
		excel.addCellHeader(col++, row, "DESC. OFICINA SEL.");
		excel.addCellHeader(col++, row, "COD. GESTOR SEL.");
		excel.addCellHeader(col++, row, "NOMBRE GESTOR SEL.");
		excel.addCellHeader(col++, row, "FECHAS");

		for(i = 13; i < cols.size(); i++) {
			if(i < (cols.size() - 1)) {
				excel.addCellHeader(col++, row, cols.get(i).getColumnName(), Excel.HEADER_DARK_BLUE_PLUS_90);
			} else {
				excel.addCellHeader(col++, row, cols.get(i).getColumnName());
			}
		}
	
		row++;
		
		for(i = 0; i < result.size(); i++) {
			o = result.get(i);
			col = 1;
			excel.addCellObject(col++, row, o[2]); // "Usuario"
			excel.addCellObject(col++, row, o[3]); // "Nombre"
			excel.addCellObject(col++, row, o[4]); // "Cargo"
			excel.addCellObject(col++, row, o[5]); // "Territorio"
			excel.addCellObjectToDecimal(col++, row, o[6], Excel.CELL_NUMBER3); // "Oficina"
			excel.addCellObject(col++, row, o[7]); // "Desc. Oficina"
			excel.addCellObjectToDecimal(col++, row, o[8], Excel.CELL_NUMBER3); // "Cod. Oficina Sel."
			excel.addCellObject(col++, row, o[9]); // "Desc. Oficina Sel."
			excel.addCellObject(col++, row, o[10]); // "Cod. Gestor Sel."
			excel.addCellObject(col++, row, o[11]); // "Nombre Gestor Sel."
			excel.addCellObject(col++, row, o[12], (Integer.parseInt(o[1].toString()) == 0 ? Excel.CELL_TEXT_AQUA : Excel.CELL_TEXT_GRAY25)); // "Fechas"	
			
			for(j = 13; j < cols.size(); j++) {
				if(Integer.parseInt(o[1].toString()) == 0) {
					excel.addCellObjectToDecimal(col++, row, o[j], Excel.CELL_TEXT_AQUA);
				} else {
					if(j < (cols.size() - 1)) {
						excel.addCellObject(col++, row, o[j]);
					} else {
						excel.addCellObjectToDecimal(col++, row, o[j]);
					}
				}
			}
			
			row++;
		}
		
		// excel.autoSize(0, (cols.size() - 13) + 11);
		excel.save();
	}
}