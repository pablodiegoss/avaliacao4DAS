package questao3.stubs;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Postman extends Remote {
	public void sendMessage(String message, String reciever) throws RemoteException;
	public void receiveMessage(String message, String sender) throws RemoteException;
	public void sendBroadCast(String message) throws RemoteException;
}
