package br.upe.ecomp.model.factory;

import br.upe.ecomp.enumeration.PlayerType;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Player;
import br.upe.ecomp.model.Scenario;

public class ObjectFactory
{
	public static Game createGame()
	{
		return new Game();
	}
	
	public static Player createPlayer(PlayerType type)
	{
		return PlayerFactory.getPlayer(type);
	}
	
	public static Scenario createScenario()
	{
		return ScenarioFactory.getScenario();
	}
}
