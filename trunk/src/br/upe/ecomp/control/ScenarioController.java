package br.upe.ecomp.control;

import java.rmi.RemoteException;
import br.upe.ecomp.enumeration.ShipType;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.Piece;
import br.upe.ecomp.model.Ship;
import br.upe.ecomp.model.factory.ObjectFactory;
import br.upe.ecomp.view.ScenarioScreen;

public class ScenarioController
{
	public void plotShips(Game game) throws RemoteException
	{
		ObjectFactory of = new ObjectFactory();
		game.setPlayerScenario(of.createScenario());
		
		ScenarioScreen scenarioScreen = ScenarioScreen.getInstance();
		scenarioScreen.reset(game.getPlayerScenario());
		scenarioScreen.unlockShips();
		scenarioScreen.setVisible(true);
		
		if(scenarioScreen.isToPlot())
		{
			this.setShipPieces(ShipType.AircraftCarrier, game);
			this.setShipPieces(ShipType.Cruiser, game);
			this.setShipPieces(ShipType.Destroyer, game);
			this.setShipPieces(ShipType.Submarine, game);
			this.setShipPieces(ShipType.Frigate, game);
		}
		else
		{ return; }
	}
	
	public void setShipPieces(ShipType type, Game game) throws RemoteException
	{
		ScenarioScreen scenarioScreen = ScenarioScreen.getInstance();
		
		ObjectFactory of = new ObjectFactory();
		Ship ship = of.createShip(type);
		
		for(int i=0; i<scenarioScreen.getShipCoordinates(type).size(); i++)
		{
			if((game.getPlayerScenario().getPiece(scenarioScreen.getShipCoordinates(type).get(i).getHorizontal(), scenarioScreen.getShipCoordinates(type).get(i).getVertical()))!=null)
			{
				Piece piece = new Piece();
				piece = (Piece) game.getPlayerScenario().getPiece(scenarioScreen.getShipCoordinates(type).get(i).getHorizontal(), scenarioScreen.getShipCoordinates(type).get(i).getVertical());
				piece.setOccupied();
				ship.getPieces().add(piece);
			}
		}
		
		game.getPlayer().getShips().add(ship);
	}
}
