package br.upe.ecomp.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SplashScreen extends JDialog
{
	private static SplashScreen splashScreen;
	private Timer timer;
	
	public SplashScreen()
	{
		Container container = this.getContentPane();
		
		ImageIcon imageSplash = new ImageIcon("images/ui/splash.png");
		JLabel splash = new JLabel(imageSplash);
		container.add(splash);
		
		ActionListener close = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				timer.stop();
				splashScreen.setVisible(false);
			}
		};
		
		timer = new Timer(2000, close);
		timer.start();
		
		this.setUndecorated(true);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setLayout(new FlowLayout(0, 0, FlowLayout.LEFT));
	}
	
	public static SplashScreen getInstance()
	{
		if(splashScreen==null)
		{ splashScreen = new SplashScreen(); }
		return splashScreen;
	}
}
