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
public class WaitShipsScreen extends JDialog
{
	private static WaitShipsScreen waitShipsScreen;
	private boolean toStop = false;
	
	private WaitShipsScreen()
	{
		super(MainScreen.getInstance(null), true);
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		JLabel waitLabel = new JLabel("Aguarde, seu oponente está posicionando as embarcações...");
		waitLabel.setBounds(30, 15, 300, 20);
		container.add(waitLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setBounds(30, 50, 300, 20);
		container.add(progressBar);
		
		JButton exit = new JButton("Sair");
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				setToStop(true);
				dispose();
			}
		});
		exit.setBounds(260, 85, 70, 25);
		container.add(exit);
		
		this.pack();
		this.setSize(360, 150);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	public static WaitShipsScreen getInstance()
	{
		if(waitShipsScreen==null)
		{ waitShipsScreen = new WaitShipsScreen(); }
		return waitShipsScreen;
	}

	public boolean isToStop()
	{ return toStop; }

	public void setToStop(boolean toStop)
	{ this.toStop = toStop; }

	public void run()
	{ this.setVisible(true); }
}
