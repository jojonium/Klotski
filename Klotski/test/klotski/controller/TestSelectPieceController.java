package klotski.controller;

import static org.junit.Assert.*;

import java.awt.event.MouseEvent;

import org.junit.Test;

import klotski.model.Board;
import klotski.view.KlotskiApp;

public class TestSelectPieceController {

	@Test
	public void testSelectPieceController() {
		Board b = new Board();
		KlotskiApp app = new KlotskiApp(b);
		SelectPieceController testCont = new SelectPieceController(app, b);
		MouseEvent me1 = new MouseEvent(app, 0, 10, 0, 50, 50, 1234, 1234, 1, false, MouseEvent.BUTTON1);
		MouseEvent me2 = new MouseEvent(app, 0, 10, 0, 50, 50, 1234, 1234, 1, false, MouseEvent.BUTTON2);
		testCont.select(me2);
		assertNull(b.getSelectedPiece());
		testCont.select(me1);
		assertTrue(b.getSelectedPiece() != null);
	}
}
