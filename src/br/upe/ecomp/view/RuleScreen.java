package br.upe.ecomp.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class RuleScreen extends JFrame
{
	private static RuleScreen ruleScreen;
	
	private RuleScreen() {}
	
	public static RuleScreen getInstance()
	{
		if(ruleScreen==null)
		{ ruleScreen = new RuleScreen(); }
		return ruleScreen;
	}
}
