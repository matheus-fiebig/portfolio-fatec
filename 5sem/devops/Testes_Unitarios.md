## ⚙️ Testes unitários no contexto do processo de desenvolvimento

A seguir está o fluxograma dos testes unitários no contexto do processo de desenvolvimento:

![fluxograma-testes-unitarios](https://github.com/xxzidanilloxx/sakaue/blob/main/assets/fluxograma-testes-unitarios.svg)

> [!IMPORTANT]
> No processo de desenvolvimento, os testes unitários são executados automaticamente quando ocorre um trigger, que, neste caso, é a abertura de um pull request para a branch develop.

## 📘 Orientações para implementação de testes unitários

> [!IMPORTANT]
> Recomendações gerais: Ao incluir um novo teste e perceber que um teste já existente interfere em sua execução, é necessária refatoração imediata. A responsabilidade pela correção deve ser da pessoa que identificou o problema, garantindo eficiência e promovendo a colaboração na equipe.

### 🖥️ Back-end:

A seguir está a estrutura e as orientações para a organização e implementação de testes unitários no back-end do projeto:

#### 📂 Estrutura
<details open>
<summary>
  <b> Exemplo de Estrutura </b>
</summary>

```plaintext
api-back/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br.gov.sp.cps.api.pixel/
│   │   │       ├── core/
│   │   │       │   ├── service/
│   │   │       │   │   └── exemplo/
│   │   │       │   │      └── ExemploService.java
│   │   │       │   └── usecase/
│   │   │       │       └── exemplo/
│   │   │       │          └── ExemploUseCase.java
│   │   │       ├── inbound.rest/
│   │   │       ├── outbound/
│   │   │       └── PixelApplication
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   └── br.gov.sp.cps.api.pixel/
│       │       ├── core/
│       │       │   ├── service/
│       │       │   │   └── exemplo/
│       │       │   │      └── ExemploServiceTest.java
│       │       │   └── usecase/
│       │       │       └── exemplo/
│       │       │          └── ExemploUseCaseTest.java
│       │       ├── inbound.rest/
│       │       ├── outbound/
│       │       └── ApplicationTests.java
│       └── resources/
├── pom.xml
└── README.md
```
</details>

#### 📋 Orientações

1️⃣ Nome dos arquivos de teste:
   - Deve ser utilizado o mesmo nome da classe testada, adicionando o sufixo `Test`.  
     Exemplo:  
     - Classe: `ExemploService.java`  
     - Teste: `ExemploServiceTest.java`  

2️⃣ Localização dos testes: 
   - Os testes devem ser colocados no diretório correspondente em `src/test/java`, espelhando a estrutura de `src/main/java`.
     Exemplo:
     - Serviços: `src/test/java/br.gov.sp.cps.api.pixel/core/service/`.  
     - Casos de Uso: `src/test/java/br.gov.sp.cps.api.pixel/core/usecase/`.

### 🌐 Front-end:

A seguir está a estrutura e as orientações para a organização e implementação de testes unitários no front-end do projeto:

#### 📂 Estrutura
<details open>
<summary>
    <b>Exemplo de Estrutura</b>
</summary>

```plaintext
api/
├── src/
│   ├── app/
│   │   ├── components/
│   │   │   └── exemplo/
│   │   │       ├── exemplo.component.ts
│   │   │       └── exemplo.component.spec.ts
│   │   └── app.module.ts
│   ├── assets/
│   ├── environments/
│   ├── index.html
│   ├── main.ts
│   ├── polyfills.ts
│   ├── styles.css
│   └── test.ts
├── angular.json
├── package.json
├── tsconfig.json
└── README.md
```
</details>

#### 📋 Orientações

1️⃣ Nome dos arquivos de teste:
   - Deve ser utilizado o mesmo nome do arquivo testado, adicionando o sufixo `.spec.ts`.  
     Exemplo:  
     - Componente: `exemplo.component.ts`  
     - Teste: `exemplo.component.spec.ts`.

2️⃣ Localização dos testes: 
   - Os testes devem ser colocados no mesmo diretório do componente ou serviço correspondente.
