package br.upe.ecomp.model.factory;

public abstract class ObjectFactory
{
	public enum FactoryType
	{
		Game,
		Player,
		Scenario,
		Ship;
	}
	
	public static ObjectFactory getFactory(FactoryType type)
	{
		switch(type)
		{
			case Game:
				return new GameFactory();
			case Player:
				return new PlayerFactory();
			case Scenario:
				return new ScenarioFactory();
			case Ship:
				return new ShipFactory();
		}
		throw new IllegalArgumentException("O tipo " + type + "Factory não existe.");
	}
	
	public abstract Object getNewObject();
}
