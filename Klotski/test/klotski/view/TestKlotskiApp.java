package klotski.view;

import static org.junit.Assert.*;
import org.junit.Test;
import javax.swing.JLabel;

import klotski.model.Board;

public class TestKlotskiApp {

	@Test
	public void testGetMovesCounter() {
		Board b = new Board();
		KlotskiApp app = new KlotskiApp(b);
		assertEquals(JLabel.class, app.getMovesCounter().getClass());
		assertEquals("0", app.getMovesCounter().getText());
	}

	@Test
	public void testGetPuzzleView() {
		Board b = new Board();
		KlotskiApp app = new KlotskiApp(b);
		assertEquals(PuzzleView.class, app.getPuzzleView().getClass());
	}

	@Test
	public void testKlotskiApp() {
		Board b = new Board();
		KlotskiApp app = new KlotskiApp(b);
		app.setVisible(true);
	}

}
