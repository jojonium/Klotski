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
	 * returns the point in the top-left-most point in this piece
	 * @return the top-left-most Point
	 */
	public Point getTopLeft() {
		int i, outx, outy;
		
		outx = this.points[0].x;
		outy = this.points[0].y;
		
		for (i = 0; i < points.length; ++i) {
			if (points[i].x < outx)
				outx = points[i].x;
			if (points[i].y < outy)
				outy = this.points[i].y;
		}
		
		return new Point(outx, outy);
	}
	
	/**
	 * returns the point in the bottom-right-most point in this piece
	 * @return the bottom-right-most Point
	 */
	public Point getBottomRight() {
		int i, outx, outy;
		
		outx = this.points[0].x;
		outy = this.points[0].y;
		
		for (i = 0; i < points.length; ++i) {
			if (points[i].x > outx)
				outx = points[i].x;
			if (points[i].y > outy)
				outy = this.points[i].y;
		}
		
		return new Point(outx, outy);
	}
}
