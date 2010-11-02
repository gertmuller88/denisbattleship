package br.upe.ecomp.control;

import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Game.GameMode;
import br.upe.ecomp.view.GameModeScreen;

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
		return new Game();
	}
	
	public Game dualplayer()
	{
		return new Game();
	}
}
