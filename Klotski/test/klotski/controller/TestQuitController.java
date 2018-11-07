package klotski.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import klotski.model.Board;
import klotski.view.KlotskiApp;

public class TestQuitController {

	@Test
	public void testConfirm() {
		Board b = new Board();
		KlotskiApp app = new KlotskiApp(b);
		
		// user has to click "yes" and then "no"
		assertTrue(new QuitController().confirm(app));
		assertFalse(new QuitController().confirm(app));
	}
}
