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
		this.imageBackground = new ImageIcon("images/ships/piece.png");
		this.background = new JLabel(this.imageBackground);
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
}
