package imagingbook_test;

import ij.ImageJ;
import imagingbook.lib.settings.PrintPrecision;

public class TestClass {
	
	public static void main(String[] args) {
		int pp = PrintPrecision.get();
		System.out.println("PrintPrecision (imagingbook) = " + pp);
		
		System.out.println("ImageJ version = " + ImageJ.VERSION);
		new ImageJ();
	}

}
