package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JPanel;
import br.upe.ecomp.model.Scenario;
import br.upe.ecomp.view.components.VisualGamePiece;
import br.upe.ecomp.view.components.VisualScenarioPanel;

@SuppressWarnings("serial")
public class GameScreen extends JDialog
{
	private static GameScreen gameScreen;
	private ArrayList<VisualGamePiece> pieces = new ArrayList<VisualGamePiece>();
	
	public GameScreen(Scenario opponentScenario, MouseAdapter listener)
	{
		super(MainScreen.getInstance(null), true);
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		ScenarioScreen.getInstance().lockShips();
		container.add(VisualScenarioPanel.getInstance());
		
		JPanel scenarioGamePanel = new JPanel();
		scenarioGamePanel.setLayout(null);
		scenarioGamePanel.setBounds(351, 50, 251, 251);
		container.add(scenarioGamePanel);
		
		for(int i=0; i<opponentScenario.getPieces().size(); i++)
		{
			VisualGamePiece visualGamePiece = new VisualGamePiece(listener);
			visualGamePiece.setHorizontal(opponentScenario.getPieces().get(i).getHorizontal());
			visualGamePiece.setVertical(opponentScenario.getPieces().get(i).getVertical());
			visualGamePiece.setBounds((opponentScenario.getPieces().get(i).getHorizontal())*25, (opponentScenario.getPieces().get(i).getVertical())*25, 26, 26);
			
			opponentScenario.getPieces().get(i).addObserver(visualGamePiece);
			pieces.add(visualGamePiece);
			scenarioGamePanel.add(visualGamePiece);
		}
		
		this.pack();
		this.setSize(720, 380);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static GameScreen getInstance(Scenario opponentScenario, MouseAdapter listener)
	{
		if(gameScreen==null)
		{ gameScreen = new GameScreen(opponentScenario, listener); }
		return gameScreen;
	}
	
	public void reset()
	{
		if(this.getContentPane().getComponentAt(55, 50)!=null)
		{ this.getContentPane().remove(this.getContentPane().getComponentAt(55, 50)); }
		
		ScenarioScreen.getInstance().lockShips();
		this.getContentPane().add(VisualScenarioPanel.getInstance());
	}
}
