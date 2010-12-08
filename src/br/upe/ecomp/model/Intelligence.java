package br.upe.ecomp.model;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import br.upe.ecomp.enumeration.ShipType;
import br.upe.ecomp.model.factory.ObjectFactory;

@SuppressWarnings("serial")
public class Intelligence extends Player implements Serializable
{
	private ArrayList<AbstractPiece> possibleShot;
	private ArrayList<AbstractPiece> shootedPieces;
	private boolean state;
	private Random random;
	private int size;

	public Intelligence()
	{
		super();
		state = false;
		random = new Random();
		possibleShot = new ArrayList<AbstractPiece>();
	}

	public void plotShips(Scenario scenario)
	{
		for(ShipType shipType : ShipType.values())
		{
			ObjectFactory of = new ObjectFactory();
			Ship ship = of.createShip(shipType);
			
			if(insertShip(random.nextInt(Scenario.COLUMNS), random.nextInt(Scenario.LINES), random.nextBoolean(), ship, scenario))
			{ this.getShips().add(ship); }
		}
	}

	/**
	 * Realiza a pr�xima jogada da IA
	 * @param scenario - Tabuleiro do oponente (Jogador Real)
	 * @return - Pe�a escolhida pela IA
	 */
	public boolean chooseNextMove(Scenario scenario)
	{
		if(shootedPieces==null)
		{ shootedPieces = new ArrayList<AbstractPiece>(); }

		AbstractPiece shootPiece = null;
		
		if (!shootedPieces.isEmpty())
		{ return makeMove(scenario, shootPiece); }
		else
		{ return choosePieceRandom(scenario); }
	}
	
	private boolean checkPosition(final int x, final int y, final boolean direction, final Ship ship, final Scenario scenario)
	{
		if(direction)
		{ // is horizontal
			if (x + ship.getSize() <= size)
			{
				for(int i=x; i < x + ship.getSize(); i++) {
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

	private boolean insertShip(final int x, final int y, final boolean direction, final Ship ship, Scenario scenario)
	{
		if(checkPosition(x, y, direction, ship, scenario))
		{
			ArrayList<AbstractPiece> pieces = new ArrayList<AbstractPiece>();
			
			for (int i = 0; i < ship.getSize(); i++)
			{
				Piece piece = new Piece();
				
				if (direction)
				{
					piece.setHorizontal(x + i);
					piece.setVertical(y);
				}
				else
				{
					piece.setHorizontal(x);
					piece.setVertical(y + i);
				}
				piece.setOccupied();
				pieces.add(piece);
			}
			ship.setPieces(pieces);
			return true;
		}
		return false;
	}

	private boolean choosePieceRandom(Scenario board) {
		AbstractPiece shootPiece = new Piece();
		shootPiece.setHorizontal(random.nextInt(Scenario.COLUMNS));
		shootPiece.setVertical(random.nextInt(Scenario.LINES));
		boolean retorno = this.shot(shootPiece.getHorizontal(), shootPiece.getVertical(), board);
		shootedPieces.add(shootPiece);

		return retorno;
	}
	
	private boolean makeMove(Scenario board, AbstractPiece piece) {
		System.out.println("AI");
		boolean hit;

		if (state) {
			System.out.println(shootedPieces); // attackingBoat
			if (shootedPieces.size() == 1) {
				piece = getNeighbour();
				if (piece != null && isShotable((Piece) piece) != -1) {
					possibleShot.remove(isShotable((Piece) piece));
					hit = this.shot(((Piece)piece).getHorizontal(), ((Piece)piece).getVertical(), board);
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
					hit = this.shot(((Piece)piece).getHorizontal(), ((Piece)piece).getVertical(), board);
					if (hit) {
						//firePlayerMakeMoved();
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
			hit = this.shot(((Piece)piece).getHorizontal(), ((Piece)piece).getVertical(), board);
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
	
	private boolean shot(int x, int y, Scenario board)
	{
		AbstractPiece piece = board.getPiece(x,y);
		if (piece != null) {
			if (((Piece)piece).isOccupied()) {
				((Piece) piece).setDestroyed();
				return true;
			}
		}
		return false;
	}
}
