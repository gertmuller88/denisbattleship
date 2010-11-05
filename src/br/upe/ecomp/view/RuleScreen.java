package br.upe.ecomp.view;

import javax.swing.JDialog;

@SuppressWarnings("serial")
public class RuleScreen extends JDialog
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
