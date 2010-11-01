package br.upe.ecomp;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import br.upe.ecomp.view.MainScreen;
import br.upe.ecomp.view.SplashScreen;

public class Main
{
	public static void main(String args[])
	{
		try
		{ UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
		catch (ClassNotFoundException e)
		{ e.printStackTrace(); }
		catch (InstantiationException e)
		{ e.printStackTrace(); }
		catch (IllegalAccessException e)
		{ e.printStackTrace(); }
		catch (UnsupportedLookAndFeelException e)
		{ e.printStackTrace(); }
		
		SplashScreen splashScreen = SplashScreen.getInstance();
		splashScreen.setVisible(true);
		
		while(true)
		{
			if(!splashScreen.isVisible())
			{
				MainScreen mainScreen = MainScreen.getInstance();
				mainScreen.setVisible(true);
				break;
			}
		}
	}
}
