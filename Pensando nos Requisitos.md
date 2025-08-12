Este arquivo deverá ser reorganizado caso a atividades seguintes utilizem esse sistema, especialmente que não foram
adicionadas as etapas já concluídas de boa maneira, estou tratando esse arquivo como um BrainStorm nesse primeiro
 momento.<br><br>
O sistema deve ser possuir uma classe para estruturar as coisas como em POO tanto para as vendas quanto
para o próprio sistema que lida com os produtos.<br><br>
Os Menus são classes à parte do Main onde serão executados e são ao menos 3: <br>Menu que lida com os produtos do 
ponto vista do Sistema <br>Menu que lida com os produtos do ponto vista das Vendas; <br>Menu cujas opções servem 
ao desenvolvedor para testar o sistema não precisando manualmente reinserir nada a cada fechamento e abertura do sistema
bem como possa apagar os arquivos movidos para a pasta do projeto durante os testes.<br><br>
No primeiro momento não será feito um menu para lidar com estoque de ingredientes, lido com os funcionários e outras
coisas apenas o necessário para o funcionamento do sistema de vendas (pagamento também não incluso) mas poderá ser feito
a depender de como a atividade prossiga.<br>
O sistema já possui o local onde ficam armazenadas as imagens dos produtos e já é possível adicionar, remover e 
listar os produtos, bem como editar os mesmos.<br> Para editar e remover ao lidar com os produtos em seu sistema ou
adicionar e remover produtos no sistema de vendas, será usado o ID do produto que é um número inteiro.
<br><br>Como não estão sendo usados bancos de dados no primeiro momento, o sistema salva os produtos em um ArrayList e mais pra 
frente posso ver a questão de persistência dos dados entre sessões com ".txt" ou ".json" mas isso abre precedente para 
ser necessário verificar no sistema se a imagem apontada pela persistência existe nos arquivos do projeto bem como se as
imagens que existem estão listadas.<br><br>
Estou pensando sobre a classe Produto, como eu poderia fazer para que a venda uma vez gerada não fosse editável, uma
maneira de contornar isso que eu pensei foi uma classe LOG com Data/Hora e a alteração mas não faz muito sentido sem um
 banco de dados.

Precisava separar as classes de maneira correta, preciso pesquisar sobre porque é improvavel que o correto em POO fosse
 tão bagunçado quanto deixar tudo em src.