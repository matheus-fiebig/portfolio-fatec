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
- Deve ser permitido criar um indicador.
- O usuário deve escolher os mesmos dados da configuração de dashboard.

# BDD

---

**Dado** que eu esteja na tela principal  
**Quando** eu clicar no novo item do menu "Indicadores"  
**Então** devo ser movido para uma nova tela de indicadores.

---

**Dado** que eu esteja na tela de indicadores  
**Quando** eu clicar na opção "Criar Novo Indicador"  
**Então** devo ser levado a uma nova tela para inserir dados de configuração  
**E** eu devo conseguir salvar o novo indicador.

---

**Dado** que eu esteja na tela de visualização de indicadores  
**Quando** eu tiver criado um indicador  
**Então** os dados do indicador devem aparecer na tela de indicadores.
