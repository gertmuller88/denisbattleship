package br.upe.ecomp.view.components;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import br.upe.ecomp.model.Piece;

@SuppressWarnings("serial")
public class VisualGamePiece extends JPanel implements Observer
{
	private int horizontal;
	private int vertical;
	private ImageIcon imageTarget, imageGray, imageWater, imageFire;
	private JLabel background;
	private MouseAdapter listener;
	
	public VisualGamePiece(MouseAdapter adpt)
	{
		this.imageTarget = new ImageIcon("images/ships/piece-target-wb.png");
		this.imageGray = new ImageIcon("images/ships/piece-wb.png");
		this.imageWater = new ImageIcon("images/ships/water.png");
		this.imageFire = new ImageIcon("images/ships/fire.png");
		
		this.listener = new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				if(background.getName().equals("Available"))
				{ background.setIcon(imageTarget); }
			}
			
			public void mouseExited(MouseEvent e)
			{
				if(background.getName().equals("Available"))
				{ background.setIcon(imageGray); }
			}
		};
		
		this.background = new JLabel(this.imageGray);
		this.background.setName("Available");
		this.background.addMouseListener(this.listener);
		this.background.addMouseListener(adpt);
		this.background.setBounds(0, 0, 26, 26);
		this.add(background);
		
		this.setVisible(true);
		this.setLayout(null);
	}

	public int getHorizontal()
	{ return horizontal; }

	public void setHorizontal(int horizontal)
	{ this.horizontal = horizontal; }

	public int getVertical()
	{ return vertical; }

	public void setVertical(int vertical)
	{ this.vertical = vertical; }

	public void update(Observable o, Object arg)
	{
		Piece piece = (Piece) arg;
		
		if(piece.isDestroyed() && piece.isOccupied())
		{
			this.background.setName("Unavailable");
			this.background.setIcon(this.imageFire);
		}
		else if(piece.isDestroyed() && piece.isUnoccupied())
		{
			this.background.setName("Unavailable");
			this.background.setIcon(this.imageWater);
		}
	}
}
