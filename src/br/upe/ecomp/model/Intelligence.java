package br.upe.ecomp.model;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import br.upe.ecomp.enumeration.ShipType;
import br.upe.ecomp.model.factory.ShipFactory;

@SuppressWarnings("serial")
public class Intelligence extends Player implements Serializable {
	private ArrayList<Ship> attackingBoat;
	private ArrayList<AbstractPiece> possibleShot;
	private ArrayList<AbstractPiece> shootedPieces;
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

	public ArrayList<Ship> posicionarEmbarcacoes(Scenario scenario) {
		this.scenario = scenario;
		// tamanho do cen�rio 10x10
		ArrayList<Ship> ships = new ArrayList<Ship>();
		for (ShipType shipType : ShipType.values()) {
			// criar um ship
			Ship ship = ShipFactory.getShip(shipType);
			// escolher dentro do cen�rio as pieces referente ao tamanho do ship
			if (insertShip(random.nextInt(Scenario.COLUMNS),
					random.nextInt(Scenario.LINES), random.nextBoolean(), ship)) {
				// atualizar lista de embarca��es
				System.out.println("ship pieces: " + ship.getPieces().size());
				ships.add(ship);
			}
		}
		

		if (shootedPieces == null) {
			shootedPieces = new ArrayList<AbstractPiece>();
		}


		return ships;
	}

	public AbstractPiece escolherProximaJogada(Scenario scenario) {
		// scenario � o tabuleiro do oponent com as marca��es das pe�as
		// (destruidas e n�o destru�das)
		// com base nesse scenario o player vai analisar as pe�as destruidas e
		// preparar movimento

		AbstractPiece shootPiece = null;

		if (!shootedPieces.isEmpty()) {
			makeMove(scenario, shootPiece);
		} else {
			shootPiece = choosePieceRandom();
			shootedPieces.add(shootPiece);

		}
		return shootPiece;

	}
	
	public Scenario getScenario(){
		return this.scenario;
	}

	private boolean checkPosition(final int x, final int y,
			final boolean direction, final Ship ship) {
		if (direction) { // is horizontal
			if (x + ship.getSize() <= size) {
				for (int i = x; i < x + ship.getSize(); i++) {
					for (AbstractPiece piece : scenario.getPieces()) {
						if (((Piece) piece).getHorizontal() == i
								&& ((Piece) piece).getVertical() == y) {
							if (((Piece) piece).getColor() != Color.BLUE) {
								return false;
							}
						}
					}
				}
				return true;
			} else {
				return false;
			}
		} else { // is vertical
			if (y + ship.getSize() <= size) {
				for (int i = y; i < y + ship.getSize(); i++) {
					for (AbstractPiece piece : scenario.getPieces()) {
						if (((Piece) piece).getHorizontal() == x
								&& ((Piece) piece).getVertical() == i) {
							if (((Piece) piece).getColor() != Color.BLUE) {
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

	private boolean insertShip(final int x, final int y,
			final boolean direction, final Ship ship) {
		if (checkPosition(x, y, direction, ship)) {
			ArrayList<AbstractPiece> pieces = new ArrayList<AbstractPiece>();
			// ship.setPosition(x, y, direction);
			for (int i = 0; i < ship.getSize(); i++) {
				Piece piece = new Piece();
				if (direction) {
					piece.setHorizontal(x + i);
					piece.setVertical(y);
				} else {
					piece.setHorizontal(x);
					piece.setVertical(y + i);
				}
				piece.setColor(Color.ORANGE);
				pieces.add(piece);
			}
			ship.setPieces(pieces);
			return true;
		}
		return false;
	}

	private AbstractPiece choosePieceRandom() {
		AbstractPiece piece = new Piece();
		((Piece) piece).setHorizontal(random.nextInt(Scenario.COLUMNS));
		((Piece) piece).setVertical(random.nextInt(Scenario.LINES));
		return piece;
	}
	
	private boolean makeMove(Scenario board, AbstractPiece piece) {
		System.out.println("AI");
		boolean hit;

		if (state) {
			System.out.println(shootedPieces); // attackingBoat
			if (shootedPieces.size() == 1) {
				piece = getNeighbour();
				if (getNeighbour() != null && isShotable(getNeighbour()) != -1) {
					possibleShot.remove(isShotable(getNeighbour()));
					hit = board.shot(((Piece)piece).getHorizontal(), ((Piece)piece).getVertical());
					if (hit) {
						((Piece) piece).setDestroyed();
						shootedPieces.add(piece);
						if ((getDirection() && ((Piece) shootedPieces.get(0))
								.getVertical() > ((Piece) shootedPieces.get(1))
								.getVertical())
								|| !getDirection()
								&& ((Piece) shootedPieces.get(0))
										.getHorizontal() > ((Piece) shootedPieces
										.get(1)).getHorizontal()) {
							shootedPieces.add(shootedPieces.remove(0));

						}
						//firePlayerMakeMoved();
						return true;
					} else {// /not hit
						//firePlayerMakeMoved();
						return false;
					}
				} else {
					state = false;
					makeMove(board, piece);

				}

			} else {// +1
				piece = getPiecePoint();
				checkAndRemove();
				System.out.println("piece:" + piece);
				if (piece != null) {
					piece = possibleShot.remove(isShotable(((Piece)piece)));
					hit = board.shot(((Piece)piece).getHorizontal(), ((Piece)piece).getVertical());
					if (hit) {
						//firePlayerMakeMoved();
						((Piece) piece).setDestroyed();
						return true;
					} else {
						if (((Piece)piece).getHorizontal() == ((Piece)shootedPieces.get(0)).getHorizontal()
								&& ((Piece)piece).getVertical() == ((Piece)shootedPieces.get(0)).getVertical()) {
							shootedPieces.remove(0);
						} else {
							shootedPieces.remove(shootedPieces.size() - 1);
						}
						//firePlayerMakeMoved();
						return false;
					}

				} else { // p == null
					state = false;
				}
			}
		}

		if (!state) {
			int index = random.nextInt(possibleShot.size());
			piece = (Piece) possibleShot.remove(index);
			hit = board.shot(((Piece)piece).getHorizontal(), ((Piece)piece).getVertical());
			//firePlayerMakeMoved();
			if (hit) {
				state = true;
				shootedPieces.clear();
				shootedPieces.add(piece);
				return true;
			}
			return false;
		}

		return false;
	}

	private boolean isLegalPoint(Piece p) {
		return (p.getHorizontal() > 0 && p.getHorizontal() < size
				&& p.getVertical() > 0 && p.getVertical() < size);
	}

	private Piece getPiecePoint() {
		Piece p = null;
		if (getDirection()) {
			p = (Piece)shootedPieces.get(0);
			int y = p.getVertical();
			y -= 1;
			p.setVertical(y);
			if (isShotable(p) != -1 && isLegalPoint(p)) {
				shootedPieces.add(0, p);
				return p;
			} else {
				p = (Piece)shootedPieces.get(shootedPieces.size() - 1);
				y = p.getVertical();
				y += 1;
				p.setVertical(y);
				if (isShotable(p) != -1 && isLegalPoint(p)) {
					shootedPieces.add(p);
					return p;
				} else {
					return null;
				}
			}
		} else {
			p = (Piece)shootedPieces.get(0);
			int x = p.getHorizontal();
			x -= 1;
			p.setHorizontal(x);
			if (isShotable(p) != -1 && isLegalPoint(p)) {
				shootedPieces.add(0, p);
				return p;
			} else {
				p = (Piece)shootedPieces.get(shootedPieces.size() - 1);
				x = p.getHorizontal();
				x += 1;
				p.setHorizontal(x);
				if (isShotable(p) != -1 && isLegalPoint(p)) {
					shootedPieces.add(p);
					return p;
				} else {
					return null;
				}
			}
		}
	}

	private void checkAndRemove() {
		for (int i = 1; i < shootedPieces.size(); i++) {
			if (((Piece) shootedPieces.get(i)).getHorizontal() == ((Piece) shootedPieces
					.get(i - 1)).getHorizontal()
					&& ((Piece) shootedPieces.get(i)).getVertical() == ((Piece) shootedPieces
							.get(i - 1)).getVertical()) {
				shootedPieces.remove(i);
			}
		}
	}

	private boolean getDirection() {
		return (((Piece) shootedPieces.get(0)).getHorizontal() == ((Piece) shootedPieces
				.get(1)).getHorizontal());
	}

	private Piece getNeighbour() {
		Piece p = new Piece();
		p.setHorizontal(((Piece) shootedPieces.get(0)).getHorizontal());
		p.setVertical(((Piece) shootedPieces.get(0)).getVertical() - 1);
		if (isShotable(p) != -1 && isLegalPoint(p)) {
			return p;
		}

		p.setHorizontal(((Piece) shootedPieces.get(0)).getHorizontal());
		p.setVertical(((Piece) shootedPieces.get(0)).getVertical() + 1);
		if (isShotable(p) != -1 && isLegalPoint(p)) {
			return p;
		}

		p.setHorizontal(((Piece) shootedPieces.get(0)).getHorizontal() + 1);
		p.setVertical(((Piece) shootedPieces.get(0)).getVertical());
		if (isShotable(p) != -1 && isLegalPoint(p)) {
			return p;
		}

		p.setHorizontal(((Piece) shootedPieces.get(0)).getHorizontal() - 1);
		p.setVertical(((Piece) shootedPieces.get(0)).getVertical());
		if (isShotable(p) != -1 && isLegalPoint(p)) {
			return p;
		}
		return null;
	}

	private int isShotable(Piece p) {
		for (int i = 0; i < possibleShot.size(); i++) {
			if (((Piece) possibleShot.get(i)).getHorizontal() == p
					.getHorizontal()
					&& ((Piece) possibleShot.get(i)).getVertical() == p
							.getVertical()) {
				return i;
			}
		}
		return -1;
	}

}
