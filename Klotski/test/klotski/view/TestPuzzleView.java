package klotski.view;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.Test;

import klotski.model.Board;

public class TestPuzzleView {

	@Test
	public void testGetSquareSize() {
		Board b = new Board();
		PuzzleView pv = new PuzzleView(b);
		assertEquals(100, pv.getSquareSize());
	}

	@Test
	public void testGetPreferredSize() {
		Board b = new Board();
		PuzzleView pv = new PuzzleView(b);
		Dimension dim = pv.getPreferredSize();
		assertEquals(400, dim.width);
		assertEquals(506, dim.height);
	}
}
