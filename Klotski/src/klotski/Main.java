package klotski;

import java.awt.Point;

import klotski.model.Board;
import klotski.model.Piece;
import klotski.view.KlotskiApp;

public class Main {
	public static void main(String[] args) {
		// make the pieces for configuration 1
		Piece[] config1 = new Piece[10];
		config1[0] = new Piece(new Point[] {new Point(1, 0), new Point(2, 0),
				new Point(1, 1), new Point(2, 1)});
		config1[1] = new Piece(new Point[] {new Point(0, 0), new Point(0, 1)});
		config1[2] = new Piece(new Point[] {new Point(3, 0), new Point(3, 1)});
		config1[3] = new Piece(new Point[] {new Point(0, 2), new Point(0, 3)});
		config1[4] = new Piece(new Point[] {new Point(1, 2)});
		config1[5] = new Piece(new Point[] {new Point(2, 2)});
		config1[6] = new Piece(new Point[] {new Point(3, 2), new Point(3, 3)});
		config1[7] = new Piece(new Point[] {new Point(1, 3)});
		config1[8] = new Piece(new Point[] {new Point(2, 3)});
		config1[9] = new Piece(new Point[] {new Point(1, 4), new Point(2, 4)});

		Board b = new Board(config1);
		
		KlotskiApp app = new KlotskiApp();
		
		app.setVisible(true);
	}

}
