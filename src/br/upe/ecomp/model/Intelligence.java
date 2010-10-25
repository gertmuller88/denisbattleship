package br.upe.ecomp.model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Intelligence implements Serializable
{
	private Player player;
	
	public Player getPlayer()
	{ return player; }

	public void setPlayer(Player player)
	{ this.player = player; }

	public ArrayList<Ship> posicionarEmbarcacoes(Scene scene)
	{ return null; }
	
	public Piece escolherProximaJogada(Scene scene)
	{ return null; }
}
