package br.upe.ecomp.model;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("serial")
public class Scenario implements Serializable
{
	public static final int LINES = 10;
	public static final int COLUMNS = 10;
	
	private ArrayList<AbstractPiece> pieces;

	public ArrayList<AbstractPiece> getPieces()
	{ return pieces; }

	public void setPieces(ArrayList<AbstractPiece> pieces)
	{ this.pieces = pieces; }
	
	public boolean shot(int x, int y) {
		boolean hitted = false;
		
		for (AbstractPiece piece : getPieces()) {
			if (((Piece) piece).getHorizontal() == x
					&& ((Piece) piece).getVertical() == y) {
				if (((Piece) piece).getColor() == Color.ORANGE) {
					hitted = true;
				}
			}
		}
		
		return hitted;
	}
}
