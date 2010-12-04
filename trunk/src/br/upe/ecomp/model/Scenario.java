package br.upe.ecomp.model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Scenario implements Serializable
{
	private ArrayList<AbstractPiece> pieces;

	public ArrayList<AbstractPiece> getPieces()
	{ return pieces; }

	public void setPieces(ArrayList<AbstractPiece> pieces)
	{ this.pieces = pieces; }
	
	public AbstractPiece getPiece(int horizontal, int vertical)
	{
		for(int i=0; i<pieces.size(); i++)
		{
			if(pieces.get(i).getHorizontal()==horizontal && pieces.get(i).getVertical()==vertical)
			{ return pieces.get(i); }
		}
		return null;
	}
}
