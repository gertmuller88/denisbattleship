package br.upe.ecomp.model.state;

public interface StateShip
{
	public void setNoDamaged();
	public void setDamaged();
	public void setSunk();
	public void update();
}
