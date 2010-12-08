package br.upe.ecomp.view.components;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VisualScenarioPanel extends JPanel
{
	private static VisualScenarioPanel visualScenarioPanel;
	
	private VisualScenarioPanel()
	{
		this.setLayout(null);
		this.setBounds(55, 50, 251, 251);
	}
	
	public static VisualScenarioPanel getInstance()
	{
		if(visualScenarioPanel==null)
		{ visualScenarioPanel = new VisualScenarioPanel(); }
		return visualScenarioPanel;
	}
	
	public static void reset()
	{ visualScenarioPanel = new VisualScenarioPanel(); }
}
