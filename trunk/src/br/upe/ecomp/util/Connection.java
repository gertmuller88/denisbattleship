package br.upe.ecomp.util;

public class Connection
{
	private static RemoteGameInterface remoteGame;
	
	public static RemoteGameInterface getRemoteGame()
	{ return remoteGame; }

	public static void setRemoteGame(RemoteGameInterface remoteGame)
	{ Connection.remoteGame = remoteGame; }
}
