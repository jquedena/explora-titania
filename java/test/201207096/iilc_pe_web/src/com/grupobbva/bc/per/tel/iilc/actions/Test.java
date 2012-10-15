package com.grupobbva.bc.per.tel.iilc.actions;

import java.io.File;
import java.io.IOException;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File("c:\\qwerasdf.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		f = null;
	}

}
