package br.upe.ecomp.util;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.view.ServerScreen;
import br.upe.ecomp.view.WaitScreen;

public class WaitRemoteUpdate implements Runnable
{
	public Game game;
	
	public WaitRemoteUpdate(Game game)
	{ this.game = game; }
	
	public void run()
	{
		while(true)
		{
			try
			{
				Connection.updateGame(game);
				
				if(game.getOpponent().getShips().size()>=5)
				{
					WaitScreen.getInstance().setVisible(false);
					break;
				}
			}
			catch(MalformedURLException e)
			{ JOptionPane.showMessageDialog(ServerScreen.getInstance(), "O IP digitado é inválido.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
			catch(RemoteException e)
			{ JOptionPane.showMessageDialog(ServerScreen.getInstance(), "Houve um problema com a conexão.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
			catch (NotBoundException e)
			{ JOptionPane.showMessageDialog(ServerScreen.getInstance(), "O serviço solicitado não está disponível.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
		}
	}
}
