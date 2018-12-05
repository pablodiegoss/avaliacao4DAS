package questao3.stubs;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
	public static void main(String[] args) {
		Pessoa p1 = null;
		Pessoa p2 = null;
		Pessoa p3 = null;
		Pessoa p4 = null;
		
		try {
			p1 = new Pessoa("Pablo");
			p2 = new Pessoa("Rodrigo");
			p3 = new Pessoa("Hugo");
			p4 = new Pessoa("Fabíola");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}

		p1.sendMessage("OI!", "Rodrigo");
		p2.sendBroadCast("OI GALERA!");
	}
}
