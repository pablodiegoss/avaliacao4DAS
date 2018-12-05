# 4ª Avaliação de Desenvolvimento Avançado de Software 2018/2

## Pablo Diego Silva da Silva 15/0019475
## Rodrigo Oliveira Campos 15/0021399

Repositório para resolução da avaliação 4 de Desenvolvimento Avançado de Software - 2018/2


# Questão 1

## Componentes

Componentes são partes autocontidas (que não dependem de outros componentes) de um sistema de software, que são feitas de forma genérica, possuem documentação específica e portanto podem ser utilizadas novamente em outros sistemas.

O papel dos componentes no DBC é encapsular a implementação das funcionalidades providas e interagir com o abiente através de interfaces bem definidas pelo modelo de componentes.


## Modelo de Componentes

Os modelos de componentes são responsáveis por definir um conjunto de padrões e convenções que os componentes do sistema deverão se adequar, como o tipo dos componentes, as suas formas de interação e definição de recursos. Isto pode ser entendido como uma abstração arquitetural que irá expressar um modelo que permita realizar a coordenação destes componentes do software, descrevendo a função de cada um e como eles irão interagir, implementando então as restrições do projeto arquitetural do sistema.

O papel do modelo de componentes no DBC é garantir a adequação dos componentes a arquitetura do software e sua interface de interação com o sistema. Se um determinado componente não se adequar ao modelo, ele pode não corresponder as atividades do software ou mesmo de outros componentes no qual ele está se propondo a realizar.


## Framework de Componentes

O Framework de Componentes é a estrutura que dará suporte ao modelo de componentes e sua função é gerenciar recursos e a comunicação entre componentes. O Framework assim como o modelo de componentes impõe restrições ao projeto e seus componentes principalmente em relação aos recursos compartilhados e do sistema, devendo então ser considerado também na arquitetura do sistema.

O papel do framework é de respeitar e regular as defnições estabelecidas pelo modelo de componentes, fazendo com que diferentes aplicações não tenham que se preocupar em implentar protocolos para troca de mensagem e conexão de componentes. O framework então, age como um barramento, conectando todos os componentes e gerenciando suas peculiaridades.


# Questão 2

## RMI e o DBC

É possível perceber os itens de uma arquitetura Java RMI como um desenvolvimento orientado a componentes. Esta analogia é possível ser visualizada levando em consideração os elementos de Stub, Registro, Skeletons e Serialização com os Três elementos DBC de Componentes, Modelos e Frameworks de Componentes.

Stubs se assemelham aos componentes definidos por Spagnoli e Becker (2003), pois são partes do sistema que encapsulam determinadas funcionalidades e as fornecem como recursos através de um padrão de comunicação definido pelo RMI. Os stubs agem como um proxy que faz a comunicação entre a chamada do método local com a execução do método remoto.

Os Skeletons juntamente com o Registro podem ser entendidos como o framework definido por Spagnoli e Becker (2003). Os Skeletons recebem a chamadas dos Stubs(Componentes) e redirecionam para a implementação real (Recurso), assim os skeletons não possuem as implementações dos métodos, mas sabem onde encontrá-las e realiza esse trabalho de mediador e gerenciador de recursos e componentes da aplicação. 

O Registro então pode ser visto como um repositório e auxiliador da gerência de recursos da aplicação, sendo o responsável por conectar novos recursos ao barramento do framework, indicando para o skeleton onde está o recurso e sua disponibilidade.

Toda esta comunicação da aplicação que permite a invocação remota de métodos só é possível através dos padrões e regras definidos, como o processo de serialização (Marshalling) e deserialização (Unmarshalling) de respostas e mensagens. Estes padrões e as regras podem ser vistos como um modelo de componentes, que impõe as regras aos componentes stubs e skeletons para que a comunicação remota da aplicação funcione.
 
