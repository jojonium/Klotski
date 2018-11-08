package klotski.model;

/**
 * Represents the entire game board, containing several pieces
 * @author Joseph Petitti
 *
 */
public class Board {
	Piece[] pieces;
	Piece selected;
	int height;
	int width;
	int moves; // number of moves the player has made
	boolean hasWon;
	
	/**
	 * Basic constructor. Initializes height and width to standard klotski size.
	 * Initializes pieces to configuration 1
	 */
	public Board() {
		this.pieces = new Piece[10];
		
		// initialize all pieces to configuration 1, set moves to 0, set
		// selectedPiece to null, and set hasWon to false
		reset();
		
		this.height = 5;
		this.width = 4;
	}
	
	/**
	 * Custom constructor that uses a custom array of pieces
	 * @param pieces the custom array of pieces that this board holds
	 */
	public Board(Piece[] pieces) {
		this.pieces = pieces;
		this.height = 5;
		this.width = 4;
		this.moves = 0;
		this.hasWon = false;
		this.selected = null;
	}
	
	/**
	 * hasWon getter
	 * @return whether the play has won
	 */
	public boolean checkWin() { return hasWon; }
	
	/**
	 * move getter
	 * @return the current number of moves
	 */
	public int getMoves() { return moves; }
	
	/**
	 * selectedPiece getter
	 * @return this board's selectedPiece
	 */
	public Piece getSelectedPiece() { return selected; }
	
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
		for (Piece p : pieces) {
			if (p.containsPoint(x, y)) {
				selected = p;
				return true;
			}
		}
		
		// if we get here then they clicked on an empty square, so deselect
		// the piece
		selected = null;
		return false;
	}
	
	/**
	 * Checks whether there is a piece occupying a given point
	 * @param x the x coordinate of the point to check
	 * @param y the y coordinate of the point to check
	 * @return true if the point is occupied
	 */
	public boolean isOccupied(int x, int y) {
		for (Piece p : pieces) {
			if (p.containsPoint(x, y)) {
				return true;
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
		int i;
		
		// if there's no selected piece we can't move, so just return false
		if (selected == null) {
			return false;
		}
		
		// check for a win
		if (selected == pieces[0] && selected.x == 1 &&
				selected.y == 3 && direction == 2) {
			hasWon = true;
			return true;
		}
		
		if (direction == 0) {
			// up
			if (selected.y == 0) return false;
			for (i = selected.x; i < selected.x + selected.w; ++i) {
				if (isOccupied(i, selected.y - 1)) {
					// there's a piece blocking this one
					return false;
				}
			}
		} else if (direction == 1) {
			// right
			if (selected.x + selected.w == width) return false;
			for (i = selected.y; i < selected.y + selected.h; ++i) {
				if (isOccupied(selected.x + selected.w, i)) {
					// there's a piece blocking this one
					return false;
				}
			}
		} else if (direction == 2) {
			// down
			if (selected.y + selected.h == height) return false;
			for (i = selected.x; i < selected.x + selected.w; ++i) {
				if (isOccupied(i, selected.y + selected.h)) {
					// there's a piece blocking this one
					return false;
				}
			}
		} else if (direction == 3) {
			// left
			if (selected.x == 0) return false;
			for (i = selected.y; i < selected.y + selected.h; ++i) {
				if (isOccupied(selected.x - 1, i)) {
					// there's a piece blocking this one
					return false;
				}
			}
		} else {
			throw new IllegalArgumentException("direction must be 0..3");
		}
		
		// if we've gotten here it means we're clear to move the selected piece
		selected.move(direction);
		++moves;
		return true;
	}

	/*
	 * Sets all pieces to their original position, sets moves to 0, sets
	 * selectedPiece to null, and sets hasWon to false
	 */
	public void reset() {
		pieces[0] = new Piece(1, 0, 2, 2);
		pieces[1] = new Piece(0, 0, 1, 2);
		pieces[2] = new Piece(3, 0, 1, 2);
		pieces[3] = new Piece(0, 2, 1, 2);
		pieces[4] = new Piece(1, 2, 1, 1);
		pieces[5] = new Piece(2, 2, 1, 1);
		pieces[6] = new Piece(3, 2, 1, 2);
		pieces[7] = new Piece(1, 3, 1, 1);
		pieces[8] = new Piece(2, 3, 1, 1);
		pieces[9] = new Piece(1, 4, 2, 1);
		
		moves = 0;
		selected = null;
		hasWon = false;
	}
}
