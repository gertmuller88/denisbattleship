package br.upe.ecomp.util;

import br.upe.ecomp.model.Game;

public class Connection
{
	private static Game remoteGame;
	
	public static Game getRemoteGame()
	{ return remoteGame; }

	public static void setRemoteGame(Game remoteGame)
	{ Connection.remoteGame = remoteGame; }
}
