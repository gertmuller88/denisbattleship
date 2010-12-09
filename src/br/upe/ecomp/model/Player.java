package br.upe.ecomp.model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Player implements Serializable
{
	private boolean locked;
	private String name;
	private int score;
	private ArrayList<Ship> ships;
	
	public Player()
	{ this.locked = false; }
	
	public void setLocked()
	{ this.locked = true; }
	
	public boolean isLocked()
	{ return this.locked; }

	public void setUnlocked()
	{ this.locked = false; }
	
	public boolean isUnlocked()
	{ return !this.locked; }

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
