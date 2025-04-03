### Pré-requisitos
Para realizar o monitoramento requisitos é necessário primeiro que alguns padrões sejam seguidos, sendo eles:
   <ul>
      <li>
         <a href="https://github.com/api-5-sem/api-documentation/blob/main/devops/Versionamento_E_FluxoTrabalho.md">Versionamento e Fluxo de Trabalho.</a>  
      </li>
      <ul>
         <li>Motivo: permite controlar qual “commit” esta vinculado a qual história e a intenção daquele dele (correção, nova feature, etc)</li>
      </ul>
   </ul>   
   <ul>
      <li>Preenchimento dos requisitos da história pelo PO</li>
      <ul>
         <li>Motivo: determinar de qual requisito aquela história deu origem </li>
      </ul>
   </ul>
   <ul>
      <li>Todos requisitos funcionais/não-funcionais estão centralizados no 
         <a href="https://github.com/api-5-sem/api-documentation/blob/main/devops/Requisitos.md">documento de requisitos</a></li>
      <ul>
         <li>Motivo: facilidade de identificação dos requisitos do projeto</li>
      </ul>
   </ul>
   <ul>
      <li>DoD/DOR esta sendo realizado em toda as histórias</li>
      <ul>
         <li>Motivo: demarcação dos projetos/requisitos que estão sendo afetados em uma determinada história</li>
      </ul>
   </ul>

### Relação Requisito X História
Para encontrar a relação descrita acima basta entrar no link que se encontra logo abaixo de cada tópico na pagina de <a href="https://github.com/api-5-sem/api-documentation/blob/main/devops/Requisitos.md">Requisitos</a>  
OBS: é possível realizar consultas mais complexas utilizando JQL caso necessário
Ex: "Requisitos(F/NF)[Paragraph]" ~ "RF-3" OR "Requisitos(F/NF)[Paragraph]" ~ "RF-4"
<br>
Ex 2:
<br>
-Como pode se ver a baixo cada historia leva a um link
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/DEVOPS/DEVOPS_PAGINA_REQUISITOS.png)

<br>
-E nesse link e possível ver quais histórias são afetadas por cada requisito

![](https://github.com/api-5-sem/api-documentation/blob/main/assets/DEVOPS/DEVOPS_PAGINA_FILTRO1.png)
<br>

![](https://github.com/api-5-sem/api-documentation/blob/main/assets/DEVOPS/DEVOPS_PAGINA_FILTRO2.png)
<br>
<br>
Para encontrar qual requisitos uma história afeta, basta entrar na pagina desta e observara seção de Requisitos Funcionais / Não Funcionais <br>
OBS: caso você clique nesses requisitos você sera redirecionado a tela de <a href="https://github.com/api-5-sem/api-documentation/blob/main/devops/Requisitos.md"> Requisitos</a>  

![](https://github.com/api-5-sem/api-documentation/blob/main/assets/DEVOPS/DEVOPS_HISTORIA_JIRA.png)
 
### Relação Requisito X Commit
Para encontrar qual commit afetou uma determinada história basta olhar para o número que o precede (Ex: PX-14). Após isso você encontrará a subtask que originou aquele commit, que por sua vez sempre terá uma task pai, que consequentemente possui os requisitos funcionais e não funcionais afetados (Que deverá sempre estar preenchido devido ao DOR).
<br>
<br>
Exemplo:
<br>
-Commit que afetou uma história
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/DEVOPS/DEVOPS_SUBCOMMIT_GIT.png)

<br>
-Subtask que gerou o commit

![](https://github.com/api-5-sem/api-documentation/blob/main/assets/DEVOPS/DEVOPS_SUBCOMMIT_JIRA.png)

<br>
-Requisitos afetados pelo commit

![](https://github.com/api-5-sem/api-documentation/blob/main/assets/DEVOPS/DEVOPS_HISTORIA_JIRA.png)

### Observações e Considerações
1 - Devido ao DoD e possível, também, descobrir se uma determinada historia impactou ou não determinado sistema. Para isso basta atentar-se ao campo de Sistemas Afetados, localizado logo abaixo do DoD nas historias.
<br>
2 - Todos os links das histórias possuem ancôras para o navegamento mais fácil na documentação de requisitos.
<br>
3 - O controle de histórias afetadas só é possível devido a ferramente jira como demonstrado na documentação acima.
