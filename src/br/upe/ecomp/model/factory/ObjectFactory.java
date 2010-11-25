package br.upe.ecomp.model.factory;

import java.rmi.RemoteException;
import br.upe.ecomp.enumeration.PlayerType;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Player;
import br.upe.ecomp.model.Scenario;

public class ObjectFactory
{
	public static Game createGame()
	{
		try
		{ return new Game(); }
		catch (RemoteException e)
		{ return null; }
	}
	
	public static Player createPlayer(PlayerType type)
	{ return PlayerFactory.getPlayer(type); }
	
	public static Scenario createScenario()
	{ return ScenarioFactory.getScenario(); }
}
