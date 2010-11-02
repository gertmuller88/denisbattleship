package br.upe.ecomp.control;

import br.upe.ecomp.model.Game;

public class MainController
{
	public void play()
	{
		GameModeController gameModeController = new GameModeController();
		Game game = gameModeController.init();
		
		System.out.println(game);
	}
}
