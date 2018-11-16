package klotski.controller;

import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import klotski.model.Board;
import klotski.view.KlotskiApp;

public class SolvePuzzleController {
	KlotskiApp app;
	Board b;
	Random rng;	
	
	/**
	 * Basic constructor
	 * @param app the view application
	 * @param b the model board
	 */
	public SolvePuzzleController(KlotskiApp app, Board b) {
		this.app = app;
		this.b = b;
		this.rng = new Random();
	}
	
	/**
	 * Makes random moves until it wins
	 */
	public void solve() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				int c = 0;
				int d = rng.nextInt(4);
				b.setSelected(rng.nextInt(10));
				while(!(b.movePiece(d)) && c++ < 5 && (d = ++d % 4) < 4);
				app.getMovesCounter().setText(Integer.toString(b.getMoves()));
				app.getPuzzleView().refresh();
				
				if (b.checkWin()) {
					this.cancel();
				}
			}
		}, 1, 1);
	}
}
