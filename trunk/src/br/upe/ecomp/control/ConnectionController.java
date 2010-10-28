package br.upe.ecomp.control;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.UnknownHostException;
import java.io.IOException;
import br.upe.ecomp.util.ClientConnection;
import br.upe.ecomp.util.Server;

public class ConnectionController
{
	private Server server;
	int i;
	
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
	
	public boolean connectToServer(String host) throws UnknownHostException, IOException
	{
		ClientConnection conn = ClientConnection.getInstance();
		conn.setSocket(new Socket(host, 1100));
		conn.setIn(new DataInputStream(conn.getSocket().getInputStream()));
		conn.setOut(new DataOutputStream(conn.getSocket().getOutputStream()));
		return true;
	}
}
