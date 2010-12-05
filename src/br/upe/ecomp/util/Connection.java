package br.upe.ecomp.util;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import br.upe.ecomp.model.Game;

public class Connection
{
	private static Game remoteGame;
	private static String host;
	
	public static Game getRemoteGame()
	{ return remoteGame; }

	public static void setRemoteGame(Game remoteGame)
	{ Connection.remoteGame = remoteGame; }
	
	public static String getHost()
	{ return host; }
	
	public static void setHost(String host)
	{ Connection.host = host; }
	
	public static void updateGame(Game game) throws RemoteException, MalformedURLException, NotBoundException
	{
		game.setOpponent(Client.lookupGame(Connection.getHost()).getPlayer());
		game.setOpponentScenario(Client.lookupGame(Connection.getHost()).getPlayerScenario());
	}
}
