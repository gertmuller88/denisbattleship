package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import br.upe.ecomp.model.Piece;
import br.upe.ecomp.model.Scenario;
import br.upe.ecomp.view.components.VisualPlotPiece;

@SuppressWarnings("serial")
public class ScenarioScreen extends JDialog
{
	private static ScenarioScreen scenarioScreen;
	private ArrayList<VisualPlotPiece> pieces = new ArrayList<VisualPlotPiece>();
	private JLabel aircraftCarrier, cruiser, destroyer, submarine, frigate;
	
	private ScenarioScreen(Scenario scenario)
	{
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		JLabel letterA = new JLabel("A");
		letterA.setBounds(85, 55, 15, 15);
		container.add(letterA);
		
		JLabel letterB = new JLabel("B");
		letterB.setBounds(110, 55, 15, 15);
		container.add(letterB);
		
		JLabel letterC = new JLabel("C");
		letterC.setBounds(135, 55, 15, 15);
		container.add(letterC);
		
		JLabel letterD = new JLabel("D");
		letterD.setBounds(160, 55, 15, 15);
		container.add(letterD);
		
		JLabel letterE = new JLabel("E");
		letterE.setBounds(185, 55, 15, 15);
		container.add(letterE);
		
		JLabel letterF = new JLabel("F");
		letterF.setBounds(210, 55, 15, 15);
		container.add(letterF);
		
		JLabel letterG = new JLabel("G");
		letterG.setBounds(235, 55, 15, 15);
		container.add(letterG);
		
		JLabel letterH = new JLabel("H");
		letterH.setBounds(260, 55, 15, 15);
		container.add(letterH);
		
		JLabel letterI = new JLabel("I");
		letterI.setBounds(285, 55, 15, 15);
		container.add(letterI);
		
		JLabel letterJ = new JLabel("J");
		letterJ.setBounds(310, 55, 15, 15);
		container.add(letterJ);
		
		JLabel number1 = new JLabel("1");
		number1.setBounds(60, 81, 15, 15);
		container.add(number1);
		
		JLabel number2 = new JLabel("2");
		number2.setBounds(60, 106, 15, 15);
		container.add(number2);
		
		JLabel number3 = new JLabel("3");
		number3.setBounds(60, 131, 15, 15);
		container.add(number3);
		
		JLabel number4 = new JLabel("4");
		number4.setBounds(60, 156, 15, 15);
		container.add(number4);
		
		JLabel number5 = new JLabel("5");
		number5.setBounds(60, 181, 15, 15);
		container.add(number5);
		
		JLabel number6 = new JLabel("6");
		number6.setBounds(60, 206, 15, 15);
		container.add(number6);
		
		JLabel number7 = new JLabel("7");
		number7.setBounds(60, 231, 15, 15);
		container.add(number7);
		
		JLabel number8 = new JLabel("8");
		number8.setBounds(60, 256, 15, 15);
		container.add(number8);
		
		JLabel number9 = new JLabel("9");
		number9.setBounds(60, 281, 15, 15);
		container.add(number9);
		
		JLabel number10 = new JLabel("10");
		number10.setBounds(56, 306, 15, 15);
		container.add(number10);
		
		JPanel scenarioPanel = new JPanel();
		scenarioPanel.setLayout(null);
		scenarioPanel.setBounds(75, 75, 251, 251);
		container.add(scenarioPanel);
		
		ImageIcon imageCarrier = new ImageIcon("images/ships/carrier.png");
		aircraftCarrier = new JLabel(imageCarrier);
		aircraftCarrier.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				if(aircraftCarrier.getX()+((e.getX()-2)/25)*25>=0 && aircraftCarrier.getX()+((e.getX()-2)/25)*25<126 && aircraftCarrier.getY()+((e.getY()-2)/25)*25>=0 && aircraftCarrier.getY()+((e.getY()-2)/25)*25<226)
				aircraftCarrier.setBounds(aircraftCarrier.getX()+((e.getX()-2)/25)*25, aircraftCarrier.getY()+((e.getY()-2)/25)*25, 126, 26);
			}
		});
		aircraftCarrier.setBounds(0, 0, 126, 26);
		scenarioPanel.add(aircraftCarrier);
		
		ImageIcon imageCruiser = new ImageIcon("images/ships/cruiser.png");
		cruiser = new JLabel(imageCruiser);
		cruiser.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{ cruiser.setBounds(cruiser.getX()+((e.getX()-2)/25)*25, cruiser.getY()+((e.getY()-2)/25)*25, 101, 26); }
		});
		cruiser.setBounds(0, 25, 101, 26);
		scenarioPanel.add(cruiser);
		
		ImageIcon imageDestroyer = new ImageIcon("images/ships/destroyer.png");
		destroyer = new JLabel(imageDestroyer);
		destroyer.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{ destroyer.setBounds(destroyer.getX()+((e.getX()-2)/25)*25, destroyer.getY()+((e.getY()-2)/25)*25, 76, 26); }
		});
		destroyer.setBounds(0, 50, 76, 26);
		scenarioPanel.add(destroyer);
		
		ImageIcon imageSubmarine = new ImageIcon("images/ships/submarine.png");
		submarine = new JLabel(imageSubmarine);
		submarine.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{ submarine.setBounds(submarine.getX()+(e.getX()/25)*25, submarine.getY()+(e.getY()/25)*25, 51, 26); }
		});
		submarine.setBounds(0, 75, 51, 26);
		scenarioPanel.add(submarine);
		
		ImageIcon imageFrigate = new ImageIcon("images/ships/frigate.png");
		frigate = new JLabel(imageFrigate);
		frigate.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{ frigate.setBounds(frigate.getX()+(e.getX()/25)*25, frigate.getY()+(e.getY()/25)*25, 51, 26); }
		});
		frigate.setBounds(0, 100, 51, 26);
		scenarioPanel.add(frigate);
		
		for(int i=0; i<100; i++)
		{
			Piece piece = (Piece) scenario.getPieces().get(i);
			
			VisualPlotPiece visualPlotPiece = new VisualPlotPiece();
			visualPlotPiece.setPiece(piece);
			visualPlotPiece.setBounds((piece.getHorizontal()-1)*25, (piece.getVertical()-1)*25, 26, 26);
			
			pieces.add(visualPlotPiece);
			scenarioPanel.add(visualPlotPiece);
		}
		
		this.pack();
		this.setSize(640, 480);
		this.setResizable(false);
		this.setLayout(null);
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static ScenarioScreen getInstance(Scenario scenario)
	{
		if(scenarioScreen==null)
		{ scenarioScreen = new ScenarioScreen(scenario); }
		return scenarioScreen;
	}
}
