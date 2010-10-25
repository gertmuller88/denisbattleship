package br.upe.ecomp.model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Player implements Serializable
{
	private String name;
	private int score;
	private ArrayList<Ship> ships;
	
	public String getName()
	{ return name; }
	
	public void setName(String name)
	{ this.name = name; }
	
	public int getScore()
	{ return score; }
	
	public void setScore(int score)
	{ this.score = score; }
	
	public ArrayList<Ship> getShips()
	{ return ships; }
	
	public void setShips(ArrayList<Ship> ships)
	{ this.ships = ships; }
}
