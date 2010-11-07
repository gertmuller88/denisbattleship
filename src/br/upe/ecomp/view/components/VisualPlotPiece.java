package br.upe.ecomp.view.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import br.upe.ecomp.model.Piece;

@SuppressWarnings("serial")
public class VisualPlotPiece extends JPanel
{
	private Piece piece;
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
	
	public Piece getPiece()
	{ return this.piece; }
	
	public void setPiece(Piece piece)
	{ this.piece = piece; }
}
