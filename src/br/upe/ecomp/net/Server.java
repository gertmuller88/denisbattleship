package br.upe.ecomp.net;

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
			ServerConnection conn = ServerConnection.getInstance();
			System.out.println("Cria o servidor.");
			conn.setServerSocket(new ServerSocket(1100));
			System.out.println("Aguarda conexões.");
			conn.setSocket(conn.getServerSocket().accept());
			System.out.println("Conectou!");
			conn.setIn(new ObjectInputStream(conn.getSocket().getInputStream()));
			System.out.println("O input foi obtido com sucesso.");
			conn.setOut(new ObjectOutputStream(conn.getSocket().getOutputStream()));
			System.out.println("O output também.");
		}
		catch (IOException e)
		{ e.printStackTrace(); }

		this.setChanged();
		this.notifyObservers(new Boolean(true));
	}
}
