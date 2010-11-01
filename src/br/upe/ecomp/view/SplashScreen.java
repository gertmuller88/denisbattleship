package br.upe.ecomp.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SplashScreen extends JWindow
{
	private static SplashScreen splashScreen;
	
	public SplashScreen()
	{
		Container container = this.getContentPane();
		
		ImageIcon imageSplash = new ImageIcon("images/main.png");
		JLabel splash = new JLabel(imageSplash);
		container.add(splash);
		
		ActionListener close = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ setVisible(false); }
		};
		
		Timer timer = new Timer(2000, close);
		timer.start();
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout(0, 0, FlowLayout.LEFT));
	}
	
	public static SplashScreen getInstance()
	{
		if(splashScreen==null)
		{ splashScreen = new SplashScreen(); }
		return splashScreen;
	}
}
