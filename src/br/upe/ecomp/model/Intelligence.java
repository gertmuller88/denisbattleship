package br.upe.ecomp.model;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import br.upe.ecomp.enumeration.ShipType;
import br.upe.ecomp.model.factory.ShipFactory;

@SuppressWarnings("serial")
public class Intelligence extends Player implements Serializable
{
    private final ArrayList<Ship> attackingBoat;
    private final ArrayList<AbstractPiece> possibleShot;
    private boolean state;
    private Random random;
    private int size;
    private Scenario scenario;

	
    public Intelligence() {
            super();
            state = false;
            random = new Random();
            possibleShot = new ArrayList<AbstractPiece>();
            attackingBoat = new ArrayList<Ship>();

    }

	public ArrayList<Ship> posicionarEmbarcacoes(Scenario scenario)
	{ 
		this.scenario = scenario;
		// tamanho do cen‡rio 10x10
		//criar um ship
		ArrayList<Ship> ships = new ArrayList<Ship>();
		for(ShipType shipType : ShipType.values()){
			 Ship ship = ShipFactory.getShip(shipType);
			 if (insertShip(random.nextInt(Scenario.COLUMNS), random.nextInt(Scenario.LINES),
                     random.nextBoolean(), ship)) {
				 ships.add(ship);
			 }
		}
		
		
		//escolher dentro do cen‡rio as pieces referente ao tamanho do ship
		//atualizar lista de embarca�›es
		
		return null; 
	}
	
	public AbstractPiece escolherProximaJogada(Scenario scenario)
	{ 
		//scenario Ž o tabuleiro do oponent com as marca�›es das pe�as (destruidas e n‹o destru’das)
		//com base nesse scenario o player vai analisar as pe�as destruidas e preparar movimento
		
		return null; 
		
	}
	


	public boolean checkPosition(final int x, final int y,
			final boolean direction, final Ship ship) {
		if (direction) { //is horizontal
			if (x + ship.getSize() <= size) {
				for (int i = x; i < x + ship.getSize(); i++) {
					for (AbstractPiece piece : scenario.getPieces()) {
						if (((Piece) piece).getHorizontal() == i && 
								((Piece) piece).getVertical() == y){
							if (((Piece) piece).getColor() != Color.BLACK) {
								return false;
							}
						}
					}
				}
				return true;
			} else {
				return false;
			}
		} else { //is vertical
			if (y + ship.getSize() <= size) {
				for (int i = y; i < y + ship.getSize(); i++) {
					for (AbstractPiece piece : scenario.getPieces()) {
						if (((Piece) piece).getHorizontal() == x && 
								((Piece) piece).getVertical() == i){
							if (((Piece) piece).getColor() != Color.BLACK) {
								return false;
							}
						}
					}
				}
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean insertShip(final int x, final int y,
			final boolean direction, final Ship ship) {
		if (checkPosition(x, y, direction, ship)) {
			ArrayList<AbstractPiece> pieces = new ArrayList<AbstractPiece>();
			//ship.setPosition(x, y, direction);
			for (int i = 0; i < ship.getSize(); i++) {
				Piece piece = new Piece();
				if (direction) {
					piece.setHorizontal(x + i);
					piece.setVertical(y);
				} else {
					piece.setHorizontal(x);
					piece.setVertical(y+i);
				}
				piece.setColor(Color.BLACK);
				pieces.add(piece);
			}
			return true;
		}
		return false;
	}


}
