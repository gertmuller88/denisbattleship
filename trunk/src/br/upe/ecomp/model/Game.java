package br.upe.ecomp.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Game implements Serializable
{
	private Player player;
	private Player opponent;
	private Scene playerScene;
	private Scene opponentScene;

	public Player getPlayer()
	{ return player; }

	public void setPlayer(Player player)
	{ this.player = player; }

	public Player getOpponent()
	{ return opponent; }

	public void setOpponent(Player opponent)
	{ this.opponent = opponent; }

	public Scene getPlayerScene()
	{ return playerScene; }

	public void setPlayerScene(Scene playerScene)
	{ this.playerScene = playerScene; }

	public Scene getOpponentScene()
	{ return opponentScene; }

	public void setOpponentScene(Scene opponentScene)
	{ this.opponentScene = opponentScene; }
}
