package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import br.upe.ecomp.enumeration.ShipType;
import br.upe.ecomp.view.components.VisualPlotPiece;

@SuppressWarnings("serial")
public class ScenarioScreen extends JDialog
{
	private static ScenarioScreen scenarioScreen;
	private ArrayList<VisualPlotPiece> pieces = new ArrayList<VisualPlotPiece>();
	private JLabel aircraftCarrier, cruiser, destroyer, submarine, frigate;
	
	private ScenarioScreen()
	{
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
		
		JPanel scenarioPanel = new JPanel();
		scenarioPanel.setLayout(null);
		scenarioPanel.setBounds(55, 50, 251, 251);
		container.add(scenarioPanel);
		
		ImageIcon imageCarrier = new ImageIcon("images/ships/carrier.png");
		aircraftCarrier = new JLabel(imageCarrier);
		aircraftCarrier.addMouseMotionListener(new MouseMotionAdapter()
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
		aircraftCarrier.addMouseListener(new MouseAdapter()
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
						if(aircraftCarrier.getHeight()==25)
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
		aircraftCarrier.setBounds(0, 0, 125, 25);
		scenarioPanel.add(aircraftCarrier);
		
		ImageIcon imageCruiser = new ImageIcon("images/ships/cruiser.png");
		cruiser = new JLabel(imageCruiser);
		cruiser.addMouseMotionListener(new MouseMotionAdapter()
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
		cruiser.addMouseListener(new MouseAdapter()
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
						if(cruiser.getHeight()==25)
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
		cruiser.setBounds(0, 25, 100, 25);
		scenarioPanel.add(cruiser);
		
		ImageIcon imageDestroyer = new ImageIcon("images/ships/destroyer.png");
		destroyer = new JLabel(imageDestroyer);
		destroyer.addMouseMotionListener(new MouseMotionAdapter()
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
		destroyer.addMouseListener(new MouseAdapter()
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
						if(destroyer.getHeight()==25)
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
		destroyer.setBounds(0, 50, 75, 25);
		scenarioPanel.add(destroyer);
		
		ImageIcon imageSubmarine = new ImageIcon("images/ships/submarine.png");
		submarine = new JLabel(imageSubmarine);
		submarine.addMouseMotionListener(new MouseMotionAdapter()
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
		submarine.addMouseListener(new MouseAdapter()
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
						if(submarine.getHeight()==25)
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
		submarine.setBounds(0, 75, 50, 25);
		scenarioPanel.add(submarine);
		
		ImageIcon imageFrigate = new ImageIcon("images/ships/frigate.png");
		frigate = new JLabel(imageFrigate);
		frigate.addMouseMotionListener(new MouseMotionAdapter()
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
		frigate.addMouseListener(new MouseAdapter()
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
						if(frigate.getHeight()==25)
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
		frigate.setBounds(0, 100, 50, 25);
		scenarioPanel.add(frigate);
		
		for(int i=0; i<10; i++)
		{
			for(int j=0; j<10; j++)
			{
				VisualPlotPiece visualPlotPiece = new VisualPlotPiece();
				visualPlotPiece.setHorizontal(i);
				visualPlotPiece.setVertical(j);
				visualPlotPiece.setBounds((j)*25, (i)*25, 26, 26);
				
				pieces.add(visualPlotPiece);
				scenarioPanel.add(visualPlotPiece);
			}
		}
		
		JButton plot = new JButton("Posicionar Embarcações");
		plot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(shipsIntersect())
				{ JOptionPane.showMessageDialog(null, "Existem embarcações sobrepostas. Organize-as novamente.", "", JOptionPane.WARNING_MESSAGE); }
				else
				{ dispose(); }
			}
		});
		plot.setBounds(355, 250, 200, 50);
		container.add(plot);
		
		this.pack();
		this.setSize(610, 380);
		this.setResizable(false);
		this.setLayout(null);
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static ScenarioScreen getInstance()
	{
		if(scenarioScreen==null)
		{ scenarioScreen = new ScenarioScreen(); }
		return scenarioScreen;
	}
	
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
}
