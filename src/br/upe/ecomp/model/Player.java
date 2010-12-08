package br.upe.ecomp.model;

import java.io.Serializable;
import java.util.ArrayList;

import br.upe.ecomp.model.state.Locked;
import br.upe.ecomp.model.state.StatePlayer;
import br.upe.ecomp.model.state.Unlocked;

@SuppressWarnings("serial")
public class Player implements Serializable
{
	private StatePlayer locked;
	private StatePlayer unlocked;
	private StatePlayer state;
	private String name;
	private int score;
	private ArrayList<Ship> ships;
	
	public Player()
	{
		this.locked = new Locked(this);
		this.unlocked = new Unlocked(this);
		this.state = unlocked;
	}
	
	public StatePlayer getLocked()
	{ return locked; }

	public void setLocked()
	{ this.state = locked; }
	
	public boolean isLocked()
	{
		if(this.state.getClass().isInstance(this.locked))
		{ return true; }
		return false;
	}

	public StatePlayer getUnlocked()
	{ return unlocked; }

	public void setUnlocked()
	{ this.state = unlocked; }
	
	public boolean isUnlocked()
	{
		if(this.state.getClass().isInstance(this.unlocked))
		{ return true; }
		return false;
	}

	public StatePlayer getState()
	{ return state; }

	public void setState(StatePlayer state)
	{ this.state = state; }

	public String getName()
	{ return this.name; }
	
	public void setName(String name)
	{ this.name = name; }
	
	public int getScore()
	{ return this.score; }
	
	public void setScore(int score)
	{ this.score = score; }
	
	public ArrayList<Ship> getShips()
	{ return this.ships; }
	
	public void setShips(ArrayList<Ship> ships)
	{ this.ships = ships; }
}
