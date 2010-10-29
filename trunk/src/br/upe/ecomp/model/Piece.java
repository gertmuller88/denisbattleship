package br.upe.ecomp.model;

import java.awt.Color;

public class Piece extends AbstractPiece
{
	private int horizontal;
	private int vertical;
	private Color color;

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
