package br.upe.ecomp.model.factory;

import java.util.ArrayList;
import br.upe.ecomp.model.AbstractPiece;
import br.upe.ecomp.model.Piece;
import br.upe.ecomp.model.Scenario;

public class ScenarioFactory
{
	public Scenario getScenario()
	{
		Scenario scenario = new Scenario();
		scenario.setPieces(new ArrayList<AbstractPiece>());
		
		for(int i=0; i<Scenario.LINES; i++)
		{
			for(int j=0; j<Scenario.COLUMNS; j++)
			{
				Piece piece = new Piece();
				piece.setHorizontal(i);
				piece.setVertical(j);
				scenario.getPieces().add(piece);
			}
		}
		
		return scenario;
	}
}
