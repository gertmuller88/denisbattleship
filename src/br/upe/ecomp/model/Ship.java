package br.upe.ecomp.model;

import java.util.ArrayList;

public class Ship extends AbstractPiece
{
	private String name;
	private int size;
	private ArrayList<AbstractPiece> pieces;

	public String getName()
	{ return name; }

	public void setName(String name)
	{ this.name = name; }

	public int getSize()
	{ return size; }

	public void setSize(int size)
	{ this.size = size; }

	public ArrayList<AbstractPiece> getPieces()
	{ return pieces; }

	public void setPieces(ArrayList<AbstractPiece> pieces)
	{ this.pieces = pieces; }
}
