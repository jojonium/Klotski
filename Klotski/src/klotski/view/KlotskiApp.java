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
import klotski.controller.SelectPieceController;

public class KlotskiApp extends JFrame {
	Board board;
	
	JButton btnUp;
	JButton btnRight;
	JButton btnDown;
	JButton btnLeft;
	
	PuzzleView puzzleView;
	
	//Necessary to suppress an Eclipse warning
	private static final long serialVersionUID = 5052390254637954176L;
	
	private JPanel contentPane;
	
	/** return all actionable elements in the GUI */
	public JButton getBtnUp() { return btnUp; }
	public JButton getBtnRight() { return btnRight; }
	public JButton getBtnDown() { return btnDown; }
	public JButton getBtnLeft() { return btnLeft; }
	
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
		btnReset.setBounds(525, 525, 100, 25);
		contentPane.add(btnReset);
		
		btnUp = new JButton("↑");
		btnUp.setBounds(525, 50, 50, 25);
		contentPane.add(btnUp);
		
		btnRight = new JButton("→");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRight.setBounds(575, 100, 50, 25);
		contentPane.add(btnRight);
		
		btnLeft = new JButton("←");
		btnLeft.setBounds(475, 100, 50, 25);
		contentPane.add(btnLeft);
		
		btnDown = new JButton("↓");
		btnDown.setBounds(525, 150, 50, 25);
		contentPane.add(btnDown);
		
		JLabel lblMoves = new JLabel("Moves:");
		lblMoves.setBounds(284, 12, 66, 15);
		contentPane.add(lblMoves);
		
		JLabel movesCounter = new JLabel("0");
		movesCounter.setBounds(346, 12, 66, 15);
		contentPane.add(movesCounter);
	}
}
