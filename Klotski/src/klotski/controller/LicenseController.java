package klotski.controller;

import javax.swing.JOptionPane;

import klotski.view.KlotskiApp;

public class LicenseController {
	final KlotskiApp app;
	
	/**
	 * Basic constructor
	 * @param app the top-level application view
	 */
	public LicenseController(KlotskiApp app) {
		this.app = app;
	}
	
	/**
	 * Displays license info in a popup window
	 */
	public void show() {        
		JOptionPane.showMessageDialog(app, 
			/* Message */
			"Copyright 2018 Joseph Petitti\n" +
			"\n" +
			"Permission is hereby granted, free of charge, to any person\n" +
			"obtaining a copy of this software and associated documentation\n" +
			"files (the \"Software\"), to deal in the Software without\n" +
			"restriction, including without limitation the rights to use,\n" +
			"copy, modify, merge, publish, distribute, sublicense, and/or\n" +
			"sell copies of the Software, and to permit persons to whom the\n" +
			"Software is furnished to do so, subject to the following\n" +
			"conditions:\n" +
			"\n" +
			"The above copyright notice and this permission notice shall be\n" +
			"included in all copies or substantial portions of the Software.\n"+
			"\n" +
			"THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY\n" +
			"KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE\n" +
			"WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR\n" +
			"PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR\n" +
			"COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n" +
			"LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,\n"+
			"ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE\n" +
			"USE OR OTHER DEALINGS IN THE SOFTWARE.",

			/* Title */
			"Klotski Application License",

			/* Type. */
			JOptionPane.INFORMATION_MESSAGE);
	}
}
