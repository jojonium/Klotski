package klotski.view;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
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
				System.currentTimeMillis(), 0, KeyEvent.VK_UP, 'Z');
		KeyEvent keyDown = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, 'Z');
		KeyEvent keyLeft = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, 'Z');
		KeyEvent keyRight = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, 'Z');
		
		KeyEvent keyW = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
		KeyEvent keyA = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A');
		KeyEvent keyS = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');
		KeyEvent keyD = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D');
		
		KeyEvent keyH = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_H, 'H');
		KeyEvent keyJ = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_J, 'J');
		KeyEvent keyK = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_K, 'K');
		KeyEvent keyL = new KeyEvent(app, KeyEvent.KEY_PRESSED,
				System.currentTimeMillis(), 0, KeyEvent.VK_L, 'L');

		b.selectPiece(1, 4);

	    app.getKeyListeners()[0].keyPressed(keyUp);
	    app.getKeyListeners()[0].keyPressed(keyDown);
	    app.getKeyListeners()[0].keyPressed(keyLeft);
	    app.getKeyListeners()[0].keyPressed(keyRight);
	    
	    app.getKeyListeners()[0].keyPressed(keyW);
	    app.getKeyListeners()[0].keyPressed(keyA);
	    app.getKeyListeners()[0].keyPressed(keyS);
	    app.getKeyListeners()[0].keyPressed(keyD);
	    
	    app.getKeyListeners()[0].keyPressed(keyH);
	    app.getKeyListeners()[0].keyPressed(keyJ);
	    app.getKeyListeners()[0].keyPressed(keyK);
	    app.getKeyListeners()[0].keyPressed(keyL);
	}
	
	@Test
	public void testResetButton() {
		Board b = new Board();
		KlotskiApp app = new KlotskiApp(b);
		app.getResetButton().getActionListeners()[0].actionPerformed(new ActionEvent(app, 1, ""));
	}
}
