# Requisitos (F/NF)

## Funcionais

- **RF-10**
- **RF-6**

## Não Funcionais

- **RNF-2**
- **RNF-6**

# Descrição

## Critérios de Aceite

- Os dados provisionados devem ser extraídos para um modelo estrela.
- Um endpoint deve ser criado no backend para permitir a extração de dados.
- O endpoint deve:
  - Aceitar um template pré-estabelecido pelo cliente.
  - Retornar uma resposta de erro caso o template não esteja de acordo com o preestabelecido.
- Devem tratar todos os dados a serem extraídos de modo que:
  - Não haja espaços em branco em dados de texto.
  - Dados vazios de colunas devem ser ignorados.
  - Todos os dados presentes possam ser inseridos no banco de dados.
- A operação deve ser atômica, ou seja, ou todos os dados extraídos devem ser inseridos, ou nenhum deve ser inserido em caso de erro.
- Deve haver um botão em tela que permita ao usuário escolher um arquivo Excel para ser enviado ao banco.

# BDD

---

**Dado** que eu envie o Excel para o endpoint de extração de dados através do botão em tela  
**Quando** os dados estiverem de acordo com o template pré-estabelecido  
**Então** eles devem ser salvos no banco de dados.

---

**Dado** que eu envie o Excel para o endpoint de extração de dados através do botão em tela  
**Quando** for encontrado algum tipo de erro nas informações fornecidas  
**Então** uma mensagem de erro deve ser retornada ao usuário informando o que aconteceu  
**E** toda a operação de inserção deve ser cancelada.

---

**Dado** que eu envie um Excel para o endpoint de extração de dados através do botão em tela  
**Quando** o template não for reconhecido pelo sistema  
**Então** uma mensagem de erro deve ser retornada ao usuário informando o que aconteceu  
**E** toda a operação de inserção deve ser cancelada.
