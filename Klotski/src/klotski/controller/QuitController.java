package klotski.controller;

import javax.swing.JOptionPane;

import klotski.view.KlotskiApp;

	
public class QuitController {
	/**
	 * Asks the player to confirm quitting the app
	 * @param app the top level application view
	 * @return true if the player clicks yes
	 */
	public boolean confirm(KlotskiApp app) {
		return JOptionPane.showOptionDialog (app, 
				"Are you sure you want to quit?", "Klotski - Confirm Quit",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
				null, null) == JOptionPane.OK_OPTION;	
	}
}
