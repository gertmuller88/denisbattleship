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
import br.upe.ecomp.control.MainController;

@SuppressWarnings("serial")
public class MainScreen extends JFrame
{
	private static MainScreen mainScreen;
	private ImageIcon imageLogo, imageJogar, imageCreditos, imageSair;
	private JLabel logo, jogar, creditos, sair;
	
	private MainScreen()
	{
		super("Denis' BattleShip (EComp/UPE)");
		
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		JMenuBar barraDeMenus = new JMenuBar();
		
		JMenu menuJogo = new JMenu("Jogo");
		barraDeMenus.add(menuJogo);
		
		JMenuItem novo = new JMenuItem("Iniciar novo...");
		novo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MainController mainController = new MainController();
				mainController.play();
			}
		});
		menuJogo.add(novo);
		
		JMenuItem exit = new JMenuItem("Sair");
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ System.exit(0); }
		});
		menuJogo.add(exit);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		barraDeMenus.add(menuAjuda);
		
		JMenuItem regras = new JMenuItem("Regras");
		regras.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				RuleScreen ruleScreen = RuleScreen.getInstance();
				ruleScreen.setVisible(true);
			}
		});
		menuAjuda.add(regras);
		
		JMenuItem sobre = new JMenuItem("Sobre");
		sobre.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				AboutScreen aboutScreen = AboutScreen.getInstance();
				aboutScreen.setVisible(true);
			}
		});
		menuAjuda.add(sobre);
		
		imageJogar = new ImageIcon("images/jogar-pb.png");
		jogar = new JLabel(imageJogar);
		jogar.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				imageJogar = new ImageIcon("images/jogar.png");
				jogar.setIcon(imageJogar);
			}
			
			public void mouseExited(MouseEvent e)
			{
				imageJogar = new ImageIcon("images/jogar-pb.png");
				jogar.setIcon(imageJogar);
			}
			
			public void mouseClicked(MouseEvent e)
			{
				MainController mainController = new MainController();
				mainController.play();
			}
		});
		jogar.setBounds(560, 80, 171, 64);
		container.add(jogar);
		
		imageCreditos = new ImageIcon("images/creditos-pb.png");
		creditos = new JLabel(imageCreditos);
		creditos.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				imageCreditos = new ImageIcon("images/creditos.png");
				creditos.setIcon(imageCreditos);
			}
			
			public void mouseExited(MouseEvent e)
			{
				imageCreditos = new ImageIcon("images/creditos-pb.png");
				creditos.setIcon(imageCreditos);
			}
			
			public void mouseClicked(MouseEvent e)
			{
				AboutScreen aboutScreen = AboutScreen.getInstance();
				aboutScreen.setVisible(true);
			}
		});
		creditos.setBounds(560, 150, 171, 64);
		container.add(creditos);
		
		imageSair = new ImageIcon("images/sair-pb.png");
		sair = new JLabel(imageSair);
		sair.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				imageSair = new ImageIcon("images/sair.png");
				sair.setIcon(imageSair);
			}
			
			public void mouseExited(MouseEvent e)
			{
				imageSair = new ImageIcon("images/sair-pb.png");
				sair.setIcon(imageSair);
			}
			
			public void mouseClicked(MouseEvent e)
			{ System.exit(0); }
		});
		sair.setBounds(560, 220, 171, 64);
		container.add(sair);
		
		imageLogo = new ImageIcon("images/main.png");
		logo = new JLabel(imageLogo);
		logo.setBounds(0, 411, 800, 140);
		container.add(logo);
		
		this.pack();
		this.setJMenuBar(barraDeMenus);
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static MainScreen getInstance()
	{
		if(mainScreen==null)
		{ mainScreen = new MainScreen(); }
		return mainScreen;
	}
}
