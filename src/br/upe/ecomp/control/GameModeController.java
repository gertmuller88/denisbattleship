package br.upe.ecomp.control;

import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.util.DualplayerMode;
import br.upe.ecomp.util.GameMode;
import br.upe.ecomp.model.Intelligence;
import br.upe.ecomp.net.ConnectionManager;
import br.upe.ecomp.view.ClientServerScreen;
import br.upe.ecomp.view.GameModeScreen;
import br.upe.ecomp.view.IPScreen;

public class GameModeController
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
		
		ClientServerScreen clientServerScreen = ClientServerScreen.getInstance();
		clientServerScreen.reset();
		clientServerScreen.setVisible(true);
		
		DualplayerMode dualplayerMode = clientServerScreen.getDualplayerMode();
		
		if(dualplayerMode==DualplayerMode.Client)
		{
			while(true)
			{
				try
				{
					IPScreen ipScreen = IPScreen.getInstance();
					ipScreen.reset();
					ipScreen.setVisible(true);
					
					String host = ipScreen.getIP();
					
					if(host==null)
					{ break; }
					else
					{
						System.out.println(host);
						ConnectionManager connectionManager = new ConnectionManager();
						connectionManager.getConnectionTo(host);
						JOptionPane.showMessageDialog(null, "Conexão realizada com êxito.", "Conexão", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}
				catch (UnknownHostException e)
				{ JOptionPane.showMessageDialog(null, "O IP digitado é inválido.", "Erro", JOptionPane.ERROR_MESSAGE); }
				catch (IOException e)
				{ JOptionPane.showMessageDialog(null, "O Servidor não pôde ser encontrado.", "Erro", JOptionPane.ERROR_MESSAGE); }
			}
		}
		else if(dualplayerMode==DualplayerMode.Server)
		{  }
		else
		{ return null; }
		
		return game;
	}
}
