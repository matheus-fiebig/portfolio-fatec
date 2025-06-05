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

## Meus Projetos

### Em 2022-2
**A EMPRESA** parceira escolhida foi a FATEC.
<br>
<br>
**O PROBLEMA** em questão está relacionado à criação de um portal para avaliação 360 graus, no qual cada usuário realiza uma autoavaliação e também avalia os demais membros de sua equipe em algumas soft skills preestabelecidas. Além disso, o sistema deve permitir a avaliação de cada líder e PO pelo líder do grupo e pelo Fake Client, respectivamente.
<br>
<br>
**A SOLUÇÃO** proporcionou ao usuário uma avaliação 360° dos times dos quais ele fazia parte e permitiu o acompanhamento de suas notas em um dashboard interativo, visando monitorar sua evolução a cada sprint.  <br>
Além disso, o sistema permite que o administrador gerencie os usuários, a composição dos times e o fluxo das sprints.


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


#### - Criação da tela de gestão de sprints:
Fui responsavel pela criacao de toda tela de gestão de sprints (Visualizacao, Cadastro, Edicao e Delecao). 
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

#### - Criação da tela de login e  controle de permissionamento:
Para implementar o sistema de permissionamento nesta API, desenvolvi um controle de rotas no frontend, permitindo que cada usuário visualizasse apenas os recursos compatíveis com seu nível de permissão (no caso, havia dois tipos: administrador e usuário comum). Como mencionado anteriormente, a ausência de um framework tornava o desenvolvimento mais desafiador. Para superar essa dificuldade, criei um script que inseria dinamicamente toda a barra lateral na página do usuário, levando em consideração o seu nivel de permissionamento.

O fluxo era realizado da seguinte maneira:
  
1 - O usuário realizava o login na tela abaixo, e as informações do usuário autenticado, incluindo seu nível de permissão no sistema, eram armazenadas no local storage.

<img src="https://github.com/matheus-fiebig/portfolio-fatec/blob/main/assets/1sem/tela_login.png"></img>


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

Como scrum master, minhas contribuições foram:
#### - Acompanhamento das entregas:
Fui responsável pelo monitoramento contínuo e pela cobrança diária das entregas da equipe, elaborando relatórios semanais de status para o M2, através da utilização do JIRA.

#### Hard Skills
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

#### Soft Skills
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

<br>

### Em 2023-1
**A EMPRESA** parceira escolhida foi a 2RP.
<br>
<br>
**O PROBLEMA** abordado por eles refere-se à necessidade de um sistema para gerenciar horas extras. Os usuários devem ser capazes de registrar suas horas adicionais de trabalho e acessar essas informações em tempo real. Além disso, os gestores e administradores devem ter a capacidade de controlar o acesso ao sistema, extrair relatórios detalhados das horas trabalhadas por cada usuário e personalizar diversas configurações do sistema, tais como definir as horas iniciais do período noturno e especificar o valor correspondente a essas horas extras.
<br>
<br>
**A SOLUÇÃO** entregue proporcionou ao administrador o controle completo (CRUD) de cada usuário, centro de resultado e cliente. Além disso, ele consegue parametrizar o sistema, definindo o valor de cada taxa de trabalho e estabelecendo o início/fim da hora de trabalho noturno, entre outros aspectos importantes. Por fim, o administrador é capaz de realizar a extração de relatórios das horas trabalhadas e aprovar/reprovar as horas extras lançadas. <br>
<br>
Para o gestor, foi concedida a capacidade de lançar horas extras e extrair relatórios relacionados a ele ou aos seus funcionários, além de poder acompanhar em tempo real as horas trabalhadas.
<br>
<br>
Por fim, para o usuário, foi desenvolvida a funcionalidade de lançamento de horas extras e o acompanhamento detalhado das horas extras acumuladas ao longo do mês.

[GIT](https://github.com/matheus-fiebig/portfolio-fatec/tree/main/2sem)

#### Tecnologias Utilizadas
- Java: Linguagem principal utilizada no nosso projeto. A linguagem foi amplamente adotada tanto na manipulação dos dados quanto na crição de eventos atrelados a exibição de dados desses.

- CSS: Utilizado na estilização das telas. Foi escolhido pois se adequava com a ferramenta de criação de layout SceneBuilder  

- MySQL: Sua confiabilidade, desempenho e facilidade de uso garatiram sua escolha.Permite realizar a persistência e integridade dos dados do sistema.

#### Contribuições Pessoais
**<br>**
Nesse projeto atuei como desenvolvedor e scrum master.
Como desenvolvedor, minhas contribuições foram:
#### - Desenvolvimento da Tela de Lançamento de Horas:
Fui encarregado de criar a tela de lançamento de horas no SceneBuilder, utilizando para isso CSS e algumas imagens padrões da empresa parceira. Nessa mesma tela foi implementado algumas regras de controle para lançamento e reprovação de horas, de modo que, cada nível de control conseguisse visualizar suas determinadas ações.

    ```

      public void lancarHoras(ActionEvent event) {
            var rows = table_lancamento.getItems();
            for (ExtratoHoraModel extratoHoraModel : rows) {
                if (extratoHoraModel.getId() != 0) {
                    continue;
                }
                extratoHoraModel.setIdUsuario(UsuarioDAO.usuarioLogado.getId());

                if (UsuarioDAO.usuarioLogado.getIdTipoUsuario() == TipoUsuario.Administrador || UsuarioDAO.usuarioLogado.getIdTipoUsuario() == TipoUsuario.Gestor)
                    extratoHoraModel.setStatus(EtapaExtrato.APROVADA);
                else
                    extratoHoraModel.setStatus(EtapaExtrato.EM_APROVACAO);

                var rowsModified = extratoHoraDao.lancarHora(extratoHoraModel);
                if (rowsModified <= 0) {
                    MensagemRetorno.erroCadastro();
                    return;
                }
            }

            MensagemRetorno.sucessoCadastro();
        }
    ```

Como pode ser visto, aqui esta a implementação do lançamento de horas, na qual existe toda a parte de controle de lançamento com base no seu nível de acesso. Além disso é possivel analisar como é realizado o controle no nosso sistema, através de campo estático que é atribuido durante a ação de login do usuário.
 

#### - Desenvolvimento da Tela de Cadastro de CR e Visualização de CR:
Participei também do desenvolvimento da tela de cadastro e de visualização do CR, duas telas bem simples nas quais o usuário apenas tinha o controle de quais centro de custo estavam cadastrados, podendo fazer as operações básicas de um CRUD. A tela em si não possuia nenhuma regra de negócio e apenas servia para popular as comboboxes do sistema.



<img src="https://github.com/matheus-fiebig/portfolio-fatec/blob/main/assets/2sem/tela_gerenciamento%20cr.png"></img>

Como pode ser visto acima, o usuário selecionava um CR e selecionava qual integrante do sistema ia ser atribuído aquele CR. Nesta tela fui responsável, também, por toda a parte de criação do Layout e regras de cadastro / visualização
 

#### - Desenvolvimento da Tela de Feedback:
Por fim como desenvolvedor participei do desenvolvimento da tela de Feedback. Esta tela é um complemento da tela de Lançamento de Horas e possuía regras similares a ela. Participei principalemente do parte de aprovação/reprovação de horas na qual um modal aparecia para o usuário. Este modal permite ao usuário descrever o motivo da reprovação.


    ```
    
    FeedbackController.java
     {
                        btnAprovar.setOnAction((ActionEvent event) -> {
                            ExtratoHoraModel extratoHora = getTableView().getItems().get(getIndex());
                            extratoHora.setStatus(EtapaExtrato.APROVADA);

                            if (EtapaExtrato.APROVADA == extratoHora.getStatus()) {
                                extratoHoraDao.aprovarHoraExtra(extratoHora);
                                carregarExtratos();
                            }
                        });
                    }
                    {
                        btnReprovar.setOnAction((final ActionEvent event) -> {
                            final ExtratoHoraModel extratoHora = getTableView().getItems().get(getIndex());
                            extratoHora.setStatus(EtapaExtrato.REPROVADA);

                            if (EtapaExtrato.REPROVADA == extratoHora.getStatus()) {
                                extratoHoraDao.reprovarHoraExtra(extratoHora);
                                FeedBackRetorno.motivo(extratoHoraDao, extratoHora);
                                carregarExtratos();
                            }
                        });
                    }

    ExtratoHoraDao.java
    public void aprovarHoraExtra(ExtratoHoraModel extratoHora) {
        try {
            String sql = "UPDATE Extrato_Hora SET Id_Etapa_Extrato = 2 WHERE Id = " + extratoHora.getId();
            executeUpdate(sql);
            extratoHora.setStatus(EtapaExtrato.APROVADA);

        } catch (Exception e) {
            e.addSuppressed(e);
        }

    }

    public void reprovarHoraExtra(ExtratoHoraModel extratoHora) {
        try {
            String sql = "UPDATE Extrato_Hora SET Id_Etapa_Extrato = 3 WHERE Id = " + extratoHora.getId();
            executeUpdate(sql);
            extratoHora.setStatus(EtapaExtrato.REPROVADA);

        } catch (Exception e) {
            e.addSuppressed(e);
        }
    }
                    
    ```

Como pode ser observado no código acima, a essência da funcionalidade de reprovação/aprovação de horas extras reside em uma atualização no banco de dados, que ocorre assim que o botão de aprovar/reprovar e clicado, com base no feedback fornecido pelo gestor ou administrador do sistema.
 

Como scrum master, minhas contribuições foram:
#### - Criaçao e acompanhamento das entregas:

Também fui responsável pela criação e acompanhamento das entregas da squad durante todas as sprints. Acompanhando de perto cada impedimento que o time pudesse vir a sofrer e fornecendo o devido apoio para cada integrante nesses momentos.

Também fui responsável pela criação manual do burndown e pela atualização diária de seus valores, como parte desse processo. A principal razão para a implementação do burndown foi a ausência de uma ferramenta tecnológica que auxiliasse no acompanhamento, como o Jira, na época. Para mais detalhes, segue o link dos <a href="https://github.com/matheus-fiebig/portfolio-fatec/tree/main/2sem/assets/burndown">burndowns</a>.

#### - Status report para o M2:

Por fim, eu era responsável por reportar semanalmente ao nosso M2 o andamento completo das entregas realizadas pela equipe ao longo das sprints. Esse acompanhamento envolvia a análise detalhada do progresso, identificando possíveis atrasos ou desvios e propondo soluções. Além disso, compartilhava regularmente os métodos e estratégias que utilizei para lidar com conflitos e remover impedimentos dentro da squad, garantindo a fluidez do trabalho e a manutenção do foco nos objetivos estabelecidos. Meu papel incluía tanto a mediação de problemas entre os integrantes quanto a antecipação de desafios que pudessem comprometer o sucesso das entregas.

#### Hard Skills

  <summary><b>Clique para ver a lista de hard skills</b></summary>
  <br>
  <table align="center">
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
 

#### Soft Skills

  <summary><b>Clique para ver a lista de softskills</b></summary>
  <br>
  <table align="center">
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
 


### Em 2023-2
**A EMPRESA** parceira escolhida foi a 2RP.
<br>
<br>
**O PROBLEMA** abordado por eles refere-se à necessidade de um sistema para gerenciar horas extras. Os usuários devem ser capazes de registrar suas horas adicionais de trabalho e acessar essas informações em tempo real. Além disso, os gestores e administradores devem ter a capacidade de controlar o acesso ao sistema, extrair relatórios detalhados das horas trabalhadas por cada usuário e personalizar diversas configurações do sistema, tais como definir as horas iniciais do período noturno e especificar o valor correspondente a essas horas extras.
<br>
<br>
**A SOLUÇÃO** entregue proporcionou ao administrador o controle completo (CRUD) de cada usuário, centro de resultado e cliente. Além disso, ele consegue parametrizar o sistema, definindo o valor de cada taxa de trabalho e estabelecendo o início/fim da hora de trabalho noturno, entre outros aspectos importantes. Por fim, o administrador é capaz de realizar a extração de relatórios das horas trabalhadas e aprovar/reprovar as horas extras lançadas. <br>
<br>
Para o gestor, foi concedida a capacidade de lançar horas extras e extrair relatórios relacionados a ele ou aos seus funcionários, além de poder acompanhar em tempo real as horas trabalhadas.
<br>
<br>
Por fim, para o usuário, foi desenvolvida a funcionalidade de lançamento de horas extras e o acompanhamento detalhado das horas extras acumuladas ao longo do mês.

[GIT](https://github.com/matheus-fiebig/portfolio-fatec/tree/main/3sem)

#### Tecnologias Utilizadas
- Java: Linguagem principal utilizada no nosso backend. Linguagem amplamente adotada no desenvolvimento web e mobile. Orientada a objeto e a principal linguagem ensinada na FATEC

- Springboot: Principal framework de desenvolvimento web, utilizado para configuração e organização do projeto, criação de endpoints, persistência de dados e segurança da nossa API  

- Typescript: Linguagem de desenvolvimento frontend. Facilita a depuração a manutenção do código, uma vez que, é tipada.

- Vue: Framework de desenvolvimento frontend. Facilita a manutenção e permitir a componentização de itens.  

- MySQL: Sua confiabilidade, desempenho e facilidade de uso garatiram sua escolha.Permite realizar a persistência e integridade dos dados do sistema.


#### Contribuições Pessoais
**<br>**
Nesse projeto atuei em duas frentes 
- Frontend: utilizando as tecnologias de vue e typescript e
- Product Owner

Como desenvolvedor, minhas contribuições foram:

#### - Desenvolvimento do Layout Padrão do Sistema:
Fui encarregado de criar e componentizar o layout padrão (menu lateral e conteiner do conteudo). Implementei regras de permissões específicas para que cada usuário visualizasse um menu adequado ao seu perfil. Além disso, desenvolvi controles para menus aninhados e não aninhados, garantindo uma experiência de usuário mais fluida e intuitiva.

    ```

    created(): void {
        const auth = useAuth();
        this.createSidebar(auth.getUser().permissionLevel);
    
        const currentUrl = this.$route.fullPath;
        this.menus.forEach(menu => {
            menu.active = currentUrl.includes(menu.link) &&     !!menu.link && menu.link != '/';
            this.activateSubItens(menu, currentUrl);
        })
    }

    private createSidebar(permissionLevel: number) {
        switch(permissionLevel){
        case 1: this.menus = colaboradorMenu; break;
        case 2: this.menus = gestorMenu; break;
        case 3: this.menus = adminMenu; break;
    }
    ```

Como pode ser visto aqui esta a parte de gerenciamento que controla qual acesso cada usuario tem  atraves de um objeto generico. Como pode ser observado a baixo

    ```
    export interface MenuParent extends MenuChild{
        icon: string;
        childs:MenuChild[];
    }

    export interface MenuChild{
        description:string;
        link:string;
        active:boolean;
    }

    ```
Além disso esse componente é subdivido com um componente filho para que o componente pai consigntrolar todo os estados genericos e para que cada filho consiga ter seu proprio estado independente
 

#### - Tela de Lançamento de Horas:
Desenvolvi o controle para exibição das telas de lançamento de horas, incluindo toda a funcionalidade de visualização das horas e seu fluxo de aprovação/reprovação . Isso envolveu a comunicação HTTP, criação do layout e a vinculação com o framework VUE. Além de necessitar do uso das diretivas do vue, como v-if e v-for.


<img src="..\..\assets\3sem\3_sem_lancamento_hora.png" width=1150 /></img>

Como pode ser visto na imagem acima, a tela de lançamento de horas envolve varios passos e diretivas. 
As diretivas de v-for são utilizadas para gerar as diversas linhas do sistema. O v-if controla todo o complexo sistema de regras de segurança, no qual permitirá ou não, ao usuário (dependendo do seu nível de permissão) aprovar ou reprovar hora. Por fim o v-model é responsável por realizar o <i>bind</i> do filtro com as variáveis de código, permitindo assim, realizar a requisição HTTP filtro para popular os dados 

<img src="..\..\assets\3sem\3_sem_lancamento_hora_v_for.png" width=300 /></img>

Acima esta um exemplo da utilização das <i>diretivas</i> do vue retratadas no parágrafo anterior para geração de contúdo dinâmico

 

#### - Tela de C.R. (Controle de Requisições):
Criei todas as operações do CRUD para as Requisições de Mudança (CRs), incluindo a atribuição de usuários a uma CR. Desenvolvi um sistema de lista para gerenciar quais usuários estariam associados a cada CR.


A feature do C.R é composta por algumas telas, primeiramente temos a tela de visualização e controle. Nela é possível realizar todas as ações de controle do CR além de visualiza-los (por exemplo deletar ou editar) 
<img src="..\..\assets\3sem\3_sem_cr.png" width=1000 /></img>

<br>
Além disso temos o cadastro de CR que faz uma requisição POST para o backend com todos os dados necessários para salvar um C.R ou edita-lo (depende da ação do usuário).

<img src="..\..\assets\3sem\3_sem_cr_cadastro.png" width=300 /></img>

<br>
Para finalizar temos a feature exclusiva de CR que é o controle de usuário por cr. Nessa feature temos um controle de N para N, ou seja, conseguimos colocar qualquer usuário em qualquer CR e em quantos CR quisermos. Desse modo é utilizado subtração e adição com listas para controlar o estado de qual usuário deve ser persistido no backend, como pode ser visto no código abaixo, no qual controlamos qual usuário e adicionado ao cr e qual é removido dele

    ```
    loadUsuarioCr(){
            this.limparCampos();
            http.get('/usuario')
            .then(x => {
                this.usuariosTotais = x.data;
                http.get('/crUsuario/' + this.idCr)
                    .then(y => {
                        const data = y.data as [
                            {
                                idUsuario: number,
                                idCr: number
                            }
                        ];

                        const usuariosCr = this.usuariosTotais.filter(z => data.map(z => z.idUsuario).includes(z.id));
                        this.usuariosDoCr.push(...usuariosCr)
                        
                        const usuariosForaDoCr = this.usuariosTotais.filter(z => !data.map(z => z.idUsuario).includes(z.id));
                        this.usuariosParaAdd.push(...usuariosForaDoCr)
                    });
            });
        }

    ```

 

#### - Tela de Dashboard:
Desenvolvi a tela de dashboard, utilizando a biblioteca Canvas.js para geração de gráficos. Nessa tela, os usuários podiam filtrar os dados e visualizar gráficos de barras com os dados filtrados, proporcionando uma visão clara e analítica do sistema.


    Para gerar o relatório com essa biblioteca, foi necessário criar uma tag de apexChart, delimitando assim onde seria gerado o relatório. Além disso para gerar os gráficos era necessário obte-los do backend (através de uma comunicação HTTP com o nosso servidor REST) e atribui-los a propriedade data do chartConfig. Todo esse fluxo pode ser visto no código abaixo:

    ```
    <apexchart
        type="bar"
        height="350"
        :options="chartConfig.chartOptions"
        :series="chartConfig.series"
    ></apexchart>
    getData() {
        const request = {
            idCliente: this.filter.idCliente,
            idCr: this.filter.idCr,
            dataInicio: this.filter.dataInicio + " 00:00:00",
            dataFim: this.filter.dataFim + " 23:59:59",
        };

        http.get("/dashboard", { params: request }).then((response) => {
            const user = useAuth().getUser();
            const filteredData = response.data.filter(
                (x: any) => x.idUsuario == user.id
            );

            this.chartConfig.series[0].data = [
                this.getHour(filteredData, "HE Diurno"),
                this.getHour(filteredData, "HE Noturno"),
                this.getHour(filteredData, "Sobreaviso"),
            ];
        });
    }
    ```
 

Como Product Owner
#### - Organização e Criacão do Backlog:
Criação e organização de todo o backlog do projeto, user storys, prioridades e afins. Todos com um bom alinhamento com o cliente.


 Como pode ser visto na imagem abaixo, todo o backlog e suas respectivas prioridades e user storys. Além disso há a organização por ÉPICOS e FEATURES de cada uma das histórias, bem como a sprint em que cada uma delas deveria entrar

 <img src="https://github.com/matheus-fiebig/portfolio-fatec/blob/main/3sem/assets/backlog.png"> </img>
 


#### Hard Skills

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
 

#### Soft Skills

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
      <td>★★★★★★★★☆☆</td>
    </tr>
    <tr>
      <td>Organização</td>
      <td>★★★★★★★★★☆</td>
    </tr>
  </table>
 


### Em 2024-1
**A EMPRESA** parceira escolhida foi a Oracle.
<br>
<br>
**O PROBLEMA** proposto pela empresa parceira foi desenvolver um sistema que permitisse aos usuários acompanhar o progresso de cada parceiro participante do programa de parceria. Para isso, era essencial monitorar a porcentagem de parceiros por estado, a taxa de conclusão de cada parceiro em seus cursos de capacitação e a proximidade do vencimento de cada curso.
<br>
<br>
**A SOLUÇÃO** proposta foi desenvolver um sistema capaz de gerenciar usuários, empresas parceiras e trilhas de ensino. Além disso, permitia o acompanhamento em tempo real do progresso de cada parceiro e a emissão de notificações com base na expiração de seus cursos.

[GIT](https://github.com/matheus-fiebig/portfolio-fatec/tree/main/4sem)

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

Fui responsável por todo o desenvolvimento, reproduzindo fielmente o design solicitado pelo nosso UI no Figma e implementando a integração completa entre o backend e o frontend. A interface, embora não fosse excessivamente complexa, atendeu plenamente aos requisitos, conforme demonstrado abaixo.
  
![image](https://github.com/user-attachments/assets/28a7c44d-4778-46d1-828b-0a2fbb264964)

Configurei o Axios nesta tela para apontar consistentemente para uma URL predeterminada, simplificando o desenvolvimento e facilitando futuras implementações.
 

#### - Desenvolvimento da tela de Avalicao de Parceiros :
Esta tela tinha como principal objetivo permitir os feedback dos parceiros.

  A tela não apresentava grande complexidade técnica e, assim como na tela de lacunas de habilidades, desenvolvi todo o layout e a integração com o backend. Em decorrência da falta de complexidade técnica foi possível oferecer uma experiência responsiva ao usuário, exibindo uma notificação de sucesso (toast) após cada ação de salvamento no backend, informando o usuário sobre a realização bem-sucedida das alterações, conforme demonstrado no código abaixo."

```
function salvarNota(data: any) {
    axios.post("avaliacoes/criar-avaliacao", {
        nota: +data.nota,
        dataAvaliacao: new Date(),
        expertiseId: data.expertiseId,
        trilhaId: data.trilhaId,
        feedback: data.feedback,
        empresaId: data.empresaId,
        colaboradorId: data.colaboradorId
    })
        .then(() => {
            const toast = Swal.mixin({
                toast: true,
                position: "top-end",
                showConfirmButton: false,
                timer: 3000,
                timerProgressBar: true,
                didOpen: (toast) => {
                    toast.onmouseenter = Swal.stopTimer;
                    toast.onmouseleave = Swal.resumeTimer;
                }
            });
            toast.fire({
                icon: "success",
                title: "Signed in successfully"
            });
        });
}

```
 

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

Exemplo de isolamento de CSS mencionado no parágrafo anterior. 
 


#### Hard Skills

  <summary><b>Clique para ver a lista de hard skills</b></summary>
  <br>
  <table align="center">
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
 

#### Soft Skills

  <summary><b>Clique para ver a lista de softskills</b></summary>
  <br>
  <table align="center">
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
 


### Em 2024-2
**A EMPRESA** parceira escolhida foi a PRO4TECH.
<br>
<br>
**O PROBLEMA** proposto pela empresa parceira foi a criação de um dashboard interativo para análise de dados de recrutamento e seleção. Além disso, a plataforma tinha como objetivo resolver questões relacionadas à centralização de dados, permitindo a integração de informações provenientes de diversas fontes em um único dashboard interativo, auxiliando a empresa na tomada de decisões estratégicas. 
<br>
<br>
**A SOLUÇÃO** proposta foi desenvolver um sistema que permitisse ao usuário importar dados de diversas fontes enquanto escolhia o tipo de dashboard que desejava visualizar. O sistema disponibilizava um total de seis espaços, nos quais os gráficos poderiam ser configurados com eixos X e Y, além de filtros totalmente personalizáveis.
<br>
Além disso, o sistema conseguia enviar notificações sobre as métricas da empresa com a mesma flexibilidade oferecida aos gráficos e possuía a capacidade de exportar relatórios para Excel e PDF. 

[GIT](https://github.com/matheus-fiebig/portfolio-fatec/tree/main/5sem)

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
    

    
app-graphic
@Input() public idx: number = 0;
@Input() public chartId: string = '';
@Input() public description: string = '';
@Input() public lineChartType: string = 'line';
@Input() public generatedValues: any[];
@Input() public lineChartData: Array<any>;
@Input() public lineChartLabels: Array<any>;
@Input() public lineChartColors: Array<any>

              
Como pode ser visto acima, todos os gráficos utilizavam a mesma entrada de dados para serem exibidos, sendo necessária apenas a permutação desses valores para gerar gráficos diferentes, o que atendia a uma das propostas do nosso sistema. Além disso, outro ganho foi a centralização da regra desse componente em um único lugar, facilitando a implementação de funcionalidades futuras, como a customização e o compartilhamento de dashboards.
        
<img src="https://github.com/matheus-fiebig/portfolio-fatec/blob/main/5sem/assets/PDF.gif">
 

##### Criacao da tela de permissionamento
Criei a tela de permissionamento, que permitia ao usuario controlar as permissoes de um determinado grupo do sistema


<img src="https://github.com/matheus-fiebig/portfolio-fatec/blob/main/5sem/assets/Permissionamento.gif"> 

Como pode ser visto na imagem acima, o controle de permissões era realizado em uma única página. O sistema obtinha todas as permissões existentes e, em seguida, todas as permissões que aquele grupo possuía. Quando os dois conjuntos de dados se interseccionavam, o sistema realizava a marcação do checkbox e adicionava a permissão a uma lista de permissões mantidas. Quando uma permissão era desmarcada, ela era removida dessa lista. Ao salvar, enviavam-se apenas as permissões que permaneciam no sistema.
 

<br>

#### Hard Skills

  <summary><b>Clique para ver a lista de hard skills</b></summary>
  <br>
  <table align="center">
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
 

#### Soft Skills

  <summary><b>Clique para ver a lista de softskills</b></summary>
  <br>
  <table align="center">
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

  ### Comunicação
  Para mim, a comunicação é a principal habilidade quando se trabalha em equipe. Toda informação relevante deve ser compartilhada: o status das tarefas, as dificuldades e até as facilidades encontradas. Comunicar-se bem nos ajuda a elaborar planos e definir medidas mais eficazes para o trabalho em grupo. Por isso, escolhi essa soft skill. Se quero me desenvolver profissionalmente, avaliar os pontos fortes e fracos da minha comunicação é algo essencial.
  
  ### Responsabilidade
  Responsabilidade foi a minha segunda escolha, pois, como trabalhamos com sprints, garantir uma entrega é sempre um compromisso. Se algo foi acordado como parte da entrega no início, considero fundamental me comprometer para que ela seja concluída no final. Assumir esse compromisso com seriedade é essencial para manter a confiança e a previsibilidade dentro do time.
  
  ### Organização
  Escolhi a organização especialmente por ter atuado, também, como PO neste semestre. Saber me organizar e repassar essa organização para o time é sempre bem-vindo. Se eu não consigo estruturar as demandas de forma eficaz, a entrega do time como um todo acaba sendo impactada.

 


### Em 2025-1
**A EMPRESA** parceira escolhida foi a Kersys.
<br>
<br>
**O PROBLEMA**  proposto pela empresa parceira consistiu no desenvolvimento de um sistema inteligente para o planejamento e monitoramento de reflorestamento, com o objetivo de prever padrões favoráveis ao crescimento saudável das árvores. 
<br>
<br>
**A SOLUÇÃO**  proposta consistiu no desenvolvimento de um sistema que permite ao usuário cadastrar e atualizar, em períodos arbitrários, dados relacionados à sua colheita. Com base nessas informações, o sistema é capaz de prever aspectos ligados ao crescimento e à projeção de gastos da colheita, além de sugerir melhorias por meio de algoritmos de classificação e agrupamento. Além disso, todo o desenvolvimento foi realizado em conformidade com as diretrizes da Lei Geral de Proteção de Dados (LGPD).

[GIT](https://github.com/matheus-fiebig/portfolio-fatec/tree/main/6sem)

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
 

#### Soft Skills

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
      <td>Responsabilidade</td>
      <td>★★★★★★☆☆☆☆☆</td>
    </tr>
    <tr>
      <td>Organização</td>
      <td>★★★★★★★☆☆☆☆</td>
    </tr>
  </table>
 


