package br.upe.ecomp.model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import br.upe.ecomp.enumeration.GameMode;

public interface Game extends Remote
{
	public Player getPlayer() throws RemoteException;
	public void setPlayer(Player player) throws RemoteException;
	public Player getOpponent() throws RemoteException;
	public void setOpponent(Player opponent) throws RemoteException;
	public GameMode getGameMode() throws RemoteException;
	public void setGameMode(GameMode gameMode) throws RemoteException;
	public Scenario getPlayerScenario() throws RemoteException;
	public void setPlayerScenario(Scenario playerScenario) throws RemoteException;
	public Scenario getOpponentScenario() throws RemoteException;
	public void setOpponentScenario(Scenario opponentScenario) throws RemoteException;
	public void update(Game game) throws RemoteException;
}
