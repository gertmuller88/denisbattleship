package br.upe.ecomp.util;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ServerConnection
{
	private static ServerConnection conn;
	private static ServerSocket ss;
	private static Socket s;
	private static DataInputStream in;
	private static DataOutputStream out;
	
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

	public DataInputStream getIn()
	{ return in; }

	public void setIn(DataInputStream dataInputStream)
	{ in = dataInputStream; }

	public DataOutputStream getOut()
	{ return out; }

	public void setOut(DataOutputStream dataOutputStream)
	{ out = dataOutputStream; }
}
