package bbc.juniperus.games.minesweeper.gui.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import bbc.juniperus.games.minesweeper.core.Coordinate;
import bbc.juniperus.games.minesweeper.core.MineField;

@SuppressWarnings("serial")
public class GameView extends JPanel{

	static final Color DARK_COLOR = new Color(128, 128, 128);
	static final Color MAIN_COLOR = new Color(192, 192, 192);
	static final Color LIGHT_COLOR = Color.white;
	private static final Border OUTSIDE_BORDER_A = BorderFactory.createMatteBorder(3, 3, 0, 0, LIGHT_COLOR);
	private static final Border OUTSIDE_BORDER_B = BorderFactory.createMatteBorder(1, 1, 0, 0, MAIN_COLOR);
	private static final Border OUTSIDE_BORDER = BorderFactory.createCompoundBorder(OUTSIDE_BORDER_A, OUTSIDE_BORDER_B);
	private static final Border INSIDE_BORDER = BorderFactory.createLineBorder(MAIN_COLOR,5);
	private static final Border BORDER = BorderFactory.createCompoundBorder(OUTSIDE_BORDER, INSIDE_BORDER);
	
	UpperPane upperPane;
	MineFieldPane mineFieldPane;
	
	
	public GameView() {
		super(new BorderLayout());
		setBackground(MAIN_COLOR);
		setBorder(BORDER);
		
		mineFieldPane = new MineFieldPane();
		add(mineFieldPane);
		
		upperPane = new UpperPane();

		add(upperPane, BorderLayout.NORTH);
	}
	
	public void initialize(MineField mineField, Controller controller){
		mineFieldPane.fillWithCells(mineField, controller);
	}
	
	public void updateMineField(List<Coordinate> coordinates){
		mineFieldPane.update(coordinates);
	}
	
	public void updateMineField(Coordinate coordinate){
		mineFieldPane.update(coordinate);
	}
	
}