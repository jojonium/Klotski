package klotski.controller;

import klotski.model.Board;
import klotski.view.KlotskiApp;

public class MovePieceController {
	final KlotskiApp app;
	final Board b;
	
	/**
	 * Basic constructor
	 * @param app the view application
	 * @param b the model board
	 */
	public MovePieceController(KlotskiApp app, Board b) {
		this.app = app;
		this.b = b;
	}
	
	/**
	 * Attempts to move the selected piece in the input direction. Does nothing
	 * if no piece is selected. If move is successful, updates moves counter
	 * @param direction 0=up, 1=right, 2=down, 3=right
	 * @return true if move was successful, false otherwise
	 */
	public boolean move(int direction) {
		if (b.movePiece(direction)) {
			app.getMovesCounter().setText(Integer.toString(b.getMoves()));
			app.getPuzzleView().refresh();
			return true;
		}
			return false;
	}
}
