# Documentação de Deploy

## Arquitetura Geral

A aplicação foi estruturada utilizando containers, com os seguintes componentes principais:

- **Frontend**: 1 pod dedicado.
- **Backend**: 2 pods dedicados.
- **NGINX Ingress Controller**: Para gerenciamento de tráfego.
- **Banco de Dados**: Serviço gerenciado na nuvem.

![deploy_oficial_real](https://github.com/user-attachments/assets/e489f847-d373-4eb9-9f0e-978e85a3a332)


  
---

## Detalhes da Configuração

### 1. Gerenciador de Containers
- A aplicação é gerenciada por um **cluster Kubernetes**, configurado para:
  - **Alta disponibilidade**.
  - **Escalabilidade automática**.

### 2. Frontend
- **Estrutura**:
  - Executado em **1 pod dedicado** no cluster Kubernetes.
  - O pod contém um container com a aplicação frontend.
- **Funções**:
  - Servir a interface de usuário e arquivos estáticos.

### 3. Backend
- **Estrutura**:
  - Distribuído entre **2 pods dedicados** no cluster Kubernetes.
  - Cada pod contém um container com a aplicação backend.
- **Funções**:
  - Garantir maior disponibilidade.
  - Suportar maiores cargas de trabalho.
  - Balancear automaticamente as requisições entre os pods.

### 4. Banco de Dados (Serviço Gerenciado)
- O banco de dados é hospedado em um serviço gerenciado na nuvem, o que proporciona:
  - **Alta disponibilidade**.
  - **Manutenção simplificada**.

### 5. NGINX Ingress Controller
- **Estrutura**:
  - Configurado dentro do cluster Kubernetes.
- **Funções**:
  - Atuar como interface para expor a aplicação ao mundo externo.
  - Gerenciar e rotear o tráfego de forma eficiente entre os serviços frontend e backend.

---

## Escalabilidade

O objetivo principal da aplicação é a **visualização de dados**, exigindo recursos de maneira linear na maior parte do tempo. Entretanto, a funcionalidade de **importação de dados via Excel** demanda maior capacidade computacional, tornando necessário o uso de **escalonamento horizontal** para otimizar recursos de maneira eficiente.

- **Funcionamento Geral**:
  - Configuração de escalonamento horizontal baseada no consumo de recursos dos pods (CPU/Memória).
  - Novos pods são criados automaticamente ao atingir um limite de utilização pré-definido.
  - Após a conclusão de operações intensivas (como a importação de dados via Excel), a aplicação retorna à quantidade padrão de pods.

- **Justificativa**:
  - A funcionalidade de importação de dados não é frequente, tornando o escalonamento horizontal a solução ideal. Assim, os recursos são ampliados somente quando necessário, otimizando custos e desempenho.

---

## Benefícios da Arquitetura

- **Alta Disponibilidade**: Garantida pelo uso de Kubernetes e de serviços gerenciados na nuvem.
- **Escalabilidade Automática**: Permite lidar com picos de demanda sem intervenção manual.
- **Manutenção Simplificada**: Uso de serviços gerenciados e balanceamento automático de carga.
- **Eficiência no Roteamento**: Graças ao NGINX Ingress Controller.

