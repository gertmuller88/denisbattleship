package br.upe.ecomp.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Player;
import br.upe.ecomp.view.MainScreen;
import br.upe.ecomp.view.PlayerScreen;
import br.upe.ecomp.view.SplashScreen;

public class MainController
{
	public void init()
	{
		SplashScreen splashScreen = SplashScreen.getInstance();
		splashScreen.setVisible(true);
		
		MouseAdapter listener = new MouseAdapter()
		{ public void mousePressed(MouseEvent e) { play(); } };
		
		MainScreen mainScreen = MainScreen.getInstance(listener);
		mainScreen.setVisible(true);
	}
	
	public void play()
	{
		PlayerScreen playerScreen = PlayerScreen.getInstance();
		playerScreen.reset();
		playerScreen.setVisible(true);
		
		String playerName = playerScreen.getPlayerName();
		if(playerName==null)
		{ return; }
		
		Game game = new Game();
		
		Player player = new Player();
		player.setName(playerScreen.getPlayerName());
		game.setPlayer(player);
		
		GameModeController gameModeController = new GameModeController();
		game = gameModeController.selectGameMode(game);
		
		if(game.getGameMode()==null)
		{ return; }
		
		ScenarioController scenarioController = new ScenarioController();
		game = scenarioController.plotShips(game);
		
		if(game.getPlayerScenario()==null)
		{ return; }
	}
}
