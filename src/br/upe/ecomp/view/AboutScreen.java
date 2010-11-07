package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AboutScreen extends JDialog
{
	private static AboutScreen aboutScreen;
	
	private AboutScreen()
	{
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		ImageIcon imageLogo = new ImageIcon("images/ui/about.png");
		JLabel logo = new JLabel(imageLogo);
		logo.setBounds(0, 0, 66, 276);
		container.add(logo);
		
		JLabel gameName = new JLabel("© Denis' BattleShip");
		gameName.setBounds(94, 20, 100, 20);
		container.add(gameName);
		
		JLabel version = new JLabel("Versão 0.1");
		version.setBounds(94, 40, 100, 15);
		container.add(version);
		
		JLabel label1 = new JLabel("Este software foi desenvolvido por:");
		label1.setBounds(94, 80, 250, 15);
		container.add(label1);
		
		JLabel label2 = new JLabel("   - Anthony Lins;");
		label2.setBounds(94, 100, 250, 15);
		container.add(label2);
		
		JLabel label3 = new JLabel("   - Gert Müller;");
		label3.setBounds(94, 115, 250, 15);
		container.add(label3);
		
		JLabel label4 = new JLabel("   - Maurício Manoel.");
		label4.setBounds(94, 130, 250, 15);
		container.add(label4);
		
		JLabel label5 = new JLabel("Idealizado por Denis Silveira.");
		label5.setBounds(94, 170, 250, 15);
		container.add(label5);
		
		JLabel label6 = new JLabel("Mestrado Eng. de Computação (UPE)");
		label6.setBounds(94, 185, 250, 15);
		container.add(label6);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{ dispose(); }
		});
		ok.setBounds(255, 234, 70, 25);
		container.add(ok);
		
		this.pack();
		this.setSize(350, 304);
		this.setResizable(false);
		this.setLayout(null);
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static AboutScreen getInstance()
	{
		if(aboutScreen==null)
		{ aboutScreen = new AboutScreen(); }
		return aboutScreen;
	}
}
