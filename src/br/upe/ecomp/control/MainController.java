package br.upe.ecomp.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.view.MainScreen;
import br.upe.ecomp.view.SplashScreen;

public class MainController
{
	public void init()
	{
		SplashScreen splashScreen = SplashScreen.getInstance();
		splashScreen.setVisible(true);
		
		MouseAdapter mainListener = new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getComponent().getName().equals("Jogar"))
				{ play(); }
				else if(e.getComponent().getName().equals("Creditos"))
				{ credits(); }
				else if(e.getComponent().getName().equals("Sair"))
				{ System.exit(0); }
			}
		};
		MainScreen mainScreen = MainScreen.getInstance(mainListener);
		
		while(true)
		{
			if(mainScreen!=null)
			{
				mainScreen.setVisible(true);
				splashScreen.setVisible(false);
				break;
			}
		}
	}
	
	public void play()
	{
		GameModeController gameModeController = new GameModeController();
		Game game = gameModeController.init();
		
		System.out.println(game);
	}
	
	public void credits()
	{
		
	}
}
