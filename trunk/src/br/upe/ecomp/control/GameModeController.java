package br.upe.ecomp.control;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import br.upe.ecomp.enumeration.ConnectionMode;
import br.upe.ecomp.enumeration.GameMode;
import br.upe.ecomp.enumeration.PlayerType;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Player;
import br.upe.ecomp.util.Connection;
import br.upe.ecomp.util.ConnectionManager;
import br.upe.ecomp.util.Server;
import br.upe.ecomp.model.factory.ObjectFactory;
import br.upe.ecomp.view.ConnectionModeScreen;
import br.upe.ecomp.view.GameModeScreen;
import br.upe.ecomp.view.ClientScreen;
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
					ConnectionManager.getConnectionTo(host);
					JOptionPane.showMessageDialog(null, "Conexão realizada com êxito.", "", JOptionPane.INFORMATION_MESSAGE);
					
					Connection conn = Connection.getInstance();
					conn.getOut().writeObject(game.getPlayer());
					
					desconectado = false;
				}
				catch (UnknownHostException e)
				{ JOptionPane.showMessageDialog(null, "O IP digitado é inválido.", "", JOptionPane.ERROR_MESSAGE); }
				catch (IOException e)
				{ JOptionPane.showMessageDialog(null, "O Servidor não pôde ser encontrado.", "", JOptionPane.ERROR_MESSAGE); }
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void server(Game game)
	{
		Thread server = new Thread(new Server(new GameModeController()));
		server.start();
		
		ServerScreen serverScreen = ServerScreen.getInstance();
		serverScreen.setVisible(true);
		
		if(serverScreen.isToStop())
		{ server.stop(); }
		else
		{
			try
			{
				Connection conn = Connection.getInstance();
				game.setOpponent((Player) conn.getIn().readObject());
			}
			catch (IOException e)
			{ e.printStackTrace(); }
			catch (ClassNotFoundException e)
			{ e.printStackTrace(); }
		}
	}
	
	public void update(Observable o, Object arg)
	{
		JOptionPane.showMessageDialog(null, "O servidor obteve uma conexão.", "", JOptionPane.INFORMATION_MESSAGE);
		
		ServerScreen serverScreen = ServerScreen.getInstance();
		serverScreen.setVisible(false);
		serverScreen.dispose();
	}
}
