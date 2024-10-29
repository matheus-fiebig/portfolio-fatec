**A EMPRESA** parceira escolhida foi a Oracle.
<br>
<br>
**O PROBLEMA** proposto pela empresa parceira foi desenvolver um sistema que permitisse aos usuários acompanhar o progresso de cada parceiro participante do programa de parceria. Para isso, era essencial monitorar a porcentagem de parceiros por estado, a taxa de conclusão de cada parceiro em seus cursos de capacitação e a proximidade do vencimento de cada curso.
<br>
<br>
**A SOLUÇÃO** proposta foi desenvolver um sistema capaz de gerenciar usuários, empresas parceiras e trilhas de ensino. Além disso, permitia o acompanhamento em tempo real do progresso de cada parceiro e a emissão de notificações com base na expiração de seus cursos.


[GIT](https://github.com/matheus-fiebig/portifolio-bd/tree/main/4sem)

#### Tecnologias Utilizadas
- Java: Linguagem principal utilizada no backend, amplamente aplicada no desenvolvimento web e mobile. Orientada a objetos, é a principal linguagem ensinada na FATEC. Foi selecionada em função dos requisitos não funcionais.

- Spring Boot: Framework essencial para desenvolvimento web, utilizado na configuração e estruturação do projeto, criação de endpoints, persistência de dados e segurança da API. Escolhido em conformidade com requisitos não funcionais.

- TypeScript: Linguagem frontend escolhida em substituição ao JavaScript, proporcionando maior escalabilidade, facilidade de manutenção e depuração do código por conta de sua tipagem estática.

- Vue: Framework frontend que simplifica a manutenção e permite a criação de componentes. Foi escolhido para atender aos requisitos não funcionais.

- MySQL: Sua confiabilidade, performance e facilidade de uso foram fundamentais para a escolha. Permite realizar a persistência e garantir a integridade dos dados do sistema.


#### Contribuições Pessoais
**<br>**
Nesse projeto atuei principalemnte no frontend

Como desenvolvedor, minhas contribuições foram:

#### - Desenvolvimento da tela de Lacunas de Habilidade :
Esta tela tinha como objetivo permitir o acompanhamento da progressao dos parceiros da Oracle em uma determinada trilha. 
<details>
Fui responsável por todo o desenvolvimento, reproduzindo fielmente o design solicitado pelo nosso UI no Figma e implementando a integração completa entre o backend e o frontend. A interface, embora não fosse excessivamente complexa, atendeu plenamente aos requisitos, conforme demonstrado abaixo.
  
![image](https://github.com/user-attachments/assets/4fbf8f59-0d74-4b88-ade2-9c6f47c4b729)

Configurei o Axios nesta tela para apontar consistentemente para uma URL predeterminada, simplificando o desenvolvimento e facilitando futuras implementações.
</details>

#### - Desenvolvimento da tela de Avalicao de Parceiros :



#### - Desenvolvimento do layout padrão e organização da estrutura CSS:
Criei o layout da padrão de todas as telas (header, footer e content)
<details>
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

Exemplo de isolamento de CSS mencionado no parágrafo anterior. 
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
      <td>★★★★★★★★☆☆</td>
    </tr>
    <tr>
      <td>Trabalho em Equipe</td>
      <td>★★★★★★☆☆☆☆</td>
    </tr>
    <tr>
      <td>Resolução de Problemas</td>
      <td>★★★★★★★☆☆☆</td>
    </tr>
    <tr>
      <td>Responsabilidade</td>
      <td>★★★★★★★★☆☆</td>
    </tr>
  </table>
</details>
