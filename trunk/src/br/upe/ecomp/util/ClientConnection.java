package br.upe.ecomp.util;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ClientConnection
{
	private static ClientConnection conn;
	private static Socket s;
	private static DataInputStream in;
	private static DataOutputStream out;
	
	private ClientConnection() {}
	
	public static ClientConnection getInstance()
	{
		if(conn==null)
		{ return new ClientConnection(); }
		return conn;
	}

	public Socket getSocket()
	{ return s; }

	public void setSocket(Socket socket)
	{ s = socket; }

	public DataInputStream getIn()
	{ return in; }

	public void setIn(DataInputStream dataInputStream)
	{ in = dataInputStream; }

	public DataOutputStream getOut()
	{ return out; }

	public void setOut(DataOutputStream dataOutputStream)
	{ out = dataOutputStream; }
}
