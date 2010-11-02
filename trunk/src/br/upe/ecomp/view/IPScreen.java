package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class IPScreen extends JDialog
{
	private static IPScreen ipScreen;
	private String ip;
	private JTextField oct1, oct2, oct3, oct4;
	
	private IPScreen()
	{
		this.setTitle("Conexão - Denis' BattleShip (EComp/UPE)");
		
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		JLabel gameModeLabel = new JLabel("Digite o IP do servidor a se conectar:");
		gameModeLabel.setBounds(30, 15, 300, 20);
		container.add(gameModeLabel);
		
		oct1 = new JTextField();
		oct1.setBounds(30, 50, 50, 20);
		container.add(oct1);
		
		JLabel pt1 = new JLabel(".");
		pt1.setBounds(84, 52, 5, 20);
		container.add(pt1);
		
		oct2 = new JTextField();
		oct2.setBounds(90, 50, 50, 20);
		container.add(oct2);
		
		JLabel pt2 = new JLabel(".");
		pt2.setBounds(144, 52, 5, 20);
		container.add(pt2);
		
		oct3 = new JTextField();
		oct3.setBounds(150, 50, 50, 20);
		container.add(oct3);
		
		JLabel pt3 = new JLabel(".");
		pt3.setBounds(204, 52, 5, 20);
		container.add(pt3);
		
		oct4 = new JTextField();
		oct4.setBounds(210, 50, 50, 20);
		container.add(oct4);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ip = new String(oct1.getText() + "." + oct2.getText() + "." + oct3.getText() + "." + oct4.getText());
				dispose();
			}
		});
		ok.setBounds(190, 85, 70, 25);
		container.add(ok);
		
		this.pack();
		this.setSize(300, 150);
		this.setResizable(false);
		this.setLayout(null);
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static IPScreen getInstance()
	{
		if(ipScreen==null)
		{ ipScreen = new IPScreen(); }
		return ipScreen;
	}
	
	public void reset()
	{
		oct1.setText(null);
		oct2.setText(null);
		oct3.setText(null);
		oct4.setText(null);
		ip = null;
		this.setLocationRelativeTo(null);
	}
	
	public String getIP()
	{ return this.ip; }
	
	public void setIP(String ip)
	{ this.ip = ip; }
}
