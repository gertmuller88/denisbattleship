package br.upe.ecomp.model.factory;

import br.upe.ecomp.model.Ship;

public class ShipFactory extends ObjectFactory
{
	public enum ShipType
	{
		AircraftCarrier,
		Cruiser,
		Destroyer,
		Submarine,
		Frigate;
	}
	
	public static Ship getShip(ShipType type)
	{
		Ship ship;
		
		switch(type)
		{
			case AircraftCarrier:
				ship = new Ship();
				ship.setName("Porta-Aviões");
				ship.setSize(5);
				return ship;
			case Cruiser:
				ship = new Ship();
				ship.setName("Cruzador");
				ship.setSize(4);
				return ship;
			case Destroyer:
				ship = new Ship();
				ship.setName("Contratorpedeiro");
				ship.setSize(3);
				return ship;
			case Submarine:
				ship = new Ship();
				ship.setName("Submarino");
				ship.setSize(2);
				return ship;
			case Frigate:
				ship = new Ship();
				ship.setName("Fragata");
				ship.setSize(2);
				return ship;
		}
		throw new IllegalArgumentException("O tipo de navio " + type + " não existe.");
	}

	public Ship getNewObject()
	{ return new Ship(); }
}
