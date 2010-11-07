package br.upe.ecomp.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import br.upe.ecomp.enumeration.PlayerType;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Player;
import br.upe.ecomp.model.factory.ObjectFactory;
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
		Game game = ObjectFactory.createGame();
		Player player = ObjectFactory.createPlayer(PlayerType.Player);
		
		PlayerScreen playerScreen = PlayerScreen.getInstance();
		playerScreen.reset();
		playerScreen.setVisible(true);
		
		if(playerScreen.getPlayerName()!=null)
		{
			player.setName(playerScreen.getPlayerName());
			game.setPlayer(player);
		}
		else
		{ return; }
		
		GameModeController.selectGameMode(game);
		
		if(game.getGameMode()==null)
		{ return; }
		
		ScenarioController.plotShips(game);
		
		if(game.getPlayerScenario()==null)
		{ return; }
	}
}
