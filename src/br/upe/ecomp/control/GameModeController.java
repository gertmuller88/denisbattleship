package br.upe.ecomp.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.view.GameModeScreen;

public class GameModeController
{
	private Game game;
	
	public Game init()
	{
		MouseAdapter gameModeListener = new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getComponent().getName().equals("Singleplayer"))
				{ game = singleplayer(); }
				else if(e.getComponent().getName().equals("Dualplayer"))
				{ game = dualplayer(); }
				else if(e.getComponent().getName().equals("Sair"))
				{ System.exit(0); }
			}
		};		
		GameModeScreen gameModeScreen = GameModeScreen.getInstance(gameModeListener);
		gameModeScreen.setVisible(true);
		
		return game;
	}
	
	public Game singleplayer()
	{
		return null;
	}
	
	public Game dualplayer()
	{
		return null;
	}
}
