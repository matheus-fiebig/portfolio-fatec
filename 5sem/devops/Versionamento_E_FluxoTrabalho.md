![](https://github.com/api-5-sem/api-documentation/blob/main/assets/DEVOPS/DEVOPS_GITFLOW.png)

### Branches
<ul>
  <li>main - Branch de final da sprint</li>
  <ul>
    <li>roda-se os testes de integração e unitários </li>
    <li>gera-se uma tag após o build</li>
  </ul> 
</ul>

<ul>
  <li>qas - Branch de testes</li>
  <ul>
    <li>roda-se os testes de integração e unitários </li>
    <li>após finalizado uma historia, ela deve ser movida da develop para qas</li>
  </ul> 
</ul>

<ul>
  <li>develop - Branch de desenvolvimento</li>
  <ul>
    <li>roda-se os testes unitários </li>
    <li>local de teste do time de desenvolvimento</li>
  </ul> 
</ul>

Os seus nomes devem seguir o padrão estipulado abaixo para cada necessidade:

<ul>
  <li>feat/PX-<NUMERO_HISTORIA> - Quando se esta criando novas funcionalidades <br> Ex: feat/PX-1 </li>
  <li>fix/PX-<NUMERO_HISTORIA> - Quando se esta corrigindo alguma funcionalidade  <br> Ex: fix/PX-1 </li>
</ul>

### Usos diários
<ul>
  <li>Para realizar o desenvolvimento deve-se originar a branch em DEVELOP. A partir dela se cria uma branch chamada feat/PX-<NUMERO_HISTORIA></li>
  <li>Para realizar uma correção deve-se originar a branch na onde a correção esta sendo necessária. A partir dela se cria uma branch chamada fix/PX-<NUMERO_HISTORIA>. Para as demais branchs e necessário realizar um cherry pick</li>
  <li>Para realizar uma publicação em qas e necessário realizar um PR a partir da branch de develop</li>
  <li>Para realizar uma publicação na main  e necessário realizar um PR a partir da branch de qas</li>
</ul>
    
### Padrão de Commits
Temos apenas um padrão de commit. 
Toda história/bug deve obrigatoriamente ter uma tarefa aberta no JIRA. Dessa forma torna-se mais fácil a administração de qual história esta sendo afetada por determinado commit.

<ul>
  <li>PX-[NUMERO_SUBTASK] - [DESCRIÇÃO] <br>
  Ex: PX-123 - Criação do endpoint abc <br>
     PX-345 - Criação da tela def</li>
</ul>










