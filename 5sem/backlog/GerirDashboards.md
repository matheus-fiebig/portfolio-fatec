# Requisitos (F/NF)

## Requisitos Funcionais

- **RF-1**
- **RF-2**
- **RF-3**
- **RF-6**

## Requisitos Não Funcionais

- **RNF-2**
- **RNF-3**
- **RNF-4**
- **RNF-5**

# Descrição

## Critérios de Aceite

- O usuário deve conseguir alterar dashboards predefinidos.
- Deve ser possível alterar os filtros de um determinado dashboard.
- Deve ser possível alterar os dados filtrados no eixo X e Y.
- Os dashboards devem ser configurados apenas localmente.

# BDD

---

**Dado** que eu esteja na página inicial do sistema  
**Quando** eu clicar no botão de adicionar gráfico  
**Então** deve-se abrir uma tela de configuração de gráfico.

---

**Dado** que visualize a tela de configuração de gráfico  
**Quando** eu clicar no combobox de tabelas  
**Então** deve-se abrir todas as tabelas fato do sistema.

---

**Dado** que visualize a tela de configuração de gráfico  
**Quando** eu selecionar a primeira tabela fato  
**Então** deve-se trazer todos os campos e dimensões relacionadas a ela nos demais combobox.

---

**Dado** que eu selecionei todos os valores de gráficos  
**Quando** eu clicar no botão confirmar  
**Então** deve ser gerado um dashboard para mim com base nos valores definidos.

---

**Dado** que eu visualize a tela de configuração de gráfico com pelo menos um gráfico  
**Quando** eu clicar no botão configuração  
**Então** deve-se permitir eu excluir aquele gráfico do meu sistema.
