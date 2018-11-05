package klotski.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import klotski.model.Board;
import klotski.controller.MovePieceController;
import klotski.controller.QuitController;
import klotski.controller.ResetPuzzleController;
import klotski.controller.SelectPieceController;

public class KlotskiApp extends JFrame {
	Board board;	
	PuzzleView puzzleView;
	JLabel movesCounter;
	
	//Necessary to suppress an Eclipse warning
	private static final long serialVersionUID = 5052390254637954176L;
	
	private JPanel contentPane;

	/** return actionable elements */
	public JLabel getMovesCounter() { return movesCounter; }
	public PuzzleView getPuzzleView() { return puzzleView; }

	/**
	 * Create the frame.
	 */
	public KlotskiApp(Board b) {
		this.board = b;
		setTitle("Klotski");
		setFocusable(true);
		requestFocus();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		puzzleView = new PuzzleView(board);
		puzzleView.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KlotskiApp.this.requestFocus();
				new SelectPieceController(KlotskiApp.this, board).select(e);
			}
		});
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int kc = e.getKeyCode();
				if (kc == KeyEvent.VK_UP || kc == KeyEvent.VK_W || 
						kc == KeyEvent.VK_K) {
					// up
					new MovePieceController(KlotskiApp.this, b).move(0);
				} else if (kc == KeyEvent.VK_RIGHT || kc == KeyEvent.VK_D ||
						kc == KeyEvent.VK_L) {
					// right
					new MovePieceController(KlotskiApp.this, b).move(1);
				} else if (kc == KeyEvent.VK_DOWN || kc == KeyEvent.VK_S ||
						kc == KeyEvent.VK_J) {
					// down
					new MovePieceController(KlotskiApp.this, b).move(2);
				} else if (kc == KeyEvent.VK_LEFT || kc == KeyEvent.VK_A ||
						kc == KeyEvent.VK_H) {
					// left
					new MovePieceController(KlotskiApp.this, b).move(3);
				} else if (kc == KeyEvent.VK_R) {
					// reset
					new ResetPuzzleController(KlotskiApp.this, b).reset();
				} else if (kc == KeyEvent.VK_Q) {
					// quit
					new QuitController(KlotskiApp.this).quit();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
			
		});
		puzzleView.setBounds(12, 12, puzzleView.getPreferredSize().width,
				puzzleView.getPreferredSize().height);
		contentPane.add(puzzleView);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ResetPuzzleController(KlotskiApp.this, board).reset();
			}
		});
		btnReset.setFocusable(false);
		btnReset.setBounds(525, 25, 100, 25);
		contentPane.add(btnReset);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new QuitController(KlotskiApp.this).quit();
			}
		});
		btnQuit.setFocusable(false);
		btnQuit.setBounds(525, 525, 100, 25);
		contentPane.add(btnQuit);
		
		JButton btnUp = new JButton("↑");
		btnUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new MovePieceController(KlotskiApp.this, board).move(0);
			}
		});
		btnUp.setFocusable(false);
		btnUp.setBounds(525, 150, 50, 25);
		contentPane.add(btnUp);
		
		JButton btnRight = new JButton("→");
		btnRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new MovePieceController(KlotskiApp.this, board).move(1);
			}
		});
		btnRight.setFocusable(false);
		btnRight.setBounds(575, 200, 50, 25);
		contentPane.add(btnRight);
		
		JButton btnLeft = new JButton("←");
		btnLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new MovePieceController(KlotskiApp.this, board).move(3);
			}
		});
		btnLeft.setFocusable(false);
		btnLeft.setBounds(475, 200, 50, 25);
		contentPane.add(btnLeft);
		
		JButton btnDown = new JButton("↓");
		btnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new MovePieceController(KlotskiApp.this, board).move(2);
			}
		});
		btnDown.setFocusable(false);
		btnDown.setBounds(525, 250, 50, 25);
		contentPane.add(btnDown);
		
		JLabel lblMoves = new JLabel("Moves:");
		lblMoves.setBounds(475, 112, 66, 15);
		contentPane.add(lblMoves);
		
		movesCounter = new JLabel("0");
		movesCounter.setBounds(550, 112, 66, 15);
		contentPane.add(movesCounter);
	}
}
