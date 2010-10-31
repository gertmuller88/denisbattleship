package br.upe.ecomp.util;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.UnknownHostException;
import java.io.IOException;

public class ConnectionManager
{
	private Server server;
	
	public void startServer()
	{
		server = new Server();
		server.start();
	}
	
	@SuppressWarnings("deprecation")
	public void stopServer()
	{
		server.stop();
		server.destroy();
	}
	
	public boolean getConnectionTo(String host) throws UnknownHostException, IOException
	{
		Connection conn = Connection.getInstance();
		conn.setSocket(new Socket(host, 1100));
		conn.setIn(new DataInputStream(conn.getSocket().getInputStream()));
		conn.setOut(new DataOutputStream(conn.getSocket().getOutputStream()));
		return true;
	}
}
