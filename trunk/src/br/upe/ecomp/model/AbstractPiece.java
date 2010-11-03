package br.upe.ecomp.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractPiece implements Serializable
{
	private boolean destroyed;

	public boolean isDestroyed()
	{ return destroyed; }

	public void setDestroyed(boolean destroyed)
	{ this.destroyed = destroyed; }
}
