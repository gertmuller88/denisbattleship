package br.upe.ecomp.view;

import javax.swing.JWindow;

public class SplashScreen extends JWindow
{
	private static final long serialVersionUID = 1L;
	private static SplashScreen splashScreen;
	
	public SplashScreen() {}
	
	public static SplashScreen getInstance()
	{
		if(splashScreen==null)
		{ splashScreen = new SplashScreen(); }
		return splashScreen;
	}
}
