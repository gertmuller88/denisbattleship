package br.upe.ecomp.view.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VisualPlotPiece extends JPanel
{
	private int horizontal;
	private int vertical;
	private ImageIcon imageBackground;
	private JLabel background;
	
	public VisualPlotPiece()
	{
		imageBackground = new ImageIcon("images/ships/piece.png");
		background = new JLabel(imageBackground);
		background.setBounds(0, 0, 26, 26);
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
