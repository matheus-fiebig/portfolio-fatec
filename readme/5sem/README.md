**A EMPRESA** parceira escolhida foi a PRO4TECH.
<br>
<br>
**O PROBLEMA** proposto pela empresa parceira foi a criação de um dashboard interativo para análise de dados de recrutamento e seleção. Além disso, a plataforma tinha como objetivo resolver questões relacionadas à centralização de dados, permitindo a integração de informações provenientes de diversas fontes em um único dashboard interativo, auxiliando a empresa na tomada de decisões estratégicas. 
<br>
<br>
**A SOLUÇÃO** proposta foi desenvolver um sistema que permitisse ao usuário importar dados de diversas fontes enquanto escolhia o tipo de dashboard que desejava visualizar. O sistema disponibilizava um total de seis espaços, nos quais os gráficos poderiam ser configurados com eixos X e Y, além de filtros totalmente personalizáveis.
<br>
Além disso, o sistema conseguia enviar notificações sobre as métricas da empresa com a mesma flexibilidade oferecida aos gráficos e possuía a capacidade de exportar relatórios para Excel e PDF. 

[GIT](https://github.com/matheus-fiebig/portfolio-fatec/blob/main/5sem/README.md)

#### Tecnologias Utilizadas
- Java: Linguagem principal utilizada no backend, amplamente aplicada no desenvolvimento web e mobile. Orientada a objetos, é a principal linguagem ensinada na FATEC. 

- Spring Boot: Framework essencial para desenvolvimento web, utilizado na configuração e estruturação do projeto, criação de endpoints, persistência de dados e segurança da API.

- TypeScript: Linguagem frontend escolhida em substituição ao JavaScript, proporcionando maior escalabilidade, facilidade de manutenção e depuração do código por conta de sua tipagem estática.

- Angular: Framework frontend que simplifica a manutenção e permite a criação de componentes. Foi escolhido para atender aos requisitos não funcionais.

- PostgreSQL: Sua robustez, desempenho avançado e integração com o Sprint-Boot foram determinantes para a escolha. 

#### Contribuições Pessoais
Nesse projeto atuei em três frentes 
- Product Owner
- Desenvolvedor 
- Devops 

Como Product Owner:
#### - Concepção do produto
Fui o principal responsável por compreender o problema do cliente e, com base nisso, conceber o produto, definindo suas funcionalidades e como elas se comportariam e se integrariam dentro do sistema.

#### - Criação e organização dos requisitos do projeto
Fui responsável por elaborar todos os [requisitos](https://github.com/matheus-fiebig/portfolio-fatec/blob/main/5sem/devops/Requisitos.md) do projeto.   

#### - Criação e manutenção do backlog
Como PO, uma das minhas responsabilidades também foi a criação do [backlog](https://github.com/matheus-fiebig/portfolio-fatec/tree/main/5sem/backlog) para o time de desenvolvimento, garantindo que todas as tarefas estivessem alinhadas com a entrega de valor para o cliente.
<details> 

    Estrutura das histórias para o time

    Requisitos
    -Identificação dos requisitos impactados pelo desenvolvimento da história (funcionais e não funcionais).

    Critérios de Aceite
    -Definição das funcionalidades que a história deveria possuir e do comportamento esperado no sistema.

    BDD
    -Cenários de execução baseados em eventos, criados para tornar a história mais testável e alinhada às interações do usuário na interface.

</details>    

Como DEVOPS, minhas contribuições foram:
#### - Orquestração do gitflow da equipe
<details>
    Nossos ambientes foram divididos da seguinte maneira:
    
    - **Main**
    - **Qas**
    - **Develop**
    
    A parte mais importante desse fluxo era o padrão de commits estabelecido, que levava em conta o número da subtarefa criada no JIRA (nossa ferramenta de gerenciamento).
    
    **Exemplo:**
    
    - **Jira**
        - Task: PX-1 Criação de Usuário
        - Subtask: PX-2 Criar endpoint de usuário
    - **Git**
        - Commit: PX-2 Criar controller de usuário
    
    Esse ponto é crucial, pois permitia o início da nossa rastreabilidade, o que será discutido no próximo tópico.    
</details>

#### - Traceabilidade dos requisitos funcionais e não funcionais:
<details>
    Fui responsável por organizar o fluxo de rastreabilidade dentro do sistema. Desenvolvi um modelo que possibilita identificar quais requisitos foram impactados por um commit, além de permitir a visualização das histórias afetadas por cada requisito.Para isso é apenas necessário utilizar o JIRA e o GIT.
Você pode conferir mais detalhes no seguinte link: [LINK](https://github.com/api-5-sem/api-documentation/blob/main/devops/Traceabilidade_De_Requisitos.md).
    
</details>

Como Desenvolvedor, minhas contribuições foram:
#### Componentizacao e criacao dos dashboards do sistema
    Criei o componente principal dos dashboards além de ter sido o responsável pela componentização dos gráficos. Diminuindo o código necessário para criar-se um novo gráfico e facilitando em muito o entendimento dos consumidores desse componente.
    <details>
```

        app-graphic
          @Input() public idx: number = 0;
          @Input() public chartId: string = '';
          @Input() public description: string = '';
          @Input() public lineChartType: string = 'line';
          @Input() public generatedValues: any[];
          @Input() public lineChartData: Array<any>;
          @Input() public lineChartLabels: Array<any>;
          @Input() public lineChartColors: Array<any>

```
        Como pode ser visto acima todos os graficos utilizavam dessa mesma entrada de dados para serem exibidos, necessitando apenas a permutação desses valores para gerar gráficos diferentes (que era uma das propostas do nosso sistema). Além disso, um outro ganho foi a centralização da regra desse componente dentro de apenas um lugar facilitando features futuras como é o caso da feature de customização e compartilhamento de dashboard que podem ser vistas no codigo abaixo.
```

TODO

```
    </details>

#### Criação da tela de permissionamento
Por fim fui responsável pela tela de atribuição de permissão do sistema, ela era uma tela bem simples que permitia o usuário atribuir ou remover a permissão de um grupo especifico 

#### Hard Skills
<details>
  <summary><b>Clique para ver a lista de hard skills</b></summary>
  <br>
  <table align="center">
    <tr>
      <th width="300px">Tecnologia/Metodologia</th>
      <th width="300px">Classificação</th>
    </tr>
    <tr>TODO
      <td>HTML/CSS</td>
      <td>★★★★★★★★★★</td>
    </tr>
    <tr>TODO
      <td>Angular</td>
      <td>★★★★★★★★★☆</td>
    </tr>
    <tr>TODO
      <td>Typescript</td>
      <td>★★★★★★★★★★</td>
    </tr>
    <tr>TODO
      <td>Scrum</td>
      <td>★★★★★★☆☆☆☆</td>
    </tr>
    <tr> TODO
      <td>Devops</td>
      <td>★★★★★☆☆☆☆☆</td>
    </tr>
    <tr>
      <td>Java</td>
      <td>TODO</td>
    </tr>
    <tr>
      <td>Spring Boot</td>
      <td>TODO</td>
    </tr>
    <tr>
      <td>Devops</td>
      <td>TODO</td>
    </tr>
  </table>
</details>

#### Soft Skills
<details>
  <summary><b>Clique para ver a lista de softskills</b></summary>
  <br>
  <table align="center">
    <tr>
      <th width="300px">Tecnologia/Metodologia</th>
      <th width="300px">Classificação</th>
    </tr>
    <tr>
      <td>Comunicação</td>
      <td>TODO</td>
    </tr>
    <tr>
      <td>Trabalho em Equipe</td>
      <td>TODO</td>
    </tr>
    <tr>
      <td>Resolução de Problemas</td>
      <td>TODO☆</td>
    </tr>
    <tr>
      <td>Responsabilidade</td>
      <td>TODO</td>
    </tr>
    <tr>
      <td>Organização</td>
      <td>TODO</td>
    </tr>
  </table>
</details>
