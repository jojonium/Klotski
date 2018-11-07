package klotski.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import klotski.model.Board;
import klotski.view.KlotskiApp;

public class TestMovePieceController {

	@Test
	public void testMovePieceController() {
		Board b = new Board();
		KlotskiApp app = new KlotskiApp(b);
		MovePieceController testCont = new MovePieceController(app, b);
		assertFalse(testCont.move(0));
		b.selectPiece(1, 4);
		assertTrue(testCont.move(3));
	}
}
