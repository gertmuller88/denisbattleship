package br.upe.ecomp.model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Ship extends AbstractPiece implements Serializable
{
	private ArrayList<AbstractPiece> pieces;

	public ArrayList<AbstractPiece> getPieces()
	{ return pieces; }

	public void setPieces(ArrayList<AbstractPiece> pieces)
	{ this.pieces = pieces; }
}
