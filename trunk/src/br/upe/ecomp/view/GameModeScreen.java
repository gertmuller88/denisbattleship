package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import br.upe.ecomp.enumeration.GameMode;

@SuppressWarnings("serial")
public class GameModeScreen extends JDialog
{
	private static GameModeScreen gameModeScreen;
	private GameMode gameMode;
	private ImageIcon imageSingleplayer, imageDualplayer;
	private JLabel singleplayer, dualplayer;
	
	private GameModeScreen()
	{
		super(MainScreen.getInstance(null), true);
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		JLabel gameModeLabel = new JLabel("Escolha o modo que você deseja jogar:");
		gameModeLabel.setBounds(30, 15, 300, 20);
		container.add(gameModeLabel);
		
		imageSingleplayer = new ImageIcon("images/ui/singleplayer-wb.png");
		singleplayer = new JLabel(imageSingleplayer);
		singleplayer.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				imageSingleplayer = new ImageIcon("images/ui/singleplayer.png");
				singleplayer.setIcon(imageSingleplayer);
			}
			
			public void mouseExited(MouseEvent e)
			{
				imageSingleplayer = new ImageIcon("images/ui/singleplayer-wb.png");
				singleplayer.setIcon(imageSingleplayer);
			}
			
			public void mouseClicked(MouseEvent e)
			{
				setGameMode(GameMode.Singleplayer);
				dispose();
			}
		});
		singleplayer.setBounds(10, 45, 171, 64);
		container.add(singleplayer);
		
		imageDualplayer = new ImageIcon("images/ui/dualplayer-wb.png");
		dualplayer = new JLabel(imageDualplayer);
		dualplayer.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				imageDualplayer = new ImageIcon("images/ui/dualplayer.png");
				dualplayer.setIcon(imageDualplayer);
			}
			
			public void mouseExited(MouseEvent e)
			{
				imageDualplayer = new ImageIcon("images/ui/dualplayer-wb.png");
				dualplayer.setIcon(imageDualplayer);
			}
			
			public void mouseClicked(MouseEvent e)
			{
				setGameMode(GameMode.Dualplayer);
				dispose();
			}
		});
		dualplayer.setBounds(180, 45, 171, 64);
		container.add(dualplayer);
		
		this.pack();
		this.setSize(350, 150);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static GameModeScreen getInstance()
	{
		if(gameModeScreen==null)
		{ gameModeScreen = new GameModeScreen(); }
		return gameModeScreen;
	}
	
	public void reset()
	{
		imageSingleplayer = new ImageIcon("images/ui/singleplayer-wb.png");
		singleplayer.setIcon(imageSingleplayer);
		
		imageDualplayer = new ImageIcon("images/ui/dualplayer-wb.png");
		dualplayer.setIcon(imageDualplayer);
		
		gameMode = null;
		
		this.setLocationRelativeTo(null);
	}
	
	public GameMode getGameMode()
	{ return this.gameMode; }
	
	public void setGameMode(GameMode gameMode)
	{ this.gameMode = gameMode; }
}
