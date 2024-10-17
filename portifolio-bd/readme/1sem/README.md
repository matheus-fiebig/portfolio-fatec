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
#### - Criação da tela de gestão de autenticação:

Como scrum master, minhas contribuições foram:
#### - Acompanhamento das entregas:

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
      <td>★★★★★★☆☆☆☆</td>
    </tr>
    <tr>
      <td>Trabalho em Equipe</td>
      <td>★★★★★★★☆☆☆</td>
    </tr>
    <tr>
      <td>Resolução de Problemas</td>
      <td>★★★★★★★★★☆</td>
    </tr>
    <tr>
      <td>Responsabilidade</td>
      <td>★★★★★★★★★☆</td>
    </tr>
  </table>
</details>

