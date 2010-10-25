package br.upe.ecomp.util;

import br.upe.ecomp.model.Ship;

public class ShipFactory
{
	public enum ShipEnum
	{
		PortaAvioes,
		Cruzador,
		Contratorpedeiro,
		Submarino,
		Fragata;
	}
	
	public static Ship getShip(ShipEnum type)
	{
		Ship ship;
		
		switch(type)
		{
			case PortaAvioes:
				ship = new Ship();
				ship.setName("Porta-Aviões");
				ship.setSize(5);
				return ship;
			case Cruzador:
				ship = new Ship();
				ship.setName("Cruzador");
				ship.setSize(4);
				return ship;
			case Contratorpedeiro:
				ship = new Ship();
				ship.setName("Contratorpedeiro");
				ship.setSize(3);
				return ship;
			case Submarino:
				ship = new Ship();
				ship.setName("Submarino");
				ship.setSize(2);
				return ship;
			case Fragata:
				ship = new Ship();
				ship.setName("Fragata");
				ship.setSize(2);
				return ship;
		}
		throw new IllegalArgumentException("O tipo de navio " + type + " não existe.");
	}
}
