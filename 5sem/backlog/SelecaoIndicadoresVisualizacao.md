# Requisitos (F/NF)

## Requisitos Funcionais

- **RF-6**
- **RF-9**

## Requisitos Não Funcionais

- **RNF-2**
- **RNF-3**
- **RNF-4**
- **RNF-5**

# Descrição

## Critérios de Aceite

- Deve ser criado um novo menu chamado "Indicadores".
- Deve ser mostrado ao administrador todos os indicadores personalizados em forma de tabela.
- Deve ser mostrado um descritivo do indicador, incluindo qual tabela, campo e valor ele afeta.

# BDD

---

**Dado** que eu esteja na tela principal  
**Quando** eu clicar no novo item do menu "Indicadores"  
**Então** devo ser movido para uma nova tela de indicadores.

---

**Dado** que eu esteja na tela principal  
**E** eu esteja autenticado como administrador  
**E** existam indicadores personalizados configurados no sistema  
**Quando** eu clicar no item do menu "Indicadores"  
**Então** devo ver todos os indicadores personalizados na tela de indicadores.
