package br.upe.ecomp.util;

import java.net.ServerSocket;
import java.util.Observable;
import java.util.Observer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Server extends Observable implements Runnable
{
	public Server(Observer observer)
	{ this.addObserver(observer); }
	
	public void run()
	{
		try
		{
			Connection conn = Connection.getInstance();
			conn.setConnectionMode(ConnectionMode.Server);
			conn.setServerSocket(new ServerSocket(1100));
			conn.setSocket(conn.getServerSocket().accept());
			conn.setIn(new ObjectInputStream(conn.getSocket().getInputStream()));
			conn.setOut(new ObjectOutputStream(conn.getSocket().getOutputStream()));
		}
		catch (IOException e)
		{ e.printStackTrace(); }

		this.setChanged();
		this.notifyObservers();
	}
}
