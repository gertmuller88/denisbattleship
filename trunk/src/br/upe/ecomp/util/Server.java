package br.upe.ecomp.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Observable;
import java.util.Observer;
import br.upe.ecomp.model.Game;

public class Server extends Observable implements Runnable
{
	public Server(Observer observer) throws RemoteException
	{ this.addObserver(observer); }
	
	public void run()
	{
		try
		{
			ServerSocket ss = new ServerSocket(1098);
			Socket s = ss.accept();
			String host = s.getInetAddress().getHostAddress();
			Connection.setRemoteGame(Client.lookupGame(host));
		}
		catch (IOException e)
		{ e.printStackTrace(); }
		catch (NotBoundException e)
		{ e.printStackTrace(); }
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public static void registerGameService(Game game) throws RemoteException
	{
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind("RemoteGame", game);
	}
}
