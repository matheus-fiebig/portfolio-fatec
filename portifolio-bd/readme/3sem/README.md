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

[GIT](https://github.com/matheus-fiebig/portifolio-bd/tree/main/3sem)

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
<details>
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
</details>

#### - Tela de Lançamento de Horas:
Desenvolvi o controle para exibição das telas de lançamento de horas, incluindo toda a funcionalidade de visualização das horas e seu fluxo de aprovação/reprovação . Isso envolveu a comunicação HTTP, criação do layout e a vinculação com o framework VUE. Além de necessitar do uso das diretivas do vue, como v-if e v-for.

<details>
<img src="..\..\assets\3sem\3_sem_lancamento_hora.png" width=1150 /></img>

Como pode ser visto na imagem acima, a tela de lançamento de horas envolve varios passos e diretivas. 
As diretivas de v-for são utilizadas para gerar as diversas linhas do sistema. O v-if controla todo o complexo sistema de regras de segurança, no qual permitirá ou não, ao usuário (dependendo do seu nível de permissão) aprovar ou reprovar hora. Por fim o v-model é responsável por realizar o <i>bind</i> do filtro com as variáveis de código, permitindo assim, realizar a requisição HTTP filtro para popular os dados 

<img src="..\..\assets\3sem\3_sem_lancamento_hora_v_for.png" width=300 /></img>

Acima esta um exemplo da utilização das <i>diretivas</i> do vue retratadas no parágrafo anterior para geração de contúdo dinâmico

</details>

#### - Tela de C.R. (Controle de Requisições):
Criei todas as operações do CRUD para as Requisições de Mudança (CRs), incluindo a atribuição de usuários a uma CR. Desenvolvi um sistema de lista para gerenciar quais usuários estariam associados a cada CR.

<details>
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

</details>

#### - Tela de Dashboard:
Desenvolvi a tela de dashboard, utilizando a biblioteca Canvas.js para geração de gráficos. Nessa tela, os usuários podiam filtrar os dados e visualizar gráficos de barras com os dados filtrados, proporcionando uma visão clara e analítica do sistema.

<details>
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
</details>

Como Product Owner
#### - Organização e Criacão do Backlog:
Criação e organização de todo o backlog do projeto, user storys, prioridades e afins. Todos com um bom alinhamento com o cliente.

<details>
 Como pode ser visto na imagem abaixo, todo o backlog e suas respectivas prioridades e user storys. Além disso há a organização por ÉPICOS e FEATURES de cada uma das histórias, bem como a sprint em que cada uma delas deveria entrar

 <img src="https://github.com/matheus-fiebig/portifolio-bd/blob/main/3sem/assets/backlog.png"> </img>
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
