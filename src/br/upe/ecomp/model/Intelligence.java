package br.upe.ecomp.model;

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
	private boolean turn;
	private Random random;

	public Intelligence()
	{
		super();
		turn = false;
		random = new Random();
		possibleShot = new ArrayList<AbstractPiece>();
		
        for (int i = 0; i < Scenario.COLUMNS; i++) {
            for (int j = 0; j < Scenario.LINES; j++) {
            		AbstractPiece piece = new Piece();
            		piece.setHorizontal(i);
            		piece.setVertical(j);
                    possibleShot.add(piece);
            }
        }

	}

	public void plotShips(Scenario scenario)
	{
		for(ShipType shipType : ShipType.values())
		{
			ObjectFactory of = new ObjectFactory();
			Ship ship = of.createShip(shipType);
			
			while(true)
			{
				if(this.insertShip(this.random.nextInt(Scenario.COLUMNS), this.random.nextInt(Scenario.LINES), this.random.nextBoolean(), ship, scenario))
				{
					this.getShips().add(ship);
					break;
				}
			}
		}
	}
	
	private boolean insertShip(final int x, final int y, final boolean direction, Ship ship, Scenario scenario)
	{
		if(this.checkPosition(x, y, direction, ship, scenario))
		{
			ArrayList<AbstractPiece> pieces = new ArrayList<AbstractPiece>();
			
			for(int i=0; i<ship.getSize(); i++)
			{
				if(direction)
				{
					Piece piece = (Piece) scenario.getPiece((x+i), y);
					piece.setOccupied();
					pieces.add(piece);
				}
				else
				{
					Piece piece = (Piece) scenario.getPiece(x, (y+i));
					piece.setOccupied();
					pieces.add(piece);
				}
			}
			
			ship.setPieces(pieces);
			return true;
		}
		return false;
	}
	
	private boolean checkPosition(final int x, final int y, final boolean direction, Ship ship, Scenario scenario)
	{
		if(direction)
		{
			if(x+ship.getSize()<Scenario.COLUMNS)
			{
				for(int i=x; i<x+ship.getSize(); i++)
				{
					for(AbstractPiece piece : scenario.getPieces())
					{
						if(piece.getHorizontal()==(i-1) && piece.getVertical()==y)
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if (piece.getHorizontal()==i && piece.getVertical()==y)
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if(piece.getHorizontal()==(i+1) && piece.getVertical()==y)
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if(piece.getHorizontal()==(i-1) && piece.getVertical()==(y-1))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if (piece.getHorizontal()==i && piece.getVertical()==(y-1))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if(piece.getHorizontal()==(i+1) && piece.getVertical()==(y-1))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if(piece.getHorizontal()==(i-1) && piece.getVertical()==(y+1))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if (piece.getHorizontal()==i && piece.getVertical()==(y+1))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if(piece.getHorizontal()==(i+1) && piece.getVertical()==(y+1))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
					}
				}
				return true;
			}
			else
			{ return false; }
		}
		else
		{
			if(y+ship.getSize()<=Scenario.LINES)
			{
				for(int i=y; i<y+ship.getSize(); i++)
				{
					for (AbstractPiece piece : scenario.getPieces())
					{
						if(piece.getHorizontal()==x && piece.getVertical()==(i-1))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if (piece.getHorizontal()==x && piece.getVertical()==i)
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if(piece.getHorizontal()==x && piece.getVertical()==(i+1))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if(piece.getHorizontal()==(x-1) && piece.getVertical()==(i-1))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if(piece.getHorizontal()==(x-1) && piece.getVertical()==(i))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if(piece.getHorizontal()==(x-1) && piece.getVertical()==(i+1))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if(piece.getHorizontal()==(x+1) && piece.getVertical()==(i-1))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if(piece.getHorizontal()==(x+1) && piece.getVertical()==(i))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
						
						if(piece.getHorizontal()==(x+1) && piece.getVertical()==(i+1))
						{
							if(((Piece) piece).isOccupied())
							{ return false; }
						}
					}
				}
				return true;
			}
			else
			{ return false; }
		}
	}

	public boolean chooseNextMove(Scenario scenario)
	{
		if(this.shootedPieces==null)
		{ this.shootedPieces = new ArrayList<AbstractPiece>(); }

		AbstractPiece shootPiece = null;
		
		if(this.shootedPieces.isEmpty())
		{ return this.choosePieceRandom(scenario); }
		else
		{ return this.makeMove(scenario, shootPiece); }
	}
	
	private boolean choosePieceRandom(Scenario scenario)
	{
		AbstractPiece shootPiece = new Piece();
		shootPiece.setHorizontal(this.random.nextInt(Scenario.COLUMNS));
		shootPiece.setVertical(this.random.nextInt(Scenario.LINES));
		shootedPieces.add(shootPiece);
		
		boolean retorno = this.shot(shootPiece.getHorizontal(), shootPiece.getVertical(), scenario);
		return retorno;
	}
	
	private boolean shot(int x, int y, Scenario scenario)
	{
		Piece piece = (Piece) scenario.getPiece(x,y);
		if(piece!=null)
		{
			piece.setDestroyed();
			return true;
		}
		return false;
	}
	
	private boolean makeMove(Scenario board, AbstractPiece piece)
	{
		System.out.println("IA Movendo sua peça.");
		boolean hit;
System.out.println("1");
		if(turn)
		{
			System.out.println("2");
			if(shootedPieces.size()==1)
			{
				System.out.println("3");
				piece = getNeighbour();
				System.out.println("4");
				if (piece != null && isShotable((Piece) piece) != -1) {
					System.out.println("5");
					possibleShot.remove(isShotable((Piece) piece));
					System.out.println("6");
					hit = this.shot(((Piece)piece).getHorizontal(), ((Piece)piece).getVertical(), board);
					System.out.println("7");
					if (hit) {
						System.out.println("8");
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
						System.out.println("9");
						return true;
					} else {// /not hit
						//firePlayerMakeMoved();
						System.out.println("10");
						return false;
					}
				} else {
					System.out.println("11");
					turn = false;
					System.out.println("12");
					makeMove(board, piece);

				}

			} else {// +1
				System.out.println("13");
				piece = getPiecePoint();
				System.out.println("14");
				checkAndRemove();
				System.out.println("15");
				System.out.println("piece:" + piece);
				if (piece != null) {
					System.out.println("16");
					piece = possibleShot.remove(isShotable(((Piece)piece)));
					System.out.println("17");
					hit = this.shot(((Piece)piece).getHorizontal(), ((Piece)piece).getVertical(), board);
					System.out.println("18");
					if (hit) {
						//firePlayerMakeMoved();
						System.out.println("acertou");
						return true;
					} else {
						System.out.println("19");
						if (((Piece)piece).getHorizontal() == ((Piece)shootedPieces.get(0)).getHorizontal()
								&& ((Piece)piece).getVertical() == ((Piece)shootedPieces.get(0)).getVertical()) {
							System.out.println("20");
							shootedPieces.remove(0);
						} else {
							System.out.println("21");
							shootedPieces.remove(shootedPieces.size() - 1);
						}
						//firePlayerMakeMoved();
						System.out.println("22");
						return false;
					}

				} else { // p == null
					System.out.println("23");
					turn = false;
				}
			}
		}

		System.out.println("24");
		if (!turn) {
			System.out.println("25");
			int index = random.nextInt(possibleShot.size());
			System.out.println("26");
			piece = (Piece) possibleShot.remove(index);
			System.out.println("27");
			hit = this.shot(((Piece)piece).getHorizontal(), ((Piece)piece).getVertical(), board);
			//firePlayerMakeMoved();
			System.out.println("28");
			if (hit) {
				System.out.println("29");
				turn = true;
				System.out.println("30");
				shootedPieces.clear();
				System.out.println("31");
				shootedPieces.add(piece);
				System.out.println("32");
				return true;
			}
			System.out.println("33");
			return false;
		}
		System.out.println("34");

		return false;
	}
	
	private Piece getNeighbour()
	{
		Piece p = new Piece();
		
		p.setHorizontal(((Piece) shootedPieces.get(0)).getHorizontal());
		p.setVertical(((Piece) shootedPieces.get(0)).getVertical() - 1);
		
		if(isShotable(p)!=-1 && isLegalPoint(p))
		{
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

	private boolean isLegalPoint(Piece p)
	{ return ((p.getHorizontal()>=0 && p.getHorizontal()<Scenario.LINES) && (p.getVertical()>=0 && p.getVertical()<Scenario.COLUMNS)); }

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

	private int isShotable(Piece p)
	{
		for (int i=0; i<possibleShot.size(); i++)
		{
			if (possibleShot.get(i).getHorizontal()==p.getHorizontal() && possibleShot.get(i).getVertical()==p.getVertical())
			{ return i; }
		}
		return -1;
	}
}
