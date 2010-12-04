package br.upe.ecomp.model.factory;

import java.util.ArrayList;
import br.upe.ecomp.enumeration.ShipType;
import br.upe.ecomp.model.AbstractPiece;
import br.upe.ecomp.model.Ship;

public class ShipFactory
{
	public Ship getShip(ShipType type)
	{
		Ship ship;
		
		switch(type)
		{
			case AircraftCarrier:
			{
				ship = new Ship();
				ship.setName("Porta-Aviões");
				ship.setSize(5);
				ship.setHorizontal(0);
				ship.setVertical(0);
				ship.setPieces(new ArrayList<AbstractPiece>());
				return ship;
			}
			case Cruiser:
			{
				ship = new Ship();
				ship.setName("Cruzador");
				ship.setSize(4);
				ship.setHorizontal(0);
				ship.setVertical(0);
				ship.setPieces(new ArrayList<AbstractPiece>());
				return ship;
			}
			case Destroyer:
			{
				ship = new Ship();
				ship.setName("Contratorpedeiro");
				ship.setSize(3);
				ship.setHorizontal(0);
				ship.setVertical(0);
				ship.setPieces(new ArrayList<AbstractPiece>());
				return ship;
			}
			case Submarine:
			{
				ship = new Ship();
				ship.setName("Submarino");
				ship.setSize(2);
				ship.setHorizontal(0);
				ship.setVertical(0);
				ship.setPieces(new ArrayList<AbstractPiece>());
				return ship;
			}
			case Frigate:
			{
				ship = new Ship();
				ship.setName("Fragata");
				ship.setSize(2);
				ship.setHorizontal(0);
				ship.setVertical(0);
				ship.setPieces(new ArrayList<AbstractPiece>());
				return ship;
			}
		}
		throw new IllegalArgumentException("O tipo de navio " + type + " não existe.");
	}
}
