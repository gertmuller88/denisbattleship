package br.upe.ecomp.control;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import br.upe.ecomp.enumeration.ConnectionMode;
import br.upe.ecomp.enumeration.GameMode;
import br.upe.ecomp.enumeration.PlayerType;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Player;
import br.upe.ecomp.model.factory.ObjectFactory;
import br.upe.ecomp.util.Client;
import br.upe.ecomp.util.Connection;
import br.upe.ecomp.util.Server;
import br.upe.ecomp.view.ConnectionModeScreen;
import br.upe.ecomp.view.GameModeScreen;
import br.upe.ecomp.view.ClientScreen;
import br.upe.ecomp.view.MainScreen;
import br.upe.ecomp.view.ServerScreen;

public class GameModeController implements Observer
{
	public static void selectGameMode(Game game)
	{
		GameModeScreen gameModeScreen = GameModeScreen.getInstance();
		gameModeScreen.reset();
		gameModeScreen.setVisible(true);
		
		GameMode gameMode = gameModeScreen.getGameMode();
		
		if(gameMode==GameMode.Singleplayer)
		{ singleplayer(game); }
		else if(gameMode==GameMode.Dualplayer)
		{ dualplayer(game); }
		else
		{ game.setGameMode(null); }
	}
	
	public static void singleplayer(Game game)
	{
		Player opponent = ObjectFactory.createPlayer(PlayerType.Intelligence);
		opponent.setName("Intelligence");
		
		game.setGameMode(GameMode.Singleplayer);
		game.setOpponent(opponent);
		
		return;
	}
	
	public static void dualplayer(Game game)
	{
		ConnectionModeScreen connectionModeScreen = ConnectionModeScreen.getInstance();
		connectionModeScreen.reset();
		connectionModeScreen.setVisible(true);
		
		game.setGameMode(GameMode.Dualplayer);
		
		if(connectionModeScreen.getConnectionMode()==ConnectionMode.Client)
		{ client(game); }
		else if(connectionModeScreen.getConnectionMode()==ConnectionMode.Server)
		{ server(game); }
	}

	public static void client(Game game)
	{
		boolean desconectado = true;
		
		while(desconectado)
		{
			ClientScreen clientScreen = ClientScreen.getInstance();
			clientScreen.reset();
			clientScreen.setVisible(true);
			
			String host = clientScreen.getHost();
			
			if(host==null)
			{ return; }
			else
			{
				try
				{
					Server.registerGameService(game);
					Client.getConnectionTo(host);
					game.setOpponent(Connection.getRemoteGame().getPlayer());
					game.setOpponentScenario(Connection.getRemoteGame().getPlayerScenario());
					desconectado = false;
				}
				catch (NotBoundException e)
				{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), "Houve um problema com a conexão.", "", JOptionPane.ERROR_MESSAGE); }
				catch (UnknownHostException e)
				{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), "O Servidor não foi encontrado.", "", JOptionPane.ERROR_MESSAGE); }
				catch (IOException e)
				{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), e.getMessage(), "", JOptionPane.ERROR_MESSAGE); }
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void server(Game game)
	{
		try
		{
			Server.registerGameService(game);
			
			Thread threadServer = new Thread(new Server(new GameModeController()));
			threadServer.start();
			
			ServerScreen serverScreen = ServerScreen.getInstance();
			serverScreen.setVisible(true);
			
			if(serverScreen.isToStop())
			{ threadServer.stop(); }
			
			if(Connection.getRemoteGame()!=null)
			{
				game.setOpponent(Connection.getRemoteGame().getPlayer());
				game.setOpponentScenario(Connection.getRemoteGame().getPlayerScenario());
			}
		}
		catch (RemoteException e)
		{ e.printStackTrace(); }
	}
	
	public void update(Observable o, Object arg)
	{
		JOptionPane.showMessageDialog(ServerScreen.getInstance(), "O servidor obteve uma conexão.", "", JOptionPane.INFORMATION_MESSAGE);
		
		ServerScreen serverScreen = ServerScreen.getInstance();
		serverScreen.setVisible(false);
		serverScreen.dispose();
	}
}
