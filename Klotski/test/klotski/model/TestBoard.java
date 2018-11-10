package klotski.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestBoard {

	@Test
	public void testBoard() {
		Board testBoard = new Board();
		assertEquals(0, testBoard.getMoves());
		assertNull(testBoard.getSelectedPiece());
		assertFalse(testBoard.checkWin());
		assertEquals(4, testBoard.getWidth());
		assertEquals(5, testBoard.getHeight());
		assertEquals(10, testBoard.getPieces().length);
		
		Piece winningPiece = new Piece(1, 3, 2, 2);
		Board winBoard = new Board(new Piece[] {winningPiece});
		assertEquals(0, winBoard.getMoves());
		assertNull(winBoard.getSelectedPiece());
		assertFalse(winBoard.checkWin());
		assertEquals(4, winBoard.getWidth());
		assertEquals(5, winBoard.getHeight());
		assertEquals(1, winBoard.getPieces().length);
	}

	@Test
	public void testCheckWin() {
		Board testBoard = new Board();
		assertFalse(testBoard.checkWin());
		
		Piece winningPiece = new Piece(1, 3, 2, 2);
		Board winBoard = new Board(new Piece[] {winningPiece});
		winBoard.selectPiece(2, 3);
		winBoard.movePiece(0);
		assertFalse(winBoard.checkWin());
		winBoard.movePiece(2);
		winBoard.movePiece(2);
		assertTrue(winBoard.checkWin());
	}

	@Test
	public void testGetMoves() {
		Piece winningPiece = new Piece(1, 3, 2, 2);
		Board winBoard = new Board(new Piece[] {winningPiece});
		winBoard.selectPiece(2, 3);
		assertEquals(0, winBoard.getMoves());
		winBoard.movePiece(0);
		assertEquals(1, winBoard.getMoves());
		winBoard.movePiece(3);
		assertEquals(2, winBoard.getMoves());
		winBoard.movePiece(3); // up against left wall, shouldn't move
		assertEquals(2, winBoard.getMoves());
	}

	@Test
	public void testGetSelectedPiece() {
		Board testBoard = new Board();
		testBoard.selectPiece(0, 0);
		assertEquals(testBoard.getSelectedPiece(), testBoard.getPieces()[1]);
		testBoard.selectPiece(0, 4); // deselect
		assertNull(testBoard.getSelectedPiece());
	}

	@Test
	public void testGetWidth() {
		Board testBoard = new Board();
		assertEquals(4, testBoard.getWidth());
		Piece winningPiece = new Piece(1, 3, 2, 2);
		Board winBoard = new Board(new Piece[] {winningPiece});
		assertEquals(4, winBoard.getWidth());
	}

	@Test
	public void testGetHeight() {
		Board testBoard = new Board();
		assertEquals(5, testBoard.getHeight());
		Piece winningPiece = new Piece(1, 3, 2, 2);
		Board winBoard = new Board(new Piece[] {winningPiece});
		assertEquals(5, winBoard.getHeight());
	}

	@Test
	public void testGetPieces() {
		Board testBoard = new Board();
		assertEquals(10, testBoard.getPieces().length);
	}

	@Test
	public void testSelectPiece() {
		Board testBoard = new Board();
		testBoard.selectPiece(0, 0);
		assertEquals(testBoard.getPieces()[1], testBoard.getSelectedPiece());
		testBoard.selectPiece(0, 4); // deselect
		assertNull(testBoard.getSelectedPiece());
	}

	@Test
	public void testIsOccupied() {
		Board testBoard = new Board();
		assertTrue(testBoard.isOccupied(0, 0));
		assertFalse(testBoard.isOccupied(0, 4));
	}

	@Test
	public void testMovePiece() {
		Piece singlePiece = new Piece(1, 2, 2, 2);
		Board testBoard = new Board(new Piece[] {singlePiece});
		assertFalse(testBoard.movePiece(1)); // no piece selected
		testBoard.selectPiece(2, 2);
		assertTrue(testBoard.movePiece(0));
		assertTrue(testBoard.movePiece(1));
		assertFalse(testBoard.movePiece(1)); // up against right wall
		assertTrue(testBoard.movePiece(2));
		assertTrue(testBoard.movePiece(3));
		assertTrue(testBoard.movePiece(2));
		assertTrue(testBoard.movePiece(2));
		assertTrue(testBoard.checkWin());
		
		testBoard = new Board();
		testBoard.selectPiece(1, 2);
		assertFalse(testBoard.movePiece(0));
		assertFalse(testBoard.movePiece(1));
		assertFalse(testBoard.movePiece(2));
		assertFalse(testBoard.movePiece(3));
		
		testBoard.selectPiece(0, 0);
		assertFalse(testBoard.movePiece(0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMovePieceException() {
		Piece singlePiece = new Piece(1, 2, 2, 2);
		Board testBoard = new Board(new Piece[] {singlePiece});
		testBoard.selectPiece(2, 2);
		testBoard.movePiece(4); // this should fail
	}

	@Test
	public void testReset() {
		Board testBoard = new Board();
		assertFalse(testBoard.isOccupied(0, 4));
		testBoard.selectPiece(1, 4);
		testBoard.movePiece(3);
		assertTrue(testBoard.isOccupied(0, 4));
		assertEquals(1, testBoard.getMoves());
		testBoard.reset();
		assertFalse(testBoard.isOccupied(0, 4));
		assertEquals(0, testBoard.getMoves());
		
		testBoard.setConfig(2);
		testBoard.reset();
		assertFalse(testBoard.isOccupied(2, 2));
		assertFalse(testBoard.isOccupied(2, 3));
		
		testBoard.setConfig(3);
		testBoard.reset();
		assertFalse(testBoard.isOccupied(0, 5));
		assertFalse(testBoard.isOccupied(1, 5));
		
		testBoard.setConfig(4);
		testBoard.reset();
		assertFalse(testBoard.isOccupied(1, 4));
		assertFalse(testBoard.isOccupied(2, 4));
	}
	
	@Test
	public void testSetPieces() {
		List<String> pieceLines = new ArrayList<String>();
		pieceLines.add("3");
		pieceLines.add(new Piece(1, 1, 1, 1).toString());
		pieceLines.add(new Piece(2, 2, 1, 1).toString());
		Board b = new Board();
		b.setPieces(pieceLines);
		assertEquals(2, b.getPieces().length);
		assertEquals(3, b.getMoves());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetPiecesExceptionTooLong() {
		List<String> tooLong = new ArrayList<String>();
		for (int i = 0; i < 100; ++i) {
			tooLong.add(new Piece(1, 1, 1, 1).toString());
		}
		Board b = new Board();
		b.setPieces(tooLong);
		
		List<String> tooShort = new ArrayList<String>();
		b.setPieces(tooShort);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetPiecesExceptionTooShort() {
		Board b = new Board();
		List<String> tooShort = new ArrayList<String>();
		b.setPieces(tooShort);
	}
	
	@Test
	public void toStringTest() {
		Board b = new Board();
		String testString = "0\n" +
				"1 0 2 2\n" + 
				"0 0 1 2\n" + 
				"3 0 1 2\n" + 
				"0 2 1 2\n" + 
				"1 2 1 1\n" + 
				"2 2 1 1\n" + 
				"3 2 1 2\n" + 
				"1 3 1 1\n" + 
				"2 3 1 1\n" + 
				"1 4 2 1\n";
		assertEquals(testString, b.toString());
	}

}
