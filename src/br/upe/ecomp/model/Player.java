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
	
	public boolean haveShips()
	{
		for(int i=0; i<this.ships.size(); i++)
		{
			ships.get(i).update();
			if(ships.get(i).isDamaged() || ships.get(i).isNoDamaged())
			{ return true; }
		}
		return false;
	}
	
	public void update(Player player)
	{
		if(player.isLocked())
		{ this.setLocked(); }
		else if(player.isUnlocked())
		{ this.setUnlocked(); }
		
		this.name = player.getName();
		this.score = player.getScore();
		
		for(int i=0; i<player.getShips().size(); i++)
		{ this.ships.get(i).update(player.getShips().get(i)); }
	}
}
