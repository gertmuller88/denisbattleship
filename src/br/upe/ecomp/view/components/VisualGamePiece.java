package br.upe.ecomp.view.components;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VisualGamePiece extends JPanel
{
	private int horizontal;
	private int vertical;
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
		};
		
		this.imageBackground = new ImageIcon("images/ships/piece-wb.png");
		this.background = new JLabel(this.imageBackground);
		this.background.addMouseListener(this.listener);
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
}
