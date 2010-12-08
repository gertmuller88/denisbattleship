package br.upe.ecomp.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import br.upe.ecomp.enumeration.GameMode;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Piece;
import br.upe.ecomp.model.Scenario;
import br.upe.ecomp.util.WaitRemoteShipsUpdate;
import br.upe.ecomp.view.GameScreen;
import br.upe.ecomp.view.WaitShipsScreen;
import br.upe.ecomp.view.components.VisualGamePiece;

public class GameController
{
	private Scenario opponentScenario;
	
	public void managePlay(Game game) throws RemoteException, MalformedURLException, NotBoundException
	{
		this.opponentScenario = game.getOpponentScenario();
		
		if(game.getGameMode()==GameMode.Singleplayer)
		{ this.singleplayer(game); }
		else if(game.getGameMode()==GameMode.Dualplayer)
		{ this.dualplayer(game); }
		else
		{ return; }
	}
	
	public void singleplayer(Game game) throws RemoteException
	{
		MouseAdapter listener = new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				VisualGamePiece vp = (VisualGamePiece) e.getComponent().getParent();
				((Piece) opponentScenario.getPiece(vp.getHorizontal(), vp.getVertical())).setDestroyed();
			}
		};
		
		GameScreen gameScreen = GameScreen.getInstance(game.getOpponentScenario(), listener);
		gameScreen.reset();
		gameScreen.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public void dualplayer(Game game) throws RemoteException
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
		}
		
		MouseAdapter listener = new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				VisualGamePiece vp = (VisualGamePiece) e.getComponent().getParent();
				((Piece) opponentScenario.getPiece(vp.getHorizontal(), vp.getVertical())).setDestroyed();
			}
		};
		
		GameScreen gameScreen = new GameScreen(game.getOpponentScenario(), listener);
		gameScreen.reset();
		gameScreen.setVisible(true);
	}
}
