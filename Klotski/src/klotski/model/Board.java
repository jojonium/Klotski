package klotski.model;

import java.awt.Point;

/**
 * Represents the entire game board, containing several pieces
 * @author Joseph Petitti
 *
 */
public class Board {
	Piece[] pieces;
	Piece selectedPiece;
	int height;
	int width;
	int moves; // number of moves the player has made
	
	/**
	 * Basic constructor. Initializes height and width to standard klotski size.
	 * Initializes pieces to configuration 1
	 */
	public Board() {
		// make the pieces for configuration 1
		Piece[] config1 = new Piece[10];
		config1[0] = new Piece(new Point[] {new Point(1, 0), new Point(2, 0),
				new Point(1, 1), new Point(2, 1)});
		config1[1] = new Piece(new Point[] {new Point(0, 0), new Point(0, 1)});
		config1[2] = new Piece(new Point[] {new Point(3, 0), new Point(3, 1)});
		config1[3] = new Piece(new Point[] {new Point(0, 2), new Point(0, 3)});
		config1[4] = new Piece(new Point[] {new Point(1, 2)});
		config1[5] = new Piece(new Point[] {new Point(2, 2)});
		config1[6] = new Piece(new Point[] {new Point(3, 2), new Point(3, 3)});
		config1[7] = new Piece(new Point[] {new Point(1, 3)});
		config1[8] = new Piece(new Point[] {new Point(2, 3)});
		config1[9] = new Piece(new Point[] {new Point(1, 4), new Point(2, 4)});

		this.pieces = config1;
		this.selectedPiece = null;
		this.height = 5;
		this.width = 4;
		this.moves = 0;
	}
	
	/**
	 * selectedPiece getter
	 * @return this board's selectedPiece
	 */
	public Piece getSelectedPiece() { return selectedPiece; }
	
	/**
	 * width getter
	 * @return this board's width
	 */
	public int getWidth() { return width; }
	
	/**
	 * height getter
	 * @return this board's height
	 */
	public int getHeight() { return height; }
	
	/**
	 * pieces getter
	 * @return this board's pieces
	 */
	public Piece[] getPieces() { return pieces; }
	
	/**
	 * selects the piece at the given x and y coordinates
	 * @param x the x coordinate of the point in the piece you want to select
	 * @param y the y coordinate of the point in the piece you want to select
	 * @return true if a piece was selected, false otherwise
	 */
	public boolean selectPiece(int x, int y) {
		int i, j;
		
		for (i = 0; i < pieces.length; ++i) {
			for (j = 0; j < pieces[i].points.length; ++j) {
				if (pieces[i].points[j].x == x && pieces[i].points[j].y == y) {
					selectedPiece = pieces[i];
					return true;
				}
			}
		}
		
		// if we get here then they clicked on an empty square, so deselect
		// the piece
		selectedPiece = null;
		return false;
	}
	
	/**
	 * Checks whether there is a piece occupying a given point
	 * @param x the x coordinate of the point to check
	 * @param y the y coordinate of the point to check
	 * @return true if the point is occupied
	 */
	public boolean isOccupied(int x, int y) {
		int i, j;
		
		for (i = 0; i < pieces.length; ++i) {
			for (j = 0; j < pieces.length; ++j) {
				if (pieces[i].points[j].x == x && pieces[i].points[j].y == y) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Tries to move the selected piece in the given direction
	 * @param direction 0=up, 1=right, 2=down, 3=left
	 * @return true if the move was successful, false otherwise
	 */
	public boolean movePiece(int direction) {
		int dx, dy, i, tempx, tempy;
		
		// if no selected piece just return false and exit
		if (selectedPiece == null) {
			return false;
		}
		
		// check for a win
		if (selectedPiece == pieces[0] && 
				selectedPiece.getDims()[0] == 1 &&
				selectedPiece.getDims()[1] == 3 &&
				direction == 2) {
			// TODO congratulate the player
			return true;
		}
		
		// set dx and dy
		switch (direction) {
			case 0: dx = 0; dy = -1; break; // up
			case 1: dx = 1; dy = 0; break;  // right
			case 2: dx = 0; dy = 1; break;  // down
			case 3: dx = -1; dy = 0; break; //left
			default: dx = 0; dy = 0; throw new IllegalArgumentException(
					"direction must be [0..3]");
		}
		
		// check if the selectedPiece is able to move in the input direction
		for (i = 0; i < selectedPiece.points.length; ++i) {
			tempx = selectedPiece.points[i].x + dx;
			tempy = selectedPiece.points[i].y + dy;
			
			// make sure we're not trying to go out of bounds...
			if ((tempx >= width || tempx < 0 || tempy >= height || tempy < 0)
					// ...or colliding with another piece
					|| isOccupied(tempx, tempy) &&
					!selectedPiece.containsPoint(tempx, tempy)) {
				// move failed
				return false;
			}
					
		}
		
		// if we've gotten here if means we're clear to move the piece
		selectedPiece.move(direction);
		++moves;
		return true;
	}
}
