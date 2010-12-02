package br.upe.ecomp.control;

import java.rmi.RemoteException;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Scenario;
import br.upe.ecomp.model.factory.ObjectFactory;
import br.upe.ecomp.view.ScenarioScreen;

public class ScenarioController
{
	public void plotShips(Game game) throws RemoteException
	{
		Scenario scenario = ObjectFactory.createScenario();
		game.setPlayerScenario(scenario);
		
		ScenarioScreen scenarioScreen = ScenarioScreen.getInstance(scenario);
		scenarioScreen.setVisible(true);
		return;
	}
}
