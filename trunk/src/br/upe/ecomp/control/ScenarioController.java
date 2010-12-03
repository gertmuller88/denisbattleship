package br.upe.ecomp.control;

import java.rmi.RemoteException;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.factory.ObjectFactory;
import br.upe.ecomp.view.ScenarioScreen;

public class ScenarioController
{
	public void plotShips(Game game) throws RemoteException
	{
		game.setPlayerScenario(ObjectFactory.createScenario());
		
		ScenarioScreen scenarioScreen = ScenarioScreen.getInstance(game.getPlayerScenario());
		scenarioScreen.setVisible(true);
		
		return;
	}
}
