package br.upe.ecomp.model;

import java.awt.Color;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Piece extends AbstractPiece implements Serializable
{
	private int horizontal;
	private int vertical;
	private Color color = Color.BLUE;

	public int getHorizontal()
	{ return horizontal; }

	public void setHorizontal(int horizontal)
	{ this.horizontal = horizontal; }

	public int getVertical()
	{ return vertical; }

	public void setVertical(int vertical)
	{ this.vertical = vertical; }

	public Color getColor()
	{ return color; }

	public void setColor(Color color)
	{ this.color = color; }
}
