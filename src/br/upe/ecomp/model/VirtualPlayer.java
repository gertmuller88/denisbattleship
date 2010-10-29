package br.upe.ecomp.model;

public class VirtualPlayer extends Player
{
	private Intelligence intelligence;

	public Intelligence getIntelligence()
	{ return intelligence; }

	public void setIntelligence(Intelligence intelligence)
	{ this.intelligence = intelligence; }
}
