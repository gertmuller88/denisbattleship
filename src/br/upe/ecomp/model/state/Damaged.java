package br.upe.ecomp.model.state;

import java.io.Serializable;
import br.upe.ecomp.model.Piece;
import br.upe.ecomp.model.Ship;

@SuppressWarnings("serial")
public class Damaged implements StateShip, Serializable
{
	private Ship ship;
	
	public Damaged(Ship ship)
	{ this.ship = ship; }

	public void setNoDamaged()
	{
		if(ship.getPieces().size()==ship.getSize())
		{ ship.setState(ship.getNoDamaged()); }
	}

	public void setDamaged()
	{
		if(ship.getPieces().size()>0 && ship.getPieces().size()<ship.getSize())
		{ ship.setState(ship.getDamaged()); }
	}

	public void setSunk()
	{
		if(ship.getPieces().size()==0)
		{ ship.setState(ship.getSunk()); }
	}
	
	public void update()
	{
		int cont = 0;
		for(int i=0; i<ship.getSize(); i++)
		{
			if(((Piece) ship.getPieces().get(i)).isDestroyed())
			{ cont++; }
		}
		
		if(cont<ship.getSize() && cont>0)
		{
			ship.setState(ship.getDamaged());
			return;
		}
		
		if(cont>=ship.getSize())
		{
			ship.setState(ship.getSunk());
			return;
		}
		
		if(cont==0)
		{
			ship.setState(ship.getNoDamaged());
			return;
		}
	}
}
