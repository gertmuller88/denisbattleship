package br.upe.ecomp.model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import br.upe.ecomp.enumeration.GameMode;

@SuppressWarnings("serial")
public class GameImpl extends UnicastRemoteObject implements Game
{
	private Player player;
	private Player opponent;
	private GameMode gameMode;
	private Scenario playerScenario;
	private Scenario opponentScenario;
	
	public GameImpl() throws RemoteException {}

	public Player getPlayer()
	{ return this.player; }

	public void setPlayer(Player player)
	{ this.player = player; }

	public Player getOpponent()
	{ return this.opponent; }

	public void setOpponent(Player opponent)
	{ this.opponent = opponent; }
	
	public GameMode getGameMode()
	{ return this.gameMode; }
	
	public void setGameMode(GameMode gameMode)
	{ this.gameMode = gameMode; }

	public Scenario getPlayerScenario()
	{ return this.playerScenario; }

	public void setPlayerScenario(Scenario playerScenario)
	{ this.playerScenario = playerScenario; }

	public Scenario getOpponentScenario()
	{ return this.opponentScenario; }

	public void setOpponentScenario(Scenario opponentScenario)
	{ this.opponentScenario = opponentScenario; }

	public void update(Game game) throws RemoteException
	{
		Player player = game.getPlayer();
		Player opponent = game.getOpponent();
		Scenario playerScenario = game.getPlayerScenario();
		Scenario opponentScenario = game.getOpponentScenario();
		
		this.player.update(player);
		this.opponent.update(opponent);
		this.playerScenario.update(playerScenario);
		this.opponentScenario.update(opponentScenario);
	}
}
