package br.upe.ecomp.model;

import java.io.Serializable;
import br.upe.ecomp.model.factory.GameFactory.GameMode;

@SuppressWarnings("serial")
public class Game implements Serializable
{
	private Player player;
	private Player opponent;
	private GameMode gameMode;
	private Scenario playerScenario;
	private Scenario opponentScenario;
	
	public Player getPlayer()
	{ return player; }

	public void setPlayer(Player player)
	{ this.player = player; }

	public Player getOpponent()
	{ return opponent; }

	public void setOpponent(Player opponent)
	{ this.opponent = opponent; }
	
	public GameMode getGameMode()
	{ return gameMode; }
	
	public void setGameMode(GameMode gameMode)
	{ this.gameMode = gameMode; }

	public Scenario getPlayerScenario()
	{ return playerScenario; }

	public void setPlayerScenario(Scenario playerScenario)
	{ this.playerScenario = playerScenario; }

	public Scenario getOpponentScenario()
	{ return opponentScenario; }

	public void setOpponentScenario(Scenario opponentScenario)
	{ this.opponentScenario = opponentScenario; }
}