**A EMPRESA** parceira escolhida foi a FATEC.
<br>
<br>
**O PROBLEMA** em questão está relacionado à criação de um portal para avaliação 360 graus, no qual cada usuário realiza uma autoavaliação e também avalia os demais membros de sua equipe em algumas soft skills preestabelecidas. Além disso, o sistema deve permitir a avaliação de cada líder e PO pelo líder do grupo e pelo Fake Client, respectivamente.
<br>
<br>
**A SOLUÇÃO** proporcionou ao usuário uma avaliação 360° dos times dos quais ele fazia parte e permitiu o acompanhamento de suas notas em um dashboard interativo, visando monitorar sua evolução a cada sprint.  <br>
Além disso, o sistema permite que o administrador gerencie os usuários, a composição dos times e o fluxo das sprints.

[GIT](https://github.com/matheus-fiebig/bertoti/blob/main/portifolio-bd/1sem/README.md)

#### Tecnologias Utilizadas
- Python: Linguagem utilizada no backend para criação dos endpoints e implementação dos casos de uso.

- JavaScript: Linguagem utilizada no frontend para manipulação de dados e integração com a API.
  
- HTML/CSS: Utilizados para estilização e estruturação das telas. Escolhido por ser um padrao no desenvolvimento Web 

- FastAPI: Framework utilizado no backend para criação rápida de APIs e validação automática de dados
  
#### Contribuições Pessoais
**<br>**
Nesse projeto atuei como desenvolvedor e scrum master.

Como desenvolvedor, minhas contribuições foram:

#### - Criação de uma camada de abstração de dados:
Devido à limitação do uso de banco de dados nesta API, a squad optou pelo uso de um JSON para guardar todas as informações vigentes sobre um determinado assunto. Tendo isso em vista, eu fui responsável por criar toda a lógica de abstração para realizaçã de um CRUD  em nosso 'banco'.

<details>

  ```

    def get_all(self):
        return self._context.dataset 

    def get(self, id):
        index = self._get_registry_index(id)

        if index == -1:
            return {}

        return self._context.dataset[index]

    def insert(self, data):
        self._context.last_index += 1
        data.id = self._context.last_index
        self._context.dataset.append(data)
        return data

    def update(self, data):
        index = self._get_registry_index(data.id)

        if index == -1:
            raise Exception("Registry not found")

        self._context.dataset[index] = data
        return data

    def delete(self, id):
        index = self._get_registry_index(id)

        if index == -1:
            raise Exception("Registro não encontrado")

        del self._context.dataset[index]


  ```

- Como pode ser visto no código acima, todos os métodos do CRUD estão implementados. O funcionamento desta classe era simples e seguia as regras abaixo:
  - Todo repositório criado em nossa aplicação herdava da classe que englobava os dados mencionados.
  - Ao ser inicializado, o repositório carregava em memória todos os dados presentes no nosso JSON dentro de uma variável chamada *dataset*.
- Para buscas:
  - O código iterava sobre a variável dataset e retornava o objeto cujo id foi requisitado
  - O código retornava todo dataset 
- Para inserção/ deleção / atualização de dados:
  - 1. O arquivo era limpo.
  - 2. Os valores presentes no *dataset* eram manipulados.
  - 3. Ao se realizar a chamada do método commit, os dados era inseridos de uma vez naquele arquivo.
    
</details>

#### - Criação da tela de gestão de sprints:
Fui responsavel pela criacao de toda tela de gestão de sprints (Visualizacao, Cadastro, Edicao e Delecao). 
<details>
Como não foi utilizado nenhum framework, toda a renderização desta tela é feita com JavaScript puro e manipulação direta do DOM. Além disso, nossas rotas de backend eram muito simples, o que fazia com que muitas consultas às entidades criadas retornassem apenas objetos simples, sem relacionamentos aninhados. Isso aumentava a complexidade na criação da tela, pois era necessário fazer manualmente a junção de diversas entidades, muitas vezes utilizando a função <i>filter</i> para exibir seus valores na tela.
  
  ```

          async function loadSprints() {
            var sprints = await getSprints();
            var times = await getTeams();
            var tbody = document.getElementById('tbody-sprint');
           
            for (var i = 0; i < sprints.length; i++) {
                tbody.innerHTML += `
                    <tr class=\"tr-shadow\"> 
                        <td> ${sprints[i].name} </td>
                        <td> ${sprints[i].start_date} </td>
                        <td> ${sprints[i].end_date }</td>
                        <td> ${times.filter(x => x.id == sprints[i].team_id)[0]?.times} </td>
                        <td>
                            <div class=\"table-data-feature\">
                                <button 
                                    class=\"item\" 
                                    data-toggle=\"modal\" 
                                    data-target=\"#createsprint\" 
                                    data-placement=\"top\"
                                    title=\"Editar\" 
                                    onclick=\"loadSprint(${sprints[i].id})\"
                                >
                                    <i class=\"zmdi zmdi-edit\"></i>
                                </button>
                                <button 
                                    class=\"item\" 
                                    data-toggle=\"tooltip\" 
                                    data-placement=\"top\"
                                    title=\"Deletar\" 
                                    onclick=\"deleteSprint(${sprints[i].id})\"
                                > 
                                    <i class=\"zmdi zmdi-delete text-danger\"></i>
                                </button>
                            </div>
                        </td>
                    </tr>
                    <tr class=\"spacer\">
                    </tr>
                `
            }
        }
  
  ```

Como pode-se ver no código acima, uma simples consulta resultava em métodos excessivamente complexos. Para contornar isso, propus uma solução que envolvia a divisão dos scripts por localidade. Dessa forma, qualquer script poderia ser reutilizado em diferentes partes do sistema, distribuindo as responsabilidades em arquivos distintos e facilitando a codificação.

  ```

         function insertOrUpdate(){
            var json = formToJson("sprint-form");

            if(json["id"] == 0){
                if(!isTeamChoosed) {
                    createSprintForGroup(json)
                    return;
                }
                createSprint(json);
                return;
            }

            updateSprint(json)
        }

  ```
Essa divisão de responsabilidades facilitou muito a execução de qualquer script de inserção, deleção ou atualização, pois centralizou-se alguns métodos repetitivos e frequentemente utilizados (como formToJson) e outros que realizavam apenas comunicação HTTP (como createSprint e updateSprint) em um script separado.

</details>

#### - Criação da tela de login e  controle de permissionamento:
Para implementar o sistema de permissionamento nesta API, desenvolvi um controle de rotas no frontend, permitindo que cada usuário visualizasse apenas os recursos compatíveis com seu nível de permissão (no caso, havia dois tipos: administrador e usuário comum). Como mencionado anteriormente, a ausência de um framework tornava o desenvolvimento mais desafiador. Para superar essa dificuldade, criei um script que inseria dinamicamente toda a barra lateral na página do usuário, levando em consideração o seu nivel de permissionamento.

<details>
O fluxo era realizado da seguinte maneira:
  
1 - O usuário realizava o login na tela abaixo, e as informações do usuário autenticado, incluindo seu nível de permissão no sistema, eram armazenadas no local storage.

<img src="https://github.com/matheus-fiebig/bertoti/blob/main/portifolio-bd/assets/1sem/tela_login.png"></img>


2 -  O script de criação dinâmica da sidebar era injetado para gerenciar o controle de permissionamento nas páginas subsequentes à login. Como mostrado no código abaixo, ocorre a substituição de todo o componente demarcado como menu-navbar por um HTML controlado pelo nível de permissão do usuário (admin-only). Essa abordagem reduzia o controle manual da sidebar no HTML, já que não era mais necessário adicionar cada item manualmente em todas as telas, diminuindo, por sua vez, as chances de erro.
  ```

  var user = JSON.parse(window.localStorage.getItem('user'));
  var sidebarElement = document.getElementById("menu-navbar");
  for (var i = 0; i < sidebar.length; i++) {
      var id = sidebar[i].link;
  
      if (sidebar[i]["admin-only"])
          continue;
  
      sidebarElement.innerHTML +=
          `
          <li id="${id}">
              <a 
                  href="${sidebar[i].link}"  
              >
                  <i class="${sidebar[i].icon}"></i>${sidebar[i].description}
              </a>
          </li>
      `
  }
  
  //Sidebar active
  var currentPage = window.location.href;
  var pageHtml = currentPage.substring(currentPage.lastIndexOf('/') + 1, currentPage.length)
  
  sidebarElement.innerHTML = sidebarElement.innerHTML.replace(',', '')
  var el = document.getElementById(pageHtml)
  el.classList.add('active');

  ```
  
</details>


Como scrum master, minhas contribuições foram:
#### - Acompanhamento das entregas:
Fui responsável pelo monitoramento contínuo e pela cobrança diária das entregas da equipe, elaborando relatórios semanais de status para o M2, através da utilização do JIRA.

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
      <td>Responsabilidade</td>
      <td>★★★★★★★★★★</td>
    </tr>
  </table>
</details>

