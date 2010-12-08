package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import br.upe.ecomp.model.Scenario;
import br.upe.ecomp.view.components.VisualGamePiece;
import br.upe.ecomp.view.components.VisualGamePanel;

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
		container.add(VisualGamePanel.getInstance());
		
		JLabel letterA = new JLabel("A");
		letterA.setBounds(65, 30, 15, 15);
		container.add(letterA);
		
		JLabel letterB = new JLabel("B");
		letterB.setBounds(90, 30, 15, 15);
		container.add(letterB);
		
		JLabel letterC = new JLabel("C");
		letterC.setBounds(115, 30, 15, 15);
		container.add(letterC);
		
		JLabel letterD = new JLabel("D");
		letterD.setBounds(140, 30, 15, 15);
		container.add(letterD);
		
		JLabel letterE = new JLabel("E");
		letterE.setBounds(165, 30, 15, 15);
		container.add(letterE);
		
		JLabel letterF = new JLabel("F");
		letterF.setBounds(190, 30, 15, 15);
		container.add(letterF);
		
		JLabel letterG = new JLabel("G");
		letterG.setBounds(215, 30, 15, 15);
		container.add(letterG);
		
		JLabel letterH = new JLabel("H");
		letterH.setBounds(240, 30, 15, 15);
		container.add(letterH);
		
		JLabel letterI = new JLabel("I");
		letterI.setBounds(265, 30, 15, 15);
		container.add(letterI);
		
		JLabel letterJ = new JLabel("J");
		letterJ.setBounds(290, 30, 15, 15);
		container.add(letterJ);
		
		JLabel number1 = new JLabel("1");
		number1.setBounds(40, 56, 15, 15);
		container.add(number1);
		
		JLabel number2 = new JLabel("2");
		number2.setBounds(40, 81, 15, 15);
		container.add(number2);
		
		JLabel number3 = new JLabel("3");
		number3.setBounds(40, 106, 15, 15);
		container.add(number3);
		
		JLabel number4 = new JLabel("4");
		number4.setBounds(40, 131, 15, 15);
		container.add(number4);
		
		JLabel number5 = new JLabel("5");
		number5.setBounds(40, 156, 15, 15);
		container.add(number5);
		
		JLabel number6 = new JLabel("6");
		number6.setBounds(40, 181, 15, 15);
		container.add(number6);
		
		JLabel number7 = new JLabel("7");
		number7.setBounds(40, 206, 15, 15);
		container.add(number7);
		
		JLabel number8 = new JLabel("8");
		number8.setBounds(40, 231, 15, 15);
		container.add(number8);
		
		JLabel number9 = new JLabel("9");
		number9.setBounds(40, 256, 15, 15);
		container.add(number9);
		
		JLabel number10 = new JLabel("10");
		number10.setBounds(36, 281, 15, 15);
		container.add(number10);
		
		JPanel scenarioGamePanel = new JPanel();
		scenarioGamePanel.setLayout(null);
		scenarioGamePanel.setBounds(371, 50, 251, 251);
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
		
		JLabel lettera = new JLabel("A");
		lettera.setBounds(381, 30, 15, 15);
		container.add(lettera);
		
		JLabel letterb = new JLabel("B");
		letterb.setBounds(406, 30, 15, 15);
		container.add(letterb);
		
		JLabel letterc = new JLabel("C");
		letterc.setBounds(431, 30, 15, 15);
		container.add(letterc);
		
		JLabel letterd = new JLabel("D");
		letterd.setBounds(456, 30, 15, 15);
		container.add(letterd);
		
		JLabel lettere = new JLabel("E");
		lettere.setBounds(481, 30, 15, 15);
		container.add(lettere);
		
		JLabel letterf = new JLabel("F");
		letterf.setBounds(506, 30, 15, 15);
		container.add(letterf);
		
		JLabel letterg = new JLabel("G");
		letterg.setBounds(531, 30, 15, 15);
		container.add(letterg);
		
		JLabel letterh = new JLabel("H");
		letterh.setBounds(556, 30, 15, 15);
		container.add(letterh);
		
		JLabel letteri = new JLabel("I");
		letteri.setBounds(581, 30, 15, 15);
		container.add(letteri);
		
		JLabel letterj = new JLabel("J");
		letterj.setBounds(606, 30, 15, 15);
		container.add(letterj);
		
		JLabel number01 = new JLabel("1");
		number01.setBounds(356, 56, 15, 15);
		container.add(number01);
		
		JLabel number02 = new JLabel("2");
		number02.setBounds(356, 81, 15, 15);
		container.add(number02);
		
		JLabel number03 = new JLabel("3");
		number03.setBounds(356, 106, 15, 15);
		container.add(number03);
		
		JLabel number04 = new JLabel("4");
		number04.setBounds(356, 131, 15, 15);
		container.add(number04);
		
		JLabel number05 = new JLabel("5");
		number05.setBounds(356, 156, 15, 15);
		container.add(number05);
		
		JLabel number06 = new JLabel("6");
		number06.setBounds(356, 181, 15, 15);
		container.add(number06);
		
		JLabel number07 = new JLabel("7");
		number07.setBounds(356, 206, 15, 15);
		container.add(number07);
		
		JLabel number08 = new JLabel("8");
		number08.setBounds(356, 231, 15, 15);
		container.add(number08);
		
		JLabel number09 = new JLabel("9");
		number09.setBounds(356, 256, 15, 15);
		container.add(number09);
		
		JLabel number010 = new JLabel("10");
		number010.setBounds(352, 281, 15, 15);
		container.add(number010);
		
		this.pack();
		this.setSize(680, 380);
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
		this.getContentPane().add(VisualGamePanel.getInstance());
	}
}
