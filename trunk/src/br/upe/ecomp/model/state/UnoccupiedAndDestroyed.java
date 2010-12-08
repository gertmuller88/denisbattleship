package br.upe.ecomp.model.state;

import java.awt.Color;
import java.io.Serializable;
import br.upe.ecomp.model.Piece;

@SuppressWarnings("serial")
public class UnoccupiedAndDestroyed implements StatePiece, Serializable
{
	private Piece piece;
	
	public UnoccupiedAndDestroyed(Piece piece)
	{ this.piece = piece; }

	public void setOccupied()
	{
		if(piece.getState().getClass().isInstance(piece.getUnoccupiedAndDestroyed()))
		{
			piece.setState(piece.getOccupiedAndDestroyed());
			piece.setColor(Color.ORANGE);
		}
		if(piece.getState().getClass().isInstance(piece.getUnoccupiedAndNonDestroyed()))
		{
			piece.setState(piece.getOccupiedAndNonDestroyed());
			piece.setColor(Color.GRAY);
		}
	}

	public void setUnoccupied()
	{
		if(piece.getState().getClass().isInstance(piece.getOccupiedAndDestroyed()))
		{
			piece.setState(piece.getUnoccupiedAndDestroyed());
			piece.setColor(Color.CYAN);
		}
		if(piece.getState().getClass().isInstance(piece.getOccupiedAndNonDestroyed()))
		{
			piece.setState(piece.getUnoccupiedAndNonDestroyed());
			piece.setColor(Color.BLUE);
		}
	}

	public void setDestroyed()
	{
		if(piece.getState().getClass().isInstance(piece.getOccupiedAndNonDestroyed()))
		{
			piece.setState(piece.getOccupiedAndDestroyed());
			piece.setColor(Color.ORANGE);
		}
		if(piece.getState().getClass().isInstance(piece.getUnoccupiedAndNonDestroyed()))
		{
			piece.setState(piece.getUnoccupiedAndDestroyed());
			piece.setColor(Color.CYAN);
		}
	}

	public void setNonDestroyed()
	{
		if(piece.getState().getClass().isInstance(piece.getOccupiedAndDestroyed()))
		{
			piece.setState(piece.getOccupiedAndNonDestroyed());
			piece.setColor(Color.GRAY);
		}
		if(piece.getState().getClass().isInstance(piece.getUnoccupiedAndDestroyed()))
		{
			piece.setState(piece.getUnoccupiedAndNonDestroyed());
			piece.setColor(Color.BLUE);
		}
	}
}
