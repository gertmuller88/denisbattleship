package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MainScreen extends JFrame
{
	private static MainScreen mainScreen;
	private ImageIcon imageLogo, imagePlay, imageCredits, imageExit;
	private JLabel logo, play, credits, exit;
	
	private MainScreen(MouseAdapter listener)
	{
		super("Denis' BattleShip (EComp/UPE)");
		
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu playMenu = new JMenu("Jogo");
		menuBar.add(playMenu);
		
		JMenuItem newGame = new JMenuItem("Iniciar novo...");
		newGame.addMouseListener(listener);
		playMenu.add(newGame);
		
		JMenuItem close = new JMenuItem("Sair");
		close.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ System.exit(0); }
		});
		playMenu.add(close);
		
		JMenu helpMenu = new JMenu("Ajuda");
		menuBar.add(helpMenu);
		
		JMenuItem rules = new JMenuItem("Regras");
		rules.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				RuleScreen ruleScreen = RuleScreen.getInstance();
				ruleScreen.setVisible(true);
			}
		});
		helpMenu.add(rules);
		
		JMenuItem about = new JMenuItem("Sobre");
		about.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				AboutScreen aboutScreen = AboutScreen.getInstance();
				aboutScreen.setVisible(true);
			}
		});
		helpMenu.add(about);
		
		imagePlay = new ImageIcon("images/ui/play-wb.png");
		play = new JLabel(imagePlay);
		play.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				imagePlay = new ImageIcon("images/ui/play.png");
				play.setIcon(imagePlay);
			}
			
			public void mouseExited(MouseEvent e)
			{
				imagePlay = new ImageIcon("images/ui/play-wb.png");
				play.setIcon(imagePlay);
			}
		});
		play.addMouseListener(listener);
		play.setBounds(560, 80, 171, 64);
		container.add(play);
		
		imageCredits = new ImageIcon("images/ui/credits-wb.png");
		credits = new JLabel(imageCredits);
		credits.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				imageCredits = new ImageIcon("images/ui/credits.png");
				credits.setIcon(imageCredits);
			}
			
			public void mouseExited(MouseEvent e)
			{
				imageCredits = new ImageIcon("images/ui/credits-wb.png");
				credits.setIcon(imageCredits);
			}
			
			public void mouseClicked(MouseEvent e)
			{
				AboutScreen aboutScreen = AboutScreen.getInstance();
				aboutScreen.setVisible(true);
			}
		});
		credits.setBounds(560, 150, 171, 64);
		container.add(credits);
		
		imageExit = new ImageIcon("images/ui/exit-wb.png");
		exit = new JLabel(imageExit);
		exit.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				imageExit = new ImageIcon("images/ui/exit.png");
				exit.setIcon(imageExit);
			}
			
			public void mouseExited(MouseEvent e)
			{
				imageExit = new ImageIcon("images/ui/exit-wb.png");
				exit.setIcon(imageExit);
			}
			
			public void mouseClicked(MouseEvent e)
			{ System.exit(0); }
		});
		exit.setBounds(560, 220, 171, 64);
		container.add(exit);
		
		imageLogo = new ImageIcon("images/ui/main.png");
		logo = new JLabel(imageLogo);
		logo.setBounds(0, 411, 800, 140);
		container.add(logo);
		
		this.pack();
		this.setJMenuBar(menuBar);
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static MainScreen getInstance(MouseAdapter listener)
	{
		if(mainScreen==null)
		{ mainScreen = new MainScreen(listener); }
		return mainScreen;
	}
}
