package br.upe.ecomp.util;

import java.rmi.Remote;
import java.rmi.RemoteException;
import br.upe.ecomp.enumeration.GameMode;
import br.upe.ecomp.model.Player;
import br.upe.ecomp.model.Scenario;

public interface RemoteGameInterface extends Remote
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
}
