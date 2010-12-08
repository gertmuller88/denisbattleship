package br.upe.ecomp.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import br.upe.ecomp.enumeration.GameMode;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Intelligence;
import br.upe.ecomp.model.Piece;
import br.upe.ecomp.util.Connection;
import br.upe.ecomp.util.WaitRemoteShipsUpdate;
import br.upe.ecomp.view.GameScreen;
import br.upe.ecomp.view.WaitShipsScreen;
import br.upe.ecomp.view.components.VisualGamePiece;

public class GameController
{
	private Game game;
	
	public void managePlay(Game game) throws RemoteException, MalformedURLException, NotBoundException
	{
		this.game = game;
		
		if(game.getGameMode()==GameMode.Singleplayer)
		{ this.singleplayer(); }
		else if(game.getGameMode()==GameMode.Dualplayer)
		{ this.dualplayer(); }
		else
		{ return; }
	}
	
	public void singleplayer() throws RemoteException
	{
		MouseAdapter listener = new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				VisualGamePiece vp = (VisualGamePiece) e.getComponent().getParent();
				try
				{
					((Piece) game.getOpponentScenario().getPiece(vp.getHorizontal(), vp.getVertical())).setDestroyed();
					((Intelligence) game.getOpponent()).chooseNextMove(game.getPlayerScenario());
					
					for(int i=0; i<game.getPlayer().getShips().size(); i++)
					{
						System.out.print(game.getPlayer().getShips().get(i).getName());
						for(int j=0; j<game.getPlayer().getShips().get(i).getPieces().size(); j++)
						{
							System.out.println(": " + ((Piece) game.getPlayer().getShips().get(i).getPieces().get(j)).getState().getClass().getName());
							System.out.println(" ");
						}
					}
				}
				catch (RemoteException e1)
				{ e1.printStackTrace(); }
			}
		};
		
		GameScreen gameScreen = GameScreen.getInstance(game.getOpponentScenario(), listener);
		gameScreen.reset();
		gameScreen.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public void dualplayer() throws RemoteException
	{
		if(game.getOpponent().getShips().size()<5)
		{
			Thread waitThread = new Thread(new WaitRemoteShipsUpdate(game));
			waitThread.start();
			
			WaitShipsScreen waitShipsScreen = WaitShipsScreen.getInstance();
			waitShipsScreen.setVisible(true);
						
			if(waitShipsScreen.isToStop())
			{
				waitThread.stop();
				return;
			}
			
			try
			{
				Connection.updateGame(game);
			}
			catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		MouseAdapter listener = new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				VisualGamePiece vp = (VisualGamePiece) e.getComponent().getParent();
				try
				{
					((Piece) game.getOpponentScenario().getPiece(vp.getHorizontal(), vp.getVertical())).setDestroyed();
				}
				catch (RemoteException e1)
				{ e1.printStackTrace(); }
			}
		};
		
		GameScreen gameScreen = new GameScreen(game.getOpponentScenario(), listener);
		gameScreen.reset();
		gameScreen.setVisible(true);
	}
}
