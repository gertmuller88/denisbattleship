package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import br.upe.ecomp.util.ConnectionMode;

@SuppressWarnings("serial")
public class ConnectionModeScreen extends JDialog
{
	private static ConnectionModeScreen connectionModeScreen;
	private ConnectionMode connectionMode;
	private ImageIcon imageClient, imageServer;
	private JLabel client, server;
	
	private ConnectionModeScreen()
	{
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		JLabel gameModeLabel = new JLabel("Escolha o modo de conexão Dualplayer:");
		gameModeLabel.setBounds(30, 15, 300, 20);
		container.add(gameModeLabel);
		
		imageClient = new ImageIcon("images/client-pb.png");
		client = new JLabel(imageClient);
		client.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				imageClient = new ImageIcon("images/client.png");
				client.setIcon(imageClient);
			}
			
			public void mouseExited(MouseEvent e)
			{
				imageClient = new ImageIcon("images/client-pb.png");
				client.setIcon(imageClient);
			}
			
			public void mouseClicked(MouseEvent e)
			{
				setConnectionMode(ConnectionMode.Client);
				dispose();
			}
		});
		client.setBounds(10, 45, 171, 64);
		container.add(client);
		
		imageServer = new ImageIcon("images/server-pb.png");
		server = new JLabel(imageServer);
		server.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				imageServer = new ImageIcon("images/server.png");
				server.setIcon(imageServer);
			}
			
			public void mouseExited(MouseEvent e)
			{
				imageServer = new ImageIcon("images/server-pb.png");
				server.setIcon(imageServer);
			}
			
			public void mouseClicked(MouseEvent e)
			{
				setConnectionMode(ConnectionMode.Server);
				dispose();
			}
		});
		server.setBounds(180, 45, 171, 64);
		container.add(server);
		
		this.pack();
		this.setSize(350, 150);
		this.setResizable(false);
		this.setLayout(null);
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static ConnectionModeScreen getInstance()
	{
		if(connectionModeScreen==null)
		{ connectionModeScreen = new ConnectionModeScreen(); }
		return connectionModeScreen;
	}
	
	public void reset()
	{
		imageClient = new ImageIcon("images/client-pb.png");
		client.setIcon(imageClient);
		
		imageServer = new ImageIcon("images/server-pb.png");
		server.setIcon(imageServer);
		
		connectionMode = null;
		
		this.setLocationRelativeTo(null);
	}
	
	public ConnectionMode getConnectionMode()
	{ return this.connectionMode; }
	
	public void setConnectionMode(ConnectionMode connectionMode)
	{ this.connectionMode = connectionMode; }
}
