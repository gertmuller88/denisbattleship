package br.upe.ecomp.model;

import java.awt.Color;
import java.io.Serializable;
import br.upe.ecomp.model.state.OccupiedAndDestroyed;
import br.upe.ecomp.model.state.OccupiedAndNonDestroyed;
import br.upe.ecomp.model.state.StatePiece;
import br.upe.ecomp.model.state.UnoccupiedAndDestroyed;
import br.upe.ecomp.model.state.UnoccupiedAndNonDestroyed;

@SuppressWarnings("serial")
public class Piece extends AbstractPiece implements Serializable
{
	private StatePiece occupiedAndDestroyed;
	private StatePiece occupiedAndNonDestroyed;
	private StatePiece unoccupiedAndDestroyed;
	private StatePiece unoccupiedAndNonDestroyed;
	private StatePiece state;
	private Color color = Color.BLUE;
	
	public Piece()
	{
		this.occupiedAndDestroyed = new OccupiedAndDestroyed(this);
		this.occupiedAndNonDestroyed = new OccupiedAndNonDestroyed(this);
		this.unoccupiedAndDestroyed = new UnoccupiedAndDestroyed(this);
		this.unoccupiedAndNonDestroyed = new UnoccupiedAndNonDestroyed(this);
		this.state = this.unoccupiedAndNonDestroyed;
		this.color = Color.BLUE;
	}

	public StatePiece getOccupiedAndDestroyed()
	{ return this.occupiedAndDestroyed; }

	public void setOccupiedAndDestroyed(StatePiece occupiedAndDestroyed)
	{ this.occupiedAndDestroyed = occupiedAndDestroyed; }

	public StatePiece getOccupiedAndNonDestroyed()
	{ return this.occupiedAndNonDestroyed; }

	public void setOccupiedAndNonDestroyed(StatePiece occupiedAndNonDestroyed)
	{ this.occupiedAndNonDestroyed = occupiedAndNonDestroyed; }

	public StatePiece getUnoccupiedAndDestroyed()
	{ return this.unoccupiedAndDestroyed; }

	public void setUnoccupiedAndDestroyed(StatePiece unoccupiedAndDestroyed)
	{ this.unoccupiedAndDestroyed = unoccupiedAndDestroyed; }

	public StatePiece getUnoccupiedAndNonDestroyed()
	{ return this.unoccupiedAndNonDestroyed; }

	public void setUnoccupiedAndNonDestroyed(StatePiece unoccupiedAndNonDestroyed)
	{ this.unoccupiedAndNonDestroyed = unoccupiedAndNonDestroyed; }

	public StatePiece getState()
	{ return this.state; }

	public void setState(StatePiece state)
	{ this.state = state; }

	public Color getColor()
	{ return this.color; }

	public void setColor(Color color)
	{ this.color = color; }
	
	public void setOccupied()
	{
		this.state.setOccupied();
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void setUnoccupied()
	{
		this.state.setUnoccupied();
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void setDestroyed()
	{
		this.state.setDestroyed();
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void setNonDestroyed()
	{
		this.state.setNonDestroyed();
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public boolean isOccupied()
	{
		if(this.color==Color.GRAY || this.color==Color.ORANGE)
		{ return true; }
		return false;
	}
	
	public boolean isUnoccupied()
	{
		if(this.color==Color.CYAN || this.color==Color.BLUE)
		{ return true; }
		return false;
	}
	
	public boolean isDestroyed()
	{
		if(this.color==Color.ORANGE || this.color==Color.CYAN)
		{ return true; }
		return false;
	}
	
	public boolean isNonDestroyed()
	{
		if(this.color==Color.GRAY || this.color==Color.BLUE)
		{ return true; }
		return false;
	}
}
