# Matheus Cruz Fiebig 

## Introdução

Sou formado em Técnico em Informática pelo Colégio Técnico Opção. 
<br>
<br>
Desde 2020, venho atuando na área de desenvolvimento de software. Minhas principais tecnologias são Angular e .NET. Ao longo da minha carreira, tive a oportunidade de trabalhar em algumas empresas como GSW, Stefanini, DEAL, Simptec e B3.
<br><br>
Além das tecnologias mencionadas, possuo conhecimento em outras áreas relacionadas ao desenvolvimento de software, como bancos de dados, metodologias ágeis e boas práticas de programação.

## Contatos
* [GIT](https://github.com/matheus-fiebig)
* [LinkedIn](https://www.linkedin.com/in/matheus-fiebig-28195816a/)

## Meus Principais Conhecimentos
- .NET
- C#
- Angular
- Typescript
- HTML/CSS
- SQL

## Sumário
- [Avaliacao 360](#avaliacao-360)
- [Gerenciamento de Horas Extras 1](#gerenciamento-de-horas-extras-1)
- [Gerenciamento de Horas Extras 2](#gerenciamento-de-horas-extras-2)
- [Acompanhamento de Parceiros](#acompanhamento-de-parceiros)
- [Análise de Recrutamento e Seleção](#análise-de-recrutamento-e-seleção)
- [Gestão de Reflorestamento](#gestão-de-reflorestamento)

## Avaliacao 360
**A EMPRESA** parceira escolhida foi a FATEC.
<br>
<p align="center">
  <img src="https://user-images.githubusercontent.com/111552950/199847738-8c0270c6-1a2f-499a-891c-32838378e48d.jpg" align="center">
</p>

**O PROBLEMA** em questão está relacionado à criação de um portal para avaliação 360 graus, no qual cada usuário realiza uma autoavaliação e também avalia os demais membros de sua equipe em algumas soft skills preestabelecidas. Além disso, o sistema deve permitir a avaliação de cada líder e PO pelo líder do grupo e pelo Fake Client, respectivamente.
<br>
<br>
**A SOLUÇÃO** proporcionou ao usuário uma avaliação 360° dos times dos quais ele fazia parte e permitiu o acompanhamento de suas notas em um dashboard interativo, visando monitorar sua evolução a cada sprint.  <br>
Além disso, o sistema permite que o administrador gerencie os usuários, a composição dos times e o fluxo das sprints.

#### Tecnologias Utilizadas
- Python
- JavaScript
- HTML/CSS
- FastAPI
  
#### Contribuições Pessoais
Nesse projeto atuei como desenvolvedor e scrum master. <br>
Como desenvolvedor, minhas contribuições foram:

#### - Criação de uma camada de abstração de dados:
Nesta aplicação, foi obrigatório **não utilizar um banco de dados relacional ou NoSQL**. Por isso, **todas as informações foram armazenadas em um arquivo JSON**, que atua como nossa fonte de dados principal.  Para isso, foi desenvolvida uma **abstração de CRUD**, responsável por manipular os dados de forma segura e eficiente. <br> Essa abordagem simplificou o uso e facilitou a manutenção durante o desenvolvimento.

#### - Criação da tela de gestão de sprints:
Fui responsavel pela criacao de toda tela de gestão de sprints (Visualizacao, Cadastro, Edicao e Delecao). 
Como não foi utilizado nenhum framework, toda a renderização desta tela é feita com JavaScript puro e manipulação direta do DOM. Além disso, nossas rotas de backend eram muito simples, o que fazia com que muitas consultas às entidades criadas retornassem apenas objetos simples, sem relacionamentos aninhados. Isso aumentava a complexidade na criação da tela, pois era necessário fazer manualmente a junção de diversas entidades, muitas vezes utilizando a função <i>filter</i> para exibir seus valores na tela.
  
#### - Criação da tela de login e  controle de permissionamento:
Para implementar o sistema de permissionamento nesta API, desenvolvi um controle de rotas no frontend, permitindo que cada usuário visualizasse apenas os recursos compatíveis com seu nível de permissão (no caso, havia dois tipos: administrador e usuário comum). Como mencionado anteriormente, a ausência de um framework tornava o desenvolvimento mais desafiador. Para superar essa dificuldade, criei um script que inseria dinamicamente toda a barra lateral na página do usuário, levando em consideração o seu nivel de permissionamento.<br>
O fluxo era realizado da seguinte maneira:<br>  
1 - O usuário realizava o login na tela abaixo, e as informações do usuário autenticado, incluindo seu nível de permissão no sistema, eram armazenadas no local storage.
2 - O script de criação dinâmica da sidebar era injetado para gerenciar o controle de permissionamento nas páginas subsequentes à login. Como mostrado no código abaixo, ocorre a substituição de todo o componente demarcado como menu-navbar por um HTML controlado pelo nível de permissão do usuário (admin-only). Essa abordagem reduzia o controle manual da sidebar no HTML, já que não era mais necessário adicionar cada item manualmente em todas as telas, diminuindo, por sua vez, as chances de erro.

Como scrum master, minhas contribuições foram:
#### - Acompanhamento das entregas:
Fui responsável pelo monitoramento contínuo e pela cobrança diária das entregas da equipe, elaborando relatórios semanais de status para o M2, através da utilização do JIRA.

#### Hard Skills
<table align="left">
  <tr>
    <th width="300px">Tecnologia/Metodologia</th>
    <th width="300px">Classificação</th>
  </tr>
  <tr>
    <td>Python</td>
    <td>★★★★★★☆☆☆☆</td>
  </tr>
  <tr>
    <td>HTML/CSS</td>
    <td>★★★★★★★★★☆</td>
  </tr>
  <tr>
    <td>Javascript</td>
    <td>★★★★★★★★☆☆</td>
  </tr>
  <tr>
    <td>FastAPI</td>
    <td>★★★★★☆☆☆☆☆</td>
  </tr>
  <tr>
    <td>Scrum</td>
    <td>★★★★☆☆☆☆☆☆</td>
  </tr>
</table>
<br><br><br><br><br><br><br><br><br>

#### Soft Skills
<table align="left">
  <tr>
    <th width="300px">Tecnologia/Metodologia</th>
    <th width="300px">Classificação</th>
  </tr>
  <tr>
    <td>Comunicação</td>
    <td>★★★★★★★★☆☆</td>
  </tr>
  <tr>
    <td>Responsabilidade</td>
    <td>★★★★★★★★★★</td>
  </tr>
</table>
<br><br><br><br><br>
<hr>


## Gerenciamento de Horas Extras 1
**A EMPRESA** parceira escolhida foi a 2RP.
<br>
<p align="center">
  <img src="https://github.com/user-attachments/assets/70ffe885-1115-48da-9a90-2548aedf56ef">
</p>

**O PROBLEMA** abordado por eles refere-se à necessidade de um sistema para gerenciar horas extras. Os usuários devem ser capazes de registrar suas horas adicionais de trabalho e acessar essas informações em tempo real. Além disso, os gestores e administradores devem ter a capacidade de controlar o acesso ao sistema, extrair relatórios detalhados das horas trabalhadas por cada usuário e personalizar diversas configurações do sistema, tais como definir as horas iniciais do período noturno e especificar o valor correspondente a essas horas extras.
<br>
<br>
**A SOLUÇÃO** entregue proporcionou ao administrador o controle completo (CRUD) de cada usuário, centro de resultado e cliente. Além disso, ele consegue parametrizar o sistema, definindo o valor de cada taxa de trabalho e estabelecendo o início/fim da hora de trabalho noturno, entre outros aspectos importantes. Por fim, o administrador é capaz de realizar a extração de relatórios das horas trabalhadas e aprovar/reprovar as horas extras lançadas. <br>
Para o gestor, foi concedida a capacidade de lançar horas extras e extrair relatórios relacionados a ele ou aos seus funcionários, além de poder acompanhar em tempo real as horas trabalhadas.<br>
Por fim, para o usuário, foi desenvolvida a funcionalidade de lançamento de horas extras e o acompanhamento detalhado das horas extras acumuladas ao longo do mês.

#### Tecnologias Utilizadas
- Java
- CSS
- MySQL

#### Contribuições Pessoais
Nesse projeto atuei como desenvolvedor e scrum master.
Como desenvolvedor, minhas contribuições foram:
#### - Desenvolvimento da Tela de Lançamento de Horas:
Fui encarregado de criar a tela de lançamento de horas no SceneBuilder, utilizando para isso CSS e algumas imagens padrões da empresa parceira. Nessa mesma tela foi implementado algumas regras de controle para lançamento e reprovação de horas, de modo que, cada nível de control conseguisse visualizar suas determinadas ações.

#### - Desenvolvimento da Tela de Cadastro de CR e Visualização de CR:
Participei também do desenvolvimento da tela de cadastro e de visualização do CR, duas telas bem simples nas quais o usuário apenas tinha o controle de quais centro de custo estavam cadastrados, podendo fazer as operações básicas de um CRUD. A tela em si não possuia nenhuma regra de negócio e apenas servia para popular as comboboxes do sistema.

#### - Desenvolvimento da Tela de Feedback:
Por fim como desenvolvedor participei do desenvolvimento da tela de Feedback. Esta tela é um complemento da tela de Lançamento de Horas e possuía regras similares a ela. Participei principalemente do parte de aprovação/reprovação de horas na qual um modal aparecia para o usuário. Este modal permite ao usuário descrever o motivo da reprovação.


Como scrum master, minhas contribuições foram:
#### - Criaçao e acompanhamento das entregas:

Também fui responsável pela criação e acompanhamento das entregas da squad durante todas as sprints. Acompanhando de perto cada impedimento que o time pudesse vir a sofrer e fornecendo o devido apoio para cada integrante nesses momentos.

Também fui responsável pela criação manual do burndown e pela atualização diária de seus valores, como parte desse processo. A principal razão para a implementação do burndown foi a ausência de uma ferramenta tecnológica que auxiliasse no acompanhamento, como o Jira, na época. Para mais detalhes, segue o link dos <a href="https://github.com/matheus-fiebig/portfolio-fatec/tree/main/2sem/assets/burndown">burndowns</a>.

#### - Status report para o M2:

Por fim, eu era responsável por reportar semanalmente ao nosso M2 o andamento completo das entregas realizadas pela equipe ao longo das sprints. Esse acompanhamento envolvia a análise detalhada do progresso, identificando possíveis atrasos ou desvios e propondo soluções. Além disso, compartilhava regularmente os métodos e estratégias que utilizei para lidar com conflitos e remover impedimentos dentro da squad, garantindo a fluidez do trabalho e a manutenção do foco nos objetivos estabelecidos. Meu papel incluía tanto a mediação de problemas entre os integrantes quanto a antecipação de desafios que pudessem comprometer o sucesso das entregas.

#### Hard Skills
<table align="left">
  <tr>
    <th width="300px">Tecnologia/Metodologia</th>
    <th width="300px">Classificação</th>
  </tr>
  <tr>
    <td>SQL</td>
    <td>★★★★★★★★☆☆</td>
  </tr>
  <tr>
    <td>MYSQL</td>
    <td>★★★★★★★☆☆☆</td>
  </tr>
  <tr>
    <td>SceneBuilder/HTML/CSS</td>
    <td>★★★★★★★★☆☆</td>
  </tr>
  <tr>
    <td>JAVA</td>
    <td>★★★★★★★☆☆☆</td>
  </tr>
  <tr>
    <td>Scrum</td>
    <td>★★★★☆☆☆☆☆☆</td>
  </tr>
</table>
<br><br><br><br><br><br><br><br><br>

#### Soft Skills
<table align="left">
  <tr>
    <th width="300px">Tecnologia/Metodologia</th>
    <th width="300px">Classificação</th>
  </tr>
  <tr>
    <td>Comunicação</td>
    <td>★★★★★★☆☆☆☆</td>
  </tr>
  <tr>
    <td>Responsabilidade</td>
    <td>★★★★★★★★★☆</td>
  </tr>
</table>
<br><br><br><br><br>
<hr>


## Gerenciamento de Horas Extras 2
**A EMPRESA** parceira escolhida foi a 2RP.
<br>
<p align="center">
  <img src="https://github.com/user-attachments/assets/eec8c955-668d-4925-919c-aa14a8700489">
</p>

**O PROBLEMA** abordado por eles refere-se à necessidade de um sistema para gerenciar horas extras. Os usuários devem ser capazes de registrar suas horas adicionais de trabalho e acessar essas informações em tempo real. Além disso, os gestores e administradores devem ter a capacidade de controlar o acesso ao sistema, extrair relatórios detalhados das horas trabalhadas por cada usuário e personalizar diversas configurações do sistema, tais como definir as horas iniciais do período noturno e especificar o valor correspondente a essas horas extras.
<br>
<br>
**A SOLUÇÃO** entregue proporcionou ao administrador o controle completo (CRUD) de cada usuário, centro de resultado e cliente. Além disso, ele consegue parametrizar o sistema, definindo o valor de cada taxa de trabalho e estabelecendo o início/fim da hora de trabalho noturno, entre outros aspectos importantes. Por fim, o administrador é capaz de realizar a extração de relatórios das horas trabalhadas e aprovar/reprovar as horas extras lançadas. <br>
Para o gestor, foi concedida a capacidade de lançar horas extras e extrair relatórios relacionados a ele ou aos seus funcionários, além de poder acompanhar em tempo real as horas trabalhadas. <br>
Por fim, para o usuário, foi desenvolvida a funcionalidade de lançamento de horas extras e o acompanhamento detalhado das horas extras acumuladas ao longo do mês.

#### Tecnologias Utilizadas
- Java
- Springboot
- Typescript
- Vue
- MySQL

#### Contribuições Pessoais
**<br>**
Nesse projeto atuei em duas frentes 
- Frontend: utilizando as tecnologias de vue e typescript e
- Product Owner

Como desenvolvedor, minhas contribuições foram:

#### - Desenvolvimento do Layout Padrão do Sistema:
Fui encarregado de criar e componentizar o layout padrão (menu lateral e conteiner do conteudo). Implementei regras de permissões específicas para que cada usuário visualizasse um menu adequado ao seu perfil. Além disso, desenvolvi controles para menus aninhados e não aninhados, garantindo uma experiência de usuário mais fluida e intuitiva.

#### - Tela de Lançamento de Horas:
Desenvolvi o controle para exibição das telas de lançamento de horas, incluindo toda a funcionalidade de visualização das horas e seu fluxo de aprovação/reprovação . Isso envolveu a comunicação HTTP, criação do layout e a vinculação com o framework VUE. Além de necessitar do uso das diretivas do vue, como v-if e v-for.

#### - Tela de C.R. (Controle de Requisições):
Criei todas as operações do CRUD para as Requisições de Mudança (CRs), incluindo a atribuição de usuários a uma CR. Desenvolvi um sistema de lista para gerenciar quais usuários estariam associados a cada CR. A feature do C.R é composta por algumas telas, primeiramente temos a tela de visualização e controle. Nela é possível realizar todas as ações de controle do CR além de visualiza-los (por exemplo deletar ou editar) <br>
Além disso temos o cadastro de CR que faz uma requisição POST para o backend com todos os dados necessários para salvar um C.R ou edita-lo (depende da ação do usuário).
<br>
Para finalizar temos a feature exclusiva de CR que é o controle de usuário por cr. Nessa feature temos um controle de N para N, ou seja, conseguimos colocar qualquer usuário em qualquer CR e em quantos CR quisermos. Desse modo é utilizado subtração e adição com listas para controlar o estado de qual usuário deve ser persistido no backend.

#### - Tela de Dashboard:
Desenvolvi a tela de dashboard, utilizando a biblioteca Canvas.js para geração de gráficos. Nessa tela, os usuários podiam filtrar os dados e visualizar gráficos de barras com os dados filtrados, proporcionando uma visão clara e analítica do sistema. Para gerar o relatório com essa biblioteca, foi necessário criar uma tag de apexChart, delimitando assim onde seria gerado o relatório. Além disso para gerar os gráficos era necessário obte-los do backend (através de uma comunicação HTTP com o nosso servidor REST) e atribui-los a propriedade data do chartConfig. 

Como Product Owner
#### - Organização e Criacão do Backlog:
Criação e organização de todo o backlog do projeto, user storys, prioridades e afins. Todos com um bom alinhamento com o cliente. Como pode ser visto na imagem abaixo, todo o backlog e suas respectivas prioridades e user storys. Além disso há a organização por ÉPICOS e FEATURES de cada uma das histórias, bem como a sprint em que cada uma delas deveria entrar

#### Hard Skills
<table align="left">
  <tr>
    <th width="300px">Tecnologia/Metodologia</th>
    <th width="300px">Classificação</th>
  </tr>
  <tr>
    <td>SQL</td>
    <td>★★★★★★☆☆☆☆</td>
  </tr>
  <tr>
    <td>MYSQL</td>
    <td>★★★★☆☆☆☆☆☆</td>
  </tr>
  <tr>
    <td>HTML/CSS</td>
    <td>★★★★★★★☆☆☆</td>
  </tr>
  <tr>
    <td>VUE</td>
    <td>★★★★★★★☆☆☆</td>
  </tr>
  <tr>
    <td>REST</td>
    <td>★★★★★★☆☆☆☆</td>
  </tr>
  <tr>
    <td>Scrum</td>
    <td>★★★★★★☆☆☆☆</td>
  </tr>
  <tr>
    <td>UX/UI design</td>
    <td>★★★★★☆☆☆☆☆</td>
  </tr>
</table>
<br><br><br><br><br><br><br><br><br><br><br><br><br>

#### Soft Skills
<table align="left">
  <tr>
    <th width="300px">Tecnologia/Metodologia</th>
    <th width="300px">Classificação</th>
  </tr>
  <tr>
    <td>Comunicação</td>
    <td>★★★★★★★★☆☆</td>
  </tr>
  <tr>
    <td>Responsabilidade</td>
    <td>★★★★★★★★☆☆</td>
  </tr>
  <tr>
    <td>Organização</td>
    <td>★★★★★★★★★☆</td>
  </tr>
</table>
<br><br><br><br><br><br><br><br>
<hr>


## Acompanhamento de Parceiros
**A EMPRESA** parceira escolhida foi a Oracle.
<br>
<p align="center">
  <img src="https://github.com/user-attachments/assets/86d286a6-f8ca-4f50-a8f5-5d88bf31d7e8">
</p>

**O PROBLEMA** proposto pela empresa parceira foi desenvolver um sistema que permitisse aos usuários acompanhar o progresso de cada parceiro participante do programa de parceria. Para isso, era essencial monitorar a porcentagem de parceiros por estado, a taxa de conclusão de cada parceiro em seus cursos de capacitação e a proximidade do vencimento de cada curso.
<br>
<br>
**A SOLUÇÃO** proposta foi desenvolver um sistema capaz de gerenciar usuários, empresas parceiras e trilhas de ensino. Além disso, permitia o acompanhamento em tempo real do progresso de cada parceiro e a emissão de notificações com base na expiração de seus cursos.

#### Tecnologias Utilizadas
- Java
- Spring Boot
- TypeScript
- Vue
- MySQL

#### Contribuições Pessoais
**<br>**
Nesse projeto atuei principalemnte no frontend

Como desenvolvedor, minhas contribuições foram:

#### - Desenvolvimento da tela de Lacunas de Habilidade :
Esta tela tinha como objetivo permitir o acompanhamento da progressao dos parceiros da Oracle em uma determinada trilha. <br>
Fui responsável por todo o desenvolvimento, reproduzindo fielmente o design solicitado pelo nosso UI no Figma e implementando a integração completa entre o backend e o frontend. A interface, embora não fosse excessivamente complexa, atendeu plenamente aos requisitos. <br>

#### - Desenvolvimento da tela de Avalicao de Parceiros :
Esta tela tinha como principal objetivo permitir os feedback dos parceiros.  A tela não apresentava grande complexidade técnica e, assim como na tela de lacunas de habilidades, desenvolvi todo o layout e a integração com o backend. Em decorrência da falta de complexidade técnica foi possível oferecer uma experiência responsiva ao usuário, exibindo uma notificação de sucesso (toast) após cada ação de salvamento no backend, informando o usuário sobre a realização bem-sucedida das alterações.

#### - Desenvolvimento do layout padrão e organização da estrutura CSS:
Criei o layout da padrão de todas as telas (header, footer e content)

Para criar o layout padrão da aplicação, utilizei a funcionalidade de roteamento do Vue. Essa feature permite que todas as rotas filhas de um determinado componente sejam renderizadas dentro da rota pai, o que é uma das bases para a construção de aplicações de página única (SPA) no Vue, Angular e React. No arquivo principal da aplicação, defini toda a estilização do navbar, corpo e footer (representados pelas classes menu, content e footer, respectivamente, no HTML abaixo). Dentro do corpo, utilizei a tag router-view, que instrui o Vue sobre onde renderizar os componentes. Dessa forma, todas as páginas criadas no sistema seguirão o padrão previamente definido.

```

 <div class="page">
        <nav class="menu">
            <div class="menu__logo">
                <img src="./assets/logo.png">
            </div>
            <div class="menu__links">
                <router-link to="/visualizacaoparceiro">Parceiros</router-link>
                <router-link to="/rastreio">Rastreio</router-link>
                <router-link to="/acompanhamento">Acompanhamento</router-link>
                <router-link to="/visualizacao">Habilidades</router-link>
                <router-link to="/avaliacao">Avaliações</router-link>
                <router-link to="/Dashboard">Dashboard</router-link>
                <router-link to="/notificacoes">Configurações</router-link>
                        <router-link to="/por-estado-mapa">Parceiros por Estado</router-link>
            </div>
        </nav>

        <div class="content">
            <router-view />
        </div>

        <div class="footer">
            <img src="./assets/logo.png">
        </div>
    </div> <div class="page">
        <nav class="menu">
            <div class="menu__logo">
                <img src="./assets/logo.png">
            </div>
            <div class="menu__links">
                <router-link to="/visualizacaoparceiro">Parceiros</router-link>
                <router-link to="/rastreio">Rastreio</router-link>
                <router-link to="/acompanhamento">Acompanhamento</router-link>
                <router-link to="/visualizacao">Habilidades</router-link>
                <router-link to="/avaliacao">Avaliações</router-link>
                <router-link to="/Dashboard">Dashboard</router-link>
                <router-link to="/notificacoes">Configurações</router-link>
                        <router-link to="/por-estado-mapa">Parceiros por Estado</router-link>
            </div>
        </nav>

        <div class="content">
            <router-view />
        </div>

        <div class="footer">
            <img src="./assets/logo.png">
        </div>
    </div>

```

Outro aspecto importante dessa tarefa foi a padronização do isolamento do CSS dentro dos componentes. Embora alguns frameworks modernos já implementem o isolamento de estilo por componente, o Vue, por outro lado, não possui essa funcionalidade nativa. Isso fazia com que o CSS de cada componente que desenvolvíamos afetasse os demais. Para contornar essa limitação, organizei o time para adotar padrões de estilização oferecidos pelo SCSS (um pré-processador CSS), encapsulando cada folha de estilo em uma classe principal. Assim, conseguimos isolar as estilizações específicas de cada componente, evitando inconsistências no layout da aplicação.

```
CSS Isolado
.lacuna {
    &__header {
        display: flex;
        justify-content: left;
    }

  ... DEMAIS CLASSES CSS
     th{
            width: 50%;
        }
}

CSS não isolado
.lacuna__header     {
  display: flex;
  justify-content: left;
}

 ... DEMAIS CLASSES CSS

th{
  width: 50%;
}

```
 
#### Hard Skills
<table align="left">
  <tr>
    <th width="300px">Tecnologia/Metodologia</th>
    <th width="300px">Classificação</th>
  </tr>
  <tr>
    <td>HTML/CSS</td>
    <td>★★★★★★★★☆☆</td>
  </tr>
  <tr>
    <td>VUE</td>
    <td>★★★★★★★☆☆☆</td>
  </tr>
  <tr>
    <td>Typescript</td>
    <td>★★★★★★★★★★</td>
  </tr>
  <tr>
    <td>Scrum</td>
    <td>★★★★★★☆☆☆☆</td>
  </tr>
  <tr>
    <td>UX/UI design</td>
    <td>★★★★★☆☆☆☆☆</td>
  </tr>
</table>
<br><br><br><br><br><br><br><br><br>

#### Soft Skills
<table align="left">
  <tr>
    <th width="300px">Tecnologia/Metodologia</th>
    <th width="300px">Classificação</th>
  </tr>
  <tr>
    <td>Comunicação</td>
    <td>★★★☆☆☆☆☆☆☆</td>
  </tr>
  <tr>
    <td>Responsabilidade</td>
    <td>★★★★★☆☆☆☆☆</td>
  </tr>
</table>
<br><br><br><br><br>
<hr>
 

## Análise de Recrutamento e Seleção
**A EMPRESA** parceira escolhida foi a PRO4TECH.
<br>
<p align="center">
  <img src="https://github.com/matheus-fiebig/portfolio-fatec/blob/main/5sem/assets/Exibicao-de-graficos.gif">
</p>

**O PROBLEMA** proposto pela empresa parceira foi a criação de um dashboard interativo para análise de dados de recrutamento e seleção. Além disso, a plataforma tinha como objetivo resolver questões relacionadas à centralização de dados, permitindo a integração de informações provenientes de diversas fontes em um único dashboard interativo, auxiliando a empresa na tomada de decisões estratégicas. 
<br>
<br>
**A SOLUÇÃO** proposta foi desenvolver um sistema que permitisse ao usuário importar dados de diversas fontes enquanto escolhia o tipo de dashboard que desejava visualizar. O sistema disponibilizava um total de seis espaços, nos quais os gráficos poderiam ser configurados com eixos X e Y, além de filtros totalmente personalizáveis.
<br>
Além disso, o sistema conseguia enviar notificações sobre as métricas da empresa com a mesma flexibilidade oferecida aos gráficos e possuía a capacidade de exportar relatórios para Excel e PDF. 

#### Tecnologias Utilizadas
- Java
- Spring Boot
- TypeScript
- Angular
- PostgreSQL

#### Contribuições Pessoais
Nesse projeto atuei em três frentes 
- Product Owner
- Desenvolvedor 
- Devops 

#### Como Product Owner:
##### - Concepção do produto
Fui o principal responsável por compreender o problema do cliente e, com base nisso, conceber o produto, definindo suas funcionalidades e como elas se comportariam e se integrariam dentro do sistema.

##### - Criação e organização dos requisitos do projeto
Fui responsável por elaborar todos os [requisitos](https://github.com/matheus-fiebig/portfolio-fatec/blob/main/5sem/devops/Requisitos.md) do projeto.   

##### - Criação e manutenção do backlog
Como PO, uma das minhas responsabilidades também foi a criação do [backlog](https://github.com/matheus-fiebig/portfolio-fatec/tree/main/5sem/backlog) para o time de desenvolvimento, garantindo que todas as tarefas estivessem alinhadas com a entrega de valor para o cliente.
 
    Estrutura das histórias para o time

    Requisitos
    -Identificação dos requisitos impactados pelo desenvolvimento da história (funcionais e não funcionais).

    Critérios de Aceite
    -Definição das funcionalidades que a história deveria possuir e do comportamento esperado no sistema.

    BDD
    -Cenários de execução baseados em eventos, criados para tornar a história mais testável e alinhada às interações do usuário na interface.

<br>

#### Como DEVOPS, minhas contribuições foram:
##### - Orquestração do gitflow da equipe

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
 

##### - Traceabilidade dos requisitos funcionais e não funcionais:

    Fui responsável por organizar o fluxo de rastreabilidade dentro do sistema. Desenvolvi um modelo que possibilita identificar quais requisitos foram impactados por um commit, além de permitir a visualização das histórias afetadas por cada requisito.Para isso é apenas necessário utilizar o JIRA e o GIT.
Você pode conferir mais detalhes no seguinte link: https://github.com/api-5-sem/api-documentation/blob/main/devops/Traceabilidade_De_Requisitos.md
 
<br>

#### Como Desenvolvedor, minhas contribuições foram:
##### Componentização e criacao dos dashboards do sistema
Criei o componente principal dos dashboards além de ter sido o responsável pela componentização dos gráficos. Diminuindo o código necessário para criar-se um novo gráfico e facilitando em muito o entendimento dos consumidores desse componente.
    
app-graphic <br>
@Input() public idx: number = 0; <br>
@Input() public chartId: string = '';<br>
@Input() public description: string = '';<br>
@Input() public lineChartType: string = 'line';<br>
@Input() public generatedValues: any[];<br>
@Input() public lineChartData: Array<any>;<br>
@Input() public lineChartLabels: Array<any>;<br>
@Input() public lineChartColors: Array<any><br>

Como pode ser visto acima, todos os gráficos utilizavam a mesma entrada de dados para serem exibidos, sendo necessária apenas a permutação desses valores para gerar gráficos diferentes, o que atendia a uma das propostas do nosso sistema. Além disso, outro ganho foi a centralização da regra desse componente em um único lugar, facilitando a implementação de funcionalidades futuras, como a customização e o compartilhamento de dashboards.

##### Criacao da tela de permissionamento
Criei a tela de permissionamento, que permitia ao usuario controlar as permissoes de um determinado grupo do sistema. O controle de permissões era realizado em uma única página. O sistema obtinha todas as permissões existentes e, em seguida, todas as permissões que aquele grupo possuía. Quando os dois conjuntos de dados se interseccionavam, o sistema realizava a marcação do checkbox e adicionava a permissão a uma lista de permissões mantidas. Quando uma permissão era desmarcada, ela era removida dessa lista. Ao salvar, enviavam-se apenas as permissões que permaneciam no sistema.
 
#### Hard Skills
<table align="left">
  <tr>
    <th width="300px">Tecnologia/Metodologia</th>
    <th width="300px">Classificação</th>
  </tr>
  <tr>
    <td>Typescript</td>
    <td>★★★★★★★★☆☆</td>
  </tr>
  <tr>
    <td>Angular</td>
    <td>★★★★★★★★★★</td>
  </tr>
  <tr>
    <td>Java</td>
    <td>★★★★★★★★☆☆</td>
  </tr>
  <tr>
    <td>Spring Boot</td>
    <td>★★☆☆☆☆☆☆☆☆</td>
  </tr>
  <tr> 
    <td>Devops</td>
    <td>★★★★★★★★★☆</td>
  </tr>
  <tr> 
    <td>PostgreSQL</td>
    <td>★★★★☆☆☆☆☆☆</td>
  </tr>
</table>
<br><br><br><br><br><br><br><br><br><br><br>

#### Soft Skills
<table align="left">
  <tr>
    <th width="300px">Tecnologia/Metodologia</th>
    <th width="300px">Classificação</th>
  </tr>
  <tr>
    <td>Comunicação</td>
    <td>★★★★★★★★★★☆</td>
  </tr>
  <tr>
    <td>Responsabilidade</td>
    <td>★★★★★★★★★★☆</td>
  </tr>
  <tr>
    <td>Organização</td>
    <td>★★★★★★★☆☆☆☆</td>
  </tr>
</table>
<br><br><br><br><br><br><br>

  ### Comunicação
  Para mim, a comunicação é a principal habilidade quando se trabalha em equipe. Toda informação relevante deve ser compartilhada: o status das tarefas, as dificuldades e até as facilidades encontradas. Comunicar-se bem nos ajuda a elaborar planos e definir medidas mais eficazes para o trabalho em grupo. Por isso, escolhi essa soft skill. Se quero me desenvolver profissionalmente, avaliar os pontos fortes e fracos da minha comunicação é algo essencial.
  
  ### Responsabilidade
  Responsabilidade foi a minha segunda escolha, pois, como trabalhamos com sprints, garantir uma entrega é sempre um compromisso. Se algo foi acordado como parte da entrega no início, considero fundamental me comprometer para que ela seja concluída no final. Assumir esse compromisso com seriedade é essencial para manter a confiança e a previsibilidade dentro do time.
  
  ### Organização
  Escolhi a organização especialmente por ter atuado, também, como PO neste semestre. Saber me organizar e repassar essa organização para o time é sempre bem-vindo. Se eu não consigo estruturar as demandas de forma eficaz, a entrega do time como um todo acaba sendo impactada.
<hr>


## Gestão de Reflorestamento
**A EMPRESA** parceira escolhida foi a Kersys.
<br>
<p align="center">
  <img src="https://github.com/user-attachments/assets/018f0daa-2d64-4da0-a47a-5f783e44a482">
</p>

**O PROBLEMA**  proposto pela empresa parceira consistiu no desenvolvimento de um sistema inteligente para o planejamento e monitoramento de reflorestamento, com o objetivo de prever padrões favoráveis ao crescimento saudável das árvores. 
<br>
<br>
**A SOLUÇÃO**  proposta consistiu no desenvolvimento de um sistema que permite ao usuário cadastrar e atualizar, em períodos arbitrários, dados relacionados à sua colheita. Com base nessas informações, o sistema é capaz de prever aspectos ligados ao crescimento e à projeção de gastos da colheita, além de sugerir melhorias por meio de algoritmos de classificação e agrupamento. Além disso, todo o desenvolvimento foi realizado em conformidade com as diretrizes da Lei Geral de Proteção de Dados (LGPD).

#### Tecnologias Utilizadas
- C#
- Java
- Spring Boot
- TypeScript
- Angular
- PostgreSQL
- MongoDB. 

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
##### Criação da biblioteca de portabilidade de dados ([GIT](https://github.com/matheus-fiebig/portfolio-fatec/tree/main/6sem/api-portabilidade))
Ela e divida em dois projetos, um projeto utilizado para teste e o outro a biblioteca em si. 
<br> 

    Esta biblioteca e divida em 3 metodos:
    1-CreateNewAccessToken: Responsável por gerar as chaves de autorização que permitem a comunicação segura entre a biblioteca e a API.<br>
    2-GetUserDataAsync: Solicita ao usuário final a autorização para a portabilidade de seus dados.<br>
    3-DecryptUser: Método auxiliar utilizado para descriptografar os dados do usuário recebidos por meio do webhook.<br><br>

    O processo se inicia com a criação de chaves de autorização pelo usuário, permitindo a comunicação com a API. 
    Em seguida, é solicitada ao usuário final a autorização para a portabilidade dos dados. Durante todo o processo, as informações são protegidas por criptografia: utiliza-se criptografia assimétrica para proteger as chaves simétricas, que por sua vez são responsáveis por criptografar os dados transmitidos (tanto as requisições quanto as respostas) entre a API e a biblioteca.
    Após a solitiação, o usuário que solicitou a portabilidade recebe um link para acesso à API, onde a autorização é formalizada. Por fim, a API envia os dados criptografados do usuário ao consumidor por meio de um webhook seguro.

#### Hard Skills
  <table align="left">
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
<br><br><br><br><br><br><br><br><br><br><br><br>
 
#### Soft Skills
  <table align="left">
    <tr>
      <th width="300px">Tecnologia/Metodologia</th>
      <th width="300px">Classificação</th>
    </tr>
    <tr>
      <td>Comunicação</td>
      <td>★★★★★★★★★☆☆</td>
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
