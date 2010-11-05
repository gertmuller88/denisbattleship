package br.upe.ecomp.control;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Player;
import br.upe.ecomp.util.Connection;
import br.upe.ecomp.util.ConnectionManager;
import br.upe.ecomp.util.ConnectionMode;
import br.upe.ecomp.util.GameMode;
import br.upe.ecomp.util.Server;
import br.upe.ecomp.model.Intelligence;
import br.upe.ecomp.view.ConnectionModeScreen;
import br.upe.ecomp.view.GameModeScreen;
import br.upe.ecomp.view.ClientScreen;
import br.upe.ecomp.view.ServerScreen;

public class GameModeController implements Observer
{
	public Game selectGameMode(Game game)
	{
		GameModeScreen gameModeScreen = GameModeScreen.getInstance();
		gameModeScreen.reset();
		gameModeScreen.setVisible(true);
		
		GameMode gameMode = gameModeScreen.getGameMode();
		
		if(gameMode==GameMode.Singleplayer)
		{ return this.singleplayer(game); }
		else if(gameMode==GameMode.Dualplayer)
		{ return this.dualplayer(game); }
		else
		{
			game.setGameMode(null);
			return game;
		}
	}
	
	public Game singleplayer(Game game)
	{
		game.setGameMode(GameMode.Singleplayer);
		
		Intelligence intelligence = new Intelligence();
		intelligence.setName("Intelligence");
		game.setOpponent(intelligence);
		
		return game;
	}
	
	@SuppressWarnings("deprecation")
	public Game dualplayer(Game game)
	{
		game.setGameMode(GameMode.Dualplayer);
		
		ConnectionModeScreen connectionModeScreen = ConnectionModeScreen.getInstance();
		connectionModeScreen.reset();
		connectionModeScreen.setVisible(true);
		
		ConnectionMode connectionMode = connectionModeScreen.getConnectionMode();
		
		if(connectionMode==ConnectionMode.Client)
		{
			while(true)
			{
				try
				{
					ClientScreen clientScreen = ClientScreen.getInstance();
					clientScreen.reset();
					clientScreen.setVisible(true);
					
					String host = clientScreen.getHost();
					
					if(host==null)
					{ break; }
					else
					{
						ConnectionManager.getConnectionTo(host);
						JOptionPane.showMessageDialog(null, "Conexão realizada com êxito.", "", JOptionPane.INFORMATION_MESSAGE);
						
						Connection conn = Connection.getInstance();
						conn.getOut().writeObject(game.getPlayer());
						
						break;
					}
				}
				catch (UnknownHostException e)
				{ JOptionPane.showMessageDialog(null, "O IP digitado é inválido.", "", JOptionPane.ERROR_MESSAGE); }
				catch (IOException e)
				{ JOptionPane.showMessageDialog(null, "O Servidor não pôde ser encontrado.", "", JOptionPane.ERROR_MESSAGE); }
			}
		}
		else if(connectionMode==ConnectionMode.Server)
		{
			Thread server = new Thread(new Server(this));
			server.start();
			
			ServerScreen serverScreen = ServerScreen.getInstance();
			serverScreen.setVisible(true);
			
			if(serverScreen.isToStop())
			{ server.stop(); }
			
			Connection conn = Connection.getInstance();
			try
			{ game.setOpponent((Player) conn.getIn().readObject()); }
			catch (IOException e)
			{ e.printStackTrace(); }
			catch (ClassNotFoundException e)
			{ e.printStackTrace(); }
			
			System.out.println("Jogador: " + game.getPlayer().getName());
			System.out.println("Oponente: " + game.getOpponent().getName());
		}
		else
		{ return null; }
		
		return game;
	}

	public void update(Observable o, Object arg)
	{
		JOptionPane.showMessageDialog(null, "O servidor obteve uma conexão.", "", JOptionPane.INFORMATION_MESSAGE);
		
		ServerScreen serverScreen = ServerScreen.getInstance();
		serverScreen.setVisible(false);
		serverScreen.dispose();
	}
}
