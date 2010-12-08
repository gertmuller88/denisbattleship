package br.upe.ecomp.view.components;

import java.rmi.RemoteException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import br.upe.ecomp.model.Piece;

@SuppressWarnings("serial")
public class VisualPlotPiece extends JPanel
{
	private int horizontal;
	private int vertical;
	private ImageIcon imagePiece, imageWater, imageFire;
	private JLabel background;
	
	public VisualPlotPiece()
	{
		this.imagePiece = new ImageIcon("images/ships/piece.png");
		this.imageWater = new ImageIcon("images/ships/water.png");
		this.imageFire = new ImageIcon("images/ships/fire.png");
		
		this.background = new JLabel(this.imagePiece);
		this.background.setBounds(0, 0, 26, 26);
		this.add(this.background);
		
		this.setVisible(true);
		this.setLayout(null);
	}

	public int getHorizontal()
	{ return this.horizontal; }

	public void setHorizontal(int horizontal)
	{ this.horizontal = horizontal; }

	public int getVertical()
	{ return this.vertical; }

	public void setVertical(int vertical)
	{ this.vertical = vertical; }

	public void update(Object observable, Object updateMsg) throws RemoteException 
	{
		Piece piece = (Piece) updateMsg;
		
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
