package klotski.model;

import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.Point;

public class TestPiece {

	@Test
	public void testPiece() {
		Point[] emptyPointArray = new Point[0];
		Point[] onePoint = new Point[] {new Point(0, 0)};
		Point[] manyPoints = new Point[] {new Point(1, 0), new Point(2, 0),
				new Point(1, 1), new Point(2, 1)};
		try {
			new Piece(emptyPointArray);
			new Piece(onePoint);
			new Piece(manyPoints);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMove() {
		Point[] manyPoints = new Point[] {new Point(1, 1), new Point(2, 1),
				new Point(1, 2), new Point(2, 2)};
		Point[] onePoint = new Point[] {new Point(2, 2)};
		Point[] twoPoints = new Point[] {new Point(1, 1), new Point(2, 1)};
		Point[] threePoints = new Point[] {new Point(1, 1), new Point(1, 2),
				new Point(1, 3)};
		Piece testPieceA = new Piece(manyPoints);
		Piece testPieceB = new Piece(onePoint);
		Piece testPieceC = new Piece(twoPoints);
		Piece testPieceD = new Piece(threePoints);
		
		try {
			testPieceA.move(0); // move up
			testPieceB.move(1); // move right
			testPieceC.move(2); // move down
			testPieceD.move(3); // move left
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		int[] dimensions = testPieceA.getDims();
		assertEquals(dimensions[0], 1);
		assertEquals(dimensions[1], 0);
		assertEquals(dimensions[2], 2);
		assertEquals(dimensions[3], 2);
		
		dimensions = testPieceB.getDims();
		assertEquals(dimensions[0], 3);
		assertEquals(dimensions[1], 2);
		assertEquals(dimensions[2], 1);
		assertEquals(dimensions[3], 1);
		
		dimensions = testPieceC.getDims();
		assertEquals(dimensions[0], 1);
		assertEquals(dimensions[1], 2);
		assertEquals(dimensions[2], 2);
		assertEquals(dimensions[3], 1);
		
		dimensions = testPieceD.getDims();
		assertEquals(dimensions[0], 0);
		assertEquals(dimensions[1], 1);
		assertEquals(dimensions[2], 1);
		assertEquals(dimensions[3], 3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMoveException() {
		Point[] onePoint = new Point[] {new Point(2, 2)};
		Piece testPieceB = new Piece(onePoint);
		testPieceB.move(4); // this should fail
	}

	@Test
	public void testContainsPoint() {
		Point[] manyPoints = new Point[] {new Point(1, 1), new Point(2, 1),
				new Point(1, 2), new Point(2, 2)};
		Piece testPiece = new Piece(manyPoints);
		assertTrue(testPiece.containsPoint(1, 1));
		assertTrue(testPiece.containsPoint(2, 1));
		assertTrue(testPiece.containsPoint(1, 2));
		assertTrue(testPiece.containsPoint(2, 2));
		assertFalse(testPiece.containsPoint(0, 0));
		assertFalse(testPiece.containsPoint(4, 5));
	}

	@Test
	public void testGetDims() {
		// points listed from bottom right to top left
		Point[] backwardsPoints = new Point[] {new Point(3, 3), new Point(2, 3),
				new Point(3, 2), new Point(2, 2)};
		Piece testPiece = new Piece(backwardsPoints);
		int[] dimensions = testPiece.getDims();
		assertEquals(dimensions[0], 2);
		assertEquals(dimensions[1], 2);
		assertEquals(dimensions[2], 2);
		assertEquals(dimensions[3], 2);
	}

}
