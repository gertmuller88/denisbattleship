package br.upe.ecomp.model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Scene implements Serializable
{
	private ArrayList<Piece> pieces;

	public ArrayList<Piece> getPieces()
	{ return pieces; }

	public void setPieces(ArrayList<Piece> pieces)
	{ this.pieces = pieces; }
}
