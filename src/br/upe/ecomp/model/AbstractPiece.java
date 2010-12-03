package br.upe.ecomp.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractPiece implements Serializable
{
	private String name;
	private int size;
	private int horizontal;
	private int vertical;
	
	public String getName()
	{ return name; }

	public void setName(String name)
	{ this.name = name; }

	public int getSize()
	{ return size; }

	public void setSize(int size)
	{ this.size = size; }
	
	public int getHorizontal()
	{ return horizontal; }

	public void setHorizontal(int horizontal)
	{ this.horizontal = horizontal; }

	public int getVertical()
	{ return vertical; }

	public void setVertical(int vertical)
	{ this.vertical = vertical; }
}
