package br.upe.ecomp.model.factory;

import br.upe.ecomp.enumeration.PlayerType;
import br.upe.ecomp.model.Intelligence;
import br.upe.ecomp.model.Player;

public class PlayerFactory
{
	public static Player getPlayer(PlayerType type)
	{
		Player player;
		
		switch (type)
		{
			case Player:
				player = new Player();
				player.setScore(0);
				return player;
			case Intelligence:
				player = new Intelligence();
				player.setName("Intelligence");
				player.setScore(0);
				return player;
		}
		throw new IllegalArgumentException("O tipo de jogador " + type + " não existe.");
	}
}
