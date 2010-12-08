package br.upe.ecomp.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import br.upe.ecomp.enumeration.GameMode;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Intelligence;
import br.upe.ecomp.model.Piece;
import br.upe.ecomp.util.WaitRemoteOpponentUpdate;
import br.upe.ecomp.util.WaitRemoteShipsUpdate;
import br.upe.ecomp.view.GameScreen;
import br.upe.ecomp.view.WaitShipsScreen;
import br.upe.ecomp.view.components.VisualGamePiece;

public class GameController
{
	private Game game;
	private GameScreen gameScreen;
	
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
					if(!playerNextMove(vp.getHorizontal(), vp.getVertical()))
					{
						((Intelligence) game.getOpponent()).chooseNextMove(game.getPlayerScenario());
						
						if(!game.getPlayer().haveShips())
						{
							JOptionPane.showMessageDialog(gameScreen, "Você perdeu!\n \nVocê fez " + game.getPlayer().getScore() + " pontos.", "", JOptionPane.INFORMATION_MESSAGE);
							gameScreen.setVisible(false);
							return;
						}
					}
					else
					{
						if(!game.getOpponent().haveShips())
						{
							JOptionPane.showMessageDialog(gameScreen, "Você ganhou!\n \nVocê fez " + game.getPlayer().getScore() + " pontos.", "", JOptionPane.INFORMATION_MESSAGE);
							gameScreen.setVisible(false);
							return;
						}
					}
				}
				catch (RemoteException e1)
				{ e1.printStackTrace(); }
			}
		};
		
		gameScreen = new GameScreen(game.getOpponentScenario(), listener);
		gameScreen.reset();
		gameScreen.setVisible(true);
	}
	
	public boolean playerNextMove(int x, int y) throws RemoteException
	{
		Piece piece = (Piece) game.getOpponentScenario().getPiece(x, y);
		piece.setDestroyed();
		
		if(piece.isOccupied())
		{
			game.getPlayer().setScore(game.getPlayer().getScore()+100);
			return true;
		}
		else
		{
			game.getPlayer().setScore(game.getPlayer().getScore()-10);
			return false;
		}
	}
	
	public void dualplayer() throws RemoteException
	{
		this.waitShips();
		
		Thread waitThread = new Thread(new WaitRemoteOpponentUpdate());
		waitThread.start();
		
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
		
		GameScreen gameScreen = new GameScreen(this.game.getOpponentScenario(), listener);
		gameScreen.reset();
		gameScreen.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public void waitShips() throws RemoteException
	{
		if(game.getOpponent().getShips().size()<5)
		{
			Thread waitThread = new Thread(new WaitRemoteShipsUpdate(game));
			waitThread.start();
			
			WaitShipsScreen waitShipsScreen = WaitShipsScreen.getInstance();
			waitShipsScreen.setVisible(true);
						
			if(waitShipsScreen.isToStop())
			{
				game.getPlayer().setUnlocked();
				game.getOpponent().setLocked();
				waitThread.stop();
				return;
			}
		}
	}
}
