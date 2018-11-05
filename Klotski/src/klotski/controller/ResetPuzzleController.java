package klotski.controller;

import klotski.model.Board;
import klotski.view.KlotskiApp;

public class ResetPuzzleController {
	final KlotskiApp app;
	final Board b;
	
	/**
	 * Basic constructor
	 * @param app the view application
	 * @param b the model board
	 */
	public ResetPuzzleController(KlotskiApp app, Board b) {
		this.app = app;
		this.b = b;
	}
	
	/**
	 * Resets all pieces to their original position, sets moves to 0, and
	 * refreshes display
	 */
	public void reset() {
		b.reset();
		app.getMovesCounter().setText(Integer.toString(b.getMoves()));
		app.getPuzzleView().refresh();
	}
}
