package br.upe.ecomp.model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Ship implements Serializable
{
	private String name;
	private int size;
	private ArrayList<Piece> pieces;
	private boolean destroyed;

	public String getName()
	{ return name; }

	public void setName(String name)
	{ this.name = name; }

	public int getSize()
	{ return size; }

	public void setSize(int size)
	{ this.size = size; }

	public ArrayList<Piece> getPieces()
	{ return pieces; }

	public void setPieces(ArrayList<Piece> pieces)
	{ this.pieces = pieces; }

	public boolean isDestroyed()
	{ return destroyed; }

	public void setDestroyed(boolean destroyed)
	{ this.destroyed = destroyed; }
}
