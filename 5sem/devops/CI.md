### **Processo de Integração Contínua (CI)**

A Integração Contínua (CI) é uma prática de desenvolvimento de software que, segundo Martin Fowler, recomenda que todos os membros de uma equipe integrem frequentemente suas alterações em um repositório compartilhado. Isso garante que as alterações sejam verificadas regularmente e facilita a detecção de problemas.

---

### **Estrutura de Branches**

#### **Branch `main`**  
- **Descrição**:  
  Branch principal e estável.  
  Após cada sprint, recebe a versão final validada.  

- **Ações no CI**:  
  - Realizar o build da aplicação.  
  - Gerar uma tag automática com base no número da versão.  
  - Fazer o push da imagem para o **Azure Container Registry (ACR)**.

---

#### **Branch `qas`**  
- **Descrição**:  
  Usada para validar o sistema em um ambiente de qualidade.  
  Essa branch é destinada a:  
  - Testar funcionalidades completas.  
  - Validar o fluxo de dados e realizar testes de carga.  

- **Fluxo**:  
  1. Após os testes, se tudo estiver conforme esperado, as alterações são integradas à branch `main`.  
  2. Caso contrário, as alterações retornam para `develop` com uma nova branch `fix` para ajustes.  

---

#### **Branch `develop`**  
- **Descrição**:  
  Branch de desenvolvimento ativo.  
  Usada para o desenvolvimento inicial das funcionalidades.

- **Ações no CI**:  
  - Execução de testes unitários para validar novas funcionalidades.  
  - Identificação precoce de problemas durante o desenvolvimento.  

---

### **Fluxos de Publicação**

#### **Publicação em `qas`**  
1. Criar um **Pull Request (PR)** da branch `develop` para a branch `qas`.  
2. Após a aprovação do PR:  
   - São executados testes de fluxo e de carga.  
   - O banco de dados é versionado, se necessário.  
3. Caso os testes sejam bem-sucedidos, as alterações seguem para a branch `main`.  
4. Em caso de falhas, cria-se uma branch `fix` a partir de `develop`.

---

#### **Publicação em `main`**  
1. Criar um **Pull Request (PR)** da branch `qas` para `main`.  
2. Após aprovação:  
   - O CI realiza o build final.  
   - Gera uma imagem Docker.  
   - Faz o push da imagem para o repositório no **Azure Container Registry (ACR)**.  
   - Gera uma tag automática para a nova versão.  
3. Caso ocorram falhas, retorna-se para `develop` e cria-se uma branch `fix`.

---

### **Configuração do CI (Exemplo com GitHub Actions)**

**Arquivo YAML básico do GitHub Actions:**

```yaml
name: CI Workflow

on:
  pull_request:
    branches:
      - main
      - qas
      - develop

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v3

      - name: Run Unit Tests
        run: npm run test

  build:
    if: github.ref == 'refs/heads/main'
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v3

      - name: Build and Push Docker Image
        run: |
          docker build -t myapp:${{ github.sha }} .
          docker tag myapp:${{ github.sha }} myacr.azurecr.io/myapp:${{ github.sha }}
          docker push myacr.azurecr.io/myapp:${{ github.sha }}

  notify:
    runs-on: ubuntu-latest
    steps:
      - name: Notify on Telegram
        run: |
          curl -X POST "https://api.telegram.org/bot<bot_token>/sendMessage" \
          -d chat_id=<chat_id> \
          -d text="O CI foi concluído sem falhas. PR pendente de aprovação."
```

---

### **Fluxo Resumido**

1. **Pull Request**:
   - Aciona o workflow no GitHub Actions.  

2. **Execução do CI**:
   - Testes unitários são executados (`develop` e `qas`).  
   - Build e push de imagens Docker ocorrem em `main`.

3. **Notificação**:
   - O desenvolvedor é informado via Telegram sobre o status do CI.

---

### **Benefícios do Processo**

- **Automação**: Minimiza erros manuais com processos automáticos.  
- **Validação Contínua**: Garante estabilidade do sistema em cada fase.  
- **Colaboração**: O fluxo de branches incentiva a colaboração e o controle de versões.  
- **Notificação Proativa**: A integração com Telegram mantém o time informado em tempo real.

---

### **Fluxograma do Processo**
![image](https://github.com/user-attachments/assets/d4f409ed-5cd8-4686-8a15-e3f2d3ea69da)

### **Evento de Notificação**
![image](https://github.com/user-attachments/assets/07ebb6ea-858d-46d7-81c5-19862463cbc6)
