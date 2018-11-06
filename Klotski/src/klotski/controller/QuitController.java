package klotski.controller;

import javax.swing.JOptionPane;

import klotski.view.KlotskiApp;

	
public class QuitController {
	//final KlotskiApp app;

	/**
	 * Basic constructor
	 * @param app the view application
	 *
	public QuitController(KlotskiApp app) {
		this.app = app;
		
	}*/
	
	
	
	public boolean confirm(KlotskiApp app) {
		return JOptionPane.showConfirmDialog (app, "Are you sure you want to quit?") == JOptionPane.OK_OPTION;	
	}
	
	/*public void quit() {
		app.dispose();
	}*/
}
