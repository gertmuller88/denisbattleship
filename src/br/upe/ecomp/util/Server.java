package br.upe.ecomp.util;

import java.io.IOException;
import java.net.ServerSocket;
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
	
	public Server(Observer observer) throws RemoteException
	{ this.addObserver(observer); }
	
	public void run()
	{
		try
		{
			if(ss==null)
			{ ss = new ServerSocket(1098); }
			
			Connection.setRemoteGame(Client.lookupGame(ss.accept().getInetAddress().getHostAddress()));
			
			this.setChanged();
			this.notifyObservers();
		}
		catch (IOException e)
		{ JOptionPane.showMessageDialog(ServerScreen.getInstance(), e.getMessage(), "", JOptionPane.ERROR_MESSAGE); }
		catch (NotBoundException e)
		{ JOptionPane.showMessageDialog(ServerScreen.getInstance(), e.getMessage(), "", JOptionPane.ERROR_MESSAGE); }
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
