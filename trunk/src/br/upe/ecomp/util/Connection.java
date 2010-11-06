package br.upe.ecomp.util;

import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import br.upe.ecomp.enumeration.ConnectionMode;

public class Connection
{
	private static Connection conn;
	private static ConnectionMode connectionMode;
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
	
	public static void reset()
	{ conn = new Connection(); }
}
