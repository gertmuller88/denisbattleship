package br.upe.ecomp.control;

import java.rmi.RemoteException;
import br.upe.ecomp.enumeration.GameMode;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Intelligence;
import br.upe.ecomp.model.Scenario;
import br.upe.ecomp.model.factory.ObjectFactory;
import br.upe.ecomp.view.ScenarioScreen;

public class ScenarioController
{
	public void plotShips(Game game) throws RemoteException
	{
		Scenario scenario = ObjectFactory.createScenario();
		game.setPlayerScenario(scenario);
		
		ScenarioScreen scenarioScreen = ScenarioScreen.getInstance(game.getPlayerScenario());
		scenarioScreen.setVisible(true);
		
		if(game.getGameMode()==GameMode.Singleplayer)
		{ this.singleplayer(game); }
		
		return;
	}
	
	public void singleplayer(Game game) throws RemoteException
	{
		Intelligence intelligence = (Intelligence) game.getOpponent();
		intelligence.posicionarEmbarcacoes(game.getOpponentScenario());
	}
}
