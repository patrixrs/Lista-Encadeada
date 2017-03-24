# Lista-Encadeada
## Trabalho Final Algoritmos 2 - ADS SENAC RS

Objetivo:

Demostrar a aquisição das competências trabalhadas ao longo do semestre.

Tarefas Obrigatórias:

1. Implementar uma lista duplamente encadeada (a partir da implementação de lista com encadeamento simples disponível no repositório Git da turma);

2. Demonstrar a utilização correta do Git, gravando cada "feature" implementada. Por exemplo, você implementa a remoção de elementos da lista duplamente encadeada e faz o "commit" com a mensagem "Implementação de remoção para a lista duplamente encadeada" no git.

3. Você não pode utilizar nenhuma CLASSE do pacote java.util.*, com exceção da classes Scanner, Formatter, Locale e Random. Você pode utilizar qualquer INTERFACE do pacote java.util.*.

4. Implementar uma das aplicações propostas.

Aplicações:

a) Implementar uma lista indexada para melhorar o tempo de pesquisa de dados em um grande volume de dados. Para isso, você deve implementar a leitura do arquivo de dados e modificar a estrutura de lista encadeada para modificar a inserção de forma que a lista crie um índice, e inserir um método de pesquisa de elementos.

b) Implementar uma planilha de cálculos, baseada na interface gráfica e na classe de avaliação de expressões disponibilizadas. Nesta aplicação você deve implementar uma matriz esparsa utilizando listas encadeadas.

---------------- * ----------------------

Lista Indexada
==============

O objetivo desta aplicação é acelerar o processo de procura de um elemento em uma lista encadeada. Para isso, você deve modificar a lista duplamente encadeada de forma que seja possível inserir os dados de forma ordenada na estrutura, e que seja possível criar "pulos" entre os elementos da lista.

A implementação desta lista pode ser realizada com o uso de várias listas encadeadas (uma para cada nível), ou modificando os nós da lista, armazenando apontadores extras nesses nós (veja as figuras).
