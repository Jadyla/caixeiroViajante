# Caixeiro Viajante

### 💻 Tecnologias
<div style="display: flex;">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">
</div>

### 🤙 What’s up?
Este código foi desenvolvido com o objetivo de resolver o problema <b>Caixeiro Viajante</b>. Neste momento, foi aplicado um algoritmo ótimo, que possui suas limitações. 
Posteriormente, também será feita a solução através de um algoritmo genético.

### 🤔 O Problema
Suponha que um caixeiro viajante tenha de visitar <i>n</i> cidades diferentes, iniciando e encerrando sua viagem na primeira cidade. Suponha, também, que não importa a ordem 
com que as cidades são visitadas e que de cada uma delas pode-se ir diretamente a qualquer outra. O problema do caixeiro viajante consiste em <b>descobrir a rota que 
torna mínima a viagem total</b>. <a href="http://www.mat.ufrgs.br/~portosil/caixeiro.html#:~:text=O%20problema%20do%20caixeiro%20viajante%20consiste%20em%20
descobrir%20a%20rota,e%20ent%C3%A3o%20volte%20a%20A." target="_blank">Clique aqui</a> para saber mais. <br>

### ⌨️ Código
Neste caso, o código desenvolvido visou a construção de um <b>grafo direcionado</b>, ou seja, os caminhos possuem direção, e não são necessariamente de ida e volta. Além disso, 
nem todas as cidades são conectadas entre si, tudo depende dos valores da entrada.<br>
Analisando o desempenho computacional, há uma certa limitação por se tratar da construção de uma árvore e posteriormente a aplicação do método de busca em 
profundidade para criação das possibilidades de caminho, e, ao aumentar os vértices, aumenta-se enormemente as possibilidades (combinações).<br>
Dentre os arquivos estão 3 casos testes, com 5, 10 e 25 vértices, respectivamente. Ao rodar com o último arquivo, não foi possível obter resultado, pois a máquina segue
executando sem tempo determinado.<br>
Como saída obtém-se o melhor caminho e seu esforço.
