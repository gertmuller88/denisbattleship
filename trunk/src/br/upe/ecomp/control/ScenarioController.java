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
		this.setShipPieces(ShipType.Cruiser, game);
		this.setShipPieces(ShipType.Destroyer, game);
		this.setShipPieces(ShipType.Submarine, game);
		this.setShipPieces(ShipType.Frigate, game);
		
		return;
	}
	
	public void setShipPieces(ShipType type, Game game) throws RemoteException
	{
		ScenarioScreen scenarioScreen = ScenarioScreen.getInstance();
		ArrayList<VisualPlotPiece> visualPieces = scenarioScreen.getShipCoordinates(type);
		
		ObjectFactory of = new ObjectFactory();
		Ship ship = of.createShip(type);
		
		System.out.println(type);
		
		for(int i=0; i<ship.getSize(); i++)
		{
			AbstractPiece ap = game.getPlayerScenario().getPiece(visualPieces.get(i).getHorizontal()+1, visualPieces.get(i).getVertical()+1);
			
			if(ap!=null)
			{
				ship.getPieces().add(ap);
				System.out.println(ship.getPieces().get(i).getHorizontal()+1);
				System.out.println(ship.getPieces().get(i).getVertical()+1);
			}
			
			System.out.println("AP H: " + ap.getHorizontal());
			System.out.println("AP V: " + ap.getVertical());
		}
		
		game.getPlayer().getShips().add(ship);
		System.out.println(game.getPlayer().getShips().size());
		
		return;
	}
}
