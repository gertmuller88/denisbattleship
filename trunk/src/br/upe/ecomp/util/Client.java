package br.upe.ecomp.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client
{
	public static void getConnectionTo(String host) throws UnknownHostException, IOException, NotBoundException
	{
		new Socket(host, 1098);
		Connection.setRemoteGame(Client.lookupGame(host));
	}
	
	public static RemoteGameInterface lookupGame(String host) throws MalformedURLException, RemoteException, NotBoundException
	{ return (RemoteGameInterface) Naming.lookup("rmi://" + host + "/RemoteGame"); }
}
