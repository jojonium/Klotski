package klotski.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestPiece {

	@Test
	public void testPiece() {
		try {
			new Piece(0, 0, 1, 1);
			new Piece(3, 4, 8, 5);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPieceException() {
		new Piece(1, 1, 0, 0);
		new Piece(-1, -5, 2, 4);
		new Piece(1, -2, 3, 4);
		new Piece(2, 2, 3, 0);
	}

	@Test
	public void testMove() {
		Piece testPieceA = new Piece(1, 1, 2, 2);
		Piece testPieceB = new Piece(2, 2, 1, 1);
		Piece testPieceC = new Piece(1, 1, 2, 1);
		Piece testPieceD = new Piece(1, 1, 1, 3);
		
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
		Piece testPieceB = new Piece(2, 2, 1, 1);
		testPieceB.move(4); // this should fail
	}

	@Test
	public void testContainsPoint() {
		Piece testPiece = new Piece(1, 1, 2, 2);
		assertTrue(testPiece.containsPoint(1, 1));
		assertTrue(testPiece.containsPoint(2, 1));
		assertTrue(testPiece.containsPoint(1, 2));
		assertTrue(testPiece.containsPoint(2, 2));
		assertFalse(testPiece.containsPoint(0, 0));
		assertFalse(testPiece.containsPoint(4, 5));
	}

	@Test
	public void testGetDims() {
		Piece testPiece = new Piece(8, 5, 1, 2);
		int[] dimensions = testPiece.getDims();
		assertEquals(dimensions[0], 8);
		assertEquals(dimensions[1], 5);
		assertEquals(dimensions[2], 1);
		assertEquals(dimensions[3], 2);
	}
	
	@Test
	public void testToString() {
		Piece testPiece = new Piece(8, 5, 1, 2);
		assertEquals("8 5 1 2", testPiece.toString());
	}

}
