package br.upe.ecomp.model.state;

public interface StatePiece
{
	public void setOccupied();
	public void setUnoccupied();
	public void setDestroyed();
	public void setNonDestroyed();
}
