package br.upe.ecomp.view;

import javax.swing.JWindow;

@SuppressWarnings("serial")
public class SplashScreen extends JWindow
{
	private static SplashScreen splashScreen;
	
	public SplashScreen() {}
	
	public static SplashScreen getInstance()
	{
		if(splashScreen==null)
		{ splashScreen = new SplashScreen(); }
		return splashScreen;
	}
}
