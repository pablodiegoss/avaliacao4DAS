# RMI e o DBC

É possível perceber os itens de uma arquitetura Java RMI como um desenvolvimento orientado a componentes. Esta analogia é possível ser visualizada levando em consideração os elementos de Stub, Registro, Skeletons e Serialização com os Três elementos DBC de Componentes, Modelos e Frameworks de Componentes.

Stubs se assemelham aos componentes definidos por Spagnoli e Becker (2003), pois são partes do sistema que encapsulam determinadas funcionalidades e as fornecem como recursos através de um padrão de comunicação definido pelo RMI. Os stubs agem como um proxy que faz a comunicação entre a chamada do método local com a execução do método remoto.

Os Skeletons juntamente com o Registro podem ser entendidos como o framework definido por Spagnoli e Becker (2003). Os Skeletons recebem a chamadas dos Stubs(Componentes) e redirecionam para a implementação real (Recurso), assim os skeletons não possuem as implementações dos métodos, mas sabem onde encontrá-las e realiza esse trabalho de mediador e gerenciador de recursos e componentes da aplicação. 

O Registro então pode ser visto como um repositório e auxiliador da gerência de recursos da aplicação, sendo o responsável por conectar novos recursos ao barramento do framework, indicando para o skeleton onde está o recurso e sua disponibilidade.

Toda esta comunicação da aplicação que permite a invocação remota de métodos só é possível através dos padrões e regras definidos, como o processo de serialização (Marshalling) e deserialização (Unmarshalling) de respostas e mensagens. Estes padrões e as regras podem ser vistos como um modelo de componentes, que impõe as regras aos componentes stubs e skeletons para que a comunicação remota da aplicação funcione.
 