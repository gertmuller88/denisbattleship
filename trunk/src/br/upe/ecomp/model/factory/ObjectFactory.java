package br.upe.ecomp.model.factory;

import java.rmi.RemoteException;
import br.upe.ecomp.enumeration.PlayerType;
import br.upe.ecomp.enumeration.ShipType;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.model.GameImpl;
import br.upe.ecomp.model.Player;
import br.upe.ecomp.model.Scenario;
import br.upe.ecomp.model.Ship;

public class ObjectFactory
{
	private PlayerFactory playerFactory;
	private ScenarioFactory scenarioFactory;
	private ShipFactory shipFactory;
	
	public ObjectFactory()
	{
		this.playerFactory = new PlayerFactory();
		this.scenarioFactory = new ScenarioFactory();
		this.shipFactory = new ShipFactory();
	}
	
	public Game createGame() throws RemoteException
	{
		Game game = new GameImpl();
		game.setPlayer(this.createPlayer());
		game.setOpponent(this.createPlayer());
		game.setPlayerScenario(this.createScenario());
		game.setOpponentScenario(this.createScenario());
		return game;
	}
	
	public Player createPlayer()
	{ return this.playerFactory.getPlayer(PlayerType.Player); }
	
	public Player createIntelligence()
	{ return this.playerFactory.getPlayer(PlayerType.Intelligence); }
	
	public Scenario createScenario()
	{ return this.scenarioFactory.getScenario(); }
	
	public Ship createShip(ShipType type)
	{ return this.shipFactory.getShip(type); }
}
