package klotski.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Paths;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import klotski.model.Board;
import klotski.controller.AboutController;
import klotski.controller.LicenseController;
import klotski.controller.MovePieceController;
import klotski.controller.OpenController;
import klotski.controller.QuitController;
import klotski.controller.ResetPuzzleController;
import klotski.controller.SaveController;
import klotski.controller.SelectPieceController;
import klotski.controller.SetConfigController;

public class KlotskiApp extends JFrame {
	Board board;	
	PuzzleView puzzleView;
	JLabel movesCounter;
	JButton btnReset;
	Point storedPoint;
	
	//Necessary to suppress an Eclipse warning
	private static final long serialVersionUID = 5052390254637954176L;
	
	private JPanel contentPane;

	/** return actionable elements */
	public JLabel getMovesCounter() { return movesCounter; }
	public PuzzleView getPuzzleView() { return puzzleView; }
	public JButton getResetButton() { return btnReset; }

	/**
	 * Create the frame.
	 */
	public KlotskiApp(Board b) {
		this.board = b;
		setTitle("Klotski");
		setFocusable(true);
		requestFocus();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFileChooser fc = new JFileChooser();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		/********************\
		 *   Klotski Menu   *
		\********************/
		
		JMenu mnKlotski = new JMenu("Klotski");
		menuBar.add(mnKlotski);
		
		JMenuItem mntmSave = new JMenuItem("Save as...");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));
		mnKlotski.add(mntmSave);
		
		mntmSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fc.showSaveDialog(KlotskiApp.this) == 
						JFileChooser.APPROVE_OPTION) {
					String path = fc.getSelectedFile().getAbsolutePath();
					new SaveController(board, Paths.get(path)).save();
				}
			}
		});
		
		JMenuItem mntmOpen = new JMenuItem("Open...");
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, 
				InputEvent.CTRL_MASK));
		mnKlotski.add(mntmOpen);
		
		mntmOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fc.showOpenDialog(KlotskiApp.this) == 
						JFileChooser.APPROVE_OPTION) {
					String path = fc.getSelectedFile().getAbsolutePath();
					new OpenController(KlotskiApp.this, board, Paths.get(path))
					.open();
				}
			}
		});
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 
				InputEvent.CTRL_MASK));
		mnKlotski.add(mntmQuit);
		
		mntmQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (new QuitController().confirm(KlotskiApp.this)) {
					KlotskiApp.this.dispose();
				}
			}
		});

		
		/*****************\
		 *   Puzzle Menu   *
		\*****************/
		
		JMenu mnPuzzle = new JMenu("Puzzle");
		menuBar.add(mnPuzzle);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		mntmReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				InputEvent.CTRL_MASK));
		mnPuzzle.add(mntmReset);
		
		mntmReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetPuzzleController(KlotskiApp.this, board).reset();
			}
		});
		
		JMenuItem mntmConfig1 = new JMenuItem("Configuration 1");
		mntmConfig1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				InputEvent.CTRL_MASK));
		mnPuzzle.add(mntmConfig1);
		
		mntmConfig1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SetConfigController(KlotskiApp.this, board).setConfig(1);
			}
		});
		
		JMenuItem mntmConfig2 = new JMenuItem("Configuration 2");
		mntmConfig2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				InputEvent.CTRL_MASK));
		mnPuzzle.add(mntmConfig2);
		
		mntmConfig2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SetConfigController(KlotskiApp.this, board).setConfig(2);
			}
		});
		
		JMenuItem mntmConfig3 = new JMenuItem("Configuration 3");
		mntmConfig3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,
				InputEvent.CTRL_MASK));
		mnPuzzle.add(mntmConfig3);
		
		mntmConfig3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SetConfigController(KlotskiApp.this, board).setConfig(3);
			}
		});
		
		JMenuItem mntmConfig4 = new JMenuItem("Configuration 4");
		mntmConfig4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,
				InputEvent.CTRL_MASK));
		mnPuzzle.add(mntmConfig4);
		
		mntmConfig4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SetConfigController(KlotskiApp.this, board).setConfig(4);
			}
		});
		
		
		/*****************\
		 *   Help Menu   *
		\*****************/
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnHelp.add(mntmAbout);
		
		mntmAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutController(KlotskiApp.this).about();
			}
		});
		
		JMenuItem mntmLicense = new JMenuItem("License");
		mntmLicense.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnHelp.add(mntmLicense);
		
		mntmLicense.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LicenseController(KlotskiApp.this).show();
			}
		});

		
		
		/********************\
		 *   Close Window   *
		\********************/
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				if (new QuitController().confirm(KlotskiApp.this)) {
					KlotskiApp.this.dispose();
				}
			}
		});
		
		
		
		/*******************\
		 *   Puzzle View   *
		\*******************/
		
		puzzleView = new PuzzleView(board);
		puzzleView.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KlotskiApp.this.requestFocus();
				storedPoint = e.getPoint();
				new SelectPieceController(KlotskiApp.this, board).select(e);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				KlotskiApp.this.requestFocus();
				Point newPoint = e.getPoint();
				int dx = newPoint.x - storedPoint.x;
				int dy = newPoint.y - storedPoint.y;
				if (Math.abs(dx) > 10 || Math.abs(dy) > 10) {
					// mouse dragged
					if (Math.abs(dx) > Math.abs(dy)) {
						// horizontal drag
						if (dx > 0) {
							new MovePieceController(KlotskiApp.this, board)
							.move(1);
						} else {
							new MovePieceController(KlotskiApp.this, board)
							.move(3);
						}
					} else {
						// vertical drag
						if (dy > 0) {
							new MovePieceController(KlotskiApp.this, board)
							.move(2);
						} else {
							new MovePieceController(KlotskiApp.this, board)
							.move(0);
						}
					}
				}
			}
		});
		puzzleView.setBounds(12, 12, puzzleView.getPreferredSize().width,
				puzzleView.getPreferredSize().height);
		contentPane.add(puzzleView);
		
		
		/*************************\
		 *   Keyboard Listener   *
		\*************************/
		
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int kc = e.getKeyCode();
				if (kc == KeyEvent.VK_UP || kc == KeyEvent.VK_W || 
						kc == KeyEvent.VK_K) {
					// up
					new MovePieceController(KlotskiApp.this, board).move(0);
				} else if (kc == KeyEvent.VK_RIGHT || kc == KeyEvent.VK_D ||
						kc == KeyEvent.VK_L) {
					// right
					new MovePieceController(KlotskiApp.this, board).move(1);
				} else if (kc == KeyEvent.VK_DOWN || kc == KeyEvent.VK_S ||
						kc == KeyEvent.VK_J) {
					// down
					new MovePieceController(KlotskiApp.this, board).move(2);
				} else if (kc == KeyEvent.VK_LEFT || kc == KeyEvent.VK_A ||
						kc == KeyEvent.VK_H) {
					// left
					new MovePieceController(KlotskiApp.this, board).move(3);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
			
		});
		
		
		
		/*******************\
		 *   GUI BUttons   *
		\*******************/

		btnReset = new JButton("Reset");
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
				if (new QuitController().confirm(KlotskiApp.this)) {
					KlotskiApp.this.dispose();
				}
			}
		});
		btnQuit.setFocusable(false);
		btnQuit.setBounds(525, 500, 100, 25);
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
		
		
		
		/******************\
		 *   GUI Labels   *
		\******************/

		JLabel lblMoves = new JLabel("Moves:");
		lblMoves.setBounds(475, 112, 66, 15);
		contentPane.add(lblMoves);
		
		movesCounter = new JLabel("0");
		movesCounter.setBounds(550, 112, 66, 15);
		contentPane.add(movesCounter);
	}
}
