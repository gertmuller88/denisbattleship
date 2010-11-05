package br.upe.ecomp.model.factory;

import br.upe.ecomp.model.Game;

public class GameFactory extends ObjectFactory
{
	public enum GameMode
	{
		Singleplayer,
		Dualplayer;
	}
	
	public Game getNewObject()
	{ return new Game(); }
}
