package br.upe.ecomp.model.factory;

import java.util.ArrayList;
import br.upe.ecomp.model.AbstractPiece;
import br.upe.ecomp.model.Piece;
import br.upe.ecomp.model.Scenario;

public class ScenarioFactory extends ObjectFactory
{
	public Scenario getScenario()
	{
		ArrayList<AbstractPiece> pieces = new ArrayList<AbstractPiece>();
		
		for(int i=1; i<=10; i++)
		{
			for(int j=1; j<=10; j++)
			{
				Piece piece = new Piece();
				piece.setHorizontal(i);
				piece.setVertical(j);
				pieces.add(piece);
			}
		}
		
		Scenario scenario = new Scenario();
		scenario.setPieces(pieces);
		return scenario;
	}
	
	public Scenario getNewObject()
	{ return new Scenario(); }
}
