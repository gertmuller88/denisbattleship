package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameModeScreen extends JFrame
{
	private static GameModeScreen gameModeScreen;
	
	private Container container;
	
	private GameModeScreen(MouseAdapter mouseAdapter)
	{
		super("Escolha o Modo de Jogo - Denis' BattleShip (EComp/UPE)");
		
		container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		this.pack();
		this.setSize(450, 150);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static GameModeScreen getInstance(MouseAdapter mouseAdapter)
	{
		if(gameModeScreen==null)
		{ gameModeScreen = new GameModeScreen(mouseAdapter); }
		return gameModeScreen;
	}
}
