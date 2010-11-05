package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PlayerScreen extends JDialog
{
	private static PlayerScreen playerScreen;
	private String playerName;
	private JTextField nameField;
	
	private PlayerScreen()
	{
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		JLabel gameModeLabel = new JLabel("Digite seu nome:");
		gameModeLabel.setBounds(30, 20, 300, 20);
		container.add(gameModeLabel);
		
		ActionListener okListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(nameField.getText()==null || nameField.getText().equals(""))
				{ JOptionPane.showMessageDialog(null, "Você precisa digitar um nome:", "", JOptionPane.WARNING_MESSAGE); }
				else
				{
					setPlayerName(nameField.getText());
					dispose();
				}
			}
		};
		
		nameField = new JTextField();
		nameField.addActionListener(okListener);
		nameField.setBounds(30, 50, 240, 20);
		container.add(nameField);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(okListener);
		ok.setBounds(200, 85, 70, 25);
		container.add(ok);
		
		this.pack();
		this.setSize(300, 155);
		this.setResizable(false);
		this.setLayout(null);
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static PlayerScreen getInstance()
	{
		if(playerScreen==null)
		{ playerScreen = new PlayerScreen(); }
		return playerScreen;
	}
	
	public void reset()
	{
		this.nameField.setText(null);
		this.playerName = null;
		this.setLocationRelativeTo(null);
	}
	
	public String getPlayerName()
	{ return this.playerName; }
	
	public void setPlayerName(String playerName)
	{ this.playerName = playerName; }
}
