package br.upe.ecomp.model;

import java.io.Serializable;
import java.util.ArrayList;

import br.upe.ecomp.model.state.Damaged;
import br.upe.ecomp.model.state.NoDamaged;
import br.upe.ecomp.model.state.StateShip;
import br.upe.ecomp.model.state.Sunk;

@SuppressWarnings("serial")
public class Ship extends AbstractPiece implements Serializable
{
	private StateShip noDamaged;
	private StateShip damaged;
	private StateShip sunk;
	private StateShip state = noDamaged;
	private ArrayList<AbstractPiece> pieces;
	
	public Ship()
	{
		this.noDamaged = new NoDamaged(this);
		this.damaged = new Damaged(this);
		this.sunk = new Sunk(this);
		this.state = this.noDamaged;
	}
	
	public StateShip getNoDamaged()
	{ return noDamaged; }

	public void setNoDamaged(StateShip noDamaged)
	{ this.noDamaged = noDamaged; }

	public StateShip getDamaged()
	{ return damaged; }

	public void setDamaged(StateShip damaged)
	{ this.damaged = damaged; }

	public StateShip getSunk()
	{ return sunk; }

	public void setSunk(StateShip sunk)
	{ this.sunk = sunk; }

	public StateShip getState()
	{ return state; }

	public void setState(StateShip state)
	{ this.state = state; }

	public ArrayList<AbstractPiece> getPieces()
	{ return this.pieces; }

	public void setPieces(ArrayList<AbstractPiece> pieces)
	{ this.pieces = pieces; }
	
	public void update()
	{ this.state.update(); }
	
	public boolean isNoDamaged()
	{
		if(this.state.getClass().isInstance(this.getNoDamaged()))
		{ return true; }
		return false;
	}
	
	public boolean isDamaged()
	{
		if(this.state.getClass().isInstance(this.getDamaged()))
		{ return true; }
		return false;
	}
	
	public boolean isSunk()
	{
		if(this.state.getClass().isInstance(this.getSunk()))
		{ return true; }
		return false;
	}
	
	public void update(AbstractPiece piece)
	{
		Ship ship = (Ship) piece;
		if(ship.isNoDamaged())
		{ this.setNoDamaged(this.noDamaged); }
		else if(ship.isDamaged())
		{ this.setDamaged(this.damaged); }
		else if(ship.isSunk())
		{ this.setSunk(this.sunk); }
		
		this.setName(ship.getName());
		this.setSize(ship.getSize());
		
		for(int i=0; i<ship.getPieces().size(); i++)
		{ this.pieces.get(i).update(ship.getPieces().get(i)); }
	}
}
