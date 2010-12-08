package br.upe.ecomp.view.components;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VisualGamePanel extends JPanel
{
	private static VisualGamePanel visualGamePanel;
	
	private VisualGamePanel()
	{
		this.setLayout(null);
		this.setBounds(55, 50, 251, 251);
	}
	
	public static VisualGamePanel getInstance()
	{
		if(visualGamePanel==null)
		{ visualGamePanel = new VisualGamePanel(); }
		return visualGamePanel;
	}
	
	public static void reset()
	{ visualGamePanel = new VisualGamePanel(); }
}
