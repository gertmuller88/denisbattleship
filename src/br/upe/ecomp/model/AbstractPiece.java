package br.upe.ecomp.model;

public abstract class AbstractPiece
{
	private boolean destroyed;

	public boolean isDestroyed()
	{ return destroyed; }

	public void setDestroyed(boolean destroyed)
	{ this.destroyed = destroyed; }
}
