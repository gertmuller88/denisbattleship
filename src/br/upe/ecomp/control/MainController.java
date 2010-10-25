package br.upe.ecomp.control;

import br.upe.ecomp.view.MainScreen;
import br.upe.ecomp.view.SplashScreen;

public class MainController
{
	public void init()
	{
		SplashScreen splashScreen = SplashScreen.getInstance();
		splashScreen.setVisible(true);
		
		MainScreen mainScreen = MainScreen.getInstance();
		
		while(true)
		{
			if(mainScreen!=null)
			{
				splashScreen.setVisible(false);
				mainScreen.setVisible(true);
				break;
			}
		}
	}
}
