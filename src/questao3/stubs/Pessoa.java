package questao3.stubs;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Pessoa implements Postman {

	private String nome;
	private Registry registro;

	public Pessoa(String nome) throws RemoteException, MalformedURLException {
		this.setNome(nome);
		System.out.println(nome + ": Criado!");

		Postman stub = (Postman) UnicastRemoteObject.exportObject(this, 0);
		registro = LocateRegistry.getRegistry();
		registro.rebind(getNome(), stub);

		System.out.println(nome + ": E registrado!");
	}

	public void sendMessage(String message, String reciever) {
			System.out.println(nome + ": Vou enviar uma mensagem para " + reciever);
			System.out.println(nome + ": " + message);
		try {
			
			Postman pessoa;
			pessoa = (Postman) registro.lookup(reciever);
			pessoa.receiveMessage(message, nome);
			
		} catch (RemoteException | NotBoundException e1) {
			e1.printStackTrace();
		}

	}

	public void receiveMessage(String message, String sender) {
		System.out.println(nome + ": Recebi uma mensagem do " + sender + "!");
		System.out.println(nome + ": " + sender + " diz: " + message);
	}

	public void sendBroadCast(String message) {
		System.out.println(nome + ": Vou mandar mensagem pra todo mundo");
		System.out.println(nome + ": " + message);

		String[] pessoas;
		try {
			pessoas = registro.list();
			for (String pnome : pessoas) {
				if (!pnome.equals(nome)) {
					Postman p = (Postman) registro.lookup(pnome);
					p.receiveMessage(message, nome);
				}
			}
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
