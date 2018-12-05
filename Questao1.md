
# Componentes

Componentes são partes autocontidas (que não dependem de outros componentes) de um sistema de software, que são feitas de forma genérica, possuem documentação específica e portanto podem ser utilizadas novamente em outros sistemas.

O papel dos componentes no DBC é encapsular a implementação das funcionalidades providas e interagir com o abiente através de interfaces bem definidas pelo modelo de componentes.

# Modelo de Componentes
Os modelos de componentes são responsáveis por definir um conjunto de padrões e convenções que os componentes do sistema deverão se adequar, como o tipo dos componentes, as suas formas de interação e definição de recursos. Isto pode ser entendido como uma abstração arquitetural que irá expressar um modelo que permita realizar a coordenação destes componentes do software, descrevendo a função de cada um e como eles irão interagir, implementando então as restrições do projeto arquitetural do sistema.

O papel do modelo de componentes no DBC é garantir a adequação dos componentes a arquitetura do software e sua interface de interação com o sistema. Se um determinado componente não se adequar ao modelo, ele pode não corresponder as atividades do software ou mesmo de outros componentes no qual ele está se propondo a realizar.

# Framework de Componentes

O Framework de Componentes é a estrutura que dará suporte ao modelo de componentes e sua função é gerenciar recursos e a comunicação entre componentes. O Framework assim como o modelo de componentes impõe restrições ao projeto e seus componentes principalmente em relação aos recursos compartilhados e do sistema, devendo então ser considerado também na arquitetura do sistema.

O papel do framework é de respeitar e regular as defnições estabelecidas pelo modelo de componentes, fazendo com que diferentes aplicações não tenham que se preocupar em implentar protocolos para troca de mensagem e conexão de componentes. O framework então, age como um barramento, conectando todos os componentes e gerenciando suas peculiaridades.