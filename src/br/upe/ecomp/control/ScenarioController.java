package br.upe.ecomp.control;

import java.rmi.RemoteException;
import java.util.ArrayList;
import br.upe.ecomp.enumeration.ShipType;
import br.upe.ecomp.model.AbstractPiece;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Ship;
import br.upe.ecomp.model.factory.ObjectFactory;
import br.upe.ecomp.view.ScenarioScreen;
import br.upe.ecomp.view.components.VisualPlotPiece;

public class ScenarioController
{
	public void plotShips(Game game) throws RemoteException
	{
		ObjectFactory of = new ObjectFactory();
		game.setPlayerScenario(of.createScenario());
		
		ScenarioScreen scenarioScreen = ScenarioScreen.getInstance();
		scenarioScreen.setVisible(true);
		
		this.setShipPieces(ShipType.AircraftCarrier, game);
		/*this.setShipPieces(ShipType.Cruiser, game);
		this.setShipPieces(ShipType.Destroyer, game);
		this.setShipPieces(ShipType.Submarine, game);
		this.setShipPieces(ShipType.Frigate, game);*/
		
		return;
	}
	
	public void setShipPieces(ShipType type, Game game) throws RemoteException
	{
		ScenarioScreen scenarioScreen = ScenarioScreen.getInstance();
		ArrayList<VisualPlotPiece> visualPieces = scenarioScreen.getShipCoordinates(type);
		
		for(int i=0; i<visualPieces.size(); i++)
		{
			System.out.println(visualPieces.get(i).getHorizontal());
			System.out.println(visualPieces.get(i).getVertical());
		}
		
		return;
	}
}
