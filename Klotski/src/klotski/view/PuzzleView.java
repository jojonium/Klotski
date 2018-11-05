package klotski.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import klotski.model.Board;
import klotski.model.Piece;

public class PuzzleView extends JPanel {
	private static final long serialVersionUID = 3251334679791843551L;

	Board board;
	
	/** Off-screen image for drawing (and Graphics object) */
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;
	
	/** space between pieces and at edges */
	final int spacing = 5;
	
	/** size of a single square on the board */
	final int squareSize = 100;
	
	/** squareSize getter */
	public int getSquareSize() { return squareSize; }
	
	/**
	 * Basic constructor
	 * @param b the model Board
	 */
	public PuzzleView(Board b) {
		this.board = b;
	}
	
	/**
	 * Set the size depending on the height and width of the puzzle
	 */
	@Override
	public Dimension getPreferredSize() {
		int width = squareSize * board.getWidth();
		int height = squareSize * board.getHeight() + 6;
		
		return new Dimension(width, height);
	}
	
	/**
	 * Draws the background and all pieces
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
				
		if (offScreenImage == null) {
			Dimension s = getPreferredSize();
			offScreenImage = this.createImage(s.width, s.height);
			if (offScreenImage == null) { return; }
			
			offScreenGraphics = offScreenImage.getGraphics();
			redraw();
		}
		
		// copy image into place
		g.drawImage(offScreenImage, 0, 0, this);
		
	}
	
	/**
	 * draws background and then all pieces on top of it
	 */
	public void redraw() {
		if (offScreenImage == null) { return; }
		
		Dimension s = getPreferredSize();
		offScreenGraphics.clearRect(0, 0, s.width, s.height);
		
		// draw background
		Dimension s1 = getPreferredSize();
		offScreenGraphics.setColor(Color.decode("#dddddd"));
		offScreenGraphics.fillRect(0, 0, s1.width, s1.height);
		
		// draw all pieces
		Piece[] p = board.getPieces();
		int[] currentDims;
		for (int i = 0; i < p.length; ++i) {
			currentDims = p[i].getDims();
			if (p[i] == board.getSelectedPiece())
				offScreenGraphics.setColor(Color.decode("#008cff")); // blue
			else if (i == 0)
				offScreenGraphics.setColor(Color.decode("#e06d78")); // red
			else
				offScreenGraphics.setColor(Color.decode("#fffee7"));
			offScreenGraphics.fillRect(currentDims[0] * squareSize + spacing,
					currentDims[1] * squareSize + spacing,
					currentDims[2] * squareSize - spacing * 2,
					currentDims[3] * squareSize - spacing * 2);
			
			// black outline
			offScreenGraphics.setColor(Color.decode("#222222"));
			offScreenGraphics.drawRect(currentDims[0] * squareSize + spacing,
					currentDims[1] * squareSize + spacing,
					currentDims[2] * squareSize - spacing * 2,
					currentDims[3] * squareSize - spacing * 2);
		}
		
		// draw red line at bottom to show exit slot
		offScreenGraphics.setColor(Color.decode("#e06d78"));
		offScreenGraphics.fillRect(squareSize, squareSize * board.getHeight(),
				squareSize * 2, 6);
		
		// congratulate the player if he/she has won
		if (board.checkWin()) {
			offScreenGraphics.setColor(Color.black);
			offScreenGraphics.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,45));
			offScreenGraphics.drawString("Congratulations!", 10, 72);
			offScreenGraphics.drawString("You win!", 105, 172);
		}
	}
	
	/**
	 * redraws the whole PuzzleView when pieces are changed
	 */
	public void refresh() {
		if (offScreenImage == null) { return; }
		offScreenGraphics.clearRect(0, 0, offScreenImage.getWidth(this),
				offScreenImage.getHeight(this));
		redraw();
		repaint();
	}
}
