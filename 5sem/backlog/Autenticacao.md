# Requisitos (F/NF)

## Requisitos Funcionais

- **RF-6**

## Requisitos Não Funcionais

- **RNF-1**
- **RNF-2**
- **RNF-4**

# Descrição

## Critérios de Aceite

- O login deve ser a tela inicial do sistema.
- Ao realizar login com sucesso, o usuário deve ser redirecionado para a tela de dashboard.
- Deve ser possível realizar o logout do sistema.
- Deve ser realizado o logout automático após fechar o navegador.

## Wireframe

![Wireframe](https://github.com/api-5-sem/api-documentation/blob/main/assets/BACKLOG/login.png)

# BDD

---

**Dado** que um usuário acessa o sistema  
**Então** ele deve ver a tela inicial de autenticação.

---

**Dado** que um usuário acessa o sistema  
**Quando** ele inserir dados de login e/ou senha inválidos  
**Então** ele deve permanecer na tela de autenticação  
**E** deve ser informado que o login/senha são inválidos.

---

**Dado** que um usuário acessa o sistema  
**Quando** ele inserir dados de login e senha válidos  
**Então** ele deve ser redirecionado para a tela de dashboard.
