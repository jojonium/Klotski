package klotski.controller;

import klotski.view.KlotskiApp;

public class QuitController {
	final KlotskiApp app;

	/**
	 * Basic constructor
	 * @param app the view application
	 */
	public QuitController(KlotskiApp app) {
		this.app = app;
	}
	
	public void quit() {
		app.dispose();
	}
}
