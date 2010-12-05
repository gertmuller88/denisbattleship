package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class GameScreen extends JDialog
{
	private static GameScreen gameScreen;
	
	private GameScreen()
	{
		super(MainScreen.getInstance(null), true);
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		this.pack();
		this.setSize(610, 380);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static GameScreen getInstance()
	{
		if(gameScreen==null)
		{ gameScreen = new GameScreen(); }
		return gameScreen;
	}
}
