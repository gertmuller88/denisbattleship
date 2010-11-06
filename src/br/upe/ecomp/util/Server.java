package br.upe.ecomp.util;

import java.net.ServerSocket;
import java.util.Observable;
import java.util.Observer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import br.upe.ecomp.enumeration.ConnectionMode;

public class Server extends Observable implements Runnable
{
	public Server(Observer observer)
	{ this.addObserver(observer); }
	
	public void run()
	{
		try
		{
			Connection.reset();
			Connection conn = Connection.getInstance();
			conn.setConnectionMode(ConnectionMode.Server);
			ServerSocket ss = new ServerSocket(12345);
			conn.setSocket(ss.accept());
			conn.setIn(new ObjectInputStream(conn.getSocket().getInputStream()));
			conn.setOut(new ObjectOutputStream(conn.getSocket().getOutputStream()));
			ss.close();
		}
		catch (IOException e)
		{ e.printStackTrace(); }

		this.setChanged();
		this.notifyObservers();
	}
}
