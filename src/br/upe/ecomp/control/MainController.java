package br.upe.ecomp.control;

import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Player;
import br.upe.ecomp.view.PlayerScreen;

public class MainController
{
	public void play()
	{
		Game game = new Game();
		
		PlayerScreen playerScreen = PlayerScreen.getInstance();
		playerScreen.reset();
		playerScreen.setVisible(true);
		String playerName = playerScreen.getPlayerName();
		
		if(playerName==null)
		{ return; }
		
		Player player = new Player();
		player.setName(playerScreen.getPlayerName());
		game.setPlayer(player);
		
		GameModeController gameModeController = new GameModeController();
		game = gameModeController.select(game);
		
		if(game.getGameMode()==null)
		{ return; }
		
		ScenarioController scenarioController = new ScenarioController();
		game = scenarioController.plotShips(game);
		
		if(game.getPlayerScenario()==null)
		{ return; }
	}
}
