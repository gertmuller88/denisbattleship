package br.upe.ecomp.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import br.upe.ecomp.model.Game;
import br.upe.ecomp.view.ServerScreen;

public class Server extends Observable implements Runnable
{
	private static ServerSocket ss;
	
	public Server(Observer observer)
	{ this.addObserver(observer); }
	
	public void run()
	{
		try
		{
			if(ss==null)
			{ ss = new ServerSocket(1098); }
			
			String host = ss.accept().getInetAddress().getHostAddress();
			Connection.setHost(host);
			Connection.setRemoteGame(Client.lookupGame(host));
		}
		catch(MalformedURLException e)
		{ JOptionPane.showMessageDialog(ServerScreen.getInstance(), "O IP digitado é inválido.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
		catch(RemoteException e)
		{ JOptionPane.showMessageDialog(ServerScreen.getInstance(), "Houve um problema com a conexão.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
		catch (NotBoundException e)
		{ JOptionPane.showMessageDialog(ServerScreen.getInstance(), "O serviço solicitado não está disponível.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
		catch(UnknownHostException e)
		{ JOptionPane.showMessageDialog(ServerScreen.getInstance(), "O IP digitado não foi encontrado na rede.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
		catch (IOException e)
		{ JOptionPane.showMessageDialog(ServerScreen.getInstance(), "Houve um problema no fluxo de entrada/saída da conexão.\n \nMessage:\n" + e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE); }
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public static void registerGameService(Game game) throws RemoteException
	{
		Registry registry = LocateRegistry.getRegistry(1099);
		
		try
		{ registry = LocateRegistry.createRegistry(1099); }
		catch(ExportException e) {}
		
		registry.rebind("RemoteGame", game);
	}
}
