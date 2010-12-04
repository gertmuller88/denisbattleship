package br.upe.ecomp.model.factory;

import java.util.ArrayList;
import br.upe.ecomp.enumeration.PlayerType;
import br.upe.ecomp.model.Intelligence;
import br.upe.ecomp.model.Player;
import br.upe.ecomp.model.Ship;

public class PlayerFactory
{
	public Player getPlayer(PlayerType type)
	{
		Player player;
		
		switch (type)
		{
			case Player:
				player = new Player();
				player.setScore(0);
				player.setShips(new ArrayList<Ship>());
				return player;
			case Intelligence:
				player = new Intelligence();
				player.setName("Intelligence");
				player.setScore(0);
				player.setShips(new ArrayList<Ship>());
				return player;
		}
		throw new IllegalArgumentException("O tipo de jogador " + type + " não existe.");
	}
}
