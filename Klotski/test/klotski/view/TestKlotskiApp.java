package klotski.view;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

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
		KeyEvent keyUp = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_UP,'Z');
		KeyEvent keyDown = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_DOWN,'Z');
		KeyEvent keyLeft = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_LEFT,'Z');
		KeyEvent keyRight = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT,'Z');

		b.selectPiece(1, 4);

	    app.getKeyListeners()[0].keyPressed(keyUp);
	    app.getKeyListeners()[0].keyPressed(keyDown);
	    app.getKeyListeners()[0].keyPressed(keyLeft);
	    app.getKeyListeners()[0].keyPressed(keyRight);
	}

}
