<h1 align="center"> Sistema de Gerenciamento de Parceiros </h1>

## :busts_in_silhouette: Equipe de desenvolvimento

| Função | Nome |
| :---: | :---: |
| Product Owner | [Alisson dos Santos Pereira](https://github.com/41issonm) |
| Scrum Master | [Danillo Wesley da Costa Silva](https://github.com/xxzidanilloxx) |
| Dev | [Beatrice Lopes Correa](https://github.com/beatricelopes) |
| Dev | [Jhonny Freitas Dutra](https://github.com/dutrajy) |
| Dev | [Luciano do Nascimento Pamplona da Silva](https://github.com/lucianonps) |
| Dev | [Matheus Cruz Fiebig](https://github.com/matheus-fiebig) |
| Dev | [Wagner de Deus da Silva Júnior](https://github.com/wdeus) |

## :books: Sobre o projeto

O projeto consiste em desenvolver um sistema para acompanhar o progresso dos parceiros da [Oracle](https://www.oracle.com/br/) no programa [Oracle PartnerNetwork](https://www.oracle.com/br/partnernetwork/program/), além de realizar o cadastro de novos parceiros e gerenciar as informações dos parceiros já existentes da empresa.

<details>  
<summary><b> Desafios e requisitos do projeto: </b></summary>

## :jigsaw: Desafios

1. Mapeamento da Linhagem dos Dados:
- Analisar a origem e a trajetória dos dados desde sua entrada no sistema até sua utilização final.

2. Documento de Boas Práticas de Governança - Data Quality:
- Elaborar um documento que descreva as práticas ideais de governança de dados, com foco na qualidade dos dados.

3. Relatórios de Porcentagem de Expertise de Dados:
- Gerar relatórios que apresentem a porcentagem de expertise dos parceiros em diferentes áreas.

4. Visão do Desenvolvimento dos Parceiros:
- Desenvolver uma visão que permita acompanhar o progresso e o desenvolvimento dos parceiros ao longo do tempo.

5. Gaps de Conhecimento Relacionado aos Produtos:
- Identificar lacunas no conhecimento dos parceiros em relação aos produtos oferecidos.

6. Identificação de Discrepâncias de Dados:
- Detectar e reportar as maiores discrepâncias nos dados cadastrados.

7. Indicadores de Validade das Expertises - Vencimento de Provas:
- Implementar indicadores que alertem sobre a validade das certificações e provas dos parceiros.

## :wrench: Requisitos funcionais

1. Desenvolver uma interface de cadastro cliente.

2. Desenvolver um Dashboard de indicadores de desempenho de parceiros.

3. Desenvolver um Relatório Analítico de parceiros por produtos.

##  :bookmark_tabs: Requisitos não funcionais

1. Manual do Usuário.

2. Documentação API (Application Programming Interface).
   
3. Modelagem de Banco de Dados ou Arquivo de dado.

</details>

## :notebook: Documentação do projeto
[Documentação](https://github.com/api-4-sem/api/tree/main/doc)


## :hammer_and_wrench: Tecnologias utilizadas
<div align="center">
    <img src="https://github.com/api-4-sem/api/assets/111617208/ca9c93cf-533a-46d8-8732-b89c402819bb" alt="java">
    <img src="https://github.com/api-4-sem/api/assets/111617208/f5899d7d-f774-4498-89c0-d8d251014770" alt="spring">
    <img src="https://github.com/api-4-sem/api/assets/111617208/5f197c2a-097e-4104-9a3e-18aa1c1206aa" alt="vue js">
    <img src="https://github.com/api-4-sem/api/assets/111617208/80960a12-ba8c-4db0-97dc-14ff944d658f" alt="bootstrap">
    <img src="https://github.com/api-4-sem/api/assets/111617208/4b81d580-c9eb-4d76-aae6-3df8f3e6bcec" alt="oracle">
</div>

## :clipboard: Backlog
<details>  
<summary> Confira o backlog do produto: </summary>
<br>
    
| Épico | Feature | User Story | Prioridade | Sprint |
| :---: | :---: | :--- | :---: | :---: |
| Visualização de Dados	| Rastreio |	Eu como administrador <br> Quero visualizar parceiros <br> Para que seja possível acompanhar o desempenho dos parceiros e que trilha eles se encontram |	3 |	1 |
| Visualização de Dados |	Visualização |	Eu como administrador  <br> Quero um painel interativo com gráficos e tabelas <br> Para que seja possível corrigir e visualizar diferentes dados de expertise do parceiro |	1 |	1 |
| Visualização de Dados |	Filtros	| Eu como administrador <br> Quero filtros de dados <br> Para permitir a segmentação dos dados por parceiro, área de expertise e período de tempo |	2 |	1 |
| Desenvolvimento de Parceiros |	Acompanhamento de desenvolvimento de parceiros |	Eu como administrador <br> Quero acompanhar o progresso dos parceiros em suas trilhas de aprendizado e identificar áreas de necessidade <br> Para que possa manter os serviços atualizados |	4 |	1 |
| Desenvolvimento de Parceiros |	Acompanhamento de desenvolvimento de parceiros |	Eu como administrador <br> Quero criar um sistema de acompanhamento de trilhas que permite aos parceiros registrar seu progresso em cada etapa da trilha <br> Para que possa fazer sugestões de novas trilhas com base no desempenho do parceiro |	5 |	1 |
| Desenvolvimento de Parceiros |	Acompanhamento de desenvolvimento de parceiros |	Eu como administrador <br> Quero implementar mecanismos de feedback <br> Para que os parceiros possam fornecer feedback sobre suas experiências nas trilhas para que possam ser realizadas melhorias nas trilhas |	7 |	1 |
| Análise de Lacunas de Habilidades |	Analise de lacuna de habilidade |	Eu como administrador <br>  Quero identificar a lacuna de habilidades ou conteúdo restante no caminho de desenvolvimento de um parceiro <br> Para implementar recomendações personalizadas aos meus parceiros |	6 |	1 |
| Governança de Dados |	Cadastro |	Eu como administrador <br> Quero conseguir visualizar os parceiros cadastrados e cadastrar novos parceiros <br> Para que seja possível controlar e validar a trilha que os paceiros do sistema se encontram |	8 |	2 |
| Relatórios |	Extração de Relatório |	Eu como administrador <br> Quero permitir a integração com ferramentas de edição de planilhas <br> Para análises mais avançadas do desempenho da trilha dos meus parceiros e assim poder visualizar melhor meus dados |	11 |	2 |
| Avaliação de Parceiros |	Formulário para avaliação de parceiro |	Eu como administrador <br> Quero visualizar avaliações de parceiros com base em critérios de pontuações <br> Para poder indicar ou realizar melhorias nas trilhas |	9 |	2 |
| Gestão de Notificações |	Edição |	Eu como administrador <br> Quero permitir que os parceiros possam personalizar suas preferências de notificação e escolher quais tipos de alertas desejam receber <br> Para configurar a frequência e o tipo dos alertas |	10 |	2 |
| Análise Geográfica de Parceiros | Visualização | Eu como administrador <br> Quero identificar regiões com maior concentração de parceiros e regiões com lacunas de parceiros <br> Para melhor compreensão dos indicadores e dos parceiros que consomem o serviço | 13 | 3 |
| Dashboard | Visualização | Eu como administrador <br> Quero um dashboard centralizado <br> Para controlar e gerenciar aspectos importantes do sistema | 12 | 3 |
| Dashoboard | Visualização | Eu como administrador <br> Quero uma ferramenta <br> Para ranquear os melhores parceiros | 14 | 4 |
| Gestão de dados | Padrões de dados | Eu como administrador <br> Quero um documento sobre padrões de dados <br> Para que siga as regras de governaças de dados | 17 | 4 |
| Governança de Dados	| Visualização | Eu como administrador <br> Quero estabelecer procedimentos de backup e recuperação de dados <br> Para garantir a regras os padrões e regras de governança de dados a serem seguidos na organização. | 15 | 4 |
| Atualização de Parceiros | Acompanhamento de desenvolvimento de parceiros | Eu como administrador <br> Quero um método para autalizar parceiros <br> Para atualizar parceiros Desenvolvendo um processo eficiente para atualizar informações de parceiros antigos. | 18 | 4 |

</details>

## :calendar: Entregas

| Sprint | Previsão de entrega | Status |
| :---: | :---: | :---: |
| 1 | 14/04 | :white_check_mark: |
| 2 | 05/05 | :white_check_mark:	|
| 3 | 26/05 | :white_check_mark: |
| 4 | 16/06 | :white_check_mark: |

## :spiral_calendar: Planejamento

<details>  
<summary> Confira o planejamento das sprints: </summary>
   
### Sprint 1

- [x] Visualização de dados
- [x] Rastreio de dados
- [x] Filtros de dados
- [x] Acompanhamento de progresso
- [x] Implementação de feedback
- [x] Lacunas de habilidades
- [x] Sistema de acompanhamento de trilhas

### Sprint 2

- [x] Cadastro de novos parceiros
- [x] Extração de relatórios
- [x] Formulário para avaliação de parceiros
- [x] Personalização de preferências de notificação

### Sprint 3

- [x] Dashboard geral do sistema
- [x] Análise geográfica de parceiros

### Sprint 4

- [x] Desenvolvimento de dashboard que ranqueie os melhores parceiros
- [x] Atualização de parceiros existentes
- [x] Confecção de documento data quality
- [x] Integração de rotinas de backup

</details>
