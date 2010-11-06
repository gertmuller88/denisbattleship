package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class RuleScreen extends JDialog
{
	private static RuleScreen ruleScreen;
	
	private RuleScreen()
	{
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		this.pack();
		this.setSize(600, 480);
		this.setResizable(false);
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static RuleScreen getInstance()
	{
		if(ruleScreen==null)
		{ ruleScreen = new RuleScreen(); }
		return ruleScreen;
	}
}
