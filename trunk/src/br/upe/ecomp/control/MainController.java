package br.upe.ecomp.control;

import br.upe.ecomp.model.Game;

public class MainController
{
	public void play()
	{
		GameModeController gameModeController = new GameModeController();
		Game game = gameModeController.select();
		
		try
		{
			if(game.getGameMode()==null)
			{ return; }
		}
		catch (NullPointerException e)
		{ System.out.println("passou pelo catch!");return; }
	}
}
