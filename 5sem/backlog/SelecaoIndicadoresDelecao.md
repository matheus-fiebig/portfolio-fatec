# Requisitos (F/NF)

## Requisitos Funcionais

- **RF-6**
- **RF-7**

## Requisitos Não Funcionais

- **RNF-3**
- **RNF-5**

# Descrição

## Critérios de Aceite

- Deve ser possível deletar um indicador chave.
- Deve haver uma nova coluna na tabela de indicadores chave chamada "Ações".
- Cada indicador deve ter uma ação de deleção.

# BDD

---

**Dado** que um usuário tenha permissão de deleção de indicador chave  
**Quando** ele acessar a tela de visualizações de indicadores  
**Então** ele visualiza a ação de deleção de indicador chave.

---

**Dado** que um usuário tenha permissão de deleção de indicador chave  
**E** esteja na tela de visualização de indicadores  
**Quando** ele clicar no botão de deletar  
**Então** a tabela deve ser atualizada  
**E** o indicador chave deve sumir.
