package br.upe.ecomp.util;

import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.io.IOException;
import br.upe.ecomp.enumeration.ConnectionMode;

public class ConnectionManager
{
	public static void getConnectionTo(String host) throws UnknownHostException, IOException
	{
		Connection.reset();
		Connection conn = Connection.getInstance();
		conn.setConnectionMode(ConnectionMode.Client);
		conn.setSocket(new Socket(host, 12345));
		conn.setOut(new ObjectOutputStream(conn.getSocket().getOutputStream()));
		conn.setIn(new ObjectInputStream(conn.getSocket().getInputStream()));
	}
}
