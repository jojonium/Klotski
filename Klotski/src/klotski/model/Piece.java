package klotski.model;

import java.awt.Point;

/**
 * a class that represents a single klotski piece
 * @author Joseph Petitti
 *
 */
public class Piece {
	// an array of points representing the center of each square of the piece
	Point[] points;
	
	/**
	 * Basic constructor
	 * @param points an array of points representing the center of each square
	 * of the piece
	 */
	public Piece(Point[] points) {
		this.points = points;
	}

	/**
	 * moves a piece in the given direction on the board. Assumes the move is
	 * valid.
	 * @param direction 0=up, 1=right, 2=down, 3=left
	 */
	public void move(int direction) {
		int i;
		
		if (direction == 0) { // up
			for (i = 0; i < points.length; ++i)
				points[i].y--;
		} else if (direction == 1) { // right
			for (i = 0; i < points.length; ++i)
				points[i].x++;
		} else if (direction == 2) { // down
			for (i = 0; i < points.length; ++i)
				points[i].y++;
		} else if (direction == 3) { // left
			for (i = 0; i < points.length; ++i)
				points[i].x--;
		}
	}
	
	/**
	 * Checks whether this piece contains the given point
	 * @param x the x coordinate of the point being tested
	 * @param y the y coordinate of the point being tested
	 * @return true if this piece contains the given point, false otherwise
	 */
	public boolean containsPoint(int x, int y) {
		int i;
		
		for (i = 0; i < points.length; ++i) {
			if (points[i].x == x && points[i].y == y)
				return true;
		}
		
		return false;
	}
	
	/**
	 * Finds the x and y coordinates of the top left point in the piece, as
	 * well as the piece's width and height
	 * @return an int array with the left, top, width, and height values
	 */
	public int[] getDims() {
		int i, top, left, bottom, right, height, width;
		
		left = this.points[0].x;
		top = this.points[0].y;
		bottom = top;
		right = left;
		
		
		for (i = 0; i < points.length; ++i) {
			if (points[i].x < left)
				left = points[i].x;
			if (points[i].x > right)
				right = points[i].x;
			if (points[i].y < top)
				top = points[i].y;
			if (points[i].y > bottom)
				bottom = points[i].y;
		}
		
		height = bottom - top + 1;
		width = right - left + 1;
		
		return new int[] {left, top, width, height};
	}
}
