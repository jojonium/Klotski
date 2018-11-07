package klotski.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import klotski.model.Board;
import klotski.view.KlotskiApp;

public class TestResetPuzzleController {

	@Test
	public void testResetPuzzleController() {
		Board b = new Board();
		KlotskiApp app = new KlotskiApp(b);
		ResetPuzzleController testCont = new ResetPuzzleController(app, b);
		assertFalse(b.isOccupied(0, 4));
		b.selectPiece(1, 4);
		b.movePiece(3);
		assertTrue(b.isOccupied(0, 4));
		testCont.reset();
		assertFalse(b.isOccupied(0, 4));
	}
}
