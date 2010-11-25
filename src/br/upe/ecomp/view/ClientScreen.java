package br.upe.ecomp.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class ClientScreen extends JDialog
{
	private static ClientScreen clientScreen;
	private String host;
	private JFormattedTextField oct1, oct2, oct3, oct4;
	
	private ClientScreen()
	{
		super(MainScreen.getInstance(null), true);
		Container container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		
		JLabel gameModeLabel = new JLabel("Digite o IP do servidor a se conectar:");
		gameModeLabel.setBounds(30, 15, 300, 20);
		container.add(gameModeLabel);
		
		MaskFormatter ipMask1 = new MaskFormatter();
		try
		{
			ipMask1.setMask("#**");
			ipMask1.setValidCharacters("0123456789");
			ipMask1.setPlaceholderCharacter(' ');
		}
		catch(ParseException e)
		{ e.printStackTrace(); }
		
		oct1 = new JFormattedTextField(ipMask1);
		oct1.setHorizontalAlignment(JFormattedTextField.CENTER);
		oct1.setFocusLostBehavior(JFormattedTextField.COMMIT);
		oct1.setBounds(30, 50, 50, 20);
		oct1.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
				if(oct1.getText().trim().length()==3 && Integer.parseInt(oct1.getText().trim())>255)
				{
					JOptionPane.showMessageDialog(ClientScreen.getInstance(), "O número digitado precisa ser entre 0 e 255.", "", JOptionPane.WARNING_MESSAGE);
					oct1.setText(null);
				}
				
				if(e.getKeyChar()=='.' || oct1.getText().trim().length()==3)
				{ oct1.transferFocus(); }
			}
		});
		container.add(oct1);
		
		JLabel pt1 = new JLabel(".");
		pt1.setBounds(84, 52, 5, 20);
		container.add(pt1);
		
		MaskFormatter ipMask2 = new MaskFormatter();
		try
		{
			ipMask2.setMask("#**");
			ipMask2.setValidCharacters("0123456789");
			ipMask2.setPlaceholderCharacter(' ');
		}
		catch(ParseException e)
		{ e.printStackTrace(); }
		
		oct2 = new JFormattedTextField(ipMask2);
		oct2.setHorizontalAlignment(JFormattedTextField.CENTER);
		oct2.setFocusLostBehavior(JFormattedTextField.COMMIT);
		oct2.setBounds(90, 50, 50, 20);
		oct2.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
				if(oct2.getText().trim().length()==3 && Integer.parseInt(oct2.getText().trim())>255)
				{
					JOptionPane.showMessageDialog(ClientScreen.getInstance(), "O número digitado precisa ser entre 0 e 255.", "", JOptionPane.WARNING_MESSAGE);
					oct2.setText(null);
				}
				
				if(e.getKeyChar()=='.' || oct2.getText().trim().length()==3)
				{ oct2.transferFocus(); }
			}
		});
		container.add(oct2);
		
		JLabel pt2 = new JLabel(".");
		pt2.setBounds(144, 52, 5, 20);
		container.add(pt2);
		
		MaskFormatter ipMask3 = new MaskFormatter();
		try
		{
			ipMask3.setMask("***");
			ipMask3.setValidCharacters("0123456789");
			ipMask3.setPlaceholderCharacter(' ');
		}
		catch(ParseException e)
		{ e.printStackTrace(); }
		
		oct3 = new JFormattedTextField(ipMask3);
		oct3.setHorizontalAlignment(JFormattedTextField.CENTER);
		oct3.setFocusLostBehavior(JFormattedTextField.COMMIT); 
		oct3.setBounds(150, 50, 50, 20);
		oct3.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
				if(oct3.getText().trim().length()==3 && Integer.parseInt(oct3.getText().trim())>255)
				{
					JOptionPane.showMessageDialog(ClientScreen.getInstance(), "O número digitado precisa ser entre 0 e 255.", "", JOptionPane.WARNING_MESSAGE);
					oct3.setText(null);
				}
				
				if(e.getKeyChar()=='.' || oct3.getText().trim().length()==3)
				{ oct3.transferFocus(); }
			}
		});
		container.add(oct3);
		
		JLabel pt3 = new JLabel(".");
		pt3.setBounds(204, 52, 5, 20);
		container.add(pt3);
		
		MaskFormatter ipMask4 = new MaskFormatter();
		try
		{
			ipMask4.setMask("#**");
			ipMask4.setValidCharacters("0123456789");
			ipMask4.setPlaceholderCharacter(' ');
		}
		catch(ParseException e)
		{ e.printStackTrace(); }
		
		oct4 = new JFormattedTextField(ipMask4);
		oct4.setHorizontalAlignment(JFormattedTextField.CENTER);
		oct4.setFocusLostBehavior(JFormattedTextField.COMMIT); 
		oct4.setBounds(210, 50, 50, 20);
		oct4.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
				if(oct4.getText().trim().length()==3 && Integer.parseInt(oct4.getText().trim())>255)
				{
					JOptionPane.showMessageDialog(ClientScreen.getInstance(), "O número digitado precisa ser entre 0 e 255.", "", JOptionPane.WARNING_MESSAGE);
					oct4.setText(null);
				}
				
				if(e.getKeyChar()=='.' || oct4.getText().trim().length()==3)
				{ oct4.transferFocus(); }
			}
		});
		container.add(oct4);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				setHost(oct1.getText().trim() + "." + oct2.getText().trim() + "." + oct3.getText().trim() + "." + oct4.getText().trim());
				dispose();
			}
		});
		ok.setBounds(190, 85, 70, 25);
		container.add(ok);
		
		this.pack();
		this.setSize(300, 155);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static ClientScreen getInstance()
	{
		if(clientScreen==null)
		{ clientScreen = new ClientScreen(); }
		return clientScreen;
	}
	
	public void reset()
	{
		oct1.setText(null);
		oct2.setText(null);
		oct3.setText(null);
		oct4.setText(null);
		host = null;
		this.setLocationRelativeTo(null);
	}
	
	public String getHost()
	{ return this.host; }
	
	public void setHost(String host)
	{ this.host = host; }
}
