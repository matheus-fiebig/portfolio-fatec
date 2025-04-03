# Requisitos (F/NF)

## Funcionais

- **RF-1**
- **RF-2**
- **RF-3**
- **RF-7**

## Não Funcionais

- **RNF-2**
- **RNF-3**
- **RNF-4**

# Descrição

**Eu como usuário**  
Quero poder visualizar um dashboard  
Para que eu possa ter ciência sobre as métricas atuais de recrutamento e seleção da empresa

# Critérios de Aceite

Deve ser possível visualizar dashboards relacionados às:

1. **Recrutamento e seleção**:
   - Número de processos em aberto nos últimos 12 meses (gráfico)
   - Feedbacks recebidos no último mês (gráfico)

2. **Tempo médio de contratação**:
   - Retornar em horas: (data de contratação - quanto tempo a vaga ficou em aberto) / número de vagas

Cada gráfico deve ter uma descrição clara de seu propósito.  
A tela deve ser responsiva para dispositivos móveis e desktops.

# Wireframe
![Wireframe](https://github.com/api-5-sem/api-documentation/blob/main/assets/BACKLOG/cards.png)

# BDD

**Dado** que eu tenha acesso ao sistema  
**Quando** eu entrar na tela inicial em resolução desktop  
**Então** eu visualizo na segunda linha da tela (4,5) o gráfico de feedbacks recebidos no último mês e de número de processos em aberto nos últimos 12 meses.

---

**Dado** que eu tenha acesso ao sistema  
**Quando** eu entrar na tela inicial em resolução mobile  
**Então** eu visualizo na segunda linha da tela o gráfico de feedbacks recebidos no último mês e de número de processos em aberto nos últimos 12 meses.

---

**Dado** que eu tenha acesso ao sistema  
**Quando** eu entrar na tela inicial em qualquer resolução e não possuir gráficos  
**Então** eu visualizo uma mensagem informativa: “Não existem gráficos disponíveis ainda para visualização”.
