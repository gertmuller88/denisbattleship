package br.upe.ecomp.util;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Connection
{
	public enum ConnectionMode
	{
		Client,
		Server;
	}
	
	private static Connection conn;
	private static ConnectionMode connectionMode;
	private static ServerSocket ss;
	private static Socket s;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	
	private Connection() {}
	
	public static Connection getInstance()
	{
		if(conn==null)
		{ return new Connection(); }
		return conn;
	}

	public ConnectionMode getConnectionMode()
	{ return connectionMode; }

	public void setConnectionMode(ConnectionMode connectionMode)
	{ Connection.connectionMode = connectionMode; }

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
	
	public void reset()
	{ conn = null; }
}