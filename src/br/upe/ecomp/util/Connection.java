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
		game.update(Client.lookupGame(host));
	}
	
	public static void updateShips(Game game) throws RemoteException, MalformedURLException, NotBoundException
	{
		game.setOpponent(Client.lookupGame(host).getPlayer());
		game.setOpponentScenario(Client.lookupGame(host).getPlayerScenario());
	}
}
