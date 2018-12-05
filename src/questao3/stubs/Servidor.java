package questao3.stubs;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class Servidor {
	/**Esta é uma classe servidor, para um software RMI 
	deve ser criado um registro em alguma porta que os objetos remotos irão se conectar
	Utilizando LocateRegistry.createRegistry(PORTA);
	
	Neste caso que é executado de forma não distríbuida, será utilizado o registro RMI padrão local da porta 1099.
	*/
	public static void main(String[] args) {
		// Os objetos Pessoa aqui definidos representam instâncias que podem ser remotas da aplicação.
		Pessoa p1 = null;
		Pessoa p2 = null;
		Pessoa p3 = null;
		Pessoa p4 = null;
		
		try {
			// A criação destes objetos pode retornar exceções relacionadas a conexão e a URL dos objetos.
			// Devido a conexão realizada ao registro dentro do construtor
			// Assim que você cria uma nova pessoa, esta irá se registrar ao sistema e estará disponível.
			p1 = new Pessoa("Pablo");
			p2 = new Pessoa("Rodrigo");
			p3 = new Pessoa("Hugo");
			p4 = new Pessoa("Fabíola");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
		
		// Abaixo temos alguns exemplos de módulos que poderiam ser executados remotamente através de um software distribuido.

		// Um objeto remoto que irá tentar se comunicar com a pessoa de nome "Rodrigo"
		p1.sendMessage("OI!", p2.getNome());
		
		// O Rodrigo irá enviar esta mensagem a todas as pessoas conectadas no sistema.
		p2.sendBroadCast("OI GALERA!");
		
		// Outra pessoa se comunicando diretamente com nosso quarto exemplo.
		p3.sendMessage("Olá", p4.getNome());
	}
}
