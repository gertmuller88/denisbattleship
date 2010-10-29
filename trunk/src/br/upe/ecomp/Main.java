package br.upe.ecomp;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import br.upe.ecomp.control.MainController;

public class Main
{
	public static void main(String args[])
	{
		try
		{ UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
		catch (ClassNotFoundException e)
		{ e.printStackTrace(); }
		catch (InstantiationException e)
		{ e.printStackTrace(); }
		catch (IllegalAccessException e)
		{ e.printStackTrace(); }
		catch (UnsupportedLookAndFeelException e)
		{ e.printStackTrace(); }
		
		MainController mainController = new MainController();
		mainController.init();
	}
}
