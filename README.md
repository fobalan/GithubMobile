# Criar um aplicativo de consulta a API do [GitHub](https://github.com)#

Criar um aplicativo para consultar a API do GitHub e trazer os repositórios mais populares de Kotlin. Basear-se no mockup fornecido:

![bitbucket.png](https://bitbucket.org/repo/7ndaaA/images/3102804929-Captura%20de%20tela%20de%202015-10-22%2011-28-03.png)

### **Deve conter** ###

- __Lista de repositórios__. Exemplo de chamada na API: https://api.github.com/search/repositories?q=language:kotlin&sort=stars&page=1`
  * Paginação na tela de lista, com endless scroll / scroll infinito (incrementando o parâmetro page).
  * Cada repositório deve exibir Nome do repositório, Descrição do Repositório, Nome / Foto do autor, Número de Stars, Número de Forks
  * Ao tocar em um item, deve levar a lista de Pull Requests do repositório

- __Pull Requests de um repositório__. Exemplo de chamada na API: https://api.github.com/repos/<criador>/<repositório>/pulls`
  * Cada item da lista deve exibir Nome / Foto do autor do PR, Título do PR, Data do PR e Body do PR
  * Ao tocar em um item, deve abrir no browser a página do Pull Request em questão

### **A solução DEVE conter** ###

* Versão mínima do SDK Android : 16
* Sistema de build Gradle.
* Múltiplos targets (Development, Release).
* Múltiplos flavors (Criar ao menos 2 temas diferentes, pode ser bem simples. Ex. mudar as cores primarias do App).
* Material Design.
* Framework para Comunicação com API.
* Mapeamento json -> Objeto.

### **Ganha + pontos se contiver** ###

* Utilizar Kotlin como linguagem de desenvolvimento.
* Programação Reativa Funcional
* Conter Designer Pattern. Ex. MVP, MVVM, etc. (saber defender a escolha)
* Testes funcionais (que naveguem pelo aplicativo como casos de uso)
* Testes no projeto (unitários e por tela)
* Cache de Imagens.


### **OBS** ###

A foto do mockup é meramente ilustrativa, exercite sua criatividade.