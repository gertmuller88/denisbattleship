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
		this.listener = new MouseAdapter()
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
		
		this.imageBackground = new ImageIcon("images/ships/piece-wb.png");
		this.background = new JLabel(this.imageBackground);
		this.background.addMouseListener(this.listener);
		this.background.setBounds(0, 0, 26, 26);
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
		if(this.piece.getColor()==Color.GRAY)
		{
			this.imageBackground = new ImageIcon("images/ships/piece-wb.png");
			this.background.setIcon(this.imageBackground);
		}
		else if(this.piece.getColor()==Color.CYAN)
		{
			this.imageBackground = new ImageIcon("images/ships/water.png");
			this.background.setIcon(this.imageBackground);
			this.background.removeMouseListener(this.listener);
		}
		else if(piece.getColor()==Color.ORANGE)
		{
			this.imageBackground = new ImageIcon("images/ships/fire.png");
			this.background.setIcon(this.imageBackground);
			this.background.removeMouseListener(this.listener);
		}
	}
}
