package br.upe.ecomp.control;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.util.DualplayerMode;
import br.upe.ecomp.util.GameMode;
import br.upe.ecomp.model.Intelligence;
import br.upe.ecomp.net.ConnectionManager;
import br.upe.ecomp.net.Server;
import br.upe.ecomp.view.DualplayerModeScreen;
import br.upe.ecomp.view.GameModeScreen;
import br.upe.ecomp.view.ClientScreen;
import br.upe.ecomp.view.ServerScreen;

public class GameModeController implements Observer
{
	public Game select()
	{
		GameModeScreen gameModeScreen = GameModeScreen.getInstance();
		gameModeScreen.reset();
		gameModeScreen.setVisible(true);
		
		GameMode gameMode = gameModeScreen.getGameMode();
		
		if(gameMode==GameMode.Singleplayer)
		{ return this.singleplayer(); }
		else if(gameMode==GameMode.Dualplayer)
		{ return this.dualplayer(); }
		else
		{ return null; }
	}
	
	public Game singleplayer()
	{
		Game game = new Game();
		game.setGameMode(GameMode.Singleplayer);
		
		Intelligence intelligence = new Intelligence();
		game.setOpponent(intelligence);
		
		return game;
	}
	
	public Game dualplayer()
	{
		Game game = new Game();
		game.setGameMode(GameMode.Dualplayer);
		
		DualplayerModeScreen dualplayerModeScreen = DualplayerModeScreen.getInstance();
		dualplayerModeScreen.reset();
		dualplayerModeScreen.setVisible(true);
		
		DualplayerMode dualplayerMode = dualplayerModeScreen.getDualplayerMode();
		
		if(dualplayerMode==DualplayerMode.Client)
		{
			while(true)
			{
				try
				{
					ClientScreen clientScreen = ClientScreen.getInstance();
					clientScreen.reset();
					clientScreen.setVisible(true);
					
					String host = clientScreen.getIP();
					
					if(host==null)
					{ break; }
					else
					{
						ConnectionManager connectionManager = new ConnectionManager();
						connectionManager.getConnectionTo(host);
						JOptionPane.showMessageDialog(null, "Conexão realizada com êxito.", "", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}
				catch (UnknownHostException e)
				{ JOptionPane.showMessageDialog(null, "O IP digitado é inválido.", "", JOptionPane.ERROR_MESSAGE); }
				catch (IOException e)
				{ 
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "O Servidor não pôde ser encontrado.", "", JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
		}
		else if(dualplayerMode==DualplayerMode.Server)
		{
			Thread server = new Thread(new Server(this));
			server.start();
			
			ServerScreen serverScreen = ServerScreen.getInstance();
			serverScreen.setVisible(true);
			
			if(serverScreen.isStopped())
			{ server.interrupt(); }
		}
		else
		{ return null; }
		
		return game;
	}

	public void update(Observable o, Object arg)
	{
		System.out.println("Este método foi executado.");
		JOptionPane.showMessageDialog(null, "O servidor obteve uma conexão.", "", JOptionPane.INFORMATION_MESSAGE);
		
		ServerScreen serverScreen = ServerScreen.getInstance();
		serverScreen.setVisible(false);
		serverScreen.dispose();
	}
}
