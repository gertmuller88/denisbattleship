package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import br.upe.ecomp.enumeration.ShipType;
import br.upe.ecomp.model.Scenario;
import br.upe.ecomp.view.components.VisualPlotPiece;
import br.upe.ecomp.view.components.VisualGamePanel;

@SuppressWarnings("serial")
public class ScenarioScreen extends JDialog
{
	private static ScenarioScreen scenarioScreen;
	private ArrayList<VisualPlotPiece> pieces = new ArrayList<VisualPlotPiece>();
	private JLabel aircraftCarrier, cruiser, destroyer, submarine, frigate;
	private boolean toPlot = false;
	
	private ScenarioScreen()
	{
		super(MainScreen.getInstance(null), true);
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
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
		
		JLabel instructions1 = new JLabel("Instruções:");
		instructions1.setFont(new Font(instructions1.getFont().getFontName(), Font.ITALIC, instructions1.getFont().getSize()));
		instructions1.setBounds(355, 30, 100, 15);
		container.add(instructions1);
		
		JLabel instructions2 = new JLabel("Clique e arraste as embarcações para");
		instructions2.setBounds(355, 55, 200, 15);
		container.add(instructions2);
		
		JLabel instructions3 = new JLabel("posicioná-las.");
		instructions3.setBounds(355, 70, 200, 15);
		container.add(instructions3);
		
		JLabel instructions4 = new JLabel("Dê um duplo clique para mudar a posição");
		instructions4.setBounds(355, 95, 200, 15);
		container.add(instructions4);
		
		JLabel instructions5 = new JLabel("horizontal/vertical da embarcação.");
		instructions5.setBounds(355, 110, 200, 15);
		container.add(instructions5);
		
		JLabel separator = new JLabel("___________________________________");
		separator.setBounds(350, 123, 210, 15);
		separator.setEnabled(false);
		container.add(separator);
		
		JLabel instructions6 = new JLabel("Embarcações:");
		instructions6.setFont(new Font(instructions6.getFont().getFontName(), Font.ITALIC, instructions6.getFont().getSize()));
		instructions6.setBounds(355, 145, 200, 15);
		container.add(instructions6);
		
		JLabel instructions7 = new JLabel("- Porta-Aviões (5 peças)");
		instructions7.setBounds(355, 165, 200, 15);
		container.add(instructions7);
		
		JLabel instructions8 = new JLabel("- Cruzador (4 peças)");
		instructions8.setBounds(355, 180, 200, 15);
		container.add(instructions8);
		
		JLabel instructions9 = new JLabel("- Contratorpedeiro (3 peças)");
		instructions9.setBounds(355, 195, 200, 15);
		container.add(instructions9);
		
		JLabel instructions10 = new JLabel("- Submarino (2 peças)");
		instructions10.setBounds(355, 210, 200, 15);
		container.add(instructions10);
		
		JLabel instructions11 = new JLabel("- Fragata (2 peças)");
		instructions11.setBounds(355, 225, 200, 15);
		container.add(instructions11);
		
		JButton plot = new JButton("Posicionar Embarcações");
		plot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(shipsIntersect())
				{ JOptionPane.showMessageDialog(null, "Existem embarcações sobrepostas. Organize-as novamente.", "", JOptionPane.WARNING_MESSAGE); }
				else
				{
					toPlot = true;
					dispose();
				}
			}
		});
		plot.setBounds(355, 255, 200, 45);
		container.add(plot);
		
		this.pack();
		this.setSize(610, 380);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static ScenarioScreen getInstance()
	{
		if(scenarioScreen==null)
		{ scenarioScreen = new ScenarioScreen(); }
		return scenarioScreen;
	}
	
	public boolean isToPlot()
	{ return this.toPlot; }
	
	private boolean shipsIntersect()
	{
		Rectangle aircraftCarrier = this.aircraftCarrier.getBounds();
		Rectangle cruiser = this.cruiser.getBounds();
		Rectangle destroyer = this.destroyer.getBounds();
		Rectangle submarine = this.submarine.getBounds();
		Rectangle frigate = this.frigate.getBounds();
		
		if(aircraftCarrier.intersects(cruiser))
		{ return true; }
		if(aircraftCarrier.intersects(destroyer))
		{ return true; }
		if(aircraftCarrier.intersects(submarine))
		{ return true; }
		if(aircraftCarrier.intersects(frigate))
		{ return true; }
		
		if(cruiser.intersects(destroyer))
		{ return true; }
		if(cruiser.intersects(submarine))
		{ return true; }
		if(cruiser.intersects(frigate))
		{ return true; }
		
		if(destroyer.intersects(submarine))
		{ return true; }
		if(destroyer.intersects(frigate))
		{ return true; }
		
		if(submarine.intersects(frigate))
		{ return true; }
		
		return false;
	}
	
	public ArrayList<VisualPlotPiece> getShipCoordinates(ShipType type)
	{
		ArrayList<VisualPlotPiece> temp = new ArrayList<VisualPlotPiece>();
		
		switch(type)
		{
			case AircraftCarrier:
			{
				for(int i=0; i<pieces.size(); i++)
				{
					if(this.aircraftCarrier.getBounds().intersects(pieces.get(i).getBounds()))
					{ temp.add(pieces.get(i)); }
				}
				
				return temp;
			}
			case Cruiser:
			{
				for(int i=0; i<pieces.size(); i++)
				{
					if(this.cruiser.getBounds().intersects(pieces.get(i).getBounds()))
					{ temp.add(pieces.get(i)); }
				}
				
				return temp;
			}
			case Destroyer:
			{
				for(int i=0; i<pieces.size(); i++)
				{
					if(this.destroyer.getBounds().intersects(pieces.get(i).getBounds()))
					{ temp.add(pieces.get(i)); }
				}
				
				return temp;
			}
			case Submarine:
			{
				for(int i=0; i<pieces.size(); i++)
				{
					if(this.submarine.getBounds().intersects(pieces.get(i).getBounds()))
					{ temp.add(pieces.get(i)); }
				}
				
				return temp;
			}
			case Frigate:
			{
				for(int i=0; i<pieces.size(); i++)
				{
					if(this.frigate.getBounds().intersects(pieces.get(i).getBounds()))
					{ temp.add(pieces.get(i)); }
				}
				
				return temp;
			}
		}
		throw new IllegalArgumentException("O tipo de navio " + type + " não existe.");
	}
	
	public void lockShips()
	{
		MouseMotionListener[] motion1 = this.aircraftCarrier.getMouseMotionListeners();
		MouseListener[] listener1 = this.aircraftCarrier.getMouseListeners();
		
		for(int i=0; i<motion1.length; i++)
		{ this.aircraftCarrier.removeMouseMotionListener(motion1[i]); }
		
		for(int i=0; i<listener1.length; i++)
		{ this.aircraftCarrier.removeMouseListener(listener1[i]); }
		
		MouseMotionListener[] motion2 = this.cruiser.getMouseMotionListeners();
		MouseListener[] listener2 = this.cruiser.getMouseListeners();
		
		for(int i=0; i<motion2.length; i++)
		{ this.cruiser.removeMouseMotionListener(motion2[i]); }
		
		for(int i=0; i<listener2.length; i++)
		{ this.cruiser.removeMouseListener(listener2[i]); }
		
		MouseMotionListener[] motion3 = this.destroyer.getMouseMotionListeners();
		MouseListener[] listener3 = this.destroyer.getMouseListeners();
		
		for(int i=0; i<motion3.length; i++)
		{ this.destroyer.removeMouseMotionListener(motion3[i]); }
		
		for(int i=0; i<listener3.length; i++)
		{ this.destroyer.removeMouseListener(listener3[i]); }
		
		MouseMotionListener[] motion4 = this.submarine.getMouseMotionListeners();
		MouseListener[] listener4 = this.submarine.getMouseListeners();
		
		for(int i=0; i<motion4.length; i++)
		{ this.submarine.removeMouseMotionListener(motion4[i]); }
		
		for(int i=0; i<listener4.length; i++)
		{ this.submarine.removeMouseListener(listener4[i]); }
		
		MouseMotionListener[] motion5 = this.frigate.getMouseMotionListeners();
		MouseListener[] listener5 = this.frigate.getMouseListeners();
		
		for(int i=0; i<motion5.length; i++)
		{ this.frigate.removeMouseMotionListener(motion5[i]); }
		
		for(int i=0; i<listener5.length; i++)
		{ this.frigate.removeMouseListener(listener5[i]); }
	}
	
	public void unlockShips()
	{
		this.aircraftCarrier.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				int horizontal = aircraftCarrier.getX()+((e.getX())/25)*25;
				int width = aircraftCarrier.getWidth();
				
				int vertical = aircraftCarrier.getY()+((e.getY())/25)*25;
				int height = aircraftCarrier.getHeight();
				
				if(horizontal>=0 && horizontal<(251-width) && vertical>=0 && vertical<(251-height))
				{ aircraftCarrier.setBounds(horizontal, vertical, width, height); }
			}
		});
		this.aircraftCarrier.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==2)
				{
					int horizontal = aircraftCarrier.getX();
					int vertical = aircraftCarrier.getY();
					int width = aircraftCarrier.getWidth();
					int height = aircraftCarrier.getHeight();
					
					if(horizontal<(251-height) && vertical<(251-width))
					{
						if(aircraftCarrier.getHeight()==24)
						{
							ImageIcon image = new ImageIcon("images/ships/carrierv.png");
							aircraftCarrier.setIcon(image);
							aircraftCarrier.setBounds(aircraftCarrier.getX(), aircraftCarrier.getY(), height, width);
						}
						else
						{
							ImageIcon image = new ImageIcon("images/ships/carrier.png");
							aircraftCarrier.setIcon(image);
							aircraftCarrier.setBounds(aircraftCarrier.getX(), aircraftCarrier.getY(), height, width);
						}
					}
				}
			}
		});
		
		this.cruiser.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				int horizontal = cruiser.getX()+((e.getX()-2)/25)*25;
				int width = cruiser.getWidth();
				
				int vertical = cruiser.getY()+((e.getY()-2)/25)*25;
				int height = cruiser.getHeight();
				
				if(horizontal>=0 && horizontal<(251-width) && vertical>=0 && vertical<(251-height))
				{ cruiser.setBounds(horizontal, vertical, width, height); }
			}
		});
		this.cruiser.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==2)
				{
					int horizontal = cruiser.getX();
					int vertical = cruiser.getY();
					int width = cruiser.getWidth();
					int height = cruiser.getHeight();
					
					if(horizontal<(251-height) && vertical<(251-width))
					{
						if(cruiser.getHeight()==24)
						{
							ImageIcon image = new ImageIcon("images/ships/cruiserv.png");
							cruiser.setIcon(image);
							cruiser.setBounds(cruiser.getX(), cruiser.getY(), height, width);
						}
						else
						{
							ImageIcon image = new ImageIcon("images/ships/cruiser.png");
							cruiser.setIcon(image);
							cruiser.setBounds(cruiser.getX(), cruiser.getY(), height, width);
						}
					}
				}
			}
		});
		
		this.destroyer.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				int horizontal = destroyer.getX()+((e.getX()-2)/25)*25;
				int width = destroyer.getWidth();
				
				int vertical = destroyer.getY()+((e.getY()-2)/25)*25;
				int height = destroyer.getHeight();
				
				if(horizontal>=0 && horizontal<(251-width) && vertical>=0 && vertical<(251-height))
				{ destroyer.setBounds(horizontal, vertical, width, height); }
			}
		});
		this.destroyer.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==2)
				{
					int horizontal = destroyer.getX();
					int vertical = destroyer.getY();
					int width = destroyer.getWidth();
					int height = destroyer.getHeight();
					
					if(horizontal<(251-height) && vertical<(251-width))
					{
						if(destroyer.getHeight()==24)
						{
							ImageIcon image = new ImageIcon("images/ships/destroyerv.png");
							destroyer.setIcon(image);
							destroyer.setBounds(destroyer.getX(), destroyer.getY(), height, width);
						}
						else
						{
							ImageIcon image = new ImageIcon("images/ships/destroyer.png");
							destroyer.setIcon(image);
							destroyer.setBounds(destroyer.getX(), destroyer.getY(), height, width);
						}
					}
				}
			}
		});
		
		this.submarine.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				int horizontal = submarine.getX()+((e.getX()-2)/25)*25;
				int width = submarine.getWidth();
				
				int vertical = submarine.getY()+((e.getY()-2)/25)*25;
				int height = submarine.getHeight();
				
				if(horizontal>=0 && horizontal<(251-width) && vertical>=0 && vertical<(251-height))
				{ submarine.setBounds(horizontal, vertical, width, height); }
			}
		});
		this.submarine.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==2)
				{
					int horizontal = submarine.getX();
					int vertical = submarine.getY();
					int width = submarine.getWidth();
					int height = submarine.getHeight();
					
					if(horizontal<(251-height) && vertical<(251-width))
					{
						if(submarine.getHeight()==24)
						{
							ImageIcon image = new ImageIcon("images/ships/submarinev.png");
							submarine.setIcon(image);
							submarine.setBounds(submarine.getX(), submarine.getY(), height, width);
						}
						else
						{
							ImageIcon image = new ImageIcon("images/ships/submarine.png");
							submarine.setIcon(image);
							submarine.setBounds(submarine.getX(), submarine.getY(), height, width);
						}
					}
				}
			}
		});
		
		this.frigate.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				int horizontal = frigate.getX()+((e.getX()-2)/25)*25;
				int width = frigate.getWidth();
				
				int vertical = frigate.getY()+((e.getY()-2)/25)*25;
				int height = frigate.getHeight();
				
				if(horizontal>=0 && horizontal<(251-width) && vertical>=0 && vertical<(251-height))
				{ frigate.setBounds(horizontal, vertical, width, height); }
			}
		});
		this.frigate.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==2)
				{
					int horizontal = frigate.getX();
					int vertical = frigate.getY();
					int width = frigate.getWidth();
					int height = frigate.getHeight();
					
					if(horizontal<(251-height) && vertical<(251-width))
					{
						if(frigate.getHeight()==24)
						{
							ImageIcon image = new ImageIcon("images/ships/frigatev.png");
							frigate.setIcon(image);
							frigate.setBounds(frigate.getX(), frigate.getY(), height, width);
						}
						else
						{
							ImageIcon image = new ImageIcon("images/ships/frigate.png");
							frigate.setIcon(image);
							frigate.setBounds(frigate.getX(), frigate.getY(), height, width);
						}
					}
				}
			}
		});
	}
	
	public void reset(Scenario scenario)
	{
		this.toPlot = false;
		this.pieces = new ArrayList<VisualPlotPiece>();
		
		VisualGamePanel.reset();
		VisualGamePanel scenarioPanel = VisualGamePanel.getInstance();
		
		ImageIcon imageCarrier = new ImageIcon("images/ships/carrier.png");
		this.aircraftCarrier = new JLabel(imageCarrier);
		this.aircraftCarrier.setBounds(1, 1, 124, 24);
		scenarioPanel.add(this.aircraftCarrier);
		
		ImageIcon imageCruiser = new ImageIcon("images/ships/cruiser.png");
		this.cruiser = new JLabel(imageCruiser);
		this.cruiser.setBounds(1, 26, 99, 24);
		scenarioPanel.add(this.cruiser);
		
		ImageIcon imageDestroyer = new ImageIcon("images/ships/destroyer.png");
		this.destroyer = new JLabel(imageDestroyer);
		this.destroyer.setBounds(1, 51, 74, 24);
		scenarioPanel.add(this.destroyer);
		
		ImageIcon imageSubmarine = new ImageIcon("images/ships/submarine.png");
		this.submarine = new JLabel(imageSubmarine);
		this.submarine.setBounds(1, 76, 49, 24);
		scenarioPanel.add(this.submarine);
		
		ImageIcon imageFrigate = new ImageIcon("images/ships/frigate.png");
		this.frigate = new JLabel(imageFrigate);
		this.frigate.setBounds(1, 101, 49, 24);
		scenarioPanel.add(this.frigate);
		
		for(int i=0; i<scenario.getPieces().size(); i++)
		{
			VisualPlotPiece visualPlotPiece = new VisualPlotPiece();
			visualPlotPiece.setHorizontal(scenario.getPieces().get(i).getHorizontal());
			visualPlotPiece.setVertical(scenario.getPieces().get(i).getVertical());
			visualPlotPiece.setBounds((scenario.getPieces().get(i).getHorizontal())*25, (scenario.getPieces().get(i).getVertical())*25, 26, 26);
			
			this.pieces.add(visualPlotPiece);
			scenarioPanel.add(visualPlotPiece);
		}
		
		if(this.getContentPane().getComponentAt(55, 50)!=null)
		{ this.getContentPane().remove(this.getContentPane().getComponentAt(55, 50)); }
		
		this.getContentPane().add(scenarioPanel);
		scenarioPanel.repaint();
	}
}
