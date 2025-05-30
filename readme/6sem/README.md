**A EMPRESA** parceira escolhida foi a Kersys.
<br>
<br>
**O PROBLEMA**  proposto pela empresa parceira consistiu no desenvolvimento de um sistema inteligente para o planejamento e monitoramento de reflorestamento, com o objetivo de prever padrões favoráveis ao crescimento saudável das árvores. 
<br>
<br>
**A SOLUÇÃO**  proposta consistiu no desenvolvimento de um sistema que permite ao usuário cadastrar e atualizar, em períodos arbitrários, dados relacionados à sua colheita. Com base nessas informações, o sistema é capaz de prever aspectos ligados ao crescimento e à projeção de gastos da colheita, além de sugerir melhorias por meio de algoritmos de classificação e agrupamento. Além disso, todo o desenvolvimento foi realizado em conformidade com as diretrizes da Lei Geral de Proteção de Dados (LGPD).

[GIT](https://github.com/matheus-fiebig/portfolio-fatec/blob/main/6sem/README.md)

#### Tecnologias Utilizadas
- C#: Linguagem principal utilizada na criação da biblioteca de portabilidade. 

- Java: Linguagem principal utilizada no backend. 

- Spring Boot: Utilizado na configuração e estruturação do projeto, criação de endpoints, persistência de dados e segurança da API.

- TypeScript: Utilizada no frontend do projeto.

- Angular: Framework frontend que simplifica a manutenção e permite a criação de componentes. 

- PostgreSQL: Banco de dados relacional utilizado para guardar dados gerenciais do projeto. 

- MongoDB: Banco de dados não-relacional utilizado para guardar dados de ML e de usuários. 

#### Contribuições Pessoais
Nesse projeto atuei em duas frentes 
- Product Owner
- Desenvolvedor 

#### Como Product Owner:
##### - Interface entre o cliente e time de desenvolvimento
Atuei como elo entre as necessidades do cliente e a capacidade equipe de desenvolvimento, garantindo que as expectativas fossem corretamente entendidas e traduzidas em soluções viáveis. Além de comunicar possíveis riscos das soluções e entregas.

##### - Criação e organização dos requisitos do projeto
Fui responsável por levantar, detalhar e priorizar os requisitos. Utilizei técnicas como histórias de usuário e critérios de aceitação para transformar as necessidades do cliente em tarefas compreensíveis e executáveis pela equipe de desenvolvimento. Os requisitos foram organizados e priorizados no backlog do projeto com base em valor de negócio.


#### Como Desenvolvedor, minhas contribuições foram:
##### Criação da biblioteca de portabilidade de dados ([GIT](https://github.com/api-6-pixel/api-portabilidade))
Ela e divida em dois projetos, um projeto utilizado para teste e o outro a biblioteca em si. 
<br> 
<details>
    Esta biblioteca e divida em 3 metodos:
    1-CreateNewAccessToken: Responsável por gerar as chaves de autorização que permitem a comunicação segura entre a biblioteca e a API.<br>
    2-GetUserDataAsync: Solicita ao usuário final a autorização para a portabilidade de seus dados.<br>
    3-DecryptUser: Método auxiliar utilizado para descriptografar os dados do usuário recebidos por meio do webhook.<br><br>

    O processo se inicia com a criação de chaves de autorização pelo usuário, permitindo a comunicação com a API. <br>
    Em seguida, é solicitada ao usuário final a autorização para a portabilidade dos dados. Durante todo o processo, as informações são protegidas por criptografia: utiliza-se criptografia assimétrica para proteger as chaves simétricas, que por sua vez são responsáveis por criptografar os dados transmitidos (tanto as requisições quanto as respostas) entre a API e a biblioteca.<br>
    Após a solitiação, o usuário que solicitou a portabilidade recebe um link para acesso à API, onde a autorização é formalizada. Por fim, a API envia os dados criptografados do usuário ao consumidor por meio de um webhook seguro.
</details>


#### Hard Skills
<details>
  <summary><b>Clique para ver a lista de hard skills</b></summary>
  <br>
  <table align="center">
    <tr>
      <th width="300px">Tecnologia/Metodologia</th>
      <th width="300px">Classificação</th>
    </tr>
    <tr>
      <td>Scrum</td>
      <td>★★★★★★☆☆☆☆</td>
    </tr>
    <tr>
      <td>PostgreSQL</td>
      <td>★★★★★★☆☆☆☆</td>
    </tr>
    <tr>
      <td>Criptografias</td>
      <td>★★★★★★★★★☆</td>
    </tr>
    <tr>
      <td>C#</td>
      <td>★★★★★★★★★★</td>
    </tr>
    <tr>
      <td>Gestão de backlog</td>
      <td>★★☆☆☆☆☆☆☆☆</td>
    </tr>
    <tr>
      <td>Escrita de requisitos e histórias de usuário</td>
      <td>★★★★★☆☆☆☆☆</td>
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
      <td>★★★★★★★★★☆☆</td>
    </tr>
    <tr>
      <td>Trabalho em Equipe</td>
      <td>★★★★★★☆☆☆☆☆</td>
    </tr>
    <tr>
      <td>Resolução de Problemas</td>
      <td>★★★★★★★☆☆☆</td>
    </tr>
    <tr>
      <td>Responsabilidade</td>
      <td>★★★★★★☆☆☆☆☆</td>
    </tr>
    <tr>
      <td>Organização</td>
      <td>★★★★★★★☆☆☆☆</td>
    </tr>
  </table>
</details>
