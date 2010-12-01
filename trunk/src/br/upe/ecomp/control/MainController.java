package br.upe.ecomp.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import br.upe.ecomp.enumeration.PlayerType;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Player;
import br.upe.ecomp.model.factory.ObjectFactory;
import br.upe.ecomp.util.Connection;
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
		
		GameModeController gameModeController = new GameModeController();
		gameModeController.selectGameMode(game);
		
		if(game.getGameMode()==null || Connection.getRemoteGame()==null)
		{ return; }
		
		try
		{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), "Você está jogando contra " + Connection.getRemoteGame().getPlayer().getName() + ".", "", JOptionPane.INFORMATION_MESSAGE); }
		catch(RemoteException e)
		{ e.printStackTrace(); }
		
		ScenarioController.plotShips(game);
	}
}
