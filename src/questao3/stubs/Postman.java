package questao3.stubs;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Esta é a nossa interface Serializavel que irá permitir a execução dos métodos remotos através dos stubs.
public interface Postman extends Remote {
	/* Importante fixar que todas os métodos descritos em uma interface Remote 
	devem jogar a exceção RemoteException para serem uma interface válida Java RMI.
	*/
	public void sendMessage(String message, String reciever) throws RemoteException;
	public void receiveMessage(String message, String sender) throws RemoteException;
	public void sendBroadCast(String message) throws RemoteException;
}
