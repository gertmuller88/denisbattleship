package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JPanel;
import br.upe.ecomp.view.components.VisualGamePiece;

@SuppressWarnings("serial")
public class GameScreen extends JDialog
{
	private static GameScreen gameScreen;
	private ArrayList<VisualGamePiece> pieces = new ArrayList<VisualGamePiece>();
	
	private GameScreen()
	{
		super(MainScreen.getInstance(null), true);
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		ScenarioScreen.getInstance().lockShips();
		container.add(ScenarioScreen.getInstance().getScenarioPanel());
		
		JPanel scenarioGamePanel = new JPanel();
		scenarioGamePanel.setLayout(null);
		scenarioGamePanel.setBounds(301, 50, 251, 251);
		container.add(scenarioGamePanel);
		
		for(int i=0; i<10; i++)
		{
			for(int j=0; j<10; j++)
			{
				VisualGamePiece visualGamePiece = new VisualGamePiece();
				visualGamePiece.setHorizontal(i);
				visualGamePiece.setVertical(j);
				visualGamePiece.setBounds((j)*25, (i)*25, 26, 26);
				
				pieces.add(visualGamePiece);
				scenarioGamePanel.add(visualGamePiece);
			}
		}
		
		this.pack();
		this.setSize(610, 380);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static GameScreen getInstance()
	{
		if(gameScreen==null)
		{ gameScreen = new GameScreen(); }
		return gameScreen;
	}
}
