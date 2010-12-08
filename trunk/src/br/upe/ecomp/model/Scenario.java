package br.upe.ecomp.model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Scenario implements Serializable
{
	public static final int LINES = 10;
	public static final int COLUMNS = 10;
	private ArrayList<AbstractPiece> pieces;

	public ArrayList<AbstractPiece> getPieces()
	{ return this.pieces; }

	public void setPieces(ArrayList<AbstractPiece> pieces)
	{ this.pieces = pieces; }
	
	public AbstractPiece getPiece(int horizontal, int vertical)
	{
		AbstractPiece pieceReturn = null;
		for(int i=0; i<pieces.size(); i++)
		{
			pieceReturn = pieces.get(i);
			
			if(pieceReturn.getHorizontal()==horizontal && pieceReturn.getVertical()==vertical)
			{ return pieceReturn; }
		}
		return null;
	}
}
