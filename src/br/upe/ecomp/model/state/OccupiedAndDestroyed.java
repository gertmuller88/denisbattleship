package br.upe.ecomp.model.state;

import java.awt.Color;
import java.io.Serializable;
import br.upe.ecomp.model.Piece;

@SuppressWarnings("serial")
public class OccupiedAndDestroyed implements StatePiece, Serializable
{
	Piece piece;
	
	public OccupiedAndDestroyed(Piece piece)
	{ this.piece = piece; }

	public void setOccupied()
	{
		if(piece.getState().getClass().isInstance(piece.getUnoccupiedAndDestroyed()))
		{ piece.setState(piece.getOccupiedAndDestroyed()); }
		if(piece.getState().getClass().isInstance(piece.getUnoccupiedAndNonDestroyed()))
		{ piece.setState(piece.getOccupiedAndNonDestroyed()); }
	}

	public void setUnoccupied()
	{
		if(piece.getState().getClass().isInstance(piece.getOccupiedAndDestroyed()))
		{ piece.setState(piece.getUnoccupiedAndDestroyed()); }
		if(piece.getState().getClass().isInstance(piece.getOccupiedAndNonDestroyed()))
		{ piece.setState(piece.getUnoccupiedAndNonDestroyed()); }
	}

	public void setDestroyed()
	{
		if(piece.getState().getClass().isInstance(piece.getOccupiedAndNonDestroyed()))
		{ piece.setState(piece.getOccupiedAndDestroyed()); }
		if(piece.getState().getClass().isInstance(piece.getUnoccupiedAndNonDestroyed()))
		{ piece.setState(piece.getUnoccupiedAndDestroyed()); }
		
		piece.setColor(Color.ORANGE);
	}

	public void setNonDestroyed()
	{
		if(piece.getState().getClass().isInstance(piece.getOccupiedAndNonDestroyed()))
		{ piece.setState(piece.getOccupiedAndDestroyed()); }
		if(piece.getState().getClass().isInstance(piece.getUnoccupiedAndNonDestroyed()))
		{ piece.setState(piece.getUnoccupiedAndDestroyed()); }
		
		piece.setColor(Color.BLUE);
	}
}
