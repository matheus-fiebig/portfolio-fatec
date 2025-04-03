<h1 align="center"> Dashboard Interativo para Análise de Dados de Recrutamento e Seleção </h1>

## :page_facing_up: Sobre o projeto

O projeto busca resolver os desafios das equipes de recrutamento na centralização e análise de dados essenciais do processo seletivo. Atualmente, métricas como número de candidatos, tempo de contratação e custos são fragmentadas ou de difícil acesso, prejudicando uma visão clara e estratégica. A ausência de uma plataforma unificada e personalizável compromete a eficiência operacional e limita a capacidade de ajustar as análises de acordo com as necessidades específicas, afetando diretamente a otimização do processo de recrutamento.

## :books: Solução

Desenvolver um sistema que possibilite ao usuário personalizar os gráficos exibidos, selecionando tanto o tipo de gráfico quanto os campos para filtragem de dados, por meio de uma interface de configuração interativa.

Implementar um sistema modular de permissões, permitindo que o administrador defina quais conteúdos cada usuário pode acessar, tanto nos dashboards quanto em outras áreas do sistema.

Criar uma funcionalidade de envio de notificações por e-mail ao administrador quando um indicador ultrapassar um limite pré-estabelecido, mantendo a mesma flexibilidade de personalização usada na criação dos dashboards.

Desenvolver um sistema de exportação que permita ao usuário baixar os gráficos e dados visualizados diretamente na tela.
<details>  
<summary><b> Requisitos do projeto: </b></summary>

## :wrench: Requisitos funcionais

     RF-1: O usuário pode escolher qual tipo de gráfico será exibido;

     RF-2: O usuário pode realizar a personalização de relatórios com filtros;

     RF-3: Cada usuário deve ter seu próprio dashboard configurável;

     RF-4: Deve ser possível a extração de qualquer relatório gerado para PDF;

     RF-5: Deve ser possível a extação de qualquer relatório gerado para Excel;

     RF-6: Deve-se criar um nível de permissionamento para todas as ações do sistema;

     RF-7: Deve-se permitir que o administrador gerencie permissões;

     RF-8: O envio de notificações por e-mail deve ocorrer sempre que os indicadores chaves ultrapassarem limites pré-definidos;

     RF-9: Os administradores podem configurar alertas automáticos com base em indicadores chave de desempenho.
     
     RF-10 Deve ser possível importar dados através de um modelo padrão
     
##  :bookmark_tabs: Requisitos não funcionais

    RNF-1: O sistema deve realizar autorização através de token JWT;

    RNF-2: O sistema deve ser compatível com os principais navegadores (Chrome, Firefox, Edge, Safari) e dispositivos móveis;

    RNF-3: O sistema deve ser intuitivo e fácil de usar;

    RNF-4: Deve ser responsivo, adaptando-se a diferentes dispositivos, como desktops, tablets e smartphones;

    RNF-5: Controle de permissões detalhado, garantindo que usuários só possam visualizar ou modificar dashboards e relatórios de acordo com seu nível de acesso;

    RNF-6: Implementar mecanismos de rollback para evitar perda de dados em caso de falhas.

</details>



## :clipboard: Backlog
<details>  
<summary> Confira o backlog do produto: </summary>
<br>
<table>
  <tr>
    <th>Rank</th>
    <th>Prioridade</th>
    <th>Feature</th>
    <th>User Story</th>
    <th>Sprint</th>
    <th>Requisitos</th>
  </tr>
  <tr>
    <td>1</td>
    <td>Alta</td>
    <td>Visualizar dashboards</td>
    <td>Eu como usuário, quero poder visualizar um dashboard para que eu possa ter ciência sobre as métricas atuais de recrutamento e seleção da empresa</td>
    <td>1</td>
    <td>RF-1, RF-2, RF-3, RF-7, RNF-2, RNF-3, RNF-4 </td>
  </tr>
  <tr>
    <td>2</td>
    <td>Média</td>
    <td>Importar dados provisionados</td>
    <td>Eu como administrador do sistema, quero importar os dados provisionados pelo cliente para que os dados possam ser centralizados em um único banco de dados</td>
    <td>1</td>
     <td>RF-10, RNF-2, RNF-6, RF-6 </td>
  </tr>
  <tr>
    <td>3</td>
    <td>Alta</td>
    <td>Gerir Dashboards</td>
    <td> Eu como usuário, quero poder gerir os meus dashboards para que eu possa configurar meus dashboards de maneira customizável</td>
    <td>2</td>
    <td>RNF-2, RNF-3, RNF-4, RNF-5, RF-1, RF-2 , RF-3, RF-6 </td>
  </tr>
  <tr>
    <td>4</td>
    <td>Alta</td>
    <td>Seleção de Indicadores personalizada - Cadastro</td>
    <td>Eu como administrador do sistema, quero poder criar notificações de email personalizadas com base em indicadores para que eu possa ter um direcionamento mais assertivo dos problemas da empresa</td>
    <td>2</td>
    <td>RNF-2, RNF-3, RNF-4, RNF-5, RF-6, RF-9</td>
  </tr>
  <tr>
    <td>5</td>
    <td>Alta</td>
    <td>Seleção de Indicadores personalizada - Visualização</td>
    <td>Eu como administrador do sistema, quero poder visualizar as notificações de email personalizadas para que eu possa saber quais notificações foram criadas</td>
    <td>2</td>
    <td>RNF-2, RNF-3, RNF-4, RNF-5, RF-6, RF-9 </td>
  </tr>
  <tr>
    <td>6</td>
    <td>Alta</td>
    <td>Seleção de Indicadores: envio de email</td>
    <td>Eu como administrador do sistema, quero poder receber notificações em meu email para que eu possa ser avisado quando determinado indicador for ultrapassado</td>
    <td>2</td>
    <td>RNF-5, RF-8, RF-9</td>
  </tr>
  <tr>
    <td>7</td>
    <td>Média</td>
    <td>Autenticação de usuário</td>
    <td>Eu como usuário, quero poder realizar login na aplicação para que eu possa visualizar os dashboards do sistema</td>
    <td>3</td>
    <td>RNF-1, RNF-2, RNF-4, RF-6</td>
  </tr>
  <tr>
    <td>8</td>
    <td>Média</td>
    <td>Gerir permissões</td>
    <td>Eu como administrador do sistema, quero poder dar e remover permissões do usuário para que eu possa ter o controle granular de cada usuário</td>
    <td>3</td>
    <td>RNF-3, RNF-4, RNF-5, RF-6, RF-7</td>
  </tr>
  <tr>
    <td>9</td>
    <td>Média</td>
    <td>Deletar indicadores chaves</td>
    <td>Eu como administrador do sistema, quero poder remover indicadores chaves para que eu possa excluir aqueles que não são mais relevantes para a minha análise.</td>
    <td>3</td>
    <td>RNF-3, RNF-5, RF-6, RF-7</td>
  </tr>
  <tr>
    <td>10</td>
    <td>Baixa</td>
    <td>Gerar Relatórios - PDF</td>
    <td>Eu como usuário, quero poder exportar um determinado dashboard para PDF para que eu tê-lo disponível offline</td>
    <td>4</td>
    <td>RRNF-3, RF-2, RF-4</td>
  </tr>
  <tr>
    <td>11</td>
    <td>Baixa</td>
    <td>Gerar Relatórios - Excel</td>
    <td>Eu como usuário, quero poder exportar um determinado dashboard para EXCEL para que eu tê-lo disponível offline</td>
    <td>4</td>
    <td>RNF-3, RF-2, RF-5</td>
  </tr>
</table>
</details>

## :calendar: Entregas

| Sprint | Periodo | Status |
| :---: | :---: | :---: |
| 1 | 09/09/24 - 29/09/24 |:white_check_mark:  |
| 2 | 30/09/24 - 20/10/24 |:white_check_mark:  |
| 3 | 21/10/24 - 10/11/24 |  |
| 4 | 11/11/24 - 01/12/24 |  |

### Sprint-1
<details>

Dashboard
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/Exibicao-de-graficos.gif)

Importação de dados
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/Insercao-de-Dados.gif)
 
</details>

### Sprint-2
<details>

Editar Card
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/MudancaCard_1.gif)

Editar Graficos

![](https://github.com/api-5-sem/api-documentation/blob/main/assets/MudancaGrafico_1.gif)

Vizualizar Indicador Chave
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/VisualizarIndicadorChave_1.gif)

Criar Indicador Chave
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/CadastrarIndicador_1.gif)

Envio de email
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/IndicadorAtingido_1.gif)
 
</details>

### Sprint-3
<details>

Deletar Indicador Chave
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/DeletarIndicadores.gif)

Login
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/Login.gif)

Gerir Permissões
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/VisualizarIndicardorEAlterar.gif)

Permissões Em Pratica
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/Permissionamento.gif)

</details>

### Sprint-4
<details>

Exportar PDF
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/PDF.gif)

Exportar EXCEL
![](https://github.com/api-5-sem/api-documentation/blob/main/assets/EXCEL.gif)

</details>


## :busts_in_silhouette: Equipe de desenvolvimento

| Função | Nome |
| :---: | :---: |
| Product Owner | [Matheus Cruz Fiebig](https://github.com/matheus-fiebig) |
| Scrum Master | [Wagner de Deus da Silva Júnior](https://github.com/wdeus) |
| Dev | [Alisson dos Santos Pereira](https://github.com/41issonm) |
| Dev | [Beatrice Lopes Correa](https://github.com/beatricelopes) |
| Dev | [Danillo Wesley da Costa Silva](https://github.com/xxzidanilloxx) |
| Dev | [Luciano do Nascimento Pamplona da Silva](https://github.com/lucianonps) |
