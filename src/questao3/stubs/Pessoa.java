package questao3.stubs;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* Esta é a nossa classe Pessoa que irá se comunicar com outras pessoas
 * É identificada por um nome único para questões semânticas da aplicação.
 * Esta classe pode ser entendida como um componente da aplicação que irá se conectar 
 * a outros componentes através do Registry e procurar "recursos" e enviar mensagens para outras pessoas.
 */
public class Pessoa implements Postman {

	// Identificador único.
	private String nome;

	// Registro na qual esta pessoa pertence.
	private Registry registro;

	public Pessoa(String nome) throws RemoteException, MalformedURLException {
		// A criação de uma pessoa e o preenchimento de seus atributos.
		this.setNome(nome);
		System.out.println(nome + ": Criado!");

		// Neste momento iremos obter um objeto stub a partir desta pessoa.
		Postman stub = (Postman) UnicastRemoteObject.exportObject(this, 0);

		// Aqui obtemos o registro padrão através do get sem parametros, um registro na
		// porta default 1099.
		registro = LocateRegistry.getRegistry();

		// Inserimos o stub desta pessoa no registro.
		// este stub servirá como proxy para que objetos remotos acessem esta pessoa.
		registro.rebind(getNome(), stub);

		// A partir de agora este "componente" pessoa está conectado ao sistema e
		// disponível para conexões.
		System.out.println(nome + ": E registrado!");
	}

	/*
	 * Método de enviar mensagens para outras pessoas. Recebendo como parâmetros a
	 * mensagem e o destinatário. Esta decisão é apenas para facilitar a simulação
	 * do sistema distribuido na Main.
	 */
	public void sendMessage(String message, String reciever) {
		System.out.println(nome + ": Vou enviar uma mensagem para " + reciever);
		System.out.println(nome + ": " + message);

		// Utilizando o registro desta pessoa iremos buscar um stub registrado com este
		// nome salvo em reciever.
		try {
			// Caso a pessoa que procuro esteja registrada, um objeto proxy de Postman
			// será retornado, sendo este o stub que foi registrado no Registry
			// no construtor da classe pessoa.
			Postman pessoa = (Postman) registro.lookup(reciever);

			// Método Remoto definido na interface que recebe mensagens e a exibe na tema.
			pessoa.receiveMessage(message, nome);
		} catch (RemoteException | NotBoundException e1) {
			// Caso a execução remota não funcione temos a RemoteException
			// Caso o destinatário não tenha realizado o Bind no Registry,
			// este não está conectado e temos a NotBountException
			e1.printStackTrace();
		}
	}

	// Método para recebimento e exibição de mensagens.
	public void receiveMessage(String message, String sender) {
		System.out.println(nome + ": Recebi uma mensagem do " + sender + "!");
		System.out.println(nome + ": " + sender + " diz: " + message);
	}

	// Método para envio de mensagens a todas as pessoas conectadas.
	// O parâmetro message foi definido para melhor semântica na Main do sistema e
	// simulação da execução distribuida.
	public void sendBroadCast(String message) {
		System.out.println(nome + ": Vou mandar mensagem pra todo mundo");
		System.out.println(nome + ": " + message);

		String[] pessoas;
		try {
			// Para enviar uma mensagem a todas as pessoas, podemos obter os nomes que
			// realizaram Bind no registro.
			pessoas = registro.list();
			for (String nome : pessoas) {
				// Como a pessoa atual também está conectada e disponível no registro,
				// enviaremos mensagem a todas elas, menos a si mesmo.
				if (!nome.equals(this.nome)) {
					// Acesso ao stub de cada pessoa encontrada para que acessemos seu método
					// remotamente.
					Postman p = (Postman) registro.lookup(nome);
					p.receiveMessage(message, nome);
				}
			}
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	// Getters and Setters.
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
