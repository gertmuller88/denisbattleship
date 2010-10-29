package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainScreen extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static MainScreen mainScreen;
	
	private Container container;
	private ImageIcon imageLogo, imageJogar, imageCreditos, imageSair;
	private JLabel logo, jogar, creditos, sair;
	
	private MainScreen(MouseAdapter mouseAdapter)
	{
		super("Denis' BattleShip - EComp - UPE");
		
		container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		imageLogo = new ImageIcon("images/main.png");
		logo = new JLabel(imageLogo);
		logo.setBounds(0, 411, 800, 140);
		container.add(logo);
		
		JMenuBar barraDeMenus = new JMenuBar();
		
		JMenu menuSistema = new JMenu("Sistema");
		barraDeMenus.add(menuSistema);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		barraDeMenus.add(menuAjuda);
		
		JMenuItem regras = new JMenuItem("Regras");
		menuAjuda.add(regras);
		
		JMenuItem sobre = new JMenuItem("Sobre");
		menuAjuda.add(sobre);
		
		imageJogar = new ImageIcon("images/jogar-pb.png");
		jogar = new JLabel(imageJogar);
		jogar.addMouseListener
		(
			new MouseAdapter()
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
			}
		);
		jogar.addMouseListener(mouseAdapter);
		jogar.setName("Jogar");
		jogar.setBounds(560, 80, 171, 64);
		container.add(jogar);
		
		imageCreditos = new ImageIcon("images/creditos-pb.png");
		creditos = new JLabel(imageCreditos);
		creditos.addMouseListener
		(
			new MouseAdapter()
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
			}
		);
		creditos.addMouseListener(mouseAdapter);
		creditos.setName("Creditos");
		creditos.setBounds(560, 150, 171, 64);
		container.add(creditos);
		
		imageSair = new ImageIcon("images/sair-pb.png");
		sair = new JLabel(imageSair);
		sair.addMouseListener
		(
			new MouseAdapter()
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
			}
		);
		sair.addMouseListener(mouseAdapter);
		sair.setName("Sair");
		sair.setBounds(560, 220, 171, 64);
		container.add(sair);
		
		this.pack();
		this.setJMenuBar(barraDeMenus);
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static MainScreen getInstance(MouseAdapter mouseAdapter)
	{
		if(mainScreen==null)
		{ mainScreen = new MainScreen(mouseAdapter); }
		return mainScreen;
	}
}
