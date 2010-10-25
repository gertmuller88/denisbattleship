package br.upe.ecomp.view;

import javax.swing.JFrame;

public class MainScreen extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static MainScreen mainScreen;
	
	private MainScreen() {}
	
	public static MainScreen getInstance()
	{
		if(mainScreen==null)
		{ mainScreen = new MainScreen(); }
		return mainScreen;
	}
}
