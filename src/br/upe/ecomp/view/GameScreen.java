package br.upe.ecomp.view;

import javax.swing.JDialog;

@SuppressWarnings("serial")
public class GameScreen extends JDialog
{
	private static GameScreen gameScreen;
	
	private GameScreen() {}
	
	public GameScreen getInstance()
	{
		if(gameScreen==null)
		{ gameScreen = new GameScreen(); }
		return gameScreen;
	}
}
