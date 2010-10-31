package br.upe.ecomp.util;

import java.net.ServerSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Server extends Thread
{
	public void run()
	{
		try
		{
			Connection conn = Connection.getInstance();
			conn.setServerSocket(new ServerSocket(1100));
			conn.setSocket(conn.getServerSocket().accept());
			conn.setIn(new DataInputStream(conn.getSocket().getInputStream()));
			conn.setOut(new DataOutputStream(conn.getSocket().getOutputStream()));
		}
		catch (IOException e)
		{ e.printStackTrace(); }
	}
}
