package br.upe.ecomp.control;

import java.io.IOException;
import java.rmi.ConnectException;
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
	public void selectGameMode(Game game)
	{
		GameModeScreen gameModeScreen = GameModeScreen.getInstance();
		gameModeScreen.reset();
		gameModeScreen.setVisible(true);
		
		GameMode gameMode = gameModeScreen.getGameMode();
		
		if(gameMode==GameMode.Singleplayer)
		{ this.singleplayer(game); }
		else if(gameMode==GameMode.Dualplayer)
		{ this.dualplayer(game); }
		else
		{ game.setGameMode(null); }
	}
	
	public void singleplayer(Game game)
	{
		Player opponent = ObjectFactory.createPlayer(PlayerType.Intelligence);
		opponent.setName("Intelligence");
		
		game.setGameMode(GameMode.Singleplayer);
		game.setOpponent(opponent);
		
		return;
	}
	
	public void dualplayer(Game game)
	{
		ConnectionModeScreen connectionModeScreen = ConnectionModeScreen.getInstance();
		connectionModeScreen.reset();
		connectionModeScreen.setVisible(true);
		
		game.setGameMode(GameMode.Dualplayer);
		
		if(connectionModeScreen.getConnectionMode()==ConnectionMode.Client)
		{ this.client(game); }
		else if(connectionModeScreen.getConnectionMode()==ConnectionMode.Server)
		{ this.server(game); }
	}

	public void client(Game game)
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
				{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), e.getMessage(), "NotBoundException", JOptionPane.ERROR_MESSAGE); }
				catch (UnknownHostException e)
				{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), e.getMessage(), "UnknownHostException", JOptionPane.ERROR_MESSAGE); }
				catch (IOException e)
				{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), e.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE); }
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void server(Game game)
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
				try
				{
					game.setOpponent(Connection.getRemoteGame().getPlayer());
					game.setOpponentScenario(Connection.getRemoteGame().getPlayerScenario());
				}
				catch (ConnectException e)
				{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), "Houve um problema com a rede e a conexão não pôde ser mantida.", "", JOptionPane.ERROR_MESSAGE); }
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
