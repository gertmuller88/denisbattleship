package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class ServerScreen extends JDialog
{
	private static ServerScreen serverScreen;
	private boolean toStop;
	
	private ServerScreen()
	{
		super(MainScreen.getInstance(null), true);
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		JLabel gameModeLabel = new JLabel("Aguardando conexão...");
		gameModeLabel.setBounds(30, 15, 300, 20);
		container.add(gameModeLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setBounds(30, 50, 300, 20);
		container.add(progressBar);
		
		JButton stop = new JButton("Parar");
		stop.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				setToStop(true);
				dispose();
			}
		});
		stop.setBounds(260, 85, 70, 25);
		container.add(stop);
		
		this.pack();
		this.setSize(360, 150);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	public static ServerScreen getInstance()
	{
		if(serverScreen==null)
		{ serverScreen = new ServerScreen(); }
		return serverScreen;
	}

	public boolean isToStop()
	{ return toStop; }

	public void setToStop(boolean toStop)
	{ this.toStop = toStop; }
}
