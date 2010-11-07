package br.upe.ecomp.view.components;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import br.upe.ecomp.model.Piece;

@SuppressWarnings("serial")
public class VisualGamePiece extends JPanel
{
	private Piece piece;
	private ImageIcon imageBackground;
	private JLabel background;
	private MouseAdapter listener;
	
	public VisualGamePiece()
	{
		listener = new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				imageBackground = new ImageIcon("images/ships/piece-target-wb.png");
				background.setIcon(imageBackground);
			}
			
			public void mouseExited(MouseEvent e)
			{
				imageBackground = new ImageIcon("images/ships/piece-wb.png");
				background.setIcon(imageBackground);
			}
			
			public void mouseClicked(MouseEvent e)
			{
				piece.setColor(Color.RED);
				update();
			}
		};
		
		imageBackground = new ImageIcon("images/ships/piece-wb.png");
		background = new JLabel(imageBackground);
		background.addMouseListener(listener);
		background.setBounds(0, 0, 26, 26);
		this.add(background);
		
		this.setVisible(true);
		this.setLayout(null);
	}
	
	public Piece getPiece()
	{ return this.piece; }
	
	public void setPiece(Piece piece)
	{ this.piece = piece; }
	
	public void update()
	{
		if(piece.getColor()==Color.GRAY)
		{
			imageBackground = new ImageIcon("images/ships/piece-wb.png");
			background.setIcon(imageBackground);
		}
		else if(piece.getColor()==Color.CYAN)
		{
			imageBackground = new ImageIcon("images/ships/water.png");
			background.setIcon(imageBackground);
			background.removeMouseListener(this.listener);
		}
		else if(piece.getColor()==Color.RED)
		{
			imageBackground = new ImageIcon("images/ships/fire.png");
			background.setIcon(imageBackground);
			background.removeMouseListener(this.listener);
		}
	}
}
