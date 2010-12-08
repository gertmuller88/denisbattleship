package br.upe.ecomp.util;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Piece;
import br.upe.ecomp.view.ScenarioScreen;
import br.upe.ecomp.view.ServerScreen;
import br.upe.ecomp.view.components.VisualPlotPiece;

public class WaitRemoteOpponentUpdate implements Runnable
{
	ImageIcon imageFire = new ImageIcon("images/ships/fire.png");
	ImageIcon imageWater = new ImageIcon("images/ships/water.png");
	
	public void run()
	{
		while(true)
		{
			try
			{
				Game game = Client.lookupGame(Connection.getHost());
				ArrayList<VisualPlotPiece> vp = ScenarioScreen.getInstance().getPieces();
				
				for(int i=0; i<game.getOpponentScenario().getPieces().size(); i++)
				{
					if(((Piece) game.getOpponentScenario().getPieces().get(i)).isDestroyed() && ((Piece) game.getOpponentScenario().getPieces().get(i)).isOccupied())
					{
						vp.get(i).getPicBackground().setIcon(imageFire);
					}
					
					if(((Piece) game.getOpponentScenario().getPieces().get(i)).isDestroyed() && ((Piece) game.getOpponentScenario().getPieces().get(i)).isUnoccupied())
					{
						vp.get(i).getPicBackground().setIcon(imageWater);
					}
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
