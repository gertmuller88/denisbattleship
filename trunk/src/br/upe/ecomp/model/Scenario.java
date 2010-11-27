package br.upe.ecomp.model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Scenario implements Serializable
{
	public static final int LINES	= 10;
	public static final int COLUMNS = 10;
	
	private ArrayList<AbstractPiece> pieces;

	public ArrayList<AbstractPiece> getPieces()
	{ return pieces; }

	public void setPieces(ArrayList<AbstractPiece> pieces)
	{ this.pieces = pieces; }
}
