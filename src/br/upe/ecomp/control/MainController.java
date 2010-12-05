package br.upe.ecomp.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import br.upe.ecomp.enumeration.GameMode;
import br.upe.ecomp.model.Game;
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
		try
		{
			ObjectFactory of = new ObjectFactory();
			Game game = of.createGame();
			
			PlayerScreen playerScreen = PlayerScreen.getInstance();
			playerScreen.reset();
			playerScreen.setVisible(true);
			
			if(playerScreen.getPlayerName()!=null)
			{ game.getPlayer().setName(playerScreen.getPlayerName()); }
			else
			{ return; }
			
			GameModeController gameModeController = new GameModeController();
			gameModeController.selectGameMode(game);
			
			if(game.getGameMode()==null || game.getOpponent()==null)
			{ return; }
			else if(game.getGameMode()==GameMode.Dualplayer)
			{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), "Você está jogando contra " + game.getOpponent().getName() + ".", "", JOptionPane.INFORMATION_MESSAGE); }
			
			ScenarioController scenarioController = new ScenarioController();
			scenarioController.plotShips(game);
		}
		catch(RemoteException e)
		{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), "Houve um problema com a conexão.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
	}
}
