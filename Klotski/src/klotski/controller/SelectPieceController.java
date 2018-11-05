package klotski.controller;

import java.awt.event.MouseEvent;

import klotski.model.Board;
import klotski.view.KlotskiApp;

public class SelectPieceController {
	final KlotskiApp app;
	final Board b;
	
	/**
	 * Basic constructor
	 * @param app the view application
	 * @param b the model board
	 */
	public SelectPieceController(KlotskiApp app, Board b) {
		this.app = app;
		this.b = b;
	}
	
	/**
	 * Extracts the x and y coordinates of the point clicked and attempts to
	 * select the Piece occupying that point
	 * @param e the MouseEvent passed from the view
	 * @return true if a Piece was successfully selected, false otherwise
	 */
	public boolean select(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			int xCoord = e.getX() / app.getPuzzleView().getSquareSize();
			int yCoord = e.getY() / app.getPuzzleView().getSquareSize();
						
			// tell the model to select the piece
			b.selectPiece(xCoord, yCoord);
			
			// tell the view to update
			app.getPuzzleView().refresh();
			
			return true;
		}
		
		return false;
	}
}
