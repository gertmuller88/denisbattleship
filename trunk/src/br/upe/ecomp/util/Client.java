package br.upe.ecomp.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import br.upe.ecomp.model.Game;

public class Client
{
	public static void getConnectionTo(String host) throws MalformedURLException, RemoteException, NotBoundException, UnknownHostException, IOException
	{
		new Socket(host, 1098);
		Connection.setHost(host);
		Connection.setRemoteGame(Client.lookupGame(host));
	}
	
	public static Game lookupGame(String host) throws MalformedURLException, RemoteException, NotBoundException
	{ return (Game) Naming.lookup("rmi://" + host + "/RemoteGame"); }
}
