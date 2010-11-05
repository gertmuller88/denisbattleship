package br.upe.ecomp.view;

import javax.swing.JDialog;

@SuppressWarnings("serial")
public class AboutScreen extends JDialog
{
	private static AboutScreen aboutScreen;
	
	private AboutScreen() {}
	
	public static AboutScreen getInstance()
	{
		if(aboutScreen==null)
		{ aboutScreen = new AboutScreen(); }
		return aboutScreen;
	}
}
