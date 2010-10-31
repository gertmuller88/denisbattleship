package br.upe.ecomp.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AboutScreen extends JFrame
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
