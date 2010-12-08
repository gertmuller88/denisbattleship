package br.upe.ecomp.model;

import java.io.Serializable;
import java.util.Observable;

@SuppressWarnings("serial")
public abstract class AbstractPiece extends Observable implements Serializable
{
	private String name;
	private int size;
	private int horizontal;
	private int vertical;
	
	public String getName()
	{ return this.name; }

	public void setName(String name)
	{ this.name = name; }

	public int getSize()
	{ return this.size; }

	public void setSize(int size)
	{ this.size = size; }
	
	public int getHorizontal()
	{ return this.horizontal; }

	public void setHorizontal(int horizontal)
	{ this.horizontal = horizontal; }

	public int getVertical()
	{ return this.vertical; }

	public void setVertical(int vertical)
	{ this.vertical = vertical; }
}
