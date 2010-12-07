package br.upe.ecomp.control;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Intelligence;
import br.upe.ecomp.util.WaitRemoteUpdate;
import br.upe.ecomp.view.GameScreen;
import br.upe.ecomp.view.WaitScreen;

public class GameController
{
	@SuppressWarnings("deprecation")
	public void play(Game game) throws RemoteException, MalformedURLException, NotBoundException
	{
		if(game.getOpponent().getShips().size()<5)
		{
			Thread waitThread = new Thread(new WaitRemoteUpdate(game));
			waitThread.start();
			
			WaitScreen waitScreen = WaitScreen.getInstance();
			waitScreen.setVisible(true);
						
			game.getOpponent().setShips(((Intelligence)game.getOpponent()).posicionarEmbarcacoes(game.getOpponentScenario()));
			
			if(waitScreen.isToStop())
			{
				waitThread.stop();
				return;
			}
		}
		
		GameScreen gameScreen = GameScreen.getInstance();
		gameScreen.setVisible(true);
	}
}
