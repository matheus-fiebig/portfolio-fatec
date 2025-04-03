# Requisitos (F/NF)

## Funcionais

- **RF-2**
- **RF-4**

## Não Funcionais

- **RNF-3**

# Descrição

## Critérios de Aceite

- Deve ser exportar qualquer gráfico para formato excel
- Deve ser adicionado um botão novo ao lado da engrenagem para permitir a exportação de dados 
- A exportação acontecerá para cada gráfico/card do sistema
- Apenas usuários autorizados podem exportar relatórios

# BDD

---

**Dado** que eu tenha permissão de exportação de relatório PDF
**E** esteja na tela de dashboard
**Quando** ele clicar no botão exportar
**Então** ele visualiza um modal de exportação de dados

---

**Dado** que eu selecione a opção PDF
**Quando** ele clicar no botão exportar relatório
**Então** o dashboard será baixado no formato .pdf com todos os dados que geraram aquele dashboard 

---

**Dado** que eu abra PDF baixado
**Então** eu visualizo duas colunas com nomes referentes ao eixo X e Y e
**E** todos os dados usados para gerar aquele relatório 
**E** o relatório visualmente como foi apresentado na tela
