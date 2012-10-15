/*
 * Created on 18/12/2007
 */
package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

/**
 * @author P020795
 * 
 */
public class Impresion {

	public void imprimir() throws FileNotFoundException {
		InputStream stream = new java.io.FileInputStream("E:/1.txt");
		DocFlavor formato = DocFlavor.INPUT_STREAM.AUTOSENSE;
		Doc documento = new SimpleDoc(stream, formato, null);
		PrintService impresora = PrintServiceLookup.lookupDefaultPrintService();
		if (impresora != null) {
			javax.print.DocPrintJob job = impresora.createPrintJob();
			try {
				job.print(documento, null);
			} catch (javax.print.PrintException pe) {
				pe.printStackTrace();
			}
		}
	}
	public static void main(String[] av) {
		try {
			Impresion im = new Impresion();
			im.imprimir();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
