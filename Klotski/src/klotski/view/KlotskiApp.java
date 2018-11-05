package klotski.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import klotski.model.Board;
import klotski.controller.MovePieceController;
import klotski.controller.ResetPuzzleController;
import klotski.controller.SelectPieceController;

public class KlotskiApp extends JFrame {
	Board board;	
	PuzzleView puzzleView;
	JLabel movesCounter;
	
	//Necessary to suppress an Eclipse warning
	private static final long serialVersionUID = 5052390254637954176L;
	
	private JPanel contentPane;
		
	/**
	 * sets the move counter to the input int
	 * @param newMoves the new number to display in the move counter
	 */
	public void updateMoves(int newMoves) {
		movesCounter.setText(Integer.toString(newMoves));
	}
	
	/** PuzzleView getter */
	public PuzzleView getPuzzleView() { return puzzleView; }

	/**
	 * Create the frame.
	 */
	public KlotskiApp(Board b) {
		this.board = b;
		setTitle("Klotski");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		puzzleView = new PuzzleView(board);
		puzzleView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SelectPieceController(KlotskiApp.this, board).select(e);
			}
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
		btnReset.setBounds(525, 25, 100, 25);
		contentPane.add(btnReset);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(525, 525, 100, 25);
		contentPane.add(btnQuit);
		
		JButton btnUp = new JButton("↑");
		btnUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new MovePieceController(KlotskiApp.this, board).move(0);
			}
		});
		btnUp.setBounds(525, 150, 50, 25);
		contentPane.add(btnUp);
		
		JButton btnRight = new JButton("→");
		btnRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new MovePieceController(KlotskiApp.this, board).move(1);
			}
		});
		btnRight.setBounds(575, 200, 50, 25);
		contentPane.add(btnRight);
		
		JButton btnLeft = new JButton("←");
		btnLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new MovePieceController(KlotskiApp.this, board).move(3);
			}
		});
		btnLeft.setBounds(475, 200, 50, 25);
		contentPane.add(btnLeft);
		
		JButton btnDown = new JButton("↓");
		btnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new MovePieceController(KlotskiApp.this, board).move(2);
			}
		});
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
