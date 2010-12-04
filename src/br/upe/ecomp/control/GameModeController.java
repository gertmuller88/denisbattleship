package br.upe.ecomp.control;

import java.io.IOException;
import java.net.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import br.upe.ecomp.enumeration.ConnectionMode;
import br.upe.ecomp.enumeration.GameMode;
import br.upe.ecomp.model.Game;
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
	public void selectGameMode(Game game) throws RemoteException
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
	
	public void singleplayer(Game game) throws RemoteException
	{
		ObjectFactory of = new ObjectFactory();
		game.setOpponent(of.createIntelligence());
		game.getOpponent().setName("Intelligence");
		game.setGameMode(GameMode.Singleplayer);
	}
	
	public void dualplayer(Game game) throws RemoteException
	{
		ConnectionModeScreen connectionModeScreen = ConnectionModeScreen.getInstance();
		connectionModeScreen.reset();
		connectionModeScreen.setVisible(true);
		
		if(connectionModeScreen.getConnectionMode()==ConnectionMode.Client)
		{ this.client(game); }
		else if(connectionModeScreen.getConnectionMode()==ConnectionMode.Server)
		{ this.server(game); }
		
		game.setGameMode(GameMode.Dualplayer);
	}

	public void client(Game game)
	{
		boolean disconnected = true;
		
		while(disconnected)
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
					disconnected = false;
				}
				catch(RemoteException e)
				{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), "Houve um problema com a conexão.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
				catch(NotBoundException e)
				{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), "O serviço solicitado não está disponível.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
				catch(ConnectException e)
				{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), "O IP digitado não foi encontrado na rede.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
				catch(IOException e)
				{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), "Houve um problema no fluxo de entrada/saída da conexão.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void server(Game game)
	{
		try
		{
			Server.registerGameService(game);
			
			Thread threadServer = new Thread(new Server(this));
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
		catch(RemoteException e)
		{ JOptionPane.showMessageDialog(MainScreen.getInstance(null), "Houve um problema com a conexão.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
	}
	
	public void update(Observable o, Object arg)
	{
		JOptionPane.showMessageDialog(ServerScreen.getInstance(), "O servidor obteve uma conexão.", "", JOptionPane.INFORMATION_MESSAGE);
		
		ServerScreen serverScreen = ServerScreen.getInstance();
		serverScreen.setVisible(false);
		serverScreen.dispose();
	}
}
