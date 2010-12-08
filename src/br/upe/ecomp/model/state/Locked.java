package br.upe.ecomp.model.state;

import br.upe.ecomp.model.Player;

public class Locked implements StatePlayer
{
	private Player player;
	
	public Locked(Player player)
	{ this.player = player; }
	
	public void setLocked()
	{
		if(player.getState().getClass().isInstance(player.getUnlocked()))
		{ player.setState(player.getLocked()); }
	}

	@Override
	public void setUnlocked()
	{
		if(player.getState().getClass().isInstance(player.getLocked()))
		{ player.setState(player.getUnlocked()); }
	}
}
