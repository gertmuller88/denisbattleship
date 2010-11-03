package br.upe.ecomp.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection
{
	private static ServerConnection conn;
	private static ServerSocket ss;
	private static Socket s;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	
	private ServerConnection() {}
	
	public static ServerConnection getInstance()
	{
		if(conn==null)
		{ return new ServerConnection(); }
		return conn;
	}

	public ServerSocket getServerSocket()
	{ return ss; }

	public void setServerSocket(ServerSocket serverSocket)
	{ ss = serverSocket; }

	public Socket getSocket()
	{ return s; }

	public void setSocket(Socket socket)
	{ s = socket; }

	public ObjectInputStream getIn()
	{ return in; }

	public void setIn(ObjectInputStream objectInputStream)
	{ in = objectInputStream; }

	public ObjectOutputStream getOut()
	{ return out; }

	public void setOut(ObjectOutputStream objectOutputStream)
	{ out = objectOutputStream; }
}
