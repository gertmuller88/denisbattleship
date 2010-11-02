package br.upe.ecomp.control;

import br.upe.ecomp.model.Game;

public class MainController
{
	public void play()
	{
		GameModeController gameModeController = new GameModeController();
		Game game = gameModeController.select();
		
		if(game==null)
		{ return; }
		
		ScenarioController scenarioController = new ScenarioController();
		game = scenarioController.plotShips(game);
		
		if(game.getPlayerScenario()==null)
		{ return; }
	}
}
