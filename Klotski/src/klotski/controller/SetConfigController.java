package klotski.controller;

import klotski.model.Board;
import klotski.view.KlotskiApp;

public class SetConfigController {
	KlotskiApp app;
	Board b;
	
	public SetConfigController(KlotskiApp app, Board b) {
		this.app = app;
		this.b = b;
	}
	
	public void setConfig(int number) {
		b.setConfig(number);
		b.reset();
		app.getPuzzleView().refresh();
		app.getMovesCounter().setText(Integer.toString(b.getMoves()));
	}
}
