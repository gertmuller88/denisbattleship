package br.upe.ecomp.util;

import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.io.IOException;

public class ConnectionManager
{
	public void getConnectionTo(String host) throws UnknownHostException, IOException
	{
		Connection conn = Connection.getInstance();
		conn.setConnectionMode(ConnectionMode.Client);
		conn.setSocket(new Socket(host, 1100));
		conn.setOut(new ObjectOutputStream(conn.getSocket().getOutputStream()));
		conn.setIn(new ObjectInputStream(conn.getSocket().getInputStream()));
	}
}
